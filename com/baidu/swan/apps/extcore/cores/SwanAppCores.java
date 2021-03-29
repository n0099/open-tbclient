package com.baidu.swan.apps.extcore.cores;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes2.dex */
public class SwanAppCores extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanAppCores> CREATOR = new a();
    public ExtensionCore mExtensionCore;
    public SwanCoreVersion mSwanCoreVersion;

    /* loaded from: classes2.dex */
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

    public /* synthetic */ SwanAppCores(Parcel parcel, a aVar) {
        this(parcel);
    }

    public ExtensionCore a() {
        return this.mExtensionCore;
    }

    public SwanCoreVersion b() {
        return this.mSwanCoreVersion;
    }

    public void c(ExtensionCore extensionCore) {
        this.mExtensionCore = extensionCore;
    }

    public void d(SwanCoreVersion swanCoreVersion) {
        this.mSwanCoreVersion = swanCoreVersion;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SwanAppCores{mSwanCoreVersion=" + this.mSwanCoreVersion + ", mExtensionCore=" + this.mExtensionCore + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSwanCoreVersion, i);
        parcel.writeParcelable(this.mExtensionCore, i);
    }

    public SwanAppCores() {
    }

    public SwanAppCores(Parcel parcel) {
        this.mSwanCoreVersion = (SwanCoreVersion) parcel.readParcelable(SwanCoreVersion.class.getClassLoader());
        this.mExtensionCore = (ExtensionCore) parcel.readParcelable(ExtensionCore.class.getClassLoader());
    }
}
