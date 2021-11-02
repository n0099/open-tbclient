package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes7.dex */
public class BitmapDescriptorFactory {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f39306a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f39307b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-734635675, "Lcom/baidu/mapapi/map/BitmapDescriptorFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-734635675, "Lcom/baidu/mapapi/map/BitmapDescriptorFactory;");
                return;
            }
        }
        f39306a = !BitmapDescriptorFactory.class.desiredAssertionStatus();
        f39307b = "BaiduMapSDK-" + BitmapDescriptorFactory.class.getSimpleName();
    }

    public BitmapDescriptorFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Context context = BMapManager.getContext();
            if (context == null) {
                return null;
            }
            try {
                Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, context);
                BitmapDescriptor fromBitmap = fromBitmap(a2);
                if (!f39306a && a2 == null) {
                    throw new AssertionError();
                }
                a2.recycle();
                return fromBitmap;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (BitmapDescriptor) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0063 A[Catch: Exception -> 0x0067, TRY_LEAVE, TryCatch #0 {Exception -> 0x0067, blocks: (B:7:0x000c, B:10:0x0013, B:12:0x001b, B:13:0x0035, B:18:0x005e, B:20:0x0063, B:16:0x003e, B:17:0x0059), top: B:29:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BitmapDescriptor fromAssetWithDpi(String str) {
        InterceptResult invokeL;
        BitmapDescriptor fromBitmap;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            Context context = BMapManager.getContext();
            if (context == null) {
                return null;
            }
            try {
                Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, context);
                if (a2 == null) {
                    return null;
                }
                int densityDpi = SysOSUtil.getDensityDpi();
                if (densityDpi > 480) {
                    Matrix matrix = new Matrix();
                    matrix.postScale(2.0f, 2.0f);
                    bitmap = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
                } else if (densityDpi <= 320) {
                    fromBitmap = fromBitmap(a2);
                    bitmap = null;
                    a2.recycle();
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    return fromBitmap;
                } else {
                    Matrix matrix2 = new Matrix();
                    matrix2.postScale(1.5f, 1.5f);
                    bitmap = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix2, true);
                }
                fromBitmap = fromBitmap(bitmap);
                a2.recycle();
                if (bitmap != null) {
                }
                return fromBitmap;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (BitmapDescriptor) invokeL.objValue;
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bitmap)) == null) {
            if (bitmap == null) {
                return null;
            }
            return new BitmapDescriptor(bitmap);
        }
        return (BitmapDescriptor) invokeL.objValue;
    }

    public static BitmapDescriptor fromFile(String str) {
        InterceptResult invokeL;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (str == null || str.equals("") || (context = BMapManager.getContext()) == null) {
                return null;
            }
            try {
                FileInputStream openFileInput = context.openFileInput(str);
                Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
                openFileInput.close();
                if (decodeStream != null) {
                    BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
                    decodeStream.recycle();
                    return fromBitmap;
                }
            } catch (FileNotFoundException | IOException unused) {
            }
            return null;
        }
        return (BitmapDescriptor) invokeL.objValue;
    }

    public static BitmapDescriptor fromFileWithDpi(String str, int i2) {
        InterceptResult invokeLI;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, str, i2)) == null) {
            if (str == null || str.equals("") || (context = BMapManager.getContext()) == null) {
                return null;
            }
            try {
                FileInputStream openFileInput = context.openFileInput(str);
                Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
                openFileInput.close();
                if (decodeStream != null) {
                    if (i2 <= 0) {
                        i2 = SysOSUtil.getDensityDpi();
                    }
                    decodeStream.setDensity(i2);
                    BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
                    decodeStream.recycle();
                    return fromBitmap;
                }
            } catch (FileNotFoundException | IOException unused) {
            }
            return null;
        }
        return (BitmapDescriptor) invokeLI.objValue;
    }

    public static BitmapDescriptor fromPath(String str) {
        InterceptResult invokeL;
        Bitmap decodeFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str) || (decodeFile = BitmapFactory.decodeFile(str)) == null) {
                return null;
            }
            BitmapDescriptor fromBitmap = fromBitmap(decodeFile);
            decodeFile.recycle();
            return fromBitmap;
        }
        return (BitmapDescriptor) invokeL.objValue;
    }

    public static BitmapDescriptor fromPathWithDpi(String str, int i2) {
        InterceptResult invokeLI;
        Bitmap decodeFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, str, i2)) == null) {
            if (TextUtils.isEmpty(str) || (decodeFile = BitmapFactory.decodeFile(str)) == null) {
                return null;
            }
            if (i2 <= 0) {
                i2 = SysOSUtil.getDensityDpi();
            }
            decodeFile.setDensity(i2);
            BitmapDescriptor fromBitmap = fromBitmap(decodeFile);
            decodeFile.recycle();
            return fromBitmap;
        }
        return (BitmapDescriptor) invokeLI.objValue;
    }

    public static BitmapDescriptor fromResource(int i2) {
        InterceptResult invokeI;
        Bitmap decodeResource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) {
            Context context = BMapManager.getContext();
            if (context == null || (decodeResource = BitmapFactory.decodeResource(context.getResources(), i2)) == null) {
                return null;
            }
            BitmapDescriptor fromBitmap = fromBitmap(decodeResource);
            decodeResource.recycle();
            return fromBitmap;
        }
        return (BitmapDescriptor) invokeI.objValue;
    }

    public static BitmapDescriptor fromResourceWithDpi(int i2, int i3) {
        InterceptResult invokeII;
        Bitmap decodeResource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65546, null, i2, i3)) == null) {
            Context context = BMapManager.getContext();
            if (context == null || (decodeResource = BitmapFactory.decodeResource(context.getResources(), i2)) == null) {
                return null;
            }
            if (i3 <= 0) {
                i3 = SysOSUtil.getDensityDpi();
            }
            decodeResource.setDensity(i3);
            BitmapDescriptor fromBitmap = fromBitmap(decodeResource);
            decodeResource.recycle();
            return fromBitmap;
        }
        return (BitmapDescriptor) invokeII.objValue;
    }

    public static BitmapDescriptor fromView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, view)) == null) {
            if (view == null) {
                return null;
            }
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache = view.getDrawingCache();
            BitmapDescriptor fromBitmap = fromBitmap(drawingCache);
            if (drawingCache != null) {
                drawingCache.recycle();
            }
            view.destroyDrawingCache();
            return fromBitmap;
        }
        return (BitmapDescriptor) invokeL.objValue;
    }

    public static BitmapDescriptor fromViewWithDpi(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, view, i2)) == null) {
            if (view == null) {
                return null;
            }
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache == null) {
                return null;
            }
            if (i2 <= 0) {
                i2 = SysOSUtil.getDensityDpi();
            }
            drawingCache.setDensity(i2);
            BitmapDescriptor fromBitmap = fromBitmap(drawingCache);
            if (drawingCache != null) {
                drawingCache.recycle();
            }
            view.destroyDrawingCache();
            return fromBitmap;
        }
        return (BitmapDescriptor) invokeLI.objValue;
    }
}
