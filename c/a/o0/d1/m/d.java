package c.a.o0.d1.m;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d extends BitmapDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12936a;

    /* renamed from: b  reason: collision with root package name */
    public Context f12937b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f12938c;

    /* renamed from: d  reason: collision with root package name */
    public String f12939d;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f12940e;

    /* renamed from: f  reason: collision with root package name */
    public int f12941f;

    /* renamed from: g  reason: collision with root package name */
    public int f12942g;

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
        this.f12936a = 0;
        this.f12937b = null;
        this.f12938c = null;
        this.f12939d = null;
        this.f12940e = null;
        this.f12941f = 0;
        this.f12942g = 0;
        this.f12937b = context;
        this.f12936a = i2;
        this.f12939d = String.valueOf(i2);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || this.f12936a <= 0 || this.f12937b == null) {
            return;
        }
        c.a.o0.b0.c k = c.a.o0.b0.c.k();
        c.a.e.k.d.a m = (k == null || (str2 = this.f12939d) == null) ? null : k.m(str2);
        if (m == null) {
            Bitmap resBitmap = BitmapHelper.getResBitmap(this.f12937b, this.f12936a);
            if (resBitmap != null) {
                m = new c.a.e.k.d.a(resBitmap, false, (String) null);
            }
            if (k != null && m != null && (str = this.f12939d) != null) {
                k.d(str, m);
            }
        }
        if (m != null) {
            int r = m.r();
            int m2 = m.m();
            if (r <= 0 || m2 <= 0 || this.f12938c == null) {
                return;
            }
            canvas.save();
            canvas.clipRect(super.getBounds());
            if (m2 <= 0 && r <= 0 && this.f12941f == 0 && this.f12942g == 0) {
                m.e(canvas, 0.0f, 0.0f, null);
            } else {
                if (this.f12940e == null) {
                    Matrix matrix = new Matrix();
                    this.f12940e = matrix;
                    matrix.postTranslate(this.f12941f, this.f12942g);
                    Rect rect = this.f12938c;
                    float f2 = (rect.right - rect.left) / r;
                    float f3 = (rect.bottom - rect.top) / m2;
                    if (f2 >= f3) {
                        f2 = f3;
                    }
                    if (f2 < 1.0f) {
                        this.f12940e.postScale(f2, f2);
                    }
                }
                m.f(canvas, this.f12940e, null);
            }
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            this.f12938c = new Rect(i2, i3, i4, i5);
            this.f12940e = null;
            super.setBounds(i2, i3, i4, i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rect) == null) {
            this.f12938c = new Rect(rect);
            this.f12940e = null;
            super.setBounds(rect);
        }
    }
}
