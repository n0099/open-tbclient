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
    private com.baidu.swan.apps.media.b.a chu;
    private AdElementInfo dwC;
    private a.d dwP;
    private RelativeLayout dwV;
    private RewardVideoView dwW;
    private LinearLayout dwX;
    private ImageView dwY;
    private TextView dwZ;
    private TextView dxa;
    private View dxb;
    private RelativeLayout dxc;
    private a.c dxe;
    private RewardLoadWebView dxf;
    private RewardLoadWebView dxg;
    private InteractiveEndFrameView dxh;
    private com.baidu.swan.game.ad.jsbridge.a dxi;
    private com.baidu.swan.game.ad.e.b dxk;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    protected Resources mResources;
    private final Handler dxd = new Handler();
    private boolean dxl = false;
    private Runnable dxm = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.chu != null) {
                b.this.aLA();
                int currentPosition = b.this.chu.getCurrentPosition();
                b.this.l(b.this.mDuration, currentPosition);
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.dxd.postDelayed(b.this.dxm, 100L);
                }
            }
        }
    };
    private View.OnClickListener dxn = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dwW != null) {
                if (b.this.dwW.isMute()) {
                    b.this.dwY.setImageResource(c.d.ng_game_vol_open);
                    b.this.dwW.mute(false);
                    return;
                }
                b.this.dwY.setImageResource(c.d.ng_game_vol_close);
                b.this.dwW.mute(true);
            }
        }
    };
    private View.OnClickListener dxo = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dxe != null) {
                b.this.dxe.aE(view);
            }
        }
    };
    private View.OnClickListener dwS = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dwP != null) {
                b.this.dwP.aF(view);
            }
        }
    };
    public int bTi = com.baidu.swan.games.view.a.c.aTO();
    public int bTj = com.baidu.swan.games.view.a.c.aTP();
    private boolean dxj = f.aMR();

    public abstract void a(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public abstract View aLw();

    public abstract String aLx();

    public b(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.jsbridge.a aVar) {
        this.mContext = context;
        this.dwC = adElementInfo;
        this.mResources = this.mContext.getResources();
        this.dxi = aVar;
        initView();
        this.dxk = new com.baidu.swan.game.ad.e.b(this.mContext);
    }

    private void initView() {
        this.mConvertView = aLw();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bTi, this.bTj);
        this.mConvertView.setLayoutParams(layoutParams);
        this.dwV = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.dwW = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.dwW.setLayoutParams(layoutParams);
        if (this.dxj) {
            this.dwW.setOnClickListener(this.dwS);
        }
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.dwX = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.dwY = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.dwZ = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.dxa = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.dxb = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.dxc = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.dwC.aMm())) {
            this.dxf = new RewardLoadWebView(this.mContext);
            this.dxc.addView(this.dxf, new RelativeLayout.LayoutParams(-1, -1));
            a(this.dxc, this.dwC);
            this.dxf.a(aLx(), this.dwC, this.dxi);
        } else {
            View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_banner, (ViewGroup) null);
            this.dxc.addView(inflate);
            ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dwC.getIconUrl());
            ((TextView) inflate.findViewById(c.e.title)).setText(this.dwC.getTitle());
            ((TextView) inflate.findViewById(c.e.desc)).setText(this.dwC.getDescription());
            Button button = (Button) inflate.findViewById(c.e.download);
            if (this.dwC.getActionType() == 1) {
                button.setText(this.mContext.getResources().getString(c.g.see_detail));
            }
            if (this.dwC.getActionType() == 2) {
                button.setText(this.mContext.getResources().getString(c.g.down_immediately));
            }
            this.dxc.setOnClickListener(this.dwS);
            button.setOnClickListener(this.dwS);
        }
        this.chu = this.dwW.getPlayer();
        aLp();
    }

    private void aLp() {
        this.dwV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.dwY.setOnClickListener(this.dxn);
        this.dwZ.setOnClickListener(this.dxo);
    }

    public void a(a.c cVar) {
        this.dxe = cVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void bs(String str) {
        if (this.dwW != null) {
            this.dwW.bs(str);
        }
    }

    public com.baidu.swan.apps.media.b.a getPlayer() {
        if (this.dwW != null) {
            return this.dwW.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.dxd.removeCallbacksAndMessages(null);
            this.dxd.postDelayed(this.dxm, 0L);
        }
    }

    private void afW() {
        if (this.mProgressBar != null) {
            this.dxd.removeCallbacksAndMessages(null);
        }
    }

    public void aLq() {
        startTimer();
        if (this.mProgressBar != null && this.chu != null) {
            this.mProgressBar.setMax(this.chu.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.dxa != null && this.chu != null && this.dwC != null) {
            this.dxa.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.dwC.aMh(), Math.min(this.dwC.aMg(), this.chu.getDuration())) / 1000)));
            if (this.dwC.aMh() >= 0) {
                this.dwZ.setVisibility(8);
                this.dxb.setVisibility(8);
            }
        }
        if (this.dwX.getVisibility() != 0) {
            this.dwX.setVisibility(0);
        }
        if (this.dxc.getVisibility() != 0) {
            this.dxc.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.dxc.setVisibility(0);
        }
        if (this.chu != null) {
            l(this.chu.getDuration(), this.chu.getCurrentPosition());
        }
    }

    public void onPrepared() {
        if (this.chu != null) {
            this.mDuration = this.chu.getDuration();
        }
    }

    public void aLr() {
        afW();
    }

    public void aLs() {
        startTimer();
    }

    public void aLt() {
        afW();
        if (this.dxf != null) {
            this.dxf.destroy();
            this.dxf = null;
        }
        if (this.dxg != null) {
            this.dxg.destroy();
            this.dxg = null;
        }
        if (this.dxh != null) {
            this.dxh.destroy();
            this.dxh = null;
        }
    }

    public void aLu() {
        aLy();
        afW();
    }

    public void aLv() {
        aLy();
        afW();
    }

    private void aLy() {
        if (this.dwV != null) {
            this.dxl = true;
            this.dwX.setVisibility(4);
            this.dxc.setVisibility(4);
            this.dwZ.setVisibility(4);
            if (!TextUtils.isEmpty(this.dwC.aMi())) {
                this.dxh = new InteractiveEndFrameView(this.mContext);
                this.dxh.a(this.dwC, this.dwV);
                this.dwV.addView(this.dxh, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dwC, this.dxk);
            } else if (!TextUtils.isEmpty(this.dwC.aMo())) {
                this.dxg = new RewardLoadWebView(this.mContext);
                this.dxg.a("reward_end_frame_html", this.dwC, this.dxi);
                this.dwV.addView(this.dxg, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dwC, this.dxk);
            } else {
                View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_close_banner, (ViewGroup) null);
                this.dwV.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
                ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dwC.getIconUrl());
                ((TextView) inflate.findViewById(c.e.title)).setText(this.dwC.getTitle());
                ((TextView) inflate.findViewById(c.e.desc)).setText(this.dwC.getDescription());
                Button button = (Button) inflate.findViewById(c.e.download);
                if (this.dwC.getActionType() == 1) {
                    button.setText(this.mContext.getResources().getString(c.g.see_detail));
                }
                if (this.dwC.getActionType() == 2) {
                    button.setText(this.mContext.getResources().getString(c.g.down_immediately));
                }
                inflate.findViewById(c.e.content_des).setOnClickListener(this.dwS);
                button.setOnClickListener(this.dwS);
            }
            aLz();
        }
    }

    private void aLz() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.dxo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ah.dip2px(this.mContext, 96.0f), ah.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0493c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0493c.include_land_close_ad_margin), 0);
        this.dwV.addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLA() {
        if (this.dwC != null && this.chu != null) {
            this.mDuration = this.chu.getDuration();
            int min = Math.min(this.dwC.aMg(), this.mDuration / 1000);
            int aMh = this.dwC.aMh();
            int currentPosition = this.chu.getCurrentPosition() / 1000;
            String string = this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus);
            String string2 = this.mContext.getResources().getString(c.g.swangame_game_ad_video_time_surplus);
            if (currentPosition <= min) {
                this.dxa.setText(String.format(string, Integer.valueOf(min - currentPosition)));
            } else {
                this.dxa.setText(String.format(string2, Integer.valueOf((this.mDuration / 1000) - currentPosition)));
            }
            if (currentPosition <= aMh) {
                this.dwZ.setVisibility(8);
                this.dxb.setVisibility(8);
                return;
            }
            this.dwZ.setVisibility(0);
            this.dxb.setVisibility(0);
        }
    }

    public void a(a.d dVar) {
        this.dwP = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(long j, int i) {
        if (this.dxj) {
            if (j > 15000 && i <= 15000) {
                if (i < 5000) {
                    this.dwX.setVisibility(8);
                    this.dxa.setVisibility(8);
                    this.dxb.setVisibility(8);
                    this.dwZ.setVisibility(8);
                    return;
                } else if (i < 10000) {
                    this.dwX.setVisibility(0);
                    this.dxa.setVisibility(0);
                    this.dxb.setVisibility(8);
                    this.dwZ.setVisibility(8);
                    return;
                } else {
                    this.dwX.setVisibility(0);
                    this.dxa.setVisibility(0);
                    this.dxb.setVisibility(0);
                    this.dwZ.setVisibility(0);
                    return;
                }
            }
            this.dxa.setText(c.g.swangame_game_ad_reward_tip);
            this.dwZ.setVisibility(0);
            this.dxb.setVisibility(0);
            this.dxa.setVisibility(0);
        }
    }

    public boolean aLB() {
        return this.dxl;
    }
}
