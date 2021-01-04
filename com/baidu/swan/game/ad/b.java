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
/* loaded from: classes3.dex */
public abstract class b {
    private com.baidu.swan.apps.media.b.a cFR;
    private ImageView dZA;
    private TextView dZB;
    private TextView dZC;
    private View dZD;
    private RelativeLayout dZE;
    private a.c dZG;
    private RewardLoadWebView dZH;
    private RewardLoadWebView dZI;
    private InteractiveEndFrameView dZJ;
    private com.baidu.swan.game.ad.jsbridge.a dZK;
    private com.baidu.swan.game.ad.e.b dZM;
    private AdElementInfo dZe;
    private a.d dZr;
    private RelativeLayout dZx;
    private RewardVideoView dZy;
    private LinearLayout dZz;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    protected Resources mResources;
    private final Handler dZF = new Handler();
    private boolean dZN = false;
    private Runnable dZO = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cFR != null) {
                b.this.aUL();
                int currentPosition = b.this.cFR.getCurrentPosition();
                b.this.r(b.this.mDuration, currentPosition);
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.dZF.postDelayed(b.this.dZO, 100L);
                }
            }
        }
    };
    private View.OnClickListener dZP = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dZy != null) {
                if (b.this.dZy.isMute()) {
                    b.this.dZA.setImageResource(c.d.ng_game_vol_open);
                    b.this.dZy.mute(false);
                    return;
                }
                b.this.dZA.setImageResource(c.d.ng_game_vol_close);
                b.this.dZy.mute(true);
            }
        }
    };
    private View.OnClickListener dZQ = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dZG != null) {
                b.this.dZG.aU(view);
            }
        }
    };
    private View.OnClickListener dZu = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dZr != null) {
                b.this.dZr.aV(view);
            }
        }
    };
    public int ctq = com.baidu.swan.games.view.a.c.bcX();
    public int cts = com.baidu.swan.games.view.a.c.bcY();
    private boolean dZL = f.aWc();

    public abstract void a(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public abstract View aUH();

    public abstract String aUI();

    public b(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.jsbridge.a aVar) {
        this.mContext = context;
        this.dZe = adElementInfo;
        this.mResources = this.mContext.getResources();
        this.dZK = aVar;
        initView();
        this.dZM = new com.baidu.swan.game.ad.e.b(this.mContext);
    }

    private void initView() {
        this.mConvertView = aUH();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ctq, this.cts);
        this.mConvertView.setLayoutParams(layoutParams);
        this.dZx = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.dZy = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.dZy.setLayoutParams(layoutParams);
        if (this.dZL) {
            this.dZy.setOnClickListener(this.dZu);
        }
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.dZz = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.dZA = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.dZB = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.dZC = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.dZD = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.dZE = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.dZe.aVx())) {
            this.dZH = new RewardLoadWebView(this.mContext);
            this.dZE.addView(this.dZH, new RelativeLayout.LayoutParams(-1, -1));
            a(this.dZE, this.dZe);
            this.dZH.a(aUI(), this.dZe, this.dZK);
        } else {
            View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_banner, (ViewGroup) null);
            this.dZE.addView(inflate);
            ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dZe.getIconUrl());
            ((TextView) inflate.findViewById(c.e.title)).setText(this.dZe.getTitle());
            ((TextView) inflate.findViewById(c.e.desc)).setText(this.dZe.getDescription());
            Button button = (Button) inflate.findViewById(c.e.download);
            if (this.dZe.getActionType() == 1) {
                button.setText(this.mContext.getResources().getString(c.g.see_detail));
            }
            if (this.dZe.getActionType() == 2) {
                button.setText(this.mContext.getResources().getString(c.g.down_immediately));
            }
            this.dZE.setOnClickListener(this.dZu);
            button.setOnClickListener(this.dZu);
        }
        this.cFR = this.dZy.getPlayer();
        aUA();
    }

    private void aUA() {
        this.dZx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.dZA.setOnClickListener(this.dZP);
        this.dZB.setOnClickListener(this.dZQ);
    }

    public void a(a.c cVar) {
        this.dZG = cVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void start(String str) {
        if (this.dZy != null) {
            this.dZy.start(str);
        }
    }

    public com.baidu.swan.apps.media.b.a getPlayer() {
        if (this.dZy != null) {
            return this.dZy.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.dZF.removeCallbacksAndMessages(null);
            this.dZF.postDelayed(this.dZO, 0L);
        }
    }

    private void aoa() {
        if (this.mProgressBar != null) {
            this.dZF.removeCallbacksAndMessages(null);
        }
    }

    public void aUB() {
        startTimer();
        if (this.mProgressBar != null && this.cFR != null) {
            this.mProgressBar.setMax(this.cFR.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.dZC != null && this.cFR != null && this.dZe != null) {
            this.dZC.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.dZe.aVs(), Math.min(this.dZe.aVr(), this.cFR.getDuration())) / 1000)));
            if (this.dZe.aVs() >= 0) {
                this.dZB.setVisibility(8);
                this.dZD.setVisibility(8);
            }
        }
        if (this.dZz.getVisibility() != 0) {
            this.dZz.setVisibility(0);
        }
        if (this.dZE.getVisibility() != 0) {
            this.dZE.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.dZE.setVisibility(0);
        }
        if (this.cFR != null) {
            r(this.cFR.getDuration(), this.cFR.getCurrentPosition());
        }
    }

    public void onPrepared() {
        if (this.cFR != null) {
            this.mDuration = this.cFR.getDuration();
        }
    }

    public void aUC() {
        aoa();
    }

    public void aUD() {
        startTimer();
    }

    public void aUE() {
        aoa();
        if (this.dZH != null) {
            this.dZH.destroy();
            this.dZH = null;
        }
        if (this.dZI != null) {
            this.dZI.destroy();
            this.dZI = null;
        }
        if (this.dZJ != null) {
            this.dZJ.destroy();
            this.dZJ = null;
        }
    }

    public void aUF() {
        aUJ();
        aoa();
    }

    public void aUG() {
        aUJ();
        aoa();
    }

    private void aUJ() {
        if (this.dZx != null) {
            this.dZN = true;
            this.dZz.setVisibility(4);
            this.dZE.setVisibility(4);
            this.dZB.setVisibility(4);
            if (!TextUtils.isEmpty(this.dZe.aVt())) {
                this.dZJ = new InteractiveEndFrameView(this.mContext);
                this.dZJ.a(this.dZe, this.dZx);
                this.dZx.addView(this.dZJ, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dZe, this.dZM);
            } else if (!TextUtils.isEmpty(this.dZe.aVz())) {
                this.dZI = new RewardLoadWebView(this.mContext);
                this.dZI.a("reward_end_frame_html", this.dZe, this.dZK);
                this.dZx.addView(this.dZI, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dZe, this.dZM);
            } else {
                View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_close_banner, (ViewGroup) null);
                this.dZx.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
                ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dZe.getIconUrl());
                ((TextView) inflate.findViewById(c.e.title)).setText(this.dZe.getTitle());
                ((TextView) inflate.findViewById(c.e.desc)).setText(this.dZe.getDescription());
                Button button = (Button) inflate.findViewById(c.e.download);
                if (this.dZe.getActionType() == 1) {
                    button.setText(this.mContext.getResources().getString(c.g.see_detail));
                }
                if (this.dZe.getActionType() == 2) {
                    button.setText(this.mContext.getResources().getString(c.g.down_immediately));
                }
                inflate.findViewById(c.e.content_des).setOnClickListener(this.dZu);
                button.setOnClickListener(this.dZu);
            }
            aUK();
        }
    }

    private void aUK() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.dZQ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ah.dip2px(this.mContext, 96.0f), ah.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0522c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0522c.include_land_close_ad_margin), 0);
        this.dZx.addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUL() {
        if (this.dZe != null && this.cFR != null) {
            this.mDuration = this.cFR.getDuration();
            int min = Math.min(this.dZe.aVr(), this.mDuration / 1000);
            int aVs = this.dZe.aVs();
            int currentPosition = this.cFR.getCurrentPosition() / 1000;
            String string = this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus);
            String string2 = this.mContext.getResources().getString(c.g.swangame_game_ad_video_time_surplus);
            if (currentPosition <= min) {
                this.dZC.setText(String.format(string, Integer.valueOf(min - currentPosition)));
            } else {
                this.dZC.setText(String.format(string2, Integer.valueOf((this.mDuration / 1000) - currentPosition)));
            }
            if (currentPosition <= aVs) {
                this.dZB.setVisibility(8);
                this.dZD.setVisibility(8);
                return;
            }
            this.dZB.setVisibility(0);
            this.dZD.setVisibility(0);
        }
    }

    public void a(a.d dVar) {
        this.dZr = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j, int i) {
        if (this.dZL) {
            if (j > 15000 && i <= 15000) {
                if (i < 5000) {
                    this.dZz.setVisibility(8);
                    this.dZC.setVisibility(8);
                    this.dZD.setVisibility(8);
                    this.dZB.setVisibility(8);
                    return;
                } else if (i < 10000) {
                    this.dZz.setVisibility(0);
                    this.dZC.setVisibility(0);
                    this.dZD.setVisibility(8);
                    this.dZB.setVisibility(8);
                    return;
                } else {
                    this.dZz.setVisibility(0);
                    this.dZC.setVisibility(0);
                    this.dZD.setVisibility(0);
                    this.dZB.setVisibility(0);
                    return;
                }
            }
            this.dZC.setText(c.g.swangame_game_ad_reward_tip);
            this.dZB.setVisibility(0);
            this.dZD.setVisibility(0);
            this.dZC.setVisibility(0);
        }
    }

    public boolean aUM() {
        return this.dZN;
    }
}
