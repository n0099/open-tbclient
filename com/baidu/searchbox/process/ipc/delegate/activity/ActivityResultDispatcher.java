package com.baidu.searchbox.process.ipc.delegate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class ActivityResultDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set mConsumers;
    public final Activity mHolder;
    public final int mRequestCode;

    public ActivityResultDispatcher(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mConsumers = new HashSet();
        this.mHolder = activity;
        this.mRequestCode = i;
    }

    public synchronized void addConsumer(ActivityResultConsumer activityResultConsumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activityResultConsumer) == null) {
            synchronized (this) {
                if (activityResultConsumer != null) {
                    this.mConsumers.add(activityResultConsumer);
                }
            }
        }
    }

    public synchronized void deleteConsumer(ActivityResultConsumer activityResultConsumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activityResultConsumer) == null) {
            synchronized (this) {
                this.mConsumers.remove(activityResultConsumer);
            }
        }
    }

    public void startActivityForResult(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, intent) == null) {
            this.mHolder.startActivityForResult(intent, this.mRequestCode);
        }
    }

    public synchronized int countConsumer() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                size = this.mConsumers.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public synchronized void deleteConsumer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.mConsumers.clear();
            }
        }
    }

    public boolean notifyActivityResult(int i, int i2, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048580, this, i, i2, intent)) == null) {
            if (this.mRequestCode != i) {
                return false;
            }
            HashSet hashSet = new HashSet();
            synchronized (this) {
                for (ActivityResultConsumer activityResultConsumer : new HashSet(this.mConsumers)) {
                    if (activityResultConsumer.consume(this, i2, intent)) {
                        hashSet.add(activityResultConsumer);
                    }
                }
                this.mConsumers.removeAll(hashSet);
            }
            return !hashSet.isEmpty();
        }
        return invokeIIL.booleanValue;
    }

    public void startActivityForResult(Intent intent, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, intent, bundle) == null) {
            this.mHolder.startActivityForResult(intent, this.mRequestCode, bundle);
        }
    }
}
