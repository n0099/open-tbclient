package com.baidu.tbadk.coreExtra.act;

import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        Button button;
        RadioButton radioButton;
        RadioButton radioButton2;
        RadioButton radioButton3;
        RadioButton radioButton4;
        RadioButton radioButton5;
        HorizontalScrollView horizontalScrollView;
        RadioButton radioButton6;
        boolean z;
        linearLayout = this.this$0.Px;
        linearLayout.setVisibility(0);
        button = this.this$0.Pq;
        button.setVisibility(8);
        if (Build.VERSION.SDK_INT >= 7) {
            z = this.this$0.PE;
            if (z) {
                return;
            }
        }
        radioButton = this.this$0.Pv;
        radioButton2 = this.this$0.Pv;
        int paddingTop = radioButton2.getPaddingTop();
        radioButton3 = this.this$0.Pv;
        int paddingRight = radioButton3.getPaddingRight();
        radioButton4 = this.this$0.Pv;
        radioButton.setPadding(0, paddingTop, paddingRight, radioButton4.getPaddingBottom());
        radioButton5 = this.this$0.Pv;
        radioButton5.setChecked(true);
        horizontalScrollView = this.this$0.Pr;
        horizontalScrollView.setVisibility(8);
        radioButton6 = this.this$0.Pu;
        radioButton6.setVisibility(8);
    }
}
