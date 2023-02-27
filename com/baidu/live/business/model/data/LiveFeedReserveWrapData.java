package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveFeedReserveWrapData implements Parcelable {
    public static final Parcelable.Creator<LiveFeedReserveWrapData> CREATOR = new Parcelable.Creator<LiveFeedReserveWrapData>() { // from class: com.baidu.live.business.model.data.LiveFeedReserveWrapData.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveFeedReserveWrapData createFromParcel(Parcel parcel) {
            return new LiveFeedReserveWrapData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveFeedReserveWrapData[] newArray(int i) {
            return new LiveFeedReserveWrapData[i];
        }
    };
    public LiveFeedReserveHeaderInfo headerInfo;
    public List<LiveRoomEntity> roomInfos;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LiveFeedReserveWrapData() {
    }

    public boolean isValid() {
        List<LiveRoomEntity> list;
        LiveFeedReserveHeaderInfo liveFeedReserveHeaderInfo = this.headerInfo;
        if (liveFeedReserveHeaderInfo != null && !TextUtils.isEmpty(liveFeedReserveHeaderInfo.tip) && (list = this.roomInfos) != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    public LiveFeedReserveWrapData(Parcel parcel) {
        this.headerInfo = (LiveFeedReserveHeaderInfo) parcel.readParcelable(LiveFeedReserveHeaderInfo.class.getClassLoader());
        this.roomInfos = parcel.createTypedArrayList(LiveRoomEntity.CREATOR);
    }

    public static LiveFeedReserveWrapData parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LiveFeedReserveWrapData liveFeedReserveWrapData = new LiveFeedReserveWrapData();
        liveFeedReserveWrapData.headerInfo = LiveFeedReserveHeaderInfo.parseJson(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            liveFeedReserveWrapData.roomInfos = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    LiveRoomEntity liveRoomEntity = new LiveRoomEntity();
                    liveRoomEntity.parserJson(optJSONObject);
                    liveRoomEntity.fromReserve = true;
                    liveFeedReserveWrapData.roomInfos.add(liveRoomEntity);
                }
            }
        }
        return liveFeedReserveWrapData;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.headerInfo, i);
        parcel.writeTypedList(this.roomInfos);
    }
}
