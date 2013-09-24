package com.baidu.browser.webkit;

import android.webkit.WebStorage;
import com.baidu.zeus.ValueCallback;
import com.baidu.zeus.WebStorage;
import java.util.Map;
/* loaded from: classes.dex */
public final class BdWebStorage {
    private static BdWebStorage sSysInstance;
    private static BdWebStorage sZeusInstance;
    private WebStorage mSysWebStorage;
    private com.baidu.zeus.WebStorage mZeusWebStorage;

    /* loaded from: classes.dex */
    public class BdQuotaUpdater {
        private WebStorage.QuotaUpdater mSysQuotaUpdater;
        private WebStorage.QuotaUpdater mZeusQuotaUpdater;

        public BdQuotaUpdater(WebStorage.QuotaUpdater quotaUpdater) {
            this.mSysQuotaUpdater = quotaUpdater;
        }

        public BdQuotaUpdater(WebStorage.QuotaUpdater quotaUpdater) {
            this.mZeusQuotaUpdater = quotaUpdater;
        }

        public boolean equals(Object obj) {
            return (obj instanceof BdQuotaUpdater) && unwrap() == ((BdQuotaUpdater) obj).unwrap();
        }

        public int hashCode() {
            return this.mZeusQuotaUpdater != null ? this.mZeusQuotaUpdater.hashCode() : this.mSysQuotaUpdater.hashCode();
        }

        public boolean isContains(Object obj) {
            return this.mZeusQuotaUpdater != null ? this.mZeusQuotaUpdater == obj : this.mSysQuotaUpdater == obj;
        }

        public Object unwrap() {
            return this.mZeusQuotaUpdater != null ? this.mZeusQuotaUpdater : this.mSysQuotaUpdater;
        }

        public void updateQuota(long j) {
            if (this.mZeusQuotaUpdater != null) {
                this.mZeusQuotaUpdater.updateQuota(j);
            } else {
                this.mSysQuotaUpdater.updateQuota(j);
            }
        }
    }

    public static BdWebStorage getInstance() {
        if (BdWebViewManager.getInstance().isZeusLoaded()) {
            if (sZeusInstance == null) {
                sZeusInstance = new BdWebStorage(com.baidu.zeus.WebStorage.getInstance());
            }
            return sZeusInstance;
        }
        if (sSysInstance == null) {
            sSysInstance = new BdWebStorage(android.webkit.WebStorage.getInstance());
        }
        return sSysInstance;
    }

    private BdWebStorage(android.webkit.WebStorage webStorage) {
        this.mSysWebStorage = webStorage;
    }

    private BdWebStorage(com.baidu.zeus.WebStorage webStorage) {
        this.mZeusWebStorage = webStorage;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdWebStorage) && unwrap() == ((BdWebStorage) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusWebStorage != null ? this.mZeusWebStorage.hashCode() : this.mSysWebStorage.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusWebStorage != null ? this.mZeusWebStorage == obj : this.mSysWebStorage == obj;
    }

    public Object unwrap() {
        return this.mZeusWebStorage != null ? this.mZeusWebStorage : this.mSysWebStorage;
    }

    public void getOrigins(BdValueCallback<Map> bdValueCallback) {
        if (this.mZeusWebStorage != null) {
            this.mZeusWebStorage.getOrigins((ValueCallback) bdValueCallback.unwrap());
        } else {
            this.mSysWebStorage.getOrigins((android.webkit.ValueCallback) bdValueCallback.unwrap());
        }
    }

    public void getUsageForOrigin(String str, BdValueCallback<Long> bdValueCallback) {
        if (this.mZeusWebStorage != null) {
            this.mZeusWebStorage.getUsageForOrigin(str, (ValueCallback) bdValueCallback.unwrap());
        } else {
            this.mSysWebStorage.getUsageForOrigin(str, (android.webkit.ValueCallback) bdValueCallback.unwrap());
        }
    }

    public void getQuotaForOrigin(String str, BdValueCallback<Long> bdValueCallback) {
        if (this.mZeusWebStorage != null) {
            this.mZeusWebStorage.getQuotaForOrigin(str, (ValueCallback) bdValueCallback.unwrap());
        } else {
            this.mSysWebStorage.getQuotaForOrigin(str, (android.webkit.ValueCallback) bdValueCallback.unwrap());
        }
    }

    public void setQuotaForOrigin(String str, long j) {
        if (this.mZeusWebStorage != null) {
            this.mZeusWebStorage.setQuotaForOrigin(str, j);
        } else {
            this.mSysWebStorage.setQuotaForOrigin(str, j);
        }
    }

    public void deleteOrigin(String str) {
        if (this.mZeusWebStorage != null) {
            this.mZeusWebStorage.deleteOrigin(str);
        } else {
            this.mSysWebStorage.deleteOrigin(str);
        }
    }

    public void deleteAllData() {
        if (this.mZeusWebStorage != null) {
            this.mZeusWebStorage.deleteAllData();
        } else {
            this.mSysWebStorage.deleteAllData();
        }
    }
}
