package com.baidu.tbadk.cdnOptimize;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.z;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.httpNet.ImgHttpClient;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class m<T> extends com.baidu.adp.base.f<T> {
    public static final String BU = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/checkcdn";
    private o BT;
    private HttpMessageListener BV;

    public m(TbPageContext<T> tbPageContext) {
        super(tbPageContext);
        this.BT = null;
        this.BV = new n(this, CmdConfigHttp.CDN_IPLIST_CMD);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CDN_IPLIST_CMD, BU);
        tbHttpMessageTask.setResponsedClass(TbCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.BV);
        MessageManager.getInstance().registerListener(this.BV);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CDN_IPLIST_CMD);
        MessageManager.getInstance().unRegisterListener(this.BV);
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void a(o oVar) {
        this.BT = oVar;
    }

    public void lE() {
        sendMessage(new HttpMessage(CmdConfigHttp.CDN_IPLIST_CMD));
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        boolean z2;
        if (str == null || str2 == null || str3 == null || str4 == null || !com.baidu.tbadk.util.e.eF(str)) {
            return false;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
            ImgHttpClient imgHttpClient = new ImgHttpClient(eVar);
            eVar.dP().setUrl(str);
            imgHttpClient.c(str2, str3, 1);
            byte[] bArr = eVar.dQ().kH;
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            boolean dV = eVar.dQ().dV();
            int i = 0;
            String str5 = "";
            if (bArr != null) {
                i = bArr.length;
                String n = z.n(bArr);
                if (str4.equalsIgnoreCase(n)) {
                    z2 = dV;
                } else {
                    str5 = "MD5Error_" + n + "_" + str4;
                    z2 = false;
                }
            } else {
                str5 = "downSizeZero";
                z2 = dV;
            }
            w.a(dV, str, str2, "0", str5, String.valueOf(i), currentTimeMillis2, z);
            return z2;
        } catch (Exception e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("class");
            stringBuffer.append(e.getClass());
            stringBuffer.append(" message");
            stringBuffer.append(e.getMessage());
            w.a(false, str, str2, "-1", stringBuffer.toString(), "0", 0L, z);
            return false;
        }
    }
}
