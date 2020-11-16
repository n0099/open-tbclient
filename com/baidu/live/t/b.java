package com.baidu.live.t;

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
import com.baidu.live.view.e;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.f;
/* loaded from: classes4.dex */
public class b extends e implements f {
    private RoundRectRelativeLayout boV;
    private CommonWebLayout boW;
    private View boX;
    private float boY;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.web.f
    public void eT(int i) {
        dismiss();
    }

    public SchemeCallback Oh() {
        return this.boW.getSchemeCallback();
    }

    public void a(com.baidu.live.view.web.a aVar, String str) {
        if (this.boW != null) {
            this.boW.addJavascriptInterface(aVar, str);
        }
    }

    public void g(int i, int i2, String str) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            ShowUtil.windowCount++;
            this.boW.setBackgroundColor(i2);
            n(i, false);
            showAtLocation(findViewById, 85, 0, 0);
            this.boW.loadUrl(str);
        }
    }

    public void n(int i, boolean z) {
        if (i == 2) {
            this.boV.setCornerRadius(this.boY, 0.0f, 0.0f, this.boY);
            setAnimationStyle(a.i.sdk_goods_list_right_left);
            Oi();
        } else {
            this.boV.setCornerRadius(this.boY, this.boY, 0.0f, 0.0f);
            setAnimationStyle(a.i.sdk_goods_list_up_to_top);
        }
        int[] eV = eV(i);
        if (z) {
            update(eV[0], eV[1]);
            return;
        }
        setWidth(eV[0]);
        setHeight(eV[1]);
    }

    public void eU(int i) {
        if (i == 2) {
            Oi();
        }
        if (this.boW != null) {
            this.boW.onResume();
        }
    }

    public void pause() {
        if (this.boW != null) {
            this.boW.onPause();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.t.b.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (b.this.boW != null) {
                    b.this.boW.release();
                }
            }
        });
    }

    private void initView() {
        this.boY = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.boV = new RoundRectRelativeLayout(this.mActivity);
        n(this.boV);
        o(this.boV);
        setContentView(this.boV);
    }

    private void n(ViewGroup viewGroup) {
        this.boW = new CommonWebLayout(this.mActivity);
        this.boW.setBackgroundColor(0);
        this.boW.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.live.t.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hO(String str) {
                super.hO(str);
                if (b.this.boX != null) {
                    b.this.boX.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void eW(int i) {
                super.eW(i);
                if (i == 100 && b.this.boX != null) {
                    b.this.boX.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hP(String str) {
                super.hP(str);
                if (b.this.boX != null) {
                    b.this.boX.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (b.this.boX != null) {
                    b.this.boX.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.boW, new ViewGroup.LayoutParams(-1, -1));
    }

    private void o(ViewGroup viewGroup) {
        this.boX = LayoutInflater.from(this.mActivity).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.boX, layoutParams);
        this.boX.setVisibility(8);
    }

    private int[] eV(int i) {
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

    private void Oi() {
        if (getContentView() != null && Build.VERSION.SDK_INT >= 19) {
            getContentView().setSystemUiVisibility(5380);
        }
    }
}
