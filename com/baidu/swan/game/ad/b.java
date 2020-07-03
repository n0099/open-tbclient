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
    private com.baidu.swan.apps.media.b.a bMP;
    private a.c cUL;
    private RelativeLayout cUP;
    private RewardVideoView cUQ;
    private LinearLayout cUR;
    private ImageView cUS;
    private TextView cUT;
    private TextView cUU;
    private View cUV;
    private RelativeLayout cUW;
    private a.b cUY;
    private RewardLoadWebView cUZ;
    private AdElementInfo cUz;
    private RewardLoadWebView cVa;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    private Resources mResources;
    private final Handler cUX = new Handler();
    private Runnable cVb = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bMP != null) {
                int currentPosition = b.this.bMP.getCurrentPosition();
                b.this.mDuration = b.this.bMP.getDuration();
                if (b.this.mDuration <= 15000 || currentPosition > 15000) {
                    b.this.cUV.setVisibility(8);
                    b.this.cUU.setVisibility(8);
                } else {
                    b.this.cUU.setText(String.format(b.this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(15 - (currentPosition / 1000))));
                }
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.cUX.postDelayed(b.this.cVb, 100L);
                }
            }
        }
    };
    private View.OnClickListener cVc = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cUQ != null) {
                if (b.this.cUQ.isMute()) {
                    b.this.cUS.setImageResource(c.d.ng_game_vol_open);
                    b.this.cUQ.eb(false);
                    return;
                }
                b.this.cUS.setImageResource(c.d.ng_game_vol_close);
                b.this.cUQ.eb(true);
            }
        }
    };
    private View.OnClickListener cVd = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.e.close_ad != view.getId() || b.this.bMP == null || b.this.mDuration <= 15000 || b.this.bMP.getCurrentPosition() <= 15000) {
                if (b.this.cUY != null) {
                    b.this.cUY.axs();
                    return;
                }
                return;
            }
            b.this.bMP.seekTo(b.this.mDuration);
        }
    };
    public int bEy = com.baidu.swan.games.view.a.c.aDM();
    public int bEz = com.baidu.swan.games.view.a.c.aDN();

    public abstract View axd();

    public b(Context context, AdElementInfo adElementInfo) {
        this.mContext = context;
        this.cUz = adElementInfo;
        this.mResources = this.mContext.getResources();
        initView();
    }

    private void initView() {
        this.mConvertView = axd();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bEy, this.bEz);
        this.mConvertView.setLayoutParams(layoutParams);
        this.cUP = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.cUQ = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.cUQ.setLayoutParams(layoutParams);
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.cUR = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.cUS = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.cUT = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.cUU = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.cUV = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.cUW = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.cUz.axo())) {
            this.cUZ = new RewardLoadWebView(this.mContext);
            this.cUW.addView(this.cUZ, new RelativeLayout.LayoutParams(-1, -1));
            this.cUZ.a("reward_banner_html", this.cUz, this);
        }
        this.bMP = this.cUQ.getPlayer();
        awX();
    }

    private void awX() {
        this.cUP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.cUS.setOnClickListener(this.cVc);
        this.cUT.setOnClickListener(this.cVd);
    }

    public void a(a.c cVar) {
        this.cUL = cVar;
    }

    public void a(a.b bVar) {
        this.cUY = bVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void bl(String str) {
        if (this.cUQ != null) {
            this.cUQ.bl(str);
        }
    }

    public com.baidu.swan.apps.media.b.a getPlayer() {
        if (this.cUQ != null) {
            return this.cUQ.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.cUX.removeCallbacksAndMessages(null);
            this.cUX.postDelayed(this.cVb, 0L);
        }
    }

    private void VO() {
        if (this.mProgressBar != null) {
            this.cUX.removeCallbacksAndMessages(null);
        }
    }

    public void awY() {
        startTimer();
        if (this.mProgressBar != null && this.bMP != null) {
            this.mProgressBar.setMax(this.bMP.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.cUU != null && this.bMP != null) {
            this.cUU.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(this.bMP.getDuration() / 1000)));
        }
        if (this.cUR.getVisibility() != 0) {
            this.cUR.setVisibility(0);
        }
        if (this.cUW.getVisibility() != 0) {
            this.cUW.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.cUW.setVisibility(0);
        }
    }

    public void onPrepared() {
        if (this.bMP != null) {
            this.mDuration = this.bMP.getDuration();
        }
    }

    public void awZ() {
        VO();
    }

    public void axa() {
        startTimer();
    }

    public void axb() {
        VO();
        if (this.cUZ != null) {
            this.cUZ.destroy();
            this.cUZ = null;
        }
        if (this.cVa != null) {
            this.cVa.destroy();
            this.cVa = null;
        }
    }

    public void axc() {
        axe();
        VO();
    }

    private void axe() {
        if (this.cUP != null) {
            this.cUR.setVisibility(4);
            this.cUW.setVisibility(4);
            this.cUT.setVisibility(4);
            if (!TextUtils.isEmpty(this.cUz.axp())) {
                this.cVa = new RewardLoadWebView(this.mContext);
                this.cVa.a("reward_end_frame_html", this.cUz, this);
                this.cUP.addView(this.cVa, new RelativeLayout.LayoutParams(-1, -1));
            }
            axf();
        }
    }

    private void axf() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.cVd);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ag.dip2px(this.mContext, 96.0f), ag.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0426c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0426c.include_land_close_ad_margin), 0);
        this.cUP.addView(textView, layoutParams);
    }

    @Override // com.baidu.swan.game.ad.b.d
    public void axg() {
        if (this.cUL != null) {
            this.cUL.qh();
        }
    }
}
