package c.a.p0.y.c;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.y.c.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class c implements b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f28738e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f28739f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f28740g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f28741h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f28742i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f28743j;
    public TextView k;
    public a l;
    public b.a m;
    public int n;
    public Map<Integer, Float> o;

    public c(TbPageContext tbPageContext, a aVar, b.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar, aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 0;
        this.o = new HashMap();
        this.f28738e = tbPageContext;
        this.l = aVar;
        this.m = aVar2;
        e();
    }

    @Override // c.a.p0.y.c.b
    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o.get(Integer.valueOf(this.n)).floatValue() : invokeV.floatValue;
    }

    @Override // c.a.p0.y.c.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28739f.getVisibility() : invokeV.intValue;
    }

    @Override // c.a.p0.y.c.b
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f28739f.setVisibility(i2);
        }
    }

    @Override // c.a.p0.y.c.b
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n != 0 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.o.put(0, Float.valueOf(1.0f));
            this.o.put(1, Float.valueOf(0.5f));
            this.o.put(2, Float.valueOf(0.33333334f));
            this.o.put(3, Float.valueOf(2.0f));
            this.o.put(4, Float.valueOf(3.0f));
            f();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f28739f = (LinearLayout) this.f28738e.getPageActivity().findViewById(R.id.capture_speed_container);
            this.f28740g = (TextView) this.f28738e.getPageActivity().findViewById(R.id.speed_slowest);
            this.f28741h = (TextView) this.f28738e.getPageActivity().findViewById(R.id.speed_slow);
            this.f28742i = (TextView) this.f28738e.getPageActivity().findViewById(R.id.speed_normal);
            this.f28743j = (TextView) this.f28738e.getPageActivity().findViewById(R.id.speed_fast);
            this.k = (TextView) this.f28738e.getPageActivity().findViewById(R.id.speed_fastest);
            this.f28740g.setOnClickListener(this);
            this.f28741h.setOnClickListener(this);
            this.f28742i.setOnClickListener(this);
            this.f28743j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            c.a.o0.s.u.c d2 = c.a.o0.s.u.c.d(this.f28739f);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0214);
            h(this.f28742i, true);
            h(this.f28740g, false);
            h(this.f28741h, false);
            h(this.f28743j, false);
            h(this.k, false);
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            i(this.n, false);
            this.n = i2;
            i(i2, true);
            a aVar = this.l;
            if (aVar != null) {
                aVar.a(a());
            }
        }
    }

    public final void h(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, textView, z) == null) {
            textView.setTextColor(this.f28738e.getResources().getColor(z ? R.color.CAM_X0302 : R.color.CAM_X0101));
            textView.setTextSize(0, UtilHelper.getDimenPixelSize(z ? R.dimen.T_X05 : R.dimen.T_X07));
        }
    }

    public final void i(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 == 0) {
                h(this.f28742i, z);
            } else if (i2 == 1) {
                h(this.f28741h, z);
            } else if (i2 == 2) {
                h(this.f28740g, z);
            } else if (i2 == 3) {
                h(this.f28743j, z);
            } else if (i2 != 4) {
            } else {
                h(this.k, z);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            if (view.getId() == R.id.speed_slowest) {
                b.a aVar = this.m;
                if (aVar == null || aVar.a(2)) {
                    g(2);
                }
            } else if (view.getId() == R.id.speed_slow) {
                b.a aVar2 = this.m;
                if (aVar2 == null || aVar2.a(1)) {
                    g(1);
                }
            } else if (view.getId() == R.id.speed_normal) {
                b.a aVar3 = this.m;
                if (aVar3 == null || aVar3.a(0)) {
                    g(0);
                }
            } else if (view.getId() == R.id.speed_fast) {
                b.a aVar4 = this.m;
                if (aVar4 == null || aVar4.a(3)) {
                    g(3);
                }
            } else if (view.getId() == R.id.speed_fastest) {
                b.a aVar5 = this.m;
                if (aVar5 == null || aVar5.a(4)) {
                    g(4);
                }
            }
        }
    }

    @Override // c.a.p0.y.c.b
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            g(0);
        }
    }
}
