package c.a.s0.x2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c extends c.a.s0.g0.b<c.a.s0.x2.e.d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public ClickableHeaderImageView q;
    public ClickableHeaderImageView r;
    public ClickableHeaderImageView s;
    public TextView t;
    public View u;
    public int v;
    public TbPageContext<?> w;
    public View.OnClickListener x;
    public boolean y;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25815e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25815e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (!this.f25815e.y) {
                TiebaStatic.log(new StatisticItem("c11595"));
            }
            if (view.getTag() instanceof UserData) {
                UserData userData = (UserData) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f25815e.w.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext) {
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
        this.v = 3;
        this.w = tbPageContext;
        View j2 = j();
        s();
        this.u = j2.findViewById(c.a.s0.y2.d.bottom_divider);
        this.n = (TextView) j2.findViewById(c.a.s0.y2.d.month_num);
        this.m = (TextView) j2.findViewById(c.a.s0.y2.d.day_num);
        this.o = (TextView) j2.findViewById(c.a.s0.y2.d.identity);
        this.p = (TextView) j2.findViewById(c.a.s0.y2.d.attention_str);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) j2.findViewById(c.a.s0.y2.d.header1);
        this.q = clickableHeaderImageView;
        clickableHeaderImageView.setRadius(c.a.d.f.p.m.f(this.w.getPageActivity(), c.a.s0.y2.b.ds100));
        this.q.setAutoChangeStyle(true);
        this.q.setOnClickListener(this.x);
        ClickableHeaderImageView clickableHeaderImageView2 = (ClickableHeaderImageView) j2.findViewById(c.a.s0.y2.d.header2);
        this.r = clickableHeaderImageView2;
        clickableHeaderImageView2.setRadius(c.a.d.f.p.m.f(this.w.getPageActivity(), c.a.s0.y2.b.ds100));
        this.r.setAutoChangeStyle(true);
        this.r.setOnClickListener(this.x);
        ClickableHeaderImageView clickableHeaderImageView3 = (ClickableHeaderImageView) j2.findViewById(c.a.s0.y2.d.header3);
        this.s = clickableHeaderImageView3;
        clickableHeaderImageView3.setRadius(c.a.d.f.p.m.f(this.w.getPageActivity(), c.a.s0.y2.b.ds100));
        this.s.setAutoChangeStyle(true);
        this.s.setOnClickListener(this.x);
        this.t = (TextView) j2.findViewById(c.a.s0.y2.d.etc_person);
    }

    @Override // c.a.s0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.s0.y2.e.person_info_attention_card : invokeV.intValue;
    }

    @Override // c.a.s0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.v != i2) {
                SkinManager.setBackgroundResource(j(), c.a.s0.y2.c.home_thread_card_item_bg);
                SkinManager.setBackgroundColor(this.u, c.a.s0.y2.a.CAM_X0204);
                SkinManager.setViewTextColor(this.n, c.a.s0.y2.a.CAM_X0106);
                SkinManager.setViewTextColor(this.m, c.a.s0.y2.a.CAM_X0106);
                SkinManager.setViewTextColor(this.o, c.a.s0.y2.a.CAM_X0106);
                SkinManager.setViewTextColor(this.p, c.a.s0.y2.a.CAM_X0106);
                SkinManager.setViewTextColor(this.t, c.a.s0.y2.a.CAM_X0108);
            }
            this.v = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.x = new a(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.g0.b
    /* renamed from: t */
    public void k(c.a.s0.x2.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            if (dVar == null) {
                if (j() != null) {
                    j().setVisibility(8);
                    return;
                }
                return;
            }
            if (j() != null) {
                j().setVisibility(0);
            }
            this.y = dVar.f25700e;
            this.m.setText(dVar.f25703h);
            this.n.setText(dVar.f25702g);
            this.m.setVisibility(dVar.f25701f ? 0 : 4);
            this.n.setVisibility(dVar.f25701f ? 0 : 4);
            if (dVar.f25700e) {
                this.o.setText(this.w.getString(c.a.s0.y2.g.me));
            } else {
                this.o.setText(StringHelper.getUserDescByGender(dVar.f25704i));
            }
            int count = ListUtils.getCount(dVar.f25705j);
            if (count > 3) {
                this.t.setVisibility(0);
                this.t.setText(String.format(this.w.getString(c.a.s0.y2.g.attention_etc_person), Integer.valueOf(count)));
            } else {
                this.t.setVisibility(8);
            }
            if (count >= 3) {
                this.s.setVisibility(0);
                this.s.setTag(dVar.f25705j.get(2));
                if (dVar.f25705j.get(2).getGodUserData() != null && dVar.f25705j.get(2).getGodUserData().getType() == 2) {
                    this.s.setIsGod(true);
                } else {
                    this.s.setIsGod(false);
                }
                this.s.startLoad(dVar.f25705j.get(2).getPortrait(), 12, false);
            } else {
                this.s.setVisibility(8);
            }
            if (count >= 2) {
                this.r.setVisibility(0);
                this.r.setTag(dVar.f25705j.get(1));
                if (dVar.f25705j.get(1).getGodUserData() != null && dVar.f25705j.get(1).getGodUserData().getType() == 2) {
                    this.r.setIsGod(true);
                } else {
                    this.r.setIsGod(false);
                }
                this.r.startLoad(dVar.f25705j.get(1).getPortrait(), 12, false);
            } else {
                this.r.setVisibility(8);
            }
            if (count >= 1) {
                this.q.setVisibility(0);
                this.q.setTag(dVar.f25705j.get(0));
                if (dVar.f25705j.get(0).getGodUserData() != null && dVar.f25705j.get(0).getGodUserData().getType() == 2) {
                    this.q.setIsGod(true);
                } else {
                    this.q.setIsGod(false);
                }
                this.q.startLoad(dVar.f25705j.get(0).getPortrait(), 12, false);
            } else {
                this.q.setVisibility(8);
            }
            l(this.w, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
