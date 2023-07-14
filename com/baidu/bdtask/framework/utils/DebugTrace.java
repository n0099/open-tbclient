package com.baidu.bdtask.framework.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.es;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\bÇ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\bJ1\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/baidu/bdtask/framework/utils/DebugTrace;", "Lkotlin/Function0;", "", "msgAction", "", "debug", "(Lkotlin/Function0;)V", "msg", "(Ljava/lang/String;)V", "subTag", "with", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/Function0;)V", "", "isDebugAble", "()Z", "SUB_TAG_STATE", "Ljava/lang/String;", "TAG", "<init>", "()V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class DebugTrace {
    public static /* synthetic */ Interceptable $ic;
    public static final DebugTrace a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(285097920, "Lcom/baidu/bdtask/framework/utils/DebugTrace;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(285097920, "Lcom/baidu/bdtask/framework/utils/DebugTrace;");
                return;
            }
        }
        a = new DebugTrace();
    }

    public DebugTrace() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!es.c.l() || !es.c.h().c()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.bdtask.framework.utils.DebugTrace */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(DebugTrace debugTrace, String str, String str2, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        debugTrace.b(str, str2, function0);
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            b(str, "", null);
        }
    }

    public final void c(Function0<String> function0) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, function0) == null) && e()) {
            b(function0.invoke(), "", null);
        }
    }

    public final void b(String str, final String str2, Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, function0) != null) || !e()) {
            return;
        }
        Log.d(new Function0<String>(str2) { // from class: com.baidu.bdtask.framework.utils.DebugTrace$debug$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String $subTag;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.$subTag = str2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    DebugTrace debugTrace = DebugTrace.a;
                    if (TextUtils.isEmpty(this.$subTag)) {
                        return "bdptask_sdk";
                    }
                    return "bdptask_sdk:" + this.$subTag;
                }
                return (String) invokeV.objValue;
            }
        }.invoke(), str);
        if (function0 != null) {
            function0.invoke();
        }
    }
}
