package c.a.j.g.f;

import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.utils.UniqueId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class a extends c.a.j.g.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final UniqueId f3523b;

    /* renamed from: c  reason: collision with root package name */
    public static final C0140a f3524c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.j.g.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0140a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0140a() {
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

        public final UniqueId a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a.f3523b : (UniqueId) invokeV.objValue;
        }

        public /* synthetic */ C0140a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1392769430, "Lc/a/j/g/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1392769430, "Lc/a/j/g/f/a;");
                return;
            }
        }
        f3524c = new C0140a(null);
        UniqueId gen = UniqueId.gen("TaskBackFlowCancelEvent");
        Intrinsics.checkExpressionValueIsNotNull(gen, "UniqueId.gen(\"TaskBackFlowCancelEvent\")");
        f3523b = gen;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TaskInfo taskInfo) {
        super(taskInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TaskInfo) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "" + f3524c.a().getAlias() + ':' + a().toJson();
        }
        return (String) invokeV.objValue;
    }
}
