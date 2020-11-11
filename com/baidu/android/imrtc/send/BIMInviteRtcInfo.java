package com.baidu.android.imrtc.send;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.IMJni;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcUtility;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class BIMInviteRtcInfo extends BIMRtcInfo {
    public static final Parcelable.Creator<BIMInviteRtcInfo> CREATOR = new Parcelable.Creator<BIMInviteRtcInfo>() { // from class: com.baidu.android.imrtc.send.BIMInviteRtcInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BIMInviteRtcInfo createFromParcel(Parcel parcel) {
            return new BIMInviteRtcInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BIMInviteRtcInfo[] newArray(int i) {
            return new BIMInviteRtcInfo[i];
        }
    };
    private static final String TAG = "IMInviteRtcInfo";
    protected Context mContext;
    private List<BIMInviteUser> mInviteUsers;
    private int mMediaType;
    private int mRtcRoomType;

    public int getRtcRoomType() {
        return this.mRtcRoomType;
    }

    public void setRtcRoomType(int i) {
        this.mRtcRoomType = i;
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public void setMediaType(int i) {
        this.mMediaType = i;
    }

    public List<BIMInviteUser> getBIMInviteUsers() {
        return this.mInviteUsers;
    }

    public void setBIMInviteUsers(@NonNull List<BIMInviteUser> list) {
        this.mInviteUsers.clear();
        this.mInviteUsers.addAll(list);
    }

    protected BIMInviteRtcInfo(Parcel parcel) {
        super(parcel);
        this.mInviteUsers = new ArrayList();
        this.mRtcRoomType = parcel.readInt();
        this.mMediaType = parcel.readInt();
        this.mRtcExt = parcel.readString();
        this.mInviteUsers = parcel.createTypedArrayList(BIMInviteUser.CREATOR);
    }

    public BIMInviteRtcInfo(Context context) {
        this.mInviteUsers = new ArrayList();
        this.mContext = context;
    }

    private BIMInviteRtcInfo(BIMRtcInfo bIMRtcInfo) {
        this.mInviteUsers = new ArrayList();
        setAction(bIMRtcInfo.getAction());
        setRtcRoomId(bIMRtcInfo.getRtcRoomId());
        setRtcExt(bIMRtcInfo.getRtcExt());
        setRtcDeviceId(bIMRtcInfo.getRtcDeviceId());
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mRtcRoomType);
        parcel.writeInt(this.mMediaType);
        parcel.writeString(this.mRtcExt);
        parcel.writeTypedList(this.mInviteUsers);
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        try {
            JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
            jSONObject.put("rtc_appid", RtcUtility.getRtcAppId(this.mContext));
            jSONObject.put("rtc_room_token", RtcUtility.getRtcRoomToken(this.mContext));
            jSONObject.put("rtc_room_name", RtcUtility.getRtcRoomName(this.mContext));
            jSONObject.put("rtc_room_desc", RtcUtility.getRtcRoomDes(this.mContext));
            jSONObject.put("rtc_room_type", this.mRtcRoomType);
            jSONObject.put("media_type", this.mMediaType);
            JSONArray jSONArray = new JSONArray();
            for (BIMInviteUser bIMInviteUser : this.mInviteUsers) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appid", bIMInviteUser.appId);
                jSONObject2.put("uk", bIMInviteUser.uk);
                jSONObject2.put("cuid", bIMInviteUser.cuid);
                jSONObject2.put("third_userid", IMJni.transBDUID(bIMInviteUser.thirdUserId));
                jSONObject2.put("app_version", bIMInviteUser.appVersion);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("user_list", jSONArray);
            LogUtils.d(TAG, "IMInviteRtcInfo :" + jSONObject.toString());
            return jSONObject.toString();
        } catch (Exception e) {
            LogUtils.e(TAG, "IMInviteRtcInfo Exception ", e);
            return "";
        }
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i, String str, String str2) {
        JSONArray optJSONArray;
        BIMInviteRtcInfo bIMInviteRtcInfo = new BIMInviteRtcInfo(super.toRtcInfo(i, str, str2));
        try {
            JSONObject jSONObject = new JSONObject(str2);
            bIMInviteRtcInfo.setMediaType(jSONObject.optInt("media_type"));
            bIMInviteRtcInfo.setRtcRoomType(jSONObject.optInt("rtc_room_type"));
            optJSONArray = jSONObject.optJSONArray("user_list");
        } catch (Exception e) {
            LogUtils.e(TAG, "BIMInviteRtcInfo toRtcInfo Exception ", e);
        }
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return bIMInviteRtcInfo;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            BIMInviteUser bIMInviteUser = new BIMInviteUser();
            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
            bIMInviteUser.appId = jSONObject2.optLong("appid");
            bIMInviteUser.uk = jSONObject2.optLong("uk");
            bIMInviteUser.cuid = jSONObject2.optString("cuid");
            bIMInviteUser.thirdUserId = jSONObject2.optString("third_userid");
            bIMInviteUser.appVersion = jSONObject2.optString("app_version");
            arrayList.add(bIMInviteUser);
        }
        bIMInviteRtcInfo.setBIMInviteUsers(arrayList);
        return bIMInviteRtcInfo;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        return "BIMInviteRtcInfo{" + super.toString() + ", mRtcRoomType=" + this.mRtcRoomType + ", mMediaType=" + this.mMediaType + '}';
    }

    /* loaded from: classes5.dex */
    public static class BIMInviteUser implements Parcelable {
        public static final Parcelable.Creator<BIMInviteUser> CREATOR = new Parcelable.Creator<BIMInviteUser>() { // from class: com.baidu.android.imrtc.send.BIMInviteRtcInfo.BIMInviteUser.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BIMInviteUser createFromParcel(Parcel parcel) {
                return new BIMInviteUser(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BIMInviteUser[] newArray(int i) {
                return new BIMInviteUser[i];
            }
        };
        public long appId;
        public String appVersion;
        public String cuid;
        public String thirdUserId;
        public long uk;

        protected BIMInviteUser(Parcel parcel) {
            this.appId = parcel.readLong();
            this.uk = parcel.readLong();
            this.cuid = parcel.readString();
            this.thirdUserId = parcel.readString();
            this.appVersion = parcel.readString();
        }

        public BIMInviteUser() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.appId);
            parcel.writeLong(this.uk);
            parcel.writeString(this.cuid);
            parcel.writeString(this.thirdUserId);
            parcel.writeString(this.appVersion);
        }
    }
}
