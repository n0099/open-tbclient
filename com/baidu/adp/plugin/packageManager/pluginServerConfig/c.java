package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c {
    private List<BasicNameValuePair> wt = new ArrayList();

    public List<BasicNameValuePair> ji() {
        return this.wt;
    }

    public void k(List<BasicNameValuePair> list) {
        this.wt = list;
    }
}
