package com.baidu.swan.apps.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.facebook.drawee.view.SimpleDraweeView;
import d.b.g0.a.e;
import d.b.g0.a.f;
import d.b.g0.a.g;
import d.b.g0.a.h;
import d.b.g0.a.k;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class BearLayout extends LinearLayout {
    public static final boolean n = k.f45443a;

    /* renamed from: e  reason: collision with root package name */
    public TextView f12324e;

    /* renamed from: f  reason: collision with root package name */
    public SimpleDraweeView f12325f;

    /* renamed from: g  reason: collision with root package name */
    public BdBaseImageView f12326g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f12327h;
    public TextView i;
    public BdBaseImageView j;
    public boolean k;
    public d l;
    public Context m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBearInfo f12328e;

        public a(SwanAppBearInfo swanAppBearInfo) {
            this.f12328e = swanAppBearInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BearLayout.this.j(this.f12328e.bearHomeUrl);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.j2.a f12330e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppBearInfo f12331f;

        public b(d.b.g0.a.j2.a aVar, SwanAppBearInfo swanAppBearInfo) {
            this.f12330e = aVar;
            this.f12331f = swanAppBearInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!BearLayout.this.k) {
                BearLayout.this.l();
                this.f12330e.b();
                return;
            }
            BearLayout.this.j(this.f12331f.bearHomeUrl);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f12333a;

        public c(Context context) {
            this.f12333a = context;
        }

        @Override // com.baidu.swan.apps.view.BearLayout.d
        public void a(String str) {
            if (BearLayout.n) {
                Log.d("BearLayout", str);
            }
            if (BearLayout.this.j == null || BearLayout.this.i == null) {
                return;
            }
            BearLayout.this.j.clearAnimation();
            BearLayout.this.j.setVisibility(4);
            BearLayout.this.i.setVisibility(0);
        }

        @Override // com.baidu.swan.apps.view.BearLayout.d
        public void b(boolean z) {
            BearLayout.this.k = z;
            if (BearLayout.this.j == null || BearLayout.this.i == null) {
                return;
            }
            BearLayout.this.j.clearAnimation();
            BearLayout.this.j.setVisibility(4);
            BearLayout.this.i.setVisibility(0);
            TextView textView = BearLayout.this.i;
            BearLayout bearLayout = BearLayout.this;
            textView.setText(z ? bearLayout.m.getText(h.aiapps_bear_btn_navigate) : bearLayout.m.getText(h.aiapps_bear_btn_follow));
            TextView textView2 = BearLayout.this.i;
            Context context = this.f12333a;
            textView2.setTextColor(z ? context.getResources().getColor(d.b.g0.a.c.aiapps_black_text) : context.getResources().getColor(d.b.g0.a.c.aiapps_white_text));
            BearLayout.this.f12327h.setBackgroundResource(z ? e.aiapps_bear_paw_enter_btn : e.aiapps_bear_paw_follow_btn);
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(String str);

        void b(boolean z);
    }

    public BearLayout(Context context) {
        super(context);
        this.k = false;
    }

    private void setVipLogo(String str) {
        if (this.f12326g == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f12326g.setVisibility(8);
            return;
        }
        int i = e.aiapps_follow_vip_golden;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 1567) {
            switch (hashCode) {
                case 49:
                    if (str.equals("1")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
        } else if (str.equals("10")) {
            c2 = 3;
        }
        if (c2 == 1) {
            i = e.aiapps_follow_vip_blue;
        } else if (c2 == 2) {
            i = e.aiapps_follow_vip_yellow;
        } else if (c2 == 3) {
            i = e.aiapps_follow_vip_authentication;
        }
        this.f12326g.setVisibility(0);
        this.f12326g.setImageDrawable(this.m.getResources().getDrawable(i));
    }

    public d getCallback() {
        return this.l;
    }

    public final void j(String str) {
        String str2;
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            if (n) {
                e2.printStackTrace();
            }
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        SchemeRouter.invoke(getContext(), "baiduboxapp://v1/easybrowse/open?url=" + str + "&newbrowser=1&forbidautorotate=1");
    }

    public void k(@NonNull Context context, @NonNull SwanAppBearInfo swanAppBearInfo, d.b.g0.a.j2.a aVar) {
        this.m = context;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(g.aiapps_bear_layout, this);
        linearLayout.setOnClickListener(new a(swanAppBearInfo));
        TextView textView = (TextView) linearLayout.findViewById(f.bear_account_name);
        this.f12324e = textView;
        textView.setText(swanAppBearInfo.bearName);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(f.bear_account_logo);
        this.f12325f = simpleDraweeView;
        simpleDraweeView.setImageURI(swanAppBearInfo.bearLogo);
        this.f12326g = (BdBaseImageView) linearLayout.findViewById(f.bear_account_vip_logo);
        setVipLogo(swanAppBearInfo.bearVipType);
        this.f12327h = (FrameLayout) linearLayout.findViewById(f.bear_account_follow_background);
        TextView textView2 = (TextView) linearLayout.findViewById(f.bear_account_follow_btn);
        this.i = textView2;
        textView2.setOnClickListener(new b(aVar, swanAppBearInfo));
        BdBaseImageView bdBaseImageView = (BdBaseImageView) linearLayout.findViewById(f.bear_account_loading_progress);
        this.j = bdBaseImageView;
        bdBaseImageView.setVisibility(8);
        this.l = new c(context);
    }

    public final void l() {
        TextView textView;
        if (this.j == null || (textView = this.i) == null) {
            return;
        }
        textView.setVisibility(4);
        this.j.setVisibility(0);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.j.startAnimation(rotateAnimation);
    }

    public BearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = false;
    }
}
