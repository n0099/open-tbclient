package com.baidu.live.x;

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
/* loaded from: classes10.dex */
public class b extends e implements f {
    private RoundRectRelativeLayout bud;
    private CommonWebLayout bue;
    private View bug;
    private float buh;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.web.f
    public void dL(int i) {
        dismiss();
    }

    public SchemeCallback NJ() {
        return this.bue.getSchemeCallback();
    }

    public void a(com.baidu.live.view.web.a aVar, String str) {
        if (this.bue != null) {
            this.bue.addJavascriptInterface(aVar, str);
        }
    }

    public void h(int i, int i2, String str) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            ShowUtil.windowCount++;
            this.bue.setBackgroundColor(i2);
            n(i, false);
            showAtLocation(findViewById, 85, 0, 0);
            this.bue.loadUrl(str);
        }
    }

    public void n(int i, boolean z) {
        if (i == 2) {
            this.bud.setCornerRadius(this.buh, 0.0f, 0.0f, this.buh);
            setAnimationStyle(a.i.sdk_goods_list_right_left);
            NK();
        } else {
            this.bud.setCornerRadius(this.buh, this.buh, 0.0f, 0.0f);
            setAnimationStyle(a.i.sdk_goods_list_up_to_top);
        }
        int[] dN = dN(i);
        if (z) {
            update(dN[0], dN[1]);
            return;
        }
        setWidth(dN[0]);
        setHeight(dN[1]);
    }

    public void dM(int i) {
        if (i == 2) {
            NK();
        }
        if (this.bue != null) {
            this.bue.onResume();
        }
    }

    public void pause() {
        if (this.bue != null) {
            this.bue.onPause();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.x.b.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (b.this.bue != null) {
                    b.this.bue.release();
                }
            }
        });
    }

    private void initView() {
        this.buh = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.bud = new RoundRectRelativeLayout(this.mActivity);
        q(this.bud);
        r(this.bud);
        setContentView(this.bud);
    }

    private void q(ViewGroup viewGroup) {
        this.bue = new CommonWebLayout(this.mActivity);
        this.bue.setBackgroundColor(0);
        this.bue.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.live.x.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void gU(String str) {
                super.gU(str);
                if (b.this.bug != null) {
                    b.this.bug.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dO(int i) {
                super.dO(i);
                if (i == 100 && b.this.bug != null) {
                    b.this.bug.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void gV(String str) {
                super.gV(str);
                if (b.this.bug != null) {
                    b.this.bug.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (b.this.bug != null) {
                    b.this.bug.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bue, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r(ViewGroup viewGroup) {
        this.bug = LayoutInflater.from(this.mActivity).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bug, layoutParams);
        this.bug.setVisibility(8);
    }

    private int[] dN(int i) {
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

    private void NK() {
        if (getContentView() != null && Build.VERSION.SDK_INT >= 19) {
            getContentView().setSystemUiVisibility(5380);
        }
    }
}
