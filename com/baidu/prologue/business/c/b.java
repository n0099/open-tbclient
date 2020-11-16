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
/* loaded from: classes14.dex */
public abstract class b<T extends com.baidu.prologue.business.b.a> implements View.OnClickListener, View.OnTouchListener, a {
    public static final boolean DEBUG = com.baidu.prologue.a.a.a.GLOBAL_DEBUG;
    private TextView cgA;
    private View cgB;
    private TextView cgC;
    private TextView cgD;
    private long cgE;
    private LinearLayout cgF;
    private long cgJ;
    private String cgM;
    private ImageView cgx;
    private ImageView cgy;
    private RelativeLayout cgz;
    private Context mContext;
    private LayoutInflater mInflater;
    ViewGroup mRootView = null;
    private View cgn = null;
    private T cgw = null;
    private String labelName = "广告";
    private String cgG = "";
    boolean cgp = false;
    private boolean cgH = true;
    private boolean cgI = true;
    private long cgK = 0;
    boolean cgL = false;
    protected Handler mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.prologue.business.c.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (b.DEBUG) {
                        g.cfv.d("SplashAbsBaseViewBuilder", "quit count");
                    }
                    b.this.cgw.rD();
                    b.this.acb();
                    return;
                case 1:
                    b.this.ace();
                    if (b.DEBUG) {
                        g.cfv.d("SplashAbsBaseViewBuilder", "update countdown");
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
        this.cgw = t;
        if (this.cgw != null) {
            this.cgw.a(this);
        }
        return this;
    }

    public b<T> dK(boolean z) {
        this.cgp = z;
        return this;
    }

    public b<T> jB(String str) {
        this.cgG = str;
        return this;
    }

    public b<T> gV(int i) {
        this.cgJ = i;
        return this;
    }

    public b<T> jC(String str) {
        this.labelName = str;
        return this;
    }

    public b<T> jD(String str) {
        this.cgM = str;
        return this;
    }

    public b<T> dL(boolean z) {
        this.cgL = z;
        return this;
    }

    public long abX() {
        return System.currentTimeMillis() - this.cgK;
    }

    public long abY() {
        return this.cgE;
    }

    public T abZ() {
        return this.cgw;
    }

    @SuppressLint({"ResourceType"})
    public void build() {
        int abs;
        ViewGroup.LayoutParams layoutParams;
        this.mRootView = (ViewGroup) this.mInflater.inflate(getLayoutId(), (ViewGroup) null, false);
        Xh();
        this.cgn = abU();
        if (this.cgn != null) {
            this.cgn.setOnTouchListener(this);
        } else {
            g.cfv.e("SplashAbsBaseViewBuilder", "Splash Ad didn't set up clickable view!");
        }
        this.cgz = (RelativeLayout) this.mRootView.findViewById(b.C0316b.image_logo_view);
        this.cgy = (ImageView) this.mRootView.findViewById(b.C0316b.image_logo_img);
        if (this.cgp) {
            if (this.cgz != null && (layoutParams = this.cgz.getLayoutParams()) != null) {
                layoutParams.height = 0;
            }
            this.cgx = (ImageView) this.mRootView.findViewById(b.C0316b.image_small_logo_img);
            if (this.cgx != null && (TextUtils.equals(this.cgG, "0") || TextUtils.equals(this.cgG, "1"))) {
                this.cgx.setVisibility(0);
                ImageView imageView = this.cgx;
                if (TextUtils.equals(this.cgG, "0")) {
                    abs = com.baidu.prologue.a.b.a.cft.get().abt();
                } else {
                    abs = com.baidu.prologue.a.b.a.cft.get().abs();
                }
                imageView.setImageResource(abs);
                e.a(this.cgx, SplashStyleRecorder.SplashElements.LOGO, this.cgp);
            }
        } else {
            this.cgy.setImageResource(com.baidu.prologue.a.b.a.cft.get().abu());
        }
        aca();
        onAdShow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int[] iArr = {0, 0};
            iArr[1] = (int) motionEvent.getRawY();
            iArr[0] = (int) motionEvent.getRawX();
            this.cgw.jz(com.baidu.prologue.business.b.abz().a(this.mRootView, iArr));
            acb();
        }
        return true;
    }

    protected void aca() {
        acd();
        if (!TextUtils.isEmpty(this.labelName)) {
            this.cgA = (TextView) this.mRootView.findViewById(b.C0316b.splash_ad_label);
            e.a(this.cgA, SplashStyleRecorder.SplashElements.LABEL, this.cgp);
            this.cgA.setText(this.labelName);
            this.cgA.setVisibility(0);
        }
    }

    protected void onAdShow() {
        this.cgw.onAdShow();
    }

    public void acb() {
        acc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acc() {
        if (this.mUiHandler != null) {
            this.mUiHandler.removeCallbacksAndMessages(null);
        }
    }

    protected void acd() {
        this.cgC = (TextView) this.mRootView.findViewById(b.C0316b.splash_ad_btn_skip);
        this.cgD = (TextView) this.mRootView.findViewById(b.C0316b.splash_ad_countdown);
        this.cgF = (LinearLayout) this.mRootView.findViewById(b.C0316b.splash_countdown_skip);
        this.cgB = this.mRootView.findViewById(b.C0316b.splash_countdown_skip_click);
        e.a(this.cgB, SplashStyleRecorder.SplashElements.SKIP, this.cgp);
        if (this.cgJ <= 0) {
            if ("splash_image".equals(this.cgM)) {
                this.cgJ = 3L;
            } else {
                this.cgJ = 5L;
            }
        }
        this.cgE = this.cgJ * 1000;
        if (this.cgH) {
            this.cgF.setVisibility(0);
            this.cgD.setVisibility(0);
            this.cgF.setOnClickListener(this);
            this.cgK = System.currentTimeMillis();
            this.cgD.setText(String.format("%02d", Long.valueOf(this.cgE / 1000)));
            this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
        } else {
            this.mUiHandler.sendEmptyMessageDelayed(0, this.cgE);
        }
        if (this.cgI) {
            this.cgF.setVisibility(0);
            this.cgC.setVisibility(0);
            this.cgF.setOnClickListener(this);
        }
    }

    public View getRootView() {
        if (this.mRootView == null) {
            build();
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ace() {
        if (this.cgD != null) {
            long currentTimeMillis = this.cgE - (System.currentTimeMillis() - this.cgK);
            if (currentTimeMillis > 0) {
                this.cgD.setText(String.format("%02d", Long.valueOf((currentTimeMillis / 1000) + 1)));
                this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
            } else {
                this.mUiHandler.sendEmptyMessage(0);
            }
            this.cgD.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cgF) {
            this.cgw.abD();
            acb();
        }
    }
}
