package c.a.c0.z;

import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.sweetsqlite.BooleanColumn;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.nadcore.sweetsqlite.StringColumn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2147b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2148c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2149d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2150e;

    public b(int i2, String str, String str2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2, Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i2;
        this.f2147b = str;
        this.f2150e = str2;
        this.f2148c = i3;
        this.f2149d = i4;
    }

    public static boolean a(Column column) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, column)) == null) ? ((BooleanColumn) column).getValue() : invokeL.booleanValue;
    }

    public static int b(Column column) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, column)) == null) ? ((IntegerColumn) column).getValue() : invokeL.intValue;
    }

    public static long c(Column column) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, column)) == null) ? ((LongColumn) column).getValue() : invokeL.longValue;
    }

    public static String d(Column column) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, column)) == null) ? ((StringColumn) column).getValue() : (String) invokeL.objValue;
    }
}
