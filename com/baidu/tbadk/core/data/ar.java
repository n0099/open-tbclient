package com.baidu.tbadk.core.data;

import android.content.Context;
/* loaded from: classes.dex */
public class ar {
    private Context context;
    private String eOj;
    private String url = null;

    public ar(Context context, String str) {
        this.eOj = null;
        this.context = context;
        this.eOj = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getUrl() {
        return this.url;
    }

    public String bmk() {
        return this.eOj;
    }

    public Context getContext() {
        return this.context;
    }
}
