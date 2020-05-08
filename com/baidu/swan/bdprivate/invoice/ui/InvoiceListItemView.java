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
    private PartingLineView cEc;
    private View cEd;
    private ImageView cEe;
    private TextView cEf;
    private ImageView cEg;
    private TextView cEh;
    private View caz;
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
        this.cEc = (PartingLineView) findViewById(b.e.parting_line_view);
        this.cEc.setBgNormalColor(b.C0369b.invoice_bg_normal_color);
        this.cEc.setBgPressedColor(b.C0369b.invoice_bg_pressed_color);
        this.cEc.setBorderColor(b.C0369b.invoice_bg_border_color);
        this.cEc.setDividerLineColor(b.C0369b.invoice_bg_divider_line_color);
        this.caz = LayoutInflater.from(context).inflate(b.f.invoice_item_bottom_view, (ViewGroup) null);
        this.cEe = (ImageView) this.caz.findViewById(b.e.invoice_current_use_img);
        this.cEf = (TextView) this.caz.findViewById(b.e.invoice_current_use_txt);
        this.cEg = (ImageView) this.caz.findViewById(b.e.invoice_edit_img);
        this.cEh = (TextView) this.caz.findViewById(b.e.invoice_edit);
        this.cEe.setImageDrawable(getResources().getDrawable(b.d.invoice_default_select));
        this.cEf.setTextColor(getResources().getColor(b.C0369b.invoice_bottom_text));
        this.cEg.setImageDrawable(getResources().getDrawable(b.d.invoice_edit_img));
        this.cEh.setTextColor(getResources().getColor(b.C0369b.invoice_bottom_text));
        this.cEe.setVisibility(4);
        this.cEf.setVisibility(4);
        setClickable(true);
    }

    public void arb() {
        this.cEd = LayoutInflater.from(this.mContext).inflate(b.f.invoice_item_top_company_view, (ViewGroup) null);
        ((TextView) this.cEd.findViewById(b.e.invoice_company_title_txt)).setTextColor(getResources().getColor(b.C0369b.invoice_top_title_color));
        ((TextView) this.cEd.findViewById(b.e.tax_number_txt)).setTextColor(getResources().getColor(b.C0369b.invoice_top_tax_number_color));
        ((CommonTagView) this.cEd.findViewById(b.e.common_tag_company)).setTextColor(getResources().getColor(b.C0369b.invoice_top_tag_color));
        if (this.cEc != null) {
            this.cEc.setContentView(this.cEd, this.caz);
        }
    }

    public void arc() {
        this.cEd = LayoutInflater.from(this.mContext).inflate(b.f.invoice_item_top_personage_view, (ViewGroup) null);
        ((TextView) this.cEd.findViewById(b.e.invoice_personal_title_txt)).setTextColor(getResources().getColor(b.C0369b.invoice_top_title_color));
        ((CommonTagView) this.cEd.findViewById(b.e.invoice_personal_tag)).setTextColor(getResources().getColor(b.C0369b.invoice_top_tag_color));
        if (this.cEc != null) {
            this.cEc.setContentView(this.cEd, this.caz);
        }
    }

    public void setCompanyInfo(String str, String str2) {
        if (this.cEd != null) {
            TextView textView = (TextView) this.cEd.findViewById(b.e.invoice_company_title_txt);
            TextView textView2 = (TextView) this.cEd.findViewById(b.e.tax_number_txt);
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
        if (this.cEd != null && (textView = (TextView) this.cEd.findViewById(b.e.invoice_personal_title_txt)) != null) {
            textView.setText(str);
        }
    }

    public void setEditClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            if (this.cEh != null) {
                this.cEh.setOnClickListener(onClickListener);
            }
            if (this.cEg != null) {
                this.cEg.setOnClickListener(onClickListener);
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
        if (this.cEe != null) {
            this.cEe.setVisibility(i);
        }
        if (this.cEf != null) {
            this.cEf.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        fr(z);
        super.setPressed(z);
    }

    private void fr(boolean z) {
        if (this.cEc != null) {
            this.cEc.fs(z);
        }
    }
}
