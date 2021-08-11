package c.a.z.a.i;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.Vector;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Vector<Integer> f31003a;

    /* renamed from: b  reason: collision with root package name */
    public long f31004b;

    /* renamed from: c  reason: collision with root package name */
    public long f31005c;

    /* renamed from: d  reason: collision with root package name */
    public Vector<Integer> f31006d;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31003a = new Vector<>();
        this.f31005c = 0L;
        this.f31006d = new Vector<>();
    }

    public String a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            Vector<Integer> vector = this.f31003a;
            if (vector == null || vector.size() == 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            float f2 = 0.0f;
            int size = this.f31003a.size();
            for (int i2 = 0; i2 < size; i2++) {
                Integer num = this.f31003a.get(i2);
                if (num != null) {
                    f2 += num.intValue();
                    jSONArray.put(num);
                }
            }
            if (z) {
                String jSONArray2 = jSONArray.toString();
                return TextUtils.isEmpty(jSONArray2) ? "" : jSONArray2;
            }
            return new DecimalFormat(".0").format(f2 / size);
        }
        return (String) invokeZ.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Vector<Integer> vector = this.f31003a;
            if (vector == null || vector.size() == 0) {
                return 0;
            }
            int size = this.f31003a.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = this.f31003a.get(i3);
                if (num != null) {
                    i2 += num.intValue();
                }
            }
            float f2 = (i2 * 1.0f) / size;
            if (f2 == 0.0f) {
                return 0;
            }
            return Math.round(1000.0f / f2);
        }
        return invokeV.intValue;
    }

    public String c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            Vector<Integer> vector = this.f31006d;
            if (vector == null || vector.size() == 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            float f2 = 0.0f;
            int size = this.f31006d.size();
            for (int i2 = 0; i2 < size; i2++) {
                Integer num = this.f31006d.get(i2);
                if (num != null) {
                    f2 += num.intValue();
                    jSONArray.put(num);
                }
            }
            if (z) {
                String jSONArray2 = jSONArray.toString();
                return TextUtils.isEmpty(jSONArray2) ? "" : jSONArray2;
            }
            return new DecimalFormat(".0").format(f2 / size);
        }
        return (String) invokeZ.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f31004b <= 0) {
                this.f31004b = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = (int) (currentTimeMillis - this.f31004b);
            if (i2 < 0) {
                return;
            }
            this.f31003a.add(Integer.valueOf(i2));
            this.f31004b = currentTimeMillis;
        }
    }

    public void e() {
        int currentTimeMillis;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f31005c <= 0 || (currentTimeMillis = (int) (System.currentTimeMillis() - this.f31005c)) < 0) {
            return;
        }
        this.f31006d.add(Integer.valueOf(currentTimeMillis));
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f31005c = System.currentTimeMillis();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f31004b = 0L;
            this.f31005c = 0L;
            this.f31003a.clear();
            this.f31006d.clear();
        }
    }
}
