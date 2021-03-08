package com.baidu.live.view.web.a;

import android.util.Log;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class l extends com.baidu.live.view.web.a {
    private AlaLastLiveroomInfo bXz;
    private boolean isHost;

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "openLiveBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void iy(String str) {
        if (!this.isHost) {
            Log.d("JsInterface", "@@ JsInterface-impl OpenLiveBridgeJsInterface params = " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                long optLong = jSONObject.optLong("liveId");
                if (jSONObject.optInt("isForceEnter") == 1) {
                }
                com.baidu.live.liveroom.a.Mu().a(com.baidu.live.liveroom.a.Mu().Mv().hq(String.valueOf(optLong)));
                try {
                    jSONObject.put("recommend_type", 0);
                    jSONObject.put("open_giftlist", 0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String jSONObject2 = jSONObject.toString();
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(TbadkCoreApplication.getInst());
                alaLiveRoomActivityConfig.addExtraByLiveId(optLong, jSONObject2);
                alaLiveRoomActivityConfig.addLastLiveInfoParams(this.bXz);
                alaLiveRoomActivityConfig.setNeedStopImWhenClose(true);
                alaLiveRoomActivityConfig.getIntent().addFlags(268435456);
                com.baidu.live.liveroom.a.Mu().a(alaLiveRoomActivityConfig);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
