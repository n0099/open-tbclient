package androidx.webkit;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes14.dex */
public abstract class ServiceWorkerWebSettingsCompat {

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes14.dex */
    public @interface CacheMode {
    }

    public abstract boolean getAllowContentAccess();

    public abstract boolean getAllowFileAccess();

    public abstract boolean getBlockNetworkLoads();

    public abstract int getCacheMode();

    public abstract void setAllowContentAccess(boolean z);

    public abstract void setAllowFileAccess(boolean z);

    public abstract void setBlockNetworkLoads(boolean z);

    public abstract void setCacheMode(int i);
}
