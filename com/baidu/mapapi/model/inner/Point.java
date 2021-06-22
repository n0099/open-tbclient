package com.baidu.mapapi.model.inner;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class Point implements Serializable {
    public int x;
    public int y;

    public Point() {
    }

    public Point(int i2, int i3) {
        this.x = i2;
        this.y = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Point.class == obj.getClass()) {
            Point point = (Point) obj;
            return this.x == point.x && this.y == point.y;
        }
        return false;
    }

    public int getmPtx() {
        return this.x;
    }

    public int getmPty() {
        return this.y;
    }

    public int hashCode() {
        return ((this.x + 31) * 31) + this.y;
    }

    public void setmPtx(int i2) {
        this.x = i2;
    }

    public void setmPty(int i2) {
        this.y = i2;
    }

    public String toString() {
        return "Point [x=" + this.x + ", y=" + this.y + PreferencesUtil.RIGHT_MOUNT;
    }
}
