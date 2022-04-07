package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.novel.NovelResult;
import com.baidu.tbadk.novel.ReadRecordsData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.k75;
import com.repackage.l75;
import com.repackage.m75;
import com.repackage.oi;
import com.repackage.rz4;
import com.repackage.wr4;
import com.repackage.wt4;
import com.repackage.xb9;
/* loaded from: classes3.dex */
public class NovelInfoCardView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public ImageView f;
    public TextView g;
    public View h;
    public TextView i;
    public TextView j;
    public TextView k;
    public View l;
    public TextView m;
    public TextView n;
    public TextView o;
    public rz4 p;
    public k75 q;
    public TbPageContext<?> r;
    public long s;
    public long t;
    public String u;
    public View v;
    public boolean w;
    public boolean x;
    public String y;
    public String z;

    /* loaded from: classes3.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NovelInfoCardView a;

        public a(NovelInfoCardView novelInfoCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {novelInfoCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = novelInfoCardView;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) || z) {
                return;
            }
            this.a.b.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080f42);
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.b.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080f42);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements k75.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NovelInfoCardView a;

        public b(NovelInfoCardView novelInfoCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {novelInfoCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = novelInfoCardView;
        }

        @Override // com.repackage.k75.d
        public void a(NovelResult novelResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, novelResult) == null) {
                int i = c.a[novelResult.ordinal()];
                if (i == 4) {
                    BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                    bdTopToast.i(false);
                    bdTopToast.h(this.a.r.getString(R.string.obfuscated_res_0x7f0f0c94));
                    bdTopToast.j((ViewGroup) this.a.getRootView());
                } else if (i != 5) {
                } else {
                    BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                    bdTopToast2.i(true);
                    bdTopToast2.h(this.a.r.getString(R.string.obfuscated_res_0x7f0f0c96));
                    bdTopToast2.j((ViewGroup) this.a.getRootView());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921658, Boolean.TRUE));
                    this.a.p.m(true);
                    if (this.a.w) {
                        this.a.x = true;
                        this.a.p(true);
                    }
                    NovelInfoCardView novelInfoCardView = this.a;
                    novelInfoCardView.setReadingProgress(novelInfoCardView.s);
                    NovelInfoCardView novelInfoCardView2 = this.a;
                    novelInfoCardView2.k(novelInfoCardView2.p);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(401858074, "Lcom/baidu/tbadk/core/view/NovelInfoCardView$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(401858074, "Lcom/baidu/tbadk/core/view/NovelInfoCardView$c;");
                    return;
                }
            }
            int[] iArr = new int[NovelResult.values().length];
            a = iArr;
            try {
                iArr[NovelResult.DEPOSIT_SUCC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[NovelResult.DEPOSIT_FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[NovelResult.PAY_NOVEL_CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[NovelResult.PAY_NOVEL_FAIL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[NovelResult.PAY_NOVEL_SUCC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NovelInfoCardView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.w = false;
        h(context);
    }

    private void getReadDataRecord() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.p == null) {
            return;
        }
        String b2 = l75.b(String.valueOf(this.p.h()), TbadkCoreApplication.getCurrentAccount());
        ReadRecordsData readRecordsData = (ReadRecordsData) OrmObject.objectWithJsonStr(b2, ReadRecordsData.class);
        if (StringUtils.isNull(b2) || readRecordsData == null) {
            readRecordsData = new ReadRecordsData();
            readRecordsData.B(String.valueOf(this.p.b()));
            readRecordsData.A(String.valueOf(this.s / 100));
        }
        if (this.w) {
            this.x = wt4.k().h("key_pb_free_novel_paid_data", false);
        }
        setReadingProgress(readRecordsData.y());
        setCid(readRecordsData.z());
    }

    private TbPageContext<?> getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            TbPageContext<?> tbPageContext = this.r;
            if (tbPageContext != null) {
                return tbPageContext;
            }
            Context context = getContext();
            if (context instanceof TbPageContextSupport) {
                this.r = ((TbPageContextSupport) context).getPageContext();
            }
            return this.r;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            double a2 = xb9.a(str, 0.0d) / 100.0d;
            String str2 = (a2 < 0.0d || a2 > 0.49d) ? (a2 <= 0.49d || a2 > 1.0d) ? (a2 <= 1.0d || a2 > 6.6d) ? (a2 <= 6.6d || a2 > 9.9d) ? a2 > 9.9d ? "58.8" : "0.0" : "49.9" : "36.6" : "19.9" : "16.6";
            return !StringUtils.isNull(str2) ? str2 : str;
        }
        return (String) invokeL.objValue;
    }

    public View getNovelCoverPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TbImageView tbImageView = this.b;
            if (tbImageView == null || tbImageView.getVisibility() != 0) {
                return null;
            }
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public View getNovelStateButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TextView textView = this.m;
            if (textView == null || textView.getVisibility() != 0) {
                return null;
            }
            return this.m;
        }
        return (View) invokeV.objValue;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d062f, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0915c9);
            this.b = tbImageView;
            tbImageView.setConrers(15);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0915c6);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0915bf);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0915c7);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f0915c3);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0915c4);
            this.h = findViewById(R.id.obfuscated_res_0x7f0915cb);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f0915ce);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f0915cf);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f0915cd);
            this.l = findViewById(R.id.obfuscated_res_0x7f0915d0);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f0915c0);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f0915d1);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f0915d5);
            this.r = getTbPageContext();
            this.m.setOnClickListener(this);
            this.b.setOnClickListener(this);
            setOnClickListener(this);
            l();
            i();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            k75 k75Var = new k75(this.r);
            this.q = k75Var;
            k75Var.l(new b(this));
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            rz4 rz4Var = this.p;
            if (rz4Var == null) {
                return false;
            }
            return "0".equals(rz4Var.d()) || "0L".equals(this.p.d());
        }
        return invokeV.booleanValue;
    }

    public void k(rz4 rz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rz4Var) == null) {
            if (!rz4Var.i() && !this.x) {
                if (this.w) {
                    this.d.setVisibility(0);
                    this.d.setText(R.string.obfuscated_res_0x7f0f0c9a);
                } else {
                    this.d.setVisibility(8);
                }
                this.h.setVisibility(0);
                this.j.setText(R.string.obfuscated_res_0x7f0f0c93);
                this.m.setText(R.string.obfuscated_res_0x7f0f0c92);
                this.i.setText(String.valueOf(xb9.a(rz4Var.d(), -1.0d) / 100.0d));
                this.k.setText(g(rz4Var.d()));
                return;
            }
            rz4Var.m(true);
            this.d.setVisibility(0);
            this.d.setText(R.string.obfuscated_res_0x7f0f0c98);
            this.l.setVisibility(0);
            this.n.setText(R.string.obfuscated_res_0x7f0f0c99);
            TextView textView = this.o;
            textView.setText(this.t + "%");
            this.m.setText(R.string.obfuscated_res_0x7f0f0c9b);
            this.h.setVisibility(8);
            View view2 = this.v;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            l();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a = TbadkCoreApplication.getInst().getSkinType();
            wr4 d = wr4.d(this.c);
            d.A(R.string.F_X01);
            d.v(R.color.CAM_X0105);
            wr4 d2 = wr4.d(this.e);
            d2.A(R.string.F_X01);
            d2.v(R.color.CAM_X0108);
            wr4 d3 = wr4.d(this.d);
            d3.n(R.string.J_X04);
            d3.l(R.dimen.L_X02);
            d3.k(R.color.CAM_X0302);
            wr4 d4 = wr4.d(this.g);
            d4.A(R.string.F_X01);
            d4.v(R.color.CAM_X0110);
            wr4 d5 = wr4.d(this.d);
            d5.A(R.string.F_X01);
            d5.v(R.color.CAM_X0303);
            wr4 d6 = wr4.d(this.i);
            d6.A(R.string.F_X02);
            d6.v(R.color.CAM_X0305);
            wr4 d7 = wr4.d(this.j);
            d7.A(R.string.F_X01);
            d7.v(R.color.CAM_X0305);
            this.k.getPaint().setFlags(16);
            this.k.getPaint().setAntiAlias(true);
            wr4 d8 = wr4.d(this.k);
            d8.A(R.string.F_X01);
            d8.v(R.color.CAM_X0110);
            wr4 d9 = wr4.d(this.m);
            d9.A(R.string.F_X01);
            d9.v(R.color.CAM_X0101);
            rz4 rz4Var = this.p;
            if (rz4Var != null) {
                if (rz4Var.i()) {
                    wr4 d10 = wr4.d(this.n);
                    d10.A(R.string.F_X01);
                    d10.v(R.color.CAM_X0107);
                    wr4 d11 = wr4.d(this.o);
                    d11.A(R.string.F_X02);
                    d11.v(R.color.CAM_X0107);
                    SkinManager.setBackgroundShapeDrawable(this.m, oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds60), R.color.CAM_X0303, R.color.CAM_X0207);
                }
            } else {
                SkinManager.setBackgroundShapeDrawable(this.m, oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds60), R.color.CAM_X0305, R.color.CAM_X0206);
            }
            SkinManager.setBackgroundResource(this, R.drawable.applets_cell_bg);
            this.b.setDrawBorder(true);
            this.b.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.b.setBorderWidth(oi.f(this.r.getPageActivity(), R.dimen.L_X01));
            this.b.setSkinType(this.a);
            WebPManager.setPureDrawable(this.f, R.drawable.obfuscated_res_0x7f080881, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL);
        }
    }

    public void m() {
        rz4 rz4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (rz4Var = this.p) == null || StringUtils.isNull(rz4Var.e())) {
            return;
        }
        if (this.p.i()) {
            r(s(this.p.e()));
            m75.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_JUMP_H5, String.valueOf(this.p.h()), this.y, this.z);
            return;
        }
        this.q.s(this.y, this.z);
        this.q.q(this.p.h(), this.p.g(), Double.valueOf(this.p.d()).intValue());
    }

    public void n() {
        k75 k75Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (k75Var = this.q) == null) {
            return;
        }
        k75Var.o();
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.p == null) {
            return;
        }
        getReadDataRecord();
        TextView textView = this.o;
        textView.setText(this.t + "%");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            m();
            if (this.p != null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0915c9) {
                    m75.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_CLICK, 3, String.valueOf(this.p.h()), this.y, this.z);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0915d5) {
                    if (this.p.i()) {
                        m75.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_CLICK, 2, String.valueOf(this.p.h()), this.y, this.z);
                    } else {
                        m75.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_CLICK, 1, String.valueOf(this.p.h()), this.y, this.z);
                    }
                } else {
                    m75.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_CLICK, 4, String.valueOf(this.p.h()), this.y, this.z);
                }
            }
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && TbadkCoreApplication.isLogin()) {
            wt4.k().u("key_pb_free_novel_paid_data", z);
        }
    }

    public final void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            tbWebViewActivityConfig.setNoClose(true);
            tbWebViewActivityConfig.setNoMenu(true);
            tbWebViewActivityConfig.setNoShare(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            return CommonUrlParamManager.getInstance().processUrl(l75.d(str, "data", this.u)) + "&ctv=2&cen=ua_ut_uid";
        }
        return (String) invokeL.objValue;
    }

    public void setCid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (str != null) {
                this.u = str;
            } else {
                this.u = String.valueOf(this.p.b());
            }
        }
    }

    public void setData(rz4 rz4Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, rz4Var, str, str2) == null) {
            if (rz4Var != null && !rz4Var.k()) {
                setVisibility(0);
                this.p = rz4Var;
                this.y = str;
                this.z = str2;
                if (StringUtils.isNull(rz4Var.f(), true)) {
                    this.b.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080f42);
                } else {
                    this.b.setEvent(new a(this));
                    this.b.K(this.p.f(), 10, false);
                }
                this.c.setText(this.p.g());
                this.e.setText(this.p.c());
                this.g.setText(this.p.a());
                this.s = 100 - this.p.j();
                this.w = j();
                getReadDataRecord();
                k(this.p);
                return;
            }
            setVisibility(8);
        }
    }

    public void setReadMoreButtonState(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, view2) == null) || view2 == null) {
            return;
        }
        this.v = view2;
    }

    public void setReadingProgress(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            if (j != 0) {
                this.t = Math.max(j, this.s);
            } else {
                this.t = this.s;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NovelInfoCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.w = false;
        h(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NovelInfoCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.w = false;
        h(context);
    }
}
