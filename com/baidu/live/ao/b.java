package com.baidu.live.ao;

import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.data.x;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public interface b {
    void H(Object obj);

    void Tw();

    boolean Tx();

    boolean Ty();

    void Y(View view);

    void Y(JSONObject jSONObject);

    void a(FrameLayout frameLayout);

    void a(a aVar);

    View getEnterView();

    void onDestroy();

    boolean onKeyDown(int i, KeyEvent keyEvent);

    void setLiveShowData(x xVar);

    void setMute(boolean z);
}
