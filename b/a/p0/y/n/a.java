package b.a.p0.y.n;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.k;
import b.a.p0.a.y0.d;
import b.a.p0.a.y0.f.a;
import b.a.p0.a.z2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.extractor.CyberExtractor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements b.a.p0.a.y0.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f12391e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f12392a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0473a f12393b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f12394c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f12395d;

    /* renamed from: b.a.p0.y.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0666a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12396e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f12397f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f12398g;

        public RunnableC0666a(a aVar, String str, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12398g = aVar;
            this.f12396e = str;
            this.f12397f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f12398g.f12395d) {
                    boolean unused = a.f12391e;
                    return;
                }
                this.f12398g.f12394c.setDataSource(this.f12398g.getContext(), Uri.parse(b.a.p0.a.y0.j.a.a(this.f12396e)), this.f12397f);
                Bundle metaData = this.f12398g.f12394c.getMetaData();
                if (this.f12398g.f12393b != null) {
                    this.f12398g.f12393b.a(metaData);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-378371815, "Lb/a/p0/y/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-378371815, "Lb/a/p0/y/n/a;");
                return;
            }
        }
        f12391e = k.f6863a;
    }

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invoker, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12392a = str;
        this.f12395d = false;
    }

    @Override // b.a.p0.a.y0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f12394c = new CyberExtractor(true);
            aVar.a(true);
        }
    }

    @Override // b.a.p0.a.y0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12392a : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b.a.p0.a.c1.a.c() : (Context) invokeV.objValue;
    }

    @Override // b.a.p0.a.y0.f.a
    public void k(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, map) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        q.j(new RunnableC0666a(this, str, map), "loadMetadata");
    }

    @Override // b.a.p0.a.y0.d
    @Nullable
    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.y0.f.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f12395d = true;
            CyberExtractor cyberExtractor = this.f12394c;
            if (cyberExtractor != null) {
                cyberExtractor.release();
            }
            this.f12394c = null;
            a.InterfaceC0473a interfaceC0473a = this.f12393b;
            if (interfaceC0473a != null) {
                interfaceC0473a.onRelease();
            }
            this.f12393b = null;
        }
    }

    @Override // b.a.p0.a.y0.f.a
    public void w(a.InterfaceC0473a interfaceC0473a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0473a) == null) {
            this.f12393b = interfaceC0473a;
        }
    }
}
