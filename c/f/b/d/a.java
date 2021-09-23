package c.f.b.d;

import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.core.Domains;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f32381c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f32382a;

    /* renamed from: b  reason: collision with root package name */
    public String f32383b;

    /* renamed from: c.f.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C1471a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f32384a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-733425835, "Lc/f/b/d/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-733425835, "Lc/f/b/d/a$b;");
                    return;
                }
            }
            f32384a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1462214061, "Lc/f/b/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1462214061, "Lc/f/b/d/a;");
                return;
            }
        }
        f32381c = new String[]{Domains.DU_XIAO_MAN_PAY, Domains.DU_XIAO_MAN, Domains.BAIFUBAO, ".8.baidu.com", ".wallet.baidu.com", ".umoney.baidu.com", ".icash.baidu.com", ".yqh.baidu.com", ".ibeauty.baidu.com", ".front.baidu.com", ".activity8.baidu.com", ".qianbao.baidu.com", ".dxmbaoxian.com", ".oneicash.baidu.com", ".twoicash.baidu.com", ".threeicash.baidu.com", ".onejin.baidu.com", ".twojin.baidu.com", ".threejin.baidu.com", ".dxmcash.baidu.com", ".dxmoney.baidu.com", ".fincash.baidu.com", ".www.baiyingfund.com", ".www.duxiaomanfund.com"};
    }

    public /* synthetic */ a(C1471a c1471a) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f32384a : (a) invokeV.objValue;
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(1, i2);
            Date time = calendar.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
            this.f32383b = simpleDateFormat.format(time);
            String str = "--DxmCookieManager---cookie----expires--->" + this.f32383b;
        }
    }

    public final void c(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            try {
                b(i2);
                String[] f2 = f(SdkInitResponse.getInstance().getCookiesSyncDomainList(this.f32382a));
                if (f2 == null) {
                    f2 = f32381c;
                }
                CookieSyncManager.createInstance(this.f32382a);
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setAcceptCookie(true);
                String str2 = "OPENBDUSS=" + str;
                String str3 = ";expires=" + this.f32383b;
                for (String str4 : f2) {
                    if (!str4.startsWith(".")) {
                        str4 = "." + str4;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(";path=/");
                    sb.append(str3);
                    sb.append(";domain=");
                    sb.append(str4);
                    sb.append(";httponly");
                    sb.append(";secure");
                    String str5 = "---DxmCookieManager---setCookie value--->" + sb.toString();
                    cookieManager.setCookie("https://www" + str4, sb.toString());
                }
                if (Build.VERSION.SDK_INT < 21) {
                    CookieSyncManager.getInstance().sync();
                } else {
                    cookieManager.flush();
                }
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            c(8, str);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c(-8, "");
        }
    }

    public final String[] f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return (String[]) JsonUtils.fromJson(str, String[].class);
            } catch (JSONException unused) {
                return null;
            }
        }
        return (String[]) invokeL.objValue;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32382a = BaiduWalletDelegate.getInstance().getAppContext();
    }
}
