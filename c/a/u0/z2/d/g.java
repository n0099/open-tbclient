package c.a.u0.z2.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.u0.w2.a;
import c.a.u0.z2.d.f;
import c.a.u0.z2.e.p;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.event.PersonPolymericEventController;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes9.dex */
public class g extends e implements c.a.u0.z2.i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final BaseFragmentActivity f25925f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragment f25926g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f25927h;

    /* renamed from: i  reason: collision with root package name */
    public final View f25928i;

    /* renamed from: j  reason: collision with root package name */
    public final BdUniqueId f25929j;
    public long k;
    public String l;
    public f m;
    public final PersonPolymericModel n;
    public final d o;
    public final BlackListModel p;
    public k q;
    public c.a.u0.k0.j r;
    public PersonPolymericEventController s;
    public h t;
    public int u;
    public boolean v;
    public final f.e w;
    public CustomMessageListener x;

    /* loaded from: classes9.dex */
    public class a implements f.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.u0.z2.d.f.e
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.loadData();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g gVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.a();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.u0.w2.a.c
        public void a(int i2, String str, ImageUploadResult imageUploadResult) {
            ImageUploadResult.PicDetailedInfo picDetailedInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i2, str, imageUploadResult) == null) && i2 == 0 && imageUploadResult != null) {
                String str2 = null;
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null) {
                    str2 = picDetailedInfo.picUrl;
                }
                j.a(str2, this.a.r());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j2, boolean z, boolean z2, String str) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, view, bdUniqueId, Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2), str};
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
        this.u = 3;
        this.v = false;
        this.w = new a(this);
        this.x = new b(this, 2921424);
        this.f25926g = baseFragment;
        BaseFragmentActivity baseFragmentActivity = baseFragment.getBaseFragmentActivity();
        this.f25925f = baseFragmentActivity;
        this.f25928i = view;
        this.f25929j = bdUniqueId;
        this.k = j2;
        this.l = str;
        this.f25927h = baseFragmentActivity.getPageContext();
        MessageManager.getInstance().registerListener(this.x);
        this.o = new d(this.f25926g.getPageContext(), bdUniqueId);
        f fVar = new f(this.f25926g.getPageContext(), view, z);
        this.m = fVar;
        fVar.t(this.w);
        this.s = new PersonPolymericEventController(this.f25927h, this);
        PersonPolymericModel personPolymericModel = new PersonPolymericModel(this.f25925f, bdUniqueId, z);
        this.n = personPolymericModel;
        personPolymericModel.N(new p(z));
        this.n.L(this);
        this.n.M(this.o);
        this.p = new BlackListModel(this.f25925f.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.l)) {
            k kVar = new k(this.f25926g, this, this.f25929j, this.k, z);
            this.q = kVar;
            kVar.k(TbadkCoreApplication.getInst().getSkinType());
            this.q.j(this.s);
        }
        this.t = new h(this.f25927h, this.o, this.p, bdUniqueId);
        loadData();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!TbadkCoreApplication.isLogin() && this.f25913e) {
                this.m.A();
            } else if (l.A()) {
                this.n.I(this.k, this.l);
            } else {
                this.m.n();
                n.N(this.f25927h.getContext(), this.f25927h.getString(c.a.u0.a3.g.data_load_error));
                ArrayList arrayList = new ArrayList();
                c.a.u0.z2.e.i iVar = new c.a.u0.z2.e.i();
                iVar.f26003e = this.f25913e;
                arrayList.add(iVar);
                this.m.m();
                this.m.v(arrayList);
                this.m.y();
            }
        }
    }

    @Override // c.a.u0.z2.i.b
    public void c(c.a.u0.z2.e.a aVar) {
        NicknameInfo nicknameInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (aVar != null && aVar.j() != null && !StringUtils.isNull(this.l)) {
                this.k = aVar.j().getUserIdLong();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.k)));
                this.f25913e = this.k == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            }
            this.m.n();
            h hVar = this.t;
            if (hVar != null) {
                hVar.h(aVar);
            }
            if (aVar != null) {
                this.m.k(aVar);
            }
            k kVar = this.q;
            if (kVar != null) {
                kVar.o(aVar);
            } else {
                k kVar2 = new k(this.f25926g, this, this.f25929j, this.k, this.f25913e);
                this.q = kVar2;
                kVar2.k(TbadkCoreApplication.getInst().getSkinType());
                this.q.j(this.s);
                this.q.o(aVar);
            }
            if (!this.v || aVar == null || (nicknameInfo = aVar.A) == null || nicknameInfo.left_days == null || aVar.j() == null) {
                return;
            }
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.j().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.A.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            new c.a.u0.w2.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new c(this));
        }
    }

    public boolean k(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || m.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (c.a.t0.s.j0.b.k().h(c.a.t0.s.j0.b.o(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f25925f).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public f l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (f) invokeV.objValue;
    }

    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!TbadkCoreApplication.isLogin() && this.f25913e) {
                this.m.A();
            } else if (l.A()) {
                c.a.u0.z2.b.d().m(System.currentTimeMillis());
                this.m.w(false, -1);
                this.m.B(true);
                this.n.J(this.k);
                this.n.I(this.k, this.l);
            } else {
                this.m.n();
                this.m.s(8);
                this.m.x(this.f25926g.getString(c.a.u0.a3.g.neterror), true);
            }
        }
    }

    public h m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.t : (h) invokeV.objValue;
    }

    public c.a.u0.z2.d.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.q : (c.a.u0.z2.d.b) invokeV.objValue;
    }

    public i o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (i) invokeV.objValue;
    }

    public c.a.u0.z2.e.a p(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            if (z) {
                this.v = z;
                if (l.A()) {
                    this.n.I(this.k, this.l);
                }
            }
            return this.n.H();
        }
        return (c.a.u0.z2.e.a) invokeZ.objValue;
    }

    public PersonPolymericModel q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.n : (PersonPolymericModel) invokeV.objValue;
    }

    public List<c.a.d.o.e.n> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.n.H() == null) {
                return null;
            }
            return this.n.H().k();
        }
        return (List) invokeV.objValue;
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || this.u == i2) {
            return;
        }
        k kVar = this.q;
        if (kVar != null) {
            kVar.k(i2);
        }
        this.u = i2;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.x);
            k kVar = this.q;
            if (kVar != null) {
                kVar.l();
            }
            PersonPolymericModel personPolymericModel = this.n;
            if (personPolymericModel != null) {
                personPolymericModel.destroy();
            }
        }
    }

    public void u(boolean z) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (kVar = this.q) == null) {
            return;
        }
        kVar.m(z);
    }

    public void v() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (kVar = this.q) == null) {
            return;
        }
        kVar.n();
    }

    public void w(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, postWriteCallBackData) == null) {
            if (this.r == null) {
                this.r = new c.a.u0.k0.j(this.f25925f.getPageContext(), (NavigationBarCoverTip) this.f25925f.findViewById(c.a.u0.a3.d.navigation_cover_tip));
            }
            this.r.l(postWriteCallBackData);
        }
    }
}
