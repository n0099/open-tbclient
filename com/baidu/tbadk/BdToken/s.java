package com.baidu.tbadk.BdToken;

import android.os.Build;
import android.webkit.CookieManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tbadk.util.aj;
import com.xiaomi.mipush.sdk.Constants;
import org.apache.http.cookie.SM;
/* loaded from: classes.dex */
public class s {
    public s() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_NEW_USER_GET_MONEY, TbConfig.NEW_USER_GET_MONEY_URL);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(NewUserGetMoneyResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void bjD() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEW_USER_GET_MONEY);
        httpMessage.addParam(Constants.PHONE_BRAND, Build.BRAND);
        httpMessage.addParam("cuid", TbadkCoreApplication.getInst().getCuid());
        httpMessage.addParam("client_version", TbConfig.getVersion());
        httpMessage.addParam("client_type", "Android");
        httpMessage.addParam(AdExtParam.KEY_SHOUBAI_CUID, TbadkCoreApplication.getInst().getCuidGalaxy2());
        httpMessage.addParam(com.baidu.fsg.base.statistics.j.c, aj.getUserAgent());
        httpMessage.addHeader(SM.COOKIE, CookieManager.getInstance().getCookie("tieba.baidu.com"));
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
