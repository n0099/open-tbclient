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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tencent.connect.common.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes9.dex */
public class BearLayout extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private TextView dSX;
    private SimpleDraweeView dSY;
    private BdBaseImageView dSZ;
    private FrameLayout dTa;
    private TextView dTb;
    private BdBaseImageView dTc;
    private boolean dTd;
    private a dTe;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public interface a {
        void hC(boolean z);

        void vh(String str);
    }

    public BearLayout(Context context) {
        super(context);
        this.dTd = false;
    }

    public BearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dTd = false;
    }

    public void a(@NonNull final Context context, @NonNull final SwanAppBearInfo swanAppBearInfo, final com.baidu.swan.apps.view.a aVar) {
        this.mContext = context;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(a.g.aiapps_bear_layout, this);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.BearLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BearLayout.this.vg(swanAppBearInfo.bearHomeUrl);
            }
        });
        this.dSX = (TextView) linearLayout.findViewById(a.f.bear_account_name);
        this.dSX.setText(swanAppBearInfo.bearName);
        this.dSY = (SimpleDraweeView) linearLayout.findViewById(a.f.bear_account_logo);
        this.dSY.setImageURI(swanAppBearInfo.bearLogo);
        this.dSZ = (BdBaseImageView) linearLayout.findViewById(a.f.bear_account_vip_logo);
        setVipLogo(swanAppBearInfo.bearVipType);
        this.dTa = (FrameLayout) linearLayout.findViewById(a.f.bear_account_follow_background);
        this.dTb = (TextView) linearLayout.findViewById(a.f.bear_account_follow_btn);
        this.dTb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.BearLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!BearLayout.this.dTd) {
                    BearLayout.this.aSm();
                    aVar.aSn();
                    return;
                }
                BearLayout.this.vg(swanAppBearInfo.bearHomeUrl);
            }
        });
        this.dTc = (BdBaseImageView) linearLayout.findViewById(a.f.bear_account_loading_progress);
        this.dTc.setVisibility(8);
        this.dTe = new a() { // from class: com.baidu.swan.apps.view.BearLayout.3
            @Override // com.baidu.swan.apps.view.BearLayout.a
            public void vh(String str) {
                if (BearLayout.DEBUG) {
                    Log.d("BearLayout", str);
                }
                if (BearLayout.this.dTc != null && BearLayout.this.dTb != null) {
                    BearLayout.this.dTc.clearAnimation();
                    BearLayout.this.dTc.setVisibility(4);
                    BearLayout.this.dTb.setVisibility(0);
                }
            }

            @Override // com.baidu.swan.apps.view.BearLayout.a
            public void hC(boolean z) {
                BearLayout.this.dTd = z;
                if (BearLayout.this.dTc != null && BearLayout.this.dTb != null) {
                    BearLayout.this.dTc.clearAnimation();
                    BearLayout.this.dTc.setVisibility(4);
                    BearLayout.this.dTb.setVisibility(0);
                    BearLayout.this.dTb.setText(z ? BearLayout.this.mContext.getText(a.h.aiapps_bear_btn_navigate) : BearLayout.this.mContext.getText(a.h.aiapps_bear_btn_follow));
                    BearLayout.this.dTb.setTextColor(z ? context.getResources().getColor(a.c.aiapps_black_text) : context.getResources().getColor(a.c.aiapps_white_text));
                    BearLayout.this.dTa.setBackgroundResource(z ? a.e.aiapps_bear_paw_enter_btn : a.e.aiapps_bear_paw_follow_btn);
                }
            }
        };
    }

    private void setVipLogo(String str) {
        if (this.dSZ != null) {
            if (TextUtils.isEmpty(str)) {
                this.dSZ.setVisibility(8);
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
                    if (str.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)) {
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
            this.dSZ.setVisibility(0);
            this.dSZ.setImageDrawable(this.mContext.getResources().getDrawable(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSm() {
        if (this.dTc != null && this.dTb != null) {
            this.dTb.setVisibility(4);
            this.dTc.setVisibility(0);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.dTc.startAnimation(rotateAnimation);
        }
    }

    public a getCallback() {
        return this.dTe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vg(String str) {
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
