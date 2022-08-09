package com.baidu.platform.core.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends com.baidu.platform.base.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String b = "b";
    public transient /* synthetic */ FieldHolder $fh;
    public String c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2056852920, "Lcom/baidu/platform/core/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2056852920, "Lcom/baidu/platform/core/b/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private LatLng a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            double optDouble = jSONObject.optDouble(SuggestAddrField.KEY_LAT);
            double optDouble2 = jSONObject.optDouble(SuggestAddrField.KEY_LNG);
            return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(new LatLng(optDouble, optDouble2)) : new LatLng(optDouble, optDouble2);
        }
        return (LatLng) invokeL.objValue;
    }

    private boolean a(String str, GeoCodeResult geoCodeResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, geoCodeResult)) == null) {
            if (TextUtils.isEmpty(str) || geoCodeResult == null) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("status");
                if (optInt != 0) {
                    geoCodeResult.error = optInt != 1 ? optInt != 2 ? SearchResult.ERRORNO.RESULT_NOT_FOUND : SearchResult.ERRORNO.SEARCH_OPTION_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    return false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(TiebaStatic.LogFields.RESULT);
                if (optJSONObject == null) {
                    geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return false;
                }
                geoCodeResult.setLocation(a(optJSONObject.optJSONObject("location")));
                geoCodeResult.setAddress(this.c);
                geoCodeResult.setPrecise(optJSONObject.optInt("precise"));
                geoCodeResult.setConfidence(optJSONObject.optInt("confidence"));
                geoCodeResult.setLevel(optJSONObject.optString(PollingModel.LEVEL));
                geoCodeResult.error = SearchResult.ERRORNO.NO_ERROR;
                return true;
            } catch (JSONException e) {
                geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                Log.e(b, "Parse GeoCodeResult catch JSONException", e);
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0073, code lost:
        if (r7.equals("NETWORK_ERROR") != false) goto L33;
     */
    @Override // com.baidu.platform.base.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SearchResult a(String str) {
        InterceptResult invokeL;
        SearchResult.ERRORNO errorno;
        JSONObject jSONObject;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            GeoCodeResult geoCodeResult = new GeoCodeResult();
            if (str != null && !str.equals("")) {
                try {
                    jSONObject = new JSONObject(str);
                    c = 0;
                } catch (JSONException e) {
                    Log.e(b, "JSONException caught", e);
                }
                if (!jSONObject.has("SDK_InnerError")) {
                    if (!a(str, geoCodeResult, false) && !a(str, geoCodeResult)) {
                        geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    }
                    return geoCodeResult;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (optJSONObject.has("PermissionCheckError")) {
                    errorno = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    geoCodeResult.error = errorno;
                    return geoCodeResult;
                } else if (optJSONObject.has("httpStateError")) {
                    String optString = optJSONObject.optString("httpStateError");
                    int hashCode = optString.hashCode();
                    if (hashCode != -879828873) {
                        if (hashCode == 1470557208 && optString.equals("REQUEST_ERROR")) {
                            c = 1;
                        }
                        c = 65535;
                    }
                    geoCodeResult.error = c != 0 ? c != 1 ? SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR : SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.NETWORK_ERROR;
                    return geoCodeResult;
                }
            }
            errorno = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            geoCodeResult.error = errorno;
            return geoCodeResult;
        }
        return (SearchResult) invokeL.objValue;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchResult, obj) == null) && obj != null && (obj instanceof OnGetGeoCoderResultListener)) {
            ((OnGetGeoCoderResultListener) obj).onGetGeoCodeResult((GeoCodeResult) searchResult);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.c = str;
        }
    }
}
