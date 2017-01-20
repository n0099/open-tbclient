package com.baidu.tbadk.ala;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        AlaUserInfoData alaUserInfoData;
        if (view != null && view.getTag() != null && (view.getTag() instanceof b) && (alaUserInfoData = (bVar = (b) view.getTag()).Lv) != null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            if (alaUserInfoData.anchor_live != 0) {
                alaLiveInfoCoreData.setLiveID(alaUserInfoData.anchor_live);
            } else if (alaUserInfoData.enter_live != 0) {
                alaLiveInfoCoreData.setLiveID(alaUserInfoData.enter_live);
            } else {
                return;
            }
            int i = bVar.type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            switch (i) {
                case 1:
                    TiebaStatic.log(new ar("c11850").ab(SapiAccountManager.SESSION_UID, currentAccount));
                    break;
                case 2:
                case 3:
                case 4:
                    TiebaStatic.log(new ar("c11851").ab(SapiAccountManager.SESSION_UID, currentAccount));
                    break;
                case 5:
                    TiebaStatic.log(new ar("c11852").ab(SapiAccountManager.SESSION_UID, currentAccount));
                    break;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_TAIL_LIGHT, (String) null, false)));
        }
    }
}
