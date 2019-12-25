package com.baidu.live.tbadk.ala.zan;

import android.app.Activity;
import android.content.Context;
import android.view.View;
/* loaded from: classes2.dex */
public interface IAlaBdZan {
    void addHeart(int i);

    View getZanView();

    void postZan(Context context, String str, String str2, int i);

    void prepareZanView(Activity activity);

    void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback);

    void setZanResponseCallback(IZanResponseCallback iZanResponseCallback);
}
