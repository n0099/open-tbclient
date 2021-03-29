package com.baidu.searchbox.logsystem.basic.upload;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.JsonWriter;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.util.io.Closeables;
import com.baidu.mapsdkplatform.comapi.map.r;
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
/* loaded from: classes2.dex */
public class LogSystemUploaderStrategy extends BaseUploaderStrategy {
    public static final boolean DEBUG = LLog.sDebug;
    public static final String TAG = "LSStrategy";
    public ThreadPoolExecutor mAttachmentExecutor;
    public ThreadPoolExecutor mContentExecutor;
    public boolean mInvalidDirDeleted;

    /* renamed from: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type;

        static {
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

    /* loaded from: classes2.dex */
    public static final class Constants {
        public static final int KEEP_ALIVE_TIME = 60000;
        public static final int MAX_COUNT_ATTACHMENT = 100;
        public static final int MAX_COUNT_CONTENT = 500;
        public static final long MAX_LIFE_TIME = 2592000000L;
        public static final String UBC_EVENT_ID = "1156";
        public static final int UI_TRACE_MAX_SIZE = 20;
        public static final int UPLOAD_MAX_FILE = 5;
    }

    /* loaded from: classes2.dex */
    public static final class ContentUtil {
        public static final byte GZIP_HEAD_1 = 117;
        public static final byte GZIP_HEAD_2 = 123;

        public static void createAperfInfo(@NonNull String str, @NonNull String str2, @NonNull JsonWriter jsonWriter) {
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
                    jsonWriter.name(Constant.DEVICE_SCORE).value(deviceScore);
                }
                jsonWriter.name("fileid").value(str2);
                jsonWriter.endObject();
            } catch (IOException e2) {
                if (LLog.sDebug) {
                    e2.printStackTrace();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:65:0x0189 A[Catch: IOException -> 0x01b3, TryCatch #0 {IOException -> 0x01b3, blocks: (B:3:0x0004, B:5:0x000a, B:9:0x002f, B:11:0x0057, B:12:0x0062, B:15:0x0076, B:17:0x007c, B:19:0x0093, B:22:0x009b, B:24:0x00a1, B:25:0x00a8, B:27:0x00ae, B:29:0x00b6, B:31:0x00c4, B:32:0x00c6, B:33:0x00c9, B:35:0x00d7, B:39:0x00df, B:41:0x00e4, B:42:0x00e7, B:44:0x011d, B:45:0x0132, B:46:0x013d, B:47:0x0145, B:49:0x014b, B:51:0x0157, B:53:0x015d, B:63:0x0180, B:65:0x0189, B:66:0x0190, B:68:0x0196, B:59:0x0170, B:61:0x0174, B:69:0x019d, B:18:0x008c), top: B:76:0x0004 }] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0196 A[Catch: IOException -> 0x01b3, TryCatch #0 {IOException -> 0x01b3, blocks: (B:3:0x0004, B:5:0x000a, B:9:0x002f, B:11:0x0057, B:12:0x0062, B:15:0x0076, B:17:0x007c, B:19:0x0093, B:22:0x009b, B:24:0x00a1, B:25:0x00a8, B:27:0x00ae, B:29:0x00b6, B:31:0x00c4, B:32:0x00c6, B:33:0x00c9, B:35:0x00d7, B:39:0x00df, B:41:0x00e4, B:42:0x00e7, B:44:0x011d, B:45:0x0132, B:46:0x013d, B:47:0x0145, B:49:0x014b, B:51:0x0157, B:53:0x015d, B:63:0x0180, B:65:0x0189, B:66:0x0190, B:68:0x0196, B:59:0x0170, B:61:0x0174, B:69:0x019d, B:18:0x008c), top: B:76:0x0004 }] */
        @NonNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void createCrashInfo(@NonNull LogObject logObject, @Nullable List<LogFile> list, @NonNull JsonWriter jsonWriter) {
            String str;
            String str2;
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
                        int i = 0;
                        File file = null;
                        File file2 = null;
                        for (LogFile logFile : list) {
                            if (logFile != null) {
                                if (logFile.mFile.getName().startsWith(CrashUtil.CrashpadConstant.MIND_BDMP_PREFIX)) {
                                    file = logFile.mFile;
                                } else if (logFile.mFile.getName().startsWith(CrashUtil.CrashpadConstant.JSON_EXTRA)) {
                                    file2 = logFile.mFile;
                                }
                                i++;
                            }
                            if (i == 2) {
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
                            JSONObject jSONObject = new JSONObject(logExtra.mJSONAttach);
                            str2 = jSONObject.getString(Constant.LAUNCH_STAGE);
                            try {
                                str3 = jSONObject.getString(Constant.CRASH_STAGE);
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    if (!Constant.LAUNCH_STAGE.equals(next) && !Constant.CRASH_STAGE.equals(next)) {
                                        jsonWriter.name(next).value(jSONObject.getString(next));
                                    }
                                }
                            } catch (JSONException e2) {
                                e = e2;
                                String str4 = str3;
                                str3 = str2;
                                str = str4;
                                if (LLog.sDebug) {
                                    Log.d("LSStrategy", e.getMessage());
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
                        } catch (JSONException e3) {
                            e = e3;
                            str = "";
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

        public static void createTraceUI(@NonNull String str, @NonNull JsonWriter jsonWriter) {
            RandomAccessFile randomAccessFile;
            File file = new File(LogPipelineSingleton.obtainFileDirWithProcessName(str), SnapshotConstant.ProcessConstants.PROC_UI_TRACE);
            if (file.exists()) {
                int i = 0;
                RandomAccessFile randomAccessFile2 = null;
                try {
                    try {
                        randomAccessFile = new RandomAccessFile(file, r.f7664a);
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
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
                                i++;
                                if (i == 20) {
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
                                jsonWriter.name("page").value(parse2[2]);
                                jsonWriter.name("event").value(parse2[3]);
                                jsonWriter.endObject();
                            }
                        }
                    }
                    Closeables.closeSafely(randomAccessFile);
                } catch (IOException e3) {
                    e = e3;
                    randomAccessFile2 = randomAccessFile;
                    e.printStackTrace();
                    Closeables.closeSafely(randomAccessFile2);
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile2 = randomAccessFile;
                    Closeables.closeSafely(randomAccessFile2);
                    throw th;
                }
            }
        }

        public static void createUBCContentInfo(@NonNull LogObject logObject, @Nullable List<LogFile> list, @NonNull String str, @NonNull File file) {
            JsonWriter jsonWriter;
            JsonWriter jsonWriter2 = null;
            try {
                try {
                    jsonWriter = new JsonWriter(new FileWriter(file));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
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

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x005c */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x005f */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0062 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:67:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x00fc  */
        /* JADX WARN: Removed duplicated region for block: B:96:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
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
            if (file == null || file2 == null || !file.exists() || !file2.exists()) {
                return;
            }
            byte[] bArr = new byte[1024];
            FileOutputStream fileOutputStream = null;
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
                                Closeables.closeSafely(fileOutputStream);
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
                    } catch (IOException e4) {
                        e = e4;
                        r6 = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        gZIPOutputStream2 = null;
                        Closeables.closeSafely(fileOutputStream);
                        Closeables.closeSafely(gZIPOutputStream);
                        Closeables.closeSafely(gZIPOutputStream2);
                        if (file3 != null) {
                            file3.delete();
                        }
                        throw th;
                    }
                    try {
                        r6.close();
                    } catch (IOException e5) {
                        e = e5;
                        gZIPOutputStream = null;
                        e.printStackTrace();
                        Closeables.closeSafely(fileOutputStream);
                        Closeables.closeSafely(gZIPOutputStream);
                        Closeables.closeSafely((Closeable) r6);
                        if (file3 == null) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        gZIPOutputStream = null;
                        gZIPOutputStream2 = r6;
                        Closeables.closeSafely(fileOutputStream);
                        Closeables.closeSafely(gZIPOutputStream);
                        Closeables.closeSafely(gZIPOutputStream2);
                        if (file3 != null) {
                        }
                        throw th;
                    }
                }
                fileInputStream = new FileInputStream(file3);
            } catch (IOException e6) {
                e = e6;
                gZIPOutputStream = null;
                r6 = gZIPOutputStream;
                e.printStackTrace();
                Closeables.closeSafely(fileOutputStream);
                Closeables.closeSafely(gZIPOutputStream);
                Closeables.closeSafely((Closeable) r6);
                if (file3 == null) {
                }
            } catch (Throwable th5) {
                th = th5;
                gZIPOutputStream = null;
                gZIPOutputStream2 = gZIPOutputStream;
                Closeables.closeSafely(fileOutputStream);
                Closeables.closeSafely(gZIPOutputStream);
                Closeables.closeSafely(gZIPOutputStream2);
                if (file3 != null) {
                }
                throw th;
            }
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileOutputStream2.write(new byte[]{GZIP_HEAD_1, GZIP_HEAD_2});
                    if (fileInputStream.read(new byte[2]) != -1) {
                        while (true) {
                            int read2 = fileInputStream.read(bArr);
                            if (read2 == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read2);
                        }
                    }
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    fileInputStream.close();
                    Closeables.closeSafely((Closeable) null);
                    Closeables.closeSafely((Closeable) null);
                    Closeables.closeSafely((Closeable) null);
                    if (!file3.exists()) {
                        return;
                    }
                } catch (IOException e7) {
                    r6 = fileInputStream;
                    e = e7;
                    gZIPOutputStream = null;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    Closeables.closeSafely(fileOutputStream);
                    Closeables.closeSafely(gZIPOutputStream);
                    Closeables.closeSafely((Closeable) r6);
                    if (file3 == null) {
                        return;
                    }
                    return;
                } catch (Throwable th6) {
                    gZIPOutputStream2 = fileInputStream;
                    th = th6;
                    gZIPOutputStream = null;
                    fileOutputStream = fileOutputStream2;
                    Closeables.closeSafely(fileOutputStream);
                    Closeables.closeSafely(gZIPOutputStream);
                    Closeables.closeSafely(gZIPOutputStream2);
                    if (file3 != null && file3.exists()) {
                        file3.delete();
                    }
                    throw th;
                }
            } catch (IOException e8) {
                r6 = fileInputStream;
                e = e8;
                gZIPOutputStream = null;
                e.printStackTrace();
                Closeables.closeSafely(fileOutputStream);
                Closeables.closeSafely(gZIPOutputStream);
                Closeables.closeSafely((Closeable) r6);
                if (file3 == null) {
                }
            } catch (Throwable th7) {
                r6 = fileInputStream;
                th = th7;
                gZIPOutputStream = null;
                gZIPOutputStream2 = r6;
                Closeables.closeSafely(fileOutputStream);
                Closeables.closeSafely(gZIPOutputStream);
                Closeables.closeSafely(gZIPOutputStream2);
                if (file3 != null) {
                }
                throw th;
            }
            file3.delete();
        }
    }

    /* loaded from: classes2.dex */
    public static final class CrashPadUtil {
        public static final int MAX_READ_BDMP = 102400;
        public static final int MAX_READ_EXTRA = 20480;

        public static void createJsonExtraInfo(@NonNull File file, @NonNull JsonWriter jsonWriter) {
            if (file == null || !file.exists() || jsonWriter == null) {
                return;
            }
            try {
                Pair<String, Boolean> readFile = Utility.readFile(file, MAX_READ_EXTRA);
                if (readFile == null || TextUtils.isEmpty((CharSequence) readFile.first)) {
                    return;
                }
                if (LogSystemUploaderStrategy.DEBUG) {
                    DebugUtil.saveLog("json-extra : " + ((String) readFile.first));
                    Log.d("LSStrategy", "json-extra.size = " + ((String) readFile.first).length());
                }
                jsonWriter.name(Constant.CRASH_ENVIR).value((String) readFile.first);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        public static void createMiniBDMPInfo(@NonNull File file, @NonNull JsonWriter jsonWriter) {
            ByteArrayOutputStream byteArrayOutputStream;
            FileInputStream fileInputStream;
            if (file == null || jsonWriter == null || !file.exists()) {
                return;
            }
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                int round = Math.round(76800.0f);
                int i = 0;
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1 || i >= round) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                    i += read;
                }
                byteArrayOutputStream.flush();
                String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 11);
                if (LogSystemUploaderStrategy.DEBUG) {
                    DebugUtil.saveLog("mini-bdmp : " + encodeToString);
                }
                jsonWriter.name(Constant.STACKTRACE_BDMP).value(encodeToString);
                Closeables.closeSafely(fileInputStream);
            } catch (Exception e4) {
                e = e4;
                fileInputStream2 = fileInputStream;
                try {
                    e.printStackTrace();
                    Closeables.closeSafely(fileInputStream2);
                    Closeables.closeSafely(byteArrayOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    Closeables.closeSafely(fileInputStream2);
                    Closeables.closeSafely(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream2 = fileInputStream;
                Closeables.closeSafely(fileInputStream2);
                Closeables.closeSafely(byteArrayOutputStream);
                throw th;
            }
            Closeables.closeSafely(byteArrayOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public static final class FileEntity implements Comparable<FileEntity> {
        @NonNull
        public File mFile;
        @NonNull
        public FileName mFileName;

        public FileEntity(@NonNull File file, @NonNull FileName fileName) {
            this.mFile = file;
            this.mFileName = fileName;
        }

        public static FileEntity getFileEntity(@NonNull File file) {
            FileName fileName;
            if (file == null || !file.exists() || (fileName = FileName.getFileName(file.getName())) == null) {
                return null;
            }
            return new FileEntity(file, fileName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(@NonNull FileEntity fileEntity) {
            int i = ((this.mFileName.mTimestamp.longValue() - fileEntity.mFileName.mTimestamp.longValue()) > 0L ? 1 : ((this.mFileName.mTimestamp.longValue() - fileEntity.mFileName.mTimestamp.longValue()) == 0L ? 0 : -1));
            if (i > 0) {
                return -1;
            }
            return i < 0 ? 1 : 0;
        }
    }

    /* loaded from: classes2.dex */
    public static final class StoreUtil {
        public static final String BASE_GZIP_TMP = ".gz.tmp";
        public static final String BASE_TMP = ".tmp";
        public static final String BASE_UPLOAD_ATTACHMENT_DIR = "attachment";
        public static final String BASE_UPLOAD_ATTACHMENT_FLAG = "attachment.flag";
        public static final String BASE_UPLOAD_CONTENT_DIR = "content";
        public static final String BASE_UPLOAD_CONTENT_FLAG = "content.flag";
        public static final String INVALID_UPLOAD_ZIP_DIR = "zip_supply";

        public static File getAttachDir() {
            return new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), "attachment");
        }

        public static final File getAttachFlag() {
            return new File(getStoreDir(), "attachment.flag");
        }

        public static File getContentDir() {
            return new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), "content");
        }

        public static final File getContentFlag() {
            return new File(getStoreDir(), BASE_UPLOAD_CONTENT_FLAG);
        }

        public static File getInvalidZipDir() {
            return new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), "zip_supply");
        }

        public static File getStoreDir() {
            return LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get();
        }

        @NonNull
        public static File obtainFilePath(@NonNull File file, @NonNull FileName fileName) {
            return new File(file, FileName.getFileName(fileName));
        }
    }

    /* loaded from: classes2.dex */
    public static final class TrimConfig {
        public long mLifeTime;
        public int mMaxCount;

        public TrimConfig(int i, long j) {
            this.mMaxCount = i;
            this.mLifeTime = j;
        }
    }

    /* loaded from: classes2.dex */
    public enum Type {
        CONTENT,
        ATTACHMENT
    }

    public LogSystemUploaderStrategy() {
        this(true, true, null);
    }

    public static boolean checkFlag() {
        return StoreUtil.getContentFlag().exists() || StoreUtil.getAttachFlag().exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanDiskCache(Type type) {
        File[] listFiles;
        int i;
        int i2 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
        if (i2 == 1) {
            listFiles = StoreUtil.getContentDir().listFiles();
            i = 500;
        } else if (i2 != 2) {
            listFiles = null;
            i = 0;
        } else {
            listFiles = StoreUtil.getAttachDir().listFiles();
            i = 100;
        }
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        Pair<LinkedList<FileEntity>, LinkedList<File>> fileCluster = fileCluster(listFiles, new TrimConfig(i, 2592000000L));
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

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ab, code lost:
        if (r7 == 2) goto L44;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private File createAttachZipFile(@NonNull LogObject logObject, @Nullable List<LogFile> list, @Nullable Set<LogFile> set, @Nullable List<LogFile> list2, @NonNull String str) {
        FileName fileName;
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
                Log.d("LSStrategy", e2.getMessage());
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
                int i = 0;
                for (LogFile logFile : list2) {
                    if (logFile != null && (logFile.mFile.getName().startsWith(CrashUtil.CrashpadConstant.FULL_BDMP_PERFIX) || logFile.mFile.getName().startsWith(CrashUtil.CrashpadConstant.TXT_EXTRA))) {
                        linkedList.add(logFile);
                        i++;
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
                    Log.d("LSStrategy", e3.getMessage());
                }
            }
        }
        return null;
    }

    private File createContentFile(@NonNull LogObject logObject, @Nullable List<LogFile> list, @NonNull String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doUpload(Type type, int i) {
        File[] listFiles;
        int i2;
        int i3;
        int i4 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
        if (i4 == 1) {
            listFiles = StoreUtil.getContentDir().listFiles();
            i2 = 500;
        } else if (i4 != 2) {
            listFiles = null;
            i2 = 0;
        } else {
            listFiles = StoreUtil.getAttachDir().listFiles();
            i2 = 100;
        }
        if (listFiles == null || listFiles.length == 0) {
            return false;
        }
        Pair<LinkedList<FileEntity>, LinkedList<File>> fileCluster = fileCluster(listFiles, new TrimConfig(i2, 2592000000L));
        if (((LinkedList) fileCluster.second).size() > 0) {
            Iterator it = ((LinkedList) fileCluster.second).iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                if (file != null) {
                    if (DEBUG) {
                        Log.d("LSStrategy", "invalid delete = " + file.getAbsolutePath());
                    }
                    file.delete();
                }
            }
        }
        if (((LinkedList) fileCluster.first).size() > 0) {
            Iterator it2 = ((LinkedList) fileCluster.first).iterator();
            i3 = 0;
            while (it2.hasNext() && i3 < i) {
                FileEntity fileEntity = (FileEntity) it2.next();
                if (fileEntity != null) {
                    i3++;
                    ResponseEntity uploadAction = uploadAction(type, fileEntity);
                    if (uploadAction == null || !uploadAction.isSuccess()) {
                        break;
                    }
                    fileEntity.mFile.delete();
                }
            }
        } else {
            i3 = 0;
        }
        return i3 == i;
    }

    @NonNull
    private Pair<LinkedList<FileEntity>, LinkedList<File>> fileCluster(@NonNull File[] fileArr, @NonNull TrimConfig trimConfig) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
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
                i++;
                FileEntity fileEntity2 = (FileEntity) it.next();
                if (i > trimConfig.mMaxCount) {
                    linkedList2.add(fileEntity2.mFile);
                    it.remove();
                    if (DEBUG) {
                        Log.d("LSStrategy", "fileCluster + " + Thread.currentThread().getName());
                    }
                }
            }
        }
        return new Pair<>(linkedList, linkedList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFileFlag(Type type) {
        File contentDir;
        int i = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
        boolean z = true;
        File file = null;
        if (i == 1) {
            file = StoreUtil.getContentFlag();
            contentDir = StoreUtil.getContentDir();
        } else if (i != 2) {
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

    @NonNull
    private ResponseEntity uploadAction(@NonNull Type type, @NonNull FileEntity fileEntity) {
        if (type != null && fileEntity != null) {
            int i = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return uploadAttachmentSync(fileEntity.mFileName.mFileID, fileEntity.mFile);
                }
                return new ResponseEntity(false);
            }
            return uploadContentSync(fileEntity.mFile);
        }
        return new ResponseEntity(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public ResponseEntity uploadAttachmentSync(@NonNull String str, @NonNull File file) {
        if (!TextUtils.isEmpty(str) && file != null) {
            ResponseEntity uploadSync = UploaderProvider.getAttachUploader().uploadSync(str, file);
            if (uploadSync == null) {
                uploadSync = new ResponseEntity(false);
            }
            if (DEBUG && uploadSync != null) {
                Log.d("LSStrategy", "attachment upload success = " + uploadSync.isSuccess() + "," + file.getAbsolutePath());
                String message = uploadSync.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    Log.d("LSStrategy", "attachment upload message = " + message);
                }
            }
            return uploadSync;
        }
        return new ResponseEntity(false);
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy
    public boolean canStopService() {
        return this.mAttachmentExecutor.getQueue().size() == 0 && this.mAttachmentExecutor.getActiveCount() == 0 && this.mContentExecutor.getQueue().size() == 0 && this.mContentExecutor.getActiveCount() == 0;
    }

    public void reUpload(final Type type, final int i) {
        if (i <= 0) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor = null;
        int i2 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
        if (i2 == 1) {
            threadPoolExecutor = this.mContentExecutor;
        } else if (i2 == 2) {
            threadPoolExecutor = this.mAttachmentExecutor;
        }
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(new Runnable() { // from class: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!LogSystemUploaderStrategy.this.doUpload(type, i)) {
                        LogSystemUploaderStrategy.this.updateFileFlag(type);
                    } else {
                        LogSystemUploaderStrategy.this.reUpload(type, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy, com.baidu.searchbox.logsystem.basic.upload.UploadInterface
    public void upload(Context context) {
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

    @NonNull
    public ResponseEntity uploadContentSync(@NonNull File file) {
        BaseContentUploader contentUploader;
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
            Log.d("LSStrategy", "content upload file = " + file.getAbsolutePath());
            Log.d("LSStrategy", "content upload success = " + uploadSync.isSuccess());
            String message = uploadSync.getMessage();
            if (!TextUtils.isEmpty(message)) {
                Log.d("LSStrategy", "content upload message = " + message);
            }
        }
        return uploadSync;
    }

    /* loaded from: classes2.dex */
    public static final class FileName {
        public static final String FILE_ID_SEPARATOR = "_";
        public static final String SEPARATOR = "#";
        public String mFileID;
        public LogType mLogType;
        public String mProcessName;
        public Long mTimestamp;

        public FileName(@NonNull String str, long j, @NonNull String str2, @NonNull LogType logType) {
            this.mFileID = str;
            this.mTimestamp = Long.valueOf(j);
            this.mProcessName = str2;
            this.mLogType = logType;
        }

        public static String createFileID(@NonNull String str, long j) {
            return str.replace("_", "").replace("#", "") + "_" + j;
        }

        @NonNull
        public static String getFileName(@NonNull FileName fileName) {
            return fileName.mFileID + "#" + fileName.mProcessName + "#" + fileName.mLogType.getTypeName();
        }

        @NonNull
        public String toString() {
            return this.mFileID + "#" + this.mTimestamp + "#" + this.mProcessName + "#" + this.mLogType.getTypeName();
        }

        public static FileName getFileName(String str, String str2, LogType logType) {
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

        public static FileName getFileName(@NonNull String str) {
            String[] split;
            String[] split2;
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
    }

    public LogSystemUploaderStrategy(boolean z, boolean z2) {
        this(z, z2, null);
    }

    public LogSystemUploaderStrategy(boolean z, boolean z2, @Nullable BaseUploaderStrategy.UploadListener uploadListener) {
        super(z, z2, uploadListener);
        this.mInvalidDirDeleted = false;
        this.mContentExecutor = new ThreadPoolExecutor(1, 1, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.mAttachmentExecutor = new ThreadPoolExecutor(1, 1, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy, com.baidu.searchbox.logsystem.basic.upload.UploadInterface
    public void upload(final Context context, @NonNull LogObject logObject, @Nullable List<LogFile> list, @Nullable Set<LogFile> set, @Nullable List<LogFile> list2) {
        CrashUtil.CrashTAG crashTAG;
        if (logObject.mLogType != LogType.JAVA_CRASH || this.mUploadJavaCrash) {
            if ((logObject.mLogType != LogType.NATIVE_CRASH || this.mUploadNativeCrash) && (crashTAG = CrashUtil.CrashTAG.getCrashTAG(logObject.getCrashTAG())) != null) {
                final String createFileID = FileName.createFileID(crashTAG.mCrashProcessUUID, System.currentTimeMillis());
                final File createContentFile = createContentFile(logObject, list2, createFileID);
                final File createAttachZipFile = createAttachZipFile(logObject, list, set, list2, createFileID);
                BaseUploaderStrategy.UploadListener uploadListener = this.mUploadListener;
                if (uploadListener != null) {
                    uploadListener.onUploadStart(logObject);
                }
                if (createContentFile != null) {
                    this.mContentExecutor.execute(new Runnable() { // from class: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!Utility.isNetWorkEnabled(context)) {
                                LogSystemUploaderStrategy.this.cleanDiskCache(Type.CONTENT);
                                return;
                            }
                            LogSystemUploaderStrategy.this.updateFileFlag(Type.CONTENT);
                            if (LLog.sDebug) {
                                Log.d("LSStrategy", "new content file = " + createContentFile.getAbsolutePath());
                            }
                            ResponseEntity uploadContentSync = LogSystemUploaderStrategy.this.uploadContentSync(createContentFile);
                            if (uploadContentSync.isSuccess()) {
                                createContentFile.delete();
                            }
                            if (LogSystemUploaderStrategy.this.mContentExecutor.getQueue().size() == 0) {
                                if (!uploadContentSync.isSuccess()) {
                                    LogSystemUploaderStrategy.this.cleanDiskCache(Type.CONTENT);
                                } else {
                                    LogSystemUploaderStrategy.this.reUpload(Type.CONTENT, 5);
                                }
                            }
                        }
                    });
                }
                if (createAttachZipFile != null) {
                    this.mAttachmentExecutor.execute(new Runnable() { // from class: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!Utility.isNetWorkEnabled(context)) {
                                LogSystemUploaderStrategy.this.cleanDiskCache(Type.ATTACHMENT);
                                return;
                            }
                            LogSystemUploaderStrategy.this.updateFileFlag(Type.ATTACHMENT);
                            if (LLog.sDebug) {
                                Log.d("LSStrategy", "new attachement file = " + createAttachZipFile.getAbsolutePath());
                            }
                            ResponseEntity uploadAttachmentSync = LogSystemUploaderStrategy.this.uploadAttachmentSync(createFileID, createAttachZipFile);
                            if (uploadAttachmentSync.isSuccess()) {
                                createAttachZipFile.delete();
                            }
                            if (LogSystemUploaderStrategy.this.mAttachmentExecutor.getQueue().size() == 0) {
                                if (!uploadAttachmentSync.isSuccess()) {
                                    LogSystemUploaderStrategy.this.cleanDiskCache(Type.ATTACHMENT);
                                } else {
                                    LogSystemUploaderStrategy.this.reUpload(Type.ATTACHMENT, 5);
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
