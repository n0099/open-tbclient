package com.baidu.tbadk.cdnOptimize;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h {
    private static Object lock = new Object();
    private static long mobileLastTachometerTime = 0;
    private BdUniqueId unique_id = BdUniqueId.gen();
    private final int BK = 10001;
    private final int BL = 10002;
    private HttpMessageListener BM = new i(this, CmdConfigHttp.MOBILE_CDN_IPLIST_CMD);
    private final Handler handler = new j(this, Looper.getMainLooper());

    public h() {
        this.handler.sendEmptyMessage(10001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lu() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MOBILE_CDN_IPLIST_CMD, "http://httpdns.baidu.com/ips/v1");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(TbMobileCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.BM);
        MessageManager.getInstance().registerListener(this.BM);
    }

    public void lv() {
        long currentTimeMillis;
        if (!com.baidu.adp.lib.util.i.fg() && TbadkCoreApplication.m255getInst().isMainProcess(true)) {
            synchronized (lock) {
                try {
                    if (0 == mobileLastTachometerTime) {
                        mobileLastTachometerTime = com.baidu.tbadk.core.sharedPref.b.oc().getLong("com.baidu.tbadk.opTimize.mobileLastGetCdnListTiem", 0L);
                    }
                    currentTimeMillis = System.currentTimeMillis();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                if (0 == mobileLastTachometerTime || currentTimeMillis - mobileLastTachometerTime >= 300000) {
                    mobileLastTachometerTime = currentTimeMillis;
                    com.baidu.tbadk.core.sharedPref.b.oc().putLong("com.baidu.tbadk.opTimize.mobileLastGetCdnListTiem", currentTimeMillis);
                    this.handler.sendEmptyMessage(10002);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MOBILE_CDN_IPLIST_CMD);
        httpMessage.addParam("domain", "hiphotos.jomodns.com");
        httpMessage.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ArrayList<String> arrayList) {
        if (arrayList != null) {
            Intent intent = new Intent();
            intent.setAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            intent.putExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_KEY, arrayList);
            intent.putExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_ISMOBILE, true);
            TbadkCoreApplication.m255getInst().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar) {
        if (pVar != null) {
            m(pVar.mobileIpList);
            k kVar = new k(this, pVar);
            kVar.setPriority(4);
            kVar.execute(new Object[0]);
        }
    }
}
