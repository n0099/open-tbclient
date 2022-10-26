package androidx.media2.session;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import androidx.collection.ArraySet;
import androidx.media.MediaBrowserServiceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class MediaSessionManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "MediaSessionManager";
    public static MediaSessionManager sInstance;
    public static final Object sLock;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context mContext;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2047612640, "Landroidx/media2/session/MediaSessionManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2047612640, "Landroidx/media2/session/MediaSessionManager;");
                return;
            }
        }
        DEBUG = Log.isLoggable("MediaSessionManager", 3);
        sLock = new Object();
    }

    public MediaSessionManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    public static MediaSessionManager getInstance(Context context) {
        InterceptResult invokeL;
        MediaSessionManager mediaSessionManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
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
        return (MediaSessionManager) invokeL.objValue;
    }

    public Set<SessionToken> getSessionServiceTokens() {
        InterceptResult invokeV;
        ServiceInfo serviceInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
        return (Set) invokeV.objValue;
    }
}
