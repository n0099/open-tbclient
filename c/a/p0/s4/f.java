package c.a.p0.s4;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.o0.r.t.a;
import c.a.o0.s.c.n0;
import c.a.p0.s4.a;
import c.a.p0.s4.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.BjhMasterActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishManager;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsPublishFineGoodsDialogView;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ItemInfo;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f18287b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.s4.a f18288c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18289d;

    /* renamed from: e  reason: collision with root package name */
    public g f18290e;

    /* renamed from: f  reason: collision with root package name */
    public ForumWriteData f18291f;

    /* renamed from: g  reason: collision with root package name */
    public int f18292g;

    /* renamed from: h  reason: collision with root package name */
    public String f18293h;
    public String i;
    public int j;
    public String k;
    public int l;
    public boolean m;
    @Nullable
    public final n0 n;
    public g.a o;
    public ItemInfo p;

    /* loaded from: classes2.dex */
    public class a implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // c.a.p0.s4.g.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 1) {
                    this.a.f18289d = true;
                    c.a.o0.i0.g.c.b().c();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
                } else if (i == 4) {
                    this.a.f18289d = false;
                    c.a.o0.i0.g.c.b().o();
                    if (this.a.f18288c.a.getParent() == this.a.f18287b && this.a.f18287b != null && this.a.f18288c.a != null && this.a.f18287b.indexOfChild(this.a.f18288c.a) > 0) {
                        this.a.f18287b.removeView(this.a.f18288c.a);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f18294b;

        public b(f fVar, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18294b = fVar;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.o0.r.t.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.dismiss();
            c.a.o0.r.j0.b.k().u("commodity_goods_show_first_dialog", true);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_CLICK).param("obj_locate", 1).param("fid", this.f18294b.f18291f.forumId).param("fname", this.f18294b.f18291f.forumName));
            String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=10"));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumWriteData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18295b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f18296c;

        public d(f fVar, ForumWriteData forumWriteData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, forumWriteData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18296c = fVar;
            this.a = forumWriteData;
            this.f18295b = str;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                c.a.d.f.i.a.n().j(false);
                ForumWriteData forumWriteData = this.a;
                if (forumWriteData != null) {
                    String str4 = forumWriteData.forumId;
                    String str5 = forumWriteData.forumName;
                    str3 = forumWriteData.specialForumType;
                    str = str4;
                    str2 = str5;
                } else {
                    str = "0";
                    str2 = null;
                    str3 = null;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.f18295b).param("obj_type", 4));
                if (this.f18296c.j != 1) {
                    if (this.f18296c.j == 2) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.FRS_PUBLISH_ALA_CLICK).param("fid", str));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.HOME_PUBLISH_ALA_CLICK));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(this.f18296c.a.getPageActivity(), str2, str, TbadkCoreApplication.getCurrentAccount(), str3)));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IntentConfig a;

        public e(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {intentConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = intentConfig;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.a));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str, @Nullable n0 n0Var) {
        this(tbPageContext, viewGroup, str, 1, n0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, str, n0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (ViewGroup) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue(), (n0) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean B(Activity activity, IntentConfig intentConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, activity, intentConfig)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.setOnPermissionsGrantedListener(new e(intentConfig));
            return permissionJudgePolicy.startRequestPermission(activity);
        }
        return invokeLL.booleanValue;
    }

    public void A(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, tbPageContext, str, forumWriteData) == null) || tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.CAMERA");
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.RECORD_AUDIO");
        permissionJudgePolicy.setOnPermissionsGrantedListener(new d(this, forumWriteData, str));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }

    public void C() {
        c.a.p0.s4.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f18288c) == null) {
            return;
        }
        aVar.a();
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.m = z;
        }
    }

    public void E(ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, forumWriteData) == null) {
            this.f18291f = forumWriteData;
        }
    }

    public void F(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, itemInfo) == null) {
            this.p = itemInfo;
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            c.a.p0.s4.a aVar = this.f18288c;
            if (aVar instanceof a.c) {
                ((a.c) aVar).g(z);
            }
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.k = str;
        }
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            c.a.p0.s4.a aVar = this.f18288c;
            if (aVar instanceof a.c) {
                ((a.c) aVar).G.setIconFade(i);
            }
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.f18293h = str;
        }
    }

    public void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.l = i;
        }
    }

    public void L(boolean z, View view, View view2) {
        AntiData antiData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), view, view2}) == null) || this.f18287b == null) {
            return;
        }
        if (this.f18288c.a.getParent() == null) {
            c.a.o0.f0.e.a(this.f18287b).a(this.f18287b, this.f18288c.a, z);
        }
        this.f18290e.a(view, view2);
        this.f18290e.f();
        TiebaStatic.log(new StatisticItem("c12052").param("obj_locate", this.k));
        if (l.x()) {
            String q = c.a.o0.r.j0.b.k().q("key_baidu_sim_card_writting_tip", "");
            if (!m.isEmpty(q)) {
                BdToast.c(this.a.getContext(), q).q();
                c.a.o0.r.j0.b.k().D("key_baidu_sim_card_writting_tip");
            }
        }
        ForumWriteData forumWriteData = this.f18291f;
        if (forumWriteData == null || (antiData = forumWriteData.antiData) == null || !antiData.getCanGoods()) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_SHOW).param("obj_locate", 1).param("fid", this.f18291f.forumId).param("fname", this.f18291f.forumName));
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : invokeV.intValue;
    }

    @Nullable
    public ForumWriteData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f18291f : (ForumWriteData) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    @NonNull
    public n0 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            n0 n0Var = this.n;
            return n0Var != null ? n0Var : n0.f11234b;
        }
        return (n0) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f18293h : (String) invokeV.objValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        FrsTabInfoData frsTabInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ForumWriteData forumWriteData = this.f18291f;
            if (forumWriteData != null && (frsTabInfoData = forumWriteData.frsTabInfo) != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
                for (FrsTabItemData frsTabItemData : this.f18291f.frsTabInfo.tabList) {
                    if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f18290e.b(z);
            if (z) {
                return;
            }
            c.a.p0.s4.a aVar = this.f18288c;
            if (aVar instanceof a.c) {
                ((a.c) aVar).G.h();
            }
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f18289d : invokeV.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getPageActivity(), "", true, true);
            if (this.f18291f != null) {
                albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f18291f.forumId);
                albumFloatActivityConfig.getIntent().putExtra("forum_name", this.f18291f.forumName);
                albumFloatActivityConfig.setProfessionZone(this.f18291f.defaultZone);
                albumFloatActivityConfig.setFrsTabInfo(this.f18291f.frsTabInfo);
                albumFloatActivityConfig.setCanChangeBarName(false);
                albumFloatActivityConfig.setBarName(this.f18291f.forumName);
                albumFloatActivityConfig.setBarID(this.f18291f.forumId);
                ForumWriteData forumWriteData = this.f18291f;
                albumFloatActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
            }
            albumFloatActivityConfig.getIntent().putExtra("from", this.i);
            albumFloatActivityConfig.getIntent().putExtra("write_title", this.f18293h);
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.setCanSelectVideo(true);
            albumFloatActivityConfig.setCanSelectOnlyVideo(true);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setFromWrite(4);
            albumFloatActivityConfig.setCallFrom("2");
            albumFloatActivityConfig.setStatisticFrom(this.j);
            if (B(this.a.getPageActivity(), albumFloatActivityConfig)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public void p(c.a.d.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            if (i.b()) {
                ForumWriteData forumWriteData = this.f18291f;
                if (forumWriteData != null) {
                    i.f(fVar, null, null, forumWriteData.forumId, forumWriteData.forumName, 4, Boolean.FALSE, "", "", "");
                    return;
                } else {
                    i.f(fVar, null, null, null, null, 4, Boolean.TRUE, "", "", "");
                    return;
                }
            }
            o();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            m(false);
            if (Build.VERSION.SDK_INT < 21) {
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getPageActivity());
                aVar.setAutoNight(false);
                aVar.setTitle(R.string.obfuscated_res_0x7f0f0ee9);
                aVar.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f04da));
                aVar.setTitleShowCenter(true);
                aVar.setMessageShowCenter(true);
                aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f0984, new c(this));
                aVar.create(this.a).show();
                return;
            }
            A(this.a, this.k, this.f18291f);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            m(false);
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 2));
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getPageActivity(), "", true, true);
            if (this.f18291f != null) {
                albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f18291f.forumId);
                albumFloatActivityConfig.getIntent().putExtra("forum_name", this.f18291f.forumName);
                albumFloatActivityConfig.setProfessionZone(this.f18291f.defaultZone);
                albumFloatActivityConfig.setFrsTabInfo(this.f18291f.frsTabInfo);
                ForumWriteData forumWriteData = this.f18291f;
                albumFloatActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
            }
            albumFloatActivityConfig.getIntent().putExtra("from", this.i);
            albumFloatActivityConfig.getIntent().putExtra("write_title", this.f18293h);
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.setCanSelectVideo(false);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setFromWrite(4);
            albumFloatActivityConfig.setCallFrom("2");
            albumFloatActivityConfig.getIntent().putExtra(WriteActivityConfig.RICH_MODE_ENABLE, true);
            albumFloatActivityConfig.setStatisticFrom(this.j);
            if (B(this.a.getPageActivity(), albumFloatActivityConfig)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            m(false);
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 1));
            WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumWriteData(this.f18291f).setFrom(this.i).setTitle(str).setCallFrom("2").setStatisticFrom(this.j).setRichModeEnable(true).send();
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i) == null) || this.f18292g == i) {
            return;
        }
        this.f18292g = i;
        this.f18288c.c(i);
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (!l()) {
                BdToast.i(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0e99), R.drawable.obfuscated_res_0x7f08099f, true).q();
            } else if (!this.m) {
                BdToast.i(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0e9a), R.drawable.obfuscated_res_0x7f08099f, true).q();
            } else {
                if (this.f18291f != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 1).param("fid", this.f18291f.forumId).param("fname", this.f18291f.forumName));
                }
                m(false);
                if (!c.a.o0.r.j0.b.k().h("commodity_goods_show_first_dialog", false)) {
                    c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getPageActivity());
                    aVar.setContentViewSize(2);
                    aVar.setCanceledOnTouchOutside(false);
                    FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.a.getPageActivity());
                    frsPublishFineGoodsDialogView.setConfirmButtonListener(new b(this, aVar));
                    aVar.setContentView(frsPublishFineGoodsDialogView);
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_SHOW).param("obj_locate", 1);
                    ForumWriteData forumWriteData = this.f18291f;
                    StatisticItem param2 = param.param("fid", forumWriteData != null ? forumWriteData.forumId : "");
                    ForumWriteData forumWriteData2 = this.f18291f;
                    TiebaStatic.log(param2.param("fname", forumWriteData2 != null ? forumWriteData2.forumName : ""));
                    aVar.create(this.a).show();
                    return;
                }
                String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=10"));
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            View view = this.f18288c.a;
            if (view != null) {
                ViewParent parent = view.getParent();
                ViewGroup viewGroup = this.f18287b;
                if (parent == viewGroup) {
                    viewGroup.removeView(this.f18288c.a);
                }
            }
            this.f18290e.d();
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            WorkPublishManager.setObjLocate("");
            m(false);
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 3));
            int a2 = i.a();
            if (i.c(a2)) {
                i.e(this.a.getPageActivity(), a2, i);
            } else if (i.b()) {
                ForumWriteData forumWriteData = this.f18291f;
                if (forumWriteData != null) {
                    i.g(null, null, forumWriteData.forumId, forumWriteData.forumName, i, Boolean.FALSE);
                } else {
                    i.g(null, null, null, null, i, Boolean.TRUE);
                }
            } else {
                o();
            }
        }
    }

    public void x(@Nullable String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, str2) == null) {
            m(false);
            new BjhMasterActivityConfig(TbadkCoreApplication.getInst(), str, str2).start();
            ((c.a.o0.i0.c.a) ServiceManager.getService(c.a.o0.i0.c.a.a.a())).c(Long.valueOf(c.a.d.f.m.b.g(str, 0L)), str2);
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 5));
            m(false);
            WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.a.getPageActivity(), 25048);
            writeVoteActivityConfig.setExtraTitle(str);
            if (this.f18291f == null) {
                this.f18291f = new ForumWriteData("0", null, null, null);
            }
            ForumWriteData forumWriteData = this.f18291f;
            forumWriteData.mFrom = this.i;
            forumWriteData.writeCallFrom = "2";
            forumWriteData.statisticFrom = this.j;
            writeVoteActivityConfig.setExtraData(forumWriteData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 1));
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            m(false);
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumWriteData(this.f18291f).setIsEvaluate(true).setFrom(this.i).setCallFrom("2").setStatisticFrom(this.j);
            ItemInfo itemInfo = this.p;
            if (itemInfo != null) {
                statisticFrom.setScoreItemInfo(new SerializableItemInfo(itemInfo)).setItemIsSchool(this.p.is_school.intValue() == 1).setStarCount(this.p.score.comment_star.intValue());
            }
            statisticFrom.send();
        }
    }

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i, @Nullable n0 n0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, str, Integer.valueOf(i), n0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int i4 = 0;
        this.f18289d = false;
        this.f18292g = 3;
        this.f18293h = "";
        this.i = AlbumActivityConfig.FROM_WRITE;
        this.k = "0";
        this.m = false;
        this.o = new a(this);
        this.a = tbPageContext;
        this.f18287b = viewGroup;
        this.i = str;
        if ("main_tab".equals(str)) {
            i4 = 1;
        } else if ("frs".equals(this.i)) {
            i4 = 2;
        }
        this.j = i4;
        this.n = n0Var;
        if (i == 3) {
            a.b bVar = new a.b(this.a, this);
            this.f18288c = bVar;
            this.f18290e = new c.a.p0.s4.e(tbPageContext.getPageActivity(), bVar);
        } else {
            a.c cVar = new a.c(this.a, this);
            this.f18288c = cVar;
            this.f18290e = new c.a.p0.s4.d(tbPageContext.getPageActivity(), cVar);
        }
        t(TbadkCoreApplication.getInst().getSkinType());
        this.f18290e.e(this.o);
    }
}
