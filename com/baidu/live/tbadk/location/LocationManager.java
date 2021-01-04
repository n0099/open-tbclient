package com.baidu.live.tbadk.location;

import com.baidu.live.tbadk.location.interfaces.ILocation;
import com.baidu.live.tbadk.location.interfaces.ILocationBuilder;
/* loaded from: classes11.dex */
public class LocationManager {
    private ILocation mLocation;
    private ILocationBuilder mLocationBuilder;

    public static LocationManager getInstance() {
        return InstanceHolder.sInst;
    }

    private LocationManager() {
    }

    public void init(ILocationBuilder iLocationBuilder) {
        this.mLocationBuilder = iLocationBuilder;
        build();
    }

    public ILocation buildLocation() {
        if (this.mLocation != null) {
            return this.mLocation;
        }
        build();
        return this.mLocation;
    }

    private void build() {
        if (this.mLocationBuilder != null) {
            this.mLocation = this.mLocationBuilder.build();
        }
    }

    /* loaded from: classes11.dex */
    public static class InstanceHolder {
        private static final LocationManager sInst = new LocationManager();
    }
}
