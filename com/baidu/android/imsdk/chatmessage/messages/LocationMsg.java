package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.Base64;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class LocationMsg extends RichMediaMsg implements Parcelable, NoProGuard {
    private double mLatitude;
    private double mLongitude;
    private String mTitle;
    private static String TAG = LocationMsg.class.getSimpleName();
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

    public LocationMsg(double d, double d2, String str) {
        this.mTitle = null;
        this.mLatitude = 0.0d;
        this.mLongitude = 0.0d;
        setMsgType(7);
        this.mLatitude = d;
        this.mLongitude = d2;
        this.mTitle = str;
        setContent(str, d, d2, null);
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

    @Override // com.baidu.android.imsdk.chatmessage.messages.RichMediaMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mTitle);
        parcel.writeDouble(this.mLatitude);
        parcel.writeDouble(this.mLongitude);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        if (TextUtils.isEmpty(this.mjsonContent)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mjsonContent);
            setTitle(jSONObject.getString("title"));
            this.mLatitude = jSONObject.optDouble("x");
            this.mLongitude = jSONObject.optDouble("y");
            return true;
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e);
            return false;
        }
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public void setContent(String str, double d, double d2, byte[] bArr) {
        setMsgContent(getLocationContent(str, d2, d, bArr));
    }

    private String getLocationContent(String str, double d, double d2, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", d2);
                jSONObject.put("y", d);
                jSONObject.put("thumbnail", Base64.encode(bArr));
                jSONObject.put("title", str);
                return jSONObject.toString();
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "getLocationContent", e);
            }
        }
        return "";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "[位置]";
    }
}
