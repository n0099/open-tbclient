package com.baidu.swan.b.a.e;

import com.baidu.down.manage.Download;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public c(String str) {
        super("onSuccess", 0, c(null, str));
    }

    public c(Download download) {
        super("onSuccess", 0, c(d(download), ""));
    }

    public c(Collection<Download> collection) {
        super("onSuccess", 0, c(g(collection), ""));
    }

    private static JSONArray g(Collection<Download> collection) {
        JSONArray jSONArray = new JSONArray();
        if (collection == null) {
            return jSONArray;
        }
        for (Download download : collection) {
            if (download != null) {
                jSONArray.put(d(download));
            }
        }
        return jSONArray;
    }

    private static JSONObject d(Download download) {
        JSONObject jSONObject = new JSONObject();
        if (download != null) {
            try {
                jSONObject.put("apkId", new com.baidu.swan.b.a.b.a(download).aiq());
                jSONObject.put("downloadId", download.getId());
                jSONObject.put("packageName", download.getKeyByUser());
                jSONObject.put("url", download.getUrl());
                jSONObject.put("status", download.getState().ordinal());
                jSONObject.put("current", download.getCurrentbytes());
                jSONObject.put("total", download.getTotalbytes());
                jSONObject.put("fileExist", com.baidu.swan.b.a.b.b.b(download) ? "1" : "0");
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    private static String c(Object obj, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", obj);
            jSONObject.put("message", str);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }
}
