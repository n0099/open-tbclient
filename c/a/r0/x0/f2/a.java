package c.a.r0.x0.f2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import c.a.q0.s.s.a;
import c.a.r0.x0.q;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
import com.baidu.tieba.R;
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
/* loaded from: classes4.dex */
public class a extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public d f26804h;

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f26805i;

    /* renamed from: c.a.r0.x0.f2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1258a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26806a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1258a(a aVar, int i2) {
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
            this.f26806a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                if (this.f26806a.f26804h != null) {
                    this.f26806a.f26804h.g(postWriteCallBackData);
                }
                if (!this.f26806a.k(postWriteCallBackData)) {
                    this.f26806a.d(postWriteCallBackData);
                } else {
                    c.a.q0.t.h.b.a(this.f26806a.f26896b.getTbPageContext(), postWriteCallBackData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f26807e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f26808f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f26809g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f26810h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f26811i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ ShareFromPBMsgData f26812j;
        public final /* synthetic */ a k;

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
            this.k = aVar;
            this.f26807e = thread2GroupShareView;
            this.f26808f = j2;
            this.f26809g = str;
            this.f26810h = str2;
            this.f26811i = str3;
            this.f26812j = shareFromPBMsgData;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.k.f26896b.getActivity().getSystemService("input_method");
                c.a.e.e.p.l.x(this.k.f26896b.getActivity(), this.f26807e.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.k.f26896b.getActivity(), this.f26808f, this.f26809g, this.f26810h, this.f26811i, 0, this.f26807e.getLeaveMsg(), this.f26812j.toChatMessageContent())));
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

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f26813e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f26814f;

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
            this.f26814f = aVar;
            this.f26813e = thread2GroupShareView;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.e.e.p.l.x(this.f26814f.f26896b.getActivity(), this.f26813e.getChatMsgView());
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
        this.f26805i = new C1258a(this, 2001383);
        this.f26804h = this.f26896b.getFrsPostController();
        this.f26805i.setTag(this.f26896b.getPageContext().getUniqueId());
        this.f26805i.setSelfListener(true);
        this.f26896b.registerListener(this.f26805i);
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
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || c.a.e.e.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (c.a.q0.s.d0.b.j().g(c.a.q0.s.d0.b.n(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f26896b.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f26804h == null) {
            this.f26804h = this.f26896b.getFrsPostController();
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
        ArrayList<c.a.e.l.e.n> e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, frsViewData, intent, str) == null) || frsViewData == null || intent == null || TextUtils.isEmpty(str) || this.f26899e == null) {
            return;
        }
        int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        if (this.f26899e.u0()) {
            Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
            if (!(serializableExtra instanceof CardHListViewData) || (e2 = this.f26901g.e()) == null) {
                return;
            }
            CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
            cardHListViewData.threadId = str;
            if (c.a.r0.x0.i2.b.a(e2, str, cardHListViewData, intExtra)) {
                frsViewData.setThreadList(e2);
                this.f26895a.B1(e2, frsViewData);
                p(str, this.f26896b.getForumId());
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
        c.a.r0.x0.o2.h hVar;
        c.a.r0.x0.o2.d Y;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, intent) == null) {
            FrsViewData frsViewData = this.f26896b.getFrsViewData();
            switch (i2) {
                case CyberPlayerManager.MEDIA_INFO_DISABLE_FILECACHE /* 11001 */:
                    this.f26896b.writeBlog(0);
                    return;
                case CyberPlayerManager.MEDIA_INFO_KERNEL_NET_TRAFFIC /* 11002 */:
                    this.f26898d.s0(true);
                    return;
                case 11011:
                    FrsFragment frsFragment = this.f26896b;
                    String threadId = frsFragment.getThreadId();
                    FrsFragment frsFragment2 = this.f26896b;
                    c.a.r0.x0.n2.m.f(frsFragment, threadId, frsFragment2.mThreadData, frsFragment2.isAds());
                    return;
                case 11012:
                    FrsFragment frsFragment3 = this.f26896b;
                    String threadId2 = frsFragment3.getThreadId();
                    FrsFragment frsFragment4 = this.f26896b;
                    c.a.r0.x0.n2.m.g(frsFragment3, threadId2, frsFragment4.mThreadData, frsFragment4.isAds());
                    return;
                case 11014:
                    this.f26898d.t0();
                    return;
                case 11016:
                    this.f26895a.N1();
                    return;
                case 11036:
                    this.f26898d.u0();
                    return;
                case 18003:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                    this.f26895a.W().notifyDataSetChanged();
                    c.a.r0.x0.o2.h hVar2 = this.f26898d;
                    if (hVar2 != null) {
                        hVar2.X();
                    }
                    int intExtra = intent.getIntExtra("type", -1);
                    if (intExtra == 4) {
                        this.f26896b.refresh(6);
                        return;
                    }
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra == null || (threadDataById = frsViewData.getThreadDataById(stringExtra)) == null) {
                        return;
                    }
                    if (intExtra == 2) {
                        threadDataById.W3(intent.getIntExtra("good_data", 0));
                        threadDataById.c3();
                    }
                    g(frsViewData, intent, stringExtra);
                    return;
                case 18004:
                    c.a.r0.x0.n2.m.d(this.f26896b.getPageContext(), frsViewData);
                    return;
                case 23003:
                    if (intent == null || frsViewData == null) {
                        return;
                    }
                    c.a.r0.x0.n2.i.b(this.f26896b, frsViewData, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (intExtra2 == c.a.e.e.m.b.e(this.f26896b.getForumId(), 0)) {
                        this.f26898d.v0(intExtra3, intExtra4, intExtra5);
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
                        this.f26896b.onShareSuccess(intent.getStringExtra("tid"));
                        return;
                    }
                    return;
                case 25041:
                    this.f26897c.b(intent.getIntExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1));
                    return;
                case 25050:
                    this.f26896b.refresh();
                    return;
                case 25052:
                    String stringExtra2 = intent.getStringExtra("group_name");
                    boolean booleanExtra = intent.getBooleanExtra("from", true);
                    this.f26896b.showTopToastRule(stringExtra2);
                    if (booleanExtra || (hVar = this.f26898d) == null) {
                        return;
                    }
                    hVar.Q();
                    return;
                case 25054:
                    q frsView = this.f26896b.getFrsView();
                    if (frsView == null || (Y = frsView.Y()) == null) {
                        return;
                    }
                    Y.C();
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
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (frsFragment = this.f26896b) == null || frsFragment.getTabController() == null) {
            return;
        }
        if (i2 > 0) {
            FrsTabViewController.o G = this.f26896b.getTabController().G(i2);
            if (G == null || !(G.f51682b instanceof FrsCommonTabFragment)) {
                return;
            }
            this.f26897c.b(i2);
            return;
        }
        int C = this.f26896b.getTabController().C();
        if (this.f26896b.getTabController().G(C) != null) {
            this.f26897c.b(C);
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
            MessageManager.getInstance().unRegisterListener(this.f26805i);
        }
    }

    public final void o(ShareFromPBMsgData shareFromPBMsgData, long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{shareFromPBMsgData, Long.valueOf(j2), str, str2, str3}) == null) || shareFromPBMsgData == null) {
            return;
        }
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f26896b.getActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.f26896b.getActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.share, new b(this, thread2GroupShareView, j2, str, str2, str3, shareFromPBMsgData));
        aVar.setNegativeButton(R.string.cancel, new c(this, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(this.f26896b.getPageContext()).show();
        if (c.a.e.e.p.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
            return;
        }
        thread2GroupShareView.loadImageIcon(shareFromPBMsgData.getImageUrl(), false);
    }
}
