package com.baidu.searchbox.ui.imagezoom;
/* loaded from: classes4.dex */
public class Cubic implements Easing {
    @Override // com.baidu.searchbox.ui.imagezoom.Easing
    public double easeIn(double d, double d2, double d3, double d4) {
        double d5 = d / d4;
        return (d3 * d5 * d5 * d5) + d2;
    }

    @Override // com.baidu.searchbox.ui.imagezoom.Easing
    public double easeInOut(double d, double d2, double d3, double d4) {
        double d5;
        double d6 = d / (d4 / 2.0d);
        if (d6 < 1.0d) {
            d5 = (d3 / 2.0d) * d6 * d6 * d6;
        } else {
            double d7 = d6 - 2.0d;
            d5 = (d3 / 2.0d) * ((d7 * d7 * d7) + 2.0d);
        }
        return d5 + d2;
    }

    @Override // com.baidu.searchbox.ui.imagezoom.Easing
    public double easeOut(double d, double d2, double d3, double d4) {
        double d5 = (d / d4) - 1.0d;
        return (d3 * ((d5 * d5 * d5) + 1.0d)) + d2;
    }
}
