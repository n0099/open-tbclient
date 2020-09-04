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
/* loaded from: classes19.dex */
public abstract class b {
    private com.baidu.swan.apps.media.b.a bTg;
    private a.d diH;
    private RelativeLayout diN;
    private RewardVideoView diO;
    private LinearLayout diP;
    private ImageView diQ;
    private TextView diR;
    private TextView diS;
    private View diT;
    private RelativeLayout diU;
    private a.c diW;
    private RewardLoadWebView diX;
    private RewardLoadWebView diY;
    private InteractiveEndFrameView diZ;
    private AdElementInfo diu;
    private com.baidu.swan.game.ad.jsbridge.a dja;
    private com.baidu.swan.game.ad.e.b djc;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    protected Resources mResources;
    private final Handler diV = new Handler();
    private boolean djd = false;
    private Runnable dje = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bTg != null) {
                b.this.aIg();
                int currentPosition = b.this.bTg.getCurrentPosition();
                b.this.h(b.this.mDuration, currentPosition);
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.diV.postDelayed(b.this.dje, 100L);
                }
            }
        }
    };
    private View.OnClickListener djf = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.diO != null) {
                if (b.this.diO.isMute()) {
                    b.this.diQ.setImageResource(c.d.ng_game_vol_open);
                    b.this.diO.mute(false);
                    return;
                }
                b.this.diQ.setImageResource(c.d.ng_game_vol_close);
                b.this.diO.mute(true);
            }
        }
    };
    private View.OnClickListener djg = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.diW != null) {
                b.this.diW.aB(view);
            }
        }
    };
    private View.OnClickListener diK = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.diH != null) {
                b.this.diH.aC(view);
            }
        }
    };
    public int bKz = com.baidu.swan.games.view.a.c.aQt();
    public int bKA = com.baidu.swan.games.view.a.c.aQu();
    private boolean djb = f.aJx();

    public abstract void a(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public abstract View aIc();

    public abstract String aId();

    public b(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.jsbridge.a aVar) {
        this.mContext = context;
        this.diu = adElementInfo;
        this.mResources = this.mContext.getResources();
        this.dja = aVar;
        initView();
        this.djc = new com.baidu.swan.game.ad.e.b(this.mContext);
    }

    private void initView() {
        this.mConvertView = aIc();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bKz, this.bKA);
        this.mConvertView.setLayoutParams(layoutParams);
        this.diN = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.diO = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.diO.setLayoutParams(layoutParams);
        if (this.djb) {
            this.diO.setOnClickListener(this.diK);
        }
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.diP = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.diQ = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.diR = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.diS = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.diT = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.diU = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.diu.aIS())) {
            this.diX = new RewardLoadWebView(this.mContext);
            this.diU.addView(this.diX, new RelativeLayout.LayoutParams(-1, -1));
            a(this.diU, this.diu);
            this.diX.a(aId(), this.diu, this.dja);
        } else {
            View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_banner, (ViewGroup) null);
            this.diU.addView(inflate);
            ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.diu.getIconUrl());
            ((TextView) inflate.findViewById(c.e.title)).setText(this.diu.getTitle());
            ((TextView) inflate.findViewById(c.e.desc)).setText(this.diu.getDescription());
            Button button = (Button) inflate.findViewById(c.e.download);
            if (this.diu.getActionType() == 1) {
                button.setText(this.mContext.getResources().getString(c.g.see_detail));
            }
            if (this.diu.getActionType() == 2) {
                button.setText(this.mContext.getResources().getString(c.g.down_immediately));
            }
            this.diU.setOnClickListener(this.diK);
            button.setOnClickListener(this.diK);
        }
        this.bTg = this.diO.getPlayer();
        aHV();
    }

    private void aHV() {
        this.diN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.diQ.setOnClickListener(this.djf);
        this.diR.setOnClickListener(this.djg);
    }

    public void a(a.c cVar) {
        this.diW = cVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void bq(String str) {
        if (this.diO != null) {
            this.diO.bq(str);
        }
    }

    public com.baidu.swan.apps.media.b.a getPlayer() {
        if (this.diO != null) {
            return this.diO.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.diV.removeCallbacksAndMessages(null);
            this.diV.postDelayed(this.dje, 0L);
        }
    }

    private void acB() {
        if (this.mProgressBar != null) {
            this.diV.removeCallbacksAndMessages(null);
        }
    }

    public void aHW() {
        startTimer();
        if (this.mProgressBar != null && this.bTg != null) {
            this.mProgressBar.setMax(this.bTg.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.diS != null && this.bTg != null && this.diu != null) {
            this.diS.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.diu.aIN(), Math.min(this.diu.aIM(), this.bTg.getDuration())) / 1000)));
            if (this.diu.aIN() >= 0) {
                this.diR.setVisibility(8);
                this.diT.setVisibility(8);
            }
        }
        if (this.diP.getVisibility() != 0) {
            this.diP.setVisibility(0);
        }
        if (this.diU.getVisibility() != 0) {
            this.diU.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.diU.setVisibility(0);
        }
        if (this.bTg != null) {
            h(this.bTg.getDuration(), this.bTg.getCurrentPosition());
        }
    }

    public void onPrepared() {
        if (this.bTg != null) {
            this.mDuration = this.bTg.getDuration();
        }
    }

    public void aHX() {
        acB();
    }

    public void aHY() {
        startTimer();
    }

    public void aHZ() {
        acB();
        if (this.diX != null) {
            this.diX.destroy();
            this.diX = null;
        }
        if (this.diY != null) {
            this.diY.destroy();
            this.diY = null;
        }
        if (this.diZ != null) {
            this.diZ.destroy();
            this.diZ = null;
        }
    }

    public void aIa() {
        aIe();
        acB();
    }

    public void aIb() {
        aIe();
        acB();
    }

    private void aIe() {
        if (this.diN != null) {
            this.djd = true;
            this.diP.setVisibility(4);
            this.diU.setVisibility(4);
            this.diR.setVisibility(4);
            if (!TextUtils.isEmpty(this.diu.aIO())) {
                this.diZ = new InteractiveEndFrameView(this.mContext);
                this.diZ.a(this.diu, this.diN);
                this.diN.addView(this.diZ, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.diu, this.djc);
            } else if (!TextUtils.isEmpty(this.diu.aIU())) {
                this.diY = new RewardLoadWebView(this.mContext);
                this.diY.a("reward_end_frame_html", this.diu, this.dja);
                this.diN.addView(this.diY, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.diu, this.djc);
            } else {
                View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_close_banner, (ViewGroup) null);
                this.diN.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
                ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.diu.getIconUrl());
                ((TextView) inflate.findViewById(c.e.title)).setText(this.diu.getTitle());
                ((TextView) inflate.findViewById(c.e.desc)).setText(this.diu.getDescription());
                Button button = (Button) inflate.findViewById(c.e.download);
                if (this.diu.getActionType() == 1) {
                    button.setText(this.mContext.getResources().getString(c.g.see_detail));
                }
                if (this.diu.getActionType() == 2) {
                    button.setText(this.mContext.getResources().getString(c.g.down_immediately));
                }
                inflate.findViewById(c.e.content_des).setOnClickListener(this.diK);
                button.setOnClickListener(this.diK);
            }
            aIf();
        }
    }

    private void aIf() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.djg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ah.dip2px(this.mContext, 96.0f), ah.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0481c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0481c.include_land_close_ad_margin), 0);
        this.diN.addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIg() {
        if (this.diu != null && this.bTg != null) {
            this.mDuration = this.bTg.getDuration();
            int min = Math.min(this.diu.aIM(), this.mDuration / 1000);
            int aIN = this.diu.aIN();
            int currentPosition = this.bTg.getCurrentPosition() / 1000;
            String string = this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus);
            String string2 = this.mContext.getResources().getString(c.g.swangame_game_ad_video_time_surplus);
            if (currentPosition <= min) {
                this.diS.setText(String.format(string, Integer.valueOf(min - currentPosition)));
            } else {
                this.diS.setText(String.format(string2, Integer.valueOf((this.mDuration / 1000) - currentPosition)));
            }
            if (currentPosition <= aIN) {
                this.diR.setVisibility(8);
                this.diT.setVisibility(8);
                return;
            }
            this.diR.setVisibility(0);
            this.diT.setVisibility(0);
        }
    }

    public void a(a.d dVar) {
        this.diH = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j, int i) {
        if (this.djb) {
            if (j > 15000 && i <= 15000) {
                if (i < 5000) {
                    this.diP.setVisibility(8);
                    this.diS.setVisibility(8);
                    this.diT.setVisibility(8);
                    this.diR.setVisibility(8);
                    return;
                } else if (i < 10000) {
                    this.diP.setVisibility(0);
                    this.diS.setVisibility(0);
                    this.diT.setVisibility(8);
                    this.diR.setVisibility(8);
                    return;
                } else {
                    this.diP.setVisibility(0);
                    this.diS.setVisibility(0);
                    this.diT.setVisibility(0);
                    this.diR.setVisibility(0);
                    return;
                }
            }
            this.diS.setText(c.g.swangame_game_ad_reward_tip);
            this.diR.setVisibility(0);
            this.diT.setVisibility(0);
            this.diS.setVisibility(0);
        }
    }

    public boolean aIh() {
        return this.djd;
    }
}
