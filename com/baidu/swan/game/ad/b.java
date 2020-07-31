package com.baidu.swan.game.ad;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.component.RewardVideoView;
import com.baidu.swan.game.ad.d.f;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes9.dex */
public abstract class b {
    private com.baidu.swan.apps.media.b.a bNE;
    private TextView cZA;
    private View cZB;
    private RelativeLayout cZC;
    private a.c cZE;
    private RewardLoadWebView cZF;
    private RewardLoadWebView cZG;
    private com.baidu.swan.game.ad.jsbridge.a cZH;
    private AdElementInfo cZc;
    private a.d cZp;
    private RelativeLayout cZv;
    private RewardVideoView cZw;
    private LinearLayout cZx;
    private ImageView cZy;
    private TextView cZz;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    protected Resources mResources;
    private final Handler cZD = new Handler();
    private Runnable cZJ = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bNE != null) {
                b.this.azW();
                int currentPosition = b.this.bNE.getCurrentPosition();
                b.this.h(b.this.mDuration, currentPosition);
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.cZD.postDelayed(b.this.cZJ, 100L);
                }
            }
        }
    };
    private View.OnClickListener cZK = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cZw != null) {
                if (b.this.cZw.isMute()) {
                    b.this.cZy.setImageResource(c.d.ng_game_vol_open);
                    b.this.cZw.ei(false);
                    return;
                }
                b.this.cZy.setImageResource(c.d.ng_game_vol_close);
                b.this.cZw.ei(true);
            }
        }
    };
    private View.OnClickListener cZL = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.e.close_ad == view.getId() && b.this.bNE != null && b.this.cZc != null) {
                if (b.this.bNE.getCurrentPosition() > Math.min(b.this.cZc.aAc() * 1000, b.this.mDuration)) {
                    b.this.bNE.seekTo(b.this.mDuration);
                    return;
                }
            }
            if (b.this.cZE != null) {
                b.this.cZE.aAp();
            }
        }
    };
    private View.OnClickListener cZs = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cZp != null) {
                b.this.cZp.aA(view);
            }
        }
    };
    public int bEV = com.baidu.swan.games.view.a.c.aHD();
    public int bEW = com.baidu.swan.games.view.a.c.aHE();
    private boolean cZI = f.aAO();

    public abstract void a(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public abstract View azS();

    public abstract String azT();

    public b(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.jsbridge.a aVar) {
        this.mContext = context;
        this.cZc = adElementInfo;
        this.mResources = this.mContext.getResources();
        this.cZH = aVar;
        initView();
    }

    private void initView() {
        this.mConvertView = azS();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bEV, this.bEW);
        this.mConvertView.setLayoutParams(layoutParams);
        this.cZv = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.cZw = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.cZw.setLayoutParams(layoutParams);
        if (this.cZI) {
            this.cZw.setOnClickListener(this.cZs);
        }
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.cZx = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.cZy = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.cZz = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.cZA = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.cZB = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.cZC = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.cZc.aAh())) {
            this.cZF = new RewardLoadWebView(this.mContext);
            this.cZC.addView(this.cZF, new RelativeLayout.LayoutParams(-1, -1));
            a(this.cZC, this.cZc);
            this.cZF.a(azT(), this.cZc, this.cZH);
        } else {
            View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_banner, (ViewGroup) null);
            this.cZC.addView(inflate);
            ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.cZc.getIconUrl());
            ((TextView) inflate.findViewById(c.e.title)).setText(this.cZc.getTitle());
            ((TextView) inflate.findViewById(c.e.desc)).setText(this.cZc.getDescription());
            Button button = (Button) inflate.findViewById(c.e.download);
            if (this.cZc.getActionType() == 1) {
                button.setText(this.mContext.getResources().getString(c.g.see_detail));
            }
            if (this.cZc.getActionType() == 2) {
                button.setText(this.mContext.getResources().getString(c.g.down_immediately));
            }
            this.cZC.setOnClickListener(this.cZs);
            button.setOnClickListener(this.cZs);
        }
        this.bNE = this.cZw.getPlayer();
        azL();
    }

    private void azL() {
        this.cZv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.cZy.setOnClickListener(this.cZK);
        this.cZz.setOnClickListener(this.cZL);
    }

    public void a(a.c cVar) {
        this.cZE = cVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void bl(String str) {
        if (this.cZw != null) {
            this.cZw.bl(str);
        }
    }

    public com.baidu.swan.apps.media.b.a getPlayer() {
        if (this.cZw != null) {
            return this.cZw.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.cZD.removeCallbacksAndMessages(null);
            this.cZD.postDelayed(this.cZJ, 0L);
        }
    }

    private void Wv() {
        if (this.mProgressBar != null) {
            this.cZD.removeCallbacksAndMessages(null);
        }
    }

    public void azM() {
        startTimer();
        if (this.mProgressBar != null && this.bNE != null) {
            this.mProgressBar.setMax(this.bNE.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.cZA != null && this.bNE != null && this.cZc != null) {
            this.cZA.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.cZc.aAd(), Math.min(this.cZc.aAc(), this.bNE.getDuration())) / 1000)));
            if (this.cZc.aAd() >= 0) {
                this.cZz.setVisibility(8);
                this.cZB.setVisibility(8);
            }
        }
        if (this.cZx.getVisibility() != 0) {
            this.cZx.setVisibility(0);
        }
        if (this.cZC.getVisibility() != 0) {
            this.cZC.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.cZC.setVisibility(0);
        }
        if (this.bNE != null) {
            h(this.bNE.getDuration(), this.bNE.getCurrentPosition());
        }
    }

    public void onPrepared() {
        if (this.bNE != null) {
            this.mDuration = this.bNE.getDuration();
        }
    }

    public void azN() {
        Wv();
    }

    public void azO() {
        startTimer();
    }

    public void azP() {
        Wv();
        if (this.cZF != null) {
            this.cZF.destroy();
            this.cZF = null;
        }
        if (this.cZG != null) {
            this.cZG.destroy();
            this.cZG = null;
        }
    }

    public void azQ() {
        azU();
        Wv();
    }

    public void azR() {
        azU();
        Wv();
    }

    private void azU() {
        if (this.cZv != null) {
            this.cZx.setVisibility(4);
            this.cZC.setVisibility(4);
            this.cZz.setVisibility(4);
            if (!TextUtils.isEmpty(this.cZc.aAj())) {
                this.cZG = new RewardLoadWebView(this.mContext);
                this.cZG.a("reward_end_frame_html", this.cZc, this.cZH);
                this.cZv.addView(this.cZG, new RelativeLayout.LayoutParams(-1, -1));
            } else {
                View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_close_banner, (ViewGroup) null);
                this.cZv.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
                ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.cZc.getIconUrl());
                ((TextView) inflate.findViewById(c.e.title)).setText(this.cZc.getTitle());
                ((TextView) inflate.findViewById(c.e.desc)).setText(this.cZc.getDescription());
                Button button = (Button) inflate.findViewById(c.e.download);
                if (this.cZc.getActionType() == 1) {
                    button.setText(this.mContext.getResources().getString(c.g.see_detail));
                }
                if (this.cZc.getActionType() == 2) {
                    button.setText(this.mContext.getResources().getString(c.g.down_immediately));
                }
                inflate.findViewById(c.e.content_des).setOnClickListener(this.cZs);
                button.setOnClickListener(this.cZs);
            }
            azV();
        }
    }

    private void azV() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.cZL);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ai.dip2px(this.mContext, 96.0f), ai.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0434c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0434c.include_land_close_ad_margin), 0);
        this.cZv.addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azW() {
        if (this.cZc != null && this.bNE != null) {
            this.mDuration = this.bNE.getDuration();
            int min = Math.min(this.cZc.aAc(), this.mDuration / 1000);
            int aAd = this.cZc.aAd();
            int currentPosition = this.bNE.getCurrentPosition() / 1000;
            String string = this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus);
            String string2 = this.mContext.getResources().getString(c.g.swangame_game_ad_video_time_surplus);
            if (currentPosition <= min) {
                this.cZA.setText(String.format(string, Integer.valueOf(min - currentPosition)));
            } else {
                this.cZA.setText(String.format(string2, Integer.valueOf((this.mDuration / 1000) - currentPosition)));
            }
            if (currentPosition <= aAd) {
                this.cZz.setVisibility(8);
                this.cZB.setVisibility(8);
                return;
            }
            this.cZz.setVisibility(0);
            this.cZB.setVisibility(0);
        }
    }

    public void a(a.d dVar) {
        this.cZp = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j, int i) {
        if (this.cZI) {
            if (j > 15000 && i <= 15000) {
                if (i < 5000) {
                    this.cZx.setVisibility(8);
                    this.cZA.setVisibility(8);
                    this.cZB.setVisibility(8);
                    this.cZz.setVisibility(8);
                    return;
                } else if (i < 10000) {
                    this.cZx.setVisibility(0);
                    this.cZA.setVisibility(0);
                    this.cZB.setVisibility(8);
                    this.cZz.setVisibility(8);
                    return;
                } else {
                    this.cZx.setVisibility(0);
                    this.cZA.setVisibility(0);
                    this.cZB.setVisibility(0);
                    this.cZz.setVisibility(0);
                    return;
                }
            }
            this.cZA.setText(c.g.swangame_game_ad_reward_tip);
            this.cZz.setVisibility(0);
            this.cZB.setVisibility(0);
            this.cZA.setVisibility(0);
        }
    }
}
