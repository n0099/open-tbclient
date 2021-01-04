package com.baidu.live.talentshow.e;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes11.dex */
public class a {
    public static void Vz() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_APPLY_CFM).setContentExt("", "popup", null));
    }

    public static void VA() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "author_liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_SHOW_APPLY_PANEL).setContentExt("", "popup", null));
    }

    public static void VB() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "linkapply_clk").setContentExt("", "popup", null));
    }

    public static void VC() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_LINK_CONFIRM_CLICK).setContentExt("", "popup", null));
    }

    public static void VD() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_LINK_CONFIRM_SHOW).setContentExt("", "popup", null));
    }

    public static void VE() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_CHAT_CLICK).setContentExt("", "popup", null));
    }

    public static void VF() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_LINK_CANCEL_SHOW).setContentExt("", "popup", null));
    }

    public static void VG() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_LINK_CANCEL_CLICK).setContentExt("", "popup", null));
    }
}
