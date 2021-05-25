package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class RimFaceResultPageTipView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f6122a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f6123b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f6124c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f6125d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f6126e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f6127f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f6128g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f6129h;

    /* renamed from: i  reason: collision with root package name */
    public a f6130i;
    public b j;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    public RimFaceResultPageTipView(Context context) {
        super(context);
        a();
    }

    public void resetView() {
        this.f6124c.setVisibility(4);
        this.f6125d.setVisibility(4);
        this.f6126e.setVisibility(4);
        this.f6129h.setVisibility(4);
        this.f6128g.setVisibility(4);
        this.f6122a.setVisibility(4);
        this.f6123b.setVisibility(4);
        this.j = null;
        this.f6130i = null;
    }

    public void setOnClickListener(a aVar) {
        this.f6130i = aVar;
    }

    public void setOnCloseListener(b bVar) {
        this.j = bVar;
        this.f6129h.setVisibility(0);
    }

    public void setResultPageCancelText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6122a.setVisibility(0);
        this.f6122a.setText(str);
    }

    public void setResultPageConfirmText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6123b.setVisibility(0);
        this.f6123b.setText(str);
    }

    public void setResultPageImg(int i2) {
        this.f6124c.setVisibility(0);
        this.f6124c.setBackgroundResource(i2);
    }

    public void setResultPageNextTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6126e.setTextSize(13.0f);
        this.f6126e.setTextColor(getResources().getColor(R.color.rim_base_text_666666));
        this.f6126e.setText(str);
        this.f6126e.setVisibility(0);
    }

    public void setResultPageNextTitleBold(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6126e.setTextSize(18.0f);
        this.f6126e.setTextColor(getResources().getColor(R.color.rim_base_text_333333));
        this.f6126e.setText(str);
        this.f6126e.setVisibility(0);
    }

    public void setResultPageRiskTipVisiable(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6127f.setText(str);
        this.f6128g.setVisibility(0);
    }

    public void setResultPageTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6125d.setText(str);
        this.f6125d.setVisibility(0);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.rim_face_risk_warning_tips_page, this);
        this.f6124c = (ImageView) findViewById(R.id.rim_face_result_page_img);
        this.f6129h = (ImageView) findViewById(R.id.rim_face_result_page_close_img);
        this.f6125d = (TextView) findViewById(R.id.rim_face_result_tips_title);
        this.f6126e = (TextView) findViewById(R.id.rim_face_result_tips_next_title);
        this.f6127f = (TextView) findViewById(R.id.rim_face_result_page_tip_msg);
        this.f6128g = (LinearLayout) findViewById(R.id.layout_result_page_show_risk_tip);
        this.f6123b = (TextView) findViewById(R.id.rim_face_result_page_confirm);
        this.f6122a = (TextView) findViewById(R.id.rim_face_result_page_cancel);
        this.f6129h.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RimFaceResultPageTipView.this.j != null) {
                    RimFaceResultPageTipView.this.j.a();
                }
            }
        });
        this.f6123b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RimFaceResultPageTipView.this.f6130i != null) {
                    RimFaceResultPageTipView.this.f6130i.a();
                }
            }
        });
        this.f6122a.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RimFaceResultPageTipView.this.f6130i != null) {
                    RimFaceResultPageTipView.this.f6130i.b();
                }
            }
        });
    }

    public RimFaceResultPageTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
