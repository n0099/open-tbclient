package c.a.p0.c0.f.h.d;

import android.text.TextUtils;
import android.view.View;
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
public class b extends c.a.p0.h0.b<c.a.p0.c0.f.a.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public TbPageContext<?> j;
    public c k;
    public f l;
    public ThreadData m;
    public int n;
    public String o;
    public boolean p;
    public View.OnClickListener q;
    public View.OnClickListener r;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.z()) {
                    if (this.a.m == null || this.a.m.getThreadAlaInfo() == null || this.a.l == null) {
                        return;
                    }
                    this.a.l.a(this.a.n, this.a.o, this.a.m);
                    return;
                }
                n.K(this.a.j.getPageActivity(), this.a.j.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c4c));
            }
        }
    }

    /* renamed from: c.a.p0.c0.f.h.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0988b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public View$OnClickListenerC0988b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.m == null || this.a.m.getAuthor() == null || StringUtils.isNull(this.a.m.getAuthor().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.a.m.getAuthor().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.j.getPageActivity()).createNormalConfig(g2, g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.a.m.getAuthor().isBigV())));
        }
    }

    /* loaded from: classes2.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f13127b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f13128c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f13129d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f13130e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f13131f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f13132g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f13133h;
        public TextView i;

        public c(b bVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, view};
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
            this.f13127b = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090e97);
            this.f13128c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09216b);
            this.f13129d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09216a);
            this.f13130e = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f091ac1);
            this.f13131f = (ClickableHeaderImageView) view.findViewById(R.id.obfuscated_res_0x7f090e98);
            this.f13132g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092177);
            this.f13133h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092174);
            this.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092171);
            view.setOnClickListener(bVar.q);
            this.f13127b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f13127b.setDrawerType(0);
            this.f13131f.setIsRound(true);
            this.f13131f.setDrawBorder(true);
            this.f13131f.setBorderColor(bVar.j.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f13131f.setBorderWidth(bVar.j.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070198));
            this.f13131f.setIsGod(false);
            this.f13131f.setIsBigV(false);
            this.f13131f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13130e.getLayoutParams();
            int k = (n.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224)) / 2;
            layoutParams.width = k;
            layoutParams.height = (k * 9) / 16;
            this.f13130e.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 3;
        this.p = false;
        this.q = new a(this);
        this.r = new View$OnClickListenerC0988b(this);
        this.j = tbPageContext;
        this.k = new c(this, k());
        this.p = z;
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d010e : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.i == i) {
            return;
        }
        SkinManager.setBackgroundResource(this.k.f13130e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.k.f13129d, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.k.f13132g, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.k.f13133h, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k.i, (int) R.color.CAM_X0109);
        this.i = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: x */
    public void l(c.a.p0.c0.f.a.c cVar) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            if (cVar != null && (threadData = cVar.f12865d) != null && threadData.getThreadAlaInfo() != null) {
                k().setVisibility(0);
                this.m = cVar.f12865d;
                this.n = cVar.a;
                this.o = !TextUtils.isEmpty(cVar.f12864c) ? cVar.f12864c : cVar.f12863b;
                this.k.f13127b.J(this.m.getThreadAlaInfo().cover, 10, false);
                this.k.f13129d.setText(this.j.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f11b4, StringHelper.numberUniformFormatExtra(this.m.getThreadAlaInfo().audience_count)));
                this.k.f13131f.setData(this.m, false);
                this.k.f13133h.setText(this.m.getTitle());
                if (this.m.getAuthor() != null) {
                    String name_show = this.m.getAuthor().getName_show();
                    if (o0.d(name_show) > 10) {
                        name_show = o0.n(name_show, 10) + StringHelper.STRING_MORE;
                    }
                    this.k.f13132g.setText(name_show);
                }
                String str = this.m.getThreadAlaInfo().label_name;
                if (this.p && !StringUtils.isNull(str)) {
                    this.k.f13128c.setText(str);
                    this.k.f13128c.setVisibility(0);
                } else {
                    this.k.f13128c.setVisibility(8);
                }
                if (cVar.f12866e) {
                    this.k.i.setText(this.j.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f11b3, StringHelper.numberUniformFormatExtra((long) (this.m.getThreadAlaInfo().distance / 1000.0d))));
                    this.k.i.setVisibility(0);
                } else {
                    this.k.i.setVisibility(8);
                }
                this.k.f13132g.setOnClickListener(this.r);
                m(this.j, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            k().setVisibility(4);
        }
    }

    public void y(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.l = fVar;
        }
    }
}
