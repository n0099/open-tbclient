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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WebView f32097a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32098b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32099c;

    /* renamed from: d  reason: collision with root package name */
    public URL f32100d;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f32101e;

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
            this.f32101e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f32101e.f32097a == null) {
                        return;
                    }
                    this.f32101e.f32100d = new URL(this.f32101e.f32097a.getUrl());
                } catch (MalformedURLException unused) {
                }
            }
        }
    }

    /* renamed from: c.e.b.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1461b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f32102e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f32103f;

        public RunnableC1461b(b bVar, String str) {
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
            this.f32103f = bVar;
            this.f32102e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    URL url = new URL(this.f32103f.f32097a.getUrl());
                    if (this.f32103f.f32100d != null && !url.sameFile(this.f32103f.f32100d)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(url.toString());
                        hashSet.add(this.f32103f.f32100d.toString());
                        return;
                    }
                } catch (MalformedURLException unused) {
                }
                String str = this.f32103f.f32098b;
                if (!TextUtils.isEmpty(this.f32102e)) {
                    str = str + "(" + this.f32102e + SmallTailInfo.EMOTION_SUFFIX;
                }
                if (LogUtil.DEBUG) {
                    LogUtil.logd("loadUrl=" + str);
                }
                try {
                    if (this.f32103f.f32097a == null) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.f32103f.f32097a.evaluateJavascript(str, null);
                        return;
                    }
                    this.f32103f.f32097a.loadUrl("javascript:" + str);
                } catch (Throwable unused2) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f32104e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f32105f;

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
            this.f32105f = bVar;
            this.f32104e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    URL url = new URL(this.f32105f.f32097a.getUrl());
                    if (this.f32105f.f32100d != null && !url.sameFile(this.f32105f.f32100d)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(url.toString());
                        hashSet.add(this.f32105f.f32100d.toString());
                        return;
                    }
                } catch (MalformedURLException unused) {
                }
                String str = this.f32105f.f32099c;
                if (!TextUtils.isEmpty(this.f32104e)) {
                    str = str + "(" + this.f32104e + SmallTailInfo.EMOTION_SUFFIX;
                }
                if (LogUtil.DEBUG) {
                    LogUtil.logd("loadUrl=" + str);
                }
                try {
                    if (this.f32105f.f32097a == null) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.f32105f.f32097a.evaluateJavascript(str, null);
                        return;
                    }
                    this.f32105f.f32097a.loadUrl("javascript:" + str);
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
        this.f32097a = webView;
        this.f32098b = str;
        this.f32099c = str2;
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
                LogUtil.logd("sucessJsCallback=" + str + "#" + this.f32098b);
            }
            if (TextUtils.isEmpty(this.f32098b) || this.f32097a == null) {
                return;
            }
            c(new RunnableC1461b(this, str));
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(this.f32099c) || this.f32097a == null) {
            return;
        }
        c(new c(this, str));
    }
}
