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
import com.baidu.tieba.ay3;
import com.baidu.tieba.ck3;
import com.baidu.tieba.cl3;
import com.baidu.tieba.do1;
import com.baidu.tieba.dy3;
import com.baidu.tieba.py3;
import com.baidu.tieba.sx3;
import com.baidu.tieba.t73;
import com.baidu.tieba.uv3;
import com.baidu.tieba.xx3;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
@SuppressLint({"BaseActivity"})
/* loaded from: classes3.dex */
public class CoinClickDialog extends Activity {
    public GamenowDownloadButtomView d;
    public uv3 e;
    public boolean g;
    public boolean a = false;
    public int b = 0;
    public int c = 0;
    public DownloadState f = DownloadState.NOT_START;

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    /* loaded from: classes3.dex */
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
            py3.n().j("1", CoinClickDialog.this.b, CoinClickDialog.this.c);
            CoinClickDialog.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            py3.n().j("3", CoinClickDialog.this.b, CoinClickDialog.this.c);
            dy3.n().s(true);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements uv3 {
        @Override // com.baidu.tieba.uv3
        public void b() {
        }

        @Override // com.baidu.tieba.uv3
        public void d(String str) {
        }

        @Override // com.baidu.tieba.uv3
        public void f(boolean z) {
        }

        public c() {
        }

        @Override // com.baidu.tieba.uv3
        public void a(int i) {
            dy3.n().D(i);
        }

        @Override // com.baidu.tieba.uv3
        public void c(DownloadState downloadState, int i) {
            if (CoinClickDialog.this.f == downloadState) {
                return;
            }
            String H = sx3.o.H();
            if (TextUtils.equals(sx3.o.I(), xx3.a)) {
                H = dy3.n().o();
            }
            String str = H;
            if (CoinClickDialog.this.f != DownloadState.DOWNLOAD_PAUSED && CoinClickDialog.this.f != DownloadState.DOWNLOAD_FAILED && downloadState == DownloadState.DOWNLOADING) {
                py3.n().e("statusBeginDownload", "wdview", "0", "", "", str);
            } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                if (CoinClickDialog.this.g) {
                    py3.n().e("statusDownloadPause", "wdview", "0", "", "", str);
                }
            } else if (downloadState == DownloadState.DOWNLOADED && CoinClickDialog.this.g) {
                py3.n().e("statusDownloaded", "wdview", "0", "", "", str);
            }
            dy3.n().E(downloadState);
            CoinClickDialog.this.f = downloadState;
            CoinClickDialog.this.g = true;
        }

        @Override // com.baidu.tieba.uv3
        public String e() {
            return sx3.o.I();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -1) {
                if (TextUtils.equals(sx3.o.I(), xx3.a)) {
                    sx3.o.V(true);
                }
                py3.n().j("2", CoinClickDialog.this.b, CoinClickDialog.this.c);
                CoinClickDialog.this.finish();
            }
            if (i == -2 && TextUtils.equals(sx3.o.I(), xx3.a)) {
                ((CheckBox) CoinClickDialog.this.findViewById(R.id.obfuscated_res_0x7f09061f)).setChecked(false);
            }
        }
    }

    public final void i() {
        ay3 ay3Var = new ay3(this);
        ay3Var.a = new d();
        ay3Var.show();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        dy3.n().t();
    }

    public final void h(GameGuideConfigInfo gameGuideConfigInfo) {
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092575);
        TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f092576);
        TextView textView3 = (TextView) findViewById(R.id.obfuscated_res_0x7f09259d);
        TextView textView4 = (TextView) findViewById(R.id.obfuscated_res_0x7f09259e);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0904f3);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.obfuscated_res_0x7f0906de);
        ((SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f09248a)).setController(Fresco.newDraweeControllerBuilder().setUri(gameGuideConfigInfo.dialogInfo.iconUrl).setAutoPlayAnimations(true).build());
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
        t73 b0 = t73.b0();
        if (!TextUtils.isEmpty(str3) && str3.contains("{youxi}") && b0 != null) {
            b0.q();
            str3 = str3.replace("{youxi}", b0.Z());
        }
        textView3.setText(str3);
        textView4.setText(gameGuideConfigInfo.dialogInfo.guideTips2);
        findViewById(R.id.obfuscated_res_0x7f091161).setOnClickListener(new a((CheckBox) findViewById(R.id.obfuscated_res_0x7f09061f)));
        constraintLayout.setOnClickListener(new b());
        this.e = new c();
        GamenowDownloadButtomView j = dy3.n().j(this.e, "wdview", "0", this.b, this.c);
        this.d = j;
        linearLayout.addView(j);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        ck3.e(this);
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d009e);
        if (t73.b0() != null && cl3.p(t73.b0().w())) {
            cl3.s(this);
        }
        GameGuideConfigInfo z = sx3.o.z();
        if (z != null && z.dialogInfo != null) {
            this.a = getIntent().getBooleanExtra("isShowMax", false);
            this.b = getIntent().getIntExtra("rewardCoinsThisTime", 0);
            this.c = getIntent().getIntExtra("totalRewardCoins", 0);
            py3.n().k(this.b, this.c);
            h(z);
            return;
        }
        if (do1.a) {
            Log.d("CoinClickDialog", "获取到的配置信息为null");
        }
        finish();
    }
}
