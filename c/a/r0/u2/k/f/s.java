package c.a.r0.u2.k.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.l.a;
import c.a.q0.r.r.e2;
import c.a.q0.r.r.q2;
import c.a.r0.u2.i.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.switchs.NovelPaySwitch;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFirstFloorViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import tbclient.Item;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class s extends o<PostData, PbFirstFloorViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public TbRichTextView.y B;
    public c.a.r0.u2.i.c C;
    public View.OnLongClickListener D;
    public TbRichTextView.s E;
    public View.OnClickListener F;
    public boolean G;
    public final boolean H;
    public boolean I;
    public Context J;
    public int K;
    public c.a.r0.u2.i.c L;
    public c.a.r0.f0.b0<c.a.q0.r.r.a> M;
    public a.InterfaceC0201a N;
    public int s;
    public boolean t;
    public boolean u;
    public PbModel v;
    public boolean w;
    public c.a.r0.u2.h.f x;
    public c.a.r0.u2.k.h.b y;
    public View.OnClickListener z;

    /* loaded from: classes2.dex */
    public class a implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public a(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // c.a.r0.u2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.u2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.a.C != null) {
                    this.a.C.a(view);
                    this.a.C.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.u2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (c.a.q0.f1.b.c.d()) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, 2));
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends c.a.r0.f0.b0<c.a.q0.r.r.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s f23691b;

        public b(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23691b = sVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.f0.b0
        /* renamed from: d */
        public void a(View view, c.a.q0.r.r.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, aVar) == null) {
                super.a(view, aVar);
                if (aVar == null || aVar.getThreadData() == null || aVar.getThreadData().z1 == null || this.f23691b.x == null) {
                    return;
                }
                OriginalThreadInfo originalThreadInfo = aVar.getThreadData().z1;
                String Q = this.f23691b.x.Q();
                String str = originalThreadInfo.f38793f;
                int i2 = 1;
                int i3 = originalThreadInfo.a;
                if (i3 == 3) {
                    i2 = 2;
                } else if (i3 == 4) {
                    i2 = 3;
                }
                if (StringUtils.isNull(Q) || StringUtils.isNull(str)) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c12602").param("tid", Q).param("obj_source", str).param("obj_type", i2));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements a.InterfaceC0201a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public c(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // c.a.l.a.InterfaceC0201a
        public void a(c.a.q0.r.r.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().z1 == null) {
                return;
            }
            OriginalThreadInfo originalThreadInfo = aVar.getThreadData().z1;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.J);
            pbActivityConfig.createNormalCfg(originalThreadInfo.f38793f, originalThreadInfo.n, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.f38792e));
            pbActivityConfig.setStartFrom(this.a.K);
            pbActivityConfig.setBjhData(originalThreadInfo.p);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    /* loaded from: classes2.dex */
    public class d implements TbRichTextView.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorViewHolder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PostData f23692b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f23693c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f23694d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f23695e;

        public d(s sVar, PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, pbFirstFloorViewHolder, postData, view, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23695e = sVar;
            this.a = pbFirstFloorViewHolder;
            this.f23692b = postData;
            this.f23693c = view;
            this.f23694d = i2;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.v
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.richText.getLayoutParams();
                layoutParams.topMargin = this.f23695e.Z(R.dimen.ds16);
                int Z = this.f23695e.Z(R.dimen.ds34);
                layoutParams.bottomMargin = Z;
                layoutParams.leftMargin = Z;
                layoutParams.rightMargin = Z;
                this.a.richText.setLayoutParams(layoutParams);
                this.f23695e.h0(this.a, this.f23692b, this.f23693c, this.f23694d);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFirstFloorViewHolder f23696e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PostData f23697f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f23698g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f23699h;

        public e(s sVar, PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, pbFirstFloorViewHolder, postData, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23696e = pbFirstFloorViewHolder;
            this.f23697f = postData;
            this.f23698g = str;
            this.f23699h = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23696e.mNovelInfoCardView.onClickStatePayOrRead();
                c.a.q0.m0.f.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_CLICK, String.valueOf(this.f23697f.L().h()), this.f23698g, this.f23699h);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.r0.u2.o.c) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = 0;
        boolean z = true;
        this.t = true;
        this.u = true;
        this.w = false;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = false;
        int i4 = Build.VERSION.SDK_INT;
        this.H = (i4 < 14 || i4 > 16) ? false : false;
        this.I = false;
        this.K = 0;
        this.L = new c.a.r0.u2.i.c(new a(this));
        this.M = new b(this);
        this.N = new c(this);
        if (pbFragment != null && pbFragment.getPbModel() != null) {
            this.K = pbFragment.getPbModel().Q0();
            this.v = pbFragment.getPbModel();
        }
        this.J = pbFragment.getContext();
    }

    public void A0(c.a.r0.u2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.C = cVar;
        }
    }

    public void B0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sVar) == null) {
            this.E = sVar;
        }
    }

    public final void C0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbFirstFloorViewHolder) == null) || pbFirstFloorViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbFirstFloorViewHolder.mSkinType != skinType) {
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.mYoungsterTipTv, R.color.CAM_X0202);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.pbItemViewRoot, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.mBottomDivider, R.color.CAM_X0204);
            pbFirstFloorViewHolder.richText.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbFirstFloorViewHolder.mAppletsCellView.onChangeSkinType();
            pbFirstFloorViewHolder.mNovelInfoCardView.onChangeSkinType();
            ThreadForumEnterButtonContainer threadForumEnterButtonContainer = pbFirstFloorViewHolder.mForumEnterButtonContainer;
            if (threadForumEnterButtonContainer != null) {
                threadForumEnterButtonContainer.onChangeSkinType();
            }
            PbBusinessPromotionContainer pbBusinessPromotionContainer = pbFirstFloorViewHolder.mPbBusinessPromotionContainer;
            if (pbBusinessPromotionContainer != null) {
                pbBusinessPromotionContainer.onChangeSkinType();
            }
            SkinManager.setViewTextColor(pbFirstFloorViewHolder.mVoteTailTv, (int) R.color.CAM_X0107);
            pbFirstFloorViewHolder.mManagerSelectView.i(skinType);
            VoteView voteView = pbFirstFloorViewHolder.mVoteView;
            if (voteView != null) {
                voteView.onChangeSkinType(skinType);
            }
            SkinManager.setBackgroundColorToTransparent(pbFirstFloorViewHolder.mContentReadMoreMaskView, R.color.CAM_X0201, GradientDrawable.Orientation.BOTTOM_TOP);
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(pbFirstFloorViewHolder.mReadMoreButtonText);
            d2.A(R.string.F_X01);
            d2.v(R.color.CAM_X0311);
            SkinManager.setBackgroundShapeDrawable(pbFirstFloorViewHolder.mReadMoreButton, c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50), R.color.CAM_X0328, R.color.CAM_X0207);
            WebPManager.setPureDrawable(pbFirstFloorViewHolder.mReadMoreIcon, R.drawable.icon_pure_btn_read_more, R.color.CAM_X0311, WebPManager.ResourceStateType.NORMAL);
            pbFirstFloorViewHolder.mReadMoreButton.getBackground().setAlpha(90);
        }
        pbFirstFloorViewHolder.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PbFirstFloorViewHolder o0 = o0();
            c.a.r0.u2.h.f fVar = this.x;
            if (fVar == null || fVar.O() == null || o0 == null) {
                return;
            }
            o0.showThreadTypeStampBottomPart(this.x, this.x.O().s0() == 1, this.x.O().t0() == 1);
        }
    }

    @Override // c.a.r0.u2.k.f.o, c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        s0(i2, view, viewGroup, (PostData) obj, (PbFirstFloorViewHolder) viewHolder);
        return view;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.t = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.D = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.A = onClickListener;
        }
    }

    public final void f0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.richText.setTextViewOnTouchListener(this.L);
            pbFirstFloorViewHolder.richText.setTextViewCheckSelection(false);
        }
    }

    public final void g0(TbRichTextView tbRichTextView, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048586, this, tbRichTextView, view, z) == null) || tbRichTextView == null) {
            return;
        }
        int min = Math.min(((((c.a.d.f.p.n.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - (z ? Z(R.dimen.ds80) : 0), this.s);
        tbRichTextView.getLayoutStrategy().q(min);
        tbRichTextView.getLayoutStrategy().p((int) (min * 1.618f));
    }

    /* JADX WARN: Removed duplicated region for block: B:168:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x04ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String str;
        String str2;
        long j2;
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048587, this, pbFirstFloorViewHolder, postData, view, i2) == null) || this.x == null) {
            return;
        }
        TbRichText tbRichText = null;
        if (postData.A() != 1) {
            if (TextUtils.isEmpty(postData.u())) {
                pbFirstFloorViewHolder.richText.setOnClickListener(this.A);
                pbFirstFloorViewHolder.richText.setTextViewOnClickListener(this.A);
            } else {
                pbFirstFloorViewHolder.richText.setOnClickListener(null);
                pbFirstFloorViewHolder.richText.setTextViewOnClickListener(null);
            }
            pbFirstFloorViewHolder.pbItemViewRoot.setOnClickListener(this.A);
        } else {
            pbFirstFloorViewHolder.pbItemViewRoot.setOnClickListener(null);
        }
        if (postData.A() == 1) {
            pbFirstFloorViewHolder.showForumEnterButton(this.x, this.n.isSimpleForum(), postData.S);
            g0(pbFirstFloorViewHolder.richText, view, this.I);
            if (postData.t() != null) {
                long userIdLong = postData.t().getUserIdLong();
                str = postData.t().getUserName();
                j2 = userIdLong;
                str2 = postData.t().getName_show();
            } else {
                str = null;
                str2 = null;
                j2 = 0;
            }
            c.a.r0.u2.h.f fVar = this.x;
            if (fVar != null && fVar.O() != null) {
                pbFirstFloorViewHolder.mViewStubController.b(postData.F(), str, str2, j2, c.a.d.f.m.b.g(this.x.O().h0(), 0L), c.a.d.f.m.b.g(postData.G(), 0L));
            }
            if (this.n.getPbView().H1()) {
                pbFirstFloorViewHolder.richText.setVisibility(8);
            }
            c.a.r0.u2.h.f fVar2 = this.x;
            if (fVar2 != null && fVar2.O() != null && this.x.O().J1() != null) {
                q2 J1 = this.x.O().J1();
                String a2 = J1.a();
                if (StringUtils.isNull(J1.b())) {
                    return;
                }
                if (!StringUtils.isNull(a2)) {
                    pbFirstFloorViewHolder.mGameBanner.setVisibility(0);
                    pbFirstFloorViewHolder.mGameBanner.startLoad(a2, 10, true);
                }
            } else {
                pbFirstFloorViewHolder.mGameBanner.setVisibility(8);
            }
            ThreadSkinView threadSkinView = pbFirstFloorViewHolder.mPbItemSkinView;
            if (threadSkinView != null) {
                threadSkinView.setVisibility(8);
            }
            c.a.r0.u2.h.f fVar3 = this.x;
            if (fVar3 != null && fVar3.O() != null && this.x.O().I2() && (threadForumEnterButtonContainer = pbFirstFloorViewHolder.mForumEnterButtonContainer) != null) {
                threadForumEnterButtonContainer.setPadding(threadForumEnterButtonContainer.getPaddingLeft(), c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.mForumEnterButtonContainer.getPaddingRight(), pbFirstFloorViewHolder.mForumEnterButtonContainer.getPaddingBottom());
            }
        }
        pbFirstFloorViewHolder.richText.getLayoutStrategy().x(R.drawable.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_load_sub_data, postData);
        sparseArray.put(R.id.tag_load_sub_view, view);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.A()));
        boolean z6 = postData.b0() || postData.a0(false);
        if (z6) {
            if (this.y == null) {
                c.a.r0.u2.k.h.b bVar = new c.a.r0.u2.k.h.b(this.J);
                this.y = bVar;
                bVar.f(this.q);
                this.y.h(this.z);
                c.a.r0.u2.h.f fVar4 = this.x;
                if (fVar4 != null) {
                    this.y.j(this.x.V(), TextUtils.equals(fVar4.O().J().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.y.i(this.x.O());
                }
            }
            this.y.g(postData.G());
        }
        pbFirstFloorViewHolder.richText.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.t) {
            pbFirstFloorViewHolder.richText.getLayoutStrategy().g(R.drawable.transparent_bg);
        } else {
            pbFirstFloorViewHolder.richText.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbFirstFloorViewHolder.richText.setIsFromCDN(this.q);
        c.a.r0.u2.h.f fVar5 = this.x;
        if (fVar5 != null && fVar5.O() != null && this.x.O().i2()) {
            j0(pbFirstFloorViewHolder, this.x.O().D0());
        }
        c.a.r0.u2.h.f fVar6 = this.x;
        if ((fVar6 == null || fVar6.O() == null || !this.x.O().A1 || postData.M() == null) ? false : true) {
            if (postData.M().C != null) {
                pbFirstFloorViewHolder.richText.getLayoutStrategy().m(m0(R.dimen.tbds24));
            } else {
                pbFirstFloorViewHolder.richText.getLayoutStrategy().m(m0(R.dimen.tbds14));
            }
            k0(pbFirstFloorViewHolder, postData);
        } else {
            pbFirstFloorViewHolder.richText.getLayoutStrategy().m(m0(R.dimen.tbds24));
        }
        TbRichText N = postData.N();
        c.a.r0.u2.h.f fVar7 = this.x;
        if (fVar7 == null || !fVar7.r0()) {
            tbRichText = N;
        }
        if (this.x.O() != null) {
            pbFirstFloorViewHolder.richText.setTid(this.x.Q());
            pbFirstFloorViewHolder.richText.setIsUseGridImage(this.x.O().R1());
            pbFirstFloorViewHolder.richText.setmIsGridImageSupportLongPress(true);
        }
        c.a.r0.u2.h.f fVar8 = this.x;
        if (fVar8 != null && 3 == fVar8.g()) {
            if (!this.G && this.H) {
                pbFirstFloorViewHolder.richText.setText(tbRichText, true, this.E, true, false);
            } else {
                pbFirstFloorViewHolder.richText.setText(tbRichText, false, this.E, true, false);
            }
        } else if (!this.G && this.H) {
            pbFirstFloorViewHolder.richText.setText(tbRichText, true, this.E, false, true);
        } else {
            pbFirstFloorViewHolder.richText.setText(tbRichText, false, this.E, false, true);
        }
        l0(pbFirstFloorViewHolder, postData, tbRichText);
        boolean z7 = !StringUtils.isNull(postData.t().getVirtualUserUrl());
        c.a.r0.u2.h.f fVar9 = this.x;
        if (fVar9 == null || fVar9.V() == 0 || p0()) {
            z = false;
            z2 = false;
        } else {
            if (this.x.V() != 3) {
                z = true;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            if (postData.t() != null) {
                String userId = postData.t().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        c.a.r0.u2.h.f fVar10 = this.x;
        if (fVar10 != null && fVar10.O() != null && this.x.O().J() != null && postData.t() != null) {
            String userId2 = this.x.O().J().getUserId();
            String userId3 = postData.t().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z2 = true;
                    z3 = false;
                    z4 = true;
                } else {
                    z2 = true;
                    z3 = true;
                    z4 = false;
                }
                z5 = true;
                if (postData.t() != null && UtilHelper.isCurrentAccount(postData.t().getUserId())) {
                    z2 = true;
                    z4 = true;
                }
                if (z7) {
                    z = false;
                    z2 = false;
                    z3 = false;
                }
                int i3 = postData.A() == 1 ? 0 : 1;
                sparseArray.put(R.id.tag_forbid_user_post_id, postData.G());
                if (!z) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    if (postData.t() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                    }
                    c.a.r0.u2.h.f fVar11 = this.x;
                    if (fVar11 != null) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar11.V()));
                    }
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.t() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.t().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.t().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.t().getName_show());
                    }
                    c.a.r0.u2.h.f fVar12 = this.x;
                    if (fVar12 != null && fVar12.O() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.x.O().h0());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, postData.G());
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z2) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(z6));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                    sparseArray.put(R.id.tag_del_post_id, postData.G());
                    c.a.r0.u2.h.f fVar13 = this.x;
                    if (fVar13 != null) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar13.V()));
                    }
                } else {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z5));
                f0(pbFirstFloorViewHolder);
            }
        }
        z3 = false;
        z4 = false;
        z5 = false;
        if (postData.t() != null) {
            z2 = true;
            z4 = true;
        }
        if (z7) {
        }
        if (postData.A() == 1) {
        }
        sparseArray.put(R.id.tag_forbid_user_post_id, postData.G());
        if (!z) {
        }
        if (!z3) {
        }
        if (!z2) {
        }
        sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z5));
        f0(pbFirstFloorViewHolder);
    }

    public final void i0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i2) {
        c.a.r0.u2.h.m mVar;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048588, this, pbFirstFloorViewHolder, postData, view, i2) == null) || pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        pbFirstFloorViewHolder.richText.setTag(sparseArray);
        pbFirstFloorViewHolder.pbItemViewRoot.setTag(R.id.tag_from, sparseArray);
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
        pbFirstFloorViewHolder.richText.setIsHost(true);
        if (this.u) {
            pbFirstFloorViewHolder.mBottomDivider.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.mBottomDivider.setVisibility(8);
        }
        if (!TextUtils.isEmpty(postData.u()) && this.t) {
            this.I = true;
            pbFirstFloorViewHolder.richText.startLoad(postData.u(), new d(this, pbFirstFloorViewHolder, postData, view, i2));
        } else {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.richText.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            pbFirstFloorViewHolder.richText.setLayoutParams(layoutParams);
            pbFirstFloorViewHolder.richText.startLoad(null);
            this.I = false;
            h0(pbFirstFloorViewHolder, postData, view, i2);
        }
        c.a.r0.u2.h.f fVar = this.x;
        if (fVar != null && fVar.O() != null && this.x.O().I2() && this.x.O().u1() != null && c.a.d.f.p.m.isEmpty(this.x.l().getName())) {
            pbFirstFloorViewHolder.showBlankViewAboveRichText(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
        } else if (postData.N() != null && !ListUtils.isEmpty(postData.N().y())) {
            pbFirstFloorViewHolder.showBlankViewAboveRichText(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
        } else {
            pbFirstFloorViewHolder.showBlankViewAboveRichText(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
        }
        if (postData.N() != null) {
            if (postData.N().z() > 0) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.mAppletsCellView.getLayoutParams();
                layoutParams2.topMargin = Z(R.dimen.tbds26);
                pbFirstFloorViewHolder.mAppletsCellView.setLayoutParams(layoutParams2);
            } else {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.mAppletsCellView.getLayoutParams();
                layoutParams3.topMargin = Z(R.dimen.tbds16);
                pbFirstFloorViewHolder.mAppletsCellView.setLayoutParams(layoutParams3);
            }
        }
        c.a.r0.u2.h.f fVar2 = this.x;
        if (fVar2 != null && q0(fVar2.O())) {
            pbFirstFloorViewHolder.mVoteView.setDataForPb(this.x.O().K0(), this.x.O().w1(), this.x.m());
            if (postData.N() != null && !ListUtils.isEmpty(postData.N().y())) {
                pbFirstFloorViewHolder.mVoteView.setMarginTop(c.a.d.f.p.n.f(this.J, R.dimen.tbds26));
            } else {
                pbFirstFloorViewHolder.mVoteView.setMarginTop(c.a.d.f.p.n.f(this.J, R.dimen.tbds0));
            }
            pbFirstFloorViewHolder.mVoteView.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.mVoteView.setVisibility(8);
        }
        c.a.r0.u2.h.f fVar3 = this.x;
        if (fVar3 != null && fVar3.O() != null && this.x.O().h1() != null && this.x.O().u1() == null) {
            pbFirstFloorViewHolder.mAppletsCellView.setData(this.x.O().h1());
            pbFirstFloorViewHolder.mAppletsCellView.setVisibility(0);
            c.a.r0.u2.h.f fVar4 = this.x;
            if (fVar4 != null && fVar4.l() != null) {
                pbFirstFloorViewHolder.mAppletsCellView.setForumId(String.valueOf(this.x.l().getId()));
            }
            c.a.r0.u2.h.f fVar5 = this.x;
            if (fVar5 != null && fVar5.Q() != null) {
                pbFirstFloorViewHolder.mAppletsCellView.setThreadId(this.x.Q());
            }
            pbFirstFloorViewHolder.mAppletsCellView.setFrom(AppletsCellView.PB_SHARE_CARD_LITE_PROGRAM_FROM);
        } else {
            pbFirstFloorViewHolder.mAppletsCellView.setVisibility(8);
        }
        if (NovelPaySwitch.isOn() && postData.L() != null && !postData.L().k() && this.x.j0()) {
            String Q = this.x.Q();
            String m = this.x.m();
            pbFirstFloorViewHolder.mNovelInfoCardView.setData(postData.L(), Q, m);
            pbFirstFloorViewHolder.mContentReadMoreMaskView.setVisibility(0);
            pbFirstFloorViewHolder.mNovelInfoCardView.setReadMoreButtonState(pbFirstFloorViewHolder.mReadMoreButton);
            pbFirstFloorViewHolder.mNovelInfoCardView.setVisibility(0);
            this.w = true;
            if (postData.L().i()) {
                pbFirstFloorViewHolder.mReadMoreButton.setVisibility(8);
            } else {
                pbFirstFloorViewHolder.mReadMoreButton.setVisibility(0);
                pbFirstFloorViewHolder.mReadMoreButtonText.setText(String.format(Locale.CHINA, this.J.getString(R.string.novel_read_more_btn_text), Long.valueOf(postData.L().j()), String.valueOf(c.a.d.f.m.b.c(postData.L().d(), 0.0d) / 100.0d)));
            }
            pbFirstFloorViewHolder.mReadMoreButton.setOnClickListener(new e(this, pbFirstFloorViewHolder, postData, Q, m));
        } else {
            pbFirstFloorViewHolder.mContentReadMoreMaskView.setVisibility(8);
            pbFirstFloorViewHolder.mReadMoreButton.setVisibility(8);
            pbFirstFloorViewHolder.mNovelInfoCardView.setVisibility(8);
        }
        D0();
        c.a.r0.u2.h.f fVar6 = this.x;
        if (fVar6 != null && (mVar = fVar6.f23098h) != null) {
            if (pbFirstFloorViewHolder.mVoteTailTv != null) {
                if (TextUtils.isEmpty(mVar.e())) {
                    pbFirstFloorViewHolder.mVoteTailTv.setVisibility(8);
                } else {
                    pbFirstFloorViewHolder.mVoteTailTv.setVisibility(0);
                    pbFirstFloorViewHolder.mVoteTailTv.setText(this.x.f23098h.e());
                }
            }
            if (pbFirstFloorViewHolder.mPbListContent != null && pbFirstFloorViewHolder.mManagerSelectView.h() == null) {
                pbFirstFloorViewHolder.mPbListContent.addView(pbFirstFloorViewHolder.mManagerSelectView.a(this.x));
                String fromPageKey = UtilHelper.getFromPageKey(this.n.getPageContext());
                Context context = this.J;
                if (!(context instanceof AbsPbActivity) || ((AbsPbActivity) context).getIntent() == null) {
                    z = false;
                } else {
                    z = ((AbsPbActivity) this.J).getIntent().getBooleanExtra("is_from_bar_vote", false);
                    if (z) {
                        new StatisticItem(TbadkCoreStatisticKey.KEY_PB_VOTE_SOURCE).param("obj_source", 1).eventStat();
                    }
                }
                if (fromPageKey != null && !z) {
                    if (fromPageKey.equals("a002")) {
                        new StatisticItem(TbadkCoreStatisticKey.KEY_PB_VOTE_SOURCE).param("obj_source", 3).eventStat();
                    } else if (fromPageKey.equals("a006")) {
                        new StatisticItem(TbadkCoreStatisticKey.KEY_PB_VOTE_SOURCE).param("obj_source", 2).eventStat();
                    } else if (fromPageKey.equals("a026")) {
                        new StatisticItem(TbadkCoreStatisticKey.KEY_PB_VOTE_SOURCE).param("obj_source", 4).eventStat();
                    }
                }
            }
        }
        LinearLayout linearLayout = pbFirstFloorViewHolder.mLinkContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        c.a.r0.u2.h.f fVar7 = this.x;
        if (fVar7 != null && fVar7.O() != null && !q0(this.x.O()) && (!ListUtils.isEmpty(this.x.O().C0()) || !ListUtils.isEmpty(this.x.O().e0()))) {
            c.a.q0.c1.q0 q0Var = new c.a.q0.c1.q0();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.J);
            c.a.r0.u2.h.f fVar8 = this.x;
            pbLinkGoodsRootView.bindData(fVar8, q0Var.a(fVar8.O().C0(), this.x.O().e0()), this.x.n(), this.n, q0Var.b());
            pbFirstFloorViewHolder.mLinkContainer.addView(pbLinkGoodsRootView);
            pbFirstFloorViewHolder.mLinkContainer.setVisibility(0);
            return;
        }
        pbFirstFloorViewHolder.mLinkContainer.setVisibility(8);
    }

    public final void j0(PbFirstFloorViewHolder pbFirstFloorViewHolder, c.a.q0.r.r.r0 r0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, pbFirstFloorViewHolder, r0Var) == null) || r0Var == null || c.a.d.f.p.m.isEmpty(r0Var.e()) || r0Var.c() != c.a.q0.r.r.r0.f13362g) {
            return;
        }
        if (!r0Var.f()) {
            pbFirstFloorViewHolder.richText.getLayoutStrategy().m(c.a.d.f.p.n.f(this.J, R.dimen.ds48));
        }
        pbFirstFloorViewHolder.mViewStubController.c(r0Var);
    }

    public final void k0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, pbFirstFloorViewHolder, postData) == null) || pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        pbFirstFloorViewHolder.mOrignalThreadRootView.setVisibility(0);
        if (pbFirstFloorViewHolder.mOriginalThreadView == null) {
            pbFirstFloorViewHolder.mOriginalThreadView = n0(postData);
        }
        if (pbFirstFloorViewHolder.mOrignalThreadRootView.getChildCount() <= 0 && (a2 = pbFirstFloorViewHolder.mOriginalThreadView.a()) != null) {
            pbFirstFloorViewHolder.mOrignalThreadRootView.addView(a2);
        }
        pbFirstFloorViewHolder.mOriginalThreadView.e(this.M);
        pbFirstFloorViewHolder.mOriginalThreadView.d(this.N);
        pbFirstFloorViewHolder.mOriginalThreadView.c(postData.M());
        pbFirstFloorViewHolder.mOriginalThreadView.b(this.n.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void l0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, pbFirstFloorViewHolder, postData, tbRichText) == null) {
            if (postData != null && postData.S() != null) {
                c.a.r0.u2.p.h.c(postData.S(), pbFirstFloorViewHolder.mTailContent, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.u()));
            } else {
                pbFirstFloorViewHolder.mTailContent.setVisibility(8);
            }
        }
    }

    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            this.z = onClickListener;
        }
    }

    public final int m0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), i2) : invokeI.intValue;
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.s = i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c.a.r0.u2.k.f.f1.a n0(PostData postData) {
        InterceptResult invokeL;
        c.a.r0.u2.k.f.f1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048595, this, postData)) != null) {
            return (c.a.r0.u2.k.f.f1.a) invokeL.objValue;
        }
        if (postData != null && postData.M() != null && postData.M().i()) {
            BaijiahaoData baijiahaoData = postData.M().p;
            Item item = postData.M().C;
            if (!postData.M().m && !postData.F0()) {
                if (item != null && item.item_id.longValue() != 0) {
                    if (postData.M().a != 0 && postData.M().a != 1) {
                        if (postData.M().a == 3) {
                            aVar = new c.a.r0.u2.k.f.f1.g(this.n.getPageContext());
                        } else {
                            aVar = new c.a.r0.u2.k.f.f1.e(this.n.getPageContext());
                        }
                    } else {
                        aVar = new c.a.r0.u2.k.f.f1.f(this.n.getPageContext());
                    }
                } else if (baijiahaoData != null && postData.M().j()) {
                    int i2 = baijiahaoData.oriUgcType;
                    if (i2 == 1) {
                        aVar = new c.a.r0.u2.k.f.f1.b(this.n.getPageContext(), this.K);
                    } else if (i2 == 2) {
                        aVar = new c.a.r0.u2.k.f.f1.i(this.n.getPageContext(), this.K);
                    } else if (i2 == 3) {
                        aVar = new c.a.r0.u2.k.f.f1.h(this.n.getPageContext(), this.K);
                    } else if (i2 != 4) {
                        aVar = new c.a.r0.u2.k.f.f1.c(this.n.getPageContext(), this.K);
                    } else {
                        aVar = new c.a.r0.u2.k.f.f1.i(this.n.getPageContext(), this.K);
                    }
                } else if (postData.M().a != 0 && postData.M().a != 1) {
                    if (postData.M().a == 3) {
                        aVar = new c.a.r0.u2.k.f.f1.i(this.n.getPageContext(), this.K);
                    }
                } else {
                    aVar = new c.a.r0.u2.k.f.f1.h(this.n.getPageContext(), this.K);
                }
            } else {
                aVar = new c.a.r0.u2.k.f.f1.d(this.n.getPageContext(), this.K);
            }
            return aVar != null ? new c.a.r0.u2.k.f.f1.c(this.n.getPageContext(), this.K) : aVar;
        }
        aVar = null;
        if (aVar != null) {
        }
    }

    public PbFirstFloorViewHolder o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (PbFirstFloorViewHolder) this.k : (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public void p(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, yVar) == null) {
            this.B = yVar;
        }
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            c.a.r0.u2.h.f fVar = this.x;
            if (fVar == null || fVar.O() == null) {
                return false;
            }
            return this.x.O().W1();
        }
        return invokeV.booleanValue;
    }

    public final boolean q0(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, e2Var)) == null) ? (e2Var == null || e2Var.K0() == null || e2Var.K0().getOptions() == null || e2Var.K0().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: r0 */
    public PbFirstFloorViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, viewGroup)) == null) {
            PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.n.getPageContext(), LayoutInflater.from(this.J).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.t, this.s);
            C0(pbFirstFloorViewHolder);
            pbFirstFloorViewHolder.mViewStubController.f(this.K);
            return pbFirstFloorViewHolder;
        }
        return (PbFirstFloorViewHolder) invokeL.objValue;
    }

    public View s0(int i2, View view, ViewGroup viewGroup, PostData postData, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        InterceptResult invokeCommon;
        BdTypeListView listView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, pbFirstFloorViewHolder})) == null) {
            super.S(i2, view, viewGroup, postData, pbFirstFloorViewHolder);
            C0(pbFirstFloorViewHolder);
            x0(pbFirstFloorViewHolder);
            PostData postData2 = (PostData) z(i2);
            if (postData2 != null) {
                postData2.I0();
                postData2.f0 = i2 + 1;
                c.a.r0.u2.m.a.d(this.n.getUniqueId(), this.x, postData2, postData2.f0, 1);
                i0(pbFirstFloorViewHolder, postData2, view, i2);
            }
            if (!this.G && this.H && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.richText.hasLongText() && (listView = this.n.getListView()) != null) {
                this.G = true;
                CompatibleUtile.getInstance().closeViewGpu(listView);
            }
            pbFirstFloorViewHolder.mYoungsterTipTv.setVisibility(c.a.q0.f1.b.c.d() ? 0 : 8);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void t(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, fVar) == null) {
            this.x = fVar;
        }
    }

    public void t0(boolean z) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048603, this, z) == null) && (pbModel = this.v) != null && z && this.w) {
            pbModel.f2(3);
        }
    }

    public void u0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (v = this.k) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).mViewStubController.d();
    }

    public void v0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (v = this.k) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).mViewStubController.a();
        ((PbFirstFloorViewHolder) this.k).mPbBusinessPromotionContainer.destroy();
        ((PbFirstFloorViewHolder) this.k).mNovelInfoCardView.onDestroy();
    }

    public void w0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (v = this.k) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).mViewStubController.e();
        ((PbFirstFloorViewHolder) this.k).mNovelInfoCardView.onResume();
    }

    public final void x0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.pbItemViewRoot.setOnTouchListener(this.C);
            pbFirstFloorViewHolder.pbItemViewRoot.setOnLongClickListener(this.D);
            c.a.r0.u2.k.f.e1.a aVar = this.m.getPbActivity().mEvent;
            pbFirstFloorViewHolder.richText.setOnLongClickListener(this.D);
            pbFirstFloorViewHolder.richText.setOnTouchListener(this.L);
            pbFirstFloorViewHolder.richText.setItemOrderOrDownloadListener(this.F);
            pbFirstFloorViewHolder.richText.setIsShowOrderOrDownloadBtn(true);
            pbFirstFloorViewHolder.richText.setCommonTextViewOnClickListener(this.A);
            pbFirstFloorViewHolder.richText.setOnImageClickListener(this.B);
            pbFirstFloorViewHolder.richText.setOnImageTouchListener(this.L);
            pbFirstFloorViewHolder.richText.setmGridEmptyClickListener(new f(this));
            pbFirstFloorViewHolder.richText.setOnEmotionClickListener(aVar.f23483e);
            pbFirstFloorViewHolder.mTailContent.setOnClickListener(this.A);
            pbFirstFloorViewHolder.mForumEnterButtonContainer.setAfterItemClickListener(this.A);
            pbFirstFloorViewHolder.mPbBusinessPromotionContainer.setAfterItemClickListener(this.A);
        }
    }

    public void y0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onClickListener) == null) {
            this.F = onClickListener;
        }
    }

    public void z0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.u = z;
        }
    }
}
