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
/* loaded from: classes19.dex */
public abstract class b<T extends com.baidu.prologue.business.b.a> implements View.OnClickListener, View.OnTouchListener, a {
    public static final boolean DEBUG = com.baidu.prologue.a.a.a.GLOBAL_DEBUG;
    private ImageView cij;
    private ImageView cik;
    private RelativeLayout cil;
    private TextView cim;
    private View cin;
    private TextView cio;
    private TextView cip;
    private long ciq;
    private LinearLayout cir;
    private long civ;
    private String ciy;
    private Context mContext;
    private LayoutInflater mInflater;
    ViewGroup mRootView = null;
    private View chY = null;
    private T cii = null;
    private String labelName = "广告";
    private String cis = "";
    boolean cia = false;
    private boolean cit = true;
    private boolean ciu = true;
    private long ciw = 0;
    boolean cix = false;
    protected Handler mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.prologue.business.c.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (b.DEBUG) {
                        g.chg.d("SplashAbsBaseViewBuilder", "quit count");
                    }
                    b.this.cii.rD();
                    b.this.acK();
                    return;
                case 1:
                    b.this.acN();
                    if (b.DEBUG) {
                        g.chg.d("SplashAbsBaseViewBuilder", "update countdown");
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
        this.cii = t;
        if (this.cii != null) {
            this.cii.a(this);
        }
        return this;
    }

    public b<T> dI(boolean z) {
        this.cia = z;
        return this;
    }

    public b<T> jH(String str) {
        this.cis = str;
        return this;
    }

    public b<T> gZ(int i) {
        this.civ = i;
        return this;
    }

    public b<T> jI(String str) {
        this.labelName = str;
        return this;
    }

    public b<T> jJ(String str) {
        this.ciy = str;
        return this;
    }

    public b<T> dJ(boolean z) {
        this.cix = z;
        return this;
    }

    public long acG() {
        return System.currentTimeMillis() - this.ciw;
    }

    public long acH() {
        return this.ciq;
    }

    public T acI() {
        return this.cii;
    }

    @SuppressLint({"ResourceType"})
    public void build() {
        int acb;
        ViewGroup.LayoutParams layoutParams;
        this.mRootView = (ViewGroup) this.mInflater.inflate(getLayoutId(), (ViewGroup) null, false);
        XQ();
        this.chY = acD();
        if (this.chY != null) {
            this.chY.setOnTouchListener(this);
        } else {
            g.chg.e("SplashAbsBaseViewBuilder", "Splash Ad didn't set up clickable view!");
        }
        this.cil = (RelativeLayout) this.mRootView.findViewById(b.C0318b.image_logo_view);
        this.cik = (ImageView) this.mRootView.findViewById(b.C0318b.image_logo_img);
        if (this.cia) {
            if (this.cil != null && (layoutParams = this.cil.getLayoutParams()) != null) {
                layoutParams.height = 0;
            }
            this.cij = (ImageView) this.mRootView.findViewById(b.C0318b.image_small_logo_img);
            if (this.cij != null && (TextUtils.equals(this.cis, "0") || TextUtils.equals(this.cis, "1"))) {
                this.cij.setVisibility(0);
                ImageView imageView = this.cij;
                if (TextUtils.equals(this.cis, "0")) {
                    acb = com.baidu.prologue.a.b.a.che.get().acc();
                } else {
                    acb = com.baidu.prologue.a.b.a.che.get().acb();
                }
                imageView.setImageResource(acb);
                e.a(this.cij, SplashStyleRecorder.SplashElements.LOGO, this.cia);
            }
        } else {
            this.cik.setImageResource(com.baidu.prologue.a.b.a.che.get().acd());
        }
        acJ();
        onAdShow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int[] iArr = {0, 0};
            iArr[1] = (int) motionEvent.getRawY();
            iArr[0] = (int) motionEvent.getRawX();
            this.cii.jF(com.baidu.prologue.business.b.aci().a(this.mRootView, iArr));
            acK();
        }
        return true;
    }

    protected void acJ() {
        acM();
        if (!TextUtils.isEmpty(this.labelName)) {
            this.cim = (TextView) this.mRootView.findViewById(b.C0318b.splash_ad_label);
            e.a(this.cim, SplashStyleRecorder.SplashElements.LABEL, this.cia);
            this.cim.setText(this.labelName);
            this.cim.setVisibility(0);
        }
    }

    protected void onAdShow() {
        this.cii.onAdShow();
    }

    public void acK() {
        acL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acL() {
        if (this.mUiHandler != null) {
            this.mUiHandler.removeCallbacksAndMessages(null);
        }
    }

    protected void acM() {
        this.cio = (TextView) this.mRootView.findViewById(b.C0318b.splash_ad_btn_skip);
        this.cip = (TextView) this.mRootView.findViewById(b.C0318b.splash_ad_countdown);
        this.cir = (LinearLayout) this.mRootView.findViewById(b.C0318b.splash_countdown_skip);
        this.cin = this.mRootView.findViewById(b.C0318b.splash_countdown_skip_click);
        e.a(this.cin, SplashStyleRecorder.SplashElements.SKIP, this.cia);
        if (this.civ <= 0) {
            if ("splash_image".equals(this.ciy)) {
                this.civ = 3L;
            } else {
                this.civ = 5L;
            }
        }
        this.ciq = this.civ * 1000;
        if (this.cit) {
            this.cir.setVisibility(0);
            this.cip.setVisibility(0);
            this.cir.setOnClickListener(this);
            this.ciw = System.currentTimeMillis();
            this.cip.setText(String.format("%02d", Long.valueOf(this.ciq / 1000)));
            this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
        } else {
            this.mUiHandler.sendEmptyMessageDelayed(0, this.ciq);
        }
        if (this.ciu) {
            this.cir.setVisibility(0);
            this.cio.setVisibility(0);
            this.cir.setOnClickListener(this);
        }
    }

    public View getRootView() {
        if (this.mRootView == null) {
            build();
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acN() {
        if (this.cip != null) {
            long currentTimeMillis = this.ciq - (System.currentTimeMillis() - this.ciw);
            if (currentTimeMillis > 0) {
                this.cip.setText(String.format("%02d", Long.valueOf((currentTimeMillis / 1000) + 1)));
                this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
            } else {
                this.mUiHandler.sendEmptyMessage(0);
            }
            this.cip.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cir) {
            this.cii.acm();
            acK();
        }
    }
}
