package com.baidu.ar.statistic;

import android.content.Context;
import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes5.dex */
public class h implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object mLock;
    public int wC;
    public volatile boolean wD;
    public i[] wE;
    public WeakReference<Context> wn;

    public h(Context context, Object obj, i[] iVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, obj, iVarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (iVarArr == null) {
            throw null;
        }
        this.wn = new WeakReference<>(context);
        this.wC = 0;
        this.wD = false;
        this.mLock = obj;
        this.wE = iVarArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x008a A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.wE.length == 0) {
            return;
        }
        Process.setThreadPriority(19);
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            i[] iVarArr = this.wE;
            int length = iVarArr.length;
            i iVar = null;
            List<List<a>> list = null;
            int i4 = 0;
            boolean z = false;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                i iVar2 = iVarArr[i4];
                List<List<a>> gn = iVar2.gn();
                if (iVar2.go()) {
                    z = true;
                }
                if (gn != null && gn.size() > 0) {
                    iVar = iVar2;
                    list = gn;
                    break;
                }
                i4++;
                list = gn;
            }
            if (list != null && list.size() > 0 && iVar != null) {
                Context context = this.wn.get();
                if (context == null) {
                    break;
                }
                try {
                    i3 = 0;
                    for (List<a> list2 : list) {
                        try {
                            iVar.a(context, list2);
                            i3 += list2.size();
                        } catch (Exception e2) {
                            e = e2;
                            this.wC++;
                            e.printStackTrace(System.out);
                            if (i3 > 0) {
                            }
                            if (this.wC > 0) {
                            }
                        }
                    }
                    this.wC = 0;
                } catch (Exception e3) {
                    e = e3;
                    i3 = 0;
                }
                if (i3 > 0) {
                    iVar.update(i3);
                }
                if (this.wC > 0) {
                    continue;
                } else if (this.wD) {
                    break;
                } else {
                    try {
                        int i5 = this.wC * 2000;
                        if (this.wC >= 7) {
                            i5 = 60000;
                        }
                        Thread.currentThread();
                        Thread.sleep(i5);
                    } catch (InterruptedException e4) {
                        e4.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            } else if (this.wD) {
                break;
            } else if (z) {
                Thread.currentThread();
                Thread.sleep(10L);
            } else {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait();
                    } catch (InterruptedException e5) {
                        e5.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        for (i iVar3 : this.wE) {
            iVar3.save();
        }
    }

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.wD = true;
        }
    }
}
