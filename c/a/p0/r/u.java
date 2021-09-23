package c.a.p0.r;

import android.util.SparseIntArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f12378a;

    /* renamed from: b  reason: collision with root package name */
    public SparseIntArray f12379b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f12380c;

    /* renamed from: d  reason: collision with root package name */
    public long f12381d;

    /* renamed from: e  reason: collision with root package name */
    public long f12382e;

    /* renamed from: f  reason: collision with root package name */
    public String f12383f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12384g;

    public u() {
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
        this.f12384g = false;
        this.f12378a = new JSONArray();
        this.f12379b = new SparseIntArray();
        this.f12380c = new ArrayList<>();
        this.f12381d = 0L;
        this.f12382e = 0L;
        this.f12383f = "0";
    }

    public final void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            this.f12378a.put(jSONObject);
        }
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f12378a.toString().getBytes().length >= i2 : invokeI.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f12379b.clear();
            this.f12380c.clear();
            this.f12378a = null;
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12378a.length() == 0 : invokeV.booleanValue;
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.f12380c.contains(str)) {
            return;
        }
        this.f12380c.add(str);
    }

    public final void f(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            this.f12379b.put(i2, i3);
        }
    }

    public final void g(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            long j4 = this.f12381d;
            if ((j2 < j4 || j4 == 0) && j2 != 0) {
                this.f12381d = j2;
            }
            if (j3 > this.f12382e) {
                this.f12382e = j3;
            }
        }
    }
}
