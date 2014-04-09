package com.baidu.tbadk.core.voice.service;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
final class e implements Parcelable.Creator<Voice> {
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Voice createFromParcel(Parcel parcel) {
        Voice voice = new Voice();
        voice.a((int) parcel.readLong());
        voice.a(parcel.readString());
        return voice;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Voice[] newArray(int i) {
        return new Voice[i];
    }
}
