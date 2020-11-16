package com.baidu.live.im.d;

import android.support.annotation.NonNull;
import android.view.View;
import java.util.List;
/* loaded from: classes4.dex */
public interface b {

    /* loaded from: classes4.dex */
    public interface a {
        void C(String str, int i);
    }

    void Mb();

    void Mc();

    @NonNull
    View getView();

    void setCallback(a aVar);

    void setData(List<String> list);
}
