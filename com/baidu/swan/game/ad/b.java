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
    private com.baidu.swan.apps.media.b.a cvT;
    private AdElementInfo dKR;
    private a.d dLe;
    private RelativeLayout dLk;
    private RewardVideoView dLl;
    private LinearLayout dLm;
    private ImageView dLn;
    private TextView dLo;
    private TextView dLp;
    private View dLq;
    private RelativeLayout dLr;
    private a.c dLt;
    private RewardLoadWebView dLu;
    private RewardLoadWebView dLv;
    private InteractiveEndFrameView dLw;
    private com.baidu.swan.game.ad.jsbridge.a dLx;
    private com.baidu.swan.game.ad.e.b dLz;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    protected Resources mResources;
    private final Handler dLs = new Handler();
    private boolean dLA = false;
    private Runnable dLB = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cvT != null) {
                b.this.aPU();
                int currentPosition = b.this.cvT.getCurrentPosition();
                b.this.p(b.this.mDuration, currentPosition);
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.dLs.postDelayed(b.this.dLB, 100L);
                }
            }
        }
    };
    private View.OnClickListener dLC = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dLl != null) {
                if (b.this.dLl.isMute()) {
                    b.this.dLn.setImageResource(c.d.ng_game_vol_open);
                    b.this.dLl.mute(false);
                    return;
                }
                b.this.dLn.setImageResource(c.d.ng_game_vol_close);
                b.this.dLl.mute(true);
            }
        }
    };
    private View.OnClickListener dLD = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dLt != null) {
                b.this.dLt.aJ(view);
            }
        }
    };
    private View.OnClickListener dLh = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dLe != null) {
                b.this.dLe.aK(view);
            }
        }
    };
    public int chr = com.baidu.swan.games.view.a.c.aYi();
    public int chs = com.baidu.swan.games.view.a.c.aYj();
    private boolean dLy = f.aRl();

    public abstract void a(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public abstract View aPQ();

    public abstract String aPR();

    public b(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.jsbridge.a aVar) {
        this.mContext = context;
        this.dKR = adElementInfo;
        this.mResources = this.mContext.getResources();
        this.dLx = aVar;
        initView();
        this.dLz = new com.baidu.swan.game.ad.e.b(this.mContext);
    }

    private void initView() {
        this.mConvertView = aPQ();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.chr, this.chs);
        this.mConvertView.setLayoutParams(layoutParams);
        this.dLk = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.dLl = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.dLl.setLayoutParams(layoutParams);
        if (this.dLy) {
            this.dLl.setOnClickListener(this.dLh);
        }
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.dLm = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.dLn = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.dLo = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.dLp = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.dLq = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.dLr = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.dKR.aQG())) {
            this.dLu = new RewardLoadWebView(this.mContext);
            this.dLr.addView(this.dLu, new RelativeLayout.LayoutParams(-1, -1));
            a(this.dLr, this.dKR);
            this.dLu.a(aPR(), this.dKR, this.dLx);
        } else {
            View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_banner, (ViewGroup) null);
            this.dLr.addView(inflate);
            ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dKR.getIconUrl());
            ((TextView) inflate.findViewById(c.e.title)).setText(this.dKR.getTitle());
            ((TextView) inflate.findViewById(c.e.desc)).setText(this.dKR.getDescription());
            Button button = (Button) inflate.findViewById(c.e.download);
            if (this.dKR.getActionType() == 1) {
                button.setText(this.mContext.getResources().getString(c.g.see_detail));
            }
            if (this.dKR.getActionType() == 2) {
                button.setText(this.mContext.getResources().getString(c.g.down_immediately));
            }
            this.dLr.setOnClickListener(this.dLh);
            button.setOnClickListener(this.dLh);
        }
        this.cvT = this.dLl.getPlayer();
        aPJ();
    }

    private void aPJ() {
        this.dLk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.dLn.setOnClickListener(this.dLC);
        this.dLo.setOnClickListener(this.dLD);
    }

    public void a(a.c cVar) {
        this.dLt = cVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void bs(String str) {
        if (this.dLl != null) {
            this.dLl.bs(str);
        }
    }

    public com.baidu.swan.apps.media.b.a getPlayer() {
        if (this.dLl != null) {
            return this.dLl.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.dLs.removeCallbacksAndMessages(null);
            this.dLs.postDelayed(this.dLB, 0L);
        }
    }

    private void akq() {
        if (this.mProgressBar != null) {
            this.dLs.removeCallbacksAndMessages(null);
        }
    }

    public void aPK() {
        startTimer();
        if (this.mProgressBar != null && this.cvT != null) {
            this.mProgressBar.setMax(this.cvT.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.dLp != null && this.cvT != null && this.dKR != null) {
            this.dLp.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.dKR.aQB(), Math.min(this.dKR.aQA(), this.cvT.getDuration())) / 1000)));
            if (this.dKR.aQB() >= 0) {
                this.dLo.setVisibility(8);
                this.dLq.setVisibility(8);
            }
        }
        if (this.dLm.getVisibility() != 0) {
            this.dLm.setVisibility(0);
        }
        if (this.dLr.getVisibility() != 0) {
            this.dLr.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.dLr.setVisibility(0);
        }
        if (this.cvT != null) {
            p(this.cvT.getDuration(), this.cvT.getCurrentPosition());
        }
    }

    public void onPrepared() {
        if (this.cvT != null) {
            this.mDuration = this.cvT.getDuration();
        }
    }

    public void aPL() {
        akq();
    }

    public void aPM() {
        startTimer();
    }

    public void aPN() {
        akq();
        if (this.dLu != null) {
            this.dLu.destroy();
            this.dLu = null;
        }
        if (this.dLv != null) {
            this.dLv.destroy();
            this.dLv = null;
        }
        if (this.dLw != null) {
            this.dLw.destroy();
            this.dLw = null;
        }
    }

    public void aPO() {
        aPS();
        akq();
    }

    public void aPP() {
        aPS();
        akq();
    }

    private void aPS() {
        if (this.dLk != null) {
            this.dLA = true;
            this.dLm.setVisibility(4);
            this.dLr.setVisibility(4);
            this.dLo.setVisibility(4);
            if (!TextUtils.isEmpty(this.dKR.aQC())) {
                this.dLw = new InteractiveEndFrameView(this.mContext);
                this.dLw.a(this.dKR, this.dLk);
                this.dLk.addView(this.dLw, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dKR, this.dLz);
            } else if (!TextUtils.isEmpty(this.dKR.aQI())) {
                this.dLv = new RewardLoadWebView(this.mContext);
                this.dLv.a("reward_end_frame_html", this.dKR, this.dLx);
                this.dLk.addView(this.dLv, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dKR, this.dLz);
            } else {
                View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_close_banner, (ViewGroup) null);
                this.dLk.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
                ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dKR.getIconUrl());
                ((TextView) inflate.findViewById(c.e.title)).setText(this.dKR.getTitle());
                ((TextView) inflate.findViewById(c.e.desc)).setText(this.dKR.getDescription());
                Button button = (Button) inflate.findViewById(c.e.download);
                if (this.dKR.getActionType() == 1) {
                    button.setText(this.mContext.getResources().getString(c.g.see_detail));
                }
                if (this.dKR.getActionType() == 2) {
                    button.setText(this.mContext.getResources().getString(c.g.down_immediately));
                }
                inflate.findViewById(c.e.content_des).setOnClickListener(this.dLh);
                button.setOnClickListener(this.dLh);
            }
            aPT();
        }
    }

    private void aPT() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.dLD);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ah.dip2px(this.mContext, 96.0f), ah.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0519c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0519c.include_land_close_ad_margin), 0);
        this.dLk.addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPU() {
        if (this.dKR != null && this.cvT != null) {
            this.mDuration = this.cvT.getDuration();
            int min = Math.min(this.dKR.aQA(), this.mDuration / 1000);
            int aQB = this.dKR.aQB();
            int currentPosition = this.cvT.getCurrentPosition() / 1000;
            String string = this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus);
            String string2 = this.mContext.getResources().getString(c.g.swangame_game_ad_video_time_surplus);
            if (currentPosition <= min) {
                this.dLp.setText(String.format(string, Integer.valueOf(min - currentPosition)));
            } else {
                this.dLp.setText(String.format(string2, Integer.valueOf((this.mDuration / 1000) - currentPosition)));
            }
            if (currentPosition <= aQB) {
                this.dLo.setVisibility(8);
                this.dLq.setVisibility(8);
                return;
            }
            this.dLo.setVisibility(0);
            this.dLq.setVisibility(0);
        }
    }

    public void a(a.d dVar) {
        this.dLe = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(long j, int i) {
        if (this.dLy) {
            if (j > 15000 && i <= 15000) {
                if (i < 5000) {
                    this.dLm.setVisibility(8);
                    this.dLp.setVisibility(8);
                    this.dLq.setVisibility(8);
                    this.dLo.setVisibility(8);
                    return;
                } else if (i < 10000) {
                    this.dLm.setVisibility(0);
                    this.dLp.setVisibility(0);
                    this.dLq.setVisibility(8);
                    this.dLo.setVisibility(8);
                    return;
                } else {
                    this.dLm.setVisibility(0);
                    this.dLp.setVisibility(0);
                    this.dLq.setVisibility(0);
                    this.dLo.setVisibility(0);
                    return;
                }
            }
            this.dLp.setText(c.g.swangame_game_ad_reward_tip);
            this.dLo.setVisibility(0);
            this.dLq.setVisibility(0);
            this.dLp.setVisibility(0);
        }
    }

    public boolean aPV() {
        return this.dLA;
    }
}
