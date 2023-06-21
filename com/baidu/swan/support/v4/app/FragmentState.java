package com.baidu.swan.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.baidu.tieba.up4;
import com.baidu.tieba.wp4;
/* loaded from: classes4.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();
    public final Bundle mArguments;
    public final String mClassName;
    public final int mContainerId;
    public final boolean mDetached;
    public final int mFragmentId;
    public final boolean mFromLayout;
    public final int mIndex;
    public Fragment mInstance;
    public final boolean mRetainInstance;
    public Bundle mSavedFragmentState;
    public final String mTag;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* loaded from: classes4.dex */
    public static class a implements Parcelable.Creator<FragmentState> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    }

    public FragmentState(Parcel parcel) {
        boolean z;
        boolean z2;
        this.mClassName = parcel.readString();
        this.mIndex = parcel.readInt();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.mFromLayout = z;
        this.mFragmentId = parcel.readInt();
        this.mContainerId = parcel.readInt();
        this.mTag = parcel.readString();
        if (parcel.readInt() != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mRetainInstance = z2;
        this.mDetached = parcel.readInt() != 0;
        this.mArguments = parcel.readBundle();
        this.mSavedFragmentState = parcel.readBundle();
    }

    public FragmentState(Fragment fragment) {
        this.mClassName = fragment.getClass().getName();
        this.mIndex = fragment.f;
        this.mFromLayout = fragment.o;
        this.mFragmentId = fragment.w;
        this.mContainerId = fragment.x;
        this.mTag = fragment.y;
        this.mRetainInstance = fragment.B;
        this.mDetached = fragment.A;
        this.mArguments = fragment.h;
    }

    public Fragment instantiate(up4 up4Var, Fragment fragment) {
        Fragment fragment2 = this.mInstance;
        if (fragment2 != null) {
            return fragment2;
        }
        Context context = up4Var.getContext();
        Bundle bundle = this.mArguments;
        if (bundle != null) {
            bundle.setClassLoader(context.getClassLoader());
        }
        this.mInstance = Fragment.j0(context, this.mClassName, this.mArguments);
        Bundle bundle2 = this.mSavedFragmentState;
        if (bundle2 != null) {
            bundle2.setClassLoader(context.getClassLoader());
            this.mInstance.d = this.mSavedFragmentState;
        }
        this.mInstance.l1(this.mIndex, fragment);
        Fragment fragment3 = this.mInstance;
        fragment3.o = this.mFromLayout;
        fragment3.q = true;
        fragment3.w = this.mFragmentId;
        fragment3.x = this.mContainerId;
        fragment3.y = this.mTag;
        fragment3.B = this.mRetainInstance;
        fragment3.A = this.mDetached;
        fragment3.s = up4Var.e;
        if (wp4.x) {
            Log.v("FragmentManager", "Instantiated fragment " + this.mInstance);
        }
        return this.mInstance;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mClassName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mFromLayout ? 1 : 0);
        parcel.writeInt(this.mFragmentId);
        parcel.writeInt(this.mContainerId);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.mRetainInstance ? 1 : 0);
        parcel.writeInt(this.mDetached ? 1 : 0);
        parcel.writeBundle(this.mArguments);
        parcel.writeBundle(this.mSavedFragmentState);
    }
}
