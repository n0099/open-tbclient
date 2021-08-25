package c.a.q0.h1.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.p0.s.s.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
import com.baidu.tieba.hottopic.view.ShareCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity<?> f18561a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<String> f18562b;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f18563e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f18564f;

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
            this.f18564f = bVar;
            this.f18563e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.p.a.a(this.f18563e.t);
                l.M(this.f18564f.f18561a.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* renamed from: c.a.q0.h1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0891b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f18565e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f18566f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f18567g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f18568h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ShareFromTopicMsgData f18569i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f18570j;

        public C0891b(b bVar, ShareCardView shareCardView, long j2, String str, long j3, ShareFromTopicMsgData shareFromTopicMsgData) {
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
            this.f18570j = bVar;
            this.f18565e = shareCardView;
            this.f18566f = j2;
            this.f18567g = str;
            this.f18568h = j3;
            this.f18569i = shareFromTopicMsgData;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.f18570j.f18561a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f18565e.getChatMsgView().getWindowToken(), 2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.f18570j.f18561a.getActivity(), this.f18566f, this.f18567g, this.f18568h, "from_share", this.f18565e.getLeaveMsg(), this.f18569i.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f18571e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f18572f;

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
            this.f18572f = bVar;
            this.f18571e = shareCardView;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.f18572f.f18561a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f18571e.getChatMsgView().getWindowToken(), 2);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f18573e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f18574f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f18575g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f18576h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f18577i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ ShareFromTopicMsgData f18578j;
        public final /* synthetic */ b k;

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
            this.k = bVar;
            this.f18573e = shareCardView;
            this.f18574f = j2;
            this.f18575g = str;
            this.f18576h = str2;
            this.f18577i = str3;
            this.f18578j = shareFromTopicMsgData;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.k.f18561a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f18573e.getChatMsgView().getWindowToken(), 2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.k.f18561a.getActivity(), this.f18574f, this.f18575g, this.f18576h, this.f18577i, 0, this.f18573e.getLeaveMsg(), this.f18578j.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f18579e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f18580f;

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
            this.f18580f = bVar;
            this.f18579e = shareCardView;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.f18580f.f18561a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f18579e.getChatMsgView().getWindowToken(), 2);
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
        this.f18562b = null;
        this.f18561a = baseActivity;
    }

    public final SparseArray<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f18562b == null) {
                SparseArray<String> sparseArray = new SparseArray<>(8);
                this.f18562b = sparseArray;
                sparseArray.put(2, "topic_wx_timeline");
                this.f18562b.put(3, "topic_wx_friend");
                this.f18562b.put(4, "topic_qq_zone");
                this.f18562b.put(5, "topic_tencent_weibo");
                this.f18562b.put(6, "topic_sina_weibo");
            }
            return this.f18562b;
        }
        return (SparseArray) invokeV.objValue;
    }

    public void c(ShareFromTopicMsgData shareFromTopicMsgData, long j2, String str, long j3, c.a.q0.h1.c.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{shareFromTopicMsgData, Long.valueOf(j2), str, Long.valueOf(j3), eVar}) == null) || eVar == null || eVar.h() == null) {
            return;
        }
        c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f18561a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f18561a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new C0891b(this, shareCardView, j2, str, j3, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new c(this, shareCardView));
        aVar.create(this.f18561a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.loadImageIcon(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void d(ShareFromTopicMsgData shareFromTopicMsgData, long j2, String str, String str2, String str3, c.a.q0.h1.c.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{shareFromTopicMsgData, Long.valueOf(j2), str, str2, str3, eVar}) == null) || eVar == null || eVar.h() == null) {
            return;
        }
        c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f18561a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f18561a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new d(this, shareCardView, j2, str, str2, str3, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new e(this, shareCardView));
        aVar.create(this.f18561a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.loadImageIcon(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void e(String str, String str2, String str3, String str4, String str5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z)}) == null) {
            if (TextUtils.isEmpty(str) && z) {
                BaseActivity<?> baseActivity = this.f18561a;
                baseActivity.showToast(baseActivity.getActivity().getString(R.string.no_hot_topic_data));
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
            shareItem.f47978b = true;
            shareItem.q = str;
            shareItem.v = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f18561a.getActivity(), shareItem, true, b());
            shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
            shareDialogConfig.setIsCopyLink(true);
            this.f18561a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}
