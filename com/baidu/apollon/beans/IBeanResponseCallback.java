package com.baidu.apollon.beans;
/* loaded from: classes.dex */
public interface IBeanResponseCallback {
    void onBeanExecFailure(int i2, int i3, String str);

    void onBeanExecSuccess(int i2, Object obj, String str);
}
