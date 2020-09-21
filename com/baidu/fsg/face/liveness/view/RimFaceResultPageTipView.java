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
/* loaded from: classes16.dex */
public class RimFaceResultPageTipView extends LinearLayout {
    private TextView a;
    private TextView b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private LinearLayout g;
    private ImageView h;
    private a i;
    private b j;

    /* loaded from: classes16.dex */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: classes16.dex */
    public interface b {
        void a();
    }

    public RimFaceResultPageTipView(Context context) {
        super(context);
        a();
    }

    public RimFaceResultPageTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.rim_face_risk_warning_tips_page, this);
        this.c = (ImageView) findViewById(R.id.rim_face_result_page_img);
        this.h = (ImageView) findViewById(R.id.rim_face_result_page_close_img);
        this.d = (TextView) findViewById(R.id.rim_face_result_tips_title);
        this.e = (TextView) findViewById(R.id.rim_face_result_tips_next_title);
        this.f = (TextView) findViewById(R.id.rim_face_result_page_tip_msg);
        this.g = (LinearLayout) findViewById(R.id.layout_result_page_show_risk_tip);
        this.b = (TextView) findViewById(R.id.rim_face_result_page_confirm);
        this.a = (TextView) findViewById(R.id.rim_face_result_page_cancel);
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RimFaceResultPageTipView.this.j != null) {
                    RimFaceResultPageTipView.this.j.a();
                }
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RimFaceResultPageTipView.this.i != null) {
                    RimFaceResultPageTipView.this.i.a();
                }
            }
        });
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RimFaceResultPageTipView.this.i != null) {
                    RimFaceResultPageTipView.this.i.b();
                }
            }
        });
    }

    public void resetView() {
        this.c.setVisibility(4);
        this.d.setVisibility(4);
        this.e.setVisibility(4);
        this.h.setVisibility(4);
        this.g.setVisibility(4);
        this.a.setVisibility(4);
        this.b.setVisibility(4);
        this.j = null;
        this.i = null;
    }

    public void setResultPageImg(int i) {
        this.c.setVisibility(0);
        this.c.setBackgroundResource(i);
    }

    public void setResultPageTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.d.setText(str);
            this.d.setVisibility(0);
        }
    }

    public void setResultPageNextTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.e.setTextSize(13.0f);
            this.e.setTextColor(getResources().getColor(R.color.rim_base_text_666666));
            this.e.setText(str);
            this.e.setVisibility(0);
        }
    }

    public void setResultPageNextTitleBold(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.e.setTextSize(18.0f);
            this.e.setTextColor(getResources().getColor(R.color.rim_base_text_333333));
            this.e.setText(str);
            this.e.setVisibility(0);
        }
    }

    public void setResultPageRiskTipVisiable(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f.setText(str);
            this.g.setVisibility(0);
        }
    }

    public void setResultPageConfirmText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b.setVisibility(0);
            this.b.setText(str);
        }
    }

    public void setResultPageCancelText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.setVisibility(0);
            this.a.setText(str);
        }
    }

    public void setOnClickListener(a aVar) {
        this.i = aVar;
    }

    public void setOnCloseListener(b bVar) {
        this.j = bVar;
        this.h.setVisibility(0);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }
}
