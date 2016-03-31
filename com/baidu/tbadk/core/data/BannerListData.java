package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.utils.SapiUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.FeedForumInfo;
/* loaded from: classes.dex */
public class BannerListData implements Serializable {
    private static final long serialVersionUID = 1630193525564805923L;
    private ArrayList<c> advertAppList = new ArrayList<>();
    private ArrayList<FeedForumData> feedForumList = new ArrayList<>();
    private com.baidu.tieba.card.a.x recomTopicData;

    public ArrayList<c> getAllAdvertList() {
        return this.advertAppList;
    }

    public String getLastIds() {
        if (this.advertAppList == null || this.advertAppList.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int size = this.advertAppList.size();
        for (int i = 0; i < size; i++) {
            if (!TextUtils.isEmpty(this.advertAppList.get(i).RZ)) {
                sb.append(this.advertAppList.get(i).RZ);
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
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != null) {
                        c cVar = new c();
                        cVar.a(list.get(i));
                        this.advertAppList.add(cVar);
                    }
                }
            }
            Collections.sort(this.advertAppList, new h(this));
            List<FeedForumInfo> list2 = bannerList.feed_forum;
            if (list2 != null && list2.size() > 0) {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    if (list2.get(i2) != null) {
                        FeedForumData feedForumData = new FeedForumData();
                        feedForumData.parseFromFeedForumInfo(list2.get(i2));
                        this.feedForumList.add(feedForumData);
                    }
                }
            }
            if (bannerList.hot_topic != null) {
                aj ajVar = new aj();
                ajVar.a(bannerList.hot_topic);
                this.recomTopicData = ajVar.sE();
            }
        }
    }

    public com.baidu.tieba.card.a.x getRecomTopicData() {
        return this.recomTopicData;
    }

    public List<FeedForumData> getFeedForumList() {
        return this.feedForumList;
    }

    public void setFeedForumLiked(String str, int i) {
        if (this.feedForumList != null && str != null) {
            Iterator<FeedForumData> it = this.feedForumList.iterator();
            while (it.hasNext()) {
                FeedForumData next = it.next();
                if (next != null && next.getForumId() != null && next.getForumId().equals(str)) {
                    next.setIsLike(i);
                    return;
                }
            }
        }
    }
}
