package com.baidu.searchbox.logsystem.basic.upload;

import android.text.TextUtils;
import android.util.JsonWriter;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.basic.upload.identity.NetworkParam;
import com.baidu.searchbox.logsystem.logsys.CrashUtil;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.LogObject;
import com.baidu.searchbox.logsystem.logsys.LogPipelineSingleton;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.searchbox.logsystem.util.AppExtraUtil;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.searchbox.logsystem.util.Utility;
import com.baidu.searchbox.track.ui.TrackUI;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class ContentUtil {
    public static final byte GZIP_HEAD_1 = 117;
    public static final byte GZIP_HEAD_2 = 123;
    public static final String TAG = "ContentUtil";
    public static final String UBC_EVENT_ID = "1156";
    public static final int UI_TRACE_MAX_SIZE = 20;

    public static void createAperfInfo(@NonNull LogObject logObject, @NonNull String str, @NonNull JsonWriter jsonWriter) {
        try {
            jsonWriter.name(Constant.APERF);
            jsonWriter.beginObject();
            jsonWriter.name("launchid").value(logObject.getCrashTAG());
            jsonWriter.name("logid").value(UUID.randomUUID().toString());
            jsonWriter.name(Constant.APP_EXT).value(AppExtraUtil.getAppExtra());
            jsonWriter.name("packagename").value(AppRuntime.getAppContext().getPackageName());
            String oSVersion = CommonUtils.getOSVersion();
            if (oSVersion != null) {
                jsonWriter.name("osversion").value(oSVersion);
            }
            String memoryInfo = CommonUtils.getMemoryInfo();
            if (memoryInfo != null) {
                jsonWriter.name("memory").value(memoryInfo);
            }
            String rootedInfo = CommonUtils.getRootedInfo();
            if (rootedInfo != null) {
                jsonWriter.name("root").value(rootedInfo);
            }
            String emulator = CommonUtils.getEmulator();
            if (emulator != null) {
                jsonWriter.name("emulator").value(emulator);
            }
            String inStorage = CommonUtils.getInStorage();
            if (inStorage != null) {
                jsonWriter.name("inStorage").value(inStorage);
            }
            String exStorage = CommonUtils.getExStorage();
            if (exStorage != null) {
                jsonWriter.name("exStorage").value(exStorage);
            }
            String rom = CommonUtils.getROM();
            if (rom != null) {
                jsonWriter.name("ROM").value(rom);
            }
            String processBit = CommonUtils.getProcessBit();
            if (processBit != null) {
                jsonWriter.name("procBit").value(processBit);
            }
            String cPUInfo = CommonUtils.getCPUInfo();
            if (cPUInfo != null) {
                jsonWriter.name("cpu").value(cPUInfo);
            }
            String sDKVersion = CommonUtils.getSDKVersion(Constant.KEY_LOKI_CONFIG);
            if (sDKVersion != null) {
                jsonWriter.name("sdkversion").value(sDKVersion);
            }
            String appVersion = CommonUtils.getAppVersion();
            if (appVersion != null) {
                jsonWriter.name("appversion").value(appVersion);
            }
            jsonWriter.name("network").value(new NetworkParam().getCurrentNetTypeId());
            String deviceScore = LokiRuntime.getIdentityContext().getDeviceScore();
            if (!TextUtils.isEmpty(deviceScore)) {
                jsonWriter.name("devicescore").value(deviceScore);
            }
            jsonWriter.name("fileid").value(str);
            LogExtra logExtra = logObject.getLogExtra();
            if (logExtra != null) {
                String str2 = logExtra.mHeapMem;
                if (str2 != null) {
                    jsonWriter.name("heap").value(str2);
                }
                String str3 = logExtra.mSysMem;
                if (str3 != null) {
                    jsonWriter.name("sysMem").value(str3);
                }
                if (logExtra.mSysLowMem == 0) {
                    jsonWriter.name("isLowMemory").value(true);
                } else if (logExtra.mSysLowMem == 1) {
                    jsonWriter.name("isLowMemory").value(false);
                }
                String str4 = logExtra.mVSSRSS;
                if (str4 != null) {
                    jsonWriter.name("VSSRSS").value(str4);
                }
                String str5 = logExtra.mPSS;
                if (str5 != null) {
                    jsonWriter.name("PSS").value(str5);
                }
            }
            jsonWriter.endObject();
        } catch (IOException e) {
            if (LLog.sDebug) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x018d A[Catch: IOException -> 0x01b7, TryCatch #1 {IOException -> 0x01b7, blocks: (B:3:0x0004, B:5:0x000a, B:9:0x002f, B:11:0x0058, B:12:0x0063, B:15:0x0078, B:17:0x007e, B:19:0x0095, B:22:0x009d, B:24:0x00a3, B:25:0x00aa, B:27:0x00b0, B:29:0x00b8, B:31:0x00c6, B:32:0x00c8, B:33:0x00cb, B:35:0x00d9, B:39:0x00e1, B:41:0x00e6, B:42:0x00e9, B:44:0x0121, B:45:0x0136, B:46:0x0141, B:47:0x0149, B:49:0x014f, B:51:0x015b, B:53:0x0161, B:63:0x0184, B:65:0x018d, B:66:0x0194, B:68:0x019a, B:59:0x0174, B:61:0x0178, B:69:0x01a1, B:18:0x008e), top: B:78:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019a A[Catch: IOException -> 0x01b7, TryCatch #1 {IOException -> 0x01b7, blocks: (B:3:0x0004, B:5:0x000a, B:9:0x002f, B:11:0x0058, B:12:0x0063, B:15:0x0078, B:17:0x007e, B:19:0x0095, B:22:0x009d, B:24:0x00a3, B:25:0x00aa, B:27:0x00b0, B:29:0x00b8, B:31:0x00c6, B:32:0x00c8, B:33:0x00cb, B:35:0x00d9, B:39:0x00e1, B:41:0x00e6, B:42:0x00e9, B:44:0x0121, B:45:0x0136, B:46:0x0141, B:47:0x0149, B:49:0x014f, B:51:0x015b, B:53:0x0161, B:63:0x0184, B:65:0x018d, B:66:0x0194, B:68:0x019a, B:59:0x0174, B:61:0x0178, B:69:0x01a1, B:18:0x008e), top: B:78:0x0004 }] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void createCrashInfo(@NonNull LogObject logObject, @Nullable List<LogFile> list, @NonNull JsonWriter jsonWriter) {
        String str;
        String str2;
        String str3;
        JSONObject jSONObject;
        try {
            LogExtra logExtra = logObject.getLogExtra();
            if (logExtra != null) {
                jsonWriter.name("content");
                jsonWriter.beginObject();
                jsonWriter.name("page").value(logExtra.mPage);
                JsonWriter name = jsonWriter.name("type");
                if (logObject.mLogType == LogType.NATIVE_CRASH) {
                    str = Constant.TYPE_NATIVE;
                } else {
                    str = Constant.TYPE_JAVA;
                }
                name.value(str);
                jsonWriter.name(Constant.CRASH_TIME).value(logExtra.mCrashTime);
                jsonWriter.name("launchTime").value(logExtra.mLaunchTime);
                jsonWriter.name(Constant.PROCESS_LIFE_TIME).value(logExtra.mProcessLifeTime);
                if (logExtra.mForeground != null) {
                    jsonWriter.name(Constant.FOREGROUND).value(logExtra.mForeground);
                }
                String logBasicData = logObject.getLogBasicData();
                String typeName = logObject.mLogType.getTypeName();
                String str4 = "";
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
                        jSONObject = new JSONObject(logExtra.mJSONAttach);
                        str3 = jSONObject.optString(Constant.LAUNCH_STAGE);
                    } catch (JSONException e) {
                        e = e;
                        str2 = "";
                    }
                    try {
                        str4 = jSONObject.optString(Constant.CRASH_STAGE);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (!Constant.LAUNCH_STAGE.equals(next) && !Constant.CRASH_STAGE.equals(next)) {
                                jsonWriter.name(next).value(jSONObject.optString(next));
                            }
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        String str5 = str4;
                        str4 = str3;
                        str2 = str5;
                        if (LLog.sDebug) {
                            Log.d(TAG, e.getMessage());
                        }
                        String str6 = str4;
                        str4 = str2;
                        str3 = str6;
                        jsonWriter.endObject();
                        if (!TextUtils.isEmpty(str3)) {
                        }
                        if (!TextUtils.isEmpty(str4)) {
                        }
                        jsonWriter.name("pageTrace");
                        jsonWriter.beginArray();
                        createTraceUI(logObject.getProcessName(), jsonWriter);
                        jsonWriter.endArray();
                        jsonWriter.endObject();
                    }
                    jsonWriter.endObject();
                    if (!TextUtils.isEmpty(str3)) {
                        jsonWriter.name(Constant.LAUNCH_STAGE).value(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        jsonWriter.name(Constant.CRASH_STAGE).value(str4);
                    }
                }
                jsonWriter.name("pageTrace");
                jsonWriter.beginArray();
                createTraceUI(logObject.getProcessName(), jsonWriter);
                jsonWriter.endArray();
                jsonWriter.endObject();
            }
        } catch (IOException e3) {
            if (LLog.sDebug) {
                e3.printStackTrace();
            }
        }
    }

    public static void createTraceUI(@NonNull String str, @NonNull JsonWriter jsonWriter) {
        RandomAccessFile randomAccessFile;
        File file = new File(LogPipelineSingleton.obtainFileDirWithProcessName(str), SnapshotConstant.ProcessConstants.PROC_UI_TRACE);
        if (file.exists()) {
            int i = 0;
            RandomAccessFile randomAccessFile2 = null;
            r3 = null;
            r3 = null;
            RandomAccessFile randomAccessFile3 = null;
            RandomAccessFile randomAccessFile4 = null;
            try {
                try {
                    randomAccessFile = new RandomAccessFile(file, "r");
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
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
            } catch (IOException e2) {
                e = e2;
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
        if (file != null && file2 != null && file.exists() && file2.exists()) {
            byte[] bArr = new byte[1024];
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    file3 = new File(file2.getAbsolutePath() + ".tmp");
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
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
                            } catch (IOException e2) {
                                e = e2;
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
                    } catch (IOException e3) {
                        e = e3;
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
                    } catch (IOException e4) {
                        e = e4;
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
            } catch (IOException e5) {
                e = e5;
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
                    fileOutputStream2.write(new byte[]{117, 123});
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
                } catch (IOException e6) {
                    r6 = fileInputStream;
                    e = e6;
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
            } catch (IOException e7) {
                r6 = fileInputStream;
                e = e7;
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

    public static void createUBCContentInfo(@NonNull LogObject logObject, @Nullable List<LogFile> list, @NonNull String str, @NonNull File file) {
        JsonWriter jsonWriter;
        JsonWriter jsonWriter2 = null;
        try {
            try {
                jsonWriter = new JsonWriter(new FileWriter(file));
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            jsonWriter.beginObject();
            jsonWriter.name("data");
            jsonWriter.beginArray();
            jsonWriter.beginObject();
            jsonWriter.name("id").value(UBC_EVENT_ID);
            jsonWriter.name("timestamp").value(System.currentTimeMillis());
            jsonWriter.name(Constant.ID_TYPE).value("1");
            jsonWriter.name("type").value("0");
            jsonWriter.name(Constant.IS_REAL).value("1");
            createAperfInfo(logObject, str, jsonWriter);
            createCrashInfo(logObject, list, jsonWriter);
            jsonWriter.endObject();
            jsonWriter.endArray();
            jsonWriter.endObject();
            jsonWriter.flush();
            Closeables.closeSafely(jsonWriter);
        } catch (IOException e2) {
            e = e2;
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
