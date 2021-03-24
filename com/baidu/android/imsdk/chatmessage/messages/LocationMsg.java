package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.Base64;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LocationMsg extends RichMediaMsg implements Parcelable, NoProGuard {
    public double mLatitude;
    public double mLongitude;
    public String mTitle;
    public static String TAG = LocationMsg.class.getSimpleName();
    public static final Parcelable.Creator<LocationMsg> CREATOR = new Parcelable.Creator<LocationMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.LocationMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationMsg createFromParcel(Parcel parcel) {
            return new LocationMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationMsg[] newArray(int i) {
            return new LocationMsg[i];
        }
    };

    public LocationMsg() {
        this.mTitle = null;
        this.mLatitude = 0.0d;
        this.mLongitude = 0.0d;
        setMsgType(7);
    }

    private String getLocationContent(String str, double d2, double d3, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", d3);
            jSONObject.put("y", d2);
            jSONObject.put("thumbnail", Base64.encode(bArr));
            jSONObject.put("title", str);
            return jSONObject.toString();
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "getLocationContent", e2);
            return "";
        }
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "[位置]";
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        if (!TextUtils.isEmpty(this.mjsonContent)) {
            try {
                JSONObject jSONObject = new JSONObject(this.mjsonContent);
                setTitle(jSONObject.getString("title"));
                this.mLatitude = jSONObject.optDouble("x");
                this.mLongitude = jSONObject.optDouble("y");
                return true;
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            }
        }
        return false;
    }

    public void setContent(String str, double d2, double d3, byte[] bArr) {
        setMsgContent(getLocationContent(str, d3, d2, bArr));
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.RichMediaMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mTitle);
        parcel.writeDouble(this.mLatitude);
        parcel.writeDouble(this.mLongitude);
    }

    public LocationMsg(double d2, double d3, String str) {
        this.mTitle = null;
        this.mLatitude = 0.0d;
        this.mLongitude = 0.0d;
        setMsgType(7);
        this.mLatitude = d2;
        this.mLongitude = d3;
        this.mTitle = str;
        setContent(str, d2, d3, null);
    }

    public LocationMsg(Parcel parcel) {
        super(parcel);
        this.mTitle = null;
        this.mLatitude = 0.0d;
        this.mLongitude = 0.0d;
        this.mTitle = parcel.readString();
        this.mLatitude = parcel.readDouble();
        this.mLongitude = parcel.readDouble();
    }
}
