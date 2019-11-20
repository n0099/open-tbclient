package com.baidu.live.view.input;

import android.view.View;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public interface a {

    /* renamed from: com.baidu.live.view.input.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0080a {
        void g(String str, boolean z);

        boolean sG();

        void sI();

        void sJ();
    }

    void a(List<String> list, Map<String, Integer> map);

    int getQuickInputPanelExpandHeight();

    View getView();

    boolean hasText();

    void hide();

    void setEditText(String str);

    void setQuickInputPanelVisible(boolean z);

    void show();

    boolean tF();

    boolean tG();

    void tH();
}
