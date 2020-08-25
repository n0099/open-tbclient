package com.baidu.live.im.d;

import android.support.annotation.NonNull;
import android.view.View;
import java.util.List;
/* loaded from: classes7.dex */
public interface a {

    /* renamed from: com.baidu.live.im.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0176a {
        void C(String str, int i);

        void Kd();
    }

    @NonNull
    View getView();

    void setCallback(InterfaceC0176a interfaceC0176a);

    void setData(List<String> list);
}
