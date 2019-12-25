package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DuPaBInfoMsg extends ChatMsg {
    private static final String B_ACTION = "action";
    public static final int B_ACTION_ENTER = 1;
    private static final String B_ADDR = "addr";
    private static final String B_IP = "ip";
    private static final String B_LATITUDE = "latitude";
    private static final String B_LONGITUDE = "longitude";
    private static final String B_TIME = "time";
    public static final Parcelable.Creator<DuPaBInfoMsg> CREATOR = new Parcelable.Creator<DuPaBInfoMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DuPaBInfoMsg createFromParcel(Parcel parcel) {
            return new DuPaBInfoMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DuPaBInfoMsg[] newArray(int i) {
            return new DuPaBInfoMsg[i];
        }
    };
    private static final String TAG = "DuPaBInfoMsg";
    private int action;
    private String addr;
    private String ip;
    private String latitude;
    private String longitude;
    private long time;

    public DuPaBInfoMsg(String str, long j, String str2, String str3, String str4, int i) {
        setMsgType(31);
        setCategory(7);
        setChatType(7);
        this.addr = str;
        this.time = j;
        this.longitude = str2;
        this.latitude = str3;
        this.ip = str4;
        this.action = i;
        setMsgContent(getBInfoContentJson());
    }

    private DuPaBInfoMsg(Parcel parcel) {
        super(parcel);
        this.addr = parcel.readString();
        this.time = parcel.readLong();
        this.longitude = parcel.readString();
        this.latitude = parcel.readString();
        this.ip = parcel.readString();
        this.action = parcel.readInt();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        return true;
    }

    private String getBInfoContentJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.action == 1) {
                jSONObject.put(B_ADDR, this.addr);
                jSONObject.put("time", this.time);
                jSONObject.put(B_LONGITUDE, this.longitude);
                jSONObject.put(B_LATITUDE, this.latitude);
                jSONObject.put("ip", this.ip);
            }
            jSONObject.put("action", this.action);
        } catch (JSONException e) {
            LogUtils.e(TAG, "getBInfoContentJson :", e);
        }
        return jSONObject.toString();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.addr);
        parcel.writeLong(this.time);
        parcel.writeString(this.longitude);
        parcel.writeString(this.latitude);
        parcel.writeString(this.ip);
        parcel.writeInt(this.action);
    }
}
