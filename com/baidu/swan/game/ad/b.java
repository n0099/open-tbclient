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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.component.RewardVideoView;
import com.baidu.swan.game.ad.d.f;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes14.dex */
public abstract class b {
    private com.baidu.swan.apps.media.b.a cBb;
    private RelativeLayout dQA;
    private RewardVideoView dQB;
    private LinearLayout dQC;
    private ImageView dQD;
    private TextView dQE;
    private TextView dQF;
    private View dQG;
    private RelativeLayout dQH;
    private a.c dQJ;
    private RewardLoadWebView dQK;
    private RewardLoadWebView dQL;
    private InteractiveEndFrameView dQM;
    private com.baidu.swan.game.ad.jsbridge.a dQN;
    private com.baidu.swan.game.ad.e.b dQP;
    private AdElementInfo dQh;
    private a.d dQu;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    protected Resources mResources;
    private final Handler dQI = new Handler();
    private boolean dQQ = false;
    private Runnable dQR = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cBb != null) {
                b.this.aSr();
                int currentPosition = b.this.cBb.getCurrentPosition();
                b.this.p(b.this.mDuration, currentPosition);
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.dQI.postDelayed(b.this.dQR, 100L);
                }
            }
        }
    };
    private View.OnClickListener dQS = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dQB != null) {
                if (b.this.dQB.isMute()) {
                    b.this.dQD.setImageResource(c.d.ng_game_vol_open);
                    b.this.dQB.mute(false);
                    return;
                }
                b.this.dQD.setImageResource(c.d.ng_game_vol_close);
                b.this.dQB.mute(true);
            }
        }
    };
    private View.OnClickListener dQT = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dQJ != null) {
                b.this.dQJ.aL(view);
            }
        }
    };
    private View.OnClickListener dQx = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dQu != null) {
                b.this.dQu.aM(view);
            }
        }
    };
    public int cmn = com.baidu.swan.games.view.a.c.baF();
    public int cmo = com.baidu.swan.games.view.a.c.baG();
    private boolean dQO = f.aTI();

    public abstract void a(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public abstract View aSn();

    public abstract String aSo();

    public b(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.jsbridge.a aVar) {
        this.mContext = context;
        this.dQh = adElementInfo;
        this.mResources = this.mContext.getResources();
        this.dQN = aVar;
        initView();
        this.dQP = new com.baidu.swan.game.ad.e.b(this.mContext);
    }

    private void initView() {
        this.mConvertView = aSn();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.cmn, this.cmo);
        this.mConvertView.setLayoutParams(layoutParams);
        this.dQA = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.dQB = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.dQB.setLayoutParams(layoutParams);
        if (this.dQO) {
            this.dQB.setOnClickListener(this.dQx);
        }
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.dQC = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.dQD = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.dQE = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.dQF = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.dQG = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.dQH = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.dQh.aTd())) {
            this.dQK = new RewardLoadWebView(this.mContext);
            this.dQH.addView(this.dQK, new RelativeLayout.LayoutParams(-1, -1));
            a(this.dQH, this.dQh);
            this.dQK.a(aSo(), this.dQh, this.dQN);
        } else {
            View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_banner, (ViewGroup) null);
            this.dQH.addView(inflate);
            ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dQh.getIconUrl());
            ((TextView) inflate.findViewById(c.e.title)).setText(this.dQh.getTitle());
            ((TextView) inflate.findViewById(c.e.desc)).setText(this.dQh.getDescription());
            Button button = (Button) inflate.findViewById(c.e.download);
            if (this.dQh.getActionType() == 1) {
                button.setText(this.mContext.getResources().getString(c.g.see_detail));
            }
            if (this.dQh.getActionType() == 2) {
                button.setText(this.mContext.getResources().getString(c.g.down_immediately));
            }
            this.dQH.setOnClickListener(this.dQx);
            button.setOnClickListener(this.dQx);
        }
        this.cBb = this.dQB.getPlayer();
        aSg();
    }

    private void aSg() {
        this.dQA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.dQD.setOnClickListener(this.dQS);
        this.dQE.setOnClickListener(this.dQT);
    }

    public void a(a.c cVar) {
        this.dQJ = cVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void bv(String str) {
        if (this.dQB != null) {
            this.dQB.bv(str);
        }
    }

    public com.baidu.swan.apps.media.b.a getPlayer() {
        if (this.dQB != null) {
            return this.dQB.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.dQI.removeCallbacksAndMessages(null);
            this.dQI.postDelayed(this.dQR, 0L);
        }
    }

    private void amQ() {
        if (this.mProgressBar != null) {
            this.dQI.removeCallbacksAndMessages(null);
        }
    }

    public void aSh() {
        startTimer();
        if (this.mProgressBar != null && this.cBb != null) {
            this.mProgressBar.setMax(this.cBb.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.dQF != null && this.cBb != null && this.dQh != null) {
            this.dQF.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.dQh.aSY(), Math.min(this.dQh.aSX(), this.cBb.getDuration())) / 1000)));
            if (this.dQh.aSY() >= 0) {
                this.dQE.setVisibility(8);
                this.dQG.setVisibility(8);
            }
        }
        if (this.dQC.getVisibility() != 0) {
            this.dQC.setVisibility(0);
        }
        if (this.dQH.getVisibility() != 0) {
            this.dQH.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.dQH.setVisibility(0);
        }
        if (this.cBb != null) {
            p(this.cBb.getDuration(), this.cBb.getCurrentPosition());
        }
    }

    public void onPrepared() {
        if (this.cBb != null) {
            this.mDuration = this.cBb.getDuration();
        }
    }

    public void aSi() {
        amQ();
    }

    public void aSj() {
        startTimer();
    }

    public void aSk() {
        amQ();
        if (this.dQK != null) {
            this.dQK.destroy();
            this.dQK = null;
        }
        if (this.dQL != null) {
            this.dQL.destroy();
            this.dQL = null;
        }
        if (this.dQM != null) {
            this.dQM.destroy();
            this.dQM = null;
        }
    }

    public void aSl() {
        aSp();
        amQ();
    }

    public void aSm() {
        aSp();
        amQ();
    }

    private void aSp() {
        if (this.dQA != null) {
            this.dQQ = true;
            this.dQC.setVisibility(4);
            this.dQH.setVisibility(4);
            this.dQE.setVisibility(4);
            if (!TextUtils.isEmpty(this.dQh.aSZ())) {
                this.dQM = new InteractiveEndFrameView(this.mContext);
                this.dQM.a(this.dQh, this.dQA);
                this.dQA.addView(this.dQM, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dQh, this.dQP);
            } else if (!TextUtils.isEmpty(this.dQh.aTf())) {
                this.dQL = new RewardLoadWebView(this.mContext);
                this.dQL.a("reward_end_frame_html", this.dQh, this.dQN);
                this.dQA.addView(this.dQL, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dQh, this.dQP);
            } else {
                View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_close_banner, (ViewGroup) null);
                this.dQA.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
                ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dQh.getIconUrl());
                ((TextView) inflate.findViewById(c.e.title)).setText(this.dQh.getTitle());
                ((TextView) inflate.findViewById(c.e.desc)).setText(this.dQh.getDescription());
                Button button = (Button) inflate.findViewById(c.e.download);
                if (this.dQh.getActionType() == 1) {
                    button.setText(this.mContext.getResources().getString(c.g.see_detail));
                }
                if (this.dQh.getActionType() == 2) {
                    button.setText(this.mContext.getResources().getString(c.g.down_immediately));
                }
                inflate.findViewById(c.e.content_des).setOnClickListener(this.dQx);
                button.setOnClickListener(this.dQx);
            }
            aSq();
        }
    }

    private void aSq() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.dQT);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ah.dip2px(this.mContext, 96.0f), ah.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0529c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0529c.include_land_close_ad_margin), 0);
        this.dQA.addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSr() {
        if (this.dQh != null && this.cBb != null) {
            this.mDuration = this.cBb.getDuration();
            int min = Math.min(this.dQh.aSX(), this.mDuration / 1000);
            int aSY = this.dQh.aSY();
            int currentPosition = this.cBb.getCurrentPosition() / 1000;
            String string = this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus);
            String string2 = this.mContext.getResources().getString(c.g.swangame_game_ad_video_time_surplus);
            if (currentPosition <= min) {
                this.dQF.setText(String.format(string, Integer.valueOf(min - currentPosition)));
            } else {
                this.dQF.setText(String.format(string2, Integer.valueOf((this.mDuration / 1000) - currentPosition)));
            }
            if (currentPosition <= aSY) {
                this.dQE.setVisibility(8);
                this.dQG.setVisibility(8);
                return;
            }
            this.dQE.setVisibility(0);
            this.dQG.setVisibility(0);
        }
    }

    public void a(a.d dVar) {
        this.dQu = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(long j, int i) {
        if (this.dQO) {
            if (j > 15000 && i <= 15000) {
                if (i < 5000) {
                    this.dQC.setVisibility(8);
                    this.dQF.setVisibility(8);
                    this.dQG.setVisibility(8);
                    this.dQE.setVisibility(8);
                    return;
                } else if (i < 10000) {
                    this.dQC.setVisibility(0);
                    this.dQF.setVisibility(0);
                    this.dQG.setVisibility(8);
                    this.dQE.setVisibility(8);
                    return;
                } else {
                    this.dQC.setVisibility(0);
                    this.dQF.setVisibility(0);
                    this.dQG.setVisibility(0);
                    this.dQE.setVisibility(0);
                    return;
                }
            }
            this.dQF.setText(c.g.swangame_game_ad_reward_tip);
            this.dQE.setVisibility(0);
            this.dQG.setVisibility(0);
            this.dQF.setVisibility(0);
        }
    }

    public boolean aSs() {
        return this.dQQ;
    }
}
