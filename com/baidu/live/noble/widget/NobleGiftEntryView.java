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
/* loaded from: classes4.dex */
public class NobleGiftEntryView extends LinearLayout {
    private TextView aGc;
    private TbImageView bpz;
    private View btl;
    private TextView btm;
    private TextView bto;

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
            this.btl.setVisibility(8);
            this.bto.setVisibility(0);
            return;
        }
        this.btl.setVisibility(0);
        this.bto.setVisibility(8);
        if (!TextUtils.isEmpty(aVar.iconUrl)) {
            this.bpz.startLoad(aVar.iconUrl, 10, false, false);
        }
        this.aGc.setTextColor(getResources().getColor(a.c.sdk_noble_gift_entry_tip));
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
        LayoutInflater.from(getContext()).inflate(a.g.sdk_noble_widget_entry_bar, (ViewGroup) this, true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-14277340);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds12));
        setBackgroundDrawable(gradientDrawable);
        setGravity(16);
        setOrientation(0);
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0);
        this.btl = findViewById(a.f.layout_info);
        this.bpz = (TbImageView) findViewById(a.f.iv_icon);
        this.aGc = (TextView) findViewById(a.f.tv_content);
        this.btm = (TextView) findViewById(a.f.tv_action);
        this.bto = (TextView) findViewById(a.f.tv_error);
        this.bpz.setDefaultBgResource(a.c.sdk_transparent);
        this.bpz.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void b(NobleUserInfo.a aVar) {
        this.aGc.setTextColor(-2130706433);
        String str = aVar.price + "元/" + aVar.bsM + "天";
        SpannableString spannableString = new SpannableString(String.format(getResources().getString(a.h.sdk_noble_giftentry_content_nonactivated), str, aVar.bsN));
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(a.c.sdk_noble_gift_entry_tip)), 3, str.length() + 3, 33);
        this.aGc.setText(spannableString);
        this.btm.setText("立即开通");
    }

    private void c(NobleUserInfo.a aVar) {
        this.aGc.setText(getResources().getString(a.h.sdk_noble_giftentry_content_protection));
        this.btm.setText("续费优惠");
    }

    private void d(NobleUserInfo.a aVar) {
        String format = String.format(getResources().getString(a.h.sdk_noble_giftentry_content_activated), aVar.bsM);
        int indexOf = format.indexOf(aVar.bsM);
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(a.d.sdk_fontsize26)), indexOf, aVar.bsM.length() + indexOf, 33);
        this.aGc.setText(spannableString);
        this.btm.setText("查看详情");
    }

    private void e(NobleUserInfo.a aVar) {
        String format = String.format(getResources().getString(a.h.sdk_noble_giftentry_content_recharge), aVar.bsM);
        int indexOf = format.indexOf(aVar.bsM);
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(a.d.sdk_fontsize26)), indexOf, aVar.bsM.length() + indexOf, 33);
        this.aGc.setText(spannableString);
        this.btm.setText("立即续费");
    }
}
