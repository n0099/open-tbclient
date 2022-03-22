package c.a.o0.h0;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static f f10310e;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<MaintabBottomIndicator> a;

    /* renamed from: b  reason: collision with root package name */
    public View f10311b;

    /* renamed from: c  reason: collision with root package name */
    public Object f10312c;

    /* renamed from: d  reason: collision with root package name */
    public View f10313d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(852189876, "Lc/a/o0/h0/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(852189876, "Lc/a/o0/h0/f;");
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
    }

    public static f b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f10310e == null) {
                synchronized (f.class) {
                    if (f10310e == null) {
                        f10310e = new f();
                    }
                }
            }
            return f10310e;
        }
        return (f) invokeV.objValue;
    }

    public MaintabBottomIndicator a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a.isEmpty()) {
                return null;
            }
            MaintabBottomIndicator maintabBottomIndicator = this.a.get(0);
            this.a.remove(maintabBottomIndicator);
            return maintabBottomIndicator;
        }
        return (MaintabBottomIndicator) invokeV.objValue;
    }

    public void c(MaintabBottomIndicator maintabBottomIndicator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, maintabBottomIndicator) == null) {
            this.a.add(maintabBottomIndicator);
        }
    }
}
