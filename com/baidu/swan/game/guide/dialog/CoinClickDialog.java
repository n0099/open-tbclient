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
import com.baidu.tieba.dx3;
import com.baidu.tieba.gw3;
import com.baidu.tieba.h63;
import com.baidu.tieba.iu3;
import com.baidu.tieba.lw3;
import com.baidu.tieba.ow3;
import com.baidu.tieba.qi3;
import com.baidu.tieba.qj3;
import com.baidu.tieba.rw3;
import com.baidu.tieba.sm1;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
@SuppressLint({"BaseActivity"})
/* loaded from: classes4.dex */
public class CoinClickDialog extends Activity {
    public GamenowDownloadButtomView d;
    public iu3 e;
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
            dx3.n().j("1", CoinClickDialog.this.b, CoinClickDialog.this.c);
            CoinClickDialog.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            dx3.n().j("3", CoinClickDialog.this.b, CoinClickDialog.this.c);
            rw3.n().s(true);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements iu3 {
        @Override // com.baidu.tieba.iu3
        public void b() {
        }

        @Override // com.baidu.tieba.iu3
        public void d(String str) {
        }

        @Override // com.baidu.tieba.iu3
        public void f(boolean z) {
        }

        public c() {
        }

        @Override // com.baidu.tieba.iu3
        public void a(int i) {
            rw3.n().D(i);
        }

        @Override // com.baidu.tieba.iu3
        public void c(DownloadState downloadState, int i) {
            if (CoinClickDialog.this.f == downloadState) {
                return;
            }
            String H = gw3.o.H();
            if (TextUtils.equals(gw3.o.I(), lw3.a)) {
                H = rw3.n().o();
            }
            String str = H;
            if (CoinClickDialog.this.f != DownloadState.DOWNLOAD_PAUSED && CoinClickDialog.this.f != DownloadState.DOWNLOAD_FAILED && downloadState == DownloadState.DOWNLOADING) {
                dx3.n().e("statusBeginDownload", "wdview", "0", "", "", str);
            } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                if (CoinClickDialog.this.g) {
                    dx3.n().e("statusDownloadPause", "wdview", "0", "", "", str);
                }
            } else if (downloadState == DownloadState.DOWNLOADED && CoinClickDialog.this.g) {
                dx3.n().e("statusDownloaded", "wdview", "0", "", "", str);
            }
            rw3.n().E(downloadState);
            CoinClickDialog.this.f = downloadState;
            CoinClickDialog.this.g = true;
        }

        @Override // com.baidu.tieba.iu3
        public String e() {
            return gw3.o.I();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -1) {
                if (TextUtils.equals(gw3.o.I(), lw3.a)) {
                    gw3.o.V(true);
                }
                dx3.n().j("2", CoinClickDialog.this.b, CoinClickDialog.this.c);
                CoinClickDialog.this.finish();
            }
            if (i == -2 && TextUtils.equals(gw3.o.I(), lw3.a)) {
                ((CheckBox) CoinClickDialog.this.findViewById(R.id.obfuscated_res_0x7f0906a1)).setChecked(false);
            }
        }
    }

    public final void i() {
        ow3 ow3Var = new ow3(this);
        ow3Var.a = new d();
        ow3Var.show();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        rw3.n().t();
    }

    public final void h(GameGuideConfigInfo gameGuideConfigInfo) {
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0927ee);
        TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f0927ef);
        TextView textView3 = (TextView) findViewById(R.id.obfuscated_res_0x7f092816);
        TextView textView4 = (TextView) findViewById(R.id.obfuscated_res_0x7f092817);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09055d);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.obfuscated_res_0x7f090762);
        ((SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f092719)).setController(Fresco.newDraweeControllerBuilder().setUri(gameGuideConfigInfo.dialogInfo.iconUrl).setAutoPlayAnimations(true).build());
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
        h63 c0 = h63.c0();
        if (!TextUtils.isEmpty(str3) && str3.contains("{youxi}") && c0 != null) {
            c0.q();
            str3 = str3.replace("{youxi}", c0.a0());
        }
        textView3.setText(str3);
        textView4.setText(gameGuideConfigInfo.dialogInfo.guideTips2);
        findViewById(R.id.obfuscated_res_0x7f091284).setOnClickListener(new a((CheckBox) findViewById(R.id.obfuscated_res_0x7f0906a1)));
        constraintLayout.setOnClickListener(new b());
        this.e = new c();
        GamenowDownloadButtomView j = rw3.n().j(this.e, "wdview", "0", this.b, this.c);
        this.d = j;
        linearLayout.addView(j);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        qi3.e(this);
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d00a4);
        if (h63.c0() != null && qj3.p(h63.c0().w())) {
            qj3.s(this);
        }
        GameGuideConfigInfo z = gw3.o.z();
        if (z != null && z.dialogInfo != null) {
            this.a = getIntent().getBooleanExtra("isShowMax", false);
            this.b = getIntent().getIntExtra("rewardCoinsThisTime", 0);
            this.c = getIntent().getIntExtra("totalRewardCoins", 0);
            dx3.n().k(this.b, this.c);
            h(z);
            return;
        }
        if (sm1.a) {
            Log.d("CoinClickDialog", "获取到的配置信息为null");
        }
        finish();
    }
}
