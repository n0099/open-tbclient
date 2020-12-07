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
    private TextView aYs;
    private a bYh;
    private FlexLayout buB;
    private b.a buG;

    public QuickImInputPanelView(Context context) {
        super(context);
        init();
    }

    @Override // com.baidu.live.im.d.b
    public void setCallback(b.a aVar) {
        this.buG = aVar;
    }

    @Override // com.baidu.live.im.d.b
    public void setData(List<String> list) {
        if (this.bYh == null) {
            this.bYh = new a(list);
            this.buB.setAdapter(this.bYh);
            return;
        }
        this.bYh.setDatas(list);
        this.bYh.notifyDataSetChanged();
    }

    @Override // com.baidu.live.im.d.b
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.d.b
    public void Ow() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aYs.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(12);
        } else {
            layoutParams.addRule(12, 0);
        }
        layoutParams.addRule(3, this.buB.getId());
        this.aYs.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.live.im.d.b
    public void Ox() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aYs.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(3);
        } else {
            layoutParams.addRule(3, 0);
        }
        layoutParams.addRule(12);
        this.aYs.setLayoutParams(layoutParams);
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.ala_quick_im_input_panel, (ViewGroup) this, true);
        this.buB = (FlexLayout) findViewById(a.f.layout_quick_input_flow);
        this.buB.setHorizontalSpacing(getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        this.buB.setVerticalSpacing(getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        this.buB.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.yuyinquick.QuickImInputPanelView.1
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                if (QuickImInputPanelView.this.buG != null) {
                    QuickImInputPanelView.this.buG.E(QuickImInputPanelView.this.bYh.getItem(i), i);
                }
            }
        });
        this.aYs = (TextView) findViewById(a.f.tv_quick_input_tip);
        ImageSpan imageSpan = new ImageSpan(getContext(), a.e.sdk_icon_live_quickpanel_hi);
        SpannableString spannableString = new SpannableString("点击发言区域的图也可以支持快捷输入");
        spannableString.setSpan(imageSpan, 7, 8, 18);
        this.aYs.setText(spannableString);
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
