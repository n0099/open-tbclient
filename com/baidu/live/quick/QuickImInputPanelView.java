package com.baidu.live.quick;

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
    private TextView aJF;
    private FlexLayout bbI;
    private a bbM;
    private b.a bbN;

    public QuickImInputPanelView(Context context) {
        super(context);
        init();
    }

    @Override // com.baidu.live.im.d.b
    public void setCallback(b.a aVar) {
        this.bbN = aVar;
    }

    @Override // com.baidu.live.im.d.b
    public void setData(List<String> list) {
        if (this.bbM == null) {
            this.bbM = new a(list);
            this.bbI.setAdapter(this.bbM);
            return;
        }
        this.bbM.setDatas(list);
        this.bbM.notifyDataSetChanged();
    }

    @Override // com.baidu.live.im.d.b
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.d.b
    public void Ez() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aJF.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(12);
        } else {
            layoutParams.addRule(12, 0);
        }
        layoutParams.addRule(3, this.bbI.getId());
        this.aJF.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.live.im.d.b
    public void EA() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aJF.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(3);
        } else {
            layoutParams.addRule(3, 0);
        }
        layoutParams.addRule(12);
        this.aJF.setLayoutParams(layoutParams);
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_quick_im_input_panel, (ViewGroup) this, true);
        this.bbI = (FlexLayout) findViewById(a.g.layout_quick_input_flow);
        this.bbI.setHorizontalSpacing(getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.bbI.setVerticalSpacing(getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.bbI.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.quick.QuickImInputPanelView.1
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                if (QuickImInputPanelView.this.bbN != null) {
                    QuickImInputPanelView.this.bbN.B(QuickImInputPanelView.this.bbM.getItem(i), i);
                }
            }
        });
        this.aJF = (TextView) findViewById(a.g.tv_quick_input_tip);
        ImageSpan imageSpan = new ImageSpan(getContext(), a.f.sdk_icon_live_quickpanel_hi);
        SpannableString spannableString = new SpannableString("点击发言区域的图也可以支持快捷输入");
        spannableString.setSpan(imageSpan, 7, 8, 18);
        this.aJF.setText(spannableString);
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
