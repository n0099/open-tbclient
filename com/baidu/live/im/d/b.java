package com.baidu.live.im.d;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.List;
/* loaded from: classes10.dex */
public interface b {

    /* loaded from: classes10.dex */
    public interface a {
        void G(String str, int i);
    }

    void Kh();

    void Ki();

    @NonNull
    View getView();

    void setCallback(a aVar);

    void setData(List<String> list);
}
