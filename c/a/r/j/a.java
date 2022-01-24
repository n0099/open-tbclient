package c.a.r.j;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.r.h.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.C0259a a;

    /* renamed from: b  reason: collision with root package name */
    public C0260a f5116b;

    /* renamed from: c  reason: collision with root package name */
    public String f5117c;

    /* renamed from: c.a.r.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0260a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.r.h.d.a f5118b;

        /* renamed from: c  reason: collision with root package name */
        public TrustSubjectManager.d f5119c;

        /* renamed from: d  reason: collision with root package name */
        public ExecutorService f5120d;

        /* renamed from: e  reason: collision with root package name */
        public ExecutorService f5121e;

        public C0260a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
        }
    }

    /* loaded from: classes.dex */
    public interface c<T> {
        void a(int i2, Exception exc, Bundle bundle);

        void onResult(T t, Bundle bundle);
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5122e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5123f;

        public d(a aVar, c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5122e = cVar;
            this.f5123f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5122e.onResult(this.f5123f, null);
            }
        }
    }

    public a(String str) {
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
        this.f5117c = str;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            String format = String.format("%s-%s-", str, str2);
            try {
                str3 = new c.a.r.h.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(new c.a.r.h.a.a().a(format.getBytes("UTF-8")));
            } catch (UnsupportedEncodingException unused) {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "AAAAAAAA";
            }
            return format + str3;
        }
        return (String) invokeLL.objValue;
    }

    public final void a(C0260a c0260a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, c0260a) == null) {
            this.f5116b = c0260a;
            this.a = c0260a.f5118b.d().f("ids");
        }
    }

    public abstract String c();

    public byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f5117c : (String) invokeV.objValue;
    }

    public abstract void f(b bVar);

    public void g(c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f5116b.f5120d.submit(new d(this, cVar, c()));
        }
    }
}
