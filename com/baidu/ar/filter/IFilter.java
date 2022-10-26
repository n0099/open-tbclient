package com.baidu.ar.filter;

import java.util.List;
/* loaded from: classes.dex */
public interface IFilter {
    void clearAllFilter();

    void resetAllFilter();

    void setFilterStateListener(FilterStateListener filterStateListener);

    void updateFilter(FilterParam filterParam, float f);

    void updateFilter(FilterParam filterParam, int i);

    void updateFilter(FilterParam filterParam, String str);

    void updateFilter(FilterParam filterParam, List list);

    void updateFilter(FilterParam filterParam, float[] fArr);

    String updateFilterCase(String str);
}
