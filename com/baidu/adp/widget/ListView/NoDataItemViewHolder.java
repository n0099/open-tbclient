package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NoDataItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f2395a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f2396b;

    public NoDataItemViewHolder(View view) {
        super(view);
        this.f2395a = (TextView) view.findViewById(R.id.no_data_text);
        this.f2396b = (ImageView) view.findViewById(R.id.no_data_image);
    }
}
