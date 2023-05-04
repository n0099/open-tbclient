package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.tieba.rb0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveBannerEntity implements Parcelable {
    public static final Parcelable.Creator<LiveBannerEntity> CREATOR = new Parcelable.Creator<LiveBannerEntity>() { // from class: com.baidu.live.business.model.data.LiveBannerEntity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveBannerEntity createFromParcel(Parcel parcel) {
            return new LiveBannerEntity(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveBannerEntity[] newArray(int i) {
            return new LiveBannerEntity[i];
        }
    };
    public static final int TYPE_LIVE = 1;
    public int audienceCount;
    public int bannerType;
    public BannerCmdInfo cmdInfo;
    public long endTime;
    public LiveHostInfo hostInfo;
    public LeftLableInfo leftLabel;
    public int liveStatus;
    public String materialId;
    public String name;
    public boolean needLogShow;
    public String nid;
    public String pic;
    public int position;
    public LiveRoomEntity roomEntity;
    public String roomId;
    public long startTime;
    public LiveStatInfo statInfo;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* loaded from: classes2.dex */
    public class BannerCmdInfo {
        public String action;
        public int type;

        public BannerCmdInfo() {
        }

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.action = jSONObject.optString("action");
        }
    }

    public LiveBannerEntity() {
        this.needLogShow = true;
    }

    public boolean isValid() {
        return !rb0.a(this.pic);
    }

    public LiveBannerEntity(Parcel parcel) {
        this.needLogShow = true;
        this.name = parcel.readString();
        this.pic = parcel.readString();
        this.nid = parcel.readString();
        this.roomId = parcel.readString();
        this.audienceCount = parcel.readInt();
        this.liveStatus = parcel.readInt();
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.hostInfo = (LiveHostInfo) parcel.readParcelable(LiveHostInfo.class.getClassLoader());
        this.leftLabel = (LeftLableInfo) parcel.readParcelable(LeftLableInfo.class.getClassLoader());
        this.bannerType = parcel.readInt();
        this.statInfo = (LiveStatInfo) parcel.readParcelable(LiveStatInfo.class.getClassLoader());
        this.position = parcel.readInt();
        this.needLogShow = parcel.readByte() != 0;
        this.roomEntity = (LiveRoomEntity) parcel.readParcelable(LiveRoomEntity.class.getClassLoader());
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.name = jSONObject.optString("name");
        this.pic = jSONObject.optString("pic");
        this.nid = jSONObject.optString("nid");
        this.roomId = jSONObject.optString("room_Id");
        this.audienceCount = jSONObject.optInt("audience_count");
        this.materialId = jSONObject.optString("material_id");
        this.liveStatus = jSONObject.optInt(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
        this.startTime = jSONObject.optLong("start_time");
        this.endTime = jSONObject.optLong("end_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("host");
        if (optJSONObject != null) {
            LiveHostInfo liveHostInfo = new LiveHostInfo();
            this.hostInfo = liveHostInfo;
            liveHostInfo.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("cmd");
        if (optJSONObject2 != null) {
            BannerCmdInfo bannerCmdInfo = new BannerCmdInfo();
            this.cmdInfo = bannerCmdInfo;
            bannerCmdInfo.parserJson(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("left_label");
        if (optJSONObject3 != null) {
            LeftLableInfo leftLableInfo = new LeftLableInfo();
            this.leftLabel = leftLableInfo;
            leftLableInfo.parserJson(optJSONObject3);
        }
        this.bannerType = jSONObject.optInt("banner_type");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("stat");
        if (optJSONObject4 != null) {
            LiveStatInfo liveStatInfo = new LiveStatInfo();
            this.statInfo = liveStatInfo;
            liveStatInfo.parserJson(optJSONObject4);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.pic);
        parcel.writeString(this.nid);
        parcel.writeString(this.roomId);
        parcel.writeInt(this.audienceCount);
        parcel.writeInt(this.liveStatus);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeParcelable(this.hostInfo, i);
        parcel.writeParcelable(this.leftLabel, i);
        parcel.writeInt(this.bannerType);
        parcel.writeParcelable(this.statInfo, i);
        parcel.writeInt(this.position);
        parcel.writeByte(this.needLogShow ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.roomEntity, i);
    }
}
