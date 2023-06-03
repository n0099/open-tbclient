package com.baidu.searchbox.ui.stickylistheader;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SectionIndexer;
/* loaded from: classes4.dex */
public interface StickyListHeadersAdapter extends ListAdapter, SectionIndexer {
    long getHeaderId(int i);

    View getHeaderView(int i, View view2, ViewGroup viewGroup);
}
