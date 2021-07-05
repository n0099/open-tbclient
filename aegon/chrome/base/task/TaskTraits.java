package aegon.chrome.base.task;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes.dex */
public class TaskTraits {
    public static /* synthetic */ Interceptable $ic;
    public static final TaskTraits BEST_EFFORT;
    public static final TaskTraits BEST_EFFORT_MAY_BLOCK;
    public static final TaskTraits CHOREOGRAPHER_FRAME;
    public static final TaskTraits THREAD_POOL;
    public static final TaskTraits USER_BLOCKING;
    public static final TaskTraits USER_VISIBLE;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] mExtensionData;
    public byte mExtensionId;
    public boolean mIsChoreographerFrame;
    public boolean mMayBlock;
    public int mPriority;
    public boolean mPrioritySetExplicitly;
    public boolean mUseThreadPool;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1531495991, "Laegon/chrome/base/task/TaskTraits;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1531495991, "Laegon/chrome/base/task/TaskTraits;");
                return;
            }
        }
        TaskTraits.class.desiredAssertionStatus();
        TaskTraits taskPriority = new TaskTraits().taskPriority(0);
        BEST_EFFORT = taskPriority;
        BEST_EFFORT_MAY_BLOCK = taskPriority.mayBlock();
        TaskTraits taskPriority2 = new TaskTraits().taskPriority(1);
        USER_VISIBLE = taskPriority2;
        taskPriority2.mayBlock();
        TaskTraits taskPriority3 = new TaskTraits().taskPriority(2);
        USER_BLOCKING = taskPriority3;
        taskPriority3.mayBlock();
        TaskTraits taskTraits = new TaskTraits();
        CHOREOGRAPHER_FRAME = taskTraits;
        taskTraits.mIsChoreographerFrame = true;
        TaskTraits taskTraits2 = new TaskTraits(new TaskTraits());
        taskTraits2.mUseThreadPool = true;
        THREAD_POOL = taskTraits2;
        taskTraits2.taskPriority(2);
        THREAD_POOL.taskPriority(1);
        THREAD_POOL.taskPriority(0);
    }

    public TaskTraits() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPriority = 1;
    }

    public TaskTraits(TaskTraits taskTraits) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskTraits};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mPrioritySetExplicitly = taskTraits.mPrioritySetExplicitly;
        this.mPriority = taskTraits.mPriority;
        this.mMayBlock = taskTraits.mMayBlock;
        this.mUseThreadPool = taskTraits.mUseThreadPool;
        this.mExtensionId = taskTraits.mExtensionId;
        this.mExtensionData = taskTraits.mExtensionData;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof TaskTraits) {
                TaskTraits taskTraits = (TaskTraits) obj;
                return this.mPrioritySetExplicitly == taskTraits.mPrioritySetExplicitly && this.mPriority == taskTraits.mPriority && this.mExtensionId == taskTraits.mExtensionId && Arrays.equals(this.mExtensionData, taskTraits.mExtensionData);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ((Arrays.hashCode(this.mExtensionData) + (((((((((((!this.mPrioritySetExplicitly ? 1 : 0) + 1147) * 37) + this.mPriority) * 37) + (!this.mMayBlock ? 1 : 0)) * 37) + (!this.mUseThreadPool ? 1 : 0)) * 37) + this.mExtensionId) * 37)) * 37) + (!this.mIsChoreographerFrame ? 1 : 0) : invokeV.intValue;
    }

    public TaskTraits mayBlock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TaskTraits taskTraits = new TaskTraits(this);
            taskTraits.mMayBlock = true;
            return taskTraits;
        }
        return (TaskTraits) invokeV.objValue;
    }

    public TaskTraits taskPriority(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            TaskTraits taskTraits = new TaskTraits(this);
            taskTraits.mPrioritySetExplicitly = true;
            taskTraits.mPriority = i2;
            return taskTraits;
        }
        return (TaskTraits) invokeI.objValue;
    }
}
