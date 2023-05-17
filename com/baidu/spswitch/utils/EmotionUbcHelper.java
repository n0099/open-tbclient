package com.baidu.spswitch.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class EmotionUbcHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MEME_ID = "meme_id";
    public static final String TAB_ID = "tab_id";
    public static final String TYPE_MEME_CLK = "meme_clk";
    public static final String TYPE_MEME_PRESS = "meme_press";
    public static final String TYPE_TAB_CLK = "tab_clk";
    public static final String UBC_ID_558 = "558";
    public transient /* synthetic */ FieldHolder $fh;

    public EmotionUbcHelper() {
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

    public static String getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            BoxAccountManager boxAccountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
            if (boxAccountManager != null && boxAccountManager.isLogin(0)) {
                return "1";
            }
            return "0";
        }
        return (String) invokeV.objValue;
    }

    public static void doEmotionDynamicUBC(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("from", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("type", str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("page", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject.put("source", str4);
                }
                jSONObject.put("value", getValue());
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("tab_id", str5);
                }
                if (!TextUtils.isEmpty(str6)) {
                    jSONObject2.put(MEME_ID, str6);
                }
                jSONObject.putOpt("ext", jSONObject2);
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.onEvent(UBC_ID_558, jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
