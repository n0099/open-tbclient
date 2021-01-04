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
/* loaded from: classes11.dex */
public class b extends e implements f {
    private RoundRectRelativeLayout byQ;
    private CommonWebLayout byR;
    private View byS;
    private float byT;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.web.f
    public void fr(int i) {
        dismiss();
    }

    public SchemeCallback RE() {
        return this.byR.getSchemeCallback();
    }

    public void a(com.baidu.live.view.web.a aVar, String str) {
        if (this.byR != null) {
            this.byR.addJavascriptInterface(aVar, str);
        }
    }

    public void h(int i, int i2, String str) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            ShowUtil.windowCount++;
            this.byR.setBackgroundColor(i2);
            n(i, false);
            showAtLocation(findViewById, 85, 0, 0);
            this.byR.loadUrl(str);
        }
    }

    public void n(int i, boolean z) {
        if (i == 2) {
            this.byQ.setCornerRadius(this.byT, 0.0f, 0.0f, this.byT);
            setAnimationStyle(a.i.sdk_goods_list_right_left);
            RF();
        } else {
            this.byQ.setCornerRadius(this.byT, this.byT, 0.0f, 0.0f);
            setAnimationStyle(a.i.sdk_goods_list_up_to_top);
        }
        int[] ft = ft(i);
        if (z) {
            update(ft[0], ft[1]);
            return;
        }
        setWidth(ft[0]);
        setHeight(ft[1]);
    }

    public void fs(int i) {
        if (i == 2) {
            RF();
        }
        if (this.byR != null) {
            this.byR.onResume();
        }
    }

    public void pause() {
        if (this.byR != null) {
            this.byR.onPause();
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
                if (b.this.byR != null) {
                    b.this.byR.release();
                }
            }
        });
    }

    private void initView() {
        this.byT = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.byQ = new RoundRectRelativeLayout(this.mActivity);
        q(this.byQ);
        r(this.byQ);
        setContentView(this.byQ);
    }

    private void q(ViewGroup viewGroup) {
        this.byR = new CommonWebLayout(this.mActivity);
        this.byR.setBackgroundColor(0);
        this.byR.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.live.x.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            /* renamed from: if */
            public void mo20if(String str) {
                super.mo20if(str);
                if (b.this.byS != null) {
                    b.this.byS.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fu(int i) {
                super.fu(i);
                if (i == 100 && b.this.byS != null) {
                    b.this.byS.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ig(String str) {
                super.ig(str);
                if (b.this.byS != null) {
                    b.this.byS.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (b.this.byS != null) {
                    b.this.byS.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.byR, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r(ViewGroup viewGroup) {
        this.byS = LayoutInflater.from(this.mActivity).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.byS, layoutParams);
        this.byS.setVisibility(8);
    }

    private int[] ft(int i) {
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

    private void RF() {
        if (getContentView() != null && Build.VERSION.SDK_INT >= 19) {
            getContentView().setSystemUiVisibility(5380);
        }
    }
}
