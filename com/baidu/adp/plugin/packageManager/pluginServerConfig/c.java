package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c {
    private List<BasicNameValuePair> EO = new ArrayList();

    public List<BasicNameValuePair> lN() {
        return this.EO;
    }

    public void f(List<BasicNameValuePair> list) {
        this.EO = list;
    }
}
