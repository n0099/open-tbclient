package c.a.q0.i2.k.e;

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
/* loaded from: classes3.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.p0.x.w.h f19597a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f19598b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f19599c;

    /* renamed from: d  reason: collision with root package name */
    public PbFakeFloorModel f19600d;

    /* renamed from: e  reason: collision with root package name */
    public String f19601e;

    /* renamed from: f  reason: collision with root package name */
    public String f19602f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f19603g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.i2.h.e f19604h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f19605i;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
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
        this.f19598b = tbPageContext;
        this.f19599c = relativeLayout;
        this.f19600d = pbFakeFloorModel;
    }

    public final void a() {
        c.a.p0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19599c == null || (hVar = this.f19597a) == null || hVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f19599c.addView(this.f19597a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public c.a.p0.x.w.h b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19597a : (c.a.p0.x.w.h) invokeV.objValue;
    }

    public void c() {
        c.a.p0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (hVar = this.f19597a) == null) {
            return;
        }
        hVar.y();
        if (StringUtils.isNull(this.f19601e)) {
            this.f19597a.D();
        }
        this.f19597a.a().resetChangeToLauncher();
    }

    public void d() {
        c.a.p0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hVar = this.f19597a) == null || hVar.a() == null) {
            return;
        }
        this.f19597a.a().hideTools();
    }

    public final void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) && this.f19599c != null && this.f19597a == null) {
            c.a.p0.x.w.i iVar = new c.a.p0.x.w.i(z);
            iVar.i(str);
            c.a.p0.x.w.h hVar = (c.a.p0.x.w.h) iVar.a(this.f19598b.getPageActivity());
            this.f19597a = hVar;
            hVar.N(this.f19598b);
            this.f19597a.Z(this.f19600d);
            this.f19597a.O(1);
            c.a.q0.i2.h.e eVar = this.f19604h;
            if (eVar != null) {
                this.f19597a.a0(eVar.O());
            }
            this.f19597a.a().showLinePositionBottom(true);
            this.f19597a.a().setOnCancelClickListener(this.f19605i);
            this.f19597a.z(this.f19598b);
            a();
            this.f19597a.Q(this.f19603g);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.p0.x.w.h hVar = this.f19597a;
            if (hVar == null || hVar.a() == null) {
                return false;
            }
            return this.f19597a.a().isToolVisible();
        }
        return invokeV.booleanValue;
    }

    public void g(int i2, int i3, Intent intent) {
        c.a.p0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) || (hVar = this.f19597a) == null) {
            return;
        }
        hVar.C(i2, i3, intent);
    }

    public void h(int i2) {
        c.a.p0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (hVar = this.f19597a) == null || hVar.a() == null) {
            return;
        }
        this.f19597a.a().onChangeSkinType(i2);
    }

    public void i() {
        c.a.p0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.f19597a) == null) {
            return;
        }
        hVar.E();
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f19602f = str;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f19605i = onClickListener;
        }
    }

    public void l(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f19604h = eVar;
        }
    }

    public void m(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
            this.f19603g = gVar;
            c.a.p0.x.w.h hVar = this.f19597a;
            if (hVar != null) {
                hVar.Q(gVar);
            }
        }
    }

    public void n(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            this.f19601e = str2;
            c.a.p0.x.w.h hVar = this.f19597a;
            if (hVar == null) {
                e(str3, z);
            } else {
                hVar.Z(this.f19600d);
                if (StringUtils.isNull(this.f19601e)) {
                    this.f19597a.z(this.f19598b);
                }
            }
            this.f19597a.V(str);
            this.f19597a.U(str2);
            this.f19597a.p(this.f19602f);
            if (this.f19597a.x()) {
                this.f19597a.v(null);
            }
        }
    }
}
