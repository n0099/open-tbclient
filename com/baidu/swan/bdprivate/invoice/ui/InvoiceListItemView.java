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
    private PartingLineView ceL;
    private View ceM;
    private ImageView ceN;
    private TextView ceO;
    private ImageView ceP;
    private TextView ceQ;
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
        this.ceL = (PartingLineView) findViewById(b.e.parting_line_view);
        this.ceL.setBgNormalColor(b.C0318b.invoice_bg_normal_color);
        this.ceL.setBgPressedColor(b.C0318b.invoice_bg_pressed_color);
        this.ceL.setBorderColor(b.C0318b.invoice_bg_border_color);
        this.ceL.setDividerLineColor(b.C0318b.invoice_bg_divider_line_color);
        this.mBottomView = LayoutInflater.from(context).inflate(b.f.invoice_item_bottom_view, (ViewGroup) null);
        this.ceN = (ImageView) this.mBottomView.findViewById(b.e.invoice_current_use_img);
        this.ceO = (TextView) this.mBottomView.findViewById(b.e.invoice_current_use_txt);
        this.ceP = (ImageView) this.mBottomView.findViewById(b.e.invoice_edit_img);
        this.ceQ = (TextView) this.mBottomView.findViewById(b.e.invoice_edit);
        this.ceN.setImageDrawable(getResources().getDrawable(b.d.invoice_default_select));
        this.ceO.setTextColor(getResources().getColor(b.C0318b.invoice_bottom_text));
        this.ceP.setImageDrawable(getResources().getDrawable(b.d.invoice_edit_img));
        this.ceQ.setTextColor(getResources().getColor(b.C0318b.invoice_bottom_text));
        this.ceN.setVisibility(4);
        this.ceO.setVisibility(4);
        setClickable(true);
    }

    public void aiP() {
        this.ceM = LayoutInflater.from(this.mContext).inflate(b.f.invoice_item_top_company_view, (ViewGroup) null);
        ((TextView) this.ceM.findViewById(b.e.invoice_company_title_txt)).setTextColor(getResources().getColor(b.C0318b.invoice_top_title_color));
        ((TextView) this.ceM.findViewById(b.e.tax_number_txt)).setTextColor(getResources().getColor(b.C0318b.invoice_top_tax_number_color));
        ((CommonTagView) this.ceM.findViewById(b.e.common_tag_company)).setTextColor(getResources().getColor(b.C0318b.invoice_top_tag_color));
        if (this.ceL != null) {
            this.ceL.setContentView(this.ceM, this.mBottomView);
        }
    }

    public void aiQ() {
        this.ceM = LayoutInflater.from(this.mContext).inflate(b.f.invoice_item_top_personage_view, (ViewGroup) null);
        ((TextView) this.ceM.findViewById(b.e.invoice_personal_title_txt)).setTextColor(getResources().getColor(b.C0318b.invoice_top_title_color));
        ((CommonTagView) this.ceM.findViewById(b.e.invoice_personal_tag)).setTextColor(getResources().getColor(b.C0318b.invoice_top_tag_color));
        if (this.ceL != null) {
            this.ceL.setContentView(this.ceM, this.mBottomView);
        }
    }

    public void setCompanyInfo(String str, String str2) {
        if (this.ceM != null) {
            TextView textView = (TextView) this.ceM.findViewById(b.e.invoice_company_title_txt);
            TextView textView2 = (TextView) this.ceM.findViewById(b.e.tax_number_txt);
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
        if (this.ceM != null && (textView = (TextView) this.ceM.findViewById(b.e.invoice_personal_title_txt)) != null) {
            textView.setText(str);
        }
    }

    public void setEditClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            if (this.ceQ != null) {
                this.ceQ.setOnClickListener(onClickListener);
            }
            if (this.ceP != null) {
                this.ceP.setOnClickListener(onClickListener);
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
        if (this.ceN != null) {
            this.ceN.setVisibility(i);
        }
        if (this.ceO != null) {
            this.ceO.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        et(z);
        super.setPressed(z);
    }

    private void et(boolean z) {
        if (this.ceL != null) {
            this.ceL.eu(z);
        }
    }
}
