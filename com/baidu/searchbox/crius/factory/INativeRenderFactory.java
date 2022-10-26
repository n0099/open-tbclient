package com.baidu.searchbox.crius.factory;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.crius.data.RenderData;
/* loaded from: classes2.dex */
public interface INativeRenderFactory {
    View createView(Context context, String str);

    boolean renderBackground(String str, View view2, String str2, String str3);

    boolean renderView(String str, View view2, RenderData renderData, boolean z, boolean z2);
}
