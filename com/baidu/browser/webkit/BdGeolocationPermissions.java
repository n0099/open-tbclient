package com.baidu.browser.webkit;

import android.webkit.GeolocationPermissions;
import com.baidu.zeus.GeolocationPermissions;
import com.baidu.zeus.ValueCallback;
import java.util.Set;
/* loaded from: classes.dex */
public final class BdGeolocationPermissions {
    private static BdGeolocationPermissions sSysInstance;
    private static BdGeolocationPermissions sZeusInstance;
    private GeolocationPermissions mSysGeolocationPermissions;
    private com.baidu.zeus.GeolocationPermissions mZeusGeolocationPermissions;

    /* loaded from: classes.dex */
    public class BdCallback {
        private GeolocationPermissions.Callback mSysCallback;
        private GeolocationPermissions.Callback mZeusCallback;

        public BdCallback(GeolocationPermissions.Callback callback) {
            this.mSysCallback = callback;
        }

        public BdCallback(GeolocationPermissions.Callback callback) {
            this.mZeusCallback = callback;
        }

        public boolean equals(Object obj) {
            return (obj instanceof BdCallback) && unwrap() == ((BdCallback) obj).unwrap();
        }

        public int hashCode() {
            return this.mZeusCallback != null ? this.mZeusCallback.hashCode() : this.mSysCallback.hashCode();
        }

        public boolean isContains(Object obj) {
            return this.mZeusCallback != null ? this.mZeusCallback == obj : this.mSysCallback == obj;
        }

        public Object unwrap() {
            return this.mZeusCallback != null ? this.mZeusCallback : this.mSysCallback;
        }

        public void invoke(String str, boolean z, boolean z2) {
            if (this.mZeusCallback != null) {
                this.mZeusCallback.invoke(str, z, z2);
            } else {
                this.mSysCallback.invoke(str, z, z2);
            }
        }
    }

    public static BdGeolocationPermissions getInstance() {
        if (BdWebViewManager.getInstance().isZeusLoaded()) {
            if (sZeusInstance == null) {
                sZeusInstance = new BdGeolocationPermissions(com.baidu.zeus.GeolocationPermissions.getInstance());
            }
            return sZeusInstance;
        }
        if (sSysInstance == null) {
            sSysInstance = new BdGeolocationPermissions(android.webkit.GeolocationPermissions.getInstance());
        }
        return sSysInstance;
    }

    private BdGeolocationPermissions(android.webkit.GeolocationPermissions geolocationPermissions) {
        this.mSysGeolocationPermissions = geolocationPermissions;
    }

    private BdGeolocationPermissions(com.baidu.zeus.GeolocationPermissions geolocationPermissions) {
        this.mZeusGeolocationPermissions = geolocationPermissions;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdGeolocationPermissions) && unwrap() == ((BdGeolocationPermissions) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusGeolocationPermissions != null ? this.mZeusGeolocationPermissions.hashCode() : this.mSysGeolocationPermissions.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusGeolocationPermissions != null ? this.mZeusGeolocationPermissions == obj : this.mSysGeolocationPermissions == obj;
    }

    public Object unwrap() {
        return this.mZeusGeolocationPermissions != null ? this.mZeusGeolocationPermissions : this.mSysGeolocationPermissions;
    }

    public void getOrigins(BdValueCallback<Set<String>> bdValueCallback) {
        if (this.mZeusGeolocationPermissions != null) {
            this.mZeusGeolocationPermissions.getOrigins((ValueCallback) bdValueCallback.unwrap());
        } else {
            this.mSysGeolocationPermissions.getOrigins((android.webkit.ValueCallback) bdValueCallback.unwrap());
        }
    }

    public void getAllowed(String str, BdValueCallback<Boolean> bdValueCallback) {
        if (this.mZeusGeolocationPermissions != null) {
            this.mZeusGeolocationPermissions.getAllowed(str, (ValueCallback) bdValueCallback.unwrap());
        } else {
            this.mSysGeolocationPermissions.getAllowed(str, (android.webkit.ValueCallback) bdValueCallback.unwrap());
        }
    }

    public void clear(String str) {
        if (this.mZeusGeolocationPermissions != null) {
            this.mZeusGeolocationPermissions.clear(str);
        } else {
            this.mSysGeolocationPermissions.clear(str);
        }
    }

    public void allow(String str) {
        if (this.mZeusGeolocationPermissions != null) {
            this.mZeusGeolocationPermissions.allow(str);
        } else {
            this.mSysGeolocationPermissions.allow(str);
        }
    }

    public void clearAll() {
        if (this.mZeusGeolocationPermissions != null) {
            this.mZeusGeolocationPermissions.clearAll();
        } else {
            this.mSysGeolocationPermissions.clearAll();
        }
    }
}
