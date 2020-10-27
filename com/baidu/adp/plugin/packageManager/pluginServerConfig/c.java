package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c {
    private List<BasicNameValuePair> Ua = new ArrayList();

    public List<BasicNameValuePair> qo() {
        return this.Ua;
    }

    public void p(List<BasicNameValuePair> list) {
        this.Ua = list;
    }
}
