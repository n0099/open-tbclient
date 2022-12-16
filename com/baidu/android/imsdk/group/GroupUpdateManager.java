package com.baidu.android.imsdk.group;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.media.listener.BIMValuesCallBack;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class GroupUpdateManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "GroupUpdateManager";
    public static volatile GroupUpdateManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mAppContext;
    public CopyOnWriteArrayList<BIMValuesCallBack<Long, Integer>> mApplyChangeListener;

    public GroupUpdateManager(Context context) {
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
        this.mApplyChangeListener = new CopyOnWriteArrayList<>();
        this.mAppContext = context.getApplicationContext();
    }

    private void dispatchApplyCountChanged(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            Iterator<BIMValuesCallBack<Long, Integer>> it = this.mApplyChangeListener.iterator();
            while (it.hasNext()) {
                BIMValuesCallBack<Long, Integer> next = it.next();
                if (next == null) {
                    it.remove();
                } else {
                    next.onResult(0, "", Long.valueOf(j), Integer.valueOf(i));
                }
            }
        }
    }

    public static GroupUpdateManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (sInstance == null) {
                synchronized (GroupUpdateManager.class) {
                    if (sInstance == null) {
                        sInstance = new GroupUpdateManager(context);
                    }
                }
            }
            return sInstance;
        }
        return (GroupUpdateManager) invokeL.objValue;
    }

    public void registerApplyCountChangeListener(BIMValuesCallBack<Long, Integer> bIMValuesCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bIMValuesCallBack) == null) && bIMValuesCallBack != null && !this.mApplyChangeListener.contains(bIMValuesCallBack)) {
            this.mApplyChangeListener.add(bIMValuesCallBack);
        }
    }

    public void unregisterApplyCountChangeListener(BIMValuesCallBack<Long, Integer> bIMValuesCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bIMValuesCallBack) != null) || bIMValuesCallBack == null) {
            return;
        }
        this.mApplyChangeListener.remove(bIMValuesCallBack);
    }

    public void onApplyCountChanged(long j, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) && j > 0 && i >= 0) {
            dispatchApplyCountChanged(j, i);
        }
    }
}
