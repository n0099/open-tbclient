package com.baidu.live.sdk.goods.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.sdk.a;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.f;
import com.baidu.live.view.web.g;
/* loaded from: classes4.dex */
public class b extends Dialog {
    private Activity bdG;
    private a bdH;
    private RoundRectRelativeLayout bdI;
    private CommonWebLayout bdJ;
    private View bdK;
    private f bdL;
    private InterfaceC0182b bdM;
    private boolean bdN;

    /* loaded from: classes4.dex */
    public interface a {
        boolean a(String str, JsResult jsResult);
    }

    /* renamed from: com.baidu.live.sdk.goods.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0182b {
        void cb(boolean z);
    }

    public b(@NonNull Activity activity) {
        super(activity, a.j.sdk_Transparent);
        this.bdG = activity;
        init();
    }

    public void a(a aVar) {
        this.bdH = aVar;
    }

    public void a(f fVar) {
        this.bdL = fVar;
    }

    public CommonWebLayout Hl() {
        return this.bdJ;
    }

    public void show(String str) {
        EG();
        show();
        this.bdJ.loadUrl(str);
        ShowUtil.windowCount++;
    }

    private void init() {
        GH();
        initView();
        yV();
    }

    public void a(InterfaceC0182b interfaceC0182b) {
        this.bdM = interfaceC0182b;
    }

    private void GH() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.setGravity(80);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager windowManager = (WindowManager) this.bdG.getSystemService("window");
            if (windowManager != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (Build.VERSION.SDK_INT >= 17) {
                    windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                } else {
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = displayMetrics.widthPixels;
                attributes.height = (int) (displayMetrics.heightPixels * 0.65f);
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        float dimensionPixelOffset = this.bdG.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        this.bdI = new RoundRectRelativeLayout(this.bdG);
        this.bdI.setBackgroundColor(this.bdG.getResources().getColor(a.d.sdk_white_alpha100));
        this.bdI.setCornerRadius(dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f);
        initWebView();
        Hm();
        setContentView(this.bdI);
    }

    private void initWebView() {
        this.bdJ = new CommonWebLayout(this.bdG);
        this.bdJ.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.live.sdk.goods.c.b.1
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fH(String str) {
                if (b.this.bdK != null) {
                    b.this.bdK.setVisibility(8);
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    b.this.bdJ.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.live.sdk.goods.c.b.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            b.this.bdN = Boolean.valueOf(str2).booleanValue();
                            if (b.this.bdM != null) {
                                b.this.bdM.cb(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                if (b.this.bdK != null) {
                    b.this.bdK.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void Hn() {
                if (b.this.bdK != null) {
                    b.this.bdK.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean a(String str, JsResult jsResult) {
                if (b.this.bdH != null) {
                    return b.this.bdH.a(str, jsResult);
                }
                return true;
            }
        });
        g gVar = new g();
        gVar.v(this.bdG).b(this.bdL).a(this.bdJ.getSchemeCallback());
        com.baidu.live.view.web.a[] KV = gVar.KV();
        for (com.baidu.live.view.web.a aVar : KV) {
            this.bdJ.addJavascriptInterface(aVar, aVar.getName());
        }
        this.bdI.addView(this.bdJ, new ViewGroup.LayoutParams(-1, -1));
    }

    private void Hm() {
        this.bdK = LayoutInflater.from(this.bdG).inflate(a.h.live_commerce_web_goods_progress, (ViewGroup) null);
        this.bdI.addView(this.bdK, new ViewGroup.LayoutParams(-1, -1));
    }

    private void yV() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.sdk.goods.c.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bdJ != null) {
                    b.this.bdJ.release();
                }
                if (ShowUtil.windowCount > 0) {
                    ShowUtil.windowCount--;
                }
            }
        });
    }

    private void EG() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        if (this.bdI != null) {
            this.bdI.startAnimation(translateAnimation);
        }
    }
}
