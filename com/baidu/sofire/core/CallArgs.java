package com.baidu.sofire.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class CallArgs implements Parcelable {
    public static final Parcelable.Creator<CallArgs> CREATOR = new Parcelable.Creator<CallArgs>() { // from class: com.baidu.sofire.core.CallArgs.1
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CallArgs createFromParcel(Parcel parcel) {
            return new CallArgs(parcel);
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CallArgs[] newArray(int i2) {
            return new CallArgs[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f11132a;

    /* renamed from: b  reason: collision with root package name */
    public int f11133b;

    /* renamed from: c  reason: collision with root package name */
    public String f11134c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f11135d;

    /* renamed from: e  reason: collision with root package name */
    public Object[] f11136e;

    /* renamed from: f  reason: collision with root package name */
    public Object f11137f;

    public CallArgs() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f11132a);
        parcel.writeInt(this.f11133b);
        parcel.writeString(this.f11134c);
        parcel.writeArray(this.f11136e);
        parcel.writeArray(this.f11135d);
        parcel.writeValue(this.f11137f);
    }

    public CallArgs(Parcel parcel) {
        this.f11132a = parcel.readInt();
        this.f11133b = parcel.readInt();
        this.f11134c = parcel.readString();
        this.f11136e = parcel.readArray(CallArgs.class.getClassLoader());
        this.f11135d = parcel.readArray(CallArgs.class.getClassLoader());
        this.f11137f = parcel.readValue(CallArgs.class.getClassLoader());
    }
}
