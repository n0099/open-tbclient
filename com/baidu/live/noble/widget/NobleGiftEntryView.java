package com.baidu.live.noble.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.noble.data.NobleUserInfo;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes7.dex */
public class NobleGiftEntryView extends LinearLayout {
    private TextView aAw;
    private TbImageView bcK;
    private View bgq;
    private TextView bgr;
    private TextView bgt;

    public NobleGiftEntryView(Context context) {
        super(context);
        init();
    }

    public NobleGiftEntryView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public NobleGiftEntryView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setData(NobleUserInfo.a aVar) {
        if (aVar == null) {
            this.bgq.setVisibility(8);
            this.bgt.setVisibility(0);
            return;
        }
        this.bgq.setVisibility(0);
        this.bgt.setVisibility(8);
        if (!TextUtils.isEmpty(aVar.iconUrl)) {
            this.bcK.startLoad(aVar.iconUrl, 10, false, false);
        }
        this.aAw.setTextColor(getResources().getColor(a.d.sdk_noble_gift_entry_tip));
        switch (aVar.typeId) {
            case 1:
                b(aVar);
                return;
            case 2:
                c(aVar);
                return;
            case 3:
                d(aVar);
                return;
            case 4:
                e(aVar);
                return;
            default:
                return;
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.sdk_noble_widget_entry_bar, (ViewGroup) this, true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-14277340);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds12));
        setBackgroundDrawable(gradientDrawable);
        setGravity(16);
        setOrientation(0);
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0);
        this.bgq = findViewById(a.g.layout_info);
        this.bcK = (TbImageView) findViewById(a.g.iv_icon);
        this.aAw = (TextView) findViewById(a.g.tv_content);
        this.bgr = (TextView) findViewById(a.g.tv_action);
        this.bgt = (TextView) findViewById(a.g.tv_error);
        this.bcK.setDefaultBgResource(a.d.sdk_transparent);
        this.bcK.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void b(NobleUserInfo.a aVar) {
        this.aAw.setTextColor(-2130706433);
        String str = aVar.price + "元/" + aVar.bfS + "天";
        SpannableString spannableString = new SpannableString(String.format(getResources().getString(a.i.sdk_noble_giftentry_content_nonactivated), str, aVar.bfT));
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(a.d.sdk_noble_gift_entry_tip)), 3, str.length() + 3, 33);
        this.aAw.setText(spannableString);
        this.bgr.setText("立即开通");
    }

    private void c(NobleUserInfo.a aVar) {
        this.aAw.setText(getResources().getString(a.i.sdk_noble_giftentry_content_protection));
        this.bgr.setText("续费优惠");
    }

    private void d(NobleUserInfo.a aVar) {
        String format = String.format(getResources().getString(a.i.sdk_noble_giftentry_content_activated), aVar.bfS);
        int indexOf = format.indexOf(aVar.bfS);
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(a.e.sdk_fontsize26)), indexOf, aVar.bfS.length() + indexOf, 33);
        this.aAw.setText(spannableString);
        this.bgr.setText("查看详情");
    }

    private void e(NobleUserInfo.a aVar) {
        String format = String.format(getResources().getString(a.i.sdk_noble_giftentry_content_recharge), aVar.bfS);
        int indexOf = format.indexOf(aVar.bfS);
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(a.e.sdk_fontsize26)), indexOf, aVar.bfS.length() + indexOf, 33);
        this.aAw.setText(spannableString);
        this.bgr.setText("立即续费");
    }
}
