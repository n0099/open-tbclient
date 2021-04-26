package com.baidu.swan.apps.media.chooser.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class ImageModel extends MediaModel {
    public static final Parcelable.Creator<ImageModel> CREATOR = new a();

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<ImageModel> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ImageModel createFromParcel(Parcel parcel) {
            return new ImageModel(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ImageModel[] newArray(int i2) {
            return new ImageModel[i2];
        }
    }

    public ImageModel(String str) {
        super(str);
        i("image");
    }

    @Override // com.baidu.swan.apps.media.chooser.model.MediaModel, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
    }

    public ImageModel(Parcel parcel) {
        super(parcel);
    }
}
