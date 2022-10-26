package com.baidu.android.pushservice.httpapi;

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
public class g extends com.baidu.android.pushservice.g.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public a b;
    public String c;
    public List d;

    /* loaded from: classes.dex */
    public interface a {
        void a(List list);
    }

    public g(Context context, String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new ArrayList();
        this.a = context;
        this.c = str;
        this.b = aVar;
        c("PushService-PushService-SearchboxDNS");
        a((short) 100);
    }

    @Override // com.baidu.android.pushservice.g.c
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
                DnsHelper dnsHelper = new DnsHelper(this.a);
                dnsHelper.setHttpDnsState(false, null, false, true);
                List ipListForceHttp = dnsHelper.getIpListForceHttp(this.c);
                if (ipListForceHttp != null && ipListForceHttp.size() > 0) {
                    int b = com.baidu.android.pushservice.i.i.b(this.a, "key_vip_type", 3);
                    if (b != 1) {
                        if (b == 2) {
                            String str = com.baidu.android.pushservice.i.m.d((String) ipListForceHttp.get(0)) ? null : (String) ipListForceHttp.get(0);
                            if (!TextUtils.isEmpty(str)) {
                                this.d.add(str);
                            }
                            r1 = com.baidu.android.pushservice.i.m.d((String) ipListForceHttp.get(ipListForceHttp.size() - 1)) ? (String) ipListForceHttp.get(ipListForceHttp.size() - 1) : null;
                            if (!TextUtils.isEmpty(r1)) {
                            }
                        } else if (b != 4) {
                            String str2 = com.baidu.android.pushservice.i.m.d((String) ipListForceHttp.get(ipListForceHttp.size() - 1)) ? (String) ipListForceHttp.get(ipListForceHttp.size() - 1) : null;
                            if (!TextUtils.isEmpty(str2)) {
                                this.d.add(str2);
                            }
                            if (!com.baidu.android.pushservice.i.m.d((String) ipListForceHttp.get(0))) {
                                r1 = (String) ipListForceHttp.get(0);
                            }
                        } else {
                            r1 = com.baidu.android.pushservice.i.m.d((String) ipListForceHttp.get(ipListForceHttp.size() - 1)) ? (String) ipListForceHttp.get(ipListForceHttp.size() - 1) : null;
                            if (!TextUtils.isEmpty(r1)) {
                            }
                        }
                    } else if (!com.baidu.android.pushservice.i.m.d((String) ipListForceHttp.get(0))) {
                        r1 = (String) ipListForceHttp.get(0);
                    }
                    this.d.add(r1);
                }
            } catch (Throwable unused) {
            }
            this.b.a(this.d);
        }
    }
}
