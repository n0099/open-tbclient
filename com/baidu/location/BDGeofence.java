package com.baidu.location;

import android.text.TextUtils;
/* loaded from: classes.dex */
public interface BDGeofence {
    public static final String COORD_TYPE_BD09 = "bd09";
    public static final String COORD_TYPE_BD09LL = "bd09ll";
    public static final String COORD_TYPE_GCJ = "gcj02";
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int RADIUS_TYPE_SMALL = 1;

    /* loaded from: classes.dex */
    public final class Builder {
        private int a;

        /* renamed from: for  reason: not valid java name */
        private double f1for;

        /* renamed from: int  reason: not valid java name */
        private String f3int;

        /* renamed from: try  reason: not valid java name */
        private double f5try;

        /* renamed from: do  reason: not valid java name */
        private String f0do = null;

        /* renamed from: new  reason: not valid java name */
        private boolean f4new = false;

        /* renamed from: if  reason: not valid java name */
        private long f2if = Long.MIN_VALUE;

        public BDGeofence build() {
            if (TextUtils.isEmpty(this.f0do)) {
                throw new IllegalArgumentException("BDGeofence name not set.");
            }
            if (this.f4new) {
                if (this.f2if == Long.MIN_VALUE) {
                    throw new IllegalArgumentException("BDGeofence Expiration not set.");
                }
                if (TextUtils.isEmpty(this.f3int)) {
                    throw new IllegalArgumentException("BDGeofence CoordType not set.");
                }
                return new at(this.f0do, this.f5try, this.f1for, this.a, this.f2if, this.f3int);
            }
            throw new IllegalArgumentException("BDGeofence region not set.");
        }

        public Builder setCircularRegion(double d, double d2, int i) {
            this.f4new = true;
            this.f5try = d;
            this.f1for = d2;
            this.a = 1;
            return this;
        }

        public Builder setCoordType(String str) {
            this.f3int = str;
            return this;
        }

        public Builder setExpirationDruation(long j) {
            if (j < 0) {
                this.f2if = -1L;
            } else {
                this.f2if = j;
            }
            return this;
        }

        public Builder setGeofenceId(String str) {
            this.f0do = str;
            return this;
        }
    }

    String getGeofenceId();
}
