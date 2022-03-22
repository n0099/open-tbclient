package c.a.p0.c0.l.g.c;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.t.a;
import c.a.p0.c0.l.g.a;
import c.a.p0.c0.l.g.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes2.dex */
public class a extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public static final int u;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f13312b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f13313c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f13314d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f13315e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f13316f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13317g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13318h;
    public MarkLevelGroup i;
    public TextView j;
    public c.a.p0.c0.l.g.c.c.b k;
    public AlaUpdateMarkStatusModel l;
    public i m;
    public LinearLayout n;
    public TextView o;
    public TextView p;
    public LinearLayout q;
    public TextView r;
    public c.a.p0.c0.l.g.b s;
    public c.a.p0.c0.l.g.a t;

    /* renamed from: c.a.p0.c0.l.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1003a implements AlaUpdateMarkStatusModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1003a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.b
        public void onResult(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                this.a.j.setEnabled(true);
                if (z) {
                    if (this.a.m != null) {
                        this.a.m.a(true, this.a.k);
                    }
                    this.a.dismiss();
                    return;
                }
                if (StringUtils.isNull(str)) {
                    str = this.a.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01ef);
                }
                this.a.a.showToast(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.p0.c0.l.g.b.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.a.k.n <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                this.a.v();
                this.a.u();
                this.a.s();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.p0.c0.l.g.a.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.a.k != null) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f01f1);
                        if (this.a.m != null) {
                            this.a.m.a(true, this.a.k);
                        }
                        this.a.k.q(2);
                        this.a.v();
                        this.a.u();
                        this.a.s();
                    }
                } else if (!StringUtils.isNull(str)) {
                    this.a.a.showToast(str);
                } else {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f01f0);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.m != null) {
                    this.a.m.a(false, this.a.k);
                }
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements MarkLevelGroup.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.b
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                this.a.t(str, str2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.k.j() == 0 || 3 == this.a.k.j()) {
                    if (this.a.k.m()) {
                        if (this.a.k.n > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (this.a.s != null) {
                                this.a.s.c(this.a.k.n);
                            }
                        } else if (this.a.t != null) {
                            this.a.t.c(this.a.k.d(), this.a.k.m, false);
                        }
                    } else if (this.a.k.l()) {
                    } else {
                        this.a.dismiss();
                    }
                } else if (!this.a.k.k() || 2 != this.a.k.j()) {
                    this.a.q();
                } else {
                    this.a.r();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.a.j.setEnabled(false);
                this.a.q();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public h(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface i {
        void a(boolean z, c.a.p0.c0.l.g.c.c.b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1551543414, "Lc/a/p0/c0/l/g/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1551543414, "Lc/a/p0/c0/l/g/c/a;");
                return;
            }
        }
        u = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070215);
        v = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext tbPageContext, i iVar) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, iVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.m = iVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.dismiss();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
            setCancelable(true);
            setCanceledOnTouchOutside(true);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AlaUpdateMarkStatusModel alaUpdateMarkStatusModel = new AlaUpdateMarkStatusModel(getContext());
            this.l = alaUpdateMarkStatusModel;
            alaUpdateMarkStatusModel.B(new C1003a(this));
            c.a.p0.c0.l.g.b bVar = new c.a.p0.c0.l.g.b(this.a);
            this.s = bVar;
            bVar.e(new b(this));
            this.t = new c.a.p0.c0.l.g.a(this.a, new c(this));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d00e8, (ViewGroup) null);
            this.f13312b = inflate;
            setContentView(inflate);
            this.f13312b.setOnClickListener(new d(this));
            TbImageView tbImageView = (TbImageView) this.f13312b.findViewById(R.id.obfuscated_res_0x7f09139b);
            this.f13313c = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.f13313c.setDefaultResource(R.drawable.obfuscated_res_0x7f080f25);
            this.f13314d = (FrameLayout) this.f13312b.findViewById(R.id.obfuscated_res_0x7f09139c);
            this.f13315e = (TextView) this.f13312b.findViewById(R.id.obfuscated_res_0x7f0913a7);
            this.f13316f = (RelativeLayout) this.f13312b.findViewById(R.id.obfuscated_res_0x7f091399);
            this.f13317g = (TextView) this.f13312b.findViewById(R.id.obfuscated_res_0x7f091398);
            this.f13318h = (TextView) this.f13312b.findViewById(R.id.obfuscated_res_0x7f0913a8);
            MarkLevelGroup markLevelGroup = (MarkLevelGroup) this.f13312b.findViewById(R.id.obfuscated_res_0x7f0913a1);
            this.i = markLevelGroup;
            markLevelGroup.setCallback(new e(this));
            this.j = (TextView) this.f13312b.findViewById(R.id.obfuscated_res_0x7f0913a3);
            this.p = (TextView) this.f13312b.findViewById(R.id.obfuscated_res_0x7f0913a2);
            this.n = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0913a5);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f0913a6);
            this.q = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0922d9);
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f0922da);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                getWindow().addFlags(134217728);
            }
            super.onCreate(bundle);
            getWindow().requestFeature(1);
            o();
            m();
            n();
        }
    }

    public void p() {
        AlaUpdateMarkStatusModel alaUpdateMarkStatusModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (alaUpdateMarkStatusModel = this.l) == null) {
            return;
        }
        alaUpdateMarkStatusModel.onDestroy();
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (1 == this.k.j()) {
                this.l.C(false, this.k.d());
            } else if (2 == this.k.j()) {
                this.l.C(true, this.k.d());
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getPageActivity());
            aVar.setMessageShowCenter(true);
            aVar.setCanceledOnTouchOutside(false);
            aVar.setTitle(R.string.obfuscated_res_0x7f0f01ee);
            aVar.setMessageId(R.string.obfuscated_res_0x7f0f01ed);
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f04d6, new g(this));
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f04d1, new h(this));
            aVar.create(this.a).show();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f13317g.setVisibility(4);
            this.f13318h.setVisibility(4);
            this.n.setVisibility(4);
            this.i.setVisibility(4);
            this.q.setVisibility(8);
            if (this.k.m()) {
                this.n.setVisibility(0);
                this.q.setVisibility(0);
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                this.o.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702fb));
                this.o.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                this.o.setText(AlaStringHelper.formatLowercasekDou((float) this.k.n));
                this.r.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
                this.r.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                this.r.setText(AlaStringHelper.formatLowercasekDou((float) TbadkCoreApplication.getInst().currentAccountTdouNum));
                if (this.k.j() == 1) {
                    this.q.setVisibility(8);
                }
            } else if (this.k.l()) {
                this.f13317g.setVisibility(0);
                this.f13317g.setText(this.k.a());
            } else {
                this.i.setVisibility(0);
                this.f13317g.setVisibility(0);
                this.f13318h.setVisibility(0);
                this.f13317g.setText(this.k.a());
                this.f13318h.setText(this.k.i());
                this.i.f(this.k);
            }
        }
    }

    public final void t(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            if (StringUtils.isNull(str)) {
                this.f13313c.J(String.valueOf((int) R.drawable.obfuscated_res_0x7f080f25), 24, false);
            } else {
                this.f13313c.J(str, 10, false);
            }
            this.f13315e.setText(str2);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.k.j() != 1 && this.k.j() != 2) {
                this.p.setVisibility(8);
                return;
            }
            this.p.setVisibility(0);
            this.p.setText(this.k.b());
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int j = this.k.j();
            if (j != 0) {
                if (j != 1) {
                    if (j != 2) {
                        if (j == 3) {
                            if (this.k.m()) {
                                this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f0801d5);
                                this.j.setTextSize(0, v);
                                this.j.setText(R.string.obfuscated_res_0x7f0f020c);
                                this.j.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                                if (this.k.n > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                                    this.j.setText(R.string.obfuscated_res_0x7f0f01e2);
                                }
                            } else if (this.k.l()) {
                                this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f0801e1);
                                this.j.setTextSize(0, v);
                                this.j.setText(R.string.obfuscated_res_0x7f0f022e);
                                this.j.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0603ec));
                            } else {
                                this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f081200);
                                this.j.setTextSize(0, u);
                                this.j.setText(R.string.obfuscated_res_0x7f0f01e7);
                                this.j.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                            }
                        }
                    } else if (this.k.m()) {
                        this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f0801d5);
                        this.j.setTextSize(0, v);
                        this.j.setText(R.string.obfuscated_res_0x7f0f01f3);
                        this.j.setTextColor(getContext().getResources().getColorStateList(R.color.CAM_X0201));
                    } else if (this.k.l()) {
                        this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f0801e1);
                        this.j.setTextSize(0, v);
                        this.j.setText(R.string.obfuscated_res_0x7f0f01f3);
                        this.j.setTextColor(getContext().getResources().getColorStateList(R.color.obfuscated_res_0x7f0603ec));
                    } else {
                        this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d3c);
                        this.j.setTextSize(0, v);
                        this.j.setText(R.string.obfuscated_res_0x7f0f01f3);
                        this.j.setTextColor(getContext().getResources().getColorStateList(R.color.obfuscated_res_0x7f06077d));
                    }
                } else if (this.k.m()) {
                    this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d39);
                    this.j.setTextSize(0, v);
                    this.j.setText(R.string.obfuscated_res_0x7f0f01f2);
                    this.j.setTextColor(getContext().getResources().getColorStateList(R.color.obfuscated_res_0x7f06077c));
                } else if (this.k.l()) {
                    this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d39);
                    this.j.setTextSize(0, v);
                    this.j.setText(R.string.obfuscated_res_0x7f0f01f2);
                    this.j.setTextColor(getContext().getResources().getColorStateList(R.color.obfuscated_res_0x7f06077c));
                } else {
                    this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d39);
                    this.j.setTextSize(0, v);
                    this.j.setText(R.string.obfuscated_res_0x7f0f01f2);
                    this.j.setTextColor(getContext().getResources().getColorStateList(R.color.obfuscated_res_0x7f06077c));
                }
            } else if (this.k.m()) {
                this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f0801d5);
                this.j.setTextSize(0, v);
                this.j.setText(R.string.obfuscated_res_0x7f0f020c);
                this.j.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                if (this.k.n > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    this.j.setText(R.string.obfuscated_res_0x7f0f01e2);
                }
            } else if (this.k.l()) {
                this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f0801e1);
                this.j.setTextSize(0, v);
                this.j.setText(R.string.obfuscated_res_0x7f0f022e);
                this.j.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0603ec));
            } else {
                this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f081200);
                this.j.setTextSize(0, u);
                this.j.setText(R.string.obfuscated_res_0x7f0f01e9);
                this.j.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
            }
            this.j.setOnClickListener(new f(this));
        }
    }
}
