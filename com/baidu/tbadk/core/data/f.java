package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
/* loaded from: classes.dex */
public class f {
    private ArrayList<c> DH = new ArrayList<>();

    public ArrayList<c> mt() {
        return this.DH;
    }

    public String mu() {
        if (this.DH == null || this.DH.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int size = this.DH.size();
        for (int i = 0; i < size; i++) {
            if (!TextUtils.isEmpty(this.DH.get(i).Dk)) {
                sb.append(this.DH.get(i).Dk);
                if (i != size - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
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

    public void a(BannerList bannerList) {
        List<App> list;
        if (bannerList != null && (list = bannerList.app) != null && list.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    if (list.get(i2) != null) {
                        c cVar = new c();
                        cVar.a(list.get(i2));
                        this.DH.add(cVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
