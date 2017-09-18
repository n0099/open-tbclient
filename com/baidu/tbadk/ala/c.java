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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c {
    private static View.OnClickListener Qv = new View.OnClickListener() { // from class: com.baidu.tbadk.ala.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
                if (!i.hi()) {
                    k.showToast(view.getContext(), d.l.no_network_guide);
                    return;
                }
                a aVar = (a) view.getTag();
                AlaUserInfoData alaUserInfoData = aVar.Qs;
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
                            TiebaStatic.log(new ak("c11850").ad(SapiAccountManager.SESSION_UID, currentAccount));
                            break;
                        case 2:
                        case 3:
                        case 4:
                            TiebaStatic.log(new ak("c11851").ad(SapiAccountManager.SESSION_UID, currentAccount));
                            break;
                        case 5:
                            TiebaStatic.log(new ak("c11852").ad(SapiAccountManager.SESSION_UID, currentAccount));
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

    public static TextView aw(Context context) {
        if (context == null || MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
            return null;
        }
        TextView textView = (TextView) LayoutInflater.from(context).inflate(d.j.ala_tail_view_layout, (ViewGroup) null);
        textView.setOnClickListener(Qv);
        return textView;
    }
}
