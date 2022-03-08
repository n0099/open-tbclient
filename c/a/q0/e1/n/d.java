package c.a.q0.e1.n;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d extends BitmapDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public Context f12439b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f12440c;

    /* renamed from: d  reason: collision with root package name */
    public String f12441d;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f12442e;

    /* renamed from: f  reason: collision with root package name */
    public int f12443f;

    /* renamed from: g  reason: collision with root package name */
    public int f12444g;

    /* renamed from: h  reason: collision with root package name */
    public float f12445h;

    /* renamed from: i  reason: collision with root package name */
    public float f12446i;

    public d(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f12439b = null;
        this.f12440c = null;
        this.f12441d = null;
        this.f12442e = null;
        this.f12443f = 0;
        this.f12444g = 0;
        this.f12445h = 0.9f;
        this.f12446i = 0.75f;
        this.f12439b = context;
        this.a = i2;
        this.f12441d = String.valueOf(i2);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || this.a <= 0 || this.f12439b == null) {
            return;
        }
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        c.a.q0.b0.c k = c.a.q0.b0.c.k();
        c.a.d.o.d.a m = (k == null || (str2 = this.f12441d) == null) ? null : k.m(str2);
        if (m == null) {
            Bitmap resBitmap = BitmapHelper.getResBitmap(this.f12439b, this.a);
            if (resBitmap != null) {
                m = new c.a.d.o.d.a(resBitmap, false, (String) null);
            }
            if (k != null && m != null && (str = this.f12441d) != null) {
                k.d(str, m);
            }
        }
        if (m != null) {
            int r = m.r();
            int m2 = m.m();
            if (r <= 0 || m2 <= 0 || this.f12440c == null) {
                return;
            }
            canvas.save();
            canvas.clipRect(super.getBounds());
            if (m2 <= 0 && r <= 0 && this.f12443f == 0 && this.f12444g == 0) {
                m.e(canvas, 0.0f, 0.0f, null);
            } else {
                if (this.f12442e == null) {
                    Matrix matrix = new Matrix();
                    this.f12442e = matrix;
                    matrix.postTranslate(this.f12443f, this.f12444g);
                    Rect rect = this.f12440c;
                    float f2 = (rect.right - rect.left) / r;
                    float f3 = (rect.bottom - rect.top) / m2;
                    if (f2 >= f3) {
                        f2 = f3;
                    }
                    if (f2 < 1.0f) {
                        this.f12442e.postScale(f2, f2);
                    }
                }
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    float f4 = this.f12446i;
                    colorMatrix.setScale(f4, f4, f4, 1.0f);
                    paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    m.f(canvas, this.f12442e, paint);
                } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    float f5 = this.f12445h;
                    colorMatrix.setScale(f5, f5, f5, 1.0f);
                    paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    m.f(canvas, this.f12442e, paint);
                } else {
                    m.f(canvas, this.f12442e, null);
                }
            }
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            this.f12440c = new Rect(i2, i3, i4, i5);
            this.f12442e = null;
            super.setBounds(i2, i3, i4, i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rect) == null) {
            this.f12440c = new Rect(rect);
            this.f12442e = null;
            super.setBounds(rect);
        }
    }
}
