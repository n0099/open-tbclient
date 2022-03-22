package com.baidu.sofire.facesrc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
/* loaded from: classes4.dex */
public class BitmapUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BitmapUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] nv21ToBitmap(Context context, byte[] bArr, int i, int i2) {
        InterceptResult invokeLLII;
        ByteArrayOutputStream byteArrayOutputStream;
        ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGB;
        Allocation allocation;
        Allocation allocation2;
        RenderScript create;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLII = interceptable.invokeLLII(65537, null, context, bArr, i, i2)) != null) {
            return (byte[]) invokeLLII.objValue;
        }
        RenderScript renderScript = null;
        try {
            create = RenderScript.create(context);
            try {
                scriptIntrinsicYuvToRGB = ScriptIntrinsicYuvToRGB.create(create, Element.U8_4(create));
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
                scriptIntrinsicYuvToRGB = null;
                allocation = null;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
            scriptIntrinsicYuvToRGB = null;
            allocation = null;
            allocation2 = null;
        }
        try {
            Type.Builder x = new Type.Builder(create, Element.U8(create)).setX(bArr.length);
            Type.Builder y = new Type.Builder(create, Element.RGBA_8888(create)).setX(i).setY(i2);
            allocation = Allocation.createTyped(create, x.create(), 1);
            try {
                allocation2 = Allocation.createTyped(create, y.create(), 1);
                try {
                    allocation.copyFrom(bArr);
                    scriptIntrinsicYuvToRGB.setInput(allocation);
                    scriptIntrinsicYuvToRGB.forEach(allocation2);
                    Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    allocation2.copyTo(createBitmap);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        createBitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (create != null) {
                            try {
                                create.destroy();
                            } catch (Throwable th3) {
                                CommonMethods.handleNuLException(th3);
                            }
                        }
                        if (scriptIntrinsicYuvToRGB != null) {
                            try {
                                scriptIntrinsicYuvToRGB.destroy();
                            } catch (Throwable th4) {
                                CommonMethods.handleNuLException(th4);
                            }
                        }
                        if (allocation != null) {
                            try {
                                allocation.destroy();
                            } catch (Throwable th5) {
                                CommonMethods.handleNuLException(th5);
                            }
                        }
                        if (allocation2 != null) {
                            try {
                                allocation2.destroy();
                            } catch (Throwable th6) {
                                CommonMethods.handleNuLException(th6);
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th7) {
                            CommonMethods.handleNuLException(th7);
                        }
                        return byteArray;
                    } catch (Throwable th8) {
                        th = th8;
                        renderScript = create;
                        try {
                            CommonMethods.handleNuLException(th);
                            return new byte[0];
                        } finally {
                            if (renderScript != null) {
                                try {
                                    renderScript.destroy();
                                } catch (Throwable th9) {
                                    CommonMethods.handleNuLException(th9);
                                }
                            }
                            if (scriptIntrinsicYuvToRGB != null) {
                                try {
                                    scriptIntrinsicYuvToRGB.destroy();
                                } catch (Throwable th10) {
                                    CommonMethods.handleNuLException(th10);
                                }
                            }
                            if (allocation != null) {
                                try {
                                    allocation.destroy();
                                } catch (Throwable th11) {
                                    CommonMethods.handleNuLException(th11);
                                }
                            }
                            if (allocation2 != null) {
                                try {
                                    allocation2.destroy();
                                } catch (Throwable th12) {
                                    CommonMethods.handleNuLException(th12);
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Throwable th13) {
                                    CommonMethods.handleNuLException(th13);
                                }
                            }
                        }
                    }
                } catch (Throwable th14) {
                    th = th14;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th15) {
                th = th15;
                byteArrayOutputStream = null;
                allocation2 = null;
            }
        } catch (Throwable th16) {
            th = th16;
            byteArrayOutputStream = null;
            allocation = null;
            allocation2 = allocation;
            renderScript = create;
            CommonMethods.handleNuLException(th);
            return new byte[0];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] scale(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLII = interceptable.invokeLII(65538, null, bitmap, i, i2)) != null) {
            return (byte[]) invokeLII.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                if (bitmap.getWidth() > i && bitmap.getHeight() > i2) {
                    Bitmap scale = com.baidu.pass.face.platform.utils.BitmapUtils.scale(bitmap, i, i2);
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    scale.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    scale.recycle();
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Throwable th) {
                        CommonMethods.handleNuLException(th);
                    }
                    return byteArray;
                }
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream3);
                byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
                try {
                    byteArrayOutputStream3.close();
                } catch (Throwable th2) {
                    CommonMethods.handleNuLException(th2);
                }
                return byteArray2;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = i;
                try {
                    CommonMethods.handleNuLException(th);
                    return new byte[0];
                } finally {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th4) {
                            CommonMethods.handleNuLException(th4);
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
