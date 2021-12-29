package c.a.t0.q1.k;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.s.s.a;
import c.a.t0.q1.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
import com.baidu.tieba.hottopic.view.ShareCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity<?> a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<String> f22086b;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f22087e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f22088f;

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
            this.f22088f = bVar;
            this.f22087e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.p.c.a(this.f22087e.t);
                n.M(this.f22088f.a.getActivity(), view.getResources().getString(h.copy_pb_url_success));
            }
        }
    }

    /* renamed from: c.a.t0.q1.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1324b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f22089e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f22090f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f22091g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f22092h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ShareFromTopicMsgData f22093i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f22094j;

        public C1324b(b bVar, ShareCardView shareCardView, long j2, String str, long j3, ShareFromTopicMsgData shareFromTopicMsgData) {
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
            this.f22094j = bVar;
            this.f22089e = shareCardView;
            this.f22090f = j2;
            this.f22091g = str;
            this.f22092h = j3;
            this.f22093i = shareFromTopicMsgData;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.f22094j.a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f22089e.getChatMsgView().getWindowToken(), 2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.f22094j.a.getActivity(), this.f22090f, this.f22091g, this.f22092h, "from_share", this.f22089e.getLeaveMsg(), this.f22093i.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f22095e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f22096f;

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
            this.f22096f = bVar;
            this.f22095e = shareCardView;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.f22096f.a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f22095e.getChatMsgView().getWindowToken(), 2);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f22097e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f22098f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f22099g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f22100h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f22101i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ ShareFromTopicMsgData f22102j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ b f22103k;

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
            this.f22103k = bVar;
            this.f22097e = shareCardView;
            this.f22098f = j2;
            this.f22099g = str;
            this.f22100h = str2;
            this.f22101i = str3;
            this.f22102j = shareFromTopicMsgData;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.f22103k.a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f22097e.getChatMsgView().getWindowToken(), 2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.f22103k.a.getActivity(), this.f22098f, this.f22099g, this.f22100h, this.f22101i, 0, this.f22097e.getLeaveMsg(), this.f22102j.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f22104e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f22105f;

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
            this.f22105f = bVar;
            this.f22104e = shareCardView;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.f22105f.a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f22104e.getChatMsgView().getWindowToken(), 2);
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
        this.f22086b = null;
        this.a = baseActivity;
    }

    public final void b(ShareItem shareItem, String str, long j2, String str2) {
        Uri parse;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{shareItem, str, Long.valueOf(j2), str2}) == null) && c.a.s0.b.d.c0()) {
            StringBuilder sb = new StringBuilder();
            if (!StringUtils.isNull(str) && !StringUtil.NULL_STRING.equals(str)) {
                if (str.length() > 20) {
                    sb.append(str.substring(0, 20));
                    sb.append("...");
                } else {
                    sb.append(str);
                }
                sb.append(StringUtils.lineSeparator);
            }
            if (j2 > 0) {
                sb.append(this.a.getActivity().getString(h.topic_temperature));
                sb.append(StringHelper.numFormatOver10000(j2));
            }
            shareItem.z0 = sb.toString();
            if (StringUtils.isNull(str2)) {
                parse = Uri.parse("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
            } else {
                parse = Uri.parse(str2);
            }
            shareItem.A0 = parse;
        }
    }

    public final SparseArray<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f22086b == null) {
                SparseArray<String> sparseArray = new SparseArray<>(8);
                this.f22086b = sparseArray;
                sparseArray.put(2, "topic_wx_timeline");
                this.f22086b.put(3, "topic_wx_friend");
                this.f22086b.put(4, "topic_qq_zone");
                this.f22086b.put(5, "topic_tencent_weibo");
                this.f22086b.put(6, "topic_sina_weibo");
            }
            return this.f22086b;
        }
        return (SparseArray) invokeV.objValue;
    }

    public void d(ShareFromTopicMsgData shareFromTopicMsgData, long j2, String str, long j3, c.a.t0.q1.l.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{shareFromTopicMsgData, Long.valueOf(j2), str, Long.valueOf(j3), eVar}) == null) || eVar == null || eVar.h() == null) {
            return;
        }
        c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(h.share, new C1324b(this, shareCardView, j2, str, j3, shareFromTopicMsgData));
        aVar.setNegativeButton(h.cancel, new c(this, shareCardView));
        aVar.create(this.a.getPageContext()).show();
        if (m.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.loadImageIcon(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void e(ShareFromTopicMsgData shareFromTopicMsgData, long j2, String str, String str2, String str3, c.a.t0.q1.l.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{shareFromTopicMsgData, Long.valueOf(j2), str, str2, str3, eVar}) == null) || eVar == null || eVar.h() == null) {
            return;
        }
        c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(h.share, new d(this, shareCardView, j2, str, str2, str3, shareFromTopicMsgData));
        aVar.setNegativeButton(h.cancel, new e(this, shareCardView));
        aVar.create(this.a.getPageContext()).show();
        if (m.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.loadImageIcon(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void f(String str, String str2, String str3, String str4, String str5, String str6, boolean z, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, str5, str6, Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
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
            shareItem.f42233b = true;
            shareItem.q = str;
            shareItem.v = parse;
            b(shareItem, str5, j2, str6);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.a.getActivity(), shareItem, true, c());
            shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
            shareDialogConfig.setIsCopyLink(true);
            this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}
