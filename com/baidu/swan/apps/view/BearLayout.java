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
/* loaded from: classes7.dex */
public class BearLayout extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private TextView cTr;
    private SimpleDraweeView cTs;
    private BdBaseImageView cTt;
    private FrameLayout cTu;
    private TextView cTv;
    private BdBaseImageView cTw;
    private boolean cTx;
    private a cTy;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface a {
        void fI(boolean z);

        void qR(String str);
    }

    public BearLayout(Context context) {
        super(context);
        this.cTx = false;
    }

    public BearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cTx = false;
    }

    public void a(@NonNull final Context context, @NonNull final SwanAppBearInfo swanAppBearInfo, final com.baidu.swan.apps.view.a aVar) {
        this.mContext = context;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(a.g.aiapps_bear_layout, this);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.BearLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BearLayout.this.qQ(swanAppBearInfo.bearHomeUrl);
            }
        });
        this.cTr = (TextView) linearLayout.findViewById(a.f.bear_account_name);
        this.cTr.setText(swanAppBearInfo.bearName);
        this.cTs = (SimpleDraweeView) linearLayout.findViewById(a.f.bear_account_logo);
        this.cTs.setImageURI(swanAppBearInfo.bearLogo);
        this.cTt = (BdBaseImageView) linearLayout.findViewById(a.f.bear_account_vip_logo);
        setVipLogo(swanAppBearInfo.bearVipType);
        this.cTu = (FrameLayout) linearLayout.findViewById(a.f.bear_account_follow_background);
        this.cTv = (TextView) linearLayout.findViewById(a.f.bear_account_follow_btn);
        this.cTv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.BearLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!BearLayout.this.cTx) {
                    BearLayout.this.axA();
                    aVar.axB();
                    return;
                }
                BearLayout.this.qQ(swanAppBearInfo.bearHomeUrl);
            }
        });
        this.cTw = (BdBaseImageView) linearLayout.findViewById(a.f.bear_account_loading_progress);
        this.cTw.setVisibility(8);
        this.cTy = new a() { // from class: com.baidu.swan.apps.view.BearLayout.3
            @Override // com.baidu.swan.apps.view.BearLayout.a
            public void qR(String str) {
                if (BearLayout.DEBUG) {
                    Log.d("BearLayout", str);
                }
                if (BearLayout.this.cTw != null && BearLayout.this.cTv != null) {
                    BearLayout.this.cTw.clearAnimation();
                    BearLayout.this.cTw.setVisibility(4);
                    BearLayout.this.cTv.setVisibility(0);
                }
            }

            @Override // com.baidu.swan.apps.view.BearLayout.a
            public void fI(boolean z) {
                BearLayout.this.cTx = z;
                if (BearLayout.this.cTw != null && BearLayout.this.cTv != null) {
                    BearLayout.this.cTw.clearAnimation();
                    BearLayout.this.cTw.setVisibility(4);
                    BearLayout.this.cTv.setVisibility(0);
                    BearLayout.this.cTv.setText(z ? BearLayout.this.mContext.getText(a.h.aiapps_bear_btn_navigate) : BearLayout.this.mContext.getText(a.h.aiapps_bear_btn_follow));
                    BearLayout.this.cTv.setTextColor(z ? context.getResources().getColor(a.c.aiapps_black_text) : context.getResources().getColor(a.c.aiapps_white_text));
                    BearLayout.this.cTu.setBackgroundResource(z ? a.e.aiapps_bear_paw_enter_btn : a.e.aiapps_bear_paw_follow_btn);
                }
            }
        };
    }

    private void setVipLogo(String str) {
        if (this.cTt != null) {
            if (TextUtils.isEmpty(str)) {
                this.cTt.setVisibility(8);
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
            this.cTt.setVisibility(0);
            this.cTt.setImageDrawable(this.mContext.getResources().getDrawable(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axA() {
        if (this.cTw != null && this.cTv != null) {
            this.cTv.setVisibility(4);
            this.cTw.setVisibility(0);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.cTw.startAnimation(rotateAnimation);
        }
    }

    public a getCallback() {
        return this.cTy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qQ(String str) {
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
