package c.a.n0.y.h;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.o0.d;
import c.a.n0.a.o0.f.a;
import c.a.n0.a.p2.q;
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
public class a implements c.a.n0.a.o0.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f9575e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0387a f9576b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f9577c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f9578d;

    /* renamed from: c.a.n0.y.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0776a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f9579b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f9580c;

        public RunnableC0776a(a aVar, String str, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9580c = aVar;
            this.a = str;
            this.f9579b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f9580c.f9578d) {
                    if (a.f9575e) {
                        Log.d("MediaExtractorWidget", "media extractor already released");
                        return;
                    }
                    return;
                }
                this.f9580c.f9577c.setDataSource(this.f9580c.getContext(), Uri.parse(c.a.n0.a.o0.j.a.a(this.a)), this.f9579b);
                Bundle metaData = this.f9580c.f9577c.getMetaData();
                if (this.f9580c.f9576b != null) {
                    this.f9580c.f9576b.a(metaData);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1352011938, "Lc/a/n0/y/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1352011938, "Lc/a/n0/y/h/a;");
                return;
            }
        }
        f9575e = c.a.n0.a.a.a;
    }

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invoker, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f9578d = false;
    }

    @Override // c.a.n0.a.o0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f9577c = new CyberExtractor(true);
            aVar.a(true);
        }
    }

    @Override // c.a.n0.a.o0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.n0.a.s0.a.c() : (Context) invokeV.objValue;
    }

    @Override // c.a.n0.a.o0.f.a
    public void k(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, map) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        q.j(new RunnableC0776a(this, str, map), "loadMetadata");
    }

    @Override // c.a.n0.a.o0.d
    @Nullable
    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.o0.f.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f9578d = true;
            CyberExtractor cyberExtractor = this.f9577c;
            if (cyberExtractor != null) {
                cyberExtractor.release();
            }
            this.f9577c = null;
            a.InterfaceC0387a interfaceC0387a = this.f9576b;
            if (interfaceC0387a != null) {
                interfaceC0387a.onRelease();
            }
            this.f9576b = null;
        }
    }

    @Override // c.a.n0.a.o0.f.a
    public void w(a.InterfaceC0387a interfaceC0387a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0387a) == null) {
            this.f9576b = interfaceC0387a;
        }
    }
}
