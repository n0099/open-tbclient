package com.baidu.searchbox.player.event;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.BDPlayerConfig;
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
    public static final int PRIORITY_AT_ONCE = 1;
    public static final int PRIORITY_ENTER_QUEUE = 0;
    public static final int TYPE_CONTROL_EVENT = 2;
    public static final int TYPE_LAYER_EVENT = 3;
    public static final int TYPE_PLAYER_EVENT = 4;
    public static final int TYPE_STATE_EVENT = 5;
    public static final int TYPE_STATISTICS_EVENT = 6;
    public static final int TYPE_SYSTEM_EVENT = 1;
    public static final int TYPE_UNDEFINE_EVENT = -1;
    public static VideoEventPool sEventPool;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAction;
    public StringBuilder mDesc;
    public SparseArray<Object> mEventBundle;
    public int mPriority;
    public Object mSender;
    public int mTargetType;
    public int mType;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Priority {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Type {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @PublicMethod
    public static VideoEvent copy(@NonNull VideoEvent videoEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, videoEvent)) == null) {
            VideoEvent acquire = sEventPool.acquire();
            acquire.setType(videoEvent.mType);
            acquire.setAction(videoEvent.mAction);
            acquire.setSender(videoEvent.mSender);
            acquire.setBundle(videoEvent.getBundle());
            return acquire;
        }
        return (VideoEvent) invokeL.objValue;
    }

    public static VideoEvent obtain(@NonNull String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65540, null, str, i2)) == null) {
            VideoEvent acquire = sEventPool.acquire();
            acquire.setType(i2);
            acquire.setAction(str);
            return acquire;
        }
        return (VideoEvent) invokeLI.objValue;
    }

    public boolean filter(@NonNull INeuron iNeuron) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iNeuron)) == null) ? getSender() == iNeuron || !(getTargetType() == -1 || getTargetType() == iNeuron.getType()) : invokeL.booleanValue;
    }

    @NonNull
    @PublicMethod
    public String getAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAction : (String) invokeV.objValue;
    }

    @PublicMethod
    public boolean getBooleanExtra(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? getBooleanExtra(i2, false) : invokeI.booleanValue;
    }

    @PublicMethod
    public SparseArray<Object> getBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mEventBundle : (SparseArray) invokeV.objValue;
    }

    @PublicMethod
    public Object getExtra(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.mEventBundle.get(i2) : invokeI.objValue;
    }

    @PublicMethod
    public int getIntExtra(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? getIntExtra(i2, 0) : invokeI.intValue;
    }

    @PublicMethod
    public long getLongExtra(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? getLongExtra(i2, 0L) : invokeI.longValue;
    }

    @PublicMethod(version = "11.24.0.0")
    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mPriority : invokeV.intValue;
    }

    @Nullable
    @PublicMethod
    public Object getSender() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mSender : invokeV.objValue;
    }

    @PublicMethod
    public String getStringExtra(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? getStringExtra(i2, "") : (String) invokeI.objValue;
    }

    @PublicMethod
    public int getTargetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mTargetType : invokeV.intValue;
    }

    @PublicMethod
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mType : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.mEventBundle.clear();
        }
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mAction = "";
            this.mSender = null;
            this.mTargetType = -1;
            this.mType = -1;
            this.mPriority = 0;
            this.mEventBundle.clear();
        }
    }

    @PublicMethod
    public void putExtra(int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i2, obj) == null) {
            this.mEventBundle.put(i2, obj);
        }
    }

    @PublicMethod
    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            sEventPool.release((VideoEventPool) this);
        }
    }

    @PublicMethod
    public void setAction(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.mAction = str;
        }
    }

    @PublicMethod
    public void setBundle(@NonNull SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, sparseArray) == null) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                this.mEventBundle.put(sparseArray.keyAt(i2), sparseArray.valueAt(i2));
            }
        }
    }

    @PublicMethod(version = "11.24.0.0")
    public void setPriority(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.mPriority = i2;
        }
    }

    @PublicMethod
    public void setSender(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, obj) == null) {
            this.mSender = obj;
        }
    }

    @PublicMethod
    public void setTargetType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.mTargetType = i2;
        }
    }

    @PublicMethod
    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.mType = i2;
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (BDPlayerConfig.isDebug()) {
                StringBuilder sb = this.mDesc;
                if (sb == null) {
                    this.mDesc = new StringBuilder();
                } else if (sb.length() > 0) {
                    StringBuilder sb2 = this.mDesc;
                    sb2.delete(0, sb2.length());
                }
                StringBuilder sb3 = this.mDesc;
                sb3.append("Event【Action :");
                sb3.append(this.mAction);
                sb3.append("，type :");
                sb3.append(this.mType);
                sb3.append("，from :");
                sb3.append(this.mSender);
                sb3.append("，priority :");
                sb3.append(this.mPriority);
                sb3.append("，targetType :");
                sb3.append(this.mTargetType);
                sb3.append("，bundle :");
                sb3.append(this.mEventBundle.toString());
                sb3.append("，hash :");
                sb3.append(hashCode());
                sb3.append("】");
                return this.mDesc.toString();
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public VideoEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mEventBundle = new SparseArray<>(3);
        this.mType = -1;
        this.mTargetType = -1;
        this.mPriority = 0;
        this.mAction = str;
    }

    @PublicMethod
    public boolean getBooleanExtra(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            Object obj = this.mEventBundle.get(i2);
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }
        return invokeCommon.booleanValue;
    }

    @PublicMethod
    public int getIntExtra(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) {
            Object obj = this.mEventBundle.get(i2);
            return obj instanceof Integer ? ((Integer) obj).intValue() : i3;
        }
        return invokeII.intValue;
    }

    @PublicMethod
    public long getLongExtra(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            Object obj = this.mEventBundle.get(i2);
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }
        return invokeCommon.longValue;
    }

    @PublicMethod
    public String getStringExtra(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, str)) == null) {
            Object obj = this.mEventBundle.get(i2);
            return obj != null ? String.valueOf(obj) : str;
        }
        return (String) invokeIL.objValue;
    }
}
