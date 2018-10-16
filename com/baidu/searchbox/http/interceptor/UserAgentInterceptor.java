package com.baidu.searchbox.http.interceptor;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Version;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class UserAgentInterceptor implements Interceptor {
    private static final String VALUE_DEFAULT_OSVERSION = "0.0";
    private static final String VALUE_DEFAULT_SEPARATOR = "-";
    private static final String VALUE_DEFAULT_VERSIONNAME = "0.8";
    private Context mContext;
    private String mDefaultUserAgent = initDefaultUserAgent();

    public UserAgentInterceptor(Context context) {
        this.mContext = context;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String str = request.headers().get(HTTP.USER_AGENT);
        if (TextUtils.equals(str, Version.userAgent())) {
            return chain.proceed(request.newBuilder().header(HTTP.USER_AGENT, str + " " + this.mDefaultUserAgent).build());
        }
        return chain.proceed(request);
    }

    private String initDefaultUserAgent() {
        String stringBuffer;
        String replace;
        String property = System.getProperty("http.agent");
        if (TextUtils.isEmpty(property)) {
            stringBuffer = "";
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            int length = property.length();
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if (charAt <= 31 || charAt >= 127) {
                    stringBuffer2.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    stringBuffer2.append(charAt);
                }
            }
            stringBuffer = stringBuffer2.toString();
        }
        String str = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(str)) {
            replace = VALUE_DEFAULT_OSVERSION;
        } else {
            replace = str.replace(BaseRequestAction.SPLITE, "-");
        }
        return stringBuffer + " baiduboxapp/" + getVersionName(this.mContext) + " (Baidu; P1 " + replace + ")";
    }

    private String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return VALUE_DEFAULT_VERSIONNAME;
        }
    }
}
