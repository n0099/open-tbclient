package com.baidu.searchbox.ugc.model;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class MusicData implements Serializable {
    private static final long serialVersionUID = -2120437114458663204L;
    public String icon;
    public String id;
    public String localPath;
    public String sk;
    public String title;
    public String url;
    public int startPlayMsec = 0;
    public int durationMsec = 0;

    public static MusicData parse(String str) {
        MusicData musicData;
        Exception e;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            musicData = new MusicData();
            try {
                musicData.id = jSONObject.optString("music_id");
                musicData.title = jSONObject.optString("music_title");
                musicData.icon = jSONObject.optString("music_icon");
                musicData.url = jSONObject.optString("music_url");
                musicData.sk = jSONObject.optString("sk");
                musicData.localPath = jSONObject.optString("music_local_path");
                musicData.startPlayMsec = jSONObject.optInt("music_start_msec");
                musicData.durationMsec = jSONObject.optInt("music_duration_msec");
                return musicData;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return musicData;
            }
        } catch (Exception e3) {
            musicData = null;
            e = e3;
        }
    }

    public static String toJSON(MusicData musicData) {
        if (musicData == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("music_id", musicData.id);
            jSONObject.put("music_title", musicData.title);
            jSONObject.put("music_icon", musicData.icon);
            jSONObject.put("music_url", musicData.url);
            jSONObject.put("music_local_path", musicData.localPath);
            jSONObject.put("music_start_msec", musicData.startPlayMsec);
            jSONObject.put("music_duration_msec", musicData.durationMsec);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
