package com.baidu.live.z;

import com.baidu.live.tbadk.ubc.IUbcManager;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.ubc.Flow;
import com.baidu.ubc.aa;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements IUbcManager {
    @Override // com.baidu.live.tbadk.ubc.IUbcManager
    public void onEvent(String str, JSONObject jSONObject) {
        ((aa) c.a(aa.SERVICE_REFERENCE)).onEvent(str, jSONObject);
    }

    @Override // com.baidu.live.tbadk.ubc.IUbcManager
    public Object flowBegin(String str, JSONObject jSONObject) {
        return ((aa) c.a(aa.SERVICE_REFERENCE)).beginFlow(str, jSONObject);
    }

    @Override // com.baidu.live.tbadk.ubc.IUbcManager
    public void flowSetValueWithDuration(Object obj, JSONObject jSONObject) {
        aa aaVar = (aa) c.a(aa.SERVICE_REFERENCE);
        if (jSONObject != null) {
            aaVar.flowSetValueWithDuration((Flow) obj, jSONObject.toString());
        } else {
            aaVar.flowSetValueWithDuration((Flow) obj, null);
        }
    }

    @Override // com.baidu.live.tbadk.ubc.IUbcManager
    public void flowStartSlot(Object obj, String str, JSONObject jSONObject) {
        ((aa) c.a(aa.SERVICE_REFERENCE)).a((Flow) obj, str, jSONObject);
    }

    @Override // com.baidu.live.tbadk.ubc.IUbcManager
    public void flowEndSlot(Object obj, String str) {
        ((aa) c.a(aa.SERVICE_REFERENCE)).flowEndSlot((Flow) obj, str);
    }

    @Override // com.baidu.live.tbadk.ubc.IUbcManager
    public void flowEnd(Object obj) {
        ((aa) c.a(aa.SERVICE_REFERENCE)).flowEnd((Flow) obj);
    }
}
