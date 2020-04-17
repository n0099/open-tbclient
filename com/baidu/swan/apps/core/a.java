package com.baidu.swan.apps.core;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v7.appcompat.R;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.a;
import com.baidu.swan.d.c;
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
import tv.chushou.basis.http.HttpConsts;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean PK() {
        return com.baidu.swan.apps.w.a.aca().PK();
    }

    public static void e(File file, File file2) throws IOException {
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        try {
            FileChannel channel = new FileInputStream(file).getChannel();
            try {
                FileChannel channel2 = new FileOutputStream(file2).getChannel();
                try {
                    channel2.transferFrom(channel, 0L, channel.size());
                    c.closeSafely(channel);
                    c.closeSafely(channel2);
                } catch (Throwable th) {
                    fileChannel2 = channel;
                    fileChannel = channel2;
                    th = th;
                    c.closeSafely(fileChannel2);
                    c.closeSafely(fileChannel);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileChannel2 = channel;
                fileChannel = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
        }
    }

    public static void hY(String str) {
        b(str, null, null, true);
    }

    public static void q(String str, String str2, String str3) {
        b(str, str2, str3, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [152=5, 153=4, 154=4] */
    private static void b(String str, String str2, String str3, boolean z) {
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader2;
        FileInputStream fileInputStream2;
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(str);
            String absolutePath = file.getParentFile().getAbsolutePath();
            String name = file.getName();
            File file2 = new File(absolutePath + File.separator + name + ".tmp");
            File file3 = new File(absolutePath + File.separator + name + HttpConsts.FILE_BACKUP_SUFFIX);
            if (z) {
                if (file3.exists()) {
                    file3.renameTo(file);
                }
                c.closeSafely(null);
                c.closeSafely(null);
                c.closeSafely(null);
                return;
            }
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                try {
                    if (file3.exists()) {
                        e(file3, file);
                    } else {
                        e(file, file3);
                    }
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
                    boolean z2 = false;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.contains(str2)) {
                                bufferedWriter2.write(str3 + "\n");
                                z2 = true;
                            }
                            bufferedWriter2.write(readLine + "\n");
                        } catch (Exception e) {
                            e = e;
                            bufferedWriter = bufferedWriter2;
                            bufferedReader2 = bufferedReader;
                            fileInputStream2 = fileInputStream;
                            try {
                                e.printStackTrace();
                                c.closeSafely(bufferedReader2);
                                c.closeSafely(fileInputStream2);
                                c.closeSafely(bufferedWriter);
                                return;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                bufferedReader = bufferedReader2;
                                c.closeSafely(bufferedReader);
                                c.closeSafely(fileInputStream);
                                c.closeSafely(bufferedWriter);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedWriter = bufferedWriter2;
                            c.closeSafely(bufferedReader);
                            c.closeSafely(fileInputStream);
                            c.closeSafely(bufferedWriter);
                            throw th;
                        }
                    }
                    bufferedWriter2.flush();
                    if (z2) {
                        file2.renameTo(file);
                    } else {
                        file2.delete();
                    }
                    c.closeSafely(bufferedReader);
                    c.closeSafely(fileInputStream);
                    c.closeSafely(bufferedWriter2);
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader2 = bufferedReader;
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedReader2 = null;
                fileInputStream2 = fileInputStream;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader2 = null;
            fileInputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            fileInputStream = null;
        }
    }

    public static void bG(@NonNull Context context) {
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.View, Resources.getSystem().getIdentifier("webViewStyle", "attr", "android"), 0);
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
        new a.C0327a(10006).mR(jSONObject2).mQ(e.akP()).aee();
    }

    public static void r(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
            jSONObject.put("package", AppRuntime.getApplication().getPackageName());
            jSONObject.put("processName", ProcessUtils.getCurProcessName());
            jSONObject.put("appId", str2);
            jSONObject.put("errMessage", str3);
            jSONObject.put("isMainThread", ai.isOnUiThread());
            String jSONObject2 = jSONObject.toString();
            if (DEBUG && TextUtils.isEmpty(jSONObject2)) {
                Log.d("SwanAppCoreUtils", "reportInsertHistoryCrash: empty");
                return;
            }
            if (DEBUG) {
                Log.d("SwanAppCoreUtils", "reportInsertHistoryCrash: " + jSONObject2);
            }
            new a.C0327a(10008).mR(jSONObject2).mQ(e.akP()).aee();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
