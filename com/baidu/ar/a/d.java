package com.baidu.ar.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(Context context) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65536, null, context)) != null) {
            return (a) invokeL.objValue;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("ar_ability_classification", 0);
        String string = sharedPreferences.getString("s", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (jSONObject == null) {
                a aVar = new a();
                aVar.bH = sharedPreferences.getString("v", "");
                aVar.bI = jSONObject;
                return aVar;
            }
            return null;
        }
        jSONObject = null;
        if (jSONObject == null) {
        }
    }

    public static void a(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, aVar) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ar_ability_classification", 0).edit();
            edit.putString("v", aVar.bH);
            edit.putString("s", aVar.bI.toString());
            edit.putInt("sv", com.baidu.ar.h.c.getVersionCode());
            edit.apply();
        }
    }
}
