package b.a.q0.t.g;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import b.a.e.e.p.q;
import b.a.q0.t.g.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.share.Share;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.QqShareH5Switch;
import com.baidu.tbadk.switchs.UrlNeedCuidSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f14014a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.q0.t.g.c f14015b;

    /* renamed from: c  reason: collision with root package name */
    public d f14016c;

    /* renamed from: d  reason: collision with root package name */
    public String f14017d;

    /* renamed from: e  reason: collision with root package name */
    public String f14018e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.q0.t.g.b f14019f;

    /* renamed from: g  reason: collision with root package name */
    public b.InterfaceC0702b f14020g;

    /* renamed from: h  reason: collision with root package name */
    public b.InterfaceC0702b f14021h;

    /* renamed from: i  reason: collision with root package name */
    public b.InterfaceC0702b f14022i;

    /* loaded from: classes4.dex */
    public class a implements b.InterfaceC0702b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f14023a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14023a = gVar;
        }

        @Override // b.a.q0.t.g.b.InterfaceC0702b
        public void a(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                this.f14023a.f14016c.a(this.f14023a.q(shareItem, ThirdPartyUtil.TYPE_WEIXIN), 3, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.InterfaceC0702b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f14024a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14024a = gVar;
        }

        @Override // b.a.q0.t.g.b.InterfaceC0702b
        public void a(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                this.f14024a.f14016c.a(this.f14024a.q(shareItem, Share.QQFRIEND), 8, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b.InterfaceC0702b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f14025a;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14025a = gVar;
        }

        @Override // b.a.q0.t.g.b.InterfaceC0702b
        public void a(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                this.f14025a.f14016c.a(this.f14025a.q(shareItem, "qzone"), 4, true);
            }
        }
    }

    public g(Context context, b.a.q0.t.g.c cVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14015b = null;
        this.f14016c = null;
        this.f14017d = TbadkCoreApplication.getInst().getContext().getString(R.string.share_tail);
        this.f14018e = TbadkCoreApplication.getInst().getContext().getString(R.string.weibo_share_tail) + this.f14017d;
        this.f14020g = new a(this);
        this.f14021h = new b(this);
        this.f14022i = new c(this);
        this.f14014a = context;
        this.f14015b = cVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001445, e.class);
        if (runTask == null || runTask.getData() == null || (eVar = (e) runTask.getData()) == null) {
            return;
        }
        this.f14016c = eVar.a(this.f14014a, this.f14015b);
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (str.contains("?")) {
                str3 = "&";
            } else {
                str = str + "?";
                str3 = "";
            }
            return str + str3 + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? g() : invokeL.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? TbadkCoreApplication.getInst().appResponseToCmd(2001445) : invokeV.booleanValue;
    }

    public static String o(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) ? p(str, "copy", str2) : (String) invokeLL.objValue;
    }

    public static String p(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, str2, str3)) == null) {
            if (k.isEmpty(str)) {
                str = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
            }
            String d2 = d(d(str, "sfc=" + str2), "client_type=2");
            String d3 = d(d2, "client_version=" + TbConfig.getVersion());
            String d4 = d(d3, "st=" + (System.currentTimeMillis() / 1000));
            if (str3 != null) {
                if (SwitchManager.getInstance().findType(UrlNeedCuidSwitch.URL_NEED_CUID_SWITCH) == 1) {
                    c2 = q.c(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
                } else {
                    c2 = q.c(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
                }
                return d(d4, "unique=" + c2);
            }
            return d4;
        }
        return (String) invokeLLL.objValue;
    }

    public final String c(String str, int i2, int i3, String str2) {
        InterceptResult invokeCommon;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2})) == null) {
            if (str == null) {
                return str2;
            }
            if (Math.min((i2 - str2.length()) - i3, str.length()) < str.length()) {
                return str.substring(0, min - 1) + ("..." + str2);
            }
            return str + str2;
        }
        return (String) invokeCommon.objValue;
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("file://")) {
                try {
                    file = new File(new URI(str));
                } catch (URISyntaxException unused) {
                }
                return file.isFile() && file.exists();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void h(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareItem) == null) || this.f14016c == null || shareItem == null) {
            return;
        }
        shareItem.s = c(shareItem.s, 80, 32, shareItem.f0 ? this.f14017d : "");
        if (!QqShareH5Switch.isOn() && !k.isEmpty(shareItem.i0)) {
            shareItem.v = Uri.parse(shareItem.i0);
            this.f14016c.a(q(shareItem, Share.QQFRIEND), 8, true);
        } else if (!QqShareH5Switch.isOn() && k.isEmpty(shareItem.i0) && !k.isEmpty(shareItem.K) && !"0".equals(shareItem.K)) {
            if (this.f14019f == null) {
                b.a.q0.t.g.b bVar = new b.a.q0.t.g.b();
                this.f14019f = bVar;
                bVar.c(this.f14021h);
            }
            this.f14019f.b(shareItem);
        } else {
            if (!QqShareH5Switch.isOn()) {
                if (this.f14019f == null) {
                    this.f14019f = new b.a.q0.t.g.b();
                }
                this.f14019f.b(shareItem);
            }
            this.f14016c.a(q(shareItem, Share.QQFRIEND), 8, true);
        }
    }

    public void i(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, shareItem) == null) || this.f14016c == null) {
            return;
        }
        shareItem.s = c(shareItem.s, 80, 32, shareItem.f0 ? this.f14017d : "");
        if (!QqShareH5Switch.isOn() && !k.isEmpty(shareItem.i0)) {
            shareItem.v = Uri.parse(shareItem.i0);
            this.f14016c.a(q(shareItem, "qzone"), 4, true);
        } else if (!QqShareH5Switch.isOn() && k.isEmpty(shareItem.i0) && !k.isEmpty(shareItem.K) && !"0".equals(shareItem.K)) {
            if (this.f14019f == null) {
                b.a.q0.t.g.b bVar = new b.a.q0.t.g.b();
                this.f14019f = bVar;
                bVar.c(this.f14022i);
            }
            this.f14019f.b(shareItem);
        } else {
            if (!QqShareH5Switch.isOn()) {
                if (this.f14019f == null) {
                    this.f14019f = new b.a.q0.t.g.b();
                }
                this.f14019f.b(shareItem);
            }
            this.f14016c.a(q(shareItem, "qzone"), 4, true);
        }
    }

    public void j(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, shareItem) == null) || this.f14016c == null) {
            return;
        }
        shareItem.s = c(shareItem.s, PbFullScreenEditorActivity.REPLY_MAX_SIZE, 20, shareItem.f0 ? this.f14017d : "");
        this.f14016c.a(q(shareItem, "renren"), 7, true);
    }

    public void k(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, shareItem) == null) || this.f14016c == null) {
            return;
        }
        if (!b.a.q0.t.g.a.b(TbadkApplication.getInst().getApplicationContext(), 6)) {
            BdToast.c(TbadkApplication.getInst().getApplicationContext(), TbadkApplication.getInst().getApplicationContext().getText(R.string.share_sina_weibo_not_install)).q();
            return;
        }
        shareItem.s = c(shareItem.s, PbFullScreenEditorActivity.REPLY_MAX_SIZE, 20, shareItem.f0 ? this.f14018e : "");
        this.f14016c.a(q(shareItem, "sina_weibo"), 6, true);
    }

    public void l(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, shareItem) == null) || this.f14016c == null) {
            return;
        }
        shareItem.s = c(shareItem.s, PbFullScreenEditorActivity.REPLY_MAX_SIZE, 20, shareItem.f0 ? this.f14017d : "");
        this.f14016c.a(q(shareItem, "tencent_weibo"), 5, true);
    }

    public void m(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, shareItem) == null) || this.f14016c == null || shareItem == null) {
            return;
        }
        if (StringUtils.isNull(shareItem.K)) {
            shareItem.s = c(shareItem.s, 80, 20, shareItem.f0 ? this.f14017d : "");
        }
        if (shareItem.j0 && !k.isEmpty(shareItem.i0)) {
            shareItem.v = Uri.parse(shareItem.i0);
            this.f14016c.a(q(shareItem, ThirdPartyUtil.TYPE_WEIXIN), 3, false);
        } else if (shareItem.j0 && k.isEmpty(shareItem.i0) && !k.isEmpty(shareItem.K) && !"0".equals(shareItem.K)) {
            if (this.f14019f == null) {
                b.a.q0.t.g.b bVar = new b.a.q0.t.g.b();
                this.f14019f = bVar;
                bVar.c(this.f14020g);
            }
            this.f14019f.b(shareItem);
        } else {
            if (shareItem.y == 4) {
                if (this.f14019f == null) {
                    this.f14019f = new b.a.q0.t.g.b();
                }
                this.f14019f.b(shareItem);
            }
            this.f14016c.a(q(shareItem, ThirdPartyUtil.TYPE_WEIXIN), 3, false);
        }
    }

    public void n(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareItem) == null) || this.f14016c == null || shareItem == null) {
            return;
        }
        shareItem.s = c(shareItem.s, 80, 20, shareItem.f0 ? this.f14017d : "");
        this.f14016c.a(q(shareItem, Share.WEIXIN_TIMELINE), 2, false);
    }

    public final ShareItem q(ShareItem shareItem, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, shareItem, str)) == null) {
            if (shareItem == null) {
                return null;
            }
            Uri uri = shareItem.v;
            if ((uri == null || uri.equals("")) && shareItem.c() == null) {
                str.startsWith(ThirdPartyUtil.TYPE_WEIXIN);
                shareItem.v = Uri.parse("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
            }
            Uri uri2 = shareItem.v;
            if (uri2 != null && !uri2.equals("")) {
                String uri3 = shareItem.v.toString();
                if (!f(uri3) && !r(uri3)) {
                    shareItem.v = Uri.parse("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
                } else {
                    shareItem.v = Uri.parse(uri3);
                    d(uri3, "sfc=" + str);
                }
            }
            if (shareItem.g0) {
                shareItem.t = p(shareItem.t, str, shareItem.K);
            }
            return shareItem;
        }
        return (ShareItem) invokeLL.objValue;
    }

    public final boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            String[] split = "jpg,jpeg,png,gif,bmp".split(",");
            if (UrlManager.getInstance().UrlValidated(str)) {
                if (split == null || split.length <= 0) {
                    return true;
                }
                for (String str2 : split) {
                    if (str2 != null && !str2.equals("") && (str.contains(str2) || str.contains(str2.toUpperCase()))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
