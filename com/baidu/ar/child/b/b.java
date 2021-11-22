package com.baidu.ar.child.b;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.h.s;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a {
        void e(byte[] bArr);
    }

    public b() {
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

    private void a(a aVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, this, aVar, bArr) == null) || aVar == null) {
            return;
        }
        aVar.e(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, this, jSONObject, aVar) == null) && jSONObject.has("err_no")) {
            if (jSONObject.getInt("err_no") != 0) {
                a(aVar, (byte[]) null);
            } else if (jSONObject.has("feature_res")) {
                byte[] decode = Base64.decode(jSONObject.getString("feature_res"), 0);
                if (aVar != null) {
                    aVar.e(decode);
                }
                a(aVar, decode);
            }
        }
    }

    private String x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) ? i2 != -90 ? i2 != 0 ? i2 != 90 ? i2 != 180 ? "V" : "FV" : "HL" : "V" : "HR" : (String) invokeI.objValue;
    }

    public void a(byte[] bArr, int i2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, bArr, i2, aVar) == null) {
            String gV = s.gV();
            HashMap hashMap = new HashMap();
            String encodeToString = Base64.encodeToString(bArr, 0);
            String x = x(i2);
            hashMap.put("image", encodeToString);
            hashMap.put("svc_name", "child-face");
            hashMap.put(TiebaStatic.Params.VID, x);
            com.baidu.ar.child.b.a.a(gV, hashMap, new com.baidu.ar.ihttp.a(this, aVar) { // from class: com.baidu.ar.child.b.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a mh;
                public final /* synthetic */ b mi;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mi = this;
                    this.mh = aVar;
                }

                @Override // com.baidu.ar.ihttp.a
                public void a(HttpException httpException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, httpException) == null) {
                        httpException.getMessage();
                    }
                }

                @Override // com.baidu.ar.ihttp.a
                public void a(IHttpResponse iHttpResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iHttpResponse) == null) {
                        try {
                            String content = iHttpResponse.getContent();
                            if (TextUtils.isEmpty(content)) {
                                return;
                            }
                            try {
                                this.mi.a(new JSONObject(content), this.mh);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
