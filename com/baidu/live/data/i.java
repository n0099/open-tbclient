package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i extends BaseData {
    public int aIX;
    public a aIY;
    public List<b> aIZ;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("data")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            this.aIX = optJSONObject.optInt("room_charm");
            if (optJSONObject.has("charm_data")) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("charm_data");
                this.aIY = new a();
                if (optJSONObject2 != null) {
                    this.aIY.bd_portrait = optJSONObject2.optString("bd_portrait");
                    this.aIY.user_name = optJSONObject2.optString("user_name");
                    this.aIY.user_nickname = optJSONObject2.optString("user_nickname");
                    this.aIY.aJa = optJSONObject2.optInt("current_rank");
                    this.aIY.aJb = optJSONObject2.optLong("current_charm_value");
                    this.aIY.aJc = optJSONObject2.optLong("up_charm_value");
                    this.aIY.aJd = optJSONObject2.optLong("down_charm_value");
                }
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.aIZ = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    b bVar = new b();
                    bVar.rank = optJSONObject3.optInt("rank");
                    bVar.aJg = optJSONObject3.optInt(Config.EVENT_HEAT_POINT);
                    bVar.aJh = optJSONObject3.optString("point_text");
                    bVar.user_uk = optJSONObject3.optString("user_uk");
                    bVar.user_name = optJSONObject3.optString("user_name");
                    bVar.user_nickname = optJSONObject3.optString("user_nickname");
                    bVar.follow_status = optJSONObject3.optInt("follow_status");
                    bVar.bd_portrait = optJSONObject3.optString("bd_portrait");
                    bVar.level_id = optJSONObject3.optInt("level_id");
                    bVar.aJi = optJSONObject3.optString("noble_id");
                    if (optJSONObject3.has(SubPbActivityConfig.ICON_LIST)) {
                        if (bVar.live_mark_info_new == null) {
                            bVar.live_mark_info_new = new ArrayList();
                        }
                        JSONArray optJSONArray2 = optJSONObject3.optJSONArray(SubPbActivityConfig.ICON_LIST);
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i2);
                                if (optJSONObject4 != null) {
                                    AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                                    alaLiveMarkData.parserJson(optJSONObject4);
                                    bVar.live_mark_info_new.add(alaLiveMarkData);
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    this.aIZ.add(bVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public int aJa;
        public long aJb;
        public long aJc;
        public long aJd;
        public boolean aJe;
        public long aJf;
        public String bd_portrait;
        public String user_name;
        public String user_nickname;

        public void by(boolean z) {
            this.aJe = z;
        }

        public void aL(long j) {
            this.aJf = j;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public int aJg;
        public String aJh;
        public String aJi;
        public String bd_portrait;
        public int follow_status;
        public int level_id;
        public List<AlaLiveMarkData> live_mark_info_new;
        public int rank;
        public String user_name;
        public String user_nickname;
        public String user_uk;

        public boolean Fj() {
            return this.follow_status == 1;
        }
    }
}
