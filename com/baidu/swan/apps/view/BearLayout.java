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
/* loaded from: classes11.dex */
public class BearLayout extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private TextView bZo;
    private SimpleDraweeView bZp;
    private BdBaseImageView bZq;
    private FrameLayout bZr;
    private TextView bZs;
    private BdBaseImageView bZt;
    private boolean bZu;
    private a bZv;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface a {
        void ed(boolean z);

        void mY(String str);
    }

    public BearLayout(Context context) {
        super(context);
        this.bZu = false;
    }

    public BearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZu = false;
    }

    public void a(@NonNull final Context context, @NonNull final SwanAppBearInfo swanAppBearInfo, final com.baidu.swan.apps.view.a aVar) {
        this.mContext = context;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(a.g.aiapps_bear_layout, this);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.BearLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BearLayout.this.mX(swanAppBearInfo.bearHomeUrl);
            }
        });
        this.bZo = (TextView) linearLayout.findViewById(a.f.bear_account_name);
        this.bZo.setText(swanAppBearInfo.bearName);
        this.bZp = (SimpleDraweeView) linearLayout.findViewById(a.f.bear_account_logo);
        this.bZp.setImageURI(swanAppBearInfo.bearLogo);
        this.bZq = (BdBaseImageView) linearLayout.findViewById(a.f.bear_account_vip_logo);
        setVipLogo(swanAppBearInfo.bearVipType);
        this.bZr = (FrameLayout) linearLayout.findViewById(a.f.bear_account_follow_background);
        this.bZs = (TextView) linearLayout.findViewById(a.f.bear_account_follow_btn);
        this.bZs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.BearLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!BearLayout.this.bZu) {
                    BearLayout.this.ahs();
                    aVar.aht();
                    return;
                }
                BearLayout.this.mX(swanAppBearInfo.bearHomeUrl);
            }
        });
        this.bZt = (BdBaseImageView) linearLayout.findViewById(a.f.bear_account_loading_progress);
        this.bZt.setVisibility(8);
        this.bZv = new a() { // from class: com.baidu.swan.apps.view.BearLayout.3
            @Override // com.baidu.swan.apps.view.BearLayout.a
            public void mY(String str) {
                if (BearLayout.DEBUG) {
                    Log.d("BearLayout", str);
                }
                if (BearLayout.this.bZt != null && BearLayout.this.bZs != null) {
                    BearLayout.this.bZt.clearAnimation();
                    BearLayout.this.bZt.setVisibility(4);
                    BearLayout.this.bZs.setVisibility(0);
                }
            }

            @Override // com.baidu.swan.apps.view.BearLayout.a
            public void ed(boolean z) {
                BearLayout.this.bZu = z;
                if (BearLayout.this.bZt != null && BearLayout.this.bZs != null) {
                    BearLayout.this.bZt.clearAnimation();
                    BearLayout.this.bZt.setVisibility(4);
                    BearLayout.this.bZs.setVisibility(0);
                    BearLayout.this.bZs.setText(z ? BearLayout.this.mContext.getText(a.h.aiapps_bear_btn_navigate) : BearLayout.this.mContext.getText(a.h.aiapps_bear_btn_follow));
                    BearLayout.this.bZs.setTextColor(z ? context.getResources().getColor(a.c.aiapps_black_text) : context.getResources().getColor(a.c.aiapps_white_text));
                    BearLayout.this.bZr.setBackgroundResource(z ? a.e.aiapps_bear_paw_enter_btn : a.e.aiapps_bear_paw_follow_btn);
                }
            }
        };
    }

    private void setVipLogo(String str) {
        if (this.bZq != null) {
            if (TextUtils.isEmpty(str)) {
                this.bZq.setVisibility(8);
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
            this.bZq.setVisibility(0);
            this.bZq.setImageDrawable(this.mContext.getResources().getDrawable(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahs() {
        if (this.bZt != null && this.bZs != null) {
            this.bZs.setVisibility(4);
            this.bZt.setVisibility(0);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.bZt.startAnimation(rotateAnimation);
        }
    }

    public a getCallback() {
        return this.bZv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mX(String str) {
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
