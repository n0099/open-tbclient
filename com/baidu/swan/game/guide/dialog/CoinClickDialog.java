package com.baidu.swan.game.guide.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import c.a.n0.a.a2.e;
import c.a.n0.a.k;
import c.a.n0.a.v2.f;
import c.a.n0.a.v2.f0;
import c.a.n0.f.j.h;
import c.a.n0.f.j.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.download.GamenowDownloadButtomView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
@SuppressLint({"BaseActivity"})
/* loaded from: classes6.dex */
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
    public c.a.n0.f.i.k.f.a mDownloadCallback;
    public DownloadState mDownloadState;
    public boolean mIsStatusQuried;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CheckBox f46718e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CoinClickDialog f46719f;

        public a(CoinClickDialog coinClickDialog, CheckBox checkBox) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coinClickDialog, checkBox};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46719f = coinClickDialog;
            this.f46718e = checkBox;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f46718e.isChecked()) {
                    this.f46719f.showNotShowEnsureDialog();
                    return;
                }
                c.a.n0.f.j.r.b.n().j("1", this.f46719f.coinsThisTime, this.f46719f.coinsTotal);
                this.f46719f.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoinClickDialog f46720e;

        public b(CoinClickDialog coinClickDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coinClickDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46720e = coinClickDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.n0.f.j.r.b.n().j("3", this.f46720e.coinsThisTime, this.f46720e.coinsTotal);
                c.a.n0.f.j.n.c.n().s(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.a.n0.f.i.k.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CoinClickDialog f46721a;

        public c(CoinClickDialog coinClickDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coinClickDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46721a = coinClickDialog;
        }

        @Override // c.a.n0.f.i.k.f.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                c.a.n0.f.j.n.c.n().D(i2);
            }
        }

        @Override // c.a.n0.f.i.k.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.n0.f.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) || this.f46721a.mDownloadState == downloadState) {
                return;
            }
            String H = c.a.n0.f.j.b.o.H();
            if (TextUtils.equals(c.a.n0.f.j.b.o.I(), c.a.n0.f.j.m.c.f10457a)) {
                H = c.a.n0.f.j.n.c.n().o();
            }
            String str = H;
            if (this.f46721a.mDownloadState != DownloadState.DOWNLOAD_PAUSED && this.f46721a.mDownloadState != DownloadState.DOWNLOAD_FAILED && downloadState == DownloadState.DOWNLOADING) {
                c.a.n0.f.j.r.b.n().e("statusBeginDownload", "wdview", "0", "", "", str);
            } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                if (this.f46721a.mIsStatusQuried) {
                    c.a.n0.f.j.r.b.n().e("statusDownloadPause", "wdview", "0", "", "", str);
                }
            } else if (downloadState == DownloadState.DOWNLOADED && this.f46721a.mIsStatusQuried) {
                c.a.n0.f.j.r.b.n().e("statusDownloaded", "wdview", "0", "", "", str);
            }
            c.a.n0.f.j.n.c.n().E(downloadState);
            this.f46721a.mDownloadState = downloadState;
            this.f46721a.mIsStatusQuried = true;
        }

        @Override // c.a.n0.f.i.k.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            }
        }

        @Override // c.a.n0.f.i.k.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c.a.n0.f.j.b.o.I() : (String) invokeV.objValue;
        }

        @Override // c.a.n0.f.i.k.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoinClickDialog f46722e;

        public d(CoinClickDialog coinClickDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coinClickDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46722e = coinClickDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                if (i2 == -1) {
                    if (TextUtils.equals(c.a.n0.f.j.b.o.I(), c.a.n0.f.j.m.c.f10457a)) {
                        c.a.n0.f.j.b.o.V(true);
                    }
                    c.a.n0.f.j.r.b.n().j("2", this.f46722e.coinsThisTime, this.f46722e.coinsTotal);
                    this.f46722e.finish();
                }
                if (i2 == -2 && TextUtils.equals(c.a.n0.f.j.b.o.I(), c.a.n0.f.j.m.c.f10457a)) {
                    ((CheckBox) this.f46722e.findViewById(h.cb)).setChecked(false);
                }
            }
        }
    }

    public CoinClickDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            findViewById(h.iv_close).setOnClickListener(new a(this, (CheckBox) findViewById(h.cb)));
            constraintLayout.setOnClickListener(new b(this));
            this.mDownloadCallback = new c(this);
            GamenowDownloadButtomView j2 = c.a.n0.f.j.n.c.n().j(this.mDownloadCallback, "wdview", "0", this.coinsThisTime, this.coinsTotal);
            this.buttomView = j2;
            linearLayout.addView(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotShowEnsureDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            GuideViewNotShowEnsureDialog guideViewNotShowEnsureDialog = new GuideViewNotShowEnsureDialog(this);
            guideViewNotShowEnsureDialog.clickListener = new d(this);
            guideViewNotShowEnsureDialog.show();
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
            f.e(this);
            super.onCreate(bundle);
            setContentView(i.aiapps_coin_click_dialog);
            if (e.Q() != null && f0.p(e.Q().x())) {
                f0.s(this);
            }
            GameGuideConfigInfo z = c.a.n0.f.j.b.o.z();
            if (z != null && z.dialogInfo != null) {
                this.isShowMax = getIntent().getBooleanExtra(KEY_IS_SHOW_MAX, false);
                this.coinsThisTime = getIntent().getIntExtra(KEY_COINS_REWARD_THIS_TIME, 0);
                this.coinsTotal = getIntent().getIntExtra(KEY_COINS_REWARD_TOTAL, 0);
                c.a.n0.f.j.r.b.n().k(this.coinsThisTime, this.coinsTotal);
                init(z);
                return;
            }
            boolean z2 = k.f6803a;
            finish();
        }
    }
}
