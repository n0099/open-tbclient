package com.baidu.tbadk.clientConfig;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class ClientConfigStatic {
    static {
        com.baidu.tieba.tbadkCore.a.a.c(303039, ClientConfigSocketResponse.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CLIENT_CONFIG, com.baidu.tieba.tbadkCore.a.a.au(TbConfig.GET_PAY_CONFIG, 303039));
        tbHttpMessageTask.setResponsedClass(ClientConfigHttpProtoResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
