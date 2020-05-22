package com.baidu.swan.game.ad.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AdResponseInfo implements Parcelable {
    public static final Parcelable.Creator<AdResponseInfo> CREATOR = new Parcelable.Creator<AdResponseInfo>() { // from class: com.baidu.swan.game.ad.entity.AdResponseInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: z */
        public AdResponseInfo createFromParcel(Parcel parcel) {
            return new AdResponseInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ib */
        public AdResponseInfo[] newArray(int i) {
            return new AdResponseInfo[i];
        }
    };
    public static final String TAG = "AdResponseInfo";
    private ArrayList<AdElementInfo> mAdInstanceList;
    private int mAdsNum;
    private String mErrorCode;
    private String mRequestId;

    public AdResponseInfo(String str) {
        this.mAdsNum = 0;
        this.mAdInstanceList = new ArrayList<>();
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = jSONObject.getJSONArray("ad");
                if (jSONArray != null) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            this.mAdInstanceList.add(new AdElementInfo(jSONArray.getJSONObject(i)));
                        } catch (Exception e) {
                            this.mAdInstanceList = new ArrayList<>();
                        }
                    }
                }
                this.mAdsNum = jSONObject.optInt("n", 0);
                this.mRequestId = jSONObject.optString("req_id");
                this.mErrorCode = jSONObject.optString("error_code", "");
            } catch (Exception e2) {
                this.mAdInstanceList = new ArrayList<>();
            }
        }
    }

    protected AdResponseInfo(Parcel parcel) {
        this.mAdsNum = 0;
        this.mAdInstanceList = new ArrayList<>();
        this.mAdsNum = parcel.readInt();
        this.mRequestId = parcel.readString();
        this.mErrorCode = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAdsNum);
        parcel.writeString(this.mRequestId);
        parcel.writeString(this.mErrorCode);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AdElementInfo awl() {
        if (this.mAdInstanceList.size() > 0) {
            return this.mAdInstanceList.get(0);
        }
        return null;
    }

    public String getErrorCode() {
        return this.mErrorCode;
    }

    public ArrayList<AdElementInfo> getAdInstanceList() {
        return this.mAdInstanceList;
    }
}
