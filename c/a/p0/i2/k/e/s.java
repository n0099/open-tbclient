package c.a.p0.i2.k.e;

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
import c.a.l.a;
import c.a.o0.s.q.c2;
import c.a.o0.s.q.p2;
import c.a.p0.i2.i.c;
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
import com.baidu.tieba.R;
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
/* loaded from: classes3.dex */
public class s extends o<PostData, PbFirstFloorViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.i2.i.c A;
    public View.OnLongClickListener B;
    public TbRichTextView.t C;
    public View.OnClickListener D;
    public boolean E;
    public final boolean F;
    public boolean G;
    public Context H;
    public int I;
    public c.a.p0.i2.i.c J;
    public c.a.p0.a0.b0<c.a.o0.s.q.a> K;
    public a.InterfaceC0086a L;
    public int s;
    public boolean t;
    public boolean u;
    public c.a.p0.i2.h.e v;
    public c.a.p0.i2.k.g.b w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public TbRichTextView.z z;

    /* loaded from: classes3.dex */
    public class a implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f19316a;

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
            this.f19316a = sVar;
        }

        @Override // c.a.p0.i2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.p0.i2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.f19316a.A != null) {
                    this.f19316a.A.a(view);
                    this.f19316a.A.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.p0.i2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (c.a.o0.e1.b.e.d()) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, 2));
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c.a.p0.a0.b0<c.a.o0.s.q.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s f19317b;

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
            this.f19317b = sVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a0.b0
        /* renamed from: d */
        public void a(View view, c.a.o0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, aVar) == null) {
                super.a(view, aVar);
                if (aVar == null || aVar.getThreadData() == null || aVar.getThreadData().v1 == null || this.f19317b.v == null) {
                    return;
                }
                OriginalThreadInfo originalThreadInfo = aVar.getThreadData().v1;
                String Q = this.f19317b.v.Q();
                String str = originalThreadInfo.f47200f;
                int i2 = 1;
                int i3 = originalThreadInfo.f47195a;
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

    /* loaded from: classes3.dex */
    public class c implements a.InterfaceC0086a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f19318a;

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
            this.f19318a = sVar;
        }

        @Override // c.a.l.a.InterfaceC0086a
        public void a(c.a.o0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().v1 == null) {
                return;
            }
            OriginalThreadInfo originalThreadInfo = aVar.getThreadData().v1;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f19318a.H);
            pbActivityConfig.createNormalCfg(originalThreadInfo.f47200f, originalThreadInfo.n, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.f47199e));
            pbActivityConfig.setStartFrom(this.f19318a.I);
            pbActivityConfig.setBjhData(originalThreadInfo.p);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements TbRichTextView.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFirstFloorViewHolder f19319a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PostData f19320b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f19321c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f19322d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f19323e;

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
            this.f19323e = sVar;
            this.f19319a = pbFirstFloorViewHolder;
            this.f19320b = postData;
            this.f19321c = view;
            this.f19322d = i2;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.w
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f19319a.richText.getLayoutParams();
                layoutParams.topMargin = this.f19323e.h0(R.dimen.ds16);
                int h0 = this.f19323e.h0(R.dimen.ds34);
                layoutParams.bottomMargin = h0;
                layoutParams.leftMargin = h0;
                layoutParams.rightMargin = h0;
                this.f19319a.richText.setLayoutParams(layoutParams);
                this.f19323e.p0(this.f19319a, this.f19320b, this.f19321c, this.f19322d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(s sVar) {
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
                super((c.a.p0.i2.o.b) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.J = new c.a.p0.i2.i.c(new a(this));
        this.K = new b(this);
        this.L = new c(this);
        if (pbFragment != null && pbFragment.getPbModel() != null) {
            this.I = pbFragment.getPbModel().N0();
        }
        this.H = pbFragment.getContext();
    }

    public void A0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (v = this.k) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).mViewStubController.d();
    }

    public void B0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (v = this.k) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).mViewStubController.a();
        ((PbFirstFloorViewHolder) this.k).mPbBusinessPromotionContainer.destroy();
    }

    public void C0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (v = this.k) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).mViewStubController.e();
    }

    public final void D0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.pbItemViewRoot.setOnTouchListener(this.A);
            pbFirstFloorViewHolder.pbItemViewRoot.setOnLongClickListener(this.B);
            c.a.p0.i2.k.e.c1.a aVar = this.m.getPbActivity().mEvent;
            pbFirstFloorViewHolder.richText.setOnLongClickListener(this.B);
            pbFirstFloorViewHolder.richText.setOnTouchListener(this.J);
            pbFirstFloorViewHolder.richText.setItemOrderOrDownloadListener(this.D);
            pbFirstFloorViewHolder.richText.setIsShowOrderOrDownloadBtn(true);
            pbFirstFloorViewHolder.richText.setCommonTextViewOnClickListener(this.y);
            pbFirstFloorViewHolder.richText.setOnImageClickListener(this.z);
            pbFirstFloorViewHolder.richText.setOnImageTouchListener(this.J);
            pbFirstFloorViewHolder.richText.setmGridEmptyClickListener(new e(this));
            pbFirstFloorViewHolder.richText.setOnEmotionClickListener(aVar.f19054e);
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

    public void G0(c.a.p0.i2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.A = cVar;
        }
    }

    public void H0(TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tVar) == null) {
            this.C = tVar;
        }
    }

    public final void I0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbFirstFloorViewHolder) == null) || pbFirstFloorViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbFirstFloorViewHolder.mSkinType != skinType) {
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.mYoungsterTipTv, R.color.CAM_X0202);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.pbItemViewRoot, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.mBottomDivider, R.color.CAM_X0204);
            pbFirstFloorViewHolder.richText.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbFirstFloorViewHolder.mAppletsCellView.onChangeSkinType();
            ThreadForumEnterButtonContainer threadForumEnterButtonContainer = pbFirstFloorViewHolder.mForumEnterButtonContainer;
            if (threadForumEnterButtonContainer != null) {
                threadForumEnterButtonContainer.onChangeSkinType();
            }
            PbBusinessPromotionContainer pbBusinessPromotionContainer = pbFirstFloorViewHolder.mPbBusinessPromotionContainer;
            if (pbBusinessPromotionContainer != null) {
                pbBusinessPromotionContainer.onChangeSkinType();
            }
            SkinManager.setViewTextColor(pbFirstFloorViewHolder.mVoteTailTv, R.color.CAM_X0107);
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
            PbFirstFloorViewHolder w0 = w0();
            c.a.p0.i2.h.e eVar = this.v;
            if (eVar == null || eVar.O() == null || w0 == null) {
                return;
            }
            w0.showThreadTypeStampBottomPart(this.v, this.v.O().o0() == 1, this.v.O().p0() == 1);
        }
    }

    @Override // c.a.p0.i2.k.e.o, c.a.e.k.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
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

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.s = i2;
        }
    }

    public final void n0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.richText.setTextViewOnTouchListener(this.J);
            pbFirstFloorViewHolder.richText.setTextViewCheckSelection(false);
        }
    }

    public final void o0(TbRichTextView tbRichTextView, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048594, this, tbRichTextView, view, z) == null) || tbRichTextView == null) {
            return;
        }
        int min = Math.min(((((c.a.e.e.p.l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - (z ? h0(R.dimen.ds80) : 0), this.s);
        tbRichTextView.getLayoutStrategy().q(min);
        tbRichTextView.getLayoutStrategy().p((int) (min * 1.618f));
    }

    public void p(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, zVar) == null) {
            this.z = zVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x04c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String str;
        String str2;
        long j2;
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048596, this, pbFirstFloorViewHolder, postData, view, i2) == null) || this.v == null) {
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
            pbFirstFloorViewHolder.showForumEnterButton(this.v, this.n.isSimpleForum(), postData.Q);
            o0(pbFirstFloorViewHolder.richText, view, this.G);
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
            c.a.p0.i2.h.e eVar = this.v;
            if (eVar != null && eVar.O() != null) {
                pbFirstFloorViewHolder.mViewStubController.b(postData.D(), str, str2, j2, c.a.e.e.m.b.f(this.v.O().f0(), 0L), c.a.e.e.m.b.f(postData.E(), 0L));
            }
            if (this.n.getPbView().G1()) {
                pbFirstFloorViewHolder.richText.setVisibility(8);
            }
            c.a.p0.i2.h.e eVar2 = this.v;
            if (eVar2 != null && eVar2.O() != null && this.v.O().D1() != null) {
                p2 D1 = this.v.O().D1();
                String a2 = D1.a();
                if (StringUtils.isNull(D1.b())) {
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
            c.a.p0.i2.h.e eVar3 = this.v;
            if (eVar3 != null && eVar3.O() != null && this.v.O().A2() && (threadForumEnterButtonContainer = pbFirstFloorViewHolder.mForumEnterButtonContainer) != null) {
                threadForumEnterButtonContainer.setPadding(threadForumEnterButtonContainer.getPaddingLeft(), c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.mForumEnterButtonContainer.getPaddingRight(), pbFirstFloorViewHolder.mForumEnterButtonContainer.getPaddingBottom());
            }
        }
        pbFirstFloorViewHolder.richText.getLayoutStrategy().x(R.drawable.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_load_sub_data, postData);
        sparseArray.put(R.id.tag_load_sub_view, view);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.A()));
        boolean W = postData.W();
        if (W) {
            if (this.w == null) {
                c.a.p0.i2.k.g.b bVar = new c.a.p0.i2.k.g.b(this.H);
                this.w = bVar;
                bVar.f(this.q);
                this.w.h(this.x);
                c.a.p0.i2.h.e eVar4 = this.v;
                if (eVar4 != null) {
                    this.w.j(this.v.V(), TextUtils.equals(eVar4.O().J().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.w.i(this.v.O());
                }
            }
            this.w.g(postData.E());
        }
        pbFirstFloorViewHolder.richText.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.t) {
            pbFirstFloorViewHolder.richText.getLayoutStrategy().g(R.drawable.transparent_bg);
        } else {
            pbFirstFloorViewHolder.richText.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbFirstFloorViewHolder.richText.setIsFromCDN(this.q);
        c.a.p0.i2.h.e eVar5 = this.v;
        if (eVar5 != null && eVar5.O() != null && this.v.O().b2()) {
            r0(pbFirstFloorViewHolder, this.v.O().z0());
        }
        c.a.p0.i2.h.e eVar6 = this.v;
        if ((eVar6 == null || eVar6.O() == null || !this.v.O().w1 || postData.J() == null) ? false : true) {
            if (postData.J().B != null) {
                pbFirstFloorViewHolder.richText.getLayoutStrategy().m(u0(R.dimen.tbds24));
            } else {
                pbFirstFloorViewHolder.richText.getLayoutStrategy().m(u0(R.dimen.tbds14));
            }
            s0(pbFirstFloorViewHolder, postData);
        } else {
            pbFirstFloorViewHolder.richText.getLayoutStrategy().m(u0(R.dimen.tbds24));
        }
        TbRichText K = postData.K();
        c.a.p0.i2.h.e eVar7 = this.v;
        if (eVar7 == null || !eVar7.p0()) {
            tbRichText = K;
        }
        if (this.v.O() != null) {
            pbFirstFloorViewHolder.richText.setTid(this.v.Q());
            pbFirstFloorViewHolder.richText.setIsUseGridImage(this.v.O().K1());
            pbFirstFloorViewHolder.richText.setmIsGridImageSupportLongPress(true);
        }
        c.a.p0.i2.h.e eVar8 = this.v;
        if (eVar8 != null && 3 == eVar8.g()) {
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
        t0(pbFirstFloorViewHolder, postData, tbRichText);
        boolean z5 = !StringUtils.isNull(postData.t().getVirtualUserUrl());
        c.a.p0.i2.h.e eVar9 = this.v;
        if (eVar9 == null || eVar9.V() == 0) {
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
        c.a.p0.i2.h.e eVar10 = this.v;
        if (eVar10 != null && eVar10.O() != null && this.v.O().J() != null && postData.t() != null) {
            String userId2 = this.v.O().J().getUserId();
            String userId3 = postData.t().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z2 = true;
                    z3 = false;
                    z4 = true;
                    if (postData.t() != null && UtilHelper.isCurrentAccount(postData.t().getUserId())) {
                        z2 = true;
                        z4 = true;
                    }
                    if (z5) {
                        z = false;
                        z2 = false;
                        z3 = false;
                    }
                    int i3 = postData.A() == 1 ? 0 : 1;
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                    if (z) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                        }
                        c.a.p0.i2.h.e eVar11 = this.v;
                        if (eVar11 != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar11.V()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.t().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.t().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.t().getName_show());
                        }
                        c.a.p0.i2.h.e eVar12 = this.v;
                        if (eVar12 != null && eVar12.O() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.v.O().f0());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.E());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (z2) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(W));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(R.id.tag_del_post_id, postData.E());
                        c.a.p0.i2.h.e eVar13 = this.v;
                        if (eVar13 != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar13.V()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    n0(pbFirstFloorViewHolder);
                }
                z2 = true;
                z3 = true;
                z4 = false;
                if (postData.t() != null) {
                    z2 = true;
                    z4 = true;
                }
                if (z5) {
                }
                if (postData.A() == 1) {
                }
                sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                if (z) {
                }
                if (z3) {
                }
                if (z2) {
                }
                n0(pbFirstFloorViewHolder);
            }
        }
        z3 = false;
        z4 = false;
        if (postData.t() != null) {
        }
        if (z5) {
        }
        if (postData.A() == 1) {
        }
        sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
        if (z) {
        }
        if (z3) {
        }
        if (z2) {
        }
        n0(pbFirstFloorViewHolder);
    }

    public final void q0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i2) {
        c.a.p0.i2.h.k kVar;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048597, this, pbFirstFloorViewHolder, postData, view, i2) == null) || pbFirstFloorViewHolder == null || postData == null) {
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
            p0(pbFirstFloorViewHolder, postData, view, i2);
        }
        c.a.p0.i2.h.e eVar = this.v;
        if (eVar != null && eVar.O() != null && this.v.O().A2() && this.v.O().o1() != null && c.a.e.e.p.k.isEmpty(this.v.m().getName())) {
            pbFirstFloorViewHolder.showBlankViewAboveRichText(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
        } else if (postData.K() != null && !ListUtils.isEmpty(postData.K().y())) {
            pbFirstFloorViewHolder.showBlankViewAboveRichText(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
        } else {
            pbFirstFloorViewHolder.showBlankViewAboveRichText(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
        }
        if (postData.K() != null) {
            if (postData.K().z() > 0) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.mAppletsCellView.getLayoutParams();
                layoutParams2.topMargin = h0(R.dimen.tbds26);
                pbFirstFloorViewHolder.mAppletsCellView.setLayoutParams(layoutParams2);
            } else {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.mAppletsCellView.getLayoutParams();
                layoutParams3.topMargin = h0(R.dimen.tbds16);
                pbFirstFloorViewHolder.mAppletsCellView.setLayoutParams(layoutParams3);
            }
        }
        c.a.p0.i2.h.e eVar2 = this.v;
        if (eVar2 != null && x0(eVar2.O())) {
            pbFirstFloorViewHolder.mVoteView.setDataForPb(this.v.O().G0(), this.v.O().q1(), this.v.n());
            if (postData.K() != null && !ListUtils.isEmpty(postData.K().y())) {
                pbFirstFloorViewHolder.mVoteView.setMarginTop(c.a.e.e.p.l.g(this.H, R.dimen.tbds26));
            } else {
                pbFirstFloorViewHolder.mVoteView.setMarginTop(c.a.e.e.p.l.g(this.H, R.dimen.tbds0));
            }
            pbFirstFloorViewHolder.mVoteView.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.mVoteView.setVisibility(8);
        }
        c.a.p0.i2.h.e eVar3 = this.v;
        if (eVar3 != null && eVar3.O() != null && this.v.O().c1() != null && this.v.O().o1() == null) {
            pbFirstFloorViewHolder.mAppletsCellView.setData(this.v.O().c1());
            pbFirstFloorViewHolder.mAppletsCellView.setVisibility(0);
            c.a.p0.i2.h.e eVar4 = this.v;
            if (eVar4 != null && eVar4.m() != null) {
                pbFirstFloorViewHolder.mAppletsCellView.setForumId(String.valueOf(this.v.m().getId()));
            }
            c.a.p0.i2.h.e eVar5 = this.v;
            if (eVar5 != null && eVar5.Q() != null) {
                pbFirstFloorViewHolder.mAppletsCellView.setThreadId(this.v.Q());
            }
            pbFirstFloorViewHolder.mAppletsCellView.setFrom(AppletsCellView.PB_SHARE_CARD_LITE_PROGRAM_FROM);
        } else {
            pbFirstFloorViewHolder.mAppletsCellView.setVisibility(8);
        }
        J0();
        c.a.p0.i2.h.e eVar6 = this.v;
        if (eVar6 != null && (kVar = eVar6.f18736h) != null) {
            if (pbFirstFloorViewHolder.mVoteTailTv != null) {
                if (TextUtils.isEmpty(kVar.e())) {
                    pbFirstFloorViewHolder.mVoteTailTv.setVisibility(8);
                } else {
                    pbFirstFloorViewHolder.mVoteTailTv.setVisibility(0);
                    pbFirstFloorViewHolder.mVoteTailTv.setText(this.v.f18736h.e());
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
        c.a.p0.i2.h.e eVar7 = this.v;
        if (eVar7 != null && eVar7.O() != null && !x0(this.v.O()) && (!ListUtils.isEmpty(this.v.O().y0()) || !ListUtils.isEmpty(this.v.O().c0()))) {
            c.a.o0.b1.n0 n0Var = new c.a.o0.b1.n0();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.H);
            c.a.p0.i2.h.e eVar8 = this.v;
            pbLinkGoodsRootView.bindData(eVar8, n0Var.a(eVar8.O().y0(), this.v.O().c0()), this.v.o(), this.n, n0Var.b());
            pbFirstFloorViewHolder.mLinkContainer.addView(pbLinkGoodsRootView);
            pbFirstFloorViewHolder.mLinkContainer.setVisibility(0);
            return;
        }
        pbFirstFloorViewHolder.mLinkContainer.setVisibility(8);
    }

    public final void r0(PbFirstFloorViewHolder pbFirstFloorViewHolder, c.a.o0.s.q.r0 r0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, pbFirstFloorViewHolder, r0Var) == null) || r0Var == null || c.a.e.e.p.k.isEmpty(r0Var.e()) || r0Var.c() != c.a.o0.s.q.r0.f14022g) {
            return;
        }
        if (!r0Var.f()) {
            pbFirstFloorViewHolder.richText.getLayoutStrategy().m(c.a.e.e.p.l.g(this.H, R.dimen.ds48));
        }
        pbFirstFloorViewHolder.mViewStubController.c(r0Var);
    }

    public final void s0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, pbFirstFloorViewHolder, postData) == null) || pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        pbFirstFloorViewHolder.mOrignalThreadRootView.setVisibility(0);
        if (pbFirstFloorViewHolder.mOriginalThreadView == null) {
            pbFirstFloorViewHolder.mOriginalThreadView = v0(postData);
        }
        if (pbFirstFloorViewHolder.mOrignalThreadRootView.getChildCount() <= 0 && (a2 = pbFirstFloorViewHolder.mOriginalThreadView.a()) != null) {
            pbFirstFloorViewHolder.mOrignalThreadRootView.addView(a2);
        }
        pbFirstFloorViewHolder.mOriginalThreadView.e(this.K);
        pbFirstFloorViewHolder.mOriginalThreadView.d(this.L);
        pbFirstFloorViewHolder.mOriginalThreadView.c(postData.J());
        pbFirstFloorViewHolder.mOriginalThreadView.b(this.n.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public void t(c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, eVar) == null) {
            this.v = eVar;
        }
    }

    public final void t0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, pbFirstFloorViewHolder, postData, tbRichText) == null) {
            if (postData != null && postData.O() != null) {
                c.a.p0.i2.p.f.c(postData.O(), pbFirstFloorViewHolder.mTailContent, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.u()));
            } else {
                pbFirstFloorViewHolder.mTailContent.setVisibility(8);
            }
        }
    }

    public final int u0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) ? c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), i2) : invokeI.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c.a.p0.i2.k.e.d1.a v0(PostData postData) {
        InterceptResult invokeL;
        c.a.p0.i2.k.e.d1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048603, this, postData)) != null) {
            return (c.a.p0.i2.k.e.d1.a) invokeL.objValue;
        }
        if (postData != null && postData.J() != null && postData.J().h()) {
            BaijiahaoData baijiahaoData = postData.J().p;
            Item item = postData.J().B;
            if (postData.J().m) {
                aVar = new c.a.p0.i2.k.e.d1.d(this.n.getPageContext(), this.I);
            } else if (item != null && item.item_id.longValue() != 0) {
                if (postData.J().f47195a != 0 && postData.J().f47195a != 1) {
                    if (postData.J().f47195a == 3) {
                        aVar = new c.a.p0.i2.k.e.d1.g(this.n.getPageContext());
                    } else {
                        aVar = new c.a.p0.i2.k.e.d1.e(this.n.getPageContext());
                    }
                } else {
                    aVar = new c.a.p0.i2.k.e.d1.f(this.n.getPageContext());
                }
            } else if (baijiahaoData != null && postData.J().i()) {
                int i2 = baijiahaoData.oriUgcType;
                if (i2 == 1) {
                    aVar = new c.a.p0.i2.k.e.d1.b(this.n.getPageContext(), this.I);
                } else if (i2 == 2) {
                    aVar = new c.a.p0.i2.k.e.d1.i(this.n.getPageContext(), this.I);
                } else if (i2 == 3) {
                    aVar = new c.a.p0.i2.k.e.d1.h(this.n.getPageContext(), this.I);
                } else if (i2 != 4) {
                    aVar = new c.a.p0.i2.k.e.d1.c(this.n.getPageContext(), this.I);
                } else {
                    aVar = new c.a.p0.i2.k.e.d1.i(this.n.getPageContext(), this.I);
                }
            } else if (postData.J().f47195a != 0 && postData.J().f47195a != 1) {
                if (postData.J().f47195a == 3) {
                    aVar = new c.a.p0.i2.k.e.d1.i(this.n.getPageContext(), this.I);
                }
            } else {
                aVar = new c.a.p0.i2.k.e.d1.h(this.n.getPageContext(), this.I);
            }
            return aVar != null ? new c.a.p0.i2.k.e.d1.c(this.n.getPageContext(), this.I) : aVar;
        }
        aVar = null;
        if (aVar != null) {
        }
    }

    public PbFirstFloorViewHolder w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? (PbFirstFloorViewHolder) this.k : (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public final boolean x0(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, c2Var)) == null) ? (c2Var == null || c2Var.G0() == null || c2Var.G0().getOptions() == null || c2Var.G0().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.k.e.a
    /* renamed from: y0 */
    public PbFirstFloorViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, viewGroup)) == null) {
            PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.n.getPageContext(), LayoutInflater.from(this.H).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.t, this.s);
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, pbFirstFloorViewHolder})) == null) {
            super.a0(i2, view, viewGroup, postData, pbFirstFloorViewHolder);
            I0(pbFirstFloorViewHolder);
            D0(pbFirstFloorViewHolder);
            PostData postData2 = (PostData) z(i2);
            if (postData2 != null) {
                postData2.B0();
                postData2.i0 = i2 + 1;
                c.a.p0.i2.m.a.d(this.n.getUniqueId(), this.v, postData2, postData2.i0, 1);
                q0(pbFirstFloorViewHolder, postData2, view, i2);
            }
            if (!this.E && this.F && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.richText.hasLongText() && (listView = this.n.getListView()) != null) {
                this.E = true;
                CompatibleUtile.getInstance().closeViewGpu(listView);
            }
            pbFirstFloorViewHolder.mYoungsterTipTv.setVisibility(c.a.o0.e1.b.e.d() ? 0 : 8);
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
