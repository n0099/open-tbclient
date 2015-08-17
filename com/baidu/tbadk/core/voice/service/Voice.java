package com.baidu.tbadk.core.voice.service;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class Voice implements Parcelable {
    public static final Parcelable.Creator<Voice> CREATOR = new j();
    private int duration;
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.duration);
        parcel.writeString(this.name);
    }
}
