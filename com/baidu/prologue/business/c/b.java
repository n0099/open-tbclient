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
import com.baidu.prologue.a.c.f;
import com.baidu.prologue.b;
import com.baidu.prologue.business.b.a;
import com.baidu.prologue.business.data.SplashStyleRecorder;
/* loaded from: classes6.dex */
public abstract class b<T extends com.baidu.prologue.business.b.a> implements View.OnClickListener, View.OnTouchListener, a {
    public static final boolean DEBUG = com.baidu.prologue.a.a.a.GLOBAL_DEBUG;
    private ImageView bAA;
    private ImageView bAB;
    private RelativeLayout bAC;
    private TextView bAD;
    private View bAE;
    private TextView bAF;
    private TextView bAG;
    private long bAH;
    private LinearLayout bAI;
    private long bAM;
    private String bAP;
    private Context mContext;
    private LayoutInflater mInflater;
    ViewGroup mRootView = null;
    private View bAr = null;
    private T bAz = null;
    private String labelName = "广告";
    private String bAJ = "";
    boolean bAt = false;
    private boolean bAK = true;
    private boolean bAL = true;
    private long bAN = 0;
    boolean bAO = false;
    protected Handler mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.prologue.business.c.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (b.DEBUG) {
                        f.bzz.d("SplashAbsBaseViewBuilder", "quit count");
                    }
                    b.this.bAz.pH();
                    b.this.Ow();
                    return;
                case 1:
                    b.this.Oz();
                    if (b.DEBUG) {
                        f.bzz.d("SplashAbsBaseViewBuilder", "update countdown");
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
        this.bAz = t;
        if (this.bAz != null) {
            this.bAz.a(this);
        }
        return this;
    }

    public b<T> cS(boolean z) {
        this.bAt = z;
        return this;
    }

    public b<T> gF(String str) {
        this.bAJ = str;
        return this;
    }

    public b<T> dS(int i) {
        this.bAM = i;
        return this;
    }

    public b<T> gG(String str) {
        this.labelName = str;
        return this;
    }

    public b<T> gH(String str) {
        this.bAP = str;
        return this;
    }

    public b<T> cT(boolean z) {
        this.bAO = z;
        return this;
    }

    public long Os() {
        return System.currentTimeMillis() - this.bAN;
    }

    public long Ot() {
        return this.bAH;
    }

    public T Ou() {
        return this.bAz;
    }

    @SuppressLint({"ResourceType"})
    public void build() {
        int NL;
        ViewGroup.LayoutParams layoutParams;
        this.mRootView = (ViewGroup) this.mInflater.inflate(getLayoutId(), (ViewGroup) null, false);
        Or();
        this.bAr = On();
        if (this.bAr != null) {
            this.bAr.setOnTouchListener(this);
        } else {
            f.bzz.e("SplashAbsBaseViewBuilder", "Splash Ad didn't set up clickable view!");
        }
        this.bAC = (RelativeLayout) this.mRootView.findViewById(b.C0249b.image_logo_view);
        this.bAB = (ImageView) this.mRootView.findViewById(b.C0249b.image_logo_img);
        if (this.bAt) {
            if (this.bAC != null && (layoutParams = this.bAC.getLayoutParams()) != null) {
                layoutParams.height = 0;
            }
            this.bAA = (ImageView) this.mRootView.findViewById(b.C0249b.image_small_logo_img);
            if (this.bAA != null && (TextUtils.equals(this.bAJ, "0") || TextUtils.equals(this.bAJ, "1"))) {
                this.bAA.setVisibility(0);
                ImageView imageView = this.bAA;
                if (TextUtils.equals(this.bAJ, "0")) {
                    NL = com.baidu.prologue.a.b.a.bzx.get().NM();
                } else {
                    NL = com.baidu.prologue.a.b.a.bzx.get().NL();
                }
                imageView.setImageResource(NL);
                e.a(this.bAA, SplashStyleRecorder.SplashElements.LOGO, this.bAt);
            }
        } else {
            this.bAB.setImageResource(com.baidu.prologue.a.b.a.bzx.get().NN());
        }
        Ov();
        onAdShow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int[] iArr = {0, 0};
            iArr[1] = (int) motionEvent.getRawY();
            iArr[0] = (int) motionEvent.getRawX();
            this.bAz.gD(com.baidu.prologue.business.b.NS().a(this.mRootView, iArr));
            Ow();
        }
        return true;
    }

    protected void Ov() {
        Oy();
        if (!TextUtils.isEmpty(this.labelName)) {
            this.bAD = (TextView) this.mRootView.findViewById(b.C0249b.splash_ad_label);
            e.a(this.bAD, SplashStyleRecorder.SplashElements.LABEL, this.bAt);
            this.bAD.setText(this.labelName);
            this.bAD.setVisibility(0);
        }
    }

    protected void onAdShow() {
        this.bAz.onAdShow();
    }

    public void Ow() {
        Ox();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ox() {
        if (this.mUiHandler != null) {
            this.mUiHandler.removeCallbacksAndMessages(null);
        }
    }

    protected void Oy() {
        this.bAF = (TextView) this.mRootView.findViewById(b.C0249b.splash_ad_btn_skip);
        this.bAG = (TextView) this.mRootView.findViewById(b.C0249b.splash_ad_countdown);
        this.bAI = (LinearLayout) this.mRootView.findViewById(b.C0249b.splash_countdown_skip);
        this.bAE = this.mRootView.findViewById(b.C0249b.splash_countdown_skip_click);
        e.a(this.bAE, SplashStyleRecorder.SplashElements.SKIP, this.bAt);
        if (this.bAM <= 0) {
            if ("splash_image".equals(this.bAP)) {
                this.bAM = 3L;
            } else {
                this.bAM = 5L;
            }
        }
        this.bAH = this.bAM * 1000;
        if (this.bAK) {
            this.bAI.setVisibility(0);
            this.bAG.setVisibility(0);
            this.bAI.setOnClickListener(this);
            this.bAN = System.currentTimeMillis();
            this.bAG.setText(String.format("%02d", Long.valueOf(this.bAH / 1000)));
            this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
        } else {
            this.mUiHandler.sendEmptyMessageDelayed(0, this.bAH);
        }
        if (this.bAL) {
            this.bAI.setVisibility(0);
            this.bAF.setVisibility(0);
            this.bAI.setOnClickListener(this);
        }
    }

    public View getRootView() {
        if (this.mRootView == null) {
            build();
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oz() {
        if (this.bAG != null) {
            long currentTimeMillis = this.bAH - (System.currentTimeMillis() - this.bAN);
            if (currentTimeMillis > 0) {
                this.bAG.setText(String.format("%02d", Long.valueOf((currentTimeMillis / 1000) + 1)));
                this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
            } else {
                this.mUiHandler.sendEmptyMessage(0);
            }
            this.bAG.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bAI) {
            this.bAz.NW();
            Ow();
        }
    }
}
