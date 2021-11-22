package b.a.r0.p2.j;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import b.a.q0.c1.m0;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b extends b.a.r0.b0.b<b.a.r0.p2.e.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public BarImageView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public b.a.r0.p2.e.b v;
    public LikeModel w;
    public boolean x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f23887a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23887a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f23887a.x) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof b.a.r0.m3.s0.k) {
                b.a.r0.m3.s0.k kVar = (b.a.r0.m3.s0.k) data;
                if (kVar.f22724a == this.f23887a.v.j) {
                    if (kVar.f22725b) {
                        this.f23887a.v.m = true;
                        this.f23887a.u.setVisibility(0);
                        this.f23887a.w(true);
                        b.a.e.f.p.l.L(this.f23887a.f16225g, R.string.attention_success);
                    } else if (StringUtils.isNull(kVar.f22726c)) {
                        b.a.e.f.p.l.L(this.f23887a.f16225g, R.string.attention_fail);
                    } else {
                        b.a.e.f.p.l.M(this.f23887a.f16225g, kVar.f22726c);
                    }
                }
            }
        }
    }

    /* renamed from: b.a.r0.p2.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1159b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f23888a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1159b(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23888a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f23888a.x) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof b.a.r0.m3.s0.k) {
                b.a.r0.m3.s0.k kVar = (b.a.r0.m3.s0.k) data;
                if (kVar.f22724a == this.f23888a.v.j) {
                    if (kVar.f22725b) {
                        this.f23888a.v.m = false;
                        this.f23888a.u.setVisibility(0);
                        b bVar = this.f23888a;
                        bVar.w(bVar.v.m);
                        b.a.e.f.p.l.L(this.f23888a.f16225g, R.string.unlike_success);
                        return;
                    }
                    b.a.e.f.p.l.L(this.f23888a.f16225g, R.string.unlike_failure);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = new a(this, 2001437);
        this.z = new C1159b(this, 2001438);
        t(i());
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_polymeric_attention_bar_view : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.f16223e != i2) {
                SkinManager.setBackgroundResource(this.m, R.drawable.item_person_header_attention_bg_selector);
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.t, R.color.CAM_X0108, 1);
                b.a.r0.p2.e.b bVar = this.v;
                if (bVar != null) {
                    w(bVar.m);
                }
            }
            this.f16223e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (this.m == view) {
                if (!this.x) {
                    TiebaStatic.log(new StatisticItem("c11595"));
                }
                this.f16224f.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f16225g).createNormalCfg(this.v.l, "")));
            } else if (this.u == view) {
                TiebaStatic.log(new StatisticItem("c11596"));
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ViewHelper.skipToLoginActivity(this.f16225g);
                } else if (b.a.e.f.p.k.isForumName(this.v.l)) {
                    b.a.r0.p2.e.b bVar = this.v;
                    if (bVar.m) {
                        return;
                    }
                    this.w.L(bVar.l, String.valueOf(bVar.j));
                }
            }
        }
    }

    public final void t(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.m = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
            this.n = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
            this.o = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
            this.p = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
            this.q = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
            this.r = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
            this.s = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
            this.t = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
            this.u = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
            this.m.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.f16224f.registerListener(this.y);
            this.f16224f.registerListener(this.z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: u */
    public void j(b.a.r0.p2.e.b bVar) {
        Context context;
        int i2;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            if (bVar == null) {
                this.m.setVisibility(8);
                return;
            }
            if (this.m.getVisibility() != 0) {
                this.m.setVisibility(0);
            }
            this.v = bVar;
            this.x = bVar.f23754e;
            this.n.setVisibility(bVar.f23756g ? 0 : 4);
            this.o.setVisibility(bVar.f23756g ? 0 : 4);
            this.n.setText(bVar.f23758i);
            this.o.setText(bVar.f23757h);
            TextView textView = this.p;
            if (bVar.f23754e) {
                string = this.f16225g.getString(R.string.me);
            } else {
                if (bVar.f23755f == 2) {
                    context = this.f16225g;
                    i2 = R.string.she;
                } else {
                    context = this.f16225g;
                    i2 = R.string.he;
                }
                string = context.getString(i2);
            }
            textView.setText(string);
            this.r.startLoad(bVar.k, 10, false);
            String str = bVar.l;
            if (m0.b(str) > 10) {
                str = m0.j(str, 0, 10) + "...";
            }
            this.s.setText(String.format(this.f16225g.getString(R.string.person_polymeric_bar_suffix), str));
            String numFormatOverWanNa = StringHelper.numFormatOverWanNa(bVar.n);
            this.t.setText(bVar.f23754e ? String.format(this.f16225g.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, StringHelper.numFormatOverWanNa(bVar.o)) : String.format(this.f16225g.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
            if (!bVar.m && !bVar.f23754e) {
                this.u.setVisibility(0);
                w(bVar.m);
                return;
            }
            this.u.setVisibility(8);
        }
    }

    public void v(LikeModel likeModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, likeModel) == null) {
            this.w = likeModel;
        }
    }

    public final void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.u.setText(this.f16225g.getString(R.string.relate_forum_is_followed));
                SkinManager.setViewTextColor(this.u, R.color.CAM_X0110);
                SkinManager.setBackgroundResource(this.u, R.color.transparent);
                this.u.setClickable(false);
                return;
            }
            this.u.setText(this.f16225g.getString(R.string.focus_text));
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0302, 1);
            SkinManager.setBackgroundResource(this.u, R.drawable.polymeric_attention_btn_bg);
            this.u.setClickable(true);
        }
    }
}
