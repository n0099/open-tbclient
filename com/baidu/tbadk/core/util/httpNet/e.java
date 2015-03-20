package com.baidu.tbadk.core.util.httpNet;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import org.apache.http.client.methods.HttpGet;
/* loaded from: classes.dex */
public abstract class e {
    private static e Wc = null;
    public boolean Wb = false;

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
        if (Wc == null) {
            synchronized (e.class) {
                if (Wc == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016102, e.class);
                    if (runTask != null && runTask.getData() != null) {
                        Wc = (e) runTask.getData();
                    }
                    return Wc;
                }
            }
        }
        return Wc;
    }
}
