package com.baidu.live.view.web.a;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends com.baidu.live.view.web.a {
    private AlaLastLiveroomInfo bpC;
    private boolean isHost;

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "liveBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void fW(String str) {
        if (!this.isHost) {
            Log.d("JsInterface", "@@ JsInterface-impl LiveBridgeJsInterface params = " + str);
            try {
                long parseLong = Long.parseLong(str);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE, 0);
                    jSONObject.put(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL, 0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String jSONObject2 = jSONObject.toString();
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(TbadkCoreApplication.getInst());
                alaLiveRoomActivityConfig.addExtraByLiveId(parseLong, jSONObject2);
                alaLiveRoomActivityConfig.addLastLiveInfoParams(this.bpC);
                alaLiveRoomActivityConfig.setNeedStopImWhenClose(true);
                alaLiveRoomActivityConfig.getIntent().addFlags(268435456);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.bpC = alaLastLiveroomInfo;
    }
}
