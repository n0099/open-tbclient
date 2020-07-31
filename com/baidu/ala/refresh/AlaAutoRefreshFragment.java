package com.baidu.ala.refresh;

import android.os.Bundle;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusRequestMessage;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusSocketResponseMessage;
import com.baidu.tbadk.core.BaseFragment;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class AlaAutoRefreshFragment extends BaseFragment {
    protected static final int GET_CLOSE_ONSCROLL_STOP_DELAY_MILLIS = 2000;
    private a mLiveStatusMsgListener = new a(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.ala.refresh.AlaAutoRefreshFragment.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == AlaAutoRefreshFragment.this.getUniqueId()) {
                List<Long> list = null;
                if (responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                    list = ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds();
                } else if (responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage) {
                    list = ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds();
                }
                if (list != null && !list.isEmpty()) {
                    AlaAutoRefreshFragment.this.processCloseLives(list);
                }
            }
        }
    };
    private ISquareRefreshHandler mSquareRefreshHandler;

    protected abstract List<Long> getCurrentLiveIds();

    protected abstract void processCloseLives(List<Long> list);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mLiveStatusMsgListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void refreshCurrentPage() {
        List<Long> currentLiveIds = getCurrentLiveIds();
        if (currentLiveIds != null && !currentLiveIds.isEmpty()) {
            AlaMGetLiveStatusRequestMessage alaMGetLiveStatusRequestMessage = new AlaMGetLiveStatusRequestMessage();
            alaMGetLiveStatusRequestMessage.setTag(getUniqueId());
            alaMGetLiveStatusRequestMessage.setListIds(currentLiveIds);
            sendMessage(alaMGetLiveStatusRequestMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void markHasReaded() {
        if (this.mSquareRefreshHandler != null) {
            this.mSquareRefreshHandler.markHasReaded();
        }
    }

    protected void markLoadedData(int i) {
        if (this.mSquareRefreshHandler != null) {
            this.mSquareRefreshHandler.markDataLoaded(i);
        }
    }

    public void setSquareRefreshHandler(ISquareRefreshHandler iSquareRefreshHandler) {
        this.mSquareRefreshHandler = iSquareRefreshHandler;
    }
}
