package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tieba.ua0;
import com.baidu.tieba.uc0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveFeedWrapData implements Parcelable {
    public static final Parcelable.Creator<LiveFeedWrapData> CREATOR = new Parcelable.Creator<LiveFeedWrapData>() { // from class: com.baidu.live.business.model.data.LiveFeedWrapData.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveFeedWrapData createFromParcel(Parcel parcel) {
            return new LiveFeedWrapData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveFeedWrapData[] newArray(int i) {
            return new LiveFeedWrapData[i];
        }
    };
    public static final String LIVE_FEED_PAGE_FEED_CACHE_KEY = "live_feed_page_feed_cache_key";
    public static final String LIVE_FEED_PAGE_FEED_CACHE_TIME = "live_feed_page_feed_cache_time";
    public long cacheTime;
    public int errCode;
    public String errMsg;
    public boolean hasMore;
    public boolean isCacheData;
    public int refreshIndex;
    public int refreshType;
    public String resource;
    public List<LiveRoomEntity> roomInfoList;
    public String sessionId;
    public String subTab;
    public String tab;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LiveFeedWrapData() {
    }

    public boolean isBigRefresh() {
        if (this.refreshType == 0) {
            return true;
        }
        return false;
    }

    public LiveFeedWrapData(Parcel parcel) {
        boolean z;
        this.resource = parcel.readString();
        this.errCode = parcel.readInt();
        this.errMsg = parcel.readString();
        this.sessionId = parcel.readString();
        this.tab = parcel.readString();
        this.subTab = parcel.readString();
        this.refreshType = parcel.readInt();
        this.refreshIndex = parcel.readInt();
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.hasMore = z;
        this.isCacheData = parcel.readByte() != 0;
        this.cacheTime = parcel.readLong();
        this.roomInfoList = parcel.createTypedArrayList(LiveRoomEntity.CREATOR);
    }

    public static String getFeedCacheKey(String str, String str2) {
        return "live_feed_page_feed_cache_key_" + str + "_" + str2;
    }

    public void parseJsonByResponseOnly(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.errCode = jSONObject.optInt("inner_errno");
        this.errMsg = jSONObject.optString("inner_msg");
        this.sessionId = jSONObject.optString("session_id");
        this.tab = jSONObject.optString("tab");
        this.subTab = jSONObject.optString("subtab");
        this.refreshType = jSONObject.optInt("refresh_type");
        this.refreshIndex = jSONObject.optInt("refresh_index");
        this.cacheTime = jSONObject.optLong(LIVE_FEED_PAGE_FEED_CACHE_TIME);
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        boolean z = false;
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.roomInfoList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    LiveRoomEntity liveRoomEntity = new LiveRoomEntity();
                    liveRoomEntity.parserJson(optJSONObject);
                    this.roomInfoList.add(liveRoomEntity);
                }
            }
        }
        this.hasMore = (this.errCode == 0 && uc0.c(this.roomInfoList)) ? true : true;
    }

    public void parserJson(JSONObject jSONObject, int i, boolean z) {
        List<LiveRoomEntity> list;
        parseJsonByResponseOnly(jSONObject);
        if (z && !TextUtils.isEmpty(this.tab) && (list = this.roomInfoList) != null && !list.isEmpty() && i == 0) {
            try {
                jSONObject.put(LIVE_FEED_PAGE_FEED_CACHE_TIME, System.currentTimeMillis());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog("Feed 缓存记录时间失败 " + e.getMessage());
            }
            ua0.f(getFeedCacheKey(this.tab, this.subTab), jSONObject.toString());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.resource);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.errMsg);
        parcel.writeString(this.sessionId);
        parcel.writeString(this.tab);
        parcel.writeString(this.subTab);
        parcel.writeInt(this.refreshType);
        parcel.writeInt(this.refreshIndex);
        parcel.writeByte(this.hasMore ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isCacheData ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.cacheTime);
        parcel.writeTypedList(this.roomInfoList);
    }
}
