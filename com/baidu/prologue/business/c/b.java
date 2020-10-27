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
    private TextView ccA;
    private View ccB;
    private TextView ccC;
    private TextView ccD;
    private long ccE;
    private LinearLayout ccF;
    private long ccJ;
    private String ccM;
    private ImageView ccx;
    private ImageView ccy;
    private RelativeLayout ccz;
    private Context mContext;
    private LayoutInflater mInflater;
    ViewGroup mRootView = null;
    private View ccm = null;
    private T ccw = null;
    private String labelName = "广告";
    private String ccG = "";
    boolean cco = false;
    private boolean ccH = true;
    private boolean ccI = true;
    private long ccK = 0;
    boolean ccL = false;
    protected Handler mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.prologue.business.c.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (b.DEBUG) {
                        g.cbu.d("SplashAbsBaseViewBuilder", "quit count");
                    }
                    b.this.ccw.rD();
                    b.this.aal();
                    return;
                case 1:
                    b.this.aao();
                    if (b.DEBUG) {
                        g.cbu.d("SplashAbsBaseViewBuilder", "update countdown");
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
        this.ccw = t;
        if (this.ccw != null) {
            this.ccw.a(this);
        }
        return this;
    }

    public b<T> dB(boolean z) {
        this.cco = z;
        return this;
    }

    public b<T> ju(String str) {
        this.ccG = str;
        return this;
    }

    public b<T> gP(int i) {
        this.ccJ = i;
        return this;
    }

    public b<T> jv(String str) {
        this.labelName = str;
        return this;
    }

    public b<T> jw(String str) {
        this.ccM = str;
        return this;
    }

    public b<T> dC(boolean z) {
        this.ccL = z;
        return this;
    }

    public long aah() {
        return System.currentTimeMillis() - this.ccK;
    }

    public long aai() {
        return this.ccE;
    }

    public T aaj() {
        return this.ccw;
    }

    @SuppressLint({"ResourceType"})
    public void build() {
        int ZC;
        ViewGroup.LayoutParams layoutParams;
        this.mRootView = (ViewGroup) this.mInflater.inflate(getLayoutId(), (ViewGroup) null, false);
        Vr();
        this.ccm = aae();
        if (this.ccm != null) {
            this.ccm.setOnTouchListener(this);
        } else {
            g.cbu.e("SplashAbsBaseViewBuilder", "Splash Ad didn't set up clickable view!");
        }
        this.ccz = (RelativeLayout) this.mRootView.findViewById(b.C0306b.image_logo_view);
        this.ccy = (ImageView) this.mRootView.findViewById(b.C0306b.image_logo_img);
        if (this.cco) {
            if (this.ccz != null && (layoutParams = this.ccz.getLayoutParams()) != null) {
                layoutParams.height = 0;
            }
            this.ccx = (ImageView) this.mRootView.findViewById(b.C0306b.image_small_logo_img);
            if (this.ccx != null && (TextUtils.equals(this.ccG, "0") || TextUtils.equals(this.ccG, "1"))) {
                this.ccx.setVisibility(0);
                ImageView imageView = this.ccx;
                if (TextUtils.equals(this.ccG, "0")) {
                    ZC = com.baidu.prologue.a.b.a.cbs.get().ZD();
                } else {
                    ZC = com.baidu.prologue.a.b.a.cbs.get().ZC();
                }
                imageView.setImageResource(ZC);
                e.a(this.ccx, SplashStyleRecorder.SplashElements.LOGO, this.cco);
            }
        } else {
            this.ccy.setImageResource(com.baidu.prologue.a.b.a.cbs.get().ZE());
        }
        aak();
        onAdShow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int[] iArr = {0, 0};
            iArr[1] = (int) motionEvent.getRawY();
            iArr[0] = (int) motionEvent.getRawX();
            this.ccw.js(com.baidu.prologue.business.b.ZJ().a(this.mRootView, iArr));
            aal();
        }
        return true;
    }

    protected void aak() {
        aan();
        if (!TextUtils.isEmpty(this.labelName)) {
            this.ccA = (TextView) this.mRootView.findViewById(b.C0306b.splash_ad_label);
            e.a(this.ccA, SplashStyleRecorder.SplashElements.LABEL, this.cco);
            this.ccA.setText(this.labelName);
            this.ccA.setVisibility(0);
        }
    }

    protected void onAdShow() {
        this.ccw.onAdShow();
    }

    public void aal() {
        aam();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aam() {
        if (this.mUiHandler != null) {
            this.mUiHandler.removeCallbacksAndMessages(null);
        }
    }

    protected void aan() {
        this.ccC = (TextView) this.mRootView.findViewById(b.C0306b.splash_ad_btn_skip);
        this.ccD = (TextView) this.mRootView.findViewById(b.C0306b.splash_ad_countdown);
        this.ccF = (LinearLayout) this.mRootView.findViewById(b.C0306b.splash_countdown_skip);
        this.ccB = this.mRootView.findViewById(b.C0306b.splash_countdown_skip_click);
        e.a(this.ccB, SplashStyleRecorder.SplashElements.SKIP, this.cco);
        if (this.ccJ <= 0) {
            if ("splash_image".equals(this.ccM)) {
                this.ccJ = 3L;
            } else {
                this.ccJ = 5L;
            }
        }
        this.ccE = this.ccJ * 1000;
        if (this.ccH) {
            this.ccF.setVisibility(0);
            this.ccD.setVisibility(0);
            this.ccF.setOnClickListener(this);
            this.ccK = System.currentTimeMillis();
            this.ccD.setText(String.format("%02d", Long.valueOf(this.ccE / 1000)));
            this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
        } else {
            this.mUiHandler.sendEmptyMessageDelayed(0, this.ccE);
        }
        if (this.ccI) {
            this.ccF.setVisibility(0);
            this.ccC.setVisibility(0);
            this.ccF.setOnClickListener(this);
        }
    }

    public View getRootView() {
        if (this.mRootView == null) {
            build();
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aao() {
        if (this.ccD != null) {
            long currentTimeMillis = this.ccE - (System.currentTimeMillis() - this.ccK);
            if (currentTimeMillis > 0) {
                this.ccD.setText(String.format("%02d", Long.valueOf((currentTimeMillis / 1000) + 1)));
                this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
            } else {
                this.mUiHandler.sendEmptyMessage(0);
            }
            this.ccD.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ccF) {
            this.ccw.ZN();
            aal();
        }
    }
}
