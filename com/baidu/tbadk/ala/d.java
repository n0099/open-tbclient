package com.baidu.tbadk.ala;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            if (!i.hj()) {
                k.showToast(view.getContext(), w.l.no_network_guide);
                return;
            }
            a aVar = (a) view.getTag();
            AlaUserInfoData alaUserInfoData = aVar.PQ;
            if (alaUserInfoData != null) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                if (alaUserInfoData.anchor_live != 0) {
                    alaLiveInfoCoreData.setLiveID(alaUserInfoData.anchor_live);
                } else if (alaUserInfoData.enter_live != 0) {
                    alaLiveInfoCoreData.setLiveID(alaUserInfoData.enter_live);
                } else {
                    return;
                }
                int i = aVar.type;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                switch (i) {
                    case 1:
                        TiebaStatic.log(new au("c11850").Z(SapiAccountManager.SESSION_UID, currentAccount));
                        break;
                    case 2:
                    case 3:
                    case 4:
                        TiebaStatic.log(new au("c11851").Z(SapiAccountManager.SESSION_UID, currentAccount));
                        break;
                    case 5:
                        TiebaStatic.log(new au("c11852").Z(SapiAccountManager.SESSION_UID, currentAccount));
                        break;
                }
                String str = AlaLiveRoomActivityConfig.FROM_TYPE_TAIL_LIGHT;
                if (aVar.type == 5) {
                    str = AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, str, (String) null, false, "")));
            }
        }
    }
}
