package com.baidu.sofire.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes15.dex */
public class CallArgs implements Parcelable {
    public static final Parcelable.Creator<CallArgs> CREATOR = new Parcelable.Creator<CallArgs>() { // from class: com.baidu.sofire.core.CallArgs.1
        /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CallArgs[] newArray(int i) {
            return new CallArgs[i];
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CallArgs createFromParcel(Parcel parcel) {
            return new CallArgs(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f3599a;
    public int b;
    public String c;
    public Object[] d;
    public Object[] e;
    public Object f;

    public CallArgs() {
    }

    protected CallArgs(Parcel parcel) {
        this.f3599a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.e = parcel.readArray(CallArgs.class.getClassLoader());
        this.d = parcel.readArray(CallArgs.class.getClassLoader());
        this.f = parcel.readValue(CallArgs.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3599a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeArray(this.e);
        parcel.writeArray(this.d);
        parcel.writeValue(this.f);
    }
}
