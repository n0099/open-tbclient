package bolts;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class AggregateException extends Exception {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_MESSAGE = "There were multiple errors.";
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Throwable> innerThrowables;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AggregateException(String str, Throwable[] thArr) {
        this(str, Arrays.asList(thArr));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, thArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Deprecated
    public Throwable[] getCauses() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<Throwable> list = this.innerThrowables;
            return (Throwable[]) list.toArray(new Throwable[list.size()]);
        }
        return (Throwable[]) invokeV.objValue;
    }

    @Deprecated
    public List<Exception> getErrors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<Throwable> list = this.innerThrowables;
            if (list == null) {
                return arrayList;
            }
            for (Throwable th : list) {
                if (th instanceof Exception) {
                    arrayList.add((Exception) th);
                } else {
                    arrayList.add(new Exception(th));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<Throwable> getInnerThrowables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.innerThrowables : (List) invokeV.objValue;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, printStream) == null) {
            super.printStackTrace(printStream);
            int i2 = -1;
            for (Throwable th : this.innerThrowables) {
                printStream.append("\n");
                printStream.append("  Inner throwable #");
                i2++;
                printStream.append((CharSequence) Integer.toString(i2));
                printStream.append(": ");
                th.printStackTrace(printStream);
                printStream.append("\n");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AggregateException(String str, List<? extends Throwable> list) {
        super(str, (list == null || list.size() <= 0) ? null : list.get(0));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Throwable) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.innerThrowables = Collections.unmodifiableList(list);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AggregateException(List<? extends Throwable> list) {
        this(DEFAULT_MESSAGE, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, printWriter) == null) {
            super.printStackTrace(printWriter);
            int i2 = -1;
            for (Throwable th : this.innerThrowables) {
                printWriter.append("\n");
                printWriter.append("  Inner throwable #");
                i2++;
                printWriter.append((CharSequence) Integer.toString(i2));
                printWriter.append(": ");
                th.printStackTrace(printWriter);
                printWriter.append("\n");
            }
        }
    }
}
