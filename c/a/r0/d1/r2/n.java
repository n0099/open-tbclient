package c.a.r0.d1.r2;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.r.t.a;
import c.a.r0.y3.y;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsLikeShareDialogView;
import com.baidu.tieba.frs.view.FrsPrivateShareDialogView;
import com.baidu.tieba.frs.view.FrsShareCardView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f16224e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16225f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsViewData f16226g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ShareDialogConfig f16227h;

        public a(ShareItem shareItem, TbPageContext tbPageContext, FrsViewData frsViewData, ShareDialogConfig shareDialogConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareItem, tbPageContext, frsViewData, shareDialogConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16224e = shareItem;
            this.f16225f = tbPageContext;
            this.f16226g = frsViewData;
            this.f16227h = shareDialogConfig;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", this.f16224e.q).param("obj_type", 18).param("obj_source", 10));
                FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(this.f16225f.getPageActivity());
                c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(this.f16225f.getPageActivity());
                if (frsPrivateShareDialogView.configShareDialog(this.f16226g, this.f16225f, aVar)) {
                    aVar.setContentViewSize(2);
                    aVar.setContentView(frsPrivateShareDialogView);
                    aVar.create(this.f16225f).show();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
                statisticItem.param("obj_param1", this.f16227h.experimentId);
                statisticItem.param("obj_type", 7);
                statisticItem.param("obj_source", 6);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.f16224e.q);
                statisticItem.param("fname", this.f16224e.p);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f16228e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16229f;

        public b(String str, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16228e = str;
            this.f16229f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.p.c.a(this.f16228e);
                c.a.d.f.p.n.N(this.f16229f.getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumData f16230e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.r.t.a f16231f;

        public c(ForumData forumData, c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumData, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16230e = forumData;
            this.f16231f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                m.a(this.f16230e.getId());
                this.f16231f.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f16232e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsShareCardView f16233f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f16234g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f16235h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f16236i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ ShareFromFrsMsgData f16237j;

        public d(FrsFragment frsFragment, FrsShareCardView frsShareCardView, long j2, String str, long j3, ShareFromFrsMsgData shareFromFrsMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, frsShareCardView, Long.valueOf(j2), str, Long.valueOf(j3), shareFromFrsMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16232e = frsFragment;
            this.f16233f = frsShareCardView;
            this.f16234g = j2;
            this.f16235h = str;
            this.f16236i = j3;
            this.f16237j = shareFromFrsMsgData;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16232e.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), this.f16233f.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.f16232e.getTbPageContext().getPageActivity(), this.f16234g, this.f16235h, this.f16236i, "from_share", this.f16233f.getLeaveMsg(), this.f16237j.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f16238e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsShareCardView f16239f;

        public e(FrsFragment frsFragment, FrsShareCardView frsShareCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, frsShareCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16238e = frsFragment;
            this.f16239f = frsShareCardView;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16238e.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), this.f16239f.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    public static ShareItem a(TbPageContext tbPageContext, FrsViewData frsViewData, String str, String str2, Uri uri, String str3) {
        InterceptResult invokeCommon;
        String str4;
        String str5;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{tbPageContext, frsViewData, str, str2, uri, str3})) == null) {
            if (frsViewData == null || frsViewData.getForum() == null) {
                str4 = "";
                str5 = null;
            } else {
                str4 = frsViewData.getForum().getName();
                str5 = frsViewData.getForum().getfShareImage();
            }
            ShareItem shareItem = new ShareItem();
            shareItem.r = str4 + tbPageContext.getString(R.string.forum);
            shareItem.s = str3;
            shareItem.t = str2;
            shareItem.f39425b = true;
            shareItem.E = 10;
            shareItem.q = str;
            shareItem.p = str4;
            if (StringUtils.isNull(str5)) {
                shareItem.y = 4;
                shareItem.J = frsViewData.getForum().getId();
                parse = uri;
            } else {
                parse = Uri.parse(str5);
                shareItem.y = 2;
            }
            if (parse != null) {
                shareItem.v = parse;
            }
            b(shareItem, tbPageContext, frsViewData, uri);
            return shareItem;
        }
        return (ShareItem) invokeCommon.objValue;
    }

    public static void b(ShareItem shareItem, TbPageContext tbPageContext, FrsViewData frsViewData, Uri uri) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65537, null, shareItem, tbPageContext, frsViewData, uri) == null) || shareItem == null || tbPageContext == null || frsViewData == null || !UbsABTestHelper.isShareH5CardOptimizeABTestA()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (frsViewData.getForum() != null) {
            str2 = frsViewData.getForum().getName();
            str = frsViewData.getForum().getSlogan();
        } else {
            str = "";
        }
        sb.append(tbPageContext.getString(R.string.frsgroup_recommend));
        sb.append(str2);
        sb.append(tbPageContext.getString(R.string.forum));
        shareItem.y0 = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (sb2.length() > 0) {
            if (sb2.length() > 20) {
                sb2.append(sb2.substring(0, 20));
                sb2.append("...");
            }
            sb2.append(StringUtils.lineSeparator);
        }
        if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 0) {
            sb2.append(tbPageContext.getString(R.string.forum_friend_for_short));
            sb2.append(" ");
            sb2.append(StringHelper.numFormatOver10000(frsViewData.getForum().getMember_num()));
            sb2.append(" ");
            sb2.append(tbPageContext.getString(R.string.post_name));
            sb2.append(" ");
            sb2.append(StringHelper.numFormatOver10000(frsViewData.getForum().getPost_num()));
        }
        shareItem.z0 = sb2.toString();
        if (uri == null) {
            uri = Uri.parse("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
        }
        shareItem.A0 = uri;
    }

    public static String c(ForumData forumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, forumData)) == null) {
            String str = null;
            if (forumData == null || TextUtils.isEmpty(forumData.getName())) {
                return null;
            }
            try {
                str = URLEncoder.encode(forumData.getName(), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            if (!TextUtils.isEmpty(forumData.forum_share_link)) {
                return forumData.forum_share_link + "?kw=" + str + "&fr=sharewise";
            }
            return TbConfig.HTTPS_FRS_PREFIX + str + "&fr=sharewise";
        }
        return (String) invokeL.objValue;
    }

    public static ShareFromFrsMsgData d(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, frsViewData)) == null) {
            ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
            shareFromFrsMsgData.setImageUrl(frsViewData.getForum().getImage_url());
            shareFromFrsMsgData.setName(frsViewData.getForum().getName());
            shareFromFrsMsgData.setMemberNum(frsViewData.getForum().getMember_num());
            shareFromFrsMsgData.setPostNum(frsViewData.getForum().getPost_num());
            shareFromFrsMsgData.setContent(frsViewData.getForum().getSlogan());
            return shareFromFrsMsgData;
        }
        return (ShareFromFrsMsgData) invokeL.objValue;
    }

    public static void e(FrsFragment frsFragment, FrsViewData frsViewData, long j2, String str, long j3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{frsFragment, frsViewData, Long.valueOf(j2), str, Long.valueOf(j3)}) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        ShareFromFrsMsgData d2 = d(frsViewData);
        c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(frsFragment.getPageContext().getPageActivity());
        FrsShareCardView frsShareCardView = new FrsShareCardView(frsFragment.getPageContext().getPageActivity());
        frsShareCardView.setPageId(frsFragment.getUniqueId());
        frsShareCardView.setData(d2);
        aVar.setContentViewSize(1);
        aVar.setContentView(frsShareCardView);
        aVar.setPositiveButton(R.string.share, new d(frsFragment, frsShareCardView, j2, str, j3, d2));
        aVar.setNegativeButton(R.string.cancel, new e(frsFragment, frsShareCardView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(frsFragment.getPageContext()).show();
        if (c.a.d.f.p.m.isEmpty(d2.getImageUrl())) {
            return;
        }
        frsShareCardView.loadImageIcon(d2.getImageUrl(), false);
    }

    public static void f(TbPageContext tbPageContext, y yVar, ForumData forumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, yVar, forumData) == null) || tbPageContext == null || forumData == null) {
            return;
        }
        FrsLikeShareDialogView frsLikeShareDialogView = new FrsLikeShareDialogView(tbPageContext.getPageActivity());
        c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(tbPageContext.getPageActivity());
        aVar.setContentViewSize(9);
        aVar.setContentView(frsLikeShareDialogView);
        aVar.setCancelable(false);
        aVar.setCanceledOnTouchOutside(false);
        aVar.create(tbPageContext).show();
        frsLikeShareDialogView.setCloseListener(new c(forumData, aVar));
        frsLikeShareDialogView.bind(tbPageContext, yVar, forumData);
        m.c(forumData.getId());
    }

    public static void g(TbPageContext tbPageContext, FrsViewData frsViewData, String str, int i2, boolean z, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{tbPageContext, frsViewData, str, Integer.valueOf(i2), Boolean.valueOf(z), onClickListener}) == null) || tbPageContext == null || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        if (frsViewData.getForum().getName() != null && frsViewData.getForum().getId() != null) {
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String name = frsViewData.getForum().getName();
            String c2 = c(frsViewData.getForum());
            Uri parse = frsViewData.getForum().getImage_url() == null ? null : Uri.parse(frsViewData.getForum().getImage_url());
            String slogan = frsViewData.getForum().getSlogan();
            ShareItem shareItem = new ShareItem();
            shareItem.r = name + tbPageContext.getString(R.string.forum);
            shareItem.s = slogan;
            shareItem.t = c2;
            shareItem.f39425b = true;
            shareItem.E = 10;
            shareItem.q = str;
            shareItem.p = name;
            if (parse != null) {
                shareItem.v = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(tbPageContext.getPageActivity(), shareItem, true);
            shareDialogConfig.setHasSpecialItem(true);
            shareDialogConfig.setSpecialShareItems(3, a(tbPageContext, frsViewData, str, c2, parse, slogan));
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCustomCopyTitle(R.string.copy_link);
            shareDialogConfig.addOutsideTextView(R.string.poster_share, R.drawable.icon_pure_share_poster40, new a(shareItem, tbPageContext, frsViewData, shareDialogConfig));
            shareDialogConfig.setCopyLinkListener(new b(c2, tbPageContext));
            if (UbsABTestHelper.isFrsModifyABTestA()) {
                shareDialogConfig.isShowPersonalLetter = true;
                shareDialogConfig.isShowMsg = z;
                shareDialogConfig.msgNum = i2;
                shareDialogConfig.setPersonalLetterListener(onClickListener);
            }
            shareDialogConfig.experimentId = c.a.r0.d1.l2.a.c();
            tbPageContext.sendMessage(new CustomMessage(2001276, shareDialogConfig));
            return;
        }
        tbPageContext.showToast(tbPageContext.getString(R.string.no_forum_data));
    }

    public static void h(TbPageContext tbPageContext, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, tbPageContext, frsViewData) == null) {
            FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(tbPageContext.getPageActivity());
            c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(tbPageContext.getPageActivity());
            if (frsPrivateShareDialogView.configShareDialog(frsViewData, tbPageContext, aVar)) {
                aVar.setContentViewSize(2);
                aVar.setContentView(frsPrivateShareDialogView);
                aVar.create(tbPageContext).show();
            }
        }
    }
}
