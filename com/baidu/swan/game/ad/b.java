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
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.component.RewardVideoView;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes11.dex */
public abstract class b implements com.baidu.swan.game.ad.b.d {
    private com.baidu.swan.apps.media.b.a bIb;
    private AdElementInfo cPP;
    private a.c cQb;
    private RelativeLayout cQf;
    private RewardVideoView cQg;
    private LinearLayout cQh;
    private ImageView cQi;
    private TextView cQj;
    private TextView cQk;
    private View cQl;
    private RelativeLayout cQm;
    private a.b cQo;
    private RewardLoadWebView cQp;
    private RewardLoadWebView cQq;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    private Resources mResources;
    private final Handler cQn = new Handler();
    private Runnable cQr = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bIb != null) {
                int currentPosition = b.this.bIb.getCurrentPosition();
                b.this.mDuration = b.this.bIb.getDuration();
                if (b.this.mDuration <= 15000 || currentPosition > 15000) {
                    b.this.cQl.setVisibility(8);
                    b.this.cQk.setVisibility(8);
                } else {
                    b.this.cQk.setText(String.format(b.this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(15 - (currentPosition / 1000))));
                }
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.cQn.postDelayed(b.this.cQr, 100L);
                }
            }
        }
    };
    private View.OnClickListener cQs = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cQg != null) {
                if (b.this.cQg.isMute()) {
                    b.this.cQi.setImageResource(c.d.ng_game_vol_open);
                    b.this.cQg.dW(false);
                    return;
                }
                b.this.cQi.setImageResource(c.d.ng_game_vol_close);
                b.this.cQg.dW(true);
            }
        }
    };
    private View.OnClickListener cQt = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.e.close_ad != view.getId() || b.this.bIb == null || b.this.mDuration <= 15000 || b.this.bIb.getCurrentPosition() <= 15000) {
                if (b.this.cQo != null) {
                    b.this.cQo.awm();
                    return;
                }
                return;
            }
            b.this.bIb.seekTo(b.this.mDuration);
        }
    };
    public int bzK = com.baidu.swan.games.view.a.c.aCG();
    public int bzL = com.baidu.swan.games.view.a.c.aCH();

    public abstract View avX();

    public b(Context context, AdElementInfo adElementInfo) {
        this.mContext = context;
        this.cPP = adElementInfo;
        this.mResources = this.mContext.getResources();
        initView();
    }

    private void initView() {
        this.mConvertView = avX();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bzK, this.bzL);
        this.mConvertView.setLayoutParams(layoutParams);
        this.cQf = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.cQg = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.cQg.setLayoutParams(layoutParams);
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.cQh = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.cQi = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.cQj = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.cQk = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.cQl = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.cQm = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.cPP.awi())) {
            this.cQp = new RewardLoadWebView(this.mContext);
            this.cQm.addView(this.cQp, new RelativeLayout.LayoutParams(-1, -1));
            this.cQp.a("reward_banner_html", this.cPP, this);
        }
        this.bIb = this.cQg.getPlayer();
        avR();
    }

    private void avR() {
        this.cQf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.cQi.setOnClickListener(this.cQs);
        this.cQj.setOnClickListener(this.cQt);
    }

    public void a(a.c cVar) {
        this.cQb = cVar;
    }

    public void a(a.b bVar) {
        this.cQo = bVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void bk(String str) {
        if (this.cQg != null) {
            this.cQg.bk(str);
        }
    }

    public com.baidu.swan.apps.media.b.a getPlayer() {
        if (this.cQg != null) {
            return this.cQg.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.cQn.removeCallbacksAndMessages(null);
            this.cQn.postDelayed(this.cQr, 0L);
        }
    }

    private void UI() {
        if (this.mProgressBar != null) {
            this.cQn.removeCallbacksAndMessages(null);
        }
    }

    public void avS() {
        startTimer();
        if (this.mProgressBar != null && this.bIb != null) {
            this.mProgressBar.setMax(this.bIb.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.cQk != null && this.bIb != null) {
            this.cQk.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(this.bIb.getDuration() / 1000)));
        }
        if (this.cQh.getVisibility() != 0) {
            this.cQh.setVisibility(0);
        }
        if (this.cQm.getVisibility() != 0) {
            this.cQm.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.cQm.setVisibility(0);
        }
    }

    public void onPrepared() {
        if (this.bIb != null) {
            this.mDuration = this.bIb.getDuration();
        }
    }

    public void avT() {
        UI();
    }

    public void avU() {
        startTimer();
    }

    public void avV() {
        UI();
        if (this.cQp != null) {
            this.cQp.destroy();
            this.cQp = null;
        }
        if (this.cQq != null) {
            this.cQq.destroy();
            this.cQq = null;
        }
    }

    public void avW() {
        avY();
        UI();
    }

    private void avY() {
        if (this.cQf != null) {
            this.cQh.setVisibility(4);
            this.cQm.setVisibility(4);
            this.cQj.setVisibility(4);
            if (!TextUtils.isEmpty(this.cPP.awj())) {
                this.cQq = new RewardLoadWebView(this.mContext);
                this.cQq.a("reward_end_frame_html", this.cPP, this);
                this.cQf.addView(this.cQq, new RelativeLayout.LayoutParams(-1, -1));
            }
            avZ();
        }
    }

    private void avZ() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.cQt);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ag.dip2px(this.mContext, 96.0f), ag.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0420c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0420c.include_land_close_ad_margin), 0);
        this.cQf.addView(textView, layoutParams);
    }

    @Override // com.baidu.swan.game.ad.b.d
    public void awa() {
        if (this.cQb != null) {
            this.cQb.pQ();
        }
    }
}
