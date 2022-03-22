package c.a.p0.w2.m.f;

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
import c.a.p0.h0.m;
import c.a.p0.w2.j.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
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
import com.baidu.tieba.R;
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
/* loaded from: classes3.dex */
public class p extends r<PostData, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public boolean C;
    public boolean D;
    public c.a.d.f.k.b<ConstrainImageLayout> E;
    public c.a.d.f.k.b<TbImageView> F;
    public c.a.p0.w2.j.c G;
    public int o;
    public TbRichTextView.s p;
    public boolean q;
    public float r;
    public String s;
    public c.a.p0.w2.i.f t;
    public View.OnClickListener u;
    public View.OnClickListener v;
    public TbRichTextView.y w;
    public c.a.p0.w2.j.c x;
    public View.OnLongClickListener y;
    public c.a.p0.w2.m.h.b z;

    /* loaded from: classes3.dex */
    public class a implements c.a.d.f.k.c<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p a;

        public a(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.a.a) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.d.f.k.c<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p a;

        public b(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pVar;
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
                TbImageView tbImageView = new TbImageView(this.a.a);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
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

    /* loaded from: classes3.dex */
    public class c implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p a;

        public c(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pVar;
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
                if (this.a.x != null) {
                    if (!(view instanceof TbListTextView) || this.a.v == null) {
                        this.a.x.a(view);
                        this.a.x.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    this.a.v.onClick(view);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.p0.w2.j.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (view == null || !((pbFragment = this.a.j) == null || pbFragment.S4() == null || this.a.j.S4().v1())) {
                    return true;
                }
                if (view instanceof RelativeLayout) {
                    this.a.p0(view);
                } else {
                    ViewParent parent = view.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (parent instanceof RelativeLayout) {
                            this.a.p0((RelativeLayout) parent);
                            break;
                        } else {
                            parent = parent.getParent();
                            i++;
                        }
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PostData f20287b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ p f20288c;

        public d(p pVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, pbCommenFloorItemViewHolder, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20288c = pVar;
            this.a = pbCommenFloorItemViewHolder;
            this.f20287b = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean z = this.a.R.getVisibility() == 8;
                this.f20288c.n0(this.a, !z, this.f20287b.D());
                this.f20287b.s0(!z);
                this.f20288c.K0(this.a, this.f20287b);
                PbFragment pbFragment = this.f20288c.j;
                if (pbFragment == null || pbFragment.S4() == null || this.f20288c.j.S4().Z0() == null || this.f20288c.j.S4().F0() == null || z || this.a.b().getTop() >= this.f20288c.j.S4().Z0().getMeasuredHeight()) {
                    return;
                }
                this.f20288c.j.S4().F0().setSelectionFromTop(ListUtils.getPosition(this.f20288c.j.S4().F0().getData(), this.f20287b) + this.f20288c.j.S4().F0().getHeaderViewsCount(), this.f20288c.j.S4().Z0().getMeasuredHeight());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f20289b;

        public e(p pVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, pbCommenFloorItemViewHolder, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
            this.f20289b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.f34873e.getMeasuredWidth();
                String str = this.f20289b;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                y0.a(measuredWidth, str, pbCommenFloorItemViewHolder.f34874f, pbCommenFloorItemViewHolder.f34875g, pbCommenFloorItemViewHolder.F, pbCommenFloorItemViewHolder.I, pbCommenFloorItemViewHolder.H);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public f(p pVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.t.performClick();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.w2.m.f.k1.c f20290b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ p f20291c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostData a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g f20292b;

            public a(g gVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f20292b = gVar;
                this.a = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.f20292b;
                    gVar.f20290b.f20191b.a(gVar.f20291c.t, null, this.a, gVar.a.n.getLayoutStrategy());
                }
            }
        }

        public g(p pVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, c.a.p0.w2.m.f.k1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, pbCommenFloorItemViewHolder, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20291c = pVar;
            this.a = pbCommenFloorItemViewHolder;
            this.f20290b = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (!(sparseArray.get(R.id.obfuscated_res_0x7f091e85) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e85)) == null || this.a.f34870b == null || this.f20290b == null) {
                    return;
                }
                c.a.d.f.m.e.a().postDelayed(new a(this, postData), 100L);
                String Q = this.f20291c.t.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.f20291c.t.Q())) && this.f20291c.t.O() != null) {
                    Q = this.f20291c.t.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.f20291c.t.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.G()).param("obj_source", this.f20291c.G0(view)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ p f20293b;

        public h(p pVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20293b = pVar;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f20293b.t == null || (pbCommenFloorItemViewHolder = this.a) == null || (agreeView = pbCommenFloorItemViewHolder.l) == null || agreeView.getData() == null) {
                return;
            }
            int i = view == this.a.l.getImgAgree() ? 1 : 2;
            String Q = this.f20293b.t.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.f20293b.t.Q())) && this.f20293b.t.O() != null) {
                Q = this.f20293b.t.O().getNid();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.f20293b.t.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.l.getData().postId).param("obj_source", this.f20293b.G0(this.a.l)).param("obj_type", i));
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ p f20294b;

        public i(p pVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20294b = pVar;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f20294b.t == null || (pbCommenFloorItemViewHolder = this.a) == null || (agreeView = pbCommenFloorItemViewHolder.b0) == null || agreeView.getData() == null) {
                return;
            }
            int i = view == this.a.b0.getImgAgree() ? 1 : 2;
            String Q = this.f20294b.t.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.f20294b.t.Q())) && this.f20294b.t.O() != null) {
                Q = this.f20294b.t.O().getNid();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.f20294b.t.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.b0.getData().postId).param("obj_source", this.f20294b.G0(this.a.b0)).param("obj_type", i));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(c.a.p0.w2.q.c cVar, BdUniqueId bdUniqueId) {
        super(cVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.p0.w2.q.c) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 0;
        this.p = null;
        this.q = true;
        this.r = 1.0f;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = true;
        this.C = true;
        this.D = false;
        this.E = new c.a.d.f.k.b<>(new a(this), 6, 0);
        this.F = new c.a.d.f.k.b<>(new b(this), 12, 0);
        this.G = new c.a.p0.w2.j.c(new c(this));
        if (cVar != null && cVar.w() != null) {
            this.B = cVar.w().R0();
        }
        this.o = Z(R.dimen.tbds14);
    }

    public final void A0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.f34870b == null) {
            return;
        }
        c.a.p0.w2.q.c cVar = this.i;
        if (cVar != null && cVar.w() != null && StringHelper.equals(this.i.w().u0(), postData.G())) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f34870b, R.color.CAM_X0313);
        } else {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f34870b, R.color.CAM_X0205);
        }
    }

    public final void B0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.S() != null) {
                TbRichText N = postData.N();
                c.a.p0.w2.r.h.c(postData.S(), pbCommenFloorItemViewHolder.L, false, false, N != null && StringUtils.isNull(N.toString()) && StringUtils.isNull(postData.u()));
                return;
            }
            pbCommenFloorItemViewHolder.L.setVisibility(8);
        }
    }

    public final void C0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData.E() != 2 && postData.E() != 4) {
                pbCommenFloorItemViewHolder.S.setVisibility(8);
                pbCommenFloorItemViewHolder.R.setVisibility(0);
                o0(false, pbCommenFloorItemViewHolder, postData);
            } else {
                pbCommenFloorItemViewHolder.S.setOnClickListener(new d(this, pbCommenFloorItemViewHolder, postData));
                pbCommenFloorItemViewHolder.S.setVisibility(0);
                n0(pbCommenFloorItemViewHolder, postData.d0(), postData.D());
                o0(true, pbCommenFloorItemViewHolder, postData);
            }
            K0(pbCommenFloorItemViewHolder, postData);
        }
    }

    public final void D0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.h(postData.Q, postData.G(), this.D);
    }

    /* JADX WARN: Removed duplicated region for block: B:245:0x06ab  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x06b6  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x06bf  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0702  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x070c  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0772  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x077c  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x07bb  */
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
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048580, this, pbCommenFloorItemViewHolder, postData, view, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.s() != null) {
            postData.s().isBaijiahaoUser();
        }
        if (postData.P) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f34872d, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.f34872d.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.f34872d.setVisibility(8);
        }
        ThreadData threadData = null;
        pbCommenFloorItemViewHolder.m.setTag(null);
        pbCommenFloorItemViewHolder.m.setUserId(null);
        pbCommenFloorItemViewHolder.f34874f.setText((CharSequence) null);
        pbCommenFloorItemViewHolder.G.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.n.setIsHost(false);
        if (postData.s() != null) {
            String str = this.s;
            if (str != null && !str.equals("0") && this.s.equals(postData.s().getUserId())) {
                pbCommenFloorItemViewHolder.n.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.s().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.s().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.I;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.obfuscated_res_0x7f091eb7, postData.s().getUserId());
                c.a.p0.w2.q.c cVar = this.i;
                if (cVar != null && cVar.x() != null) {
                    pbCommenFloorItemViewHolder.I.setOnClickListener(this.i.x().mEvent.f20181c);
                }
                int f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                int f3 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.I;
                i3 = R.id.obfuscated_res_0x7f091eb7;
                userIconBox2.g(iconInfo, 2, f2, f2, f3);
            } else {
                i3 = R.id.obfuscated_res_0x7f091eb7;
            }
            if (pbCommenFloorItemViewHolder.H != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.H.setTag(tShowInfoNew.get(0).getUrl());
                }
                c.a.p0.w2.q.c cVar2 = this.i;
                if (cVar2 != null && cVar2.x() != null) {
                    pbCommenFloorItemViewHolder.H.setOnClickListener(this.i.x().mEvent.f20182d);
                }
                int f4 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.H.h(tShowInfoNew, 3, f4, f4, c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        y0.k(pbCommenFloorItemViewHolder.f34874f);
                    } else {
                        c.a.o0.r.v.c.d(pbCommenFloorItemViewHolder.f34874f).A(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f34874f, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f34874f, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f34874f, R.color.CAM_X0301, 1);
            }
            String avater = postData.s().getAvater();
            int i4 = postData.g0 ? 2 : 8;
            pbCommenFloorItemViewHolder.f34874f.setTag(i3, postData.s().getUserId());
            pbCommenFloorItemViewHolder.f34874f.setTag(R.id.obfuscated_res_0x7f091ebf, postData.s().getUserName());
            pbCommenFloorItemViewHolder.f34874f.setTag(R.id.obfuscated_res_0x7f091ec1, postData.s().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.f34874f.setTag(R.id.obfuscated_res_0x7f091eae, c.a.p0.w2.o.a.i(this.t, postData, postData.h0, i4, 2));
            String name_show = postData.s().getName_show();
            String userName = postData.s().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.f34874f.setText(c.a.p0.w2.c.b(this.a, pbCommenFloorItemViewHolder.f34874f.getText().toString()));
                pbCommenFloorItemViewHolder.f34874f.setGravity(16);
                pbCommenFloorItemViewHolder.f34874f.setTag(R.id.obfuscated_res_0x7f091e90, c.a.p0.w2.c.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f34874f, R.color.CAM_X0312, 1);
            }
            if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.G.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.G.j(postData.s(), 4);
                pbCommenFloorItemViewHolder.m.setVisibility(8);
                pbCommenFloorItemViewHolder.G.setVisibility(0);
                pbCommenFloorItemViewHolder.G.getHeadView().J(avater, 28, false);
                pbCommenFloorItemViewHolder.G.getHeadView().setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.G.getHeadView().setUserName(postData.s().getUserName());
                c.a.p0.w2.i.f fVar = this.t;
                pbCommenFloorItemViewHolder.G.getHeadView().setFid(fVar != null ? fVar.m() : "");
                c.a.p0.w2.i.f fVar2 = this.t;
                pbCommenFloorItemViewHolder.G.getHeadView().setFName(fVar2 != null ? fVar2.n() : "");
                pbCommenFloorItemViewHolder.G.getHeadView().setFloor(postData.A());
                pbCommenFloorItemViewHolder.G.getHeadView().setTid(postData.G());
                pbCommenFloorItemViewHolder.G.getHeadView().setTag(R.id.obfuscated_res_0x7f091eae, c.a.p0.w2.o.a.i(this.t, postData, postData.h0, i4, 2));
                pbCommenFloorItemViewHolder.G.m(postData.s().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.m.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.m, postData.s(), 4);
                pbCommenFloorItemViewHolder.m.setUserId(postData.s().getUserId());
                c.a.p0.w2.i.f fVar3 = this.t;
                pbCommenFloorItemViewHolder.m.setFid(fVar3 != null ? fVar3.m() : "");
                c.a.p0.w2.i.f fVar4 = this.t;
                pbCommenFloorItemViewHolder.m.setFName(fVar4 != null ? fVar4.n() : "");
                pbCommenFloorItemViewHolder.m.setFloor(postData.A());
                pbCommenFloorItemViewHolder.m.setTid(postData.G());
                pbCommenFloorItemViewHolder.m.setUserName(postData.s().getUserName(), postData.X());
                pbCommenFloorItemViewHolder.m.setTag(R.id.obfuscated_res_0x7f091ec1, postData.s().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.m.setTag(R.id.obfuscated_res_0x7f091eae, c.a.p0.w2.o.a.i(this.t, postData, postData.h0, i4, 2));
                pbCommenFloorItemViewHolder.m.setImageDrawable(null);
                pbCommenFloorItemViewHolder.m.J(avater, 28, false);
                pbCommenFloorItemViewHolder.m.setVisibility(0);
                pbCommenFloorItemViewHolder.G.setVisibility(8);
            }
            if (postData.s() != null && postData.s().getAlaInfo() != null && postData.s().getAlaUserData() != null && postData.s().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.f(true);
                pbCommenFloorItemViewHolder.m.setLiveStatus(1);
                pbCommenFloorItemViewHolder.m.setAlaInfo(postData.s().getAlaInfo());
                pbCommenFloorItemViewHolder.G.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.G.getHeadView().setAlaInfo(postData.s().getAlaInfo());
                threadData = null;
            } else {
                pbCommenFloorItemViewHolder.f(false);
                pbCommenFloorItemViewHolder.m.setLiveStatus(0);
                threadData = null;
                pbCommenFloorItemViewHolder.m.setAlaInfo(null);
                pbCommenFloorItemViewHolder.G.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.G.getHeadView().setAlaInfo(null);
            }
            T0(pbCommenFloorItemViewHolder.f34875g, postData);
        }
        c.a.p0.w2.q.c cVar3 = this.i;
        int level_id = (cVar3 == null || cVar3.x() == null || !this.i.x().isSimpleForum() || postData.s() == null) ? 0 : postData.s().getLevel_id();
        c.a.p0.w2.i.f fVar5 = this.t;
        if (fVar5 != null && fVar5.g0()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbCommenFloorItemViewHolder.F.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.F, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.F.setVisibility(8);
        }
        int i5 = 15;
        if (pbCommenFloorItemViewHolder.I.getChildCount() == 1) {
            i5 = 13;
        } else if (pbCommenFloorItemViewHolder.I.getChildCount() > 1) {
            i5 = 11;
        }
        if (pbCommenFloorItemViewHolder.f34875g.getVisibility() == 0) {
            i5 -= 2;
        }
        if (pbCommenFloorItemViewHolder.H.getChildCount() > 0) {
            i5 -= 2;
        }
        if (postData.w() > 1000) {
            i5 -= 2;
        }
        if (postData.w() > 10) {
            i5 -= 2;
        }
        if (i5 < 10) {
            pbCommenFloorItemViewHolder.I.setVisibility(8);
            if (pbCommenFloorItemViewHolder.I.getChildCount() == 1) {
                i5 += 2;
            } else if (pbCommenFloorItemViewHolder.I.getChildCount() > 1) {
                i5 += 4;
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.f34875g.getVisibility() == 0) {
                i5 += 2;
                pbCommenFloorItemViewHolder.f34875g.setVisibility(8);
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.F.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.F.setVisibility(8);
            }
        }
        int e2 = y0.e();
        String name_show2 = postData.s() != null ? postData.s().getName_show() : "";
        int d2 = c.a.o0.c1.o0.d(name_show2);
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            int i6 = e2 - 2;
            if (d2 > i6) {
                name_show2 = c.a.o0.c1.o0.n(name_show2, i6) + StringHelper.STRING_MORE;
            }
        } else if (d2 > e2) {
            name_show2 = c.a.o0.c1.o0.n(name_show2, e2) + StringHelper.STRING_MORE;
        }
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            pbCommenFloorItemViewHolder.f34874f.setText(F0(postData.s().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.f34874f.setText(name_show2);
            pbCommenFloorItemViewHolder.f34873e.post(new e(this, pbCommenFloorItemViewHolder, name_show2));
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f091e69, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091e85, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091e87, view);
        sparseArray.put(R.id.obfuscated_res_0x7f091e93, Integer.valueOf(i2));
        sparseArray.put(R.id.obfuscated_res_0x7f091e92, Integer.valueOf(postData.A()));
        sparseArray.put(R.id.obfuscated_res_0x7f091e79, postData.G());
        sparseArray.put(R.id.obfuscated_res_0x7f09169f, pbCommenFloorItemViewHolder.l);
        sparseArray.put(R.id.obfuscated_res_0x7f0916a0, pbCommenFloorItemViewHolder.b0);
        sparseArray.put(R.id.obfuscated_res_0x7f09169d, pbCommenFloorItemViewHolder.t);
        sparseArray.put(R.id.obfuscated_res_0x7f09169e, pbCommenFloorItemViewHolder.u);
        c.a.p0.w2.i.f fVar6 = this.t;
        if (fVar6 != null && fVar6.O() != null) {
            threadData = this.t.O();
        }
        if (threadData != null && threadData.isUgcThreadType()) {
            sparseArray.put(R.id.obfuscated_res_0x7f09169c, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.obfuscated_res_0x7f09169c, Boolean.FALSE);
        }
        boolean z7 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        c.a.p0.w2.i.f fVar7 = this.t;
        if (fVar7 == null || fVar7.V() == 0 || H0()) {
            z = false;
            z2 = false;
        } else {
            z = (this.t.V() == 1002 || this.t.V() == 3) ? false : true;
            z2 = (this.t.V() == 3 || this.t.g0()) ? false : true;
            if (postData != null && postData.s() != null) {
                String userId = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        c.a.p0.w2.i.f fVar8 = this.t;
        if (fVar8 != null && fVar8.O() != null && this.t.O().getAuthor() != null && postData.s() != null) {
            String userId2 = this.t.O().getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
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
                if (postData != null && postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z5 = true;
                    z3 = true;
                }
                if (z7) {
                    z = false;
                    z4 = false;
                    z3 = false;
                }
                int i7 = postData.A() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091e88, Integer.valueOf(this.t.V()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091e76, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091e77, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f091e78, postData.s().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091e80, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091eba, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ebb, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091eb9, postData.s().getName_show());
                    }
                    if (this.t.O() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ebd, this.t.O().getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebc, postData.G());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ea9, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091e7d, Boolean.valueOf(postData.b0()));
                    sparseArray.put(R.id.obfuscated_res_0x7f091e88, Integer.valueOf(this.t.V()));
                    sparseArray.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(z5));
                    sparseArray.put(R.id.obfuscated_res_0x7f091e6d, Integer.valueOf(i7));
                    sparseArray.put(R.id.obfuscated_res_0x7f091e6b, postData.G());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ea9, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091e81, Boolean.valueOf(z6));
                pbCommenFloorItemViewHolder.n.setTag(sparseArray);
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
        sparseArray.put(R.id.obfuscated_res_0x7f091e81, Boolean.valueOf(z6));
        pbCommenFloorItemViewHolder.n.setTag(sparseArray);
    }

    public final SpannableStringBuilder F0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return c.a.p0.h0.m.h(this.i.x(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final String G0(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                return "1";
            }
            Object obj = sparseArray.get(R.id.obfuscated_res_0x7f091731);
            String str = obj != null ? obj : "1";
            sparseArray.remove(R.id.obfuscated_res_0x7f091731);
            view.setTag(sparseArray);
            return str.toString();
        }
        return (String) invokeL.objValue;
    }

    public final boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.p0.w2.i.f fVar = this.t;
            if (fVar == null || fVar.O() == null) {
                return false;
            }
            return this.t.O().isBlocked();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: I0 */
    public PbCommenFloorItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d069e, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091714)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0696, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.i.x().getPageContext(), inflate, this.B);
            pbCommenFloorItemViewHolder.o.setConstrainLayoutPool(this.E);
            pbCommenFloorItemViewHolder.o.setImageViewPool(this.F);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.q;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.C);
                pbCommenFloorItemViewHolder.q.setIsVideoThread(false);
            }
            R0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.n;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.A);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View J0(int i2, View view, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            super.S(i2, view, viewGroup, postData, pbCommenFloorItemViewHolder);
            R0(pbCommenFloorItemViewHolder);
            N0(pbCommenFloorItemViewHolder);
            j0(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) z(i2);
            if (postData2 != null) {
                postData2.h0 = i2 + 1;
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

    public final void K0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, postData) == null) {
            TbRichText N = postData.N();
            N.isChanged = true;
            pbCommenFloorItemViewHolder.n.setText(N, true, this.p);
        }
    }

    public final void L0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, postData) == null) {
            String userId = postData.s().getUserId();
            c.a.p0.w2.i.f fVar = this.t;
            String m = fVar != null ? fVar.m() : "";
            c.a.p0.w2.i.f fVar2 = this.t;
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
            if (postData.s().getAlaInfo() != null) {
                AlaInfoData alaInfo = postData.s().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void M0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.A = z;
        }
    }

    public final void N0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.f34870b.setOnTouchListener(this.G);
            pbCommenFloorItemViewHolder.f34870b.setOnLongClickListener(this.y);
            if (this.i.x() == null || this.i.x().getPageContext() == null || this.i.x().getPageContext().getOrignalPage() == null) {
                return;
            }
            c.a.p0.w2.m.f.k1.a aVar = this.i.x().mEvent;
            pbCommenFloorItemViewHolder.f34874f.setOnClickListener(aVar.f20180b);
            pbCommenFloorItemViewHolder.m.setOnClickListener(aVar.f20180b);
            pbCommenFloorItemViewHolder.G.setOnClickListener(aVar.f20180b);
            pbCommenFloorItemViewHolder.G.getHeadView().setOnClickListener(aVar.f20180b);
            pbCommenFloorItemViewHolder.n.setOnLongClickListener(this.y);
            pbCommenFloorItemViewHolder.n.setOnTouchListener(this.G);
            pbCommenFloorItemViewHolder.n.setCommonTextViewOnClickListener(this.v);
            pbCommenFloorItemViewHolder.n.setOnImageClickListener(this.w);
            pbCommenFloorItemViewHolder.n.setOnImageTouchListener(this.G);
            pbCommenFloorItemViewHolder.n.setOnEmotionClickListener(aVar.f20183e);
            pbCommenFloorItemViewHolder.n.setOnVoiceAfterClickListener(this.v);
            pbCommenFloorItemViewHolder.L.setOnClickListener(this.v);
            pbCommenFloorItemViewHolder.M.setOnClickListener(this.v);
            pbCommenFloorItemViewHolder.r.setOnClickListener(this.v);
            pbCommenFloorItemViewHolder.s.setOnClickListener(this.v);
            pbCommenFloorItemViewHolder.c0.setOnClickListener(this.v);
            pbCommenFloorItemViewHolder.g0.setOnClickListener(this.v);
            pbCommenFloorItemViewHolder.d0.setOnClickListener(new f(this, pbCommenFloorItemViewHolder));
            c.a.p0.w2.m.f.k1.c cVar = this.i.x().mPostShareController;
            pbCommenFloorItemViewHolder.t.setOnClickListener(this.v);
            pbCommenFloorItemViewHolder.u.setOnClickListener(new g(this, pbCommenFloorItemViewHolder, cVar));
            pbCommenFloorItemViewHolder.l.x = new h(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.b0.x = new i(this, pbCommenFloorItemViewHolder);
        }
    }

    public void O0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.D = z;
        }
    }

    public void P0(c.a.p0.w2.j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.x = cVar;
        }
    }

    public void Q0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, sVar) == null) {
            this.p = sVar;
        }
    }

    public final void R0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, pbCommenFloorItemViewHolder) == null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            S0(pbCommenFloorItemViewHolder.f34875g);
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    y0.k(pbCommenFloorItemViewHolder.f34874f);
                } else {
                    c.a.o0.r.v.c.d(pbCommenFloorItemViewHolder.f34874f).A(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f34874f, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f34874f, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f34876h, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.i, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.j, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.E, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.s, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.n.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.e0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.q, c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.r, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.r, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.r.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.t, R.drawable.obfuscated_res_0x7f08094c, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.u, R.drawable.obfuscated_res_0x7f08094d, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.q.d();
            pbCommenFloorItemViewHolder.o.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.N, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.M, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.O, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.Q, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.T, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.R.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.T.setText(R.string.obfuscated_res_0x7f0f03e4);
            } else {
                c.a.p0.w2.i.f fVar = this.t;
                if (fVar != null && StringUtils.isNull(fVar.k())) {
                    pbCommenFloorItemViewHolder.T.setText(this.t.k());
                } else {
                    pbCommenFloorItemViewHolder.T.setText(R.string.obfuscated_res_0x7f0f05bc);
                }
            }
            pbCommenFloorItemViewHolder.l.v(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.e(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.K, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.c0, R.drawable.obfuscated_res_0x7f080927, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.g0, R.drawable.obfuscated_res_0x7f080927, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.d();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }

    @Override // c.a.p0.w2.m.f.r, c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        J0(i2, view, viewGroup, (PostData) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view;
    }

    public final void S0(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, textView) == null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (tag instanceof PostData) {
            T0(textView, (PostData) tag);
        }
    }

    public final void T0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            c.a.p0.w2.i.f fVar = this.t;
            if (fVar != null && fVar.g0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.s() != null) {
                MetaData s = postData.s();
                String str = this.s;
                if (str != null && !str.equals("0") && this.s.equals(s.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.obfuscated_res_0x7f0f0855);
                    textView.setBackgroundColor(0);
                    c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(textView);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.v(R.color.CAM_X0302);
                    d2.k(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && postData.c0()) {
                    c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0330);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02ea);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    c.a.o0.r.v.c d5 = c.a.o0.r.v.c.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02eb);
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    c.a.o0.r.v.c d6 = c.a.o0.r.v.c.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02e7);
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    c.a.o0.r.v.c d7 = c.a.o0.r.v.c.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02e8);
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
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.q = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onLongClickListener) == null) {
            this.y = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) {
            this.v = onClickListener;
        }
    }

    public final void j0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.n.setTextViewOnTouchListener(this.x);
            pbCommenFloorItemViewHolder.n.setTextViewCheckSelection(false);
        }
    }

    public final void k0(PostData postData) {
        c.a.p0.w2.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, postData) == null) || (fVar = this.t) == null) {
            return;
        }
        if (fVar.r0()) {
            AbsVideoPbFragment absVideoPbFragment = this.k;
            if (absVideoPbFragment != null) {
                c.a.p0.w2.o.a.e(absVideoPbFragment.getUniqueId(), this.t, postData, postData.h0, postData.g0 ? 2 : 8, "common_exp_source_pb_comment");
                return;
            }
            return;
        }
        PbFragment pbFragment = this.j;
        if (pbFragment != null) {
            c.a.p0.w2.o.a.e(pbFragment.getUniqueId(), this.t, postData, postData.h0, postData.g0 ? 2 : 8, "common_exp_source_pb_comment");
        }
    }

    public final void l0(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, postData) == null) && postData.C == 0 && postData.K) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", postData.G());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            c.a.p0.w2.q.c cVar = this.i;
            if (cVar != null) {
                int R0 = cVar.w().R0();
                if (1 == R0 || 2 == R0) {
                    statisticItem.param("obj_source", "1");
                } else if (3 == R0) {
                    statisticItem.param("obj_source", "2");
                } else {
                    statisticItem.param("obj_source", "0");
                }
            }
            TiebaStatic.log(statisticItem);
            if (postData.s() == null || postData.s().getAlaInfo() == null || postData.s().getAlaInfo().live_status != 1) {
                return;
            }
            L0(postData);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onClickListener) == null) {
            this.u = onClickListener;
        }
    }

    public final void m0(TbRichTextView tbRichTextView, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048605, this, tbRichTextView, view, z) == null) || tbRichTextView == null || view == null) {
            return;
        }
        int k = (((c.a.d.f.p.n.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k = (k - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int Z = z ? Z(R.dimen.tbds115) : 0;
        tbRichTextView.getLayoutStrategy().q((int) ((k - Z) * this.r));
        tbRichTextView.getLayoutStrategy().G = (k - Z) - Z(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k * 1.618f * this.r));
    }

    public final void n0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.R.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.T.setText(R.string.obfuscated_res_0x7f0f05bc);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.T.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.R.setVisibility(0);
            pbCommenFloorItemViewHolder.T.setText(R.string.obfuscated_res_0x7f0f03e4);
        }
    }

    public final void o0(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, postData}) == null) || pbCommenFloorItemViewHolder == null || (view = pbCommenFloorItemViewHolder.K) == null || pbCommenFloorItemViewHolder.S == null || !(view.getLayoutParams() instanceof RelativeLayout.LayoutParams) || !(pbCommenFloorItemViewHolder.S.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        boolean z2 = !ListUtils.isEmpty(postData.P());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.K.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.S.getLayoutParams();
        if (z) {
            pbCommenFloorItemViewHolder.n.getLayoutStrategy().m(0);
            if (z2) {
                pbCommenFloorItemViewHolder.n.getLayoutStrategy().l(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                }
            } else {
                pbCommenFloorItemViewHolder.n.getLayoutStrategy().l(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            pbCommenFloorItemViewHolder.S.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = c.a.d.f.p.n.f(this.a, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.K.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        pbCommenFloorItemViewHolder.n.getLayoutStrategy().l(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        pbCommenFloorItemViewHolder.n.getLayoutStrategy().m(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = c.a.d.f.p.n.f(this.a, R.dimen.tbds14);
            pbCommenFloorItemViewHolder.K.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, view) == null) {
        }
    }

    public void p(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, yVar) == null) {
            this.w = yVar;
        }
    }

    public final void p0(View view) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, view) == null) || view == null || !(view.getTag() instanceof PbCommenFloorItemViewHolder) || (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view.getTag()).b0) == null || agreeView.getData() == null) {
            return;
        }
        pbCommenFloorItemViewHolder.b0.u();
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.s = str;
        }
    }

    public final void q0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, postData) == null) || postData == null) {
            return;
        }
        StatisticItem i2 = c.a.p0.w2.o.a.i(this.t, postData, postData.h0, postData.g0 ? 2 : 8, 6);
        postData.i0 = i2;
        if (ListUtils.isEmpty(postData.P())) {
            return;
        }
        Iterator<PostData> it = postData.P().iterator();
        while (it.hasNext()) {
            it.next().i0 = i2;
        }
    }

    public final void r0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (!TextUtils.isEmpty(postData.u()) && this.q) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.n.getLayoutParams();
                layoutParams.topMargin = Z(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = Z(R.dimen.obfuscated_res_0x7f0701d5);
                pbCommenFloorItemViewHolder.n.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.n.k0(postData.u());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.n.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbCommenFloorItemViewHolder.n.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.n.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.n.k0(null);
            }
            pbCommenFloorItemViewHolder.n.setTextViewOnTouchListener(this.G);
            pbCommenFloorItemViewHolder.n.setTextViewCheckSelection(false);
        }
    }

    public final void s0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048614, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || (imageView = pbCommenFloorItemViewHolder.J) == null || this.t == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void t(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, fVar) == null) {
            this.t = fVar;
        }
    }

    public final void t0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        int i2;
        int i3;
        c.a.p0.w2.i.f fVar;
        c.a.p0.w2.i.f fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048616, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        boolean z2 = true;
        if (postData.A() > 0 && (fVar2 = this.t) != null && !fVar2.g0()) {
            String format = String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0961), Integer.valueOf(postData.A()));
            pbCommenFloorItemViewHolder.E.setVisibility(0);
            pbCommenFloorItemViewHolder.E.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.E.setVisibility(8);
            z = false;
        }
        c.a.o0.t.g K = postData.K();
        z2 = (K == null || StringUtils.isNull(K.b()) || (fVar = this.t) == null || fVar.g0()) ? false : false;
        if (z) {
            pbCommenFloorItemViewHolder.i.setVisibility(0);
            i2 = this.o;
        } else {
            pbCommenFloorItemViewHolder.i.setVisibility(8);
            i2 = 0;
        }
        if (z2) {
            pbCommenFloorItemViewHolder.j.setVisibility(0);
            i3 = this.o;
        } else {
            pbCommenFloorItemViewHolder.j.setVisibility(8);
            i3 = 0;
        }
        pbCommenFloorItemViewHolder.f34876h.setPadding(i2, 0, i3, 0);
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.V()), "yyyy"))) {
            pbCommenFloorItemViewHolder.f34876h.setText(StringHelper.getFormatTimeShort(postData.V()));
        } else {
            pbCommenFloorItemViewHolder.f34876h.setText(StringHelper.getFormatTime(postData.V()));
        }
        if (z2) {
            pbCommenFloorItemViewHolder.k.setVisibility(0);
            pbCommenFloorItemViewHolder.k.setPadding(this.o, 0, 0, 0);
            if (postData.Z) {
                pbCommenFloorItemViewHolder.k.setText(StringHelper.cutStringWithSuffix(K.b(), 7, StringHelper.STRING_MORE));
            } else {
                pbCommenFloorItemViewHolder.k.setText(K.b());
            }
        } else {
            pbCommenFloorItemViewHolder.k.setVisibility(8);
        }
        TextView textView = pbCommenFloorItemViewHolder.e0;
        textView.setText(((Object) pbCommenFloorItemViewHolder.f34876h.getText()) + "  • ");
    }

    public final void u0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048617, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.W.setVisibility(postData.Z ? 0 : 8);
    }

    public final void v0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048618, this, pbCommenFloorItemViewHolder, postData, view, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.v.setVisibility(8);
        pbCommenFloorItemViewHolder.a0.setVisibility(0);
        pbCommenFloorItemViewHolder.p.setVisibility(0);
        pbCommenFloorItemViewHolder.d0.setVisibility(8);
        pbCommenFloorItemViewHolder.t.setVisibility(8);
        pbCommenFloorItemViewHolder.u.setVisibility(8);
        pbCommenFloorItemViewHolder.l.setVisibility(8);
        pbCommenFloorItemViewHolder.g0.setVisibility(8);
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
        if (!(interceptable == null || interceptable.invokeLL(1048619, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || postData.q() == null) {
            return;
        }
        postData.q().threadId = this.i.w().k1();
        postData.q().objType = 1;
        postData.q().isInPost = true;
        ThreadData threadData = null;
        c.a.p0.w2.i.f fVar = this.t;
        if (fVar != null && fVar.O() != null) {
            threadData = this.t.O();
        }
        if (threadData != null && threadData.isUgcThreadType()) {
            pbCommenFloorItemViewHolder.l.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.l.setThreadData(threadData);
        pbCommenFloorItemViewHolder.l.setData(postData.q());
        pbCommenFloorItemViewHolder.b0.setThreadData(threadData);
        pbCommenFloorItemViewHolder.b0.setData(postData.q());
    }

    public final void x0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048620, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.P == null || pbCommenFloorItemViewHolder.M == null) {
            return;
        }
        if (postData != null && (alaLiveInfoCoreData = postData.R) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
            pbCommenFloorItemViewHolder.P.setText(postData.R.liveTitle);
            pbCommenFloorItemViewHolder.M.setTag(postData.R);
            pbCommenFloorItemViewHolder.M.setVisibility(0);
            StatisticItem statisticItem = new StatisticItem("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(statisticItem);
            return;
        }
        pbCommenFloorItemViewHolder.M.setVisibility(8);
    }

    public final void y0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048621, this, pbCommenFloorItemViewHolder, postData, view, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.R() > 0) {
            pbCommenFloorItemViewHolder.s.setVisibility(8);
        } else {
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.s.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            }
            sparseArray.put(R.id.obfuscated_res_0x7f091e85, postData);
            if (postData.E() == 2) {
                pbCommenFloorItemViewHolder.s.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.s.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.r.setVisibility(8);
        }
        ImageView imageView = pbCommenFloorItemViewHolder.t;
        if (imageView != null) {
            SparseArray sparseArray2 = (SparseArray) imageView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                pbCommenFloorItemViewHolder.t.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.obfuscated_res_0x7f091e85, postData);
        }
        ImageView imageView2 = pbCommenFloorItemViewHolder.u;
        if (imageView2 != null) {
            SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                pbCommenFloorItemViewHolder.u.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.obfuscated_res_0x7f091e85, postData);
        }
        pbCommenFloorItemViewHolder.r.setVisibility(8);
        if (!postData.b0() && !postData.a0(false)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.q.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.q.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setVisibility(8);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.q.getLayoutParams();
            layoutParams2.topMargin = c.a.d.f.p.n.f(this.a, R.dimen.tbds10);
            layoutParams2.leftMargin = c.a.d.f.p.n.f(this.a, R.dimen.tbds148);
            layoutParams2.rightMargin = c.a.d.f.p.n.f(this.a, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = c.a.d.f.p.n.f(this.a, R.dimen.tbds20);
            pbCommenFloorItemViewHolder.q.setLayoutParams(layoutParams2);
            if (this.z == null) {
                c.a.p0.w2.m.h.b bVar = new c.a.p0.w2.m.h.b(this.a);
                this.z = bVar;
                bVar.f(this.m);
                this.z.h(this.u);
                this.z.e(this.v);
                String str = null;
                c.a.p0.w2.i.f fVar = this.t;
                if (fVar != null && fVar.O() != null && this.t.O().getAuthor() != null) {
                    str = this.t.O().getAuthor().getUserId();
                }
                boolean z = true;
                z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                c.a.p0.w2.i.f fVar2 = this.t;
                if (fVar2 != null) {
                    this.z.j(fVar2.V(), z);
                    this.z.i(this.t.O());
                }
            }
            this.z.g(postData.G());
            pbCommenFloorItemViewHolder.q.setSubPbAdapter(this.z);
            pbCommenFloorItemViewHolder.q.setVisibility(0);
            pbCommenFloorItemViewHolder.q.setData(postData, view);
            pbCommenFloorItemViewHolder.q.setChildOnClickListener(this.v);
            pbCommenFloorItemViewHolder.q.setChildOnLongClickListener(this.y);
            pbCommenFloorItemViewHolder.q.setChildOnTouchListener(this.G);
        }
        if (postData.N) {
            pbCommenFloorItemViewHolder.K.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.K.setVisibility(4);
        }
        pbCommenFloorItemViewHolder.s.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.p.getLayoutParams();
        layoutParams3.topMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
        layoutParams3.bottomMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
        if (pbCommenFloorItemViewHolder.r.getVisibility() == 8) {
            pbCommenFloorItemViewHolder.p.setVisibility(8);
        } else {
            pbCommenFloorItemViewHolder.p.setVisibility(0);
        }
        pbCommenFloorItemViewHolder.f0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f88));
    }

    public final void z0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048622, this, pbCommenFloorItemViewHolder, postData, view) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.n.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = c.a.d.f.p.n.f(this.a, R.dimen.M_W_X007);
        layoutParams.leftMargin = c.a.d.f.p.n.f(this.a, R.dimen.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        pbCommenFloorItemViewHolder.n.setPadding(0, 0, 0, 0);
        if (!this.q) {
            pbCommenFloorItemViewHolder.n.getLayoutStrategy().g(R.drawable.icon_click);
        } else {
            pbCommenFloorItemViewHolder.n.k0(null);
            pbCommenFloorItemViewHolder.n.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.n.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f081200);
        }
        pbCommenFloorItemViewHolder.n.getLayoutStrategy().x(R.drawable.pic_video);
        m0(pbCommenFloorItemViewHolder.n, view, !StringUtils.isNull(postData.u()));
        pbCommenFloorItemViewHolder.n.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.n.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbCommenFloorItemViewHolder.n.setIsFromCDN(this.m);
        pbCommenFloorItemViewHolder.n.setText(postData.N(), true, this.p);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.n.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091e69, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091e82, Boolean.FALSE);
        pbCommenFloorItemViewHolder.n.setTag(sparseArray);
        pbCommenFloorItemViewHolder.f34870b.setTag(R.id.obfuscated_res_0x7f091e7c, sparseArray);
        pbCommenFloorItemViewHolder.g0.setTag(sparseArray);
        pbCommenFloorItemViewHolder.c0.setTag(sparseArray);
    }
}
