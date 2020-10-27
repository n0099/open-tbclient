package com.baidu.tbadk.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.CheckBaiduSimResponseMessage;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a {
    private static a eoF = null;
    private CustomMessageListener eoG = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tbadk.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.isNetOk() && j.isMobileNet()) {
                a.this.checkBaiduSimCard();
            }
        }
    };
    private boolean isSendingCheckBaiduSim = false;
    private HttpMessageListener eoH = new HttpMessageListener(1003392) { // from class: com.baidu.tbadk.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003392 && (httpResponsedMessage instanceof CheckBaiduSimResponseMessage)) {
                a.this.isSendingCheckBaiduSim = false;
                if (((CheckBaiduSimResponseMessage) httpResponsedMessage).isSuc) {
                    b.bnH().putString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, ((CheckBaiduSimResponseMessage) httpResponsedMessage).isBaiduSim ? TbadkCoreApplication.getInst().getResources().getString(R.string.baidu_sim_traffic_free) : "");
                    MessageManager.getInstance().unRegisterTask(1003392);
                }
            }
        }
    };

    public static a bfT() {
        if (eoF == null) {
            eoF = new a();
        }
        return eoF;
    }

    public void registerNetworkChangedListener() {
        MessageManager.getInstance().registerListener(this.eoG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkBaiduSimCard() {
        if (TbadkCoreApplication.getInst().isMainProcess(false) && !this.isSendingCheckBaiduSim) {
            this.isSendingCheckBaiduSim = true;
            if (System.currentTimeMillis() >= b.bnH().getLong(SharedPrefConfig.KEY_NEXT_CHECK_BAIDU_SIM_TIME, 0L)) {
                b.bnH().putLong(SharedPrefConfig.KEY_NEXT_CHECK_BAIDU_SIM_TIME, System.currentTimeMillis() + 86400000);
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003392, TbConfig.SERVER_ADDRESS + Config.CHECK_BAIDU_SIM);
                tbHttpMessageTask.setResponsedClass(CheckBaiduSimResponseMessage.class);
                MessageManager.getInstance().registerTask(tbHttpMessageTask);
                MessageManager.getInstance().registerListener(this.eoH);
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
        switch (j.curOperatorType()) {
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
