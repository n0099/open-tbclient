package b.d.b.a.b;

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
    public final WebView f31485a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31486b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31487c;

    /* renamed from: d  reason: collision with root package name */
    public URL f31488d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f31489e;

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
            this.f31489e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f31489e.f31485a == null) {
                        return;
                    }
                    this.f31489e.f31488d = new URL(this.f31489e.f31485a.getUrl());
                } catch (MalformedURLException unused) {
                }
            }
        }
    }

    /* renamed from: b.d.b.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1496b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f31490e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f31491f;

        public RunnableC1496b(b bVar, String str) {
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
            this.f31491f = bVar;
            this.f31490e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    URL url = new URL(this.f31491f.f31485a.getUrl());
                    if (this.f31491f.f31488d != null && !url.sameFile(this.f31491f.f31488d)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(url.toString());
                        hashSet.add(this.f31491f.f31488d.toString());
                        return;
                    }
                } catch (MalformedURLException unused) {
                }
                String str = this.f31491f.f31486b;
                if (!TextUtils.isEmpty(this.f31490e)) {
                    str = str + "(" + this.f31490e + SmallTailInfo.EMOTION_SUFFIX;
                }
                if (LogUtil.DEBUG) {
                    LogUtil.logd("loadUrl=" + str);
                }
                try {
                    if (this.f31491f.f31485a == null) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.f31491f.f31485a.evaluateJavascript(str, null);
                        return;
                    }
                    this.f31491f.f31485a.loadUrl("javascript:" + str);
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
        public final /* synthetic */ String f31492e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f31493f;

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
            this.f31493f = bVar;
            this.f31492e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    URL url = new URL(this.f31493f.f31485a.getUrl());
                    if (this.f31493f.f31488d != null && !url.sameFile(this.f31493f.f31488d)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(url.toString());
                        hashSet.add(this.f31493f.f31488d.toString());
                        return;
                    }
                } catch (MalformedURLException unused) {
                }
                String str = this.f31493f.f31487c;
                if (!TextUtils.isEmpty(this.f31492e)) {
                    str = str + "(" + this.f31492e + SmallTailInfo.EMOTION_SUFFIX;
                }
                if (LogUtil.DEBUG) {
                    LogUtil.logd("loadUrl=" + str);
                }
                try {
                    if (this.f31493f.f31485a == null) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.f31493f.f31485a.evaluateJavascript(str, null);
                        return;
                    }
                    this.f31493f.f31485a.loadUrl("javascript:" + str);
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
        this.f31485a = webView;
        this.f31486b = str;
        this.f31487c = str2;
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
                LogUtil.logd("sucessJsCallback=" + str + "#" + this.f31486b);
            }
            if (TextUtils.isEmpty(this.f31486b) || this.f31485a == null) {
                return;
            }
            c(new RunnableC1496b(this, str));
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(this.f31487c) || this.f31485a == null) {
            return;
        }
        c(new c(this, str));
    }
}
