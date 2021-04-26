package com.baidu.android.lbspay.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ChannelDescLayout extends LinearLayout {
    public List<TextView> descListViews;
    public int mwidth;

    public ChannelDescLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.descListViews = null;
        this.mwidth = 0;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.android.lbspay.view.ChannelDescLayout.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int i2;
                int childCount = ChannelDescLayout.this.getChildCount();
                int paddingLeft = ChannelDescLayout.this.getPaddingLeft();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = ChannelDescLayout.this.getChildAt(i3);
                    if (childAt instanceof TextView) {
                        TextView textView = (TextView) childAt;
                        i2 = ((int) (textView.getPaint().measureText(textView.getText().toString()) + 0.5d)) + childAt.getPaddingLeft() + childAt.getPaddingRight();
                    } else {
                        i2 = 10;
                    }
                    paddingLeft += i2;
                    if (ChannelDescLayout.this.mwidth < paddingLeft) {
                        return;
                    }
                    childAt.setVisibility(0);
                }
            }
        });
    }

    private String[] getChannelDesc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("\\|");
    }

    private View makeGapView() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        View view = new View(getContext());
        layoutParams.width = 10;
        layoutParams.height = 1;
        view.setLayoutParams(layoutParams);
        return view;
    }

    private TextView makeTextView(String str) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, ResUtils.getDimension(getContext(), "lbspay_textsize_10"));
        textView.setLayoutParams(layoutParams);
        textView.setText(str);
        textView.setSingleLine(true);
        textView.setBackgroundResource(ResUtils.drawable(getContext(), "wallet_juhe_channel_desc_bg"));
        textView.setPadding(8, 4, 8, 4);
        int color = ResUtils.getColor(getContext(), "lbspay_color_e85352");
        textView.setTextColor(Color.argb(178, Color.red(color), Color.green(color), Color.blue(color)));
        return textView;
    }

    public void addDescView(String str) {
        if (this.descListViews != null) {
            this.descListViews = null;
        }
        this.descListViews = new ArrayList();
        String[] channelDesc = getChannelDesc(str);
        if (channelDesc == null || channelDesc.length <= 0) {
            return;
        }
        for (int i2 = 0; i2 < channelDesc.length; i2++) {
            if (!TextUtils.isEmpty(channelDesc[i2].trim())) {
                TextView makeTextView = makeTextView(channelDesc[i2]);
                makeTextView.setVisibility(8);
                addView(makeTextView);
                this.descListViews.add(makeTextView);
                View makeGapView = makeGapView();
                makeGapView.setVisibility(8);
                addView(makeGapView);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.mwidth = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
    }

    public void setTextColor(int i2) {
        List<TextView> list = this.descListViews;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < this.descListViews.size(); i3++) {
            this.descListViews.get(i3).setTextColor(i2);
        }
    }
}
