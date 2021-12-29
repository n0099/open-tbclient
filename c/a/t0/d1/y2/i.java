package c.a.t0.d1.y2;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.s.a;
import c.a.t0.d1.e1;
import c.a.t0.d1.i1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
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
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsPrivateShareDialogView;
import com.baidu.tieba.frs.view.FrsShareCardView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f17293e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17294f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsViewData f17295g;

        public a(ShareItem shareItem, TbPageContext tbPageContext, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareItem, tbPageContext, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17293e = shareItem;
            this.f17294f = tbPageContext;
            this.f17295g = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", this.f17293e.q).param("obj_type", 18).param("obj_source", 10));
                FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(this.f17294f.getPageActivity());
                c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.f17294f.getPageActivity());
                if (frsPrivateShareDialogView.configShareDialog(this.f17295g, this.f17294f, aVar)) {
                    aVar.setContentViewSize(2);
                    aVar.setContentView(frsPrivateShareDialogView);
                    aVar.create(this.f17294f).show();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17296e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17297f;

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
            this.f17296e = str;
            this.f17297f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.p.c.a(this.f17296e);
                c.a.d.f.p.n.M(this.f17297f.getPageActivity(), view.getResources().getString(i1.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f17298e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsShareCardView f17299f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f17300g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f17301h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f17302i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ ShareFromFrsMsgData f17303j;

        public c(FrsFragment frsFragment, FrsShareCardView frsShareCardView, long j2, String str, long j3, ShareFromFrsMsgData shareFromFrsMsgData) {
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
            this.f17298e = frsFragment;
            this.f17299f = frsShareCardView;
            this.f17300g = j2;
            this.f17301h = str;
            this.f17302i = j3;
            this.f17303j = shareFromFrsMsgData;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f17298e.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), this.f17299f.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.f17298e.getTbPageContext().getPageActivity(), this.f17300g, this.f17301h, this.f17302i, "from_share", this.f17299f.getLeaveMsg(), this.f17303j.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f17304e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsShareCardView f17305f;

        public d(FrsFragment frsFragment, FrsShareCardView frsShareCardView) {
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
            this.f17304e = frsFragment;
            this.f17305f = frsShareCardView;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f17304e.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), this.f17305f.getChatMsgView());
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
            shareItem.r = str4 + tbPageContext.getString(i1.forum);
            shareItem.s = str3;
            shareItem.t = str2;
            shareItem.f42233b = true;
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
        if (!(interceptable == null || interceptable.invokeLLLL(65537, null, shareItem, tbPageContext, frsViewData, uri) == null) || shareItem == null || tbPageContext == null || frsViewData == null || !c.a.s0.b.d.c0()) {
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
        sb.append(tbPageContext.getString(i1.frsgroup_recommend));
        sb.append(str2);
        sb.append(tbPageContext.getString(i1.forum));
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
            sb2.append(tbPageContext.getString(i1.forum_friend_for_short));
            sb2.append(" ");
            sb2.append(StringHelper.numFormatOver10000(frsViewData.getForum().getMember_num()));
            sb2.append(" ");
            sb2.append(tbPageContext.getString(i1.post_name));
            sb2.append(" ");
            sb2.append(StringHelper.numFormatOver10000(frsViewData.getForum().getPost_num()));
        }
        shareItem.z0 = sb2.toString();
        if (uri == null) {
            uri = Uri.parse("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
        }
        shareItem.A0 = uri;
    }

    public static ShareFromFrsMsgData c(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, frsViewData)) == null) {
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

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, long j2, String str, long j3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{frsFragment, frsViewData, Long.valueOf(j2), str, Long.valueOf(j3)}) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        ShareFromFrsMsgData c2 = c(frsViewData);
        c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(frsFragment.getPageContext().getPageActivity());
        FrsShareCardView frsShareCardView = new FrsShareCardView(frsFragment.getPageContext().getPageActivity());
        frsShareCardView.setPageId(frsFragment.getUniqueId());
        frsShareCardView.setData(c2);
        aVar.setContentViewSize(1);
        aVar.setContentView(frsShareCardView);
        aVar.setPositiveButton(i1.share, new c(frsFragment, frsShareCardView, j2, str, j3, c2));
        aVar.setNegativeButton(i1.cancel, new d(frsFragment, frsShareCardView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(frsFragment.getPageContext()).show();
        if (c.a.d.f.p.m.isEmpty(c2.getImageUrl())) {
            return;
        }
        frsShareCardView.loadImageIcon(c2.getImageUrl(), false);
    }

    public static void e(TbPageContext tbPageContext, FrsViewData frsViewData, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, frsViewData, str) == null) || tbPageContext == null || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        if (frsViewData.getForum().getName() != null && frsViewData.getForum().getId() != null) {
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String name = frsViewData.getForum().getName();
            ForumData forum = frsViewData.getForum();
            String encode = URLEncoder.encode(name);
            if (!TextUtils.isEmpty(forum.forum_share_link)) {
                str2 = forum.forum_share_link + "?kw=" + encode + "&fr=sharewise";
            } else {
                str2 = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=sharewise";
            }
            Uri parse = frsViewData.getForum().getImage_url() == null ? null : Uri.parse(frsViewData.getForum().getImage_url());
            String slogan = frsViewData.getForum().getSlogan();
            ShareItem shareItem = new ShareItem();
            shareItem.r = name + tbPageContext.getString(i1.forum);
            shareItem.s = slogan;
            shareItem.t = str2;
            shareItem.f42233b = true;
            shareItem.E = 10;
            shareItem.q = str;
            if (parse != null) {
                shareItem.v = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(tbPageContext.getPageActivity(), shareItem, true);
            shareDialogConfig.setHasSpecialItem(true);
            shareDialogConfig.setSpecialShareItems(3, a(tbPageContext, frsViewData, str, str2, parse, slogan));
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCustomCopyTitle(i1.copy_link);
            shareDialogConfig.addOutsideTextView(i1.poster_share, e1.icon_pure_share_poster40, new a(shareItem, tbPageContext, frsViewData));
            shareDialogConfig.setCopyLinkListener(new b(str2, tbPageContext));
            tbPageContext.sendMessage(new CustomMessage(2001276, shareDialogConfig));
            return;
        }
        tbPageContext.showToast(tbPageContext.getString(i1.no_forum_data));
    }

    public static void f(TbPageContext tbPageContext, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, tbPageContext, frsViewData) == null) {
            FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(tbPageContext.getPageActivity());
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(tbPageContext.getPageActivity());
            if (frsPrivateShareDialogView.configShareDialog(frsViewData, tbPageContext, aVar)) {
                aVar.setContentViewSize(2);
                aVar.setContentView(frsPrivateShareDialogView);
                aVar.create(tbPageContext).show();
            }
        }
    }
}
