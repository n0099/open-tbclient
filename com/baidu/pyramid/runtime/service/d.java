package com.baidu.pyramid.runtime.service;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public final class d {
    private final String cka;
    private final String mName;

    public d(@NonNull String str, @NonNull String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("namespace & name can not be null");
        }
        this.cka = str;
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
        if (this.cka.equals(dVar.cka)) {
            return this.mName.equals(dVar.mName);
        }
        return false;
    }

    public int hashCode() {
        return (this.cka.hashCode() * 31) + this.mName.hashCode();
    }

    public String toString() {
        return "ServiceReference{mNameSpace='" + this.cka + "', mName='" + this.mName + "'}";
    }
}
