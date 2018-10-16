package com.baidu.searchbox.ng.ai.apps.view.container.model;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class NAViewCache {
    private List<View> mWidgetList = new ArrayList();

    public synchronized void registerWidget(View view) {
        if (view != null) {
            this.mWidgetList.add(view);
        }
    }

    public synchronized boolean unregisterWidget(View view) {
        return view == null ? false : this.mWidgetList.remove(view);
    }

    public List<View> getWidgetList() {
        return this.mWidgetList;
    }

    public void clear() {
        this.mWidgetList.clear();
    }
}
