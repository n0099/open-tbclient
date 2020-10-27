package com.baidu.swan.apps.ap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.opengl.GLES10;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.sapi2.utils.SapiUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
/* loaded from: classes10.dex */
public final class t {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static int[] aKd() {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        if (iArr[0] != 0) {
            return iArr;
        }
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        egl10.eglChooseConfig(eglGetDisplay, new int[]{12351, 12430, 12329, 0, 12339, 1, 12344}, eGLConfigArr, 1, new int[1]);
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLSurface eglCreatePbufferSurface = egl10.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, new int[]{12375, 64, 12374, 64, 12344});
        EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 1, 12344});
        egl10.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext);
        GLES10.glGetIntegerv(3379, iArr, 0);
        egl10.eglMakeCurrent(eglGetDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        egl10.eglDestroySurface(eglGetDisplay, eglCreatePbufferSurface);
        egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
        egl10.eglTerminate(eglGetDisplay);
        return iArr;
    }

    public static Uri getUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("http://") && !str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) && !str.startsWith("file://") && !str.startsWith("content://")) {
            if (str.startsWith("/")) {
                return Uri.fromFile(new File(str));
            }
            return null;
        }
        return Uri.parse(str);
    }

    public static File tZ(String str) {
        return cH(com.baidu.swan.apps.v.f.axo().awU().aIm(), str);
    }

    public static File cH(String str, String str2) {
        if (DEBUG) {
            Log.d("ImageUtils", "获取temp路径");
        }
        String str3 = "swan_tmp_" + System.currentTimeMillis() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2;
        File file = null;
        if (!TextUtils.isEmpty(str)) {
            File file2 = new File(str);
            if (file2.exists()) {
                file = new File(file2, str3);
            } else if (file2.mkdirs()) {
                file = new File(file2, str3);
            }
            if (file != null && !file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (DEBUG && file != null) {
            Log.e("ImageUtils", "temp路径:" + file.getAbsolutePath());
        }
        return file;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x0073 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
    public static boolean a(File file, File file2, int i) {
        ?? r2;
        FileOutputStream fileOutputStream;
        if (DEBUG) {
            r2 = "压缩图片";
            Log.d("ImageUtils", "压缩图片");
        }
        if (file2 == null) {
            if (DEBUG) {
                Log.e("ImageUtils", "dest file is null");
                return false;
            }
            return false;
        } else if (i < 0 || i > 100) {
            if (DEBUG) {
                Log.e("ImageUtils", "quality must be 0..100");
                return false;
            }
            return false;
        } else {
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
            if (decodeFile == null) {
                if (DEBUG) {
                    Log.e("ImageUtils", "compress image，but decode bitmap is null");
                    return false;
                }
                return false;
            }
            try {
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        decodeFile.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                        com.baidu.swan.c.d.closeSafely(fileOutputStream);
                        return true;
                    } catch (FileNotFoundException e) {
                        e = e;
                        if (DEBUG) {
                            Log.e("ImageUtils", "压缩图片失败", e);
                        }
                        com.baidu.swan.c.d.closeSafely(fileOutputStream);
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.d.closeSafely(r2);
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                r2 = 0;
                com.baidu.swan.c.d.closeSafely(r2);
                throw th;
            }
        }
    }
}
