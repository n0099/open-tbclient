package com.baidu.live.sdk.goods.d;

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
/* loaded from: classes3.dex */
public class b extends Dialog {
    private Activity bdo;
    private a bdp;
    private RoundRectRelativeLayout bdq;
    private CommonWebLayout bdr;
    private View bds;
    private f bdt;
    private InterfaceC0180b bdu;
    private boolean bdv;

    /* loaded from: classes3.dex */
    public interface a {
        boolean a(String str, JsResult jsResult);
    }

    /* renamed from: com.baidu.live.sdk.goods.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0180b {
        void bZ(boolean z);
    }

    public b(@NonNull Activity activity) {
        super(activity, a.j.sdk_Transparent);
        this.bdo = activity;
        init();
    }

    public void a(a aVar) {
        this.bdp = aVar;
    }

    public void a(f fVar) {
        this.bdt = fVar;
    }

    public CommonWebLayout Hf() {
        return this.bdr;
    }

    public void show(String str) {
        Ez();
        show();
        this.bdr.loadUrl(str);
        ShowUtil.windowCount++;
    }

    private void init() {
        Fj();
        initView();
        yt();
    }

    public void a(InterfaceC0180b interfaceC0180b) {
        this.bdu = interfaceC0180b;
    }

    private void Fj() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.setGravity(80);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager windowManager = (WindowManager) this.bdo.getSystemService("window");
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
        float dimensionPixelOffset = this.bdo.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        this.bdq = new RoundRectRelativeLayout(this.bdo);
        this.bdq.setBackgroundColor(this.bdo.getResources().getColor(a.d.sdk_white_alpha100));
        this.bdq.setCornerRadius(dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f);
        initWebView();
        Hg();
        setContentView(this.bdq);
    }

    private void initWebView() {
        this.bdr = new CommonWebLayout(this.bdo);
        this.bdr.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.live.sdk.goods.d.b.1
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fJ(String str) {
                if (b.this.bds != null) {
                    b.this.bds.setVisibility(8);
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    b.this.bdr.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.live.sdk.goods.d.b.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            b.this.bdv = Boolean.valueOf(str2).booleanValue();
                            if (b.this.bdu != null) {
                                b.this.bdu.bZ(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                if (b.this.bds != null) {
                    b.this.bds.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void Hh() {
                if (b.this.bds != null) {
                    b.this.bds.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean a(String str, JsResult jsResult) {
                if (b.this.bdp != null) {
                    return b.this.bdp.a(str, jsResult);
                }
                return true;
            }
        });
        g gVar = new g();
        gVar.u(this.bdo).b(this.bdt).a(this.bdr.getSchemeCallback());
        com.baidu.live.view.web.a[] KO = gVar.KO();
        for (com.baidu.live.view.web.a aVar : KO) {
            this.bdr.addJavascriptInterface(aVar, aVar.getName());
        }
        this.bdq.addView(this.bdr, new ViewGroup.LayoutParams(-1, -1));
    }

    private void Hg() {
        this.bds = LayoutInflater.from(this.bdo).inflate(a.h.live_commerce_web_goods_progress, (ViewGroup) null);
        this.bdq.addView(this.bds, new ViewGroup.LayoutParams(-1, -1));
    }

    private void yt() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.sdk.goods.d.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bdr != null) {
                    b.this.bdr.release();
                }
                if (ShowUtil.windowCount > 0) {
                    ShowUtil.windowCount--;
                }
            }
        });
    }

    private void Ez() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        if (this.bdq != null) {
            this.bdq.startAnimation(translateAnimation);
        }
    }
}
