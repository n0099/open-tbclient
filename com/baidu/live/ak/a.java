package com.baidu.live.ak;

import com.baidu.live.tbadk.ubc.IUbcManager;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.ubc.Flow;
import com.baidu.ubc.ab;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements IUbcManager {
    @Override // com.baidu.live.tbadk.ubc.IUbcManager
    public void onEvent(String str, JSONObject jSONObject) {
        ((ab) c.a(ab.SERVICE_REFERENCE)).onEvent(str, jSONObject);
    }

    @Override // com.baidu.live.tbadk.ubc.IUbcManager
    public Object flowBegin(String str, JSONObject jSONObject) {
        return ((ab) c.a(ab.SERVICE_REFERENCE)).beginFlow(str, jSONObject);
    }

    @Override // com.baidu.live.tbadk.ubc.IUbcManager
    public void flowSetValueWithDuration(Object obj, JSONObject jSONObject) {
        ab abVar = (ab) c.a(ab.SERVICE_REFERENCE);
        if (jSONObject != null) {
            abVar.flowSetValueWithDuration((Flow) obj, jSONObject.toString());
        } else {
            abVar.flowSetValueWithDuration((Flow) obj, null);
        }
    }

    @Override // com.baidu.live.tbadk.ubc.IUbcManager
    public void flowStartSlot(Object obj, String str, JSONObject jSONObject) {
        ((ab) c.a(ab.SERVICE_REFERENCE)).a((Flow) obj, str, jSONObject);
    }

    @Override // com.baidu.live.tbadk.ubc.IUbcManager
    public void flowEndSlot(Object obj, String str) {
        ((ab) c.a(ab.SERVICE_REFERENCE)).flowEndSlot((Flow) obj, str);
    }

    @Override // com.baidu.live.tbadk.ubc.IUbcManager
    public void flowEnd(Object obj) {
        ((ab) c.a(ab.SERVICE_REFERENCE)).flowEnd((Flow) obj);
    }
}
