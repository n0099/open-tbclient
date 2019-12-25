package com.baidu.swan.games.t.b;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public JSONObject cnL;
    public d cnM;
    public String query;
    public String title;
    public String videoPath;

    public String toString() {
        return "{ videoPath=" + this.videoPath + " , query=" + this.query + " , title=" + this.title + ", extra=" + this.cnL + ", videoEditorParams=" + this.cnM + " }";
    }
}
