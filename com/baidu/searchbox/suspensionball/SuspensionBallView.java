package com.baidu.searchbox.suspensionball;

import android.content.Context;
import android.widget.ImageView;
/* loaded from: classes3.dex */
public class SuspensionBallView extends ImageView {
    public SuspensionBallView(Context context) {
        super(context);
    }

    public void updateData(String str, String str2) {
        setTag(R.id.tag_suspension_ball_key, str);
    }
}
