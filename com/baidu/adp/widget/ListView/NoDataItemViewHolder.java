package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NoDataItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f2354a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f2355b;

    public NoDataItemViewHolder(View view) {
        super(view);
        this.f2354a = (TextView) view.findViewById(R.id.no_data_text);
        this.f2355b = (ImageView) view.findViewById(R.id.no_data_image);
    }
}
