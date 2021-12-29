package c.a.b0.a.i;

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
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Vector<Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public long f1619b;

    /* renamed from: c  reason: collision with root package name */
    public long f1620c;

    /* renamed from: d  reason: collision with root package name */
    public Vector<Integer> f1621d;

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
        this.a = new Vector<>();
        this.f1620c = 0L;
        this.f1621d = new Vector<>();
    }

    public String a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            Vector<Integer> vector = this.a;
            if (vector == null || vector.size() == 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            float f2 = 0.0f;
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                Integer num = this.a.get(i2);
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
            Vector<Integer> vector = this.a;
            if (vector == null || vector.size() == 0) {
                return 0;
            }
            int size = this.a.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = this.a.get(i3);
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
            Vector<Integer> vector = this.f1621d;
            if (vector == null || vector.size() == 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            float f2 = 0.0f;
            int size = this.f1621d.size();
            for (int i2 = 0; i2 < size; i2++) {
                Integer num = this.f1621d.get(i2);
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
            if (this.f1619b <= 0) {
                this.f1619b = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = (int) (currentTimeMillis - this.f1619b);
            if (i2 < 0) {
                return;
            }
            this.a.add(Integer.valueOf(i2));
            this.f1619b = currentTimeMillis;
        }
    }

    public void e() {
        int currentTimeMillis;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f1620c <= 0 || (currentTimeMillis = (int) (System.currentTimeMillis() - this.f1620c)) < 0) {
            return;
        }
        this.f1621d.add(Integer.valueOf(currentTimeMillis));
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f1620c = System.currentTimeMillis();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f1619b = 0L;
            this.f1620c = 0L;
            this.a.clear();
            this.f1621d.clear();
        }
    }
}
