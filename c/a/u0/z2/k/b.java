package c.a.u0.z2.k;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import c.a.t0.d1.p0;
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
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b extends c.a.u0.g0.b<c.a.u0.z2.e.b> {
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
    public c.a.u0.z2.e.b v;
    public LikeModel w;
    public boolean x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.x) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof c.a.u0.z3.t0.f) {
                c.a.u0.z3.t0.f fVar = (c.a.u0.z3.t0.f) data;
                if (fVar.a == this.a.v.f25974j) {
                    if (fVar.f26402b) {
                        this.a.v.m = true;
                        this.a.u.setVisibility(0);
                        this.a.x(true);
                        c.a.d.f.p.n.M(this.a.f17876g, c.a.u0.a3.g.attention_success);
                    } else if (StringUtils.isNull(fVar.f26403c)) {
                        c.a.d.f.p.n.M(this.a.f17876g, c.a.u0.a3.g.attention_fail);
                    } else {
                        c.a.d.f.p.n.N(this.a.f17876g, fVar.f26403c);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.u0.z2.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1582b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1582b(b bVar, int i2) {
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.x) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof c.a.u0.z3.t0.f) {
                c.a.u0.z3.t0.f fVar = (c.a.u0.z3.t0.f) data;
                if (fVar.a == this.a.v.f25974j) {
                    if (fVar.f26402b) {
                        this.a.v.m = false;
                        this.a.u.setVisibility(0);
                        b bVar = this.a;
                        bVar.x(bVar.v.m);
                        c.a.d.f.p.n.M(this.a.f17876g, c.a.u0.a3.g.unlike_success);
                        return;
                    }
                    c.a.d.f.p.n.M(this.a.f17876g, c.a.u0.a3.g.unlike_failure);
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
        this.z = new C1582b(this, 2001438);
        u(j());
    }

    @Override // c.a.u0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.u0.a3.e.card_polymeric_attention_bar_view : invokeV.intValue;
    }

    @Override // c.a.u0.g0.b
    public void l(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.f17874e != i2) {
                SkinManager.setBackgroundResource(this.m, c.a.u0.a3.c.item_person_header_attention_bg_selector);
                SkinManager.setViewTextColor(this.n, c.a.u0.a3.a.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.o, c.a.u0.a3.a.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.p, c.a.u0.a3.a.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.q, c.a.u0.a3.a.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.s, c.a.u0.a3.a.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.t, c.a.u0.a3.a.CAM_X0108, 1);
                c.a.u0.z2.e.b bVar = this.v;
                if (bVar != null) {
                    x(bVar.m);
                }
            }
            this.f17874e = i2;
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
                this.f17875f.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f17876g).createNormalCfg(this.v.l, "")));
            } else if (this.u == view) {
                TiebaStatic.log(new StatisticItem("c11596"));
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ViewHelper.skipToLoginActivity(this.f17876g);
                } else if (c.a.d.f.p.m.isForumName(this.v.l)) {
                    c.a.u0.z2.e.b bVar = this.v;
                    if (bVar.m) {
                        return;
                    }
                    this.w.N(bVar.l, String.valueOf(bVar.f25974j));
                }
            }
        }
    }

    public final void u(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.m = view.findViewById(c.a.u0.a3.d.card_polymeric_attention_bar_rootview);
            this.n = (TextView) view.findViewById(c.a.u0.a3.d.card_polymeric_attention_bar_day);
            this.o = (TextView) view.findViewById(c.a.u0.a3.d.card_polymeric_attention_bar_month);
            this.p = (TextView) view.findViewById(c.a.u0.a3.d.card_polymeric_attention_sex);
            this.q = (TextView) view.findViewById(c.a.u0.a3.d.card_polymeric_attention_bar_des);
            this.r = (BarImageView) view.findViewById(c.a.u0.a3.d.card_polymeric_attention_icon);
            this.s = (TextView) view.findViewById(c.a.u0.a3.d.card_polymeric_attention_bar_name);
            this.t = (TextView) view.findViewById(c.a.u0.a3.d.card_polymeric_attention_post_num);
            this.u = (TextView) view.findViewById(c.a.u0.a3.d.card_polymeric_attention_btn);
            this.m.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.f17875f.registerListener(this.y);
            this.f17875f.registerListener(this.z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.u0.g0.b
    /* renamed from: v */
    public void k(c.a.u0.z2.e.b bVar) {
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
            this.x = bVar.f25969e;
            this.n.setVisibility(bVar.f25971g ? 0 : 4);
            this.o.setVisibility(bVar.f25971g ? 0 : 4);
            this.n.setText(bVar.f25973i);
            this.o.setText(bVar.f25972h);
            TextView textView = this.p;
            if (bVar.f25969e) {
                string = this.f17876g.getString(c.a.u0.a3.g.me);
            } else {
                if (bVar.f25970f == 2) {
                    context = this.f17876g;
                    i2 = c.a.u0.a3.g.she;
                } else {
                    context = this.f17876g;
                    i2 = c.a.u0.a3.g.he;
                }
                string = context.getString(i2);
            }
            textView.setText(string);
            this.r.startLoad(bVar.k, 10, false);
            String str = bVar.l;
            if (p0.b(str) > 10) {
                str = p0.k(str, 0, 10) + "...";
            }
            this.s.setText(String.format(this.f17876g.getString(c.a.u0.a3.g.person_polymeric_bar_suffix), str));
            String numFormatOverWanNa = StringHelper.numFormatOverWanNa(bVar.n);
            this.t.setText(bVar.f25969e ? String.format(this.f17876g.getString(c.a.u0.a3.g.person_polymeric_attention_post_host), numFormatOverWanNa, StringHelper.numFormatOverWanNa(bVar.o)) : String.format(this.f17876g.getString(c.a.u0.a3.g.person_polymeric_attention_post_guess), numFormatOverWanNa));
            if (!bVar.m && !bVar.f25969e) {
                this.u.setVisibility(0);
                x(bVar.m);
                return;
            }
            this.u.setVisibility(8);
        }
    }

    public void w(LikeModel likeModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, likeModel) == null) {
            this.w = likeModel;
        }
    }

    public final void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.u.setText(this.f17876g.getString(c.a.u0.a3.g.relate_forum_is_followed));
                SkinManager.setViewTextColor(this.u, c.a.u0.a3.a.CAM_X0110);
                SkinManager.setBackgroundResource(this.u, c.a.u0.a3.a.transparent);
                this.u.setClickable(false);
                return;
            }
            this.u.setText(this.f17876g.getString(c.a.u0.a3.g.focus_text));
            SkinManager.setViewTextColor(this.u, c.a.u0.a3.a.CAM_X0302, 1);
            SkinManager.setBackgroundResource(this.u, c.a.u0.a3.c.polymeric_attention_btn_bg);
            this.u.setClickable(true);
        }
    }
}
