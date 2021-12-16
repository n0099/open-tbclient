package com.baidu.ar.filter;

import android.graphics.Point;
import java.util.List;
/* loaded from: classes9.dex */
public interface IFilter {
    void clearAllFilter();

    void resetAllFilter();

    void setFilterStateListener(FilterStateListener filterStateListener);

    void updateFilter(FilterParam filterParam, float f2);

    void updateFilter(FilterParam filterParam, int i2);

    void updateFilter(FilterParam filterParam, String str);

    void updateFilter(FilterParam filterParam, List<Point> list);

    void updateFilter(FilterParam filterParam, float[] fArr);

    String updateFilterCase(String str);
}
