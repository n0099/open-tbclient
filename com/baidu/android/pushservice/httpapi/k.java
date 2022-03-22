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
/* loaded from: classes3.dex */
public class k extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f24710d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(i iVar, Context context) {
        super(iVar, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24710d = new ArrayList<>();
    }

    @Override // com.baidu.android.pushservice.httpapi.a
    public void a(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, bArr) == null) {
            Intent intent = new Intent();
            intent.setAction(((a) this).f24688b.a.equals("method_list_sdk_tags") ? "com.baidu.android.pushservice.action.sdk.RECEIVE" : "com.baidu.android.pushservice.action.RECEIVE");
            intent.putExtra("method", ((a) this).f24688b.a);
            intent.putExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, i);
            intent.putExtra("content", bArr);
            if (!this.f24710d.isEmpty()) {
                intent.putStringArrayListExtra("tags_list", this.f24710d);
            }
            intent.setFlags(32);
            a(intent);
            if (TextUtils.isEmpty(((a) this).f24688b.f24702d)) {
                if (!((a) this).f24688b.a.equals("method_list_sdk_tags")) {
                    return;
                }
            } else if (!((a) this).f24688b.a.equals("method_list_sdk_tags")) {
                intent.setPackage(((a) this).f24688b.f24702d);
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
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.f24710d.add(jSONArray.getJSONObject(i).getString("name"));
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
