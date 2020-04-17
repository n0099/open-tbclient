package com.baidu.swan.games.view.recommend.model;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public int QZ;
    public JSONObject data;
    public String errMsg;

    public boolean isSuccess() {
        return this.QZ == 0;
    }
}
