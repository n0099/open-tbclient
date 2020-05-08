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
    private com.baidu.swan.apps.media.c.a bAn;
    private AdElementInfo cFF;
    private a.c cFR;
    private RelativeLayout cFV;
    private RewardVideoView cFW;
    private LinearLayout cFX;
    private ImageView cFY;
    private TextView cFZ;
    private TextView cGa;
    private View cGb;
    private RelativeLayout cGc;
    private a.b cGe;
    private RewardLoadWebView cGf;
    private RewardLoadWebView cGg;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    private Resources mResources;
    private final Handler cGd = new Handler();
    private Runnable cGh = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bAn != null) {
                int currentPosition = b.this.bAn.getCurrentPosition();
                b.this.mDuration = b.this.bAn.getDuration();
                if (b.this.mDuration <= 15000 || currentPosition > 15000) {
                    b.this.cGb.setVisibility(8);
                    b.this.cGa.setVisibility(8);
                } else {
                    b.this.cGa.setText(String.format(b.this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(15 - (currentPosition / 1000))));
                }
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.cGd.postDelayed(b.this.cGh, 100L);
                }
            }
        }
    };
    private View.OnClickListener cGi = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cFW != null) {
                if (b.this.cFW.isMute()) {
                    b.this.cFY.setImageResource(c.d.ng_game_vol_open);
                    b.this.cFW.dG(false);
                    return;
                }
                b.this.cFY.setImageResource(c.d.ng_game_vol_close);
                b.this.cFW.dG(true);
            }
        }
    };
    private View.OnClickListener cGj = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.e.close_ad != view.getId() || b.this.bAn == null || b.this.mDuration <= 15000 || b.this.bAn.getCurrentPosition() <= 15000) {
                if (b.this.cGe != null) {
                    b.this.cGe.asF();
                    return;
                }
                return;
            }
            b.this.bAn.seekTo(b.this.mDuration);
        }
    };
    public int bsh = com.baidu.swan.games.view.a.c.ayO();
    public int bsi = com.baidu.swan.games.view.a.c.ayP();

    public abstract View asq();

    public b(Context context, AdElementInfo adElementInfo) {
        this.mContext = context;
        this.cFF = adElementInfo;
        this.mResources = this.mContext.getResources();
        initView();
    }

    private void initView() {
        this.mConvertView = asq();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bsh, this.bsi);
        this.mConvertView.setLayoutParams(layoutParams);
        this.cFV = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.cFW = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.cFW.setLayoutParams(layoutParams);
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.cFX = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.cFY = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.cFZ = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.cGa = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.cGb = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.cGc = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.cFF.asB())) {
            this.cGf = new RewardLoadWebView(this.mContext);
            this.cGc.addView(this.cGf, new RelativeLayout.LayoutParams(-1, -1));
            this.cGf.a("reward_banner_html", this.cFF, this);
        }
        this.bAn = this.cFW.getPlayer();
        asj();
    }

    private void asj() {
        this.cFV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.cFY.setOnClickListener(this.cGi);
        this.cFZ.setOnClickListener(this.cGj);
    }

    public void a(a.c cVar) {
        this.cFR = cVar;
    }

    public void a(a.b bVar) {
        this.cGe = bVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void bk(String str) {
        if (this.cFW != null) {
            this.cFW.bk(str);
        }
    }

    public com.baidu.swan.apps.media.c.a getPlayer() {
        if (this.cFW != null) {
            return this.cFW.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.cGd.removeCallbacksAndMessages(null);
            this.cGd.postDelayed(this.cGh, 0L);
        }
    }

    private void RW() {
        if (this.mProgressBar != null) {
            this.cGd.removeCallbacksAndMessages(null);
        }
    }

    public void ask() {
        startTimer();
        if (this.mProgressBar != null && this.bAn != null) {
            this.mProgressBar.setMax(this.bAn.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.cGa != null && this.bAn != null) {
            this.cGa.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(this.bAn.getDuration() / 1000)));
        }
        if (this.cFX.getVisibility() != 0) {
            this.cFX.setVisibility(0);
        }
        if (this.cGc.getVisibility() != 0) {
            this.cGc.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.cGc.setVisibility(0);
        }
    }

    public void onPrepared() {
        if (this.bAn != null) {
            this.mDuration = this.bAn.getDuration();
        }
    }

    public void asl() {
        RW();
    }

    public void asn() {
        startTimer();
    }

    public void aso() {
        RW();
        if (this.cGf != null) {
            this.cGf.destroy();
            this.cGf = null;
        }
        if (this.cGg != null) {
            this.cGg.destroy();
            this.cGg = null;
        }
    }

    public void asp() {
        asr();
        RW();
    }

    private void asr() {
        if (this.cFV != null) {
            this.cFX.setVisibility(4);
            this.cGc.setVisibility(4);
            this.cFZ.setVisibility(4);
            if (!TextUtils.isEmpty(this.cFF.asC())) {
                this.cGg = new RewardLoadWebView(this.mContext);
                this.cGg.a("reward_end_frame_html", this.cFF, this);
                this.cFV.addView(this.cGg, new RelativeLayout.LayoutParams(-1, -1));
            }
            ass();
        }
    }

    private void ass() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.cGj);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(af.dip2px(this.mContext, 96.0f), af.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0380c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0380c.include_land_close_ad_margin), 0);
        this.cFV.addView(textView, layoutParams);
    }

    @Override // com.baidu.swan.game.ad.b.d
    public void ast() {
        if (this.cFR != null) {
            this.cFR.pK();
        }
    }
}
