package c.d;

import c.d.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class e implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ List a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FunAdConfig f23135b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f23136c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f23137d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ f.a f23138e;

    public e(List list, FunAdConfig funAdConfig, Map map, long j, f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, funAdConfig, map, Long.valueOf(j), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = list;
        this.f23135b = funAdConfig;
        this.f23136c = map;
        this.f23137d = j;
        this.f23138e = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (Ssp ssp : this.a) {
                if (!this.f23135b.forbiddenPlatforms.contains(ssp.type)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    LogPrinter.d("sdk for %s init start", ssp.type);
                    String str3 = ssp.type;
                    str3.hashCode();
                    char c2 = 65535;
                    switch (str3.hashCode()) {
                        case 3407:
                            if (str3.equals(FunAdSdk.PLATFORM_JY)) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 3432:
                            if (str3.equals(FunAdSdk.PLATFORM_KS)) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 3477:
                            if (str3.equals(FunAdSdk.PLATFORM_MB)) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 102199:
                            if (str3.equals(FunAdSdk.PLATFORM_GDT)) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 106042:
                            if (str3.equals(FunAdSdk.PLATFORM_KDS)) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 113873:
                            if (str3.equals(FunAdSdk.PLATFORM_SIG)) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case 93498907:
                            if (str3.equals("baidu")) {
                                c2 = 6;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.JyModule";
                            f.c(str, str2, this.f23135b, this.f23136c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 1:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.KsModule";
                            f.c(str, str2, this.f23135b, this.f23136c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 2:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.MbModule";
                            f.c(str, str2, this.f23135b, this.f23136c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 3:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.GdtModule";
                            f.c(str, str2, this.f23135b, this.f23136c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 4:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.KdsModule";
                            f.c(str, str2, this.f23135b, this.f23136c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 5:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.SigModule";
                            f.c(str, str2, this.f23135b, this.f23136c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 6:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.BaiduModule";
                            f.c(str, str2, this.f23135b, this.f23136c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        default:
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                    }
                } else {
                    LogPrinter.d("Ssp:%s is not initialized for type is forbidden", ssp.type);
                }
            }
            f.b(this.f23137d, this.f23138e, this.f23136c);
        }
    }
}
