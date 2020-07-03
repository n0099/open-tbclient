package com.baidu.swan.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() { // from class: com.baidu.swan.support.v4.app.FragmentState.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: F */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: jD */
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    };
    Fragment dtc;
    final Bundle mArguments;
    final String mClassName;
    final int mContainerId;
    final boolean mDetached;
    final int mFragmentId;
    final boolean mFromLayout;
    final int mIndex;
    final boolean mRetainInstance;
    Bundle mSavedFragmentState;
    final String mTag;

    public FragmentState(Fragment fragment) {
        this.mClassName = fragment.getClass().getName();
        this.mIndex = fragment.mIndex;
        this.mFromLayout = fragment.mFromLayout;
        this.mFragmentId = fragment.mFragmentId;
        this.mContainerId = fragment.mContainerId;
        this.mTag = fragment.mTag;
        this.mRetainInstance = fragment.mRetainInstance;
        this.mDetached = fragment.mDetached;
        this.mArguments = fragment.mArguments;
    }

    public FragmentState(Parcel parcel) {
        this.mClassName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mFromLayout = parcel.readInt() != 0;
        this.mFragmentId = parcel.readInt();
        this.mContainerId = parcel.readInt();
        this.mTag = parcel.readString();
        this.mRetainInstance = parcel.readInt() != 0;
        this.mDetached = parcel.readInt() != 0;
        this.mArguments = parcel.readBundle();
        this.mSavedFragmentState = parcel.readBundle();
    }

    public Fragment a(j jVar, Fragment fragment) {
        if (this.dtc != null) {
            return this.dtc;
        }
        Context context = jVar.getContext();
        if (this.mArguments != null) {
            this.mArguments.setClassLoader(context.getClassLoader());
        }
        this.dtc = Fragment.b(context, this.mClassName, this.mArguments);
        if (this.mSavedFragmentState != null) {
            this.mSavedFragmentState.setClassLoader(context.getClassLoader());
            this.dtc.mSavedFragmentState = this.mSavedFragmentState;
        }
        this.dtc.b(this.mIndex, fragment);
        this.dtc.mFromLayout = this.mFromLayout;
        this.dtc.mRestored = true;
        this.dtc.mFragmentId = this.mFragmentId;
        this.dtc.mContainerId = this.mContainerId;
        this.dtc.mTag = this.mTag;
        this.dtc.mRetainInstance = this.mRetainInstance;
        this.dtc.mDetached = this.mDetached;
        this.dtc.dsA = jVar.dsA;
        if (l.DEBUG) {
            Log.v("FragmentManager", "Instantiated fragment " + this.dtc);
        }
        return this.dtc;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
