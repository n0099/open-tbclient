package com.baidu.minivideo.effect.core.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes13.dex */
public class AEffectEntity implements Parcelable {
    public static final Parcelable.Creator<AEffectEntity> CREATOR = new Parcelable.Creator<AEffectEntity>() { // from class: com.baidu.minivideo.effect.core.entity.AEffectEntity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: do  reason: not valid java name */
        public AEffectEntity[] newArray(int i) {
            return new AEffectEntity[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: p */
        public AEffectEntity createFromParcel(Parcel parcel) {
            return new AEffectEntity(parcel);
        }
    };
    public List<AEffect> effectGroup;
    public String id;
    public String name;
    public String resourcePath;
    public String version;

    public AEffectEntity() {
    }

    protected AEffectEntity(Parcel parcel) {
        this.version = parcel.readString();
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.resourcePath = parcel.readString();
        this.effectGroup = parcel.createTypedArrayList(AEffect.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getFirstTranTime() {
        if (this.effectGroup == null || this.effectGroup.size() == 0) {
            return 0.0f;
        }
        for (AEffect aEffect : this.effectGroup) {
            if (aEffect != null && aEffect.animGroup != null && aEffect.animGroup.size() > 0) {
                return aEffect.animGroup.get(0).transitionDuration;
            }
        }
        return 0.0f;
    }

    public boolean isInTranTime(int i, float f) {
        if (this.effectGroup == null || this.effectGroup.size() == 0) {
            return false;
        }
        for (AEffect aEffect : this.effectGroup) {
            if (aEffect != null && aEffect.animGroup != null && aEffect.animGroup.size() > i && f < aEffect.animGroup.get(i).transitionDuration) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.version);
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.resourcePath);
        parcel.writeTypedList(this.effectGroup);
    }
}
