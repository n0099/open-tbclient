package com.baidu.fsg.face.base.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Environment;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f39625a = 480;

    /* renamed from: b  reason: collision with root package name */
    public static final int f39626b = 480;

    /* renamed from: c  reason: collision with root package name */
    public static final int f39627c = 192;

    /* renamed from: d  reason: collision with root package name */
    public static final int f39628d = 728;

    /* renamed from: e  reason: collision with root package name */
    public static final int f39629e = 750;

    /* renamed from: f  reason: collision with root package name */
    public static final int f39630f = 1335;

    /* renamed from: g  reason: collision with root package name */
    public static final String f39631g = "LivenessFaceUtil";
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(int[] iArr, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, iArr, bitmap) == null) {
            Canvas canvas = new Canvas(bitmap);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            Paint paint = new Paint();
            paint.setStrokeWidth(4.0f);
            paint.setColor(-16711936);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(3.0f);
            paint.setColor(-16711936);
            for (int i2 = 0; i2 < iArr.length / 2; i2++) {
                int i3 = i2 << 1;
                canvas.drawCircle(iArr[i3], iArr[i3 + 1], 2.0f, paint);
            }
            Rect a2 = a(iArr);
            canvas.drawRect(a2, paint);
            Point point = new Point();
            point.set(a2.centerX(), a2.centerY());
            paint.setColor(SupportMenu.CATEGORY_MASK);
            canvas.drawCircle(point.x, point.y, 5.0f, paint);
            bitmap.getWidth();
            bitmap.getHeight();
            Point point2 = new Point();
            point2.set(bitmap.getWidth() / 2, (bitmap.getHeight() * 728) / 1335);
            paint.setColor(SupportMenu.CATEGORY_MASK);
            canvas.drawCircle(point2.x, point2.y, 5.0f, paint);
            int width = ((bitmap.getWidth() * 480) / 750) / 2;
            int i4 = point2.x;
            int i5 = point2.y;
            canvas.drawRect(i4 - width, i5 - width, i4 + width, i5 + width, paint);
            int width2 = ((bitmap.getWidth() * 192) / 750) / 2;
            int i6 = point2.x;
            int i7 = point2.y;
            canvas.drawRect(i6 - width2, i7 - width2, i6 + width2, i7 + width2, paint);
        }
    }

    public static boolean b(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bVar)) == null) ? (bVar == null || bVar.f39618a == null || bVar.f39619b == null) ? false : true : invokeL.booleanValue;
    }

    public static boolean c(int[] iArr, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, iArr, bVar)) == null) {
            if (bVar != null) {
                return a(iArr).width() < ((int) (((float) a(bVar).width()) / 4.0f));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(int[] iArr, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, iArr, bVar)) == null) {
            if (b(bVar)) {
                return a(iArr).width() > ((int) (((float) (a(bVar).width() * 3)) / 5.0f));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(int[] iArr, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, iArr, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            return a(bVar).contains(a(iArr));
        }
        return invokeLL.booleanValue;
    }

    public static Rect a(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            Rect rect = new Rect();
            if (b(bVar)) {
                int i2 = bVar.f39618a.left;
                Rect rect2 = bVar.f39619b;
                int i3 = rect2.left;
                if (i2 - i3 < 0) {
                    rect.left = 0;
                } else {
                    rect.left = (int) (((i2 - i3) / rect2.width()) * bVar.f39621d);
                }
                int i4 = bVar.f39618a.top;
                Rect rect3 = bVar.f39619b;
                int i5 = rect3.top;
                if (i4 > i5) {
                    rect.top = 0;
                } else {
                    rect.top = (int) (((i5 - i4) / rect3.height()) * bVar.f39620c);
                }
                int i6 = bVar.f39618a.right;
                Rect rect4 = bVar.f39619b;
                int i7 = rect4.right;
                if (i6 > i7) {
                    rect.right = bVar.f39621d;
                } else {
                    rect.right = bVar.f39621d - ((int) (((i7 - i6) / rect4.width()) * bVar.f39621d));
                }
                int i8 = bVar.f39618a.bottom;
                Rect rect5 = bVar.f39619b;
                int i9 = rect5.bottom;
                if (i8 > i9) {
                    rect.bottom = bVar.f39620c;
                } else {
                    rect.bottom = bVar.f39620c - ((int) (((i9 - i8) / rect5.height()) * bVar.f39620c));
                }
                return rect;
            }
            return rect;
        }
        return (Rect) invokeL.objValue;
    }

    public static Rect a(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iArr)) == null) {
            Point point = new Point();
            Point point2 = new Point();
            if (iArr.length > 2) {
                point.x = iArr[0];
                point.y = iArr[1];
                point2.x = iArr[0];
                point2.y = iArr[1];
            }
            for (int i2 = 0; i2 < iArr.length / 2; i2++) {
                int i3 = i2 << 1;
                float f2 = iArr[i3];
                float f3 = iArr[i3 + 1];
                if (f2 < point.x) {
                    point.x = (int) f2;
                }
                if (f3 < point.y) {
                    point.y = (int) f3;
                }
                if (f2 > point2.x) {
                    point2.x = (int) f2;
                }
                if (f3 > point2.y) {
                    point2.y = (int) f3;
                }
            }
            return new Rect(point.x, point.y, point2.x, point2.y);
        }
        return (Rect) invokeL.objValue;
    }

    public static void a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bitmap) == null) {
            try {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory.getAbsolutePath() + "/awe");
                file.mkdirs();
                File file2 = new File(file, String.format("%d.jpg", Long.valueOf(System.currentTimeMillis())));
                if (file2.exists()) {
                    file2.delete();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }
}
