package com.baidu.browser.webkit;

import android.webkit.CookieManager;
/* loaded from: classes.dex */
public class BdCookieManager {
    private static volatile BdCookieManager sSysInstance;
    private static volatile BdCookieManager sZeusInstance;
    private CookieManager mSysCookieManager;
    private com.baidu.zeus.CookieManager mZeusCookieManager;

    public static BdCookieManager getInstance() {
        if (BdWebViewManager.getInstance().isZeusLoaded()) {
            if (sZeusInstance == null) {
                sZeusInstance = new BdCookieManager(com.baidu.zeus.CookieManager.getInstance());
            }
            return sZeusInstance;
        }
        if (sSysInstance == null) {
            sSysInstance = new BdCookieManager(CookieManager.getInstance());
        }
        return sSysInstance;
    }

    public BdCookieManager(CookieManager cookieManager) {
        this.mSysCookieManager = cookieManager;
    }

    public BdCookieManager(com.baidu.zeus.CookieManager cookieManager) {
        this.mZeusCookieManager = cookieManager;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdCookieManager) && unwrap() == ((BdCookieManager) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusCookieManager != null ? this.mZeusCookieManager.hashCode() : this.mSysCookieManager.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusCookieManager != null ? this.mZeusCookieManager == obj : this.mSysCookieManager == obj;
    }

    public Object unwrap() {
        return this.mZeusCookieManager != null ? this.mZeusCookieManager : this.mSysCookieManager;
    }

    public synchronized void setAcceptCookie(boolean z) {
        if (this.mZeusCookieManager != null) {
            this.mZeusCookieManager.setAcceptCookie(z);
        } else {
            this.mSysCookieManager.setAcceptCookie(z);
        }
    }

    public synchronized boolean acceptCookie() {
        return this.mZeusCookieManager != null ? this.mZeusCookieManager.acceptCookie() : this.mSysCookieManager.acceptCookie();
    }

    public void setCookie(String str, String str2) {
        if (this.mZeusCookieManager != null) {
            this.mZeusCookieManager.setCookie(str, str2);
        } else {
            this.mSysCookieManager.setCookie(str, str2);
        }
    }

    public String getCookie(String str) {
        return this.mZeusCookieManager != null ? this.mZeusCookieManager.getCookie(str) : this.mSysCookieManager.getCookie(str);
    }

    public void removeSessionCookie() {
        if (this.mZeusCookieManager != null) {
            this.mZeusCookieManager.removeSessionCookie();
        } else {
            this.mSysCookieManager.removeSessionCookie();
        }
    }

    public void removeAllCookie() {
        if (this.mZeusCookieManager != null) {
            this.mZeusCookieManager.removeAllCookie();
        } else {
            this.mSysCookieManager.removeAllCookie();
        }
    }

    public synchronized boolean hasCookies() {
        return this.mZeusCookieManager != null ? this.mZeusCookieManager.hasCookies() : this.mSysCookieManager.hasCookies();
    }

    public void removeExpiredCookie() {
        if (this.mZeusCookieManager != null) {
            this.mZeusCookieManager.removeExpiredCookie();
        } else {
            this.mSysCookieManager.removeExpiredCookie();
        }
    }
}
