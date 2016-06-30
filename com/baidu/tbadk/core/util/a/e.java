package com.baidu.tbadk.core.util.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import org.apache.http.client.methods.HttpGet;
/* loaded from: classes.dex */
public abstract class e {
    private static e YY = null;
    public boolean YX = false;

    public abstract String getAllIPListCanUsed();

    public abstract com.baidu.tbadk.cdnOptimize.a getCDNImageTimeData();

    public abstract String getCachedCdnIp(int i);

    public abstract boolean hasImageProblem();

    public abstract HttpGet httpGetFactory(String str, int i, boolean z);

    public abstract HttpGet httpGetFactory(String str, String str2, String str3);

    public abstract void init();

    public abstract boolean isShouldCDNFallBack();

    public abstract void result(String str, String str2, boolean z, boolean z2, boolean z3);

    public abstract void setCDNImageTimeData(com.baidu.tbadk.cdnOptimize.a aVar);

    public abstract void setIpDisableTime(int i);

    public static e getInstance() {
        if (YY == null) {
            synchronized (e.class) {
                if (YY == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CDN_IP_DIRECT_CONNECT, e.class);
                    if (runTask != null && runTask.getData() != null) {
                        YY = (e) runTask.getData();
                    }
                    return YY;
                }
            }
        }
        return YY;
    }
}
