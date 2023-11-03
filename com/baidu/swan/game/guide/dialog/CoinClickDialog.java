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
import com.baidu.tieba.R;
import com.baidu.tieba.cx3;
import com.baidu.tieba.fw3;
import com.baidu.tieba.g63;
import com.baidu.tieba.hu3;
import com.baidu.tieba.kw3;
import com.baidu.tieba.nw3;
import com.baidu.tieba.pi3;
import com.baidu.tieba.pj3;
import com.baidu.tieba.qw3;
import com.baidu.tieba.rm1;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
@SuppressLint({"BaseActivity"})
/* loaded from: classes4.dex */
public class CoinClickDialog extends Activity {
    public GamenowDownloadButtomView d;
    public hu3 e;
    public boolean g;
    public boolean a = false;
    public int b = 0;
    public int c = 0;
    public DownloadState f = DownloadState.NOT_START;

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ CheckBox a;

        public a(CheckBox checkBox) {
            this.a = checkBox;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (this.a.isChecked()) {
                CoinClickDialog.this.i();
                return;
            }
            cx3.n().j("1", CoinClickDialog.this.b, CoinClickDialog.this.c);
            CoinClickDialog.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            cx3.n().j("3", CoinClickDialog.this.b, CoinClickDialog.this.c);
            qw3.n().s(true);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements hu3 {
        @Override // com.baidu.tieba.hu3
        public void b() {
        }

        @Override // com.baidu.tieba.hu3
        public void d(String str) {
        }

        @Override // com.baidu.tieba.hu3
        public void f(boolean z) {
        }

        public c() {
        }

        @Override // com.baidu.tieba.hu3
        public void a(int i) {
            qw3.n().D(i);
        }

        @Override // com.baidu.tieba.hu3
        public void c(DownloadState downloadState, int i) {
            if (CoinClickDialog.this.f == downloadState) {
                return;
            }
            String H = fw3.o.H();
            if (TextUtils.equals(fw3.o.I(), kw3.a)) {
                H = qw3.n().o();
            }
            String str = H;
            if (CoinClickDialog.this.f != DownloadState.DOWNLOAD_PAUSED && CoinClickDialog.this.f != DownloadState.DOWNLOAD_FAILED && downloadState == DownloadState.DOWNLOADING) {
                cx3.n().e("statusBeginDownload", "wdview", "0", "", "", str);
            } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                if (CoinClickDialog.this.g) {
                    cx3.n().e("statusDownloadPause", "wdview", "0", "", "", str);
                }
            } else if (downloadState == DownloadState.DOWNLOADED && CoinClickDialog.this.g) {
                cx3.n().e("statusDownloaded", "wdview", "0", "", "", str);
            }
            qw3.n().E(downloadState);
            CoinClickDialog.this.f = downloadState;
            CoinClickDialog.this.g = true;
        }

        @Override // com.baidu.tieba.hu3
        public String e() {
            return fw3.o.I();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -1) {
                if (TextUtils.equals(fw3.o.I(), kw3.a)) {
                    fw3.o.V(true);
                }
                cx3.n().j("2", CoinClickDialog.this.b, CoinClickDialog.this.c);
                CoinClickDialog.this.finish();
            }
            if (i == -2 && TextUtils.equals(fw3.o.I(), kw3.a)) {
                ((CheckBox) CoinClickDialog.this.findViewById(R.id.obfuscated_res_0x7f090685)).setChecked(false);
            }
        }
    }

    public final void i() {
        nw3 nw3Var = new nw3(this);
        nw3Var.a = new d();
        nw3Var.show();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        qw3.n().t();
    }

    public final void h(GameGuideConfigInfo gameGuideConfigInfo) {
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09276b);
        TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f09276c);
        TextView textView3 = (TextView) findViewById(R.id.obfuscated_res_0x7f092793);
        TextView textView4 = (TextView) findViewById(R.id.obfuscated_res_0x7f092794);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090542);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.obfuscated_res_0x7f090746);
        ((SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f092696)).setController(Fresco.newDraweeControllerBuilder().setUri(gameGuideConfigInfo.dialogInfo.iconUrl).setAutoPlayAnimations(true).build());
        if (this.a) {
            textView.setText(gameGuideConfigInfo.dialogInfo.maxNumsTips);
        } else {
            String str = gameGuideConfigInfo.dialogInfo.content1;
            if (!TextUtils.isEmpty(str) && str.contains("{benci}")) {
                str = str.replace("{benci}", String.valueOf(this.b));
            }
            textView.setText(str);
        }
        String str2 = gameGuideConfigInfo.dialogInfo.content2;
        if (!TextUtils.isEmpty(str2) && str2.contains("{leiji}")) {
            int indexOf = str2.indexOf("{leiji}");
            String replace = str2.replace("{leiji}", String.valueOf(this.c));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(replace);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF6600")), indexOf, replace.length(), 33);
            textView2.setText(spannableStringBuilder);
        } else {
            textView2.setText(str2);
        }
        String str3 = gameGuideConfigInfo.dialogInfo.guideTips1;
        g63 c0 = g63.c0();
        if (!TextUtils.isEmpty(str3) && str3.contains("{youxi}") && c0 != null) {
            c0.q();
            str3 = str3.replace("{youxi}", c0.a0());
        }
        textView3.setText(str3);
        textView4.setText(gameGuideConfigInfo.dialogInfo.guideTips2);
        findViewById(R.id.obfuscated_res_0x7f09125b).setOnClickListener(new a((CheckBox) findViewById(R.id.obfuscated_res_0x7f090685)));
        constraintLayout.setOnClickListener(new b());
        this.e = new c();
        GamenowDownloadButtomView j = qw3.n().j(this.e, "wdview", "0", this.b, this.c);
        this.d = j;
        linearLayout.addView(j);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        pi3.e(this);
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d00a3);
        if (g63.c0() != null && pj3.p(g63.c0().w())) {
            pj3.s(this);
        }
        GameGuideConfigInfo z = fw3.o.z();
        if (z != null && z.dialogInfo != null) {
            this.a = getIntent().getBooleanExtra("isShowMax", false);
            this.b = getIntent().getIntExtra("rewardCoinsThisTime", 0);
            this.c = getIntent().getIntExtra("totalRewardCoins", 0);
            cx3.n().k(this.b, this.c);
            h(z);
            return;
        }
        if (rm1.a) {
            Log.d("CoinClickDialog", "获取到的配置信息为null");
        }
        finish();
    }
}
