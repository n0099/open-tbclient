package com.baidu.live.h;

import android.content.res.Configuration;
import android.view.View;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public interface b {
    void Kd();

    void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z);

    void bS(boolean z);

    void bT(boolean z);

    String getTitle();

    View getView();

    void onConfigurationChanged(Configuration configuration);

    void onDestroy();
}
