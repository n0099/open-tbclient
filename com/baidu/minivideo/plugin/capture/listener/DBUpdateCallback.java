package com.baidu.minivideo.plugin.capture.listener;

import com.baidu.minivideo.plugin.capture.bean.VideoDraftBean;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public interface DBUpdateCallback extends ApsListener {
    void onAddResult();

    void onDeleteResult();

    void onQueryResult(String str);

    void onQueryResult(ArrayList<VideoDraftBean> arrayList);

    void onUpdateResult();
}
