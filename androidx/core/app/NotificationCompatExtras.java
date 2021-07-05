package androidx.core.app;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class NotificationCompatExtras {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_ACTION_EXTRAS = "android.support.actionExtras";
    public static final String EXTRA_GROUP_KEY = "android.support.groupKey";
    public static final String EXTRA_GROUP_SUMMARY = "android.support.isGroupSummary";
    public static final String EXTRA_LOCAL_ONLY = "android.support.localOnly";
    public static final String EXTRA_REMOTE_INPUTS = "android.support.remoteInputs";
    public static final String EXTRA_SORT_KEY = "android.support.sortKey";
    public transient /* synthetic */ FieldHolder $fh;

    public NotificationCompatExtras() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
