package com.baidu.live.tieba.horizonallist.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import java.util.List;
/* loaded from: classes2.dex */
public class HTypeListView extends HListView {
    TypeAdapter mTypeAdapter;

    public HTypeListView(Context context) {
        super(context);
        this.mTypeAdapter = null;
        init();
    }

    public HTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTypeAdapter = null;
        init();
    }

    public HTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTypeAdapter = null;
    }

    private void init() {
        if (this.mTypeAdapter == null) {
            this.mTypeAdapter = new TypeAdapter();
        }
    }

    public void setData(List<? extends IAdapterData> list) {
        this.mTypeAdapter.setData(list);
    }

    public List<IAdapterData> getData() {
        return this.mTypeAdapter.getData();
    }
}
