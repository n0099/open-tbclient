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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.download.GamenowDownloadButtomView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.repackage.cr3;
import com.repackage.fq3;
import com.repackage.h03;
import com.repackage.ho3;
import com.repackage.kq3;
import com.repackage.nq3;
import com.repackage.qc3;
import com.repackage.qd3;
import com.repackage.qq3;
import com.repackage.rg1;
import com.sina.weibo.sdk.share.BaseActivity;
@SuppressLint({BaseActivity.TAG})
/* loaded from: classes2.dex */
public class CoinClickDialog extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public int c;
    public GamenowDownloadButtomView d;
    public ho3 e;
    public DownloadState f;
    public boolean g;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CheckBox a;
        public final /* synthetic */ CoinClickDialog b;

        public a(CoinClickDialog coinClickDialog, CheckBox checkBox) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coinClickDialog, checkBox};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = coinClickDialog;
            this.a = checkBox;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.isChecked()) {
                    this.b.i();
                    return;
                }
                cr3.n().j("1", this.b.b, this.b.c);
                this.b.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoinClickDialog a;

        public b(CoinClickDialog coinClickDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coinClickDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coinClickDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                cr3.n().j("3", this.a.b, this.a.c);
                qq3.n().s(true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ho3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoinClickDialog a;

        public c(CoinClickDialog coinClickDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coinClickDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coinClickDialog;
        }

        @Override // com.repackage.ho3
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                qq3.n().D(i);
            }
        }

        @Override // com.repackage.ho3
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.repackage.ho3
        public void c(DownloadState downloadState, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i) == null) || this.a.f == downloadState) {
                return;
            }
            String H = fq3.o.H();
            if (TextUtils.equals(fq3.o.I(), kq3.a)) {
                H = qq3.n().o();
            }
            String str = H;
            if (this.a.f != DownloadState.DOWNLOAD_PAUSED && this.a.f != DownloadState.DOWNLOAD_FAILED && downloadState == DownloadState.DOWNLOADING) {
                cr3.n().e("statusBeginDownload", "wdview", "0", "", "", str);
            } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                if (this.a.g) {
                    cr3.n().e("statusDownloadPause", "wdview", "0", "", "", str);
                }
            } else if (downloadState == DownloadState.DOWNLOADED && this.a.g) {
                cr3.n().e("statusDownloaded", "wdview", "0", "", "", str);
            }
            qq3.n().E(downloadState);
            this.a.f = downloadState;
            this.a.g = true;
        }

        @Override // com.repackage.ho3
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            }
        }

        @Override // com.repackage.ho3
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? fq3.o.I() : (String) invokeV.objValue;
        }

        @Override // com.repackage.ho3
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoinClickDialog a;

        public d(CoinClickDialog coinClickDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coinClickDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coinClickDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                if (i == -1) {
                    if (TextUtils.equals(fq3.o.I(), kq3.a)) {
                        fq3.o.V(true);
                    }
                    cr3.n().j("2", this.a.b, this.a.c);
                    this.a.finish();
                }
                if (i == -2 && TextUtils.equals(fq3.o.I(), kq3.a)) {
                    ((CheckBox) this.a.findViewById(R.id.obfuscated_res_0x7f090588)).setChecked(false);
                }
            }
        }
    }

    public CoinClickDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = 0;
        this.c = 0;
        this.f = DownloadState.NOT_START;
    }

    public final void h(GameGuideConfigInfo gameGuideConfigInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gameGuideConfigInfo) == null) {
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09221a);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f09221b);
            TextView textView3 = (TextView) findViewById(R.id.obfuscated_res_0x7f09223d);
            TextView textView4 = (TextView) findViewById(R.id.obfuscated_res_0x7f09223e);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090457);
            ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.obfuscated_res_0x7f090613);
            ((SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f092141)).setController(Fresco.newDraweeControllerBuilder().setUri(gameGuideConfigInfo.dialogInfo.iconUrl).setAutoPlayAnimations(true).build());
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
            h03 b0 = h03.b0();
            if (!TextUtils.isEmpty(str3) && str3.contains("{youxi}") && b0 != null) {
                b0.q();
                str3 = str3.replace("{youxi}", b0.Z());
            }
            textView3.setText(str3);
            textView4.setText(gameGuideConfigInfo.dialogInfo.guideTips2);
            findViewById(R.id.obfuscated_res_0x7f090f8f).setOnClickListener(new a(this, (CheckBox) findViewById(R.id.obfuscated_res_0x7f090588)));
            constraintLayout.setOnClickListener(new b(this));
            this.e = new c(this);
            GamenowDownloadButtomView j = qq3.n().j(this.e, "wdview", "0", this.b, this.c);
            this.d = j;
            linearLayout.addView(j);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            nq3 nq3Var = new nq3(this);
            nq3Var.a = new d(this);
            nq3Var.show();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            qc3.e(this);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0098);
            if (h03.b0() != null && qd3.p(h03.b0().w())) {
                qd3.s(this);
            }
            GameGuideConfigInfo z = fq3.o.z();
            if (z != null && z.dialogInfo != null) {
                this.a = getIntent().getBooleanExtra("isShowMax", false);
                this.b = getIntent().getIntExtra("rewardCoinsThisTime", 0);
                this.c = getIntent().getIntExtra("totalRewardCoins", 0);
                cr3.n().k(this.b, this.c);
                h(z);
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            if (rg1.a) {
                Log.d("CoinClickDialog", "获取到的配置信息为null");
            }
            finish();
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            qq3.n().t();
        }
    }
}
