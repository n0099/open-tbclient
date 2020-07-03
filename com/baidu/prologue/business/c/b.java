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
    private long bFA;
    private String bFD;
    private ImageView bFo;
    private ImageView bFp;
    private RelativeLayout bFq;
    private TextView bFr;
    private View bFs;
    private TextView bFt;
    private TextView bFu;
    private long bFv;
    private LinearLayout bFw;
    private Context mContext;
    private LayoutInflater mInflater;
    ViewGroup mRootView = null;
    private View bFf = null;
    private T bFn = null;
    private String labelName = "广告";
    private String bFx = "";
    boolean bFh = false;
    private boolean bFy = true;
    private boolean bFz = true;
    private long bFB = 0;
    boolean bFC = false;
    protected Handler mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.prologue.business.c.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (b.DEBUG) {
                        f.bEn.d("SplashAbsBaseViewBuilder", "quit count");
                    }
                    b.this.bFn.pY();
                    b.this.PC();
                    return;
                case 1:
                    b.this.PF();
                    if (b.DEBUG) {
                        f.bEn.d("SplashAbsBaseViewBuilder", "update countdown");
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
        this.bFn = t;
        if (this.bFn != null) {
            this.bFn.a(this);
        }
        return this;
    }

    public b<T> cX(boolean z) {
        this.bFh = z;
        return this;
    }

    public b<T> gN(String str) {
        this.bFx = str;
        return this;
    }

    public b<T> ef(int i) {
        this.bFA = i;
        return this;
    }

    public b<T> gO(String str) {
        this.labelName = str;
        return this;
    }

    public b<T> gP(String str) {
        this.bFD = str;
        return this;
    }

    public b<T> cY(boolean z) {
        this.bFC = z;
        return this;
    }

    public long Py() {
        return System.currentTimeMillis() - this.bFB;
    }

    public long Pz() {
        return this.bFv;
    }

    public T PA() {
        return this.bFn;
    }

    @SuppressLint({"ResourceType"})
    public void build() {
        int OR;
        ViewGroup.LayoutParams layoutParams;
        this.mRootView = (ViewGroup) this.mInflater.inflate(getLayoutId(), (ViewGroup) null, false);
        Px();
        this.bFf = Pt();
        if (this.bFf != null) {
            this.bFf.setOnTouchListener(this);
        } else {
            f.bEn.e("SplashAbsBaseViewBuilder", "Splash Ad didn't set up clickable view!");
        }
        this.bFq = (RelativeLayout) this.mRootView.findViewById(b.C0255b.image_logo_view);
        this.bFp = (ImageView) this.mRootView.findViewById(b.C0255b.image_logo_img);
        if (this.bFh) {
            if (this.bFq != null && (layoutParams = this.bFq.getLayoutParams()) != null) {
                layoutParams.height = 0;
            }
            this.bFo = (ImageView) this.mRootView.findViewById(b.C0255b.image_small_logo_img);
            if (this.bFo != null && (TextUtils.equals(this.bFx, "0") || TextUtils.equals(this.bFx, "1"))) {
                this.bFo.setVisibility(0);
                ImageView imageView = this.bFo;
                if (TextUtils.equals(this.bFx, "0")) {
                    OR = com.baidu.prologue.a.b.a.bEl.get().OS();
                } else {
                    OR = com.baidu.prologue.a.b.a.bEl.get().OR();
                }
                imageView.setImageResource(OR);
                e.a(this.bFo, SplashStyleRecorder.SplashElements.LOGO, this.bFh);
            }
        } else {
            this.bFp.setImageResource(com.baidu.prologue.a.b.a.bEl.get().OT());
        }
        PB();
        onAdShow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int[] iArr = {0, 0};
            iArr[1] = (int) motionEvent.getRawY();
            iArr[0] = (int) motionEvent.getRawX();
            this.bFn.gL(com.baidu.prologue.business.b.OY().a(this.mRootView, iArr));
            PC();
        }
        return true;
    }

    protected void PB() {
        PE();
        if (!TextUtils.isEmpty(this.labelName)) {
            this.bFr = (TextView) this.mRootView.findViewById(b.C0255b.splash_ad_label);
            e.a(this.bFr, SplashStyleRecorder.SplashElements.LABEL, this.bFh);
            this.bFr.setText(this.labelName);
            this.bFr.setVisibility(0);
        }
    }

    protected void onAdShow() {
        this.bFn.onAdShow();
    }

    public void PC() {
        PD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void PD() {
        if (this.mUiHandler != null) {
            this.mUiHandler.removeCallbacksAndMessages(null);
        }
    }

    protected void PE() {
        this.bFt = (TextView) this.mRootView.findViewById(b.C0255b.splash_ad_btn_skip);
        this.bFu = (TextView) this.mRootView.findViewById(b.C0255b.splash_ad_countdown);
        this.bFw = (LinearLayout) this.mRootView.findViewById(b.C0255b.splash_countdown_skip);
        this.bFs = this.mRootView.findViewById(b.C0255b.splash_countdown_skip_click);
        e.a(this.bFs, SplashStyleRecorder.SplashElements.SKIP, this.bFh);
        if (this.bFA <= 0) {
            if ("splash_image".equals(this.bFD)) {
                this.bFA = 3L;
            } else {
                this.bFA = 5L;
            }
        }
        this.bFv = this.bFA * 1000;
        if (this.bFy) {
            this.bFw.setVisibility(0);
            this.bFu.setVisibility(0);
            this.bFw.setOnClickListener(this);
            this.bFB = System.currentTimeMillis();
            this.bFu.setText(String.format("%02d", Long.valueOf(this.bFv / 1000)));
            this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
        } else {
            this.mUiHandler.sendEmptyMessageDelayed(0, this.bFv);
        }
        if (this.bFz) {
            this.bFw.setVisibility(0);
            this.bFt.setVisibility(0);
            this.bFw.setOnClickListener(this);
        }
    }

    public View getRootView() {
        if (this.mRootView == null) {
            build();
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PF() {
        if (this.bFu != null) {
            long currentTimeMillis = this.bFv - (System.currentTimeMillis() - this.bFB);
            if (currentTimeMillis > 0) {
                this.bFu.setText(String.format("%02d", Long.valueOf((currentTimeMillis / 1000) + 1)));
                this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
            } else {
                this.mUiHandler.sendEmptyMessage(0);
            }
            this.bFu.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bFw) {
            this.bFn.Pc();
            PC();
        }
    }
}
