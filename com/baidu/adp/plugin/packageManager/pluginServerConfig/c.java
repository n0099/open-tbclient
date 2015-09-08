package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c {
    private List<BasicNameValuePair> DN = new ArrayList();

    public List<BasicNameValuePair> mf() {
        return this.DN;
    }

    public void g(List<BasicNameValuePair> list) {
        this.DN = list;
    }
}
