package com.baidu.swan.games.q.b;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public JSONObject bDm;
    public d bDn;
    public String query;
    public String title;
    public String videoPath;

    public String toString() {
        return "{ videoPath=" + this.videoPath + " , query=" + this.query + " , title=" + this.title + ", extra=" + this.bDm + ", videoEditorParams=" + this.bDn + " }";
    }
}
