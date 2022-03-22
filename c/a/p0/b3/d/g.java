package c.a.p0.b3.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.p0.b3.d.f;
import c.a.p0.b3.e.p;
import c.a.p0.y2.a;
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
import com.baidu.tieba.R;
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
/* loaded from: classes2.dex */
public class g extends e implements c.a.p0.b3.i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final BaseFragmentActivity f12652b;

    /* renamed from: c  reason: collision with root package name */
    public BaseFragment f12653c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f12654d;

    /* renamed from: e  reason: collision with root package name */
    public final View f12655e;

    /* renamed from: f  reason: collision with root package name */
    public final BdUniqueId f12656f;

    /* renamed from: g  reason: collision with root package name */
    public long f12657g;

    /* renamed from: h  reason: collision with root package name */
    public String f12658h;
    public f i;
    public final PersonPolymericModel j;
    public final d k;
    public final BlackListModel l;
    public k m;
    public c.a.p0.l0.j n;
    public PersonPolymericEventController o;
    public h p;
    public int q;
    public boolean r;
    public final f.e s;
    public CustomMessageListener t;

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.p0.b3.d.f.e
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.loadData();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g gVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.p0.y2.a.c
        public void a(int i, String str, ImageUploadResult imageUploadResult) {
            ImageUploadResult.PicDetailedInfo picDetailedInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, imageUploadResult) == null) && i == 0 && imageUploadResult != null) {
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
    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, view, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), str};
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
        this.q = 3;
        this.r = false;
        this.s = new a(this);
        this.t = new b(this, 2921424);
        this.f12653c = baseFragment;
        BaseFragmentActivity baseFragmentActivity = baseFragment.getBaseFragmentActivity();
        this.f12652b = baseFragmentActivity;
        this.f12655e = view;
        this.f12656f = bdUniqueId;
        this.f12657g = j;
        this.f12658h = str;
        this.f12654d = baseFragmentActivity.getPageContext();
        MessageManager.getInstance().registerListener(this.t);
        this.k = new d(this.f12653c.getPageContext(), bdUniqueId);
        f fVar = new f(this.f12653c.getPageContext(), view, z);
        this.i = fVar;
        fVar.t(this.s);
        this.o = new PersonPolymericEventController(this.f12654d, this);
        PersonPolymericModel personPolymericModel = new PersonPolymericModel(this.f12652b, bdUniqueId, z);
        this.j = personPolymericModel;
        personPolymericModel.P(new p(z));
        this.j.N(this);
        this.j.O(this.k);
        this.l = new BlackListModel(this.f12652b.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.f12658h)) {
            k kVar = new k(this.f12653c, this, this.f12656f, this.f12657g, z);
            this.m = kVar;
            kVar.k(TbadkCoreApplication.getInst().getSkinType());
            this.m.j(this.o);
        }
        this.p = new h(this.f12654d, this.k, this.l, bdUniqueId);
        loadData();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!TbadkCoreApplication.isLogin() && this.a) {
                this.i.A();
            } else if (l.A()) {
                this.j.K(this.f12657g, this.f12658h);
            } else {
                this.i.n();
                n.N(this.f12654d.getContext(), this.f12654d.getString(R.string.obfuscated_res_0x7f0f046c));
                ArrayList arrayList = new ArrayList();
                c.a.p0.b3.e.i iVar = new c.a.p0.b3.e.i();
                iVar.a = this.a;
                arrayList.add(iVar);
                this.i.m();
                this.i.v(arrayList);
                this.i.y();
            }
        }
    }

    @Override // c.a.p0.b3.i.b
    public void c(c.a.p0.b3.e.a aVar) {
        NicknameInfo nicknameInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (aVar != null && aVar.j() != null && !StringUtils.isNull(this.f12658h)) {
                this.f12657g = aVar.j().getUserIdLong();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.f12657g)));
                this.a = this.f12657g == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            }
            this.i.n();
            h hVar = this.p;
            if (hVar != null) {
                hVar.h(aVar);
            }
            if (aVar != null) {
                this.i.k(aVar);
            }
            k kVar = this.m;
            if (kVar != null) {
                kVar.o(aVar);
            } else {
                k kVar2 = new k(this.f12653c, this, this.f12656f, this.f12657g, this.a);
                this.m = kVar2;
                kVar2.k(TbadkCoreApplication.getInst().getSkinType());
                this.m.j(this.o);
                this.m.o(aVar);
            }
            if (!this.r || aVar == null || (nicknameInfo = aVar.A) == null || nicknameInfo.left_days == null || aVar.j() == null) {
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
            new c.a.p0.y2.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new c(this));
        }
    }

    public boolean k(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || m.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (c.a.o0.r.j0.b.k().h(c.a.o0.r.j0.b.o(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f12652b).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public f l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i : (f) invokeV.objValue;
    }

    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!TbadkCoreApplication.isLogin() && this.a) {
                this.i.A();
            } else if (l.A()) {
                c.a.p0.b3.b.d().m(System.currentTimeMillis());
                this.i.w(false, -1);
                this.i.B(true);
                this.j.L(this.f12657g);
                this.j.K(this.f12657g, this.f12658h);
            } else {
                this.i.n();
                this.i.s(8);
                this.i.x(this.f12653c.getString(R.string.obfuscated_res_0x7f0f0c15), true);
            }
        }
    }

    public h m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.p : (h) invokeV.objValue;
    }

    public c.a.p0.b3.d.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m : (c.a.p0.b3.d.b) invokeV.objValue;
    }

    public i o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (i) invokeV.objValue;
    }

    public c.a.p0.b3.e.a p(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            if (z) {
                this.r = z;
                if (l.A()) {
                    this.j.K(this.f12657g, this.f12658h);
                }
            }
            return this.j.J();
        }
        return (c.a.p0.b3.e.a) invokeZ.objValue;
    }

    public PersonPolymericModel q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.j : (PersonPolymericModel) invokeV.objValue;
    }

    public List<c.a.d.o.e.n> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.j.J() == null) {
                return null;
            }
            return this.j.J().k();
        }
        return (List) invokeV.objValue;
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || this.q == i) {
            return;
        }
        k kVar = this.m;
        if (kVar != null) {
            kVar.k(i);
        }
        this.q = i;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.t);
            k kVar = this.m;
            if (kVar != null) {
                kVar.l();
            }
            PersonPolymericModel personPolymericModel = this.j;
            if (personPolymericModel != null) {
                personPolymericModel.destroy();
            }
        }
    }

    public void u(boolean z) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (kVar = this.m) == null) {
            return;
        }
        kVar.m(z);
    }

    public void v() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (kVar = this.m) == null) {
            return;
        }
        kVar.n();
    }

    public void w(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, postWriteCallBackData) == null) {
            if (this.n == null) {
                this.n = new c.a.p0.l0.j(this.f12652b.getPageContext(), (NavigationBarCoverTip) this.f12652b.findViewById(R.id.obfuscated_res_0x7f091525));
            }
            this.n.l(postWriteCallBackData);
        }
    }
}
