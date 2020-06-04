package com.baidu.swan.apps.media.chooser.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes11.dex */
public class ImageModel extends MediaModel {
    public static final Parcelable.Creator<ImageModel> CREATOR = new Parcelable.Creator<ImageModel>() { // from class: com.baidu.swan.apps.media.chooser.model.ImageModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: s */
        public ImageModel createFromParcel(Parcel parcel) {
            return new ImageModel(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: fP */
        public ImageModel[] newArray(int i) {
            return new ImageModel[i];
        }
    };

    public ImageModel(String str) {
        super(str);
        setType("photo");
    }

    public ImageModel(Parcel parcel) {
        super(parcel);
    }

    @Override // com.baidu.swan.apps.media.chooser.model.MediaModel, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
