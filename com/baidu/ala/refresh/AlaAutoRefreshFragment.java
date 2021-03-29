package com.baidu.ala.refresh;

import android.os.Bundle;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusRequestMessage;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusSocketResponseMessage;
import com.baidu.tbadk.core.BaseFragment;
import d.b.b.c.g.a;
import java.util.List;
/* loaded from: classes.dex */
public abstract class AlaAutoRefreshFragment extends BaseFragment {
    public static final int GET_CLOSE_ONSCROLL_STOP_DELAY_MILLIS = 2000;
    public a mLiveStatusMsgListener = new a(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.ala.refresh.AlaAutoRefreshFragment.1
        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == AlaAutoRefreshFragment.this.getUniqueId()) {
                List<Long> list = null;
                if (responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                    list = ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds();
                } else if (responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage) {
                    list = ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds();
                }
                if (list == null || list.isEmpty()) {
                    return;
                }
                AlaAutoRefreshFragment.this.processCloseLives(list);
            }
        }
    };
    public ISquareRefreshHandler mSquareRefreshHandler;

    public abstract List<Long> getCurrentLiveIds();

    public void markHasReaded() {
        ISquareRefreshHandler iSquareRefreshHandler = this.mSquareRefreshHandler;
        if (iSquareRefreshHandler != null) {
            iSquareRefreshHandler.markHasReaded();
        }
    }

    public void markLoadedData(int i) {
        ISquareRefreshHandler iSquareRefreshHandler = this.mSquareRefreshHandler;
        if (iSquareRefreshHandler != null) {
            iSquareRefreshHandler.markDataLoaded(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mLiveStatusMsgListener);
    }

    public abstract void processCloseLives(List<Long> list);

    public void refreshCurrentPage() {
        List<Long> currentLiveIds = getCurrentLiveIds();
        if (currentLiveIds == null || currentLiveIds.isEmpty()) {
            return;
        }
        AlaMGetLiveStatusRequestMessage alaMGetLiveStatusRequestMessage = new AlaMGetLiveStatusRequestMessage();
        alaMGetLiveStatusRequestMessage.setTag(getUniqueId());
        alaMGetLiveStatusRequestMessage.setListIds(currentLiveIds);
        sendMessage(alaMGetLiveStatusRequestMessage);
    }

    public void setSquareRefreshHandler(ISquareRefreshHandler iSquareRefreshHandler) {
        this.mSquareRefreshHandler = iSquareRefreshHandler;
    }
}
