package com.baidu.tbadk.cdnOptimize;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.stats.p;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.httpNet.ImgHttpClient;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e {
    private String b = "c/s/checkcdn";
    private i c = null;
    public String a = String.valueOf(TbConfig.SERVER_ADDRESS) + this.b;
    private HttpMessageListener d = new h(this, 1002100);

    public g() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002100, this.a);
        tbHttpMessageTask.setResponsedClass(TbCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.d);
        MessageManager.getInstance().registerListener(this.d);
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
        this.c = iVar;
    }

    public void a() {
        sendMessage(new HttpMessage(1002100));
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        boolean z2;
        int i;
        if (str == null || str2 == null || str3 == null || str4 == null) {
            return false;
        }
        boolean z3 = false;
        int indexOf = str.indexOf("hiphotos");
        if (indexOf > 0 && indexOf < 20) {
            z3 = true;
        }
        if (!z3) {
            return false;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
            ImgHttpClient imgHttpClient = new ImgHttpClient(eVar);
            eVar.a().a(str);
            imgHttpClient.a(str2, str3, 1);
            byte[] bArr = eVar.b().g;
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            boolean a = eVar.b().a();
            String str5 = "";
            if (bArr != null) {
                int length = bArr.length;
                String a2 = p.a(bArr);
                if (str4.equals(a2)) {
                    z2 = a;
                    i = length;
                } else {
                    str5 = "MD5Error_" + a2 + "_" + str4;
                    z2 = false;
                    i = length;
                }
            } else {
                str5 = "downSizeZero";
                z2 = false;
                i = 0;
            }
            w.a(z2, str, str2, "0", str5, String.valueOf(i), currentTimeMillis2, z);
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
