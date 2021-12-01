package c.a.r0.q2.u.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.k.a;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.q2;
import c.a.r0.q2.s.c;
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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFirstFloorViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Item;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class r extends n<PostData, PbFirstFloorViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.q2.s.c A;
    public View.OnLongClickListener B;
    public TbRichTextView.s C;
    public View.OnClickListener D;
    public boolean E;
    public final boolean F;
    public boolean G;
    public Context H;
    public int I;
    public c.a.r0.q2.s.c J;
    public c.a.r0.g0.d0<c.a.q0.s.q.a> K;
    public a.InterfaceC0129a L;
    public int s;
    public boolean t;
    public boolean u;
    public c.a.r0.q2.r.f v;
    public c.a.r0.q2.u.h.b w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public TbRichTextView.y z;

    /* loaded from: classes6.dex */
    public class a implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public a(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // c.a.r0.q2.s.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.q2.s.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.a.A != null) {
                    this.a.A.a(view);
                    this.a.A.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.q2.s.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (c.a.q0.g1.b.c.d()) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, 2));
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c.a.r0.g0.d0<c.a.q0.s.q.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ r f22117b;

        public b(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22117b = rVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.g0.d0
        /* renamed from: d */
        public void a(View view, c.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, aVar) == null) {
                super.a(view, aVar);
                if (aVar == null || aVar.getThreadData() == null || aVar.getThreadData().A1 == null || this.f22117b.v == null) {
                    return;
                }
                OriginalThreadInfo originalThreadInfo = aVar.getThreadData().A1;
                String Q = this.f22117b.v.Q();
                String str = originalThreadInfo.f40904f;
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

    /* loaded from: classes6.dex */
    public class c implements a.InterfaceC0129a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public c(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // c.a.k.a.InterfaceC0129a
        public void a(c.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().A1 == null) {
                return;
            }
            OriginalThreadInfo originalThreadInfo = aVar.getThreadData().A1;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.H);
            pbActivityConfig.createNormalCfg(originalThreadInfo.f40904f, originalThreadInfo.n, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.f40903e));
            pbActivityConfig.setStartFrom(this.a.I);
            pbActivityConfig.setBjhData(originalThreadInfo.p);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    /* loaded from: classes6.dex */
    public class d implements TbRichTextView.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorViewHolder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PostData f22118b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f22119c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f22120d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f22121e;

        public d(r rVar, PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, pbFirstFloorViewHolder, postData, view, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22121e = rVar;
            this.a = pbFirstFloorViewHolder;
            this.f22118b = postData;
            this.f22119c = view;
            this.f22120d = i2;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.v
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.richText.getLayoutParams();
                layoutParams.topMargin = this.f22121e.g0(c.a.r0.q2.g.ds16);
                int g0 = this.f22121e.g0(c.a.r0.q2.g.ds34);
                layoutParams.bottomMargin = g0;
                layoutParams.leftMargin = g0;
                layoutParams.rightMargin = g0;
                this.a.richText.setLayoutParams(layoutParams);
                this.f22121e.o0(this.a, this.f22118b, this.f22119c, this.f22120d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
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
    public r(PbFragment pbFragment, BdUniqueId bdUniqueId) {
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
                super((c.a.r0.q2.y.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = 0;
        boolean z = true;
        this.t = true;
        this.u = true;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = false;
        int i4 = Build.VERSION.SDK_INT;
        this.F = (i4 < 14 || i4 > 16) ? false : false;
        this.G = false;
        this.I = 0;
        this.J = new c.a.r0.q2.s.c(new a(this));
        this.K = new b(this);
        this.L = new c(this);
        if (pbFragment != null && pbFragment.getPbModel() != null) {
            this.I = pbFragment.getPbModel().Q0();
        }
        this.H = pbFragment.getContext();
    }

    public void A0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (v = this.f2913k) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).mViewStubController.d();
    }

    public void B0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (v = this.f2913k) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).mViewStubController.a();
        ((PbFirstFloorViewHolder) this.f2913k).mPbBusinessPromotionContainer.destroy();
    }

    public void C0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (v = this.f2913k) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).mViewStubController.e();
    }

    public final void D0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.pbItemViewRoot.setOnTouchListener(this.A);
            pbFirstFloorViewHolder.pbItemViewRoot.setOnLongClickListener(this.B);
            c.a.r0.q2.u.f.d1.a aVar = this.m.getPbActivity().mEvent;
            pbFirstFloorViewHolder.richText.setOnLongClickListener(this.B);
            pbFirstFloorViewHolder.richText.setOnTouchListener(this.J);
            pbFirstFloorViewHolder.richText.setItemOrderOrDownloadListener(this.D);
            pbFirstFloorViewHolder.richText.setIsShowOrderOrDownloadBtn(true);
            pbFirstFloorViewHolder.richText.setCommonTextViewOnClickListener(this.y);
            pbFirstFloorViewHolder.richText.setOnImageClickListener(this.z);
            pbFirstFloorViewHolder.richText.setOnImageTouchListener(this.J);
            pbFirstFloorViewHolder.richText.setmGridEmptyClickListener(new e(this));
            pbFirstFloorViewHolder.richText.setOnEmotionClickListener(aVar.f21899e);
            pbFirstFloorViewHolder.mTailContent.setOnClickListener(this.y);
            pbFirstFloorViewHolder.mForumEnterButtonContainer.setAfterItemClickListener(this.y);
            pbFirstFloorViewHolder.mPbBusinessPromotionContainer.setAfterItemClickListener(this.y);
        }
    }

    public void E0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.D = onClickListener;
        }
    }

    public void F0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.u = z;
        }
    }

    public void G0(c.a.r0.q2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.A = cVar;
        }
    }

    public void H0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sVar) == null) {
            this.C = sVar;
        }
    }

    public final void I0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbFirstFloorViewHolder) == null) || pbFirstFloorViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbFirstFloorViewHolder.mSkinType != skinType) {
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.mYoungsterTipTv, c.a.r0.q2.f.CAM_X0202);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.pbItemViewRoot, c.a.r0.q2.f.CAM_X0205);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.mBottomDivider, c.a.r0.q2.f.CAM_X0204);
            pbFirstFloorViewHolder.richText.setTextColor(SkinManager.getColor(c.a.r0.q2.f.CAM_X0105));
            pbFirstFloorViewHolder.mAppletsCellView.onChangeSkinType();
            ThreadForumEnterButtonContainer threadForumEnterButtonContainer = pbFirstFloorViewHolder.mForumEnterButtonContainer;
            if (threadForumEnterButtonContainer != null) {
                threadForumEnterButtonContainer.onChangeSkinType();
            }
            PbBusinessPromotionContainer pbBusinessPromotionContainer = pbFirstFloorViewHolder.mPbBusinessPromotionContainer;
            if (pbBusinessPromotionContainer != null) {
                pbBusinessPromotionContainer.onChangeSkinType();
            }
            SkinManager.setViewTextColor(pbFirstFloorViewHolder.mVoteTailTv, c.a.r0.q2.f.CAM_X0107);
            pbFirstFloorViewHolder.mManagerSelectView.i(skinType);
            VoteView voteView = pbFirstFloorViewHolder.mVoteView;
            if (voteView != null) {
                voteView.onChangeSkinType(skinType);
            }
        }
        pbFirstFloorViewHolder.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            PbFirstFloorViewHolder v0 = v0();
            c.a.r0.q2.r.f fVar = this.v;
            if (fVar == null || fVar.O() == null || v0 == null) {
                return;
            }
            v0.showThreadTypeStampBottomPart(this.v, this.v.O().r0() == 1, this.v.O().s0() == 1);
        }
    }

    @Override // c.a.r0.q2.u.f.n, c.a.d.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        z0(i2, view, viewGroup, (PostData) obj, (PbFirstFloorViewHolder) viewHolder);
        return view;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.t = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onLongClickListener) == null) {
            this.B = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.y = onClickListener;
        }
    }

    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public final void m0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.richText.setTextViewOnTouchListener(this.J);
            pbFirstFloorViewHolder.richText.setTextViewCheckSelection(false);
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.s = i2;
        }
    }

    public final void n0(TbRichTextView tbRichTextView, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048594, this, tbRichTextView, view, z) == null) || tbRichTextView == null) {
            return;
        }
        int min = Math.min(((((c.a.d.f.p.l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - (z ? g0(c.a.r0.q2.g.ds80) : 0), this.s);
        tbRichTextView.getLayoutStrategy().q(min);
        tbRichTextView.getLayoutStrategy().p((int) (min * 1.618f));
    }

    /* JADX WARN: Removed duplicated region for block: B:167:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i2) {
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
        if (!(interceptable == null || interceptable.invokeLLLI(1048595, this, pbFirstFloorViewHolder, postData, view, i2) == null) || this.v == null) {
            return;
        }
        TbRichText tbRichText = null;
        if (postData.A() != 1) {
            if (TextUtils.isEmpty(postData.u())) {
                pbFirstFloorViewHolder.richText.setOnClickListener(this.y);
                pbFirstFloorViewHolder.richText.setTextViewOnClickListener(this.y);
            } else {
                pbFirstFloorViewHolder.richText.setOnClickListener(null);
                pbFirstFloorViewHolder.richText.setTextViewOnClickListener(null);
            }
            pbFirstFloorViewHolder.pbItemViewRoot.setOnClickListener(this.y);
        } else {
            pbFirstFloorViewHolder.pbItemViewRoot.setOnClickListener(null);
        }
        if (postData.A() == 1) {
            pbFirstFloorViewHolder.showForumEnterButton(this.v, this.n.isSimpleForum(), postData.S);
            n0(pbFirstFloorViewHolder.richText, view, this.G);
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
            c.a.r0.q2.r.f fVar = this.v;
            if (fVar != null && fVar.O() != null) {
                pbFirstFloorViewHolder.mViewStubController.b(postData.F(), str, str2, j2, c.a.d.f.m.b.g(this.v.O().g0(), 0L), c.a.d.f.m.b.g(postData.G(), 0L));
            }
            if (this.n.getPbView().G1()) {
                pbFirstFloorViewHolder.richText.setVisibility(8);
            }
            c.a.r0.q2.r.f fVar2 = this.v;
            if (fVar2 != null && fVar2.O() != null && this.v.O().I1() != null) {
                q2 I1 = this.v.O().I1();
                String a2 = I1.a();
                if (StringUtils.isNull(I1.b())) {
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
            c.a.r0.q2.r.f fVar3 = this.v;
            if (fVar3 != null && fVar3.O() != null && this.v.O().H2() && (threadForumEnterButtonContainer = pbFirstFloorViewHolder.mForumEnterButtonContainer) != null) {
                threadForumEnterButtonContainer.setPadding(threadForumEnterButtonContainer.getPaddingLeft(), c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), c.a.r0.q2.g.tbds29), pbFirstFloorViewHolder.mForumEnterButtonContainer.getPaddingRight(), pbFirstFloorViewHolder.mForumEnterButtonContainer.getPaddingBottom());
            }
        }
        pbFirstFloorViewHolder.richText.getLayoutStrategy().x(c.a.r0.q2.h.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(c.a.r0.q2.i.tag_clip_board, postData);
        sparseArray.put(c.a.r0.q2.i.tag_load_sub_data, postData);
        sparseArray.put(c.a.r0.q2.i.tag_load_sub_view, view);
        sparseArray.put(c.a.r0.q2.i.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(c.a.r0.q2.i.tag_pb_floor_number, Integer.valueOf(postData.A()));
        boolean z6 = postData.a0() || postData.Z(false);
        if (z6) {
            if (this.w == null) {
                c.a.r0.q2.u.h.b bVar = new c.a.r0.q2.u.h.b(this.H);
                this.w = bVar;
                bVar.f(this.q);
                this.w.h(this.x);
                c.a.r0.q2.r.f fVar4 = this.v;
                if (fVar4 != null) {
                    this.w.j(this.v.V(), TextUtils.equals(fVar4.O().J().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.w.i(this.v.O());
                }
            }
            this.w.g(postData.G());
        }
        pbFirstFloorViewHolder.richText.setLinkTextColor(SkinManager.getColor(c.a.r0.q2.f.CAM_X0304));
        if (this.t) {
            pbFirstFloorViewHolder.richText.getLayoutStrategy().g(c.a.r0.q2.h.transparent_bg);
        } else {
            pbFirstFloorViewHolder.richText.getLayoutStrategy().g(c.a.r0.q2.h.icon_click);
        }
        pbFirstFloorViewHolder.richText.setIsFromCDN(this.q);
        c.a.r0.q2.r.f fVar5 = this.v;
        if (fVar5 != null && fVar5.O() != null && this.v.O().h2()) {
            q0(pbFirstFloorViewHolder, this.v.O().C0());
        }
        c.a.r0.q2.r.f fVar6 = this.v;
        if ((fVar6 == null || fVar6.O() == null || !this.v.O().B1 || postData.L() == null) ? false : true) {
            if (postData.L().B != null) {
                pbFirstFloorViewHolder.richText.getLayoutStrategy().m(t0(c.a.r0.q2.g.tbds24));
            } else {
                pbFirstFloorViewHolder.richText.getLayoutStrategy().m(t0(c.a.r0.q2.g.tbds14));
            }
            r0(pbFirstFloorViewHolder, postData);
        } else {
            pbFirstFloorViewHolder.richText.getLayoutStrategy().m(t0(c.a.r0.q2.g.tbds24));
        }
        TbRichText M = postData.M();
        c.a.r0.q2.r.f fVar7 = this.v;
        if (fVar7 == null || !fVar7.r0()) {
            tbRichText = M;
        }
        if (this.v.O() != null) {
            pbFirstFloorViewHolder.richText.setTid(this.v.Q());
            pbFirstFloorViewHolder.richText.setIsUseGridImage(this.v.O().Q1());
            pbFirstFloorViewHolder.richText.setmIsGridImageSupportLongPress(true);
        }
        c.a.r0.q2.r.f fVar8 = this.v;
        if (fVar8 != null && 3 == fVar8.g()) {
            if (!this.E && this.F) {
                pbFirstFloorViewHolder.richText.setText(tbRichText, true, this.C, true, false);
            } else {
                pbFirstFloorViewHolder.richText.setText(tbRichText, false, this.C, true, false);
            }
        } else if (!this.E && this.F) {
            pbFirstFloorViewHolder.richText.setText(tbRichText, true, this.C, false, true);
        } else {
            pbFirstFloorViewHolder.richText.setText(tbRichText, false, this.C, false, true);
        }
        s0(pbFirstFloorViewHolder, postData, tbRichText);
        boolean z7 = !StringUtils.isNull(postData.t().getVirtualUserUrl());
        c.a.r0.q2.r.f fVar9 = this.v;
        if (fVar9 == null || fVar9.V() == 0 || w0()) {
            z = false;
            z2 = false;
        } else {
            if (this.v.V() != 3) {
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
        c.a.r0.q2.r.f fVar10 = this.v;
        if (fVar10 != null && fVar10.O() != null && this.v.O().J() != null && postData.t() != null) {
            String userId2 = this.v.O().J().getUserId();
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
                sparseArray.put(c.a.r0.q2.i.tag_forbid_user_post_id, postData.G());
                if (!z) {
                    sparseArray.put(c.a.r0.q2.i.tag_should_manage_visible, Boolean.TRUE);
                    if (postData.t() != null) {
                        sparseArray.put(c.a.r0.q2.i.tag_forbid_user_name, postData.t().getUserName());
                        sparseArray.put(c.a.r0.q2.i.tag_forbid_user_name_show, postData.t().getName_show());
                        sparseArray.put(c.a.r0.q2.i.tag_forbid_user_portrait, postData.t().getPortrait());
                    }
                    c.a.r0.q2.r.f fVar11 = this.v;
                    if (fVar11 != null) {
                        sparseArray.put(c.a.r0.q2.i.tag_manage_user_identity, Integer.valueOf(fVar11.V()));
                    }
                } else {
                    sparseArray.put(c.a.r0.q2.i.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray.put(c.a.r0.q2.i.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(c.a.r0.q2.i.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.t() != null) {
                        sparseArray.put(c.a.r0.q2.i.tag_user_mute_mute_userid, postData.t().getUserId());
                        sparseArray.put(c.a.r0.q2.i.tag_user_mute_mute_username, postData.t().getUserName());
                        sparseArray.put(c.a.r0.q2.i.tag_user_mute_mute_nameshow, postData.t().getName_show());
                    }
                    c.a.r0.q2.r.f fVar12 = this.v;
                    if (fVar12 != null && fVar12.O() != null) {
                        sparseArray.put(c.a.r0.q2.i.tag_user_mute_thread_id, this.v.O().g0());
                    }
                    sparseArray.put(c.a.r0.q2.i.tag_user_mute_post_id, postData.G());
                } else {
                    sparseArray.put(c.a.r0.q2.i.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z2) {
                    sparseArray.put(c.a.r0.q2.i.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(c.a.r0.q2.i.tag_has_sub_post, Boolean.valueOf(z6));
                    sparseArray.put(c.a.r0.q2.i.tag_del_post_is_self, Boolean.valueOf(z4));
                    sparseArray.put(c.a.r0.q2.i.tag_del_post_type, Integer.valueOf(i3));
                    sparseArray.put(c.a.r0.q2.i.tag_del_post_id, postData.G());
                    c.a.r0.q2.r.f fVar13 = this.v;
                    if (fVar13 != null) {
                        sparseArray.put(c.a.r0.q2.i.tag_manage_user_identity, Integer.valueOf(fVar13.V()));
                    }
                } else {
                    sparseArray.put(c.a.r0.q2.i.tag_should_delete_visible, Boolean.FALSE);
                }
                sparseArray.put(c.a.r0.q2.i.tag_is_self_post, Boolean.valueOf(z5));
                m0(pbFirstFloorViewHolder);
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
        sparseArray.put(c.a.r0.q2.i.tag_forbid_user_post_id, postData.G());
        if (!z) {
        }
        if (!z3) {
        }
        if (!z2) {
        }
        sparseArray.put(c.a.r0.q2.i.tag_is_self_post, Boolean.valueOf(z5));
        m0(pbFirstFloorViewHolder);
    }

    public void p(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, yVar) == null) {
            this.z = yVar;
        }
    }

    public final void p0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i2) {
        c.a.r0.q2.r.m mVar;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048597, this, pbFirstFloorViewHolder, postData, view, i2) == null) || pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        pbFirstFloorViewHolder.richText.setTag(sparseArray);
        pbFirstFloorViewHolder.pbItemViewRoot.setTag(c.a.r0.q2.i.tag_from, sparseArray);
        sparseArray.put(c.a.r0.q2.i.tag_clip_board, postData);
        sparseArray.put(c.a.r0.q2.i.tag_is_subpb, Boolean.FALSE);
        pbFirstFloorViewHolder.richText.setIsHost(true);
        if (this.u) {
            pbFirstFloorViewHolder.mBottomDivider.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.mBottomDivider.setVisibility(8);
        }
        if (!TextUtils.isEmpty(postData.u()) && this.t) {
            this.G = true;
            pbFirstFloorViewHolder.richText.startLoad(postData.u(), new d(this, pbFirstFloorViewHolder, postData, view, i2));
        } else {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.richText.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            pbFirstFloorViewHolder.richText.setLayoutParams(layoutParams);
            pbFirstFloorViewHolder.richText.startLoad(null);
            this.G = false;
            o0(pbFirstFloorViewHolder, postData, view, i2);
        }
        c.a.r0.q2.r.f fVar = this.v;
        if (fVar != null && fVar.O() != null && this.v.O().H2() && this.v.O().t1() != null && c.a.d.f.p.k.isEmpty(this.v.l().getName())) {
            pbFirstFloorViewHolder.showBlankViewAboveRichText(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(c.a.r0.q2.g.tbds28));
        } else if (postData.M() != null && !ListUtils.isEmpty(postData.M().y())) {
            pbFirstFloorViewHolder.showBlankViewAboveRichText(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(c.a.r0.q2.g.tbds30));
        } else {
            pbFirstFloorViewHolder.showBlankViewAboveRichText(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(c.a.r0.q2.g.tbds52));
        }
        if (postData.M() != null) {
            if (postData.M().z() > 0) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.mAppletsCellView.getLayoutParams();
                layoutParams2.topMargin = g0(c.a.r0.q2.g.tbds26);
                pbFirstFloorViewHolder.mAppletsCellView.setLayoutParams(layoutParams2);
            } else {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.mAppletsCellView.getLayoutParams();
                layoutParams3.topMargin = g0(c.a.r0.q2.g.tbds16);
                pbFirstFloorViewHolder.mAppletsCellView.setLayoutParams(layoutParams3);
            }
        }
        c.a.r0.q2.r.f fVar2 = this.v;
        if (fVar2 != null && x0(fVar2.O())) {
            pbFirstFloorViewHolder.mVoteView.setDataForPb(this.v.O().J0(), this.v.O().v1(), this.v.m());
            if (postData.M() != null && !ListUtils.isEmpty(postData.M().y())) {
                pbFirstFloorViewHolder.mVoteView.setMarginTop(c.a.d.f.p.l.f(this.H, c.a.r0.q2.g.tbds26));
            } else {
                pbFirstFloorViewHolder.mVoteView.setMarginTop(c.a.d.f.p.l.f(this.H, c.a.r0.q2.g.tbds0));
            }
            pbFirstFloorViewHolder.mVoteView.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.mVoteView.setVisibility(8);
        }
        c.a.r0.q2.r.f fVar3 = this.v;
        if (fVar3 != null && fVar3.O() != null && this.v.O().g1() != null && this.v.O().t1() == null) {
            pbFirstFloorViewHolder.mAppletsCellView.setData(this.v.O().g1());
            pbFirstFloorViewHolder.mAppletsCellView.setVisibility(0);
            c.a.r0.q2.r.f fVar4 = this.v;
            if (fVar4 != null && fVar4.l() != null) {
                pbFirstFloorViewHolder.mAppletsCellView.setForumId(String.valueOf(this.v.l().getId()));
            }
            c.a.r0.q2.r.f fVar5 = this.v;
            if (fVar5 != null && fVar5.Q() != null) {
                pbFirstFloorViewHolder.mAppletsCellView.setThreadId(this.v.Q());
            }
            pbFirstFloorViewHolder.mAppletsCellView.setFrom(AppletsCellView.PB_SHARE_CARD_LITE_PROGRAM_FROM);
        } else {
            pbFirstFloorViewHolder.mAppletsCellView.setVisibility(8);
        }
        J0();
        c.a.r0.q2.r.f fVar6 = this.v;
        if (fVar6 != null && (mVar = fVar6.f21522h) != null) {
            if (pbFirstFloorViewHolder.mVoteTailTv != null) {
                if (TextUtils.isEmpty(mVar.e())) {
                    pbFirstFloorViewHolder.mVoteTailTv.setVisibility(8);
                } else {
                    pbFirstFloorViewHolder.mVoteTailTv.setVisibility(0);
                    pbFirstFloorViewHolder.mVoteTailTv.setText(this.v.f21522h.e());
                }
            }
            if (pbFirstFloorViewHolder.mPbListContent != null && pbFirstFloorViewHolder.mManagerSelectView.h() == null) {
                pbFirstFloorViewHolder.mPbListContent.addView(pbFirstFloorViewHolder.mManagerSelectView.a(this.v));
                String fromPageKey = UtilHelper.getFromPageKey(this.n.getPageContext());
                Context context = this.H;
                if (!(context instanceof AbsPbActivity) || ((AbsPbActivity) context).getIntent() == null) {
                    z = false;
                } else {
                    z = ((AbsPbActivity) this.H).getIntent().getBooleanExtra("is_from_bar_vote", false);
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
        c.a.r0.q2.r.f fVar7 = this.v;
        if (fVar7 != null && fVar7.O() != null && !x0(this.v.O()) && (!ListUtils.isEmpty(this.v.O().B0()) || !ListUtils.isEmpty(this.v.O().d0()))) {
            c.a.q0.d1.o0 o0Var = new c.a.q0.d1.o0();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.H);
            c.a.r0.q2.r.f fVar8 = this.v;
            pbLinkGoodsRootView.bindData(fVar8, o0Var.a(fVar8.O().B0(), this.v.O().d0()), this.v.n(), this.n, o0Var.b());
            pbFirstFloorViewHolder.mLinkContainer.addView(pbLinkGoodsRootView);
            pbFirstFloorViewHolder.mLinkContainer.setVisibility(0);
            return;
        }
        pbFirstFloorViewHolder.mLinkContainer.setVisibility(8);
    }

    public final void q0(PbFirstFloorViewHolder pbFirstFloorViewHolder, c.a.q0.s.q.r0 r0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, pbFirstFloorViewHolder, r0Var) == null) || r0Var == null || c.a.d.f.p.k.isEmpty(r0Var.e()) || r0Var.c() != c.a.q0.s.q.r0.f13037g) {
            return;
        }
        if (!r0Var.f()) {
            pbFirstFloorViewHolder.richText.getLayoutStrategy().m(c.a.d.f.p.l.f(this.H, c.a.r0.q2.g.ds48));
        }
        pbFirstFloorViewHolder.mViewStubController.c(r0Var);
    }

    public final void r0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, pbFirstFloorViewHolder, postData) == null) || pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        pbFirstFloorViewHolder.mOrignalThreadRootView.setVisibility(0);
        if (pbFirstFloorViewHolder.mOriginalThreadView == null) {
            pbFirstFloorViewHolder.mOriginalThreadView = u0(postData);
        }
        if (pbFirstFloorViewHolder.mOrignalThreadRootView.getChildCount() <= 0 && (a2 = pbFirstFloorViewHolder.mOriginalThreadView.a()) != null) {
            pbFirstFloorViewHolder.mOrignalThreadRootView.addView(a2);
        }
        pbFirstFloorViewHolder.mOriginalThreadView.e(this.K);
        pbFirstFloorViewHolder.mOriginalThreadView.d(this.L);
        pbFirstFloorViewHolder.mOriginalThreadView.c(postData.L());
        pbFirstFloorViewHolder.mOriginalThreadView.b(this.n.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void s0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048600, this, pbFirstFloorViewHolder, postData, tbRichText) == null) {
            if (postData != null && postData.R() != null) {
                c.a.r0.q2.z.g.c(postData.R(), pbFirstFloorViewHolder.mTailContent, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.u()));
            } else {
                pbFirstFloorViewHolder.mTailContent.setVisibility(8);
            }
        }
    }

    public void t(c.a.r0.q2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, fVar) == null) {
            this.v = fVar;
        }
    }

    public final int t0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) ? c.a.d.f.p.l.f(TbadkCoreApplication.getInst().getContext(), i2) : invokeI.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c.a.r0.q2.u.f.e1.a u0(PostData postData) {
        InterceptResult invokeL;
        c.a.r0.q2.u.f.e1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048603, this, postData)) != null) {
            return (c.a.r0.q2.u.f.e1.a) invokeL.objValue;
        }
        if (postData != null && postData.L() != null && postData.L().h()) {
            BaijiahaoData baijiahaoData = postData.L().p;
            Item item = postData.L().B;
            if (!postData.L().m && !postData.E0()) {
                if (item != null && item.item_id.longValue() != 0) {
                    if (postData.L().a != 0 && postData.L().a != 1) {
                        if (postData.L().a == 3) {
                            aVar = new c.a.r0.q2.u.f.e1.g(this.n.getPageContext());
                        } else {
                            aVar = new c.a.r0.q2.u.f.e1.e(this.n.getPageContext());
                        }
                    } else {
                        aVar = new c.a.r0.q2.u.f.e1.f(this.n.getPageContext());
                    }
                } else if (baijiahaoData != null && postData.L().i()) {
                    int i2 = baijiahaoData.oriUgcType;
                    if (i2 == 1) {
                        aVar = new c.a.r0.q2.u.f.e1.b(this.n.getPageContext(), this.I);
                    } else if (i2 == 2) {
                        aVar = new c.a.r0.q2.u.f.e1.i(this.n.getPageContext(), this.I);
                    } else if (i2 == 3) {
                        aVar = new c.a.r0.q2.u.f.e1.h(this.n.getPageContext(), this.I);
                    } else if (i2 != 4) {
                        aVar = new c.a.r0.q2.u.f.e1.c(this.n.getPageContext(), this.I);
                    } else {
                        aVar = new c.a.r0.q2.u.f.e1.i(this.n.getPageContext(), this.I);
                    }
                } else if (postData.L().a != 0 && postData.L().a != 1) {
                    if (postData.L().a == 3) {
                        aVar = new c.a.r0.q2.u.f.e1.i(this.n.getPageContext(), this.I);
                    }
                } else {
                    aVar = new c.a.r0.q2.u.f.e1.h(this.n.getPageContext(), this.I);
                }
            } else {
                aVar = new c.a.r0.q2.u.f.e1.d(this.n.getPageContext(), this.I);
            }
            return aVar != null ? new c.a.r0.q2.u.f.e1.c(this.n.getPageContext(), this.I) : aVar;
        }
        aVar = null;
        if (aVar != null) {
        }
    }

    public PbFirstFloorViewHolder v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? (PbFirstFloorViewHolder) this.f2913k : (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public final boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            c.a.r0.q2.r.f fVar = this.v;
            if (fVar == null || fVar.O() == null) {
                return false;
            }
            return this.v.O().V1();
        }
        return invokeV.booleanValue;
    }

    public final boolean x0(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, d2Var)) == null) ? (d2Var == null || d2Var.J0() == null || d2Var.J0().getOptions() == null || d2Var.J0().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: y0 */
    public PbFirstFloorViewHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, viewGroup)) == null) {
            PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.n.getPageContext(), LayoutInflater.from(this.H).inflate(c.a.r0.q2.j.new_pb_list_first_floor_item, viewGroup, false), this.t, this.s);
            I0(pbFirstFloorViewHolder);
            pbFirstFloorViewHolder.mViewStubController.f(this.I);
            return pbFirstFloorViewHolder;
        }
        return (PbFirstFloorViewHolder) invokeL.objValue;
    }

    public View z0(int i2, View view, ViewGroup viewGroup, PostData postData, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        InterceptResult invokeCommon;
        BdTypeListView listView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, pbFirstFloorViewHolder})) == null) {
            super.Z(i2, view, viewGroup, postData, pbFirstFloorViewHolder);
            I0(pbFirstFloorViewHolder);
            D0(pbFirstFloorViewHolder);
            PostData postData2 = (PostData) z(i2);
            if (postData2 != null) {
                postData2.H0();
                postData2.f0 = i2 + 1;
                c.a.r0.q2.w.a.d(this.n.getUniqueId(), this.v, postData2, postData2.f0, 1);
                p0(pbFirstFloorViewHolder, postData2, view, i2);
            }
            if (!this.E && this.F && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.richText.hasLongText() && (listView = this.n.getListView()) != null) {
                this.E = true;
                CompatibleUtile.getInstance().closeViewGpu(listView);
            }
            pbFirstFloorViewHolder.mYoungsterTipTv.setVisibility(c.a.q0.g1.b.c.d() ? 0 : 8);
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
