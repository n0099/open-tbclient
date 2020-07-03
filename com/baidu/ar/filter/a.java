package com.baidu.ar.filter;

import android.text.TextUtils;
import com.baidu.ar.DefaultParams;
import com.baidu.ar.arrender.h;
import com.baidu.ar.arrender.j;
import com.baidu.ar.f.b;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private DefaultParams d;
    private String mCasePath;
    private j pf;
    private FilterStateListener pg;
    private HashMap<FilterNode, Boolean> ph = new HashMap<>();
    private HashMap<FilterNode, Boolean> pi = new HashMap<>();
    private HashMap<FilterNode, Boolean> pj = new HashMap<>();

    public a(DefaultParams defaultParams) {
        this.d = defaultParams;
        if (this.ph != null) {
            this.ph.put(FilterNode.lutFilter, false);
            this.ph.put(FilterNode.skinFilter, false);
            this.ph.put(FilterNode.faceFilter, false);
            this.ph.put(FilterNode.makeupFilter, false);
        }
        if (this.pi != null) {
            this.pi.put(FilterNode.lutFilter, true);
            this.pi.put(FilterNode.skinFilter, Boolean.valueOf(this.d.isUseBeautyFilter()));
            this.pi.put(FilterNode.faceFilter, Boolean.valueOf(this.d.isUseFaceFilter()));
            this.pi.put(FilterNode.makeupFilter, Boolean.valueOf(this.d.isUseMakeupFilter()));
        }
    }

    private void G(int i) {
        if (this.pf != null) {
            h hVar = new h();
            hVar.o("ability_common_filter");
            hVar.setFilterName(FilterNode.faceFilter.getNodeName());
            hVar.K("clearAllKnead");
            hVar.s(i);
            this.pf.a(hVar);
        }
    }

    private String a(FilterNode filterNode) {
        return filterNode == null ? "ability_common_filter" : filterNode.equals(FilterNode.faceFilter) ? "ability_face_filter" : filterNode.equals(FilterNode.makeupFilter) ? "ability_makeup_filter" : "ability_common_filter";
    }

    private void a(FilterParam.MakeupFilter makeupFilter) {
        String str = null;
        switch (makeupFilter) {
            case lips:
            case lipsMask:
                str = StatisticConstants.EVENT_MAKEUP_LIPSTICK_ENTER;
                break;
            case cheeks:
                str = StatisticConstants.EVENT_MAKEUP_BLUSHER_ENTER;
                break;
            case highlight:
                str = StatisticConstants.EVENT_MAKEUP_HIGHLIGHT_ENTER;
                break;
        }
        if (str != null) {
            StatisticApi.onEvent(str);
        }
    }

    public void a(j jVar) {
        this.pf = jVar;
    }

    public synchronized void a(FilterNode filterNode, boolean z) {
        b.c("ARFilterManager", "updateAbilityState filerName = " + filterNode + " && state = " + z);
        if (filterNode != null && this.pi != null && this.pi.containsKey(filterNode)) {
            this.pi.put(filterNode, Boolean.valueOf(z));
        }
    }

    public void a(FilterParam filterParam, Object obj) {
        String str;
        boolean z;
        if (filterParam == null) {
            return;
        }
        if (filterParam.getFilterNode().equals(FilterNode.makeupFilter)) {
            if (obj instanceof Float) {
                str = "/opacity";
                z = false;
            } else if (obj instanceof String) {
                a((FilterParam.MakeupFilter) filterParam);
                str = "/texture_path";
                z = false;
            } else if (obj instanceof Integer) {
                z = true;
                str = "/is_enable";
            }
            a(filterParam, obj, str, z);
        }
        str = null;
        z = false;
        a(filterParam, obj, str, z);
    }

    public void a(FilterParam filterParam, Object obj, String str, boolean z) {
        if (filterParam == null) {
            return;
        }
        h hVar = new h();
        FilterNode filterNode = filterParam.getFilterNode();
        hVar.o(a(filterNode));
        hVar.setFilterName(filterNode.getNodeName());
        if (TextUtils.isEmpty(str)) {
            hVar.K(filterParam.getParamName());
        } else {
            hVar.K(filterParam.getParamName() + str);
        }
        if (obj instanceof Float) {
            hVar.b(((Float) obj).floatValue());
        } else if (obj instanceof String) {
            hVar.L((String) obj);
        } else if (obj instanceof Integer) {
            hVar.s(((Integer) obj).intValue());
        } else if (!(obj instanceof float[])) {
            b.b("ARFilterManager", "updateFilter value type error!!!");
            return;
        } else {
            hVar.b((float[]) obj);
        }
        hVar.e(z);
        if (this.pf != null) {
            this.pf.a(hVar);
        }
    }

    public void a(FilterParam filterParam, boolean z) {
        if (filterParam == null) {
            return;
        }
        FilterNode filterNode = filterParam.getFilterNode();
        h hVar = new h();
        hVar.e(true);
        hVar.o(a(filterNode));
        hVar.setFilterName(filterNode.getNodeName());
        hVar.K("is_enable");
        if (z) {
            Integer num = 1;
            hVar.s(num.intValue());
        } else {
            Integer num2 = 0;
            hVar.s(num2.intValue());
        }
        if (this.pf != null) {
            this.pf.a(hVar);
        }
    }

    public void af(String str) {
        this.mCasePath = str;
    }

    public void bq() {
        if (this.pf != null) {
            this.pf.bq();
        }
    }

    public void clearAllFilter() {
        G(1);
    }

    public synchronized void dv() {
        if (this.ph != null) {
            this.ph.put(FilterNode.lutFilter, true);
            this.ph.put(FilterNode.skinFilter, true);
            this.ph.put(FilterNode.faceFilter, true);
            this.ph.put(FilterNode.makeupFilter, true);
            b.c("ARFilterManager", "onPipelineCreate mPipelineStates = " + this.ph.toString());
        }
        dw();
    }

    public void dw() {
        boolean z = true;
        if (this.pj != null && this.ph != null && this.pi != null) {
            this.pj.put(FilterNode.lutFilter, Boolean.valueOf(this.ph.get(FilterNode.lutFilter).booleanValue() && this.pi.get(FilterNode.lutFilter).booleanValue()));
            this.pj.put(FilterNode.skinFilter, Boolean.valueOf(this.ph.get(FilterNode.skinFilter).booleanValue() && this.pi.get(FilterNode.skinFilter).booleanValue()));
            this.pj.put(FilterNode.faceFilter, Boolean.valueOf(this.ph.get(FilterNode.faceFilter).booleanValue() && this.pi.get(FilterNode.faceFilter).booleanValue()));
            HashMap<FilterNode, Boolean> hashMap = this.pj;
            FilterNode filterNode = FilterNode.makeupFilter;
            if (!this.ph.get(FilterNode.makeupFilter).booleanValue() || !this.pi.get(FilterNode.makeupFilter).booleanValue()) {
                z = false;
            }
            hashMap.put(filterNode, Boolean.valueOf(z));
            b.c("ARFilterManager", "callbackFilterStates mFilterStates = " + this.pj.toString() + " && mCasePath = " + this.mCasePath);
        }
        if (this.pg != null) {
            this.pg.onFilterStateChanged(this.pj, this.mCasePath);
        }
    }

    public synchronized void f(List<String> list) {
        if (list != null) {
            if (this.ph != null) {
                this.ph.put(FilterNode.lutFilter, Boolean.valueOf(list.contains(FilterNode.lutFilter.getNodeName())));
                this.ph.put(FilterNode.skinFilter, Boolean.valueOf(list.contains(FilterNode.skinFilter.getNodeName())));
                this.ph.put(FilterNode.faceFilter, Boolean.valueOf(list.contains(FilterNode.faceFilter.getNodeName())));
                this.ph.put(FilterNode.makeupFilter, Boolean.valueOf(list.contains(FilterNode.makeupFilter.getNodeName())));
                b.c("ARFilterManager", "onPipelineChanged mPipelineStates = " + this.ph.toString());
            }
            dw();
        }
    }

    public synchronized void release() {
        this.d = null;
        this.pf = null;
        this.pg = null;
        if (this.ph != null) {
            this.ph.clear();
            this.ph = null;
        }
        if (this.pi != null) {
            this.pi.clear();
            this.pi = null;
        }
        if (this.pj != null) {
            this.pj.clear();
            this.pj = null;
        }
    }

    public void resetAllFilter() {
        G(0);
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.pg = filterStateListener;
    }

    public String updateFilterCase(String str) {
        if (this.pf != null) {
            return this.pf.updateFilterCase(str);
        }
        return null;
    }
}
