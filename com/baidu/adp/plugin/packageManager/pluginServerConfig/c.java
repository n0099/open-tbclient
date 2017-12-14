package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c {
    private List<BasicNameValuePair> DM = new ArrayList();

    public List<BasicNameValuePair> jN() {
        return this.DM;
    }

    public void h(List<BasicNameValuePair> list) {
        this.DM = list;
    }
}
