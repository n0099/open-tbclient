package com.baidu.pyramid.runtime.service;

import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public final class ServiceReference {
    public final String mName;
    public final String mNameSpace;

    public ServiceReference(@NonNull String str, @NonNull String str2) {
        if (str != null && str2 != null) {
            this.mNameSpace = str;
            this.mName = str2;
            return;
        }
        throw new NullPointerException("namespace & name can not be null");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ServiceReference.class != obj.getClass()) {
            return false;
        }
        ServiceReference serviceReference = (ServiceReference) obj;
        if (this.mNameSpace.equals(serviceReference.mNameSpace)) {
            return this.mName.equals(serviceReference.mName);
        }
        return false;
    }

    public int hashCode() {
        return (this.mNameSpace.hashCode() * 31) + this.mName.hashCode();
    }

    public String toString() {
        return "ServiceReference{mNameSpace='" + this.mNameSpace + "', mName='" + this.mName + "'}";
    }
}
