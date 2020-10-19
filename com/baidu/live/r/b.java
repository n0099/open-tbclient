package com.baidu.live.r;

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
    private RoundRectRelativeLayout bnA;
    private CommonWebLayout bnB;
    private View bnC;
    private float bnD;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.web.f
    public void eU(int i) {
        dismiss();
    }

    public SchemeCallback NS() {
        return this.bnB.getSchemeCallback();
    }

    public void a(com.baidu.live.view.web.a aVar, String str) {
        if (this.bnB != null) {
            this.bnB.addJavascriptInterface(aVar, str);
        }
    }

    public void g(int i, int i2, String str) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            ShowUtil.windowCount++;
            this.bnB.setBackgroundColor(i2);
            n(i, false);
            showAtLocation(findViewById, 85, 0, 0);
            this.bnB.loadUrl(str);
        }
    }

    public void n(int i, boolean z) {
        if (i == 2) {
            this.bnA.setCornerRadius(this.bnD, 0.0f, 0.0f, this.bnD);
            setAnimationStyle(a.j.sdk_goods_list_right_left);
            NT();
        } else {
            this.bnA.setCornerRadius(this.bnD, this.bnD, 0.0f, 0.0f);
            setAnimationStyle(a.j.sdk_goods_list_up_to_top);
        }
        int[] eW = eW(i);
        if (z) {
            update(eW[0], eW[1]);
            return;
        }
        setWidth(eW[0]);
        setHeight(eW[1]);
    }

    public void eV(int i) {
        if (i == 2) {
            NT();
        }
        if (this.bnB != null) {
            this.bnB.onResume();
        }
    }

    public void pause() {
        if (this.bnB != null) {
            this.bnB.onPause();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.r.b.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (b.this.bnB != null) {
                    b.this.bnB.release();
                }
            }
        });
    }

    private void initView() {
        this.bnD = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.bnA = new RoundRectRelativeLayout(this.mActivity);
        q(this.bnA);
        r(this.bnA);
        setContentView(this.bnA);
    }

    private void q(ViewGroup viewGroup) {
        this.bnB = new CommonWebLayout(this.mActivity);
        this.bnB.setBackgroundColor(0);
        this.bnB.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.live.r.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hF(String str) {
                super.hF(str);
                if (b.this.bnC != null) {
                    b.this.bnC.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void eX(int i) {
                super.eX(i);
                if (i == 100 && b.this.bnC != null) {
                    b.this.bnC.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hG(String str) {
                super.hG(str);
                if (b.this.bnC != null) {
                    b.this.bnC.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (b.this.bnC != null) {
                    b.this.bnC.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bnB, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r(ViewGroup viewGroup) {
        this.bnC = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bnC, layoutParams);
        this.bnC.setVisibility(8);
    }

    private int[] eW(int i) {
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

    private void NT() {
        if (getContentView() != null && Build.VERSION.SDK_INT >= 19) {
            getContentView().setSystemUiVisibility(5380);
        }
    }
}
