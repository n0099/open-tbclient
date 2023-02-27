package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;
import java.util.List;
/* loaded from: classes2.dex */
public class GradientLineOptions extends OverlayOptions {
    public List<LatLng> a;
    public List<Integer> b;
    public List<Integer> c;
    public int d = 5;
    public boolean e = true;
    public LineDirectionCross180 f = LineDirectionCross180.NONE;

    /* loaded from: classes2.dex */
    public enum LineDirectionCross180 {
        NONE,
        FROM_EAST_TO_WEST,
        FROM_WEST_TO_EAST
    }

    public List<Integer> getColors() {
        return this.c;
    }

    public List<Integer> getIndexs() {
        return this.b;
    }

    public LineDirectionCross180 getLineDirectionCross180() {
        return this.f;
    }

    public List<LatLng> getPoints() {
        return this.a;
    }

    public int getWidth() {
        return this.d;
    }

    public boolean isVisible() {
        return this.e;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        GradientLine gradientLine = new GradientLine();
        gradientLine.d = this.d;
        gradientLine.H = this.e;
        gradientLine.e = this.f;
        List<LatLng> list = this.a;
        if (list != null && list.size() >= 2) {
            gradientLine.a = this.a;
            List<Integer> list2 = this.c;
            if (list2 != null) {
                if (list2.size() != 0) {
                    int[] iArr = new int[this.c.size()];
                    int i = 0;
                    int i2 = 0;
                    for (Integer num : this.c) {
                        iArr[i2] = num.intValue();
                        i2++;
                    }
                    gradientLine.c = iArr;
                    List<Integer> list3 = this.b;
                    if (list3 != null) {
                        if (list3.size() != 0) {
                            int[] iArr2 = new int[this.b.size()];
                            for (Integer num2 : this.b) {
                                iArr2[i] = num2.intValue();
                                i++;
                            }
                            gradientLine.b = iArr2;
                            return gradientLine;
                        }
                        throw new IllegalStateException("BDMapSDKException: Indexs list size can not be Equal to zero");
                    }
                    throw new IllegalStateException("BDMapSDKException: Indexs list can not be null");
                }
                throw new IllegalStateException("BDMapSDKException: colors list size can not be Equal to zero");
            }
            throw new IllegalStateException("BDMapSDKException: colors list can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: when you add GradientLine, you must at least supply 2 points");
    }

    public GradientLineOptions setColorIndex(List<Integer> list) {
        if (list != null) {
            if (!list.contains(null)) {
                if (list.size() != 0) {
                    this.b = list;
                    return this;
                }
                throw new IllegalStateException("BDMapSDKException: indexs list size can not be Equal to zero");
            }
            throw new IllegalArgumentException("BDMapSDKException: indexs list can not contains null");
        }
        throw new IllegalArgumentException("BDMapSDKException: indexs list can not be null");
    }

    public GradientLineOptions setColorsValues(List<Integer> list) {
        if (list != null) {
            if (!list.contains(null)) {
                if (list.size() != 0) {
                    this.c = list;
                    return this;
                }
                throw new IllegalStateException("BDMapSDKException: colors list list size can not be Equal to zero");
            }
            throw new IllegalArgumentException("BDMapSDKException: colors list can not contains null");
        }
        throw new IllegalArgumentException("BDMapSDKException: colors list can not be null");
    }

    public GradientLineOptions setLineDirectionCross180(LineDirectionCross180 lineDirectionCross180) {
        this.f = lineDirectionCross180;
        return this;
    }

    public GradientLineOptions setPoints(List<LatLng> list) {
        if (list != null) {
            if (list.size() >= 2) {
                if (!list.contains(null)) {
                    this.a = list;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public GradientLineOptions setWidth(int i) {
        if (i > 0) {
            this.d = i;
        }
        return this;
    }

    public GradientLineOptions visible(boolean z) {
        this.e = z;
        return this;
    }
}
