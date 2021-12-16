package com.baidu.bdtask.ctrl.model;

import androidx.core.view.InputDeviceCompat;
import c.a.j.m.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.bdtask.model.rule.TaskRuleData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u0000 \\2\u00020\u0001:\u0001\\B]\u0012\b\b\u0002\u0010$\u001a\u00020\u0017\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\b\b\u0002\u0010&\u001a\u00020\u0017\u0012\u0006\u0010'\u001a\u00020\n\u0012\u0006\u0010(\u001a\u00020\u0017\u0012\u0006\u0010)\u001a\u00020\u0017\u0012\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050 \u0012\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0 ¢\u0006\u0004\bZ\u0010[J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0015\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\r\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\r\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\r\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0004J\r\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0019J\u0010\u0010\u001d\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0019J\u0010\u0010\u001f\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0019J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050 HÂ\u0003¢\u0006\u0004\b!\u0010\"J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0 HÂ\u0003¢\u0006\u0004\b#\u0010\"Jl\u0010,\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\u00172\b\b\u0002\u0010%\u001a\u00020\n2\b\b\u0002\u0010&\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020\n2\b\b\u0002\u0010(\u001a\u00020\u00172\b\b\u0002\u0010)\u001a\u00020\u00172\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050 2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0 HÆ\u0001¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0000H\u0016¢\u0006\u0004\b.\u0010/J\u001a\u00103\u001a\u0002022\b\u00101\u001a\u0004\u0018\u000100HÖ\u0003¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\n¢\u0006\u0004\b5\u0010\u001bJ\r\u00107\u001a\u000206¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b9\u0010\u0019J\r\u0010:\u001a\u000202¢\u0006\u0004\b:\u0010;J\u0015\u0010<\u001a\u0002022\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b<\u0010=J\r\u0010>\u001a\u000202¢\u0006\u0004\b>\u0010;J\r\u0010?\u001a\u000202¢\u0006\u0004\b?\u0010;J\r\u0010@\u001a\u000202¢\u0006\u0004\b@\u0010;J\u000f\u0010A\u001a\u000206H\u0002¢\u0006\u0004\bA\u00108J\u000f\u0010B\u001a\u000206H\u0002¢\u0006\u0004\bB\u00108J\u000f\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010EJ\u0010\u0010F\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\bF\u0010GR\"\u0010&\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010H\u001a\u0004\bI\u0010\u0019\"\u0004\bJ\u0010KR\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010LR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0019\u0010)\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010H\u001a\u0004\bP\u0010\u0019R\"\u0010(\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010H\u001a\u0004\bQ\u0010\u0019\"\u0004\bR\u0010KR\"\u0010'\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010S\u001a\u0004\bT\u0010\u001b\"\u0004\bU\u0010\rR\"\u0010$\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010H\u001a\u0004\bV\u0010\u0019\"\u0004\bW\u0010KR\"\u0010%\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010S\u001a\u0004\bX\u0010\u001b\"\u0004\bY\u0010\rR\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010L¨\u0006]"}, d2 = {"Lcom/baidu/bdtask/ctrl/model/TaskProcess;", "Lcom/baidu/bdtask/model/ITaskModelData;", "", "addClickNumber", "()V", "Lcom/baidu/bdtask/ctrl/model/TaskEnvTag;", "tag", "addEnvTag", "(Lcom/baidu/bdtask/ctrl/model/TaskEnvTag;)V", "addNoClickTimes", "", "time", "addStayTime", "(J)V", "", "id", "cacheDuplicateId", "(Ljava/lang/String;)V", "cleanDuplicateId", "cleanNoClickTimes", "clearClickNumber", "clearStayTime", "clearTags", "", "component1", "()I", "component2", "()J", "component3", "component4", "component5", "component6", "", "component7", "()Ljava/util/Set;", "component8", "repeatTimes", TaskProcess.keyStayDurTimeMs, TaskProcess.keyCurNoClickTimes, "maxStayTimeMS", "maxRepeatTimes", TaskProcess.keyMaxNoClickTimes, "tags", "duplicateIds", "copy", "(IJIJIILjava/util/Set;Ljava/util/Set;)Lcom/baidu/bdtask/ctrl/model/TaskProcess;", "deepCopy", "()Lcom/baidu/bdtask/ctrl/model/TaskProcess;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "getFormatStay", "Lorg/json/JSONArray;", "getSerializeTags", "()Lorg/json/JSONArray;", TTDownloadField.TT_HASHCODE, "isCompleted", "()Z", "isContainsInDuplicateIds", "(Ljava/lang/String;)Z", "isGotClickedNumber", "isGotMaxNoClickTimes", "isGotStayTime", "serializeDuplicateId", "serializeTags", "Lorg/json/JSONObject;", "toJson", "()Lorg/json/JSONObject;", "toString", "()Ljava/lang/String;", "I", "getCurNoClickTimes", "setCurNoClickTimes", "(I)V", "Ljava/util/Set;", "Ljava/util/concurrent/locks/ReentrantLock;", "fairLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getMaxNoClickTimes", "getMaxRepeatTimes", "setMaxRepeatTimes", "J", "getMaxStayTimeMS", "setMaxStayTimeMS", "getRepeatTimes", "setRepeatTimes", "getStayDurTimeMs", "setStayDurTimeMs", "<init>", "(IJIJIILjava/util/Set;Ljava/util/Set;)V", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class TaskProcess implements ITaskModelData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final int MAX_DUPLICATE_ID_NUMBERS = 100;
    public static final String keyClickNumber = "clickNumber";
    public static final String keyCurNoClickTimes = "curNoClickTimes";
    public static final String keyDuplicateIds = "keyDuplicateIds";
    public static final String keyMaxNoClickTimes = "maxNoClickTimes";
    public static final String keyMaxRepeatTimes = "keyMaxRepeatTimes";
    public static final String keyMaxStayTime = "maxStayTime";
    public static final String keyStayDurTimeMs = "stayDurTimeMs";
    public static final String keyTags = "tags";
    public transient /* synthetic */ FieldHolder $fh;
    public int curNoClickTimes;
    public final Set<String> duplicateIds;
    public final ReentrantLock fairLock;
    public final int maxNoClickTimes;
    public int maxRepeatTimes;
    public long maxStayTimeMS;
    public int repeatTimes;
    public long stayDurTimeMs;
    public final Set<TaskEnvTag> tags;

    /* loaded from: classes9.dex */
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

        public final TaskProcess a(TaskRuleData taskRuleData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, taskRuleData)) == null) ? new TaskProcess(0, 0L, 0, taskRuleData.getStay(), taskRuleData.getRepeat(), taskRuleData.getNoclickTimes(), null, null, 199, null) : (TaskProcess) invokeL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2057851137, "Lcom/baidu/bdtask/ctrl/model/TaskProcess;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2057851137, "Lcom/baidu/bdtask/ctrl/model/TaskProcess;");
                return;
            }
        }
        Companion = new a(null);
    }

    public TaskProcess(int i2, long j2, int i3, long j3, int i4, int i5, Set<TaskEnvTag> set, Set<String> set2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i4), Integer.valueOf(i5), set, set2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.repeatTimes = i2;
        this.stayDurTimeMs = j2;
        this.curNoClickTimes = i3;
        this.maxStayTimeMS = j3;
        this.maxRepeatTimes = i4;
        this.maxNoClickTimes = i5;
        this.tags = set;
        this.duplicateIds = set2;
        this.fairLock = new ReentrantLock(true);
    }

    private final Set<TaskEnvTag> component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.tags : (Set) invokeV.objValue;
    }

    private final Set<String> component8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.duplicateIds : (Set) invokeV.objValue;
    }

    private final JSONArray serializeDuplicateId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            ReentrantLock reentrantLock = this.fairLock;
            reentrantLock.lock();
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator it = CollectionsKt___CollectionsKt.toHashSet(this.duplicateIds).iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                return jSONArray;
            } finally {
                reentrantLock.unlock();
            }
        }
        return (JSONArray) invokeV.objValue;
    }

    private final JSONArray serializeTags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            ReentrantLock reentrantLock = this.fairLock;
            reentrantLock.lock();
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator it = CollectionsKt___CollectionsKt.toHashSet(this.tags).iterator();
                while (it.hasNext()) {
                    jSONArray.put(((TaskEnvTag) it.next()).toJson());
                }
                return jSONArray;
            } finally {
                reentrantLock.unlock();
            }
        }
        return (JSONArray) invokeV.objValue;
    }

    public final void addClickNumber() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.repeatTimes + 1;
            this.repeatTimes = i2;
            int i3 = this.maxRepeatTimes;
            if (i2 >= i3) {
                this.repeatTimes = i3;
            }
        }
    }

    public final void addEnvTag(TaskEnvTag taskEnvTag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskEnvTag) == null) {
            ReentrantLock reentrantLock = this.fairLock;
            reentrantLock.lock();
            try {
                for (TaskEnvTag taskEnvTag2 : this.tags) {
                    if (Intrinsics.areEqual(taskEnvTag2, taskEnvTag)) {
                        if (taskEnvTag.getTimestamp() > taskEnvTag2.getTimestamp()) {
                            taskEnvTag2.setTimestamp(taskEnvTag.getTimestamp());
                        }
                        taskEnvTag2.setValue(taskEnvTag2.getValue() + taskEnvTag.getValue());
                        return;
                    }
                }
                this.tags.add(taskEnvTag);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void addNoClickTimes() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (i2 = this.maxNoClickTimes) <= 0) {
            return;
        }
        int i3 = this.curNoClickTimes + 1;
        this.curNoClickTimes = i3;
        if (i3 > i2) {
            this.curNoClickTimes = i2;
        }
    }

    public final void addStayTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            long j3 = this.stayDurTimeMs + j2;
            this.stayDurTimeMs = j3;
            long j4 = this.maxStayTimeMS;
            if (j3 > j4) {
                this.stayDurTimeMs = j4;
            }
        }
    }

    public final void cacheDuplicateId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            ReentrantLock reentrantLock = this.fairLock;
            reentrantLock.lock();
            try {
                if (this.duplicateIds.size() > 100) {
                    int size = this.duplicateIds.size() - 100;
                    Iterator<String> it = this.duplicateIds.iterator();
                    while (it.hasNext()) {
                        int i2 = size - 1;
                        if (size <= 0) {
                            break;
                        }
                        it.next();
                        it.remove();
                        size = i2;
                    }
                }
                this.duplicateIds.add(f.a.b(str));
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void cleanDuplicateId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ReentrantLock reentrantLock = this.fairLock;
            reentrantLock.lock();
            try {
                this.duplicateIds.clear();
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void cleanNoClickTimes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.curNoClickTimes = 0;
        }
    }

    public final void clearClickNumber() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.repeatTimes = 0;
        }
    }

    public final void clearStayTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.stayDurTimeMs = 0L;
        }
    }

    public final void clearTags() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ReentrantLock reentrantLock = this.fairLock;
            reentrantLock.lock();
            try {
                this.tags.clear();
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final int component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.repeatTimes : invokeV.intValue;
    }

    public final long component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.stayDurTimeMs : invokeV.longValue;
    }

    public final int component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.curNoClickTimes : invokeV.intValue;
    }

    public final long component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.maxStayTimeMS : invokeV.longValue;
    }

    public final int component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.maxRepeatTimes : invokeV.intValue;
    }

    public final int component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.maxNoClickTimes : invokeV.intValue;
    }

    public final TaskProcess copy(int i2, long j2, int i3, long j3, int i4, int i5, Set<TaskEnvTag> set, Set<String> set2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i4), Integer.valueOf(i5), set, set2})) == null) ? new TaskProcess(i2, j2, i3, j3, i4, i5, set, set2) : (TaskProcess) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof TaskProcess) {
                    TaskProcess taskProcess = (TaskProcess) obj;
                    if (this.repeatTimes == taskProcess.repeatTimes) {
                        if (this.stayDurTimeMs == taskProcess.stayDurTimeMs) {
                            if (this.curNoClickTimes == taskProcess.curNoClickTimes) {
                                if (this.maxStayTimeMS == taskProcess.maxStayTimeMS) {
                                    if (this.maxRepeatTimes == taskProcess.maxRepeatTimes) {
                                        if (!(this.maxNoClickTimes == taskProcess.maxNoClickTimes) || !Intrinsics.areEqual(this.tags, taskProcess.tags) || !Intrinsics.areEqual(this.duplicateIds, taskProcess.duplicateIds)) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final int getCurNoClickTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.curNoClickTimes : invokeV.intValue;
    }

    public final long getFormatStay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.stayDurTimeMs / 1000 : invokeV.longValue;
    }

    public final int getMaxNoClickTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.maxNoClickTimes : invokeV.intValue;
    }

    public final int getMaxRepeatTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.maxRepeatTimes : invokeV.intValue;
    }

    public final long getMaxStayTimeMS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.maxStayTimeMS : invokeV.longValue;
    }

    public final int getRepeatTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.repeatTimes : invokeV.intValue;
    }

    public final JSONArray getSerializeTags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            ReentrantLock reentrantLock = this.fairLock;
            reentrantLock.lock();
            try {
                return serializeTags();
            } finally {
                reentrantLock.unlock();
            }
        }
        return (JSONArray) invokeV.objValue;
    }

    public final long getStayDurTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.stayDurTimeMs : invokeV.longValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            long j2 = this.stayDurTimeMs;
            long j3 = this.maxStayTimeMS;
            int i2 = ((((((((((this.repeatTimes * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.curNoClickTimes) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.maxRepeatTimes) * 31) + this.maxNoClickTimes) * 31;
            Set<TaskEnvTag> set = this.tags;
            int hashCode = (i2 + (set != null ? set.hashCode() : 0)) * 31;
            Set<String> set2 = this.duplicateIds;
            return hashCode + (set2 != null ? set2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public final boolean isCompleted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? isGotClickedNumber() || isGotStayTime() : invokeV.booleanValue;
    }

    public final boolean isContainsInDuplicateIds(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            ReentrantLock reentrantLock = this.fairLock;
            reentrantLock.lock();
            try {
                return this.duplicateIds.contains(f.a.b(str));
            } finally {
                reentrantLock.unlock();
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? ITaskModelData.a.a(this) : invokeV.booleanValue;
    }

    public final boolean isGotClickedNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.repeatTimes >= this.maxRepeatTimes : invokeV.booleanValue;
    }

    public final boolean isGotMaxNoClickTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            int i2 = this.maxNoClickTimes;
            return (i2 == -1 || i2 == 0 || this.curNoClickTimes < i2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean isGotStayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.stayDurTimeMs >= this.maxStayTimeMS : invokeV.booleanValue;
    }

    public final void setCurNoClickTimes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.curNoClickTimes = i2;
        }
    }

    public final void setMaxRepeatTimes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.maxRepeatTimes = i2;
        }
    }

    public final void setMaxStayTimeMS(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048613, this, j2) == null) {
            this.maxStayTimeMS = j2;
        }
    }

    public final void setRepeatTimes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.repeatTimes = i2;
        }
    }

    public final void setStayDurTimeMs(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048615, this, j2) == null) {
            this.stayDurTimeMs = j2;
        }
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(keyClickNumber, this.repeatTimes);
            jSONObject.put(keyStayDurTimeMs, this.stayDurTimeMs);
            jSONObject.put(keyMaxStayTime, this.maxStayTimeMS);
            jSONObject.put(keyMaxRepeatTimes, this.maxRepeatTimes);
            jSONObject.put(keyCurNoClickTimes, this.curNoClickTimes);
            jSONObject.put(keyMaxNoClickTimes, this.maxNoClickTimes);
            jSONObject.put("tags", serializeTags());
            jSONObject.put(keyDuplicateIds, serializeDuplicateId());
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return "TaskProcess(repeatTimes=" + this.repeatTimes + ", stayDurTimeMs=" + this.stayDurTimeMs + ", curNoClickTimes=" + this.curNoClickTimes + ", maxStayTimeMS=" + this.maxStayTimeMS + ", maxRepeatTimes=" + this.maxRepeatTimes + ", maxNoClickTimes=" + this.maxNoClickTimes + ", tags=" + this.tags + ", duplicateIds=" + this.duplicateIds + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.bdtask.model.ITaskModelData
    public TaskProcess deepCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ReentrantLock reentrantLock = this.fairLock;
            reentrantLock.lock();
            try {
                return new TaskProcess(this.repeatTimes, this.stayDurTimeMs, this.curNoClickTimes, this.maxStayTimeMS, this.maxRepeatTimes, this.maxNoClickTimes, CollectionsKt___CollectionsKt.toHashSet(this.tags), CollectionsKt___CollectionsKt.toHashSet(this.duplicateIds));
            } finally {
                reentrantLock.unlock();
            }
        }
        return (TaskProcess) invokeV.objValue;
    }

    public /* synthetic */ TaskProcess(int i2, long j2, int i3, long j3, int i4, int i5, Set set, Set set2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i2, (i6 & 2) != 0 ? 0L : j2, (i6 & 4) != 0 ? 0 : i3, j3, i4, i5, (i6 & 64) != 0 ? new HashSet() : set, (i6 & 128) != 0 ? new HashSet() : set2);
    }
}
