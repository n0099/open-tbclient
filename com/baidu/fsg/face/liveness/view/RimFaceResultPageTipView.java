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
    public TextView f6165a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f6166b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f6167c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f6168d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f6169e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f6170f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f6171g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f6172h;

    /* renamed from: i  reason: collision with root package name */
    public a f6173i;
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
        this.f6167c.setVisibility(4);
        this.f6168d.setVisibility(4);
        this.f6169e.setVisibility(4);
        this.f6172h.setVisibility(4);
        this.f6171g.setVisibility(4);
        this.f6165a.setVisibility(4);
        this.f6166b.setVisibility(4);
        this.j = null;
        this.f6173i = null;
    }

    public void setOnClickListener(a aVar) {
        this.f6173i = aVar;
    }

    public void setOnCloseListener(b bVar) {
        this.j = bVar;
        this.f6172h.setVisibility(0);
    }

    public void setResultPageCancelText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6165a.setVisibility(0);
        this.f6165a.setText(str);
    }

    public void setResultPageConfirmText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6166b.setVisibility(0);
        this.f6166b.setText(str);
    }

    public void setResultPageImg(int i2) {
        this.f6167c.setVisibility(0);
        this.f6167c.setBackgroundResource(i2);
    }

    public void setResultPageNextTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6169e.setTextSize(13.0f);
        this.f6169e.setTextColor(getResources().getColor(R.color.rim_base_text_666666));
        this.f6169e.setText(str);
        this.f6169e.setVisibility(0);
    }

    public void setResultPageNextTitleBold(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6169e.setTextSize(18.0f);
        this.f6169e.setTextColor(getResources().getColor(R.color.rim_base_text_333333));
        this.f6169e.setText(str);
        this.f6169e.setVisibility(0);
    }

    public void setResultPageRiskTipVisiable(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6170f.setText(str);
        this.f6171g.setVisibility(0);
    }

    public void setResultPageTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6168d.setText(str);
        this.f6168d.setVisibility(0);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.rim_face_risk_warning_tips_page, this);
        this.f6167c = (ImageView) findViewById(R.id.rim_face_result_page_img);
        this.f6172h = (ImageView) findViewById(R.id.rim_face_result_page_close_img);
        this.f6168d = (TextView) findViewById(R.id.rim_face_result_tips_title);
        this.f6169e = (TextView) findViewById(R.id.rim_face_result_tips_next_title);
        this.f6170f = (TextView) findViewById(R.id.rim_face_result_page_tip_msg);
        this.f6171g = (LinearLayout) findViewById(R.id.layout_result_page_show_risk_tip);
        this.f6166b = (TextView) findViewById(R.id.rim_face_result_page_confirm);
        this.f6165a = (TextView) findViewById(R.id.rim_face_result_page_cancel);
        this.f6172h.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RimFaceResultPageTipView.this.j != null) {
                    RimFaceResultPageTipView.this.j.a();
                }
            }
        });
        this.f6166b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RimFaceResultPageTipView.this.f6173i != null) {
                    RimFaceResultPageTipView.this.f6173i.a();
                }
            }
        });
        this.f6165a.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RimFaceResultPageTipView.this.f6173i != null) {
                    RimFaceResultPageTipView.this.f6173i.b();
                }
            }
        });
    }

    public RimFaceResultPageTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
