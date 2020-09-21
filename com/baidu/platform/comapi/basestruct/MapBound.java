package com.baidu.platform.comapi.basestruct;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class MapBound implements Serializable {
    public Point leftBottomPt = new Point();
    public Point rightTopPt = new Point();

    public MapBound() {
    }

    public MapBound(int i, int i2, int i3, int i4) {
        setLeftBottomPt(i, i2);
        setRightTopPt(i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapBound) {
            MapBound mapBound = (MapBound) obj;
            if (this.leftBottomPt == null ? mapBound.leftBottomPt != null : !this.leftBottomPt.equals(mapBound.leftBottomPt)) {
                return false;
            }
            if (this.rightTopPt != null) {
                if (this.rightTopPt.equals(mapBound.rightTopPt)) {
                    return true;
                }
            } else if (mapBound.rightTopPt == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public Point getCenterPt() {
        return new Point((this.leftBottomPt.getIntX() + this.rightTopPt.getIntX()) / 2, (this.leftBottomPt.getIntY() + this.rightTopPt.getIntY()) / 2);
    }

    public int hashCode() {
        return ((this.leftBottomPt != null ? this.leftBottomPt.hashCode() : 0) * 31) + (this.rightTopPt != null ? this.rightTopPt.hashCode() : 0);
    }

    public void setLeftBottomPt(int i, int i2) {
        this.leftBottomPt.setTo(i, i2);
    }

    public void setLeftBottomPt(Point point) {
        this.leftBottomPt.setTo(point);
    }

    public void setRightTopPt(int i, int i2) {
        this.rightTopPt.setTo(i, i2);
    }

    public void setRightTopPt(Point point) {
        this.rightTopPt.setTo(point);
    }

    public String toQuery() {
        return String.format("(%d,%d;%d,%d)", Integer.valueOf(this.leftBottomPt.getIntX()), Integer.valueOf(this.leftBottomPt.getIntY()), Integer.valueOf(this.rightTopPt.getIntX()), Integer.valueOf(this.rightTopPt.getIntY()));
    }

    public String toString() {
        return "MapBound{leftBottomPt=" + this.leftBottomPt + ", rightTopPt=" + this.rightTopPt + '}';
    }
}
