package b.a.r0.f4;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<C0852a> f16598a;

    /* renamed from: b.a.r0.f4.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0852a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f16599a;

        /* renamed from: b  reason: collision with root package name */
        public String f16600b;

        public C0852a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public a() {
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
        this.f16598a = new ArrayList();
    }

    public List<C0852a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16598a : (List) invokeV.objValue;
    }

    public final void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null) {
            return;
        }
        try {
            if (jSONArray.length() > 0) {
                if (this.f16598a == null) {
                    this.f16598a = new ArrayList();
                }
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    C0852a c0852a = new C0852a();
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    c0852a.f16599a = optJSONObject.optInt("tab_id");
                    c0852a.f16600b = optJSONObject.optString("tab_name");
                    optJSONObject.optInt("obj_type");
                    this.f16598a.add(c0852a);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray) == null) || jSONArray == null) {
            return;
        }
        b(jSONArray);
    }
}
