package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ThreadCardBottomOpSegmentLayout extends ThreadCommentAndPraiseInfoLayout {
    private AgreeView.a edm;

    public ThreadCardBottomOpSegmentLayout(Context context) {
        super(context);
        this.edm = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentLayout.this.z(ThreadCardBottomOpSegmentLayout.this.aPZ(), z);
            }
        };
    }

    public ThreadCardBottomOpSegmentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.edm = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentLayout.this.z(ThreadCardBottomOpSegmentLayout.this.aPZ(), z);
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View dL(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aYu() {
        this.edr.setVisibilityListener(this.edm);
        boolean aPZ = aPZ();
        if (hu(aPZ) || hv(aPZ)) {
            this.edr.hn(aPZ);
            hw(aPZ());
        }
    }

    private boolean hu(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.edw.getLayoutParams();
        float f = layoutParams.weight;
        int i = layoutParams.width;
        if (z) {
            if (f != 1.0f || i != 0) {
                return true;
            }
        } else if (f != 0.0f || i != -2) {
            return true;
        }
        return false;
    }

    private boolean hv(boolean z) {
        boolean aXM = this.edr.aXM();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.edr.getLayoutParams();
        int i = layoutParams.width;
        float f = layoutParams.weight;
        if (z) {
            if (f != (aXM ? 1.0f : 2.0f) || i != 0) {
                return true;
            }
        } else if (f != 0.0f || i != -2) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aYv() {
        z(aPZ(), this.edr.aXM());
    }

    private void hw(boolean z) {
        if (z) {
            a(0, -1, 0, 1.0f, true, this.edr.aXM());
            return;
        }
        a(-2, -1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds78), 0.0f, false, this.edr.aXM());
    }

    private void a(int i, int i2, int i3, float f, boolean z, boolean z2) {
        this.edw.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.edD.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.edD.setLayoutParams(layoutParams);
        this.edt.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eds.getLayoutParams();
        layoutParams2.leftMargin = i3;
        this.eds.setLayoutParams(layoutParams2);
        this.edB.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.edA.getLayoutParams();
        layoutParams3.leftMargin = i3;
        this.edA.setLayoutParams(layoutParams3);
        this.edE.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.cpN.getLayoutParams();
        layoutParams4.leftMargin = i3;
        this.cpN.setLayoutParams(layoutParams4);
        z(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.edr.getLayoutParams();
        int i = layoutParams.width;
        float f = layoutParams.weight;
        if (z) {
            float f2 = z2 ? 1.0f : 2.0f;
            if (f != f2 || i != 0) {
                layoutParams.width = 0;
                layoutParams.weight = f2;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                this.edr.setLayoutParams(layoutParams);
            }
        } else if (f != 0.0f || i != -2) {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds50);
            layoutParams.rightMargin = 0;
            this.edr.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aPZ() {
        return this.aeK != null && this.aeK.aPZ();
    }
}
