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
/* loaded from: classes10.dex */
public abstract class b implements com.baidu.swan.game.ad.b.d {
    private com.baidu.swan.apps.media.c.a aXu;
    private RelativeLayout ccA;
    private RewardVideoView ccB;
    private LinearLayout ccC;
    private ImageView ccD;
    private TextView ccE;
    private TextView ccF;
    private View ccG;
    private RelativeLayout ccH;
    private a.b ccL;
    private RewardLoadWebView ccM;
    private RewardLoadWebView ccN;
    private AdElementInfo ccj;
    private a.c ccw;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    private Resources mResources;
    private final Handler ccK = new Handler();
    private Runnable ccO = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.aXu != null) {
                int currentPosition = b.this.aXu.getCurrentPosition();
                b.this.mDuration = b.this.aXu.getDuration();
                if (b.this.mDuration <= 15000 || currentPosition > 15000) {
                    b.this.ccG.setVisibility(8);
                    b.this.ccF.setVisibility(8);
                } else {
                    b.this.ccF.setText(String.format(b.this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(15 - (currentPosition / 1000))));
                }
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.ccK.postDelayed(b.this.ccO, 100L);
                }
            }
        }
    };
    private View.OnClickListener ccP = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.ccB != null) {
                if (b.this.ccB.isMute()) {
                    b.this.ccD.setImageResource(c.d.ng_game_vol_open);
                    b.this.ccB.cC(false);
                    return;
                }
                b.this.ccD.setImageResource(c.d.ng_game_vol_close);
                b.this.ccB.cC(true);
            }
        }
    };
    private View.OnClickListener ccQ = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.e.close_ad != view.getId() || b.this.aXu == null || b.this.mDuration <= 15000 || b.this.aXu.getCurrentPosition() <= 15000) {
                if (b.this.ccL != null) {
                    b.this.ccL.aib();
                    return;
                }
                return;
            }
            b.this.aXu.seekTo(b.this.mDuration);
        }
    };
    public int ccI = com.baidu.swan.games.view.a.c.aoj();
    public int ccJ = com.baidu.swan.games.view.a.c.aok();

    public abstract View ahN();

    public b(Context context, AdElementInfo adElementInfo) {
        this.mContext = context;
        this.ccj = adElementInfo;
        this.mResources = this.mContext.getResources();
        initView();
    }

    private void initView() {
        this.mConvertView = ahN();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ccI, this.ccJ);
        this.mConvertView.setLayoutParams(layoutParams);
        this.ccA = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.ccB = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.ccB.setLayoutParams(layoutParams);
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.ccC = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.ccD = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.ccE = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.ccF = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.ccG = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.ccH = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.ccj.ahX())) {
            this.ccM = new RewardLoadWebView(this.mContext);
            this.ccH.addView(this.ccM, new RelativeLayout.LayoutParams(-1, -1));
            this.ccM.a("reward_banner_html", this.ccj, this);
        }
        this.aXu = this.ccB.getPlayer();
        ahI();
    }

    private void ahI() {
        this.ccA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.ccD.setOnClickListener(this.ccP);
        this.ccE.setOnClickListener(this.ccQ);
    }

    public void a(a.c cVar) {
        this.ccw = cVar;
    }

    public void a(a.b bVar) {
        this.ccL = bVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void U(String str) {
        if (this.ccB != null) {
            this.ccB.U(str);
        }
    }

    public com.baidu.swan.apps.media.c.a getPlayer() {
        if (this.ccB != null) {
            return this.ccB.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.ccK.removeCallbacksAndMessages(null);
            this.ccK.postDelayed(this.ccO, 0L);
        }
    }

    private void stopTimer() {
        if (this.mProgressBar != null) {
            this.ccK.removeCallbacksAndMessages(null);
        }
    }

    public void ahJ() {
        startTimer();
        if (this.mProgressBar != null && this.aXu != null) {
            this.mProgressBar.setMax(this.aXu.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.ccF != null && this.aXu != null) {
            this.ccF.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_close_ad_time_less), Integer.valueOf(this.aXu.getDuration() / 1000)));
        }
        if (this.ccC.getVisibility() != 0) {
            this.ccC.setVisibility(0);
        }
        if (this.ccH.getVisibility() != 0) {
            this.ccH.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.ccH.setVisibility(0);
        }
    }

    public void onPrepared() {
        if (this.aXu != null) {
            this.mDuration = this.aXu.getDuration();
        }
    }

    public void pausePlay() {
        stopTimer();
    }

    public void ahK() {
        startTimer();
    }

    public void ahL() {
        stopTimer();
        if (this.ccM != null) {
            this.ccM.destroy();
            this.ccM = null;
        }
        if (this.ccN != null) {
            this.ccN.destroy();
            this.ccN = null;
        }
    }

    public void ahM() {
        ahO();
        stopTimer();
    }

    private void ahO() {
        if (this.ccA != null) {
            this.ccC.setVisibility(4);
            this.ccH.setVisibility(4);
            this.ccE.setVisibility(4);
            if (!TextUtils.isEmpty(this.ccj.ahY())) {
                this.ccN = new RewardLoadWebView(this.mContext);
                this.ccN.a("reward_end_frame_html", this.ccj, this);
                this.ccA.addView(this.ccN, new RelativeLayout.LayoutParams(-1, -1));
            }
            ahP();
        }
    }

    private void ahP() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.ccQ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(af.dip2px(this.mContext, 96.0f), af.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0319c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0319c.include_land_close_ad_margin), 0);
        this.ccA.addView(textView, layoutParams);
    }

    @Override // com.baidu.swan.game.ad.b.d
    public void ahQ() {
        if (this.ccw != null) {
            this.ccw.kR();
        }
    }
}
