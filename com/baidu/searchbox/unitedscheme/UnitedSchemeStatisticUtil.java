package com.baidu.searchbox.unitedscheme;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UnitedSchemeStatisticUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String UBC_KEY_SCHEME_INVALID = "326";
    public static final String UBC_KEY_SCHEME_INVOKE = "327";
    public static final String UBC_KEY_SCHEME_UPDATE = "328";
    public transient /* synthetic */ FieldHolder $fh;

    public UnitedSchemeStatisticUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void doUBCForInvalidScheme(Uri uri, String str) {
        String uri2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, uri, str) == null) {
            JSONObject jSONObject = new JSONObject();
            if (uri == null) {
                uri2 = StringUtil.NULL_STRING;
            } else {
                try {
                    uri2 = uri.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jSONObject.put("scheme", uri2);
            if (TextUtils.isEmpty(str)) {
                str = StringUtil.NULL_STRING;
            }
            jSONObject.put("msg", str);
            SchemeRuntime.getSchemeIoc().doStatistic(UBC_KEY_SCHEME_INVALID, jSONObject.toString());
        }
    }

    public static void doUBCForSchemeInvoke(String str, Uri uri) {
        String uri2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, uri) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", str);
                if (uri == null) {
                    uri2 = StringUtil.NULL_STRING;
                } else {
                    uri2 = uri.toString();
                }
                jSONObject.put("scheme", uri2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            SchemeRuntime.getSchemeIoc().doStatistic(UBC_KEY_SCHEME_INVOKE, jSONObject.toString());
        }
    }

    public static void doUBCForUpdateDialog(Uri uri) {
        String uri2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, uri) == null) {
            JSONObject jSONObject = new JSONObject();
            if (uri == null) {
                uri2 = StringUtil.NULL_STRING;
            } else {
                try {
                    uri2 = uri.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jSONObject.put("scheme", uri2);
            SchemeRuntime.getSchemeIoc().doStatistic(UBC_KEY_SCHEME_UPDATE, jSONObject.toString());
        }
    }
}
