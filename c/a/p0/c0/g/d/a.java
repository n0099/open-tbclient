package c.a.p0.c0.g.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.c1.o0;
import c.a.p0.c0.d;
import c.a.p0.c0.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f13189b;

    /* renamed from: c  reason: collision with root package name */
    public b f13190c;

    /* renamed from: d  reason: collision with root package name */
    public View f13191d;

    /* renamed from: e  reason: collision with root package name */
    public ThreadData f13192e;

    /* renamed from: f  reason: collision with root package name */
    public e f13193f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f13194g;

    /* renamed from: c.a.p0.c0.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0991a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC0991a(a aVar) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f13192e == null || this.a.f13192e.getAuthor() == null || StringUtils.isNull(this.a.f13192e.getAuthor().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.a.f13192e.getAuthor().getUserId(), 0L);
            boolean z = g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.f13189b.getPageActivity()).createNormalConfig(g2, z, this.a.f13192e.getAuthor().isBigV())));
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f13195b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f13196c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f13197d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f13198e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f13199f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f13200g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f13201h;
        public RelativeLayout i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            this.f13195b = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090e97);
            this.f13196c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09216b);
            this.f13197d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09216a);
            this.f13198e = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f091ac1);
            this.f13199f = (ClickableHeaderImageView) view.findViewById(R.id.obfuscated_res_0x7f090e98);
            this.f13200g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092177);
            this.i = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f091ac3);
            this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092174);
            this.k = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0912e3);
            this.f13201h = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090e99);
            this.l = view.findViewById(R.id.obfuscated_res_0x7f0912da);
            TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092166);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070324));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f13201h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f13195b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13198e.getLayoutParams();
            layoutParams.width = (n.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070225);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070225);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070225);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be);
            this.j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.i.setVisibility(0);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.f13198e.setLayoutParams(layoutParams);
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.f13194g = new View$OnClickListenerC0991a(this);
        this.f13189b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d00fc, (ViewGroup) null, false);
        this.f13191d = inflate;
        this.f13190c = new b(inflate);
        c().setOnClickListener(this);
        this.f13189b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0222);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13191d : (View) invokeV.objValue;
    }

    public void d(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) {
            if (threadData == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f13192e = threadData;
            this.f13190c.f13195b.setDrawerType(0);
            this.f13190c.f13195b.setBorderSurroundContent(true);
            this.f13190c.f13195b.setDrawBorder(true);
            this.f13190c.f13195b.J(this.f13192e.getThreadAlaInfo().cover, 10, false);
            this.f13190c.f13197d.setText(this.f13189b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f021a, StringHelper.numberUniformFormatExtra(this.f13192e.getThreadAlaInfo().audience_count)));
            this.f13190c.f13199f.setData(this.f13192e);
            this.f13190c.f13199f.setIsRound(true);
            this.f13190c.f13199f.setBorderSurroundContent(true);
            this.f13190c.j.setText(this.f13192e.getTitle());
            if (this.f13192e.getAuthor() != null) {
                String name_show = this.f13192e.getAuthor().getName_show();
                if (o0.d(name_show) > 10) {
                    name_show = o0.n(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.f13190c.f13200g.setText(name_show);
            }
            this.f13190c.l.setVisibility(0);
            this.f13190c.f13196c.setBackgroundResource(R.drawable.obfuscated_res_0x7f081200);
            this.f13190c.f13196c.setText(this.f13192e.getThreadAlaInfo().label_name);
            this.f13190c.f13196c.setVisibility(0);
            if (this.f13192e.getAuthor() != null && this.f13192e.getAuthor().getAlaUserData() != null && !m.isEmpty(this.f13192e.getAuthor().getAlaUserData().great_anchor_icon)) {
                this.f13190c.f13201h.setVisibility(0);
                this.f13190c.f13201h.J(this.f13192e.getAuthor().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f13190c.f13201h.setVisibility(8);
            }
            this.f13190c.f13200g.setOnClickListener(this.f13194g);
            e(this.f13189b, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        SkinManager.setBackgroundResource(this.f13190c.f13198e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f13190c.f13196c, (int) R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f13190c.f13197d, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f13190c.f13200g, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f13190c.j, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f13190c.m, (int) R.color.CAM_X0101);
        this.a = i;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f13193f = eVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (!l.z()) {
                n.K(this.f13189b.getPageActivity(), this.f13189b.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c4c));
                return;
            }
            ThreadData threadData = this.f13192e;
            if (threadData == null || threadData.getThreadAlaInfo() == null) {
                return;
            }
            e eVar = this.f13193f;
            if (eVar != null) {
                eVar.a(this.f13192e);
            }
            d.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f13192e.getThreadAlaInfo().live_id));
        }
    }
}
