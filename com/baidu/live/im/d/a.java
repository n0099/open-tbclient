package com.baidu.live.im.d;

import android.support.annotation.NonNull;
import android.view.View;
import java.util.List;
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: com.baidu.live.im.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0178a {
        void C(String str, int i);

        void KK();
    }

    @NonNull
    View getView();

    void setCallback(InterfaceC0178a interfaceC0178a);

    void setData(List<String> list);
}
