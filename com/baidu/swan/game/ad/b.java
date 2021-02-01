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
/* loaded from: classes5.dex */
public abstract class b {
    private com.baidu.swan.apps.media.b.a cDB;
    private a.d dWL;
    private RelativeLayout dWR;
    private RewardVideoView dWS;
    private LinearLayout dWT;
    private ImageView dWU;
    private TextView dWV;
    private TextView dWW;
    private View dWX;
    private RelativeLayout dWY;
    private AdElementInfo dWy;
    private a.c dXc;
    private RewardLoadWebView dXd;
    private RewardLoadWebView dXe;
    private InteractiveEndFrameView dXf;
    private com.baidu.swan.game.ad.jsbridge.a dXg;
    private com.baidu.swan.game.ad.e.b dXi;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    protected Resources mResources;
    private final Handler dXb = new Handler();
    private boolean dXj = false;
    private Runnable dXk = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cDB != null) {
                b.this.aRi();
                int currentPosition = b.this.cDB.getCurrentPosition();
                b.this.r(b.this.mDuration, currentPosition);
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.dXb.postDelayed(b.this.dXk, 100L);
                }
            }
        }
    };
    private View.OnClickListener dXl = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dWS != null) {
                if (b.this.dWS.isMute()) {
                    b.this.dWU.setImageResource(c.d.ng_game_vol_open);
                    b.this.dWS.mute(false);
                    return;
                }
                b.this.dWU.setImageResource(c.d.ng_game_vol_close);
                b.this.dWS.mute(true);
            }
        }
    };
    private View.OnClickListener dXm = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dXc != null) {
                b.this.dXc.aQ(view);
            }
        }
    };
    private View.OnClickListener dWO = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dWL != null) {
                b.this.dWL.aR(view);
            }
        }
    };
    public int dWZ = com.baidu.swan.games.view.a.c.aZq();
    public int dXa = com.baidu.swan.games.view.a.c.aZr();
    private boolean dXh = f.aSv();

    public abstract void a(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public abstract View aRe();

    public abstract String aRf();

    public b(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.jsbridge.a aVar) {
        this.mContext = context;
        this.dWy = adElementInfo;
        this.mResources = this.mContext.getResources();
        this.dXg = aVar;
        initView();
        this.dXi = new com.baidu.swan.game.ad.e.b(this.mContext);
    }

    private void initView() {
        this.mConvertView = aRe();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.dWZ, this.dXa);
        this.mConvertView.setLayoutParams(layoutParams);
        this.dWR = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.dWS = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.dWS.setLayoutParams(layoutParams);
        if (this.dXh) {
            this.dWS.setOnClickListener(this.dWO);
        }
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.dWT = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.dWU = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.dWV = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.dWW = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.dWX = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.dWY = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.dWy.aRT())) {
            this.dXd = new RewardLoadWebView(this.mContext);
            this.dWY.addView(this.dXd, new RelativeLayout.LayoutParams(-1, -1));
            a(this.dWY, this.dWy);
            this.dXd.a(aRf(), this.dWy, this.dXg);
        } else {
            View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_banner, (ViewGroup) null);
            this.dWY.addView(inflate);
            ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dWy.getIconUrl());
            ((TextView) inflate.findViewById(c.e.title)).setText(this.dWy.getTitle());
            ((TextView) inflate.findViewById(c.e.desc)).setText(this.dWy.getDescription());
            Button button = (Button) inflate.findViewById(c.e.download);
            if (this.dWy.getActionType() == 1) {
                button.setText(this.mContext.getResources().getString(c.g.see_detail));
            }
            if (this.dWy.getActionType() == 2) {
                button.setText(this.mContext.getResources().getString(c.g.down_immediately));
            }
            this.dWY.setOnClickListener(this.dWO);
            button.setOnClickListener(this.dWO);
        }
        this.cDB = this.dWS.getPlayer();
        aRa();
    }

    private void aRa() {
        this.dWR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.dWU.setOnClickListener(this.dXl);
        this.dWV.setOnClickListener(this.dXm);
    }

    public void a(a.c cVar) {
        this.dXc = cVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void start(String str) {
        if (this.dWS != null) {
            this.dWS.start(str);
        }
    }

    public com.baidu.swan.apps.media.b.a getPlayer() {
        if (this.dWS != null) {
            return this.dWS.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.dXb.removeCallbacksAndMessages(null);
            this.dXb.postDelayed(this.dXk, 0L);
        }
    }

    private void akF() {
        if (this.mProgressBar != null) {
            this.dXb.removeCallbacksAndMessages(null);
        }
    }

    public void aRb() {
        startTimer();
        if (this.mProgressBar != null && this.cDB != null) {
            this.mProgressBar.setMax(this.cDB.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.dWW != null && this.cDB != null && this.dWy != null) {
            this.dWW.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.dWy.aRP(), Math.min(this.dWy.aRO(), this.cDB.getDuration())) / 1000)));
            if (this.dWy.aRP() >= 0) {
                this.dWV.setVisibility(8);
                this.dWX.setVisibility(8);
            }
        }
        if (this.dWT.getVisibility() != 0) {
            this.dWT.setVisibility(0);
        }
        if (this.dWY.getVisibility() != 0) {
            this.dWY.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.dWY.setVisibility(0);
        }
        if (this.cDB != null) {
            r(this.cDB.getDuration(), this.cDB.getCurrentPosition());
        }
    }

    public void onPrepared() {
        if (this.cDB != null) {
            this.mDuration = this.cDB.getDuration();
        }
    }

    public void pausePlay() {
        akF();
    }

    public void resumePlay() {
        startTimer();
    }

    public void aRc() {
        akF();
        if (this.dXd != null) {
            this.dXd.destroy();
            this.dXd = null;
        }
        if (this.dXe != null) {
            this.dXe.destroy();
            this.dXe = null;
        }
        if (this.dXf != null) {
            this.dXf.destroy();
            this.dXf = null;
        }
    }

    public void playCompletion() {
        aRg();
        akF();
    }

    public void aRd() {
        aRg();
        akF();
    }

    private void aRg() {
        if (this.dWR != null) {
            this.dXj = true;
            this.dWT.setVisibility(4);
            this.dWY.setVisibility(4);
            this.dWV.setVisibility(4);
            if (!TextUtils.isEmpty(this.dWy.aRQ())) {
                this.dXf = new InteractiveEndFrameView(this.mContext);
                this.dXf.a(this.dWy, this.dWR);
                this.dWR.addView(this.dXf, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dWy, this.dXi);
            } else if (!TextUtils.isEmpty(this.dWy.aRV())) {
                this.dXe = new RewardLoadWebView(this.mContext);
                this.dXe.a("reward_end_frame_html", this.dWy, this.dXg);
                this.dWR.addView(this.dXe, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dWy, this.dXi);
            } else {
                View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_close_banner, (ViewGroup) null);
                this.dWR.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
                ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dWy.getIconUrl());
                ((TextView) inflate.findViewById(c.e.title)).setText(this.dWy.getTitle());
                ((TextView) inflate.findViewById(c.e.desc)).setText(this.dWy.getDescription());
                Button button = (Button) inflate.findViewById(c.e.download);
                if (this.dWy.getActionType() == 1) {
                    button.setText(this.mContext.getResources().getString(c.g.see_detail));
                }
                if (this.dWy.getActionType() == 2) {
                    button.setText(this.mContext.getResources().getString(c.g.down_immediately));
                }
                inflate.findViewById(c.e.content_des).setOnClickListener(this.dWO);
                button.setOnClickListener(this.dWO);
            }
            aRh();
        }
    }

    private void aRh() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.dXm);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ah.dip2px(this.mContext, 96.0f), ah.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0502c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0502c.include_land_close_ad_margin), 0);
        this.dWR.addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRi() {
        if (this.dWy != null && this.cDB != null) {
            this.mDuration = this.cDB.getDuration();
            int min = Math.min(this.dWy.aRO(), this.mDuration / 1000);
            int aRP = this.dWy.aRP();
            int currentPosition = this.cDB.getCurrentPosition() / 1000;
            String string = this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus);
            String string2 = this.mContext.getResources().getString(c.g.swangame_game_ad_video_time_surplus);
            if (currentPosition <= min) {
                this.dWW.setText(String.format(string, Integer.valueOf(min - currentPosition)));
            } else {
                this.dWW.setText(String.format(string2, Integer.valueOf((this.mDuration / 1000) - currentPosition)));
            }
            if (currentPosition <= aRP) {
                this.dWV.setVisibility(8);
                this.dWX.setVisibility(8);
                return;
            }
            this.dWV.setVisibility(0);
            this.dWX.setVisibility(0);
        }
    }

    public void a(a.d dVar) {
        this.dWL = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j, int i) {
        if (this.dXh) {
            if (j > 15000 && i <= 15000) {
                if (i < 5000) {
                    this.dWT.setVisibility(8);
                    this.dWW.setVisibility(8);
                    this.dWX.setVisibility(8);
                    this.dWV.setVisibility(8);
                    return;
                } else if (i < 10000) {
                    this.dWT.setVisibility(0);
                    this.dWW.setVisibility(0);
                    this.dWX.setVisibility(8);
                    this.dWV.setVisibility(8);
                    return;
                } else {
                    this.dWT.setVisibility(0);
                    this.dWW.setVisibility(0);
                    this.dWX.setVisibility(0);
                    this.dWV.setVisibility(0);
                    return;
                }
            }
            this.dWW.setText(c.g.swangame_game_ad_reward_tip);
            this.dWV.setVisibility(0);
            this.dWX.setVisibility(0);
            this.dWW.setVisibility(0);
        }
    }

    public boolean aRj() {
        return this.dXj;
    }
}
