package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.b.b.e.m.b;
import d.b.i0.r2.s;
import d.b.i0.x.e0.n;
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
            return (advertAppInfo != null ? b.d(advertAppInfo.K3, 0) : 0) - (advertAppInfo2 != null ? b.d(advertAppInfo2.K3, 0) : 0);
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
        for (int i = 0; i < size; i++) {
            if (!TextUtils.isEmpty(this.advertAppList.get(i).E3)) {
                sb.append(this.advertAppList.get(i).E3);
                if (i != size - 1) {
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
        List<AppData> n = s.o().n();
        if (n != null) {
            n.clear();
        }
        if (bannerList == null) {
            return;
        }
        List<App> list = bannerList.app;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                    advertAppInfo.F4(list.get(i));
                    this.advertAppList.add(advertAppInfo);
                    if (n != null) {
                        n.add(advertAppInfo.e4);
                    }
                }
            }
        }
        s.o().m();
        Collections.sort(this.advertAppList, new a(this));
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
            RecommendTopicData recommendTopicData = new RecommendTopicData();
            recommendTopicData.d(bannerList.hot_topic);
            this.recomTopicData = recommendTopicData.a();
        }
    }

    public void setFeedForumLiked(String str, int i) {
        ArrayList<FeedForumData> arrayList = this.feedForumList;
        if (arrayList == null || str == null) {
            return;
        }
        Iterator<FeedForumData> it = arrayList.iterator();
        while (it.hasNext()) {
            FeedForumData next = it.next();
            if (next != null && next.getForumId() != null && next.getForumId().equals(str)) {
                next.setIsLike(i);
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
            for (int i = 0; i < optJSONArray.length(); i++) {
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
