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
    private ImageView bTZ;
    private ImageView bUa;
    private RelativeLayout bUb;
    private TextView bUc;
    private View bUd;
    private TextView bUe;
    private TextView bUf;
    private long bUg;
    private LinearLayout bUh;
    private long bUl;
    private String bUo;
    private Context mContext;
    private LayoutInflater mInflater;
    ViewGroup mRootView = null;
    private View bTP = null;
    private T bTY = null;
    private String labelName = "广告";
    private String bUi = "";
    boolean bTR = false;
    private boolean bUj = true;
    private boolean bUk = true;
    private long bUm = 0;
    boolean bUn = false;
    protected Handler mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.prologue.business.c.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (b.DEBUG) {
                        g.bSX.d("SplashAbsBaseViewBuilder", "quit count");
                    }
                    b.this.bTY.rD();
                    b.this.Ys();
                    return;
                case 1:
                    b.this.Yv();
                    if (b.DEBUG) {
                        g.bSX.d("SplashAbsBaseViewBuilder", "update countdown");
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
        this.bTY = t;
        if (this.bTY != null) {
            this.bTY.a(this);
        }
        return this;
    }

    public b<T> dn(boolean z) {
        this.bTR = z;
        return this;
    }

    public b<T> jb(String str) {
        this.bUi = str;
        return this;
    }

    public b<T> gE(int i) {
        this.bUl = i;
        return this;
    }

    public b<T> jc(String str) {
        this.labelName = str;
        return this;
    }

    public b<T> jd(String str) {
        this.bUo = str;
        return this;
    }

    /* renamed from: do  reason: not valid java name */
    public b<T> m31do(boolean z) {
        this.bUn = z;
        return this;
    }

    public long Yo() {
        return System.currentTimeMillis() - this.bUm;
    }

    public long Yp() {
        return this.bUg;
    }

    public T Yq() {
        return this.bTY;
    }

    @SuppressLint({"ResourceType"})
    public void build() {
        int XI;
        ViewGroup.LayoutParams layoutParams;
        this.mRootView = (ViewGroup) this.mInflater.inflate(getLayoutId(), (ViewGroup) null, false);
        Yn();
        this.bTP = Yk();
        if (this.bTP != null) {
            this.bTP.setOnTouchListener(this);
        } else {
            g.bSX.e("SplashAbsBaseViewBuilder", "Splash Ad didn't set up clickable view!");
        }
        this.bUb = (RelativeLayout) this.mRootView.findViewById(b.C0292b.image_logo_view);
        this.bUa = (ImageView) this.mRootView.findViewById(b.C0292b.image_logo_img);
        if (this.bTR) {
            if (this.bUb != null && (layoutParams = this.bUb.getLayoutParams()) != null) {
                layoutParams.height = 0;
            }
            this.bTZ = (ImageView) this.mRootView.findViewById(b.C0292b.image_small_logo_img);
            if (this.bTZ != null && (TextUtils.equals(this.bUi, "0") || TextUtils.equals(this.bUi, "1"))) {
                this.bTZ.setVisibility(0);
                ImageView imageView = this.bTZ;
                if (TextUtils.equals(this.bUi, "0")) {
                    XI = com.baidu.prologue.a.b.a.bSV.get().XJ();
                } else {
                    XI = com.baidu.prologue.a.b.a.bSV.get().XI();
                }
                imageView.setImageResource(XI);
                e.a(this.bTZ, SplashStyleRecorder.SplashElements.LOGO, this.bTR);
            }
        } else {
            this.bUa.setImageResource(com.baidu.prologue.a.b.a.bSV.get().XK());
        }
        Yr();
        onAdShow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int[] iArr = {0, 0};
            iArr[1] = (int) motionEvent.getRawY();
            iArr[0] = (int) motionEvent.getRawX();
            this.bTY.iZ(com.baidu.prologue.business.b.XP().a(this.mRootView, iArr));
            Ys();
        }
        return true;
    }

    protected void Yr() {
        Yu();
        if (!TextUtils.isEmpty(this.labelName)) {
            this.bUc = (TextView) this.mRootView.findViewById(b.C0292b.splash_ad_label);
            e.a(this.bUc, SplashStyleRecorder.SplashElements.LABEL, this.bTR);
            this.bUc.setText(this.labelName);
            this.bUc.setVisibility(0);
        }
    }

    protected void onAdShow() {
        this.bTY.onAdShow();
    }

    public void Ys() {
        Yt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Yt() {
        if (this.mUiHandler != null) {
            this.mUiHandler.removeCallbacksAndMessages(null);
        }
    }

    protected void Yu() {
        this.bUe = (TextView) this.mRootView.findViewById(b.C0292b.splash_ad_btn_skip);
        this.bUf = (TextView) this.mRootView.findViewById(b.C0292b.splash_ad_countdown);
        this.bUh = (LinearLayout) this.mRootView.findViewById(b.C0292b.splash_countdown_skip);
        this.bUd = this.mRootView.findViewById(b.C0292b.splash_countdown_skip_click);
        e.a(this.bUd, SplashStyleRecorder.SplashElements.SKIP, this.bTR);
        if (this.bUl <= 0) {
            if ("splash_image".equals(this.bUo)) {
                this.bUl = 3L;
            } else {
                this.bUl = 5L;
            }
        }
        this.bUg = this.bUl * 1000;
        if (this.bUj) {
            this.bUh.setVisibility(0);
            this.bUf.setVisibility(0);
            this.bUh.setOnClickListener(this);
            this.bUm = System.currentTimeMillis();
            this.bUf.setText(String.format("%02d", Long.valueOf(this.bUg / 1000)));
            this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
        } else {
            this.mUiHandler.sendEmptyMessageDelayed(0, this.bUg);
        }
        if (this.bUk) {
            this.bUh.setVisibility(0);
            this.bUe.setVisibility(0);
            this.bUh.setOnClickListener(this);
        }
    }

    public View getRootView() {
        if (this.mRootView == null) {
            build();
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yv() {
        if (this.bUf != null) {
            long currentTimeMillis = this.bUg - (System.currentTimeMillis() - this.bUm);
            if (currentTimeMillis > 0) {
                this.bUf.setText(String.format("%02d", Long.valueOf((currentTimeMillis / 1000) + 1)));
                this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
            } else {
                this.mUiHandler.sendEmptyMessage(0);
            }
            this.bUf.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bUh) {
            this.bTY.XT();
            Ys();
        }
    }
}
