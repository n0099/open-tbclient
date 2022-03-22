package androidx.core.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class TaskStackBuilder implements Iterable<Intent> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TaskStackBuilder";
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Intent> mIntents;
    public final Context mSourceContext;

    /* loaded from: classes.dex */
    public interface SupportParentable {
        @Nullable
        Intent getSupportParentActivityIntent();
    }

    public TaskStackBuilder(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIntents = new ArrayList<>();
        this.mSourceContext = context;
    }

    @NonNull
    public static TaskStackBuilder create(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? new TaskStackBuilder(context) : (TaskStackBuilder) invokeL.objValue;
    }

    @Deprecated
    public static TaskStackBuilder from(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? create(context) : (TaskStackBuilder) invokeL.objValue;
    }

    @NonNull
    public TaskStackBuilder addNextIntent(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            this.mIntents.add(intent);
            return this;
        }
        return (TaskStackBuilder) invokeL.objValue;
    }

    @NonNull
    public TaskStackBuilder addNextIntentWithParentStack(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) {
            ComponentName component = intent.getComponent();
            if (component == null) {
                component = intent.resolveActivity(this.mSourceContext.getPackageManager());
            }
            if (component != null) {
                addParentStack(component);
            }
            addNextIntent(intent);
            return this;
        }
        return (TaskStackBuilder) invokeL.objValue;
    }

    @NonNull
    public TaskStackBuilder addParentStack(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            Intent supportParentActivityIntent = activity instanceof SupportParentable ? ((SupportParentable) activity).getSupportParentActivityIntent() : null;
            if (supportParentActivityIntent == null) {
                supportParentActivityIntent = NavUtils.getParentActivityIntent(activity);
            }
            if (supportParentActivityIntent != null) {
                ComponentName component = supportParentActivityIntent.getComponent();
                if (component == null) {
                    component = supportParentActivityIntent.resolveActivity(this.mSourceContext.getPackageManager());
                }
                addParentStack(component);
                addNextIntent(supportParentActivityIntent);
            }
            return this;
        }
        return (TaskStackBuilder) invokeL.objValue;
    }

    @Nullable
    public Intent editIntentAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? this.mIntents.get(i) : (Intent) invokeI.objValue;
    }

    @Deprecated
    public Intent getIntent(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? editIntentAt(i) : (Intent) invokeI.objValue;
    }

    public int getIntentCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mIntents.size() : invokeV.intValue;
    }

    @NonNull
    public Intent[] getIntents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int size = this.mIntents.size();
            Intent[] intentArr = new Intent[size];
            if (size == 0) {
                return intentArr;
            }
            intentArr[0] = new Intent(this.mIntents.get(0)).addFlags(268484608);
            for (int i = 1; i < size; i++) {
                intentArr[i] = new Intent(this.mIntents.get(i));
            }
            return intentArr;
        }
        return (Intent[]) invokeV.objValue;
    }

    @Nullable
    public PendingIntent getPendingIntent(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i, i2)) == null) ? getPendingIntent(i, i2, null) : (PendingIntent) invokeII.objValue;
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mIntents.iterator() : (Iterator) invokeV.objValue;
    }

    public void startActivities() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            startActivities(null);
        }
    }

    @Nullable
    public PendingIntent getPendingIntent(int i, int i2, @Nullable Bundle bundle) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i, i2, bundle)) == null) {
            if (!this.mIntents.isEmpty()) {
                ArrayList<Intent> arrayList = this.mIntents;
                Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                if (Build.VERSION.SDK_INT >= 16) {
                    return PendingIntent.getActivities(this.mSourceContext, i, intentArr, i2, bundle);
                }
                return PendingIntent.getActivities(this.mSourceContext, i, intentArr, i2);
            }
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        return (PendingIntent) invokeIIL.objValue;
    }

    public void startActivities(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            if (!this.mIntents.isEmpty()) {
                ArrayList<Intent> arrayList = this.mIntents;
                Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                if (ContextCompat.startActivities(this.mSourceContext, intentArr, bundle)) {
                    return;
                }
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                this.mSourceContext.startActivity(intent);
                return;
            }
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
    }

    @NonNull
    public TaskStackBuilder addParentStack(@NonNull Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cls)) == null) ? addParentStack(new ComponentName(this.mSourceContext, cls)) : (TaskStackBuilder) invokeL.objValue;
    }

    public TaskStackBuilder addParentStack(ComponentName componentName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, componentName)) == null) {
            int size = this.mIntents.size();
            try {
                Intent parentActivityIntent = NavUtils.getParentActivityIntent(this.mSourceContext, componentName);
                while (parentActivityIntent != null) {
                    this.mIntents.add(size, parentActivityIntent);
                    parentActivityIntent = NavUtils.getParentActivityIntent(this.mSourceContext, parentActivityIntent.getComponent());
                }
                return this;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e(TAG, "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e2);
            }
        }
        return (TaskStackBuilder) invokeL.objValue;
    }
}
