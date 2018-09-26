package com.baidu.tbadk.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.CheckBaiduSimResponseMessage;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class a {
    private static a ada = null;
    private CustomMessageListener adb = new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.lb() && j.kM()) {
                a.this.sO();
            }
        }
    };
    private boolean adc = false;
    private HttpMessageListener ade = new HttpMessageListener(CmdConfigHttp.CMD_CHECK_BAIDU_SIM) { // from class: com.baidu.tbadk.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003392 && (httpResponsedMessage instanceof CheckBaiduSimResponseMessage)) {
                a.this.adc = false;
                if (((CheckBaiduSimResponseMessage) httpResponsedMessage).isSuc) {
                    b.getInstance().putString("key_baidu_sim_card_writting_tip", ((CheckBaiduSimResponseMessage) httpResponsedMessage).isBaiduSim ? TbadkCoreApplication.getInst().getResources().getString(e.j.baidu_sim_traffic_free) : "");
                    MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_CHECK_BAIDU_SIM);
                }
            }
        }
    };

    public static a sM() {
        if (ada == null) {
            ada = new a();
        }
        return ada;
    }

    public void sN() {
        MessageManager.getInstance().registerListener(this.adb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sO() {
        if (TbadkCoreApplication.getInst().isMainProcess(false) && !this.adc) {
            this.adc = true;
            if (System.currentTimeMillis() >= b.getInstance().getLong("key_next_check_baidu_sim_time", 0L)) {
                b.getInstance().putLong("key_next_check_baidu_sim_time", System.currentTimeMillis() + 86400000);
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CHECK_BAIDU_SIM, TbConfig.SERVER_ADDRESS + "c/s/holycard");
                tbHttpMessageTask.setResponsedClass(CheckBaiduSimResponseMessage.class);
                MessageManager.getInstance().registerTask(tbHttpMessageTask);
                MessageManager.getInstance().registerListener(this.ade);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHECK_BAIDU_SIM);
                httpMessage.addParam("localip", UtilHelper.getGprsIpv4Address());
                httpMessage.addParam("network", sP());
                MessageManager.getInstance().sendMessage(httpMessage);
                return;
            }
            this.adc = false;
        }
    }

    private String sP() {
        switch (j.kT()) {
            case 1:
                return "MOBILE";
            case 2:
                return "UNICOM";
            case 3:
                return "TELECOM";
            default:
                return "UNKNOWN";
        }
    }
}
