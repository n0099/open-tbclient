package com.baidu.searchbox.logsystem.logsys;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class LogExtra implements Parcelable {
    public static final Parcelable.Creator<LogExtra> CREATOR = new Parcelable.Creator<LogExtra>() { // from class: com.baidu.searchbox.logsystem.logsys.LogExtra.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LogExtra createFromParcel(Parcel parcel) {
            return new LogExtra(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LogExtra[] newArray(int i) {
            if (i <= 0) {
                return null;
            }
            return new LogExtra[i];
        }
    };
    public String mCrashThreadName;
    public String mCrashThreadPriority;
    public String mCrashTime;
    public String mForeground;
    public String mHeapMem;
    public String mJSONAttach;
    public String mLaunchTime;
    public String mPSS;
    public String mPage;
    public String mProcessLifeTime;
    public int mSysLowMem;
    public String mSysMem;
    public String mTraceID;
    public String mVSSRSS;

    public static void init() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LogExtra() {
        this.mPage = null;
        this.mCrashTime = null;
        this.mLaunchTime = null;
        this.mProcessLifeTime = null;
        this.mCrashThreadName = null;
        this.mCrashThreadPriority = null;
        this.mForeground = null;
        this.mTraceID = null;
        this.mJSONAttach = null;
        this.mHeapMem = null;
        this.mVSSRSS = null;
        this.mPSS = null;
        this.mSysMem = null;
        this.mSysLowMem = 1;
    }

    public LogExtra(Parcel parcel) {
        this.mPage = null;
        this.mCrashTime = null;
        this.mLaunchTime = null;
        this.mProcessLifeTime = null;
        this.mCrashThreadName = null;
        this.mCrashThreadPriority = null;
        this.mForeground = null;
        this.mTraceID = null;
        this.mJSONAttach = null;
        this.mHeapMem = null;
        this.mVSSRSS = null;
        this.mPSS = null;
        this.mSysMem = null;
        this.mSysLowMem = 1;
        this.mPage = parcel.readString();
        this.mCrashTime = parcel.readString();
        this.mLaunchTime = parcel.readString();
        this.mProcessLifeTime = parcel.readString();
        this.mCrashThreadName = parcel.readString();
        this.mCrashThreadPriority = parcel.readString();
        this.mForeground = parcel.readString();
        this.mTraceID = parcel.readString();
        this.mJSONAttach = parcel.readString();
        this.mHeapMem = parcel.readString();
        this.mVSSRSS = parcel.readString();
        this.mPSS = parcel.readString();
        this.mSysMem = parcel.readString();
        this.mSysLowMem = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPage);
        parcel.writeString(this.mCrashTime);
        parcel.writeString(this.mLaunchTime);
        parcel.writeString(this.mProcessLifeTime);
        parcel.writeString(this.mCrashThreadName);
        parcel.writeString(this.mCrashThreadPriority);
        parcel.writeString(this.mForeground);
        parcel.writeString(this.mTraceID);
        parcel.writeString(this.mJSONAttach);
        parcel.writeString(this.mHeapMem);
        parcel.writeString(this.mVSSRSS);
        parcel.writeString(this.mPSS);
        parcel.writeString(this.mSysMem);
        parcel.writeInt(this.mSysLowMem);
    }
}
