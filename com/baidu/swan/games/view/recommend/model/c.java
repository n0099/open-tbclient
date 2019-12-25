package com.baidu.swan.games.view.recommend.model;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public JSONObject data;
    public String errMsg;
    public int xz;

    public boolean isSuccess() {
        return this.xz == 0;
    }
}
