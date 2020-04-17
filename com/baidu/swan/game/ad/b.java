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
import com.baidu.swan.apps.as.af;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.component.RewardVideoView;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes11.dex */
public abstract class b implements com.baidu.swan.game.ad.b.d {
    private com.baidu.swan.apps.media.c.a bAi;
    private a.c cFL;
    private RelativeLayout cFP;
    private RewardVideoView cFQ;
    private LinearLayout cFR;
    private ImageView cFS;
    private TextView cFT;
    private TextView cFU;
    private View cFV;
    private RelativeLayout cFW;
    private a.b cFY;
    private RewardLoadWebView cFZ;
    private AdElementInfo cFz;
    private RewardLoadWebView cGa;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    private Resources mResources;
    private final Handler cFX = new Handler();
    private Runnable cGb = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bAi != null) {
                int currentPosition = b.this.bAi.getCurrentPosition();
                b.this.mDuration = b.this.bAi.getDuration();
                if (b.this.mDuration <= 15000 || currentPosition > 15000) {
                    b.this.cFV.setVisibility(8);
                    b.this.cFU.setVisibility(8);
                } else {
                    b.this.cFU.setText(String.format(b.this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(15 - (currentPosition / 1000))));
                }
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.cFX.postDelayed(b.this.cGb, 100L);
                }
            }
        }
    };
    private View.OnClickListener cGc = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cFQ != null) {
                if (b.this.cFQ.isMute()) {
                    b.this.cFS.setImageResource(c.d.ng_game_vol_open);
                    b.this.cFQ.dG(false);
                    return;
                }
                b.this.cFS.setImageResource(c.d.ng_game_vol_close);
                b.this.cFQ.dG(true);
            }
        }
    };
    private View.OnClickListener cGd = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.e.close_ad != view.getId() || b.this.bAi == null || b.this.mDuration <= 15000 || b.this.bAi.getCurrentPosition() <= 15000) {
                if (b.this.cFY != null) {
                    b.this.cFY.asG();
                    return;
                }
                return;
            }
            b.this.bAi.seekTo(b.this.mDuration);
        }
    };
    public int bsd = com.baidu.swan.games.view.a.c.ayO();
    public int bse = com.baidu.swan.games.view.a.c.ayP();

    public abstract View asr();

    public b(Context context, AdElementInfo adElementInfo) {
        this.mContext = context;
        this.cFz = adElementInfo;
        this.mResources = this.mContext.getResources();
        initView();
    }

    private void initView() {
        this.mConvertView = asr();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bsd, this.bse);
        this.mConvertView.setLayoutParams(layoutParams);
        this.cFP = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.cFQ = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.cFQ.setLayoutParams(layoutParams);
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.cFR = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.cFS = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.cFT = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.cFU = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.cFV = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.cFW = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.cFz.asC())) {
            this.cFZ = new RewardLoadWebView(this.mContext);
            this.cFW.addView(this.cFZ, new RelativeLayout.LayoutParams(-1, -1));
            this.cFZ.a("reward_banner_html", this.cFz, this);
        }
        this.bAi = this.cFQ.getPlayer();
        ask();
    }

    private void ask() {
        this.cFP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.cFS.setOnClickListener(this.cGc);
        this.cFT.setOnClickListener(this.cGd);
    }

    public void a(a.c cVar) {
        this.cFL = cVar;
    }

    public void a(a.b bVar) {
        this.cFY = bVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void bk(String str) {
        if (this.cFQ != null) {
            this.cFQ.bk(str);
        }
    }

    public com.baidu.swan.apps.media.c.a getPlayer() {
        if (this.cFQ != null) {
            return this.cFQ.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.cFX.removeCallbacksAndMessages(null);
            this.cFX.postDelayed(this.cGb, 0L);
        }
    }

    private void RX() {
        if (this.mProgressBar != null) {
            this.cFX.removeCallbacksAndMessages(null);
        }
    }

    public void asl() {
        startTimer();
        if (this.mProgressBar != null && this.bAi != null) {
            this.mProgressBar.setMax(this.bAi.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.cFU != null && this.bAi != null) {
            this.cFU.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(this.bAi.getDuration() / 1000)));
        }
        if (this.cFR.getVisibility() != 0) {
            this.cFR.setVisibility(0);
        }
        if (this.cFW.getVisibility() != 0) {
            this.cFW.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.cFW.setVisibility(0);
        }
    }

    public void onPrepared() {
        if (this.bAi != null) {
            this.mDuration = this.bAi.getDuration();
        }
    }

    public void asn() {
        RX();
    }

    public void aso() {
        startTimer();
    }

    public void asp() {
        RX();
        if (this.cFZ != null) {
            this.cFZ.destroy();
            this.cFZ = null;
        }
        if (this.cGa != null) {
            this.cGa.destroy();
            this.cGa = null;
        }
    }

    public void asq() {
        ass();
        RX();
    }

    private void ass() {
        if (this.cFP != null) {
            this.cFR.setVisibility(4);
            this.cFW.setVisibility(4);
            this.cFT.setVisibility(4);
            if (!TextUtils.isEmpty(this.cFz.asD())) {
                this.cGa = new RewardLoadWebView(this.mContext);
                this.cGa.a("reward_end_frame_html", this.cFz, this);
                this.cFP.addView(this.cGa, new RelativeLayout.LayoutParams(-1, -1));
            }
            ast();
        }
    }

    private void ast() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.cGd);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(af.dip2px(this.mContext, 96.0f), af.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0359c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0359c.include_land_close_ad_margin), 0);
        this.cFP.addView(textView, layoutParams);
    }

    @Override // com.baidu.swan.game.ad.b.d
    public void asu() {
        if (this.cFL != null) {
            this.cFL.pK();
        }
    }
}
