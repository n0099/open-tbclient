package com.baidu.live.s;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes4.dex */
public class b extends f implements com.baidu.live.view.web.f {
    private RoundRectRelativeLayout bpn;
    private CommonWebLayout bpo;
    private View bpp;
    private float bpq;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.web.f
    public void eX(int i) {
        dismiss();
    }

    public SchemeCallback Oq() {
        return this.bpo.getSchemeCallback();
    }

    public void a(com.baidu.live.view.web.a aVar, String str) {
        if (this.bpo != null) {
            this.bpo.addJavascriptInterface(aVar, str);
        }
    }

    public void h(int i, int i2, String str) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            ShowUtil.windowCount++;
            this.bpo.setBackgroundColor(i2);
            n(i, false);
            showAtLocation(findViewById, 85, 0, 0);
            this.bpo.loadUrl(str);
        }
    }

    public void n(int i, boolean z) {
        if (i == 2) {
            this.bpn.setCornerRadius(this.bpq, 0.0f, 0.0f, this.bpq);
            setAnimationStyle(a.j.sdk_goods_list_right_left);
            Or();
        } else {
            this.bpn.setCornerRadius(this.bpq, this.bpq, 0.0f, 0.0f);
            setAnimationStyle(a.j.sdk_goods_list_up_to_top);
        }
        int[] eZ = eZ(i);
        if (z) {
            update(eZ[0], eZ[1]);
            return;
        }
        setWidth(eZ[0]);
        setHeight(eZ[1]);
    }

    public void eY(int i) {
        if (i == 2) {
            Or();
        }
        if (this.bpo != null) {
            this.bpo.onResume();
        }
    }

    public void pause() {
        if (this.bpo != null) {
            this.bpo.onPause();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.s.b.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (b.this.bpo != null) {
                    b.this.bpo.release();
                }
            }
        });
    }

    private void initView() {
        this.bpq = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.bpn = new RoundRectRelativeLayout(this.mActivity);
        q(this.bpn);
        r(this.bpn);
        setContentView(this.bpn);
    }

    private void q(ViewGroup viewGroup) {
        this.bpo = new CommonWebLayout(this.mActivity);
        this.bpo.setBackgroundColor(0);
        this.bpo.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.live.s.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hN(String str) {
                super.hN(str);
                if (b.this.bpp != null) {
                    b.this.bpp.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fa(int i) {
                super.fa(i);
                if (i == 100 && b.this.bpp != null) {
                    b.this.bpp.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hO(String str) {
                super.hO(str);
                if (b.this.bpp != null) {
                    b.this.bpp.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (b.this.bpp != null) {
                    b.this.bpp.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bpo, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r(ViewGroup viewGroup) {
        this.bpp = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bpp, layoutParams);
        this.bpp.setVisibility(8);
    }

    private int[] eZ(int i) {
        int[] iArr = new int[2];
        if (i == 2) {
            iArr[0] = ScreenHelper.getRealScreenHeight(this.mActivity);
            iArr[1] = ScreenHelper.getRealScreenHeight(this.mActivity);
        } else {
            iArr[0] = ScreenHelper.getRealScreenWidth(this.mActivity);
            iArr[1] = (int) (ScreenHelper.getRealScreenHeight(this.mActivity) * 0.65f);
        }
        return iArr;
    }

    private void Or() {
        if (getContentView() != null && Build.VERSION.SDK_INT >= 19) {
            getContentView().setSystemUiVisibility(5380);
        }
    }
}
