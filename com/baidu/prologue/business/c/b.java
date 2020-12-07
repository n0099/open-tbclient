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
    private ImageView cne;
    private ImageView cnf;
    private RelativeLayout cng;
    private TextView cnh;
    private View cni;
    private TextView cnj;
    private TextView cnk;
    private long cnl;
    private LinearLayout cnm;
    private long cnq;
    private String cnu;
    private Context mContext;
    private LayoutInflater mInflater;
    ViewGroup mRootView = null;
    private View cmU = null;
    private T cnd = null;
    private String labelName = "广告";
    private String cnn = "";
    boolean cmW = false;
    private boolean cno = true;
    private boolean cnp = true;
    private long cnr = 0;
    boolean cns = false;
    protected Handler mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.prologue.business.c.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (b.DEBUG) {
                        g.cmb.d("SplashAbsBaseViewBuilder", "quit count");
                    }
                    b.this.cnd.rF();
                    b.this.afj();
                    return;
                case 1:
                    b.this.afm();
                    if (b.DEBUG) {
                        g.cmb.d("SplashAbsBaseViewBuilder", "update countdown");
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
        this.cnd = t;
        if (this.cnd != null) {
            this.cnd.a(this);
        }
        return this;
    }

    public b<T> ea(boolean z) {
        this.cmW = z;
        return this;
    }

    public b<T> ki(String str) {
        this.cnn = str;
        return this;
    }

    public b<T> ht(int i) {
        this.cnq = i;
        return this;
    }

    public b<T> kj(String str) {
        this.labelName = str;
        return this;
    }

    public b<T> kk(String str) {
        this.cnu = str;
        return this;
    }

    public b<T> eb(boolean z) {
        this.cns = z;
        return this;
    }

    public long aff() {
        return System.currentTimeMillis() - this.cnr;
    }

    public long afg() {
        return this.cnl;
    }

    public T afh() {
        return this.cnd;
    }

    @SuppressLint({"ResourceType"})
    public void build() {
        int aeA;
        ViewGroup.LayoutParams layoutParams;
        this.mRootView = (ViewGroup) this.mInflater.inflate(getLayoutId(), (ViewGroup) null, false);
        ZG();
        this.cmU = afc();
        if (this.cmU != null) {
            this.cmU.setOnTouchListener(this);
        } else {
            g.cmb.e("SplashAbsBaseViewBuilder", "Splash Ad didn't set up clickable view!");
        }
        this.cng = (RelativeLayout) this.mRootView.findViewById(b.C0327b.image_logo_view);
        this.cnf = (ImageView) this.mRootView.findViewById(b.C0327b.image_logo_img);
        if (this.cmW) {
            if (this.cng != null && (layoutParams = this.cng.getLayoutParams()) != null) {
                layoutParams.height = 0;
            }
            this.cne = (ImageView) this.mRootView.findViewById(b.C0327b.image_small_logo_img);
            if (this.cne != null && (TextUtils.equals(this.cnn, "0") || TextUtils.equals(this.cnn, "1"))) {
                this.cne.setVisibility(0);
                ImageView imageView = this.cne;
                if (TextUtils.equals(this.cnn, "0")) {
                    aeA = com.baidu.prologue.a.b.a.clZ.get().aeB();
                } else {
                    aeA = com.baidu.prologue.a.b.a.clZ.get().aeA();
                }
                imageView.setImageResource(aeA);
                e.a(this.cne, SplashStyleRecorder.SplashElements.LOGO, this.cmW);
            }
        } else {
            this.cnf.setImageResource(com.baidu.prologue.a.b.a.clZ.get().aeC());
        }
        afi();
        onAdShow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int[] iArr = {0, 0};
            iArr[1] = (int) motionEvent.getRawY();
            iArr[0] = (int) motionEvent.getRawX();
            this.cnd.kg(com.baidu.prologue.business.b.aeH().a(this.mRootView, iArr));
            afj();
        }
        return true;
    }

    protected void afi() {
        afl();
        if (!TextUtils.isEmpty(this.labelName)) {
            this.cnh = (TextView) this.mRootView.findViewById(b.C0327b.splash_ad_label);
            e.a(this.cnh, SplashStyleRecorder.SplashElements.LABEL, this.cmW);
            this.cnh.setText(this.labelName);
            this.cnh.setVisibility(0);
        }
    }

    protected void onAdShow() {
        this.cnd.onAdShow();
    }

    public void afj() {
        afk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afk() {
        if (this.mUiHandler != null) {
            this.mUiHandler.removeCallbacksAndMessages(null);
        }
    }

    protected void afl() {
        this.cnj = (TextView) this.mRootView.findViewById(b.C0327b.splash_ad_btn_skip);
        this.cnk = (TextView) this.mRootView.findViewById(b.C0327b.splash_ad_countdown);
        this.cnm = (LinearLayout) this.mRootView.findViewById(b.C0327b.splash_countdown_skip);
        this.cni = this.mRootView.findViewById(b.C0327b.splash_countdown_skip_click);
        e.a(this.cni, SplashStyleRecorder.SplashElements.SKIP, this.cmW);
        if (this.cnq <= 0) {
            if ("splash_image".equals(this.cnu)) {
                this.cnq = 3L;
            } else {
                this.cnq = 5L;
            }
        }
        this.cnl = this.cnq * 1000;
        if (this.cno) {
            this.cnm.setVisibility(0);
            this.cnk.setVisibility(0);
            this.cnm.setOnClickListener(this);
            this.cnr = System.currentTimeMillis();
            this.cnk.setText(String.format("%02d", Long.valueOf(this.cnl / 1000)));
            this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
        } else {
            this.mUiHandler.sendEmptyMessageDelayed(0, this.cnl);
        }
        if (this.cnp) {
            this.cnm.setVisibility(0);
            this.cnj.setVisibility(0);
            this.cnm.setOnClickListener(this);
        }
    }

    public View getRootView() {
        if (this.mRootView == null) {
            build();
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afm() {
        if (this.cnk != null) {
            long currentTimeMillis = this.cnl - (System.currentTimeMillis() - this.cnr);
            if (currentTimeMillis > 0) {
                this.cnk.setText(String.format("%02d", Long.valueOf((currentTimeMillis / 1000) + 1)));
                this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
            } else {
                this.mUiHandler.sendEmptyMessage(0);
            }
            this.cnk.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cnm) {
            this.cnd.aeL();
            afj();
        }
    }
}
