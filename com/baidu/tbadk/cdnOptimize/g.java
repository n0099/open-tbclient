package com.baidu.tbadk.cdnOptimize;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.u;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.httpNet.ImgHttpClient;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e {
    public static final String ya = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/checkcdn";
    private i xZ;
    private HttpMessageListener yb;

    public g(Context context) {
        super(context);
        this.xZ = null;
        this.yb = new h(this, CmdConfigHttp.CDN_IPLIST_CMD);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CDN_IPLIST_CMD, ya);
        tbHttpMessageTask.setResponsedClass(TbCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.yb);
        MessageManager.getInstance().registerListener(this.yb);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(i iVar) {
        this.xZ = iVar;
    }

    public void iU() {
        sendMessage(new HttpMessage(CmdConfigHttp.CDN_IPLIST_CMD));
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        int i;
        boolean z2 = true;
        if (str == null || str2 == null || str3 == null || str4 == null) {
            return false;
        }
        int indexOf = str.indexOf("hiphotos");
        if (indexOf <= 0 || indexOf >= 20) {
            z2 = false;
        }
        if (z2) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
                ImgHttpClient imgHttpClient = new ImgHttpClient(eVar);
                eVar.dQ().setUrl(str);
                imgHttpClient.a(str2, str3, 1);
                byte[] bArr = eVar.dR().kG;
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                boolean dW = eVar.dR().dW();
                String str5 = "";
                if (bArr != null) {
                    i = bArr.length;
                    String n = u.n(bArr);
                    if (!str4.equals(n)) {
                        str5 = "MD5Error_" + n + "_" + str4;
                    }
                } else {
                    str5 = "downSizeZero";
                    i = 0;
                }
                v.a(dW, str, str2, "0", str5, String.valueOf(i), currentTimeMillis2, z);
                return dW;
            } catch (Exception e) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("class");
                stringBuffer.append(e.getClass());
                stringBuffer.append(" message");
                stringBuffer.append(e.getMessage());
                v.a(false, str, str2, "-1", stringBuffer.toString(), "0", 0L, z);
                return false;
            }
        }
        return false;
    }
}
