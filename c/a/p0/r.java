package c.a.p0;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a4.c0;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.switchs.UpdateDialogStyleSyncSwitch;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.constant.BaseConstants;
/* loaded from: classes2.dex */
public class r extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public f B;
    public View.OnClickListener C;
    public View.OnClickListener D;
    public boolean E;
    public boolean F;
    public View.OnClickListener G;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public VersionData f17894b;

    /* renamed from: c  reason: collision with root package name */
    public CombineDownload f17895c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f17896d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17897e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f17898f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17899g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17900h;
    public TextView i;
    public TextView j;
    public TextView k;
    public String l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public View q;
    public ImageView r;
    public TextView s;
    public TextView t;
    public View u;
    public LinearLayout v;
    public TextView w;
    public TextView x;
    public TextView y;
    public View z;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public a(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                this.a.f17898f = true;
                if (this.a.f17897e) {
                    Drawable drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.a.m.setCompoundDrawables(drawable, null, null, null);
                }
                this.a.B.a(this.a.f17897e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public b(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.F) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                this.a.s.setEnabled(false);
                this.a.B.b(this.a.f17897e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public c(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.B.c();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public d(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f17898f) {
                return;
            }
            if (this.a.f17897e) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.a.m.setCompoundDrawables(drawable, null, null, null);
                this.a.f17896d = false;
                this.a.f17897e = false;
                return;
            }
            Drawable drawable2 = SkinManager.getDrawable(R.drawable.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.a.m.setCompoundDrawables(drawable2, null, null, null);
            this.a.f17896d = true;
            this.a.f17897e = true;
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public e(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == this.a.o.getId()) {
                    this.a.B.c();
                    r rVar = this.a;
                    rVar.n(rVar.a);
                } else if (view.getId() == this.a.r.getId()) {
                    this.a.B.c();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a(boolean z);

        void b(boolean z);

        void c();

        void d();

        void stopService();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Context context, int i) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17897e = true;
        this.f17898f = false;
        this.f17899g = false;
        this.E = true;
        this.F = true;
        this.G = new e(this);
        this.a = context;
    }

    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, tbPageContext, i) == null) {
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().k(i == 1);
                tbPageContext.getLayoutMode().j(findViewById(R.id.obfuscated_res_0x7f090286));
            }
            SkinManager.setImageResource(this.r, R.drawable.write_close_selector);
        }
    }

    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + context.getPackageName()));
            try {
                intent.setClassName("com.tencent.android.qqdownloader", "com.tencent.pangu.link.LinkProxyActivity");
                if (!(context instanceof Activity)) {
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                context.startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void o() {
        Window window;
        WindowManager.LayoutParams attributes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (window = getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onBackPressed();
            if (this.f17898f) {
                this.B.stopService();
                this.f17900h.setVisibility(8);
                if (this.f17899g) {
                    this.w.setText(getContext().getString(R.string.obfuscated_res_0x7f0f04e9));
                }
                this.v.setVisibility(0);
                return;
            }
            this.B.d();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0121);
            this.f17900h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090289);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f090295);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f090284);
            this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f090c09);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f090493);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f09043c);
            this.r = (ImageView) findViewById(R.id.obfuscated_res_0x7f090eab);
            this.o.setOnClickListener(this.G);
            this.r.setOnClickListener(this.G);
            this.q = findViewById(R.id.obfuscated_res_0x7f0907f4);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f090827);
            this.s = (TextView) findViewById(R.id.obfuscated_res_0x7f090eed);
            this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f0915bb);
            this.u = findViewById(R.id.obfuscated_res_0x7f090eee);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f091625);
            this.z = findViewById(R.id.obfuscated_res_0x7f090807);
            this.A = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090491);
            this.l = this.k.getText().toString();
            this.v = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090492);
            this.x = (TextView) findViewById(R.id.obfuscated_res_0x7f091de2);
            this.y = (TextView) findViewById(R.id.obfuscated_res_0x7f09048f);
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f090497);
            this.x.setOnClickListener(this.C);
            this.y.setOnClickListener(this.D);
            if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
                this.E = true;
            } else {
                this.E = false;
            }
            String size = this.f17894b.getSize();
            String newVersion = this.f17894b.getNewVersion();
            String newVersionDesc = this.f17894b.getNewVersionDesc();
            StringBuilder sb = new StringBuilder();
            sb.append(this.a.getString(R.string.obfuscated_res_0x7f0f0c1d));
            if (!TextUtils.isEmpty(newVersion)) {
                sb.append(newVersion);
            }
            if (!TextUtils.isEmpty(size)) {
                sb.append(" / " + String.format("%.2f", Float.valueOf(c.a.d.f.m.b.d(size, 0.0f) / 1048576.0f)) + "MB");
            }
            this.i.setText(sb.toString());
            this.j.setText(newVersionDesc);
            if (this.f17894b.forceUpdate()) {
                this.f17899g = true;
                this.n.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0f22));
                this.o.setVisibility(8);
                this.r.setVisibility(8);
            } else {
                this.n.setText(this.a.getString(R.string.obfuscated_res_0x7f0f1484));
                this.o.setVisibility(8);
                this.r.setVisibility(8);
            }
            CombineDownload combineDownload = this.f17895c;
            if (combineDownload != null && combineDownload.showCombineDownload() && !TextUtils.isEmpty(this.f17895c.getApkMD5RSA())) {
                this.m.setText(this.f17895c.getAppName());
                if (!c0.b(this.a, this.f17895c.getAppProc()) && !TextUtils.isEmpty(this.f17895c.getAppUrl())) {
                    this.m.setVisibility(0);
                    Drawable drawable = this.a.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.m.setCompoundDrawables(drawable, null, null, null);
                } else {
                    this.m.setVisibility(8);
                }
            } else {
                this.m.setVisibility(8);
            }
            s(this.E);
            this.p.setOnClickListener(new a(this));
            this.s.setOnClickListener(new b(this));
            this.n.setOnClickListener(new c(this));
            this.m.setOnClickListener(new d(this));
            o();
        }
    }

    public void p(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.C = onClickListener;
        }
    }

    public void q(VersionData versionData, CombineDownload combineDownload, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, versionData, combineDownload, fVar) == null) {
            this.f17894b = versionData;
            this.f17895c = combineDownload;
            this.B = fVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.v.setVisibility(8);
            this.f17900h.setVisibility(0);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                VersionData versionData = this.f17894b;
                if (versionData != null && !TextUtils.isEmpty(versionData.getPatch()) && this.f17894b.getNewVersionCode() >= 0) {
                    this.u.setVisibility(0);
                    this.s.setText(R.string.obfuscated_res_0x7f0f08ce);
                    SkinManager.setBackgroundResource(this.s, R.drawable.dialog_single_button_bg_selector);
                    this.z.setVisibility(8);
                    this.A.setVisibility(8);
                    this.F = true;
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
                    return;
                }
                this.u.setVisibility(0);
                this.s.setText(R.string.obfuscated_res_0x7f0f11f7);
                SkinManager.setBackgroundResource(this.s, R.drawable.dialog_middle_item_bg_selector);
                this.A.setVisibility(0);
                this.F = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            VersionData versionData2 = this.f17894b;
            if (versionData2 != null && !TextUtils.isEmpty(versionData2.getPatch()) && this.f17894b.getNewVersionCode() >= 0) {
                this.u.setVisibility(0);
                SkinManager.setBackgroundResource(this.s, R.drawable.dialog_middle_item_bg_selector);
                this.s.setText(R.string.obfuscated_res_0x7f0f08ce);
                this.A.setVisibility(0);
                this.F = true;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.u.setVisibility(8);
            this.A.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p.setEnabled(z);
        }
    }

    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.D = onClickListener;
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.p.setVisibility(8);
            this.u.setVisibility(8);
            this.n.setVisibility(8);
            this.q.setVisibility(8);
            this.f17898f = true;
            this.A.setVisibility(0);
            this.k.setVisibility(0);
            TextView textView = this.k;
            textView.setText(this.l + i + "%");
            this.r.setVisibility(8);
            this.o.setVisibility(8);
        }
    }
}
