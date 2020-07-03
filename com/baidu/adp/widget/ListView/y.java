package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class y extends ad.a {
    public ImageView mImageView;
    public TextView mTextView;

    public y(View view) {
        super(view);
        this.mTextView = (TextView) view.findViewById(R.id.no_data_text);
        this.mImageView = (ImageView) view.findViewById(R.id.no_data_image);
    }
}
