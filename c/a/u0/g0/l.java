package c.a.u0.g0;

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
import c.a.t0.d1.u0;
import c.a.t0.s.r.e2;
import c.a.t0.s.r.x0;
import c.a.u0.b3.h;
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
/* loaded from: classes8.dex */
public class l extends c.a.u0.g0.b<c.a.u0.g0.d0.l> implements View.OnClickListener, c.a.u0.t.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView A;
    public ImageView B;
    public TbVideoViewContainer C;
    public TextView D;
    public LinearLayout E;
    public TextView F;
    public View G;
    public TextView H;
    public View I;
    public c.a.u0.b3.q J;
    public c.a.u0.g0.d0.l K;
    public View L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public String Q;
    public c.a.u0.b3.h R;
    public Animation S;
    public TextView T;
    public TextView U;
    public String V;
    public Handler W;
    public Runnable X;
    public Runnable Y;
    public final View.OnClickListener Z;
    public final View.OnClickListener a0;
    public c.a.e.m.d m;
    public ThreadCommentAndPraiseInfoLayout n;
    public View o;
    public FrameLayout p;
    public ThreadGodReplyLayout q;
    public LinearLayout r;
    public NEGFeedBackView s;
    public String t;
    public ThreadSourceShareAndPraiseLayout u;
    public TbPageContext<?> v;
    public RelativeLayout w;
    public TextView x;
    public ThreadUserInfoLayout y;
    public HeadPendantClickableView z;

    /* loaded from: classes8.dex */
    public class a extends c.a.t0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, int i2, String str, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = str2;
        }

        @Override // c.a.t0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.t0.m.a.v(TbadkCoreApplication.getInst().getApplicationContext(), false, this.l);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "0"));
            }
        }

        @Override // c.a.t0.f1.n.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f17934e;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17934e = lVar;
        }

        @Override // c.a.u0.b3.h.c
        public void onProgressUpdated(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (i3 >= i2) {
                    this.f17934e.m.I(false, false, "NEWINDEX");
                } else if (i2 == 0 || (i3 * 100) / i2 < 80 || i2 <= 15000) {
                } else {
                    l lVar = this.f17934e;
                    lVar.M(lVar.K);
                }
            }
        }
    }

    public final void A() {
        c.a.u0.g0.d0.l lVar;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            I();
            H();
            if (this.A == null || this.p == null || this.C == null) {
                return;
            }
            if (c.a.t0.s.l.c().g() && (lVar = this.K) != null && (e2Var = lVar.f17886e) != null && e2Var.u1() != null) {
                this.A.setPlaceHolder(3);
                this.A.startLoad(this.K.f17886e.u1().thumbnail_url, 10, false);
                this.p.setVisibility(0);
                stopPlay();
                this.Q = this.K.f17886e.u1().video_url;
                if (C()) {
                    this.Q = this.K.f17886e.v1().video_url;
                }
                if (StringUtils.isNull(this.K.f17886e.u1().video_url)) {
                    K(true, 4);
                }
                this.C.getControl().setThreadDataForStatistic(this.K.f17886e);
            } else {
                this.p.setVisibility(8);
            }
            this.m.B();
            this.R.j(new b(this));
        }
    }

    public final void B(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            if (g() != null) {
                g().a(view, this.K);
            }
            if (!c.a.d.f.p.l.z()) {
                c.a.d.f.p.n.M(this.v.getPageActivity(), R.string.no_network_guide);
            } else {
                x();
            }
        }
    }

    public final boolean C() {
        InterceptResult invokeV;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.u0.g0.d0.l lVar = this.K;
            return (lVar == null || (e2Var = lVar.f17886e) == null || e2Var.v1() == null || TextUtils.isEmpty(this.K.f17886e.v1().video_url)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.u0.g0.d0.l lVar = this.K;
            return lVar.V && !lVar.W;
        }
        return invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.O : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.u0.g0.b
    /* renamed from: F */
    public void k(c.a.u0.g0.d0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lVar) == null) {
            this.K = lVar;
            G();
        }
    }

    public final void G() {
        e2 e2Var;
        e2 e2Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.u0.g0.d0.l lVar = this.K;
            if (lVar != null && (e2Var = lVar.f17886e) != null && e2Var.J() != null) {
                this.w.setVisibility(0);
                A();
                if (!D() && m.k(this.K.f17886e.h0())) {
                    m.l(this.x, this.K.f17886e.h0(), R.color.CAM_X0105, R.color.CAM_X0109);
                    m.l(this.q.getGodReplyContent(), this.K.getThreadData().h0(), R.color.CAM_X0106, R.color.CAM_X0109);
                }
                this.K.getThreadData().h3();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.K.getThreadData().j1());
                if (this.K.getThreadData().i() && !StringUtils.isNull(this.K.getThreadData().w1())) {
                    String str = c.a.t0.s.j0.b.k().q("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.K.getThreadData().w1();
                    spannableStringBuilder.append((CharSequence) this.K.getThreadData().k(new a(this, 2, str, str)));
                }
                this.x.setOnTouchListener(new c.a.u0.q4.h(spannableStringBuilder));
                this.x.setText(spannableStringBuilder);
                this.y.setData(this.K.getThreadData());
                this.y.setUserAfterClickListener(this.Z);
                if (this.y.getHeaderImg() != null) {
                    this.y.getHeaderImg().setAfterClickListener(this.a0);
                    if (this.y.getIsSimpleThread()) {
                        this.y.getHeaderImg().setVisibility(8);
                        this.z.setVisibility(8);
                    } else if (this.K.getThreadData() != null && this.K.getThreadData().J() != null && this.K.getThreadData().J().getPendantData() != null && !StringUtils.isNull(this.K.getThreadData().J().getPendantData().getImgUrl())) {
                        this.y.getHeaderImg().setVisibility(4);
                        this.z.setVisibility(0);
                        this.z.setData(this.K.getThreadData());
                    } else {
                        this.z.setVisibility(8);
                        this.y.getHeaderImg().setVisibility(0);
                        if (this.K.getThreadData().x1 > 0 && this.K.getThreadData().y1 == 0) {
                            this.K.getThreadData().J().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                            this.y.getHeaderImg().setData(this.K.getThreadData(), false);
                        } else {
                            this.y.getHeaderImg().setData(this.K.getThreadData());
                            this.y.getHeaderImg().setOnInterceptClickEventListener(null);
                        }
                    }
                }
                this.D.setText(StringHelper.stringForVideoTime(this.K.f17886e.u1().video_duration.intValue() * 1000));
                this.F.setText(String.format(this.v.getResources().getString(R.string.play_count), StringHelper.numFormatOverWan(this.K.f17886e.u1().play_count.intValue())));
                if (this.s != null && this.K.getThreadData() != null) {
                    x0 x0Var = new x0();
                    x0Var.o(this.K.getThreadData().w1());
                    x0Var.k(this.K.getThreadData().U());
                    x0Var.n(this.K.getThreadData().H0());
                    x0Var.j(this.K.feedBackReasonMap);
                    this.s.setData(x0Var);
                    this.s.setFirstRowSingleColumn(true);
                    this.s.setVisibility(this.P ? 0 : 8);
                }
                this.q.setData(this.K.getThreadData().z1());
                L(t(1));
                l(this.v, TbadkCoreApplication.getInst().getSkinType());
                if (m.k(this.K.f17886e.h0())) {
                    SkinManager.setViewTextColor(this.x, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.x, R.color.CAM_X0105, 1);
                }
                c.a.u0.g0.d0.l lVar2 = this.K;
                if ((lVar2 == null || (e2Var2 = lVar2.f17886e) == null || e2Var2.u1() == null || this.K.f17886e.u1().is_vertical.intValue() != 1) ? false : true) {
                    this.U.setVisibility(0);
                    if (C()) {
                        this.U.setText(String.format("%s | %s", this.v.getResources().getString(R.string.nani_video), this.v.getResources().getString(R.string.video_preview)));
                        return;
                    } else {
                        this.U.setText(this.v.getString(R.string.nani_video));
                        return;
                    }
                } else if (C()) {
                    this.U.setVisibility(0);
                    this.U.setText(this.v.getString(R.string.video_preview));
                    return;
                } else {
                    this.U.setVisibility(8);
                    return;
                }
            }
            this.w.setVisibility(8);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.W.removeMessages(202);
            this.W.removeMessages(203);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.X);
            c.a.d.f.m.e.a().removeCallbacks(this.Y);
        }
    }

    public final void J() {
        c.a.u0.g0.d0.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (lVar = this.K) == null || lVar.f17886e == null) {
            return;
        }
        c.a.u0.b3.t tVar = new c.a.u0.b3.t();
        tVar.a = this.K.X == 0 ? "index" : "hot_juhe";
        tVar.f15610c = this.K.f17886e.w1();
        tVar.f15611d = this.K.f17886e.U() + "";
        tVar.f15612e = TbadkCoreApplication.getCurrentAccount();
        c.a.u0.g0.d0.l lVar2 = this.K;
        e2 e2Var = lVar2.f17886e;
        tVar.f15613f = e2Var.Z0;
        String str = e2Var.b1;
        tVar.l = str;
        tVar.f15614g = str;
        tVar.f15615h = e2Var.a1;
        tVar.f15616i = "";
        tVar.k = lVar2.k();
        if (this.K.f17886e.u1() != null) {
            tVar.m = this.K.f17886e.u1().video_md5;
        }
        c.a.u0.b3.j.e(this.K.f17886e.u1().video_md5, "", "1", tVar, this.C.getControl().getPcdnState());
    }

    public final void K(boolean z, int i2) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.B == null || this.A == null || this.L == null || this.J == null || this.I == null || this.H == null) {
            return;
        }
        if (z || this.N != i2) {
            this.N = i2;
            c.a.d.f.m.e.a().removeCallbacks(this.Y);
            c.a.d.f.m.e.a().removeCallbacks(this.X);
            if (i2 == 2) {
                this.B.setVisibility(8);
                this.S.cancel();
                this.A.clearAnimation();
                this.A.setVisibility(0);
                this.L.setVisibility(0);
                this.E.setVisibility(0);
                this.T.setVisibility(8);
                this.J.g();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
                c.a.d.f.m.e.a().postDelayed(this.Y, 60000L);
            } else if (i2 == 3) {
                this.B.setVisibility(8);
                this.A.startAnimation(this.S);
                this.L.setVisibility(8);
                this.E.setVisibility(8);
                c.a.u0.g0.d0.l lVar = this.K;
                if (lVar != null && lVar.getThreadData() != null && this.K.getThreadData().x1 > 0) {
                    this.T.setVisibility(0);
                }
                this.J.c();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
                c.a.u0.g0.d0.l lVar2 = this.K;
                if (lVar2 != null && (e2Var = lVar2.f17886e) != null && e2Var.u1() != null) {
                    this.K.f17886e.u1().video_length.intValue();
                    this.K.f17886e.u1().video_duration.intValue();
                    this.K.f17886e.w1();
                }
            } else if (i2 == 4) {
                this.B.setVisibility(8);
                this.A.startAnimation(this.S);
                this.L.setVisibility(8);
                this.J.b();
                this.I.setVisibility(0);
                this.H.setVisibility(0);
                c.a.d.f.m.e.a().postDelayed(this.X, 2000L);
            } else {
                this.B.setVisibility(0);
                this.S.cancel();
                this.A.clearAnimation();
                this.A.setVisibility(0);
                this.L.setVisibility(0);
                this.E.setVisibility(0);
                this.J.b();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
            }
            c.a.u0.g0.d0.l lVar3 = this.K;
            if (lVar3 == null || lVar3.getThreadData() == null || this.K.getThreadData().x1 <= 0) {
                return;
            }
            this.E.setVisibility(8);
        }
    }

    public void L(int i2) {
        c.a.u0.g0.d0.l lVar;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (lVar = this.K) == null || (e2Var = lVar.f17886e) == null) {
            return;
        }
        if (i2 == 1) {
            if (e2Var.x1 > 0) {
                this.u.mSharePraiseView.setShowPraiseNum(false);
                this.u.mSharePraiseView.setShareVisible(false);
                this.T.setText(StringHelper.numFormatOverWan(this.K.f17886e.x1));
                this.T.setVisibility(0);
            } else {
                this.u.mSharePraiseView.setShowPraiseNum(true);
                this.u.mSharePraiseView.setShareVisible(true);
                this.T.setVisibility(8);
            }
            this.u.setData(this.K.f17886e);
            this.n.setVisibility(8);
            this.y.showForumNameView(false);
            return;
        }
        this.u.setVisibility(8);
        this.y.showForumNameView(true);
        if (this.K.f17886e.x1 > 0) {
            this.n.setShowPraiseNum(false);
            this.n.setShareVisible(false);
            this.T.setText(StringHelper.numFormatOverWan(this.K.f17886e.x1));
            this.T.setVisibility(0);
        } else {
            this.n.setShowPraiseNum(true);
            this.n.setShareVisible(true);
            this.T.setVisibility(8);
        }
        if (this.n.setData(this.K.f17886e)) {
            this.o.setVisibility(8);
        } else {
            this.o.setVisibility(0);
        }
    }

    public final void M(c.a.u0.g0.d0.l lVar) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, lVar) == null) || lVar == null || (e2Var = lVar.f17886e) == null || e2Var.h0() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, e2Var.h0()));
    }

    @Override // c.a.u0.t.e
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.t = str;
        }
    }

    @Override // c.a.u0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? R.layout.card_home_page_auto_video_view_new : invokeV.intValue;
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.C;
            if (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null) {
                return 0;
            }
            return this.C.getControl().getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.C;
            if (tbVideoViewContainer == null) {
                return false;
            }
            return tbVideoViewContainer.getControl().isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.u0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048594, this, tbPageContext, i2) == null) || this.M == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.w, R.drawable.addresslist_item_bg);
        SkinManager.setImageResource(this.B, R.drawable.btn_icon_play_video_n);
        SkinManager.setViewTextColor(this.H, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.D, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.F, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.T, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.I, R.color.common_color_10014);
        SkinManager.setBackgroundColor(this.G, R.color.CAM_X0204);
        TextView textView = this.U;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.U, R.drawable.video_play_count_bg);
        }
        if (this.H != null) {
            this.H.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
        }
        this.q.onChangeSkinType();
        NEGFeedBackView nEGFeedBackView = this.s;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.onChangeSkinType();
        }
        this.y.onChangeSkinType();
        this.n.onChangeSkinType();
        this.u.onChangeSkinType();
        this.A.setPlaceHolder(3);
        this.z.getHeadView().setPlaceHolder(1);
        this.M = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e2 e2Var;
        e2 e2Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
            c.a.u0.g0.d0.l lVar = this.K;
            if (lVar != null && (e2Var2 = lVar.f17886e) != null && e2Var2.x1 > 0) {
                if (g() != null) {
                    g().a(view, this.K);
                }
                this.v.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.v.getPageActivity(), this.K.f17886e.w1(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, m.g(), this.K.getPbInputLocate())));
                return;
            }
            if (view == this.w || view == this.q) {
                z(view);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
            }
            if (view == this.C) {
                c.a.u0.g0.d0.l lVar2 = this.K;
                if (lVar2 != null) {
                    lVar2.f17891j = 5;
                }
                c.a.u0.g0.d0.l lVar3 = this.K;
                boolean z = false;
                if (lVar3 != null && (e2Var = lVar3.f17886e) != null && e2Var.u1() != null && this.K.f17886e.u1().is_vertical.intValue() == 1) {
                    z = true;
                }
                if (z) {
                    y(this.C);
                } else if (UtilHelper.isGotoVideoMiddlePage()) {
                    B(this.C);
                } else {
                    z(j());
                }
            }
        }
    }

    public void startPlay() {
        c.a.u0.g0.d0.l lVar;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.O || (lVar = this.K) == null || (e2Var = lVar.f17886e) == null || e2Var.u1() == null || this.C == null) {
            return;
        }
        if (this.m.r()) {
            this.m.E();
            return;
        }
        this.C.getControl().stopPlayback();
        if (u0.b(1, this.Q)) {
            K(true, 2);
            if (StringUtils.isNull(this.Q)) {
                TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "index").param("tid", this.K.k));
                this.Q = this.K.f17886e.u1().video_url;
            }
            this.O = true;
            this.C.getControl().setVideoPath(this.Q, this.K.k);
            c.a.u0.b3.h hVar = this.R;
            if (hVar != null) {
                hVar.m();
            }
            J();
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            I();
            H();
            K(true, 1);
            TbVideoViewContainer tbVideoViewContainer = this.C;
            if (tbVideoViewContainer != null) {
                tbVideoViewContainer.getControl().stopPlayback();
                c.a.u0.b3.h hVar = this.R;
                if (hVar != null) {
                    hVar.n();
                }
            }
            this.O = false;
            this.m.L();
        }
    }

    public int t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) ? c.a.u0.t.d.c().b(this.t, i2) : invokeI.intValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.Q : (String) invokeV.objValue;
    }

    public View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.p : (View) invokeV.objValue;
    }

    public final void w(Rect rect) {
        c.a.u0.g0.d0.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, rect) == null) || (lVar = this.K) == null || lVar.f17886e == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.buildWithThreadData(this.K.f17886e);
        videoItemData.mRecomExtra = this.K.k();
        videoItemData.mRecomAbTag = this.K.g();
        videoItemData.mRecomSource = this.K.t();
        videoItemData.mRecomWeight = this.K.D();
        arrayList.add(videoItemData);
        c.a.t0.d1.y.d(this.f17875f.getPageActivity(), arrayList, this.K.f17886e.L() != null ? this.K.f17886e.L().oriUgcNid : null, false, 0, rect, "from_nani_video", "personalize_page", this.K.getPbInputLocate(), "index", "", false, false);
    }

    public final void x() {
        c.a.u0.g0.d0.l lVar;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (lVar = this.K) == null || (e2Var = lVar.f17886e) == null || e2Var.h0() == null) {
            return;
        }
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.K.f17886e);
        videoSerializeVideoThreadInfo.source = this.K.t();
        videoSerializeVideoThreadInfo.extra = this.K.k();
        videoSerializeVideoThreadInfo.ab_tag = this.K.g();
        videoSerializeVideoThreadInfo.weight = this.K.D();
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (this.r.getX() + v().getX());
        videoCardViewInfo.cardViewY = (int) (j().getY() + this.r.getY() + v().getY());
        videoCardViewInfo.cardViewWidth = v().getWidth();
        videoCardViewInfo.cardViewHeight = v().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.v.getPageActivity(), (c.a.d.f.p.m.isEmpty(this.V) || !this.V.equals("hottopic")) ? "index" : "hottopic", this.K.f17886e.w1(), m.g(), this.K.getPbInputLocate(), videoSerializeVideoThreadInfo);
        if (this.K.getThreadData() != null && this.K.getThreadData().L() != null) {
            videoMiddlePageActivityConfig.setNid(this.K.getThreadData().L().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
    }

    public final void y(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, view) == null) {
            if (g() != null) {
                g().a(view, this.K);
            }
            if (!c.a.d.f.p.l.z()) {
                c.a.d.f.p.n.M(this.v.getPageActivity(), R.string.no_network_guide);
            } else {
                w(ThreadCardUtils.computeViewArea(this.p));
            }
        }
    }

    public final void z(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, view) == null) {
            c.a.u0.g0.d0.l lVar = this.K;
            if (lVar != null) {
                lVar.f17891j = 1;
            }
            if (g() != null) {
                g().a(view, this.K);
            }
            c.a.u0.g0.d0.l lVar2 = this.K;
            if (lVar2 == null || lVar2.f17886e == null) {
                return;
            }
            if (!D()) {
                m.a(this.K.f17886e.h0());
                m.l(this.x, this.K.f17886e.h0(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.v.getPageActivity()).createFromThreadCfg(this.K.f17886e, null, m.g(), 18003, true, false, false).addLocateParam(this.K.getPbInputLocate());
            addLocateParam.setVideo_source(this.K.X == 0 ? "index" : "hot_juhe");
            if (this.K.X == 0) {
                addLocateParam.setFrom("from_personalize");
            }
            addLocateParam.setForumId(String.valueOf(this.K.f17886e.U()));
            addLocateParam.setForumName(this.K.f17886e.b0());
            addLocateParam.setStartFrom(this.l);
            if (view == this.q) {
                addLocateParam.setJumpGodReply(true);
            }
            this.v.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }
}
