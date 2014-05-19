package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.App;
import tbclient.FrsPage.BannerList;
/* loaded from: classes.dex */
public class c {
    private ArrayList<b> a = new ArrayList<>();

    public ArrayList<b> a() {
        return this.a;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("app");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        b bVar = new b();
                        bVar.a(optJSONArray.optJSONObject(i));
                        this.a.add(bVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "parserJson", "error = " + e.getMessage());
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
                    b bVar = new b();
                    bVar.a(list.get(i2));
                    this.a.add(bVar);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
