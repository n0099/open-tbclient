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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.CheckBaiduSimResponseMessage;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a {
    private static a bBt = null;
    private CustomMessageListener bBu = new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.kt() && j.ke()) {
                a.this.aay();
            }
        }
    };
    private boolean bBv = false;
    private HttpMessageListener bBw = new HttpMessageListener(CmdConfigHttp.CMD_CHECK_BAIDU_SIM) { // from class: com.baidu.tbadk.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003392 && (httpResponsedMessage instanceof CheckBaiduSimResponseMessage)) {
                a.this.bBv = false;
                if (((CheckBaiduSimResponseMessage) httpResponsedMessage).isSuc) {
                    b.ahQ().putString("key_baidu_sim_card_writting_tip", ((CheckBaiduSimResponseMessage) httpResponsedMessage).isBaiduSim ? TbadkCoreApplication.getInst().getResources().getString(R.string.baidu_sim_traffic_free) : "");
                    MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_CHECK_BAIDU_SIM);
                }
            }
        }
    };

    public static a aaw() {
        if (bBt == null) {
            bBt = new a();
        }
        return bBt;
    }

    public void aax() {
        MessageManager.getInstance().registerListener(this.bBu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aay() {
        if (TbadkCoreApplication.getInst().isMainProcess(false) && !this.bBv) {
            this.bBv = true;
            if (System.currentTimeMillis() >= b.ahQ().getLong("key_next_check_baidu_sim_time", 0L)) {
                b.ahQ().putLong("key_next_check_baidu_sim_time", System.currentTimeMillis() + 86400000);
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CHECK_BAIDU_SIM, TbConfig.SERVER_ADDRESS + "c/s/holycard");
                tbHttpMessageTask.setResponsedClass(CheckBaiduSimResponseMessage.class);
                MessageManager.getInstance().registerTask(tbHttpMessageTask);
                MessageManager.getInstance().registerListener(this.bBw);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHECK_BAIDU_SIM);
                httpMessage.addParam("localip", UtilHelper.getGprsIpv4Address());
                httpMessage.addParam("network", aaz());
                MessageManager.getInstance().sendMessage(httpMessage);
                return;
            }
            this.bBv = false;
        }
    }

    private String aaz() {
        switch (j.kk()) {
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
