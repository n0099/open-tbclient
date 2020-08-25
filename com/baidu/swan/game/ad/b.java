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
    private com.baidu.swan.apps.media.b.a bTc;
    private a.d diD;
    private RelativeLayout diJ;
    private RewardVideoView diK;
    private LinearLayout diL;
    private ImageView diM;
    private TextView diN;
    private TextView diO;
    private View diP;
    private RelativeLayout diQ;
    private a.c diS;
    private RewardLoadWebView diT;
    private RewardLoadWebView diU;
    private InteractiveEndFrameView diV;
    private com.baidu.swan.game.ad.jsbridge.a diW;
    private com.baidu.swan.game.ad.e.b diY;
    private AdElementInfo dio;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    protected Resources mResources;
    private final Handler diR = new Handler();
    private boolean diZ = false;
    private Runnable dja = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bTc != null) {
                b.this.aIg();
                int currentPosition = b.this.bTc.getCurrentPosition();
                b.this.h(b.this.mDuration, currentPosition);
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.diR.postDelayed(b.this.dja, 100L);
                }
            }
        }
    };
    private View.OnClickListener djb = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.diK != null) {
                if (b.this.diK.isMute()) {
                    b.this.diM.setImageResource(c.d.ng_game_vol_open);
                    b.this.diK.mute(false);
                    return;
                }
                b.this.diM.setImageResource(c.d.ng_game_vol_close);
                b.this.diK.mute(true);
            }
        }
    };
    private View.OnClickListener djc = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.diS != null) {
                b.this.diS.aB(view);
            }
        }
    };
    private View.OnClickListener diG = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.diD != null) {
                b.this.diD.aC(view);
            }
        }
    };
    public int bKv = com.baidu.swan.games.view.a.c.aQt();
    public int bKw = com.baidu.swan.games.view.a.c.aQu();
    private boolean diX = f.aJx();

    public abstract void a(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public abstract View aIc();

    public abstract String aId();

    public b(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.jsbridge.a aVar) {
        this.mContext = context;
        this.dio = adElementInfo;
        this.mResources = this.mContext.getResources();
        this.diW = aVar;
        initView();
        this.diY = new com.baidu.swan.game.ad.e.b(this.mContext);
    }

    private void initView() {
        this.mConvertView = aIc();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bKv, this.bKw);
        this.mConvertView.setLayoutParams(layoutParams);
        this.diJ = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.diK = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.diK.setLayoutParams(layoutParams);
        if (this.diX) {
            this.diK.setOnClickListener(this.diG);
        }
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.diL = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.diM = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.diN = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.diO = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.diP = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.diQ = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.dio.aIS())) {
            this.diT = new RewardLoadWebView(this.mContext);
            this.diQ.addView(this.diT, new RelativeLayout.LayoutParams(-1, -1));
            a(this.diQ, this.dio);
            this.diT.a(aId(), this.dio, this.diW);
        } else {
            View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_banner, (ViewGroup) null);
            this.diQ.addView(inflate);
            ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dio.getIconUrl());
            ((TextView) inflate.findViewById(c.e.title)).setText(this.dio.getTitle());
            ((TextView) inflate.findViewById(c.e.desc)).setText(this.dio.getDescription());
            Button button = (Button) inflate.findViewById(c.e.download);
            if (this.dio.getActionType() == 1) {
                button.setText(this.mContext.getResources().getString(c.g.see_detail));
            }
            if (this.dio.getActionType() == 2) {
                button.setText(this.mContext.getResources().getString(c.g.down_immediately));
            }
            this.diQ.setOnClickListener(this.diG);
            button.setOnClickListener(this.diG);
        }
        this.bTc = this.diK.getPlayer();
        aHV();
    }

    private void aHV() {
        this.diJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.diM.setOnClickListener(this.djb);
        this.diN.setOnClickListener(this.djc);
    }

    public void a(a.c cVar) {
        this.diS = cVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void bq(String str) {
        if (this.diK != null) {
            this.diK.bq(str);
        }
    }

    public com.baidu.swan.apps.media.b.a getPlayer() {
        if (this.diK != null) {
            return this.diK.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.diR.removeCallbacksAndMessages(null);
            this.diR.postDelayed(this.dja, 0L);
        }
    }

    private void acB() {
        if (this.mProgressBar != null) {
            this.diR.removeCallbacksAndMessages(null);
        }
    }

    public void aHW() {
        startTimer();
        if (this.mProgressBar != null && this.bTc != null) {
            this.mProgressBar.setMax(this.bTc.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.diO != null && this.bTc != null && this.dio != null) {
            this.diO.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.dio.aIN(), Math.min(this.dio.aIM(), this.bTc.getDuration())) / 1000)));
            if (this.dio.aIN() >= 0) {
                this.diN.setVisibility(8);
                this.diP.setVisibility(8);
            }
        }
        if (this.diL.getVisibility() != 0) {
            this.diL.setVisibility(0);
        }
        if (this.diQ.getVisibility() != 0) {
            this.diQ.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.diQ.setVisibility(0);
        }
        if (this.bTc != null) {
            h(this.bTc.getDuration(), this.bTc.getCurrentPosition());
        }
    }

    public void onPrepared() {
        if (this.bTc != null) {
            this.mDuration = this.bTc.getDuration();
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
        if (this.diT != null) {
            this.diT.destroy();
            this.diT = null;
        }
        if (this.diU != null) {
            this.diU.destroy();
            this.diU = null;
        }
        if (this.diV != null) {
            this.diV.destroy();
            this.diV = null;
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
        if (this.diJ != null) {
            this.diZ = true;
            this.diL.setVisibility(4);
            this.diQ.setVisibility(4);
            this.diN.setVisibility(4);
            if (!TextUtils.isEmpty(this.dio.aIO())) {
                this.diV = new InteractiveEndFrameView(this.mContext);
                this.diV.a(this.dio, this.diJ);
                this.diJ.addView(this.diV, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dio, this.diY);
            } else if (!TextUtils.isEmpty(this.dio.aIU())) {
                this.diU = new RewardLoadWebView(this.mContext);
                this.diU.a("reward_end_frame_html", this.dio, this.diW);
                this.diJ.addView(this.diU, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dio, this.diY);
            } else {
                View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_close_banner, (ViewGroup) null);
                this.diJ.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
                ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dio.getIconUrl());
                ((TextView) inflate.findViewById(c.e.title)).setText(this.dio.getTitle());
                ((TextView) inflate.findViewById(c.e.desc)).setText(this.dio.getDescription());
                Button button = (Button) inflate.findViewById(c.e.download);
                if (this.dio.getActionType() == 1) {
                    button.setText(this.mContext.getResources().getString(c.g.see_detail));
                }
                if (this.dio.getActionType() == 2) {
                    button.setText(this.mContext.getResources().getString(c.g.down_immediately));
                }
                inflate.findViewById(c.e.content_des).setOnClickListener(this.diG);
                button.setOnClickListener(this.diG);
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
        textView.setOnClickListener(this.djc);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ah.dip2px(this.mContext, 96.0f), ah.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0481c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0481c.include_land_close_ad_margin), 0);
        this.diJ.addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIg() {
        if (this.dio != null && this.bTc != null) {
            this.mDuration = this.bTc.getDuration();
            int min = Math.min(this.dio.aIM(), this.mDuration / 1000);
            int aIN = this.dio.aIN();
            int currentPosition = this.bTc.getCurrentPosition() / 1000;
            String string = this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus);
            String string2 = this.mContext.getResources().getString(c.g.swangame_game_ad_video_time_surplus);
            if (currentPosition <= min) {
                this.diO.setText(String.format(string, Integer.valueOf(min - currentPosition)));
            } else {
                this.diO.setText(String.format(string2, Integer.valueOf((this.mDuration / 1000) - currentPosition)));
            }
            if (currentPosition <= aIN) {
                this.diN.setVisibility(8);
                this.diP.setVisibility(8);
                return;
            }
            this.diN.setVisibility(0);
            this.diP.setVisibility(0);
        }
    }

    public void a(a.d dVar) {
        this.diD = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j, int i) {
        if (this.diX) {
            if (j > 15000 && i <= 15000) {
                if (i < 5000) {
                    this.diL.setVisibility(8);
                    this.diO.setVisibility(8);
                    this.diP.setVisibility(8);
                    this.diN.setVisibility(8);
                    return;
                } else if (i < 10000) {
                    this.diL.setVisibility(0);
                    this.diO.setVisibility(0);
                    this.diP.setVisibility(8);
                    this.diN.setVisibility(8);
                    return;
                } else {
                    this.diL.setVisibility(0);
                    this.diO.setVisibility(0);
                    this.diP.setVisibility(0);
                    this.diN.setVisibility(0);
                    return;
                }
            }
            this.diO.setText(c.g.swangame_game_ad_reward_tip);
            this.diN.setVisibility(0);
            this.diP.setVisibility(0);
            this.diO.setVisibility(0);
        }
    }

    public boolean aIh() {
        return this.diZ;
    }
}
