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
    private com.baidu.swan.apps.media.b.a cFb;
    private AdElementInfo dXZ;
    private a.c dYD;
    private RewardLoadWebView dYE;
    private RewardLoadWebView dYF;
    private InteractiveEndFrameView dYG;
    private com.baidu.swan.game.ad.jsbridge.a dYH;
    private com.baidu.swan.game.ad.e.b dYJ;
    private a.d dYm;
    private RelativeLayout dYs;
    private RewardVideoView dYt;
    private LinearLayout dYu;
    private ImageView dYv;
    private TextView dYw;
    private TextView dYx;
    private View dYy;
    private RelativeLayout dYz;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    protected Resources mResources;
    private final Handler dYC = new Handler();
    private boolean dYK = false;
    private Runnable dYL = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cFb != null) {
                b.this.aRl();
                int currentPosition = b.this.cFb.getCurrentPosition();
                b.this.r(b.this.mDuration, currentPosition);
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.dYC.postDelayed(b.this.dYL, 100L);
                }
            }
        }
    };
    private View.OnClickListener dYM = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dYt != null) {
                if (b.this.dYt.isMute()) {
                    b.this.dYv.setImageResource(c.d.ng_game_vol_open);
                    b.this.dYt.mute(false);
                    return;
                }
                b.this.dYv.setImageResource(c.d.ng_game_vol_close);
                b.this.dYt.mute(true);
            }
        }
    };
    private View.OnClickListener dYN = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dYD != null) {
                b.this.dYD.aQ(view);
            }
        }
    };
    private View.OnClickListener dYp = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dYm != null) {
                b.this.dYm.aR(view);
            }
        }
    };
    public int dYA = com.baidu.swan.games.view.a.c.aZt();
    public int dYB = com.baidu.swan.games.view.a.c.aZu();
    private boolean dYI = f.aSy();

    public abstract void a(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public abstract View aRh();

    public abstract String aRi();

    public b(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.jsbridge.a aVar) {
        this.mContext = context;
        this.dXZ = adElementInfo;
        this.mResources = this.mContext.getResources();
        this.dYH = aVar;
        initView();
        this.dYJ = new com.baidu.swan.game.ad.e.b(this.mContext);
    }

    private void initView() {
        this.mConvertView = aRh();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.dYA, this.dYB);
        this.mConvertView.setLayoutParams(layoutParams);
        this.dYs = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.dYt = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.dYt.setLayoutParams(layoutParams);
        if (this.dYI) {
            this.dYt.setOnClickListener(this.dYp);
        }
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.dYu = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.dYv = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.dYw = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.dYx = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.dYy = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.dYz = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.dXZ.aRW())) {
            this.dYE = new RewardLoadWebView(this.mContext);
            this.dYz.addView(this.dYE, new RelativeLayout.LayoutParams(-1, -1));
            a(this.dYz, this.dXZ);
            this.dYE.a(aRi(), this.dXZ, this.dYH);
        } else {
            View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_banner, (ViewGroup) null);
            this.dYz.addView(inflate);
            ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dXZ.getIconUrl());
            ((TextView) inflate.findViewById(c.e.title)).setText(this.dXZ.getTitle());
            ((TextView) inflate.findViewById(c.e.desc)).setText(this.dXZ.getDescription());
            Button button = (Button) inflate.findViewById(c.e.download);
            if (this.dXZ.getActionType() == 1) {
                button.setText(this.mContext.getResources().getString(c.g.see_detail));
            }
            if (this.dXZ.getActionType() == 2) {
                button.setText(this.mContext.getResources().getString(c.g.down_immediately));
            }
            this.dYz.setOnClickListener(this.dYp);
            button.setOnClickListener(this.dYp);
        }
        this.cFb = this.dYt.getPlayer();
        aRd();
    }

    private void aRd() {
        this.dYs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.dYv.setOnClickListener(this.dYM);
        this.dYw.setOnClickListener(this.dYN);
    }

    public void a(a.c cVar) {
        this.dYD = cVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void start(String str) {
        if (this.dYt != null) {
            this.dYt.start(str);
        }
    }

    public com.baidu.swan.apps.media.b.a getPlayer() {
        if (this.dYt != null) {
            return this.dYt.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.dYC.removeCallbacksAndMessages(null);
            this.dYC.postDelayed(this.dYL, 0L);
        }
    }

    private void akI() {
        if (this.mProgressBar != null) {
            this.dYC.removeCallbacksAndMessages(null);
        }
    }

    public void aRe() {
        startTimer();
        if (this.mProgressBar != null && this.cFb != null) {
            this.mProgressBar.setMax(this.cFb.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.dYx != null && this.cFb != null && this.dXZ != null) {
            this.dYx.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.dXZ.aRS(), Math.min(this.dXZ.aRR(), this.cFb.getDuration())) / 1000)));
            if (this.dXZ.aRS() >= 0) {
                this.dYw.setVisibility(8);
                this.dYy.setVisibility(8);
            }
        }
        if (this.dYu.getVisibility() != 0) {
            this.dYu.setVisibility(0);
        }
        if (this.dYz.getVisibility() != 0) {
            this.dYz.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.dYz.setVisibility(0);
        }
        if (this.cFb != null) {
            r(this.cFb.getDuration(), this.cFb.getCurrentPosition());
        }
    }

    public void onPrepared() {
        if (this.cFb != null) {
            this.mDuration = this.cFb.getDuration();
        }
    }

    public void pausePlay() {
        akI();
    }

    public void resumePlay() {
        startTimer();
    }

    public void aRf() {
        akI();
        if (this.dYE != null) {
            this.dYE.destroy();
            this.dYE = null;
        }
        if (this.dYF != null) {
            this.dYF.destroy();
            this.dYF = null;
        }
        if (this.dYG != null) {
            this.dYG.destroy();
            this.dYG = null;
        }
    }

    public void playCompletion() {
        aRj();
        akI();
    }

    public void aRg() {
        aRj();
        akI();
    }

    private void aRj() {
        if (this.dYs != null) {
            this.dYK = true;
            this.dYu.setVisibility(4);
            this.dYz.setVisibility(4);
            this.dYw.setVisibility(4);
            if (!TextUtils.isEmpty(this.dXZ.aRT())) {
                this.dYG = new InteractiveEndFrameView(this.mContext);
                this.dYG.a(this.dXZ, this.dYs);
                this.dYs.addView(this.dYG, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dXZ, this.dYJ);
            } else if (!TextUtils.isEmpty(this.dXZ.aRY())) {
                this.dYF = new RewardLoadWebView(this.mContext);
                this.dYF.a("reward_end_frame_html", this.dXZ, this.dYH);
                this.dYs.addView(this.dYF, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dXZ, this.dYJ);
            } else {
                View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_close_banner, (ViewGroup) null);
                this.dYs.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
                ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dXZ.getIconUrl());
                ((TextView) inflate.findViewById(c.e.title)).setText(this.dXZ.getTitle());
                ((TextView) inflate.findViewById(c.e.desc)).setText(this.dXZ.getDescription());
                Button button = (Button) inflate.findViewById(c.e.download);
                if (this.dXZ.getActionType() == 1) {
                    button.setText(this.mContext.getResources().getString(c.g.see_detail));
                }
                if (this.dXZ.getActionType() == 2) {
                    button.setText(this.mContext.getResources().getString(c.g.down_immediately));
                }
                inflate.findViewById(c.e.content_des).setOnClickListener(this.dYp);
                button.setOnClickListener(this.dYp);
            }
            aRk();
        }
    }

    private void aRk() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.dYN);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ah.dip2px(this.mContext, 96.0f), ah.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0508c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0508c.include_land_close_ad_margin), 0);
        this.dYs.addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRl() {
        if (this.dXZ != null && this.cFb != null) {
            this.mDuration = this.cFb.getDuration();
            int min = Math.min(this.dXZ.aRR(), this.mDuration / 1000);
            int aRS = this.dXZ.aRS();
            int currentPosition = this.cFb.getCurrentPosition() / 1000;
            String string = this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus);
            String string2 = this.mContext.getResources().getString(c.g.swangame_game_ad_video_time_surplus);
            if (currentPosition <= min) {
                this.dYx.setText(String.format(string, Integer.valueOf(min - currentPosition)));
            } else {
                this.dYx.setText(String.format(string2, Integer.valueOf((this.mDuration / 1000) - currentPosition)));
            }
            if (currentPosition <= aRS) {
                this.dYw.setVisibility(8);
                this.dYy.setVisibility(8);
                return;
            }
            this.dYw.setVisibility(0);
            this.dYy.setVisibility(0);
        }
    }

    public void a(a.d dVar) {
        this.dYm = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j, int i) {
        if (this.dYI) {
            if (j > 15000 && i <= 15000) {
                if (i < 5000) {
                    this.dYu.setVisibility(8);
                    this.dYx.setVisibility(8);
                    this.dYy.setVisibility(8);
                    this.dYw.setVisibility(8);
                    return;
                } else if (i < 10000) {
                    this.dYu.setVisibility(0);
                    this.dYx.setVisibility(0);
                    this.dYy.setVisibility(8);
                    this.dYw.setVisibility(8);
                    return;
                } else {
                    this.dYu.setVisibility(0);
                    this.dYx.setVisibility(0);
                    this.dYy.setVisibility(0);
                    this.dYw.setVisibility(0);
                    return;
                }
            }
            this.dYx.setText(c.g.swangame_game_ad_reward_tip);
            this.dYw.setVisibility(0);
            this.dYy.setVisibility(0);
            this.dYx.setVisibility(0);
        }
    }

    public boolean aRm() {
        return this.dYK;
    }
}
