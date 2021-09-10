package c.a.p0.v.k;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.p0.a.k;
import c.a.p0.a.v2.q;
import c.a.p0.a.y0.d;
import c.a.p0.a.y0.f.a;
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
public class a implements c.a.p0.a.y0.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f12466e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f12467a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0463a f12468b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f12469c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f12470d;

    /* renamed from: c.a.p0.v.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0638a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12471e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f12472f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f12473g;

        public RunnableC0638a(a aVar, String str, Map map) {
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
            this.f12473g = aVar;
            this.f12471e = str;
            this.f12472f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f12473g.f12470d) {
                    boolean unused = a.f12466e;
                    return;
                }
                this.f12473g.f12469c.setDataSource(this.f12473g.getContext(), Uri.parse(c.a.p0.a.y0.j.a.a(this.f12471e)), this.f12472f);
                Bundle metaData = this.f12473g.f12469c.getMetaData();
                if (this.f12473g.f12468b != null) {
                    this.f12473g.f12468b.a(metaData);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-757751648, "Lc/a/p0/v/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-757751648, "Lc/a/p0/v/k/a;");
                return;
            }
        }
        f12466e = k.f7077a;
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
        this.f12467a = str;
        this.f12470d = false;
    }

    @Override // c.a.p0.a.y0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f12469c = new CyberExtractor(true);
            aVar.a(true);
        }
    }

    @Override // c.a.p0.a.y0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12467a : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.p0.a.c1.a.b() : (Context) invokeV.objValue;
    }

    @Override // c.a.p0.a.y0.d
    @Nullable
    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.y0.f.a
    public void k(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, map) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        q.i(new RunnableC0638a(this, str, map), "loadMetadata");
    }

    @Override // c.a.p0.a.y0.f.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f12470d = true;
            CyberExtractor cyberExtractor = this.f12469c;
            if (cyberExtractor != null) {
                cyberExtractor.release();
            }
            this.f12469c = null;
            a.InterfaceC0463a interfaceC0463a = this.f12468b;
            if (interfaceC0463a != null) {
                interfaceC0463a.onRelease();
            }
            this.f12468b = null;
        }
    }

    @Override // c.a.p0.a.y0.f.a
    public void w(a.InterfaceC0463a interfaceC0463a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0463a) == null) {
            this.f12468b = interfaceC0463a;
        }
    }
}
