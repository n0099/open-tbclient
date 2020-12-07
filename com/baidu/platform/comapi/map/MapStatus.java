package com.baidu.platform.comapi.map;

import java.io.Serializable;
/* loaded from: classes26.dex */
public class MapStatus implements Serializable {
    public int animationTime;
    public int animationType;
    public boolean bOverlookSpringback;
    public boolean bfpp;
    public double centerPtX;
    public double centerPtY;
    public double centerPtZ;
    public GeoBound geoRound;
    public int hasAnimation;
    public boolean isBirdEye;
    public float level;
    public int minOverlooking;
    public int overlooking;
    public String panoId;
    public float roadOffsetX;
    public float roadOffsetY;
    public int rotation;
    public int streetExt;
    public float streetIndicateAngle;
    public WinRound winRound;
    public float xOffset;
    public float yOffset;

    /* loaded from: classes26.dex */
    public static class GeoBound implements Serializable {
        public long left = 0;
        public long right = 0;
        public long top = 0;
        public long bottom = 0;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof GeoBound)) {
                return false;
            }
            GeoBound geoBound = (GeoBound) obj;
            if (this.bottom == geoBound.bottom && this.left == geoBound.left && this.right == geoBound.right) {
                return this.top == geoBound.top;
            }
            return false;
        }

        public int hashCode() {
            return ((((((((int) (this.bottom ^ (this.bottom >>> 32))) + 31) * 31) + ((int) (this.left ^ (this.left >>> 32)))) * 31) + ((int) (this.right ^ (this.right >>> 32)))) * 31) + ((int) (this.top ^ (this.top >>> 32)));
        }
    }

    /* loaded from: classes26.dex */
    public static class WinRound implements Serializable {
        public int left = 0;
        public int right = 0;
        public int top = 0;
        public int bottom = 0;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof WinRound)) {
                return false;
            }
            WinRound winRound = (WinRound) obj;
            if (this.bottom == winRound.bottom && this.left == winRound.left && this.right == winRound.right) {
                return this.top == winRound.top;
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.bottom + 31) * 31) + this.left) * 31) + this.right) * 31) + this.top;
        }
    }

    public MapStatus() {
        this.animationType = 0;
        this.level = -1.0f;
        this.rotation = -1;
        this.overlooking = -1;
        this.centerPtX = -1.0d;
        this.centerPtY = -1.0d;
        this.centerPtZ = 0.0d;
        this.xOffset = 0.0f;
        this.yOffset = 0.0f;
        this.winRound = new WinRound();
        this.geoRound = new GeoBound();
        this.bfpp = false;
        this.panoId = "";
        this.streetIndicateAngle = 0.0f;
        this.isBirdEye = false;
        this.streetExt = 0;
        this.roadOffsetX = 0.0f;
        this.roadOffsetY = 0.0f;
        this.bOverlookSpringback = false;
        this.minOverlooking = -1;
    }

    public MapStatus(MapStatus mapStatus) {
        this.animationType = 0;
        this.level = mapStatus.level;
        this.rotation = mapStatus.rotation;
        this.overlooking = mapStatus.overlooking;
        this.centerPtX = mapStatus.centerPtX;
        this.centerPtY = mapStatus.centerPtY;
        this.centerPtZ = mapStatus.centerPtZ;
        this.xOffset = mapStatus.xOffset;
        this.yOffset = mapStatus.yOffset;
        this.winRound = mapStatus.winRound;
        this.geoRound = mapStatus.geoRound;
        this.bfpp = mapStatus.bfpp;
        this.panoId = mapStatus.panoId;
        this.streetIndicateAngle = mapStatus.streetIndicateAngle;
        this.isBirdEye = mapStatus.isBirdEye;
        this.streetExt = mapStatus.streetExt;
        this.roadOffsetX = mapStatus.roadOffsetX;
        this.roadOffsetY = mapStatus.roadOffsetY;
        this.bOverlookSpringback = mapStatus.bOverlookSpringback;
        this.minOverlooking = mapStatus.minOverlooking;
    }

    public boolean equals(Object obj) {
        if (obj instanceof MapStatus) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                MapStatus mapStatus = (MapStatus) obj;
                if (this.centerPtX == mapStatus.centerPtX && this.centerPtY == mapStatus.centerPtY && this.centerPtZ == mapStatus.centerPtZ && this.bfpp == mapStatus.bfpp) {
                    if (this.geoRound == null) {
                        if (mapStatus.geoRound != null) {
                            return false;
                        }
                    } else if (!this.geoRound.equals(mapStatus.geoRound)) {
                        return false;
                    }
                    if (Float.floatToIntBits(this.level) == Float.floatToIntBits(mapStatus.level) && this.overlooking == mapStatus.overlooking && this.rotation == mapStatus.rotation && this.yOffset == mapStatus.yOffset && this.xOffset == mapStatus.xOffset) {
                        if (this.winRound == null) {
                            if (mapStatus.winRound != null) {
                                return false;
                            }
                        } else if (!this.winRound.equals(mapStatus.winRound)) {
                            return false;
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (int) ((this.winRound != null ? this.winRound.hashCode() : 0) + (((((((((((((((((1.0d * 31.0d) + this.centerPtX) * 31.0d) + this.centerPtY) * 31.0d) + this.centerPtZ) * 31.0d) + (this.bfpp ? 1 : 0)) * 31.0d) + (this.geoRound == null ? 0 : this.geoRound.hashCode())) * 31.0d) + Float.floatToIntBits(this.level)) * 31.0d) + this.overlooking) * 31.0d) + this.rotation) * 31.0d));
    }

    public String toString() {
        return "MapStatus{level=" + this.level + ", rotation=" + this.rotation + ", overlooking=" + this.overlooking + ", centerPtX=" + this.centerPtX + ", centerPtY=" + this.centerPtY + ", centerPtZ=" + this.centerPtZ + ", winRound=" + this.winRound + ", geoRound=" + this.geoRound + ", xOffset=" + this.xOffset + ", yOffset=" + this.yOffset + ", bfpp=" + this.bfpp + ", panoId='" + this.panoId + "', streetIndicateAngle=" + this.streetIndicateAngle + ", isBirdEye=" + this.isBirdEye + ", streetExt=" + this.streetExt + ", roadOffsetX=" + this.roadOffsetX + ", roadOffsetY=" + this.roadOffsetY + '}';
    }
}
