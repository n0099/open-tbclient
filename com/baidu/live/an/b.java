package com.baidu.live.an;

import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.data.w;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface b {
    void L(Object obj);

    void Q(JSONObject jSONObject);

    void Ss();

    boolean St();

    boolean Su();

    void Y(View view);

    void a(FrameLayout frameLayout);

    void a(a aVar);

    View getEnterView();

    void onDestroy();

    boolean onKeyDown(int i, KeyEvent keyEvent);

    void setLiveShowData(w wVar);

    void setMute(boolean z);
}
