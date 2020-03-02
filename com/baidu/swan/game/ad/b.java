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
    private com.baidu.swan.apps.media.c.a bbG;
    private a.c cgB;
    private RelativeLayout cgF;
    private RewardVideoView cgG;
    private LinearLayout cgH;
    private ImageView cgI;
    private TextView cgJ;
    private TextView cgK;
    private View cgL;
    private RelativeLayout cgM;
    private a.b cgQ;
    private RewardLoadWebView cgR;
    private RewardLoadWebView cgS;
    private AdElementInfo cgp;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    private Resources mResources;
    private final Handler cgP = new Handler();
    private Runnable cgT = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bbG != null) {
                int currentPosition = b.this.bbG.getCurrentPosition();
                b.this.mDuration = b.this.bbG.getDuration();
                if (b.this.mDuration <= 15000 || currentPosition > 15000) {
                    b.this.cgL.setVisibility(8);
                    b.this.cgK.setVisibility(8);
                } else {
                    b.this.cgK.setText(String.format(b.this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(15 - (currentPosition / 1000))));
                }
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.cgP.postDelayed(b.this.cgT, 100L);
                }
            }
        }
    };
    private View.OnClickListener cgU = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cgG != null) {
                if (b.this.cgG.isMute()) {
                    b.this.cgI.setImageResource(c.d.ng_game_vol_open);
                    b.this.cgG.cJ(false);
                    return;
                }
                b.this.cgI.setImageResource(c.d.ng_game_vol_close);
                b.this.cgG.cJ(true);
            }
        }
    };
    private View.OnClickListener cgV = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.e.close_ad != view.getId() || b.this.bbG == null || b.this.mDuration <= 15000 || b.this.bbG.getCurrentPosition() <= 15000) {
                if (b.this.cgQ != null) {
                    b.this.cgQ.akr();
                    return;
                }
                return;
            }
            b.this.bbG.seekTo(b.this.mDuration);
        }
    };
    public int cgN = com.baidu.swan.games.view.a.c.aqz();
    public int cgO = com.baidu.swan.games.view.a.c.aqA();

    public abstract View akd();

    public b(Context context, AdElementInfo adElementInfo) {
        this.mContext = context;
        this.cgp = adElementInfo;
        this.mResources = this.mContext.getResources();
        initView();
    }

    private void initView() {
        this.mConvertView = akd();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.cgN, this.cgO);
        this.mConvertView.setLayoutParams(layoutParams);
        this.cgF = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.cgG = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.cgG.setLayoutParams(layoutParams);
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.cgH = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.cgI = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.cgJ = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.cgK = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.cgL = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.cgM = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.cgp.akn())) {
            this.cgR = new RewardLoadWebView(this.mContext);
            this.cgM.addView(this.cgR, new RelativeLayout.LayoutParams(-1, -1));
            this.cgR.a("reward_banner_html", this.cgp, this);
        }
        this.bbG = this.cgG.getPlayer();
        ajY();
    }

    private void ajY() {
        this.cgF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.cgI.setOnClickListener(this.cgU);
        this.cgJ.setOnClickListener(this.cgV);
    }

    public void a(a.c cVar) {
        this.cgB = cVar;
    }

    public void a(a.b bVar) {
        this.cgQ = bVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void V(String str) {
        if (this.cgG != null) {
            this.cgG.V(str);
        }
    }

    public com.baidu.swan.apps.media.c.a getPlayer() {
        if (this.cgG != null) {
            return this.cgG.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.cgP.removeCallbacksAndMessages(null);
            this.cgP.postDelayed(this.cgT, 0L);
        }
    }

    private void stopTimer() {
        if (this.mProgressBar != null) {
            this.cgP.removeCallbacksAndMessages(null);
        }
    }

    public void ajZ() {
        startTimer();
        if (this.mProgressBar != null && this.bbG != null) {
            this.mProgressBar.setMax(this.bbG.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.cgK != null && this.bbG != null) {
            this.cgK.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(this.bbG.getDuration() / 1000)));
        }
        if (this.cgH.getVisibility() != 0) {
            this.cgH.setVisibility(0);
        }
        if (this.cgM.getVisibility() != 0) {
            this.cgM.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.cgM.setVisibility(0);
        }
    }

    public void onPrepared() {
        if (this.bbG != null) {
            this.mDuration = this.bbG.getDuration();
        }
    }

    public void pausePlay() {
        stopTimer();
    }

    public void aka() {
        startTimer();
    }

    public void akb() {
        stopTimer();
        if (this.cgR != null) {
            this.cgR.destroy();
            this.cgR = null;
        }
        if (this.cgS != null) {
            this.cgS.destroy();
            this.cgS = null;
        }
    }

    public void akc() {
        ake();
        stopTimer();
    }

    private void ake() {
        if (this.cgF != null) {
            this.cgH.setVisibility(4);
            this.cgM.setVisibility(4);
            this.cgJ.setVisibility(4);
            if (!TextUtils.isEmpty(this.cgp.ako())) {
                this.cgS = new RewardLoadWebView(this.mContext);
                this.cgS.a("reward_end_frame_html", this.cgp, this);
                this.cgF.addView(this.cgS, new RelativeLayout.LayoutParams(-1, -1));
            }
            akf();
        }
    }

    private void akf() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.cgV);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(af.dip2px(this.mContext, 96.0f), af.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0329c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0329c.include_land_close_ad_margin), 0);
        this.cgF.addView(textView, layoutParams);
    }

    @Override // com.baidu.swan.game.ad.b.d
    public void akg() {
        if (this.cgB != null) {
            this.cgB.lg();
        }
    }
}
