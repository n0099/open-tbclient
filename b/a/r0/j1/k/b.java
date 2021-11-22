package b.a.r0.j1.k;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import b.a.e.f.p.k;
import b.a.e.f.p.l;
import b.a.q0.s.s.a;
import b.a.r0.j1.h;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity<?> f19725a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<String> f19726b;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f19727e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f19728f;

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
            this.f19728f = bVar;
            this.f19727e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.e.f.p.a.a(this.f19727e.t);
                l.M(this.f19728f.f19725a.getActivity(), view.getResources().getString(h.copy_pb_url_success));
            }
        }
    }

    /* renamed from: b.a.r0.j1.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0994b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f19729e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f19730f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f19731g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f19732h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ShareFromTopicMsgData f19733i;
        public final /* synthetic */ b j;

        public C0994b(b bVar, ShareCardView shareCardView, long j, String str, long j2, ShareFromTopicMsgData shareFromTopicMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, shareCardView, Long.valueOf(j), str, Long.valueOf(j2), shareFromTopicMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = bVar;
            this.f19729e = shareCardView;
            this.f19730f = j;
            this.f19731g = str;
            this.f19732h = j2;
            this.f19733i = shareFromTopicMsgData;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.j.f19725a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f19729e.getChatMsgView().getWindowToken(), 2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.j.f19725a.getActivity(), this.f19730f, this.f19731g, this.f19732h, "from_share", this.f19729e.getLeaveMsg(), this.f19733i.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f19734e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f19735f;

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
            this.f19735f = bVar;
            this.f19734e = shareCardView;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.f19735f.f19725a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f19734e.getChatMsgView().getWindowToken(), 2);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f19736e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f19737f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f19738g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f19739h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f19740i;
        public final /* synthetic */ ShareFromTopicMsgData j;
        public final /* synthetic */ b k;

        public d(b bVar, ShareCardView shareCardView, long j, String str, String str2, String str3, ShareFromTopicMsgData shareFromTopicMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, shareCardView, Long.valueOf(j), str, str2, str3, shareFromTopicMsgData};
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
            this.f19736e = shareCardView;
            this.f19737f = j;
            this.f19738g = str;
            this.f19739h = str2;
            this.f19740i = str3;
            this.j = shareFromTopicMsgData;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.k.f19725a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f19736e.getChatMsgView().getWindowToken(), 2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.k.f19725a.getActivity(), this.f19737f, this.f19738g, this.f19739h, this.f19740i, 0, this.f19736e.getLeaveMsg(), this.j.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f19741e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f19742f;

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
            this.f19742f = bVar;
            this.f19741e = shareCardView;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.f19742f.f19725a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f19741e.getChatMsgView().getWindowToken(), 2);
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
        this.f19726b = null;
        this.f19725a = baseActivity;
    }

    public final SparseArray<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f19726b == null) {
                SparseArray<String> sparseArray = new SparseArray<>(8);
                this.f19726b = sparseArray;
                sparseArray.put(2, "topic_wx_timeline");
                this.f19726b.put(3, "topic_wx_friend");
                this.f19726b.put(4, "topic_qq_zone");
                this.f19726b.put(5, "topic_tencent_weibo");
                this.f19726b.put(6, "topic_sina_weibo");
            }
            return this.f19726b;
        }
        return (SparseArray) invokeV.objValue;
    }

    public void c(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, long j2, b.a.r0.j1.l.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{shareFromTopicMsgData, Long.valueOf(j), str, Long.valueOf(j2), eVar}) == null) || eVar == null || eVar.h() == null) {
            return;
        }
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f19725a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f19725a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(h.share, new C0994b(this, shareCardView, j, str, j2, shareFromTopicMsgData));
        aVar.setNegativeButton(h.cancel, new c(this, shareCardView));
        aVar.create(this.f19725a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.loadImageIcon(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void d(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, String str2, String str3, b.a.r0.j1.l.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{shareFromTopicMsgData, Long.valueOf(j), str, str2, str3, eVar}) == null) || eVar == null || eVar.h() == null) {
            return;
        }
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f19725a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f19725a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(h.share, new d(this, shareCardView, j, str, str2, str3, shareFromTopicMsgData));
        aVar.setNegativeButton(h.cancel, new e(this, shareCardView));
        aVar.create(this.f19725a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.loadImageIcon(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void e(String str, String str2, String str3, String str4, String str5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z)}) == null) {
            if (TextUtils.isEmpty(str) && z) {
                BaseActivity<?> baseActivity = this.f19725a;
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
            shareItem.f46539b = true;
            shareItem.q = str;
            shareItem.v = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f19725a.getActivity(), shareItem, true, b());
            shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
            shareDialogConfig.setIsCopyLink(true);
            this.f19725a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}
