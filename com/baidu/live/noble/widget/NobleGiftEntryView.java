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
    private TextView aBe;
    private TbImageView bfB;
    private View bjk;
    private TextView bjl;
    private TextView bjm;

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
            this.bjk.setVisibility(8);
            this.bjm.setVisibility(0);
            return;
        }
        this.bjk.setVisibility(0);
        this.bjm.setVisibility(8);
        if (!TextUtils.isEmpty(aVar.iconUrl)) {
            this.bfB.startLoad(aVar.iconUrl, 10, false, false);
        }
        this.aBe.setTextColor(getResources().getColor(a.d.sdk_noble_gift_entry_tip));
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
        this.bjk = findViewById(a.g.layout_info);
        this.bfB = (TbImageView) findViewById(a.g.iv_icon);
        this.aBe = (TextView) findViewById(a.g.tv_content);
        this.bjl = (TextView) findViewById(a.g.tv_action);
        this.bjm = (TextView) findViewById(a.g.tv_error);
        this.bfB.setDefaultBgResource(a.d.sdk_transparent);
        this.bfB.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void b(NobleUserInfo.a aVar) {
        this.aBe.setTextColor(-2130706433);
        String str = aVar.price + "元/" + aVar.biM + "天";
        SpannableString spannableString = new SpannableString(String.format(getResources().getString(a.i.sdk_noble_giftentry_content_nonactivated), str, aVar.biN));
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(a.d.sdk_noble_gift_entry_tip)), 3, str.length() + 3, 33);
        this.aBe.setText(spannableString);
        this.bjl.setText("立即开通");
    }

    private void c(NobleUserInfo.a aVar) {
        this.aBe.setText(getResources().getString(a.i.sdk_noble_giftentry_content_protection));
        this.bjl.setText("续费优惠");
    }

    private void d(NobleUserInfo.a aVar) {
        String format = String.format(getResources().getString(a.i.sdk_noble_giftentry_content_activated), aVar.biM);
        int indexOf = format.indexOf(aVar.biM);
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(a.e.sdk_fontsize26)), indexOf, aVar.biM.length() + indexOf, 33);
        this.aBe.setText(spannableString);
        this.bjl.setText("查看详情");
    }

    private void e(NobleUserInfo.a aVar) {
        String format = String.format(getResources().getString(a.i.sdk_noble_giftentry_content_recharge), aVar.biM);
        int indexOf = format.indexOf(aVar.biM);
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(a.e.sdk_fontsize26)), indexOf, aVar.biM.length() + indexOf, 33);
        this.aBe.setText(spannableString);
        this.bjl.setText("立即续费");
    }
}
