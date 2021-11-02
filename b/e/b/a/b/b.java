package b.e.b.a.b;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WebView f30627a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30628b;

    /* renamed from: c  reason: collision with root package name */
    public final String f30629c;

    /* renamed from: d  reason: collision with root package name */
    public URL f30630d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f30631e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30631e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f30631e.f30627a == null) {
                        return;
                    }
                    this.f30631e.f30630d = new URL(this.f30631e.f30627a.getUrl());
                } catch (MalformedURLException unused) {
                }
            }
        }
    }

    /* renamed from: b.e.b.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1454b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f30632e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f30633f;

        public RunnableC1454b(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30633f = bVar;
            this.f30632e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    URL url = new URL(this.f30633f.f30627a.getUrl());
                    if (this.f30633f.f30630d != null && !url.sameFile(this.f30633f.f30630d)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(url.toString());
                        hashSet.add(this.f30633f.f30630d.toString());
                        return;
                    }
                } catch (MalformedURLException unused) {
                }
                String str = this.f30633f.f30628b;
                if (!TextUtils.isEmpty(this.f30632e)) {
                    str = str + "(" + this.f30632e + SmallTailInfo.EMOTION_SUFFIX;
                }
                if (LogUtil.DEBUG) {
                    LogUtil.logd("loadUrl=" + str);
                }
                try {
                    if (this.f30633f.f30627a == null) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.f30633f.f30627a.evaluateJavascript(str, null);
                        return;
                    }
                    this.f30633f.f30627a.loadUrl("javascript:" + str);
                } catch (Throwable unused2) {
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f30634e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f30635f;

        public c(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30635f = bVar;
            this.f30634e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    URL url = new URL(this.f30635f.f30627a.getUrl());
                    if (this.f30635f.f30630d != null && !url.sameFile(this.f30635f.f30630d)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(url.toString());
                        hashSet.add(this.f30635f.f30630d.toString());
                        return;
                    }
                } catch (MalformedURLException unused) {
                }
                String str = this.f30635f.f30629c;
                if (!TextUtils.isEmpty(this.f30634e)) {
                    str = str + "(" + this.f30634e + SmallTailInfo.EMOTION_SUFFIX;
                }
                if (LogUtil.DEBUG) {
                    LogUtil.logd("loadUrl=" + str);
                }
                try {
                    if (this.f30635f.f30627a == null) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.f30635f.f30627a.evaluateJavascript(str, null);
                        return;
                    }
                    this.f30635f.f30627a.loadUrl("javascript:" + str);
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30627a = webView;
        this.f30628b = str;
        this.f30629c = str2;
        if (webView != null) {
            c(new a(this));
        }
    }

    public final void c(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) || runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (LogUtil.DEBUG) {
                LogUtil.logd("sucessJsCallback=" + str + "#" + this.f30628b);
            }
            if (TextUtils.isEmpty(this.f30628b) || this.f30627a == null) {
                return;
            }
            c(new RunnableC1454b(this, str));
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(this.f30629c) || this.f30627a == null) {
            return;
        }
        c(new c(this, str));
    }
}
