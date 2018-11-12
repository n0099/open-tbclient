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
import com.baidu.searchbox.ng.ai.apps.util.AiAppRomUtils;
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
    private static a aiM = null;
    private CustomMessageListener aiN = new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.lm() && j.kX()) {
                a.this.vj();
            }
        }
    };
    private boolean aiO = false;
    private HttpMessageListener aiP = new HttpMessageListener(CmdConfigHttp.CMD_CHECK_BAIDU_SIM) { // from class: com.baidu.tbadk.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003392 && (httpResponsedMessage instanceof CheckBaiduSimResponseMessage)) {
                a.this.aiO = false;
                if (((CheckBaiduSimResponseMessage) httpResponsedMessage).isSuc) {
                    b.getInstance().putString("key_baidu_sim_card_writting_tip", ((CheckBaiduSimResponseMessage) httpResponsedMessage).isBaiduSim ? TbadkCoreApplication.getInst().getResources().getString(e.j.baidu_sim_traffic_free) : "");
                    MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_CHECK_BAIDU_SIM);
                }
            }
        }
    };

    public static a vh() {
        if (aiM == null) {
            aiM = new a();
        }
        return aiM;
    }

    public void vi() {
        MessageManager.getInstance().registerListener(this.aiN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vj() {
        if (TbadkCoreApplication.getInst().isMainProcess(false) && !this.aiO) {
            this.aiO = true;
            if (System.currentTimeMillis() >= b.getInstance().getLong("key_next_check_baidu_sim_time", 0L)) {
                b.getInstance().putLong("key_next_check_baidu_sim_time", System.currentTimeMillis() + 86400000);
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CHECK_BAIDU_SIM, TbConfig.SERVER_ADDRESS + "c/s/holycard");
                tbHttpMessageTask.setResponsedClass(CheckBaiduSimResponseMessage.class);
                MessageManager.getInstance().registerTask(tbHttpMessageTask);
                MessageManager.getInstance().registerListener(this.aiP);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHECK_BAIDU_SIM);
                httpMessage.addParam("localip", UtilHelper.getGprsIpv4Address());
                httpMessage.addParam("network", vk());
                MessageManager.getInstance().sendMessage(httpMessage);
                return;
            }
            this.aiO = false;
        }
    }

    private String vk() {
        switch (j.le()) {
            case 1:
                return "MOBILE";
            case 2:
                return "UNICOM";
            case 3:
                return "TELECOM";
            default:
                return AiAppRomUtils.UNKNOWN;
        }
    }
}
