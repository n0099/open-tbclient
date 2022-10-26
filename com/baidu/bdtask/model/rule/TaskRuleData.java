package com.baidu.bdtask.model.rule;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u0000 J2\u00020\u0001:\u0001JBk\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\bH\u0010IJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÂ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0007Jt\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0000H\u0016¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\t¢\u0006\u0004\b&\u0010\u000bJ\u0010\u0010'\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b'\u0010\u0007J\u000f\u0010(\u001a\u00020\u000eH\u0016¢\u0006\u0004\b(\u0010\u0010J\r\u0010)\u001a\u00020\u000e¢\u0006\u0004\b)\u0010\u0010J\r\u0010*\u001a\u00020\u000e¢\u0006\u0004\b*\u0010\u0010J\r\u0010+\u001a\u00020\u000e¢\u0006\u0004\b+\u0010\u0010J\u000f\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0002H\u0016¢\u0006\u0004\b/\u0010\u0004J\u0015\u00102\u001a\u0002012\u0006\u00100\u001a\u00020\u0005¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\u0002012\u0006\u00104\u001a\u00020\u0005¢\u0006\u0004\b5\u00103R\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00106R\u0019\u0010\u001b\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00107\u001a\u0004\b8\u0010\u0010R\u0019\u0010\u0016\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u00109\u001a\u0004\b:\u0010\u000bR\u0019\u0010\u001c\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00106\u001a\u0004\b;\u0010\u0007R\u0019\u0010\u001a\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00107\u001a\u0004\b<\u0010\u0010R\u0019\u0010\u001d\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00106\u001a\u0004\b=\u0010\u0007R\"\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u00106\u001a\u0004\b>\u0010\u0007\"\u0004\b?\u00103R\"\u0010@\u001a\u00020\t8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u00109\u001a\u0004\bA\u0010\u000b\"\u0004\bB\u0010CR\u0019\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00107\u001a\u0004\bD\u0010\u0010R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010E\u001a\u0004\bF\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010E\u001a\u0004\bG\u0010\u0004¨\u0006K"}, d2 = {"Lcom/baidu/bdtask/model/rule/TaskRuleData;", "Lcom/baidu/bdtask/model/ITaskModelData;", "", "component1", "()Ljava/lang/String;", "", "component10", "()I", "component2", "", "component3", "()J", "component4", "component5", "", "component6", "()Z", "component7", "component8", "component9", "versionLimit", "url", "expireTime", "_stay", "repeat", TaskRuleData.keyUniq, TaskRuleData.keyPersist, "auto", TaskRuleData.keyNoClickTimes, TaskRuleData.keyPersistOnFail, "copy", "(Ljava/lang/String;Ljava/lang/String;JIIZZZII)Lcom/baidu/bdtask/model/rule/TaskRuleData;", "deepCopy", "()Lcom/baidu/bdtask/model/rule/TaskRuleData;", "", ImageViewerConfig.FROM_OTHER, "equals", "(Ljava/lang/Object;)Z", "getFormatStay", TTDownloadField.TT_HASHCODE, "isEmpty", "isNeedPersist", "isNeedSkipRequestError", "isNeedUnique", "Lorg/json/JSONObject;", "toJson", "()Lorg/json/JSONObject;", "toString", "newRepeat", "", "updateMaxRepeat", "(I)V", "newStay", "updateMaxStay", "I", "Z", "getAuto", "J", "getExpireTime", "getNoclickTimes", "getPersist", "getPersistOnFail", "getRepeat", "setRepeat", "stay", "getStay", "setStay", "(J)V", "getUniq", "Ljava/lang/String;", "getUrl", "getVersionLimit", "<init>", "(Ljava/lang/String;Ljava/lang/String;JIIZZZII)V", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class TaskRuleData implements ITaskModelData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final int MAX_REPEAT_TIMES = Integer.MAX_VALUE;
    public static final int MAX_STAY_TIMES = Integer.MAX_VALUE;
    public static final long TIME_UNIT = 1000;
    public static final String key = "rule";
    public static final String keyAuto = "auto";
    public static final String keyExpire = "expire";
    public static final String keyNoClickTimes = "noclickTimes";
    public static final String keyPersist = "persist";
    public static final String keyPersistOnFail = "persistOnFail";
    public static final String keyRepeat = "repeat";
    public static final String keyStay = "stay";
    public static final String keyUniq = "uniq";
    public static final String keyUrl = "url";
    public static final String keyVer = "ver";
    public transient /* synthetic */ FieldHolder $fh;
    public int _stay;
    public final boolean auto;
    public final long expireTime;
    public final int noclickTimes;
    public final boolean persist;
    public final int persistOnFail;
    public int repeat;
    public long stay;
    public final boolean uniq;
    public final String url;
    public final String versionLimit;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(273393245, "Lcom/baidu/bdtask/model/rule/TaskRuleData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(273393245, "Lcom/baidu/bdtask/model/rule/TaskRuleData;");
                return;
            }
        }
        Companion = new a(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskRuleData() {
        this(null, null, 0L, 0, 0, false, false, false, 0, 0, 1023, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], (String) objArr[1], ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue(), ((Boolean) objArr[5]).booleanValue(), ((Boolean) objArr[6]).booleanValue(), ((Boolean) objArr[7]).booleanValue(), ((Integer) objArr[8]).intValue(), ((Integer) objArr[9]).intValue(), ((Integer) objArr[10]).intValue(), (DefaultConstructorMarker) objArr[11]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private final int component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this._stay : invokeV.intValue;
    }

    public static /* synthetic */ TaskRuleData copy$default(TaskRuleData taskRuleData, String str, String str2, long j, int i, int i2, boolean z, boolean z2, boolean z3, int i3, int i4, int i5, Object obj) {
        return taskRuleData.copy((i5 & 1) != 0 ? taskRuleData.versionLimit : str, (i5 & 2) != 0 ? taskRuleData.url : str2, (i5 & 4) != 0 ? taskRuleData.expireTime : j, (i5 & 8) != 0 ? taskRuleData._stay : i, (i5 & 16) != 0 ? taskRuleData.repeat : i2, (i5 & 32) != 0 ? taskRuleData.uniq : z, (i5 & 64) != 0 ? taskRuleData.persist : z2, (i5 & 128) != 0 ? taskRuleData.auto : z3, (i5 & 256) != 0 ? taskRuleData.noclickTimes : i3, (i5 & 512) != 0 ? taskRuleData.persistOnFail : i4);
    }

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.versionLimit : (String) invokeV.objValue;
    }

    public final int component10() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.persistOnFail : invokeV.intValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.url : (String) invokeV.objValue;
    }

    public final long component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.expireTime : invokeV.longValue;
    }

    public final int component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.repeat : invokeV.intValue;
    }

    public final boolean component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.uniq : invokeV.booleanValue;
    }

    public final boolean component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.persist : invokeV.booleanValue;
    }

    public final boolean component8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.auto : invokeV.booleanValue;
    }

    public final int component9() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.noclickTimes : invokeV.intValue;
    }

    public final TaskRuleData copy(String str, String str2, long j, int i, int i2, boolean z, boolean z2, boolean z3, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, str2, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) ? new TaskRuleData(str, str2, j, i, i2, z, z2, z3, i3, i4) : (TaskRuleData) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof TaskRuleData) {
                    TaskRuleData taskRuleData = (TaskRuleData) obj;
                    if (Intrinsics.areEqual(this.versionLimit, taskRuleData.versionLimit) && Intrinsics.areEqual(this.url, taskRuleData.url)) {
                        if (this.expireTime == taskRuleData.expireTime) {
                            if (this._stay == taskRuleData._stay) {
                                if (this.repeat == taskRuleData.repeat) {
                                    if (this.uniq == taskRuleData.uniq) {
                                        if (this.persist == taskRuleData.persist) {
                                            if (this.auto == taskRuleData.auto) {
                                                if (this.noclickTimes == taskRuleData.noclickTimes) {
                                                    if (this.persistOnFail == taskRuleData.persistOnFail) {
                                                    }
                                                }
                                            }
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String str = this.versionLimit;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.url;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            long j = this.expireTime;
            int i = (((((((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this._stay) * 31) + this.repeat) * 31;
            boolean z = this.uniq;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            boolean z2 = this.persist;
            int i4 = z2;
            if (z2 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            boolean z3 = this.auto;
            return ((((i5 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.noclickTimes) * 31) + this.persistOnFail;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TaskRuleData(String str, String str2, long j, int i, int i2, boolean z, boolean z2, boolean z3, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str, str2, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.versionLimit = str;
        this.url = str2;
        this.expireTime = j;
        this._stay = i;
        this.repeat = i2;
        this.uniq = z;
        this.persist = z2;
        this.auto = z3;
        this.noclickTimes = i3;
        this.persistOnFail = i4;
        this.stay = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TaskRuleData(String str, String str2, long j, int i, int i2, boolean z, boolean z2, boolean z3, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, r3, r5, r7, r8, r9, r10, r11, (i5 & 512) == 0 ? i4 : 0);
        String str3;
        long j2;
        int i6;
        int i7;
        boolean z4;
        boolean z5;
        boolean z6;
        int i8;
        if ((i5 & 1) != 0) {
            str3 = "";
        } else {
            str3 = str;
        }
        String str4 = (i5 & 2) == 0 ? str2 : "";
        if ((i5 & 4) != 0) {
            j2 = 0;
        } else {
            j2 = j;
        }
        if ((i5 & 8) != 0) {
            i6 = 0;
        } else {
            i6 = i;
        }
        if ((i5 & 16) != 0) {
            i7 = 0;
        } else {
            i7 = i2;
        }
        if ((i5 & 32) != 0) {
            z4 = false;
        } else {
            z4 = z;
        }
        if ((i5 & 64) != 0) {
            z5 = false;
        } else {
            z5 = z2;
        }
        if ((i5 & 128) != 0) {
            z6 = true;
        } else {
            z6 = z3;
        }
        if ((i5 & 256) != 0) {
            i8 = -1;
        } else {
            i8 = i3;
        }
    }

    public final boolean getAuto() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.auto;
        }
        return invokeV.booleanValue;
    }

    public final long getExpireTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.expireTime;
        }
        return invokeV.longValue;
    }

    public final long getFormatStay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return getStay() / 1000;
        }
        return invokeV.longValue;
    }

    public final int getNoclickTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.noclickTimes;
        }
        return invokeV.intValue;
    }

    public final boolean getPersist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.persist;
        }
        return invokeV.booleanValue;
    }

    public final int getPersistOnFail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.persistOnFail;
        }
        return invokeV.intValue;
    }

    public final int getRepeat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.repeat;
        }
        return invokeV.intValue;
    }

    public final long getStay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this._stay * 1000;
        }
        return invokeV.longValue;
    }

    public final boolean getUniq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.uniq;
        }
        return invokeV.booleanValue;
    }

    public final String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.url;
        }
        return (String) invokeV.objValue;
    }

    public final String getVersionLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.versionLimit;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.expireTime == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean isNeedPersist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.persist;
        }
        return invokeV.booleanValue;
    }

    public final boolean isNeedSkipRequestError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.persistOnFail == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean isNeedUnique() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.uniq;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            String jSONObject = toJson().toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject, "toJson().toString()");
            return jSONObject;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.bdtask.model.ITaskModelData
    public TaskRuleData deepCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return copy$default(this, null, null, 0L, 0, 0, false, false, false, 0, 0, 1023, null);
        }
        return (TaskRuleData) invokeV.objValue;
    }

    public final void setRepeat(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.repeat = i;
        }
    }

    public final void setStay(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048606, this, j) == null) {
            this.stay = j;
        }
    }

    public final void updateMaxRepeat(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.repeat = i;
        }
    }

    public final void updateMaxStay(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this._stay = i;
        }
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.versionLimit);
            jSONObject.put("url", this.url);
            jSONObject.put("expire", this.expireTime);
            jSONObject.put("stay", this._stay);
            jSONObject.put("repeat", this.repeat);
            jSONObject.put(keyUniq, this.uniq);
            jSONObject.put(keyPersist, this.persist);
            jSONObject.put("auto", this.auto);
            jSONObject.put(keyNoClickTimes, this.noclickTimes);
            jSONObject.put(keyPersistOnFail, this.persistOnFail);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
