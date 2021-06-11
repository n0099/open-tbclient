package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.m.b;
import d.a.n0.t2.x;
import d.a.n0.z.e0.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.FeedForumInfo;
/* loaded from: classes3.dex */
public class BannerListData implements Serializable {
    public static final long serialVersionUID = 1630193525564805923L;
    public ArrayList<AdvertAppInfo> advertAppList = new ArrayList<>();
    public ArrayList<FeedForumData> feedForumList = new ArrayList<>();
    public n recomTopicData;

    /* loaded from: classes3.dex */
    public class a implements Comparator<AdvertAppInfo> {
        public a(BannerListData bannerListData) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(AdvertAppInfo advertAppInfo, AdvertAppInfo advertAppInfo2) {
            return (advertAppInfo != null ? b.d(advertAppInfo.P3, 0) : 0) - (advertAppInfo2 != null ? b.d(advertAppInfo2.P3, 0) : 0);
        }
    }

    public ArrayList<AdvertAppInfo> getAllAdvertList() {
        return this.advertAppList;
    }

    public List<FeedForumData> getFeedForumList() {
        return this.feedForumList;
    }

    public String getLastIds() {
        ArrayList<AdvertAppInfo> arrayList = this.advertAppList;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int size = this.advertAppList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!TextUtils.isEmpty(this.advertAppList.get(i2).J3)) {
                sb.append(this.advertAppList.get(i2).J3);
                if (i2 != size - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    public n getRecomTopicData() {
        return this.recomTopicData;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void parserProtobuf(BannerList bannerList) {
        List<AdvertAppInfo> j = x.p().j();
        if (j != null) {
            j.clear();
        }
        if (bannerList == null) {
            return;
        }
        List<App> list = bannerList.app;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2) != null) {
                    AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                    advertAppInfo.K4(list.get(i2));
                    this.advertAppList.add(advertAppInfo);
                    if (j != null) {
                        j.add(advertAppInfo);
                    }
                }
            }
        }
        x.p().i();
        Collections.sort(this.advertAppList, new a(this));
        List<FeedForumInfo> list2 = bannerList.feed_forum;
        if (list2 != null && list2.size() > 0) {
            for (int i3 = 0; i3 < list2.size(); i3++) {
                if (list2.get(i3) != null) {
                    FeedForumData feedForumData = new FeedForumData();
                    feedForumData.parseFromFeedForumInfo(list2.get(i3));
                    this.feedForumList.add(feedForumData);
                }
            }
        }
        if (bannerList.hot_topic != null) {
            RecommendTopicData recommendTopicData = new RecommendTopicData();
            recommendTopicData.d(bannerList.hot_topic);
            this.recomTopicData = recommendTopicData.a();
        }
    }

    public void setFeedForumLiked(String str, int i2) {
        ArrayList<FeedForumData> arrayList = this.feedForumList;
        if (arrayList == null || str == null) {
            return;
        }
        Iterator<FeedForumData> it = arrayList.iterator();
        while (it.hasNext()) {
            FeedForumData next = it.next();
            if (next != null && next.getForumId() != null && next.getForumId().equals(str)) {
                next.setIsLike(i2);
                return;
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("app");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
