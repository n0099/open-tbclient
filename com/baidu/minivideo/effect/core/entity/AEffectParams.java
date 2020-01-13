package com.baidu.minivideo.effect.core.entity;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes12.dex */
public class AEffectParams implements Parcelable {
    public static final Parcelable.Creator<AEffectParams> CREATOR = new Parcelable.Creator<AEffectParams>() { // from class: com.baidu.minivideo.effect.core.entity.AEffectParams.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: da */
        public AEffectParams[] newArray(int i) {
            return new AEffectParams[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: r */
        public AEffectParams createFromParcel(Parcel parcel) {
            return new AEffectParams(parcel);
        }
    };
    public static final String IMAGE_HEIGHT = "imageHeight";
    public static final String IMAGE_WIDTH = "imageWidth";
    public static final String VALUE_TYPE_ARRAY = "array";
    public static final String VALUE_TYPE_FLOAT = "float";
    public static final String VALUE_TYPE_STEP = "step";
    public String name;
    public float timeInterval;
    public String type;
    public float[] values;

    public AEffectParams() {
    }

    protected AEffectParams(Parcel parcel) {
        this.name = parcel.readString();
        this.type = parcel.readString();
        this.values = parcel.createFloatArray();
        this.timeInterval = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.type);
        parcel.writeFloatArray(this.values);
        parcel.writeFloat(this.timeInterval);
    }
}
