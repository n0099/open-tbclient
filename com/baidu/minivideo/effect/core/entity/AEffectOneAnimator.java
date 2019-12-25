package com.baidu.minivideo.effect.core.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes11.dex */
public class AEffectOneAnimator implements Parcelable {
    public static final String ANIM_TYPE_ANIMATORVALUE = "animatorValue";
    public static final String ANIM_TYPE_VALUE = "value";
    public static final Parcelable.Creator<AEffectOneAnimator> CREATOR = new Parcelable.Creator<AEffectOneAnimator>() { // from class: com.baidu.minivideo.effect.core.entity.AEffectOneAnimator.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: cY */
        public AEffectOneAnimator[] newArray(int i) {
            return new AEffectOneAnimator[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: q */
        public AEffectOneAnimator createFromParcel(Parcel parcel) {
            return new AEffectOneAnimator(parcel);
        }
    };
    public List<AEffectAnimatorParams> animParams;
    public float beginTime;
    public float endTime;

    public AEffectOneAnimator() {
    }

    protected AEffectOneAnimator(Parcel parcel) {
        this.beginTime = parcel.readFloat();
        this.endTime = parcel.readFloat();
        this.animParams = parcel.createTypedArrayList(AEffectAnimatorParams.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.beginTime);
        parcel.writeFloat(this.endTime);
        parcel.writeTypedList(this.animParams);
    }
}
