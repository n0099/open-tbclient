package cn.com.chinatelecom.gateway.lib.b;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f29222b;

    /* renamed from: c  reason: collision with root package name */
    public String f29223c;

    /* renamed from: d  reason: collision with root package name */
    public String f29224d;

    /* renamed from: e  reason: collision with root package name */
    public String f29225e;

    /* renamed from: f  reason: collision with root package name */
    public String f29226f;

    /* renamed from: g  reason: collision with root package name */
    public String f29227g;

    /* renamed from: h  reason: collision with root package name */
    public String f29228h;

    /* renamed from: i  reason: collision with root package name */
    public String f29229i;

    /* renamed from: j  reason: collision with root package name */
    public String f29230j;
    public String k;
    public String l;
    public String m;
    public String n;
    public int o;
    public String p;
    public long q;
    public long r;
    public String s;
    public StringBuffer t;
    public long u;
    public long v;

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = new StringBuffer();
        this.f29223c = "";
        this.f29225e = "";
        this.n = "";
        this.m = "";
        this.p = "";
        this.a = "1.1";
        long currentTimeMillis = System.currentTimeMillis();
        this.u = currentTimeMillis;
        this.f29222b = a(currentTimeMillis);
        this.f29224d = "";
        this.f29226f = "";
        this.f29227g = Build.BRAND;
        this.f29228h = Build.MODEL;
        this.f29229i = "Android";
        this.f29230j = Build.VERSION.RELEASE;
        this.k = "SDK-JJ-v3.6.2";
        this.l = str;
        this.s = "0";
    }

    public static String a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j2)) == null) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA).format(new Date(j2));
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeJ.objValue;
    }

    public b a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            this.o = i2;
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f29224d = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            this.q = j2;
            return this;
        }
        return (b) invokeJ.objValue;
    }

    public b b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f29225e = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.f29226f = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.m = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.n = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            this.p = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.s = str;
            }
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            StringBuffer stringBuffer = this.t;
            stringBuffer.append(str);
            stringBuffer.append(StringUtils.LF);
            return this;
        }
        return (b) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.v = currentTimeMillis;
                this.r = currentTimeMillis - this.u;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("v", this.a);
                jSONObject.put("t", this.f29222b);
                jSONObject.put("tag", this.f29223c);
                jSONObject.put("ai", this.f29224d);
                jSONObject.put(AppIconSetting.DEFAULT_LARGE_ICON, this.f29225e);
                jSONObject.put(NotificationStyle.NOTIFICATION_STYLE, this.f29226f);
                jSONObject.put(TtmlNode.TAG_BR, this.f29227g);
                jSONObject.put("ml", this.f29228h);
                jSONObject.put(UrlOcrConfig.IdCardKey.OS, this.f29229i);
                jSONObject.put(SearchJsBridge.COOKIE_OV, this.f29230j);
                jSONObject.put("sv", this.k);
                jSONObject.put("ri", this.l);
                jSONObject.put(RetrieveTaskManager.KEY, this.m);
                jSONObject.put("p", this.n);
                jSONObject.put("rt", this.o);
                jSONObject.put("msg", this.p);
                jSONObject.put("st", this.q);
                jSONObject.put("tt", this.r);
                jSONObject.put("ot", this.s);
                jSONObject.put("ep", this.t.toString());
                return jSONObject.toString();
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
