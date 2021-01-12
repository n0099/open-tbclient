package com.baidu.live.k;

import android.content.res.Configuration;
import android.view.View;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public interface c {
    void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z);

    void bW(boolean z);

    void bX(boolean z);

    void bY(boolean z);

    String getTitle();

    View getView();

    void onConfigurationChanged(Configuration configuration);

    void onDestroy();
}
