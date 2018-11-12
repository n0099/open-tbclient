package com.baidu.searchbox.ng.ai.apps.impl.map.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsIPCData;
/* loaded from: classes4.dex */
public class BdMapLibApsInfo extends AiAppsIPCData {
    public static final Parcelable.Creator<BdMapLibApsInfo> CREATOR = new Parcelable.Creator<BdMapLibApsInfo>() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.data.BdMapLibApsInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BdMapLibApsInfo createFromParcel(Parcel parcel) {
            return new BdMapLibApsInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BdMapLibApsInfo[] newArray(int i) {
            return new BdMapLibApsInfo[i];
        }
    };
    public static final int RESULT_CODE_DOWNLOADING = 2005;
    public static final int RESULT_CODE_FAILED = 2002;
    public static final int RESULT_CODE_NO_PACKAGE = 2003;
    public static final int RESULT_CODE_START = 2000;
    public static final int RESULT_CODE_SUCCESS = 2001;
    public static final int RESULT_CODE_VERSION_MISMATCH = 2004;
    public int mAiAppProcessId;
    public int mCallback;
    public boolean mIsMainProcess;
    public int mResultCode;

    public BdMapLibApsInfo() {
        this.mAiAppProcessId = -1;
    }

    public boolean isMainProcess() {
        return this.mIsMainProcess;
    }

    public BdMapLibApsInfo(Parcel parcel) {
        this.mAiAppProcessId = -1;
        this.mAiAppProcessId = parcel.readInt();
        this.mResultCode = parcel.readInt();
        this.mCallback = parcel.readInt();
        this.mIsMainProcess = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAiAppProcessId);
        parcel.writeInt(this.mResultCode);
        parcel.writeInt(this.mCallback);
        parcel.writeInt(this.mIsMainProcess ? 1 : 0);
    }

    public String toString() {
        return "BdMapLibApsInfo{mAiAppProcessId=" + this.mAiAppProcessId + ", mResultCode=" + this.mResultCode + ", callback=" + this.mCallback + ", mIsMainProcess" + this.mIsMainProcess + '}';
    }
}
