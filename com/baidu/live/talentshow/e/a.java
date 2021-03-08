package com.baidu.live.talentshow.e;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes10.dex */
public class a {
    public static void Tq() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_APPLY_CFM).setContentExt("", UbcStatConstant.SubPage.POPUP, null));
    }

    public static void Tr() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "author_liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_SHOW_APPLY_PANEL).setContentExt("", UbcStatConstant.SubPage.POPUP, null));
    }

    public static void Ts() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "linkapply_clk").setContentExt("", UbcStatConstant.SubPage.POPUP, null));
    }

    public static void Tt() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_LINK_CONFIRM_CLICK).setContentExt("", UbcStatConstant.SubPage.POPUP, null));
    }

    public static void Tu() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_LINK_CONFIRM_SHOW).setContentExt("", UbcStatConstant.SubPage.POPUP, null));
    }

    public static void Tv() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_CHAT_CLICK).setContentExt("", UbcStatConstant.SubPage.POPUP, null));
    }

    public static void Tw() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_LINK_CANCEL_SHOW).setContentExt("", UbcStatConstant.SubPage.POPUP, null));
    }

    public static void Tx() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_LINK_CANCEL_CLICK).setContentExt("", UbcStatConstant.SubPage.POPUP, null));
    }
}
