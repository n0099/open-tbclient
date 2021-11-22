package com.baidu.searchbox.logsystem.basic.upload;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.JsonWriter;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.Closeables;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy;
import com.baidu.searchbox.logsystem.basic.upload.identity.NetworkParam;
import com.baidu.searchbox.logsystem.logsys.CrashUtil;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.LogObject;
import com.baidu.searchbox.logsystem.logsys.LogPipelineSingleton;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.searchbox.logsystem.util.Common;
import com.baidu.searchbox.logsystem.util.DebugUtil;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.searchbox.logsystem.util.Utility;
import com.baidu.searchbox.logsystem.util.ZipUtils;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class LogSystemUploaderStrategy extends BaseUploaderStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "LSStrategy";
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor mAttachmentExecutor;
    public ThreadPoolExecutor mContentExecutor;
    public boolean mInvalidDirDeleted;

    /* renamed from: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy$4  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(798875310, "Lcom/baidu/searchbox/logsystem/basic/upload/LogSystemUploaderStrategy$4;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(798875310, "Lcom/baidu/searchbox/logsystem/basic/upload/LogSystemUploaderStrategy$4;");
                    return;
                }
            }
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type = iArr;
            try {
                iArr[Type.CONTENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[Type.ATTACHMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class Constants {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int KEEP_ALIVE_TIME = 60000;
        public static final int MAX_COUNT_ATTACHMENT = 100;
        public static final int MAX_COUNT_CONTENT = 500;
        public static final long MAX_LIFE_TIME = 2592000000L;
        public static final String UBC_EVENT_ID = "1156";
        public static final int UI_TRACE_MAX_SIZE = 20;
        public static final int UPLOAD_MAX_FILE = 5;
        public transient /* synthetic */ FieldHolder $fh;

        public Constants() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class ContentUtil {
        public static /* synthetic */ Interceptable $ic = null;
        public static final byte GZIP_HEAD_1 = 117;
        public static final byte GZIP_HEAD_2 = 123;
        public transient /* synthetic */ FieldHolder $fh;

        public ContentUtil() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static void createAperfInfo(@NonNull String str, @NonNull String str2, @NonNull JsonWriter jsonWriter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65537, null, str, str2, jsonWriter) == null) {
                try {
                    jsonWriter.name(Constant.APERF);
                    jsonWriter.beginObject();
                    jsonWriter.name("launchid").value(str);
                    jsonWriter.name("logid").value(UUID.randomUUID().toString());
                    jsonWriter.name(Constant.APP_EXT).value(Common.getAppExtra());
                    jsonWriter.name("packagename").value(AppRuntime.getAppContext().getPackageName());
                    jsonWriter.name("osversion").value(Common.getDeviceInfo().mOSVersion);
                    jsonWriter.name("memory").value(Common.getDeviceInfo().mMemory);
                    jsonWriter.name("cpu").value(Common.getDeviceInfo().mCPU);
                    jsonWriter.name("sdkversion").value(Common.getVersionInfo().mSDKVersion);
                    jsonWriter.name("appversion").value(Common.getVersionInfo().mAppVersion);
                    jsonWriter.name("network").value(new NetworkParam().getCurrentNetTypeId());
                    String deviceScore = LokiRuntime.getIdentityContext().getDeviceScore();
                    if (!TextUtils.isEmpty(deviceScore)) {
                        jsonWriter.name("devicescore").value(deviceScore);
                    }
                    jsonWriter.name("fileid").value(str2);
                    jsonWriter.endObject();
                } catch (IOException e2) {
                    if (LLog.sDebug) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:67:0x0188 A[Catch: IOException -> 0x01b2, TryCatch #1 {IOException -> 0x01b2, blocks: (B:5:0x0008, B:7:0x000e, B:11:0x0033, B:13:0x005b, B:14:0x0066, B:17:0x007b, B:19:0x0081, B:21:0x0098, B:24:0x00a0, B:26:0x00a6, B:27:0x00ad, B:29:0x00b3, B:31:0x00bb, B:33:0x00c9, B:34:0x00cb, B:35:0x00ce, B:37:0x00dc, B:41:0x00e4, B:43:0x00e9, B:44:0x00ec, B:46:0x0122, B:47:0x0137, B:48:0x0142, B:49:0x014a, B:51:0x0150, B:53:0x015c, B:55:0x0162, B:65:0x017f, B:67:0x0188, B:68:0x018f, B:70:0x0195, B:61:0x0175, B:63:0x0179, B:71:0x019c, B:20:0x0091), top: B:83:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0195 A[Catch: IOException -> 0x01b2, TryCatch #1 {IOException -> 0x01b2, blocks: (B:5:0x0008, B:7:0x000e, B:11:0x0033, B:13:0x005b, B:14:0x0066, B:17:0x007b, B:19:0x0081, B:21:0x0098, B:24:0x00a0, B:26:0x00a6, B:27:0x00ad, B:29:0x00b3, B:31:0x00bb, B:33:0x00c9, B:34:0x00cb, B:35:0x00ce, B:37:0x00dc, B:41:0x00e4, B:43:0x00e9, B:44:0x00ec, B:46:0x0122, B:47:0x0137, B:48:0x0142, B:49:0x014a, B:51:0x0150, B:53:0x015c, B:55:0x0162, B:65:0x017f, B:67:0x0188, B:68:0x018f, B:70:0x0195, B:61:0x0175, B:63:0x0179, B:71:0x019c, B:20:0x0091), top: B:83:0x0008 }] */
        @NonNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void createCrashInfo(@NonNull LogObject logObject, @Nullable List<LogFile> list, @NonNull JsonWriter jsonWriter) {
            String str;
            String str2;
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65538, null, logObject, list, jsonWriter) == null) {
                try {
                    LogExtra logExtra = logObject.getLogExtra();
                    if (logExtra != null) {
                        jsonWriter.name("content");
                        jsonWriter.beginObject();
                        jsonWriter.name("page").value(logExtra.mPage);
                        jsonWriter.name("type").value(logObject.mLogType == LogType.NATIVE_CRASH ? Constant.TYPE_NATIVE : Constant.TYPE_JAVA);
                        jsonWriter.name(Constant.CRASH_TIME).value(logExtra.mCrashTime);
                        jsonWriter.name("launchTime").value(logExtra.mLaunchTime);
                        jsonWriter.name(Constant.PROCESS_LIFE_TIME).value(logExtra.mProcessLifeTime);
                        if (logExtra.mForeground != null) {
                            jsonWriter.name(Constant.FOREGROUND).value(logExtra.mForeground);
                        }
                        String logBasicData = logObject.getLogBasicData();
                        String typeName = logObject.mLogType.getTypeName();
                        String str3 = "";
                        if (!TextUtils.isEmpty(logBasicData) && logBasicData.startsWith(typeName)) {
                            jsonWriter.name("stacktrace").value(logBasicData.replaceFirst(Matcher.quoteReplacement(typeName), ""));
                        } else {
                            jsonWriter.name("stacktrace").value(logBasicData);
                        }
                        if (logObject.mLogType == LogType.NATIVE_CRASH && list != null && list.size() > 0) {
                            int i2 = 0;
                            File file = null;
                            File file2 = null;
                            for (LogFile logFile : list) {
                                if (logFile != null) {
                                    if (logFile.mFile.getName().startsWith(CrashUtil.CrashpadConstant.MIND_BDMP_PREFIX)) {
                                        file = logFile.mFile;
                                    } else if (logFile.mFile.getName().startsWith(CrashUtil.CrashpadConstant.JSON_EXTRA)) {
                                        file2 = logFile.mFile;
                                    }
                                    i2++;
                                }
                                if (i2 == 2) {
                                    break;
                                }
                            }
                            if (file != null) {
                                CrashPadUtil.createMiniBDMPInfo(file, jsonWriter);
                            }
                            if (file2 != null) {
                                CrashPadUtil.createJsonExtraInfo(file2, jsonWriter);
                            }
                        }
                        jsonWriter.name("processName").value(logObject.getProcessName());
                        jsonWriter.name(Constant.CRASH_THREAD_DES);
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(logExtra.mCrashThreadName);
                        jsonWriter.name("priority").value(logExtra.mCrashThreadPriority);
                        jsonWriter.endObject();
                        if (!TextUtils.isEmpty(logExtra.mJSONAttach)) {
                            jsonWriter.name(Constant.TRACE_INFO);
                            jsonWriter.beginObject();
                            jsonWriter.name("traceid").value(logExtra.mTraceID);
                            try {
                                jSONObject = new JSONObject(logExtra.mJSONAttach);
                                str2 = jSONObject.getString(Constant.LAUNCH_STAGE);
                            } catch (JSONException e2) {
                                e = e2;
                                str = "";
                            }
                            try {
                                str3 = jSONObject.getString(Constant.CRASH_STAGE);
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    if (!Constant.LAUNCH_STAGE.equals(next) && !Constant.CRASH_STAGE.equals(next)) {
                                        jsonWriter.name(next).value(jSONObject.getString(next));
                                    }
                                }
                            } catch (JSONException e3) {
                                e = e3;
                                String str4 = str3;
                                str3 = str2;
                                str = str4;
                                if (LLog.sDebug) {
                                    e.getMessage();
                                }
                                String str5 = str3;
                                str3 = str;
                                str2 = str5;
                                jsonWriter.endObject();
                                if (!TextUtils.isEmpty(str2)) {
                                }
                                if (!TextUtils.isEmpty(str3)) {
                                }
                                jsonWriter.name("pageTrace");
                                jsonWriter.beginArray();
                                createTraceUI(logObject.getProcessName(), jsonWriter);
                                jsonWriter.endArray();
                                jsonWriter.endObject();
                            }
                            jsonWriter.endObject();
                            if (!TextUtils.isEmpty(str2)) {
                                jsonWriter.name(Constant.LAUNCH_STAGE).value(str2);
                            }
                            if (!TextUtils.isEmpty(str3)) {
                                jsonWriter.name(Constant.CRASH_STAGE).value(str3);
                            }
                        }
                        jsonWriter.name("pageTrace");
                        jsonWriter.beginArray();
                        createTraceUI(logObject.getProcessName(), jsonWriter);
                        jsonWriter.endArray();
                        jsonWriter.endObject();
                    }
                } catch (IOException e4) {
                    if (LLog.sDebug) {
                        e4.printStackTrace();
                    }
                }
            }
        }

        public static void createTraceUI(@NonNull String str, @NonNull JsonWriter jsonWriter) {
            RandomAccessFile randomAccessFile;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, str, jsonWriter) == null) {
                File file = new File(LogPipelineSingleton.obtainFileDirWithProcessName(str), SnapshotConstant.ProcessConstants.PROC_UI_TRACE);
                if (file.exists()) {
                    int i2 = 0;
                    RandomAccessFile randomAccessFile2 = null;
                    r3 = null;
                    r3 = null;
                    RandomAccessFile randomAccessFile3 = null;
                    RandomAccessFile randomAccessFile4 = null;
                    try {
                        try {
                            randomAccessFile = new RandomAccessFile(file, r.f41000a);
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (IOException e2) {
                        e = e2;
                    }
                    try {
                        long length = randomAccessFile.length();
                        if (length > 0) {
                            long j = 1;
                            long j2 = length - 1;
                            while (j2 > 0) {
                                j2 -= j;
                                randomAccessFile.seek(j2);
                                if (randomAccessFile.readByte() == 10) {
                                    String[] parse = TrackUI.parse(randomAccessFile.readLine());
                                    if (parse != null && parse.length == 4) {
                                        jsonWriter.beginObject();
                                        jsonWriter.name("time").value(parse[1]);
                                        jsonWriter.name("page").value(parse[2]);
                                        jsonWriter.name("event").value(parse[3]);
                                        jsonWriter.endObject();
                                    }
                                    i2++;
                                    if (i2 == 20) {
                                        break;
                                    }
                                }
                                j = 1;
                            }
                            if (j2 == 0) {
                                randomAccessFile.seek(0L);
                                String[] parse2 = TrackUI.parse(randomAccessFile.readLine());
                                if (parse2 != null) {
                                    jsonWriter.beginObject();
                                    jsonWriter.name("time").value(parse2[1]);
                                    JsonWriter name = jsonWriter.name("page");
                                    String str2 = parse2[2];
                                    name.value(str2);
                                    jsonWriter.name("event").value(parse2[3]);
                                    jsonWriter.endObject();
                                    randomAccessFile3 = str2;
                                }
                            }
                        }
                        Closeables.closeSafely(randomAccessFile);
                        randomAccessFile2 = randomAccessFile3;
                    } catch (IOException e3) {
                        e = e3;
                        randomAccessFile4 = randomAccessFile;
                        e.printStackTrace();
                        Closeables.closeSafely(randomAccessFile4);
                        randomAccessFile2 = randomAccessFile4;
                    } catch (Throwable th2) {
                        th = th2;
                        randomAccessFile2 = randomAccessFile;
                        Closeables.closeSafely(randomAccessFile2);
                        throw th;
                    }
                }
            }
        }

        public static void createUBCContentInfo(@NonNull LogObject logObject, @Nullable List<LogFile> list, @NonNull String str, @NonNull File file) {
            JsonWriter jsonWriter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, logObject, list, str, file) == null) {
                JsonWriter jsonWriter2 = null;
                try {
                    try {
                        jsonWriter = new JsonWriter(new FileWriter(file));
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    jsonWriter.beginObject();
                    jsonWriter.name("data");
                    jsonWriter.beginArray();
                    jsonWriter.beginObject();
                    jsonWriter.name("id").value(Constants.UBC_EVENT_ID);
                    jsonWriter.name("timestamp").value(System.currentTimeMillis());
                    jsonWriter.name(Constant.ID_TYPE).value("1");
                    jsonWriter.name("type").value("0");
                    jsonWriter.name(Constant.IS_REAL).value("1");
                    createAperfInfo(logObject.getCrashTAG(), str, jsonWriter);
                    createCrashInfo(logObject, list, jsonWriter);
                    jsonWriter.endObject();
                    jsonWriter.endArray();
                    jsonWriter.endObject();
                    jsonWriter.flush();
                    Closeables.closeSafely(jsonWriter);
                } catch (IOException e3) {
                    e = e3;
                    jsonWriter2 = jsonWriter;
                    if (LLog.sDebug) {
                        e.printStackTrace();
                    }
                    Closeables.closeSafely(jsonWriter2);
                } catch (Throwable th2) {
                    th = th2;
                    jsonWriter2 = jsonWriter;
                    Closeables.closeSafely(jsonWriter2);
                    throw th;
                }
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0060 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0063 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0066 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:101:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x00ea  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0100  */
        /* JADX WARN: Type inference failed for: r10v11, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v10 */
        /* JADX WARN: Type inference failed for: r6v13 */
        /* JADX WARN: Type inference failed for: r6v14, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r6v3, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r6v4 */
        /* JADX WARN: Type inference failed for: r6v5 */
        /* JADX WARN: Type inference failed for: r6v7 */
        /* JADX WARN: Type inference failed for: r6v9 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void gzipContent(@NonNull File file, @NonNull File file2) {
            File file3;
            GZIPOutputStream gZIPOutputStream;
            GZIPOutputStream gZIPOutputStream2;
            ?? r6;
            ?? fileInputStream;
            FileOutputStream fileOutputStream;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, file, file2) == null) && file != null && file2 != null && file.exists() && file2.exists()) {
                byte[] bArr = new byte[1024];
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        file3 = new File(file2.getAbsolutePath() + ".tmp");
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    file3 = null;
                    gZIPOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    file3 = null;
                    gZIPOutputStream = null;
                }
                try {
                    if (Utility.createNewEmptyFile(file3)) {
                        gZIPOutputStream = new GZIPOutputStream(new FileOutputStream(file3));
                        try {
                            r6 = new FileInputStream(file);
                            while (true) {
                                try {
                                    int read = r6.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    gZIPOutputStream.write(bArr, 0, read);
                                } catch (IOException e3) {
                                    e = e3;
                                    e.printStackTrace();
                                    Closeables.closeSafely(fileOutputStream2);
                                    Closeables.closeSafely(gZIPOutputStream);
                                    Closeables.closeSafely((Closeable) r6);
                                    if (file3 == null || !file3.exists()) {
                                        return;
                                    }
                                    file3.delete();
                                }
                            }
                            gZIPOutputStream.flush();
                            gZIPOutputStream.close();
                            try {
                                r6.close();
                            } catch (IOException e4) {
                                e = e4;
                                gZIPOutputStream = null;
                                e.printStackTrace();
                                Closeables.closeSafely(fileOutputStream2);
                                Closeables.closeSafely(gZIPOutputStream);
                                Closeables.closeSafely((Closeable) r6);
                                if (file3 == null) {
                                    return;
                                }
                                return;
                            } catch (Throwable th3) {
                                th = th3;
                                gZIPOutputStream = null;
                                gZIPOutputStream2 = r6;
                                Closeables.closeSafely(fileOutputStream2);
                                Closeables.closeSafely(gZIPOutputStream);
                                Closeables.closeSafely(gZIPOutputStream2);
                                if (file3 != null && file3.exists()) {
                                    file3.delete();
                                }
                                throw th;
                            }
                        } catch (IOException e5) {
                            e = e5;
                            r6 = 0;
                        } catch (Throwable th4) {
                            th = th4;
                            gZIPOutputStream2 = null;
                            Closeables.closeSafely(fileOutputStream2);
                            Closeables.closeSafely(gZIPOutputStream);
                            Closeables.closeSafely(gZIPOutputStream2);
                            if (file3 != null) {
                            }
                            throw th;
                        }
                    }
                    fileInputStream = new FileInputStream(file3);
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (IOException e6) {
                        r6 = fileInputStream;
                        e = e6;
                        gZIPOutputStream = null;
                        e.printStackTrace();
                        Closeables.closeSafely(fileOutputStream2);
                        Closeables.closeSafely(gZIPOutputStream);
                        Closeables.closeSafely((Closeable) r6);
                        if (file3 == null) {
                        }
                    } catch (Throwable th5) {
                        r6 = fileInputStream;
                        th = th5;
                        gZIPOutputStream = null;
                        gZIPOutputStream2 = r6;
                        Closeables.closeSafely(fileOutputStream2);
                        Closeables.closeSafely(gZIPOutputStream);
                        Closeables.closeSafely(gZIPOutputStream2);
                        if (file3 != null) {
                            file3.delete();
                        }
                        throw th;
                    }
                } catch (IOException e7) {
                    e = e7;
                    gZIPOutputStream = null;
                    r6 = gZIPOutputStream;
                    e.printStackTrace();
                    Closeables.closeSafely(fileOutputStream2);
                    Closeables.closeSafely(gZIPOutputStream);
                    Closeables.closeSafely((Closeable) r6);
                    if (file3 == null) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    gZIPOutputStream = null;
                    gZIPOutputStream2 = gZIPOutputStream;
                    Closeables.closeSafely(fileOutputStream2);
                    Closeables.closeSafely(gZIPOutputStream);
                    Closeables.closeSafely(gZIPOutputStream2);
                    if (file3 != null) {
                    }
                    throw th;
                }
                try {
                    fileOutputStream.write(new byte[]{GZIP_HEAD_1, GZIP_HEAD_2});
                    if (fileInputStream.read(new byte[2]) != -1) {
                        while (true) {
                            int read2 = fileInputStream.read(bArr);
                            if (read2 == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read2);
                        }
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    fileInputStream.close();
                    Closeables.closeSafely((Closeable) null);
                    Closeables.closeSafely((Closeable) null);
                    Closeables.closeSafely((Closeable) null);
                    if (!file3.exists()) {
                        return;
                    }
                } catch (IOException e8) {
                    r6 = fileInputStream;
                    e = e8;
                    gZIPOutputStream = null;
                    fileOutputStream2 = fileOutputStream;
                    e.printStackTrace();
                    Closeables.closeSafely(fileOutputStream2);
                    Closeables.closeSafely(gZIPOutputStream);
                    Closeables.closeSafely((Closeable) r6);
                    if (file3 == null) {
                    }
                } catch (Throwable th7) {
                    gZIPOutputStream2 = fileInputStream;
                    th = th7;
                    gZIPOutputStream = null;
                    fileOutputStream2 = fileOutputStream;
                    Closeables.closeSafely(fileOutputStream2);
                    Closeables.closeSafely(gZIPOutputStream);
                    Closeables.closeSafely(gZIPOutputStream2);
                    if (file3 != null) {
                    }
                    throw th;
                }
                file3.delete();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class CrashPadUtil {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MAX_READ_BDMP = 102400;
        public static final int MAX_READ_EXTRA = 20480;
        public transient /* synthetic */ FieldHolder $fh;

        public CrashPadUtil() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static void createJsonExtraInfo(@NonNull File file, @NonNull JsonWriter jsonWriter) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65539, null, file, jsonWriter) == null) || file == null || !file.exists() || jsonWriter == null) {
                return;
            }
            try {
                Pair<String, Boolean> readFile = Utility.readFile(file, MAX_READ_EXTRA);
                if (readFile == null || TextUtils.isEmpty((CharSequence) readFile.first)) {
                    return;
                }
                if (LogSystemUploaderStrategy.DEBUG) {
                    DebugUtil.saveLog("json-extra : " + ((String) readFile.first));
                    String str = "json-extra.size = " + ((String) readFile.first).length();
                }
                jsonWriter.name(Constant.CRASH_ENVIR).value((String) readFile.first);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        public static void createMiniBDMPInfo(@NonNull File file, @NonNull JsonWriter jsonWriter) {
            ByteArrayOutputStream byteArrayOutputStream;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, jsonWriter) == null) || file == null || jsonWriter == null || !file.exists()) {
                return;
            }
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        int round = Math.round(76800.0f);
                        int i2 = 0;
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1 || i2 >= round) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                            i2 += read;
                        }
                        byteArrayOutputStream.flush();
                        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 11);
                        if (LogSystemUploaderStrategy.DEBUG) {
                            DebugUtil.saveLog("mini-bdmp : " + encodeToString);
                        }
                        jsonWriter.name(Constant.STACKTRACE_BDMP).value(encodeToString);
                        Closeables.closeSafely(fileInputStream2);
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        try {
                            e.printStackTrace();
                            Closeables.closeSafely(fileInputStream);
                            Closeables.closeSafely(byteArrayOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            Closeables.closeSafely(fileInputStream);
                            Closeables.closeSafely(byteArrayOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        Closeables.closeSafely(fileInputStream);
                        Closeables.closeSafely(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                }
            } catch (Exception e4) {
                e = e4;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
            }
            Closeables.closeSafely(byteArrayOutputStream);
        }
    }

    /* loaded from: classes7.dex */
    public static final class FileEntity implements Comparable<FileEntity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public File mFile;
        @NonNull
        public FileName mFileName;

        public FileEntity(@NonNull File file, @NonNull FileName fileName) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, fileName};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mFile = file;
            this.mFileName = fileName;
        }

        public static FileEntity getFileEntity(@NonNull File file) {
            InterceptResult invokeL;
            FileName fileName;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
                if (file == null || !file.exists() || (fileName = FileName.getFileName(file.getName())) == null) {
                    return null;
                }
                return new FileEntity(file, fileName);
            }
            return (FileEntity) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(@NonNull FileEntity fileEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fileEntity)) == null) {
                int i2 = ((this.mFileName.mTimestamp.longValue() - fileEntity.mFileName.mTimestamp.longValue()) > 0L ? 1 : ((this.mFileName.mTimestamp.longValue() - fileEntity.mFileName.mTimestamp.longValue()) == 0L ? 0 : -1));
                if (i2 > 0) {
                    return -1;
                }
                return i2 < 0 ? 1 : 0;
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class StoreUtil {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String BASE_GZIP_TMP = ".gz.tmp";
        public static final String BASE_TMP = ".tmp";
        public static final String BASE_UPLOAD_ATTACHMENT_DIR = "attachment";
        public static final String BASE_UPLOAD_ATTACHMENT_FLAG = "attachment.flag";
        public static final String BASE_UPLOAD_CONTENT_DIR = "content";
        public static final String BASE_UPLOAD_CONTENT_FLAG = "content.flag";
        public static final String INVALID_UPLOAD_ZIP_DIR = "zip_supply";
        public transient /* synthetic */ FieldHolder $fh;

        public StoreUtil() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static File getAttachDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), "attachment") : (File) invokeV.objValue;
        }

        public static final File getAttachFlag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new File(getStoreDir(), "attachment.flag") : (File) invokeV.objValue;
        }

        public static File getContentDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), "content") : (File) invokeV.objValue;
        }

        public static final File getContentFlag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? new File(getStoreDir(), BASE_UPLOAD_CONTENT_FLAG) : (File) invokeV.objValue;
        }

        public static File getInvalidZipDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), "zip_supply") : (File) invokeV.objValue;
        }

        public static File getStoreDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get() : (File) invokeV.objValue;
        }

        @NonNull
        public static File obtainFilePath(@NonNull File file, @NonNull FileName fileName) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, file, fileName)) == null) ? new File(file, FileName.getFileName(fileName)) : (File) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class TrimConfig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long mLifeTime;
        public int mMaxCount;

        public TrimConfig(int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mMaxCount = i2;
            this.mLifeTime = j;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Type ATTACHMENT;
        public static final Type CONTENT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(912083610, "Lcom/baidu/searchbox/logsystem/basic/upload/LogSystemUploaderStrategy$Type;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(912083610, "Lcom/baidu/searchbox/logsystem/basic/upload/LogSystemUploaderStrategy$Type;");
                    return;
                }
            }
            CONTENT = new Type("CONTENT", 0);
            Type type = new Type("ATTACHMENT", 1);
            ATTACHMENT = type;
            $VALUES = new Type[]{CONTENT, type};
        }

        public Type(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Type valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Type) Enum.valueOf(Type.class, str) : (Type) invokeL.objValue;
        }

        public static Type[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Type[]) $VALUES.clone() : (Type[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-843860482, "Lcom/baidu/searchbox/logsystem/basic/upload/LogSystemUploaderStrategy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-843860482, "Lcom/baidu/searchbox/logsystem/basic/upload/LogSystemUploaderStrategy;");
                return;
            }
        }
        DEBUG = LLog.sDebug;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LogSystemUploaderStrategy() {
        this(true, true, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Boolean) objArr[0]).booleanValue(), ((Boolean) objArr[1]).booleanValue(), (BaseUploaderStrategy.UploadListener) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean checkFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? StoreUtil.getContentFlag().exists() || StoreUtil.getAttachFlag().exists() : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanDiskCache(Type type) {
        File[] listFiles;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, type) == null) {
            int i3 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
            if (i3 == 1) {
                listFiles = StoreUtil.getContentDir().listFiles();
                i2 = 500;
            } else if (i3 != 2) {
                listFiles = null;
                i2 = 0;
            } else {
                listFiles = StoreUtil.getAttachDir().listFiles();
                i2 = 100;
            }
            if (listFiles == null || listFiles.length == 0) {
                return;
            }
            Pair<LinkedList<FileEntity>, LinkedList<File>> fileCluster = fileCluster(listFiles, new TrimConfig(i2, 2592000000L));
            if (((LinkedList) fileCluster.second).size() > 0) {
                Iterator it = ((LinkedList) fileCluster.second).iterator();
                while (it.hasNext()) {
                    File file = (File) it.next();
                    if (file != null) {
                        file.delete();
                    }
                }
            }
            updateFileFlag(type);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a9, code lost:
        if (r6 == 2) goto L46;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private File createAttachZipFile(@NonNull LogObject logObject, @Nullable List<LogFile> list, @Nullable Set<LogFile> set, @Nullable List<LogFile> list2, @NonNull String str) {
        InterceptResult invokeLLLLL;
        FileName fileName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65549, this, logObject, list, set, list2, str)) == null) {
            if (logObject.getLogBasicDataFile() == null || !logObject.getLogBasicDataFile().exists() || (fileName = FileName.getFileName(str, logObject.getProcessName(), logObject.mLogType)) == null) {
                return null;
            }
            File attachDir = StoreUtil.getAttachDir();
            if (!attachDir.exists()) {
                attachDir.mkdirs();
            }
            File obtainFilePath = StoreUtil.obtainFilePath(attachDir, fileName);
            try {
                if (obtainFilePath.exists()) {
                    obtainFilePath.delete();
                }
                obtainFilePath.createNewFile();
            } catch (IOException e2) {
                if (LLog.sDebug) {
                    e2.getMessage();
                }
            }
            if (obtainFilePath.exists()) {
                LinkedList linkedList = new LinkedList();
                if (set != null && set.size() > 0) {
                    linkedList.addAll(set);
                }
                if (list != null && list.size() > 0) {
                    linkedList.addAll(list);
                }
                if (list2 != null && list2.size() > 0) {
                    int i2 = 0;
                    for (LogFile logFile : list2) {
                        if (logFile != null && (logFile.mFile.getName().startsWith(CrashUtil.CrashpadConstant.FULL_BDMP_PERFIX) || logFile.mFile.getName().startsWith(CrashUtil.CrashpadConstant.TXT_EXTRA))) {
                            linkedList.add(logFile);
                            i2++;
                        }
                    }
                }
                try {
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new ZipUtils.ZipSrc(logObject.getLogBasicDataFile(), SnapshotConstant.ProcessConstants.PROCESS_LOG_BASIC_DATA));
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        LogFile logFile2 = (LogFile) it.next();
                        if (logFile2 != null && logFile2.mFile.exists()) {
                            linkedList2.add(new ZipUtils.ZipSrc(logFile2.mFile));
                        }
                    }
                    ZipUtils.zip(obtainFilePath, linkedList2);
                    return obtainFilePath;
                } catch (IOException e3) {
                    if (LLog.sDebug) {
                        e3.getMessage();
                    }
                }
            }
            return null;
        }
        return (File) invokeLLLLL.objValue;
    }

    private File createContentFile(@NonNull LogObject logObject, @Nullable List<LogFile> list, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, this, logObject, list, str)) == null) {
            File contentDir = StoreUtil.getContentDir();
            if (!contentDir.exists()) {
                contentDir.mkdirs();
            }
            FileName fileName = FileName.getFileName(str, logObject.getProcessName(), logObject.mLogType);
            if (fileName == null) {
                return null;
            }
            File obtainFilePath = StoreUtil.obtainFilePath(contentDir, fileName);
            File file = new File(obtainFilePath.getAbsolutePath() + ".tmp");
            File file2 = new File(obtainFilePath.getAbsolutePath() + StoreUtil.BASE_GZIP_TMP);
            Utility.createNewEmptyFile(file);
            Utility.createNewEmptyFile(file2);
            if (file.exists()) {
                ContentUtil.createUBCContentInfo(logObject, list, str, file);
                if (file2.exists()) {
                    ContentUtil.gzipContent(file, file2);
                }
                file2.renameTo(obtainFilePath);
            }
            file.delete();
            file2.delete();
            if (obtainFilePath.exists()) {
                return obtainFilePath;
            }
            return null;
        }
        return (File) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doUpload(Type type, int i2) {
        InterceptResult invokeLI;
        File[] listFiles;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, this, type, i2)) == null) {
            int i5 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
            if (i5 == 1) {
                listFiles = StoreUtil.getContentDir().listFiles();
                i3 = 500;
            } else if (i5 != 2) {
                listFiles = null;
                i3 = 0;
            } else {
                listFiles = StoreUtil.getAttachDir().listFiles();
                i3 = 100;
            }
            if (listFiles == null || listFiles.length == 0) {
                return false;
            }
            Pair<LinkedList<FileEntity>, LinkedList<File>> fileCluster = fileCluster(listFiles, new TrimConfig(i3, 2592000000L));
            if (((LinkedList) fileCluster.second).size() > 0) {
                Iterator it = ((LinkedList) fileCluster.second).iterator();
                while (it.hasNext()) {
                    File file = (File) it.next();
                    if (file != null) {
                        if (DEBUG) {
                            String str = "invalid delete = " + file.getAbsolutePath();
                        }
                        file.delete();
                    }
                }
            }
            if (((LinkedList) fileCluster.first).size() > 0) {
                Iterator it2 = ((LinkedList) fileCluster.first).iterator();
                i4 = 0;
                while (it2.hasNext() && i4 < i2) {
                    FileEntity fileEntity = (FileEntity) it2.next();
                    if (fileEntity != null) {
                        i4++;
                        ResponseEntity uploadAction = uploadAction(type, fileEntity);
                        if (uploadAction == null || !uploadAction.isSuccess()) {
                            break;
                        }
                        fileEntity.mFile.delete();
                    }
                }
            } else {
                i4 = 0;
            }
            return i4 == i2;
        }
        return invokeLI.booleanValue;
    }

    @NonNull
    private Pair<LinkedList<FileEntity>, LinkedList<File>> fileCluster(@NonNull File[] fileArr, @NonNull TrimConfig trimConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, this, fileArr, trimConfig)) == null) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = 0;
            for (File file : fileArr) {
                if (file != null && file.exists()) {
                    FileEntity fileEntity = FileEntity.getFileEntity(file);
                    if (fileEntity != null) {
                        if (currentTimeMillis - fileEntity.mFileName.mTimestamp.longValue() > trimConfig.mLifeTime) {
                            linkedList2.add(file);
                        } else {
                            linkedList.add(fileEntity);
                        }
                    } else {
                        linkedList2.add(file);
                    }
                }
            }
            Collections.sort(linkedList);
            if (linkedList.size() > trimConfig.mMaxCount) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    i2++;
                    FileEntity fileEntity2 = (FileEntity) it.next();
                    if (i2 > trimConfig.mMaxCount) {
                        linkedList2.add(fileEntity2.mFile);
                        it.remove();
                        if (DEBUG) {
                            String str = "fileCluster + " + Thread.currentThread().getName();
                        }
                    }
                }
            }
            return new Pair<>(linkedList, linkedList2);
        }
        return (Pair) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFileFlag(Type type) {
        File contentDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, type) == null) {
            int i2 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
            boolean z = true;
            File file = null;
            if (i2 == 1) {
                file = StoreUtil.getContentFlag();
                contentDir = StoreUtil.getContentDir();
            } else if (i2 != 2) {
                contentDir = null;
            } else {
                file = StoreUtil.getAttachFlag();
                contentDir = StoreUtil.getAttachDir();
            }
            if (file == null || contentDir == null) {
                return;
            }
            String[] list = contentDir.list();
            z = (list == null || list.length <= 0) ? false : false;
            boolean exists = file.exists();
            if (!z) {
                if (exists) {
                    file.delete();
                }
            } else if (exists) {
            } else {
                try {
                    file.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @NonNull
    private ResponseEntity uploadAction(@NonNull Type type, @NonNull FileEntity fileEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, this, type, fileEntity)) == null) {
            if (type != null && fileEntity != null) {
                int i2 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        return uploadAttachmentSync(fileEntity.mFileName.mFileID, fileEntity.mFile);
                    }
                    return new ResponseEntity(false);
                }
                return uploadContentSync(fileEntity.mFile);
            }
            return new ResponseEntity(false);
        }
        return (ResponseEntity) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public ResponseEntity uploadAttachmentSync(@NonNull String str, @NonNull File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, this, str, file)) == null) {
            if (!TextUtils.isEmpty(str) && file != null) {
                ResponseEntity uploadSync = UploaderProvider.getAttachUploader().uploadSync(str, file);
                if (uploadSync == null) {
                    uploadSync = new ResponseEntity(false);
                }
                if (DEBUG && uploadSync != null) {
                    String str2 = "attachment upload success = " + uploadSync.isSuccess() + "," + file.getAbsolutePath();
                    String message = uploadSync.getMessage();
                    if (!TextUtils.isEmpty(message)) {
                        String str3 = "attachment upload message = " + message;
                    }
                }
                return uploadSync;
            }
            return new ResponseEntity(false);
        }
        return (ResponseEntity) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy
    public boolean canStopService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAttachmentExecutor.getQueue().size() == 0 && this.mAttachmentExecutor.getActiveCount() == 0 && this.mContentExecutor.getQueue().size() == 0 && this.mContentExecutor.getActiveCount() == 0 : invokeV.booleanValue;
    }

    public void reUpload(Type type, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, type, i2) == null) || i2 <= 0) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor = null;
        int i3 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
        if (i3 == 1) {
            threadPoolExecutor = this.mContentExecutor;
        } else if (i3 == 2) {
            threadPoolExecutor = this.mAttachmentExecutor;
        }
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(new Runnable(this, type, i2) { // from class: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LogSystemUploaderStrategy this$0;
                public final /* synthetic */ int val$maxFileCount;
                public final /* synthetic */ Type val$type;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, type, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$type = type;
                    this.val$maxFileCount = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!this.this$0.doUpload(this.val$type, this.val$maxFileCount)) {
                            this.this$0.updateFileFlag(this.val$type);
                        } else {
                            this.this$0.reUpload(this.val$type, this.val$maxFileCount);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy, com.baidu.searchbox.logsystem.basic.upload.UploadInterface
    public void upload(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            reUpload(Type.CONTENT, 5);
            reUpload(Type.ATTACHMENT, 5);
            if (this.mInvalidDirDeleted) {
                return;
            }
            this.mInvalidDirDeleted = true;
            File invalidZipDir = StoreUtil.getInvalidZipDir();
            if (invalidZipDir.exists()) {
                invalidZipDir.delete();
            }
        }
    }

    @NonNull
    public ResponseEntity uploadContentSync(@NonNull File file) {
        InterceptResult invokeL;
        BaseContentUploader contentUploader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, file)) == null) {
            if (file == null) {
                return new ResponseEntity(false);
            }
            BaseContentUploader defaultContentUploader = UploaderProvider.getDefaultContentUploader();
            ResponseEntity uploadSync = defaultContentUploader.uploadSync(file);
            if (!(uploadSync != null ? uploadSync.isSuccess() : false) && (contentUploader = UploaderProvider.getContentUploader()) != defaultContentUploader) {
                uploadSync = contentUploader.uploadSync(file);
            }
            if (uploadSync == null) {
                uploadSync = new ResponseEntity(false);
            }
            if (DEBUG && uploadSync != null) {
                String str = "content upload file = " + file.getAbsolutePath();
                String str2 = "content upload success = " + uploadSync.isSuccess();
                String message = uploadSync.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    String str3 = "content upload message = " + message;
                }
            }
            return uploadSync;
        }
        return (ResponseEntity) invokeL.objValue;
    }

    /* loaded from: classes7.dex */
    public static final class FileName {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FILE_ID_SEPARATOR = "_";
        public static final String SEPARATOR = "#";
        public transient /* synthetic */ FieldHolder $fh;
        public String mFileID;
        public LogType mLogType;
        public String mProcessName;
        public Long mTimestamp;

        public FileName(@NonNull String str, long j, @NonNull String str2, @NonNull LogType logType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j), str2, logType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mFileID = str;
            this.mTimestamp = Long.valueOf(j);
            this.mProcessName = str2;
            this.mLogType = logType;
        }

        public static String createFileID(@NonNull String str, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, str, j)) == null) {
                return str.replace("_", "").replace("#", "") + "_" + j;
            }
            return (String) invokeLJ.objValue;
        }

        @NonNull
        public static String getFileName(@NonNull FileName fileName) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, fileName)) == null) {
                return fileName.mFileID + "#" + fileName.mProcessName + "#" + fileName.mLogType.getTypeName();
            }
            return (String) invokeL.objValue;
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mFileID + "#" + this.mTimestamp + "#" + this.mProcessName + "#" + this.mLogType.getTypeName();
            }
            return (String) invokeV.objValue;
        }

        public static FileName getFileName(String str, String str2, LogType logType) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, str, str2, logType)) == null) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && logType != null) {
                    long j = -1;
                    String[] split = str.split("_");
                    if (split != null && split.length == 2) {
                        try {
                            j = Long.valueOf(split[1]).longValue();
                        } catch (NumberFormatException unused) {
                            return null;
                        }
                    }
                    long j2 = j;
                    if (j2 > 0) {
                        return new FileName(str, j2, str2, logType);
                    }
                }
                return null;
            }
            return (FileName) invokeLLL.objValue;
        }

        public static FileName getFileName(@NonNull String str) {
            InterceptResult invokeL;
            String[] split;
            String[] split2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
                if (!TextUtils.isEmpty(str) && (split = str.split("#")) != null && split.length == 3) {
                    long j = -1;
                    String str2 = split[0];
                    if (!TextUtils.isEmpty(str2) && (split2 = str2.split("_")) != null && split2.length == 2) {
                        String str3 = split2[1];
                        if (!TextUtils.isEmpty(str3)) {
                            try {
                                j = Long.valueOf(str3).longValue();
                            } catch (NumberFormatException unused) {
                                return null;
                            }
                        }
                    }
                    String str4 = split[1];
                    LogType logType = LogType.getLogType(split[2]);
                    if (!TextUtils.isEmpty(str2) && j > 0 && !TextUtils.isEmpty(str4) && logType != null) {
                        return new FileName(str2, j, str4, logType);
                    }
                }
                return null;
            }
            return (FileName) invokeL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LogSystemUploaderStrategy(boolean z, boolean z2) {
        this(z, z2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue(), (BaseUploaderStrategy.UploadListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogSystemUploaderStrategy(boolean z, boolean z2, @Nullable BaseUploaderStrategy.UploadListener uploadListener) {
        super(z, z2, uploadListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), uploadListener};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue(), (BaseUploaderStrategy.UploadListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mInvalidDirDeleted = false;
        this.mContentExecutor = new ThreadPoolExecutor(1, 1, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.mAttachmentExecutor = new ThreadPoolExecutor(1, 1, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy, com.baidu.searchbox.logsystem.basic.upload.UploadInterface
    public void upload(Context context, @NonNull LogObject logObject, @Nullable List<LogFile> list, @Nullable Set<LogFile> set, @Nullable List<LogFile> list2) {
        CrashUtil.CrashTAG crashTAG;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, logObject, list, set, list2) == null) {
            if (logObject.mLogType != LogType.JAVA_CRASH || this.mUploadJavaCrash) {
                if ((logObject.mLogType != LogType.NATIVE_CRASH || this.mUploadNativeCrash) && (crashTAG = CrashUtil.CrashTAG.getCrashTAG(logObject.getCrashTAG())) != null) {
                    String createFileID = FileName.createFileID(crashTAG.mCrashProcessUUID, System.currentTimeMillis());
                    File createContentFile = createContentFile(logObject, list2, createFileID);
                    File createAttachZipFile = createAttachZipFile(logObject, list, set, list2, createFileID);
                    BaseUploaderStrategy.UploadListener uploadListener = this.mUploadListener;
                    if (uploadListener != null) {
                        uploadListener.onUploadStart(logObject);
                    }
                    if (createContentFile != null) {
                        this.mContentExecutor.execute(new Runnable(this, context, createContentFile) { // from class: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ LogSystemUploaderStrategy this$0;
                            public final /* synthetic */ File val$contentFile;
                            public final /* synthetic */ Context val$context;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, context, createContentFile};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$context = context;
                                this.val$contentFile = createContentFile;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    if (!Utility.isNetWorkEnabled(this.val$context)) {
                                        this.this$0.cleanDiskCache(Type.CONTENT);
                                        return;
                                    }
                                    this.this$0.updateFileFlag(Type.CONTENT);
                                    if (LLog.sDebug) {
                                        String str = "new content file = " + this.val$contentFile.getAbsolutePath();
                                    }
                                    ResponseEntity uploadContentSync = this.this$0.uploadContentSync(this.val$contentFile);
                                    if (uploadContentSync.isSuccess()) {
                                        this.val$contentFile.delete();
                                    }
                                    if (this.this$0.mContentExecutor.getQueue().size() == 0) {
                                        if (!uploadContentSync.isSuccess()) {
                                            this.this$0.cleanDiskCache(Type.CONTENT);
                                        } else {
                                            this.this$0.reUpload(Type.CONTENT, 5);
                                        }
                                    }
                                }
                            }
                        });
                    }
                    if (createAttachZipFile != null) {
                        this.mAttachmentExecutor.execute(new Runnable(this, context, createAttachZipFile, createFileID) { // from class: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ LogSystemUploaderStrategy this$0;
                            public final /* synthetic */ File val$attachZipFile;
                            public final /* synthetic */ Context val$context;
                            public final /* synthetic */ String val$fileID;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, context, createAttachZipFile, createFileID};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$context = context;
                                this.val$attachZipFile = createAttachZipFile;
                                this.val$fileID = createFileID;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    if (!Utility.isNetWorkEnabled(this.val$context)) {
                                        this.this$0.cleanDiskCache(Type.ATTACHMENT);
                                        return;
                                    }
                                    this.this$0.updateFileFlag(Type.ATTACHMENT);
                                    if (LLog.sDebug) {
                                        String str = "new attachement file = " + this.val$attachZipFile.getAbsolutePath();
                                    }
                                    ResponseEntity uploadAttachmentSync = this.this$0.uploadAttachmentSync(this.val$fileID, this.val$attachZipFile);
                                    if (uploadAttachmentSync.isSuccess()) {
                                        this.val$attachZipFile.delete();
                                    }
                                    if (this.this$0.mAttachmentExecutor.getQueue().size() == 0) {
                                        if (!uploadAttachmentSync.isSuccess()) {
                                            this.this$0.cleanDiskCache(Type.ATTACHMENT);
                                        } else {
                                            this.this$0.reUpload(Type.ATTACHMENT, 5);
                                        }
                                    }
                                }
                            }
                        });
                        BaseUploaderStrategy.UploadListener uploadListener2 = this.mUploadListener;
                        if (uploadListener2 != null) {
                            uploadListener2.onUploadDone(logObject);
                        }
                    }
                }
            }
        }
    }
}
