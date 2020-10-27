package com.baidu.live.yuyinquick;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.im.d.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.flex.FlexAdapter;
import com.baidu.live.tbadk.widget.flex.FlexLayout;
import java.util.List;
/* loaded from: classes4.dex */
public class QuickImInputPanelView extends RelativeLayout implements com.baidu.live.im.d.b {
    private TextView aVA;
    private a bOR;
    private FlexLayout bpI;
    private b.a bpN;

    public QuickImInputPanelView(Context context) {
        super(context);
        init();
    }

    @Override // com.baidu.live.im.d.b
    public void setCallback(b.a aVar) {
        this.bpN = aVar;
    }

    @Override // com.baidu.live.im.d.b
    public void setData(List<String> list) {
        if (this.bOR == null) {
            this.bOR = new a(list);
            this.bpI.setAdapter(this.bOR);
            return;
        }
        this.bOR.setDatas(list);
        this.bOR.notifyDataSetChanged();
    }

    @Override // com.baidu.live.im.d.b
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.d.b
    public void Mk() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aVA.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(12);
        } else {
            layoutParams.addRule(12, 0);
        }
        layoutParams.addRule(3, this.bpI.getId());
        this.aVA.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.live.im.d.b
    public void Ml() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aVA.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(3);
        } else {
            layoutParams.addRule(3, 0);
        }
        layoutParams.addRule(12);
        this.aVA.setLayoutParams(layoutParams);
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_quick_im_input_panel, (ViewGroup) this, true);
        this.bpI = (FlexLayout) findViewById(a.g.layout_quick_input_flow);
        this.bpI.setHorizontalSpacing(getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.bpI.setVerticalSpacing(getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.bpI.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.yuyinquick.QuickImInputPanelView.1
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                if (QuickImInputPanelView.this.bpN != null) {
                    QuickImInputPanelView.this.bpN.C(QuickImInputPanelView.this.bOR.getItem(i), i);
                }
            }
        });
        this.aVA = (TextView) findViewById(a.g.tv_quick_input_tip);
        ImageSpan imageSpan = new ImageSpan(getContext(), a.f.sdk_icon_live_quickpanel_hi);
        SpannableString spannableString = new SpannableString("点击发言区域的图也可以支持快捷输入");
        spannableString.setSpan(imageSpan, 7, 8, 18);
        this.aVA.setText(spannableString);
    }

    /* loaded from: classes4.dex */
    private static class a extends FlexAdapter<String> {
        a(List<String> list) {
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
