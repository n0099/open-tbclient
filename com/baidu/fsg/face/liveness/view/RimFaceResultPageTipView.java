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
    public TextView f6155a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f6156b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f6157c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f6158d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f6159e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f6160f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f6161g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f6162h;
    public a i;
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
        this.f6157c.setVisibility(4);
        this.f6158d.setVisibility(4);
        this.f6159e.setVisibility(4);
        this.f6162h.setVisibility(4);
        this.f6161g.setVisibility(4);
        this.f6155a.setVisibility(4);
        this.f6156b.setVisibility(4);
        this.j = null;
        this.i = null;
    }

    public void setOnClickListener(a aVar) {
        this.i = aVar;
    }

    public void setOnCloseListener(b bVar) {
        this.j = bVar;
        this.f6162h.setVisibility(0);
    }

    public void setResultPageCancelText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6155a.setVisibility(0);
        this.f6155a.setText(str);
    }

    public void setResultPageConfirmText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6156b.setVisibility(0);
        this.f6156b.setText(str);
    }

    public void setResultPageImg(int i) {
        this.f6157c.setVisibility(0);
        this.f6157c.setBackgroundResource(i);
    }

    public void setResultPageNextTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6159e.setTextSize(13.0f);
        this.f6159e.setTextColor(getResources().getColor(R.color.rim_base_text_666666));
        this.f6159e.setText(str);
        this.f6159e.setVisibility(0);
    }

    public void setResultPageNextTitleBold(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6159e.setTextSize(18.0f);
        this.f6159e.setTextColor(getResources().getColor(R.color.rim_base_text_333333));
        this.f6159e.setText(str);
        this.f6159e.setVisibility(0);
    }

    public void setResultPageRiskTipVisiable(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6160f.setText(str);
        this.f6161g.setVisibility(0);
    }

    public void setResultPageTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6158d.setText(str);
        this.f6158d.setVisibility(0);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.rim_face_risk_warning_tips_page, this);
        this.f6157c = (ImageView) findViewById(R.id.rim_face_result_page_img);
        this.f6162h = (ImageView) findViewById(R.id.rim_face_result_page_close_img);
        this.f6158d = (TextView) findViewById(R.id.rim_face_result_tips_title);
        this.f6159e = (TextView) findViewById(R.id.rim_face_result_tips_next_title);
        this.f6160f = (TextView) findViewById(R.id.rim_face_result_page_tip_msg);
        this.f6161g = (LinearLayout) findViewById(R.id.layout_result_page_show_risk_tip);
        this.f6156b = (TextView) findViewById(R.id.rim_face_result_page_confirm);
        this.f6155a = (TextView) findViewById(R.id.rim_face_result_page_cancel);
        this.f6162h.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RimFaceResultPageTipView.this.j != null) {
                    RimFaceResultPageTipView.this.j.a();
                }
            }
        });
        this.f6156b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RimFaceResultPageTipView.this.i != null) {
                    RimFaceResultPageTipView.this.i.a();
                }
            }
        });
        this.f6155a.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RimFaceResultPageTipView.this.i != null) {
                    RimFaceResultPageTipView.this.i.b();
                }
            }
        });
    }

    public RimFaceResultPageTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
