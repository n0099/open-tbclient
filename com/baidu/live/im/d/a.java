package com.baidu.live.im.d;

import android.support.annotation.NonNull;
import android.view.View;
import java.util.List;
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: com.baidu.live.im.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0187a {
        void C(String str, int i);

        void Mj();
    }

    @NonNull
    View getView();

    void setCallback(InterfaceC0187a interfaceC0187a);

    void setData(List<String> list);
}
