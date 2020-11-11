package com.baidu.live.tbadk.baidusim;

import com.baidu.android.util.devices.RomUtils;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.util.CheckBaiduSimResponseMessage;
@Deprecated
/* loaded from: classes4.dex */
public class CheckBaiduSimController {
    private static CheckBaiduSimController mInstance = null;
    private CustomMessageListener networkChangedListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.tbadk.baidusim.CheckBaiduSimController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && BdUtilHelper.isNetOk() && BdNetTypeUtil.isMobileNet()) {
                CheckBaiduSimController.this.checkBaiduSimCard();
            }
        }
    };
    private boolean isSendingCheckBaiduSim = false;
    private HttpMessageListener checkBaiduSimListener = new HttpMessageListener(1003392) { // from class: com.baidu.live.tbadk.baidusim.CheckBaiduSimController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003392 && (httpResponsedMessage instanceof CheckBaiduSimResponseMessage)) {
                CheckBaiduSimController.this.isSendingCheckBaiduSim = false;
                if (((CheckBaiduSimResponseMessage) httpResponsedMessage).isSuc) {
                    SharedPrefHelper.getInstance().putString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, ((CheckBaiduSimResponseMessage) httpResponsedMessage).isBaiduSim ? TbadkCoreApplication.getInst().getResources().getString(a.h.sdk_baidu_sim_traffic_free) : "");
                    MessageManager.getInstance().unRegisterTask(1003392);
                }
            }
        }
    };

    public static CheckBaiduSimController getInstance() {
        if (mInstance == null) {
            mInstance = new CheckBaiduSimController();
        }
        return mInstance;
    }

    public void registerNetworkChangedListener() {
        MessageManager.getInstance().registerListener(this.networkChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkBaiduSimCard() {
        if (TbadkCoreApplication.getInst().isMainProcess(false) && !this.isSendingCheckBaiduSim) {
            this.isSendingCheckBaiduSim = true;
            if (System.currentTimeMillis() >= SharedPrefHelper.getInstance().getLong(SharedPrefConfig.KEY_NEXT_CHECK_BAIDU_SIM_TIME, 0L)) {
                SharedPrefHelper.getInstance().putLong(SharedPrefConfig.KEY_NEXT_CHECK_BAIDU_SIM_TIME, System.currentTimeMillis() + 86400000);
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003392, TbConfig.SERVER_ADDRESS + Config.CHECK_BAIDU_SIM);
                tbHttpMessageTask.setResponsedClass(CheckBaiduSimResponseMessage.class);
                MessageManager.getInstance().registerTask(tbHttpMessageTask);
                MessageManager.getInstance().registerListener(this.checkBaiduSimListener);
                HttpMessage httpMessage = new HttpMessage(1003392);
                httpMessage.addParam("localip", UtilHelper.getGprsIpv4Address());
                httpMessage.addParam("network", getNetOperatorType());
                MessageManager.getInstance().sendMessage(httpMessage);
                return;
            }
            this.isSendingCheckBaiduSim = false;
        }
    }

    private String getNetOperatorType() {
        switch (BdNetTypeUtil.curOperatorType()) {
            case 1:
                return "MOBILE";
            case 2:
                return "UNICOM";
            case 3:
                return "TELECOM";
            default:
                return RomUtils.UNKNOWN;
        }
    }
}
