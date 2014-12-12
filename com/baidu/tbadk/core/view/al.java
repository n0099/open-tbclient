package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class al extends ak {
    public al(Context context) {
        super(context);
    }

    @Override // com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public View jx() {
        return h(getContext().getString(com.baidu.tieba.z.pull_view_pull_more), getContext().getString(com.baidu.tieba.z.pull_view_release_more), null);
    }
}
