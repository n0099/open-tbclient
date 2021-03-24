package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NoDataItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f2353a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f2354b;

    public NoDataItemViewHolder(View view) {
        super(view);
        this.f2353a = (TextView) view.findViewById(R.id.no_data_text);
        this.f2354b = (ImageView) view.findViewById(R.id.no_data_image);
    }
}
