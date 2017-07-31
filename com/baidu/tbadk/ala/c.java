package com.baidu.tbadk.ala;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c {
    private static View.OnClickListener Rr = new View.OnClickListener() { // from class: com.baidu.tbadk.ala.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
                if (!i.hr()) {
                    k.showToast(view.getContext(), d.l.no_network_guide);
                    return;
                }
                a aVar = (a) view.getTag();
                AlaUserInfoData alaUserInfoData = aVar.Ro;
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
                            TiebaStatic.log(new aj("c11850").aa(SapiAccountManager.SESSION_UID, currentAccount));
                            break;
                        case 2:
                        case 3:
                        case 4:
                            TiebaStatic.log(new aj("c11851").aa(SapiAccountManager.SESSION_UID, currentAccount));
                            break;
                        case 5:
                            TiebaStatic.log(new aj("c11852").aa(SapiAccountManager.SESSION_UID, currentAccount));
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
    };

    public static TextView aq(Context context) {
        if (context == null || MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
            return null;
        }
        TextView textView = (TextView) LayoutInflater.from(context).inflate(d.j.ala_tail_view_layout, (ViewGroup) null);
        textView.setOnClickListener(Rr);
        return textView;
    }
}
