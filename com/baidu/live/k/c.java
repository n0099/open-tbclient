package com.baidu.live.k;

import android.content.res.Configuration;
import android.view.View;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public interface c {
    void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z);

    void ca(boolean z);

    void cb(boolean z);

    void cc(boolean z);

    String getTitle();

    View getView();

    void onConfigurationChanged(Configuration configuration);

    void onDestroy();
}
