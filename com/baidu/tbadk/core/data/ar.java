package com.baidu.tbadk.core.data;

import android.content.Context;
/* loaded from: classes.dex */
public class ar {
    private Context context;
    private String ePK;
    private String url = null;

    public ar(Context context, String str) {
        this.ePK = null;
        this.context = context;
        this.ePK = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getUrl() {
        return this.url;
    }

    public String bmm() {
        return this.ePK;
    }

    public Context getContext() {
        return this.context;
    }
}
