package c.a.p0.y.h;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.p0.a.o0.d;
import c.a.p0.a.o0.f.a;
import c.a.p0.a.p2.q;
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
/* loaded from: classes2.dex */
public class a implements c.a.p0.a.o0.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f11468e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0399a f11469b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f11470c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f11471d;

    /* renamed from: c.a.p0.y.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0781a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11472e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f11473f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f11474g;

        public RunnableC0781a(a aVar, String str, Map map) {
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
            this.f11474g = aVar;
            this.f11472e = str;
            this.f11473f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11474g.f11471d) {
                    boolean unused = a.f11468e;
                    return;
                }
                this.f11474g.f11470c.setDataSource(this.f11474g.getContext(), Uri.parse(c.a.p0.a.o0.j.a.a(this.f11472e)), this.f11473f);
                Bundle metaData = this.f11474g.f11470c.getMetaData();
                if (this.f11474g.f11469b != null) {
                    this.f11474g.f11469b.a(metaData);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-671953568, "Lc/a/p0/y/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-671953568, "Lc/a/p0/y/h/a;");
                return;
            }
        }
        f11468e = c.a.p0.a.a.a;
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
        this.f11471d = false;
    }

    @Override // c.a.p0.a.o0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f11470c = new CyberExtractor(true);
            aVar.a(true);
        }
    }

    @Override // c.a.p0.a.o0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.p0.a.s0.a.c() : (Context) invokeV.objValue;
    }

    @Override // c.a.p0.a.o0.f.a
    public void k(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, map) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        q.j(new RunnableC0781a(this, str, map), "loadMetadata");
    }

    @Override // c.a.p0.a.o0.d
    @Nullable
    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.o0.f.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f11471d = true;
            CyberExtractor cyberExtractor = this.f11470c;
            if (cyberExtractor != null) {
                cyberExtractor.release();
            }
            this.f11470c = null;
            a.InterfaceC0399a interfaceC0399a = this.f11469b;
            if (interfaceC0399a != null) {
                interfaceC0399a.onRelease();
            }
            this.f11469b = null;
        }
    }

    @Override // c.a.p0.a.o0.f.a
    public void w(a.InterfaceC0399a interfaceC0399a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0399a) == null) {
            this.f11469b = interfaceC0399a;
        }
    }
}
