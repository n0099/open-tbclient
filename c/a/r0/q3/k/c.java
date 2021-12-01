package c.a.r0.q3.k;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.e;
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.r0.g0.d0;
import c.a.r0.t3.h0;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.view.RecommendBarLayout;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c extends c.a.r0.g0.b<c.a.r0.q3.f.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View m;
    public BarImageView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TBSpecificationBtn s;
    public String t;
    public String u;
    public c.a.r0.q3.f.b v;
    public LikeModel w;
    public h0 x;
    public boolean y;

    /* loaded from: classes6.dex */
    public class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.y = false;
                if (this.a.w.getErrorCode() == 22) {
                    l.M(this.a.f17233f.getPageActivity(), this.a.f17233f.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.a.w.getErrorCode() != 0) {
                        l.M(this.a.f17233f.getPageActivity(), this.a.w.getErrorString());
                    } else {
                        this.a.w(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements h0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
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
            this.a = cVar;
        }

        @Override // c.a.r0.t3.h0.a
        public void a(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
                this.a.y = false;
            }
        }

        @Override // c.a.r0.t3.h0.a
        public void b(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
                this.a.y = false;
                this.a.w(false);
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
        this.y = false;
        this.t = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.u = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View j2 = j();
        this.m = j2;
        this.n = (BarImageView) j2.findViewById(R.id.bar_image);
        this.o = (TextView) j2.findViewById(R.id.bar_name);
        this.p = (TextView) j2.findViewById(R.id.desc);
        this.q = (TextView) j2.findViewById(R.id.member_text);
        this.r = (TextView) j2.findViewById(R.id.post_text);
        this.s = (TBSpecificationBtn) j2.findViewById(R.id.forum_like_button);
    }

    @Override // c.a.r0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.square_forum_item_layout : invokeV.intValue;
    }

    @Override // c.a.r0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
            this.s.changeSkinType();
            SkinManager.setBackgroundColor(j(), R.color.CAM_X0205);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StatisticItem statisticItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || this.v == null) {
            return;
        }
        if (this.m == view) {
            u();
            d0<T> d0Var = this.f17236i;
            if (d0Var != 0) {
                d0Var.a(view, this.v);
            }
        } else if (this.s == view) {
            if (this.f17233f.getPageActivity() instanceof ForumSquareActivity) {
                String h2 = ((ForumSquareActivity) this.f17233f.getPageActivity()).getDelegate().h();
                if (!"推荐".equals(h2)) {
                    statisticItem = new StatisticItem("c13653");
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, h2);
                } else {
                    statisticItem = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_CONCERN);
                    statisticItem.param("obj_locate", 3);
                }
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.v.f22617e);
                statisticItem.param(TiebaStatic.Params.OBJ_TO, this.v.q() ? 2 : 1);
                TiebaStatic.log(statisticItem);
            }
            if (this.v.q()) {
                t();
            } else {
                s();
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.y) {
            return;
        }
        if (!l.C()) {
            UtilHelper.showToast(this.f17233f.getPageActivity(), this.f17233f.getString(R.string.neterror));
            return;
        }
        c.a.r0.q3.f.b bVar = this.v;
        if (bVar == null || StringUtils.isNull(bVar.k()) || this.v.i() <= 0 || !ViewHelper.checkUpIsLogin(this.f17233f.getPageActivity())) {
            return;
        }
        if (this.w == null) {
            LikeModel likeModel = new LikeModel(this.f17233f);
            this.w = likeModel;
            likeModel.setLoadDataCallBack(new a(this));
        }
        if (k.isForumName(this.v.k())) {
            this.y = true;
            this.w.I();
            this.w.L(this.v.k(), String.valueOf(this.v.i()));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.y) {
            return;
        }
        if (!l.C()) {
            UtilHelper.showToast(this.f17233f.getPageActivity(), this.f17233f.getString(R.string.neterror));
            return;
        }
        c.a.r0.q3.f.b bVar = this.v;
        if (bVar == null || StringUtils.isNull(bVar.k()) || this.v.i() <= 0 || !ViewHelper.checkUpIsLogin(this.f17233f.getPageActivity())) {
            return;
        }
        if (this.x == null) {
            h0 h0Var = new h0();
            this.x = h0Var;
            h0Var.b(new b(this));
        }
        this.y = true;
        this.x.c(this.v.k(), this.v.i());
    }

    public final void u() {
        c.a.r0.q3.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bVar = this.v) == null) {
            return;
        }
        String k2 = bVar.k();
        if (k.isForumName(k2)) {
            this.f17233f.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f17233f.getPageActivity()).createNormalCfg(k2, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.g0.b
    /* renamed from: v */
    public void k(c.a.r0.q3.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || bVar == null) {
            return;
        }
        this.v = bVar;
        this.n.setShowOval(true);
        this.n.setShowOuterBorder(false);
        this.n.setShowInnerBorder(true);
        this.n.setStrokeWith(l.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.n.setStrokeColorResId(R.color.CAM_X0401);
        this.n.startLoad(bVar.g(), 10, false);
        String k2 = bVar.k();
        if (k.isEmpty(k2)) {
            k2 = "";
        }
        this.o.setText(k2);
        this.q.setText(this.t + " " + StringHelper.numberUniformFormatExtra(bVar.o()));
        this.r.setText(this.u + " " + StringHelper.numberUniformFormatExtra((long) bVar.p()));
        x(bVar.getRecomReason());
        w(this.v.q());
        this.m.setOnClickListener(this);
        this.s.setOnClickListener(this);
        l(this.f17233f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (!z) {
                c.a.q0.s.g0.n.b bVar = new c.a.q0.s.g0.n.b();
                bVar.r(R.color.CAM_X0302);
                this.s.setConfig(bVar);
                this.s.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
            } else {
                c.a.q0.s.g0.n.b bVar2 = new c.a.q0.s.g0.n.b();
                bVar2.s(R.color.CAM_X0109);
                this.s.setConfig(bVar2);
                this.s.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
            }
            this.v.w(z);
        }
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (k.isEmpty(str)) {
                if (this.p.getVisibility() != 8) {
                    this.p.setVisibility(8);
                    if (this.o.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.o.getLayoutParams()).topMargin = l.f(this.f17233f.getPageActivity(), R.dimen.tbds47);
                        this.o.requestLayout();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.p.getVisibility() != 0) {
                this.p.setVisibility(0);
                if (this.o.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.o.getLayoutParams()).topMargin = l.f(this.f17233f.getPageActivity(), R.dimen.tbds24);
                    this.o.requestLayout();
                }
            }
            this.p.setText(str);
        }
    }
}
