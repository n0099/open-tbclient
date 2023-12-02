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
import com.baidu.tieba.dz0;
import com.baidu.tieba.nn0;
import com.baidu.tieba.pn0;
/* loaded from: classes3.dex */
public class HorizontalVideoTailView extends AdBaseTailFrameView {
    public pn0 m;
    public SimpleAdInfoView n;

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public int e() {
        return R.layout.nad_horizontal_video_tail_view;
    }

    /* loaded from: classes3.dex */
    public class a implements SimpleAdInfoView.c {
        public final /* synthetic */ nn0 a;

        public a(nn0 nn0Var) {
            this.a = nn0Var;
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

    public void setAdInfo(pn0 pn0Var) {
        this.m = pn0Var;
    }

    public HorizontalVideoTailView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalVideoTailView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void l(ClogBuilder.LogType logType, String str, nn0 nn0Var) {
        if (nn0Var == null) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(logType);
        clogBuilder.j(str);
        clogBuilder.p(nn0Var.r);
        dz0.e(clogBuilder);
    }

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public boolean j(nn0 nn0Var) {
        nn0Var.u = false;
        boolean j = super.j(nn0Var);
        pn0 pn0Var = this.m;
        if (pn0Var != null && pn0Var.m) {
            Resources resources = getContext().getResources();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.leftMargin = resources.getDimensionPixelOffset(R.dimen.nad_dimen_15dp);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(R.dimen.nad_dimen_15dp);
            this.n.setLayoutParams(layoutParams);
            this.n.setAdInfo(this.m);
            this.n.setVisibility(0);
            this.n.setAfterListener(new a(nn0Var));
        } else {
            this.n.setVisibility(8);
        }
        return j;
    }
}
