package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c {
    private List<BasicNameValuePair> EI = new ArrayList();

    public List<BasicNameValuePair> lV() {
        return this.EI;
    }

    public void f(List<BasicNameValuePair> list) {
        this.EI = list;
    }
}
