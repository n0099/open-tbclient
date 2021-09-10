package c.a.q0.f1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Paint f13081a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f13082b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f13083c;

    /* renamed from: d  reason: collision with root package name */
    public final View f13084d;

    /* renamed from: e  reason: collision with root package name */
    public int f13085e;

    /* renamed from: f  reason: collision with root package name */
    public int f13086f;

    /* renamed from: g  reason: collision with root package name */
    public int f13087g;

    /* renamed from: h  reason: collision with root package name */
    public int f13088h;

    /* renamed from: i  reason: collision with root package name */
    public int f13089i;

    /* renamed from: j  reason: collision with root package name */
    public int f13090j;
    public int k;
    public float l;
    public final Paint m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public float[] u;
    public int v;

    public c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13081a = new Paint();
        this.f13082b = new Paint();
        this.f13083c = new Paint();
        this.f13085e = 16;
        this.f13086f = 16;
        this.f13087g = -1;
        this.f13088h = 1711276032;
        this.f13089i = 20;
        this.f13090j = 20;
        this.k = 36;
        this.l = 0.0f;
        this.m = new Paint();
        this.n = 3;
        this.o = R.color.CAM_X0101;
        this.p = R.color.CAM_X0305;
        this.q = 20;
        this.r = 20;
        this.s = 36;
        this.t = 0;
        this.v = 0;
        this.f13084d = view;
        int color = c().getResources().getColor(R.color.black_alpha40);
        this.f13088h = color;
        this.f13082b.setColor(color);
        this.f13082b.setAntiAlias(true);
        this.f13089i = (int) c().getResources().getDimension(R.dimen.tbfontsize26);
        int color2 = c().getResources().getColor(R.color.CAM_X0101);
        this.f13087g = color2;
        this.f13081a.setColor(color2);
        this.f13081a.setTextSize(this.f13089i);
        this.f13081a.setAntiAlias(true);
        this.f13081a.setTypeface(c.a.q0.s.u.a.J(c.a.q0.s.u.a.G(R.string.F_X02)));
        this.f13085e = l.g(c(), R.dimen.tbds16);
        this.f13086f = l.g(c(), R.dimen.tbds16);
        this.f13090j = l.g(c(), R.dimen.tbds22);
        this.k = l.g(c(), R.dimen.tbds40);
        this.l = c.a.q0.s.u.a.A(R.string.J_X01)[0];
        int dimension = (int) c().getResources().getDimension(R.dimen.tbfontsize26);
        this.q = dimension;
        this.f13083c.setTextSize(dimension);
        this.f13081a.setAntiAlias(true);
        this.m.setAntiAlias(true);
        this.r = l.g(c(), R.dimen.tbds16);
        this.s = l.g(c(), R.dimen.tbds22);
        this.t = l.g(c(), R.dimen.tbds5);
        this.v = l.g(c(), R.dimen.M_W_X006);
        l.g(c(), R.dimen.M_H_X004);
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(Canvas canvas, String str, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, canvas, str, z) == null) || canvas == null || this.f13084d == null || TextUtils.isEmpty(str)) {
            return;
        }
        int save = canvas.save();
        this.f13084d.getPaddingLeft();
        int paddingRight = this.f13084d.getPaddingRight();
        this.f13084d.getPaddingTop();
        int paddingBottom = this.f13084d.getPaddingBottom();
        int left = this.f13084d.getLeft();
        int right = this.f13084d.getRight();
        int top = this.f13084d.getTop();
        int bottom = this.f13084d.getBottom();
        float measureText = this.f13081a.measureText(str);
        Paint.FontMetrics fontMetrics = this.f13081a.getFontMetrics();
        if (z) {
            if (this.u == null) {
                this.u = c.a.q0.s.u.a.D(R.array.S_O_X001);
            }
            float[] fArr = this.u;
            if (fArr == null || fArr.length < 4) {
                i2 = save;
            } else {
                i2 = save;
                this.f13081a.setShadowLayer(fArr[1], fArr[2], fArr[3], (int) fArr[0]);
            }
            int i3 = this.v;
            canvas.drawText(str, (((right - left) - paddingRight) - i3) - measureText, (((bottom - top) - paddingBottom) - i3) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.f13081a);
        } else {
            i2 = save;
            float f2 = this.k + measureText;
            float f3 = this.f13089i + this.f13090j;
            canvas.translate((((right - left) - paddingRight) - f2) - this.f13086f, (((bottom - top) - paddingBottom) - f3) - this.f13085e);
            RectF rectF = new RectF(0.0f, 0.0f, f2, f3);
            float f4 = this.l;
            if (f4 < 1.0f) {
                this.l = f4 * f3;
            }
            float f5 = this.l;
            canvas.drawRoundRect(rectF, f5, f5, this.f13082b);
            this.f13081a.clearShadowLayer();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.f13081a);
        }
        int i4 = i2;
        if (i4 < 1 || i4 > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(i4);
    }

    public void b(Canvas canvas, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, str, i2) == null) || canvas == null || this.f13084d == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (i2 != 0) {
            this.p = i2;
            this.m.setColor(SkinManager.getColor(i2));
        }
        int save = canvas.save();
        int paddingLeft = this.f13084d.getPaddingLeft();
        this.f13084d.getPaddingRight();
        int paddingTop = this.f13084d.getPaddingTop();
        this.f13084d.getPaddingBottom();
        float measureText = this.f13083c.measureText(str);
        canvas.translate(paddingLeft, paddingTop);
        RectF rectF = new RectF(0.0f, 0.0f, this.s + measureText, this.q + this.r);
        int i3 = this.t;
        canvas.drawRoundRect(rectF, i3, i3, this.m);
        Paint.FontMetrics fontMetrics = this.f13083c.getFontMetrics();
        canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.f13083c);
        if (save < 1 || save > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(save);
    }

    public final Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View view = this.f13084d;
            if (view != null && view.getContext() != null) {
                return this.f13084d.getContext();
            }
            return TbadkCoreApplication.getInst().getContext();
        }
        return (Context) invokeV.objValue;
    }

    public float d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? l.E(this.f13081a, str).height() + this.f13090j : invokeL.floatValue;
    }

    public float e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? l.F(this.f13081a, str) + this.k : invokeL.floatValue;
    }

    public final void f() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (view = this.f13084d) == null) {
            return;
        }
        view.invalidate();
    }

    public void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            this.f13086f = i2;
            this.f13085e = i3;
            f();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f13087g = i2;
            this.f13081a.setColor(i2);
            f();
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f13089i = i2;
            this.f13081a.setTextSize(i2);
            f();
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.n == i2) {
            return;
        }
        this.n = i2;
        this.f13083c.setColor(SkinManager.getColor(i2, this.o));
        this.m.setColor(SkinManager.getColor(i2, this.p));
    }
}
