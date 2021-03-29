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
        public final /* bridge */ /* synthetic */ CallArgs[] newArray(int i) {
            return new CallArgs[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f11644a;

    /* renamed from: b  reason: collision with root package name */
    public int f11645b;

    /* renamed from: c  reason: collision with root package name */
    public String f11646c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f11647d;

    /* renamed from: e  reason: collision with root package name */
    public Object[] f11648e;

    /* renamed from: f  reason: collision with root package name */
    public Object f11649f;

    public CallArgs() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11644a);
        parcel.writeInt(this.f11645b);
        parcel.writeString(this.f11646c);
        parcel.writeArray(this.f11648e);
        parcel.writeArray(this.f11647d);
        parcel.writeValue(this.f11649f);
    }

    public CallArgs(Parcel parcel) {
        this.f11644a = parcel.readInt();
        this.f11645b = parcel.readInt();
        this.f11646c = parcel.readString();
        this.f11648e = parcel.readArray(CallArgs.class.getClassLoader());
        this.f11647d = parcel.readArray(CallArgs.class.getClassLoader());
        this.f11649f = parcel.readValue(CallArgs.class.getClassLoader());
    }
}
