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
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.component.RewardVideoView;
import com.baidu.swan.game.ad.d.f;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes14.dex */
public abstract class b {
    private com.baidu.swan.apps.media.b.a cBf;
    private a.d dUF;
    private RelativeLayout dUL;
    private RewardVideoView dUM;
    private LinearLayout dUN;
    private ImageView dUO;
    private TextView dUP;
    private TextView dUQ;
    private View dUR;
    private RelativeLayout dUS;
    private a.c dUU;
    private RewardLoadWebView dUV;
    private RewardLoadWebView dUW;
    private InteractiveEndFrameView dUX;
    private com.baidu.swan.game.ad.jsbridge.a dUY;
    private AdElementInfo dUs;
    private com.baidu.swan.game.ad.e.b dVa;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    protected Resources mResources;
    private final Handler dUT = new Handler();
    private boolean dVb = false;
    private Runnable dVc = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cBf != null) {
                b.this.aQS();
                int currentPosition = b.this.cBf.getCurrentPosition();
                b.this.r(b.this.mDuration, currentPosition);
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.dUT.postDelayed(b.this.dVc, 100L);
                }
            }
        }
    };
    private View.OnClickListener dVd = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dUM != null) {
                if (b.this.dUM.isMute()) {
                    b.this.dUO.setImageResource(c.d.ng_game_vol_open);
                    b.this.dUM.mute(false);
                    return;
                }
                b.this.dUO.setImageResource(c.d.ng_game_vol_close);
                b.this.dUM.mute(true);
            }
        }
    };
    private View.OnClickListener dVe = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dUU != null) {
                b.this.dUU.aU(view);
            }
        }
    };
    private View.OnClickListener dUI = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dUF != null) {
                b.this.dUF.aV(view);
            }
        }
    };
    public int coC = com.baidu.swan.games.view.a.c.aZe();
    public int coD = com.baidu.swan.games.view.a.c.aZf();
    private boolean dUZ = f.aSj();

    public abstract void a(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public abstract View aQO();

    public abstract String aQP();

    public b(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.jsbridge.a aVar) {
        this.mContext = context;
        this.dUs = adElementInfo;
        this.mResources = this.mContext.getResources();
        this.dUY = aVar;
        initView();
        this.dVa = new com.baidu.swan.game.ad.e.b(this.mContext);
    }

    private void initView() {
        this.mConvertView = aQO();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.coC, this.coD);
        this.mConvertView.setLayoutParams(layoutParams);
        this.dUL = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.dUM = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.dUM.setLayoutParams(layoutParams);
        if (this.dUZ) {
            this.dUM.setOnClickListener(this.dUI);
        }
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.dUN = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.dUO = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.dUP = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.dUQ = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.dUR = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.dUS = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.dUs.aRE())) {
            this.dUV = new RewardLoadWebView(this.mContext);
            this.dUS.addView(this.dUV, new RelativeLayout.LayoutParams(-1, -1));
            a(this.dUS, this.dUs);
            this.dUV.a(aQP(), this.dUs, this.dUY);
        } else {
            View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_banner, (ViewGroup) null);
            this.dUS.addView(inflate);
            ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dUs.getIconUrl());
            ((TextView) inflate.findViewById(c.e.title)).setText(this.dUs.getTitle());
            ((TextView) inflate.findViewById(c.e.desc)).setText(this.dUs.getDescription());
            Button button = (Button) inflate.findViewById(c.e.download);
            if (this.dUs.getActionType() == 1) {
                button.setText(this.mContext.getResources().getString(c.g.see_detail));
            }
            if (this.dUs.getActionType() == 2) {
                button.setText(this.mContext.getResources().getString(c.g.down_immediately));
            }
            this.dUS.setOnClickListener(this.dUI);
            button.setOnClickListener(this.dUI);
        }
        this.cBf = this.dUM.getPlayer();
        aQH();
    }

    private void aQH() {
        this.dUL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.dUO.setOnClickListener(this.dVd);
        this.dUP.setOnClickListener(this.dVe);
    }

    public void a(a.c cVar) {
        this.dUU = cVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void start(String str) {
        if (this.dUM != null) {
            this.dUM.start(str);
        }
    }

    public com.baidu.swan.apps.media.b.a getPlayer() {
        if (this.dUM != null) {
            return this.dUM.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.dUT.removeCallbacksAndMessages(null);
            this.dUT.postDelayed(this.dVc, 0L);
        }
    }

    private void akh() {
        if (this.mProgressBar != null) {
            this.dUT.removeCallbacksAndMessages(null);
        }
    }

    public void aQI() {
        startTimer();
        if (this.mProgressBar != null && this.cBf != null) {
            this.mProgressBar.setMax(this.cBf.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.dUQ != null && this.cBf != null && this.dUs != null) {
            this.dUQ.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.dUs.aRz(), Math.min(this.dUs.aRy(), this.cBf.getDuration())) / 1000)));
            if (this.dUs.aRz() >= 0) {
                this.dUP.setVisibility(8);
                this.dUR.setVisibility(8);
            }
        }
        if (this.dUN.getVisibility() != 0) {
            this.dUN.setVisibility(0);
        }
        if (this.dUS.getVisibility() != 0) {
            this.dUS.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.dUS.setVisibility(0);
        }
        if (this.cBf != null) {
            r(this.cBf.getDuration(), this.cBf.getCurrentPosition());
        }
    }

    public void onPrepared() {
        if (this.cBf != null) {
            this.mDuration = this.cBf.getDuration();
        }
    }

    public void aQJ() {
        akh();
    }

    public void aQK() {
        startTimer();
    }

    public void aQL() {
        akh();
        if (this.dUV != null) {
            this.dUV.destroy();
            this.dUV = null;
        }
        if (this.dUW != null) {
            this.dUW.destroy();
            this.dUW = null;
        }
        if (this.dUX != null) {
            this.dUX.destroy();
            this.dUX = null;
        }
    }

    public void aQM() {
        aQQ();
        akh();
    }

    public void aQN() {
        aQQ();
        akh();
    }

    private void aQQ() {
        if (this.dUL != null) {
            this.dVb = true;
            this.dUN.setVisibility(4);
            this.dUS.setVisibility(4);
            this.dUP.setVisibility(4);
            if (!TextUtils.isEmpty(this.dUs.aRA())) {
                this.dUX = new InteractiveEndFrameView(this.mContext);
                this.dUX.a(this.dUs, this.dUL);
                this.dUL.addView(this.dUX, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dUs, this.dVa);
            } else if (!TextUtils.isEmpty(this.dUs.aRG())) {
                this.dUW = new RewardLoadWebView(this.mContext);
                this.dUW.a("reward_end_frame_html", this.dUs, this.dUY);
                this.dUL.addView(this.dUW, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dUs, this.dVa);
            } else {
                View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_close_banner, (ViewGroup) null);
                this.dUL.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
                ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dUs.getIconUrl());
                ((TextView) inflate.findViewById(c.e.title)).setText(this.dUs.getTitle());
                ((TextView) inflate.findViewById(c.e.desc)).setText(this.dUs.getDescription());
                Button button = (Button) inflate.findViewById(c.e.download);
                if (this.dUs.getActionType() == 1) {
                    button.setText(this.mContext.getResources().getString(c.g.see_detail));
                }
                if (this.dUs.getActionType() == 2) {
                    button.setText(this.mContext.getResources().getString(c.g.down_immediately));
                }
                inflate.findViewById(c.e.content_des).setOnClickListener(this.dUI);
                button.setOnClickListener(this.dUI);
            }
            aQR();
        }
    }

    private void aQR() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.dVe);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ah.dip2px(this.mContext, 96.0f), ah.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0505c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0505c.include_land_close_ad_margin), 0);
        this.dUL.addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQS() {
        if (this.dUs != null && this.cBf != null) {
            this.mDuration = this.cBf.getDuration();
            int min = Math.min(this.dUs.aRy(), this.mDuration / 1000);
            int aRz = this.dUs.aRz();
            int currentPosition = this.cBf.getCurrentPosition() / 1000;
            String string = this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus);
            String string2 = this.mContext.getResources().getString(c.g.swangame_game_ad_video_time_surplus);
            if (currentPosition <= min) {
                this.dUQ.setText(String.format(string, Integer.valueOf(min - currentPosition)));
            } else {
                this.dUQ.setText(String.format(string2, Integer.valueOf((this.mDuration / 1000) - currentPosition)));
            }
            if (currentPosition <= aRz) {
                this.dUP.setVisibility(8);
                this.dUR.setVisibility(8);
                return;
            }
            this.dUP.setVisibility(0);
            this.dUR.setVisibility(0);
        }
    }

    public void a(a.d dVar) {
        this.dUF = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j, int i) {
        if (this.dUZ) {
            if (j > 15000 && i <= 15000) {
                if (i < 5000) {
                    this.dUN.setVisibility(8);
                    this.dUQ.setVisibility(8);
                    this.dUR.setVisibility(8);
                    this.dUP.setVisibility(8);
                    return;
                } else if (i < 10000) {
                    this.dUN.setVisibility(0);
                    this.dUQ.setVisibility(0);
                    this.dUR.setVisibility(8);
                    this.dUP.setVisibility(8);
                    return;
                } else {
                    this.dUN.setVisibility(0);
                    this.dUQ.setVisibility(0);
                    this.dUR.setVisibility(0);
                    this.dUP.setVisibility(0);
                    return;
                }
            }
            this.dUQ.setText(c.g.swangame_game_ad_reward_tip);
            this.dUP.setVisibility(0);
            this.dUR.setVisibility(0);
            this.dUQ.setVisibility(0);
        }
    }

    public boolean aQT() {
        return this.dVb;
    }
}
