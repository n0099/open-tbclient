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
    private String aB;
    private DefaultParams c;
    private j oF;
    private FilterStateListener oG;
    private HashMap<FilterNode, Boolean> oH = new HashMap<>();
    private HashMap<FilterNode, Boolean> oI = new HashMap<>();
    private HashMap<FilterNode, Boolean> oJ = new HashMap<>();

    public a(DefaultParams defaultParams) {
        this.c = defaultParams;
        if (this.oH != null) {
            this.oH.put(FilterNode.lutFilter, false);
            this.oH.put(FilterNode.skinFilter, false);
            this.oH.put(FilterNode.faceFilter, false);
            this.oH.put(FilterNode.makeupFilter, false);
        }
        if (this.oI != null) {
            this.oI.put(FilterNode.lutFilter, true);
            this.oI.put(FilterNode.skinFilter, Boolean.valueOf(this.c.isUseBeautyFilter()));
            this.oI.put(FilterNode.faceFilter, Boolean.valueOf(this.c.isUseFaceFilter()));
            this.oI.put(FilterNode.makeupFilter, Boolean.valueOf(this.c.isUseMakeupFilter()));
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
        this.oF = jVar;
    }

    public synchronized void a(FilterNode filterNode, boolean z) {
        b.c("ARFilterManager", "updateAbilityState filerName = " + filterNode + " && state = " + z);
        if (filterNode != null && this.oI != null && this.oI.containsKey(filterNode)) {
            this.oI.put(filterNode, Boolean.valueOf(z));
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
            hVar.q(((Integer) obj).intValue());
        } else if (!(obj instanceof float[])) {
            b.b("ARFilterManager", "updateFilter value type error!!!");
            return;
        } else {
            hVar.b((float[]) obj);
        }
        hVar.e(z);
        if (this.oF != null) {
            this.oF.a(hVar);
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
            hVar.q(num.intValue());
        } else {
            Integer num2 = 0;
            hVar.q(num2.intValue());
        }
        if (this.oF != null) {
            this.oF.a(hVar);
        }
    }

    public void ae(String str) {
        this.aB = str;
    }

    public void bc() {
        if (this.oF != null) {
            this.oF.bc();
        }
    }

    public void clearAllFilter() {
        if (this.oF != null) {
            h hVar = new h();
            hVar.o("ability_common_filter");
            hVar.setFilterName(FilterNode.faceFilter.getNodeName());
            hVar.K("clearAllKnead");
            hVar.q(1);
            this.oF.a(hVar);
        }
    }

    public synchronized void d(List<String> list) {
        if (list != null) {
            if (this.oH != null) {
                this.oH.put(FilterNode.lutFilter, Boolean.valueOf(list.contains(FilterNode.lutFilter.getNodeName())));
                this.oH.put(FilterNode.skinFilter, Boolean.valueOf(list.contains(FilterNode.skinFilter.getNodeName())));
                this.oH.put(FilterNode.faceFilter, Boolean.valueOf(list.contains(FilterNode.faceFilter.getNodeName())));
                this.oH.put(FilterNode.makeupFilter, Boolean.valueOf(list.contains(FilterNode.makeupFilter.getNodeName())));
                b.c("ARFilterManager", "onPipelineChanged mPipelineStates = " + this.oH.toString());
            }
            dg();
        }
    }

    public synchronized void df() {
        if (this.oH != null) {
            this.oH.put(FilterNode.lutFilter, true);
            this.oH.put(FilterNode.skinFilter, true);
            this.oH.put(FilterNode.faceFilter, true);
            this.oH.put(FilterNode.makeupFilter, true);
            b.c("ARFilterManager", "onPipelineCreate mPipelineStates = " + this.oH.toString());
        }
        dg();
    }

    public synchronized void dg() {
        if (this.oJ != null && this.oH != null && this.oI != null) {
            this.oJ.put(FilterNode.lutFilter, Boolean.valueOf(this.oH.get(FilterNode.lutFilter).booleanValue() && this.oI.get(FilterNode.lutFilter).booleanValue()));
            this.oJ.put(FilterNode.skinFilter, Boolean.valueOf(this.oH.get(FilterNode.skinFilter).booleanValue() && this.oI.get(FilterNode.skinFilter).booleanValue()));
            this.oJ.put(FilterNode.faceFilter, Boolean.valueOf(this.oH.get(FilterNode.faceFilter).booleanValue() && this.oI.get(FilterNode.faceFilter).booleanValue()));
            this.oJ.put(FilterNode.makeupFilter, Boolean.valueOf(this.oH.get(FilterNode.makeupFilter).booleanValue() && this.oI.get(FilterNode.makeupFilter).booleanValue()));
            b.c("ARFilterManager", "callbackFilterStates mFilterStates = " + this.oJ.toString() + " && mCasePath = " + this.aB);
        }
        if (this.oG != null) {
            this.oG.onFilterStateChanged(this.oJ, this.aB);
        }
    }

    public synchronized void release() {
        this.c = null;
        this.oF = null;
        this.oG = null;
        if (this.oH != null) {
            this.oH.clear();
            this.oH = null;
        }
        if (this.oI != null) {
            this.oI.clear();
            this.oI = null;
        }
        if (this.oJ != null) {
            this.oJ.clear();
            this.oJ = null;
        }
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.oG = filterStateListener;
    }

    public String updateFilterCase(String str) {
        if (this.oF != null) {
            return this.oF.updateFilterCase(str);
        }
        return null;
    }
}
