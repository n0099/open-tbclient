package b.a.p0.v.k;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.k;
import b.a.p0.a.v2.q;
import b.a.p0.a.y0.d;
import b.a.p0.a.y0.f.a;
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
    public static final boolean f11648e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f11649a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0458a f11650b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f11651c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f11652d;

    /* renamed from: b.a.p0.v.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0632a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11653e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f11654f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f11655g;

        public RunnableC0632a(a aVar, String str, Map map) {
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
            this.f11655g = aVar;
            this.f11653e = str;
            this.f11654f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11655g.f11652d) {
                    boolean unused = a.f11648e;
                    return;
                }
                this.f11655g.f11651c.setDataSource(this.f11655g.getContext(), Uri.parse(b.a.p0.a.y0.j.a.a(this.f11653e)), this.f11654f);
                Bundle metaData = this.f11655g.f11651c.getMetaData();
                if (this.f11655g.f11650b != null) {
                    this.f11655g.f11650b.a(metaData);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-464348641, "Lb/a/p0/v/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-464348641, "Lb/a/p0/v/k/a;");
                return;
            }
        }
        f11648e = k.f6397a;
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
        this.f11649a = str;
        this.f11652d = false;
    }

    @Override // b.a.p0.a.y0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f11651c = new CyberExtractor(true);
            aVar.a(true);
        }
    }

    @Override // b.a.p0.a.y0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11649a : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b.a.p0.a.c1.a.b() : (Context) invokeV.objValue;
    }

    @Override // b.a.p0.a.y0.d
    @Nullable
    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.y0.f.a
    public void k(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, map) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        q.i(new RunnableC0632a(this, str, map), "loadMetadata");
    }

    @Override // b.a.p0.a.y0.f.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f11652d = true;
            CyberExtractor cyberExtractor = this.f11651c;
            if (cyberExtractor != null) {
                cyberExtractor.release();
            }
            this.f11651c = null;
            a.InterfaceC0458a interfaceC0458a = this.f11650b;
            if (interfaceC0458a != null) {
                interfaceC0458a.onRelease();
            }
            this.f11650b = null;
        }
    }

    @Override // b.a.p0.a.y0.f.a
    public void w(a.InterfaceC0458a interfaceC0458a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0458a) == null) {
            this.f11650b = interfaceC0458a;
        }
    }
}
