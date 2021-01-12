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
/* loaded from: classes5.dex */
public abstract class b<T extends com.baidu.prologue.business.b.a> implements View.OnClickListener, View.OnTouchListener, a {
    public static final boolean DEBUG = com.baidu.prologue.a.a.a.coo;
    private TextView cpA;
    private long cpB;
    private LinearLayout cpC;
    private long cpG;
    private String cpJ;
    private ImageView cpt;
    private ImageView cpv;
    private RelativeLayout cpw;
    private TextView cpx;
    private View cpy;
    private TextView cpz;
    private Context mContext;
    private LayoutInflater mInflater;
    ViewGroup mRootView = null;
    private View cpj = null;
    private T cps = null;
    private String labelName = "广告";
    private String cpD = "";
    boolean cpl = false;
    private boolean cpE = true;
    private boolean cpF = true;
    private long cpH = 0;
    boolean cpI = false;
    protected Handler mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.prologue.business.c.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (b.DEBUG) {
                        g.cor.d("SplashAbsBaseViewBuilder", "quit count");
                    }
                    b.this.cps.rg();
                    b.this.adm();
                    return;
                case 1:
                    b.this.adp();
                    if (b.DEBUG) {
                        g.cor.d("SplashAbsBaseViewBuilder", "update countdown");
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
        this.cps = t;
        if (this.cps != null) {
            this.cps.a(this);
        }
        return this;
    }

    public b<T> ef(boolean z) {
        this.cpl = z;
        return this;
    }

    public b<T> iR(String str) {
        this.cpD = str;
        return this;
    }

    public b<T> fL(int i) {
        this.cpG = i;
        return this;
    }

    public b<T> iS(String str) {
        this.labelName = str;
        return this;
    }

    public b<T> iT(String str) {
        this.cpJ = str;
        return this;
    }

    public b<T> eg(boolean z) {
        this.cpI = z;
        return this;
    }

    public long adi() {
        return System.currentTimeMillis() - this.cpH;
    }

    public long adj() {
        return this.cpB;
    }

    public T adk() {
        return this.cps;
    }

    @SuppressLint({"ResourceType"})
    public void build() {
        int acD;
        ViewGroup.LayoutParams layoutParams;
        this.mRootView = (ViewGroup) this.mInflater.inflate(getLayoutId(), (ViewGroup) null, false);
        Xv();
        this.cpj = adf();
        if (this.cpj != null) {
            this.cpj.setOnTouchListener(this);
        } else {
            g.cor.e("SplashAbsBaseViewBuilder", "Splash Ad didn't set up clickable view!");
        }
        this.cpw = (RelativeLayout) this.mRootView.findViewById(b.C0310b.image_logo_view);
        this.cpv = (ImageView) this.mRootView.findViewById(b.C0310b.image_logo_img);
        if (this.cpl) {
            if (this.cpw != null && (layoutParams = this.cpw.getLayoutParams()) != null) {
                layoutParams.height = 0;
            }
            this.cpt = (ImageView) this.mRootView.findViewById(b.C0310b.image_small_logo_img);
            if (this.cpt != null && (TextUtils.equals(this.cpD, "0") || TextUtils.equals(this.cpD, "1"))) {
                this.cpt.setVisibility(0);
                ImageView imageView = this.cpt;
                if (TextUtils.equals(this.cpD, "0")) {
                    acD = com.baidu.prologue.a.b.a.cop.get().acE();
                } else {
                    acD = com.baidu.prologue.a.b.a.cop.get().acD();
                }
                imageView.setImageResource(acD);
                e.a(this.cpt, SplashStyleRecorder.SplashElements.LOGO, this.cpl);
            }
        } else {
            this.cpv.setImageResource(com.baidu.prologue.a.b.a.cop.get().acF());
        }
        adl();
        onAdShow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int[] iArr = {0, 0};
            iArr[1] = (int) motionEvent.getRawY();
            iArr[0] = (int) motionEvent.getRawX();
            this.cps.onAdClick(com.baidu.prologue.business.b.acK().a(this.mRootView, iArr));
            adm();
        }
        return true;
    }

    protected void adl() {
        ado();
        if (!TextUtils.isEmpty(this.labelName)) {
            this.cpx = (TextView) this.mRootView.findViewById(b.C0310b.splash_ad_label);
            e.a(this.cpx, SplashStyleRecorder.SplashElements.LABEL, this.cpl);
            this.cpx.setText(this.labelName);
            this.cpx.setVisibility(0);
        }
    }

    protected void onAdShow() {
        this.cps.onAdShow();
    }

    public void adm() {
        adn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adn() {
        if (this.mUiHandler != null) {
            this.mUiHandler.removeCallbacksAndMessages(null);
        }
    }

    protected void ado() {
        this.cpz = (TextView) this.mRootView.findViewById(b.C0310b.splash_ad_btn_skip);
        this.cpA = (TextView) this.mRootView.findViewById(b.C0310b.splash_ad_countdown);
        this.cpC = (LinearLayout) this.mRootView.findViewById(b.C0310b.splash_countdown_skip);
        this.cpy = this.mRootView.findViewById(b.C0310b.splash_countdown_skip_click);
        e.a(this.cpy, SplashStyleRecorder.SplashElements.SKIP, this.cpl);
        if (this.cpG <= 0) {
            if ("splash_image".equals(this.cpJ)) {
                this.cpG = 3L;
            } else {
                this.cpG = 5L;
            }
        }
        this.cpB = this.cpG * 1000;
        if (this.cpE) {
            this.cpC.setVisibility(0);
            this.cpA.setVisibility(0);
            this.cpC.setOnClickListener(this);
            this.cpH = System.currentTimeMillis();
            this.cpA.setText(String.format("%02d", Long.valueOf(this.cpB / 1000)));
            this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
        } else {
            this.mUiHandler.sendEmptyMessageDelayed(0, this.cpB);
        }
        if (this.cpF) {
            this.cpC.setVisibility(0);
            this.cpz.setVisibility(0);
            this.cpC.setOnClickListener(this);
        }
    }

    public View getRootView() {
        if (this.mRootView == null) {
            build();
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adp() {
        if (this.cpA != null) {
            long currentTimeMillis = this.cpB - (System.currentTimeMillis() - this.cpH);
            if (currentTimeMillis > 0) {
                this.cpA.setText(String.format("%02d", Long.valueOf((currentTimeMillis / 1000) + 1)));
                this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
            } else {
                this.mUiHandler.sendEmptyMessage(0);
            }
            this.cpA.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cpC) {
            this.cps.acO();
            adm();
        }
    }
}
