package c.a.r0.y.n;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.r0.a.k;
import c.a.r0.a.y0.d;
import c.a.r0.a.y0.f.a;
import c.a.r0.a.z2.q;
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
public class a implements c.a.r0.a.y0.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f12143e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0631a f12144b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f12145c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f12146d;

    /* renamed from: c.a.r0.y.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0824a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12147e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f12148f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f12149g;

        public RunnableC0824a(a aVar, String str, Map map) {
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
            this.f12149g = aVar;
            this.f12147e = str;
            this.f12148f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f12149g.f12146d) {
                    boolean unused = a.f12143e;
                    return;
                }
                this.f12149g.f12145c.setDataSource(this.f12149g.getContext(), Uri.parse(c.a.r0.a.y0.j.a.a(this.f12147e)), this.f12148f);
                Bundle metaData = this.f12149g.f12145c.getMetaData();
                if (this.f12149g.f12144b != null) {
                    this.f12149g.f12144b.a(metaData);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(8283548, "Lc/a/r0/y/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(8283548, "Lc/a/r0/y/n/a;");
                return;
            }
        }
        f12143e = k.a;
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
        this.f12146d = false;
    }

    @Override // c.a.r0.a.y0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f12145c = new CyberExtractor(true);
            aVar.a(true);
        }
    }

    @Override // c.a.r0.a.y0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.r0.a.c1.a.c() : (Context) invokeV.objValue;
    }

    @Override // c.a.r0.a.y0.f.a
    public void k(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, map) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        q.j(new RunnableC0824a(this, str, map), "loadMetadata");
    }

    @Override // c.a.r0.a.y0.d
    @Nullable
    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.y0.f.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f12146d = true;
            CyberExtractor cyberExtractor = this.f12145c;
            if (cyberExtractor != null) {
                cyberExtractor.release();
            }
            this.f12145c = null;
            a.InterfaceC0631a interfaceC0631a = this.f12144b;
            if (interfaceC0631a != null) {
                interfaceC0631a.onRelease();
            }
            this.f12144b = null;
        }
    }

    @Override // c.a.r0.a.y0.f.a
    public void w(a.InterfaceC0631a interfaceC0631a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0631a) == null) {
            this.f12144b = interfaceC0631a;
        }
    }
}
