package c.e.b.a.b;

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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WebView a;

    /* renamed from: b  reason: collision with root package name */
    public final String f28491b;

    /* renamed from: c  reason: collision with root package name */
    public final String f28492c;

    /* renamed from: d  reason: collision with root package name */
    public URL f28493d;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28494e;

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
            this.f28494e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f28494e.a == null) {
                        return;
                    }
                    this.f28494e.f28493d = new URL(this.f28494e.a.getUrl());
                } catch (MalformedURLException unused) {
                }
            }
        }
    }

    /* renamed from: c.e.b.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1571b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f28495e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f28496f;

        public RunnableC1571b(b bVar, String str) {
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
            this.f28496f = bVar;
            this.f28495e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    URL url = new URL(this.f28496f.a.getUrl());
                    if (this.f28496f.f28493d != null && !url.sameFile(this.f28496f.f28493d)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(url.toString());
                        hashSet.add(this.f28496f.f28493d.toString());
                        return;
                    }
                } catch (MalformedURLException unused) {
                }
                String str = this.f28496f.f28491b;
                if (!TextUtils.isEmpty(this.f28495e)) {
                    str = str + "(" + this.f28495e + SmallTailInfo.EMOTION_SUFFIX;
                }
                if (LogUtil.DEBUG) {
                    LogUtil.logd("loadUrl=" + str);
                }
                try {
                    if (this.f28496f.a == null) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.f28496f.a.evaluateJavascript(str, null);
                        return;
                    }
                    this.f28496f.a.loadUrl("javascript:" + str);
                } catch (Throwable unused2) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f28497e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f28498f;

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
            this.f28498f = bVar;
            this.f28497e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    URL url = new URL(this.f28498f.a.getUrl());
                    if (this.f28498f.f28493d != null && !url.sameFile(this.f28498f.f28493d)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(url.toString());
                        hashSet.add(this.f28498f.f28493d.toString());
                        return;
                    }
                } catch (MalformedURLException unused) {
                }
                String str = this.f28498f.f28492c;
                if (!TextUtils.isEmpty(this.f28497e)) {
                    str = str + "(" + this.f28497e + SmallTailInfo.EMOTION_SUFFIX;
                }
                if (LogUtil.DEBUG) {
                    LogUtil.logd("loadUrl=" + str);
                }
                try {
                    if (this.f28498f.a == null) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.f28498f.a.evaluateJavascript(str, null);
                        return;
                    }
                    this.f28498f.a.loadUrl("javascript:" + str);
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
        this.a = webView;
        this.f28491b = str;
        this.f28492c = str2;
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
                LogUtil.logd("sucessJsCallback=" + str + "#" + this.f28491b);
            }
            if (TextUtils.isEmpty(this.f28491b) || this.a == null) {
                return;
            }
            c(new RunnableC1571b(this, str));
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(this.f28492c) || this.a == null) {
            return;
        }
        c(new c(this, str));
    }
}
