package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
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
/* loaded from: classes2.dex */
public class BitmapDescriptorFactory {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean a;
    public static final String b;
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
        a = !BitmapDescriptorFactory.class.desiredAssertionStatus();
        b = "BaiduMapSDK-" + BitmapDescriptorFactory.class.getSimpleName();
    }

    public BitmapDescriptorFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                if (!a && a2 == null) {
                    throw new AssertionError();
                }
                a2.recycle();
                return fromBitmap;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (BitmapDescriptor) invokeL.objValue;
    }

    public static BitmapDescriptor fromView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            try {
                view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                view2.layout(0, 0, view2.getMeasuredWidth(), view2.getMeasuredHeight());
                view2.buildDrawingCache();
                Bitmap drawingCache = view2.getDrawingCache();
                BitmapDescriptor fromBitmap = fromBitmap(drawingCache);
                if (drawingCache != null) {
                    drawingCache.recycle();
                }
                view2.destroyDrawingCache();
                return fromBitmap;
            } catch (Exception unused) {
                return null;
            }
        }
        return (BitmapDescriptor) invokeL.objValue;
    }

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
                    fromBitmap = fromBitmap(bitmap);
                } else if (densityDpi > 320) {
                    Matrix matrix2 = new Matrix();
                    matrix2.postScale(1.5f, 1.5f);
                    bitmap = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix2, true);
                    fromBitmap = fromBitmap(bitmap);
                } else {
                    fromBitmap = fromBitmap(a2);
                    bitmap = null;
                }
                a2.recycle();
                if (bitmap != null) {
                    bitmap.recycle();
                }
                return fromBitmap;
            } catch (Exception e) {
                e.printStackTrace();
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

    public static BitmapDescriptor fromResource(int i) {
        InterceptResult invokeI;
        Bitmap decodeResource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            Context context = BMapManager.getContext();
            if (context == null || (decodeResource = BitmapFactory.decodeResource(context.getResources(), i)) == null) {
                return null;
            }
            BitmapDescriptor fromBitmap = fromBitmap(decodeResource);
            decodeResource.recycle();
            return fromBitmap;
        }
        return (BitmapDescriptor) invokeI.objValue;
    }

    public static BitmapDescriptor fromFile(String str) {
        InterceptResult invokeL;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
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
            } catch (FileNotFoundException e) {
                Log.e(b, "FileNotFoundException happened", e);
            } catch (IOException e2) {
                Log.e(b, "IOException happened", e2);
            }
            return null;
        }
        return (BitmapDescriptor) invokeL.objValue;
    }

    public static BitmapDescriptor fromFileWithDpi(String str, int i) {
        InterceptResult invokeLI;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            if (str == null || str.equals("") || (context = BMapManager.getContext()) == null) {
                return null;
            }
            try {
                FileInputStream openFileInput = context.openFileInput(str);
                Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
                openFileInput.close();
                if (decodeStream != null) {
                    if (i <= 0) {
                        i = SysOSUtil.getDensityDpi();
                    }
                    decodeStream.setDensity(i);
                    BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
                    decodeStream.recycle();
                    return fromBitmap;
                }
            } catch (FileNotFoundException e) {
                Log.e(b, "FileNotFoundException happened", e);
            } catch (IOException e2) {
                Log.e(b, "IOException happened", e2);
            }
            return null;
        }
        return (BitmapDescriptor) invokeLI.objValue;
    }

    public static BitmapDescriptor fromViewWithDpi(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, view2, i)) == null) {
            if (view2 == null) {
                return null;
            }
            view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view2.layout(0, 0, view2.getMeasuredWidth(), view2.getMeasuredHeight());
            view2.buildDrawingCache();
            Bitmap drawingCache = view2.getDrawingCache();
            if (drawingCache == null) {
                Log.e(b, "Get bitmap failed");
                return null;
            }
            if (i <= 0) {
                i = SysOSUtil.getDensityDpi();
            }
            drawingCache.setDensity(i);
            BitmapDescriptor fromBitmap = fromBitmap(drawingCache);
            if (drawingCache != null) {
                drawingCache.recycle();
            }
            view2.destroyDrawingCache();
            return fromBitmap;
        }
        return (BitmapDescriptor) invokeLI.objValue;
    }

    public static BitmapDescriptor fromPathWithDpi(String str, int i) {
        InterceptResult invokeLI;
        Bitmap decodeFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, str, i)) == null) {
            if (TextUtils.isEmpty(str) || (decodeFile = BitmapFactory.decodeFile(str)) == null) {
                return null;
            }
            if (i <= 0) {
                i = SysOSUtil.getDensityDpi();
            }
            decodeFile.setDensity(i);
            BitmapDescriptor fromBitmap = fromBitmap(decodeFile);
            decodeFile.recycle();
            return fromBitmap;
        }
        return (BitmapDescriptor) invokeLI.objValue;
    }

    public static BitmapDescriptor fromResourceWithDpi(int i, int i2) {
        InterceptResult invokeII;
        Bitmap decodeResource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65546, null, i, i2)) == null) {
            Context context = BMapManager.getContext();
            if (context == null || (decodeResource = BitmapFactory.decodeResource(context.getResources(), i)) == null) {
                return null;
            }
            if (i2 <= 0) {
                i2 = SysOSUtil.getDensityDpi();
            }
            decodeResource.setDensity(i2);
            BitmapDescriptor fromBitmap = fromBitmap(decodeResource);
            decodeResource.recycle();
            return fromBitmap;
        }
        return (BitmapDescriptor) invokeII.objValue;
    }
}
