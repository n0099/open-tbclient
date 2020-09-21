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
    private RoundRectRelativeLayout bjN;
    private CommonWebLayout bjO;
    private View bjP;
    private float bjQ;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.web.f
    public void eL(int i) {
        dismiss();
    }

    public SchemeCallback MN() {
        return this.bjO.getSchemeCallback();
    }

    public void a(com.baidu.live.view.web.a aVar, String str) {
        if (this.bjO != null) {
            this.bjO.addJavascriptInterface(aVar, str);
        }
    }

    public void f(int i, int i2, String str) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            ShowUtil.windowCount++;
            this.bjO.setBackgroundColor(i2);
            n(i, false);
            showAtLocation(findViewById, 85, 0, 0);
            this.bjO.loadUrl(str);
        }
    }

    public void n(int i, boolean z) {
        if (i == 2) {
            this.bjN.setCornerRadius(this.bjQ, 0.0f, 0.0f, this.bjQ);
            setAnimationStyle(a.j.sdk_goods_list_right_left);
            MO();
        } else {
            this.bjN.setCornerRadius(this.bjQ, this.bjQ, 0.0f, 0.0f);
            setAnimationStyle(a.j.sdk_goods_list_up_to_top);
        }
        int[] eN = eN(i);
        if (z) {
            update(eN[0], eN[1]);
            return;
        }
        setWidth(eN[0]);
        setHeight(eN[1]);
    }

    public void eM(int i) {
        if (i == 2) {
            MO();
        }
        if (this.bjO != null) {
            this.bjO.onResume();
        }
    }

    public void pause() {
        if (this.bjO != null) {
            this.bjO.onPause();
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
                if (b.this.bjO != null) {
                    b.this.bjO.release();
                }
            }
        });
    }

    private void initView() {
        this.bjQ = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.bjN = new RoundRectRelativeLayout(this.mActivity);
        q(this.bjN);
        r(this.bjN);
        setContentView(this.bjN);
    }

    private void q(ViewGroup viewGroup) {
        this.bjO = new CommonWebLayout(this.mActivity);
        this.bjO.setBackgroundColor(0);
        this.bjO.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.live.r.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ho(String str) {
                super.ho(str);
                if (b.this.bjP != null) {
                    b.this.bjP.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void eO(int i) {
                super.eO(i);
                if (i == 100 && b.this.bjP != null) {
                    b.this.bjP.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hp(String str) {
                super.hp(str);
                if (b.this.bjP != null) {
                    b.this.bjP.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (b.this.bjP != null) {
                    b.this.bjP.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bjO, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r(ViewGroup viewGroup) {
        this.bjP = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bjP, layoutParams);
        this.bjP.setVisibility(8);
    }

    private int[] eN(int i) {
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

    private void MO() {
        if (getContentView() != null && Build.VERSION.SDK_INT >= 19) {
            getContentView().setSystemUiVisibility(5380);
        }
    }
}
