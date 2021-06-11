package com.baidu.swan.game.guide.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.download.GamenowDownloadButtomView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import d.a.l0.a.v2.f0;
import d.a.l0.f.j.h;
import d.a.l0.f.j.i;
import d.a.l0.f.j.m.f;
@SuppressLint({"BaseActivity"})
/* loaded from: classes3.dex */
public class CoinClickDialog extends Activity {
    public static final String KEY_COINS_REWARD_THIS_TIME = "rewardCoinsThisTime";
    public static final String KEY_COINS_REWARD_TOTAL = "totalRewardCoins";
    public static final String KEY_IS_SHOW_MAX = "isShowMax";
    public static final String MARK_OF_BENCI = "{benci}";
    public static final String MARK_OF_LEIJI = "{leiji}";
    public static final String MARK_OF_YOUXI = "{youxi}";
    public static final String TAG = "CoinClickDialog";
    public GamenowDownloadButtomView buttomView;
    public d.a.l0.f.i.k.f.a mDownloadCallback;
    public boolean mIsStatusQuried;
    public boolean isShowMax = false;
    public int coinsThisTime = 0;
    public int coinsTotal = 0;
    public DownloadState mDownloadState = DownloadState.NOT_START;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CheckBox f11640e;

        public a(CheckBox checkBox) {
            this.f11640e = checkBox;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f11640e.isChecked()) {
                CoinClickDialog.this.showNotShowEnsureDialog();
                return;
            }
            d.a.l0.f.j.r.b.n().j("1", CoinClickDialog.this.coinsThisTime, CoinClickDialog.this.coinsTotal);
            CoinClickDialog.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.l0.f.j.r.b.n().j("3", CoinClickDialog.this.coinsThisTime, CoinClickDialog.this.coinsTotal);
            d.a.l0.f.j.n.c.n().s(true);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.f.i.k.f.a {
        public c() {
        }

        @Override // d.a.l0.f.i.k.f.a
        public void a(int i2) {
            d.a.l0.f.j.n.c.n().D(i2);
        }

        @Override // d.a.l0.f.i.k.f.a
        public void b() {
        }

        @Override // d.a.l0.f.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            if (CoinClickDialog.this.mDownloadState == downloadState) {
                return;
            }
            String H = d.a.l0.f.j.b.o.H();
            if (TextUtils.equals(d.a.l0.f.j.b.o.I(), d.a.l0.f.j.m.c.f50548a)) {
                H = d.a.l0.f.j.n.c.n().o();
            }
            String str = H;
            if (CoinClickDialog.this.mDownloadState != DownloadState.DOWNLOAD_PAUSED && CoinClickDialog.this.mDownloadState != DownloadState.DOWNLOAD_FAILED && downloadState == DownloadState.DOWNLOADING) {
                d.a.l0.f.j.r.b.n().e("statusBeginDownload", "wdview", "0", "", "", str);
            } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                if (CoinClickDialog.this.mIsStatusQuried) {
                    d.a.l0.f.j.r.b.n().e("statusDownloadPause", "wdview", "0", "", "", str);
                }
            } else if (downloadState == DownloadState.DOWNLOADED && CoinClickDialog.this.mIsStatusQuried) {
                d.a.l0.f.j.r.b.n().e("statusDownloaded", "wdview", "0", "", "", str);
            }
            d.a.l0.f.j.n.c.n().E(downloadState);
            CoinClickDialog.this.mDownloadState = downloadState;
            CoinClickDialog.this.mIsStatusQuried = true;
        }

        @Override // d.a.l0.f.i.k.f.a
        public void d(String str) {
        }

        @Override // d.a.l0.f.i.k.f.a
        public String e() {
            return d.a.l0.f.j.b.o.I();
        }

        @Override // d.a.l0.f.i.k.f.a
        public void f(boolean z) {
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (i2 == -1) {
                if (TextUtils.equals(d.a.l0.f.j.b.o.I(), d.a.l0.f.j.m.c.f50548a)) {
                    d.a.l0.f.j.b.o.V(true);
                }
                d.a.l0.f.j.r.b.n().j("2", CoinClickDialog.this.coinsThisTime, CoinClickDialog.this.coinsTotal);
                CoinClickDialog.this.finish();
            }
            if (i2 == -2 && TextUtils.equals(d.a.l0.f.j.b.o.I(), d.a.l0.f.j.m.c.f50548a)) {
                ((CheckBox) CoinClickDialog.this.findViewById(h.cb)).setChecked(false);
            }
        }
    }

    private void init(GameGuideConfigInfo gameGuideConfigInfo) {
        TextView textView = (TextView) findViewById(h.tv_content1);
        TextView textView2 = (TextView) findViewById(h.tv_content2);
        TextView textView3 = (TextView) findViewById(h.tv_guide1);
        TextView textView4 = (TextView) findViewById(h.tv_guide2);
        LinearLayout linearLayout = (LinearLayout) findViewById(h.button);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(h.cl_gamenow_introduce);
        ((SimpleDraweeView) findViewById(h.top_icon)).setController(Fresco.newDraweeControllerBuilder().setUri(gameGuideConfigInfo.dialogInfo.iconUrl).setAutoPlayAnimations(true).build());
        if (this.isShowMax) {
            textView.setText(gameGuideConfigInfo.dialogInfo.maxNumsTips);
        } else {
            String str = gameGuideConfigInfo.dialogInfo.content1;
            if (!TextUtils.isEmpty(str) && str.contains(MARK_OF_BENCI)) {
                str = str.replace(MARK_OF_BENCI, String.valueOf(this.coinsThisTime));
            }
            textView.setText(str);
        }
        String str2 = gameGuideConfigInfo.dialogInfo.content2;
        if (!TextUtils.isEmpty(str2) && str2.contains(MARK_OF_LEIJI)) {
            int indexOf = str2.indexOf(MARK_OF_LEIJI);
            String replace = str2.replace(MARK_OF_LEIJI, String.valueOf(this.coinsTotal));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(replace);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF6600")), indexOf, replace.length(), 33);
            textView2.setText(spannableStringBuilder);
        } else {
            textView2.setText(str2);
        }
        String str3 = gameGuideConfigInfo.dialogInfo.guideTips1;
        e Q = e.Q();
        if (!TextUtils.isEmpty(str3) && str3.contains(MARK_OF_YOUXI) && Q != null) {
            Q.r();
            str3 = str3.replace(MARK_OF_YOUXI, Q.O());
        }
        textView3.setText(str3);
        textView4.setText(gameGuideConfigInfo.dialogInfo.guideTips2);
        findViewById(h.iv_close).setOnClickListener(new a((CheckBox) findViewById(h.cb)));
        constraintLayout.setOnClickListener(new b());
        this.mDownloadCallback = new c();
        GamenowDownloadButtomView j = d.a.l0.f.j.n.c.n().j(this.mDownloadCallback, "wdview", "0", this.coinsThisTime, this.coinsTotal);
        this.buttomView = j;
        linearLayout.addView(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotShowEnsureDialog() {
        f fVar = new f(this);
        fVar.f50551e = new d();
        fVar.show();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        d.a.l0.a.v2.f.e(this);
        super.onCreate(bundle);
        setContentView(i.aiapps_coin_click_dialog);
        if (e.Q() != null && f0.p(e.Q().x())) {
            f0.s(this);
        }
        GameGuideConfigInfo z = d.a.l0.f.j.b.o.z();
        if (z != null && z.dialogInfo != null) {
            this.isShowMax = getIntent().getBooleanExtra(KEY_IS_SHOW_MAX, false);
            this.coinsThisTime = getIntent().getIntExtra(KEY_COINS_REWARD_THIS_TIME, 0);
            this.coinsTotal = getIntent().getIntExtra(KEY_COINS_REWARD_TOTAL, 0);
            d.a.l0.f.j.r.b.n().k(this.coinsThisTime, this.coinsTotal);
            init(z);
            return;
        }
        if (k.f46875a) {
            Log.d(TAG, "获取到的配置信息为null");
        }
        finish();
    }
}
