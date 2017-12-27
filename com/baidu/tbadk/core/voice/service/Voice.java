package com.baidu.tbadk.core.voice.service;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class Voice implements Parcelable {
    public static final Parcelable.Creator<Voice> CREATOR = new Parcelable.Creator<Voice>() { // from class: com.baidu.tbadk.core.voice.service.Voice.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: gO */
        public Voice[] newArray(int i) {
            return new Voice[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: w */
        public Voice createFromParcel(Parcel parcel) {
            Voice voice = new Voice();
            voice.setDuration((int) parcel.readLong());
            voice.setName(parcel.readString());
            return voice;
        }
    };
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
