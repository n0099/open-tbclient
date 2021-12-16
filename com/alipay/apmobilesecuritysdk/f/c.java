package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public final class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ b a;

    public c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x0012 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                Process.setThreadPriority(0);
                while (!linkedList.isEmpty()) {
                    linkedList2 = this.a.f31567c;
                    Runnable runnable = (Runnable) linkedList2.get(0);
                    linkedList3 = this.a.f31567c;
                    linkedList3.remove(0);
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.a.f31566b = null;
                throw th;
            }
            this.a.f31566b = null;
        }
    }
}
