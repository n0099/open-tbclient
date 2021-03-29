package com.baidu.down.loopj.android.urlconnection;

import android.text.TextUtils;
import com.baidu.down.loopj.android.http.BaseRetryHandler;
import com.baidu.down.loopj.android.http.HttpResponseException;
import com.baidu.down.utils.network.NetWorkDetector;
import java.io.IOException;
/* loaded from: classes.dex */
public class UrlConnectionRetryHandler extends BaseRetryHandler {
    public UrlConnectionRetryHandler(long[] jArr) {
        super(jArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean retryRequest(IOException iOException, int i, String str, int i2) {
        boolean z;
        if (i >= 1) {
            long[] jArr = this.retryIntervals;
            if (i <= jArr.length && i2 <= jArr.length * 3 && !isInList(BaseRetryHandler.exceptionBlacklist, iOException)) {
                isInList(BaseRetryHandler.exceptionWhitelist, iOException);
                z = true;
                if ((iOException instanceof HttpResponseException) || ((HttpResponseException) iOException).getStatusCode() != 412) {
                    if (!z) {
                        try {
                            long j = this.retryIntervals[i - 1];
                            if (j > 0) {
                                if (NetWorkDetector.getInstance().sNeedDetect && !TextUtils.isEmpty(str) && !NetWorkDetector.getInstance().isHostReachableCached(str, 5000L)) {
                                    while (true) {
                                        long j2 = j - 5000;
                                        if (j2 <= 0) {
                                            break;
                                        }
                                        Thread.sleep(5000L);
                                        if (NetWorkDetector.getInstance().isHostReachableCached(str, 5000L)) {
                                            return z;
                                        }
                                        j = j2;
                                    }
                                }
                                Thread.sleep(j);
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
}
