package com.baidu.android.pushservice.pull.reportdata;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class EventData implements Parcelable {
    public static final Parcelable.Creator<EventData> CREATOR = new a();
    public String a;
    public String b;

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<EventData> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EventData createFromParcel(Parcel parcel) {
            return new EventData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EventData[] newArray(int i) {
            return new EventData[i];
        }
    }

    public EventData(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    public EventData(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
