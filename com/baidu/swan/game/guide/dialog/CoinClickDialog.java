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
import com.repackage.er3;
import com.repackage.hq3;
import com.repackage.j03;
import com.repackage.jo3;
import com.repackage.mq3;
import com.repackage.pq3;
import com.repackage.sc3;
import com.repackage.sd3;
import com.repackage.sq3;
import com.repackage.tg1;
@SuppressLint({"BaseActivity"})
/* loaded from: classes2.dex */
public class CoinClickDialog extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_COINS_REWARD_THIS_TIME = "rewardCoinsThisTime";
    public static final String KEY_COINS_REWARD_TOTAL = "totalRewardCoins";
    public static final String KEY_IS_SHOW_MAX = "isShowMax";
    public static final String MARK_OF_BENCI = "{benci}";
    public static final String MARK_OF_LEIJI = "{leiji}";
    public static final String MARK_OF_YOUXI = "{youxi}";
    public static final String TAG = "CoinClickDialog";
    public transient /* synthetic */ FieldHolder $fh;
    public GamenowDownloadButtomView buttomView;
    public int coinsThisTime;
    public int coinsTotal;
    public boolean isShowMax;
    public jo3 mDownloadCallback;
    public DownloadState mDownloadState;
    public boolean mIsStatusQuried;

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
                    this.b.showNotShowEnsureDialog();
                    return;
                }
                er3.n().j("1", this.b.coinsThisTime, this.b.coinsTotal);
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
                er3.n().j("3", this.a.coinsThisTime, this.a.coinsTotal);
                sq3.n().s(true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements jo3 {
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

        @Override // com.repackage.jo3
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                sq3.n().D(i);
            }
        }

        @Override // com.repackage.jo3
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.repackage.jo3
        public void c(DownloadState downloadState, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i) == null) || this.a.mDownloadState == downloadState) {
                return;
            }
            String H = hq3.o.H();
            if (TextUtils.equals(hq3.o.I(), mq3.a)) {
                H = sq3.n().o();
            }
            String str = H;
            if (this.a.mDownloadState != DownloadState.DOWNLOAD_PAUSED && this.a.mDownloadState != DownloadState.DOWNLOAD_FAILED && downloadState == DownloadState.DOWNLOADING) {
                er3.n().e("statusBeginDownload", "wdview", "0", "", "", str);
            } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                if (this.a.mIsStatusQuried) {
                    er3.n().e("statusDownloadPause", "wdview", "0", "", "", str);
                }
            } else if (downloadState == DownloadState.DOWNLOADED && this.a.mIsStatusQuried) {
                er3.n().e("statusDownloaded", "wdview", "0", "", "", str);
            }
            sq3.n().E(downloadState);
            this.a.mDownloadState = downloadState;
            this.a.mIsStatusQuried = true;
        }

        @Override // com.repackage.jo3
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            }
        }

        @Override // com.repackage.jo3
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? hq3.o.I() : (String) invokeV.objValue;
        }

        @Override // com.repackage.jo3
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
                    if (TextUtils.equals(hq3.o.I(), mq3.a)) {
                        hq3.o.V(true);
                    }
                    er3.n().j("2", this.a.coinsThisTime, this.a.coinsTotal);
                    this.a.finish();
                }
                if (i == -2 && TextUtils.equals(hq3.o.I(), mq3.a)) {
                    ((CheckBox) this.a.findViewById(R.id.obfuscated_res_0x7f0905af)).setChecked(false);
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
        this.isShowMax = false;
        this.coinsThisTime = 0;
        this.coinsTotal = 0;
        this.mDownloadState = DownloadState.NOT_START;
    }

    private void init(GameGuideConfigInfo gameGuideConfigInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, gameGuideConfigInfo) == null) {
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09217e);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f09217f);
            TextView textView3 = (TextView) findViewById(R.id.obfuscated_res_0x7f0921a1);
            TextView textView4 = (TextView) findViewById(R.id.obfuscated_res_0x7f0921a2);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090464);
            ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.obfuscated_res_0x7f090658);
            ((SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f09209f)).setController(Fresco.newDraweeControllerBuilder().setUri(gameGuideConfigInfo.dialogInfo.iconUrl).setAutoPlayAnimations(true).build());
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
            j03 a0 = j03.a0();
            if (!TextUtils.isEmpty(str3) && str3.contains(MARK_OF_YOUXI) && a0 != null) {
                a0.r();
                str3 = str3.replace(MARK_OF_YOUXI, a0.Y());
            }
            textView3.setText(str3);
            textView4.setText(gameGuideConfigInfo.dialogInfo.guideTips2);
            findViewById(R.id.obfuscated_res_0x7f090fc0).setOnClickListener(new a(this, (CheckBox) findViewById(R.id.obfuscated_res_0x7f0905af)));
            constraintLayout.setOnClickListener(new b(this));
            this.mDownloadCallback = new c(this);
            GamenowDownloadButtomView j = sq3.n().j(this.mDownloadCallback, "wdview", "0", this.coinsThisTime, this.coinsTotal);
            this.buttomView = j;
            linearLayout.addView(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotShowEnsureDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            pq3 pq3Var = new pq3(this);
            pq3Var.a = new d(this);
            pq3Var.show();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            sc3.e(this);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d00a1);
            if (j03.a0() != null && sd3.p(j03.a0().x())) {
                sd3.s(this);
            }
            GameGuideConfigInfo z = hq3.o.z();
            if (z != null && z.dialogInfo != null) {
                this.isShowMax = getIntent().getBooleanExtra(KEY_IS_SHOW_MAX, false);
                this.coinsThisTime = getIntent().getIntExtra(KEY_COINS_REWARD_THIS_TIME, 0);
                this.coinsTotal = getIntent().getIntExtra(KEY_COINS_REWARD_TOTAL, 0);
                er3.n().k(this.coinsThisTime, this.coinsTotal);
                init(z);
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            if (tg1.a) {
                Log.d(TAG, "获取到的配置信息为null");
            }
            finish();
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onResume();
            sq3.n().t();
        }
    }
}
