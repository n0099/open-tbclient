package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class u extends y.a {
    public ImageView mImageView;
    public TextView mTextView;

    public u(View view) {
        super(view);
        this.mTextView = (TextView) view.findViewById(R.id.no_data_text);
        this.mImageView = (ImageView) view.findViewById(R.id.no_data_image);
    }
}
