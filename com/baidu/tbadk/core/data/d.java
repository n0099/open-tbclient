package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
/* loaded from: classes.dex */
public class d {
    private ArrayList<a> a = new ArrayList<>();

    public ArrayList<a> a() {
        return this.a;
    }

    public String b() {
        if (this.a == null || this.a.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            sb.append(this.a.get(i).b);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("app");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(BannerList bannerList) {
        List<App> list;
        if (bannerList != null && (list = bannerList.app) != null && list.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    if (list.get(i2) != null) {
                        a aVar = new a();
                        aVar.a(list.get(i2));
                        this.a.add(aVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
