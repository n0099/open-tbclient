package com.baidu.bdtask.ctrl.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004\"\u0004\b\u001e\u0010\u001fR\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010#R\"\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010 \u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010#¨\u0006)"}, d2 = {"Lcom/baidu/bdtask/ctrl/model/TaskEnvTag;", "Lcom/baidu/bdtask/model/ITaskModelData;", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "component3", "tag", "value", "timestamp", "copy", "(Ljava/lang/String;JJ)Lcom/baidu/bdtask/ctrl/model/TaskEnvTag;", "deepCopy", "()Lcom/baidu/bdtask/model/ITaskModelData;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "Lorg/json/JSONObject;", "toJson", "()Lorg/json/JSONObject;", "toString", "Ljava/lang/String;", "getTag", "setTag", "(Ljava/lang/String;)V", "J", "getTimestamp", "setTimestamp", "(J)V", "getValue", "setValue", "<init>", "(Ljava/lang/String;JJ)V", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class TaskEnvTag implements ITaskModelData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final String keyTag = "tag";
    public static final String keyTimestamp = "timestamp";
    public static final String keyValue = "value";
    public static final int tagLenLimited = 128;
    public transient /* synthetic */ FieldHolder $fh;
    public String tag;
    public long timestamp;
    public long value;

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        public static /* synthetic */ TaskEnvTag a(a aVar, String str, long j2, long j3, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                j3 = System.currentTimeMillis();
            }
            return aVar.c(str, j2, j3);
        }

        public final TaskEnvTag b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String tempTag = jSONObject.getString("tag");
                    long j2 = jSONObject.getLong("value");
                    long j3 = jSONObject.getLong("timestamp");
                    Intrinsics.checkExpressionValueIsNotNull(tempTag, "tempTag");
                    return c(tempTag, j2, j3);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (TaskEnvTag) invokeL.objValue;
        }

        public final TaskEnvTag c(String str, long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                if (str.length() >= 128) {
                    str = str.substring(0, 128);
                    Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                return new TaskEnvTag(str, j2, j3);
            }
            return (TaskEnvTag) invokeCommon.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(32199289, "Lcom/baidu/bdtask/ctrl/model/TaskEnvTag;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(32199289, "Lcom/baidu/bdtask/ctrl/model/TaskEnvTag;");
                return;
            }
        }
        Companion = new a(null);
    }

    public TaskEnvTag(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.tag = str;
        this.value = j2;
        this.timestamp = j3;
    }

    public static /* synthetic */ TaskEnvTag copy$default(TaskEnvTag taskEnvTag, String str, long j2, long j3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = taskEnvTag.tag;
        }
        if ((i2 & 2) != 0) {
            j2 = taskEnvTag.value;
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            j3 = taskEnvTag.timestamp;
        }
        return taskEnvTag.copy(str, j4, j3);
    }

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.tag : (String) invokeV.objValue;
    }

    public final long component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.value : invokeV.longValue;
    }

    public final long component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.timestamp : invokeV.longValue;
    }

    public final TaskEnvTag copy(String str, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)})) == null) ? new TaskEnvTag(str, j2, j3) : (TaskEnvTag) invokeCommon.objValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public ITaskModelData deepCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new TaskEnvTag(this.tag, this.value, this.timestamp) : (ITaskModelData) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (!(obj instanceof TaskEnvTag)) {
                obj = null;
            }
            TaskEnvTag taskEnvTag = (TaskEnvTag) obj;
            return Intrinsics.areEqual(taskEnvTag != null ? taskEnvTag.tag : null, this.tag);
        }
        return invokeL.booleanValue;
    }

    public final String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.tag : (String) invokeV.objValue;
    }

    public final long getTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.timestamp : invokeV.longValue;
    }

    public final long getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.value : invokeV.longValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.tag.hashCode() : invokeV.intValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ITaskModelData.a.a(this) : invokeV.booleanValue;
    }

    public final void setTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.tag = str;
        }
    }

    public final void setTimestamp(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            this.timestamp = j2;
        }
    }

    public final void setValue(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            this.value = j2;
        }
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tag", this.tag);
            jSONObject.put("value", this.value);
            jSONObject.put("timestamp", this.timestamp);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return "TaskEnvTag(tag=" + this.tag + ", value=" + this.value + ", timestamp=" + this.timestamp + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
