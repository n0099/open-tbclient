package com.baidu.live.refresh;

import android.os.Bundle;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.live.tbadk.core.BaseFragment;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class AlaAutoRefreshFragment extends BaseFragment {
    private NetMessageListener ate = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.live.refresh.AlaAutoRefreshFragment.1
        @Override // com.baidu.live.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == AlaAutoRefreshFragment.this.getUniqueId()) {
                List<Long> list = null;
                if (responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                    list = ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds();
                }
                if (list != null && !list.isEmpty()) {
                    AlaAutoRefreshFragment.this.processCloseLives(list);
                }
            }
        }
    };

    protected abstract void processCloseLives(List<Long> list);

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.ate);
    }
}
