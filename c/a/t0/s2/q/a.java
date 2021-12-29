package c.a.t0.s2.q;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.s.s.a;
import c.a.s0.t.g.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
import com.baidu.tieba.pb.chosen.view.ShareThreadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbChosenActivity a;

    /* renamed from: c.a.t0.s2.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1371a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22944e;

        public View$OnClickListenerC1371a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22944e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22944e.a.sendMessage(new CustomMessage(2001277));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(this.f22944e.a.getPageContext().getPageActivity(), 23007)));
                TiebaStatic.eventStat(this.f22944e.a.getPageContext().getPageActivity(), "pb_new_share", "loc", 0, new Object[0]);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f22945e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f22946f;

        public b(a aVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22946f = aVar;
            this.f22945e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ShareItem shareItem = this.f22945e;
                shareItem.t = g.v(shareItem.t, shareItem.K, UtilHelper.isVideoThread(shareItem.M));
                c.a.d.f.p.c.a(this.f22945e.t);
                n.M(this.f22946f.a.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.s2.q.c.a f22947e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f22948f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f22949g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f22950h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f22951i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f22952j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f22953k;
        public final /* synthetic */ String l;

        public c(c.a.t0.s2.q.c.a aVar, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j2, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, pbChosenActivity, shareThreadView, Long.valueOf(j2), str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22947e = aVar;
            this.f22948f = pbChosenActivity;
            this.f22949g = shareThreadView;
            this.f22950h = j2;
            this.f22951i = str;
            this.f22952j = str2;
            this.f22953k = str3;
            this.l = str4;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            c.a.t0.s2.q.c.a aVar2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (aVar2 = this.f22947e) == null || aVar2.getThreadInfo() == null) {
                return;
            }
            n.w(this.f22948f.getPageContext().getPageActivity(), this.f22949g.getChatMsgView());
            Activity pageActivity = this.f22948f.getPageContext().getPageActivity();
            long j2 = this.f22950h;
            String str = this.f22951i;
            String str2 = this.f22952j;
            String str3 = this.f22953k;
            String leaveMsg = this.f22949g.getLeaveMsg();
            c.a.t0.s2.q.c.a aVar3 = this.f22947e;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pageActivity, j2, str, str2, str3, 0, leaveMsg, a.c(aVar3, aVar3.getThreadInfo().excid.longValue(), this.l).toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f22954e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f22955f;

        public d(PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, shareThreadView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22954e = pbChosenActivity;
            this.f22955f = shareThreadView;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                n.w(this.f22954e.getPageContext().getPageActivity(), this.f22955f.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.s2.q.c.a f22956e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f22957f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f22958g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f22959h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f22960i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ long f22961j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f22962k;

        public e(c.a.t0.s2.q.c.a aVar, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j2, String str, long j3, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, pbChosenActivity, shareThreadView, Long.valueOf(j2), str, Long.valueOf(j3), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22956e = aVar;
            this.f22957f = pbChosenActivity;
            this.f22958g = shareThreadView;
            this.f22959h = j2;
            this.f22960i = str;
            this.f22961j = j3;
            this.f22962k = str2;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            c.a.t0.s2.q.c.a aVar2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (aVar2 = this.f22956e) == null || aVar2.getThreadInfo() == null) {
                return;
            }
            n.w(this.f22957f.getPageContext().getPageActivity(), this.f22958g.getChatMsgView());
            Activity pageActivity = this.f22957f.getPageContext().getPageActivity();
            long j2 = this.f22959h;
            String str = this.f22960i;
            long j3 = this.f22961j;
            String leaveMsg = this.f22958g.getLeaveMsg();
            c.a.t0.s2.q.c.a aVar3 = this.f22956e;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(pageActivity, j2, str, j3, "from_share", leaveMsg, a.c(aVar3, aVar3.getThreadInfo().excid.longValue(), this.f22962k).toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public static class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f22963e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f22964f;

        public f(PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, shareThreadView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22963e = pbChosenActivity;
            this.f22964f = shareThreadView;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                n.w(this.f22963e.getPageContext().getPageActivity(), this.f22964f.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    public a(PbChosenActivity pbChosenActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbChosenActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pbChosenActivity;
    }

    public static ShareFromPBMsgData c(c.a.t0.s2.q.c.a aVar, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{aVar, Long.valueOf(j2), str})) == null) {
            if (aVar == null || aVar.getThreadInfo() == null) {
                return null;
            }
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            shareFromPBMsgData.setContent(aVar.getThreadInfo()._abstract);
            shareFromPBMsgData.setImageUrl(str);
            shareFromPBMsgData.setForumName(aVar.getThreadInfo().forum.forum_name);
            shareFromPBMsgData.setPostId(null);
            shareFromPBMsgData.setThreadId(aVar.getThreadInfo().thread_id + "");
            shareFromPBMsgData.setTheNewThemeId(String.valueOf(j2));
            shareFromPBMsgData.setTitle(aVar.getThreadInfo().title);
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeCommon.objValue;
    }

    public static void d(PbChosenActivity pbChosenActivity, c.a.t0.s2.q.c.a aVar, long j2, String str, long j3, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{pbChosenActivity, aVar, Long.valueOf(j2), str, Long.valueOf(j3), str2}) == null) || aVar == null || aVar.getThreadInfo() == null) {
            return;
        }
        c.a.s0.s.s.a aVar2 = new c.a.s0.s.s.a(pbChosenActivity.getPageContext().getPageActivity());
        ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
        shareThreadView.loadImageIcon(str2, false);
        shareThreadView.setTitle(aVar.getThreadInfo().title);
        shareThreadView.setDesc(aVar.getThreadInfo()._abstract);
        aVar2.setContentView(shareThreadView);
        aVar2.setPositiveButton(R.string.share, new e(aVar, pbChosenActivity, shareThreadView, j2, str, j3, str2));
        aVar2.setNegativeButton(R.string.cancel, new f(pbChosenActivity, shareThreadView));
        aVar2.setCanceledOnTouchOutside(false);
        aVar2.create(pbChosenActivity.getPageContext()).show();
    }

    public static void e(PbChosenActivity pbChosenActivity, c.a.t0.s2.q.c.a aVar, long j2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{pbChosenActivity, aVar, Long.valueOf(j2), str, str2, str3, str4}) == null) || aVar == null || aVar.getThreadInfo() == null) {
            return;
        }
        c.a.s0.s.s.a aVar2 = new c.a.s0.s.s.a(pbChosenActivity.getPageContext().getPageActivity());
        ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
        shareThreadView.setTitle(aVar.getThreadInfo().title);
        shareThreadView.setDesc(aVar.getThreadInfo()._abstract);
        shareThreadView.loadImageIcon(str4, false);
        aVar2.setContentView(shareThreadView);
        aVar2.setPositiveButton(R.string.share, new c(aVar, pbChosenActivity, shareThreadView, j2, str, str2, str3, str4));
        aVar2.setNegativeButton(R.string.cancel, new d(pbChosenActivity, shareThreadView));
        aVar2.setCanceledOnTouchOutside(false);
        aVar2.create(pbChosenActivity.getPageContext()).show();
    }

    public void f(c.a.t0.s2.q.c.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, str) == null) || aVar == null || aVar.getThreadInfo() == null || aVar.getThreadInfo().excid == null) {
            return;
        }
        String str2 = aVar.getThreadInfo().forum.forum_name;
        String str3 = aVar.getThreadInfo().title;
        String str4 = aVar.getThreadInfo()._abstract;
        Resources resources = this.a.getPageContext().getPageActivity().getResources();
        String format = MessageFormat.format(resources.getString(R.string.share_content_tpl), str3, str4);
        resources.getString(R.string.chosen_pb_share_content, str3);
        ShareItem shareItem = new ShareItem();
        shareItem.r = str3;
        shareItem.s = format;
        shareItem.t = "http://tieba.baidu.com/mo/q/recommendpb?ftid=" + aVar.getThreadInfo().excid;
        shareItem.D = str4;
        shareItem.C = Long.toString(aVar.getThreadInfo().excid.longValue());
        shareItem.K = Long.toString(aVar.getThreadInfo().thread_id.longValue());
        shareItem.a = true;
        if (!StringUtils.isNull(str)) {
            shareItem.v = Uri.parse(str);
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a.getPageContext().getPageActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.addOutsideTextView(R.string.forum_friend, R.drawable.icon_share_friends_n, new View$OnClickListenerC1371a(this));
        shareDialogConfig.setCopyLinkListener(new b(this, shareItem));
        this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
