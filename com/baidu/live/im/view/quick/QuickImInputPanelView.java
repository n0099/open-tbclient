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
    private TextView ahK;
    private FlexLayout avI;
    private b avL;
    private a avM;

    /* loaded from: classes3.dex */
    public interface a {
        void r(String str, int i);
    }

    public QuickImInputPanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.avM = aVar;
    }

    public void setData(List<String> list) {
        if (this.avL == null) {
            this.avL = new b(list);
            this.avI.setAdapter(this.avL);
            return;
        }
        this.avL.setDatas(list);
        this.avL.notifyDataSetChanged();
    }

    public void yk() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ahK.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(12);
        } else {
            layoutParams.addRule(12, 0);
        }
        layoutParams.addRule(3, this.avI.getId());
        this.ahK.setLayoutParams(layoutParams);
    }

    public void yl() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ahK.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(3);
        } else {
            layoutParams.addRule(3, 0);
        }
        layoutParams.addRule(12);
        this.ahK.setLayoutParams(layoutParams);
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_quick_im_input_panel, (ViewGroup) this, true);
        this.avI = (FlexLayout) findViewById(a.g.layout_quick_input_flow);
        this.avI.setHorizontalSpacing(getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.avI.setVerticalSpacing(getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.avI.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.im.view.quick.QuickImInputPanelView.1
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                if (QuickImInputPanelView.this.avM != null) {
                    QuickImInputPanelView.this.avM.r(QuickImInputPanelView.this.avL.getItem(i), i);
                }
            }
        });
        this.ahK = (TextView) findViewById(a.g.tv_quick_input_tip);
        ImageSpan imageSpan = new ImageSpan(getContext(), a.f.sdk_icon_live_quickpanel_hi);
        SpannableString spannableString = new SpannableString("点击发言区域的图也可以支持快捷输入");
        spannableString.setSpan(imageSpan, 7, 8, 18);
        this.ahK.setText(spannableString);
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
