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
/* loaded from: classes10.dex */
public class InvoiceListItemView extends FrameLayout {
    private PartingLineView caF;
    private View caG;
    private ImageView caH;
    private TextView caI;
    private ImageView caJ;
    private TextView caK;
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
        this.caF = (PartingLineView) findViewById(b.e.parting_line_view);
        this.caF.setBgNormalColor(b.C0308b.invoice_bg_normal_color);
        this.caF.setBgPressedColor(b.C0308b.invoice_bg_pressed_color);
        this.caF.setBorderColor(b.C0308b.invoice_bg_border_color);
        this.caF.setDividerLineColor(b.C0308b.invoice_bg_divider_line_color);
        this.mBottomView = LayoutInflater.from(context).inflate(b.f.invoice_item_bottom_view, (ViewGroup) null);
        this.caH = (ImageView) this.mBottomView.findViewById(b.e.invoice_current_use_img);
        this.caI = (TextView) this.mBottomView.findViewById(b.e.invoice_current_use_txt);
        this.caJ = (ImageView) this.mBottomView.findViewById(b.e.invoice_edit_img);
        this.caK = (TextView) this.mBottomView.findViewById(b.e.invoice_edit);
        this.caH.setImageDrawable(getResources().getDrawable(b.d.invoice_default_select));
        this.caI.setTextColor(getResources().getColor(b.C0308b.invoice_bottom_text));
        this.caJ.setImageDrawable(getResources().getDrawable(b.d.invoice_edit_img));
        this.caK.setTextColor(getResources().getColor(b.C0308b.invoice_bottom_text));
        this.caH.setVisibility(4);
        this.caI.setVisibility(4);
        setClickable(true);
    }

    public void agB() {
        this.caG = LayoutInflater.from(this.mContext).inflate(b.f.invoice_item_top_company_view, (ViewGroup) null);
        ((TextView) this.caG.findViewById(b.e.invoice_company_title_txt)).setTextColor(getResources().getColor(b.C0308b.invoice_top_title_color));
        ((TextView) this.caG.findViewById(b.e.tax_number_txt)).setTextColor(getResources().getColor(b.C0308b.invoice_top_tax_number_color));
        ((CommonTagView) this.caG.findViewById(b.e.common_tag_company)).setTextColor(getResources().getColor(b.C0308b.invoice_top_tag_color));
        if (this.caF != null) {
            this.caF.setContentView(this.caG, this.mBottomView);
        }
    }

    public void agC() {
        this.caG = LayoutInflater.from(this.mContext).inflate(b.f.invoice_item_top_personage_view, (ViewGroup) null);
        ((TextView) this.caG.findViewById(b.e.invoice_personal_title_txt)).setTextColor(getResources().getColor(b.C0308b.invoice_top_title_color));
        ((CommonTagView) this.caG.findViewById(b.e.invoice_personal_tag)).setTextColor(getResources().getColor(b.C0308b.invoice_top_tag_color));
        if (this.caF != null) {
            this.caF.setContentView(this.caG, this.mBottomView);
        }
    }

    public void setCompanyInfo(String str, String str2) {
        if (this.caG != null) {
            TextView textView = (TextView) this.caG.findViewById(b.e.invoice_company_title_txt);
            TextView textView2 = (TextView) this.caG.findViewById(b.e.tax_number_txt);
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
        if (this.caG != null && (textView = (TextView) this.caG.findViewById(b.e.invoice_personal_title_txt)) != null) {
            textView.setText(str);
        }
    }

    public void setEditClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            if (this.caK != null) {
                this.caK.setOnClickListener(onClickListener);
            }
            if (this.caJ != null) {
                this.caJ.setOnClickListener(onClickListener);
            }
        }
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }

    public void el(boolean z) {
        int i = z ? 0 : 4;
        if (this.caH != null) {
            this.caH.setVisibility(i);
        }
        if (this.caI != null) {
            this.caI.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        em(z);
        super.setPressed(z);
    }

    private void em(boolean z) {
        if (this.caF != null) {
            this.caF.en(z);
        }
    }
}
