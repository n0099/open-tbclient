package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NoDataItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f2389a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f2390b;

    public NoDataItemViewHolder(View view) {
        super(view);
        this.f2389a = (TextView) view.findViewById(R.id.no_data_text);
        this.f2390b = (ImageView) view.findViewById(R.id.no_data_image);
    }
}
