package c.a.r0.z2.k;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import c.a.q0.c1.o0;
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
/* loaded from: classes3.dex */
public class b extends c.a.r0.f0.b<c.a.r0.z2.e.b> {
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
    public c.a.r0.z2.e.b v;
    public LikeModel w;
    public boolean x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes3.dex */
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
            if (data instanceof c.a.r0.y3.t0.f) {
                c.a.r0.y3.t0.f fVar = (c.a.r0.y3.t0.f) data;
                if (fVar.a == this.a.v.f25636j) {
                    if (fVar.f25222b) {
                        this.a.v.m = true;
                        this.a.u.setVisibility(0);
                        this.a.x(true);
                        c.a.d.f.p.n.M(this.a.f17262g, R.string.attention_success);
                    } else if (StringUtils.isNull(fVar.f25223c)) {
                        c.a.d.f.p.n.M(this.a.f17262g, R.string.attention_fail);
                    } else {
                        c.a.d.f.p.n.N(this.a.f17262g, fVar.f25223c);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.r0.z2.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1574b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1574b(b bVar, int i2) {
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
            if (data instanceof c.a.r0.y3.t0.f) {
                c.a.r0.y3.t0.f fVar = (c.a.r0.y3.t0.f) data;
                if (fVar.a == this.a.v.f25636j) {
                    if (fVar.f25222b) {
                        this.a.v.m = false;
                        this.a.u.setVisibility(0);
                        b bVar = this.a;
                        bVar.x(bVar.v.m);
                        c.a.d.f.p.n.M(this.a.f17262g, R.string.unlike_success);
                        return;
                    }
                    c.a.d.f.p.n.M(this.a.f17262g, R.string.unlike_failure);
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
        this.z = new C1574b(this, 2001438);
        u(j());
    }

    @Override // c.a.r0.f0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_polymeric_attention_bar_view : invokeV.intValue;
    }

    @Override // c.a.r0.f0.b
    public void l(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.f17260e != i2) {
                SkinManager.setBackgroundResource(this.m, R.drawable.item_person_header_attention_bg_selector);
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.t, R.color.CAM_X0108, 1);
                c.a.r0.z2.e.b bVar = this.v;
                if (bVar != null) {
                    x(bVar.m);
                }
            }
            this.f17260e = i2;
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
                this.f17261f.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f17262g).createNormalCfg(this.v.l, "")));
            } else if (this.u == view) {
                TiebaStatic.log(new StatisticItem("c11596"));
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ViewHelper.skipToLoginActivity(this.f17262g);
                } else if (c.a.d.f.p.m.isForumName(this.v.l)) {
                    c.a.r0.z2.e.b bVar = this.v;
                    if (bVar.m) {
                        return;
                    }
                    this.w.N(bVar.l, String.valueOf(bVar.f25636j));
                }
            }
        }
    }

    public final void u(View view) {
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
            this.f17261f.registerListener(this.y);
            this.f17261f.registerListener(this.z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.f0.b
    /* renamed from: v */
    public void k(c.a.r0.z2.e.b bVar) {
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
            this.x = bVar.f25631e;
            this.n.setVisibility(bVar.f25633g ? 0 : 4);
            this.o.setVisibility(bVar.f25633g ? 0 : 4);
            this.n.setText(bVar.f25635i);
            this.o.setText(bVar.f25634h);
            TextView textView = this.p;
            if (bVar.f25631e) {
                string = this.f17262g.getString(R.string.me);
            } else {
                if (bVar.f25632f == 2) {
                    context = this.f17262g;
                    i2 = R.string.she;
                } else {
                    context = this.f17262g;
                    i2 = R.string.he;
                }
                string = context.getString(i2);
            }
            textView.setText(string);
            this.r.startLoad(bVar.k, 10, false);
            String str = bVar.l;
            if (o0.b(str) > 10) {
                str = o0.k(str, 0, 10) + "...";
            }
            this.s.setText(String.format(this.f17262g.getString(R.string.person_polymeric_bar_suffix), str));
            String numFormatOverWanNa = StringHelper.numFormatOverWanNa(bVar.n);
            this.t.setText(bVar.f25631e ? String.format(this.f17262g.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, StringHelper.numFormatOverWanNa(bVar.o)) : String.format(this.f17262g.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
            if (!bVar.m && !bVar.f25631e) {
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
                this.u.setText(this.f17262g.getString(R.string.relate_forum_is_followed));
                SkinManager.setViewTextColor(this.u, (int) R.color.CAM_X0110);
                SkinManager.setBackgroundResource(this.u, R.color.transparent);
                this.u.setClickable(false);
                return;
            }
            this.u.setText(this.f17262g.getString(R.string.focus_text));
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0302, 1);
            SkinManager.setBackgroundResource(this.u, R.drawable.polymeric_attention_btn_bg);
            this.u.setClickable(true);
        }
    }
}
