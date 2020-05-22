package com.baidu.afd;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AfdSyncResponseMessage extends JsonHttpResponsedMessage {
    e adModel;

    public AfdSyncResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            try {
                this.adModel = f.j(jSONObject, "1517888290046");
                return;
            } catch (ParseError e) {
                e.printStackTrace();
                this.adModel = a.L("", "1517888290046");
                this.adModel.Xf = e;
                return;
            }
        }
        this.adModel = a.L("", "1517888290046");
    }
}
