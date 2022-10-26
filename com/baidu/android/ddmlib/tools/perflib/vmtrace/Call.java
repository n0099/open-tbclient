package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ddmlib.tools.perflib.vmtrace.utils.Strings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class Call {
    public static /* synthetic */ Interceptable $ic;
    public static final Formatter METHOD_ID_FORMATTER;
    public transient /* synthetic */ FieldHolder $fh;
    public final List mCallees;
    public final int mDepth;
    public final int mEntryGlobalTime;
    public final int mEntryThreadTime;
    public final int mExitGlobalTime;
    public final int mExitThreadTime;
    public final long mInclusiveGlobalTimeInCallees;
    public final long mInclusiveThreadTimeInCallees;
    public final boolean mIsRecursive;
    public final long mMethodId;

    /* loaded from: classes.dex */
    public interface Formatter {
        String format(Call call);
    }

    /* loaded from: classes.dex */
    public class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List mCallees;
        public int mEntryGlobalTime;
        public int mEntryThreadTime;
        public int mExitGlobalTime;
        public int mExitThreadTime;
        public final long mMethodId;

        public Builder(long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCallees = null;
            this.mMethodId = j;
        }

        public void addCallee(Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, builder) == null) {
                if (this.mCallees == null) {
                    this.mCallees = new ArrayList();
                }
                this.mCallees.add(builder);
            }
        }

        public Call build(Stack stack) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stack)) == null) {
                return new Call(this, stack);
            }
            return (Call) invokeL.objValue;
        }

        public List getCallees() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mCallees;
            }
            return (List) invokeV.objValue;
        }

        public int getMethodEntryGlobalTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mEntryGlobalTime;
            }
            return invokeV.intValue;
        }

        public int getMethodEntryThreadTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mEntryThreadTime;
            }
            return invokeV.intValue;
        }

        public int getMethodExitGlobalTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.mExitGlobalTime;
            }
            return invokeV.intValue;
        }

        public int getMethodExitThreadTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.mExitThreadTime;
            }
            return invokeV.intValue;
        }

        public long getMethodId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.mMethodId;
            }
            return invokeV.longValue;
        }

        public void setMethodEntryTime(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
                this.mEntryThreadTime = i;
                this.mEntryGlobalTime = i2;
            }
        }

        public void setMethodExitTime(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
                this.mExitThreadTime = i;
                this.mExitGlobalTime = i2;
            }
        }
    }

    /* loaded from: classes.dex */
    public class CallHierarchyIterator implements Iterator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Stack mCallStack;

        public CallHierarchyIterator(Call call) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {call};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Stack stack = new Stack();
            this.mCallStack = stack;
            stack.push(call);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return !this.mCallStack.isEmpty();
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                throw new UnsupportedOperationException();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Call next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.mCallStack.isEmpty()) {
                    return null;
                }
                Call call = (Call) this.mCallStack.pop();
                for (int size = call.getCallees().size() - 1; size >= 0; size--) {
                    this.mCallStack.push(call.getCallees().get(size));
                }
                return call;
            }
            return (Call) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(722241836, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/Call;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(722241836, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/Call;");
                return;
            }
        }
        METHOD_ID_FORMATTER = new Formatter() { // from class: com.baidu.android.ddmlib.tools.perflib.vmtrace.Call.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.android.ddmlib.tools.perflib.vmtrace.Call.Formatter
            public String format(Call call) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, call)) == null) {
                    return Long.toString(call.getMethodId());
                }
                return (String) invokeL.objValue;
            }
        };
    }

    public Iterator getCallHierarchyIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new CallHierarchyIterator(this);
        }
        return (Iterator) invokeV.objValue;
    }

    public List getCallees() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCallees;
        }
        return (List) invokeV.objValue;
    }

    public int getDepth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mDepth;
        }
        return invokeV.intValue;
    }

    public long getMethodId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mMethodId;
        }
        return invokeV.longValue;
    }

    public boolean isRecursive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mIsRecursive;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return format(METHOD_ID_FORMATTER);
        }
        return (String) invokeV.objValue;
    }

    public Call(Builder builder, Stack stack) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, stack};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMethodId = builder.mMethodId;
        this.mEntryThreadTime = builder.mEntryThreadTime;
        this.mEntryGlobalTime = builder.mEntryGlobalTime;
        this.mExitThreadTime = builder.mExitThreadTime;
        this.mExitGlobalTime = builder.mExitGlobalTime;
        this.mDepth = stack.size();
        this.mIsRecursive = stack.contains(Long.valueOf(this.mMethodId));
        if (builder.mCallees == null) {
            this.mCallees = Collections.emptyList();
        } else {
            stack.push(Long.valueOf(this.mMethodId));
            ArrayList arrayList = new ArrayList(builder.mCallees.size());
            for (Builder builder2 : builder.mCallees) {
                arrayList.add(builder2.build(stack));
            }
            stack.pop();
            this.mCallees = Collections.unmodifiableList(arrayList);
        }
        this.mInclusiveThreadTimeInCallees = sumInclusiveTimes(this.mCallees, ClockType.THREAD);
        this.mInclusiveGlobalTimeInCallees = sumInclusiveTimes(this.mCallees, ClockType.GLOBAL);
    }

    private void printCallHierarchy(StringBuilder sb, Formatter formatter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, sb, formatter) == null) {
            sb.append(LoadErrorCode.TOKEN_NEXT);
            sb.append(formatter.format(this));
            List callees = getCallees();
            int length = sb.length() - (sb.lastIndexOf("\n") + 1);
            for (int i = 0; i < callees.size(); i++) {
                if (i != 0) {
                    sb.append("\n");
                    sb.append(Strings.repeat(" ", length));
                }
                ((Call) callees.get(i)).printCallHierarchy(sb, formatter);
            }
        }
    }

    private long sumInclusiveTimes(List list, ClockType clockType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, list, clockType)) == null) {
            Iterator it = list.iterator();
            long j = 0;
            while (it.hasNext()) {
                j += ((Call) it.next()).getInclusiveTime(clockType, TimeUnit.MICROSECONDS);
            }
            return j;
        }
        return invokeLL.longValue;
    }

    public long getEntryTime(ClockType clockType, TimeUnit timeUnit) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, clockType, timeUnit)) == null) {
            if (clockType == ClockType.THREAD) {
                i = this.mEntryThreadTime;
            } else {
                i = this.mEntryGlobalTime;
            }
            return timeUnit.convert(i & 4294967295L, VmTraceData.getDefaultTimeUnits());
        }
        return invokeLL.longValue;
    }

    public long getExclusiveTime(ClockType clockType, TimeUnit timeUnit) {
        InterceptResult invokeLL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, clockType, timeUnit)) == null) {
            if (clockType == ClockType.THREAD) {
                j = this.mInclusiveThreadTimeInCallees;
            } else {
                j = this.mInclusiveGlobalTimeInCallees;
            }
            return timeUnit.convert(getInclusiveTime(clockType, VmTraceData.getDefaultTimeUnits()) - j, VmTraceData.getDefaultTimeUnits());
        }
        return invokeLL.longValue;
    }

    public long getExitTime(ClockType clockType, TimeUnit timeUnit) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, clockType, timeUnit)) == null) {
            if (clockType == ClockType.THREAD) {
                i = this.mExitThreadTime;
            } else {
                i = this.mExitGlobalTime;
            }
            return timeUnit.convert(i & 4294967295L, VmTraceData.getDefaultTimeUnits());
        }
        return invokeLL.longValue;
    }

    public long getInclusiveTime(ClockType clockType, TimeUnit timeUnit) {
        InterceptResult invokeLL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, clockType, timeUnit)) == null) {
            if (clockType == ClockType.THREAD) {
                i = this.mExitThreadTime;
                i2 = this.mEntryThreadTime;
            } else {
                i = this.mExitGlobalTime;
                i2 = this.mEntryGlobalTime;
            }
            return timeUnit.convert((i - i2) & 4294967295L, VmTraceData.getDefaultTimeUnits());
        }
        return invokeLL.longValue;
    }

    public String format(Formatter formatter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, formatter)) == null) {
            StringBuilder sb = new StringBuilder(100);
            printCallHierarchy(sb, formatter);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
