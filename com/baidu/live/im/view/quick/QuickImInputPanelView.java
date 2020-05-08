package com.baidu.live.im.view.quick;

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
import com.baidu.live.tbadk.widget.flex.FlexAdapter;
import com.baidu.live.tbadk.widget.flex.FlexLayout;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class QuickImInputPanelView extends RelativeLayout {
    private TextView aAu;
    private FlexLayout aPB;
    private b aPE;
    private a aPF;

    /* loaded from: classes3.dex */
    public interface a {
        void y(String str, int i);
    }

    public QuickImInputPanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.aPF = aVar;
    }

    public void setData(List<String> list) {
        if (this.aPE == null) {
            this.aPE = new b(list);
            this.aPB.setAdapter(this.aPE);
            return;
        }
        this.aPE.setDatas(list);
        this.aPE.notifyDataSetChanged();
    }

    public void Di() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aAu.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(12);
        } else {
            layoutParams.addRule(12, 0);
        }
        layoutParams.addRule(3, this.aPB.getId());
        this.aAu.setLayoutParams(layoutParams);
    }

    public void Dj() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aAu.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(3);
        } else {
            layoutParams.addRule(3, 0);
        }
        layoutParams.addRule(12);
        this.aAu.setLayoutParams(layoutParams);
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_quick_im_input_panel, (ViewGroup) this, true);
        this.aPB = (FlexLayout) findViewById(a.g.layout_quick_input_flow);
        this.aPB.setHorizontalSpacing(getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.aPB.setVerticalSpacing(getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.aPB.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.im.view.quick.QuickImInputPanelView.1
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                if (QuickImInputPanelView.this.aPF != null) {
                    QuickImInputPanelView.this.aPF.y(QuickImInputPanelView.this.aPE.getItem(i), i);
                }
            }
        });
        this.aAu = (TextView) findViewById(a.g.tv_quick_input_tip);
        ImageSpan imageSpan = new ImageSpan(getContext(), a.f.sdk_icon_live_quickpanel_hi);
        SpannableString spannableString = new SpannableString("点击发言区域的图也可以支持快捷输入");
        spannableString.setSpan(imageSpan, 7, 8, 18);
        this.aAu.setText(spannableString);
    }

    /* loaded from: classes3.dex */
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
