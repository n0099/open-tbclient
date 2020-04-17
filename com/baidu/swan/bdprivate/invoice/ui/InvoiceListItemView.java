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
/* loaded from: classes11.dex */
public class InvoiceListItemView extends FrameLayout {
    private PartingLineView cDW;
    private View cDX;
    private ImageView cDY;
    private TextView cDZ;
    private ImageView cEa;
    private TextView cEb;
    private View cat;
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
        this.cDW = (PartingLineView) findViewById(b.e.parting_line_view);
        this.cDW.setBgNormalColor(b.C0348b.invoice_bg_normal_color);
        this.cDW.setBgPressedColor(b.C0348b.invoice_bg_pressed_color);
        this.cDW.setBorderColor(b.C0348b.invoice_bg_border_color);
        this.cDW.setDividerLineColor(b.C0348b.invoice_bg_divider_line_color);
        this.cat = LayoutInflater.from(context).inflate(b.f.invoice_item_bottom_view, (ViewGroup) null);
        this.cDY = (ImageView) this.cat.findViewById(b.e.invoice_current_use_img);
        this.cDZ = (TextView) this.cat.findViewById(b.e.invoice_current_use_txt);
        this.cEa = (ImageView) this.cat.findViewById(b.e.invoice_edit_img);
        this.cEb = (TextView) this.cat.findViewById(b.e.invoice_edit);
        this.cDY.setImageDrawable(getResources().getDrawable(b.d.invoice_default_select));
        this.cDZ.setTextColor(getResources().getColor(b.C0348b.invoice_bottom_text));
        this.cEa.setImageDrawable(getResources().getDrawable(b.d.invoice_edit_img));
        this.cEb.setTextColor(getResources().getColor(b.C0348b.invoice_bottom_text));
        this.cDY.setVisibility(4);
        this.cDZ.setVisibility(4);
        setClickable(true);
    }

    public void arc() {
        this.cDX = LayoutInflater.from(this.mContext).inflate(b.f.invoice_item_top_company_view, (ViewGroup) null);
        ((TextView) this.cDX.findViewById(b.e.invoice_company_title_txt)).setTextColor(getResources().getColor(b.C0348b.invoice_top_title_color));
        ((TextView) this.cDX.findViewById(b.e.tax_number_txt)).setTextColor(getResources().getColor(b.C0348b.invoice_top_tax_number_color));
        ((CommonTagView) this.cDX.findViewById(b.e.common_tag_company)).setTextColor(getResources().getColor(b.C0348b.invoice_top_tag_color));
        if (this.cDW != null) {
            this.cDW.setContentView(this.cDX, this.cat);
        }
    }

    public void ard() {
        this.cDX = LayoutInflater.from(this.mContext).inflate(b.f.invoice_item_top_personage_view, (ViewGroup) null);
        ((TextView) this.cDX.findViewById(b.e.invoice_personal_title_txt)).setTextColor(getResources().getColor(b.C0348b.invoice_top_title_color));
        ((CommonTagView) this.cDX.findViewById(b.e.invoice_personal_tag)).setTextColor(getResources().getColor(b.C0348b.invoice_top_tag_color));
        if (this.cDW != null) {
            this.cDW.setContentView(this.cDX, this.cat);
        }
    }

    public void setCompanyInfo(String str, String str2) {
        if (this.cDX != null) {
            TextView textView = (TextView) this.cDX.findViewById(b.e.invoice_company_title_txt);
            TextView textView2 = (TextView) this.cDX.findViewById(b.e.tax_number_txt);
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
        if (this.cDX != null && (textView = (TextView) this.cDX.findViewById(b.e.invoice_personal_title_txt)) != null) {
            textView.setText(str);
        }
    }

    public void setEditClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            if (this.cEb != null) {
                this.cEb.setOnClickListener(onClickListener);
            }
            if (this.cEa != null) {
                this.cEa.setOnClickListener(onClickListener);
            }
        }
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }

    public void fq(boolean z) {
        int i = z ? 0 : 4;
        if (this.cDY != null) {
            this.cDY.setVisibility(i);
        }
        if (this.cDZ != null) {
            this.cDZ.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        fr(z);
        super.setPressed(z);
    }

    private void fr(boolean z) {
        if (this.cDW != null) {
            this.cDW.fs(z);
        }
    }
}
