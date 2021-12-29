package c.a.t0.s2.u.f;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.d2;
import c.a.t0.g0.m;
import c.a.t0.s2.s.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class z0 extends n<PostData, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbRichTextView.y A;
    public c.a.t0.s2.s.c B;
    public View.OnLongClickListener C;
    public c.a.t0.s2.u.h.b D;
    public int E;
    public boolean F;
    public int G;
    public boolean H;
    public boolean I;
    public c.a.d.f.k.b<ConstrainImageLayout> J;
    public c.a.d.f.k.b<TbImageView> K;
    public c.a.t0.s2.s.c L;
    public int s;
    public TbRichTextView.s t;
    public boolean u;
    public float v;
    public String w;
    public c.a.t0.s2.r.f x;
    public View.OnClickListener y;
    public View.OnClickListener z;

    /* loaded from: classes8.dex */
    public class a implements c.a.d.f.k.c<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z0 a;

        public a(z0 z0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z0Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.a.f3299e) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements c.a.d.f.k.c<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z0 a;

        public b(z0 z0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z0Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.f3299e);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(c.a.t0.s2.f.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.s2.g.ds1));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }

        public TbImageView h(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbImageView)) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z0 a;

        public c(z0 z0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z0Var;
        }

        @Override // c.a.t0.s2.s.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.t0.s2.s.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.a.B != null) {
                    if (!(view instanceof TbListTextView) || this.a.z == null) {
                        this.a.B.a(view);
                        this.a.B.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    this.a.z.onClick(view);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.t0.s2.s.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (view == null || !((pbFragment = this.a.n) == null || pbFragment.getPbView() == null || this.a.n.getPbView().v1())) {
                    return true;
                }
                if (view instanceof RelativeLayout) {
                    this.a.p0(view);
                } else {
                    ViewParent parent = view.getParent();
                    int i2 = 0;
                    while (true) {
                        if (parent == null || i2 >= 10) {
                            break;
                        } else if (parent instanceof RelativeLayout) {
                            this.a.p0((RelativeLayout) parent);
                            break;
                        } else {
                            parent = parent.getParent();
                            i2++;
                        }
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f23759e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ z0 f23760f;

        public d(z0 z0Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z0Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23760f = z0Var;
            this.f23759e = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundColor(this.f23759e.pbItemViewRoot, c.a.t0.s2.f.CAM_X0205);
                c.a.t0.s2.y.b bVar = this.f23760f.m;
                if (bVar == null || bVar.getPbModel() == null) {
                    return;
                }
                this.f23760f.m.getPbModel().X();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f23761e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PostData f23762f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ z0 f23763g;

        public e(z0 z0Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z0Var, pbCommenFloorItemViewHolder, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23763g = z0Var;
            this.f23761e = pbCommenFloorItemViewHolder;
            this.f23762f = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean z = this.f23761e.mAllContent.getVisibility() == 8;
                this.f23763g.n0(this.f23761e, !z, this.f23762f.D());
                this.f23762f.s0(!z);
                this.f23763g.L0(this.f23761e, this.f23762f);
                PbFragment pbFragment = this.f23763g.n;
                if (pbFragment == null || pbFragment.getPbView() == null || this.f23763g.n.getPbView().Y0() == null || this.f23763g.n.getPbView().E0() == null || z || this.f23761e.getView().getTop() >= this.f23763g.n.getPbView().Y0().getMeasuredHeight()) {
                    return;
                }
                this.f23763g.n.getPbView().E0().setSelectionFromTop(ListUtils.getPosition(this.f23763g.n.getPbView().E0().getData(), this.f23762f) + this.f23763g.n.getPbView().E0().getHeaderViewsCount(), this.f23763g.n.getPbView().Y0().getMeasuredHeight());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f23764e;

        public f(z0 z0Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z0Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23764e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23764e.mCommentView.performClick();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f23765e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.s2.u.f.d1.c f23766f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ z0 f23767g;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostData f23768e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f23769f;

            public a(g gVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23769f = gVar;
                this.f23768e = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.f23769f;
                    gVar.f23766f.f23437b.a(gVar.f23767g.x, null, this.f23768e, gVar.f23765e.mRichTextView.getLayoutStrategy());
                }
            }
        }

        public g(z0 z0Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, c.a.t0.s2.u.f.d1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z0Var, pbCommenFloorItemViewHolder, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23767g = z0Var;
            this.f23765e = pbCommenFloorItemViewHolder;
            this.f23766f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (!(sparseArray.get(c.a.t0.s2.i.tag_load_sub_data) instanceof PostData) || (postData = (PostData) sparseArray.get(c.a.t0.s2.i.tag_load_sub_data)) == null || this.f23765e.pbItemViewRoot == null || this.f23766f == null) {
                    return;
                }
                c.a.d.f.m.e.a().postDelayed(new a(this, postData), 100L);
                String Q = this.f23767g.x.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.f23767g.x.Q())) && this.f23767g.x.O() != null) {
                    Q = this.f23767g.x.O().G0();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.f23767g.x.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.G()).param("obj_source", this.f23767g.H0(view)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f23770e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ z0 f23771f;

        public h(z0 z0Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z0Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23771f = z0Var;
            this.f23770e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f23771f.x == null || (pbCommenFloorItemViewHolder = this.f23770e) == null || (agreeView = pbCommenFloorItemViewHolder.mPbFloorPraiseView) == null || agreeView.getData() == null) {
                return;
            }
            int i2 = view == this.f23770e.mPbFloorPraiseView.getImgAgree() ? 1 : 2;
            String Q = this.f23771f.x.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.f23771f.x.Q())) && this.f23771f.x.O() != null) {
                Q = this.f23771f.x.O().G0();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.f23771f.x.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f23770e.mPbFloorPraiseView.getData().postId).param("obj_source", this.f23771f.H0(this.f23770e.mPbFloorPraiseView)).param("obj_type", i2));
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
            statisticItem.param("fid", this.f23771f.x.m());
            statisticItem.param("tid", this.f23771f.x.Q());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("post_id", this.f23771f.x.j().G());
            statisticItem.param("obj_source", 1);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_locate", this.f23771f.F0());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f23772e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ z0 f23773f;

        public i(z0 z0Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z0Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23773f = z0Var;
            this.f23772e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f23773f.x == null || (pbCommenFloorItemViewHolder = this.f23772e) == null || (agreeView = pbCommenFloorItemViewHolder.mPbRightTopAgreeView) == null || agreeView.getData() == null) {
                return;
            }
            int i2 = view == this.f23772e.mPbRightTopAgreeView.getImgAgree() ? 1 : 2;
            String Q = this.f23773f.x.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.f23773f.x.Q())) && this.f23773f.x.O() != null) {
                Q = this.f23773f.x.O().G0();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.f23773f.x.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f23772e.mPbRightTopAgreeView.getData().postId).param("obj_source", this.f23773f.H0(this.f23772e.mPbRightTopAgreeView)).param("obj_type", i2));
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
            statisticItem.param("fid", this.f23773f.x.m());
            statisticItem.param("tid", this.f23773f.x.Q());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("post_id", this.f23773f.x.j().G());
            statisticItem.param("obj_source", 1);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_locate", this.f23773f.F0());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(c.a.t0.s2.y.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.t0.s2.y.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = 0;
        this.t = null;
        this.u = true;
        this.v = 1.0f;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.F = true;
        this.H = true;
        this.I = false;
        this.J = new c.a.d.f.k.b<>(new a(this), 6, 0);
        this.K = new c.a.d.f.k.b<>(new b(this), 12, 0);
        this.L = new c.a.t0.s2.s.c(new c(this));
        if (bVar != null && bVar.getPbModel() != null) {
            this.G = bVar.getPbModel().Q0();
        }
        this.s = Z(c.a.t0.s2.g.tbds14);
    }

    public final void A0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.pbItemViewRoot == null) {
            return;
        }
        c.a.t0.s2.y.b bVar = this.m;
        if (bVar != null && bVar.getPbModel() != null && this.m.getPbModel().B1() && StringHelper.equals(this.m.getPbModel().t0(), postData.G())) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.pbItemViewRoot, c.a.t0.s2.f.CAM_X0313);
            return;
        }
        c.a.t0.s2.y.b bVar2 = this.m;
        if (bVar2 != null && bVar2.getPbModel() != null && StringHelper.equals(this.m.getPbModel().s0(), postData.G())) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.pbItemViewRoot, c.a.t0.s2.f.CAM_X0313);
            c.a.d.f.m.e.a().postDelayed(new d(this, pbCommenFloorItemViewHolder), 3000L);
            return;
        }
        SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.pbItemViewRoot, c.a.t0.s2.f.CAM_X0205);
    }

    public final void B0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.S() != null) {
                TbRichText N = postData.N();
                c.a.t0.s2.z.g.c(postData.S(), pbCommenFloorItemViewHolder.mTailContent, false, false, N != null && StringUtils.isNull(N.toString()) && StringUtils.isNull(postData.u()));
                return;
            }
            pbCommenFloorItemViewHolder.mTailContent.setVisibility(8);
        }
    }

    public final void C0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData.E() != 2 && postData.E() != 4) {
                pbCommenFloorItemViewHolder.mFoldOpArea.setVisibility(8);
                pbCommenFloorItemViewHolder.mAllContent.setVisibility(0);
                o0(false, pbCommenFloorItemViewHolder, postData);
            } else {
                pbCommenFloorItemViewHolder.mFoldOpArea.setOnClickListener(new e(this, pbCommenFloorItemViewHolder, postData));
                pbCommenFloorItemViewHolder.mFoldOpArea.setVisibility(0);
                n0(pbCommenFloorItemViewHolder, postData.d0(), postData.D());
                o0(true, pbCommenFloorItemViewHolder, postData);
            }
            L0(pbCommenFloorItemViewHolder, postData);
        }
    }

    public final void D0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.updateUegInfo(postData.U, postData.G(), this.I);
    }

    /* JADX WARN: Removed duplicated region for block: B:243:0x0681  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x068c  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x068f  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x06dc  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x073e  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0747  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0786  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void E0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048580, this, pbCommenFloorItemViewHolder, postData, view, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.t() != null) {
            postData.t().isBaijiahaoUser();
        }
        if (postData.T) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.mTopLine, c.a.t0.s2.f.CAM_X0204);
            pbCommenFloorItemViewHolder.mTopLine.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.mTopLine.setVisibility(8);
        }
        d2 d2Var = null;
        pbCommenFloorItemViewHolder.mHeadPhotoView.setTag(null);
        pbCommenFloorItemViewHolder.mHeadPhotoView.setUserId(null);
        pbCommenFloorItemViewHolder.mUserNameView.setText((CharSequence) null);
        pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.mRichTextView.setIsHost(false);
        if (postData.t() != null) {
            String str = this.w;
            if (str != null && !"0".equals(str) && this.w.equals(postData.t().getUserId())) {
                pbCommenFloorItemViewHolder.mRichTextView.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.t().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.t().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.mTshowIconBox;
            if (userIconBox != null) {
                userIconBox.setTag(c.a.t0.s2.i.tag_user_id, postData.t().getUserId());
                c.a.t0.s2.y.b bVar = this.m;
                if (bVar != null && bVar.getPbActivity() != null) {
                    pbCommenFloorItemViewHolder.mTshowIconBox.setOnClickListener(this.m.getPbActivity().mEvent.f23415c);
                }
                int f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.tbds40);
                pbCommenFloorItemViewHolder.mTshowIconBox.loadIcon(iconInfo, 2, f2, f2, c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.tbds10));
            }
            if (pbCommenFloorItemViewHolder.mVipIconBox != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.mVipIconBox.setTag(tShowInfoNew.get(0).getUrl());
                }
                c.a.t0.s2.y.b bVar2 = this.m;
                if (bVar2 != null && bVar2.getPbActivity() != null) {
                    pbCommenFloorItemViewHolder.mVipIconBox.setOnClickListener(this.m.getPbActivity().mEvent.f23416d);
                }
                int f3 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.tbds48);
                pbCommenFloorItemViewHolder.mVipIconBox.loadIcon(tShowInfoNew, 3, f3, f3, c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.t().isBigV()) {
                if (c.a.s0.b.d.N()) {
                    if (DeviceInfoUtil.isMate30()) {
                        r0.k(pbCommenFloorItemViewHolder.mUserNameView);
                    } else {
                        c.a.s0.s.u.c.d(pbCommenFloorItemViewHolder.mUserNameView).A(c.a.t0.s2.l.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, c.a.t0.s2.f.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, c.a.t0.s2.f.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, c.a.t0.s2.f.CAM_X0301, 1);
            }
            String avater = postData.t().getAvater();
            int i3 = postData.e0 ? 2 : 8;
            pbCommenFloorItemViewHolder.mUserNameView.setTag(c.a.t0.s2.i.tag_user_id, postData.t().getUserId());
            pbCommenFloorItemViewHolder.mUserNameView.setTag(c.a.t0.s2.i.tag_user_name, postData.t().getUserName());
            pbCommenFloorItemViewHolder.mUserNameView.setTag(c.a.t0.s2.i.tag_virtual_user_url, postData.t().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.mUserNameView.setTag(c.a.t0.s2.i.tag_statistic_item, c.a.t0.s2.w.a.i(this.x, postData, postData.f0, i3, 2));
            String name_show = postData.t().getName_show();
            String userName = postData.t().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.mUserNameView.setText(c.a.t0.s2.c.b(this.f3299e, pbCommenFloorItemViewHolder.mUserNameView.getText().toString()));
                pbCommenFloorItemViewHolder.mUserNameView.setGravity(16);
                pbCommenFloorItemViewHolder.mUserNameView.setTag(c.a.t0.s2.i.tag_nick_name_activity, c.a.t0.s2.c.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, c.a.t0.s2.f.CAM_X0312, 1);
            }
            if (postData.t().getPendantData() != null && !StringUtils.isNull(postData.t().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.mPendantHeadView.setBigVDimenSize(c.a.t0.s2.g.tbds36);
                pbCommenFloorItemViewHolder.mPendantHeadView.showHeadPendantAndBigV(postData.t(), 4);
                pbCommenFloorItemViewHolder.mHeadPhotoView.setVisibility(8);
                pbCommenFloorItemViewHolder.mPendantHeadView.setVisibility(0);
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().startLoad(avater, 28, false);
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setUserId(postData.t().getUserId());
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setUserName(postData.t().getUserName());
                c.a.t0.s2.r.f fVar = this.x;
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setFid(fVar != null ? fVar.m() : "");
                c.a.t0.s2.r.f fVar2 = this.x;
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setFName(fVar2 != null ? fVar2.n() : "");
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setFloor(postData.A());
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setTid(postData.G());
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setTag(c.a.t0.s2.i.tag_statistic_item, c.a.t0.s2.w.a.i(this.x, postData, postData.f0, i3, 2));
                pbCommenFloorItemViewHolder.mPendantHeadView.startLoadPendantUrl(postData.t().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.mHeadPhotoView.setGodIconWidth(c.a.t0.s2.g.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.mHeadPhotoView, postData.t(), 4);
                pbCommenFloorItemViewHolder.mHeadPhotoView.setUserId(postData.t().getUserId());
                c.a.t0.s2.r.f fVar3 = this.x;
                pbCommenFloorItemViewHolder.mHeadPhotoView.setFid(fVar3 != null ? fVar3.m() : "");
                c.a.t0.s2.r.f fVar4 = this.x;
                pbCommenFloorItemViewHolder.mHeadPhotoView.setFName(fVar4 != null ? fVar4.n() : "");
                pbCommenFloorItemViewHolder.mHeadPhotoView.setFloor(postData.A());
                pbCommenFloorItemViewHolder.mHeadPhotoView.setTid(postData.G());
                pbCommenFloorItemViewHolder.mHeadPhotoView.setUserName(postData.t().getUserName(), postData.X());
                pbCommenFloorItemViewHolder.mHeadPhotoView.setTag(c.a.t0.s2.i.tag_virtual_user_url, postData.t().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.mHeadPhotoView.setTag(c.a.t0.s2.i.tag_statistic_item, c.a.t0.s2.w.a.i(this.x, postData, postData.f0, i3, 2));
                pbCommenFloorItemViewHolder.mHeadPhotoView.setImageDrawable(null);
                pbCommenFloorItemViewHolder.mHeadPhotoView.startLoad(avater, 28, false);
                pbCommenFloorItemViewHolder.mHeadPhotoView.setVisibility(0);
                pbCommenFloorItemViewHolder.mPendantHeadView.setVisibility(8);
            }
            if (postData.t() != null && postData.t().getAlaInfo() != null && postData.t().getAlaUserData() != null && postData.t().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.handleUserAlaLiveState(true);
                pbCommenFloorItemViewHolder.mHeadPhotoView.setLiveStatus(1);
                pbCommenFloorItemViewHolder.mHeadPhotoView.setAlaInfo(postData.t().getAlaInfo());
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setAlaInfo(postData.t().getAlaInfo());
            } else {
                pbCommenFloorItemViewHolder.handleUserAlaLiveState(false);
                pbCommenFloorItemViewHolder.mHeadPhotoView.setLiveStatus(0);
                pbCommenFloorItemViewHolder.mHeadPhotoView.setAlaInfo(null);
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setAlaInfo(null);
            }
            U0(pbCommenFloorItemViewHolder.mFloorAuthorView, postData);
        }
        c.a.t0.s2.y.b bVar3 = this.m;
        int level_id = (bVar3 == null || bVar3.getPbActivity() == null || !this.m.getPbActivity().isSimpleForum() || postData.t() == null) ? 0 : postData.t().getLevel_id();
        c.a.t0.s2.r.f fVar5 = this.x;
        if (fVar5 != null && fVar5.g0()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbCommenFloorItemViewHolder.mForumLevelIcon.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.mForumLevelIcon, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.mForumLevelIcon.setVisibility(8);
        }
        int i4 = 15;
        if (pbCommenFloorItemViewHolder.mTshowIconBox.getChildCount() == 1) {
            i4 = 13;
        } else if (pbCommenFloorItemViewHolder.mTshowIconBox.getChildCount() > 1) {
            i4 = 11;
        }
        if (pbCommenFloorItemViewHolder.mFloorAuthorView.getVisibility() == 0) {
            i4 -= 2;
        }
        if (pbCommenFloorItemViewHolder.mVipIconBox.getChildCount() > 0) {
            i4 -= 2;
        }
        if (postData.w() > 1000) {
            i4 -= 2;
        }
        if (postData.w() > 10) {
            i4 -= 2;
        }
        if (i4 < 10) {
            pbCommenFloorItemViewHolder.mTshowIconBox.setVisibility(8);
            if (pbCommenFloorItemViewHolder.mTshowIconBox.getChildCount() == 1) {
                i4 += 2;
            } else if (pbCommenFloorItemViewHolder.mTshowIconBox.getChildCount() > 1) {
                i4 += 4;
            }
            if (i4 < 10 && pbCommenFloorItemViewHolder.mFloorAuthorView.getVisibility() == 0) {
                i4 += 2;
                pbCommenFloorItemViewHolder.mFloorAuthorView.setVisibility(8);
            }
            if (i4 < 10 && pbCommenFloorItemViewHolder.mForumLevelIcon.getVisibility() == 0) {
                i4 += 2;
                pbCommenFloorItemViewHolder.mForumLevelIcon.setVisibility(8);
            }
        }
        String name_show2 = postData.t() != null ? postData.t().getName_show() : "";
        int d2 = c.a.s0.e1.o0.d(name_show2);
        if (postData.t() != null && !StringUtils.isNull(postData.t().getSealPrefix())) {
            int i5 = i4 - 2;
            if (d2 > i5) {
                name_show2 = c.a.s0.e1.o0.m(name_show2, i5) + "...";
            }
        } else if (d2 > i4) {
            name_show2 = c.a.s0.e1.o0.m(name_show2, i4) + "...";
        }
        if (postData.t() != null && !StringUtils.isNull(postData.t().getSealPrefix())) {
            pbCommenFloorItemViewHolder.mUserNameView.setText(G0(postData.t().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.mUserNameView.setText(name_show2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(c.a.t0.s2.i.tag_clip_board, postData);
        sparseArray.put(c.a.t0.s2.i.tag_load_sub_data, postData);
        sparseArray.put(c.a.t0.s2.i.tag_load_sub_view, view);
        sparseArray.put(c.a.t0.s2.i.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(c.a.t0.s2.i.tag_pb_floor_number, Integer.valueOf(postData.A()));
        sparseArray.put(c.a.t0.s2.i.tag_forbid_user_post_id, postData.G());
        sparseArray.put(c.a.t0.s2.i.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.mPbFloorPraiseView);
        sparseArray.put(c.a.t0.s2.i.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.mPbRightTopAgreeView);
        sparseArray.put(c.a.t0.s2.i.pb_dialog_item_reply, pbCommenFloorItemViewHolder.mCommentView);
        sparseArray.put(c.a.t0.s2.i.pb_dialog_item_share, pbCommenFloorItemViewHolder.mShareView);
        c.a.t0.s2.r.f fVar6 = this.x;
        if (fVar6 != null && fVar6.O() != null) {
            d2Var = this.x.O();
        }
        if (d2Var != null && d2Var.G2()) {
            sparseArray.put(c.a.t0.s2.i.pb_dialog_item_isugc, Boolean.TRUE);
        } else {
            sparseArray.put(c.a.t0.s2.i.pb_dialog_item_isugc, Boolean.FALSE);
        }
        boolean z7 = (postData.t() == null || StringUtils.isNull(postData.t().getVirtualUserUrl())) ? false : true;
        c.a.t0.s2.r.f fVar7 = this.x;
        if (fVar7 == null || fVar7.V() == 0 || I0()) {
            z = false;
            z2 = false;
        } else {
            z = (this.x.V() == 1002 || this.x.V() == 3) ? false : true;
            z2 = (this.x.V() == 3 || this.x.g0()) ? false : true;
            if (postData != null && postData.t() != null) {
                String userId = postData.t().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || "0".equals(userId) || userId.length() == 0) {
                    z = false;
                }
            }
        }
        c.a.t0.s2.r.f fVar8 = this.x;
        if (fVar8 != null && fVar8.O() != null && this.x.O().J() != null && postData.t() != null) {
            String userId2 = this.x.O().J().getUserId();
            String userId3 = postData.t().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z4 = false;
                    z5 = true;
                } else {
                    z4 = true;
                    z5 = false;
                }
                z3 = true;
                z6 = true;
                if (postData != null && postData.t() != null && UtilHelper.isCurrentAccount(postData.t().getUserId())) {
                    z5 = true;
                    z3 = true;
                }
                if (z7) {
                    z = false;
                    z4 = false;
                    z3 = false;
                }
                int i6 = postData.A() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(c.a.t0.s2.i.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(c.a.t0.s2.i.tag_manage_user_identity, Integer.valueOf(this.x.V()));
                    if (postData.t() != null) {
                        sparseArray.put(c.a.t0.s2.i.tag_forbid_user_name, postData.t().getUserName());
                        sparseArray.put(c.a.t0.s2.i.tag_forbid_user_name_show, postData.t().getName_show());
                        sparseArray.put(c.a.t0.s2.i.tag_forbid_user_portrait, postData.t().getPortrait());
                    }
                } else {
                    sparseArray.put(c.a.t0.s2.i.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(c.a.t0.s2.i.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.t() != null) {
                        sparseArray.put(c.a.t0.s2.i.tag_user_mute_mute_userid, postData.t().getUserId());
                        sparseArray.put(c.a.t0.s2.i.tag_user_mute_mute_username, postData.t().getUserName());
                        sparseArray.put(c.a.t0.s2.i.tag_user_mute_mute_nameshow, postData.t().getName_show());
                    }
                    if (this.x.O() != null) {
                        sparseArray.put(c.a.t0.s2.i.tag_user_mute_thread_id, this.x.O().g0());
                    }
                    sparseArray.put(c.a.t0.s2.i.tag_user_mute_post_id, postData.G());
                } else {
                    sparseArray.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray.put(c.a.t0.s2.i.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(c.a.t0.s2.i.tag_has_sub_post, Boolean.valueOf(postData.b0()));
                    sparseArray.put(c.a.t0.s2.i.tag_manage_user_identity, Integer.valueOf(this.x.V()));
                    sparseArray.put(c.a.t0.s2.i.tag_del_post_is_self, Boolean.valueOf(z5));
                    sparseArray.put(c.a.t0.s2.i.tag_del_post_type, Integer.valueOf(i6));
                    sparseArray.put(c.a.t0.s2.i.tag_del_post_id, postData.G());
                } else {
                    sparseArray.put(c.a.t0.s2.i.tag_should_delete_visible, Boolean.FALSE);
                }
                sparseArray.put(c.a.t0.s2.i.tag_is_self_post, Boolean.valueOf(z6));
                pbCommenFloorItemViewHolder.mRichTextView.setTag(sparseArray);
            }
        }
        z3 = z2;
        z4 = false;
        z5 = false;
        z6 = false;
        if (postData != null) {
            z5 = true;
            z3 = true;
        }
        if (z7) {
        }
        if (postData.A() != 1) {
        }
        if (!z) {
        }
        if (!z4) {
        }
        if (!z3) {
        }
        sparseArray.put(c.a.t0.s2.i.tag_is_self_post, Boolean.valueOf(z6));
        pbCommenFloorItemViewHolder.mRichTextView.setTag(sparseArray);
    }

    public int F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.E : invokeV.intValue;
    }

    public final SpannableStringBuilder G0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new m.a(str, c.a.t0.s2.h.pic_smalldot_title));
            return c.a.t0.g0.m.h(this.m.getPbActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final String H0(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                return "1";
            }
            Object obj = sparseArray.get(c.a.t0.s2.i.pb_track_more_obj_source);
            String str = obj != null ? obj : "1";
            sparseArray.remove(c.a.t0.s2.i.pb_track_more_obj_source);
            view.setTag(sparseArray);
            return str.toString();
        }
        return (String) invokeL.objValue;
    }

    public final boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.t0.s2.r.f fVar = this.x;
            if (fVar == null || fVar.O() == null) {
                return false;
            }
            return this.x.O().V1();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: J0 */
    public PbCommenFloorItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f3299e).inflate(c.a.t0.s2.j.pb_reply_floor_item_layout, viewGroup, false);
            ((ViewGroup) inflate.findViewById(c.a.t0.s2.i.pb_post_reply_container)).addView(LayoutInflater.from(inflate.getContext()).inflate(c.a.t0.s2.j.pb_op_stragtery_default, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.m.getPbActivity().getPageContext(), inflate, this.G);
            pbCommenFloorItemViewHolder.mImagesView.setConstrainLayoutPool(this.J);
            pbCommenFloorItemViewHolder.mImagesView.setImageViewPool(this.K);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.mReplyContentView;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.H);
                pbCommenFloorItemViewHolder.mReplyContentView.setIsVideoThread(true);
            }
            S0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.mRichTextView;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.F);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View K0(int i2, View view, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            super.S(i2, view, viewGroup, postData, pbCommenFloorItemViewHolder);
            S0(pbCommenFloorItemViewHolder);
            O0(pbCommenFloorItemViewHolder);
            j0(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) z(i2);
            if (postData2 != null) {
                postData2.f0 = i2 + 1;
                l0(postData2);
                k0(postData2);
                postData2.I0();
                q0(postData2);
                v0(pbCommenFloorItemViewHolder, postData2, view, i2);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void L0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, pbCommenFloorItemViewHolder, postData) == null) {
            TbRichText N = postData.N();
            N.isChanged = true;
            pbCommenFloorItemViewHolder.mRichTextView.setText(N, true, this.t);
        }
    }

    public final void M0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, postData) == null) {
            String userId = postData.t().getUserId();
            c.a.t0.s2.r.f fVar = this.x;
            String m = fVar != null ? fVar.m() : "";
            c.a.t0.s2.r.f fVar2 = this.x;
            String n = fVar2 != null ? fVar2.n() : "";
            int A = postData.A();
            String G = postData.G();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", m);
            statisticItem.param("fname", n);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", G);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, A);
            if (postData.t().getAlaInfo() != null) {
                AlaInfoData alaInfo = postData.t().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void N0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.E = i2;
        }
    }

    public final void O0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.pbItemViewRoot.setOnTouchListener(this.L);
            pbCommenFloorItemViewHolder.pbItemViewRoot.setOnLongClickListener(this.C);
            if (this.m.getPbActivity() == null || this.m.getPbActivity().getPageContext() == null || this.m.getPbActivity().getPageContext().getOrignalPage() == null) {
                return;
            }
            c.a.t0.s2.u.f.d1.a aVar = this.m.getPbActivity().mEvent;
            pbCommenFloorItemViewHolder.mUserNameView.setOnClickListener(aVar.f23414b);
            pbCommenFloorItemViewHolder.mHeadPhotoView.setOnClickListener(aVar.f23414b);
            pbCommenFloorItemViewHolder.mPendantHeadView.setOnClickListener(aVar.f23414b);
            pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setOnClickListener(aVar.f23414b);
            pbCommenFloorItemViewHolder.mRichTextView.setOnLongClickListener(this.C);
            pbCommenFloorItemViewHolder.mRichTextView.setOnTouchListener(this.L);
            pbCommenFloorItemViewHolder.mRichTextView.setCommonTextViewOnClickListener(this.z);
            pbCommenFloorItemViewHolder.mRichTextView.setOnImageClickListener(this.A);
            pbCommenFloorItemViewHolder.mRichTextView.setOnImageTouchListener(this.L);
            pbCommenFloorItemViewHolder.mRichTextView.setOnEmotionClickListener(aVar.f23417e);
            pbCommenFloorItemViewHolder.mRichTextView.setOnVoiceAfterClickListener(this.z);
            pbCommenFloorItemViewHolder.mTailContent.setOnClickListener(this.z);
            pbCommenFloorItemViewHolder.mRecommendLiveLayout.setOnClickListener(this.z);
            pbCommenFloorItemViewHolder.mReplyCountView.setOnClickListener(this.z);
            pbCommenFloorItemViewHolder.mReplyView.setOnClickListener(this.z);
            pbCommenFloorItemViewHolder.mPbRightTopMoreView.setOnClickListener(this.z);
            pbCommenFloorItemViewHolder.mBtnOpMore.setOnClickListener(this.z);
            pbCommenFloorItemViewHolder.mPbPostReplyLayoutAbove.setOnClickListener(new f(this, pbCommenFloorItemViewHolder));
            c.a.t0.s2.u.f.d1.c cVar = this.m.getPbActivity().mPostShareController;
            pbCommenFloorItemViewHolder.mCommentView.setOnClickListener(this.z);
            pbCommenFloorItemViewHolder.mShareView.setOnClickListener(new g(this, pbCommenFloorItemViewHolder, cVar));
            pbCommenFloorItemViewHolder.mPbFloorPraiseView.mAfterManualClickListener = new h(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.mPbRightTopAgreeView.mAfterManualClickListener = new i(this, pbCommenFloorItemViewHolder);
        }
    }

    public void P0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.v = f2;
        }
    }

    public void Q0(c.a.t0.s2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) {
            this.B = cVar;
        }
    }

    public void R0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, sVar) == null) {
            this.t = sVar;
        }
    }

    @Override // c.a.t0.s2.u.f.n, c.a.d.n.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        K0(i2, view, viewGroup, (PostData) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view;
    }

    public final void S0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, pbCommenFloorItemViewHolder) == null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.mSkinType != skinType) {
            T0(pbCommenFloorItemViewHolder.mFloorAuthorView);
            if (c.a.s0.b.d.N()) {
                if (DeviceInfoUtil.isMate30()) {
                    r0.k(pbCommenFloorItemViewHolder.mUserNameView);
                } else {
                    c.a.s0.s.u.c.d(pbCommenFloorItemViewHolder.mUserNameView).A(c.a.t0.s2.l.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, c.a.t0.s2.f.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, c.a.t0.s2.f.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mReplyTimeView, c.a.t0.s2.f.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mPointRightFloor, c.a.t0.s2.f.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mPointRightPostTime, c.a.t0.s2.f.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mFloorNum, c.a.t0.s2.f.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mLocationView, c.a.t0.s2.f.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mReplyView, c.a.t0.s2.f.CAM_X0108);
            pbCommenFloorItemViewHolder.mRichTextView.setTextColor(SkinManager.getColor(c.a.t0.s2.f.CAM_X0105));
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mViewPostTimeAbove, c.a.t0.s2.f.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mBtnPostAbove, c.a.t0.s2.f.CAM_X0107, 1);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.mReplyContentView;
            int f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.tbds21);
            int i2 = c.a.t0.s2.f.CAM_X0206;
            SkinManager.setBackgroundShapeDrawable(subPbLayout, f2, i2, i2);
            SkinManager.getColor(c.a.t0.s2.f.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mReplyCountView, c.a.t0.s2.f.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mReplyCountView, c.a.t0.s2.f.CAM_X0304);
            pbCommenFloorItemViewHolder.mReplyCountView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(c.a.t0.s2.h.icon_pure_arrow12_right, SkinManager.getColor(c.a.t0.s2.f.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.mCommentView, c.a.t0.s2.h.icon_pure_pb_reply18, c.a.t0.s2.f.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.mShareView, c.a.t0.s2.h.icon_pure_pb_share18, c.a.t0.s2.f.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.mReplyContentView.onChangeSkinType();
            pbCommenFloorItemViewHolder.mImagesView.onChangeSkinType();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mRecommendLiveTitleView, c.a.t0.s2.f.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mRecommendLivePrefixTv, c.a.t0.s2.f.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.mRecommendLiveLayout, c.a.t0.s2.f.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.mRecommendLiveDividerView, c.a.t0.s2.f.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.mRecommendLiveArrowView, c.a.t0.s2.h.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mFoldTitleView, c.a.t0.s2.f.CAM_X0107);
            if (pbCommenFloorItemViewHolder.mAllContent.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.mFoldTitleView.setText(c.a.t0.s2.l.close_content);
            } else {
                c.a.t0.s2.r.f fVar = this.x;
                if (fVar != null && StringUtils.isNull(fVar.k())) {
                    pbCommenFloorItemViewHolder.mFoldTitleView.setText(this.x.k());
                } else {
                    pbCommenFloorItemViewHolder.mFoldTitleView.setText(c.a.t0.s2.l.expand_content);
                }
            }
            pbCommenFloorItemViewHolder.mPbFloorPraiseView.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.handleUserAlaLiveSkinType(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.mBottomLine, c.a.t0.s2.f.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.mPbRightTopMoreView, c.a.t0.s2.h.icon_pure_pb_more18, c.a.t0.s2.f.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.mBtnOpMore, c.a.t0.s2.h.icon_pure_pb_more18, c.a.t0.s2.f.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.handleUegSkin();
        }
        pbCommenFloorItemViewHolder.mSkinType = skinType;
    }

    public final void T0(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, textView) == null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (tag instanceof PostData) {
            U0(textView, (PostData) tag);
        }
    }

    public final void U0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            c.a.t0.s2.r.f fVar = this.x;
            if (fVar != null && fVar.g0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.t() != null) {
                MetaData t = postData.t();
                String str = this.w;
                if (str != null && !"0".equals(str) && this.w.equals(t.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(c.a.t0.s2.l.host_name);
                    textView.setBackgroundColor(0);
                    c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(textView);
                    d2.n(c.a.t0.s2.l.J_X04);
                    d2.l(c.a.t0.s2.g.L_X01);
                    d2.v(c.a.t0.s2.f.CAM_X0302);
                    d2.k(c.a.t0.s2.f.CAM_X0302);
                } else if (t.getIs_bawu() == 1 && postData.c0()) {
                    c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(textView);
                    d3.v(c.a.t0.s2.f.CAM_X0101);
                    d3.n(c.a.t0.s2.l.J_X04);
                    d3.f(c.a.t0.s2.f.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(c.a.t0.s2.l.brand_official);
                } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                    c.a.s0.s.u.c d4 = c.a.s0.s.u.c.d(textView);
                    d4.v(c.a.t0.s2.f.CAM_X0101);
                    d4.n(c.a.t0.s2.l.J_X04);
                    d4.f(c.a.t0.s2.f.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(c.a.t0.s2.l.bawu_member_bazhu_tip);
                } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                    c.a.s0.s.u.c d5 = c.a.s0.s.u.c.d(textView);
                    d5.v(c.a.t0.s2.f.CAM_X0101);
                    d5.n(c.a.t0.s2.l.J_X04);
                    d5.f(c.a.t0.s2.f.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(c.a.t0.s2.l.bawu_member_xbazhu_tip);
                } else if (t.getIs_bawu() == 1 && "pri_content_assist".equals(t.getBawu_type())) {
                    c.a.s0.s.u.c d6 = c.a.s0.s.u.c.d(textView);
                    d6.v(c.a.t0.s2.f.CAM_X0101);
                    d6.n(c.a.t0.s2.l.J_X04);
                    d6.f(c.a.t0.s2.f.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(c.a.t0.s2.l.bawu_content_assist_tip);
                } else if (t.getIs_bawu() == 1 && "pri_manage_assist".equals(t.getBawu_type())) {
                    c.a.s0.s.u.c d7 = c.a.s0.s.u.c.d(textView);
                    d7.v(c.a.t0.s2.f.CAM_X0101);
                    d7.n(c.a.t0.s2.l.J_X04);
                    d7.f(c.a.t0.s2.f.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(c.a.t0.s2.l.bawu_manage_assist_tip);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.u = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onLongClickListener) == null) {
            this.C = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.z = onClickListener;
        }
    }

    public final void j0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.mRichTextView.setTextViewOnTouchListener(this.B);
            pbCommenFloorItemViewHolder.mRichTextView.setTextViewCheckSelection(false);
        }
    }

    public final void k0(PostData postData) {
        c.a.t0.s2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, postData) == null) || (fVar = this.x) == null) {
            return;
        }
        if (fVar.r0()) {
            AbsVideoPbFragment absVideoPbFragment = this.o;
            if (absVideoPbFragment != null) {
                c.a.t0.s2.w.a.e(absVideoPbFragment.getUniqueId(), this.x, postData, postData.f0, postData.e0 ? 2 : 8, "common_exp_source_pb_comment");
                return;
            }
            return;
        }
        PbFragment pbFragment = this.n;
        if (pbFragment != null) {
            c.a.t0.s2.w.a.e(pbFragment.getUniqueId(), this.x, postData, postData.f0, postData.e0 ? 2 : 8, "common_exp_source_pb_comment");
        }
    }

    public final void l0(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, postData) == null) && postData.G == 0 && postData.O) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", postData.G());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            c.a.t0.s2.y.b bVar = this.m;
            if (bVar != null) {
                int Q0 = bVar.getPbModel().Q0();
                if (1 == Q0 || 2 == Q0) {
                    statisticItem.param("obj_source", "1");
                } else if (3 == Q0) {
                    statisticItem.param("obj_source", "2");
                } else {
                    statisticItem.param("obj_source", "0");
                }
            }
            TiebaStatic.log(statisticItem);
            if (postData.t() == null || postData.t().getAlaInfo() == null || postData.t().getAlaInfo().live_status != 1) {
                return;
            }
            M0(postData);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
            this.y = onClickListener;
        }
    }

    public final void m0(TbRichTextView tbRichTextView, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048606, this, tbRichTextView, view, z) == null) || tbRichTextView == null || view == null) {
            return;
        }
        int k2 = (((c.a.d.f.p.n.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k2 = (k2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int Z = z ? Z(c.a.t0.s2.g.tbds115) : 0;
        tbRichTextView.getLayoutStrategy().q((int) ((k2 - Z) * this.v));
        tbRichTextView.getLayoutStrategy().G = (k2 - Z) - Z(c.a.t0.s2.g.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k2 * 1.618f * this.v));
    }

    public final void n0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.mAllContent.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.mFoldTitleView.setText(c.a.t0.s2.l.expand_content);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.mFoldTitleView.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.mAllContent.setVisibility(0);
            pbCommenFloorItemViewHolder.mFoldTitleView.setText(c.a.t0.s2.l.close_content);
        }
    }

    public final void o0(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, postData}) == null) || pbCommenFloorItemViewHolder == null || (view = pbCommenFloorItemViewHolder.mBottomLine) == null || pbCommenFloorItemViewHolder.mFoldOpArea == null || !(view.getLayoutParams() instanceof RelativeLayout.LayoutParams) || !(pbCommenFloorItemViewHolder.mFoldOpArea.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        boolean z2 = !ListUtils.isEmpty(postData.P());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.mFoldOpArea.getLayoutParams();
        if (z) {
            pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().m(0);
            if (z2) {
                pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().l(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), c.a.t0.s2.g.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), c.a.t0.s2.g.tbds26);
                }
            } else {
                pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().l(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), c.a.t0.s2.g.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            pbCommenFloorItemViewHolder.mFoldOpArea.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = c.a.d.f.p.n.f(this.f3299e, c.a.t0.s2.g.tbds20);
                pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().l(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), c.a.t0.s2.g.tbds30));
        pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().m(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), c.a.t0.s2.g.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = c.a.d.f.p.n.f(this.f3299e, c.a.t0.s2.g.tbds14);
            pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view) == null) {
        }
    }

    public void p(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, yVar) == null) {
            this.A = yVar;
        }
    }

    public final void p0(View view) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, view) == null) || view == null || !(view.getTag() instanceof PbCommenFloorItemViewHolder) || (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view.getTag()).mPbRightTopAgreeView) == null || agreeView.getData() == null) {
            return;
        }
        pbCommenFloorItemViewHolder.mPbRightTopAgreeView.onAgreeClick();
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
        statisticItem.param("fid", this.x.m());
        statisticItem.param("tid", this.x.Q());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("post_id", this.x.j().G());
        statisticItem.param("obj_source", 1);
        statisticItem.param("obj_type", 1);
        statisticItem.param("obj_locate", F0());
        TiebaStatic.log(statisticItem);
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.w = str;
        }
    }

    public final void q0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, postData) == null) || postData == null) {
            return;
        }
        StatisticItem i2 = c.a.t0.s2.w.a.i(this.x, postData, postData.f0, postData.e0 ? 2 : 8, 6);
        postData.g0 = i2;
        if (ListUtils.isEmpty(postData.P())) {
            return;
        }
        Iterator<PostData> it = postData.P().iterator();
        while (it.hasNext()) {
            it.next().g0 = i2;
        }
    }

    public final void r0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (!TextUtils.isEmpty(postData.u()) && this.u) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.mRichTextView.getLayoutParams();
                layoutParams.topMargin = Z(c.a.t0.s2.g.ds20);
                layoutParams.bottomMargin = Z(c.a.t0.s2.g.ds20);
                pbCommenFloorItemViewHolder.mRichTextView.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.mRichTextView.startLoad(postData.u());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.mRichTextView.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbCommenFloorItemViewHolder.mRichTextView.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.mRichTextView.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.mRichTextView.startLoad(null);
            }
            pbCommenFloorItemViewHolder.mRichTextView.setTextViewOnTouchListener(this.L);
            pbCommenFloorItemViewHolder.mRichTextView.setTextViewCheckSelection(false);
        }
    }

    public final void s0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048615, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || (imageView = pbCommenFloorItemViewHolder.mFeedBackImg) == null || this.x == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void t(c.a.t0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, fVar) == null) {
            this.x = fVar;
        }
    }

    public final void t0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        int i2;
        int i3;
        c.a.t0.s2.r.f fVar;
        c.a.t0.s2.r.f fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048617, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        boolean z2 = true;
        if (postData.A() > 0 && (fVar2 = this.x) != null && !fVar2.g0()) {
            String format = String.format(this.f3299e.getString(c.a.t0.s2.l.is_floor), Integer.valueOf(postData.A()));
            pbCommenFloorItemViewHolder.mFloorNum.setVisibility(0);
            pbCommenFloorItemViewHolder.mFloorNum.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.mFloorNum.setVisibility(8);
            z = false;
        }
        c.a.s0.u.g K = postData.K();
        z2 = (K == null || StringUtils.isNull(K.b()) || (fVar = this.x) == null || fVar.g0()) ? false : false;
        if (z) {
            pbCommenFloorItemViewHolder.mPointRightFloor.setVisibility(0);
            i2 = this.s;
        } else {
            pbCommenFloorItemViewHolder.mPointRightFloor.setVisibility(8);
            i2 = 0;
        }
        if (z2) {
            pbCommenFloorItemViewHolder.mPointRightPostTime.setVisibility(0);
            i3 = this.s;
        } else {
            pbCommenFloorItemViewHolder.mPointRightPostTime.setVisibility(8);
            i3 = 0;
        }
        pbCommenFloorItemViewHolder.mReplyTimeView.setPadding(i2, 0, i3, 0);
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.V()), "yyyy"))) {
            pbCommenFloorItemViewHolder.mReplyTimeView.setText(StringHelper.getFormatTimeShort(postData.V()));
        } else {
            pbCommenFloorItemViewHolder.mReplyTimeView.setText(StringHelper.getFormatTime(postData.V()));
        }
        if (z2) {
            pbCommenFloorItemViewHolder.mLocationView.setVisibility(0);
            pbCommenFloorItemViewHolder.mLocationView.setPadding(this.s, 0, 0, 0);
            if (postData.d0) {
                pbCommenFloorItemViewHolder.mLocationView.setText(StringHelper.cutStringWithSuffix(K.b(), 7, "..."));
            } else {
                pbCommenFloorItemViewHolder.mLocationView.setText(K.b());
            }
        } else {
            pbCommenFloorItemViewHolder.mLocationView.setVisibility(8);
        }
        TextView textView = pbCommenFloorItemViewHolder.mViewPostTimeAbove;
        textView.setText(((Object) pbCommenFloorItemViewHolder.mReplyTimeView.getText()) + "  • ");
    }

    public final void u0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048618, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.mImgGodComment.setVisibility(postData.d0 ? 0 : 8);
    }

    public final void v0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048619, this, pbCommenFloorItemViewHolder, postData, view, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.mTrisectionContainer.setVisibility(8);
        pbCommenFloorItemViewHolder.mPbRightTopLayout.setVisibility(0);
        pbCommenFloorItemViewHolder.mPostReplyContainer.setVisibility(0);
        pbCommenFloorItemViewHolder.mPbPostReplyLayoutAbove.setVisibility(8);
        pbCommenFloorItemViewHolder.mCommentView.setVisibility(8);
        pbCommenFloorItemViewHolder.mShareView.setVisibility(8);
        pbCommenFloorItemViewHolder.mPbFloorPraiseView.setVisibility(8);
        pbCommenFloorItemViewHolder.mBtnOpMore.setVisibility(8);
        E0(pbCommenFloorItemViewHolder, postData, view, i2);
        s0(pbCommenFloorItemViewHolder, postData);
        w0(pbCommenFloorItemViewHolder, postData);
        z0(pbCommenFloorItemViewHolder, postData, view);
        y0(pbCommenFloorItemViewHolder, postData, view, i2);
        t0(pbCommenFloorItemViewHolder, postData);
        B0(pbCommenFloorItemViewHolder, postData);
        x0(pbCommenFloorItemViewHolder, postData);
        C0(pbCommenFloorItemViewHolder, postData);
        r0(pbCommenFloorItemViewHolder, postData);
        u0(pbCommenFloorItemViewHolder, postData);
        A0(pbCommenFloorItemViewHolder, postData);
        D0(pbCommenFloorItemViewHolder, postData);
    }

    public final void w0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048620, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || postData.q() == null) {
            return;
        }
        postData.q().threadId = this.m.getPbModel().h1();
        postData.q().objType = 1;
        postData.q().isInPost = true;
        d2 d2Var = null;
        c.a.t0.s2.r.f fVar = this.x;
        if (fVar != null && fVar.O() != null) {
            d2Var = this.x.O();
        }
        if (d2Var != null && d2Var.G2()) {
            pbCommenFloorItemViewHolder.mPbFloorPraiseView.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.mPbFloorPraiseView.setThreadData(d2Var);
        pbCommenFloorItemViewHolder.mPbFloorPraiseView.setData(postData.q());
        pbCommenFloorItemViewHolder.mPbRightTopAgreeView.setThreadData(d2Var);
        pbCommenFloorItemViewHolder.mPbRightTopAgreeView.setData(postData.q());
    }

    public final void x0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048621, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.mRecommendLiveTitleView == null || pbCommenFloorItemViewHolder.mRecommendLiveLayout == null) {
            return;
        }
        if (postData != null && (alaLiveInfoCoreData = postData.V) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
            pbCommenFloorItemViewHolder.mRecommendLiveTitleView.setText(postData.V.liveTitle);
            pbCommenFloorItemViewHolder.mRecommendLiveLayout.setTag(postData.V);
            pbCommenFloorItemViewHolder.mRecommendLiveLayout.setVisibility(0);
            StatisticItem statisticItem = new StatisticItem("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(statisticItem);
            return;
        }
        pbCommenFloorItemViewHolder.mRecommendLiveLayout.setVisibility(8);
    }

    public final void y0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048622, this, pbCommenFloorItemViewHolder, postData, view, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.R() > 0) {
            pbCommenFloorItemViewHolder.mReplyView.setVisibility(8);
        } else {
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.mReplyView.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                pbCommenFloorItemViewHolder.mReplyView.setTag(sparseArray);
            }
            sparseArray.put(c.a.t0.s2.i.tag_load_sub_data, postData);
            if (postData.E() == 2) {
                pbCommenFloorItemViewHolder.mReplyView.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.mReplyView.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.mReplyCountView.setVisibility(8);
        }
        ImageView imageView = pbCommenFloorItemViewHolder.mCommentView;
        if (imageView != null) {
            SparseArray sparseArray2 = (SparseArray) imageView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                pbCommenFloorItemViewHolder.mCommentView.setTag(sparseArray2);
            }
            sparseArray2.put(c.a.t0.s2.i.tag_load_sub_data, postData);
        }
        ImageView imageView2 = pbCommenFloorItemViewHolder.mShareView;
        if (imageView2 != null) {
            SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                pbCommenFloorItemViewHolder.mShareView.setTag(sparseArray3);
            }
            sparseArray3.put(c.a.t0.s2.i.tag_load_sub_data, postData);
        }
        pbCommenFloorItemViewHolder.mReplyCountView.setVisibility(8);
        boolean z = true;
        if (!postData.b0() && !postData.a0(true)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.mReplyContentView.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.mReplyContentView.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.mReplyContentView.setVisibility(8);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.mReplyContentView.getLayoutParams();
            layoutParams2.topMargin = c.a.d.f.p.n.f(this.f3299e, c.a.t0.s2.g.tbds10);
            layoutParams2.leftMargin = c.a.d.f.p.n.f(this.f3299e, c.a.t0.s2.g.tbds148);
            layoutParams2.rightMargin = c.a.d.f.p.n.f(this.f3299e, c.a.t0.s2.g.M_W_X007);
            layoutParams2.bottomMargin = c.a.d.f.p.n.f(this.f3299e, c.a.t0.s2.g.tbds20);
            pbCommenFloorItemViewHolder.mReplyContentView.setLayoutParams(layoutParams2);
            if (this.D == null) {
                c.a.t0.s2.u.h.b bVar = new c.a.t0.s2.u.h.b(this.f3299e);
                this.D = bVar;
                bVar.f(this.q);
                this.D.h(this.y);
                this.D.e(this.z);
                String str = null;
                c.a.t0.s2.r.f fVar = this.x;
                if (fVar != null && fVar.O() != null && this.x.O().J() != null) {
                    str = this.x.O().J().getUserId();
                }
                z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                c.a.t0.s2.r.f fVar2 = this.x;
                if (fVar2 != null) {
                    this.D.j(fVar2.V(), z);
                    this.D.i(this.x.O());
                }
            }
            this.D.g(postData.G());
            pbCommenFloorItemViewHolder.mReplyContentView.setSubPbAdapter(this.D);
            pbCommenFloorItemViewHolder.mReplyContentView.setVisibility(0);
            pbCommenFloorItemViewHolder.mReplyContentView.setData(postData, view);
            pbCommenFloorItemViewHolder.mReplyContentView.setChildOnClickListener(this.z);
            pbCommenFloorItemViewHolder.mReplyContentView.setChildOnLongClickListener(this.C);
            pbCommenFloorItemViewHolder.mReplyContentView.setChildOnTouchListener(this.L);
        }
        if (postData.R) {
            pbCommenFloorItemViewHolder.mBottomLine.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.mBottomLine.setVisibility(4);
        }
        pbCommenFloorItemViewHolder.mReplyView.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.mPostReplyContainer.getLayoutParams();
        layoutParams3.topMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.M_H_X001);
        layoutParams3.bottomMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.M_H_X002);
        if (pbCommenFloorItemViewHolder.mReplyCountView.getVisibility() == 8) {
            pbCommenFloorItemViewHolder.mPostReplyContainer.setVisibility(8);
        } else {
            pbCommenFloorItemViewHolder.mPostReplyContainer.setVisibility(0);
        }
        pbCommenFloorItemViewHolder.mBtnPostAbove.setText(TbadkCoreApplication.getInst().getString(c.a.t0.s2.l.reply));
    }

    public final void z0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048623, this, pbCommenFloorItemViewHolder, postData, view) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.mRichTextView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = c.a.d.f.p.n.f(this.f3299e, c.a.t0.s2.g.M_W_X007);
        layoutParams.leftMargin = c.a.d.f.p.n.f(this.f3299e, c.a.t0.s2.g.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        pbCommenFloorItemViewHolder.mRichTextView.setPadding(0, 0, 0, 0);
        if (!this.u) {
            pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().g(c.a.t0.s2.h.icon_click);
        } else {
            pbCommenFloorItemViewHolder.mRichTextView.startLoad(null);
            pbCommenFloorItemViewHolder.mRichTextView.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().g(c.a.t0.s2.h.transparent_bg);
        }
        pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().x(c.a.t0.s2.h.pic_video);
        m0(pbCommenFloorItemViewHolder.mRichTextView, view, !StringUtils.isNull(postData.u()));
        pbCommenFloorItemViewHolder.mRichTextView.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.mRichTextView.setLinkTextColor(SkinManager.getColor(c.a.t0.s2.f.CAM_X0304));
        pbCommenFloorItemViewHolder.mRichTextView.setIsFromCDN(this.q);
        pbCommenFloorItemViewHolder.mRichTextView.setText(postData.N(), true, this.t);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.mRichTextView.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(c.a.t0.s2.i.tag_clip_board, postData);
        sparseArray.put(c.a.t0.s2.i.tag_is_subpb, Boolean.FALSE);
        pbCommenFloorItemViewHolder.mRichTextView.setTag(sparseArray);
        pbCommenFloorItemViewHolder.pbItemViewRoot.setTag(c.a.t0.s2.i.tag_from, sparseArray);
        pbCommenFloorItemViewHolder.mBtnOpMore.setTag(sparseArray);
        pbCommenFloorItemViewHolder.mPbRightTopMoreView.setTag(sparseArray);
    }
}
