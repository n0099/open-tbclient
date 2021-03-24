package com.baidu.swan.apps.textarea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import d.b.g0.a.f;
import d.b.g0.a.g;
/* loaded from: classes3.dex */
public class ShowConfirmBarLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Button f12659e;

    /* renamed from: f  reason: collision with root package name */
    public b f12660f;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ShowConfirmBarLayout.this.f12660f != null) {
                ShowConfirmBarLayout.this.f12660f.onClick(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onClick(View view);
    }

    public ShowConfirmBarLayout(Context context) {
        super(context);
        Button button = (Button) LayoutInflater.from(context).inflate(g.aiapps_textarea_confirm_bar, this).findViewById(f.confirm_button);
        this.f12659e = button;
        button.setOnClickListener(new a());
    }

    public void setOnConfirmButtonClickListener(b bVar) {
        this.f12660f = bVar;
    }
}
