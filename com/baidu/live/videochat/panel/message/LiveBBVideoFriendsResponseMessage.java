package com.baidu.live.videochat.panel.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.panel.a.a;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class LiveBBVideoFriendsResponseMessage extends JsonHttpResponsedMessage {
    private List<a> bSq;
    private boolean hasMore;
    private int pn;

    public LiveBBVideoFriendsResponseMessage() {
        super(1021216);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.pn = optJSONObject.optInt(Config.PACKAGE_NAME);
            this.hasMore = optJSONObject.optInt("has_more") == 1;
            this.bSq = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject2 != null) {
                        a aVar = new a();
                        aVar.parserJson(optJSONObject2);
                        this.bSq.add(aVar);
                    }
                }
            }
        }
    }

    public int getPn() {
        return this.pn;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public List<a> Zm() {
        return this.bSq;
    }
}
