package com.baidu.tbadk.core.util.httpNet;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.a.i0.n.a;
import org.apache.http.client.methods.HttpGet;
/* loaded from: classes3.dex */
public abstract class ICDNIPDirectConnect {
    public static ICDNIPDirectConnect directConnect;
    public boolean isAlreadyInit = false;

    public static ICDNIPDirectConnect getInstance() {
        if (directConnect == null) {
            synchronized (ICDNIPDirectConnect.class) {
                if (directConnect == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016102, ICDNIPDirectConnect.class);
                    if (runTask != null && runTask.getData() != null) {
                        directConnect = (ICDNIPDirectConnect) runTask.getData();
                    }
                    return directConnect;
                }
            }
        }
        return directConnect;
    }

    public abstract String getAllIPListCanUsed();

    public abstract a getCDNImageTimeData();

    public abstract String getCachedCdnIp(int i2);

    public abstract boolean hasImageProblem();

    public abstract HttpGet httpGetFactory(String str, int i2, boolean z);

    public abstract HttpGet httpGetFactory(String str, String str2, String str3);

    public abstract void init();

    public abstract boolean isShouldCDNFallBack();

    public abstract void result(String str, String str2, boolean z, boolean z2, boolean z3);

    public abstract void setCDNImageTimeData(a aVar);

    public abstract void setIpDisableTime(int i2);
}
