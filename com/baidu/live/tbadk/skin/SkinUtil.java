package com.baidu.live.tbadk.skin;

import android.view.View;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class SkinUtil {
    public static final boolean onModeChanged(TbPageContext<?> tbPageContext, View view) {
        if (tbPageContext == null || view == null) {
            return false;
        }
        tbPageContext.getLayoutMode().onModeChanged(view);
        return true;
    }
}
