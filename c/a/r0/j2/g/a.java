package c.a.r0.j2.g;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.s.a;
import c.a.q0.t.g.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbChosenActivity f19515a;

    /* renamed from: c.a.r0.j2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0942a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19516e;

        public View$OnClickListenerC0942a(a aVar) {
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
            this.f19516e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19516e.f19515a.sendMessage(new CustomMessage(2001277));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(this.f19516e.f19515a.getPageContext().getPageActivity(), 23007)));
                TiebaStatic.eventStat(this.f19516e.f19515a.getPageContext().getPageActivity(), "pb_new_share", "loc", 0, new Object[0]);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f19517e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f19518f;

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
            this.f19518f = aVar;
            this.f19517e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ShareItem shareItem = this.f19517e;
                shareItem.t = g.o(shareItem.t, shareItem.K);
                c.a.e.e.p.a.a(this.f19517e.t);
                l.M(this.f19518f.f19515a.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.j2.g.c.a f19519e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19520f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f19521g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f19522h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f19523i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f19524j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;

        public c(c.a.r0.j2.g.c.a aVar, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j2, String str, String str2, String str3, String str4) {
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
            this.f19519e = aVar;
            this.f19520f = pbChosenActivity;
            this.f19521g = shareThreadView;
            this.f19522h = j2;
            this.f19523i = str;
            this.f19524j = str2;
            this.k = str3;
            this.l = str4;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            c.a.r0.j2.g.c.a aVar2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (aVar2 = this.f19519e) == null || aVar2.getThreadInfo() == null) {
                return;
            }
            l.x(this.f19520f.getPageContext().getPageActivity(), this.f19521g.getChatMsgView());
            Activity pageActivity = this.f19520f.getPageContext().getPageActivity();
            long j2 = this.f19522h;
            String str = this.f19523i;
            String str2 = this.f19524j;
            String str3 = this.k;
            String leaveMsg = this.f19521g.getLeaveMsg();
            c.a.r0.j2.g.c.a aVar3 = this.f19519e;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pageActivity, j2, str, str2, str3, 0, leaveMsg, a.c(aVar3, aVar3.getThreadInfo().excid.longValue(), this.l).toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19525e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f19526f;

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
            this.f19525e = pbChosenActivity;
            this.f19526f = shareThreadView;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                l.x(this.f19525e.getPageContext().getPageActivity(), this.f19526f.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.j2.g.c.a f19527e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19528f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f19529g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f19530h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f19531i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ long f19532j;
        public final /* synthetic */ String k;

        public e(c.a.r0.j2.g.c.a aVar, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j2, String str, long j3, String str2) {
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
            this.f19527e = aVar;
            this.f19528f = pbChosenActivity;
            this.f19529g = shareThreadView;
            this.f19530h = j2;
            this.f19531i = str;
            this.f19532j = j3;
            this.k = str2;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            c.a.r0.j2.g.c.a aVar2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (aVar2 = this.f19527e) == null || aVar2.getThreadInfo() == null) {
                return;
            }
            l.x(this.f19528f.getPageContext().getPageActivity(), this.f19529g.getChatMsgView());
            Activity pageActivity = this.f19528f.getPageContext().getPageActivity();
            long j2 = this.f19530h;
            String str = this.f19531i;
            long j3 = this.f19532j;
            String leaveMsg = this.f19529g.getLeaveMsg();
            c.a.r0.j2.g.c.a aVar3 = this.f19527e;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(pageActivity, j2, str, j3, "from_share", leaveMsg, a.c(aVar3, aVar3.getThreadInfo().excid.longValue(), this.k).toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19533e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f19534f;

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
            this.f19533e = pbChosenActivity;
            this.f19534f = shareThreadView;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                l.x(this.f19533e.getPageContext().getPageActivity(), this.f19534f.getChatMsgView());
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
        this.f19515a = pbChosenActivity;
    }

    public static ShareFromPBMsgData c(c.a.r0.j2.g.c.a aVar, long j2, String str) {
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

    public static void d(PbChosenActivity pbChosenActivity, c.a.r0.j2.g.c.a aVar, long j2, String str, long j3, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{pbChosenActivity, aVar, Long.valueOf(j2), str, Long.valueOf(j3), str2}) == null) || aVar == null || aVar.getThreadInfo() == null) {
            return;
        }
        c.a.q0.s.s.a aVar2 = new c.a.q0.s.s.a(pbChosenActivity.getPageContext().getPageActivity());
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

    public static void e(PbChosenActivity pbChosenActivity, c.a.r0.j2.g.c.a aVar, long j2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{pbChosenActivity, aVar, Long.valueOf(j2), str, str2, str3, str4}) == null) || aVar == null || aVar.getThreadInfo() == null) {
            return;
        }
        c.a.q0.s.s.a aVar2 = new c.a.q0.s.s.a(pbChosenActivity.getPageContext().getPageActivity());
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

    public void f(c.a.r0.j2.g.c.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, str) == null) || aVar == null || aVar.getThreadInfo() == null || aVar.getThreadInfo().excid == null) {
            return;
        }
        String str2 = aVar.getThreadInfo().forum.forum_name;
        String str3 = aVar.getThreadInfo().title;
        String str4 = aVar.getThreadInfo()._abstract;
        Resources resources = this.f19515a.getPageContext().getPageActivity().getResources();
        String format = MessageFormat.format(resources.getString(R.string.share_content_tpl), str3, str4);
        resources.getString(R.string.chosen_pb_share_content, str3);
        ShareItem shareItem = new ShareItem();
        shareItem.r = str3;
        shareItem.s = format;
        shareItem.t = "http://tieba.baidu.com/mo/q/recommendpb?ftid=" + aVar.getThreadInfo().excid;
        shareItem.D = str4;
        shareItem.C = Long.toString(aVar.getThreadInfo().excid.longValue());
        shareItem.K = Long.toString(aVar.getThreadInfo().thread_id.longValue());
        shareItem.f48105a = true;
        if (!StringUtils.isNull(str)) {
            shareItem.v = Uri.parse(str);
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f19515a.getPageContext().getPageActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.addOutsideTextView(R.string.forum_friend, R.drawable.icon_share_friends_n, new View$OnClickListenerC0942a(this));
        shareDialogConfig.setCopyLinkListener(new b(this, shareItem));
        this.f19515a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
