package com.baidu.live.im.d;

import android.support.annotation.NonNull;
import android.view.View;
import java.util.List;
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: com.baidu.live.im.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0168a {
        void B(String str, int i);

        void Ey();
    }

    @NonNull
    View getView();

    void setCallback(InterfaceC0168a interfaceC0168a);

    void setData(List<String> list);
}
