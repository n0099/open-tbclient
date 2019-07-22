package com.baidu.swan.games.q.b;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public JSONObject bkR;
    public d bkS;
    public String query;
    public String title;
    public String videoPath;

    public String toString() {
        return "{ videoPath=" + this.videoPath + " , query=" + this.query + " , title=" + this.title + ", extra=" + this.bkR + ", videoEditorParams=" + this.bkS + " }";
    }
}
