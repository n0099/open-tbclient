package com.baidu.swan.game.ad.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdResponseInfo implements Parcelable {
    public static final Parcelable.Creator<AdResponseInfo> CREATOR = new a();
    public static final String TAG = "AdResponseInfo";
    public ArrayList<AdElementInfo> mAdInstanceList;
    public int mAdsNum;
    public String mErrorCode;
    public String mRequestId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<AdElementInfo> getAdInstanceList() {
        return this.mAdInstanceList;
    }

    public int getAdsNum() {
        return this.mAdsNum;
    }

    public String getErrorCode() {
        return this.mErrorCode;
    }

    public AdElementInfo getPrimaryAdInstanceInfo() {
        if (this.mAdInstanceList.size() > 0) {
            return this.mAdInstanceList.get(0);
        }
        return null;
    }

    public String getRequestId() {
        return this.mRequestId;
    }

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<AdResponseInfo> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdResponseInfo createFromParcel(Parcel parcel) {
            return new AdResponseInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AdResponseInfo[] newArray(int i) {
            return new AdResponseInfo[i];
        }
    }

    public AdResponseInfo(Parcel parcel) {
        this.mAdsNum = 0;
        this.mAdInstanceList = new ArrayList<>();
        this.mAdsNum = parcel.readInt();
        this.mRequestId = parcel.readString();
        this.mErrorCode = parcel.readString();
    }

    public AdResponseInfo(String str) {
        this.mAdsNum = 0;
        this.mAdInstanceList = new ArrayList<>();
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mAdsNum = jSONObject.optInt("n", 0);
            this.mRequestId = jSONObject.optString("req_id");
            this.mErrorCode = jSONObject.optString("error_code", "");
            JSONArray jSONArray = jSONObject.getJSONArray("ad");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        this.mAdInstanceList.add(new AdElementInfo(jSONArray.getJSONObject(i)));
                    } catch (Exception unused) {
                        this.mAdInstanceList = new ArrayList<>();
                    }
                }
            }
        } catch (Exception unused2) {
            this.mAdInstanceList = new ArrayList<>();
        }
    }

    public AdResponseInfo(String str, boolean z) {
        JSONObject optJSONObject;
        this.mAdsNum = 0;
        this.mAdInstanceList = new ArrayList<>();
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(Constants.KEYS.RET, "");
            this.mErrorCode = optString;
            if (!TextUtils.equals(optString, "0") || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return;
            }
            this.mRequestId = optJSONObject.optString("id");
            JSONArray optJSONArray = optJSONObject.optJSONArray("ads");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        this.mAdInstanceList.add(new AdElementInfo(optJSONObject2, z));
                    }
                }
            }
        } catch (Exception unused) {
            this.mAdInstanceList = new ArrayList<>();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAdsNum);
        parcel.writeString(this.mRequestId);
        parcel.writeString(this.mErrorCode);
    }
}
