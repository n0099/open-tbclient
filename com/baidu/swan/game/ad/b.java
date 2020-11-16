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
/* loaded from: classes12.dex */
public abstract class b {
    private com.baidu.swan.apps.media.b.a cuh;
    private RelativeLayout dJC;
    private RewardVideoView dJD;
    private LinearLayout dJE;
    private ImageView dJF;
    private TextView dJG;
    private TextView dJH;
    private View dJI;
    private RelativeLayout dJJ;
    private a.c dJL;
    private RewardLoadWebView dJM;
    private RewardLoadWebView dJN;
    private InteractiveEndFrameView dJO;
    private com.baidu.swan.game.ad.jsbridge.a dJP;
    private com.baidu.swan.game.ad.e.b dJR;
    private AdElementInfo dJj;
    private a.d dJw;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    protected Resources mResources;
    private final Handler dJK = new Handler();
    private boolean dJS = false;
    private Runnable dJT = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cuh != null) {
                b.this.aPm();
                int currentPosition = b.this.cuh.getCurrentPosition();
                b.this.p(b.this.mDuration, currentPosition);
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.dJK.postDelayed(b.this.dJT, 100L);
                }
            }
        }
    };
    private View.OnClickListener dJU = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dJD != null) {
                if (b.this.dJD.isMute()) {
                    b.this.dJF.setImageResource(c.d.ng_game_vol_open);
                    b.this.dJD.mute(false);
                    return;
                }
                b.this.dJF.setImageResource(c.d.ng_game_vol_close);
                b.this.dJD.mute(true);
            }
        }
    };
    private View.OnClickListener dJV = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dJL != null) {
                b.this.dJL.aJ(view);
            }
        }
    };
    private View.OnClickListener dJz = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dJw != null) {
                b.this.dJw.aK(view);
            }
        }
    };
    public int cfG = com.baidu.swan.games.view.a.c.aXA();
    public int cfH = com.baidu.swan.games.view.a.c.aXB();
    private boolean dJQ = f.aQD();

    public abstract void a(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public abstract View aPi();

    public abstract String aPj();

    public b(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.jsbridge.a aVar) {
        this.mContext = context;
        this.dJj = adElementInfo;
        this.mResources = this.mContext.getResources();
        this.dJP = aVar;
        initView();
        this.dJR = new com.baidu.swan.game.ad.e.b(this.mContext);
    }

    private void initView() {
        this.mConvertView = aPi();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.cfG, this.cfH);
        this.mConvertView.setLayoutParams(layoutParams);
        this.dJC = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.dJD = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.dJD.setLayoutParams(layoutParams);
        if (this.dJQ) {
            this.dJD.setOnClickListener(this.dJz);
        }
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.dJE = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.dJF = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.dJG = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.dJH = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.dJI = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.dJJ = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.dJj.aPY())) {
            this.dJM = new RewardLoadWebView(this.mContext);
            this.dJJ.addView(this.dJM, new RelativeLayout.LayoutParams(-1, -1));
            a(this.dJJ, this.dJj);
            this.dJM.a(aPj(), this.dJj, this.dJP);
        } else {
            View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_banner, (ViewGroup) null);
            this.dJJ.addView(inflate);
            ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dJj.getIconUrl());
            ((TextView) inflate.findViewById(c.e.title)).setText(this.dJj.getTitle());
            ((TextView) inflate.findViewById(c.e.desc)).setText(this.dJj.getDescription());
            Button button = (Button) inflate.findViewById(c.e.download);
            if (this.dJj.getActionType() == 1) {
                button.setText(this.mContext.getResources().getString(c.g.see_detail));
            }
            if (this.dJj.getActionType() == 2) {
                button.setText(this.mContext.getResources().getString(c.g.down_immediately));
            }
            this.dJJ.setOnClickListener(this.dJz);
            button.setOnClickListener(this.dJz);
        }
        this.cuh = this.dJD.getPlayer();
        aPb();
    }

    private void aPb() {
        this.dJC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.dJF.setOnClickListener(this.dJU);
        this.dJG.setOnClickListener(this.dJV);
    }

    public void a(a.c cVar) {
        this.dJL = cVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void bs(String str) {
        if (this.dJD != null) {
            this.dJD.bs(str);
        }
    }

    public com.baidu.swan.apps.media.b.a getPlayer() {
        if (this.dJD != null) {
            return this.dJD.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.dJK.removeCallbacksAndMessages(null);
            this.dJK.postDelayed(this.dJT, 0L);
        }
    }

    private void ajI() {
        if (this.mProgressBar != null) {
            this.dJK.removeCallbacksAndMessages(null);
        }
    }

    public void aPc() {
        startTimer();
        if (this.mProgressBar != null && this.cuh != null) {
            this.mProgressBar.setMax(this.cuh.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.dJH != null && this.cuh != null && this.dJj != null) {
            this.dJH.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.dJj.aPT(), Math.min(this.dJj.aPS(), this.cuh.getDuration())) / 1000)));
            if (this.dJj.aPT() >= 0) {
                this.dJG.setVisibility(8);
                this.dJI.setVisibility(8);
            }
        }
        if (this.dJE.getVisibility() != 0) {
            this.dJE.setVisibility(0);
        }
        if (this.dJJ.getVisibility() != 0) {
            this.dJJ.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.dJJ.setVisibility(0);
        }
        if (this.cuh != null) {
            p(this.cuh.getDuration(), this.cuh.getCurrentPosition());
        }
    }

    public void onPrepared() {
        if (this.cuh != null) {
            this.mDuration = this.cuh.getDuration();
        }
    }

    public void aPd() {
        ajI();
    }

    public void aPe() {
        startTimer();
    }

    public void aPf() {
        ajI();
        if (this.dJM != null) {
            this.dJM.destroy();
            this.dJM = null;
        }
        if (this.dJN != null) {
            this.dJN.destroy();
            this.dJN = null;
        }
        if (this.dJO != null) {
            this.dJO.destroy();
            this.dJO = null;
        }
    }

    public void aPg() {
        aPk();
        ajI();
    }

    public void aPh() {
        aPk();
        ajI();
    }

    private void aPk() {
        if (this.dJC != null) {
            this.dJS = true;
            this.dJE.setVisibility(4);
            this.dJJ.setVisibility(4);
            this.dJG.setVisibility(4);
            if (!TextUtils.isEmpty(this.dJj.aPU())) {
                this.dJO = new InteractiveEndFrameView(this.mContext);
                this.dJO.a(this.dJj, this.dJC);
                this.dJC.addView(this.dJO, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dJj, this.dJR);
            } else if (!TextUtils.isEmpty(this.dJj.aQa())) {
                this.dJN = new RewardLoadWebView(this.mContext);
                this.dJN.a("reward_end_frame_html", this.dJj, this.dJP);
                this.dJC.addView(this.dJN, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dJj, this.dJR);
            } else {
                View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_close_banner, (ViewGroup) null);
                this.dJC.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
                ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dJj.getIconUrl());
                ((TextView) inflate.findViewById(c.e.title)).setText(this.dJj.getTitle());
                ((TextView) inflate.findViewById(c.e.desc)).setText(this.dJj.getDescription());
                Button button = (Button) inflate.findViewById(c.e.download);
                if (this.dJj.getActionType() == 1) {
                    button.setText(this.mContext.getResources().getString(c.g.see_detail));
                }
                if (this.dJj.getActionType() == 2) {
                    button.setText(this.mContext.getResources().getString(c.g.down_immediately));
                }
                inflate.findViewById(c.e.content_des).setOnClickListener(this.dJz);
                button.setOnClickListener(this.dJz);
            }
            aPl();
        }
    }

    private void aPl() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.dJV);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ah.dip2px(this.mContext, 96.0f), ah.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0517c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0517c.include_land_close_ad_margin), 0);
        this.dJC.addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPm() {
        if (this.dJj != null && this.cuh != null) {
            this.mDuration = this.cuh.getDuration();
            int min = Math.min(this.dJj.aPS(), this.mDuration / 1000);
            int aPT = this.dJj.aPT();
            int currentPosition = this.cuh.getCurrentPosition() / 1000;
            String string = this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus);
            String string2 = this.mContext.getResources().getString(c.g.swangame_game_ad_video_time_surplus);
            if (currentPosition <= min) {
                this.dJH.setText(String.format(string, Integer.valueOf(min - currentPosition)));
            } else {
                this.dJH.setText(String.format(string2, Integer.valueOf((this.mDuration / 1000) - currentPosition)));
            }
            if (currentPosition <= aPT) {
                this.dJG.setVisibility(8);
                this.dJI.setVisibility(8);
                return;
            }
            this.dJG.setVisibility(0);
            this.dJI.setVisibility(0);
        }
    }

    public void a(a.d dVar) {
        this.dJw = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(long j, int i) {
        if (this.dJQ) {
            if (j > 15000 && i <= 15000) {
                if (i < 5000) {
                    this.dJE.setVisibility(8);
                    this.dJH.setVisibility(8);
                    this.dJI.setVisibility(8);
                    this.dJG.setVisibility(8);
                    return;
                } else if (i < 10000) {
                    this.dJE.setVisibility(0);
                    this.dJH.setVisibility(0);
                    this.dJI.setVisibility(8);
                    this.dJG.setVisibility(8);
                    return;
                } else {
                    this.dJE.setVisibility(0);
                    this.dJH.setVisibility(0);
                    this.dJI.setVisibility(0);
                    this.dJG.setVisibility(0);
                    return;
                }
            }
            this.dJH.setText(c.g.swangame_game_ad_reward_tip);
            this.dJG.setVisibility(0);
            this.dJI.setVisibility(0);
            this.dJH.setVisibility(0);
        }
    }

    public boolean aPn() {
        return this.dJS;
    }
}
