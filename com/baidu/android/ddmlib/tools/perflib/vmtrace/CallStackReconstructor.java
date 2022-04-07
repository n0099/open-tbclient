package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ddmlib.tools.perflib.vmtrace.Call;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/* loaded from: classes.dex */
public class CallStackReconstructor {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Stack<Call.Builder> mCallStack;
    public Call mTopLevelCall;
    public final long mTopLevelCallId;
    public final List<Call.Builder> mTopLevelCalls;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(939022445, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/CallStackReconstructor;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(939022445, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/CallStackReconstructor;");
        }
    }

    public CallStackReconstructor(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTopLevelCalls = new ArrayList();
        this.mCallStack = new Stack<>();
        this.mTopLevelCallId = j;
    }

    private void enterMethod(long j, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            Call.Builder builder = new Call.Builder(j);
            builder.setMethodEntryTime(i, i2);
            if (this.mCallStack.isEmpty()) {
                this.mTopLevelCalls.add(builder);
            } else {
                this.mCallStack.peek().addCallee(builder);
            }
            this.mCallStack.push(builder);
        }
    }

    private void exitMethod(long j, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (!this.mCallStack.isEmpty()) {
                Call.Builder pop = this.mCallStack.pop();
                if (pop.getMethodId() == j) {
                    pop.setMethodExitTime(i, i2);
                    return;
                }
                throw new RuntimeException(String.format("Error during call stack reconstruction. Attempt to exit from method 0x%1$x while in method 0x%2$x", Long.valueOf(pop.getMethodId()), Long.valueOf(j)));
            }
            Call.Builder builder = new Call.Builder(j);
            for (Call.Builder builder2 : this.mTopLevelCalls) {
                builder.addCallee(builder2);
            }
            this.mTopLevelCalls.clear();
            this.mTopLevelCalls.add(builder);
            builder.setMethodExitTime(i, i2);
            int i3 = i - 1;
            int i4 = i2 - 1;
            if (builder.getCallees() != null && !builder.getCallees().isEmpty()) {
                Call.Builder builder3 = builder.getCallees().get(0);
                i3 = Math.max(builder3.getMethodEntryThreadTime() - 1, 0);
                i4 = Math.max(builder3.getMethodEntryGlobalTime() - 1, 0);
            }
            builder.setMethodEntryTime(i3, i4);
        }
    }

    private void fixupCallStacks() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && this.mTopLevelCall == null) {
            while (!this.mCallStack.isEmpty()) {
                Call.Builder peek = this.mCallStack.peek();
                exitMethod(peek.getMethodId(), peek.getMethodEntryThreadTime(), peek.getMethodEntryGlobalTime(), peek.getCallees());
            }
            exitMethod(this.mTopLevelCallId, 0, 0, this.mTopLevelCalls);
            this.mTopLevelCall = this.mTopLevelCalls.get(0).build(new Stack<>());
        }
    }

    public void addTraceAction(long j, TraceAction traceAction, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), traceAction, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (traceAction == TraceAction.METHOD_ENTER) {
                enterMethod(j, i, i2);
            } else {
                exitMethod(j, i, i2);
            }
        }
    }

    public Call getTopLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            fixupCallStacks();
            return this.mTopLevelCall;
        }
        return (Call) invokeV.objValue;
    }

    private void exitMethod(long j, int i, int i2, @Nullable List<Call.Builder> list) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), list}) == null) {
            if (list == null || list.isEmpty()) {
                int i5 = i2 + 1;
                i3 = i + 1;
                i4 = i5;
            } else {
                Call.Builder builder = list.get(list.size() - 1);
                i3 = builder.getMethodExitThreadTime() + 1;
                i4 = builder.getMethodExitGlobalTime() + 1;
            }
            exitMethod(j, i3, i4);
        }
    }
}
