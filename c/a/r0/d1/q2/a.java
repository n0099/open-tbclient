package c.a.r0.d1.q2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import c.a.q0.s.s.a;
import c.a.r0.d1.i1;
import c.a.r0.d1.q;
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
/* loaded from: classes5.dex */
public class a extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public d f15807h;

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f15808i;

    /* renamed from: c.a.r0.d1.q2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0956a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0956a(a aVar, int i2) {
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
                if (this.a.f15807h != null) {
                    this.a.f15807h.g(postWriteCallBackData);
                }
                if (!this.a.k(postWriteCallBackData)) {
                    this.a.d(postWriteCallBackData);
                } else {
                    c.a.q0.t.h.b.a(this.a.f15875b.getTbPageContext(), postWriteCallBackData);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f15809e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f15810f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f15811g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f15812h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f15813i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ ShareFromPBMsgData f15814j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ a f15815k;

        public b(a aVar, Thread2GroupShareView thread2GroupShareView, long j2, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
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
            this.f15815k = aVar;
            this.f15809e = thread2GroupShareView;
            this.f15810f = j2;
            this.f15811g = str;
            this.f15812h = str2;
            this.f15813i = str3;
            this.f15814j = shareFromPBMsgData;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.f15815k.f15875b.getActivity().getSystemService("input_method");
                c.a.d.f.p.l.w(this.f15815k.f15875b.getActivity(), this.f15809e.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.f15815k.f15875b.getActivity(), this.f15810f, this.f15811g, this.f15812h, this.f15813i, 0, this.f15809e.getLeaveMsg(), this.f15814j.toChatMessageContent())));
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

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f15816e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15817f;

        public c(a aVar, Thread2GroupShareView thread2GroupShareView) {
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
            this.f15817f = aVar;
            this.f15816e = thread2GroupShareView;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.d.f.p.l.w(this.f15817f.f15875b.getActivity(), this.f15816e.getChatMsgView());
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
        this.f15808i = new C0956a(this, 2001383);
        this.f15807h = this.f15875b.getFrsPostController();
        this.f15808i.setTag(this.f15875b.getPageContext().getUniqueId());
        this.f15808i.setSelfListener(true);
        this.f15875b.registerListener(this.f15808i);
    }

    public static void p(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11959");
        statisticItem.param("tid", str);
        statisticItem.param("fid", str2);
        statisticItem.param("obj_type", 1);
        TiebaStatic.log(statisticItem);
    }

    public final boolean d(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || c.a.d.f.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (c.a.q0.s.e0.b.j().g(c.a.q0.s.e0.b.n(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f15875b.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f15807h == null) {
            this.f15807h = this.f15875b.getFrsPostController();
        }
    }

    public final ShareFromPBMsgData f() {
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

    public final void g(FrsViewData frsViewData, Intent intent, String str) {
        ArrayList<c.a.d.m.e.n> e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, frsViewData, intent, str) == null) || frsViewData == null || intent == null || TextUtils.isEmpty(str) || this.f15878e == null) {
            return;
        }
        int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        if (this.f15878e.u0()) {
            Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
            if (!(serializableExtra instanceof CardHListViewData) || (e2 = this.f15880g.e()) == null) {
                return;
            }
            CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
            cardHListViewData.threadId = str;
            if (c.a.r0.d1.t2.b.a(e2, str, cardHListViewData, intExtra)) {
                frsViewData.setThreadList(e2);
                this.a.A1(e2, frsViewData);
                p(str, this.f15875b.getForumId());
            }
        }
    }

    public final void h(int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i2, intent) == null) && i2 == 18003) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public final void i(int i2, Intent intent) {
        d2 threadDataById;
        ShareItem shareItem;
        c.a.r0.d1.z2.h hVar;
        c.a.r0.d1.z2.d X;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, intent) == null) {
            FrsViewData frsViewData = this.f15875b.getFrsViewData();
            switch (i2) {
                case 11001:
                    this.f15875b.writeBlog(0);
                    return;
                case 11002:
                    this.f15877d.s0(true);
                    return;
                case 11011:
                    FrsFragment frsFragment = this.f15875b;
                    String threadId = frsFragment.getThreadId();
                    FrsFragment frsFragment2 = this.f15875b;
                    c.a.r0.d1.y2.m.f(frsFragment, threadId, frsFragment2.mThreadData, frsFragment2.isAds());
                    return;
                case 11012:
                    FrsFragment frsFragment3 = this.f15875b;
                    String threadId2 = frsFragment3.getThreadId();
                    FrsFragment frsFragment4 = this.f15875b;
                    c.a.r0.d1.y2.m.g(frsFragment3, threadId2, frsFragment4.mThreadData, frsFragment4.isAds());
                    return;
                case 11014:
                    this.f15877d.t0();
                    return;
                case 11016:
                    this.a.M1();
                    return;
                case 11036:
                    this.f15877d.u0();
                    return;
                case 18003:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                    this.a.V().notifyDataSetChanged();
                    c.a.r0.d1.z2.h hVar2 = this.f15877d;
                    if (hVar2 != null) {
                        hVar2.X();
                    }
                    int intExtra = intent.getIntExtra("type", -1);
                    if (intExtra == 4) {
                        this.f15875b.refresh(6);
                        return;
                    }
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra == null || (threadDataById = frsViewData.getThreadDataById(stringExtra)) == null) {
                        return;
                    }
                    if (intExtra == 2) {
                        threadDataById.b4(intent.getIntExtra("good_data", 0));
                        threadDataById.g3();
                    }
                    g(frsViewData, intent, stringExtra);
                    return;
                case 18004:
                    c.a.r0.d1.y2.m.d(this.f15875b.getPageContext(), frsViewData);
                    return;
                case 23003:
                    if (intent == null || frsViewData == null) {
                        return;
                    }
                    c.a.r0.d1.y2.i.b(this.f15875b, frsViewData, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                case 23007:
                    j(intent);
                    return;
                case 24002:
                    if (intent == null) {
                        return;
                    }
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == c.a.d.f.m.b.e(this.f15875b.getForumId(), 0)) {
                        this.f15877d.v0(intExtra3, intExtra4, intExtra5);
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
                        this.f15875b.onShareSuccess(intent.getStringExtra("tid"));
                        return;
                    }
                    return;
                case 25041:
                    this.f15876c.b(intent.getIntExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1));
                    return;
                case 25050:
                    this.f15875b.refresh();
                    return;
                case 25052:
                    String stringExtra2 = intent.getStringExtra("group_name");
                    boolean booleanExtra = intent.getBooleanExtra("from", true);
                    this.f15875b.showTopToastRule(stringExtra2);
                    if (booleanExtra || (hVar = this.f15877d) == null) {
                        return;
                    }
                    hVar.M();
                    return;
                case 25054:
                    q frsView = this.f15875b.getFrsView();
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

    public final void j(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, intent) == null) {
            long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
            String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
            String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
            o(f(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
        }
    }

    public final boolean k(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, postWriteCallBackData)) == null) ? (postWriteCallBackData == null || postWriteCallBackData.getIconStampData() == null) ? false : true : invokeL.booleanValue;
    }

    public void l(int i2) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (frsFragment = this.f15875b) == null || frsFragment.getTabController() == null) {
            return;
        }
        if (i2 > 0) {
            FrsTabViewController.o G = this.f15875b.getTabController().G(i2);
            if (G == null || !(G.f44719b instanceof FrsCommonTabFragment)) {
                return;
            }
            this.f15876c.b(i2);
            return;
        }
        int C = this.f15875b.getTabController().C();
        if (this.f15875b.getTabController().G(C) != null) {
            this.f15876c.b(C);
        }
    }

    public void m(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i2, i3, intent) == null) {
            e();
            if (i3 == -1) {
                i(i2, intent);
            } else if (i3 == 0) {
                h(i2, intent);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f15808i);
        }
    }

    public final void o(ShareFromPBMsgData shareFromPBMsgData, long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{shareFromPBMsgData, Long.valueOf(j2), str, str2, str3}) == null) || shareFromPBMsgData == null) {
            return;
        }
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f15875b.getActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.f15875b.getActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(i1.share, new b(this, thread2GroupShareView, j2, str, str2, str3, shareFromPBMsgData));
        aVar.setNegativeButton(i1.cancel, new c(this, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(this.f15875b.getPageContext()).show();
        if (c.a.d.f.p.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
            return;
        }
        thread2GroupShareView.loadImageIcon(shareFromPBMsgData.getImageUrl(), false);
    }
}
