package c.a.t0.e1.r2;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.y0;
import c.a.t0.e1.d0;
import c.a.t0.e1.i1;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes7.dex */
public class d extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final CustomMessageListener f16794h;

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f16795i;

    /* renamed from: j  reason: collision with root package name */
    public final c.a.d.c.g.a f16796j;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str) || this.a.f16841b.getFrsViewData() == null) {
                    return;
                }
                FrsViewData frsViewData = this.a.f16841b.getFrsViewData();
                frsViewData.removeThread(str);
                c.a.t0.e1.r2.c cVar = this.a.f16846g;
                if (cVar != null) {
                    cVar.k(str);
                }
                this.a.a.A1(frsViewData.getThreadList(), frsViewData);
                if (c.a.t0.x3.e.i() != null) {
                    c.a.t0.x3.e.i().n(this.a.f16841b.getForumName(), false);
                }
                if (this.a.f16841b != null) {
                    if (c.a.t0.e1.j.g()) {
                        new BdTopToast(this.a.f16841b.getContext()).setIcon(true).setContent(this.a.f16841b.getContext().getString(i1.shield_success)).show((ViewGroup) this.a.f16841b.getRootView());
                    } else {
                        new BdTopToast(this.a.f16841b.getContext()).setIcon(true).setContent(this.a.f16841b.getContext().getString(i1.delete_success)).show((ViewGroup) this.a.f16841b.getRootView());
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ForumManageModel.e eVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e)) {
                d dVar = this.a;
                if (dVar.f16841b == null || dVar.a == null || dVar.f16843d == null || (eVar = (ForumManageModel.e) customResponsedMessage.getData()) == null || TextUtils.isEmpty(eVar.a) || this.a.f16841b.getFrsViewData() == null) {
                    return;
                }
                String str = eVar.a;
                String str2 = eVar.f48205b;
                String str3 = eVar.f48206c;
                if (eVar.f48207d == 4) {
                    FrsViewData frsViewData = this.a.f16841b.getFrsViewData();
                    e2 threadDataById = frsViewData.getThreadDataById(str);
                    frsViewData.removeThreadData(threadDataById);
                    List<c.a.d.n.e.n> topThreadList = frsViewData.getTopThreadList();
                    if (topThreadList == null) {
                        topThreadList = new ArrayList<>();
                    }
                    topThreadList.add(0, threadDataById);
                    this.a.a.A1(frsViewData.getThreadList(), frsViewData);
                    this.a.f16843d.L(frsViewData);
                }
                if (TextUtils.equals(this.a.f16841b.getForumName(), str3)) {
                    c.a.t0.x3.e.i().n(this.a.f16841b.getForumName(), false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
        @Override // c.a.d.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            String errorString;
            int proZone;
            String errorString2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof RequestGetMyPostNetMessage) {
                    z = ((RequestGetMyPostNetMessage) extra).showErrorToast();
                    if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
                        GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                        if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                            errorString2 = this.a.f16841b.getResources().getString(i1.neterror);
                        } else {
                            errorString2 = getMyPostHttpResponseMessage.getErrorString();
                        }
                        proZone = responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0;
                        if (z || getMyPostHttpResponseMessage.getError() == 0) {
                            this.a.d(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), proZone);
                            return;
                        }
                        return;
                    } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                        GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                        if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                            errorString = this.a.f16841b.getResources().getString(i1.neterror);
                        } else {
                            errorString = getMyPostSocketResponseMessage.getErrorString();
                        }
                        proZone = responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0;
                        if (z || getMyPostSocketResponseMessage.getError() == 0) {
                            this.a.d(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), proZone);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
            z = true;
            if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
            }
        }
    }

    /* renamed from: c.a.t0.e1.r2.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1065d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostWriteCallBackData f16797e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f16798f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f16799g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f16800h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f16801i;

        public RunnableC1065d(d dVar, PostWriteCallBackData postWriteCallBackData, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, postWriteCallBackData, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16801i = dVar;
            this.f16797e = postWriteCallBackData;
            this.f16798f = j2;
            this.f16799g = j3;
            this.f16800h = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int k = c.a.d.f.p.n.k(TbadkCoreApplication.getInst());
                int i2 = c.a.d.f.p.n.i(TbadkCoreApplication.getInst());
                float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setProZone(this.f16797e.getProZone());
                requestGetMyPostNetMessage.setParams(this.f16798f, this.f16799g, this.f16800h, k, i2, f2, i3);
                this.f16801i.f16841b.sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(FrsFragment frsFragment) {
        super(frsFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((FrsFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16794h = new a(this, 2921031);
        this.f16795i = new b(this, 2921316);
        c cVar = new c(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.f16796j = cVar;
        cVar.getSocketMessageListener().setSelfListener(true);
        this.f16796j.getHttpMessageListener().setSelfListener(true);
        this.f16794h.setSelfListener(false);
        this.f16841b.registerListener(this.f16794h);
        this.f16841b.registerListener(this.f16796j);
        this.f16841b.registerListener(this.f16795i);
    }

    public final void b(e2 e2Var, FrsNewAreaFragment frsNewAreaFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, e2Var, frsNewAreaFragment) == null) {
            frsNewAreaFragment.addThreadData(e2Var);
        }
    }

    public final void c(y0 y0Var) {
        FrsViewData frsViewData;
        ArrayList<c.a.d.n.e.n> threadList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y0Var) == null) || (frsViewData = this.f16841b.getFrsViewData()) == null) {
            return;
        }
        this.f16844e.G(y0Var);
        if (this.f16844e.t0()) {
            ArrayList<c.a.d.n.e.n> arrayList = new ArrayList<>();
            arrayList.add(y0Var);
            threadList = this.f16846g.c(false, true, arrayList, null, true);
        } else {
            threadList = frsViewData.getThreadList();
        }
        if (threadList != null) {
            frsViewData.setThreadList(threadList);
            frsViewData.checkLiveStageInThreadList();
            this.a.A1(threadList, frsViewData);
        }
    }

    public final void d(int i2, String str, GetMyPostResIdl getMyPostResIdl, int i3) {
        DataRes dataRes;
        User_Info user_Info;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, getMyPostResIdl, Integer.valueOf(i3)}) == null) {
            if (i2 != 0) {
                this.f16841b.showToast(str);
                return;
            }
            FrsViewData frsViewData = this.f16841b.getFrsViewData();
            if (frsViewData == null || frsViewData.getForum() == null || getMyPostResIdl == null || this.a == null || this.f16844e == null || (dataRes = getMyPostResIdl.data) == null || dataRes.thread_info == null) {
                return;
            }
            y0 y0Var = new y0();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            e(builder2, getMyPostResIdl.data.user_info);
            User user = builder.author;
            if (user == null || TextUtils.isEmpty(user.name)) {
                builder.author = builder2.build(true);
            }
            User user2 = builder.author;
            if (user2 != null && (user_Info = getMyPostResIdl.data.user_info) != null && user2.name.equals(user_Info.name)) {
                builder.author = builder2.build(true);
            }
            builder.cheak_repeat = 1;
            builder.fname = frsViewData.getForum().getName();
            builder.fid = Long.valueOf(c.a.d.f.m.b.g(frsViewData.getForum().getId(), 0L));
            y0Var.d3(builder.build(true));
            f(y0Var, i3);
        }
    }

    public final void e(User.Builder builder, User_Info user_Info) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, builder, user_Info) == null) || user_Info == null) {
            return;
        }
        Long l = user_Info.id;
        builder.id = l;
        builder.gender = user_Info.gender;
        builder.type = user_Info.type;
        builder.name = user_Info.name;
        builder.name_show = user_Info.name_show;
        if (l.longValue() == TbadkCoreApplication.getCurrentAccountId()) {
            builder.portrait = TbadkCoreApplication.getCurrentPortrait();
        } else {
            builder.portrait = user_Info.portrait;
        }
        builder.god_data = user_Info.god_data;
        builder.fans_num = user_Info.fans_num;
        builder.fans_nickname = user_Info.fans_nickname;
        builder.is_bawu = user_Info.is_bawu;
        builder.bawu_type = user_Info.bawu_type;
        builder.new_god_data = user_Info.new_god_data;
        builder.business_account_info = user_Info.business_account_info;
    }

    public final void f(y0 y0Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, y0Var, i2) == null) {
            if (i2 == 1) {
                FrsTabViewController.o A = this.f16841b.getTabController().A();
                if (A != null) {
                    Fragment fragment = A.f43769b;
                    if (fragment instanceof FrsCommonTabFragment) {
                        ((FrsCommonTabFragment) fragment).addThreadData(y0Var);
                    }
                }
            } else if (i2 == 2) {
                FrsTabViewController.o H = this.f16841b.getTabController().H(301);
                if (H == null || !(H.f43769b instanceof FrsGoodFragment)) {
                    return;
                }
                this.f16842c.b(301);
                ((FrsGoodFragment) H.f43769b).addThreadData(y0Var);
            } else if (y0Var.k1() > 0) {
                FrsTabViewController.o H2 = this.f16841b.getTabController().H(y0Var.k1());
                if (H2 != null) {
                    Fragment fragment2 = H2.f43769b;
                    if (fragment2 instanceof FrsCommonTabFragment) {
                        ((FrsCommonTabFragment) fragment2).addThreadData(y0Var);
                    }
                }
            } else {
                if (!ListUtils.isEmpty(y0Var.v0())) {
                    y0Var.K1();
                }
                FrsTabViewController.o H3 = this.f16841b.getTabController().H(this.f16841b.getTabController().D());
                if (H3 != null) {
                    Fragment fragment3 = H3.f43769b;
                    if (fragment3 instanceof FrsNewAreaFragment) {
                        b(y0Var, (FrsNewAreaFragment) fragment3);
                    } else {
                        c(y0Var);
                    }
                }
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, postWriteCallBackData) == null) || (frsModelController = this.f16844e) == null) {
            return;
        }
        boolean z = frsModelController.d0() != null && this.f16844e.d0().getIsBrandForum();
        int R = this.f16844e.R();
        if (R == 2 || R == 3 || R == 7 || R == 8 || z) {
            if ((d0.a().b(1) != null ? this.f16844e.V() : 0) != 0 || postWriteCallBackData == null) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(postWriteCallBackData.getPostId(), 0L);
            long g3 = c.a.d.f.m.b.g(postWriteCallBackData.getThreadId(), 0L);
            long g4 = c.a.d.f.m.b.g(this.f16841b.getForumId(), 0L);
            if (g2 != 0 && g3 != 0 && g4 != 0) {
                c.a.d.f.m.e.a().postDelayed(new RunnableC1065d(this, postWriteCallBackData, g3, g2, g4), 1000L);
                return;
            }
            WriteData writeData = postWriteCallBackData.writeDataForVideo;
            if (writeData != null) {
                y0 y0Var = new y0();
                y0Var.T2(writeData);
                f(y0Var, writeData.getProZone());
            }
        }
    }
}
