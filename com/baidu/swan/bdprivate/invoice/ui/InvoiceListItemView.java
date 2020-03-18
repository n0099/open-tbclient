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
    private PartingLineView ceY;
    private View ceZ;
    private ImageView cfa;
    private TextView cfb;
    private ImageView cfc;
    private TextView cfd;
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
        this.ceY = (PartingLineView) findViewById(b.e.parting_line_view);
        this.ceY.setBgNormalColor(b.C0318b.invoice_bg_normal_color);
        this.ceY.setBgPressedColor(b.C0318b.invoice_bg_pressed_color);
        this.ceY.setBorderColor(b.C0318b.invoice_bg_border_color);
        this.ceY.setDividerLineColor(b.C0318b.invoice_bg_divider_line_color);
        this.mBottomView = LayoutInflater.from(context).inflate(b.f.invoice_item_bottom_view, (ViewGroup) null);
        this.cfa = (ImageView) this.mBottomView.findViewById(b.e.invoice_current_use_img);
        this.cfb = (TextView) this.mBottomView.findViewById(b.e.invoice_current_use_txt);
        this.cfc = (ImageView) this.mBottomView.findViewById(b.e.invoice_edit_img);
        this.cfd = (TextView) this.mBottomView.findViewById(b.e.invoice_edit);
        this.cfa.setImageDrawable(getResources().getDrawable(b.d.invoice_default_select));
        this.cfb.setTextColor(getResources().getColor(b.C0318b.invoice_bottom_text));
        this.cfc.setImageDrawable(getResources().getDrawable(b.d.invoice_edit_img));
        this.cfd.setTextColor(getResources().getColor(b.C0318b.invoice_bottom_text));
        this.cfa.setVisibility(4);
        this.cfb.setVisibility(4);
        setClickable(true);
    }

    public void aiU() {
        this.ceZ = LayoutInflater.from(this.mContext).inflate(b.f.invoice_item_top_company_view, (ViewGroup) null);
        ((TextView) this.ceZ.findViewById(b.e.invoice_company_title_txt)).setTextColor(getResources().getColor(b.C0318b.invoice_top_title_color));
        ((TextView) this.ceZ.findViewById(b.e.tax_number_txt)).setTextColor(getResources().getColor(b.C0318b.invoice_top_tax_number_color));
        ((CommonTagView) this.ceZ.findViewById(b.e.common_tag_company)).setTextColor(getResources().getColor(b.C0318b.invoice_top_tag_color));
        if (this.ceY != null) {
            this.ceY.setContentView(this.ceZ, this.mBottomView);
        }
    }

    public void aiV() {
        this.ceZ = LayoutInflater.from(this.mContext).inflate(b.f.invoice_item_top_personage_view, (ViewGroup) null);
        ((TextView) this.ceZ.findViewById(b.e.invoice_personal_title_txt)).setTextColor(getResources().getColor(b.C0318b.invoice_top_title_color));
        ((CommonTagView) this.ceZ.findViewById(b.e.invoice_personal_tag)).setTextColor(getResources().getColor(b.C0318b.invoice_top_tag_color));
        if (this.ceY != null) {
            this.ceY.setContentView(this.ceZ, this.mBottomView);
        }
    }

    public void setCompanyInfo(String str, String str2) {
        if (this.ceZ != null) {
            TextView textView = (TextView) this.ceZ.findViewById(b.e.invoice_company_title_txt);
            TextView textView2 = (TextView) this.ceZ.findViewById(b.e.tax_number_txt);
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
        if (this.ceZ != null && (textView = (TextView) this.ceZ.findViewById(b.e.invoice_personal_title_txt)) != null) {
            textView.setText(str);
        }
    }

    public void setEditClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            if (this.cfd != null) {
                this.cfd.setOnClickListener(onClickListener);
            }
            if (this.cfc != null) {
                this.cfc.setOnClickListener(onClickListener);
            }
        }
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }

    public void et(boolean z) {
        int i = z ? 0 : 4;
        if (this.cfa != null) {
            this.cfa.setVisibility(i);
        }
        if (this.cfb != null) {
            this.cfb.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        eu(z);
        super.setPressed(z);
    }

    private void eu(boolean z) {
        if (this.ceY != null) {
            this.ceY.ev(z);
        }
    }
}
