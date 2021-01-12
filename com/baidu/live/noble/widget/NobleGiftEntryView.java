package com.baidu.live.noble.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
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
import androidx.annotation.Nullable;
import com.baidu.live.noble.data.NobleUserInfo;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes10.dex */
public class NobleGiftEntryView extends LinearLayout {
    private TextView aBG;
    private TbImageView bmv;
    private View btk;
    private TextView btl;
    private TextView btm;

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
            this.btk.setVisibility(8);
            this.btm.setVisibility(0);
            return;
        }
        this.btk.setVisibility(0);
        this.btm.setVisibility(8);
        if (!TextUtils.isEmpty(aVar.iconUrl)) {
            this.bmv.startLoad(aVar.iconUrl, 10, false, false);
        }
        this.aBG.setTextColor(getResources().getColor(a.c.sdk_noble_gift_entry_tip));
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
        this.btk = findViewById(a.f.layout_info);
        this.bmv = (TbImageView) findViewById(a.f.iv_icon);
        this.aBG = (TextView) findViewById(a.f.tv_content);
        this.btl = (TextView) findViewById(a.f.tv_action);
        this.btm = (TextView) findViewById(a.f.tv_error);
        this.bmv.setDefaultBgResource(a.c.sdk_transparent);
        this.bmv.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void b(NobleUserInfo.a aVar) {
        this.aBG.setTextColor(-2130706433);
        String str = aVar.price + "元/" + aVar.bsJ + "天";
        SpannableString spannableString = new SpannableString(String.format(getResources().getString(a.h.sdk_noble_giftentry_content_nonactivated), str, aVar.bsK));
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(a.c.sdk_noble_gift_entry_tip)), 3, str.length() + 3, 33);
        this.aBG.setText(spannableString);
        this.btl.setText("立即开通");
    }

    private void c(NobleUserInfo.a aVar) {
        this.aBG.setText(getResources().getString(a.h.sdk_noble_giftentry_content_protection));
        this.btl.setText("续费优惠");
    }

    private void d(NobleUserInfo.a aVar) {
        String format = String.format(getResources().getString(a.h.sdk_noble_giftentry_content_activated), aVar.bsJ);
        int indexOf = format.indexOf(aVar.bsJ);
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(a.d.sdk_fontsize26)), indexOf, aVar.bsJ.length() + indexOf, 33);
        this.aBG.setText(spannableString);
        this.btl.setText("查看详情");
    }

    private void e(NobleUserInfo.a aVar) {
        String format = String.format(getResources().getString(a.h.sdk_noble_giftentry_content_recharge), aVar.bsJ);
        int indexOf = format.indexOf(aVar.bsJ);
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(a.d.sdk_fontsize26)), indexOf, aVar.bsJ.length() + indexOf, 33);
        this.aBG.setText(spannableString);
        this.btl.setText("立即续费");
    }
}
