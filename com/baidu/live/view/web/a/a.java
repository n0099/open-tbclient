package com.baidu.live.view.web.a;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends com.baidu.live.view.web.a {
    private AlaLastLiveroomInfo bSf;
    private boolean isHost;

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "audioLiveBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void hU(String str) {
        if (!this.isHost) {
            Log.d("JsInterface", "@@ JsInterface-impl AudioLiveBridgeJsInterface params = " + str);
            try {
                long parseLong = Long.parseLong(str);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("recommend_type", 0);
                    jSONObject.put("open_giftlist", 0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String jSONObject2 = jSONObject.toString();
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(TbadkCoreApplication.getInst());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(parseLong, jSONObject2);
                yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(this.bSf);
                yuyinAlaLiveRoomActivityConfig.setNeedStopImWhenClose(true);
                yuyinAlaLiveRoomActivityConfig.getIntent().addFlags(268435456);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501080, yuyinAlaLiveRoomActivityConfig));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.bSf = alaLastLiveroomInfo;
    }
}
