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
import com.baidu.tieba.k11;
import com.baidu.tieba.up0;
import com.baidu.tieba.wp0;
import com.baidu.tieba.yp0;
/* loaded from: classes2.dex */
public class HorizontalVideoTailView extends AdBaseTailFrameView {
    public yp0 m;
    public SimpleAdInfoView n;

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public int f() {
        return R.layout.nad_horizontal_video_tail_view;
    }

    /* loaded from: classes2.dex */
    public class a implements SimpleAdInfoView.c {
        public final /* synthetic */ wp0 a;

        public a(wp0 wp0Var) {
            this.a = wp0Var;
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
        up0 up0Var;
        if (adBaseModel != null && (up0Var = adBaseModel.j) != null) {
            return k(up0Var.i);
        }
        return false;
    }

    public void setAdInfo(yp0 yp0Var) {
        this.m = yp0Var;
    }

    public HorizontalVideoTailView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalVideoTailView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m(ClogBuilder.LogType logType, String str, wp0 wp0Var) {
        if (wp0Var == null) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(logType);
        clogBuilder.j(str);
        clogBuilder.p(wp0Var.q);
        k11.b(clogBuilder);
    }

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public boolean k(wp0 wp0Var) {
        wp0Var.t = false;
        boolean k = super.k(wp0Var);
        yp0 yp0Var = this.m;
        if (yp0Var != null && yp0Var.k) {
            Resources resources = getContext().getResources();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.leftMargin = resources.getDimensionPixelOffset(R.dimen.nad_dimen_15dp);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(R.dimen.nad_dimen_15dp);
            this.n.setLayoutParams(layoutParams);
            this.n.setAdInfo(this.m);
            this.n.setVisibility(0);
            this.n.setAfterListener(new a(wp0Var));
        } else {
            this.n.setVisibility(8);
        }
        return k;
    }
}
