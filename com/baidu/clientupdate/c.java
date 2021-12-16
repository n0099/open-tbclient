package com.baidu.clientupdate;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.LogUtil;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.SSLHandshakeException;
/* loaded from: classes10.dex */
public class c extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ClientUpdater a;

    public c(ClientUpdater clientUpdater) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {clientUpdater};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = clientUpdater;
        setName("SDK_ClientUpdater_thread");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:7|(4:(2:9|(8:11|12|13|14|15|16|17|(2:19|20)(1:21)))|16|17|(0)(0))|47|12|13|14|15) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0098, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009a, code lost:
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        com.baidu.clientupdate.c.a aVar;
        boolean z;
        com.baidu.clientupdate.c.a aVar2;
        com.baidu.clientupdate.c.a aVar3;
        String str;
        HttpURLConnection httpURLConnection;
        String str2;
        HttpURLConnection httpURLConnection2;
        boolean z2;
        com.baidu.clientupdate.c.a aVar4;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        aVar = this.a.n;
        if (aVar == null) {
            return;
        }
        z = this.a.f34268d;
        try {
            if (!z) {
                z2 = this.a.f34274k;
                if (!z2) {
                    aVar4 = this.a.n;
                    aVar4.b(false);
                    this.a.f34274k = false;
                    ClientUpdater clientUpdater = this.a;
                    aVar3 = clientUpdater.n;
                    clientUpdater.f34267c = aVar3.b("/lcmanage/index.php?r=InterfaceAction&method=upgrade&contype=client&clientv=3.0");
                    StringBuilder sb = new StringBuilder();
                    sb.append("更新检查请求的完整参数： ");
                    str = this.a.f34267c;
                    sb.append(str);
                    LogUtil.logE("ClientUpdater", sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    httpURLConnection = null;
                    str2 = this.a.f34267c;
                    httpURLConnection2 = (HttpURLConnection) new URL(str2).openConnection();
                    httpURLConnection2.setConnectTimeout(5000);
                    httpURLConnection2.setReadTimeout(5000);
                    httpURLConnection2.connect();
                    this.a.a(httpURLConnection2, null, sb2);
                    if (httpURLConnection2 == null) {
                        httpURLConnection2.disconnect();
                        return;
                    }
                    return;
                }
            }
            httpURLConnection2.setConnectTimeout(5000);
            httpURLConnection2.setReadTimeout(5000);
            httpURLConnection2.connect();
            this.a.a(httpURLConnection2, null, sb2);
            if (httpURLConnection2 == null) {
            }
        } catch (SSLHandshakeException unused) {
            httpURLConnection = httpURLConnection2;
            try {
                LogUtil.logE("ClientUpdater", "SSLHandshakeException caught!!!! ");
                this.a.c();
            } catch (Exception e2) {
                this.a.a(e2);
            }
            if (httpURLConnection == null) {
                return;
            }
            httpURLConnection.disconnect();
            return;
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = httpURLConnection2;
            this.a.a(e);
            if (httpURLConnection == null) {
                return;
            }
            httpURLConnection.disconnect();
            return;
        } catch (Throwable th) {
            th = th;
            httpURLConnection = httpURLConnection2;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
        aVar2 = this.a.n;
        aVar2.b(true);
        this.a.f34274k = false;
        ClientUpdater clientUpdater2 = this.a;
        aVar3 = clientUpdater2.n;
        clientUpdater2.f34267c = aVar3.b("/lcmanage/index.php?r=InterfaceAction&method=upgrade&contype=client&clientv=3.0");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("更新检查请求的完整参数： ");
        str = this.a.f34267c;
        sb3.append(str);
        LogUtil.logE("ClientUpdater", sb3.toString());
        StringBuilder sb22 = new StringBuilder();
        httpURLConnection = null;
        str2 = this.a.f34267c;
        httpURLConnection2 = (HttpURLConnection) new URL(str2).openConnection();
    }
}
