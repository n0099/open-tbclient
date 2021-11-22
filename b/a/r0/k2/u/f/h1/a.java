package b.a.r0.k2.u.f.h1;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.e.f.p.k;
import b.a.e.f.p.l;
import b.a.r0.k2.g;
import b.a.r0.k2.i;
import b.a.r0.k2.j;
import b.a.r0.k2.r.f;
import b.a.r0.k2.r.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tbadk.widget.SelectRuleView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.VoteCountDownView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f20847a;

    /* renamed from: b  reason: collision with root package name */
    public View f20848b;

    /* renamed from: c  reason: collision with root package name */
    public f f20849c;

    /* renamed from: d  reason: collision with root package name */
    public m f20850d;

    /* renamed from: e  reason: collision with root package name */
    public int f20851e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20852f;

    /* renamed from: g  reason: collision with root package name */
    public View f20853g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20854h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f20855i;
    public TextView j;
    public View k;
    public TextView l;
    public VoteCountDownView m;
    public View n;
    public TextView o;
    public SelectRuleView p;
    public TextView q;
    public VoteCountDownView.b r;
    public View.OnClickListener s;
    public HttpMessageListener t;

    /* renamed from: b.a.r0.k2.u.f.h1.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1039a implements VoteCountDownView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20856a;

        public C1039a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20856a = aVar;
        }

        @Override // com.baidu.tieba.view.VoteCountDownView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20856a.f20848b == null) {
                return;
            }
            if (this.f20856a.f20849c == null || this.f20856a.f20849c.f20300h == null) {
                this.f20856a.f20848b.setVisibility(8);
                return;
            }
            this.f20856a.f20849c.f20300h.k(3);
            a aVar = this.f20856a;
            aVar.j(aVar.f20849c);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20857e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20857e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == i.pb_jump_to_vote_page) {
                    if (this.f20857e.f20849c == null || this.f20857e.f20847a == null || !ViewHelper.checkUpIsLogin(this.f20857e.f20847a.getPageActivity())) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.f20857e.f20847a.getPageActivity()).createNormalConfig(b.a.e.f.m.b.g(this.f20857e.f20849c.m(), 0L), 3)));
                } else if (view.getId() != i.pb_vote_button || !ViewHelper.checkUpIsLogin(this.f20857e.f20847a.getPageActivity()) || this.f20857e.f20849c == null || this.f20857e.f20850d == null || this.f20857e.f20849c.O() == null) {
                } else {
                    if (this.f20857e.f20850d.a()) {
                        new StatisticItem("c13444").param("forum_id", this.f20857e.f20849c.m()).eventStat();
                        b.a.r0.k2.d dVar = new b.a.r0.k2.d();
                        dVar.i(b.a.e.f.m.b.g(this.f20857e.f20849c.Q(), 0L));
                        dVar.g(b.a.e.f.m.b.g(this.f20857e.f20849c.m(), 0L));
                        a aVar = this.f20857e;
                        PostData f2 = aVar.f(aVar.f20849c);
                        dVar.f(b.a.e.f.m.b.g((f2 == null || f2.t() == null) ? "" : f2.t().getUserId(), 0L));
                        dVar.h(2);
                        dVar.j(this.f20857e.f20847a.getUniqueId());
                        CustomMessage customMessage = new CustomMessage(2921411);
                        customMessage.setData(dVar);
                        MessageManager.getInstance().sendMessage(customMessage);
                        return;
                    }
                    l.L(TbadkCoreApplication.getInst(), b.a.r0.k2.l.has_not_other_ticket);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20858a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f20858a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage() == null) {
                return;
            }
            int error = httpResponsedMessage.getError();
            if (!(httpResponsedMessage instanceof CommitVoteResMsg) || this.f20858a.f20849c == null || this.f20858a.f20849c.f20300h == null || this.f20858a.f20847a == null || httpResponsedMessage.getOrginalMessage().getTag() != this.f20858a.f20847a.getUniqueId()) {
                return;
            }
            if (error == 0) {
                l.L(TbadkCoreApplication.getInst(), b.a.r0.k2.l.bar_manager_vote_success);
                this.f20858a.f20849c.f20300h.l(this.f20858a.f20849c.f20300h.h() + 1);
                this.f20858a.f20849c.f20300h.j(false);
                a aVar = this.f20858a;
                aVar.j(aVar.f20849c);
            } else if (error == 3250023) {
                b.a.r0.m3.p0.f.b(error, "", null);
            } else if (error == 3250021) {
                b.a.r0.m3.p0.f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), null);
            } else if (error != 3250002 && error != 3250004) {
                l.M(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
            } else {
                BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                blockPopInfoData.block_info = k.isEmpty(httpResponsedMessage.getErrorString()) ? this.f20858a.f20847a.getResources().getString(b.a.r0.k2.l.block_user_tip) : httpResponsedMessage.getErrorString();
                blockPopInfoData.ahead_info = this.f20858a.f20847a.getResources().getString(b.a.r0.k2.l.block_user_feed);
                blockPopInfoData.ok_info = this.f20858a.f20847a.getResources().getString(b.a.r0.k2.l.know);
                blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                AntiHelper.s(this.f20858a.f20847a.getPageActivity(), blockPopInfoData);
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new C1039a(this);
        this.s = new b(this);
        this.t = new c(this, CmdConfigHttp.CMD_BAR_VOTE);
        this.f20847a = tbPageContext;
    }

    public View a(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            TbPageContext tbPageContext = this.f20847a;
            if (tbPageContext == null) {
                return null;
            }
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(j.bar_manager_select_view, (ViewGroup) null);
            this.f20848b = inflate;
            this.f20852f = (TextView) inflate.findViewById(i.pb_bar_manager_select_warn);
            this.f20853g = this.f20848b.findViewById(i.pb_vote_button_container);
            this.l = (TextView) this.f20848b.findViewById(i.pb_count_down_title);
            this.f20855i = (TBSpecificationBtn) this.f20848b.findViewById(i.pb_vote_button);
            b.a.q0.s.g0.n.a aVar = new b.a.q0.s.g0.n.a();
            aVar.e(GradientDrawable.Orientation.TL_BR);
            this.f20855i.setText(TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.pb_vote_text));
            this.f20855i.setTextSize(g.tbfontsize44);
            this.f20855i.setConfig(aVar);
            this.f20854h = (TextView) this.f20848b.findViewById(i.pb_vote_num);
            this.j = (TextView) this.f20848b.findViewById(i.pb_bar_manager_ueg_tip);
            this.k = this.f20848b.findViewById(i.pb_count_down_container);
            this.m = (VoteCountDownView) this.f20848b.findViewById(i.pb_vote_count_down_view);
            this.n = this.f20848b.findViewById(i.pb_vote_rule);
            this.o = (TextView) this.f20848b.findViewById(i.pb_vote_rule_title);
            this.p = (SelectRuleView) this.f20848b.findViewById(i.pb_vote_rule_content);
            this.q = (TextView) this.f20848b.findViewById(i.pb_jump_to_vote_page);
            if (this.t != null) {
                if (this.f20847a.getPageActivity() instanceof BaseActivity) {
                    this.t.setTag(((BaseActivity) this.f20847a.getPageActivity()).getUniqueId());
                } else if (this.f20847a.getPageActivity() instanceof BaseFragmentActivity) {
                    this.t.setTag(((BaseFragmentActivity) this.f20847a.getPageActivity()).getUniqueId());
                }
                MessageManager.getInstance().registerListener(this.t);
            }
            j(fVar);
            return this.f20848b;
        }
        return (View) invokeL.objValue;
    }

    public PostData f(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            PostData postData = null;
            if (fVar == null) {
                return null;
            }
            if (fVar.W() != null) {
                return fVar.W();
            }
            if (!ListUtils.isEmpty(fVar.F())) {
                Iterator<PostData> it = fVar.F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        postData = next;
                        break;
                    }
                }
            }
            if (postData == null) {
                postData = fVar.j();
            }
            if (postData == null) {
                postData = g(fVar);
            }
            if (postData != null && postData.t() != null && postData.t().getUserTbVipInfoData() != null && postData.t().getUserTbVipInfoData().getvipIntro() != null) {
                postData.t().getGodUserData().setIntro(postData.t().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public final PostData g(f fVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null || fVar.O().J() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData J = fVar.O().J();
            String userId = J.getUserId();
            HashMap<String, MetaData> B1 = fVar.O().B1();
            if (B1 != null && (metaData = B1.get(userId)) != null && metaData.getUserId() != null) {
                J = metaData;
            }
            postData.m0(1);
            postData.q0(fVar.O().W());
            postData.C0(fVar.O().getTitle());
            postData.B0(fVar.O().P());
            postData.k0(J);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20848b : (View) invokeV.objValue;
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setViewTextColor(this.f20854h, b.a.r0.k2.f.CAM_X0304, 1, i2);
            SkinManager.setViewTextColor(this.f20852f, b.a.r0.k2.f.CAM_X0109, 1, i2);
            SkinManager.setViewTextColor(this.j, b.a.r0.k2.f.CAM_X0109, 1, i2);
            SkinManager.setViewTextColor(this.o, b.a.r0.k2.f.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.q, b.a.r0.k2.f.CAM_X0304, 1, i2);
            SkinManager.setViewTextColor(this.l, b.a.r0.k2.f.CAM_X0105, 1, i2);
            TBSpecificationBtn tBSpecificationBtn = this.f20855i;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
            SkinManager.setBackgroundColor(this.n, b.a.r0.k2.f.CAM_X0206, i2);
            VoteCountDownView voteCountDownView = this.m;
            if (voteCountDownView != null) {
                voteCountDownView.onSkinChange(i2);
            }
            SelectRuleView selectRuleView = this.p;
            if (selectRuleView != null) {
                selectRuleView.onSkinTypeChange(i2);
            }
        }
    }

    public void j(f fVar) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || this.f20848b == null) {
            return;
        }
        if (fVar != null && (mVar = fVar.f20300h) != null) {
            this.f20849c = fVar;
            this.f20850d = mVar;
            if (mVar.d() != 0) {
                int d2 = this.f20850d.d();
                this.f20851e = d2;
                if (d2 == 2) {
                    this.f20853g.setVisibility(8);
                    this.k.setVisibility(0);
                    this.m.setOnCountDownFinished(this.r);
                    this.m.setData(this.f20850d.c() * 1000);
                    this.q.setVisibility(8);
                } else if (d2 == 3) {
                    this.f20853g.setVisibility(0);
                    this.f20855i.setOnClickListener(this.s);
                    this.k.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setOnClickListener(this.s);
                    TextView textView = this.f20854h;
                    textView.setText(this.f20850d.h() + "票");
                } else if (d2 == 4 || d2 == 5) {
                    this.f20853g.setVisibility(0);
                    this.f20855i.setEnabled(false);
                    this.k.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setOnClickListener(this.s);
                    TextView textView2 = this.f20854h;
                    textView2.setText(this.f20850d.h() + "票");
                } else if (d2 == 6) {
                    this.f20853g.setVisibility(0);
                    this.f20855i.setEnabled(false);
                    this.k.setVisibility(8);
                    TextView textView3 = this.f20854h;
                    textView3.setText(this.f20850d.h() + "票");
                    this.q.setVisibility(8);
                } else {
                    this.f20848b.setVisibility(8);
                    return;
                }
                if (!ListUtils.isEmpty(this.f20850d.g()) || !ListUtils.isEmpty(this.f20850d.f())) {
                    this.p.setColumn(2);
                    this.p.setData(this.f20850d.g(), this.f20850d.f());
                }
                i(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            return;
        }
        this.f20848b.setVisibility(8);
    }
}
