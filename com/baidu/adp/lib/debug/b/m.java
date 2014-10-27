package com.baidu.adp.lib.debug.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.adp.R;
import java.io.IOException;
/* loaded from: classes.dex */
public class m extends View {
    com.baidu.adp.lib.debug.a.b hA;
    com.baidu.adp.lib.debug.a.q hB;
    ImageButton hC;
    ImageButton hD;
    TextView hE;
    TextView hF;
    TextView hG;
    TextView hH;
    TextView hI;
    TextView hJ;
    TextView hK;
    TextView hL;
    TextView hM;
    boolean hN;
    View hw;
    View hx;
    TextView hy;
    com.baidu.adp.lib.debug.a.n hz;
    Context mContext;
    com.baidu.adp.lib.debug.a.e mFpsMonitor;
    com.baidu.adp.lib.debug.a.i mGCMonitor;
    com.baidu.adp.lib.debug.a.k mLogcatMonitor;
    com.baidu.adp.lib.debug.a.p mSRMonitor;

    public m(Context context) {
        super(context);
        this.mContext = null;
        this.hN = true;
        this.mContext = context;
        try {
            onCreate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onCreate() {
        this.mFpsMonitor = new com.baidu.adp.lib.debug.a.e(this.mContext);
        this.mSRMonitor = new com.baidu.adp.lib.debug.a.p(this.mContext);
        this.mGCMonitor = new com.baidu.adp.lib.debug.a.i();
        this.hz = new com.baidu.adp.lib.debug.a.n();
        this.mLogcatMonitor = new com.baidu.adp.lib.debug.a.k();
        this.hB = new com.baidu.adp.lib.debug.a.q(this.mContext);
        this.hA = new com.baidu.adp.lib.debug.a.b(this.mContext);
        this.hw = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, R.layout.adp_debug_monitor_view, null);
        this.hx = this.hw.findViewById(R.id.monitor_view);
        this.hy = (TextView) this.hw.findViewById(R.id.debug_text);
        this.hC = (ImageButton) this.hw.findViewById(R.id.debug_switch);
        this.hD = (ImageButton) this.hw.findViewById(R.id.debug_refresh);
        this.hE = (TextView) this.hw.findViewById(R.id.debug_fps);
        this.hF = (TextView) this.hw.findViewById(R.id.debug_mem);
        this.hG = (TextView) this.hw.findViewById(R.id.debug_cpu);
        this.hH = (TextView) this.hw.findViewById(R.id.debug_gc);
        this.hI = (TextView) this.hw.findViewById(R.id.debug_sm);
        this.hJ = (TextView) this.hw.findViewById(R.id.debug_bt);
        this.hK = (TextView) this.hw.findViewById(R.id.debug_snd);
        this.hL = (TextView) this.hw.findViewById(R.id.debug_rcv);
        this.hM = (TextView) this.hw.findViewById(R.id.debug_total);
        monitorOn();
        this.hD.setOnTouchListener(new n(this));
        this.hC.setOnTouchListener(new o(this));
        l.a(this.mContext, this.hw);
        this.hw.setOnTouchListener(new p(this));
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        this.hw.setVisibility(i);
    }

    public void onClick(View view) {
    }

    public void monitorOn() {
        if (!this.mSRMonitor.cJ()) {
            new Thread(this.mSRMonitor).start();
        }
        if (!this.mGCMonitor.cJ()) {
            this.mGCMonitor.start();
        }
        if (!this.hz.cJ()) {
            this.hz.start();
        }
        if (!this.hA.cJ()) {
            this.hA.start();
        }
        if (!this.mLogcatMonitor.cJ()) {
            new Thread(this.mLogcatMonitor).start();
        }
        if (!this.mFpsMonitor.cJ()) {
            this.mFpsMonitor.start();
        }
        if (!this.hB.cJ()) {
            new Thread(this.hB).start();
        }
        if (!this.hA.cJ()) {
            this.hA.start();
        }
        com.baidu.adp.lib.debug.d.mHandler = new q(this);
    }

    public void monitorOff() {
        if (this.mSRMonitor != null) {
            this.mSRMonitor.stop();
        }
        if (this.mLogcatMonitor != null) {
            this.mLogcatMonitor.stop();
        }
        if (this.mFpsMonitor != null) {
            this.mFpsMonitor.stop();
        }
        if (this.hB != null) {
            this.hB.stop();
        }
        if (this.hA != null) {
            this.hA.stop();
        }
    }
}
