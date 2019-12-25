package com.baidu.minivideo.effect.core.entity;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes11.dex */
public class AEffectTextureParams implements Parcelable {
    public static final Parcelable.Creator<AEffectTextureParams> CREATOR = new Parcelable.Creator<AEffectTextureParams>() { // from class: com.baidu.minivideo.effect.core.entity.AEffectTextureParams.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: da */
        public AEffectTextureParams[] newArray(int i) {
            return new AEffectTextureParams[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: s */
        public AEffectTextureParams createFromParcel(Parcel parcel) {
            return new AEffectTextureParams(parcel);
        }
    };
    public String name;
    public String type;
    public String value;

    public AEffectTextureParams() {
    }

    protected AEffectTextureParams(Parcel parcel) {
        this.name = parcel.readString();
        this.type = parcel.readString();
        this.value = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.type);
        parcel.writeString(this.value);
    }
}
