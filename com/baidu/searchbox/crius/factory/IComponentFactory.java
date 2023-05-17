package com.baidu.searchbox.crius.factory;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.searchbox.crius.data.RenderData;
/* loaded from: classes3.dex */
public interface IComponentFactory {
    @Nullable
    View createComponent(Context context, String str);

    boolean renderComponent(String str, View view2, RenderData renderData, boolean z, boolean z2, boolean z3);
}
