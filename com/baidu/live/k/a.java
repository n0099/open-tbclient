package com.baidu.live.k;

import android.view.ViewGroup;
import com.baidu.live.data.w;
import com.baidu.live.im.data.b;
/* loaded from: classes4.dex */
public interface a {
    void Do();

    void a(ViewGroup viewGroup, w wVar, ViewGroup.LayoutParams layoutParams, String str);

    void a(w wVar);

    void en(int i);

    boolean isShowing();

    void l(b bVar);

    void onDestroy();

    void onPause();

    void onResume();

    void setCanVisible(boolean z);
}
