package c.a.p0.w2.m.f;

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
import c.a.o0.r.r.k2;
import c.a.p0.w2.j.c;
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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
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
/* loaded from: classes3.dex */
public class v extends r<PostData, PbFirstFloorViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbRichTextView.s A;
    public View.OnClickListener B;
    public boolean C;
    public final boolean D;
    public boolean E;
    public Context F;
    public int G;
    public c.a.p0.w2.j.c H;
    public c.a.p0.h0.b0<c.a.o0.r.r.a> I;
    public a.InterfaceC0194a J;
    public int o;
    public boolean p;
    public boolean q;
    public PbModel r;
    public boolean s;
    public c.a.p0.w2.i.f t;
    public c.a.p0.w2.m.h.b u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public TbRichTextView.y x;
    public c.a.p0.w2.j.c y;
    public View.OnLongClickListener z;

    /* loaded from: classes3.dex */
    public class a implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v a;

        public a(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vVar;
        }

        @Override // c.a.p0.w2.j.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.p0.w2.j.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.a.y != null) {
                    this.a.y.a(view);
                    this.a.y.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.p0.w2.j.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, 2));
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c.a.p0.h0.b0<c.a.o0.r.r.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ v f20318b;

        public b(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20318b = vVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.h0.b0
        /* renamed from: d */
        public void a(View view, c.a.o0.r.r.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, aVar) == null) {
                super.a(view, aVar);
                if (aVar == null || aVar.getThreadData() == null || aVar.getThreadData().originalThreadData == null || this.f20318b.t == null) {
                    return;
                }
                OriginalThreadInfo originalThreadInfo = aVar.getThreadData().originalThreadData;
                String Q = this.f20318b.t.Q();
                String str = originalThreadInfo.f29826f;
                int i = 1;
                int i2 = originalThreadInfo.a;
                if (i2 == 3) {
                    i = 2;
                } else if (i2 == 4) {
                    i = 3;
                }
                if (StringUtils.isNull(Q) || StringUtils.isNull(str)) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c12602").param("tid", Q).param("obj_source", str).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.InterfaceC0194a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v a;

        public c(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vVar;
        }

        @Override // c.a.l.a.InterfaceC0194a
        public void a(c.a.o0.r.r.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().originalThreadData == null) {
                return;
            }
            OriginalThreadInfo originalThreadInfo = aVar.getThreadData().originalThreadData;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.F);
            pbActivityConfig.createNormalCfg(originalThreadInfo.f29826f, originalThreadInfo.n, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.f29825e));
            pbActivityConfig.setStartFrom(this.a.G);
            pbActivityConfig.setBjhData(originalThreadInfo.p);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements TbRichTextView.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorViewHolder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PostData f20319b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f20320c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f20321d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f20322e;

        public d(v vVar, PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, pbFirstFloorViewHolder, postData, view, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20322e = vVar;
            this.a = pbFirstFloorViewHolder;
            this.f20319b = postData;
            this.f20320c = view;
            this.f20321d = i;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.v
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.f34880e.getLayoutParams();
                layoutParams.topMargin = this.f20322e.Z(R.dimen.obfuscated_res_0x7f0701be);
                int Z = this.f20322e.Z(R.dimen.obfuscated_res_0x7f07020f);
                layoutParams.bottomMargin = Z;
                layoutParams.leftMargin = Z;
                layoutParams.rightMargin = Z;
                this.a.f34880e.setLayoutParams(layoutParams);
                this.f20322e.h0(this.a, this.f20319b, this.f20320c, this.f20321d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorViewHolder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PostData f20323b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f20324c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f20325d;

        public e(v vVar, PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, pbFirstFloorViewHolder, postData, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFirstFloorViewHolder;
            this.f20323b = postData;
            this.f20324c = str;
            this.f20325d = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.r.m();
                c.a.o0.m0.f.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_CLICK, String.valueOf(this.f20323b.L().h()), this.f20324c, this.f20325d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
    public v(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.p0.w2.q.c) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 0;
        boolean z = true;
        this.p = true;
        this.q = true;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = false;
        int i3 = Build.VERSION.SDK_INT;
        this.D = (i3 < 14 || i3 > 16) ? false : false;
        this.E = false;
        this.G = 0;
        this.H = new c.a.p0.w2.j.c(new a(this));
        this.I = new b(this);
        this.J = new c(this);
        if (pbFragment != null && pbFragment.w() != null) {
            this.G = pbFragment.w().R0();
            this.r = pbFragment.w();
        }
        this.F = pbFragment.getContext();
    }

    public void A0(c.a.p0.w2.j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.y = cVar;
        }
    }

    public void B0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sVar) == null) {
            this.A = sVar;
        }
    }

    public final void C0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbFirstFloorViewHolder) == null) || pbFirstFloorViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbFirstFloorViewHolder.a != skinType) {
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.A, R.color.CAM_X0202);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.f34877b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.f34881f, R.color.CAM_X0204);
            pbFirstFloorViewHolder.f34880e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbFirstFloorViewHolder.m.c();
            pbFirstFloorViewHolder.r.l();
            ThreadForumEnterButtonContainer threadForumEnterButtonContainer = pbFirstFloorViewHolder.w;
            if (threadForumEnterButtonContainer != null) {
                threadForumEnterButtonContainer.a();
            }
            PbBusinessPromotionContainer pbBusinessPromotionContainer = pbFirstFloorViewHolder.x;
            if (pbBusinessPromotionContainer != null) {
                pbBusinessPromotionContainer.h();
            }
            SkinManager.setViewTextColor(pbFirstFloorViewHolder.l, (int) R.color.CAM_X0107);
            pbFirstFloorViewHolder.y.i(skinType);
            VoteView voteView = pbFirstFloorViewHolder.z;
            if (voteView != null) {
                voteView.C(skinType);
            }
            SkinManager.setBackgroundColorToTransparent(pbFirstFloorViewHolder.n, R.color.CAM_X0201, GradientDrawable.Orientation.BOTTOM_TOP);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(pbFirstFloorViewHolder.q);
            d2.A(R.string.F_X01);
            d2.v(R.color.CAM_X0311);
            SkinManager.setBackgroundShapeDrawable(pbFirstFloorViewHolder.o, c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50), R.color.CAM_X0328, R.color.CAM_X0207);
            WebPManager.setPureDrawable(pbFirstFloorViewHolder.p, R.drawable.obfuscated_res_0x7f0808e4, R.color.CAM_X0311, WebPManager.ResourceStateType.NORMAL);
            pbFirstFloorViewHolder.o.getBackground().setAlpha(90);
        }
        pbFirstFloorViewHolder.a = TbadkCoreApplication.getInst().getSkinType();
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PbFirstFloorViewHolder o0 = o0();
            c.a.p0.w2.i.f fVar = this.t;
            if (fVar == null || fVar.O() == null || o0 == null) {
                return;
            }
            o0.e(this.t, this.t.O().getIs_good() == 1, this.t.O().getIs_top() == 1);
        }
    }

    @Override // c.a.p0.w2.m.f.r, c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        s0(i, view, viewGroup, (PostData) obj, (PbFirstFloorViewHolder) viewHolder);
        return view;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.p = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.z = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.w = onClickListener;
        }
    }

    public final void f0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.f34880e.setTextViewOnTouchListener(this.H);
            pbFirstFloorViewHolder.f34880e.setTextViewCheckSelection(false);
        }
    }

    public final void g0(TbRichTextView tbRichTextView, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048586, this, tbRichTextView, view, z) == null) || tbRichTextView == null) {
            return;
        }
        int min = Math.min(((((c.a.d.f.p.n.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - (z ? Z(R.dimen.obfuscated_res_0x7f070275) : 0), this.o);
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
    public final void h0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String str;
        String str2;
        long j;
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048587, this, pbFirstFloorViewHolder, postData, view, i) == null) || this.t == null) {
            return;
        }
        TbRichText tbRichText = null;
        if (postData.A() != 1) {
            if (TextUtils.isEmpty(postData.u())) {
                pbFirstFloorViewHolder.f34880e.setOnClickListener(this.w);
                pbFirstFloorViewHolder.f34880e.setTextViewOnClickListener(this.w);
            } else {
                pbFirstFloorViewHolder.f34880e.setOnClickListener(null);
                pbFirstFloorViewHolder.f34880e.setTextViewOnClickListener(null);
            }
            pbFirstFloorViewHolder.f34877b.setOnClickListener(this.w);
        } else {
            pbFirstFloorViewHolder.f34877b.setOnClickListener(null);
        }
        if (postData.A() == 1) {
            pbFirstFloorViewHolder.d(this.t, this.j.isSimpleForum(), postData.O);
            g0(pbFirstFloorViewHolder.f34880e, view, this.E);
            if (postData.s() != null) {
                long userIdLong = postData.s().getUserIdLong();
                str = postData.s().getUserName();
                j = userIdLong;
                str2 = postData.s().getName_show();
            } else {
                str = null;
                str2 = null;
                j = 0;
            }
            c.a.p0.w2.i.f fVar = this.t;
            if (fVar != null && fVar.O() != null) {
                pbFirstFloorViewHolder.t.b(postData.F(), str, str2, j, c.a.d.f.m.b.g(this.t.O().getId(), 0L), c.a.d.f.m.b.g(postData.G(), 0L));
            }
            if (this.j.S4().G1()) {
                pbFirstFloorViewHolder.f34880e.setVisibility(8);
            }
            c.a.p0.w2.i.f fVar2 = this.t;
            if (fVar2 != null && fVar2.O() != null && this.t.O().getYulePostActivityData() != null) {
                k2 yulePostActivityData = this.t.O().getYulePostActivityData();
                String a2 = yulePostActivityData.a();
                if (StringUtils.isNull(yulePostActivityData.b())) {
                    return;
                }
                if (!StringUtils.isNull(a2)) {
                    pbFirstFloorViewHolder.f34883h.setVisibility(0);
                    pbFirstFloorViewHolder.f34883h.J(a2, 10, true);
                }
            } else {
                pbFirstFloorViewHolder.f34883h.setVisibility(8);
            }
            ThreadSkinView threadSkinView = pbFirstFloorViewHolder.i;
            if (threadSkinView != null) {
                threadSkinView.setVisibility(8);
            }
            c.a.p0.w2.i.f fVar3 = this.t;
            if (fVar3 != null && fVar3.O() != null && this.t.O().isVideoThreadType() && (threadForumEnterButtonContainer = pbFirstFloorViewHolder.w) != null) {
                threadForumEnterButtonContainer.setPadding(threadForumEnterButtonContainer.getPaddingLeft(), c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.w.getPaddingRight(), pbFirstFloorViewHolder.w.getPaddingBottom());
            }
        }
        pbFirstFloorViewHolder.f34880e.getLayoutStrategy().x(R.drawable.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f091e69, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091e85, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091e87, view);
        sparseArray.put(R.id.obfuscated_res_0x7f091e93, Integer.valueOf(i));
        sparseArray.put(R.id.obfuscated_res_0x7f091e92, Integer.valueOf(postData.A()));
        boolean z6 = postData.b0() || postData.a0(false);
        if (z6) {
            if (this.u == null) {
                c.a.p0.w2.m.h.b bVar = new c.a.p0.w2.m.h.b(this.F);
                this.u = bVar;
                bVar.f(this.m);
                this.u.h(this.v);
                c.a.p0.w2.i.f fVar4 = this.t;
                if (fVar4 != null) {
                    this.u.j(this.t.V(), TextUtils.equals(fVar4.O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.u.i(this.t.O());
                }
            }
            this.u.g(postData.G());
        }
        pbFirstFloorViewHolder.f34880e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.p) {
            pbFirstFloorViewHolder.f34880e.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f081200);
        } else {
            pbFirstFloorViewHolder.f34880e.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbFirstFloorViewHolder.f34880e.setIsFromCDN(this.m);
        c.a.p0.w2.i.f fVar5 = this.t;
        if (fVar5 != null && fVar5.O() != null && this.t.O().isLinkThread()) {
            j0(pbFirstFloorViewHolder, this.t.O().getLinkThreadData());
        }
        c.a.p0.w2.i.f fVar6 = this.t;
        if ((fVar6 == null || fVar6.O() == null || !this.t.O().isShareThread || postData.M() == null) ? false : true) {
            if (postData.M().C != null) {
                pbFirstFloorViewHolder.f34880e.getLayoutStrategy().m(m0(R.dimen.tbds24));
            } else {
                pbFirstFloorViewHolder.f34880e.getLayoutStrategy().m(m0(R.dimen.tbds14));
            }
            k0(pbFirstFloorViewHolder, postData);
        } else {
            pbFirstFloorViewHolder.f34880e.getLayoutStrategy().m(m0(R.dimen.tbds24));
        }
        TbRichText N = postData.N();
        c.a.p0.w2.i.f fVar7 = this.t;
        if (fVar7 == null || !fVar7.r0()) {
            tbRichText = N;
        }
        if (this.t.O() != null) {
            pbFirstFloorViewHolder.f34880e.setTid(this.t.Q());
            pbFirstFloorViewHolder.f34880e.setIsUseGridImage(this.t.O().isBJHNormalThreadType());
            pbFirstFloorViewHolder.f34880e.setmIsGridImageSupportLongPress(true);
        }
        c.a.p0.w2.i.f fVar8 = this.t;
        if (fVar8 != null && 3 == fVar8.g()) {
            if (!this.C && this.D) {
                pbFirstFloorViewHolder.f34880e.setText(tbRichText, true, this.A, true, false);
            } else {
                pbFirstFloorViewHolder.f34880e.setText(tbRichText, false, this.A, true, false);
            }
        } else if (!this.C && this.D) {
            pbFirstFloorViewHolder.f34880e.setText(tbRichText, true, this.A, false, true);
        } else {
            pbFirstFloorViewHolder.f34880e.setText(tbRichText, false, this.A, false, true);
        }
        l0(pbFirstFloorViewHolder, postData, tbRichText);
        boolean z7 = !StringUtils.isNull(postData.s().getVirtualUserUrl());
        c.a.p0.w2.i.f fVar9 = this.t;
        if (fVar9 == null || fVar9.V() == 0 || p0()) {
            z = false;
            z2 = false;
        } else {
            if (this.t.V() != 3) {
                z = true;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            if (postData.s() != null) {
                String userId = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        c.a.p0.w2.i.f fVar10 = this.t;
        if (fVar10 != null && fVar10.O() != null && this.t.O().getAuthor() != null && postData.s() != null) {
            String userId2 = this.t.O().getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
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
                if (postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z2 = true;
                    z4 = true;
                }
                if (z7) {
                    z = false;
                    z2 = false;
                    z3 = false;
                }
                int i2 = postData.A() == 1 ? 0 : 1;
                sparseArray.put(R.id.obfuscated_res_0x7f091e79, postData.G());
                if (!z) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091e76, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091e77, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f091e78, postData.s().getPortrait());
                    }
                    c.a.p0.w2.i.f fVar11 = this.t;
                    if (fVar11 != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091e88, Integer.valueOf(fVar11.V()));
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091e80, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091eba, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ebb, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091eb9, postData.s().getName_show());
                    }
                    c.a.p0.w2.i.f fVar12 = this.t;
                    if (fVar12 != null && fVar12.O() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ebd, this.t.O().getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebc, postData.G());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
                }
                if (!z2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ea9, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091e7d, Boolean.valueOf(z6));
                    sparseArray.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(z4));
                    sparseArray.put(R.id.obfuscated_res_0x7f091e6d, Integer.valueOf(i2));
                    sparseArray.put(R.id.obfuscated_res_0x7f091e6b, postData.G());
                    c.a.p0.w2.i.f fVar13 = this.t;
                    if (fVar13 != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091e88, Integer.valueOf(fVar13.V()));
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ea9, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091e81, Boolean.valueOf(z5));
                f0(pbFirstFloorViewHolder);
            }
        }
        z3 = false;
        z4 = false;
        z5 = false;
        if (postData.s() != null) {
            z2 = true;
            z4 = true;
        }
        if (z7) {
        }
        if (postData.A() == 1) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091e79, postData.G());
        if (!z) {
        }
        if (!z3) {
        }
        if (!z2) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091e81, Boolean.valueOf(z5));
        f0(pbFirstFloorViewHolder);
    }

    public final void i0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i) {
        c.a.p0.w2.i.n nVar;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048588, this, pbFirstFloorViewHolder, postData, view, i) == null) || pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        pbFirstFloorViewHolder.f34880e.setTag(sparseArray);
        pbFirstFloorViewHolder.f34877b.setTag(R.id.obfuscated_res_0x7f091e7c, sparseArray);
        sparseArray.put(R.id.obfuscated_res_0x7f091e69, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091e82, Boolean.FALSE);
        pbFirstFloorViewHolder.f34880e.setIsHost(true);
        if (this.q) {
            pbFirstFloorViewHolder.f34881f.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.f34881f.setVisibility(8);
        }
        if (!TextUtils.isEmpty(postData.u()) && this.p) {
            this.E = true;
            pbFirstFloorViewHolder.f34880e.l0(postData.u(), new d(this, pbFirstFloorViewHolder, postData, view, i));
        } else {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.f34880e.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            pbFirstFloorViewHolder.f34880e.setLayoutParams(layoutParams);
            pbFirstFloorViewHolder.f34880e.k0(null);
            this.E = false;
            h0(pbFirstFloorViewHolder, postData, view, i);
        }
        c.a.p0.w2.i.f fVar = this.t;
        if (fVar != null && fVar.O() != null && this.t.O().isVideoThreadType() && this.t.O().getThreadVideoInfo() != null && c.a.d.f.p.m.isEmpty(this.t.l().getName())) {
            pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
        } else if (postData.N() != null && !ListUtils.isEmpty(postData.N().A())) {
            pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
        } else {
            pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
        }
        if (postData.N() != null) {
            if (postData.N().B() > 0) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.m.getLayoutParams();
                layoutParams2.topMargin = Z(R.dimen.tbds26);
                pbFirstFloorViewHolder.m.setLayoutParams(layoutParams2);
            } else {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.m.getLayoutParams();
                layoutParams3.topMargin = Z(R.dimen.tbds16);
                pbFirstFloorViewHolder.m.setLayoutParams(layoutParams3);
            }
        }
        c.a.p0.w2.i.f fVar2 = this.t;
        if (fVar2 != null && q0(fVar2.O())) {
            pbFirstFloorViewHolder.z.setDataForPb(this.t.O().getPollData(), this.t.O().getTid(), this.t.m());
            if (postData.N() != null && !ListUtils.isEmpty(postData.N().A())) {
                pbFirstFloorViewHolder.z.setMarginTop(c.a.d.f.p.n.f(this.F, R.dimen.tbds26));
            } else {
                pbFirstFloorViewHolder.z.setMarginTop(c.a.d.f.p.n.f(this.F, R.dimen.tbds0));
            }
            pbFirstFloorViewHolder.z.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.z.setVisibility(8);
        }
        c.a.p0.w2.i.f fVar3 = this.t;
        if (fVar3 != null && fVar3.O() != null && this.t.O().getSmartApp() != null && this.t.O().getThreadVideoInfo() == null) {
            pbFirstFloorViewHolder.m.setData(this.t.O().getSmartApp());
            pbFirstFloorViewHolder.m.setVisibility(0);
            c.a.p0.w2.i.f fVar4 = this.t;
            if (fVar4 != null && fVar4.l() != null) {
                pbFirstFloorViewHolder.m.setForumId(String.valueOf(this.t.l().getId()));
            }
            c.a.p0.w2.i.f fVar5 = this.t;
            if (fVar5 != null && fVar5.Q() != null) {
                pbFirstFloorViewHolder.m.setThreadId(this.t.Q());
            }
            pbFirstFloorViewHolder.m.setFrom("PB_card");
        } else {
            pbFirstFloorViewHolder.m.setVisibility(8);
        }
        if (NovelPaySwitch.isOn() && postData.L() != null && !postData.L().k() && this.t.j0()) {
            String Q = this.t.Q();
            String m = this.t.m();
            pbFirstFloorViewHolder.r.setData(postData.L(), Q, m);
            pbFirstFloorViewHolder.n.setVisibility(0);
            pbFirstFloorViewHolder.r.setReadMoreButtonState(pbFirstFloorViewHolder.o);
            pbFirstFloorViewHolder.r.setVisibility(0);
            this.s = true;
            if (postData.L().i()) {
                pbFirstFloorViewHolder.o.setVisibility(8);
            } else {
                pbFirstFloorViewHolder.o.setVisibility(0);
                pbFirstFloorViewHolder.q.setText(String.format(Locale.CHINA, this.F.getString(R.string.obfuscated_res_0x7f0f0c94), Long.valueOf(postData.L().j()), String.valueOf(c.a.d.f.m.b.c(postData.L().d(), 0.0d) / 100.0d)));
            }
            pbFirstFloorViewHolder.o.setOnClickListener(new e(this, pbFirstFloorViewHolder, postData, Q, m));
        } else {
            pbFirstFloorViewHolder.n.setVisibility(8);
            pbFirstFloorViewHolder.o.setVisibility(8);
            pbFirstFloorViewHolder.r.setVisibility(8);
        }
        D0();
        c.a.p0.w2.i.f fVar6 = this.t;
        if (fVar6 != null && (nVar = fVar6.f19821h) != null) {
            if (pbFirstFloorViewHolder.l != null) {
                if (TextUtils.isEmpty(nVar.e())) {
                    pbFirstFloorViewHolder.l.setVisibility(8);
                } else {
                    pbFirstFloorViewHolder.l.setVisibility(0);
                    pbFirstFloorViewHolder.l.setText(this.t.f19821h.e());
                }
            }
            if (pbFirstFloorViewHolder.k != null && pbFirstFloorViewHolder.y.h() == null) {
                pbFirstFloorViewHolder.k.addView(pbFirstFloorViewHolder.y.a(this.t));
                String fromPageKey = UtilHelper.getFromPageKey(this.j.getPageContext());
                Context context = this.F;
                if (!(context instanceof AbsPbActivity) || ((AbsPbActivity) context).getIntent() == null) {
                    z = false;
                } else {
                    z = ((AbsPbActivity) this.F).getIntent().getBooleanExtra("is_from_bar_vote", false);
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
        LinearLayout linearLayout = pbFirstFloorViewHolder.s;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        c.a.p0.w2.i.f fVar7 = this.t;
        if (fVar7 != null && fVar7.O() != null && !q0(this.t.O()) && (!ListUtils.isEmpty(this.t.O().getLinkDataList()) || !ListUtils.isEmpty(this.t.O().getGoodsDataList()))) {
            c.a.o0.c1.q0 q0Var = new c.a.o0.c1.q0();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.F);
            c.a.p0.w2.i.f fVar8 = this.t;
            pbLinkGoodsRootView.i(fVar8, q0Var.a(fVar8.O().getLinkDataList(), this.t.O().getGoodsDataList()), this.t.n(), this.j, q0Var.b());
            pbFirstFloorViewHolder.s.addView(pbLinkGoodsRootView);
            pbFirstFloorViewHolder.s.setVisibility(0);
            return;
        }
        pbFirstFloorViewHolder.s.setVisibility(8);
    }

    public final void j0(PbFirstFloorViewHolder pbFirstFloorViewHolder, c.a.o0.r.r.q0 q0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, pbFirstFloorViewHolder, q0Var) == null) || q0Var == null || c.a.d.f.p.m.isEmpty(q0Var.e()) || q0Var.c() != c.a.o0.r.r.q0.f10930g) {
            return;
        }
        if (!q0Var.f()) {
            pbFirstFloorViewHolder.f34880e.getLayoutStrategy().m(c.a.d.f.p.n.f(this.F, R.dimen.obfuscated_res_0x7f0702c4));
        }
        pbFirstFloorViewHolder.t.c(q0Var);
    }

    public final void k0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, pbFirstFloorViewHolder, postData) == null) || pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        pbFirstFloorViewHolder.u.setVisibility(0);
        if (pbFirstFloorViewHolder.v == null) {
            pbFirstFloorViewHolder.v = n0(postData);
        }
        if (pbFirstFloorViewHolder.u.getChildCount() <= 0 && (a2 = pbFirstFloorViewHolder.v.a()) != null) {
            pbFirstFloorViewHolder.u.addView(a2);
        }
        pbFirstFloorViewHolder.v.e(this.I);
        pbFirstFloorViewHolder.v.d(this.J);
        pbFirstFloorViewHolder.v.c(postData.M());
        pbFirstFloorViewHolder.v.b(this.j.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void l0(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, pbFirstFloorViewHolder, postData, tbRichText) == null) {
            if (postData != null && postData.S() != null) {
                c.a.p0.w2.r.h.c(postData.S(), pbFirstFloorViewHolder.j, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.u()));
            } else {
                pbFirstFloorViewHolder.j.setVisibility(8);
            }
        }
    }

    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            this.v = onClickListener;
        }
    }

    public final int m0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) ? c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), i) : invokeI.intValue;
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.o = i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c.a.p0.w2.m.f.l1.a n0(PostData postData) {
        InterceptResult invokeL;
        c.a.p0.w2.m.f.l1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048595, this, postData)) != null) {
            return (c.a.p0.w2.m.f.l1.a) invokeL.objValue;
        }
        if (postData != null && postData.M() != null && postData.M().i()) {
            BaijiahaoData baijiahaoData = postData.M().p;
            Item item = postData.M().C;
            if (!postData.M().m && !postData.F0()) {
                if (item != null && item.item_id.longValue() != 0) {
                    if (postData.M().a != 0 && postData.M().a != 1) {
                        if (postData.M().a == 3) {
                            aVar = new c.a.p0.w2.m.f.l1.g(this.j.getPageContext());
                        } else {
                            aVar = new c.a.p0.w2.m.f.l1.e(this.j.getPageContext());
                        }
                    } else {
                        aVar = new c.a.p0.w2.m.f.l1.f(this.j.getPageContext());
                    }
                } else if (baijiahaoData != null && postData.M().j()) {
                    int i = baijiahaoData.oriUgcType;
                    if (i == 1) {
                        aVar = new c.a.p0.w2.m.f.l1.b(this.j.getPageContext(), this.G);
                    } else if (i == 2) {
                        aVar = new c.a.p0.w2.m.f.l1.i(this.j.getPageContext(), this.G);
                    } else if (i == 3) {
                        aVar = new c.a.p0.w2.m.f.l1.h(this.j.getPageContext(), this.G);
                    } else if (i != 4) {
                        aVar = new c.a.p0.w2.m.f.l1.c(this.j.getPageContext(), this.G);
                    } else {
                        aVar = new c.a.p0.w2.m.f.l1.i(this.j.getPageContext(), this.G);
                    }
                } else if (postData.M().a != 0 && postData.M().a != 1) {
                    if (postData.M().a == 3) {
                        aVar = new c.a.p0.w2.m.f.l1.i(this.j.getPageContext(), this.G);
                    }
                } else {
                    aVar = new c.a.p0.w2.m.f.l1.h(this.j.getPageContext(), this.G);
                }
            } else {
                aVar = new c.a.p0.w2.m.f.l1.d(this.j.getPageContext(), this.G);
            }
            return aVar != null ? new c.a.p0.w2.m.f.l1.c(this.j.getPageContext(), this.G) : aVar;
        }
        aVar = null;
        if (aVar != null) {
        }
    }

    public PbFirstFloorViewHolder o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (PbFirstFloorViewHolder) this.f2573g : (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public void p(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, yVar) == null) {
            this.x = yVar;
        }
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            c.a.p0.w2.i.f fVar = this.t;
            if (fVar == null || fVar.O() == null) {
                return false;
            }
            return this.t.O().isBlocked();
        }
        return invokeV.booleanValue;
    }

    public final boolean q0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, threadData)) == null) ? (threadData == null || threadData.getPollData() == null || threadData.getPollData().getOptions() == null || threadData.getPollData().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: r0 */
    public PbFirstFloorViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, viewGroup)) == null) {
            PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.j.getPageContext(), LayoutInflater.from(this.F).inflate(R.layout.obfuscated_res_0x7f0d05fd, viewGroup, false), this.p, this.o);
            C0(pbFirstFloorViewHolder);
            pbFirstFloorViewHolder.t.f(this.G);
            return pbFirstFloorViewHolder;
        }
        return (PbFirstFloorViewHolder) invokeL.objValue;
    }

    public View s0(int i, View view, ViewGroup viewGroup, PostData postData, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        InterceptResult invokeCommon;
        BdTypeListView listView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), view, viewGroup, postData, pbFirstFloorViewHolder})) == null) {
            super.S(i, view, viewGroup, postData, pbFirstFloorViewHolder);
            C0(pbFirstFloorViewHolder);
            x0(pbFirstFloorViewHolder);
            PostData postData2 = (PostData) z(i);
            if (postData2 != null) {
                postData2.I0();
                postData2.h0 = i + 1;
                c.a.p0.w2.o.a.d(this.j.getUniqueId(), this.t, postData2, postData2.h0, 1);
                i0(pbFirstFloorViewHolder, postData2, view, i);
            }
            if (!this.C && this.D && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.f34880e.G() && (listView = this.j.getListView()) != null) {
                this.C = true;
                CompatibleUtile.getInstance().closeViewGpu(listView);
            }
            pbFirstFloorViewHolder.A.setVisibility(8);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void t(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, fVar) == null) {
            this.t = fVar;
        }
    }

    public void t0(boolean z) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048603, this, z) == null) && (pbModel = this.r) != null && z && this.s) {
            pbModel.k2(3);
        }
    }

    public void u0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (v = this.f2573g) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).t.d();
    }

    public void v0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (v = this.f2573g) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).t.a();
        ((PbFirstFloorViewHolder) this.f2573g).x.g();
        ((PbFirstFloorViewHolder) this.f2573g).r.n();
    }

    public void w0() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (v = this.f2573g) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).t.e();
        ((PbFirstFloorViewHolder) this.f2573g).r.o();
    }

    public final void x0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.f34877b.setOnTouchListener(this.y);
            pbFirstFloorViewHolder.f34877b.setOnLongClickListener(this.z);
            c.a.p0.w2.m.f.k1.a aVar = this.i.x().mEvent;
            pbFirstFloorViewHolder.f34880e.setOnLongClickListener(this.z);
            pbFirstFloorViewHolder.f34880e.setOnTouchListener(this.H);
            pbFirstFloorViewHolder.f34880e.setItemOrderOrDownloadListener(this.B);
            pbFirstFloorViewHolder.f34880e.setIsShowOrderOrDownloadBtn(true);
            pbFirstFloorViewHolder.f34880e.setCommonTextViewOnClickListener(this.w);
            pbFirstFloorViewHolder.f34880e.setOnImageClickListener(this.x);
            pbFirstFloorViewHolder.f34880e.setOnImageTouchListener(this.H);
            pbFirstFloorViewHolder.f34880e.setmGridEmptyClickListener(new f(this));
            pbFirstFloorViewHolder.f34880e.setOnEmotionClickListener(aVar.f20183e);
            pbFirstFloorViewHolder.j.setOnClickListener(this.w);
            pbFirstFloorViewHolder.w.setAfterItemClickListener(this.w);
            pbFirstFloorViewHolder.x.setAfterItemClickListener(this.w);
        }
    }

    public void y0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onClickListener) == null) {
            this.B = onClickListener;
        }
    }

    public void z0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.q = z;
        }
    }
}
