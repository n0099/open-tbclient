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
/* loaded from: classes10.dex */
public abstract class b {
    private com.baidu.swan.apps.media.b.a bVg;
    private a.d dkJ;
    private RelativeLayout dkP;
    private RewardVideoView dkQ;
    private LinearLayout dkR;
    private ImageView dkS;
    private TextView dkT;
    private TextView dkU;
    private View dkV;
    private RelativeLayout dkW;
    private a.c dkY;
    private RewardLoadWebView dkZ;
    private AdElementInfo dkw;
    private RewardLoadWebView dla;
    private InteractiveEndFrameView dlb;
    private com.baidu.swan.game.ad.jsbridge.a dlc;
    private com.baidu.swan.game.ad.e.b dle;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    protected Resources mResources;
    private final Handler dkX = new Handler();
    private boolean dlf = false;
    private Runnable dlg = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bVg != null) {
                b.this.aIR();
                int currentPosition = b.this.bVg.getCurrentPosition();
                b.this.l(b.this.mDuration, currentPosition);
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.dkX.postDelayed(b.this.dlg, 100L);
                }
            }
        }
    };
    private View.OnClickListener dlh = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dkQ != null) {
                if (b.this.dkQ.isMute()) {
                    b.this.dkS.setImageResource(c.d.ng_game_vol_open);
                    b.this.dkQ.mute(false);
                    return;
                }
                b.this.dkS.setImageResource(c.d.ng_game_vol_close);
                b.this.dkQ.mute(true);
            }
        }
    };
    private View.OnClickListener dli = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dkY != null) {
                b.this.dkY.aD(view);
            }
        }
    };
    private View.OnClickListener dkM = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dkJ != null) {
                b.this.dkJ.aE(view);
            }
        }
    };
    public int bMz = com.baidu.swan.games.view.a.c.aRf();
    public int bMA = com.baidu.swan.games.view.a.c.aRg();
    private boolean dld = f.aKi();

    public abstract void a(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public abstract View aIN();

    public abstract String aIO();

    public b(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.jsbridge.a aVar) {
        this.mContext = context;
        this.dkw = adElementInfo;
        this.mResources = this.mContext.getResources();
        this.dlc = aVar;
        initView();
        this.dle = new com.baidu.swan.game.ad.e.b(this.mContext);
    }

    private void initView() {
        this.mConvertView = aIN();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bMz, this.bMA);
        this.mConvertView.setLayoutParams(layoutParams);
        this.dkP = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.dkQ = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.dkQ.setLayoutParams(layoutParams);
        if (this.dld) {
            this.dkQ.setOnClickListener(this.dkM);
        }
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.dkR = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.dkS = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.dkT = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.dkU = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.dkV = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.dkW = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.dkw.aJD())) {
            this.dkZ = new RewardLoadWebView(this.mContext);
            this.dkW.addView(this.dkZ, new RelativeLayout.LayoutParams(-1, -1));
            a(this.dkW, this.dkw);
            this.dkZ.a(aIO(), this.dkw, this.dlc);
        } else {
            View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_banner, (ViewGroup) null);
            this.dkW.addView(inflate);
            ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dkw.getIconUrl());
            ((TextView) inflate.findViewById(c.e.title)).setText(this.dkw.getTitle());
            ((TextView) inflate.findViewById(c.e.desc)).setText(this.dkw.getDescription());
            Button button = (Button) inflate.findViewById(c.e.download);
            if (this.dkw.getActionType() == 1) {
                button.setText(this.mContext.getResources().getString(c.g.see_detail));
            }
            if (this.dkw.getActionType() == 2) {
                button.setText(this.mContext.getResources().getString(c.g.down_immediately));
            }
            this.dkW.setOnClickListener(this.dkM);
            button.setOnClickListener(this.dkM);
        }
        this.bVg = this.dkQ.getPlayer();
        aIG();
    }

    private void aIG() {
        this.dkP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.dkS.setOnClickListener(this.dlh);
        this.dkT.setOnClickListener(this.dli);
    }

    public void a(a.c cVar) {
        this.dkY = cVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void bs(String str) {
        if (this.dkQ != null) {
            this.dkQ.bs(str);
        }
    }

    public com.baidu.swan.apps.media.b.a getPlayer() {
        if (this.dkQ != null) {
            return this.dkQ.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.dkX.removeCallbacksAndMessages(null);
            this.dkX.postDelayed(this.dlg, 0L);
        }
    }

    private void adk() {
        if (this.mProgressBar != null) {
            this.dkX.removeCallbacksAndMessages(null);
        }
    }

    public void aIH() {
        startTimer();
        if (this.mProgressBar != null && this.bVg != null) {
            this.mProgressBar.setMax(this.bVg.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.dkU != null && this.bVg != null && this.dkw != null) {
            this.dkU.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.dkw.aJy(), Math.min(this.dkw.aJx(), this.bVg.getDuration())) / 1000)));
            if (this.dkw.aJy() >= 0) {
                this.dkT.setVisibility(8);
                this.dkV.setVisibility(8);
            }
        }
        if (this.dkR.getVisibility() != 0) {
            this.dkR.setVisibility(0);
        }
        if (this.dkW.getVisibility() != 0) {
            this.dkW.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.dkW.setVisibility(0);
        }
        if (this.bVg != null) {
            l(this.bVg.getDuration(), this.bVg.getCurrentPosition());
        }
    }

    public void onPrepared() {
        if (this.bVg != null) {
            this.mDuration = this.bVg.getDuration();
        }
    }

    public void aII() {
        adk();
    }

    public void aIJ() {
        startTimer();
    }

    public void aIK() {
        adk();
        if (this.dkZ != null) {
            this.dkZ.destroy();
            this.dkZ = null;
        }
        if (this.dla != null) {
            this.dla.destroy();
            this.dla = null;
        }
        if (this.dlb != null) {
            this.dlb.destroy();
            this.dlb = null;
        }
    }

    public void aIL() {
        aIP();
        adk();
    }

    public void aIM() {
        aIP();
        adk();
    }

    private void aIP() {
        if (this.dkP != null) {
            this.dlf = true;
            this.dkR.setVisibility(4);
            this.dkW.setVisibility(4);
            this.dkT.setVisibility(4);
            if (!TextUtils.isEmpty(this.dkw.aJz())) {
                this.dlb = new InteractiveEndFrameView(this.mContext);
                this.dlb.a(this.dkw, this.dkP);
                this.dkP.addView(this.dlb, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dkw, this.dle);
            } else if (!TextUtils.isEmpty(this.dkw.aJF())) {
                this.dla = new RewardLoadWebView(this.mContext);
                this.dla.a("reward_end_frame_html", this.dkw, this.dlc);
                this.dkP.addView(this.dla, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dkw, this.dle);
            } else {
                View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_close_banner, (ViewGroup) null);
                this.dkP.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
                ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dkw.getIconUrl());
                ((TextView) inflate.findViewById(c.e.title)).setText(this.dkw.getTitle());
                ((TextView) inflate.findViewById(c.e.desc)).setText(this.dkw.getDescription());
                Button button = (Button) inflate.findViewById(c.e.download);
                if (this.dkw.getActionType() == 1) {
                    button.setText(this.mContext.getResources().getString(c.g.see_detail));
                }
                if (this.dkw.getActionType() == 2) {
                    button.setText(this.mContext.getResources().getString(c.g.down_immediately));
                }
                inflate.findViewById(c.e.content_des).setOnClickListener(this.dkM);
                button.setOnClickListener(this.dkM);
            }
            aIQ();
        }
    }

    private void aIQ() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.dli);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ah.dip2px(this.mContext, 96.0f), ah.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0476c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0476c.include_land_close_ad_margin), 0);
        this.dkP.addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIR() {
        if (this.dkw != null && this.bVg != null) {
            this.mDuration = this.bVg.getDuration();
            int min = Math.min(this.dkw.aJx(), this.mDuration / 1000);
            int aJy = this.dkw.aJy();
            int currentPosition = this.bVg.getCurrentPosition() / 1000;
            String string = this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus);
            String string2 = this.mContext.getResources().getString(c.g.swangame_game_ad_video_time_surplus);
            if (currentPosition <= min) {
                this.dkU.setText(String.format(string, Integer.valueOf(min - currentPosition)));
            } else {
                this.dkU.setText(String.format(string2, Integer.valueOf((this.mDuration / 1000) - currentPosition)));
            }
            if (currentPosition <= aJy) {
                this.dkT.setVisibility(8);
                this.dkV.setVisibility(8);
                return;
            }
            this.dkT.setVisibility(0);
            this.dkV.setVisibility(0);
        }
    }

    public void a(a.d dVar) {
        this.dkJ = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(long j, int i) {
        if (this.dld) {
            if (j > 15000 && i <= 15000) {
                if (i < 5000) {
                    this.dkR.setVisibility(8);
                    this.dkU.setVisibility(8);
                    this.dkV.setVisibility(8);
                    this.dkT.setVisibility(8);
                    return;
                } else if (i < 10000) {
                    this.dkR.setVisibility(0);
                    this.dkU.setVisibility(0);
                    this.dkV.setVisibility(8);
                    this.dkT.setVisibility(8);
                    return;
                } else {
                    this.dkR.setVisibility(0);
                    this.dkU.setVisibility(0);
                    this.dkV.setVisibility(0);
                    this.dkT.setVisibility(0);
                    return;
                }
            }
            this.dkU.setText(c.g.swangame_game_ad_reward_tip);
            this.dkT.setVisibility(0);
            this.dkV.setVisibility(0);
            this.dkU.setVisibility(0);
        }
    }

    public boolean aIS() {
        return this.dlf;
    }
}
