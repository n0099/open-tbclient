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
    private PartingLineView ceM;
    private View ceN;
    private ImageView ceO;
    private TextView ceP;
    private ImageView ceQ;
    private TextView ceR;
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
        this.ceM = (PartingLineView) findViewById(b.e.parting_line_view);
        this.ceM.setBgNormalColor(b.C0318b.invoice_bg_normal_color);
        this.ceM.setBgPressedColor(b.C0318b.invoice_bg_pressed_color);
        this.ceM.setBorderColor(b.C0318b.invoice_bg_border_color);
        this.ceM.setDividerLineColor(b.C0318b.invoice_bg_divider_line_color);
        this.mBottomView = LayoutInflater.from(context).inflate(b.f.invoice_item_bottom_view, (ViewGroup) null);
        this.ceO = (ImageView) this.mBottomView.findViewById(b.e.invoice_current_use_img);
        this.ceP = (TextView) this.mBottomView.findViewById(b.e.invoice_current_use_txt);
        this.ceQ = (ImageView) this.mBottomView.findViewById(b.e.invoice_edit_img);
        this.ceR = (TextView) this.mBottomView.findViewById(b.e.invoice_edit);
        this.ceO.setImageDrawable(getResources().getDrawable(b.d.invoice_default_select));
        this.ceP.setTextColor(getResources().getColor(b.C0318b.invoice_bottom_text));
        this.ceQ.setImageDrawable(getResources().getDrawable(b.d.invoice_edit_img));
        this.ceR.setTextColor(getResources().getColor(b.C0318b.invoice_bottom_text));
        this.ceO.setVisibility(4);
        this.ceP.setVisibility(4);
        setClickable(true);
    }

    public void aiR() {
        this.ceN = LayoutInflater.from(this.mContext).inflate(b.f.invoice_item_top_company_view, (ViewGroup) null);
        ((TextView) this.ceN.findViewById(b.e.invoice_company_title_txt)).setTextColor(getResources().getColor(b.C0318b.invoice_top_title_color));
        ((TextView) this.ceN.findViewById(b.e.tax_number_txt)).setTextColor(getResources().getColor(b.C0318b.invoice_top_tax_number_color));
        ((CommonTagView) this.ceN.findViewById(b.e.common_tag_company)).setTextColor(getResources().getColor(b.C0318b.invoice_top_tag_color));
        if (this.ceM != null) {
            this.ceM.setContentView(this.ceN, this.mBottomView);
        }
    }

    public void aiS() {
        this.ceN = LayoutInflater.from(this.mContext).inflate(b.f.invoice_item_top_personage_view, (ViewGroup) null);
        ((TextView) this.ceN.findViewById(b.e.invoice_personal_title_txt)).setTextColor(getResources().getColor(b.C0318b.invoice_top_title_color));
        ((CommonTagView) this.ceN.findViewById(b.e.invoice_personal_tag)).setTextColor(getResources().getColor(b.C0318b.invoice_top_tag_color));
        if (this.ceM != null) {
            this.ceM.setContentView(this.ceN, this.mBottomView);
        }
    }

    public void setCompanyInfo(String str, String str2) {
        if (this.ceN != null) {
            TextView textView = (TextView) this.ceN.findViewById(b.e.invoice_company_title_txt);
            TextView textView2 = (TextView) this.ceN.findViewById(b.e.tax_number_txt);
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
        if (this.ceN != null && (textView = (TextView) this.ceN.findViewById(b.e.invoice_personal_title_txt)) != null) {
            textView.setText(str);
        }
    }

    public void setEditClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            if (this.ceR != null) {
                this.ceR.setOnClickListener(onClickListener);
            }
            if (this.ceQ != null) {
                this.ceQ.setOnClickListener(onClickListener);
            }
        }
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }

    public void es(boolean z) {
        int i = z ? 0 : 4;
        if (this.ceO != null) {
            this.ceO.setVisibility(i);
        }
        if (this.ceP != null) {
            this.ceP.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        et(z);
        super.setPressed(z);
    }

    private void et(boolean z) {
        if (this.ceM != null) {
            this.ceM.eu(z);
        }
    }
}
