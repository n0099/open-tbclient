package com.baidu.sofire.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class CallArgs implements Parcelable {
    public static final Parcelable.Creator<CallArgs> CREATOR = new Parcelable.Creator<CallArgs>() { // from class: com.baidu.sofire.core.CallArgs.1
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CallArgs createFromParcel(Parcel parcel) {
            return new CallArgs(parcel);
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CallArgs[] newArray(int i) {
            return new CallArgs[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f11643a;

    /* renamed from: b  reason: collision with root package name */
    public int f11644b;

    /* renamed from: c  reason: collision with root package name */
    public String f11645c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f11646d;

    /* renamed from: e  reason: collision with root package name */
    public Object[] f11647e;

    /* renamed from: f  reason: collision with root package name */
    public Object f11648f;

    public CallArgs() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11643a);
        parcel.writeInt(this.f11644b);
        parcel.writeString(this.f11645c);
        parcel.writeArray(this.f11647e);
        parcel.writeArray(this.f11646d);
        parcel.writeValue(this.f11648f);
    }

    public CallArgs(Parcel parcel) {
        this.f11643a = parcel.readInt();
        this.f11644b = parcel.readInt();
        this.f11645c = parcel.readString();
        this.f11647e = parcel.readArray(CallArgs.class.getClassLoader());
        this.f11646d = parcel.readArray(CallArgs.class.getClassLoader());
        this.f11648f = parcel.readValue(CallArgs.class.getClassLoader());
    }
}
