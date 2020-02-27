package com.baidu.searchbox.ugc.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
/* loaded from: classes13.dex */
public class CommonContentItem implements Parcelable, Serializable {
    public static final Parcelable.Creator<CommonContentItem> CREATOR = new Parcelable.Creator<CommonContentItem>() { // from class: com.baidu.searchbox.ugc.model.CommonContentItem.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommonContentItem createFromParcel(Parcel parcel) {
            return new CommonContentItem(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommonContentItem[] newArray(int i) {
            return new CommonContentItem[i];
        }
    };
    public static final int TYPE_GIF = 3;
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_LONG = 4;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_VIDEO = 5;
    public int height;
    public String type;
    public String value;
    public int width;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.type);
        parcel.writeString(this.value);
        parcel.writeInt(this.height);
        parcel.writeInt(this.width);
    }

    public CommonContentItem() {
    }

    protected CommonContentItem(Parcel parcel) {
        this.type = parcel.readString();
        this.value = parcel.readString();
        this.height = parcel.readInt();
        this.width = parcel.readInt();
    }
}
