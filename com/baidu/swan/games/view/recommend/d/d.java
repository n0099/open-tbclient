package com.baidu.swan.games.view.recommend.d;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    public JSONObject data;
    public String errMsg;
    public int vx;

    public boolean isSuccess() {
        return this.vx == 0;
    }
}
