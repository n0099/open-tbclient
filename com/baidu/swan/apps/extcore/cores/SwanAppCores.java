package com.baidu.swan.apps.extcore.cores;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes3.dex */
public class SwanAppCores extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanAppCores> CREATOR = new a();
    public ExtensionCore mExtensionCore;
    public SwanCoreVersion mSwanCoreVersion;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SwanAppCores() {
    }

    public ExtensionCore getExtensionCore() {
        return this.mExtensionCore;
    }

    public SwanCoreVersion getSwanCoreVersion() {
        return this.mSwanCoreVersion;
    }

    public String toString() {
        return "SwanAppCores{mSwanCoreVersion=" + this.mSwanCoreVersion + ", mExtensionCore=" + this.mExtensionCore + '}';
    }

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<SwanAppCores> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SwanAppCores createFromParcel(Parcel parcel) {
            return new SwanAppCores(parcel, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SwanAppCores[] newArray(int i) {
            return new SwanAppCores[i];
        }
    }

    public SwanAppCores(Parcel parcel) {
        this.mSwanCoreVersion = (SwanCoreVersion) parcel.readParcelable(SwanCoreVersion.class.getClassLoader());
        this.mExtensionCore = (ExtensionCore) parcel.readParcelable(ExtensionCore.class.getClassLoader());
    }

    public void setExtensionCore(ExtensionCore extensionCore) {
        this.mExtensionCore = extensionCore;
    }

    public void setSwanCoreVersion(SwanCoreVersion swanCoreVersion) {
        this.mSwanCoreVersion = swanCoreVersion;
    }

    public /* synthetic */ SwanAppCores(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSwanCoreVersion, i);
        parcel.writeParcelable(this.mExtensionCore, i);
    }
}
