package c.a.t0.t.g;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.t;
import c.a.t0.s.r.e2;
import c.a.t0.t.g.b;
import c.a.u0.a4.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.share.Share;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.QqShareH5Switch;
import com.baidu.tbadk.switchs.UrlNeedCuidSwitch;
import com.baidu.tbadk.switchs.WeChatShareSmallAppToH5Switch;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.t.g.c f14450b;

    /* renamed from: c  reason: collision with root package name */
    public d f14451c;

    /* renamed from: d  reason: collision with root package name */
    public String f14452d;

    /* renamed from: e  reason: collision with root package name */
    public String f14453e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.t.g.b f14454f;

    /* renamed from: g  reason: collision with root package name */
    public b.InterfaceC0915b f14455g;

    /* renamed from: h  reason: collision with root package name */
    public b.InterfaceC0915b f14456h;

    /* renamed from: i  reason: collision with root package name */
    public b.InterfaceC0915b f14457i;

    /* loaded from: classes6.dex */
    public class a implements b.InterfaceC0915b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // c.a.t0.t.g.b.InterfaceC0915b
        public void a(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                ShareItem x = this.a.x(shareItem, ThirdPartyUtil.TYPE_WEIXIN);
                this.a.g(x);
                this.a.f14451c.a(x, 3, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements b.InterfaceC0915b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // c.a.t0.t.g.b.InterfaceC0915b
        public void a(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                this.a.f14451c.a(this.a.x(shareItem, Share.QQFRIEND), 8, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements b.InterfaceC0915b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // c.a.t0.t.g.b.InterfaceC0915b
        public void a(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                this.a.f14451c.a(this.a.x(shareItem, "qzone"), 4, true);
            }
        }
    }

    public g(Context context, c.a.t0.t.g.c cVar) {
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
        this.f14450b = null;
        this.f14451c = null;
        this.f14452d = TbadkCoreApplication.getInst().getContext().getString(j.share_tail);
        this.f14453e = TbadkCoreApplication.getInst().getContext().getString(j.weibo_share_tail) + this.f14452d;
        this.f14455g = new a(this);
        this.f14456h = new b(this);
        this.f14457i = new c(this);
        this.a = context;
        this.f14450b = cVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001445, e.class);
        if (runTask == null || runTask.getData() == null || (eVar = (e) runTask.getData()) == null) {
            return;
        }
        this.f14451c = eVar.a(this.a, this.f14450b);
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
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

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? n() : invokeL.booleanValue;
    }

    public static String i(e2 e2Var, int i2, String str, long j2, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{e2Var, Integer.valueOf(i2), str, Long.valueOf(j2), str2, str3})) == null) {
            if (e2Var == null) {
                return "";
            }
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            StringBuilder sb = new StringBuilder();
            if (i2 != 2 && i2 != 6 && i2 != 8) {
                if (e2Var.p0() == 0) {
                    String o = e2Var.o();
                    if (!StringUtils.isNull(o)) {
                        str3 = o;
                    }
                    if (!StringUtils.isNull(str3) && !StringUtil.NULL_STRING.equals(str3)) {
                        if (str3.length() > 20) {
                            sb.append(str3.substring(0, 20));
                            sb.append("...");
                        } else {
                            sb.append(str3);
                        }
                        sb.append(StringUtils.lineSeparator);
                    } else {
                        String l = l(e2Var, str2);
                        if (!StringUtils.isNull(l)) {
                            sb.append(inst.getString(j.post_author));
                            sb.append(l);
                            sb.append(StringUtils.lineSeparator);
                        }
                    }
                    if (j2 > 0) {
                        sb.append(inst.getString(j.forum_friend_looking));
                        sb.append(StringHelper.numFormatOver10000(j2));
                    }
                } else {
                    String l2 = l(e2Var, str2);
                    if (!StringUtils.isNull(l2)) {
                        sb.append(inst.getString(j.post_author));
                        sb.append(l2);
                        sb.append(StringUtils.lineSeparator);
                    }
                    if (j2 > 0) {
                        sb.append(inst.getString(j.forum_friend_looking));
                        sb.append(StringHelper.numFormatOver10000(j2));
                    }
                }
            } else {
                if (j2 > 0) {
                    sb.append(inst.getString(j.forum_friend_looking));
                    sb.append(StringHelper.numFormatOver10000(j2));
                    sb.append(StringUtils.lineSeparator);
                }
                String l3 = l(e2Var, str2);
                if (!StringUtils.isNull(l3)) {
                    sb.append(inst.getString(j.post_author));
                    sb.append(l3);
                    sb.append(StringUtils.lineSeparator);
                }
                if (!StringUtils.isNull(str)) {
                    if (str.length() > 10) {
                        str = str.substring(0, 10) + "...";
                    }
                    sb.append(str);
                    sb.append(inst.getString(j.forum));
                }
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String j(e2 e2Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, e2Var, i2)) == null) {
            if (e2Var == null) {
                return "";
            }
            String title = e2Var.getTitle();
            if (i2 == 2 || i2 == 6 || i2 == 8) {
                return title;
            }
            return e2Var.p0() == 0 ? title : e2Var.o();
        }
        return (String) invokeLI.objValue;
    }

    public static int k(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, e2Var)) == null) {
            if (e2Var != null) {
                if (e2Var.u2()) {
                    return 4;
                }
                if (e2Var.l0() == 1) {
                    return 3;
                }
                if (e2Var.Q1()) {
                    return 5;
                }
                if (e2Var.T1()) {
                    return 6;
                }
                if (e2Var.R1()) {
                    return 7;
                }
                if (e2Var.S1()) {
                    return 8;
                }
                if (!e2Var.A1 || e2Var.z1 == null) {
                    return e2Var.v2() ? 2 : 1;
                }
                return 9;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String l(e2 e2Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, e2Var, str)) == null) {
            if (e2Var.J() != null) {
                str2 = e2Var.J().getName_show();
                if (!StringUtils.isNull(str2) && str2.length() > 10) {
                    str2 = str2.substring(0, 10) + "...";
                }
            } else {
                str2 = "";
            }
            return StringUtils.isNull(str2) ? str : str2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? TbadkCoreApplication.getInst().appResponseToCmd(2001445) : invokeV.booleanValue;
    }

    public static String v(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65547, null, str, str2, z)) == null) ? w(str, "copy", str2, z) : (String) invokeLLZ.objValue;
    }

    public static String w(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
            if (m.isEmpty(str)) {
                str = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
            }
            String e2 = e(e(str, "sfc=" + str2), "client_type=2");
            String e3 = e(e2, "client_version=" + TbConfig.getVersion());
            String e4 = e(e3, "st=" + (System.currentTimeMillis() / 1000));
            String e5 = e(e4, "is_video=" + z);
            if (str3 != null) {
                if (SwitchManager.getInstance().findType(UrlNeedCuidSwitch.URL_NEED_CUID_SWITCH) == 1) {
                    c2 = t.c(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
                } else {
                    c2 = t.c(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
                }
                return e(e5, "unique=" + c2);
            }
            return e5;
        }
        return (String) invokeCommon.objValue;
    }

    public final String d(String str, int i2, int i3, String str2) {
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

    public final ShareItem g(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareItem)) == null) {
            if (WeChatShareSmallAppToH5Switch.isOn() && c.a.t0.b.d.n0() && (!StringUtils.isNull(shareItem.y0) || !StringUtils.isNull(shareItem.z0) || shareItem.A0 != null)) {
                if (!StringUtils.isNull(shareItem.y0)) {
                    shareItem.r = m.cutString(shareItem.y0, 100);
                }
                if (!StringUtils.isNull(shareItem.z0)) {
                    shareItem.s = m.cutString(shareItem.z0, 100);
                }
                Uri uri = shareItem.A0;
                if (uri != null) {
                    shareItem.v = uri;
                }
            }
            if (WeChatShareSmallAppToH5Switch.isOn() && !StringUtils.isNull(shareItem.t)) {
                if (c.a.t0.b.d.n0()) {
                    shareItem.t = e(shareItem.t, "&source=12_16_sharecard_a");
                } else if (c.a.t0.b.d.o0()) {
                    shareItem.t = e(shareItem.t, "&source=12_16_sharecard");
                }
            }
            return shareItem;
        }
        return (ShareItem) invokeL.objValue;
    }

    public final ShareItem h(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareItem)) == null) {
            if (c.a.t0.b.d.n0() && (shareItem.A0 != null || !StringUtils.isNull(shareItem.z0))) {
                if (!StringUtils.isNull(shareItem.z0)) {
                    shareItem.s = m.cutString(shareItem.z0, 100);
                }
                Uri uri = shareItem.A0;
                if (uri != null) {
                    shareItem.v = uri;
                }
            }
            if (c.a.t0.b.d.n0()) {
                if (!StringUtils.isNull(shareItem.t)) {
                    shareItem.t = e(shareItem.t, "&source=12_16_sharecard_a");
                }
            } else if (c.a.t0.b.d.o0() && !StringUtils.isNull(shareItem.t)) {
                shareItem.t = e(shareItem.t, "&source=12_16_sharecard");
            }
            return shareItem;
        }
        return (ShareItem) invokeL.objValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
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

    public void o(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, shareItem) == null) || this.f14451c == null || shareItem == null) {
            return;
        }
        shareItem.s = d(shareItem.s, 80, 32, shareItem.h0 ? this.f14452d : "");
        if (!QqShareH5Switch.isOn() && !m.isEmpty(shareItem.k0)) {
            shareItem.v = Uri.parse(shareItem.k0);
            this.f14451c.a(x(shareItem, Share.QQFRIEND), 8, true);
        } else if (!QqShareH5Switch.isOn() && m.isEmpty(shareItem.k0) && !m.isEmpty(shareItem.K) && !"0".equals(shareItem.K)) {
            if (this.f14454f == null) {
                c.a.t0.t.g.b bVar = new c.a.t0.t.g.b();
                this.f14454f = bVar;
                bVar.c(this.f14456h);
            }
            this.f14454f.b(shareItem);
        } else {
            if (!QqShareH5Switch.isOn()) {
                if (this.f14454f == null) {
                    this.f14454f = new c.a.t0.t.g.b();
                }
                this.f14454f.b(shareItem);
            }
            ShareItem x = x(shareItem, Share.QQFRIEND);
            h(x);
            this.f14451c.a(x, 8, true);
        }
    }

    public void p(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, shareItem) == null) || this.f14451c == null) {
            return;
        }
        shareItem.s = d(shareItem.s, 80, 32, shareItem.h0 ? this.f14452d : "");
        if (!QqShareH5Switch.isOn() && !m.isEmpty(shareItem.k0)) {
            shareItem.v = Uri.parse(shareItem.k0);
            this.f14451c.a(x(shareItem, "qzone"), 4, true);
        } else if (!QqShareH5Switch.isOn() && m.isEmpty(shareItem.k0) && !m.isEmpty(shareItem.K) && !"0".equals(shareItem.K)) {
            if (this.f14454f == null) {
                c.a.t0.t.g.b bVar = new c.a.t0.t.g.b();
                this.f14454f = bVar;
                bVar.c(this.f14457i);
            }
            this.f14454f.b(shareItem);
        } else {
            if (!QqShareH5Switch.isOn()) {
                if (this.f14454f == null) {
                    this.f14454f = new c.a.t0.t.g.b();
                }
                this.f14454f.b(shareItem);
            }
            this.f14451c.a(x(shareItem, "qzone"), 4, true);
        }
    }

    public void q(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, shareItem) == null) || this.f14451c == null) {
            return;
        }
        shareItem.s = d(shareItem.s, PbFullScreenEditorActivity.REPLY_MAX_SIZE, 20, shareItem.h0 ? this.f14452d : "");
        this.f14451c.a(x(shareItem, "renren"), 7, true);
    }

    public void r(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, shareItem) == null) || this.f14451c == null) {
            return;
        }
        if (!c.a.t0.t.g.a.b(TbadkApplication.getInst().getApplicationContext(), 6)) {
            BdToast.c(TbadkApplication.getInst().getApplicationContext(), TbadkApplication.getInst().getApplicationContext().getText(j.share_sina_weibo_not_install)).q();
            return;
        }
        shareItem.s = d(shareItem.s, PbFullScreenEditorActivity.REPLY_MAX_SIZE, 20, shareItem.h0 ? this.f14453e : "");
        this.f14451c.a(x(shareItem, "sina_weibo"), 6, true);
    }

    public void s(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareItem) == null) || this.f14451c == null) {
            return;
        }
        shareItem.s = d(shareItem.s, PbFullScreenEditorActivity.REPLY_MAX_SIZE, 20, shareItem.h0 ? this.f14452d : "");
        this.f14451c.a(x(shareItem, "tencent_weibo"), 5, true);
    }

    public void t(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, shareItem) == null) || this.f14451c == null || shareItem == null) {
            return;
        }
        if (StringUtils.isNull(shareItem.K)) {
            shareItem.s = d(shareItem.s, 80, 20, shareItem.h0 ? this.f14452d : "");
        }
        if (shareItem.m0 && !m.isEmpty(shareItem.k0)) {
            shareItem.v = Uri.parse(shareItem.k0);
            ShareItem x = x(shareItem, ThirdPartyUtil.TYPE_WEIXIN);
            g(x);
            this.f14451c.a(x, 3, false);
        } else if (shareItem.m0 && m.isEmpty(shareItem.k0) && !m.isEmpty(shareItem.K) && !"0".equals(shareItem.K)) {
            if (this.f14454f == null) {
                c.a.t0.t.g.b bVar = new c.a.t0.t.g.b();
                this.f14454f = bVar;
                bVar.c(this.f14455g);
            }
            this.f14454f.b(shareItem);
        } else {
            if (shareItem.y == 4) {
                if (this.f14454f == null) {
                    this.f14454f = new c.a.t0.t.g.b();
                }
                this.f14454f.b(shareItem);
            }
            ShareItem x2 = x(shareItem, ThirdPartyUtil.TYPE_WEIXIN);
            g(x2);
            this.f14451c.a(x2, 3, false);
        }
    }

    public void u(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, shareItem) == null) || this.f14451c == null || shareItem == null) {
            return;
        }
        shareItem.s = d(shareItem.s, 80, 20, shareItem.h0 ? this.f14452d : "");
        this.f14451c.a(x(shareItem, Share.WEIXIN_TIMELINE), 2, false);
    }

    public final ShareItem x(ShareItem shareItem, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, shareItem, str)) == null) {
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
                if (!m(uri3) && !y(uri3)) {
                    shareItem.v = Uri.parse("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
                } else {
                    shareItem.v = Uri.parse(uri3);
                    e(uri3, "sfc=" + str);
                }
            }
            if (shareItem.i0) {
                shareItem.t = w(shareItem.t, str, shareItem.K, UtilHelper.isVideoThread(shareItem.M));
            }
            return shareItem;
        }
        return (ShareItem) invokeLL.objValue;
    }

    public final boolean y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
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
