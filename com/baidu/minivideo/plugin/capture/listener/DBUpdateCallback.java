package com.baidu.minivideo.plugin.capture.listener;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public interface DBUpdateCallback extends ApsListener {
    void onAddResult();

    void onDeleteResult();

    void onQueryResult(String str);

    void onQueryResult(ArrayList arrayList);

    void onUpdateResult();
}
