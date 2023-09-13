package com.baidu.pass.ecommerce.common.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.pass.ecommerce.view.RotateYAnimation;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class CommonFootViewHolder extends BaseRecyclerViewHolder<Boolean> {
    public boolean isDarkMode;
    public TextView mFootTv;
    public View mFooterIc;

    public CommonFootViewHolder(@NonNull View view2, boolean z) {
        super(view2);
        this.mFooterIc = view2.findViewById(R.id.obfuscated_res_0x7f0920c1);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920c2);
        this.mFootTv = textView;
        this.isDarkMode = z;
        if (z) {
            textView.setTextColor(view2.getContext().getResources().getColor(R.color.obfuscated_res_0x7f060a0e));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pass.ecommerce.common.adapter.BaseRecyclerViewHolder
    public void bindData2View(int i, Boolean bool) {
        super.bindData2View(i, (int) bool);
        if (bool.booleanValue()) {
            this.mFooterIc.setVisibility(0);
            this.mFootTv.setText("正在加载...");
            RotateYAnimation rotateYAnimation = new RotateYAnimation();
            rotateYAnimation.setRepeatCount(-1);
            this.mFooterIc.startAnimation(rotateYAnimation);
            return;
        }
        this.mFooterIc.setVisibility(8);
        this.mFootTv.setText("已经到底啦");
    }
}
