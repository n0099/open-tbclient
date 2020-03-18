package com.baidu.live.view.input;

import android.view.View;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public interface a {

    /* renamed from: com.baidu.live.view.input.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0104a {
        void j(String str, boolean z);

        void wA();

        boolean wB();

        boolean wx();

        void wz();
    }

    void b(List<String> list, Map<String, Integer> map);

    int getQuickInputPanelExpandHeight();

    View getView();

    boolean hasText();

    void hide();

    void setEditText(String str);

    void setQuickInputPanelVisible(boolean z);

    void show();

    boolean xU();

    boolean xV();

    void xW();
}
