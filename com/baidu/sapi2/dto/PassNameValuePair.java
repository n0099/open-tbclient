package com.baidu.sapi2.dto;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
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
        public PassNameValuePair[] newArray(int i2) {
            return new PassNameValuePair[i2];
        }
    };
    public String name;
    public String value;

    public PassNameValuePair(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
        if (str == null ? passNameValuePair.name == null : str.equals(passNameValuePair.name)) {
            String str2 = this.value;
            String str3 = passNameValuePair.value;
            return str2 != null ? str2.equals(str3) : str3 == null;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.name);
        parcel.writeString(this.value);
    }

    public PassNameValuePair(Parcel parcel) {
        this.name = parcel.readString();
        this.value = parcel.readString();
    }
}
