package com.baidu.searchbox.ng.ai.apps.performance.panel;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.trace.Index;
import com.baidu.searchbox.ng.ai.apps.trace.Tracer;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class PanelDataProvider {
    public static final String PAGES_WITCH_END = "pageSwitchEnd";
    public static final String PAGES_WITCH_START = "pageSwitchStart";
    public static final String PAGE_INIT_RENDER_END = "pageInitRenderEnd";
    public static final String PAGE_INIT_RENDER_START = "pageInitRenderStart";
    public static final String PAGE_UPDATE_END = "pageUpdateEnd";
    public static final String PAGE_UPDATE_START = "pageUpdateStart";
    private static PanelDataProvider sInstance;
    private HashMap<String, TimeCost> mPageInitRenderMap;
    private HashMap<String, TimeCost> mPageSwitchMap;
    private HashMap<String, TimeCost> mPageUpdateRenderMap;

    private PanelDataProvider() {
        initMapIfNeed();
    }

    public static PanelDataProvider getInstance() {
        if (sInstance == null) {
            synchronized (PanelDataProvider.class) {
                if (sInstance == null) {
                    sInstance = new PanelDataProvider();
                }
            }
        }
        return sInstance;
    }

    public static synchronized void releaseInstance() {
        synchronized (PanelDataProvider.class) {
            if (sInstance != null) {
                sInstance.release();
                sInstance = null;
            }
        }
    }

    private void release() {
        if (this.mPageSwitchMap != null) {
            this.mPageSwitchMap.clear();
        }
        if (this.mPageInitRenderMap != null) {
            this.mPageInitRenderMap.clear();
        }
        if (this.mPageUpdateRenderMap != null) {
            this.mPageUpdateRenderMap.clear();
        }
    }

    public void onReceivedPerformanceData(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            initMapIfNeed();
            char c = 65535;
            switch (str2.hashCode()) {
                case -1880922749:
                    if (str2.equals(PAGE_UPDATE_END)) {
                        c = 5;
                        break;
                    }
                    break;
                case -964566145:
                    if (str2.equals(PAGES_WITCH_START)) {
                        c = 0;
                        break;
                    }
                    break;
                case -410083667:
                    if (str2.equals(PAGE_INIT_RENDER_START)) {
                        c = 1;
                        break;
                    }
                    break;
                case 4028902:
                    if (str2.equals(PAGE_INIT_RENDER_END)) {
                        c = 4;
                        break;
                    }
                    break;
                case 627578634:
                    if (str2.equals(PAGE_UPDATE_START)) {
                        c = 2;
                        break;
                    }
                    break;
                case 1719651128:
                    if (str2.equals(PAGES_WITCH_END)) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                    setTimeCostStart(str, str2, j);
                    return;
                case 3:
                case 4:
                case 5:
                    setTimeCostEnd(str, str2, j);
                    return;
                default:
                    return;
            }
        }
    }

    private void initMapIfNeed() {
        if (this.mPageSwitchMap == null) {
            this.mPageSwitchMap = new HashMap<>();
        }
        if (this.mPageInitRenderMap == null) {
            this.mPageInitRenderMap = new HashMap<>();
        }
        if (this.mPageUpdateRenderMap == null) {
            this.mPageUpdateRenderMap = new HashMap<>();
        }
    }

    private void setTimeCostStart(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            TimeCost timeCost = null;
            char c = 65535;
            switch (str2.hashCode()) {
                case -964566145:
                    if (str2.equals(PAGES_WITCH_START)) {
                        c = 0;
                        break;
                    }
                    break;
                case -410083667:
                    if (str2.equals(PAGE_INIT_RENDER_START)) {
                        c = 1;
                        break;
                    }
                    break;
                case 627578634:
                    if (str2.equals(PAGE_UPDATE_START)) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    timeCost = this.mPageSwitchMap.get(str);
                    if (timeCost == null) {
                        timeCost = new PageSwitchCost();
                        this.mPageSwitchMap.put(str, timeCost);
                        break;
                    }
                    break;
                case 1:
                    timeCost = this.mPageInitRenderMap.get(str);
                    if (timeCost == null) {
                        timeCost = new PageInitRenderCost();
                        this.mPageInitRenderMap.put(str, timeCost);
                        break;
                    }
                    break;
                case 2:
                    timeCost = this.mPageUpdateRenderMap.get(str);
                    if (timeCost == null) {
                        timeCost = new PageUpdateRenderCost();
                        this.mPageUpdateRenderMap.put(str, timeCost);
                        break;
                    }
                    break;
            }
            if (timeCost != null) {
                timeCost.setStart(j);
            }
        }
    }

    private void setTimeCostEnd(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            TimeCost timeCost = null;
            char c = 65535;
            switch (str2.hashCode()) {
                case -1880922749:
                    if (str2.equals(PAGE_UPDATE_END)) {
                        c = 2;
                        break;
                    }
                    break;
                case 4028902:
                    if (str2.equals(PAGE_INIT_RENDER_END)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1719651128:
                    if (str2.equals(PAGES_WITCH_END)) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    timeCost = this.mPageSwitchMap.remove(str);
                    break;
                case 1:
                    timeCost = this.mPageInitRenderMap.remove(str);
                    break;
                case 2:
                    timeCost = this.mPageUpdateRenderMap.remove(str);
                    break;
            }
            if (timeCost != null) {
                timeCost.setEnd(j);
                callbackCost(timeCost.getType(), timeCost.getCost());
            }
        }
    }

    private void callbackCost(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            char c = 65535;
            switch (str.hashCode()) {
                case 767526192:
                    if (str.equals(TimeCost.PAGE_SWITCH)) {
                        c = 0;
                        break;
                    }
                    break;
                case 1331686101:
                    if (str.equals(TimeCost.PAGE_INIT_RENDER)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1390184462:
                    if (str.equals(TimeCost.PAGE_UPDATE_RENDER)) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    Tracer.INDEX_COST_RECENT_PAGE_SWITCH.update((Index<Long>) Long.valueOf(j));
                    return;
                case 1:
                    Tracer.INDEX_COST_CURRENT_PAGE_RENDERED_INITIAL.update((Index<Long>) Long.valueOf(j));
                    return;
                case 2:
                    Tracer.INDEX_COST_CURRENT_PAGE_RENDERED.update((Index<Long>) Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
