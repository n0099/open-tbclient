package cn.com.chinatelecom.gateway.lib.c;

import androidx.appcompat.widget.TooltipCompatHandler;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class k implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public /* synthetic */ int a;
    public /* synthetic */ j b;

    public k(j jVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = jVar;
        this.a = i;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:3|(4:25|26|27|(5:29|(1:31)|32|15|16))|5|6|(1:8)(1:22)|9|10|(2:12|(3:14|15|16)(2:18|19))(1:20)) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
        r6 = cn.com.chinatelecom.gateway.lib.c.j.a;
        cn.com.chinatelecom.gateway.lib.CtAuth.warn(r6, "timeoutCheckRunnable exception!", r0);
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        String str;
        boolean z;
        m mVar;
        String str2;
        m mVar2;
        m mVar3;
        boolean z2;
        m mVar4;
        m mVar5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a > 2500) {
                try {
                    Thread.sleep(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                } catch (Throwable th) {
                    str = j.a;
                    CtAuth.warn(str, "timeoutCheckRunnable exception!", th);
                }
                z = this.b.b;
                if (!z) {
                    mVar = this.b.e;
                    if (mVar != null) {
                        mVar2 = this.b.e;
                        mVar2.a(80800, "WIFI切换超时", TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                    }
                    str2 = j.a;
                    CtAuth.info(str2, "切换网络超时(L)");
                    j.c(this.b);
                }
            }
            Thread.sleep(this.a <= 2500 ? this.a : this.a - 2500);
            mVar3 = this.b.e;
            if (mVar3 != null) {
                z2 = this.b.b;
                if (z2) {
                    mVar4 = this.b.e;
                    mVar4.a();
                    return;
                }
                mVar5 = this.b.e;
                mVar5.a(80800, "WIFI切换超时", TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                j.c(this.b);
            }
        }
    }
}
