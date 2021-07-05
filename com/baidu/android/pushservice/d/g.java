package com.baidu.android.pushservice.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.DnsHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.android.pushservice.h.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f3023a;

    /* renamed from: b  reason: collision with root package name */
    public a f3024b;

    /* renamed from: c  reason: collision with root package name */
    public String f3025c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f3026d;

    /* loaded from: classes.dex */
    public interface a {
        void a(List<String> list);
    }

    public g(Context context, String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3026d = new ArrayList();
        this.f3023a = context;
        this.f3025c = str;
        this.f3024b = aVar;
        c("PushService-PushService-SearchboxDNS");
        a((short) 100);
    }

    @Override // com.baidu.android.pushservice.h.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f9, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                DnsHelper dnsHelper = new DnsHelper(this.f3023a);
                dnsHelper.setHttpDnsState(false, null, false, true);
                List<String> ipListForceHttp = dnsHelper.getIpListForceHttp(this.f3025c);
                if (ipListForceHttp != null && ipListForceHttp.size() > 0) {
                    int b2 = com.baidu.android.pushservice.j.i.b(this.f3023a, "key_vip_type", 3);
                    if (b2 != 1) {
                        if (b2 == 2) {
                            String str = com.baidu.android.pushservice.j.m.d(ipListForceHttp.get(0)) ? null : ipListForceHttp.get(0);
                            if (!TextUtils.isEmpty(str)) {
                                this.f3026d.add(str);
                            }
                            r1 = com.baidu.android.pushservice.j.m.d(ipListForceHttp.get(ipListForceHttp.size() - 1)) ? ipListForceHttp.get(ipListForceHttp.size() - 1) : null;
                            if (!TextUtils.isEmpty(r1)) {
                            }
                        } else if (b2 != 4) {
                            String str2 = com.baidu.android.pushservice.j.m.d(ipListForceHttp.get(ipListForceHttp.size() - 1)) ? ipListForceHttp.get(ipListForceHttp.size() - 1) : null;
                            if (!TextUtils.isEmpty(str2)) {
                                this.f3026d.add(str2);
                            }
                            if (!com.baidu.android.pushservice.j.m.d(ipListForceHttp.get(0))) {
                                r1 = ipListForceHttp.get(0);
                            }
                        } else {
                            r1 = com.baidu.android.pushservice.j.m.d(ipListForceHttp.get(ipListForceHttp.size() - 1)) ? ipListForceHttp.get(ipListForceHttp.size() - 1) : null;
                            if (!TextUtils.isEmpty(r1)) {
                            }
                        }
                    } else if (!com.baidu.android.pushservice.j.m.d(ipListForceHttp.get(0))) {
                        r1 = ipListForceHttp.get(0);
                    }
                    this.f3026d.add(r1);
                }
            } catch (Throwable unused) {
            }
            this.f3024b.a(this.f3026d);
        }
    }
}
