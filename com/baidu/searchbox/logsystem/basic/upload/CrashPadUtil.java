package com.baidu.searchbox.logsystem.basic.upload;

import android.text.TextUtils;
import android.util.Base64;
import android.util.JsonWriter;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.logsystem.util.DebugUtil;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.searchbox.logsystem.util.Utility;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class CrashPadUtil {
    public static final boolean DEBUG = LLog.sDebug;
    public static final int MAX_READ_BDMP = 102400;
    public static final int MAX_READ_EXTRA = 20480;
    public static final String TAG = "CrashPadUtil";

    public static void createJsonExtraInfo(@NonNull File file, @NonNull JsonWriter jsonWriter) {
        if (file != null && file.exists() && jsonWriter != null) {
            try {
                Pair<String, Boolean> readFile = Utility.readFile(file, 20480);
                if (readFile != null && !TextUtils.isEmpty((CharSequence) readFile.first)) {
                    if (DEBUG) {
                        DebugUtil.saveLog("json-extra : " + ((String) readFile.first));
                        Log.d(TAG, "json-extra.size = " + ((String) readFile.first).length());
                    }
                    jsonWriter.name(Constant.CRASH_ENVIR).value((String) readFile.first);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createMiniBDMPInfo(@NonNull File file, @NonNull JsonWriter jsonWriter) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (file != null && jsonWriter != null && file.exists()) {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        int round = Math.round(76800.0f);
                        int i = 0;
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1 || i >= round) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                            i += read;
                        }
                        byteArrayOutputStream.flush();
                        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 11);
                        if (DEBUG) {
                            DebugUtil.saveLog("mini-bdmp : " + encodeToString);
                        }
                        jsonWriter.name(Constant.STACKTRACE_BDMP).value(encodeToString);
                        Closeables.closeSafely(fileInputStream2);
                    } catch (Exception e) {
                        e = e;
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
                } catch (Exception e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
            }
            Closeables.closeSafely(byteArrayOutputStream);
        }
    }
}
