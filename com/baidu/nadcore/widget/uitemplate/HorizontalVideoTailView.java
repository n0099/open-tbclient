package com.baidu.nadcore.widget.uitemplate;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.tail.AdBaseTailFrameView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.tieba.R;
import com.baidu.tieba.jy0;
import com.baidu.tieba.um0;
import com.baidu.tieba.wm0;
/* loaded from: classes3.dex */
public class HorizontalVideoTailView extends AdBaseTailFrameView {
    public wm0 m;
    public SimpleAdInfoView n;

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public int e() {
        return R.layout.nad_horizontal_video_tail_view;
    }

    /* loaded from: classes3.dex */
    public class a implements SimpleAdInfoView.c {
        public final /* synthetic */ um0 a;

        public a(um0 um0Var) {
            this.a = um0Var;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            HorizontalVideoTailView.this.l(ClogBuilder.LogType.FREE_CLICK, str, this.a);
        }
    }

    public HorizontalVideoTailView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public void d(Context context) {
        super.d(context);
        this.n = (SimpleAdInfoView) findViewById(R.id.ad_app_info_view);
    }

    public void setAdInfo(wm0 wm0Var) {
        this.m = wm0Var;
    }

    public HorizontalVideoTailView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalVideoTailView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void l(ClogBuilder.LogType logType, String str, um0 um0Var) {
        if (um0Var == null) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(logType);
        clogBuilder.j(str);
        clogBuilder.p(um0Var.r);
        jy0.e(clogBuilder);
    }

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public boolean j(um0 um0Var) {
        um0Var.u = false;
        boolean j = super.j(um0Var);
        wm0 wm0Var = this.m;
        if (wm0Var != null && wm0Var.l) {
            Resources resources = getContext().getResources();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.leftMargin = resources.getDimensionPixelOffset(R.dimen.nad_dimen_15dp);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(R.dimen.nad_dimen_15dp);
            this.n.setLayoutParams(layoutParams);
            this.n.setAdInfo(this.m);
            this.n.setVisibility(0);
            this.n.setAfterListener(new a(um0Var));
        } else {
            this.n.setVisibility(8);
        }
        return j;
    }
}
