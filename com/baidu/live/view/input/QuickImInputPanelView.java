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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.widget.flex.FlexAdapter;
import com.baidu.live.tbadk.widget.flex.FlexLayout;
import java.util.List;
/* loaded from: classes6.dex */
public class QuickImInputPanelView extends RelativeLayout {
    private TextView Xi;
    private FlexLayout ata;
    private b atb;
    private a atc;

    /* loaded from: classes6.dex */
    public interface a {
        void n(String str, int i);
    }

    public QuickImInputPanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.atc = aVar;
    }

    public void setData(List<String> list) {
        if (this.atb == null) {
            this.atb = new b(list);
            this.ata.setAdapter(this.atb);
            return;
        }
        this.atb.setDatas(list);
        this.atb.notifyDataSetChanged();
    }

    public void wK() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Xi.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(12);
        } else {
            layoutParams.addRule(12, 0);
        }
        layoutParams.addRule(3, this.ata.getId());
        this.Xi.setLayoutParams(layoutParams);
    }

    public void wL() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Xi.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(3);
        } else {
            layoutParams.addRule(3, 0);
        }
        layoutParams.addRule(12);
        this.Xi.setLayoutParams(layoutParams);
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.sdk_quick_im_input_panel, (ViewGroup) this, true);
        this.ata = (FlexLayout) findViewById(a.g.layout_quick_input_flow);
        this.ata.setHorizontalSpacing(getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.ata.setVerticalSpacing(getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.ata.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.view.input.QuickImInputPanelView.1
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                if (QuickImInputPanelView.this.atc != null) {
                    QuickImInputPanelView.this.atc.n(QuickImInputPanelView.this.atb.getItem(i), i);
                }
            }
        });
        this.Xi = (TextView) findViewById(a.g.tv_quick_input_tip);
        ImageSpan imageSpan = new ImageSpan(getContext(), a.f.sdk_icon_live_quickpanel_hi);
        SpannableString spannableString = new SpannableString("点击发言区域的图也可以支持快捷输入");
        spannableString.setSpan(imageSpan, 7, 8, 18);
        this.Xi.setText(spannableString);
    }

    /* loaded from: classes6.dex */
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
