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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c {
    private static View.OnClickListener bsR = new View.OnClickListener() { // from class: com.baidu.tbadk.ala.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
                if (!j.kY()) {
                    l.showToast(view.getContext(), d.j.no_network_guide);
                    return;
                }
                a aVar = (a) view.getTag();
                AlaUserInfoData alaUserInfoData = aVar.bsN;
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
                            TiebaStatic.log(new am("c11850").bJ("uid", currentAccount));
                            break;
                        case 2:
                        case 3:
                        case 4:
                            TiebaStatic.log(new am("c11851").bJ("uid", currentAccount));
                            break;
                        case 5:
                            TiebaStatic.log(new am("c11852").bJ("uid", currentAccount));
                            break;
                        case 7:
                            if (alaUserInfoData.ala_id != 0) {
                                TiebaStatic.log(new am("c11855").bJ("uid", currentAccount).k("click_uid", alaUserInfoData.ala_id).T("live_status", alaUserInfoData.live_status));
                            }
                            TiebaStatic.log(new am("c12542"));
                            if (aVar.bsO && !StringUtils.isNull(alaUserInfoData.sex)) {
                                BdToast.c(view.getContext(), String.format(view.getContext().getString(d.j.person_privacy_toast), alaUserInfoData.sex), d.f.icon_toast_game_error).abe();
                                return;
                            }
                            break;
                    }
                    String str = AlaLiveRoomActivityConfig.FROM_TYPE_TAIL_LIGHT;
                    if (aVar.type == 5) {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION;
                    } else if (aVar.type == 7) {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2911003, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, str, null, false, "")));
                }
            }
        }
    };

    public static TextView cE(Context context) {
        if (context == null || MessageManager.getInstance().findTask(2911003) == null) {
            return null;
        }
        TextView textView = (TextView) LayoutInflater.from(context).inflate(d.h.ala_tail_view_layout, (ViewGroup) null);
        textView.setOnClickListener(bsR);
        return textView;
    }
}
