package c.a.n0.a.p.c;

import android.content.Context;
import android.graphics.Bitmap;
import c.a.n0.a.p.d.e0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q implements c.a.n0.a.p.d.e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public q() {
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

    @Override // c.a.n0.a.p.d.e0
    public void a(HashMap<String, String> hashMap, File file, e0.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, hashMap, file, aVar, str) == null) {
            e(aVar);
        }
    }

    @Override // c.a.n0.a.p.d.e0
    public void b(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, str3) == null) {
        }
    }

    @Override // c.a.n0.a.p.d.e0
    public void c(HashMap<String, String> hashMap, File file, e0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, hashMap, file, aVar) == null) {
            e(aVar);
        }
    }

    @Override // c.a.n0.a.p.d.e0
    public void d(Bitmap bitmap, HashMap<String, String> hashMap, File[] fileArr, e0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, bitmap, hashMap, fileArr, aVar) == null) {
            e(aVar);
        }
    }

    public final void e(e0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", "success");
                aVar.onResult(jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
