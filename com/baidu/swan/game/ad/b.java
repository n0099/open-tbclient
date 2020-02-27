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
    private com.baidu.swan.apps.media.c.a bbF;
    private a.c cgA;
    private RelativeLayout cgE;
    private RewardVideoView cgF;
    private LinearLayout cgG;
    private ImageView cgH;
    private TextView cgI;
    private TextView cgJ;
    private View cgK;
    private RelativeLayout cgL;
    private a.b cgP;
    private RewardLoadWebView cgQ;
    private RewardLoadWebView cgR;
    private AdElementInfo cgo;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    private Resources mResources;
    private final Handler cgO = new Handler();
    private Runnable cgS = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bbF != null) {
                int currentPosition = b.this.bbF.getCurrentPosition();
                b.this.mDuration = b.this.bbF.getDuration();
                if (b.this.mDuration <= 15000 || currentPosition > 15000) {
                    b.this.cgK.setVisibility(8);
                    b.this.cgJ.setVisibility(8);
                } else {
                    b.this.cgJ.setText(String.format(b.this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(15 - (currentPosition / 1000))));
                }
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.cgO.postDelayed(b.this.cgS, 100L);
                }
            }
        }
    };
    private View.OnClickListener cgT = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cgF != null) {
                if (b.this.cgF.isMute()) {
                    b.this.cgH.setImageResource(c.d.ng_game_vol_open);
                    b.this.cgF.cJ(false);
                    return;
                }
                b.this.cgH.setImageResource(c.d.ng_game_vol_close);
                b.this.cgF.cJ(true);
            }
        }
    };
    private View.OnClickListener cgU = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.e.close_ad != view.getId() || b.this.bbF == null || b.this.mDuration <= 15000 || b.this.bbF.getCurrentPosition() <= 15000) {
                if (b.this.cgP != null) {
                    b.this.cgP.akp();
                    return;
                }
                return;
            }
            b.this.bbF.seekTo(b.this.mDuration);
        }
    };
    public int cgM = com.baidu.swan.games.view.a.c.aqx();
    public int cgN = com.baidu.swan.games.view.a.c.aqy();

    public abstract View akb();

    public b(Context context, AdElementInfo adElementInfo) {
        this.mContext = context;
        this.cgo = adElementInfo;
        this.mResources = this.mContext.getResources();
        initView();
    }

    private void initView() {
        this.mConvertView = akb();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.cgM, this.cgN);
        this.mConvertView.setLayoutParams(layoutParams);
        this.cgE = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.cgF = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.cgF.setLayoutParams(layoutParams);
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.cgG = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.cgH = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.cgI = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.cgJ = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.cgK = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.cgL = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.cgo.akl())) {
            this.cgQ = new RewardLoadWebView(this.mContext);
            this.cgL.addView(this.cgQ, new RelativeLayout.LayoutParams(-1, -1));
            this.cgQ.a("reward_banner_html", this.cgo, this);
        }
        this.bbF = this.cgF.getPlayer();
        ajW();
    }

    private void ajW() {
        this.cgE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.cgH.setOnClickListener(this.cgT);
        this.cgI.setOnClickListener(this.cgU);
    }

    public void a(a.c cVar) {
        this.cgA = cVar;
    }

    public void a(a.b bVar) {
        this.cgP = bVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void V(String str) {
        if (this.cgF != null) {
            this.cgF.V(str);
        }
    }

    public com.baidu.swan.apps.media.c.a getPlayer() {
        if (this.cgF != null) {
            return this.cgF.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.cgO.removeCallbacksAndMessages(null);
            this.cgO.postDelayed(this.cgS, 0L);
        }
    }

    private void stopTimer() {
        if (this.mProgressBar != null) {
            this.cgO.removeCallbacksAndMessages(null);
        }
    }

    public void ajX() {
        startTimer();
        if (this.mProgressBar != null && this.bbF != null) {
            this.mProgressBar.setMax(this.bbF.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.cgJ != null && this.bbF != null) {
            this.cgJ.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(this.bbF.getDuration() / 1000)));
        }
        if (this.cgG.getVisibility() != 0) {
            this.cgG.setVisibility(0);
        }
        if (this.cgL.getVisibility() != 0) {
            this.cgL.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.cgL.setVisibility(0);
        }
    }

    public void onPrepared() {
        if (this.bbF != null) {
            this.mDuration = this.bbF.getDuration();
        }
    }

    public void pausePlay() {
        stopTimer();
    }

    public void ajY() {
        startTimer();
    }

    public void ajZ() {
        stopTimer();
        if (this.cgQ != null) {
            this.cgQ.destroy();
            this.cgQ = null;
        }
        if (this.cgR != null) {
            this.cgR.destroy();
            this.cgR = null;
        }
    }

    public void aka() {
        akc();
        stopTimer();
    }

    private void akc() {
        if (this.cgE != null) {
            this.cgG.setVisibility(4);
            this.cgL.setVisibility(4);
            this.cgI.setVisibility(4);
            if (!TextUtils.isEmpty(this.cgo.akm())) {
                this.cgR = new RewardLoadWebView(this.mContext);
                this.cgR.a("reward_end_frame_html", this.cgo, this);
                this.cgE.addView(this.cgR, new RelativeLayout.LayoutParams(-1, -1));
            }
            akd();
        }
    }

    private void akd() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.cgU);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(af.dip2px(this.mContext, 96.0f), af.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0329c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0329c.include_land_close_ad_margin), 0);
        this.cgE.addView(textView, layoutParams);
    }

    @Override // com.baidu.swan.game.ad.b.d
    public void ake() {
        if (this.cgA != null) {
            this.cgA.lg();
        }
    }
}
