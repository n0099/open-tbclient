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
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tencent.connect.common.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class BearLayout extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private TextView aWE;
    private SimpleDraweeView aWF;
    private BdBaseImageView aWG;
    private FrameLayout aWH;
    private TextView aWI;
    private BdBaseImageView aWJ;
    private boolean aWK;
    private a aWL;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void cn(boolean z);

        void hP(String str);
    }

    public BearLayout(Context context) {
        super(context);
        this.aWK = false;
    }

    public BearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWK = false;
    }

    public void a(@NonNull final Context context, @NonNull final SwanAppBearInfo swanAppBearInfo, final com.baidu.swan.apps.view.a aVar) {
        this.mContext = context;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(b.g.aiapps_bear_layout, this);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.BearLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BearLayout.this.hO(swanAppBearInfo.aBu);
            }
        });
        this.aWE = (TextView) linearLayout.findViewById(b.f.bear_account_name);
        this.aWE.setText(swanAppBearInfo.aBs);
        this.aWF = (SimpleDraweeView) linearLayout.findViewById(b.f.bear_account_logo);
        this.aWF.setImageURI(swanAppBearInfo.aBt);
        this.aWG = (BdBaseImageView) linearLayout.findViewById(b.f.bear_account_vip_logo);
        setVipLogo(swanAppBearInfo.aBw);
        this.aWH = (FrameLayout) linearLayout.findViewById(b.f.bear_account_follow_background);
        this.aWI = (TextView) linearLayout.findViewById(b.f.bear_account_follow_btn);
        this.aWI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.BearLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!BearLayout.this.aWK) {
                    BearLayout.this.Mu();
                    aVar.Mv();
                    return;
                }
                BearLayout.this.hO(swanAppBearInfo.aBu);
            }
        });
        this.aWJ = (BdBaseImageView) linearLayout.findViewById(b.f.bear_account_loading_progress);
        this.aWJ.setVisibility(8);
        this.aWL = new a() { // from class: com.baidu.swan.apps.view.BearLayout.3
            @Override // com.baidu.swan.apps.view.BearLayout.a
            public void hP(String str) {
                if (BearLayout.DEBUG) {
                    Log.d("BearLayout", str);
                }
                if (BearLayout.this.aWJ != null && BearLayout.this.aWI != null) {
                    BearLayout.this.aWJ.clearAnimation();
                    BearLayout.this.aWJ.setVisibility(4);
                    BearLayout.this.aWI.setVisibility(0);
                }
            }

            @Override // com.baidu.swan.apps.view.BearLayout.a
            public void cn(boolean z) {
                BearLayout.this.aWK = z;
                if (BearLayout.this.aWJ != null && BearLayout.this.aWI != null) {
                    BearLayout.this.aWJ.clearAnimation();
                    BearLayout.this.aWJ.setVisibility(4);
                    BearLayout.this.aWI.setVisibility(0);
                    BearLayout.this.aWI.setText(z ? BearLayout.this.mContext.getText(b.h.aiapps_bear_btn_navigate) : BearLayout.this.mContext.getText(b.h.aiapps_bear_btn_follow));
                    BearLayout.this.aWI.setTextColor(z ? context.getResources().getColor(b.c.aiapps_black_text) : context.getResources().getColor(b.c.aiapps_white_text));
                    BearLayout.this.aWH.setBackgroundResource(z ? b.e.aiapps_bear_paw_enter_btn : b.e.aiapps_bear_paw_follow_btn);
                }
            }
        };
    }

    private void setVipLogo(String str) {
        if (this.aWG != null) {
            if (TextUtils.isEmpty(str)) {
                this.aWG.setVisibility(8);
                return;
            }
            int i = b.e.aiapps_follow_vip_golden;
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
                    i = b.e.aiapps_follow_vip_blue;
                    break;
                case 2:
                    i = b.e.aiapps_follow_vip_yellow;
                    break;
                case 3:
                    i = b.e.aiapps_follow_vip_authentication;
                    break;
            }
            this.aWG.setVisibility(0);
            this.aWG.setImageDrawable(this.mContext.getResources().getDrawable(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mu() {
        if (this.aWJ != null && this.aWI != null) {
            this.aWI.setVisibility(4);
            this.aWJ.setVisibility(0);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.aWJ.startAnimation(rotateAnimation);
        }
    }

    public a getCallback() {
        return this.aWL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(String str) {
        String str2 = null;
        try {
            str2 = URLEncoder.encode(str, HTTP.UTF_8);
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
