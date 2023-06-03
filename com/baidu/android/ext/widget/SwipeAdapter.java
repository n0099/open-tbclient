package com.baidu.android.ext.widget;

import android.widget.BaseAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class SwipeAdapter extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ONLY_REMOVE = -2;
    public static final int SWIPE_DRAG = 1;
    public static final int SWIPE_FIXED = 0;
    public static final int SWIPE_REMOVE = 2;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract int getSwipeAction(int i);

    public abstract int removeAndInsert(int i);

    public SwipeAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
