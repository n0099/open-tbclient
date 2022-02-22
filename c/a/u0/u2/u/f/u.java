package c.a.u0.u2.u.f;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.t0.x.y.h a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f23795b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f23796c;

    /* renamed from: d  reason: collision with root package name */
    public PbFakeFloorModel f23797d;

    /* renamed from: e  reason: collision with root package name */
    public String f23798e;

    /* renamed from: f  reason: collision with root package name */
    public String f23799f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f23800g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.u0.u2.r.f f23801h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f23802i;

    public u(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, pbFakeFloorModel, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23795b = tbPageContext;
        this.f23796c = relativeLayout;
        this.f23797d = pbFakeFloorModel;
    }

    public final void a() {
        c.a.t0.x.y.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23796c == null || (hVar = this.a) == null || hVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f23796c.addView(this.a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public c.a.t0.x.y.h b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (c.a.t0.x.y.h) invokeV.objValue;
    }

    public void c() {
        c.a.t0.x.y.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.y();
        if (StringUtils.isNull(this.f23798e)) {
            this.a.D();
        }
        this.a.a().resetChangeToLauncher();
    }

    public void d() {
        c.a.t0.x.y.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hVar = this.a) == null || hVar.a() == null) {
            return;
        }
        this.a.a().hideTools();
    }

    public final void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) && this.f23796c != null && this.a == null) {
            c.a.t0.x.y.i iVar = new c.a.t0.x.y.i(z);
            iVar.i(str);
            c.a.t0.x.y.h hVar = (c.a.t0.x.y.h) iVar.a(this.f23795b.getPageActivity());
            this.a = hVar;
            hVar.N(this.f23795b);
            this.a.a0(this.f23797d);
            this.a.O(1);
            c.a.u0.u2.r.f fVar = this.f23801h;
            if (fVar != null) {
                this.a.b0(fVar.O());
            }
            this.a.a().showLinePositionBottom(true);
            this.a.a().setOnCancelClickListener(this.f23802i);
            this.a.z(this.f23795b);
            a();
            this.a.Q(this.f23800g);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.t0.x.y.h hVar = this.a;
            if (hVar == null || hVar.a() == null) {
                return false;
            }
            return this.a.a().isToolVisible();
        }
        return invokeV.booleanValue;
    }

    public void g(int i2, int i3, Intent intent) {
        c.a.t0.x.y.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.C(i2, i3, intent);
    }

    public void h(int i2) {
        c.a.t0.x.y.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (hVar = this.a) == null || hVar.a() == null) {
            return;
        }
        this.a.a().onChangeSkinType(i2);
    }

    public void i() {
        c.a.t0.x.y.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.E();
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f23799f = str;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f23802i = onClickListener;
        }
    }

    public void l(int i2) {
        c.a.t0.x.y.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.P(i2);
    }

    public void m(c.a.u0.u2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
            this.f23801h = fVar;
        }
    }

    public void n(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f23800g = gVar;
            c.a.t0.x.y.h hVar = this.a;
            if (hVar != null) {
                hVar.Q(gVar);
            }
        }
    }

    public void o(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            this.f23798e = str2;
            c.a.t0.x.y.h hVar = this.a;
            if (hVar == null) {
                e(str3, z);
            } else {
                hVar.a0(this.f23797d);
                if (StringUtils.isNull(this.f23798e)) {
                    this.a.z(this.f23795b);
                }
            }
            this.a.W(str);
            this.a.V(str2, "");
            this.a.p(this.f23799f);
            if (this.a.x()) {
                this.a.v(null);
            }
        }
    }
}
