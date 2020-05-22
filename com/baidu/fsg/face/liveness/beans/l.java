package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import com.baidu.fsg.base.restnet.beans.business.BaseBean;
/* loaded from: classes4.dex */
public abstract class l extends BaseBean {
    protected String a;

    public l(Context context) {
        super(context);
    }

    public l(Context context, int i) {
        super(context, i);
    }

    public void d(String str) {
        this.a = str;
    }
}
