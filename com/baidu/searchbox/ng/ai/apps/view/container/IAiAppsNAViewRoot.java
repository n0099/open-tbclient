package com.baidu.searchbox.ng.ai.apps.view.container;

import android.view.View;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsRectPosition;
import com.baidu.searchbox.ng.ai.apps.view.container.model.NAViewCache;
/* loaded from: classes2.dex */
public interface IAiAppsNAViewRoot {
    int getMeasuredHeight();

    int getMeasuredWidth();

    NAViewCache getNAViewCache();

    boolean insertView(View view, AiAppsRectPosition aiAppsRectPosition);

    boolean removeView(View view);

    boolean updateView(View view, AiAppsRectPosition aiAppsRectPosition);
}
