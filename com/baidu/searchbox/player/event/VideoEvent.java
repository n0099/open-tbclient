package com.baidu.searchbox.player.event;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.interfaces.INeuron;
import com.baidu.searchbox.player.pool.IPoolItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class VideoEvent implements IPoolItem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOG_LEVEL_HIGH = 0;
    public static final int LOG_LEVEL_LOW = 1;
    public static final int PRIORITY_AT_ONCE = 1;
    public static final int PRIORITY_ENTER_QUEUE = 0;
    public static final int TYPE_CONTROL_EVENT = 2;
    public static final int TYPE_INTERACTIVE_EVENT = 8;
    public static final int TYPE_LAYER_EVENT = 3;
    public static final int TYPE_PLAYER_EVENT = 4;
    public static final int TYPE_PLUGIN_EVENT = 7;
    public static final int TYPE_STATE_EVENT = 5;
    public static final int TYPE_STATISTICS_EVENT = 6;
    public static final int TYPE_SYSTEM_EVENT = 1;
    public static final int TYPE_UNDEFINE_EVENT = -1;
    public static final VideoEventPool sEventPool;
    public transient /* synthetic */ FieldHolder $fh;
    public String action;
    public StringBuilder desc;
    public final SparseArray<Object> eventBundle;
    public int logLevel;
    public int priority;
    public Object sender;
    public int targetType;
    public int type;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface LogLevel {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Priority {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Type {
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-513406349, "Lcom/baidu/searchbox/player/event/VideoEvent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-513406349, "Lcom/baidu/searchbox/player/event/VideoEvent;");
                return;
            }
        }
        sEventPool = new VideoEventPool();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoEvent() {
        this("");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @NonNull
    @PublicMethod
    public String getAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.action;
        }
        return (String) invokeV.objValue;
    }

    @PublicMethod
    public SparseArray<Object> getBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.eventBundle;
        }
        return (SparseArray) invokeV.objValue;
    }

    public int getLogLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.logLevel;
        }
        return invokeV.intValue;
    }

    @PublicMethod(version = "11.24.0.0")
    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.priority;
        }
        return invokeV.intValue;
    }

    @Nullable
    @PublicMethod
    public Object getSender() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.sender;
        }
        return invokeV.objValue;
    }

    @PublicMethod
    public int getTargetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.targetType;
        }
        return invokeV.intValue;
    }

    @PublicMethod
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.eventBundle.clear();
        }
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.action = "";
            this.sender = null;
            this.targetType = -1;
            this.type = -1;
            this.priority = 0;
            this.logLevel = 0;
            this.eventBundle.clear();
        }
    }

    @PublicMethod
    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            sEventPool.release((VideoEventPool) this);
        }
    }

    public VideoEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.eventBundle = new SparseArray<>(3);
        this.type = -1;
        this.targetType = -1;
        this.priority = 0;
        this.logLevel = 0;
        this.action = str;
    }

    @PublicMethod
    public static VideoEvent copy(@NonNull VideoEvent videoEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, videoEvent)) == null) {
            VideoEvent acquire = sEventPool.acquire();
            acquire.setType(videoEvent.type);
            acquire.setAction(videoEvent.action);
            acquire.setSender(videoEvent.sender);
            acquire.setTargetType(videoEvent.targetType);
            acquire.setPriority(videoEvent.priority);
            acquire.setBundle(videoEvent.eventBundle);
            acquire.setLogLevel(videoEvent.logLevel);
            return acquire;
        }
        return (VideoEvent) invokeL.objValue;
    }

    public static VideoEvent obtain(@NonNull String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i)) == null) {
            VideoEvent acquire = sEventPool.acquire();
            acquire.setType(i);
            acquire.setAction(str);
            return acquire;
        }
        return (VideoEvent) invokeLI.objValue;
    }

    @PublicMethod
    public int getIntExtra(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i, i2)) == null) {
            Object obj = this.eventBundle.get(i);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return i2;
        }
        return invokeII.intValue;
    }

    @PublicMethod
    public String getStringExtra(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048592, this, i, str)) == null) {
            Object obj = this.eventBundle.get(i);
            if (obj != null) {
                return String.valueOf(obj);
            }
            return str;
        }
        return (String) invokeIL.objValue;
    }

    @PublicMethod
    public void putExtra(int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048597, this, i, obj) == null) {
            this.eventBundle.put(i, obj);
        }
    }

    public boolean filter(@NonNull INeuron iNeuron) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iNeuron)) == null) {
            if (getSender() != iNeuron && (getTargetType() == -1 || getTargetType() == iNeuron.getType())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @PublicMethod
    public boolean getBooleanExtra(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return getBooleanExtra(i, false);
        }
        return invokeI.booleanValue;
    }

    @PublicMethod
    public Object getExtra(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return this.eventBundle.get(i);
        }
        return invokeI.objValue;
    }

    @PublicMethod
    public float getFloatExtra(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return getFloatExtra(i, 0.0f);
        }
        return invokeI.floatValue;
    }

    @PublicMethod
    public int getIntExtra(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return getIntExtra(i, 0);
        }
        return invokeI.intValue;
    }

    @PublicMethod
    public long getLongExtra(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return getLongExtra(i, 0L);
        }
        return invokeI.longValue;
    }

    @PublicMethod
    public String getStringExtra(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            return getStringExtra(i, "");
        }
        return (String) invokeI.objValue;
    }

    @PublicMethod
    public void setAction(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.action = str;
        }
    }

    @PublicMethod
    public void setBundle(@NonNull SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, sparseArray) == null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                this.eventBundle.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
            }
        }
    }

    public void setLogLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.logLevel = i;
        }
    }

    @PublicMethod(version = "11.24.0.0")
    public void setPriority(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.priority = i;
        }
    }

    @PublicMethod
    public void setSender(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, obj) == null) {
            this.sender = obj;
        }
    }

    @PublicMethod
    public void setTargetType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.targetType = i;
        }
    }

    @PublicMethod
    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.type = i;
        }
    }

    @PublicMethod
    public boolean getBooleanExtra(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            Object obj = this.eventBundle.get(i);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    @PublicMethod(version = "12.2.0")
    public float getFloatExtra(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            Object obj = this.eventBundle.get(i);
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            return f;
        }
        return invokeCommon.floatValue;
    }

    @PublicMethod
    public long getLongExtra(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            Object obj = this.eventBundle.get(i);
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            return j;
        }
        return invokeCommon.longValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            StringBuilder sb = this.desc;
            if (sb == null) {
                this.desc = new StringBuilder();
            } else if (sb.length() > 0) {
                StringBuilder sb2 = this.desc;
                sb2.delete(0, sb2.length());
            }
            StringBuilder sb3 = this.desc;
            sb3.append("Action :");
            sb3.append(this.action);
            sb3.append(", type :");
            sb3.append(this.type);
            sb3.append(", from :");
            sb3.append(this.sender);
            sb3.append(", priority :");
            sb3.append(this.priority);
            sb3.append(", targetType :");
            sb3.append(this.targetType);
            sb3.append(", bundle :");
            sb3.append(this.eventBundle.toString());
            sb3.append(", hash :");
            sb3.append(hashCode());
            return this.desc.toString();
        }
        return (String) invokeV.objValue;
    }
}
