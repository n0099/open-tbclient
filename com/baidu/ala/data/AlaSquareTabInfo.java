package com.baidu.ala.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaSquareTabInfo implements Parcelable {
    public static final Parcelable.Creator<AlaSquareTabInfo> CREATOR = new Parcelable.Creator<AlaSquareTabInfo>() { // from class: com.baidu.ala.data.AlaSquareTabInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlaSquareTabInfo createFromParcel(Parcel parcel) {
            return new AlaSquareTabInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlaSquareTabInfo[] newArray(int i) {
            return new AlaSquareTabInfo[i];
        }
    };
    public String bitmapWHRatio;
    public int iconType;
    public String iconUrl;
    public int id;
    public String name;
    public List<String> sortTypeList;

    public AlaSquareTabInfo() {
    }

    public AlaSquareTabInfo(Parcel parcel) {
        this.id = parcel.readInt();
        this.name = parcel.readString();
        this.iconUrl = parcel.readString();
        this.bitmapWHRatio = parcel.readString();
        this.iconType = parcel.readInt();
        this.sortTypeList = parcel.createStringArrayList();
    }

    public void parse(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.id = jSONObject.optInt("id");
            this.name = jSONObject.optString("name");
            this.iconUrl = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.bitmapWHRatio = jSONObject.optString("bitmap_wh_ratio");
            this.iconType = jSONObject.optInt("icon_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_tab_type");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                this.sortTypeList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    this.sortTypeList.add(optJSONArray.optString(i));
                }
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.bitmapWHRatio);
        parcel.writeInt(this.iconType);
        parcel.writeStringList(this.sortTypeList);
    }
}
