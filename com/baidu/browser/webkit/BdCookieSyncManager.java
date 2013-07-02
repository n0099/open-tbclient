package com.baidu.browser.webkit;

import android.content.Context;
import android.webkit.CookieSyncManager;
/* loaded from: classes.dex */
public class BdCookieSyncManager {
    private static volatile BdCookieSyncManager sSysInstance;
    private static volatile BdCookieSyncManager sZeusInstance;
    private CookieSyncManager mSysCookieSyncManager;
    private com.baidu.zeus.CookieSyncManager mZeusCookieSyncManager;

    public static BdCookieSyncManager getInstance() {
        if (BdWebViewManager.getInstance().isZeusLoaded()) {
            if (sZeusInstance == null) {
                sZeusInstance = new BdCookieSyncManager(com.baidu.zeus.CookieSyncManager.getInstance());
            }
            return sZeusInstance;
        }
        if (sSysInstance == null) {
            sSysInstance = new BdCookieSyncManager(CookieSyncManager.getInstance());
        }
        return sSysInstance;
    }

    public static synchronized BdCookieSyncManager createInstance(Context context) {
        BdCookieSyncManager bdCookieSyncManager;
        synchronized (BdCookieSyncManager.class) {
            if (BdWebViewManager.getInstance().isZeusLoaded()) {
                if (sZeusInstance == null) {
                    sZeusInstance = new BdCookieSyncManager(com.baidu.zeus.CookieSyncManager.createInstance(context));
                }
                bdCookieSyncManager = sZeusInstance;
            } else {
                if (sSysInstance == null) {
                    sSysInstance = new BdCookieSyncManager(CookieSyncManager.createInstance(context));
                }
                bdCookieSyncManager = sSysInstance;
            }
        }
        return bdCookieSyncManager;
    }

    public BdCookieSyncManager(CookieSyncManager cookieSyncManager) {
        this.mSysCookieSyncManager = cookieSyncManager;
    }

    public BdCookieSyncManager(com.baidu.zeus.CookieSyncManager cookieSyncManager) {
        this.mZeusCookieSyncManager = cookieSyncManager;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdCookieSyncManager) && unwrap() == ((BdCookieSyncManager) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusCookieSyncManager != null ? this.mZeusCookieSyncManager.hashCode() : this.mSysCookieSyncManager.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusCookieSyncManager != null ? this.mZeusCookieSyncManager == obj : this.mSysCookieSyncManager == obj;
    }

    public Object unwrap() {
        return this.mZeusCookieSyncManager != null ? this.mZeusCookieSyncManager : this.mSysCookieSyncManager;
    }

    public void sync() {
        if (this.mZeusCookieSyncManager != null) {
            this.mZeusCookieSyncManager.sync();
        } else {
            this.mSysCookieSyncManager.sync();
        }
    }

    public void resetSync() {
        if (this.mZeusCookieSyncManager != null) {
            this.mZeusCookieSyncManager.resetSync();
        } else {
            this.mSysCookieSyncManager.resetSync();
        }
    }

    public void startSync() {
        if (this.mZeusCookieSyncManager != null) {
            this.mZeusCookieSyncManager.startSync();
        } else {
            this.mSysCookieSyncManager.startSync();
        }
    }

    public void stopSync() {
        if (this.mZeusCookieSyncManager != null) {
            this.mZeusCookieSyncManager.stopSync();
        } else {
            this.mSysCookieSyncManager.stopSync();
        }
    }
}
