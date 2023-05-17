package com.baidu.sapi2.dto;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class PassNameValuePair implements Parcelable {
    public static final Parcelable.Creator<PassNameValuePair> CREATOR = new Parcelable.Creator<PassNameValuePair>() { // from class: com.baidu.sapi2.dto.PassNameValuePair.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PassNameValuePair createFromParcel(Parcel parcel) {
            return new PassNameValuePair(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PassNameValuePair[] newArray(int i) {
            return new PassNameValuePair[i];
        }
    };
    public String name;
    public String value;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int i;
        String str = this.name;
        int i2 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i3 = i * 31;
        String str2 = this.value;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return i3 + i2;
    }

    public PassNameValuePair(Parcel parcel) {
        this.name = parcel.readString();
        this.value = parcel.readString();
    }

    public PassNameValuePair(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PassNameValuePair.class != obj.getClass()) {
            return false;
        }
        PassNameValuePair passNameValuePair = (PassNameValuePair) obj;
        String str = this.name;
        if (str == null ? passNameValuePair.name != null : !str.equals(passNameValuePair.name)) {
            return false;
        }
        String str2 = this.value;
        String str3 = passNameValuePair.value;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }
}
