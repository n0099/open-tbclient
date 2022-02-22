package c.a.s0.y.n;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.s0.a.k;
import c.a.s0.a.y0.d;
import c.a.s0.a.y0.f.a;
import c.a.s0.a.z2.q;
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
/* loaded from: classes6.dex */
public class a implements c.a.s0.a.y0.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f12243e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0642a f12244b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f12245c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f12246d;

    /* renamed from: c.a.s0.y.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0835a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12247e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f12248f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f12249g;

        public RunnableC0835a(a aVar, String str, Map map) {
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
            this.f12249g = aVar;
            this.f12247e = str;
            this.f12248f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f12249g.f12246d) {
                    boolean unused = a.f12243e;
                    return;
                }
                this.f12249g.f12245c.setDataSource(this.f12249g.getContext(), Uri.parse(c.a.s0.a.y0.j.a.a(this.f12247e)), this.f12248f);
                Bundle metaData = this.f12249g.f12245c.getMetaData();
                if (this.f12249g.f12244b != null) {
                    this.f12249g.f12244b.a(metaData);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1799170915, "Lc/a/s0/y/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1799170915, "Lc/a/s0/y/n/a;");
                return;
            }
        }
        f12243e = k.a;
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
        this.a = str;
        this.f12246d = false;
    }

    @Override // c.a.s0.a.y0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f12245c = new CyberExtractor(true);
            aVar.a(true);
        }
    }

    @Override // c.a.s0.a.y0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.s0.a.c1.a.c() : (Context) invokeV.objValue;
    }

    @Override // c.a.s0.a.y0.f.a
    public void k(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, map) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        q.j(new RunnableC0835a(this, str, map), "loadMetadata");
    }

    @Override // c.a.s0.a.y0.d
    @Nullable
    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s0.a.y0.f.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f12246d = true;
            CyberExtractor cyberExtractor = this.f12245c;
            if (cyberExtractor != null) {
                cyberExtractor.release();
            }
            this.f12245c = null;
            a.InterfaceC0642a interfaceC0642a = this.f12244b;
            if (interfaceC0642a != null) {
                interfaceC0642a.onRelease();
            }
            this.f12244b = null;
        }
    }

    @Override // c.a.s0.a.y0.f.a
    public void w(a.InterfaceC0642a interfaceC0642a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0642a) == null) {
            this.f12244b = interfaceC0642a;
        }
    }
}
