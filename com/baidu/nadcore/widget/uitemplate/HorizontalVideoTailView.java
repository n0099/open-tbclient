package com.baidu.nadcore.widget.uitemplate;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.player.tail.AdBaseTailFrameView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.tieba.R;
import com.baidu.tieba.as0;
import com.baidu.tieba.wr0;
import com.baidu.tieba.x31;
import com.baidu.tieba.yr0;
/* loaded from: classes3.dex */
public class HorizontalVideoTailView extends AdBaseTailFrameView {
    public as0 m;
    public SimpleAdInfoView n;

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public int f() {
        return R.layout.nad_horizontal_video_tail_view;
    }

    /* loaded from: classes3.dex */
    public class a implements SimpleAdInfoView.c {
        public final /* synthetic */ yr0 a;

        public a(yr0 yr0Var) {
            this.a = yr0Var;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            HorizontalVideoTailView.this.m(ClogBuilder.LogType.FREE_CLICK, str, this.a);
        }
    }

    public HorizontalVideoTailView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public void e(Context context) {
        super.e(context);
        this.n = (SimpleAdInfoView) findViewById(R.id.ad_app_info_view);
    }

    public boolean n(AdBaseModel adBaseModel) {
        wr0 wr0Var;
        if (adBaseModel != null && (wr0Var = adBaseModel.j) != null) {
            return k(wr0Var.i);
        }
        return false;
    }

    public void setAdInfo(as0 as0Var) {
        this.m = as0Var;
    }

    public HorizontalVideoTailView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalVideoTailView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m(ClogBuilder.LogType logType, String str, yr0 yr0Var) {
        if (yr0Var == null) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(logType);
        clogBuilder.j(str);
        clogBuilder.p(yr0Var.r);
        x31.e(clogBuilder);
    }

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public boolean k(yr0 yr0Var) {
        yr0Var.u = false;
        boolean k = super.k(yr0Var);
        as0 as0Var = this.m;
        if (as0Var != null && as0Var.l) {
            Resources resources = getContext().getResources();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.leftMargin = resources.getDimensionPixelOffset(R.dimen.nad_dimen_15dp);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(R.dimen.nad_dimen_15dp);
            this.n.setLayoutParams(layoutParams);
            this.n.setAdInfo(this.m);
            this.n.setVisibility(0);
            this.n.setAfterListener(new a(yr0Var));
        } else {
            this.n.setVisibility(8);
        }
        return k;
    }
}
