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
/* loaded from: classes11.dex */
public abstract class b implements com.baidu.swan.game.ad.b.d {
    private com.baidu.swan.apps.media.c.a bbU;
    private AdElementInfo cgB;
    private a.c cgN;
    private RelativeLayout cgR;
    private RewardVideoView cgS;
    private LinearLayout cgT;
    private ImageView cgU;
    private TextView cgV;
    private TextView cgW;
    private View cgX;
    private RelativeLayout cgY;
    private a.b chc;
    private RewardLoadWebView chd;
    private RewardLoadWebView che;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    private Resources mResources;
    private final Handler chb = new Handler();
    private Runnable chf = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bbU != null) {
                int currentPosition = b.this.bbU.getCurrentPosition();
                b.this.mDuration = b.this.bbU.getDuration();
                if (b.this.mDuration <= 15000 || currentPosition > 15000) {
                    b.this.cgX.setVisibility(8);
                    b.this.cgW.setVisibility(8);
                } else {
                    b.this.cgW.setText(String.format(b.this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(15 - (currentPosition / 1000))));
                }
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.chb.postDelayed(b.this.chf, 100L);
                }
            }
        }
    };
    private View.OnClickListener chg = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cgS != null) {
                if (b.this.cgS.isMute()) {
                    b.this.cgU.setImageResource(c.d.ng_game_vol_open);
                    b.this.cgS.cK(false);
                    return;
                }
                b.this.cgU.setImageResource(c.d.ng_game_vol_close);
                b.this.cgS.cK(true);
            }
        }
    };
    private View.OnClickListener chh = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.e.close_ad != view.getId() || b.this.bbU == null || b.this.mDuration <= 15000 || b.this.bbU.getCurrentPosition() <= 15000) {
                if (b.this.chc != null) {
                    b.this.chc.aku();
                    return;
                }
                return;
            }
            b.this.bbU.seekTo(b.this.mDuration);
        }
    };
    public int cgZ = com.baidu.swan.games.view.a.c.aqC();
    public int cha = com.baidu.swan.games.view.a.c.aqD();

    public abstract View akg();

    public b(Context context, AdElementInfo adElementInfo) {
        this.mContext = context;
        this.cgB = adElementInfo;
        this.mResources = this.mContext.getResources();
        initView();
    }

    private void initView() {
        this.mConvertView = akg();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.cgZ, this.cha);
        this.mConvertView.setLayoutParams(layoutParams);
        this.cgR = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.cgS = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.cgS.setLayoutParams(layoutParams);
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.cgT = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.cgU = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.cgV = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.cgW = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.cgX = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.cgY = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.cgB.akq())) {
            this.chd = new RewardLoadWebView(this.mContext);
            this.cgY.addView(this.chd, new RelativeLayout.LayoutParams(-1, -1));
            this.chd.a("reward_banner_html", this.cgB, this);
        }
        this.bbU = this.cgS.getPlayer();
        akb();
    }

    private void akb() {
        this.cgR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.cgU.setOnClickListener(this.chg);
        this.cgV.setOnClickListener(this.chh);
    }

    public void a(a.c cVar) {
        this.cgN = cVar;
    }

    public void a(a.b bVar) {
        this.chc = bVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void V(String str) {
        if (this.cgS != null) {
            this.cgS.V(str);
        }
    }

    public com.baidu.swan.apps.media.c.a getPlayer() {
        if (this.cgS != null) {
            return this.cgS.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.chb.removeCallbacksAndMessages(null);
            this.chb.postDelayed(this.chf, 0L);
        }
    }

    private void stopTimer() {
        if (this.mProgressBar != null) {
            this.chb.removeCallbacksAndMessages(null);
        }
    }

    public void akc() {
        startTimer();
        if (this.mProgressBar != null && this.bbU != null) {
            this.mProgressBar.setMax(this.bbU.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.cgW != null && this.bbU != null) {
            this.cgW.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(this.bbU.getDuration() / 1000)));
        }
        if (this.cgT.getVisibility() != 0) {
            this.cgT.setVisibility(0);
        }
        if (this.cgY.getVisibility() != 0) {
            this.cgY.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.cgY.setVisibility(0);
        }
    }

    public void onPrepared() {
        if (this.bbU != null) {
            this.mDuration = this.bbU.getDuration();
        }
    }

    public void pausePlay() {
        stopTimer();
    }

    public void akd() {
        startTimer();
    }

    public void ake() {
        stopTimer();
        if (this.chd != null) {
            this.chd.destroy();
            this.chd = null;
        }
        if (this.che != null) {
            this.che.destroy();
            this.che = null;
        }
    }

    public void akf() {
        akh();
        stopTimer();
    }

    private void akh() {
        if (this.cgR != null) {
            this.cgT.setVisibility(4);
            this.cgY.setVisibility(4);
            this.cgV.setVisibility(4);
            if (!TextUtils.isEmpty(this.cgB.akr())) {
                this.che = new RewardLoadWebView(this.mContext);
                this.che.a("reward_end_frame_html", this.cgB, this);
                this.cgR.addView(this.che, new RelativeLayout.LayoutParams(-1, -1));
            }
            aki();
        }
    }

    private void aki() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.chh);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(af.dip2px(this.mContext, 96.0f), af.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0329c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0329c.include_land_close_ad_margin), 0);
        this.cgR.addView(textView, layoutParams);
    }

    @Override // com.baidu.swan.game.ad.b.d
    public void akj() {
        if (this.cgN != null) {
            this.cgN.lg();
        }
    }
}
