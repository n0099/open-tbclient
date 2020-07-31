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
/* loaded from: classes8.dex */
public abstract class b<T extends com.baidu.prologue.business.b.a> implements View.OnClickListener, View.OnTouchListener, a {
    public static final boolean DEBUG = com.baidu.prologue.a.a.a.GLOBAL_DEBUG;
    private ImageView bFM;
    private ImageView bFN;
    private RelativeLayout bFO;
    private TextView bFP;
    private View bFQ;
    private TextView bFR;
    private TextView bFS;
    private long bFT;
    private LinearLayout bFU;
    private long bFY;
    private String bGb;
    private Context mContext;
    private LayoutInflater mInflater;
    ViewGroup mRootView = null;
    private View bFC = null;
    private T bFL = null;
    private String labelName = "广告";
    private String bFV = "";
    boolean bFE = false;
    private boolean bFW = true;
    private boolean bFX = true;
    private long bFZ = 0;
    boolean bGa = false;
    protected Handler mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.prologue.business.c.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (b.DEBUG) {
                        g.bEK.d("SplashAbsBaseViewBuilder", "quit count");
                    }
                    b.this.bFL.pZ();
                    b.this.PR();
                    return;
                case 1:
                    b.this.PU();
                    if (b.DEBUG) {
                        g.bEK.d("SplashAbsBaseViewBuilder", "update countdown");
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
        this.bFL = t;
        if (this.bFL != null) {
            this.bFL.a(this);
        }
        return this;
    }

    public b<T> cZ(boolean z) {
        this.bFE = z;
        return this;
    }

    public b<T> gL(String str) {
        this.bFV = str;
        return this;
    }

    public b<T> ef(int i) {
        this.bFY = i;
        return this;
    }

    public b<T> gM(String str) {
        this.labelName = str;
        return this;
    }

    public b<T> gN(String str) {
        this.bGb = str;
        return this;
    }

    public b<T> da(boolean z) {
        this.bGa = z;
        return this;
    }

    public long PN() {
        return System.currentTimeMillis() - this.bFZ;
    }

    public long PO() {
        return this.bFT;
    }

    public T PP() {
        return this.bFL;
    }

    @SuppressLint({"ResourceType"})
    public void build() {
        int Pg;
        ViewGroup.LayoutParams layoutParams;
        this.mRootView = (ViewGroup) this.mInflater.inflate(getLayoutId(), (ViewGroup) null, false);
        PM();
        this.bFC = PI();
        if (this.bFC != null) {
            this.bFC.setOnTouchListener(this);
        } else {
            g.bEK.e("SplashAbsBaseViewBuilder", "Splash Ad didn't set up clickable view!");
        }
        this.bFO = (RelativeLayout) this.mRootView.findViewById(b.C0258b.image_logo_view);
        this.bFN = (ImageView) this.mRootView.findViewById(b.C0258b.image_logo_img);
        if (this.bFE) {
            if (this.bFO != null && (layoutParams = this.bFO.getLayoutParams()) != null) {
                layoutParams.height = 0;
            }
            this.bFM = (ImageView) this.mRootView.findViewById(b.C0258b.image_small_logo_img);
            if (this.bFM != null && (TextUtils.equals(this.bFV, "0") || TextUtils.equals(this.bFV, "1"))) {
                this.bFM.setVisibility(0);
                ImageView imageView = this.bFM;
                if (TextUtils.equals(this.bFV, "0")) {
                    Pg = com.baidu.prologue.a.b.a.bEI.get().Ph();
                } else {
                    Pg = com.baidu.prologue.a.b.a.bEI.get().Pg();
                }
                imageView.setImageResource(Pg);
                e.a(this.bFM, SplashStyleRecorder.SplashElements.LOGO, this.bFE);
            }
        } else {
            this.bFN.setImageResource(com.baidu.prologue.a.b.a.bEI.get().Pi());
        }
        PQ();
        onAdShow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int[] iArr = {0, 0};
            iArr[1] = (int) motionEvent.getRawY();
            iArr[0] = (int) motionEvent.getRawX();
            this.bFL.gJ(com.baidu.prologue.business.b.Pn().a(this.mRootView, iArr));
            PR();
        }
        return true;
    }

    protected void PQ() {
        PT();
        if (!TextUtils.isEmpty(this.labelName)) {
            this.bFP = (TextView) this.mRootView.findViewById(b.C0258b.splash_ad_label);
            e.a(this.bFP, SplashStyleRecorder.SplashElements.LABEL, this.bFE);
            this.bFP.setText(this.labelName);
            this.bFP.setVisibility(0);
        }
    }

    protected void onAdShow() {
        this.bFL.onAdShow();
    }

    public void PR() {
        PS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void PS() {
        if (this.mUiHandler != null) {
            this.mUiHandler.removeCallbacksAndMessages(null);
        }
    }

    protected void PT() {
        this.bFR = (TextView) this.mRootView.findViewById(b.C0258b.splash_ad_btn_skip);
        this.bFS = (TextView) this.mRootView.findViewById(b.C0258b.splash_ad_countdown);
        this.bFU = (LinearLayout) this.mRootView.findViewById(b.C0258b.splash_countdown_skip);
        this.bFQ = this.mRootView.findViewById(b.C0258b.splash_countdown_skip_click);
        e.a(this.bFQ, SplashStyleRecorder.SplashElements.SKIP, this.bFE);
        if (this.bFY <= 0) {
            if ("splash_image".equals(this.bGb)) {
                this.bFY = 3L;
            } else {
                this.bFY = 5L;
            }
        }
        this.bFT = this.bFY * 1000;
        if (this.bFW) {
            this.bFU.setVisibility(0);
            this.bFS.setVisibility(0);
            this.bFU.setOnClickListener(this);
            this.bFZ = System.currentTimeMillis();
            this.bFS.setText(String.format("%02d", Long.valueOf(this.bFT / 1000)));
            this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
        } else {
            this.mUiHandler.sendEmptyMessageDelayed(0, this.bFT);
        }
        if (this.bFX) {
            this.bFU.setVisibility(0);
            this.bFR.setVisibility(0);
            this.bFU.setOnClickListener(this);
        }
    }

    public View getRootView() {
        if (this.mRootView == null) {
            build();
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PU() {
        if (this.bFS != null) {
            long currentTimeMillis = this.bFT - (System.currentTimeMillis() - this.bFZ);
            if (currentTimeMillis > 0) {
                this.bFS.setText(String.format("%02d", Long.valueOf((currentTimeMillis / 1000) + 1)));
                this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
            } else {
                this.mUiHandler.sendEmptyMessage(0);
            }
            this.bFS.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bFU) {
            this.bFL.Pr();
            PR();
        }
    }
}
