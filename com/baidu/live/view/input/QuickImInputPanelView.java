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
    private TextView XA;
    private FlexLayout ats;
    private b att;
    private a atu;

    /* loaded from: classes6.dex */
    public interface a {
        void n(String str, int i);
    }

    public QuickImInputPanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.atu = aVar;
    }

    public void setData(List<String> list) {
        if (this.att == null) {
            this.att = new b(list);
            this.ats.setAdapter(this.att);
            return;
        }
        this.att.setDatas(list);
        this.att.notifyDataSetChanged();
    }

    public void wJ() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.XA.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(12);
        } else {
            layoutParams.addRule(12, 0);
        }
        layoutParams.addRule(3, this.ats.getId());
        this.XA.setLayoutParams(layoutParams);
    }

    public void wK() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.XA.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(3);
        } else {
            layoutParams.addRule(3, 0);
        }
        layoutParams.addRule(12);
        this.XA.setLayoutParams(layoutParams);
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.sdk_quick_im_input_panel, (ViewGroup) this, true);
        this.ats = (FlexLayout) findViewById(a.g.layout_quick_input_flow);
        this.ats.setHorizontalSpacing(getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.ats.setVerticalSpacing(getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.ats.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.view.input.QuickImInputPanelView.1
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                if (QuickImInputPanelView.this.atu != null) {
                    QuickImInputPanelView.this.atu.n(QuickImInputPanelView.this.att.getItem(i), i);
                }
            }
        });
        this.XA = (TextView) findViewById(a.g.tv_quick_input_tip);
        ImageSpan imageSpan = new ImageSpan(getContext(), a.f.sdk_icon_live_quickpanel_hi);
        SpannableString spannableString = new SpannableString("点击发言区域的图也可以支持快捷输入");
        spannableString.setSpan(imageSpan, 7, 8, 18);
        this.XA.setText(spannableString);
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
