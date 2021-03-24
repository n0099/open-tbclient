package com.baidu.pass.ecommerce.common.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.pass.ecommerce.view.RotateYAnimation;
import com.baidu.sapi2.ecommerce.R;
/* loaded from: classes2.dex */
public class CommonFootViewHolder extends BaseRecyclerViewHolder<Boolean> {
    public boolean isDarkMode;
    public TextView mFootTv;
    public View mFooterIc;

    public CommonFootViewHolder(@NonNull View view, boolean z) {
        super(view);
        this.mFooterIc = view.findViewById(R.id.sapi_sdk_load_more_ic);
        TextView textView = (TextView) view.findViewById(R.id.sapi_sdk_load_more_tip);
        this.mFootTv = textView;
        this.isDarkMode = z;
        if (z) {
            textView.setTextColor(view.getContext().getResources().getColor(R.color.sapi_sdk_addr_load_more_loading_text_dark_color));
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
