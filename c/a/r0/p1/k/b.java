package c.a.r0.p1.k;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.q0.s.s.a;
import c.a.r0.p1.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
import com.baidu.tieba.hottopic.view.ShareCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity<?> a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<String> f21090b;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f21091e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f21092f;

        public a(b bVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21092f = bVar;
            this.f21091e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.p.a.a(this.f21091e.t);
                l.M(this.f21092f.a.getActivity(), view.getResources().getString(h.copy_pb_url_success));
            }
        }
    }

    /* renamed from: c.a.r0.p1.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1246b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f21093e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f21094f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f21095g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f21096h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ShareFromTopicMsgData f21097i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f21098j;

        public C1246b(b bVar, ShareCardView shareCardView, long j2, String str, long j3, ShareFromTopicMsgData shareFromTopicMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, shareCardView, Long.valueOf(j2), str, Long.valueOf(j3), shareFromTopicMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21098j = bVar;
            this.f21093e = shareCardView;
            this.f21094f = j2;
            this.f21095g = str;
            this.f21096h = j3;
            this.f21097i = shareFromTopicMsgData;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.f21098j.a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f21093e.getChatMsgView().getWindowToken(), 2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.f21098j.a.getActivity(), this.f21094f, this.f21095g, this.f21096h, "from_share", this.f21093e.getLeaveMsg(), this.f21097i.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f21099e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f21100f;

        public c(b bVar, ShareCardView shareCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, shareCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21100f = bVar;
            this.f21099e = shareCardView;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.f21100f.a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f21099e.getChatMsgView().getWindowToken(), 2);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f21101e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f21102f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f21103g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f21104h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f21105i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ ShareFromTopicMsgData f21106j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ b f21107k;

        public d(b bVar, ShareCardView shareCardView, long j2, String str, String str2, String str3, ShareFromTopicMsgData shareFromTopicMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, shareCardView, Long.valueOf(j2), str, str2, str3, shareFromTopicMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21107k = bVar;
            this.f21101e = shareCardView;
            this.f21102f = j2;
            this.f21103g = str;
            this.f21104h = str2;
            this.f21105i = str3;
            this.f21106j = shareFromTopicMsgData;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.f21107k.a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f21101e.getChatMsgView().getWindowToken(), 2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.f21107k.a.getActivity(), this.f21102f, this.f21103g, this.f21104h, this.f21105i, 0, this.f21101e.getLeaveMsg(), this.f21106j.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f21108e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f21109f;

        public e(b bVar, ShareCardView shareCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, shareCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21109f = bVar;
            this.f21108e = shareCardView;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.f21109f.a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f21108e.getChatMsgView().getWindowToken(), 2);
                aVar.dismiss();
            }
        }
    }

    public b(BaseActivity<?> baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21090b = null;
        this.a = baseActivity;
    }

    public final SparseArray<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f21090b == null) {
                SparseArray<String> sparseArray = new SparseArray<>(8);
                this.f21090b = sparseArray;
                sparseArray.put(2, "topic_wx_timeline");
                this.f21090b.put(3, "topic_wx_friend");
                this.f21090b.put(4, "topic_qq_zone");
                this.f21090b.put(5, "topic_tencent_weibo");
                this.f21090b.put(6, "topic_sina_weibo");
            }
            return this.f21090b;
        }
        return (SparseArray) invokeV.objValue;
    }

    public void c(ShareFromTopicMsgData shareFromTopicMsgData, long j2, String str, long j3, c.a.r0.p1.l.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{shareFromTopicMsgData, Long.valueOf(j2), str, Long.valueOf(j3), eVar}) == null) || eVar == null || eVar.h() == null) {
            return;
        }
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(h.share, new C1246b(this, shareCardView, j2, str, j3, shareFromTopicMsgData));
        aVar.setNegativeButton(h.cancel, new c(this, shareCardView));
        aVar.create(this.a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.loadImageIcon(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void d(ShareFromTopicMsgData shareFromTopicMsgData, long j2, String str, String str2, String str3, c.a.r0.p1.l.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{shareFromTopicMsgData, Long.valueOf(j2), str, str2, str3, eVar}) == null) || eVar == null || eVar.h() == null) {
            return;
        }
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(h.share, new d(this, shareCardView, j2, str, str2, str3, shareFromTopicMsgData));
        aVar.setNegativeButton(h.cancel, new e(this, shareCardView));
        aVar.create(this.a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.loadImageIcon(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void e(String str, String str2, String str3, String str4, String str5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z)}) == null) {
            if (TextUtils.isEmpty(str) && z) {
                BaseActivity<?> baseActivity = this.a;
                baseActivity.showToast(baseActivity.getActivity().getString(h.no_hot_topic_data));
                return;
            }
            if (StringUtils.isNull(str3)) {
                str3 = "http://tieba.baidu.com/mo/q/hotMessage?topic_id=" + str + "&topic_name=" + URLEncoder.encode(str2);
            }
            Uri parse = StringUtils.isNull(str4) ? null : Uri.parse(str4);
            ShareItem shareItem = new ShareItem();
            shareItem.r = str2;
            shareItem.s = str5;
            shareItem.t = str3;
            shareItem.f41576b = true;
            shareItem.q = str;
            shareItem.v = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.a.getActivity(), shareItem, true, b());
            shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
            shareDialogConfig.setIsCopyLink(true);
            this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}
