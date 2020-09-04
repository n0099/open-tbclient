package com.baidu.prologue.business.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.prologue.a.c.g;
import com.baidu.prologue.b;
import com.baidu.prologue.business.b.a;
import com.baidu.prologue.business.data.SplashStyleRecorder;
/* loaded from: classes9.dex */
public abstract class b<T extends com.baidu.prologue.business.b.a> implements View.OnClickListener, View.OnTouchListener, a {
    public static final boolean DEBUG = com.baidu.prologue.a.a.a.GLOBAL_DEBUG;
    private long bLC;
    private String bLF;
    private ImageView bLq;
    private ImageView bLr;
    private RelativeLayout bLs;
    private TextView bLt;
    private View bLu;
    private TextView bLv;
    private TextView bLw;
    private long bLx;
    private LinearLayout bLy;
    private Context mContext;
    private LayoutInflater mInflater;
    ViewGroup mRootView = null;
    private View bLg = null;
    private T bLp = null;
    private String labelName = "广告";
    private String bLz = "";
    boolean bLi = false;
    private boolean bLA = true;
    private boolean bLB = true;
    private long bLD = 0;
    boolean bLE = false;
    protected Handler mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.prologue.business.c.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (b.DEBUG) {
                        g.bKo.d("SplashAbsBaseViewBuilder", "quit count");
                    }
                    b.this.bLp.ry();
                    b.this.VM();
                    return;
                case 1:
                    b.this.VP();
                    if (b.DEBUG) {
                        g.bKo.d("SplashAbsBaseViewBuilder", "update countdown");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.mContext = null;
        this.mInflater = null;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public b<T> a(T t) {
        this.bLp = t;
        if (this.bLp != null) {
            this.bLp.a(this);
        }
        return this;
    }

    public b<T> di(boolean z) {
        this.bLi = z;
        return this;
    }

    public b<T> ig(String str) {
        this.bLz = str;
        return this;
    }

    public b<T> gb(int i) {
        this.bLC = i;
        return this;
    }

    public b<T> ih(String str) {
        this.labelName = str;
        return this;
    }

    public b<T> ii(String str) {
        this.bLF = str;
        return this;
    }

    public b<T> dj(boolean z) {
        this.bLE = z;
        return this;
    }

    public long VI() {
        return System.currentTimeMillis() - this.bLD;
    }

    public long VJ() {
        return this.bLx;
    }

    public T VK() {
        return this.bLp;
    }

    @SuppressLint({"ResourceType"})
    public void build() {
        int Vc;
        ViewGroup.LayoutParams layoutParams;
        this.mRootView = (ViewGroup) this.mInflater.inflate(getLayoutId(), (ViewGroup) null, false);
        VH();
        this.bLg = VE();
        if (this.bLg != null) {
            this.bLg.setOnTouchListener(this);
        } else {
            g.bKo.e("SplashAbsBaseViewBuilder", "Splash Ad didn't set up clickable view!");
        }
        this.bLs = (RelativeLayout) this.mRootView.findViewById(b.C0279b.image_logo_view);
        this.bLr = (ImageView) this.mRootView.findViewById(b.C0279b.image_logo_img);
        if (this.bLi) {
            if (this.bLs != null && (layoutParams = this.bLs.getLayoutParams()) != null) {
                layoutParams.height = 0;
            }
            this.bLq = (ImageView) this.mRootView.findViewById(b.C0279b.image_small_logo_img);
            if (this.bLq != null && (TextUtils.equals(this.bLz, "0") || TextUtils.equals(this.bLz, "1"))) {
                this.bLq.setVisibility(0);
                ImageView imageView = this.bLq;
                if (TextUtils.equals(this.bLz, "0")) {
                    Vc = com.baidu.prologue.a.b.a.bKm.get().Vd();
                } else {
                    Vc = com.baidu.prologue.a.b.a.bKm.get().Vc();
                }
                imageView.setImageResource(Vc);
                e.a(this.bLq, SplashStyleRecorder.SplashElements.LOGO, this.bLi);
            }
        } else {
            this.bLr.setImageResource(com.baidu.prologue.a.b.a.bKm.get().Ve());
        }
        VL();
        onAdShow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int[] iArr = {0, 0};
            iArr[1] = (int) motionEvent.getRawY();
            iArr[0] = (int) motionEvent.getRawX();
            this.bLp.ie(com.baidu.prologue.business.b.Vj().a(this.mRootView, iArr));
            VM();
        }
        return true;
    }

    protected void VL() {
        VO();
        if (!TextUtils.isEmpty(this.labelName)) {
            this.bLt = (TextView) this.mRootView.findViewById(b.C0279b.splash_ad_label);
            e.a(this.bLt, SplashStyleRecorder.SplashElements.LABEL, this.bLi);
            this.bLt.setText(this.labelName);
            this.bLt.setVisibility(0);
        }
    }

    protected void onAdShow() {
        this.bLp.onAdShow();
    }

    public void VM() {
        VN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void VN() {
        if (this.mUiHandler != null) {
            this.mUiHandler.removeCallbacksAndMessages(null);
        }
    }

    protected void VO() {
        this.bLv = (TextView) this.mRootView.findViewById(b.C0279b.splash_ad_btn_skip);
        this.bLw = (TextView) this.mRootView.findViewById(b.C0279b.splash_ad_countdown);
        this.bLy = (LinearLayout) this.mRootView.findViewById(b.C0279b.splash_countdown_skip);
        this.bLu = this.mRootView.findViewById(b.C0279b.splash_countdown_skip_click);
        e.a(this.bLu, SplashStyleRecorder.SplashElements.SKIP, this.bLi);
        if (this.bLC <= 0) {
            if ("splash_image".equals(this.bLF)) {
                this.bLC = 3L;
            } else {
                this.bLC = 5L;
            }
        }
        this.bLx = this.bLC * 1000;
        if (this.bLA) {
            this.bLy.setVisibility(0);
            this.bLw.setVisibility(0);
            this.bLy.setOnClickListener(this);
            this.bLD = System.currentTimeMillis();
            this.bLw.setText(String.format("%02d", Long.valueOf(this.bLx / 1000)));
            this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
        } else {
            this.mUiHandler.sendEmptyMessageDelayed(0, this.bLx);
        }
        if (this.bLB) {
            this.bLy.setVisibility(0);
            this.bLv.setVisibility(0);
            this.bLy.setOnClickListener(this);
        }
    }

    public View getRootView() {
        if (this.mRootView == null) {
            build();
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VP() {
        if (this.bLw != null) {
            long currentTimeMillis = this.bLx - (System.currentTimeMillis() - this.bLD);
            if (currentTimeMillis > 0) {
                this.bLw.setText(String.format("%02d", Long.valueOf((currentTimeMillis / 1000) + 1)));
                this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
            } else {
                this.mUiHandler.sendEmptyMessage(0);
            }
            this.bLw.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bLy) {
            this.bLp.Vn();
            VM();
        }
    }
}
