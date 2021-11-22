package b.a.s.a.d;

import b.a.s.a.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f29476a;

    /* renamed from: b  reason: collision with root package name */
    public String f29477b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29478c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f29479d;

    public a(boolean z, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), jSONArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29478c = z;
        this.f29476a = jSONArray;
        this.f29477b = String.valueOf(System.currentTimeMillis());
    }

    public final JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = this.f29476a;
            if (jSONArray == null || jSONArray.length() < 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("metadata", b());
                jSONObject.put(Constant.IS_REAL, this.f29478c ? "1" : "0");
                jSONObject.put("data", this.f29476a);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c.a("UploadData", "uploadJson:" + jSONObject.toString());
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("uploadtime", this.f29477b);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.f29479d = jSONObject;
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
