package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c {
    private List<BasicNameValuePair> tj = new ArrayList();

    public List<BasicNameValuePair> ir() {
        return this.tj;
    }

    public void g(List<BasicNameValuePair> list) {
        this.tj = list;
    }
}
