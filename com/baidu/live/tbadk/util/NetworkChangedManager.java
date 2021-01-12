package com.baidu.live.tbadk.util;

import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.tbadk.core.util.TbImageHelper;
import com.baidu.live.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes10.dex */
public class NetworkChangedManager {
    private CustomMessageListener mNetworkChangedListener;
    private static final byte[] mlock = new byte[1];
    private static NetworkChangedManager mInstance = new NetworkChangedManager();

    public static NetworkChangedManager getInstance() {
        return mInstance;
    }

    private NetworkChangedManager() {
        BdNetTypeUtil.init();
    }

    public void registerNetworkChangedListener() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = getNetworkChangedListener();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener getNetworkChangedListener() {
        return new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.tbadk.util.NetworkChangedManager.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    NetworkChangedManager.this.handleNetworkState();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNetworkState() {
        try {
            boolean isNetWorkAvailable = BdNetTypeUtil.isNetWorkAvailable();
            if (isNetWorkAvailable) {
                if (BdNetTypeUtil.isWifiNet()) {
                    TbImageHelper.getInstance().setNetworkIsWifi(true);
                } else if (BdNetTypeUtil.isMobileNet()) {
                    TbImageHelper.getInstance().setNetworkIsWifi(false);
                }
            }
            NoNetworkView.setIsHasNetwork(isNetWorkAvailable);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
