package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.SparseArray;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes.dex */
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_WAKE_LOCK_ID = "androidx.contentpager.content.wakelockid";
    public static int mNextId;
    public static final SparseArray<PowerManager.WakeLock> sActiveWakeLocks;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1869779778, "Landroidx/legacy/content/WakefulBroadcastReceiver;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1869779778, "Landroidx/legacy/content/WakefulBroadcastReceiver;");
                return;
            }
        }
        sActiveWakeLocks = new SparseArray<>();
        mNextId = 1;
    }

    public WakefulBroadcastReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean completeWakefulIntent(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, intent)) == null) {
            int intExtra = intent.getIntExtra(EXTRA_WAKE_LOCK_ID, 0);
            if (intExtra == 0) {
                return false;
            }
            synchronized (sActiveWakeLocks) {
                PowerManager.WakeLock wakeLock = sActiveWakeLocks.get(intExtra);
                if (wakeLock != null) {
                    wakeLock.release();
                    sActiveWakeLocks.remove(intExtra);
                    return true;
                }
                String str = "No active wake lock id #" + intExtra;
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static ComponentName startWakefulService(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, intent)) == null) {
            synchronized (sActiveWakeLocks) {
                int i2 = mNextId;
                int i3 = mNextId + 1;
                mNextId = i3;
                if (i3 <= 0) {
                    mNextId = 1;
                }
                intent.putExtra(EXTRA_WAKE_LOCK_ID, i2);
                ComponentName startService = context.startService(intent);
                if (startService == null) {
                    return null;
                }
                PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + startService.flattenToShortString());
                newWakeLock.setReferenceCounted(false);
                newWakeLock.acquire(60000L);
                sActiveWakeLocks.put(i2, newWakeLock);
                return startService;
            }
        }
        return (ComponentName) invokeLL.objValue;
    }
}
