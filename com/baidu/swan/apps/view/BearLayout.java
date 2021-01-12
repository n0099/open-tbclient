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
/* loaded from: classes8.dex */
public class BearLayout extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private TextView dOl;
    private SimpleDraweeView dOm;
    private BdBaseImageView dOn;
    private FrameLayout dOo;
    private TextView dOp;
    private BdBaseImageView dOq;
    private boolean dOr;
    private a dOs;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public interface a {
        void hy(boolean z);

        void tW(String str);
    }

    public BearLayout(Context context) {
        super(context);
        this.dOr = false;
    }

    public BearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dOr = false;
    }

    public void a(@NonNull final Context context, @NonNull final SwanAppBearInfo swanAppBearInfo, final com.baidu.swan.apps.view.a aVar) {
        this.mContext = context;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(a.g.aiapps_bear_layout, this);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.BearLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BearLayout.this.tV(swanAppBearInfo.bearHomeUrl);
            }
        });
        this.dOl = (TextView) linearLayout.findViewById(a.f.bear_account_name);
        this.dOl.setText(swanAppBearInfo.bearName);
        this.dOm = (SimpleDraweeView) linearLayout.findViewById(a.f.bear_account_logo);
        this.dOm.setImageURI(swanAppBearInfo.bearLogo);
        this.dOn = (BdBaseImageView) linearLayout.findViewById(a.f.bear_account_vip_logo);
        setVipLogo(swanAppBearInfo.bearVipType);
        this.dOo = (FrameLayout) linearLayout.findViewById(a.f.bear_account_follow_background);
        this.dOp = (TextView) linearLayout.findViewById(a.f.bear_account_follow_btn);
        this.dOp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.BearLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!BearLayout.this.dOr) {
                    BearLayout.this.aOt();
                    aVar.aOu();
                    return;
                }
                BearLayout.this.tV(swanAppBearInfo.bearHomeUrl);
            }
        });
        this.dOq = (BdBaseImageView) linearLayout.findViewById(a.f.bear_account_loading_progress);
        this.dOq.setVisibility(8);
        this.dOs = new a() { // from class: com.baidu.swan.apps.view.BearLayout.3
            @Override // com.baidu.swan.apps.view.BearLayout.a
            public void tW(String str) {
                if (BearLayout.DEBUG) {
                    Log.d("BearLayout", str);
                }
                if (BearLayout.this.dOq != null && BearLayout.this.dOp != null) {
                    BearLayout.this.dOq.clearAnimation();
                    BearLayout.this.dOq.setVisibility(4);
                    BearLayout.this.dOp.setVisibility(0);
                }
            }

            @Override // com.baidu.swan.apps.view.BearLayout.a
            public void hy(boolean z) {
                BearLayout.this.dOr = z;
                if (BearLayout.this.dOq != null && BearLayout.this.dOp != null) {
                    BearLayout.this.dOq.clearAnimation();
                    BearLayout.this.dOq.setVisibility(4);
                    BearLayout.this.dOp.setVisibility(0);
                    BearLayout.this.dOp.setText(z ? BearLayout.this.mContext.getText(a.h.aiapps_bear_btn_navigate) : BearLayout.this.mContext.getText(a.h.aiapps_bear_btn_follow));
                    BearLayout.this.dOp.setTextColor(z ? context.getResources().getColor(a.c.aiapps_black_text) : context.getResources().getColor(a.c.aiapps_white_text));
                    BearLayout.this.dOo.setBackgroundResource(z ? a.e.aiapps_bear_paw_enter_btn : a.e.aiapps_bear_paw_follow_btn);
                }
            }
        };
    }

    private void setVipLogo(String str) {
        if (this.dOn != null) {
            if (TextUtils.isEmpty(str)) {
                this.dOn.setVisibility(8);
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
            this.dOn.setVisibility(0);
            this.dOn.setImageDrawable(this.mContext.getResources().getDrawable(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOt() {
        if (this.dOq != null && this.dOp != null) {
            this.dOp.setVisibility(4);
            this.dOq.setVisibility(0);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.dOq.startAnimation(rotateAnimation);
        }
    }

    public a getCallback() {
        return this.dOs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tV(String str) {
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
