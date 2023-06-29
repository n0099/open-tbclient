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
import com.baidu.tieba.bs0;
import com.baidu.tieba.ds0;
import com.baidu.tieba.fs0;
import com.baidu.tieba.r31;
/* loaded from: classes3.dex */
public class HorizontalVideoTailView extends AdBaseTailFrameView {
    public fs0 m;
    public SimpleAdInfoView n;

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public int f() {
        return R.layout.nad_horizontal_video_tail_view;
    }

    /* loaded from: classes3.dex */
    public class a implements SimpleAdInfoView.c {
        public final /* synthetic */ ds0 a;

        public a(ds0 ds0Var) {
            this.a = ds0Var;
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
        bs0 bs0Var;
        if (adBaseModel != null && (bs0Var = adBaseModel.j) != null) {
            return k(bs0Var.i);
        }
        return false;
    }

    public void setAdInfo(fs0 fs0Var) {
        this.m = fs0Var;
    }

    public HorizontalVideoTailView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalVideoTailView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m(ClogBuilder.LogType logType, String str, ds0 ds0Var) {
        if (ds0Var == null) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(logType);
        clogBuilder.j(str);
        clogBuilder.p(ds0Var.q);
        r31.b(clogBuilder);
    }

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public boolean k(ds0 ds0Var) {
        ds0Var.t = false;
        boolean k = super.k(ds0Var);
        fs0 fs0Var = this.m;
        if (fs0Var != null && fs0Var.k) {
            Resources resources = getContext().getResources();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.leftMargin = resources.getDimensionPixelOffset(R.dimen.nad_dimen_15dp);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(R.dimen.nad_dimen_15dp);
            this.n.setLayoutParams(layoutParams);
            this.n.setAdInfo(this.m);
            this.n.setVisibility(0);
            this.n.setAfterListener(new a(ds0Var));
        } else {
            this.n.setVisibility(8);
        }
        return k;
    }
}
