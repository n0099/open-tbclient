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
    public int f10199a;

    /* renamed from: b  reason: collision with root package name */
    public int f10200b;

    /* renamed from: c  reason: collision with root package name */
    public String f10201c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f10202d;

    /* renamed from: e  reason: collision with root package name */
    public Object[] f10203e;

    /* renamed from: f  reason: collision with root package name */
    public Object f10204f;

    public CallArgs() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f10199a);
        parcel.writeInt(this.f10200b);
        parcel.writeString(this.f10201c);
        parcel.writeArray(this.f10203e);
        parcel.writeArray(this.f10202d);
        parcel.writeValue(this.f10204f);
    }

    public CallArgs(Parcel parcel) {
        this.f10199a = parcel.readInt();
        this.f10200b = parcel.readInt();
        this.f10201c = parcel.readString();
        this.f10203e = parcel.readArray(CallArgs.class.getClassLoader());
        this.f10202d = parcel.readArray(CallArgs.class.getClassLoader());
        this.f10204f = parcel.readValue(CallArgs.class.getClassLoader());
    }
}
