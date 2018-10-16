package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import com.baidu.fsg.base.restnet.beans.business.BaseBean;
/* loaded from: classes6.dex */
public abstract class k extends BaseBean {
    protected String a;

    public k(Context context) {
        super(context);
    }

    public k(Context context, int i) {
        super(context, i);
    }

    public void c(String str) {
        this.a = str;
    }
}
