package com.baidu.sofire.face.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.face.platform.utils.BitmapUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static File a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            File file = new File(str, ".records");
            if (!file.exists() && !file.mkdirs()) {
                return null;
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            return new File(file.getPath() + File.separator + "bdv_" + valueOf + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
        }
        return (File) invokeL.objValue;
    }

    public static void a(Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, camera) == null) && camera != null) {
            try {
                camera.release();
            } catch (Throwable unused) {
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                return activeNetworkInfo.isConnected();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Context context, byte[] bArr, File file) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, bArr, file)) == null) {
            if (context != null && bArr != null) {
                try {
                    if (bArr.length > 0) {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            fileOutputStream.write(bArr);
                            fileOutputStream.flush();
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                            return true;
                        } catch (Throwable unused2) {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                            return false;
                        }
                    }
                } catch (Throwable unused4) {
                    fileOutputStream = null;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(Context context, byte[] bArr, int i, int i2) {
        InterceptResult invokeLLII;
        RenderScript renderScript;
        ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGB;
        Allocation allocation;
        Allocation allocation2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, context, bArr, i, i2)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                renderScript = RenderScript.create(context);
                try {
                    scriptIntrinsicYuvToRGB = ScriptIntrinsicYuvToRGB.create(renderScript, Element.U8_4(renderScript));
                    try {
                        Type.Builder x = new Type.Builder(renderScript, Element.U8(renderScript)).setX(bArr.length);
                        Type.Builder y = new Type.Builder(renderScript, Element.RGBA_8888(renderScript)).setX(i).setY(i2);
                        allocation = Allocation.createTyped(renderScript, x.create(), 1);
                        try {
                            allocation2 = Allocation.createTyped(renderScript, y.create(), 1);
                            try {
                                allocation.copyFrom(bArr);
                                scriptIntrinsicYuvToRGB.setInput(allocation);
                                scriptIntrinsicYuvToRGB.forEach(allocation2);
                                Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                                allocation2.copyTo(createBitmap);
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                try {
                                    createBitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream2);
                                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                    if (renderScript != null) {
                                        try {
                                            renderScript.destroy();
                                        } catch (Throwable unused) {
                                        }
                                    }
                                    try {
                                        scriptIntrinsicYuvToRGB.destroy();
                                    } catch (Throwable unused2) {
                                    }
                                    try {
                                        allocation.destroy();
                                    } catch (Throwable unused3) {
                                    }
                                    try {
                                        allocation2.destroy();
                                    } catch (Throwable unused4) {
                                    }
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (Throwable unused5) {
                                    }
                                    return byteArray;
                                } catch (Throwable unused6) {
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    if (renderScript != null) {
                                        try {
                                            renderScript.destroy();
                                        } catch (Throwable unused7) {
                                        }
                                    }
                                    if (scriptIntrinsicYuvToRGB != null) {
                                        try {
                                            scriptIntrinsicYuvToRGB.destroy();
                                        } catch (Throwable unused8) {
                                        }
                                    }
                                    if (allocation != null) {
                                        try {
                                            allocation.destroy();
                                        } catch (Throwable unused9) {
                                        }
                                    }
                                    if (allocation2 != null) {
                                        try {
                                            allocation2.destroy();
                                        } catch (Throwable unused10) {
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Throwable unused11) {
                                        }
                                    }
                                    return new byte[0];
                                }
                            } catch (Throwable unused12) {
                            }
                        } catch (Throwable unused13) {
                            allocation2 = null;
                        }
                    } catch (Throwable unused14) {
                        allocation = null;
                        allocation2 = allocation;
                        if (renderScript != null) {
                        }
                        if (scriptIntrinsicYuvToRGB != null) {
                        }
                        if (allocation != null) {
                        }
                        if (allocation2 != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        return new byte[0];
                    }
                } catch (Throwable unused15) {
                    scriptIntrinsicYuvToRGB = null;
                    allocation = scriptIntrinsicYuvToRGB;
                    allocation2 = allocation;
                    if (renderScript != null) {
                    }
                    if (scriptIntrinsicYuvToRGB != null) {
                    }
                    if (allocation != null) {
                    }
                    if (allocation2 != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    return new byte[0];
                }
            } catch (Throwable unused16) {
                renderScript = null;
                scriptIntrinsicYuvToRGB = null;
            }
        } else {
            return (byte[]) invokeLLII.objValue;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.graphics.Bitmap, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r5v5 */
    public static byte[] a(Bitmap bitmap, int i, int i2) {
        ?? r5;
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, bitmap, i, i2)) == null) {
            try {
            } catch (Throwable unused) {
                r5 = 0;
            }
            try {
                if (bitmap.getWidth() > i && bitmap.getHeight() > i2) {
                    Bitmap scale = BitmapUtils.scale(bitmap, i, i2);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    scale.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    scale.recycle();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                    return byteArray;
                }
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream2);
                byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                try {
                    byteArrayOutputStream2.close();
                } catch (Throwable unused3) {
                }
                return byteArray2;
            } catch (Throwable unused4) {
                r5 = i;
                if (r5 != 0) {
                    try {
                        r5.close();
                    } catch (Throwable unused5) {
                    }
                }
                return new byte[0];
            }
        }
        return (byte[]) invokeLII.objValue;
    }

    public static byte[] a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, file)) == null) {
            BufferedInputStream bufferedInputStream = null;
            if (!file.exists()) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream2.read(bArr, 0, 1024);
                        if (-1 == read) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused2) {
                    }
                    return byteArray;
                } catch (Throwable unused3) {
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused5) {
                    }
                    return new byte[0];
                }
            } catch (Throwable unused6) {
            }
        } else {
            return (byte[]) invokeL.objValue;
        }
    }
}
