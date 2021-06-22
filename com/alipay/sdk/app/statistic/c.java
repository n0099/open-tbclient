package com.alipay.sdk.app.statistic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    public static final String A = "ClientBindException";
    public static final String B = "SaveTradeTokenError";
    public static final String C = "ClientBindServiceFailed";
    public static final String D = "BindWaitTimeoutEx";
    public static final String E = "CheckClientExistEx";
    public static final String F = "CheckClientSignEx";
    public static final String G = "GetInstalledAppEx";
    public static final String H = "ParserTidClientKeyEx";
    public static final String I = "GetInstalledAppEx";
    public static final String J = "StartLaunchAppTransEx";
    public static final String K = "CheckLaunchAppExistEx";
    public static final String L = "LogCurrentAppLaunchSwitch";
    public static final String M = "LogCurrentQueryTime";
    public static final String N = "LogCalledPackage";
    public static final String O = "LogBindCalledH5";
    public static final String P = "LogCalledH5";
    public static final String Q = "LogHkLoginByIntent";
    public static final String R = "SchemePayWrongHashEx";
    public static final String S = "LogAppLaunchSwitchEnabled";
    public static final String T = "H5CbUrlEmpty";
    public static final String U = "H5CbEx";
    public static final String V = "BuildSchemePayUriError";
    public static final String W = "StartActivityEx";
    public static final String X = "JSONEx";
    public static final String Y = "ParseBundleSerializableError";
    public static final String Z = "ParseSchemeQueryError";

    /* renamed from: a  reason: collision with root package name */
    public static final String f1819a = "net";
    public static final String aa = "tid_context_null";
    public static final String ab = "partner";
    public static final String ac = "out_trade_no";
    public static final String ad = "trade_no";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1820b = "biz";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1821c = "cp";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1822d = "auth";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1823e = "third";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1824f = "tid";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1825g = "FormatResultEx";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1826h = "GetApdidEx";

    /* renamed from: i  reason: collision with root package name */
    public static final String f1827i = "GetApdidNull";
    public static final String j = "GetApdidTimeout";
    public static final String k = "GetUtdidEx";
    public static final String l = "GetPackageInfoEx";
    public static final String m = "NotIncludeSignatures";
    public static final String n = "GetInstalledPackagesEx";
    public static final String o = "GetPublicKeyFromSignEx";
    public static final String p = "H5PayNetworkError";
    public static final String q = "H5AuthNetworkError";
    public static final String r = "SSLError";
    public static final String s = "SSLProceed";
    public static final String t = "SSLDenied";
    public static final String u = "H5PayDataAnalysisError";
    public static final String v = "H5AuthDataAnalysisError";
    public static final String w = "PublicKeyUnmatch";
    public static final String x = "ClientBindFailed";
    public static final String y = "TriDesEncryptError";
    public static final String z = "TriDesDecryptError";
    public String ae;
    public String af;
    public String ag;
    public String ah;
    public String ai;
    public String aj;
    public String ak;
    public String al;
    public String am = "";
    public String an;

    public c(Context context) {
        context = context != null ? context.getApplicationContext() : context;
        this.ae = b();
        this.ag = a(context);
        this.ah = c();
        this.ai = d();
        this.aj = b(context);
        this.ak = "-";
        this.al = "-";
        this.an = "-";
    }

    private String b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace(PreferencesUtil.LEFT_MOUNT, "【").replace(PreferencesUtil.RIGHT_MOUNT, "】").replace("(", "（").replace(SmallTailInfo.EMOTION_SUFFIX, "）").replace(",", "，").replace("-", "=").replace(PayTypeItemView.PayTypeItemViewData.MASK_FLAG, Constants.WAVE_SEPARATOR);
    }

    private String c(String str) {
        String str2;
        String[] split = str.split("&");
        String str3 = null;
        if (split != null) {
            String str4 = null;
            for (String str5 : split) {
                String[] split2 = str5.split("=");
                if (split2 != null && split2.length == 2) {
                    if (split2[0].equalsIgnoreCase(ab)) {
                        split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase(ac)) {
                        str3 = split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase(ad)) {
                        str4 = split2[1].replace("\"", "");
                    }
                }
            }
            str2 = str3;
            str3 = str4;
        } else {
            str2 = null;
        }
        String b2 = b(str3);
        String b3 = b(str2);
        return String.format("%s,%s,-,%s,-,-,-", b2, b3, b(b3));
    }

    private String d() {
        return String.format("%s,%s,-,-,-", b(com.alipay.sdk.tid.b.a(com.alipay.sdk.sys.b.a().b()).a()), b(com.alipay.sdk.sys.b.a().e()));
    }

    public boolean a() {
        return TextUtils.isEmpty(this.am);
    }

    public void a(String str, String str2, Throwable th) {
        a(str, str2, a(th));
    }

    @SuppressLint({"SimpleDateFormat"})
    private String b() {
        return String.format("123456789,%s", new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()));
    }

    public void a(String str, String str2, Throwable th, String str3) {
        a(str, str2, a(th), str3);
    }

    public void a(String str, String str2, String str3, String str4) {
        String str5 = "";
        if (!TextUtils.isEmpty(this.am)) {
            str5 = "" + PayTypeItemView.PayTypeItemViewData.MASK_FLAG;
        }
        this.am += (str5 + String.format("%s,%s,%s,%s", str, str2, b(str3), str4));
    }

    private String b(Context context) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", b(com.alipay.sdk.util.a.d(context)), "android", b(Build.VERSION.RELEASE), b(Build.MODEL), "-", b(com.alipay.sdk.util.a.a(context).a()), b(com.alipay.sdk.util.a.b(context).b()), "gw", b(com.alipay.sdk.util.a.a(context).b()));
    }

    public void a(String str, String str2, String str3) {
        a(str, str2, str3, "-");
    }

    private String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(th.getClass().getName());
            stringBuffer.append(":");
            stringBuffer.append(th.getMessage());
            stringBuffer.append(" 》 ");
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                for (int i2 = 0; i2 < stackTrace.length; i2++) {
                    stringBuffer.append(stackTrace[i2].toString() + " 》 ");
                }
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    private String c() {
        return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,-,-", b("15.6.5"), b("h.a.3.6.5"));
    }

    public String a(String str) {
        if (a()) {
            return "";
        }
        String c2 = c(str);
        this.af = c2;
        return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", this.ae, c2, this.ag, this.ah, this.ai, this.aj, this.ak, this.al, this.am, this.an);
    }

    private String a(Context context) {
        String str;
        String str2;
        String str3 = "-";
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                str = applicationContext.getPackageName();
                try {
                    str3 = applicationContext.getPackageManager().getPackageInfo(str, 0).versionName;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                str = "-";
            }
            str2 = str3;
            str3 = str;
        } else {
            str2 = "-";
        }
        return String.format("%s,%s,-,-,-", str3, str2);
    }
}
