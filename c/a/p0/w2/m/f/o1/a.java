package c.a.p0.w2.m.f.o1;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.p0.w2.d;
import c.a.p0.w2.i.f;
import c.a.p0.w2.i.n;
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
import com.baidu.tieba.R;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f20269b;

    /* renamed from: c  reason: collision with root package name */
    public f f20270c;

    /* renamed from: d  reason: collision with root package name */
    public n f20271d;

    /* renamed from: e  reason: collision with root package name */
    public int f20272e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20273f;

    /* renamed from: g  reason: collision with root package name */
    public View f20274g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20275h;
    public TBSpecificationBtn i;
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

    /* renamed from: c.a.p0.w2.m.f.o1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1516a implements VoteCountDownView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1516a(a aVar) {
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

        @Override // com.baidu.tieba.view.VoteCountDownView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f20269b == null) {
                return;
            }
            if (this.a.f20270c == null || this.a.f20270c.f19821h == null) {
                this.a.f20269b.setVisibility(8);
                return;
            }
            this.a.f20270c.f19821h.k(3);
            a aVar = this.a;
            aVar.j(aVar.f20270c);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.obfuscated_res_0x7f0916e0) {
                    if (this.a.f20270c == null || this.a.a == null || !ViewHelper.checkUpIsLogin(this.a.a.getPageActivity())) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.a.a.getPageActivity()).createNormalConfig(c.a.d.f.m.b.g(this.a.f20270c.m(), 0L), 3)));
                } else if (view.getId() != R.id.obfuscated_res_0x7f091750 || !ViewHelper.checkUpIsLogin(this.a.a.getPageActivity()) || this.a.f20270c == null || this.a.f20271d == null || this.a.f20270c.O() == null) {
                } else {
                    if (this.a.f20271d.a()) {
                        new StatisticItem("c13444").param("forum_id", this.a.f20270c.m()).eventStat();
                        d dVar = new d();
                        dVar.i(c.a.d.f.m.b.g(this.a.f20270c.Q(), 0L));
                        dVar.g(c.a.d.f.m.b.g(this.a.f20270c.m(), 0L));
                        a aVar = this.a;
                        PostData f2 = aVar.f(aVar.f20270c);
                        dVar.f(c.a.d.f.m.b.g((f2 == null || f2.s() == null) ? "" : f2.s().getUserId(), 0L));
                        dVar.h(2);
                        dVar.j(this.a.a.getUniqueId());
                        CustomMessage customMessage = new CustomMessage(2921411);
                        customMessage.setData(dVar);
                        MessageManager.getInstance().sendMessage(customMessage);
                        return;
                    }
                    c.a.d.f.p.n.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0808);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage() == null) {
                return;
            }
            int error = httpResponsedMessage.getError();
            if (!(httpResponsedMessage instanceof CommitVoteResMsg) || this.a.f20270c == null || this.a.f20270c.f19821h == null || this.a.a == null || httpResponsedMessage.getOrginalMessage().getTag() != this.a.a.getUniqueId()) {
                return;
            }
            if (error == 0) {
                c.a.d.f.p.n.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f02db);
                this.a.f20270c.f19821h.l(this.a.f20270c.f19821h.h() + 1);
                this.a.f20270c.f19821h.j(false);
                a aVar = this.a;
                aVar.j(aVar.f20270c);
            } else if (error == 3250023) {
                c.a.p0.a4.q0.f.b(error, "", null);
            } else if (error == 3250021) {
                c.a.p0.a4.q0.f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), null);
            } else if (error != 3250002 && error != 3250004) {
                c.a.d.f.p.n.N(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
            } else {
                BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                blockPopInfoData.block_info = m.isEmpty(httpResponsedMessage.getErrorString()) ? this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0314) : httpResponsedMessage.getErrorString();
                blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0312);
                blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0984);
                blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new C1516a(this);
        this.s = new b(this);
        this.t = new c(this, CmdConfigHttp.CMD_BAR_VOTE);
        this.a = tbPageContext;
    }

    public View a(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            TbPageContext tbPageContext = this.a;
            if (tbPageContext == null) {
                return null;
            }
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d013d, (ViewGroup) null);
            this.f20269b = inflate;
            this.f20273f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09168c);
            this.f20274g = this.f20269b.findViewById(R.id.obfuscated_res_0x7f091751);
            this.l = (TextView) this.f20269b.findViewById(R.id.obfuscated_res_0x7f09169a);
            this.i = (TBSpecificationBtn) this.f20269b.findViewById(R.id.obfuscated_res_0x7f091750);
            c.a.o0.r.l0.n.a aVar = new c.a.o0.r.l0.n.a();
            aVar.e(GradientDrawable.Orientation.TL_BR);
            this.i.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0dd1));
            this.i.setTextSize(R.dimen.tbfontsize44);
            this.i.setConfig(aVar);
            this.f20275h = (TextView) this.f20269b.findViewById(R.id.obfuscated_res_0x7f091753);
            this.j = (TextView) this.f20269b.findViewById(R.id.obfuscated_res_0x7f09168d);
            this.k = this.f20269b.findViewById(R.id.obfuscated_res_0x7f091699);
            this.m = (VoteCountDownView) this.f20269b.findViewById(R.id.obfuscated_res_0x7f091752);
            this.n = this.f20269b.findViewById(R.id.obfuscated_res_0x7f091754);
            this.o = (TextView) this.f20269b.findViewById(R.id.obfuscated_res_0x7f091756);
            this.p = (SelectRuleView) this.f20269b.findViewById(R.id.obfuscated_res_0x7f091755);
            this.q = (TextView) this.f20269b.findViewById(R.id.obfuscated_res_0x7f0916e0);
            if (this.t != null) {
                if (this.a.getPageActivity() instanceof BaseActivity) {
                    this.t.setTag(((BaseActivity) this.a.getPageActivity()).getUniqueId());
                } else if (this.a.getPageActivity() instanceof BaseFragmentActivity) {
                    this.t.setTag(((BaseFragmentActivity) this.a.getPageActivity()).getUniqueId());
                }
                MessageManager.getInstance().registerListener(this.t);
            }
            j(fVar);
            return this.f20269b;
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
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
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
            if (fVar == null || fVar.O() == null || fVar.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = fVar.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = fVar.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.n0(1);
            postData.r0(fVar.O().getFirstPostId());
            postData.D0(fVar.O().getTitle());
            postData.C0(fVar.O().getCreateTime());
            postData.l0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20269b : (View) invokeV.objValue;
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            SkinManager.setViewTextColor(this.f20275h, R.color.CAM_X0304, 1, i);
            SkinManager.setViewTextColor(this.f20273f, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0304, 1, i);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1, i);
            TBSpecificationBtn tBSpecificationBtn = this.i;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0206, i);
            VoteCountDownView voteCountDownView = this.m;
            if (voteCountDownView != null) {
                voteCountDownView.e(i);
            }
            SelectRuleView selectRuleView = this.p;
            if (selectRuleView != null) {
                selectRuleView.d(i);
            }
        }
    }

    public void j(f fVar) {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || this.f20269b == null) {
            return;
        }
        if (fVar != null && (nVar = fVar.f19821h) != null) {
            this.f20270c = fVar;
            this.f20271d = nVar;
            if (nVar.d() != 0) {
                int d2 = this.f20271d.d();
                this.f20272e = d2;
                if (d2 == 2) {
                    this.f20274g.setVisibility(8);
                    this.k.setVisibility(0);
                    this.m.setOnCountDownFinished(this.r);
                    this.m.setData(this.f20271d.c() * 1000);
                    this.q.setVisibility(8);
                } else if (d2 == 3) {
                    this.f20274g.setVisibility(0);
                    this.i.setOnClickListener(this.s);
                    this.k.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setOnClickListener(this.s);
                    TextView textView = this.f20275h;
                    textView.setText(this.f20271d.h() + "票");
                } else if (d2 == 4 || d2 == 5) {
                    this.f20274g.setVisibility(0);
                    this.i.setEnabled(false);
                    this.k.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setOnClickListener(this.s);
                    TextView textView2 = this.f20275h;
                    textView2.setText(this.f20271d.h() + "票");
                } else if (d2 == 6) {
                    this.f20274g.setVisibility(0);
                    this.i.setEnabled(false);
                    this.k.setVisibility(8);
                    TextView textView3 = this.f20275h;
                    textView3.setText(this.f20271d.h() + "票");
                    this.q.setVisibility(8);
                } else {
                    this.f20269b.setVisibility(8);
                    return;
                }
                if (!ListUtils.isEmpty(this.f20271d.g()) || !ListUtils.isEmpty(this.f20271d.f())) {
                    this.p.setColumn(2);
                    this.p.setData(this.f20271d.g(), this.f20271d.f());
                }
                i(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            return;
        }
        this.f20269b.setVisibility(8);
    }
}
