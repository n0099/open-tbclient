package c.a.p0.c0.f.h.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.o0.c1.o0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f13148b;

    /* renamed from: c  reason: collision with root package name */
    public c f13149c;

    /* renamed from: d  reason: collision with root package name */
    public View f13150d;

    /* renamed from: e  reason: collision with root package name */
    public int f13151e;

    /* renamed from: f  reason: collision with root package name */
    public String f13152f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadData f13153g;

    /* renamed from: h  reason: collision with root package name */
    public f f13154h;
    public boolean i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.z()) {
                    if (this.a.f13153g == null || this.a.f13153g.getThreadAlaInfo() == null || this.a.f13154h == null) {
                        return;
                    }
                    this.a.f13154h.a(this.a.f13151e, this.a.f13152f, this.a.f13153g);
                    return;
                }
                n.K(this.a.f13148b.getPageActivity(), this.a.f13148b.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c4c));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f13153g == null || this.a.f13153g.getAuthor() == null || StringUtils.isNull(this.a.f13153g.getAuthor().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.a.f13153g.getAuthor().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.f13148b.getPageActivity()).createNormalConfig(g2, g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.a.f13153g.getAuthor().isBigV())));
        }
    }

    /* loaded from: classes2.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f13155b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f13156c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f13157d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f13158e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f13159f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f13160g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f13161h;
        public TextView i;

        public c(e eVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view;
            this.f13155b = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090e97);
            this.f13156c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09216b);
            this.f13157d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09216a);
            this.f13158e = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f091ac1);
            this.f13159f = (ClickableHeaderImageView) view.findViewById(R.id.obfuscated_res_0x7f090e98);
            this.f13160g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092177);
            this.f13161h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092174);
            this.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092171);
            view.setOnClickListener(eVar.j);
            this.f13155b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f13155b.setDrawerType(0);
            this.f13159f.setIsRound(true);
            this.f13159f.setDrawBorder(true);
            this.f13159f.setBorderColor(eVar.f13148b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f13159f.setBorderWidth(eVar.f13148b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070198));
            this.f13159f.setIsGod(false);
            this.f13159f.setIsBigV(false);
            this.f13159f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13158e.getLayoutParams();
            int k = (n.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f13158e.setLayoutParams(layoutParams);
        }
    }

    public e(TbPageContext<?> tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.j = new a(this);
        this.k = new b(this);
        this.f13148b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0110, (ViewGroup) null, false);
        this.f13150d = inflate;
        this.f13149c = new c(this, inflate);
        this.i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13150d : (View) invokeV.objValue;
    }

    public void h(c.a.p0.c0.f.a.c cVar) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (threadData = cVar.f12865d) != null && threadData.getThreadAlaInfo() != null) {
                g().setVisibility(0);
                this.f13153g = cVar.f12865d;
                this.f13151e = cVar.a;
                this.f13152f = !TextUtils.isEmpty(cVar.f12864c) ? cVar.f12864c : cVar.f12863b;
                this.f13149c.f13155b.setDrawerType(0);
                this.f13149c.f13155b.setBorderSurroundContent(true);
                this.f13149c.f13155b.setDrawBorder(true);
                this.f13149c.f13155b.J(this.f13153g.getThreadAlaInfo().cover, 10, false);
                this.f13149c.f13157d.setText(this.f13148b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f11b4, StringHelper.numberUniformFormatExtra(this.f13153g.getThreadAlaInfo().audience_count)));
                this.f13149c.f13159f.setData(this.f13153g, false);
                this.f13149c.f13161h.setText(this.f13153g.getTitle());
                if (this.f13153g.getAuthor() != null) {
                    String name_show = this.f13153g.getAuthor().getName_show();
                    if (o0.d(name_show) > 10) {
                        name_show = o0.n(name_show, 10) + StringHelper.STRING_MORE;
                    }
                    this.f13149c.f13160g.setText(name_show);
                }
                String str = this.f13153g.getThreadAlaInfo().label_name;
                if (this.i && !StringUtils.isNull(str)) {
                    this.f13149c.f13156c.setText(str);
                    this.f13149c.f13156c.setVisibility(0);
                } else {
                    this.f13149c.f13156c.setVisibility(8);
                }
                if (cVar.f12866e) {
                    this.f13149c.i.setText(this.f13148b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f11b3, StringHelper.numberUniformFormatExtra((long) (this.f13153g.getThreadAlaInfo().distance / 1000.0d))));
                    this.f13149c.i.setVisibility(0);
                } else {
                    this.f13149c.i.setVisibility(8);
                }
                this.f13149c.f13160g.setOnClickListener(this.k);
                i(this.f13148b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            g().setVisibility(4);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        SkinManager.setBackgroundResource(this.f13149c.f13158e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f13149c.f13157d, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f13149c.f13160g, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f13149c.f13161h, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f13149c.i, (int) R.color.CAM_X0109);
        this.a = i;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f13154h = fVar;
        }
    }
}
