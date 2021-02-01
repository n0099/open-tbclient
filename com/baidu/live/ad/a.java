package com.baidu.live.ad;

import android.view.ViewGroup;
import com.baidu.live.data.ab;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public interface a {
    boolean Z(JSONObject jSONObject);

    void a(ViewGroup viewGroup, String str);

    void a(ab abVar);

    void cT(boolean z);

    void onDestroy();

    void setCanVisible(boolean z);

    void setIsHost(boolean z);

    void xh();
}
