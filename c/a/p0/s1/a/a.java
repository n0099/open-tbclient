package c.a.p0.s1.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import c.a.d.f.p.c;
import c.a.d.f.p.n;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity<?> a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<String> f18135b;

    /* renamed from: c.a.p0.s1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1371a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f18136b;

        public View$OnClickListenerC1371a(a aVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18136b = aVar;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a(this.a.t);
                n.N(this.f18136b.a.getActivity(), view.getResources().getString(R.string.obfuscated_res_0x7f0f0438));
            }
        }
    }

    public a(BaseActivity<?> baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18135b = null;
        this.a = baseActivity;
    }

    public final void b(ShareItem shareItem, String str, long j, String str2) {
        Uri parse;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{shareItem, str, Long.valueOf(j), str2}) == null) && UbsABTestHelper.isShareH5CardOptimizeABTestA()) {
            StringBuilder sb = new StringBuilder();
            if (!StringUtils.isNull(str) && !StringUtil.NULL_STRING.equals(str)) {
                if (str.length() > 20) {
                    sb.append(str.substring(0, 20));
                    sb.append(StringHelper.STRING_MORE);
                } else {
                    sb.append(str);
                }
                sb.append(StringUtils.lineSeparator);
            }
            if (j > 0) {
                sb.append(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f140f));
                sb.append(StringHelper.numFormatOver10000(j));
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
            if (this.f18135b == null) {
                SparseArray<String> sparseArray = new SparseArray<>(8);
                this.f18135b = sparseArray;
                sparseArray.put(2, "topic_wx_timeline");
                this.f18135b.put(3, "topic_wx_friend");
                this.f18135b.put(4, "topic_qq_zone");
                this.f18135b.put(5, "topic_tencent_weibo");
                this.f18135b.put(6, "topic_sina_weibo");
            }
            return this.f18135b;
        }
        return (SparseArray) invokeV.objValue;
    }

    public void d(String str, String str2, String str3, String str4, String str5, String str6, boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, str4, str5, str6, Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            if (TextUtils.isEmpty(str) && z) {
                BaseActivity<?> baseActivity = this.a;
                baseActivity.showToast(baseActivity.getActivity().getString(R.string.obfuscated_res_0x7f0f0c3e));
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
            shareItem.f30352b = true;
            shareItem.q = str;
            shareItem.v = parse;
            b(shareItem, str5, j, str6);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.a.getActivity(), shareItem, true, c());
            shareDialogConfig.setCopyLinkListener(new View$OnClickListenerC1371a(this, shareItem));
            shareDialogConfig.setIsCopyLink(true);
            this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}
