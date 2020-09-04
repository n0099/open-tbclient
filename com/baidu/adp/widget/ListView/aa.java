package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class aa extends af.a {
    public ImageView mImageView;
    public TextView mTextView;

    public aa(View view) {
        super(view);
        this.mTextView = (TextView) view.findViewById(R.id.no_data_text);
        this.mImageView = (ImageView) view.findViewById(R.id.no_data_image);
    }
}
