package com.baidu.pyramid.runtime.service;

import android.support.annotation.NonNull;
/* loaded from: classes12.dex */
public final class d {
    private final String aRz;
    private final String mName;

    public d(@NonNull String str, @NonNull String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("namespace & name can not be null");
        }
        this.aRz = str;
        this.mName = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.aRz.equals(dVar.aRz)) {
            return this.mName.equals(dVar.mName);
        }
        return false;
    }

    public int hashCode() {
        return (this.aRz.hashCode() * 31) + this.mName.hashCode();
    }

    public String toString() {
        return "ServiceReference{mNameSpace='" + this.aRz + "', mName='" + this.mName + "'}";
    }
}
