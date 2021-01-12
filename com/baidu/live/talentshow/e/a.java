package com.baidu.live.talentshow.e;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes10.dex */
public class a {
    public static void RG() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_APPLY_CFM).setContentExt("", UbcStatConstant.SubPage.POPUP, null));
    }

    public static void RH() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "author_liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_SHOW_APPLY_PANEL).setContentExt("", UbcStatConstant.SubPage.POPUP, null));
    }

    public static void RI() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "linkapply_clk").setContentExt("", UbcStatConstant.SubPage.POPUP, null));
    }

    public static void RJ() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_LINK_CONFIRM_CLICK).setContentExt("", UbcStatConstant.SubPage.POPUP, null));
    }

    public static void RK() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_LINK_CONFIRM_SHOW).setContentExt("", UbcStatConstant.SubPage.POPUP, null));
    }

    public static void RL() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_CHAT_CLICK).setContentExt("", UbcStatConstant.SubPage.POPUP, null));
    }

    public static void RM() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_LINK_CANCEL_SHOW).setContentExt("", UbcStatConstant.SubPage.POPUP, null));
    }

    public static void RN() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_LINK_CANCEL_CLICK).setContentExt("", UbcStatConstant.SubPage.POPUP, null));
    }
}
