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
import c.a.a1.t.g;
import c.a.d.f.p.n;
import c.a.s0.n0.d;
import c.a.s0.n0.e;
import c.a.s0.n0.f;
import c.a.s0.u.j;
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
/* loaded from: classes11.dex */
public class NovelInfoCardView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public String B;
    public String C;

    /* renamed from: e  reason: collision with root package name */
    public int f40437e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f40438f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f40439g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f40440h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f40441i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f40442j;
    public TextView k;
    public View l;
    public TextView m;
    public View mReadMoreButton;
    public TextView n;
    public TextView o;
    public View p;
    public TextView q;
    public TextView r;
    public TextView s;
    public j t;
    public d u;
    public TbPageContext<?> v;
    public long w;
    public long x;
    public String y;
    public boolean z;

    /* loaded from: classes11.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            this.a.f40438f.setDefaultBgResource(R.drawable.pic_novel_default_cover_normal);
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.f40438f.setDefaultBgResource(R.drawable.pic_novel_default_cover_normal);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements d.InterfaceC0860d {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = novelInfoCardView;
        }

        @Override // c.a.s0.n0.d.InterfaceC0860d
        public void a(NovelResult novelResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, novelResult) == null) {
                int i2 = c.a[novelResult.ordinal()];
                if (i2 == 4) {
                    new BdTopToast(this.a.getContext()).setIcon(false).setContent(this.a.v.getString(R.string.novel_pay_fail)).show((ViewGroup) this.a.getRootView());
                } else if (i2 != 5) {
                } else {
                    new BdTopToast(this.a.getContext()).setIcon(true).setContent(this.a.v.getString(R.string.novel_pay_success)).show((ViewGroup) this.a.getRootView());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921658, Boolean.TRUE));
                    this.a.t.m(true);
                    if (this.a.z) {
                        this.a.A = true;
                        this.a.saveFreeBookPayState(true);
                    }
                    NovelInfoCardView novelInfoCardView = this.a;
                    novelInfoCardView.setReadingProgress(novelInfoCardView.w);
                    NovelInfoCardView novelInfoCardView2 = this.a;
                    novelInfoCardView2.onChangePayState(novelInfoCardView2.t);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40437e = 3;
        this.z = false;
        h(context);
    }

    private void getReadDataRecord() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.t == null) {
            return;
        }
        String b2 = e.b(String.valueOf(this.t.h()), TbadkCoreApplication.getCurrentAccount());
        ReadRecordsData readRecordsData = (ReadRecordsData) OrmObject.objectWithJsonStr(b2, ReadRecordsData.class);
        if (StringUtils.isNull(b2) || readRecordsData == null) {
            readRecordsData = new ReadRecordsData();
            readRecordsData.z(String.valueOf(this.t.b()));
            readRecordsData.y(String.valueOf(this.w / 100));
        }
        if (this.z) {
            this.A = c.a.s0.s.h0.b.k().h("key_pb_free_novel_paid_data", false);
        }
        setReadingProgress(readRecordsData.w());
        setCid(readRecordsData.x());
    }

    private TbPageContext<?> getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            TbPageContext<?> tbPageContext = this.v;
            if (tbPageContext != null) {
                return tbPageContext;
            }
            Context context = getContext();
            if (context instanceof TbPageContextSupport) {
                this.v = ((TbPageContextSupport) context).getPageContext();
            }
            return this.v;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            double a2 = g.a(str, 0.0d) / 100.0d;
            String str2 = (a2 < 0.0d || a2 > 0.49d) ? (a2 <= 0.49d || a2 > 1.0d) ? (a2 <= 1.0d || a2 > 6.6d) ? (a2 <= 6.6d || a2 > 9.9d) ? a2 > 9.9d ? "58.8" : "0.0" : "49.9" : "36.6" : "19.9" : "16.6";
            return !StringUtils.isNull(str2) ? str2 : str;
        }
        return (String) invokeL.objValue;
    }

    public View getNovelCoverPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TbImageView tbImageView = this.f40438f;
            if (tbImageView == null || tbImageView.getVisibility() != 0) {
                return null;
            }
            return this.f40438f;
        }
        return (View) invokeV.objValue;
    }

    public View getNovelStateButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TextView textView = this.q;
            if (textView == null || textView.getVisibility() != 0) {
                return null;
            }
            return this.q;
        }
        return (View) invokeV.objValue;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.novel_info_card_layout, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.novel_info_cover_page);
            this.f40438f = tbImageView;
            tbImageView.setConrers(15);
            this.f40439g = (TextView) findViewById(R.id.novel_info_book_name);
            this.f40440h = (TextView) findViewById(R.id.novel_already_pay_state_tip);
            this.f40441i = (TextView) findViewById(R.id.novel_info_book_summary);
            this.f40442j = (ImageView) findViewById(R.id.novel_author_icon);
            this.k = (TextView) findViewById(R.id.novel_author_name);
            this.l = findViewById(R.id.novel_no_pay_view);
            this.m = (TextView) findViewById(R.id.novel_pay_price_num);
            this.n = (TextView) findViewById(R.id.novel_pay_price_unit);
            this.o = (TextView) findViewById(R.id.novel_pay_original_price_num);
            this.p = findViewById(R.id.novel_pay_view);
            this.r = (TextView) findViewById(R.id.novel_already_read);
            this.s = (TextView) findViewById(R.id.novel_progress_read);
            this.q = (TextView) findViewById(R.id.novel_state_btn);
            this.v = getTbPageContext();
            this.q.setOnClickListener(this);
            this.f40438f.setOnClickListener(this);
            setOnClickListener(this);
            onChangeSkinType();
            i();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d dVar = new d(this.v);
            this.u = dVar;
            dVar.l(new b(this));
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            j jVar = this.t;
            if (jVar == null) {
                return false;
            }
            return "0".equals(jVar.d()) || "0L".equals(this.t.d());
        }
        return invokeV.booleanValue;
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            tbWebViewActivityConfig.setNoClose(true);
            tbWebViewActivityConfig.setNoMenu(true);
            tbWebViewActivityConfig.setNoShare(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return CommonUrlParamManager.getInstance().processUrl(e.d(str, "data", this.y)) + "&ctv=2&cen=ua_ut_uid";
        }
        return (String) invokeL.objValue;
    }

    public void onChangePayState(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jVar) == null) {
            if (!jVar.i() && !this.A) {
                if (this.z) {
                    this.f40440h.setVisibility(0);
                    this.f40440h.setText(R.string.novel_text_free);
                } else {
                    this.f40440h.setVisibility(8);
                }
                this.l.setVisibility(0);
                this.n.setText(R.string.novel_pay_currency_unit_Y_coin);
                this.q.setText(R.string.novel_pay);
                this.m.setText(String.valueOf(g.a(jVar.d(), -1.0d) / 100.0d));
                this.o.setText(g(jVar.d()));
                return;
            }
            jVar.m(true);
            this.f40440h.setVisibility(0);
            this.f40440h.setText(R.string.novel_text_already_pay);
            this.p.setVisibility(0);
            this.r.setText(R.string.novel_text_already_read);
            TextView textView = this.s;
            textView.setText(this.x + "%");
            this.q.setText(R.string.novel_text_go_to_reading);
            this.l.setVisibility(8);
            View view = this.mReadMoreButton;
            if (view != null) {
                view.setVisibility(8);
            }
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f40437e = TbadkCoreApplication.getInst().getSkinType();
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f40439g);
            d2.A(R.string.F_X01);
            d2.v(R.color.CAM_X0105);
            c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(this.f40441i);
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0108);
            c.a.s0.s.u.c d4 = c.a.s0.s.u.c.d(this.f40440h);
            d4.n(R.string.J_X04);
            d4.l(R.dimen.L_X02);
            d4.k(R.color.CAM_X0302);
            c.a.s0.s.u.c d5 = c.a.s0.s.u.c.d(this.k);
            d5.A(R.string.F_X01);
            d5.v(R.color.CAM_X0110);
            c.a.s0.s.u.c d6 = c.a.s0.s.u.c.d(this.f40440h);
            d6.A(R.string.F_X01);
            d6.v(R.color.CAM_X0303);
            c.a.s0.s.u.c d7 = c.a.s0.s.u.c.d(this.m);
            d7.A(R.string.F_X02);
            d7.v(R.color.CAM_X0305);
            c.a.s0.s.u.c d8 = c.a.s0.s.u.c.d(this.n);
            d8.A(R.string.F_X01);
            d8.v(R.color.CAM_X0305);
            this.o.getPaint().setFlags(16);
            this.o.getPaint().setAntiAlias(true);
            c.a.s0.s.u.c d9 = c.a.s0.s.u.c.d(this.o);
            d9.A(R.string.F_X01);
            d9.v(R.color.CAM_X0110);
            c.a.s0.s.u.c d10 = c.a.s0.s.u.c.d(this.q);
            d10.A(R.string.F_X01);
            d10.v(R.color.CAM_X0101);
            j jVar = this.t;
            if (jVar != null) {
                if (jVar.i()) {
                    c.a.s0.s.u.c d11 = c.a.s0.s.u.c.d(this.r);
                    d11.A(R.string.F_X01);
                    d11.v(R.color.CAM_X0107);
                    c.a.s0.s.u.c d12 = c.a.s0.s.u.c.d(this.s);
                    d12.A(R.string.F_X02);
                    d12.v(R.color.CAM_X0107);
                    SkinManager.setBackgroundShapeDrawable(this.q, n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds60), R.color.CAM_X0303, R.color.CAM_X0207);
                }
            } else {
                SkinManager.setBackgroundShapeDrawable(this.q, n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds60), R.color.CAM_X0305, R.color.CAM_X0206);
            }
            SkinManager.setBackgroundResource(this, R.drawable.applets_cell_bg);
            this.f40438f.setDrawBorder(true);
            this.f40438f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f40438f.setBorderWidth(n.f(this.v.getPageActivity(), R.dimen.L_X01));
            this.f40438f.setSkinType(this.f40437e);
            WebPManager.setPureDrawable(this.f40442j, R.drawable.icon_novel_author, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            onClickStatePayOrRead();
            if (this.t != null) {
                if (view.getId() == R.id.novel_info_cover_page) {
                    f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_CLICK, 3, String.valueOf(this.t.h()), this.B, this.C);
                } else if (view.getId() == R.id.novel_state_btn) {
                    if (this.t.i()) {
                        f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_CLICK, 2, String.valueOf(this.t.h()), this.B, this.C);
                    } else {
                        f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_CLICK, 1, String.valueOf(this.t.h()), this.B, this.C);
                    }
                } else {
                    f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_CLICK, 4, String.valueOf(this.t.h()), this.B, this.C);
                }
            }
        }
    }

    public void onClickStatePayOrRead() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (jVar = this.t) == null || StringUtils.isNull(jVar.e())) {
            return;
        }
        if (this.t.i()) {
            k(l(this.t.e()));
            f.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_JUMP_H5, String.valueOf(this.t.h()), this.B, this.C);
            return;
        }
        this.u.q(this.t.h(), this.t.g(), Double.valueOf(this.t.d()).intValue());
        this.u.s(this.B, this.C);
    }

    public void onDestroy() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (dVar = this.u) == null) {
            return;
        }
        dVar.o();
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.t == null) {
            return;
        }
        getReadDataRecord();
        TextView textView = this.s;
        textView.setText(this.x + "%");
    }

    public void saveFreeBookPayState(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && TbadkCoreApplication.isLogin()) {
            c.a.s0.s.h0.b.k().u("key_pb_free_novel_paid_data", z);
        }
    }

    public void setCid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (str != null) {
                this.y = str;
            } else {
                this.y = String.valueOf(this.t.b());
            }
        }
    }

    public void setData(j jVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, jVar, str, str2) == null) {
            if (jVar != null && !jVar.k()) {
                setVisibility(0);
                this.t = jVar;
                this.B = str;
                this.C = str2;
                if (StringUtils.isNull(jVar.f(), true)) {
                    this.f40438f.setDefaultBgResource(R.drawable.pic_novel_default_cover_normal);
                } else {
                    this.f40438f.setEvent(new a(this));
                    this.f40438f.startLoad(this.t.f(), 10, false);
                }
                this.f40439g.setText(this.t.g());
                this.f40441i.setText(this.t.c());
                this.k.setText(this.t.a());
                this.w = 100 - this.t.j();
                this.z = j();
                getReadDataRecord();
                onChangePayState(this.t);
                return;
            }
            setVisibility(8);
        }
    }

    public void setReadMoreButtonState(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, view) == null) || view == null) {
            return;
        }
        this.mReadMoreButton = view;
    }

    public void setReadingProgress(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j2) == null) {
            if (j2 != 0) {
                this.x = Math.max(j2, this.w);
            } else {
                this.x = this.w;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40437e = 3;
        this.z = false;
        h(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NovelInfoCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f40437e = 3;
        this.z = false;
        h(context);
    }
}
