package c.a.o0.t.g;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.q;
import c.a.o0.t.g.b;
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
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f14594a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.t.g.c f14595b;

    /* renamed from: c  reason: collision with root package name */
    public d f14596c;

    /* renamed from: d  reason: collision with root package name */
    public String f14597d;

    /* renamed from: e  reason: collision with root package name */
    public String f14598e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.t.g.b f14599f;

    /* renamed from: g  reason: collision with root package name */
    public b.InterfaceC0695b f14600g;

    /* renamed from: h  reason: collision with root package name */
    public b.InterfaceC0695b f14601h;

    /* renamed from: i  reason: collision with root package name */
    public b.InterfaceC0695b f14602i;

    /* loaded from: classes3.dex */
    public class a implements b.InterfaceC0695b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f14603a;

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
            this.f14603a = gVar;
        }

        @Override // c.a.o0.t.g.b.InterfaceC0695b
        public void a(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                this.f14603a.f14596c.a(this.f14603a.q(shareItem, ThirdPartyUtil.TYPE_WEIXIN), 3, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements b.InterfaceC0695b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f14604a;

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
            this.f14604a = gVar;
        }

        @Override // c.a.o0.t.g.b.InterfaceC0695b
        public void a(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                this.f14604a.f14596c.a(this.f14604a.q(shareItem, Share.QQFRIEND), 8, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements b.InterfaceC0695b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f14605a;

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
            this.f14605a = gVar;
        }

        @Override // c.a.o0.t.g.b.InterfaceC0695b
        public void a(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                this.f14605a.f14596c.a(this.f14605a.q(shareItem, "qzone"), 4, true);
            }
        }
    }

    public g(Context context, c.a.o0.t.g.c cVar) {
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
        this.f14595b = null;
        this.f14596c = null;
        this.f14597d = TbadkCoreApplication.getInst().getContext().getString(R.string.share_tail);
        this.f14598e = TbadkCoreApplication.getInst().getContext().getString(R.string.weibo_share_tail) + this.f14597d;
        this.f14600g = new a(this);
        this.f14601h = new b(this);
        this.f14602i = new c(this);
        this.f14594a = context;
        this.f14595b = cVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001445, e.class);
        if (runTask == null || runTask.getData() == null || (eVar = (e) runTask.getData()) == null) {
            return;
        }
        this.f14596c = eVar.a(this.f14594a, this.f14595b);
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareItem) == null) || this.f14596c == null || shareItem == null) {
            return;
        }
        shareItem.s = c(shareItem.s, 80, 32, shareItem.c0 ? this.f14597d : "");
        if (!QqShareH5Switch.isOn() && !k.isEmpty(shareItem.f0)) {
            shareItem.v = Uri.parse(shareItem.f0);
            this.f14596c.a(q(shareItem, Share.QQFRIEND), 8, true);
        } else if (!QqShareH5Switch.isOn() && k.isEmpty(shareItem.f0) && !k.isEmpty(shareItem.K) && !"0".equals(shareItem.K)) {
            if (this.f14599f == null) {
                c.a.o0.t.g.b bVar = new c.a.o0.t.g.b();
                this.f14599f = bVar;
                bVar.c(this.f14601h);
            }
            this.f14599f.b(shareItem);
        } else {
            if (!QqShareH5Switch.isOn()) {
                if (this.f14599f == null) {
                    this.f14599f = new c.a.o0.t.g.b();
                }
                this.f14599f.b(shareItem);
            }
            this.f14596c.a(q(shareItem, Share.QQFRIEND), 8, true);
        }
    }

    public void i(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, shareItem) == null) || this.f14596c == null) {
            return;
        }
        shareItem.s = c(shareItem.s, 80, 32, shareItem.c0 ? this.f14597d : "");
        if (!QqShareH5Switch.isOn() && !k.isEmpty(shareItem.f0)) {
            shareItem.v = Uri.parse(shareItem.f0);
            this.f14596c.a(q(shareItem, "qzone"), 4, true);
        } else if (!QqShareH5Switch.isOn() && k.isEmpty(shareItem.f0) && !k.isEmpty(shareItem.K) && !"0".equals(shareItem.K)) {
            if (this.f14599f == null) {
                c.a.o0.t.g.b bVar = new c.a.o0.t.g.b();
                this.f14599f = bVar;
                bVar.c(this.f14602i);
            }
            this.f14599f.b(shareItem);
        } else {
            if (!QqShareH5Switch.isOn()) {
                if (this.f14599f == null) {
                    this.f14599f = new c.a.o0.t.g.b();
                }
                this.f14599f.b(shareItem);
            }
            this.f14596c.a(q(shareItem, "qzone"), 4, true);
        }
    }

    public void j(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, shareItem) == null) || this.f14596c == null) {
            return;
        }
        shareItem.s = c(shareItem.s, PbFullScreenEditorActivity.REPLY_MAX_SIZE, 20, shareItem.c0 ? this.f14597d : "");
        this.f14596c.a(q(shareItem, "renren"), 7, true);
    }

    public void k(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, shareItem) == null) || this.f14596c == null) {
            return;
        }
        if (!c.a.o0.t.g.a.b(TbadkApplication.getInst().getApplicationContext(), 6)) {
            BdToast.c(TbadkApplication.getInst().getApplicationContext(), TbadkApplication.getInst().getApplicationContext().getText(R.string.share_sina_weibo_not_install)).q();
            return;
        }
        shareItem.s = c(shareItem.s, PbFullScreenEditorActivity.REPLY_MAX_SIZE, 20, shareItem.c0 ? this.f14598e : "");
        this.f14596c.a(q(shareItem, "sina_weibo"), 6, true);
    }

    public void l(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, shareItem) == null) || this.f14596c == null) {
            return;
        }
        shareItem.s = c(shareItem.s, PbFullScreenEditorActivity.REPLY_MAX_SIZE, 20, shareItem.c0 ? this.f14597d : "");
        this.f14596c.a(q(shareItem, "tencent_weibo"), 5, true);
    }

    public void m(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, shareItem) == null) || this.f14596c == null || shareItem == null) {
            return;
        }
        if (StringUtils.isNull(shareItem.K)) {
            shareItem.s = c(shareItem.s, 80, 20, shareItem.c0 ? this.f14597d : "");
        }
        if (shareItem.g0 && !k.isEmpty(shareItem.f0)) {
            shareItem.v = Uri.parse(shareItem.f0);
            this.f14596c.a(q(shareItem, ThirdPartyUtil.TYPE_WEIXIN), 3, false);
        } else if (shareItem.g0 && k.isEmpty(shareItem.f0) && !k.isEmpty(shareItem.K) && !"0".equals(shareItem.K)) {
            if (this.f14599f == null) {
                c.a.o0.t.g.b bVar = new c.a.o0.t.g.b();
                this.f14599f = bVar;
                bVar.c(this.f14600g);
            }
            this.f14599f.b(shareItem);
        } else {
            if (shareItem.y == 4) {
                if (this.f14599f == null) {
                    this.f14599f = new c.a.o0.t.g.b();
                }
                this.f14599f.b(shareItem);
            }
            this.f14596c.a(q(shareItem, ThirdPartyUtil.TYPE_WEIXIN), 3, false);
        }
    }

    public void n(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareItem) == null) || this.f14596c == null || shareItem == null) {
            return;
        }
        shareItem.s = c(shareItem.s, 80, 20, shareItem.c0 ? this.f14597d : "");
        this.f14596c.a(q(shareItem, Share.WEIXIN_TIMELINE), 2, false);
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
            if (shareItem.d0) {
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
