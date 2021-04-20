package com.baidu.mobads.container.preload;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mobads.container.util.AdURIUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XAdMaterialsInfo implements Parcelable {
    public static final Parcelable.Creator<XAdMaterialsInfo> CREATOR = new Parcelable.Creator<XAdMaterialsInfo>() { // from class: com.baidu.mobads.container.preload.XAdMaterialsInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XAdMaterialsInfo createFromParcel(Parcel parcel) {
            return new XAdMaterialsInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XAdMaterialsInfo[] newArray(int i) {
            return new XAdMaterialsInfo[i];
        }
    };
    public String appsid;
    public String expired;
    public String mimetype;
    public String url;

    public XAdMaterialsInfo() {
    }

    public static XAdMaterialsInfo fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            XAdMaterialsInfo xAdMaterialsInfo = new XAdMaterialsInfo();
            xAdMaterialsInfo.url = jSONObject.optString("url");
            xAdMaterialsInfo.appsid = jSONObject.optString("appsid");
            xAdMaterialsInfo.expired = jSONObject.optString("expired");
            xAdMaterialsInfo.mimetype = jSONObject.optString("mimetype");
            return xAdMaterialsInfo;
        }
        return null;
    }

    public static List<XAdMaterialsInfo> fromJsonArray(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    arrayList.add(fromJson(jSONArray.getJSONObject(i)));
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppsid() {
        return this.appsid;
    }

    public String getExpired() {
        return this.expired;
    }

    public String getMimetype() {
        return this.mimetype;
    }

    public String getUrl() {
        return AdURIUtils.replaceURLWithSupportProtocol(this.url);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeString(this.appsid);
        parcel.writeString(this.expired);
        parcel.writeString(this.mimetype);
    }

    public XAdMaterialsInfo(Parcel parcel) {
        this.url = parcel.readString();
        this.appsid = parcel.readString();
        this.expired = parcel.readString();
        this.mimetype = parcel.readString();
    }
}
