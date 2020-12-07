package com.baidu.ar.filter;

import android.text.TextUtils;
import com.baidu.ar.DefaultParams;
import com.baidu.ar.arrender.i;
import com.baidu.ar.arrender.l;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.h.b;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private DefaultParams d;
    private String mCasePath;
    private l qh;
    private FilterStateListener qi;
    private HashMap<FilterNode, Boolean> qj = new HashMap<>();
    private HashMap<FilterNode, Boolean> qk = new HashMap<>();
    private HashMap<FilterNode, Boolean> ql = new HashMap<>();

    public a(DefaultParams defaultParams) {
        this.d = defaultParams;
        if (this.qj != null) {
            this.qj.put(FilterNode.lutFilter, false);
            this.qj.put(FilterNode.skinFilter, false);
            this.qj.put(FilterNode.faceFilter, false);
            this.qj.put(FilterNode.makeupFilter, false);
        }
        if (this.qk != null) {
            this.qk.put(FilterNode.lutFilter, true);
            this.qk.put(FilterNode.skinFilter, Boolean.valueOf(this.d.isUseBeautyFilter()));
            this.qk.put(FilterNode.faceFilter, Boolean.valueOf(this.d.isUseFaceFilter()));
            this.qk.put(FilterNode.makeupFilter, Boolean.valueOf(this.d.isUseMakeupFilter()));
        }
    }

    private void K(int i) {
        if (this.qh != null) {
            i iVar = new i();
            iVar.r("ability_common_filter");
            iVar.setFilterName(FilterNode.faceFilter.getNodeName());
            iVar.N("clearAllKnead");
            iVar.r(i);
            this.qh.a(iVar);
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

    public void a(l lVar) {
        this.qh = lVar;
    }

    public synchronized void a(FilterNode filterNode, boolean z) {
        b.c("ARFilterManager", "updateAbilityState filerName = " + filterNode + " && state = " + z);
        if (filterNode != null && this.qk != null && this.qk.containsKey(filterNode)) {
            this.qk.put(filterNode, Boolean.valueOf(z));
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
        i iVar = new i();
        FilterNode filterNode = filterParam.getFilterNode();
        iVar.r(a(filterNode));
        iVar.setFilterName(filterNode.getNodeName());
        if (TextUtils.isEmpty(str)) {
            iVar.N(filterParam.getParamName());
        } else {
            iVar.N(filterParam.getParamName() + str);
        }
        if (obj instanceof Float) {
            iVar.a(((Float) obj).floatValue());
        } else if (obj instanceof String) {
            iVar.O((String) obj);
        } else if (obj instanceof Integer) {
            iVar.r(((Integer) obj).intValue());
        } else if (!(obj instanceof float[])) {
            b.b("ARFilterManager", "updateFilter value type error!!!");
            return;
        } else {
            iVar.a((float[]) obj);
        }
        iVar.e(z);
        if (this.qh != null) {
            this.qh.a(iVar);
        }
    }

    public void a(FilterParam filterParam, boolean z) {
        if (filterParam == null) {
            return;
        }
        FilterNode filterNode = filterParam.getFilterNode();
        i iVar = new i();
        iVar.e(true);
        iVar.r(a(filterNode));
        iVar.setFilterName(filterNode.getNodeName());
        iVar.N("is_enable");
        if (z) {
            Integer num = 1;
            iVar.r(num.intValue());
        } else {
            Integer num2 = 0;
            iVar.r(num2.intValue());
        }
        if (this.qh != null) {
            this.qh.a(iVar);
        }
    }

    public void am(String str) {
        this.mCasePath = str;
    }

    public void bv() {
        if (this.qh != null) {
            this.qh.bv();
        }
    }

    public void clearAllFilter() {
        K(1);
    }

    public synchronized void eE() {
        if (this.qj != null) {
            this.qj.put(FilterNode.lutFilter, true);
            this.qj.put(FilterNode.skinFilter, true);
            this.qj.put(FilterNode.faceFilter, true);
            this.qj.put(FilterNode.makeupFilter, true);
            b.c("ARFilterManager", "onPipelineCreate mPipelineStates = " + this.qj.toString());
        }
        eF();
    }

    public void eF() {
        boolean z = true;
        if (this.ql != null && this.qj != null && this.qk != null) {
            this.ql.put(FilterNode.lutFilter, Boolean.valueOf(this.qj.get(FilterNode.lutFilter).booleanValue() && this.qk.get(FilterNode.lutFilter).booleanValue()));
            this.ql.put(FilterNode.skinFilter, Boolean.valueOf(this.qj.get(FilterNode.skinFilter).booleanValue() && this.qk.get(FilterNode.skinFilter).booleanValue()));
            this.ql.put(FilterNode.faceFilter, Boolean.valueOf(this.qj.get(FilterNode.faceFilter).booleanValue() && this.qk.get(FilterNode.faceFilter).booleanValue()));
            HashMap<FilterNode, Boolean> hashMap = this.ql;
            FilterNode filterNode = FilterNode.makeupFilter;
            if (!this.qj.get(FilterNode.makeupFilter).booleanValue() || !this.qk.get(FilterNode.makeupFilter).booleanValue()) {
                z = false;
            }
            hashMap.put(filterNode, Boolean.valueOf(z));
            b.c("ARFilterManager", "callbackFilterStates mFilterStates = " + this.ql.toString() + " && mCasePath = " + this.mCasePath);
        }
        if (this.qi != null) {
            this.qi.onFilterStateChanged(this.ql, this.mCasePath);
        }
    }

    public synchronized void f(List<String> list) {
        if (list != null) {
            if (this.qj != null) {
                this.qj.put(FilterNode.lutFilter, Boolean.valueOf(list.contains(FilterNode.lutFilter.getNodeName())));
                this.qj.put(FilterNode.skinFilter, Boolean.valueOf(list.contains(FilterNode.skinFilter.getNodeName())));
                this.qj.put(FilterNode.faceFilter, Boolean.valueOf(list.contains(FilterNode.faceFilter.getNodeName())));
                this.qj.put(FilterNode.makeupFilter, Boolean.valueOf(list.contains(FilterNode.makeupFilter.getNodeName())));
                b.c("ARFilterManager", "onPipelineChanged mPipelineStates = " + this.qj.toString());
            }
            eF();
        }
    }

    public synchronized void release() {
        this.d = null;
        this.qh = null;
        this.qi = null;
        if (this.qj != null) {
            this.qj.clear();
            this.qj = null;
        }
        if (this.qk != null) {
            this.qk.clear();
            this.qk = null;
        }
        if (this.ql != null) {
            this.ql.clear();
            this.ql = null;
        }
    }

    public void resetAllFilter() {
        K(0);
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.qi = filterStateListener;
    }

    public String updateFilterCase(String str) {
        if (this.qh != null) {
            return this.qh.updateFilterCase(str);
        }
        return null;
    }
}
