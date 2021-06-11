package com.baidu.afd;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.d.a;
import d.a.d.e;
import d.a.d.f;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AfdSyncResponseMessage extends JsonHttpResponsedMessage {
    public e adModel;

    public AfdSyncResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            try {
                this.adModel = f.b(jSONObject, "1517888290046");
                return;
            } catch (ParseError e2) {
                e2.printStackTrace();
                e a2 = a.a("", "1517888290046");
                this.adModel = a2;
                a2.f43221d = e2;
                return;
            }
        }
        this.adModel = a.a("", "1517888290046");
    }
}
