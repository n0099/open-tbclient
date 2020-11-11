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
    public int aHZ;
    public a aIa;
    public List<b> aIb;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("data")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            this.aHZ = optJSONObject.optInt("room_charm");
            if (optJSONObject.has("charm_data")) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("charm_data");
                this.aIa = new a();
                if (optJSONObject2 != null) {
                    this.aIa.bd_portrait = optJSONObject2.optString("bd_portrait");
                    this.aIa.user_name = optJSONObject2.optString("user_name");
                    this.aIa.user_nickname = optJSONObject2.optString("user_nickname");
                    this.aIa.aIc = optJSONObject2.optInt("current_rank");
                    this.aIa.aId = optJSONObject2.optLong("current_charm_value");
                    this.aIa.aIe = optJSONObject2.optLong("up_charm_value");
                    this.aIa.aIf = optJSONObject2.optLong("down_charm_value");
                }
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.aIb = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    b bVar = new b();
                    bVar.rank = optJSONObject3.optInt("rank");
                    bVar.point = optJSONObject3.optInt(Config.EVENT_HEAT_POINT);
                    bVar.aIi = optJSONObject3.optString("point_text");
                    bVar.user_uk = optJSONObject3.optString("user_uk");
                    bVar.user_name = optJSONObject3.optString("user_name");
                    bVar.user_nickname = optJSONObject3.optString("user_nickname");
                    bVar.follow_status = optJSONObject3.optInt("follow_status");
                    bVar.bd_portrait = optJSONObject3.optString("bd_portrait");
                    bVar.level_id = optJSONObject3.optInt("level_id");
                    bVar.aIj = optJSONObject3.optString("noble_id");
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
                    this.aIb.add(bVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public int aIc;
        public long aId;
        public long aIe;
        public long aIf;
        public boolean aIg;
        public long aIh;
        public String bd_portrait;
        public String user_name;
        public String user_nickname;

        public void bo(boolean z) {
            this.aIg = z;
        }

        public void an(long j) {
            this.aIh = j;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public String aIi;
        public String aIj;
        public String bd_portrait;
        public int follow_status;
        public int level_id;
        public List<AlaLiveMarkData> live_mark_info_new;
        public int point;
        public int rank;
        public String user_name;
        public String user_nickname;
        public String user_uk;

        public boolean Eh() {
            return this.follow_status == 1;
        }
    }
}
