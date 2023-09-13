package com.baidu.tbadk.core.dialog.yun;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tieba.u55;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001:\u0002()B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u001fJ\u0006\u0010 \u001a\u00020\u001eJ\r\u0010!\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\"J\u0006\u0010#\u001a\u00020\u001eJ\b\u0010$\u001a\u00020\u001eH\u0016J\b\u0010%\u001a\u00020\u001eH\u0016J\b\u0010&\u001a\u00020\u001eH&J\b\u0010'\u001a\u00020\u001eH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/baidu/tbadk/core/dialog/yun/YunTask;", "", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "priority", "", "getPriority", "()I", "setPriority", "(I)V", "queue", "Lcom/baidu/tbadk/core/dialog/yun/YunPriorityQueue;", "status", "Lcom/baidu/tbadk/core/dialog/yun/YunTask$Status;", "getStatus$tbadkcore_release", "()Lcom/baidu/tbadk/core/dialog/yun/YunTask$Status;", "setStatus$tbadkcore_release", "(Lcom/baidu/tbadk/core/dialog/yun/YunTask$Status;)V", "type", "Lcom/baidu/tbadk/core/dialog/yun/YunTask$Type;", "getType", "()Lcom/baidu/tbadk/core/dialog/yun/YunTask$Type;", "setType", "(Lcom/baidu/tbadk/core/dialog/yun/YunTask$Type;)V", "attachQueue", "", "attachQueue$tbadkcore_release", "cancel", "execute", "execute$tbadkcore_release", "finish", GameAssistConstKt.TYPE_CALLBACK_CANCEL, "onDiscard", "onExecute", "onFinish", "Status", "Type", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class YunTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Type b;
    public u55 c;
    public Status d;

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public abstract void h();

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/tbadk/core/dialog/yun/YunTask$Status;", "", "(Ljava/lang/String;I)V", "isCanceled", "", "isExecuting", "isFinished", "isUnStart", "UN_START", "EXECUTING", "CANCELED", "FINISHED", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Status {
        public static final /* synthetic */ Status[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Status CANCELED;
        public static final Status EXECUTING;
        public static final Status FINISHED;
        public static final Status UN_START;
        public transient /* synthetic */ FieldHolder $fh;

        public static final /* synthetic */ Status[] $values() {
            return new Status[]{UN_START, EXECUTING, CANCELED, FINISHED};
        }

        public static Status valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Status) Enum.valueOf(Status.class, str) : (Status) invokeL.objValue;
        }

        public static Status[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Status[]) $VALUES.clone() : (Status[]) invokeV.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1177173723, "Lcom/baidu/tbadk/core/dialog/yun/YunTask$Status;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1177173723, "Lcom/baidu/tbadk/core/dialog/yun/YunTask$Status;");
                    return;
                }
            }
            UN_START = new Status("UN_START", 0);
            EXECUTING = new Status("EXECUTING", 1);
            CANCELED = new Status("CANCELED", 2);
            FINISHED = new Status("FINISHED", 3);
            $VALUES = $values();
        }

        public Status(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                }
            }
        }

        public final boolean isCanceled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this == CANCELED) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final boolean isExecuting() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this == EXECUTING) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final boolean isFinished() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this == FINISHED) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final boolean isUnStart() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this == UN_START) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/tbadk/core/dialog/yun/YunTask$Type;", "", "(Ljava/lang/String;I)V", "DISCARD", "DIRECT_EXECUTE", "ENQUEUE", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Type DIRECT_EXECUTE;
        public static final Type DISCARD;
        public static final Type ENQUEUE;
        public transient /* synthetic */ FieldHolder $fh;

        public static final /* synthetic */ Type[] $values() {
            return new Type[]{DISCARD, DIRECT_EXECUTE, ENQUEUE};
        }

        public static Type valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Type) Enum.valueOf(Type.class, str) : (Type) invokeL.objValue;
        }

        public static Type[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Type[]) $VALUES.clone() : (Type[]) invokeV.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(616620509, "Lcom/baidu/tbadk/core/dialog/yun/YunTask$Type;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(616620509, "Lcom/baidu/tbadk/core/dialog/yun/YunTask$Type;");
                    return;
                }
            }
            DISCARD = new Type("DISCARD", 0);
            DIRECT_EXECUTE = new Type("DIRECT_EXECUTE", 1);
            ENQUEUE = new Type("ENQUEUE", 2);
            $VALUES = $values();
        }

        public Type(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                }
            }
        }
    }

    public YunTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = Type.DIRECT_EXECUTE;
        this.d = Status.UN_START;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = Status.EXECUTING;
            h();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d = Status.FINISHED;
            i();
            u55 u55Var = this.c;
            if (u55Var != null) {
                u55Var.e(this);
            }
        }
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public final Status f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (Status) invokeV.objValue;
    }

    public final Type getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (Type) invokeV.objValue;
    }

    public final void b(u55 queue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, queue) == null) {
            Intrinsics.checkNotNullParameter(queue, "queue");
            this.c = queue;
        }
    }

    public final void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.a = i;
        }
    }

    public final void l(Type type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, type) == null) {
            Intrinsics.checkNotNullParameter(type, "<set-?>");
            this.b = type;
        }
    }
}
