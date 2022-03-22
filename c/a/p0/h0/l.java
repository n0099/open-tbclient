package c.a.p0.h0;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.c1.t0;
import c.a.o0.r.r.v0;
import c.a.p0.c3.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class l extends c.a.p0.h0.b<c.a.p0.h0.e0.l> implements View.OnClickListener, c.a.p0.v.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public TextView B;
    public View C;
    public TextView D;
    public View E;
    public c.a.p0.c3.r F;
    public c.a.p0.h0.e0.l G;
    public View H;
    public int I;
    public int J;
    public boolean K;
    public boolean L;
    public String M;
    public c.a.p0.c3.h N;
    public Animation O;
    public TextView P;
    public TextView Q;
    public String R;
    public Handler S;
    public Runnable T;
    public Runnable U;
    public final View.OnClickListener V;
    public final View.OnClickListener W;
    public c.a.e.m.d i;
    public ThreadCommentAndPraiseInfoLayout j;
    public View k;
    public FrameLayout l;
    public ThreadGodReplyLayout m;
    public LinearLayout n;
    public NEGFeedBackView o;
    public String p;
    public ThreadSourceShareAndPraiseLayout q;
    public TbPageContext<?> r;
    public RelativeLayout s;
    public TextView t;
    public ThreadUserInfoLayout u;
    public HeadPendantClickableView v;
    public TbImageView w;
    public ImageView x;
    public TbVideoViewContainer y;
    public TextView z;

    /* loaded from: classes2.dex */
    public class a extends c.a.o0.e1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f15355h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, int i, String str, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15355h = str2;
        }

        @Override // c.a.o0.e1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.o0.l.a.v(TbadkCoreApplication.getInst().getApplicationContext(), false, this.f15355h);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "0"));
            }
        }

        @Override // c.a.o0.e1.n.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // c.a.p0.c3.h.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (i2 >= i) {
                    this.a.i.I(false, false, "HOME");
                } else if (i == 0 || (i2 * 100) / i < 80 || i <= 15000) {
                } else {
                    l lVar = this.a;
                    lVar.N(lVar.G);
                }
            }
        }
    }

    public final void A(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            c.a.p0.h0.e0.l lVar = this.G;
            if (lVar != null) {
                lVar.f15320f = 1;
            }
            if (h() != null) {
                h().a(view, this.G);
            }
            c.a.p0.h0.e0.l lVar2 = this.G;
            if (lVar2 == null || lVar2.a == null) {
                return;
            }
            if (!E()) {
                m.a(this.G.a.getId());
                m.l(this.t, this.G.a.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.r.getPageActivity()).createFromThreadCfg(this.G.a, null, m.g(), 18003, true, false, false).addLocateParam(this.G.getPbInputLocate());
            addLocateParam.setVideo_source(this.G.T == 0 ? "index" : "hot_juhe");
            if (this.G.T == 0) {
                addLocateParam.setFrom("from_personalize");
            }
            addLocateParam.setForumId(String.valueOf(this.G.a.getFid()));
            addLocateParam.setForumName(this.G.a.getForum_name());
            addLocateParam.setStartFrom(this.f15310h);
            if (view == this.m) {
                addLocateParam.setJumpGodReply(true);
            }
            this.r.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    public final void B() {
        c.a.p0.h0.e0.l lVar;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            J();
            I();
            if (this.w == null || this.l == null || this.y == null) {
                return;
            }
            if (c.a.o0.r.l.c().g() && (lVar = this.G) != null && (threadData = lVar.a) != null && threadData.getThreadVideoInfo() != null) {
                this.w.setPlaceHolder(3);
                this.w.J(this.G.a.getThreadVideoInfo().thumbnail_url, 10, false);
                this.l.setVisibility(0);
                stopPlay();
                this.M = this.G.a.getThreadVideoInfo().video_url;
                if (D()) {
                    this.M = this.G.a.getThreadVideoSegment().video_url;
                }
                if (StringUtils.isNull(this.G.a.getThreadVideoInfo().video_url)) {
                    L(true, 4);
                }
                this.y.getControl().setThreadDataForStatistic(this.G.a);
            } else {
                this.l.setVisibility(8);
            }
            this.i.B();
            this.N.j(new b(this));
        }
    }

    public final void C(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (h() != null) {
                h().a(view, this.G);
            }
            if (!c.a.d.f.p.l.z()) {
                c.a.d.f.p.n.M(this.r.getPageActivity(), R.string.obfuscated_res_0x7f0f0c4c);
            } else {
                y();
            }
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.p0.h0.e0.l lVar = this.G;
            return (lVar == null || (threadData = lVar.a) == null || threadData.getThreadVideoSegment() == null || TextUtils.isEmpty(this.G.a.getThreadVideoSegment().video_url)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.p0.h0.e0.l lVar = this.G;
            return lVar.R && !lVar.S;
        }
        return invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.K : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: G */
    public void l(c.a.p0.h0.e0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lVar) == null) {
            this.G = lVar;
            H();
        }
    }

    public final void H() {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.h0.e0.l lVar = this.G;
            if (lVar != null && (threadData = lVar.a) != null && threadData.getAuthor() != null) {
                this.s.setVisibility(0);
                B();
                if (!E() && m.k(this.G.a.getId())) {
                    m.l(this.t, this.G.a.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    m.l(this.m.getGodReplyContent(), this.G.getThreadData().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
                }
                this.G.getThreadData().parser_title();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.G.getThreadData().getSpan_str());
                if (this.G.getThreadData().canShowNaniTail() && !StringUtils.isNull(this.G.getThreadData().getTid())) {
                    String str = c.a.o0.r.j0.b.k().q("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.G.getThreadData().getTid();
                    spannableStringBuilder.append((CharSequence) this.G.getThreadData().generateNaniTail(new a(this, 2, str, str)));
                }
                this.t.setOnTouchListener(new c.a.p0.q4.i(spannableStringBuilder));
                this.t.setText(spannableStringBuilder);
                this.u.j(this.G.getThreadData());
                this.u.setUserAfterClickListener(this.V);
                if (this.u.getHeaderImg() != null) {
                    this.u.getHeaderImg().setAfterClickListener(this.W);
                    if (this.u.getIsSimpleThread()) {
                        this.u.getHeaderImg().setVisibility(8);
                        this.v.setVisibility(8);
                    } else if (this.G.getThreadData() != null && this.G.getThreadData().getAuthor() != null && this.G.getThreadData().getAuthor().getPendantData() != null && !StringUtils.isNull(this.G.getThreadData().getAuthor().getPendantData().getImgUrl())) {
                        this.u.getHeaderImg().setVisibility(4);
                        this.v.setVisibility(0);
                        this.v.setData(this.G.getThreadData());
                    } else {
                        this.v.setVisibility(8);
                        this.u.getHeaderImg().setVisibility(0);
                        if (this.G.getThreadData().middle_page_num > 0 && this.G.getThreadData().middle_page_pass_flag == 0) {
                            this.G.getThreadData().getAuthor().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                            this.u.getHeaderImg().setData(this.G.getThreadData(), false);
                        } else {
                            this.u.getHeaderImg().setData(this.G.getThreadData());
                            this.u.getHeaderImg().setOnInterceptClickEventListener(null);
                        }
                    }
                }
                this.z.setText(StringHelper.stringForVideoTime(this.G.a.getThreadVideoInfo().video_duration.intValue() * 1000));
                this.B.setText(String.format(this.r.getResources().getString(R.string.obfuscated_res_0x7f0f0e4a), StringHelper.numFormatOverWan(this.G.a.getThreadVideoInfo().play_count.intValue())));
                if (this.o != null && this.G.getThreadData() != null) {
                    v0 v0Var = new v0();
                    v0Var.o(this.G.getThreadData().getTid());
                    v0Var.k(this.G.getThreadData().getFid());
                    v0Var.n(this.G.getThreadData().getNid());
                    v0Var.j(this.G.feedBackReasonMap);
                    this.o.setData(v0Var);
                    this.o.setFirstRowSingleColumn(true);
                    this.o.setVisibility(this.L ? 0 : 8);
                }
                this.m.setData(this.G.getThreadData().getTopAgreePost());
                M(u(1));
                m(this.r, TbadkCoreApplication.getInst().getSkinType());
                if (m.k(this.G.a.getId())) {
                    SkinManager.setViewTextColor(this.t, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.t, R.color.CAM_X0105, 1);
                }
                c.a.p0.h0.e0.l lVar2 = this.G;
                if ((lVar2 == null || (threadData2 = lVar2.a) == null || threadData2.getThreadVideoInfo() == null || this.G.a.getThreadVideoInfo().is_vertical.intValue() != 1) ? false : true) {
                    this.Q.setVisibility(0);
                    if (D()) {
                        this.Q.setText(String.format("%s | %s", this.r.getResources().getString(R.string.obfuscated_res_0x7f0f0c07), this.r.getResources().getString(R.string.obfuscated_res_0x7f0f14e8)));
                        return;
                    } else {
                        this.Q.setText(this.r.getString(R.string.obfuscated_res_0x7f0f0c07));
                        return;
                    }
                } else if (D()) {
                    this.Q.setVisibility(0);
                    this.Q.setText(this.r.getString(R.string.obfuscated_res_0x7f0f14e8));
                    return;
                } else {
                    this.Q.setVisibility(8);
                    return;
                }
            }
            this.s.setVisibility(8);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.S.removeMessages(202);
            this.S.removeMessages(203);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.T);
            c.a.d.f.m.e.a().removeCallbacks(this.U);
        }
    }

    public final void K() {
        c.a.p0.h0.e0.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (lVar = this.G) == null || lVar.a == null) {
            return;
        }
        c.a.p0.c3.u uVar = new c.a.p0.c3.u();
        uVar.a = this.G.T == 0 ? "index" : "hot_juhe";
        uVar.f13504c = this.G.a.getTid();
        uVar.f13505d = this.G.a.getFid() + "";
        uVar.f13506e = TbadkCoreApplication.getCurrentAccount();
        c.a.p0.h0.e0.l lVar2 = this.G;
        ThreadData threadData = lVar2.a;
        uVar.f13507f = threadData.mRecomSource;
        String str = threadData.mRecomAbTag;
        uVar.l = str;
        uVar.f13508g = str;
        uVar.f13509h = threadData.mRecomWeight;
        uVar.i = "";
        uVar.k = lVar2.i();
        if (this.G.a.getThreadVideoInfo() != null) {
            uVar.m = this.G.a.getThreadVideoInfo().video_md5;
        }
        c.a.p0.c3.j.e(this.G.a.getThreadVideoInfo().video_md5, "", "1", uVar, this.y.getControl().getPcdnState());
    }

    public final void L(boolean z, int i) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || this.x == null || this.w == null || this.H == null || this.F == null || this.E == null || this.D == null) {
            return;
        }
        if (z || this.J != i) {
            this.J = i;
            c.a.d.f.m.e.a().removeCallbacks(this.U);
            c.a.d.f.m.e.a().removeCallbacks(this.T);
            if (i == 2) {
                this.x.setVisibility(8);
                this.O.cancel();
                this.w.clearAnimation();
                this.w.setVisibility(0);
                this.H.setVisibility(0);
                this.A.setVisibility(0);
                this.P.setVisibility(8);
                this.F.g();
                this.E.setVisibility(8);
                this.D.setVisibility(8);
                c.a.d.f.m.e.a().postDelayed(this.U, 60000L);
            } else if (i == 3) {
                this.x.setVisibility(8);
                this.w.startAnimation(this.O);
                this.H.setVisibility(8);
                this.A.setVisibility(8);
                c.a.p0.h0.e0.l lVar = this.G;
                if (lVar != null && lVar.getThreadData() != null && this.G.getThreadData().middle_page_num > 0) {
                    this.P.setVisibility(0);
                }
                this.F.c();
                this.E.setVisibility(8);
                this.D.setVisibility(8);
                c.a.p0.h0.e0.l lVar2 = this.G;
                if (lVar2 != null && (threadData = lVar2.a) != null && threadData.getThreadVideoInfo() != null) {
                    this.G.a.getThreadVideoInfo().video_length.intValue();
                    this.G.a.getThreadVideoInfo().video_duration.intValue();
                    this.G.a.getTid();
                }
            } else if (i == 4) {
                this.x.setVisibility(8);
                this.w.startAnimation(this.O);
                this.H.setVisibility(8);
                this.F.b();
                this.E.setVisibility(0);
                this.D.setVisibility(0);
                c.a.d.f.m.e.a().postDelayed(this.T, 2000L);
            } else {
                this.x.setVisibility(0);
                this.O.cancel();
                this.w.clearAnimation();
                this.w.setVisibility(0);
                this.H.setVisibility(0);
                this.A.setVisibility(0);
                this.F.b();
                this.E.setVisibility(8);
                this.D.setVisibility(8);
            }
            c.a.p0.h0.e0.l lVar3 = this.G;
            if (lVar3 == null || lVar3.getThreadData() == null || this.G.getThreadData().middle_page_num <= 0) {
                return;
            }
            this.A.setVisibility(8);
        }
    }

    public void M(int i) {
        c.a.p0.h0.e0.l lVar;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (lVar = this.G) == null || (threadData = lVar.a) == null) {
            return;
        }
        if (i == 1) {
            if (threadData.middle_page_num > 0) {
                this.q.f30173b.setShowPraiseNum(false);
                this.q.f30173b.setShareVisible(false);
                this.P.setText(StringHelper.numFormatOverWan(this.G.a.middle_page_num));
                this.P.setVisibility(0);
            } else {
                this.q.f30173b.setShowPraiseNum(true);
                this.q.f30173b.setShareVisible(true);
                this.P.setVisibility(8);
            }
            this.q.g(this.G.a);
            this.j.setVisibility(8);
            this.u.l(false);
            return;
        }
        this.q.setVisibility(8);
        this.u.l(true);
        if (this.G.a.middle_page_num > 0) {
            this.j.setShowPraiseNum(false);
            this.j.setShareVisible(false);
            this.P.setText(StringHelper.numFormatOverWan(this.G.a.middle_page_num));
            this.P.setVisibility(0);
        } else {
            this.j.setShowPraiseNum(true);
            this.j.setShareVisible(true);
            this.P.setVisibility(8);
        }
        if (this.j.setData(this.G.a)) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
        }
    }

    public final void N(c.a.p0.h0.e0.l lVar) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, lVar) == null) || lVar == null || (threadData = lVar.a) == null || threadData.getId() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, threadData.getId()));
    }

    @Override // c.a.p0.v.e
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.p = str;
        }
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? R.layout.obfuscated_res_0x7f0d0199 : invokeV.intValue;
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.y;
            if (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null) {
                return 0;
            }
            return this.y.getControl().getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.y;
            if (tbVideoViewContainer == null) {
                return false;
            }
            return tbVideoViewContainer.getControl().isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048595, this, tbPageContext, i) == null) || this.I == i) {
            return;
        }
        SkinManager.setBackgroundResource(this.s, R.drawable.addresslist_item_bg);
        SkinManager.setImageResource(this.x, R.drawable.obfuscated_res_0x7f08039a);
        SkinManager.setViewTextColor(this.D, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.P, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.E, R.color.common_color_10014);
        SkinManager.setBackgroundColor(this.C, R.color.CAM_X0204);
        TextView textView = this.Q;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.Q, R.drawable.obfuscated_res_0x7f08123d);
        }
        if (this.D != null) {
            this.D.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080a66), (Drawable) null, (Drawable) null);
        }
        this.m.k();
        NEGFeedBackView nEGFeedBackView = this.o;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.q();
        }
        this.u.h();
        this.j.onChangeSkinType();
        this.q.f();
        this.w.setPlaceHolder(3);
        this.v.getHeadView().setPlaceHolder(1);
        this.I = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
            c.a.p0.h0.e0.l lVar = this.G;
            if (lVar != null && (threadData2 = lVar.a) != null && threadData2.middle_page_num > 0) {
                if (h() != null) {
                    h().a(view, this.G);
                }
                this.r.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.r.getPageActivity(), this.G.a.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, m.g(), this.G.getPbInputLocate())));
                return;
            }
            if (view == this.s || view == this.m) {
                A(view);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
            }
            if (view == this.y) {
                c.a.p0.h0.e0.l lVar2 = this.G;
                if (lVar2 != null) {
                    lVar2.f15320f = 5;
                }
                c.a.p0.h0.e0.l lVar3 = this.G;
                boolean z = false;
                if (lVar3 != null && (threadData = lVar3.a) != null && threadData.getThreadVideoInfo() != null && this.G.a.getThreadVideoInfo().is_vertical.intValue() == 1) {
                    z = true;
                }
                if (z) {
                    z(this.y);
                } else if (UtilHelper.isGotoVideoMiddlePage()) {
                    C(this.y);
                } else {
                    A(k());
                }
            }
        }
    }

    public void startPlay() {
        c.a.p0.h0.e0.l lVar;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.K || (lVar = this.G) == null || (threadData = lVar.a) == null || threadData.getThreadVideoInfo() == null || this.y == null) {
            return;
        }
        if (this.i.r()) {
            this.i.E();
            return;
        }
        this.y.getControl().stopPlayback();
        if (t0.b(1, this.M)) {
            L(true, 2);
            if (StringUtils.isNull(this.M)) {
                TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "index").param("tid", this.G.f15321g));
                this.M = this.G.a.getThreadVideoInfo().video_url;
            }
            this.K = true;
            this.y.getControl().setVideoPath(this.M, this.G.f15321g);
            c.a.p0.c3.h hVar = this.N;
            if (hVar != null) {
                hVar.m();
            }
            K();
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            J();
            I();
            L(true, 1);
            TbVideoViewContainer tbVideoViewContainer = this.y;
            if (tbVideoViewContainer != null) {
                tbVideoViewContainer.getControl().stopPlayback();
                c.a.p0.c3.h hVar = this.N;
                if (hVar != null) {
                    hVar.n();
                }
            }
            this.K = false;
            this.i.L();
        }
    }

    public int u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) ? c.a.p0.v.d.c().b(this.p, i) : invokeI.intValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.M : (String) invokeV.objValue;
    }

    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public final void x(Rect rect) {
        c.a.p0.h0.e0.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, rect) == null) || (lVar = this.G) == null || lVar.a == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.buildWithThreadData(this.G.a);
        videoItemData.mRecomExtra = this.G.i();
        videoItemData.mRecomAbTag = this.G.e();
        videoItemData.mRecomSource = this.G.r();
        videoItemData.mRecomWeight = this.G.D();
        arrayList.add(videoItemData);
        c.a.o0.c1.x.d(this.f15304b.getPageActivity(), arrayList, this.G.a.getBaijiahaoData() != null ? this.G.a.getBaijiahaoData().oriUgcNid : null, false, 0, rect, "from_nani_video", "personalize_page", this.G.getPbInputLocate(), "index", "", false, false);
    }

    public final void y() {
        c.a.p0.h0.e0.l lVar;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (lVar = this.G) == null || (threadData = lVar.a) == null || threadData.getId() == null) {
            return;
        }
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.G.a);
        videoSerializeVideoThreadInfo.source = this.G.r();
        videoSerializeVideoThreadInfo.extra = this.G.i();
        videoSerializeVideoThreadInfo.ab_tag = this.G.e();
        videoSerializeVideoThreadInfo.weight = this.G.D();
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (this.n.getX() + w().getX());
        videoCardViewInfo.cardViewY = (int) (k().getY() + this.n.getY() + w().getY());
        videoCardViewInfo.cardViewWidth = w().getWidth();
        videoCardViewInfo.cardViewHeight = w().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.r.getPageActivity(), (c.a.d.f.p.m.isEmpty(this.R) || !this.R.equals("hottopic")) ? "index" : "hottopic", this.G.a.getTid(), m.g(), this.G.getPbInputLocate(), videoSerializeVideoThreadInfo);
        if (this.G.getThreadData() != null && this.G.getThreadData().getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.G.getThreadData().getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
    }

    public final void z(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, view) == null) {
            if (h() != null) {
                h().a(view, this.G);
            }
            if (!c.a.d.f.p.l.z()) {
                c.a.d.f.p.n.M(this.r.getPageActivity(), R.string.obfuscated_res_0x7f0f0c4c);
            } else {
                x(ThreadCardUtils.computeViewArea(this.l));
            }
        }
    }
}
