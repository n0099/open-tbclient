package com.baidu.searchbox.aps.invoker.holder;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class SerializableHolder implements Parcelable {
    public static final Parcelable.Creator<SerializableHolder> CREATOR = new Parcelable.Creator<SerializableHolder>() { // from class: com.baidu.searchbox.aps.invoker.holder.SerializableHolder.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SerializableHolder createFromParcel(Parcel parcel) {
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SerializableHolder[] newArray(int i) {
            return new SerializableHolder[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }
}
