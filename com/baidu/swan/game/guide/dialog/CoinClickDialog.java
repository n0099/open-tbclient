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
import com.baidu.tieba.am1;
import com.baidu.tieba.lw3;
import com.baidu.tieba.ov3;
import com.baidu.tieba.p53;
import com.baidu.tieba.qt3;
import com.baidu.tieba.tv3;
import com.baidu.tieba.wv3;
import com.baidu.tieba.yh3;
import com.baidu.tieba.yi3;
import com.baidu.tieba.zv3;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
@SuppressLint({"BaseActivity"})
/* loaded from: classes4.dex */
public class CoinClickDialog extends Activity {
    public GamenowDownloadButtomView d;
    public qt3 e;
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
            lw3.n().j("1", CoinClickDialog.this.b, CoinClickDialog.this.c);
            CoinClickDialog.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            lw3.n().j("3", CoinClickDialog.this.b, CoinClickDialog.this.c);
            zv3.n().s(true);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements qt3 {
        @Override // com.baidu.tieba.qt3
        public void b() {
        }

        @Override // com.baidu.tieba.qt3
        public void d(String str) {
        }

        @Override // com.baidu.tieba.qt3
        public void f(boolean z) {
        }

        public c() {
        }

        @Override // com.baidu.tieba.qt3
        public void a(int i) {
            zv3.n().D(i);
        }

        @Override // com.baidu.tieba.qt3
        public void c(DownloadState downloadState, int i) {
            if (CoinClickDialog.this.f == downloadState) {
                return;
            }
            String H = ov3.o.H();
            if (TextUtils.equals(ov3.o.I(), tv3.a)) {
                H = zv3.n().o();
            }
            String str = H;
            if (CoinClickDialog.this.f != DownloadState.DOWNLOAD_PAUSED && CoinClickDialog.this.f != DownloadState.DOWNLOAD_FAILED && downloadState == DownloadState.DOWNLOADING) {
                lw3.n().e("statusBeginDownload", "wdview", "0", "", "", str);
            } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                if (CoinClickDialog.this.g) {
                    lw3.n().e("statusDownloadPause", "wdview", "0", "", "", str);
                }
            } else if (downloadState == DownloadState.DOWNLOADED && CoinClickDialog.this.g) {
                lw3.n().e("statusDownloaded", "wdview", "0", "", "", str);
            }
            zv3.n().E(downloadState);
            CoinClickDialog.this.f = downloadState;
            CoinClickDialog.this.g = true;
        }

        @Override // com.baidu.tieba.qt3
        public String e() {
            return ov3.o.I();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -1) {
                if (TextUtils.equals(ov3.o.I(), tv3.a)) {
                    ov3.o.V(true);
                }
                lw3.n().j("2", CoinClickDialog.this.b, CoinClickDialog.this.c);
                CoinClickDialog.this.finish();
            }
            if (i == -2 && TextUtils.equals(ov3.o.I(), tv3.a)) {
                ((CheckBox) CoinClickDialog.this.findViewById(R.id.obfuscated_res_0x7f090666)).setChecked(false);
            }
        }
    }

    public final void i() {
        wv3 wv3Var = new wv3(this);
        wv3Var.a = new d();
        wv3Var.show();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        zv3.n().t();
    }

    public final void h(GameGuideConfigInfo gameGuideConfigInfo) {
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09270c);
        TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f09270d);
        TextView textView3 = (TextView) findViewById(R.id.obfuscated_res_0x7f092734);
        TextView textView4 = (TextView) findViewById(R.id.obfuscated_res_0x7f092735);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090524);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.obfuscated_res_0x7f090727);
        ((SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f09263c)).setController(Fresco.newDraweeControllerBuilder().setUri(gameGuideConfigInfo.dialogInfo.iconUrl).setAutoPlayAnimations(true).build());
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
        p53 c0 = p53.c0();
        if (!TextUtils.isEmpty(str3) && str3.contains("{youxi}") && c0 != null) {
            c0.q();
            str3 = str3.replace("{youxi}", c0.a0());
        }
        textView3.setText(str3);
        textView4.setText(gameGuideConfigInfo.dialogInfo.guideTips2);
        findViewById(R.id.obfuscated_res_0x7f09121d).setOnClickListener(new a((CheckBox) findViewById(R.id.obfuscated_res_0x7f090666)));
        constraintLayout.setOnClickListener(new b());
        this.e = new c();
        GamenowDownloadButtomView j = zv3.n().j(this.e, "wdview", "0", this.b, this.c);
        this.d = j;
        linearLayout.addView(j);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        yh3.e(this);
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d00a1);
        if (p53.c0() != null && yi3.p(p53.c0().w())) {
            yi3.s(this);
        }
        GameGuideConfigInfo z = ov3.o.z();
        if (z != null && z.dialogInfo != null) {
            this.a = getIntent().getBooleanExtra("isShowMax", false);
            this.b = getIntent().getIntExtra("rewardCoinsThisTime", 0);
            this.c = getIntent().getIntExtra("totalRewardCoins", 0);
            lw3.n().k(this.b, this.c);
            h(z);
            return;
        }
        if (am1.a) {
            Log.d("CoinClickDialog", "获取到的配置信息为null");
        }
        finish();
    }
}
