package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.xiaomi.mipush.sdk.Constants;
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
/* loaded from: classes.dex */
public class BannerListData implements Serializable {
    private static final long serialVersionUID = 1630193525564805923L;
    private ArrayList<AdvertAppInfo> advertAppList = new ArrayList<>();
    private ArrayList<FeedForumData> feedForumList = new ArrayList<>();
    private com.baidu.tieba.card.data.n recomTopicData;

    public ArrayList<AdvertAppInfo> getAllAdvertList() {
        return this.advertAppList;
    }

    public String getLastIds() {
        if (this.advertAppList == null || this.advertAppList.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int size = this.advertAppList.size();
        for (int i = 0; i < size; i++) {
            if (!TextUtils.isEmpty(this.advertAppList.get(i).dms)) {
                sb.append(this.advertAppList.get(i).dms);
                if (i != size - 1) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
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

    public void parserProtobuf(BannerList bannerList) {
        List<AppData> cNj = com.baidu.tieba.recapp.q.cNl().cNj();
        if (cNj != null) {
            cNj.clear();
        }
        if (bannerList != null) {
            List<App> list = bannerList.app;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != null) {
                        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                        advertAppInfo.a(list.get(i));
                        this.advertAppList.add(advertAppInfo);
                        if (cNj != null) {
                            cNj.add(advertAppInfo.dmI);
                        }
                    }
                }
            }
            com.baidu.tieba.recapp.q.cNl().cNk();
            Collections.sort(this.advertAppList, new Comparator<AdvertAppInfo>() { // from class: com.baidu.tbadk.core.data.BannerListData.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(AdvertAppInfo advertAppInfo2, AdvertAppInfo advertAppInfo3) {
                    return (advertAppInfo2 != null ? com.baidu.adp.lib.f.b.toInt(advertAppInfo2.adPosition, 0) : 0) - (advertAppInfo3 != null ? com.baidu.adp.lib.f.b.toInt(advertAppInfo3.adPosition, 0) : 0);
                }
            });
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
                bb bbVar = new bb();
                bbVar.a(bannerList.hot_topic);
                this.recomTopicData = bbVar.aJO();
            }
        }
    }

    public com.baidu.tieba.card.data.n getRecomTopicData() {
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
