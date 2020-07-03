package com.baidu.live.noble.data;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.data.BaseData;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NobleUserInfo extends BaseData implements Serializable {
    public String detailUrl;
    public a tip;
    public b user;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user");
            if (optJSONObject != null) {
                this.user = new b();
                this.user.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(TableDefine.MessageColumns.COLUME_TIPS);
            if (optJSONObject2 != null) {
                this.tip = new a();
                this.tip.parseJson(optJSONObject2);
            }
            this.detailUrl = jSONObject.optString("detail_url");
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public String id;

        public b() {
        }

        void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.id = jSONObject.optString("id");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public String bay;
        public String baz;
        public String iconUrl;
        public String price;
        public int typeId;

        public a() {
        }

        void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.typeId = jSONObject.optInt("type_id");
                this.iconUrl = jSONObject.optString("icon_url");
                this.price = jSONObject.optString("price");
                this.bay = jSONObject.optString("days");
                this.baz = jSONObject.optString("give_score");
            }
        }
    }
}
