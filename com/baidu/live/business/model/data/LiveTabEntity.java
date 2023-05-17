package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveTabEntity implements Parcelable {
    public static final Parcelable.Creator<LiveTabEntity> CREATOR = new Parcelable.Creator<LiveTabEntity>() { // from class: com.baidu.live.business.model.data.LiveTabEntity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveTabEntity createFromParcel(Parcel parcel) {
            return new LiveTabEntity(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveTabEntity[] newArray(int i) {
            return new LiveTabEntity[i];
        }
    };
    public String channelId;
    public int id;
    public String name;
    public boolean selected;
    public List<TabLabelInfo> subTabList;
    public String type;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* loaded from: classes3.dex */
    public static class TabLabelInfo implements Parcelable {
        public static final Parcelable.Creator<TabLabelInfo> CREATOR = new Parcelable.Creator<TabLabelInfo>() { // from class: com.baidu.live.business.model.data.LiveTabEntity.TabLabelInfo.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TabLabelInfo createFromParcel(Parcel parcel) {
                return new TabLabelInfo(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TabLabelInfo[] newArray(int i) {
                return new TabLabelInfo[i];
            }
        };
        public int id;
        public String name;
        public boolean selected;
        public String type;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public TabLabelInfo() {
        }

        public TabLabelInfo(Parcel parcel) {
            boolean z;
            this.id = parcel.readInt();
            this.type = parcel.readString();
            this.name = parcel.readString();
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.selected = z;
        }

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.id = jSONObject.optInt("id");
            this.type = jSONObject.optString("type");
            this.name = jSONObject.optString("name");
            this.selected = jSONObject.optBoolean("selected");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.id);
            parcel.writeString(this.type);
            parcel.writeString(this.name);
            parcel.writeByte(this.selected ? (byte) 1 : (byte) 0);
        }
    }

    public LiveTabEntity() {
    }

    public LiveTabEntity(Parcel parcel) {
        boolean z;
        this.id = parcel.readInt();
        this.type = parcel.readString();
        this.channelId = parcel.readString();
        this.name = parcel.readString();
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.selected = z;
        this.subTabList = parcel.createTypedArrayList(TabLabelInfo.CREATOR);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.id = jSONObject.optInt("id");
        this.type = jSONObject.optString("type");
        this.channelId = jSONObject.optString("channel_id");
        this.name = jSONObject.optString("name");
        this.selected = jSONObject.optBoolean("selected");
        JSONArray optJSONArray = jSONObject.optJSONArray("tab_list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.subTabList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    TabLabelInfo tabLabelInfo = new TabLabelInfo();
                    tabLabelInfo.parserJson(optJSONObject);
                    this.subTabList.add(tabLabelInfo);
                }
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.type);
        parcel.writeString(this.channelId);
        parcel.writeString(this.name);
        parcel.writeByte(this.selected ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.subTabList);
    }
}
