package com.baidu.minivideo.effect.core.entity;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes11.dex */
public class AEffectAnimatorParams implements Parcelable {
    public static final String ANIM_TYPE_VALUE = "value";
    public static final Parcelable.Creator<AEffectAnimatorParams> CREATOR = new Parcelable.Creator<AEffectAnimatorParams>() { // from class: com.baidu.minivideo.effect.core.entity.AEffectAnimatorParams.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: cW */
        public AEffectAnimatorParams[] newArray(int i) {
            return new AEffectAnimatorParams[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: o */
        public AEffectAnimatorParams createFromParcel(Parcel parcel) {
            return new AEffectAnimatorParams(parcel);
        }
    };
    public int angle;
    public float beginValue;
    public float endValue;
    public String interpolator;
    public String name;
    public String type;

    public AEffectAnimatorParams() {
    }

    protected AEffectAnimatorParams(Parcel parcel) {
        this.name = parcel.readString();
        this.type = parcel.readString();
        this.angle = parcel.readInt();
        this.beginValue = parcel.readFloat();
        this.endValue = parcel.readFloat();
        this.interpolator = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.type);
        parcel.writeInt(this.angle);
        parcel.writeFloat(this.beginValue);
        parcel.writeFloat(this.endValue);
        parcel.writeString(this.interpolator);
    }
}
