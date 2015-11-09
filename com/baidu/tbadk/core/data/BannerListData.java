package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.utils.SapiUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
/* loaded from: classes.dex */
public class BannerListData implements Serializable {
    private static final long serialVersionUID = 1630193525564805923L;
    private ArrayList<b> advertAppList = new ArrayList<>();

    public ArrayList<b> getAllAdvertList() {
        return this.advertAppList;
    }

    public String getLastIds() {
        if (this.advertAppList == null || this.advertAppList.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int size = this.advertAppList.size();
        for (int i = 0; i < size; i++) {
            if (!TextUtils.isEmpty(this.advertAppList.get(i).TW)) {
                sb.append(this.advertAppList.get(i).TW);
                if (i != size - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray(SapiUtils.QR_LOGIN_LP_APP);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserProtobuf(BannerList bannerList) {
        if (bannerList != null) {
            List<App> list = bannerList.app;
            if (list != null && list.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    if (list.get(i2) != null) {
                        b bVar = new b();
                        bVar.a(list.get(i2));
                        this.advertAppList.add(bVar);
                    }
                    i = i2 + 1;
                }
            }
            Collections.sort(this.advertAppList, new d(this));
        }
    }
}
