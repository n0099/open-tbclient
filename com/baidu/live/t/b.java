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
    private RoundRectRelativeLayout bqG;
    private CommonWebLayout bqH;
    private View bqI;
    private float bqJ;
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

    public SchemeCallback OQ() {
        return this.bqH.getSchemeCallback();
    }

    public void a(com.baidu.live.view.web.a aVar, String str) {
        if (this.bqH != null) {
            this.bqH.addJavascriptInterface(aVar, str);
        }
    }

    public void h(int i, int i2, String str) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            ShowUtil.windowCount++;
            this.bqH.setBackgroundColor(i2);
            n(i, false);
            showAtLocation(findViewById, 85, 0, 0);
            this.bqH.loadUrl(str);
        }
    }

    public void n(int i, boolean z) {
        if (i == 2) {
            this.bqG.setCornerRadius(this.bqJ, 0.0f, 0.0f, this.bqJ);
            setAnimationStyle(a.i.sdk_goods_list_right_left);
            OR();
        } else {
            this.bqG.setCornerRadius(this.bqJ, this.bqJ, 0.0f, 0.0f);
            setAnimationStyle(a.i.sdk_goods_list_up_to_top);
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
            OR();
        }
        if (this.bqH != null) {
            this.bqH.onResume();
        }
    }

    public void pause() {
        if (this.bqH != null) {
            this.bqH.onPause();
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
                if (b.this.bqH != null) {
                    b.this.bqH.release();
                }
            }
        });
    }

    private void initView() {
        this.bqJ = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.bqG = new RoundRectRelativeLayout(this.mActivity);
        r(this.bqG);
        s(this.bqG);
        setContentView(this.bqG);
    }

    private void r(ViewGroup viewGroup) {
        this.bqH = new CommonWebLayout(this.mActivity);
        this.bqH.setBackgroundColor(0);
        this.bqH.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.live.t.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hU(String str) {
                super.hU(str);
                if (b.this.bqI != null) {
                    b.this.bqI.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fa(int i) {
                super.fa(i);
                if (i == 100 && b.this.bqI != null) {
                    b.this.bqI.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hV(String str) {
                super.hV(str);
                if (b.this.bqI != null) {
                    b.this.bqI.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (b.this.bqI != null) {
                    b.this.bqI.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bqH, new ViewGroup.LayoutParams(-1, -1));
    }

    private void s(ViewGroup viewGroup) {
        this.bqI = LayoutInflater.from(this.mActivity).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bqI, layoutParams);
        this.bqI.setVisibility(8);
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

    private void OR() {
        if (getContentView() != null && Build.VERSION.SDK_INT >= 19) {
            getContentView().setSystemUiVisibility(5380);
        }
    }
}
