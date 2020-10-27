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
    private com.baidu.swan.apps.media.b.a cpV;
    private AdElementInfo dEZ;
    private a.c dFB;
    private RewardLoadWebView dFC;
    private RewardLoadWebView dFD;
    private InteractiveEndFrameView dFE;
    private com.baidu.swan.game.ad.jsbridge.a dFF;
    private com.baidu.swan.game.ad.e.b dFH;
    private a.d dFm;
    private RelativeLayout dFs;
    private RewardVideoView dFt;
    private LinearLayout dFu;
    private ImageView dFv;
    private TextView dFw;
    private TextView dFx;
    private View dFy;
    private RelativeLayout dFz;
    public Context mContext;
    private View mConvertView;
    private int mDuration;
    private ProgressBar mProgressBar;
    protected Resources mResources;
    private final Handler dFA = new Handler();
    private boolean dFI = false;
    private Runnable dFJ = new Runnable() { // from class: com.baidu.swan.game.ad.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cpV != null) {
                b.this.aNu();
                int currentPosition = b.this.cpV.getCurrentPosition();
                b.this.l(b.this.mDuration, currentPosition);
                int min = Math.min(currentPosition + 1000, b.this.mDuration);
                b.this.mProgressBar.setProgress(min / 1000);
                if (min < b.this.mDuration) {
                    b.this.dFA.postDelayed(b.this.dFJ, 100L);
                }
            }
        }
    };
    private View.OnClickListener dFK = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dFt != null) {
                if (b.this.dFt.isMute()) {
                    b.this.dFv.setImageResource(c.d.ng_game_vol_open);
                    b.this.dFt.mute(false);
                    return;
                }
                b.this.dFv.setImageResource(c.d.ng_game_vol_close);
                b.this.dFt.mute(true);
            }
        }
    };
    private View.OnClickListener dFL = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dFB != null) {
                b.this.dFB.aF(view);
            }
        }
    };
    private View.OnClickListener dFp = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dFm != null) {
                b.this.dFm.aG(view);
            }
        }
    };
    public int cbF = com.baidu.swan.games.view.a.c.aVI();
    public int cbG = com.baidu.swan.games.view.a.c.aVJ();
    private boolean dFG = f.aOL();

    public abstract void a(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public abstract View aNq();

    public abstract String aNr();

    public b(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.jsbridge.a aVar) {
        this.mContext = context;
        this.dEZ = adElementInfo;
        this.mResources = this.mContext.getResources();
        this.dFF = aVar;
        initView();
        this.dFH = new com.baidu.swan.game.ad.e.b(this.mContext);
    }

    private void initView() {
        this.mConvertView = aNq();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.cbF, this.cbG);
        this.mConvertView.setLayoutParams(layoutParams);
        this.dFs = (RelativeLayout) this.mConvertView.findViewById(c.e.reward_relative);
        this.dFt = (RewardVideoView) this.mConvertView.findViewById(c.e.video_view);
        this.dFt.setLayoutParams(layoutParams);
        if (this.dFG) {
            this.dFt.setOnClickListener(this.dFp);
        }
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(c.e.swangame_game_ad_video_progress_horizontal);
        this.dFu = (LinearLayout) this.mConvertView.findViewById(c.e.vol_clo);
        this.dFv = (ImageView) this.mConvertView.findViewById(c.e.volume);
        this.dFw = (TextView) this.mConvertView.findViewById(c.e.close_ad);
        this.dFx = (TextView) this.mConvertView.findViewById(c.e.close_ad_header);
        this.dFy = this.mConvertView.findViewById(c.e.close_ad_middle);
        this.dFz = (RelativeLayout) this.mConvertView.findViewById(c.e.banner);
        if (!TextUtils.isEmpty(this.dEZ.aOg())) {
            this.dFC = new RewardLoadWebView(this.mContext);
            this.dFz.addView(this.dFC, new RelativeLayout.LayoutParams(-1, -1));
            a(this.dFz, this.dEZ);
            this.dFC.a(aNr(), this.dEZ, this.dFF);
        } else {
            View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_banner, (ViewGroup) null);
            this.dFz.addView(inflate);
            ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dEZ.getIconUrl());
            ((TextView) inflate.findViewById(c.e.title)).setText(this.dEZ.getTitle());
            ((TextView) inflate.findViewById(c.e.desc)).setText(this.dEZ.getDescription());
            Button button = (Button) inflate.findViewById(c.e.download);
            if (this.dEZ.getActionType() == 1) {
                button.setText(this.mContext.getResources().getString(c.g.see_detail));
            }
            if (this.dEZ.getActionType() == 2) {
                button.setText(this.mContext.getResources().getString(c.g.down_immediately));
            }
            this.dFz.setOnClickListener(this.dFp);
            button.setOnClickListener(this.dFp);
        }
        this.cpV = this.dFt.getPlayer();
        aNj();
    }

    private void aNj() {
        this.dFs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.dFv.setOnClickListener(this.dFK);
        this.dFw.setOnClickListener(this.dFL);
    }

    public void a(a.c cVar) {
        this.dFB = cVar;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void bs(String str) {
        if (this.dFt != null) {
            this.dFt.bs(str);
        }
    }

    public com.baidu.swan.apps.media.b.a getPlayer() {
        if (this.dFt != null) {
            return this.dFt.getPlayer();
        }
        return null;
    }

    private void startTimer() {
        if (this.mProgressBar != null) {
            this.dFA.removeCallbacksAndMessages(null);
            this.dFA.postDelayed(this.dFJ, 0L);
        }
    }

    private void ahQ() {
        if (this.mProgressBar != null) {
            this.dFA.removeCallbacksAndMessages(null);
        }
    }

    public void aNk() {
        startTimer();
        if (this.mProgressBar != null && this.cpV != null) {
            this.mProgressBar.setMax(this.cpV.getDuration() / 1000);
            this.mProgressBar.setVisibility(4);
        }
        if (this.dFx != null && this.cpV != null && this.dEZ != null) {
            this.dFx.setText(String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.dEZ.aOb(), Math.min(this.dEZ.aOa(), this.cpV.getDuration())) / 1000)));
            if (this.dEZ.aOb() >= 0) {
                this.dFw.setVisibility(8);
                this.dFy.setVisibility(8);
            }
        }
        if (this.dFu.getVisibility() != 0) {
            this.dFu.setVisibility(0);
        }
        if (this.dFz.getVisibility() != 0) {
            this.dFz.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.dFz.setVisibility(0);
        }
        if (this.cpV != null) {
            l(this.cpV.getDuration(), this.cpV.getCurrentPosition());
        }
    }

    public void onPrepared() {
        if (this.cpV != null) {
            this.mDuration = this.cpV.getDuration();
        }
    }

    public void aNl() {
        ahQ();
    }

    public void aNm() {
        startTimer();
    }

    public void aNn() {
        ahQ();
        if (this.dFC != null) {
            this.dFC.destroy();
            this.dFC = null;
        }
        if (this.dFD != null) {
            this.dFD.destroy();
            this.dFD = null;
        }
        if (this.dFE != null) {
            this.dFE.destroy();
            this.dFE = null;
        }
    }

    public void aNo() {
        aNs();
        ahQ();
    }

    public void aNp() {
        aNs();
        ahQ();
    }

    private void aNs() {
        if (this.dFs != null) {
            this.dFI = true;
            this.dFu.setVisibility(4);
            this.dFz.setVisibility(4);
            this.dFw.setVisibility(4);
            if (!TextUtils.isEmpty(this.dEZ.aOc())) {
                this.dFE = new InteractiveEndFrameView(this.mContext);
                this.dFE.a(this.dEZ, this.dFs);
                this.dFs.addView(this.dFE, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dEZ, this.dFH);
            } else if (!TextUtils.isEmpty(this.dEZ.aOi())) {
                this.dFD = new RewardLoadWebView(this.mContext);
                this.dFD.a("reward_end_frame_html", this.dEZ, this.dFF);
                this.dFs.addView(this.dFD, new RelativeLayout.LayoutParams(-1, -1));
                com.baidu.swan.game.ad.c.c.b(this.dEZ, this.dFH);
            } else {
                View inflate = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_reward_close_banner, (ViewGroup) null);
                this.dFs.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
                ((AdImageVIew) inflate.findViewById(c.e.reward_icon)).setImageUrl(this.dEZ.getIconUrl());
                ((TextView) inflate.findViewById(c.e.title)).setText(this.dEZ.getTitle());
                ((TextView) inflate.findViewById(c.e.desc)).setText(this.dEZ.getDescription());
                Button button = (Button) inflate.findViewById(c.e.download);
                if (this.dEZ.getActionType() == 1) {
                    button.setText(this.mContext.getResources().getString(c.g.see_detail));
                }
                if (this.dEZ.getActionType() == 2) {
                    button.setText(this.mContext.getResources().getString(c.g.down_immediately));
                }
                inflate.findViewById(c.e.content_des).setOnClickListener(this.dFp);
                button.setOnClickListener(this.dFp);
            }
            aNt();
        }
    }

    private void aNt() {
        TextView textView = new TextView(this.mContext);
        textView.setBackground(this.mResources.getDrawable(c.d.ng_game_bg_close_ad));
        textView.setTextColor(this.mResources.getColor(c.b.close_ad_text_color));
        textView.setText(this.mResources.getString(c.g.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.dFL);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ah.dip2px(this.mContext, 96.0f), ah.dip2px(this.mContext, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.mResources.getDimensionPixelSize(c.C0507c.include_land_close_ad_margin), this.mResources.getDimensionPixelSize(c.C0507c.include_land_close_ad_margin), 0);
        this.dFs.addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNu() {
        if (this.dEZ != null && this.cpV != null) {
            this.mDuration = this.cpV.getDuration();
            int min = Math.min(this.dEZ.aOa(), this.mDuration / 1000);
            int aOb = this.dEZ.aOb();
            int currentPosition = this.cpV.getCurrentPosition() / 1000;
            String string = this.mContext.getResources().getString(c.g.swangame_game_ad_video_reward_time_surplus);
            String string2 = this.mContext.getResources().getString(c.g.swangame_game_ad_video_time_surplus);
            if (currentPosition <= min) {
                this.dFx.setText(String.format(string, Integer.valueOf(min - currentPosition)));
            } else {
                this.dFx.setText(String.format(string2, Integer.valueOf((this.mDuration / 1000) - currentPosition)));
            }
            if (currentPosition <= aOb) {
                this.dFw.setVisibility(8);
                this.dFy.setVisibility(8);
                return;
            }
            this.dFw.setVisibility(0);
            this.dFy.setVisibility(0);
        }
    }

    public void a(a.d dVar) {
        this.dFm = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(long j, int i) {
        if (this.dFG) {
            if (j > 15000 && i <= 15000) {
                if (i < 5000) {
                    this.dFu.setVisibility(8);
                    this.dFx.setVisibility(8);
                    this.dFy.setVisibility(8);
                    this.dFw.setVisibility(8);
                    return;
                } else if (i < 10000) {
                    this.dFu.setVisibility(0);
                    this.dFx.setVisibility(0);
                    this.dFy.setVisibility(8);
                    this.dFw.setVisibility(8);
                    return;
                } else {
                    this.dFu.setVisibility(0);
                    this.dFx.setVisibility(0);
                    this.dFy.setVisibility(0);
                    this.dFw.setVisibility(0);
                    return;
                }
            }
            this.dFx.setText(c.g.swangame_game_ad_reward_tip);
            this.dFw.setVisibility(0);
            this.dFy.setVisibility(0);
            this.dFx.setVisibility(0);
        }
    }

    public boolean aNv() {
        return this.dFI;
    }
}
