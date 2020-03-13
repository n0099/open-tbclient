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
    private com.baidu.swan.apps.media.c.a bbH;
    private a.c cgC;
    private RelativeLayout cgG;
    private RewardVideoView cgH;
    private LinearLayout cgI;
    private ImageView cgJ;
    private TextView cgK;
    private TextView cgL;
    private View cgM;
    private RelativeLayout cgN;
    private a.b cgR;
    private RewardLoadWebView cgS;
    private RewardLoadWebView cgT;
    private AdElementInfo cgq;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    private Resources mResources;
    private final Handler cgQ = new Handler();
    private Runnable cgU = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bbH != null) {
                int currentPosition = b.this.bbH.getCurrentPosition();
                b.this.mDuration = b.this.bbH.getDuration();
                if (b.this.mDuration <= 15000 || currentPosition > 15000) {
                    b.this.cgM.setVisibility(8);
                    b.this.cgL.setVisibility(8);
                } else {
                    b.this.cgL.setText(String.format(b.this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(15 - (currentPosition / 1000))));
                }
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.cgQ.postDelayed(b.this.cgU, 100L);
                }
            }
        }
    };
    private View.OnClickListener cgV = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cgH != null) {
                if (b.this.cgH.isMute()) {
                    b.this.cgJ.setImageResource(c.d.ng_game_vol_open);
                    b.this.cgH.cJ(false);
                    return;
                }
                b.this.cgJ.setImageResource(c.d.ng_game_vol_close);
                b.this.cgH.cJ(true);
            }
        }
    };
    private View.OnClickListener cgW = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.e.close_ad != view.getId() || b.this.bbH == null || b.this.mDuration <= 15000 || b.this.bbH.getCurrentPosition() <= 15000) {
                if (b.this.cgR != null) {
                    b.this.cgR.akr();
                    return;
                }
                return;
            }
            b.this.bbH.seekTo(b.this.mDuration);
        }
    };
    public int cgO = com.baidu.swan.games.view.a.c.aqz();
    public int cgP = com.baidu.swan.games.view.a.c.aqA();

    public abstract View akd();

    public b(Context context, AdElementInfo adElementInfo) {
        this.mContext = context;
        this.cgq = adElementInfo;
        this.mResources = this.mContext.getResources();
        initView();
    }

    private void initView() {
        this.mConvertView = akd();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.cgO, this.cgP);
        this.mConvertView.setLayoutParams(layoutParams);
        this.cgG = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.cgH = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.cgH.setLayoutParams(layoutParams);
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.cgI = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.cgJ = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.cgK = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.cgL = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.cgM = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.cgN = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.cgq.akn())) {
            this.cgS = new RewardLoadWebView(this.mContext);
            this.cgN.addView(this.cgS, new RelativeLayout.LayoutParams(-1, -1));
            this.cgS.a("reward_banner_html", this.cgq, this);
        }
        this.bbH = this.cgH.getPlayer();
        ajY();
    }

    private void ajY() {
        this.cgG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.cgJ.setOnClickListener(this.cgV);
        this.cgK.setOnClickListener(this.cgW);
    }

    public void a(a.c cVar) {
        this.cgC = cVar;
    }

    public void a(a.b bVar) {
        this.cgR = bVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void V(String str) {
        if (this.cgH != null) {
            this.cgH.V(str);
        }
    }

    public com.baidu.swan.apps.media.c.a getPlayer() {
        if (this.cgH != null) {
            return this.cgH.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.cgQ.removeCallbacksAndMessages(null);
            this.cgQ.postDelayed(this.cgU, 0L);
        }
    }

    private void stopTimer() {
        if (this.mProgressBar != null) {
            this.cgQ.removeCallbacksAndMessages(null);
        }
    }

    public void ajZ() {
        startTimer();
        if (this.mProgressBar != null && this.bbH != null) {
            this.mProgressBar.setMax(this.bbH.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.cgL != null && this.bbH != null) {
            this.cgL.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(this.bbH.getDuration() / 1000)));
        }
        if (this.cgI.getVisibility() != 0) {
            this.cgI.setVisibility(0);
        }
        if (this.cgN.getVisibility() != 0) {
            this.cgN.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.cgN.setVisibility(0);
        }
    }

    public void onPrepared() {
        if (this.bbH != null) {
            this.mDuration = this.bbH.getDuration();
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
        if (this.cgS != null) {
            this.cgS.destroy();
            this.cgS = null;
        }
        if (this.cgT != null) {
            this.cgT.destroy();
            this.cgT = null;
        }
    }

    public void akc() {
        ake();
        stopTimer();
    }

    private void ake() {
        if (this.cgG != null) {
            this.cgI.setVisibility(4);
            this.cgN.setVisibility(4);
            this.cgK.setVisibility(4);
            if (!TextUtils.isEmpty(this.cgq.ako())) {
                this.cgT = new RewardLoadWebView(this.mContext);
                this.cgT.a("reward_end_frame_html", this.cgq, this);
                this.cgG.addView(this.cgT, new RelativeLayout.LayoutParams(-1, -1));
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
        textView.setOnClickListener(this.cgW);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(af.dip2px(this.mContext, 96.0f), af.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0329c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0329c.include_land_close_ad_margin), 0);
        this.cgG.addView(textView, layoutParams);
    }

    @Override // com.baidu.swan.game.ad.b.d
    public void akg() {
        if (this.cgC != null) {
            this.cgC.lg();
        }
    }
}
