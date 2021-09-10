package c.a.r0.o2.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.o2.j.p;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class k extends e implements c.a.r0.y1.a, b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f23169f;

    /* renamed from: g  reason: collision with root package name */
    public long f23170g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23171h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f23172i;

    /* renamed from: j  reason: collision with root package name */
    public g f23173j;
    public p k;
    public PersonPolymericModel l;
    public f m;
    public BaseFragmentActivity n;
    public View o;
    public PersonPostModel p;
    public int q;
    public List<c.a.r0.l2.h.e> r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(BaseFragment baseFragment, g gVar, BdUniqueId bdUniqueId, long j2, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, gVar, bdUniqueId, Long.valueOf(j2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23171h = true;
        this.q = 3;
        BaseFragmentActivity baseFragmentActivity = baseFragment.getBaseFragmentActivity();
        this.n = baseFragmentActivity;
        this.f23169f = baseFragmentActivity.getPageContext();
        this.f23170g = j2;
        this.f23173j = gVar;
        this.f23172i = bdUniqueId;
        this.o = gVar.f23130i;
        this.p = new PersonPostModel(this.f23169f, bdUniqueId, null, this.f23115e, PersonPostModel.FROM_PERSON_POLYMERIC);
        p pVar = new p(baseFragment, gVar, bdUniqueId, z, this.f23170g);
        this.k = pVar;
        pVar.W(this);
        f();
        this.l = this.f23173j.q();
        this.m = this.f23173j.l();
        ArrayList arrayList = new ArrayList(2);
        this.r = arrayList;
        arrayList.add(new c.a.r0.l2.h.e());
        this.r.add(new c.a.r0.l2.h.e());
    }

    @Override // c.a.r0.o2.d.b
    public p a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (p) invokeV.objValue;
    }

    @Override // c.a.r0.o2.d.b
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    @Override // c.a.r0.o2.d.b
    public void d() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (pVar = this.k) == null) {
            return;
        }
        pVar.M();
    }

    @Override // c.a.r0.o2.d.b
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // c.a.r0.y1.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.p.resetThreadPn();
            PersonPolymericModel personPolymericModel = this.l;
            if (personPolymericModel != null) {
                personPolymericModel.K();
            }
        }
    }

    @Override // c.a.r0.y1.a
    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (gVar = this.f23173j) == null) {
            return;
        }
        gVar.g();
    }

    public void j(c.a.r0.b4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.k.X(eVar);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.q == i2) {
            return;
        }
        p pVar = this.k;
        if (pVar != null) {
            pVar.T(i2);
        }
        this.q = i2;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f23172i);
            p pVar = this.k;
            if (pVar != null) {
                pVar.U();
            }
        }
    }

    @Override // c.a.r0.y1.a
    public void loadData() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (gVar = this.f23173j) == null) {
            return;
        }
        gVar.loadData();
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && z && this.f23171h) {
            loadData();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && TbadkCoreApplication.isLogin() && !this.f23115e && this.f23170g == TbadkCoreApplication.getCurrentAccountId()) {
            this.f23115e = true;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f23169f.getPageActivity()).createNormalConfig(c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.n.finish();
        }
    }

    public void o(c.a.r0.o2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.k.N();
            this.n.hideLoadingView(this.o);
            boolean z = true;
            if (aVar == null) {
                this.m.x(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                this.m.m();
                this.m.s(8);
                return;
            }
            this.m.o();
            if (aVar.e() != null && ((aVar.e().getHide_stat() == 1 && aVar.e().getBlock_stat() == 1) || (aVar.e().getHide_stat() == 1 && aVar.e().getBlock_stat() == 2))) {
                this.m.u(this.f23115e);
                this.m.s(8);
                return;
            }
            this.m.s(0);
            aVar.b();
            z = (aVar.f() == null || aVar.f().size() < 20) ? false : false;
            if (aVar.j() != null) {
                aVar.j().getSex();
            }
            this.f23171h = false;
            if (this.f23115e && aVar.j() != null) {
                aVar.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                c.a.q0.a0.b.a().e(aVar.j());
            }
            c.a.r0.l2.h.e eVar = this.r.get(0);
            eVar.a(aVar.f());
            eVar.b(z);
            this.k.Z(aVar, z, i(aVar));
        }
    }
}
