package com.baidu.live.view.input;

import android.content.Context;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.widget.flex.FlexAdapter;
import com.baidu.live.tbadk.widget.flex.FlexLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class QuickImInputPanelView extends RelativeLayout {
    private FlexLayout aAU;
    private b aAV;
    private a aAW;
    private TextView aeT;

    /* loaded from: classes2.dex */
    public interface a {
        void r(String str, int i);
    }

    public QuickImInputPanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.aAW = aVar;
    }

    public void setData(List<String> list) {
        if (this.aAV == null) {
            this.aAV = new b(list);
            this.aAU.setAdapter(this.aAV);
            return;
        }
        this.aAV.setDatas(list);
        this.aAV.notifyDataSetChanged();
    }

    public void yJ() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aeT.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(12);
        } else {
            layoutParams.addRule(12, 0);
        }
        layoutParams.addRule(3, this.aAU.getId());
        this.aeT.setLayoutParams(layoutParams);
    }

    public void yK() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aeT.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(3);
        } else {
            layoutParams.addRule(3, 0);
        }
        layoutParams.addRule(12);
        this.aeT.setLayoutParams(layoutParams);
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.sdk_quick_im_input_panel, (ViewGroup) this, true);
        this.aAU = (FlexLayout) findViewById(a.g.layout_quick_input_flow);
        this.aAU.setHorizontalSpacing(getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.aAU.setVerticalSpacing(getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.aAU.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.view.input.QuickImInputPanelView.1
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                if (QuickImInputPanelView.this.aAW != null) {
                    QuickImInputPanelView.this.aAW.r(QuickImInputPanelView.this.aAV.getItem(i), i);
                }
            }
        });
        this.aeT = (TextView) findViewById(a.g.tv_quick_input_tip);
        ImageSpan imageSpan = new ImageSpan(getContext(), a.f.sdk_icon_live_quickpanel_hi);
        SpannableString spannableString = new SpannableString("点击发言区域的图也可以支持快捷输入");
        spannableString.setSpan(imageSpan, 7, 8, 18);
        this.aeT.setText(spannableString);
    }

    /* loaded from: classes2.dex */
    private static class b extends FlexAdapter<String> {
        b(List<String> list) {
            super(list);
        }

        @Override // com.baidu.live.tbadk.widget.flex.FlexAdapter
        public View getView(int i, ViewGroup viewGroup) {
            QuickInputFlexTextView quickInputFlexTextView = new QuickInputFlexTextView(viewGroup.getContext());
            quickInputFlexTextView.setText(getItem(i));
            return quickInputFlexTextView;
        }
    }
}
