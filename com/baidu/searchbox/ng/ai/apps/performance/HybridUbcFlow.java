package com.baidu.searchbox.ng.ai.apps.performance;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.trace.Index;
import com.baidu.searchbox.ng.ai.apps.trace.Tracer;
import com.baidu.ubc.Flow;
import com.baidu.ubc.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class HybridUbcFlow {
    private static final boolean DEBUG = false;
    private static final String TAG = "HybridUbcFlow";
    final String mFlowId;
    private Reporter mReporter;
    private final JSONObject mValues = new JSONObject();
    private final Map<String, String> mExt = new HashMap();
    public final List<String> mEvents = new ArrayList();
    private final Map<String, UbcFlowEvent> mEventPool = new HashMap();
    public final List<UbcFlowEvent> mFinalEvents = new ArrayList();
    private boolean mFlagNaDone = false;
    private boolean mFlagH5Done = false;

    /* loaded from: classes2.dex */
    public interface Reporter {
        void report(HybridUbcFlow hybridUbcFlow);
    }

    public HybridUbcFlow(String str) {
        this.mFlowId = str;
    }

    public HybridUbcFlow record(UbcFlowEvent ubcFlowEvent) {
        if (isValid(ubcFlowEvent)) {
            synchronized (this.mEvents) {
                switch (ubcFlowEvent.recordType()) {
                    case UPDATE:
                        update(ubcFlowEvent);
                        break;
                    case UPDATE_RECENT:
                        updateRecent(ubcFlowEvent);
                        break;
                    case UPDATE_EARLIER:
                        updateEarlier(ubcFlowEvent);
                        break;
                    default:
                        keep(ubcFlowEvent);
                        break;
                }
            }
        }
        return this;
    }

    private void update(UbcFlowEvent ubcFlowEvent) {
        this.mEvents.remove(ubcFlowEvent.id);
        this.mEvents.add(ubcFlowEvent.id);
        this.mEventPool.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void updateRecent(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.mEventPool.get(ubcFlowEvent.id);
        if (!isValid(ubcFlowEvent2) || ubcFlowEvent.time() > ubcFlowEvent2.time()) {
            update(ubcFlowEvent);
        }
    }

    private void updateEarlier(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.mEventPool.get(ubcFlowEvent.id);
        if (!isValid(ubcFlowEvent2) || ubcFlowEvent.time() < ubcFlowEvent2.time()) {
            update(ubcFlowEvent);
        }
    }

    private void keep(UbcFlowEvent ubcFlowEvent) {
        if (!isValid(this.mEventPool.get(ubcFlowEvent.id))) {
            update(ubcFlowEvent);
        }
    }

    private boolean isValid(UbcFlowEvent ubcFlowEvent) {
        return (ubcFlowEvent == null || TextUtils.isEmpty(ubcFlowEvent.id)) ? false : true;
    }

    public HybridUbcFlow record(List<UbcFlowEvent> list) {
        synchronized (this.mEvents) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                record(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow putExt(String str, String str2) {
        this.mExt.put(str, str2);
        return this;
    }

    public HybridUbcFlow putValue(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.mValues.put(str, obj);
            } catch (JSONException e) {
            }
        }
        return this;
    }

    public HybridUbcFlow naFlowDone() {
        this.mFlagNaDone = true;
        checkSubmit();
        return this;
    }

    public HybridUbcFlow h5FlowDone() {
        this.mFlagH5Done = true;
        checkSubmit();
        return this;
    }

    public HybridUbcFlow reporter(Reporter reporter) {
        this.mReporter = reporter;
        return this;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mEvents) {
            isEmpty = this.mEvents.isEmpty();
        }
        return isEmpty;
    }

    public void updateFinalEvents() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.mEvents) {
            this.mFinalEvents.clear();
            for (String str : this.mEvents) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.mEventPool.get(str)) != null && ubcFlowEvent.time() > 0) {
                    this.mFinalEvents.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.mFinalEvents, new Comparator<UbcFlowEvent>() { // from class: com.baidu.searchbox.ng.ai.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.time(), ubcFlowEvent2.time());
            }
        });
    }

    private boolean allDone() {
        return this.mFlagNaDone && this.mFlagH5Done;
    }

    private boolean checkSubmit() {
        if (allDone()) {
            Flow xD = o.xD(this.mFlowId);
            updateFinalEvents();
            if (this.mReporter != null) {
                this.mReporter.report(this);
            }
            for (UbcFlowEvent ubcFlowEvent : this.mFinalEvents) {
                if (!ubcFlowEvent.justLocalRecord()) {
                    xD.d(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.time());
                }
            }
            if (isEmpty()) {
                return false;
            }
            Tracer.INDEX_COST_RECENT_LAUNCH_TOTAL.update((Index<Long>) Long.valueOf(getCost(AiAppsPerformanceUBC.ACTION_FE_SLAVE_FIRST_RENDERED, AiAppsPerformanceUBC.ACTION_NA_START)));
            Tracer.INDEX_COST_RECENT_DOWNLOAD.update((Index<Long>) Long.valueOf(getCost(AiAppsPerformanceUBC.ACTION_APS_END_DOWNLOAD, AiAppsPerformanceUBC.ACTION_APS_START_DOWNLOAD, AiAppsPerformanceUBC.ACTION_APS_END_REQ, AiAppsPerformanceUBC.ACTION_APS_START_REQ, AiAppsPerformanceUBC.ACTION_NA_START)));
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : this.mExt.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        jSONObject.put(key, value);
                    }
                }
                putValue("ext", jSONObject);
            } catch (Exception e) {
            }
            xD.xy(this.mValues.toString());
            xD.end();
            AiAppsPerformanceUBC.resetSession();
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r1.time() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.time() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.time() - r0.time();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getCost(String... strArr) {
        UbcFlowEvent ubcFlowEvent;
        int length = strArr.length;
        int i = 0;
        UbcFlowEvent ubcFlowEvent2 = null;
        while (true) {
            if (i >= length) {
                ubcFlowEvent = null;
                break;
            }
            ubcFlowEvent = this.mEventPool.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.time() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.time() > 0) {
                break;
            } else {
                ubcFlowEvent = ubcFlowEvent2;
            }
            i++;
            ubcFlowEvent2 = ubcFlowEvent;
        }
        return -1L;
    }
}
