package com.baidu.nadcore.crius.uiwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.searchbox.crius.data.RenderData;
import com.baidu.searchbox.crius.render.util.RenderUtils;
import view.CriusTextView;
/* loaded from: classes3.dex */
public class SyncTextView extends CriusTextView {
    public SyncTextView(Context context) {
        super(context);
    }

    public SyncTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SyncTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void b(@Nullable RenderData renderData, boolean z, boolean z2) {
        if (renderData == null) {
            return;
        }
        RenderUtils.setBackground(this, "", renderData, z, z2);
        RenderUtils.setInitAlphaAndController(this, renderData.opacities, z, z2);
        RenderUtils.renderTextView(this, renderData, z, z2);
        setText(renderData.text, TextView.BufferType.NORMAL);
    }
}
