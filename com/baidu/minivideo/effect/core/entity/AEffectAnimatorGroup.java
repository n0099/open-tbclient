package com.baidu.minivideo.effect.core.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes12.dex */
public class AEffectAnimatorGroup implements Parcelable {
    public static final Parcelable.Creator<AEffectAnimatorGroup> CREATOR = new Parcelable.Creator<AEffectAnimatorGroup>() { // from class: com.baidu.minivideo.effect.core.entity.AEffectAnimatorGroup.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: cW */
        public AEffectAnimatorGroup[] newArray(int i) {
            return new AEffectAnimatorGroup[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: n */
        public AEffectAnimatorGroup createFromParcel(Parcel parcel) {
            return new AEffectAnimatorGroup(parcel);
        }
    };
    public int priority;
    public float sceneDuration;
    public List<AEffectOneAnimator> sceneGroup;
    public float transitionDuration;
    public List<AEffectOneAnimator> transitionGroup;

    public AEffectAnimatorGroup() {
    }

    protected AEffectAnimatorGroup(Parcel parcel) {
        this.priority = parcel.readInt();
        this.transitionDuration = parcel.readFloat();
        this.sceneDuration = parcel.readFloat();
        this.transitionGroup = parcel.createTypedArrayList(AEffectOneAnimator.CREATOR);
        this.sceneGroup = parcel.createTypedArrayList(AEffectOneAnimator.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.priority);
        parcel.writeFloat(this.transitionDuration);
        parcel.writeFloat(this.sceneDuration);
        parcel.writeTypedList(this.transitionGroup);
        parcel.writeTypedList(this.sceneGroup);
    }
}
