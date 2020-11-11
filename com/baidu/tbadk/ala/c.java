package com.baidu.tbadk.ala;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private static View.OnClickListener eui = new View.OnClickListener() { // from class: com.baidu.tbadk.ala.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
                if (!j.isNetWorkAvailable()) {
                    l.showToast(view.getContext(), R.string.no_network_guide);
                    return;
                }
                a aVar = (a) view.getTag();
                AlaUserInfoData alaUserInfoData = aVar.eue;
                if (alaUserInfoData != null) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    if (alaUserInfoData.anchor_live != 0) {
                        alaLiveInfoCoreData.liveID = alaUserInfoData.anchor_live;
                    } else if (alaUserInfoData.enter_live != 0) {
                        alaLiveInfoCoreData.liveID = alaUserInfoData.enter_live;
                    } else if (alaUserInfoData.live_id != 0) {
                        alaLiveInfoCoreData.liveID = alaUserInfoData.live_id;
                    } else {
                        return;
                    }
                    int i = aVar.type;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    switch (i) {
                        case 1:
                            TiebaStatic.log(new aq("c11850").dR("uid", currentAccount));
                            break;
                        case 2:
                        case 3:
                        case 4:
                            TiebaStatic.log(new aq("c11851").dR("uid", currentAccount));
                            break;
                        case 5:
                            TiebaStatic.log(new aq("c11852").dR("uid", currentAccount));
                            break;
                        case 7:
                            if (alaUserInfoData.ala_id != 0) {
                                TiebaStatic.log(new aq("c11855").dR("uid", currentAccount).w("click_uid", alaUserInfoData.ala_id).al("live_status", alaUserInfoData.live_status));
                            }
                            TiebaStatic.log(new aq("c12542"));
                            if (aVar.euf && !StringUtils.isNull(alaUserInfoData.sex)) {
                                BdToast.a(view.getContext(), (CharSequence) String.format(view.getContext().getString(R.string.person_privacy_toast), alaUserInfoData.sex), R.drawable.icon_pure_toast_mistake40_svg, true).bpi();
                                return;
                            }
                            break;
                    }
                    String str = "tail_light_play";
                    if (aVar.type == 5) {
                        str = "person_attention";
                    } else if (aVar.type == 7) {
                        str = "person_play";
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, str, null, false, "")));
                }
            }
        }
    };

    public static TextView dT(Context context) {
        if (context == null || MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
            return null;
        }
        TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.ala_tail_view_layout, (ViewGroup) null);
        textView.setOnClickListener(eui);
        return textView;
    }
}
