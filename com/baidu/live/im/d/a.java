package com.baidu.live.im.d;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.live.view.AlphaGradientHListView;
import java.util.List;
/* loaded from: classes11.dex */
public interface a {

    /* renamed from: com.baidu.live.im.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0180a {
        void H(String str, int i);

        void LF();
    }

    AlphaGradientHListView getListView();

    @NonNull
    View getView();

    void setCallback(InterfaceC0180a interfaceC0180a);

    void setData(List<String> list);

    void setInVisible();

    void setTextColor(int i);
}
