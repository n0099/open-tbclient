package c.a.t0.x2.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.x2.j.p;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class k extends e implements c.a.t0.g2.a, b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f26162f;

    /* renamed from: g  reason: collision with root package name */
    public long f26163g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26164h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f26165i;

    /* renamed from: j  reason: collision with root package name */
    public g f26166j;

    /* renamed from: k  reason: collision with root package name */
    public p f26167k;
    public PersonPolymericModel l;
    public f m;
    public BaseFragmentActivity n;
    public View o;
    public PersonPostModel p;
    public int q;
    public List<c.a.t0.u2.h.e> r;

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
        this.f26164h = true;
        this.q = 3;
        BaseFragmentActivity baseFragmentActivity = baseFragment.getBaseFragmentActivity();
        this.n = baseFragmentActivity;
        this.f26162f = baseFragmentActivity.getPageContext();
        this.f26163g = j2;
        this.f26166j = gVar;
        this.f26165i = bdUniqueId;
        this.o = gVar.f26132i;
        this.p = new PersonPostModel(this.f26162f, bdUniqueId, null, this.f26116e, PersonPostModel.FROM_PERSON_POLYMERIC);
        p pVar = new p(baseFragment, gVar, bdUniqueId, z, this.f26163g);
        this.f26167k = pVar;
        pVar.W(this);
        g();
        this.l = this.f26166j.q();
        this.m = this.f26166j.l();
        ArrayList arrayList = new ArrayList(2);
        this.r = arrayList;
        arrayList.add(new c.a.t0.u2.h.e());
        this.r.add(new c.a.t0.u2.h.e());
    }

    @Override // c.a.t0.g2.a
    public void a() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f26166j) == null) {
            return;
        }
        gVar.a();
    }

    @Override // c.a.t0.x2.d.b
    public p b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26167k : (p) invokeV.objValue;
    }

    @Override // c.a.t0.x2.d.b
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // c.a.t0.x2.d.b
    public void e() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (pVar = this.f26167k) == null) {
            return;
        }
        pVar.M();
    }

    @Override // c.a.t0.x2.d.b
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // c.a.t0.g2.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.resetThreadPn();
            PersonPolymericModel personPolymericModel = this.l;
            if (personPolymericModel != null) {
                personPolymericModel.K();
            }
        }
    }

    public void j(c.a.t0.n4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.f26167k.X(eVar);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.q == i2) {
            return;
        }
        p pVar = this.f26167k;
        if (pVar != null) {
            pVar.T(i2);
        }
        this.q = i2;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f26165i);
            p pVar = this.f26167k;
            if (pVar != null) {
                pVar.U();
            }
        }
    }

    @Override // c.a.t0.g2.a
    public void loadData() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (gVar = this.f26166j) == null) {
            return;
        }
        gVar.loadData();
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && z && this.f26164h) {
            loadData();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && TbadkCoreApplication.isLogin() && !this.f26116e && this.f26163g == TbadkCoreApplication.getCurrentAccountId()) {
            this.f26116e = true;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f26162f.getPageActivity()).createNormalConfig(c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.n.finish();
        }
    }

    public void o(c.a.t0.x2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.f26167k.N();
            this.n.hideLoadingView(this.o);
            boolean z = true;
            if (aVar == null) {
                this.m.x(TbadkCoreApplication.getInst().getString(c.a.t0.y2.g.neterror), true);
                this.m.m();
                this.m.s(8);
                return;
            }
            this.m.o();
            if (aVar.e() != null && ((aVar.e().getHide_stat() == 1 && aVar.e().getBlock_stat() == 1) || (aVar.e().getHide_stat() == 1 && aVar.e().getBlock_stat() == 2))) {
                this.m.u(this.f26116e);
                this.m.s(8);
                return;
            }
            this.m.s(0);
            aVar.b();
            z = (aVar.f() == null || aVar.f().size() < 20) ? false : false;
            if (aVar.j() != null) {
                aVar.j().getSex();
            }
            this.f26164h = false;
            if (this.f26116e && aVar.j() != null) {
                aVar.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                c.a.s0.a0.b.a().e(aVar.j());
            }
            c.a.t0.u2.h.e eVar = this.r.get(0);
            eVar.a(aVar.f());
            eVar.b(z);
            this.f26167k.Z(aVar, z, i(aVar));
        }
    }
}
