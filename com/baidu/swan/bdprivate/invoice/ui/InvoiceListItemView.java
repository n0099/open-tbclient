package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.widget.CommonTagView;
/* loaded from: classes9.dex */
public class InvoiceListItemView extends FrameLayout {
    private PartingLineView cat;
    private View cau;
    private ImageView cav;
    private TextView caw;
    private ImageView cax;
    private TextView cay;
    private View mBottomView;
    private Context mContext;

    public InvoiceListItemView(Context context) {
        this(context, null);
    }

    public InvoiceListItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InvoiceListItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(b.f.invoice_item_view, (ViewGroup) this, true);
        this.cat = (PartingLineView) findViewById(b.e.parting_line_view);
        this.cat.setBgNormalColor(b.C0306b.invoice_bg_normal_color);
        this.cat.setBgPressedColor(b.C0306b.invoice_bg_pressed_color);
        this.cat.setBorderColor(b.C0306b.invoice_bg_border_color);
        this.cat.setDividerLineColor(b.C0306b.invoice_bg_divider_line_color);
        this.mBottomView = LayoutInflater.from(context).inflate(b.f.invoice_item_bottom_view, (ViewGroup) null);
        this.cav = (ImageView) this.mBottomView.findViewById(b.e.invoice_current_use_img);
        this.caw = (TextView) this.mBottomView.findViewById(b.e.invoice_current_use_txt);
        this.cax = (ImageView) this.mBottomView.findViewById(b.e.invoice_edit_img);
        this.cay = (TextView) this.mBottomView.findViewById(b.e.invoice_edit);
        this.cav.setImageDrawable(getResources().getDrawable(b.d.invoice_default_select));
        this.caw.setTextColor(getResources().getColor(b.C0306b.invoice_bottom_text));
        this.cax.setImageDrawable(getResources().getDrawable(b.d.invoice_edit_img));
        this.cay.setTextColor(getResources().getColor(b.C0306b.invoice_bottom_text));
        this.cav.setVisibility(4);
        this.caw.setVisibility(4);
        setClickable(true);
    }

    public void agi() {
        this.cau = LayoutInflater.from(this.mContext).inflate(b.f.invoice_item_top_company_view, (ViewGroup) null);
        ((TextView) this.cau.findViewById(b.e.invoice_company_title_txt)).setTextColor(getResources().getColor(b.C0306b.invoice_top_title_color));
        ((TextView) this.cau.findViewById(b.e.tax_number_txt)).setTextColor(getResources().getColor(b.C0306b.invoice_top_tax_number_color));
        ((CommonTagView) this.cau.findViewById(b.e.common_tag_company)).setTextColor(getResources().getColor(b.C0306b.invoice_top_tag_color));
        if (this.cat != null) {
            this.cat.setContentView(this.cau, this.mBottomView);
        }
    }

    public void agj() {
        this.cau = LayoutInflater.from(this.mContext).inflate(b.f.invoice_item_top_personage_view, (ViewGroup) null);
        ((TextView) this.cau.findViewById(b.e.invoice_personal_title_txt)).setTextColor(getResources().getColor(b.C0306b.invoice_top_title_color));
        ((CommonTagView) this.cau.findViewById(b.e.invoice_personal_tag)).setTextColor(getResources().getColor(b.C0306b.invoice_top_tag_color));
        if (this.cat != null) {
            this.cat.setContentView(this.cau, this.mBottomView);
        }
    }

    public void setCompanyInfo(String str, String str2) {
        if (this.cau != null) {
            TextView textView = (TextView) this.cau.findViewById(b.e.invoice_company_title_txt);
            TextView textView2 = (TextView) this.cau.findViewById(b.e.tax_number_txt);
            if (textView != null) {
                textView.setText(str);
            }
            if (textView2 != null) {
                textView2.setText(str2);
            }
        }
    }

    public void setPersonageInfo(String str) {
        TextView textView;
        if (this.cau != null && (textView = (TextView) this.cau.findViewById(b.e.invoice_personal_title_txt)) != null) {
            textView.setText(str);
        }
    }

    public void setEditClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            if (this.cay != null) {
                this.cay.setOnClickListener(onClickListener);
            }
            if (this.cax != null) {
                this.cax.setOnClickListener(onClickListener);
            }
        }
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }

    public void eg(boolean z) {
        int i = z ? 0 : 4;
        if (this.cav != null) {
            this.cav.setVisibility(i);
        }
        if (this.caw != null) {
            this.caw.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        eh(z);
        super.setPressed(z);
    }

    private void eh(boolean z) {
        if (this.cat != null) {
            this.cat.ei(z);
        }
    }
}
