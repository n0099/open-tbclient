package c.a.p0.f0.c;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.f0.c.b;
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
/* loaded from: classes2.dex */
public class c implements b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f13830b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13831c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f13832d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f13833e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13834f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13835g;

    /* renamed from: h  reason: collision with root package name */
    public a f13836h;
    public b.a i;
    public int j;
    public Map<Integer, Float> k;

    public c(TbPageContext tbPageContext, a aVar, b.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar, aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 0;
        this.k = new HashMap();
        this.a = tbPageContext;
        this.f13836h = aVar;
        this.i = aVar2;
        e();
    }

    @Override // c.a.p0.f0.c.b
    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k.get(Integer.valueOf(this.j)).floatValue() : invokeV.floatValue;
    }

    @Override // c.a.p0.f0.c.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13830b.getVisibility() : invokeV.intValue;
    }

    @Override // c.a.p0.f0.c.b
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f13830b.setVisibility(i);
        }
    }

    @Override // c.a.p0.f0.c.b
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j != 0 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.k.put(0, Float.valueOf(1.0f));
            this.k.put(1, Float.valueOf(0.5f));
            this.k.put(2, Float.valueOf(0.33333334f));
            this.k.put(3, Float.valueOf(2.0f));
            this.k.put(4, Float.valueOf(3.0f));
            f();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f13830b = (LinearLayout) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0904b9);
            this.f13831c = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091d59);
            this.f13832d = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091d58);
            this.f13833e = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091d57);
            this.f13834f = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091d54);
            this.f13835g = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091d55);
            this.f13831c.setOnClickListener(this);
            this.f13832d.setOnClickListener(this);
            this.f13833e.setOnClickListener(this);
            this.f13834f.setOnClickListener(this);
            this.f13835g.setOnClickListener(this);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f13830b);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0214);
            h(this.f13833e, true);
            h(this.f13831c, false);
            h(this.f13832d, false);
            h(this.f13834f, false);
            h(this.f13835g, false);
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            i(this.j, false);
            this.j = i;
            i(i, true);
            a aVar = this.f13836h;
            if (aVar != null) {
                aVar.a(a());
            }
        }
    }

    public final void h(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, textView, z) == null) {
            textView.setTextColor(this.a.getResources().getColor(z ? R.color.CAM_X0302 : R.color.CAM_X0101));
            textView.setTextSize(0, UtilHelper.getDimenPixelSize(z ? R.dimen.T_X05 : R.dimen.T_X07));
        }
    }

    public final void i(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i == 0) {
                h(this.f13833e, z);
            } else if (i == 1) {
                h(this.f13832d, z);
            } else if (i == 2) {
                h(this.f13831c, z);
            } else if (i == 3) {
                h(this.f13834f, z);
            } else if (i != 4) {
            } else {
                h(this.f13835g, z);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            if (view.getId() == R.id.obfuscated_res_0x7f091d59) {
                b.a aVar = this.i;
                if (aVar == null || aVar.a(2)) {
                    g(2);
                }
            } else if (view.getId() == R.id.obfuscated_res_0x7f091d58) {
                b.a aVar2 = this.i;
                if (aVar2 == null || aVar2.a(1)) {
                    g(1);
                }
            } else if (view.getId() == R.id.obfuscated_res_0x7f091d57) {
                b.a aVar3 = this.i;
                if (aVar3 == null || aVar3.a(0)) {
                    g(0);
                }
            } else if (view.getId() == R.id.obfuscated_res_0x7f091d54) {
                b.a aVar4 = this.i;
                if (aVar4 == null || aVar4.a(3)) {
                    g(3);
                }
            } else if (view.getId() == R.id.obfuscated_res_0x7f091d55) {
                b.a aVar5 = this.i;
                if (aVar5 == null || aVar5.a(4)) {
                    g(4);
                }
            }
        }
    }

    @Override // c.a.p0.f0.c.b
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            g(0);
        }
    }
}
