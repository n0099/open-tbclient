package com.baidu.down.loopj.android.urlconnection;

import android.text.TextUtils;
import com.baidu.down.loopj.android.http.BaseRetryHandler;
import com.baidu.down.loopj.android.http.HttpResponseException;
import com.baidu.down.utils.network.NetWorkDetector;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes4.dex */
public class UrlConnectionRetryHandler extends BaseRetryHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlConnectionRetryHandler(long[] jArr) {
        super(jArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((long[]) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean retryRequest(IOException iOException, int i2, String str, int i3) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{iOException, Integer.valueOf(i2), str, Integer.valueOf(i3)})) == null) {
            if (i2 >= 1) {
                long[] jArr = this.retryIntervals;
                if (i2 <= jArr.length && i3 <= jArr.length * 3 && !isInList(BaseRetryHandler.exceptionBlacklist, iOException)) {
                    isInList(BaseRetryHandler.exceptionWhitelist, iOException);
                    z = true;
                    if ((iOException instanceof HttpResponseException) || ((HttpResponseException) iOException).getStatusCode() != 412) {
                        if (!z) {
                            try {
                                long j2 = this.retryIntervals[i2 - 1];
                                if (j2 > 0) {
                                    if (NetWorkDetector.getInstance().sNeedDetect && !TextUtils.isEmpty(str) && !NetWorkDetector.getInstance().isHostReachableCached(str, 5000L)) {
                                        while (true) {
                                            long j3 = j2 - 5000;
                                            if (j3 <= 0) {
                                                break;
                                            }
                                            Thread.sleep(5000L);
                                            if (NetWorkDetector.getInstance().isHostReachableCached(str, 5000L)) {
                                                return z;
                                            }
                                            j2 = j3;
                                        }
                                    }
                                    Thread.sleep(j2);
                                }
                            } catch (InterruptedException unused) {
                            }
                        } else {
                            iOException.printStackTrace();
                        }
                        return z;
                    }
                    return false;
                }
            }
            z = false;
            if (iOException instanceof HttpResponseException) {
            }
            if (!z) {
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }
}
