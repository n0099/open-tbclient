package com.baidu.live.liveroom;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.player.ubc.PlayerSpeedTracker;
/* loaded from: classes10.dex */
public class a {
    private a() {
    }

    /* renamed from: com.baidu.live.liveroom.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0190a {
        private static a bsQ = new a();
    }

    public static a Mu() {
        return C0190a.bsQ;
    }

    public b Mv() {
        return new b();
    }

    public void a(b bVar) {
        if (TextUtils.isEmpty(bVar.getKey())) {
            bVar.hq(String.valueOf(System.currentTimeMillis()));
        }
        if (!TbadkCoreApplication.getInst().isTieba() && !PlayerSpeedTracker.hasCreateFlow(bVar.getKey())) {
            PlayerSpeedTracker.beginTrack(bVar.getKey());
        }
    }

    public void a(AlaLiveRoomActivityConfig alaLiveRoomActivityConfig) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
    }
}
