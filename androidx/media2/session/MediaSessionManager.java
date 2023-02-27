package androidx.media2.session;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import androidx.media.MediaBrowserServiceCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class MediaSessionManager {
    public static final String TAG = "MediaSessionManager";
    @GuardedBy("sLock")
    public static MediaSessionManager sInstance;
    public final Context mContext;
    public static final boolean DEBUG = Log.isLoggable("MediaSessionManager", 3);
    public static final Object sLock = new Object();

    public MediaSessionManager(Context context) {
        this.mContext = context;
    }

    @NonNull
    public static MediaSessionManager getInstance(@NonNull Context context) {
        MediaSessionManager mediaSessionManager;
        if (context != null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new MediaSessionManager(context.getApplicationContext());
                }
                mediaSessionManager = sInstance;
            }
            return mediaSessionManager;
        }
        throw new NullPointerException("context shouldn't be null");
    }

    @NonNull
    public Set<SessionToken> getSessionServiceTokens() {
        ServiceInfo serviceInfo;
        ArraySet arraySet = new ArraySet();
        PackageManager packageManager = this.mContext.getPackageManager();
        ArrayList<ResolveInfo> arrayList = new ArrayList();
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(new Intent(MediaLibraryService.SERVICE_INTERFACE), 128);
        if (queryIntentServices != null) {
            arrayList.addAll(queryIntentServices);
        }
        List<ResolveInfo> queryIntentServices2 = packageManager.queryIntentServices(new Intent(MediaSessionService.SERVICE_INTERFACE), 128);
        if (queryIntentServices2 != null) {
            arrayList.addAll(queryIntentServices2);
        }
        List<ResolveInfo> queryIntentServices3 = packageManager.queryIntentServices(new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE), 128);
        if (queryIntentServices3 != null) {
            arrayList.addAll(queryIntentServices3);
        }
        for (ResolveInfo resolveInfo : arrayList) {
            if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                arraySet.add(new SessionToken(this.mContext, new ComponentName(serviceInfo.packageName, serviceInfo.name)));
            }
        }
        if (DEBUG) {
            Log.d("MediaSessionManager", "Found " + arraySet.size() + " session services");
            Iterator it = arraySet.iterator();
            while (it.hasNext()) {
                Log.d("MediaSessionManager", "   " + ((SessionToken) it.next()));
            }
        }
        return arraySet;
    }
}
