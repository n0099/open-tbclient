package com.baidu.tbadk.core.voice.service;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
class j implements Parcelable.Creator<Voice> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: dx */
    public Voice[] newArray(int i) {
        return new Voice[i];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: d */
    public Voice createFromParcel(Parcel parcel) {
        Voice voice = new Voice();
        voice.setDuration((int) parcel.readLong());
        voice.setName(parcel.readString());
        return voice;
    }
}
