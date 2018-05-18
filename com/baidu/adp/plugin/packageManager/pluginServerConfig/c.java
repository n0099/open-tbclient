package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c {
    private List<BasicNameValuePair> Cn = new ArrayList();

    public List<BasicNameValuePair> js() {
        return this.Cn;
    }

    public void i(List<BasicNameValuePair> list) {
        this.Cn = list;
    }
}
