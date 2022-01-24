package c.a.t0.e1.r2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.e2;
import c.a.s0.s.s.a;
import c.a.t0.e1.i1;
import c.a.t0.e1.q;
import c.a.t0.e1.z2.r;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class a extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.e1.r2.d f16775h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.e1.q1.a.e f16776i;

    /* renamed from: j  reason: collision with root package name */
    public final CustomMessageListener f16777j;
    public final CustomMessageListener k;

    /* renamed from: c.a.t0.e1.r2.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1063a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1063a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                if (this.a.f16775h != null) {
                    this.a.f16775h.g(postWriteCallBackData);
                }
                if (!this.a.l(postWriteCallBackData)) {
                    this.a.e(postWriteCallBackData);
                } else {
                    c.a.s0.t.h.b.c(this.a.f16841b.getTbPageContext(), postWriteCallBackData, 1);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.t0.e1.q1.b.a)) {
                this.a.f16776i.B(((c.a.t0.e1.q1.b.a) customResponsedMessage.getData()).a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f16778e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f16779f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f16780g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f16781h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f16782i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ ShareFromPBMsgData f16783j;
        public final /* synthetic */ a k;

        public c(a aVar, Thread2GroupShareView thread2GroupShareView, long j2, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, thread2GroupShareView, Long.valueOf(j2), str, str2, str3, shareFromPBMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = aVar;
            this.f16778e = thread2GroupShareView;
            this.f16779f = j2;
            this.f16780g = str;
            this.f16781h = str2;
            this.f16782i = str3;
            this.f16783j = shareFromPBMsgData;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.k.f16841b.getActivity().getSystemService("input_method");
                c.a.d.f.p.n.w(this.k.f16841b.getActivity(), this.f16778e.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.k.f16841b.getActivity(), this.f16779f, this.f16780g, this.f16781h, this.f16782i, 0, this.f16778e.getLeaveMsg(), this.f16783j.toChatMessageContent())));
                aVar.dismiss();
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem == null || shareItem.e() == null) {
                    return;
                }
                Bundle e2 = shareItem.e();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_type", e2.getInt("obj_type")).param("obj_param1", 3).param("fid", e2.getString("fid")).param("tid", e2.getString("tid")));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f16784e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16785f;

        public d(a aVar, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16785f = aVar;
            this.f16784e = thread2GroupShareView;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.d.f.p.n.w(this.f16785f.f16841b.getActivity(), this.f16784e.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FrsFragment frsFragment) {
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
        this.f16777j = new C1063a(this, 2001383);
        this.k = new b(this, 2921662);
        this.f16775h = this.f16841b.getFrsPostController();
        this.f16777j.setTag(this.f16841b.getPageContext().getUniqueId());
        this.f16777j.setSelfListener(true);
        this.f16841b.registerListener(this.f16777j);
        this.k.setTag(this.f16841b.getUniqueId());
        this.k.setSelfListener(true);
        this.f16841b.registerListener(this.k);
        this.f16776i = new c.a.t0.e1.q1.a.e(this.f16841b);
    }

    public static void q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11959");
        statisticItem.param("tid", str);
        statisticItem.param("fid", str2);
        statisticItem.param("obj_type", 1);
        TiebaStatic.log(statisticItem);
    }

    public final boolean e(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || c.a.d.f.p.m.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (c.a.s0.s.i0.b.k().h(c.a.s0.s.i0.b.o(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f16841b.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f16775h == null) {
            this.f16775h = this.f16841b.getFrsPostController();
        }
    }

    public final ShareFromPBMsgData g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
            if (shareItem == null) {
                return null;
            }
            Uri uri = shareItem.v;
            String uri2 = uri == null ? "https://tb5.bdstatic.com/yunying/tieba_logo.jpg" : uri.toString();
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            shareFromPBMsgData.setTitle(shareItem.r);
            shareFromPBMsgData.setContent(shareItem.D);
            shareFromPBMsgData.setImageUrl(uri2);
            shareFromPBMsgData.setForumName(shareItem.p);
            shareFromPBMsgData.setThreadId(shareItem.K);
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeV.objValue;
    }

    public final void h(FrsViewData frsViewData, Intent intent, String str) {
        ArrayList<c.a.d.n.e.n> e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, frsViewData, intent, str) == null) || frsViewData == null || intent == null || TextUtils.isEmpty(str) || this.f16844e == null) {
            return;
        }
        int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        if (this.f16844e.t0()) {
            Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
            if (!(serializableExtra instanceof CardHListViewData) || (e2 = this.f16846g.e()) == null) {
                return;
            }
            CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
            cardHListViewData.threadId = str;
            if (c.a.t0.e1.u2.b.a(e2, str, cardHListViewData, intExtra)) {
                frsViewData.setThreadList(e2);
                this.a.A1(e2, frsViewData);
                q(str, this.f16841b.getForumId());
            }
        }
    }

    public final void i(int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i2, intent) == null) && i2 == 18003) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public final void j(int i2, Intent intent) {
        e2 threadDataById;
        ShareItem shareItem;
        c.a.t0.e1.a3.h hVar;
        c.a.t0.e1.a3.d X;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, intent) == null) {
            FrsViewData frsViewData = this.f16841b.getFrsViewData();
            switch (i2) {
                case 11001:
                    this.f16841b.writeBlog(0);
                    return;
                case 11002:
                    this.f16843d.l0(true);
                    return;
                case 11011:
                    FrsFragment frsFragment = this.f16841b;
                    String threadId = frsFragment.getThreadId();
                    FrsFragment frsFragment2 = this.f16841b;
                    r.f(frsFragment, threadId, frsFragment2.mThreadData, frsFragment2.isAds());
                    return;
                case 11012:
                    FrsFragment frsFragment3 = this.f16841b;
                    String threadId2 = frsFragment3.getThreadId();
                    FrsFragment frsFragment4 = this.f16841b;
                    r.g(frsFragment3, threadId2, frsFragment4.mThreadData, frsFragment4.isAds());
                    return;
                case 11014:
                    this.f16843d.m0();
                    return;
                case 11016:
                    this.a.M1();
                    return;
                case 11036:
                    this.f16843d.n0();
                    return;
                case 18003:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                    this.a.V().notifyDataSetChanged();
                    c.a.t0.e1.a3.h hVar2 = this.f16843d;
                    if (hVar2 != null) {
                        hVar2.Q();
                    }
                    int intExtra = intent.getIntExtra("type", -1);
                    if (intExtra == 4) {
                        this.f16841b.refresh(6);
                        return;
                    }
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra == null || (threadDataById = frsViewData.getThreadDataById(stringExtra)) == null) {
                        return;
                    }
                    if (intExtra == 2) {
                        threadDataById.c4(intent.getIntExtra("good_data", 0));
                        threadDataById.h3();
                    }
                    h(frsViewData, intent, stringExtra);
                    return;
                case 18004:
                    r.d(this.f16841b.getPageContext(), frsViewData);
                    return;
                case 23003:
                    if (intent == null || frsViewData == null) {
                        return;
                    }
                    c.a.t0.e1.z2.n.e(this.f16841b, frsViewData, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                case 23007:
                    k(intent);
                    return;
                case 24002:
                    if (intent == null) {
                        return;
                    }
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == c.a.d.f.m.b.e(this.f16841b.getForumId(), 0)) {
                        this.f16843d.o0(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                case 24007:
                    int intExtra6 = intent.getIntExtra("extra_share_status", 2);
                    if (intExtra6 == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null) {
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                        statisticItem.param("obj_locate", 4);
                        statisticItem.param("tid", shareItem.K);
                        statisticItem.param("pid", intent.getStringExtra("pid"));
                        TiebaStatic.log(statisticItem);
                    }
                    if (intExtra6 == 1) {
                        this.f16841b.onShareSuccess(intent.getStringExtra("tid"));
                        return;
                    }
                    return;
                case 25041:
                    this.f16842c.b(intent.getIntExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1));
                    return;
                case 25050:
                    this.f16841b.refresh();
                    return;
                case 25052:
                    String stringExtra2 = intent.getStringExtra("group_name");
                    boolean booleanExtra = intent.getBooleanExtra("from", true);
                    this.f16841b.showTopToastRule(stringExtra2);
                    if (booleanExtra || (hVar = this.f16843d) == null) {
                        return;
                    }
                    hVar.J();
                    return;
                case 25054:
                    q frsView = this.f16841b.getFrsView();
                    if (frsView == null || (X = frsView.X()) == null) {
                        return;
                    }
                    X.C();
                    return;
                default:
                    return;
            }
        }
    }

    public final void k(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, intent) == null) {
            long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
            String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
            String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
            p(g(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
        }
    }

    public final boolean l(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, postWriteCallBackData)) == null) ? (postWriteCallBackData == null || postWriteCallBackData.getIconStampData() == null) ? false : true : invokeL.booleanValue;
    }

    public void m(int i2) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (frsFragment = this.f16841b) == null || frsFragment.getTabController() == null) {
            return;
        }
        if (i2 > 0) {
            FrsTabViewController.o H = this.f16841b.getTabController().H(i2);
            if (H == null || !(H.f43769b instanceof FrsCommonTabFragment)) {
                return;
            }
            this.f16842c.b(i2);
            return;
        }
        int D = this.f16841b.getTabController().D();
        if (this.f16841b.getTabController().H(D) != null) {
            this.f16842c.b(D);
        }
    }

    public void n(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i2, i3, intent) == null) {
            f();
            if (c.a.s0.e1.a.c(i2, i3, intent)) {
                return;
            }
            if (i3 == -1) {
                j(i2, intent);
            } else if (i3 == 0) {
                i(i2, intent);
            }
            c.a.t0.e1.q1.a.e eVar = this.f16776i;
            if (eVar == null || eVar.r() == null) {
                return;
            }
            this.f16776i.r().a(i2, i3, intent);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f16777j);
            c.a.t0.e1.q1.a.e eVar = this.f16776i;
            if (eVar != null) {
                eVar.p();
            }
        }
    }

    public final void p(ShareFromPBMsgData shareFromPBMsgData, long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{shareFromPBMsgData, Long.valueOf(j2), str, str2, str3}) == null) || shareFromPBMsgData == null) {
            return;
        }
        c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.f16841b.getActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.f16841b.getActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(i1.share, new c(this, thread2GroupShareView, j2, str, str2, str3, shareFromPBMsgData));
        aVar.setNegativeButton(i1.cancel, new d(this, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(this.f16841b.getPageContext()).show();
        if (c.a.d.f.p.m.isEmpty(shareFromPBMsgData.getImageUrl())) {
            return;
        }
        thread2GroupShareView.loadImageIcon(shareFromPBMsgData.getImageUrl(), false);
    }
}
