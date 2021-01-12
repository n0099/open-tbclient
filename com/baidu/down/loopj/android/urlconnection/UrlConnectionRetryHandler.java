package com.baidu.down.loopj.android.urlconnection;

import android.text.TextUtils;
import com.baidu.down.loopj.android.http.BaseRetryHandler;
import com.baidu.down.loopj.android.http.HttpResponseException;
import com.baidu.down.utils.network.NetWorkDetector;
import java.io.IOException;
/* loaded from: classes3.dex */
public class UrlConnectionRetryHandler extends BaseRetryHandler {
    public UrlConnectionRetryHandler(long[] jArr) {
        super(jArr);
    }

    public boolean retryRequest(IOException iOException, int i, String str, int i2) {
        boolean z;
        if (i < 1 || i > this.retryIntervals.length || i2 > this.retryIntervals.length * 3) {
            z = false;
        } else if (isInList(exceptionBlacklist, iOException)) {
            z = false;
        } else {
            z = isInList(exceptionWhitelist, iOException) ? true : true;
        }
        if ((iOException instanceof HttpResponseException) && ((HttpResponseException) iOException).getStatusCode() == 412) {
            return false;
        }
        if (z) {
            try {
                long j = this.retryIntervals[i - 1];
                if (j > 0) {
                    if (NetWorkDetector.getInstance().sNeedDetect && !TextUtils.isEmpty(str) && !NetWorkDetector.getInstance().isHostReachableCached(str, 5000L)) {
                        while (j - 5000 > 0) {
                            j -= 5000;
                            Thread.sleep(5000L);
                            if (NetWorkDetector.getInstance().isHostReachableCached(str, 5000L)) {
                                return z;
                            }
                        }
                    }
                    Thread.sleep(j);
                    return z;
                }
                return z;
            } catch (InterruptedException e) {
                return z;
            }
        }
        iOException.printStackTrace();
        return z;
    }
}
