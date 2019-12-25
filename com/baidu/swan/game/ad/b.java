package com.baidu.swan.game.ad;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.component.RewardVideoView;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes9.dex */
public abstract class b implements com.baidu.swan.game.ad.b.d {
    private com.baidu.swan.apps.media.c.a aWC;
    private AdElementInfo cbX;
    private RewardLoadWebView ccA;
    private RewardLoadWebView ccB;
    private a.c ccj;
    private RelativeLayout ccn;
    private RewardVideoView cco;
    private LinearLayout ccp;
    private ImageView ccq;
    private TextView ccr;
    private TextView cct;
    private View ccu;
    private RelativeLayout ccv;
    private a.b ccz;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    private Resources mResources;
    private final Handler ccy = new Handler();
    private Runnable ccC = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.aWC != null) {
                int currentPosition = b.this.aWC.getCurrentPosition();
                b.this.mDuration = b.this.aWC.getDuration();
                if (b.this.mDuration <= 15000 || currentPosition > 15000) {
                    b.this.ccu.setVisibility(8);
                    b.this.cct.setVisibility(8);
                } else {
                    b.this.cct.setText(String.format(b.this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(15 - (currentPosition / 1000))));
                }
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.ccy.postDelayed(b.this.ccC, 100L);
                }
            }
        }
    };
    private View.OnClickListener ccD = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cco != null) {
                if (b.this.cco.isMute()) {
                    b.this.ccq.setImageResource(c.d.ng_game_vol_open);
                    b.this.cco.cx(false);
                    return;
                }
                b.this.ccq.setImageResource(c.d.ng_game_vol_close);
                b.this.cco.cx(true);
            }
        }
    };
    private View.OnClickListener ccE = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.e.close_ad != view.getId() || b.this.aWC == null || b.this.mDuration <= 15000 || b.this.aWC.getCurrentPosition() <= 15000) {
                if (b.this.ccz != null) {
                    b.this.ccz.ahI();
                    return;
                }
                return;
            }
            b.this.aWC.seekTo(b.this.mDuration);
        }
    };
    public int ccw = com.baidu.swan.games.view.a.c.anQ();
    public int ccx = com.baidu.swan.games.view.a.c.anR();

    public abstract View ahu();

    public b(Context context, AdElementInfo adElementInfo) {
        this.mContext = context;
        this.cbX = adElementInfo;
        this.mResources = this.mContext.getResources();
        initView();
    }

    private void initView() {
        this.mConvertView = ahu();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ccw, this.ccx);
        this.mConvertView.setLayoutParams(layoutParams);
        this.ccn = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.cco = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.cco.setLayoutParams(layoutParams);
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.ccp = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.ccq = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.ccr = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.cct = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.ccu = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.ccv = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.cbX.ahE())) {
            this.ccA = new RewardLoadWebView(this.mContext);
            this.ccv.addView(this.ccA, new RelativeLayout.LayoutParams(-1, -1));
            this.ccA.a("reward_banner_html", this.cbX, this);
        }
        this.aWC = this.cco.getPlayer();
        ahp();
    }

    private void ahp() {
        this.ccn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.ccq.setOnClickListener(this.ccD);
        this.ccr.setOnClickListener(this.ccE);
    }

    public void a(a.c cVar) {
        this.ccj = cVar;
    }

    public void a(a.b bVar) {
        this.ccz = bVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void U(String str) {
        if (this.cco != null) {
            this.cco.U(str);
        }
    }

    public com.baidu.swan.apps.media.c.a getPlayer() {
        if (this.cco != null) {
            return this.cco.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.ccy.removeCallbacksAndMessages(null);
            this.ccy.postDelayed(this.ccC, 0L);
        }
    }

    private void stopTimer() {
        if (this.mProgressBar != null) {
            this.ccy.removeCallbacksAndMessages(null);
        }
    }

    public void ahq() {
        startTimer();
        if (this.mProgressBar != null && this.aWC != null) {
            this.mProgressBar.setMax(this.aWC.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.cct != null && this.aWC != null) {
            this.cct.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(this.aWC.getDuration() / 1000)));
        }
        if (this.ccp.getVisibility() != 0) {
            this.ccp.setVisibility(0);
        }
        if (this.ccv.getVisibility() != 0) {
            this.ccv.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.ccv.setVisibility(0);
        }
    }

    public void onPrepared() {
        if (this.aWC != null) {
            this.mDuration = this.aWC.getDuration();
        }
    }

    public void pausePlay() {
        stopTimer();
    }

    public void ahr() {
        startTimer();
    }

    public void ahs() {
        stopTimer();
        if (this.ccA != null) {
            this.ccA.destroy();
            this.ccA = null;
        }
        if (this.ccB != null) {
            this.ccB.destroy();
            this.ccB = null;
        }
    }

    public void aht() {
        ahv();
        stopTimer();
    }

    private void ahv() {
        if (this.ccn != null) {
            this.ccp.setVisibility(4);
            this.ccv.setVisibility(4);
            this.ccr.setVisibility(4);
            if (!TextUtils.isEmpty(this.cbX.ahF())) {
                this.ccB = new RewardLoadWebView(this.mContext);
                this.ccB.a("reward_end_frame_html", this.cbX, this);
                this.ccn.addView(this.ccB, new RelativeLayout.LayoutParams(-1, -1));
            }
            ahw();
        }
    }

    private void ahw() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.ccE);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(af.dip2px(this.mContext, 96.0f), af.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0317c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0317c.include_land_close_ad_margin), 0);
        this.ccn.addView(textView, layoutParams);
    }

    @Override // com.baidu.swan.game.ad.b.d
    public void ahx() {
        if (this.ccj != null) {
            this.ccj.kQ();
        }
    }
}
