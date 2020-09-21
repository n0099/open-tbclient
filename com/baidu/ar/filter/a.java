package com.baidu.ar.filter;

import android.text.TextUtils;
import com.baidu.ar.DefaultParams;
import com.baidu.ar.arrender.h;
import com.baidu.ar.arrender.k;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.g.b;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private DefaultParams d;
    private String mCasePath;
    private k pR;
    private FilterStateListener pS;
    private HashMap<FilterNode, Boolean> pT = new HashMap<>();
    private HashMap<FilterNode, Boolean> pU = new HashMap<>();
    private HashMap<FilterNode, Boolean> pV = new HashMap<>();

    public a(DefaultParams defaultParams) {
        this.d = defaultParams;
        if (this.pT != null) {
            this.pT.put(FilterNode.lutFilter, false);
            this.pT.put(FilterNode.skinFilter, false);
            this.pT.put(FilterNode.faceFilter, false);
            this.pT.put(FilterNode.makeupFilter, false);
        }
        if (this.pU != null) {
            this.pU.put(FilterNode.lutFilter, true);
            this.pU.put(FilterNode.skinFilter, Boolean.valueOf(this.d.isUseBeautyFilter()));
            this.pU.put(FilterNode.faceFilter, Boolean.valueOf(this.d.isUseFaceFilter()));
            this.pU.put(FilterNode.makeupFilter, Boolean.valueOf(this.d.isUseMakeupFilter()));
        }
    }

    private void I(int i) {
        if (this.pR != null) {
            h hVar = new h();
            hVar.p("ability_common_filter");
            hVar.setFilterName(FilterNode.faceFilter.getNodeName());
            hVar.K("clearAllKnead");
            hVar.p(i);
            this.pR.a(hVar);
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

    public void a(k kVar) {
        this.pR = kVar;
    }

    public synchronized void a(FilterNode filterNode, boolean z) {
        b.c("ARFilterManager", "updateAbilityState filerName = " + filterNode + " && state = " + z);
        if (filterNode != null && this.pU != null && this.pU.containsKey(filterNode)) {
            this.pU.put(filterNode, Boolean.valueOf(z));
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
        hVar.p(a(filterNode));
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
            hVar.p(((Integer) obj).intValue());
        } else if (!(obj instanceof float[])) {
            b.b("ARFilterManager", "updateFilter value type error!!!");
            return;
        } else {
            hVar.b((float[]) obj);
        }
        hVar.e(z);
        if (this.pR != null) {
            this.pR.a(hVar);
        }
    }

    public void a(FilterParam filterParam, boolean z) {
        if (filterParam == null) {
            return;
        }
        FilterNode filterNode = filterParam.getFilterNode();
        h hVar = new h();
        hVar.e(true);
        hVar.p(a(filterNode));
        hVar.setFilterName(filterNode.getNodeName());
        hVar.K("is_enable");
        if (z) {
            Integer num = 1;
            hVar.p(num.intValue());
        } else {
            Integer num2 = 0;
            hVar.p(num2.intValue());
        }
        if (this.pR != null) {
            this.pR.a(hVar);
        }
    }

    public void aj(String str) {
        this.mCasePath = str;
    }

    public void by() {
        if (this.pR != null) {
            this.pR.by();
        }
    }

    public void clearAllFilter() {
        I(1);
    }

    public synchronized void eF() {
        if (this.pT != null) {
            this.pT.put(FilterNode.lutFilter, true);
            this.pT.put(FilterNode.skinFilter, true);
            this.pT.put(FilterNode.faceFilter, true);
            this.pT.put(FilterNode.makeupFilter, true);
            b.c("ARFilterManager", "onPipelineCreate mPipelineStates = " + this.pT.toString());
        }
        eG();
    }

    public void eG() {
        boolean z = true;
        if (this.pV != null && this.pT != null && this.pU != null) {
            this.pV.put(FilterNode.lutFilter, Boolean.valueOf(this.pT.get(FilterNode.lutFilter).booleanValue() && this.pU.get(FilterNode.lutFilter).booleanValue()));
            this.pV.put(FilterNode.skinFilter, Boolean.valueOf(this.pT.get(FilterNode.skinFilter).booleanValue() && this.pU.get(FilterNode.skinFilter).booleanValue()));
            this.pV.put(FilterNode.faceFilter, Boolean.valueOf(this.pT.get(FilterNode.faceFilter).booleanValue() && this.pU.get(FilterNode.faceFilter).booleanValue()));
            HashMap<FilterNode, Boolean> hashMap = this.pV;
            FilterNode filterNode = FilterNode.makeupFilter;
            if (!this.pT.get(FilterNode.makeupFilter).booleanValue() || !this.pU.get(FilterNode.makeupFilter).booleanValue()) {
                z = false;
            }
            hashMap.put(filterNode, Boolean.valueOf(z));
            b.c("ARFilterManager", "callbackFilterStates mFilterStates = " + this.pV.toString() + " && mCasePath = " + this.mCasePath);
        }
        if (this.pS != null) {
            this.pS.onFilterStateChanged(this.pV, this.mCasePath);
        }
    }

    public synchronized void f(List<String> list) {
        if (list != null) {
            if (this.pT != null) {
                this.pT.put(FilterNode.lutFilter, Boolean.valueOf(list.contains(FilterNode.lutFilter.getNodeName())));
                this.pT.put(FilterNode.skinFilter, Boolean.valueOf(list.contains(FilterNode.skinFilter.getNodeName())));
                this.pT.put(FilterNode.faceFilter, Boolean.valueOf(list.contains(FilterNode.faceFilter.getNodeName())));
                this.pT.put(FilterNode.makeupFilter, Boolean.valueOf(list.contains(FilterNode.makeupFilter.getNodeName())));
                b.c("ARFilterManager", "onPipelineChanged mPipelineStates = " + this.pT.toString());
            }
            eG();
        }
    }

    public synchronized void release() {
        this.d = null;
        this.pR = null;
        this.pS = null;
        if (this.pT != null) {
            this.pT.clear();
            this.pT = null;
        }
        if (this.pU != null) {
            this.pU.clear();
            this.pU = null;
        }
        if (this.pV != null) {
            this.pV.clear();
            this.pV = null;
        }
    }

    public void resetAllFilter() {
        I(0);
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.pS = filterStateListener;
    }

    public String updateFilterCase(String str) {
        if (this.pR != null) {
            return this.pR.updateFilterCase(str);
        }
        return null;
    }
}
