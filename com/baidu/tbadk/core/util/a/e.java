package com.baidu.tbadk.core.util.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import org.apache.http.client.methods.HttpGet;
/* loaded from: classes.dex */
public abstract class e {
    private static e bUM = null;
    public boolean bUL = false;

    public abstract String getAllIPListCanUsed();

    public abstract com.baidu.tbadk.i.a getCDNImageTimeData();

    public abstract String getCachedCdnIp(int i);

    public abstract boolean hasImageProblem();

    public abstract HttpGet httpGetFactory(String str, int i, boolean z);

    public abstract HttpGet httpGetFactory(String str, String str2, String str3);

    public abstract void init();

    public abstract boolean isShouldCDNFallBack();

    public abstract void result(String str, String str2, boolean z, boolean z2, boolean z3);

    public abstract void setCDNImageTimeData(com.baidu.tbadk.i.a aVar);

    public abstract void setIpDisableTime(int i);

    public static e getInstance() {
        if (bUM == null) {
            synchronized (e.class) {
                if (bUM == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016102, e.class);
                    if (runTask != null && runTask.getData() != null) {
                        bUM = (e) runTask.getData();
                    }
                    return bUM;
                }
            }
        }
        return bUM;
    }
}
