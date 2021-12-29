package c.q.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class f0 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f31294e;

    public f0(i0 i0Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i0Var, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31294e = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String userAgentString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Context context = this.f31294e;
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    try {
                        Process.myPid();
                        if (context != null) {
                            try {
                                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                                    if (runningAppProcessInfo.pid == Process.myPid()) {
                                        str = runningAppProcessInfo.processName;
                                        break;
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                        str = null;
                        if (!TextUtils.equals(context.getPackageName(), str)) {
                            WebView.setDataDirectorySuffix(str);
                        }
                    } catch (Exception unused2) {
                    }
                }
                d3.a = System.getProperty("http.agent");
                if (Build.VERSION.SDK_INT >= 17) {
                    userAgentString = WebSettings.getDefaultUserAgent(context);
                } else if (Looper.myLooper() != Looper.getMainLooper()) {
                    w2.a.post(new z2(context));
                    return;
                } else {
                    userAgentString = new WebView(context).getSettings().getUserAgentString();
                }
                d3.a = userAgentString;
            } catch (Exception unused3) {
            }
        }
    }
}
