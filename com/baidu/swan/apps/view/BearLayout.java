package com.baidu.swan.apps.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes25.dex */
public class BearLayout extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private TextView dKn;
    private SimpleDraweeView dKo;
    private BdBaseImageView dKp;
    private FrameLayout dKq;
    private TextView dKr;
    private BdBaseImageView dKs;
    private boolean dKt;
    private a dKu;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public interface a {
        void hk(boolean z);

        void vi(String str);
    }

    public BearLayout(Context context) {
        super(context);
        this.dKt = false;
    }

    public BearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dKt = false;
    }

    public void a(@NonNull final Context context, @NonNull final SwanAppBearInfo swanAppBearInfo, final com.baidu.swan.apps.view.a aVar) {
        this.mContext = context;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(a.g.aiapps_bear_layout, this);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.BearLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BearLayout.this.vh(swanAppBearInfo.bearHomeUrl);
            }
        });
        this.dKn = (TextView) linearLayout.findViewById(a.f.bear_account_name);
        this.dKn.setText(swanAppBearInfo.bearName);
        this.dKo = (SimpleDraweeView) linearLayout.findViewById(a.f.bear_account_logo);
        this.dKo.setImageURI(swanAppBearInfo.bearLogo);
        this.dKp = (BdBaseImageView) linearLayout.findViewById(a.f.bear_account_vip_logo);
        setVipLogo(swanAppBearInfo.bearVipType);
        this.dKq = (FrameLayout) linearLayout.findViewById(a.f.bear_account_follow_background);
        this.dKr = (TextView) linearLayout.findViewById(a.f.bear_account_follow_btn);
        this.dKr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.BearLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!BearLayout.this.dKt) {
                    BearLayout.this.aPT();
                    aVar.aPU();
                    return;
                }
                BearLayout.this.vh(swanAppBearInfo.bearHomeUrl);
            }
        });
        this.dKs = (BdBaseImageView) linearLayout.findViewById(a.f.bear_account_loading_progress);
        this.dKs.setVisibility(8);
        this.dKu = new a() { // from class: com.baidu.swan.apps.view.BearLayout.3
            @Override // com.baidu.swan.apps.view.BearLayout.a
            public void vi(String str) {
                if (BearLayout.DEBUG) {
                    Log.d("BearLayout", str);
                }
                if (BearLayout.this.dKs != null && BearLayout.this.dKr != null) {
                    BearLayout.this.dKs.clearAnimation();
                    BearLayout.this.dKs.setVisibility(4);
                    BearLayout.this.dKr.setVisibility(0);
                }
            }

            @Override // com.baidu.swan.apps.view.BearLayout.a
            public void hk(boolean z) {
                BearLayout.this.dKt = z;
                if (BearLayout.this.dKs != null && BearLayout.this.dKr != null) {
                    BearLayout.this.dKs.clearAnimation();
                    BearLayout.this.dKs.setVisibility(4);
                    BearLayout.this.dKr.setVisibility(0);
                    BearLayout.this.dKr.setText(z ? BearLayout.this.mContext.getText(a.h.aiapps_bear_btn_navigate) : BearLayout.this.mContext.getText(a.h.aiapps_bear_btn_follow));
                    BearLayout.this.dKr.setTextColor(z ? context.getResources().getColor(a.c.aiapps_black_text) : context.getResources().getColor(a.c.aiapps_white_text));
                    BearLayout.this.dKq.setBackgroundResource(z ? a.e.aiapps_bear_paw_enter_btn : a.e.aiapps_bear_paw_follow_btn);
                }
            }
        };
    }

    private void setVipLogo(String str) {
        if (this.dKp != null) {
            if (TextUtils.isEmpty(str)) {
                this.dKp.setVisibility(8);
                return;
            }
            int i = a.e.aiapps_follow_vip_golden;
            char c = 65535;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        c = 1;
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1567:
                    if (str.equals("10")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 1:
                    i = a.e.aiapps_follow_vip_blue;
                    break;
                case 2:
                    i = a.e.aiapps_follow_vip_yellow;
                    break;
                case 3:
                    i = a.e.aiapps_follow_vip_authentication;
                    break;
            }
            this.dKp.setVisibility(0);
            this.dKp.setImageDrawable(this.mContext.getResources().getDrawable(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPT() {
        if (this.dKs != null && this.dKr != null) {
            this.dKr.setVisibility(4);
            this.dKs.setVisibility(0);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.dKs.startAnimation(rotateAnimation);
        }
    }

    public a getCallback() {
        return this.dKu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh(String str) {
        String str2 = null;
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        SchemeRouter.invoke(getContext(), "baiduboxapp://v1/easybrowse/open?url=" + str + "&newbrowser=1&forbidautorotate=1");
    }
}
