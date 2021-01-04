package com.baidu.swan.apps.core;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.R;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.statistic.c;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.channels.FileChannel;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean akL() {
        return com.baidu.swan.apps.t.a.aAD().akL();
    }

    public static void g(File file, File file2) throws IOException {
        Throwable th;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        try {
            fileChannel2 = new FileInputStream(file).getChannel();
            try {
                FileChannel channel = new FileOutputStream(file2).getChannel();
                try {
                    channel.transferFrom(fileChannel2, 0L, fileChannel2.size());
                    com.baidu.swan.c.d.closeSafely(fileChannel2);
                    com.baidu.swan.c.d.closeSafely(channel);
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = channel;
                    com.baidu.swan.c.d.closeSafely(fileChannel2);
                    com.baidu.swan.c.d.closeSafely(fileChannel);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileChannel = null;
            fileChannel2 = null;
        }
    }

    public static void mZ(String str) {
        d(str, null, null, true);
    }

    public static void M(String str, String str2, String str3) {
        d(str, str2, str3, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [152=5, 153=4, 154=4] */
    private static void d(String str, String str2, String str3, boolean z) {
        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        try {
            File file = new File(str);
            String absolutePath = file.getParentFile().getAbsolutePath();
            String name = file.getName();
            File file2 = new File(absolutePath + File.separator + name + ".tmp");
            File file3 = new File(absolutePath + File.separator + name + ".bak");
            if (z) {
                if (file3.exists()) {
                    file3.renameTo(file);
                }
                com.baidu.swan.c.d.closeSafely(null);
                com.baidu.swan.c.d.closeSafely(null);
                com.baidu.swan.c.d.closeSafely(null);
                return;
            }
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                try {
                    if (file3.exists()) {
                        g(file3, file);
                    } else {
                        g(file, file3);
                    }
                    bufferedWriter = new BufferedWriter(new FileWriter(file2));
                    boolean z2 = false;
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (readLine.contains(str2)) {
                                    bufferedWriter.write(str3 + "\n");
                                    z2 = true;
                                }
                                bufferedWriter.write(readLine + "\n");
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                com.baidu.swan.c.d.closeSafely(bufferedReader);
                                com.baidu.swan.c.d.closeSafely(fileInputStream);
                                com.baidu.swan.c.d.closeSafely(bufferedWriter);
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            com.baidu.swan.c.d.closeSafely(bufferedReader);
                            com.baidu.swan.c.d.closeSafely(fileInputStream);
                            com.baidu.swan.c.d.closeSafely(bufferedWriter);
                            throw th;
                        }
                    }
                    bufferedWriter.flush();
                    if (z2) {
                        file2.renameTo(file);
                    } else {
                        file2.delete();
                    }
                    com.baidu.swan.c.d.closeSafely(bufferedReader);
                    com.baidu.swan.c.d.closeSafely(fileInputStream);
                    com.baidu.swan.c.d.closeSafely(bufferedWriter);
                } catch (Exception e2) {
                    e = e2;
                    bufferedWriter = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = null;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedWriter = null;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = null;
                bufferedReader = null;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedWriter = null;
            bufferedReader = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedWriter = null;
            bufferedReader = null;
            fileInputStream = null;
        }
    }

    public static void cI(@NonNull Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            Class<?> cls = Class.forName("android.content.res.AssetManager");
            Field declaredField = cls.getDeclaredField("mStringBlocks");
            declaredField.setAccessible(true);
            Object[] objArr = (Object[]) declaredField.get(context.getAssets());
            if (objArr == null) {
                jSONObject.put("stringBlocks", "null");
            } else {
                jSONObject.put("stringBlocks size", objArr.length);
                for (int i = 0; i < objArr.length; i++) {
                    jSONObject.put("stringBlocks " + i, " == null :" + (objArr[i] == null));
                }
            }
            Field declaredField2 = cls.getDeclaredField("sSystem");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(cls);
            Field declaredField3 = cls.getDeclaredField("mStringBlocks");
            declaredField3.setAccessible(true);
            Object[] objArr2 = (Object[]) declaredField3.get(obj);
            if (objArr2 == null) {
                jSONObject.put("stringBlocksSys", "null");
            } else {
                jSONObject.put("stringBlocksSys size", objArr2.length);
                for (int i2 = 0; i2 < objArr2.length; i2++) {
                    jSONObject.put("stringBlocksSys " + i2, " == null :" + (objArr2[i2] == null));
                }
            }
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.View, Resources.getSystem().getIdentifier("webViewStyle", "attr", HttpConstants.OS_TYPE_VALUE), 0);
            if (obtainStyledAttributes == null) {
                jSONObject.put("TypedArray", "null");
            } else {
                jSONObject.put("TypedArray ", obtainStyledAttributes.toString());
                jSONObject.put("TypedArray mLength", obtainStyledAttributes.length());
                Field declaredField4 = obtainStyledAttributes.getClass().getDeclaredField("mRecycled");
                declaredField4.setAccessible(true);
                jSONObject.put("TypedArray mRecycled", declaredField4.get(obtainStyledAttributes));
                Field declaredField5 = obtainStyledAttributes.getClass().getDeclaredField("mAssets");
                declaredField5.setAccessible(true);
                jSONObject.put("TypedArray mAssets", declaredField5.get(obtainStyledAttributes) == context.getAssets());
                obtainStyledAttributes.recycle();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            if (DEBUG) {
                Log.d("SwanAppCoreUtils", "reportFatalInfo: empty");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppCoreUtils", "reportFatalInfo: " + jSONObject2);
        }
        new c.a(10006).tw(jSONObject2).tv(com.baidu.swan.apps.runtime.e.aMm()).axJ();
    }

    public static void N(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
            jSONObject.put("package", AppRuntime.getApplication().getPackageName());
            jSONObject.put(Constant.KEY_PROCESS_NAME, ProcessUtils.getCurProcessName());
            jSONObject.put("appId", str2);
            jSONObject.put("errMessage", str3);
            jSONObject.put("isMainThread", ak.aRS());
            String jSONObject2 = jSONObject.toString();
            if (DEBUG && TextUtils.isEmpty(jSONObject2)) {
                Log.d("SwanAppCoreUtils", "reportInsertHistoryCrash: empty");
                return;
            }
            if (DEBUG) {
                Log.d("SwanAppCoreUtils", "reportInsertHistoryCrash: " + jSONObject2);
            }
            new c.a(10008).tw(jSONObject2).tv(com.baidu.swan.apps.runtime.e.aMm()).axJ();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
