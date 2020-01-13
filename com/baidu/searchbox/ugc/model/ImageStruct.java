package com.baidu.searchbox.ugc.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.searchbox.ugc.utils.UgcUriUtils;
/* loaded from: classes12.dex */
public class ImageStruct implements Parcelable {
    public static final Parcelable.Creator<ImageStruct> CREATOR = new Parcelable.Creator<ImageStruct>() { // from class: com.baidu.searchbox.ugc.model.ImageStruct.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageStruct createFromParcel(Parcel parcel) {
            return new ImageStruct(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageStruct[] newArray(int i) {
            return new ImageStruct[i];
        }
    };
    public Uri contentUri;
    public long dateModified;
    public int height;
    public String mimeType;
    public long size;
    public String uriStr;
    public int width;

    public ImageStruct(String str) {
        this.contentUri = UgcUriUtils.getUri(str);
        this.uriStr = str;
    }

    public ImageStruct(UgcImageInfo ugcImageInfo) {
        this.contentUri = ugcImageInfo.contentUri;
        this.uriStr = ugcImageInfo.contentUri.toString();
        this.size = ugcImageInfo.size;
        this.dateModified = ugcImageInfo.dateModified;
        this.mimeType = ugcImageInfo.mimeType;
        this.width = ugcImageInfo.width;
        this.height = ugcImageInfo.height;
    }

    protected ImageStruct(Parcel parcel) {
        this(parcel.readString());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uriStr);
    }

    public boolean equals(Object obj) {
        return obj instanceof ImageStruct ? this.contentUri.equals(((ImageStruct) obj).contentUri) : super.equals(obj);
    }

    public boolean isGif() {
        return "image/gif".equalsIgnoreCase(this.mimeType);
    }
}
