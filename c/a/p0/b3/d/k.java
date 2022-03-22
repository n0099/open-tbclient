package c.a.p0.b3.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.b3.k.p;
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
/* loaded from: classes2.dex */
public class k extends e implements c.a.p0.k2.a, b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f12682b;

    /* renamed from: c  reason: collision with root package name */
    public long f12683c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12684d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f12685e;

    /* renamed from: f  reason: collision with root package name */
    public g f12686f;

    /* renamed from: g  reason: collision with root package name */
    public p f12687g;

    /* renamed from: h  reason: collision with root package name */
    public PersonPolymericModel f12688h;
    public f i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<c.a.p0.y2.i.e> n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(BaseFragment baseFragment, g gVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, gVar, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12684d = true;
        this.m = 3;
        BaseFragmentActivity baseFragmentActivity = baseFragment.getBaseFragmentActivity();
        this.j = baseFragmentActivity;
        this.f12682b = baseFragmentActivity.getPageContext();
        this.f12683c = j;
        this.f12686f = gVar;
        this.f12685e = bdUniqueId;
        this.k = gVar.f12655e;
        this.l = new PersonPostModel(this.f12682b, bdUniqueId, null, this.a, PersonPostModel.FROM_PERSON_POLYMERIC);
        p pVar = new p(baseFragment, gVar, bdUniqueId, z, this.f12683c);
        this.f12687g = pVar;
        pVar.W(this);
        g();
        this.f12688h = this.f12686f.q();
        this.i = this.f12686f.l();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new c.a.p0.y2.i.e());
        this.n.add(new c.a.p0.y2.i.e());
    }

    @Override // c.a.p0.k2.a
    public void a() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f12686f) == null) {
            return;
        }
        gVar.a();
    }

    @Override // c.a.p0.b3.d.b
    public p b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12687g : (p) invokeV.objValue;
    }

    @Override // c.a.p0.b3.d.b
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // c.a.p0.b3.d.b
    public void e() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (pVar = this.f12687g) == null) {
            return;
        }
        pVar.M();
    }

    @Override // c.a.p0.b3.d.b
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // c.a.p0.k2.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.l.resetThreadPn();
            PersonPolymericModel personPolymericModel = this.f12688h;
            if (personPolymericModel != null) {
                personPolymericModel.M();
            }
        }
    }

    public void j(c.a.p0.q4.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.f12687g.X(fVar);
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || this.m == i) {
            return;
        }
        p pVar = this.f12687g;
        if (pVar != null) {
            pVar.T(i);
        }
        this.m = i;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f12685e);
            p pVar = this.f12687g;
            if (pVar != null) {
                pVar.U();
            }
        }
    }

    @Override // c.a.p0.k2.a
    public void loadData() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (gVar = this.f12686f) == null) {
            return;
        }
        gVar.loadData();
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && z && this.f12684d) {
            loadData();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && TbadkCoreApplication.isLogin() && !this.a && this.f12683c == TbadkCoreApplication.getCurrentAccountId()) {
            this.a = true;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f12682b.getPageActivity()).createNormalConfig(c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.j.finish();
        }
    }

    public void o(c.a.p0.b3.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.f12687g.N();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (aVar == null) {
                this.i.x(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c15), true);
                this.i.m();
                this.i.s(8);
                return;
            }
            this.i.o();
            if (aVar.e() != null && ((aVar.e().getHide_stat() == 1 && aVar.e().getBlock_stat() == 1) || (aVar.e().getHide_stat() == 1 && aVar.e().getBlock_stat() == 2))) {
                this.i.u(this.a);
                this.i.s(8);
                return;
            }
            this.i.s(0);
            aVar.b();
            z = (aVar.f() == null || aVar.f().size() < 20) ? false : false;
            if (aVar.j() != null) {
                aVar.j().getSex();
            }
            this.f12684d = false;
            if (this.a && aVar.j() != null) {
                aVar.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                c.a.o0.z.b.d().i(aVar.j());
            }
            c.a.p0.y2.i.e eVar = this.n.get(0);
            eVar.a(aVar.f());
            eVar.b(z);
            this.f12687g.Z(aVar, z, i(aVar));
        }
    }
}
