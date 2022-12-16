package com.baidu.searchbox.dns.transmit.task;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class PriorityAsyncTask extends AsyncTask implements Comparable<PriorityAsyncTask> {
    public static /* synthetic */ Interceptable $ic;
    public static final int DEFAULT_PRIORITY = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int mPriority;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PriorityAsyncTask() {
        this(PriorityDispatcherHolder.getDispatcher());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Dispatcher) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PriorityAsyncTask(int i) {
        this(PriorityDispatcherHolder.getDispatcher(), i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Dispatcher) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PriorityAsyncTask(int i, String str) {
        this(PriorityDispatcherHolder.getDispatcher(), i, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Dispatcher) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriorityAsyncTask(Dispatcher dispatcher) {
        super(dispatcher);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dispatcher};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Dispatcher) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mPriority = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriorityAsyncTask(Dispatcher dispatcher, int i) {
        super(dispatcher);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dispatcher, Integer.valueOf(i)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Dispatcher) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.mPriority = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriorityAsyncTask(Dispatcher dispatcher, int i, String str) {
        super(dispatcher, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dispatcher, Integer.valueOf(i), str};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Dispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.mPriority = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriorityAsyncTask(Dispatcher dispatcher, String str) {
        super(dispatcher, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dispatcher, str};
            interceptable.invokeUnInit(65542, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Dispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
        this.mPriority = 0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PriorityAsyncTask(String str) {
        this(PriorityDispatcherHolder.getDispatcher(), str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65543, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Dispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(PriorityAsyncTask priorityAsyncTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, priorityAsyncTask)) == null) {
            if (equals(priorityAsyncTask)) {
                return 0;
            }
            if (priorityAsyncTask == null) {
                return -1;
            }
            int i = this.mPriority;
            int i2 = priorityAsyncTask.mPriority;
            if (i == i2) {
                return 0;
            }
            if (i > i2) {
                return -1;
            }
            return 1;
        }
        return invokeL.intValue;
    }
}
