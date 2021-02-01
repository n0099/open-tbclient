package com.baidu.live.am;

import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.data.ab;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public interface b {
    void H(Object obj);

    void Rl();

    boolean Rm();

    boolean Rn();

    void Y(View view);

    void a(FrameLayout frameLayout);

    void a(a aVar);

    void aa(JSONObject jSONObject);

    View getEnterView();

    void onDestroy();

    boolean onKeyDown(int i, KeyEvent keyEvent);

    void setLiveShowData(ab abVar);

    void setMute(boolean z);
}
