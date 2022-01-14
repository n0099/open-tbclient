package com.baidu.android.pushservice.httpapi;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class k extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f32231d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(i iVar, Context context) {
        super(iVar, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32231d = new ArrayList<>();
    }

    @Override // com.baidu.android.pushservice.httpapi.a
    public void a(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, bArr) == null) {
            Intent intent = new Intent();
            intent.setAction(((a) this).f32207b.a.equals("method_list_sdk_tags") ? "com.baidu.android.pushservice.action.sdk.RECEIVE" : "com.baidu.android.pushservice.action.RECEIVE");
            intent.putExtra("method", ((a) this).f32207b.a);
            intent.putExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, i2);
            intent.putExtra("content", bArr);
            if (!this.f32231d.isEmpty()) {
                intent.putStringArrayListExtra("tags_list", this.f32231d);
            }
            intent.setFlags(32);
            a(intent);
            if (TextUtils.isEmpty(((a) this).f32207b.f32221d)) {
                if (!((a) this).f32207b.a.equals("method_list_sdk_tags")) {
                    return;
                }
            } else if (!((a) this).f32207b.a.equals("method_list_sdk_tags")) {
                intent.setPackage(((a) this).f32207b.f32221d);
            }
            com.baidu.android.pushservice.i.m.b(((a) this).a, intent, intent.getAction(), intent.getPackage());
        }
    }

    @Override // com.baidu.android.pushservice.httpapi.a
    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String b2 = super.b(str);
            try {
                JSONArray jSONArray = new JSONObject(b2).getJSONObject("response_params").getJSONArray("groups");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f32231d.add(jSONArray.getJSONObject(i2).getString("name"));
                }
            } catch (JSONException e2) {
                new b.c(((a) this).a).a(Log.getStackTraceString(e2)).a();
            }
            return b2;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.android.pushservice.httpapi.a
    public void b(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
            super.b(hashMap);
            hashMap.put("method", "glist");
        }
    }
}
