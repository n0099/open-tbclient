package com.baidu.fsg.base.restnet.beans;
/* loaded from: classes3.dex */
public interface IBeanResponseCallback {
    void onBeanExecFailure(int i2, int i3, String str);

    void onBeanExecSuccess(int i2, Object obj, String str, String str2);
}
