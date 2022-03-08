package c.a.q0.e1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Paint a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f12293b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f12294c;

    /* renamed from: d  reason: collision with root package name */
    public final View f12295d;

    /* renamed from: e  reason: collision with root package name */
    public int f12296e;

    /* renamed from: f  reason: collision with root package name */
    public int f12297f;

    /* renamed from: g  reason: collision with root package name */
    public int f12298g;

    /* renamed from: h  reason: collision with root package name */
    public int f12299h;

    /* renamed from: i  reason: collision with root package name */
    public int f12300i;

    /* renamed from: j  reason: collision with root package name */
    public int f12301j;
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
        this.a = new Paint();
        this.f12293b = new Paint();
        this.f12294c = new Paint();
        this.f12296e = 16;
        this.f12297f = 16;
        this.f12298g = -1;
        this.f12299h = 1711276032;
        this.f12300i = 20;
        this.f12301j = 20;
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
        this.f12295d = view;
        int color = getContext().getResources().getColor(R.color.black_alpha40);
        this.f12299h = color;
        this.f12293b.setColor(color);
        this.f12293b.setAntiAlias(true);
        this.f12300i = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        int color2 = getContext().getResources().getColor(R.color.CAM_X0101);
        this.f12298g = color2;
        this.a.setColor(color2);
        this.a.setTextSize(this.f12300i);
        this.a.setAntiAlias(true);
        this.a.setTypeface(c.a.q0.r.v.a.H(c.a.q0.r.v.a.E(R.string.F_X02)));
        this.f12296e = n.f(getContext(), R.dimen.tbds16);
        this.f12297f = n.f(getContext(), R.dimen.tbds16);
        this.f12301j = n.f(getContext(), R.dimen.tbds22);
        this.k = n.f(getContext(), R.dimen.tbds40);
        this.l = c.a.q0.r.v.a.y(R.string.J_X01)[0];
        int dimension = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.q = dimension;
        this.f12294c.setTextSize(dimension);
        this.a.setAntiAlias(true);
        this.m.setAntiAlias(true);
        this.r = n.f(getContext(), R.dimen.tbds16);
        this.s = n.f(getContext(), R.dimen.tbds22);
        this.t = n.f(getContext(), R.dimen.tbds5);
        this.v = n.f(getContext(), R.dimen.M_W_X006);
        n.f(getContext(), R.dimen.M_H_X004);
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            View view = this.f12295d;
            if (view != null && view.getContext() != null) {
                return this.f12295d.getContext();
            }
            return TbadkCoreApplication.getInst().getContext();
        }
        return (Context) invokeV.objValue;
    }

    public void a(Canvas canvas, String str, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, canvas, str, z) == null) || canvas == null || this.f12295d == null || TextUtils.isEmpty(str)) {
            return;
        }
        int save = canvas.save();
        this.f12295d.getPaddingLeft();
        int paddingRight = this.f12295d.getPaddingRight();
        this.f12295d.getPaddingTop();
        int paddingBottom = this.f12295d.getPaddingBottom();
        int left = this.f12295d.getLeft();
        int right = this.f12295d.getRight();
        int top = this.f12295d.getTop();
        int bottom = this.f12295d.getBottom();
        float measureText = this.a.measureText(str);
        Paint.FontMetrics fontMetrics = this.a.getFontMetrics();
        if (z) {
            if (this.u == null) {
                this.u = c.a.q0.r.v.a.B(R.array.S_O_X001);
            }
            float[] fArr = this.u;
            if (fArr == null || fArr.length < 4) {
                i2 = save;
            } else {
                i2 = save;
                this.a.setShadowLayer(fArr[1], fArr[2], fArr[3], (int) fArr[0]);
            }
            int i3 = this.v;
            canvas.drawText(str, (((right - left) - paddingRight) - i3) - measureText, (((bottom - top) - paddingBottom) - i3) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.a);
        } else {
            i2 = save;
            float f2 = this.k + measureText;
            float f3 = this.f12300i + this.f12301j;
            canvas.translate((((right - left) - paddingRight) - f2) - this.f12297f, (((bottom - top) - paddingBottom) - f3) - this.f12296e);
            RectF rectF = new RectF(0.0f, 0.0f, f2, f3);
            float f4 = this.l;
            if (f4 < 1.0f) {
                this.l = f4 * f3;
            }
            float f5 = this.l;
            canvas.drawRoundRect(rectF, f5, f5, this.f12293b);
            this.a.clearShadowLayer();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.a);
        }
        int i4 = i2;
        if (i4 < 1 || i4 > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(i4);
    }

    public void b(Canvas canvas, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, str, i2) == null) || canvas == null || this.f12295d == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (i2 != 0) {
            this.p = i2;
            this.m.setColor(SkinManager.getColor(i2));
        }
        int save = canvas.save();
        int paddingLeft = this.f12295d.getPaddingLeft();
        this.f12295d.getPaddingRight();
        int paddingTop = this.f12295d.getPaddingTop();
        this.f12295d.getPaddingBottom();
        float measureText = this.f12294c.measureText(str);
        canvas.translate(paddingLeft, paddingTop);
        RectF rectF = new RectF(0.0f, 0.0f, this.s + measureText, this.q + this.r);
        int i3 = this.t;
        canvas.drawRoundRect(rectF, i3, i3, this.m);
        Paint.FontMetrics fontMetrics = this.f12294c.getFontMetrics();
        canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.f12294c);
        if (save < 1 || save > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(save);
    }

    public float c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? n.D(this.a, str).height() + this.f12301j : invokeL.floatValue;
    }

    public float d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? n.E(this.a, str) + this.k : invokeL.floatValue;
    }

    public final void e() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (view = this.f12295d) == null) {
            return;
        }
        view.invalidate();
    }

    public void f(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            this.f12297f = i2;
            this.f12296e = i3;
            e();
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f12298g = i2;
            this.a.setColor(i2);
            e();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f12300i = i2;
            this.a.setTextSize(i2);
            e();
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.n == i2) {
            return;
        }
        this.n = i2;
        this.f12294c.setColor(SkinManager.getColor(i2, this.o));
        this.m.setColor(SkinManager.getColor(i2, this.p));
    }
}
