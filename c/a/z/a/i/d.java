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
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Vector<Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public long f22216b;

    /* renamed from: c  reason: collision with root package name */
    public long f22217c;

    /* renamed from: d  reason: collision with root package name */
    public Vector<Integer> f22218d;

    public d() {
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
        this.a = new Vector<>();
        this.f22217c = 0L;
        this.f22218d = new Vector<>();
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
            for (int i = 0; i < size; i++) {
                Integer num = this.a.get(i);
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
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                Integer num = this.a.get(i2);
                if (num != null) {
                    i += num.intValue();
                }
            }
            float f2 = (i * 1.0f) / size;
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
            Vector<Integer> vector = this.f22218d;
            if (vector == null || vector.size() == 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            float f2 = 0.0f;
            int size = this.f22218d.size();
            for (int i = 0; i < size; i++) {
                Integer num = this.f22218d.get(i);
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
            if (this.f22216b <= 0) {
                this.f22216b = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i = (int) (currentTimeMillis - this.f22216b);
            if (i < 0) {
                return;
            }
            this.a.add(Integer.valueOf(i));
            this.f22216b = currentTimeMillis;
        }
    }

    public void e() {
        int currentTimeMillis;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f22217c <= 0 || (currentTimeMillis = (int) (System.currentTimeMillis() - this.f22217c)) < 0) {
            return;
        }
        this.f22218d.add(Integer.valueOf(currentTimeMillis));
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f22217c = System.currentTimeMillis();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f22216b = 0L;
            this.f22217c = 0L;
            this.a.clear();
            this.f22218d.clear();
        }
    }
}
