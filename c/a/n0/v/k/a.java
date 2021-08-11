package c.a.n0.v.k;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.k;
import c.a.n0.a.v2.q;
import c.a.n0.a.y0.d;
import c.a.n0.a.y0.f.a;
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
/* loaded from: classes3.dex */
public class a implements c.a.n0.a.y0.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f12192e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f12193a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0453a f12194b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f12195c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f12196d;

    /* renamed from: c.a.n0.v.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0628a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12197e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f12198f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f12199g;

        public RunnableC0628a(a aVar, String str, Map map) {
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
            this.f12199g = aVar;
            this.f12197e = str;
            this.f12198f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f12199g.f12196d) {
                    boolean unused = a.f12192e;
                    return;
                }
                this.f12199g.f12195c.setDataSource(this.f12199g.getContext(), Uri.parse(c.a.n0.a.y0.j.a.a(this.f12197e)), this.f12198f);
                Bundle metaData = this.f12199g.f12195c.getMetaData();
                if (this.f12199g.f12194b != null) {
                    this.f12199g.f12194b.a(metaData);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1437810018, "Lc/a/n0/v/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1437810018, "Lc/a/n0/v/k/a;");
                return;
            }
        }
        f12192e = k.f6803a;
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
        this.f12193a = str;
        this.f12196d = false;
    }

    @Override // c.a.n0.a.y0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f12195c = new CyberExtractor(true);
            aVar.a(true);
        }
    }

    @Override // c.a.n0.a.y0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12193a : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.n0.a.c1.a.b() : (Context) invokeV.objValue;
    }

    @Override // c.a.n0.a.y0.d
    @Nullable
    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.y0.f.a
    public void k(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, map) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        q.i(new RunnableC0628a(this, str, map), "loadMetadata");
    }

    @Override // c.a.n0.a.y0.f.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f12196d = true;
            CyberExtractor cyberExtractor = this.f12195c;
            if (cyberExtractor != null) {
                cyberExtractor.release();
            }
            this.f12195c = null;
            a.InterfaceC0453a interfaceC0453a = this.f12194b;
            if (interfaceC0453a != null) {
                interfaceC0453a.onRelease();
            }
            this.f12194b = null;
        }
    }

    @Override // c.a.n0.a.y0.f.a
    public void w(a.InterfaceC0453a interfaceC0453a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0453a) == null) {
            this.f12194b = interfaceC0453a;
        }
    }
}
