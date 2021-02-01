package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import com.baidu.fsg.base.restnet.beans.business.BaseBean;
/* loaded from: classes5.dex */
public abstract class l extends BaseBean {

    /* renamed from: a  reason: collision with root package name */
    protected String f2278a;

    public l(Context context) {
        super(context);
    }

    public l(Context context, int i) {
        super(context, i);
    }

    public void d(String str) {
        this.f2278a = str;
    }
}
