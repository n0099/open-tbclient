package b.a.p0.a.y0.k;

import androidx.annotation.NonNull;
import b.a.p0.a.u.e.o.k;
import b.a.p0.a.v2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes.dex */
public class d implements ZeusPluginFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f9069a;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                b.a.p0.a.y0.k.g.a b2 = b.a.p0.a.c1.a.z().b(null, null);
                b2.m0();
                b2.U();
                b2.C();
                k.e().s(b2);
                if (b.a.p0.a.k.f6397a) {
                    String str = "pre-create video cost time ：" + (System.currentTimeMillis() - currentTimeMillis);
                }
            }
        }
    }

    public d(@NonNull String str) {
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
        this.f9069a = str;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || b.a.p0.a.c1.a.z() == null) {
            return;
        }
        b.a.p0.a.y0.k.f.b.d("4");
        k.e().c();
        q.j(new a(), "PreCreateVideo");
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        InterceptResult invokeL;
        b.a.p0.a.y0.k.g.a b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, invoker)) == null) {
            if (b.a.p0.a.c1.a.z() == null) {
                return null;
            }
            if (k.e().f()) {
                b.a.p0.a.e0.d.g("【InlineFactory】", "handleAppOnLaunch use cache inline video. ");
                b2 = k.e().d();
                k.e().r();
                b2.N(invoker);
            } else {
                b.a.p0.a.e0.d.g("【InlineFactory】", "handleAppOnLaunch create cache inline video. ");
                b2 = b.a.p0.a.c1.a.z().b(invoker, this.f9069a);
                b2.H();
            }
            if (b.a.p0.a.k.f6397a) {
                String str = "Factory 「Hash:" + hashCode() + "」 is creating inline video「Hash:" + b2.hashCode() + "」";
            }
            k.e().b(b2);
            return new b(b2);
        }
        return (ZeusPlugin) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "inline_video" : (String) invokeV.objValue;
    }
}
