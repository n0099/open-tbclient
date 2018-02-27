package com.baidu.tbadk.core.util.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import org.apache.http.client.methods.HttpGet;
/* loaded from: classes.dex */
public abstract class e {
    private static e aYf = null;
    public boolean aYe = false;

    public abstract String getAllIPListCanUsed();

    public abstract com.baidu.tbadk.e.a getCDNImageTimeData();

    public abstract String getCachedCdnIp(int i);

    public abstract boolean hasImageProblem();

    public abstract HttpGet httpGetFactory(String str, int i, boolean z);

    public abstract HttpGet httpGetFactory(String str, String str2, String str3);

    public abstract void init();

    public abstract boolean isShouldCDNFallBack();

    public abstract void result(String str, String str2, boolean z, boolean z2, boolean z3);

    public abstract void setCDNImageTimeData(com.baidu.tbadk.e.a aVar);

    public abstract void setIpDisableTime(int i);

    public static e getInstance() {
        if (aYf == null) {
            synchronized (e.class) {
                if (aYf == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016102, e.class);
                    if (runTask != null && runTask.getData() != null) {
                        aYf = (e) runTask.getData();
                    }
                    return aYf;
                }
            }
        }
        return aYf;
    }
}
