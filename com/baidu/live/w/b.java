package com.baidu.live.w;

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
    private RoundRectRelativeLayout bue;
    private CommonWebLayout bug;
    private View buh;
    private float bui;
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

    public SchemeCallback QA() {
        return this.bug.getSchemeCallback();
    }

    public void a(com.baidu.live.view.web.a aVar, String str) {
        if (this.bug != null) {
            this.bug.addJavascriptInterface(aVar, str);
        }
    }

    public void h(int i, int i2, String str) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            ShowUtil.windowCount++;
            this.bug.setBackgroundColor(i2);
            n(i, false);
            showAtLocation(findViewById, 85, 0, 0);
            this.bug.loadUrl(str);
        }
    }

    public void n(int i, boolean z) {
        if (i == 2) {
            this.bue.setCornerRadius(this.bui, 0.0f, 0.0f, this.bui);
            setAnimationStyle(a.i.sdk_goods_list_right_left);
            QB();
        } else {
            this.bue.setCornerRadius(this.bui, this.bui, 0.0f, 0.0f);
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
            QB();
        }
        if (this.bug != null) {
            this.bug.onResume();
        }
    }

    public void pause() {
        if (this.bug != null) {
            this.bug.onPause();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.w.b.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (b.this.bug != null) {
                    b.this.bug.release();
                }
            }
        });
    }

    private void initView() {
        this.bui = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.bue = new RoundRectRelativeLayout(this.mActivity);
        n(this.bue);
        o(this.bue);
        setContentView(this.bue);
    }

    private void n(ViewGroup viewGroup) {
        this.bug = new CommonWebLayout(this.mActivity);
        this.bug.setBackgroundColor(0);
        this.bug.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.live.w.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void is(String str) {
                super.is(str);
                if (b.this.buh != null) {
                    b.this.buh.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fu(int i) {
                super.fu(i);
                if (i == 100 && b.this.buh != null) {
                    b.this.buh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void it(String str) {
                super.it(str);
                if (b.this.buh != null) {
                    b.this.buh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (b.this.buh != null) {
                    b.this.buh.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bug, new ViewGroup.LayoutParams(-1, -1));
    }

    private void o(ViewGroup viewGroup) {
        this.buh = LayoutInflater.from(this.mActivity).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.buh, layoutParams);
        this.buh.setVisibility(8);
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

    private void QB() {
        if (getContentView() != null && Build.VERSION.SDK_INT >= 19) {
            getContentView().setSystemUiVisibility(5380);
        }
    }
}
