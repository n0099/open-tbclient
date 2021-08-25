package c.a.q0.i2.k.g.f;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.k;
import c.a.p0.s.q.c2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b extends c.a.q0.i2.k.g.f.a<PostData, PbCommenFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.e.e.k.b<ConstrainImageLayout> A;
    public c.a.e.e.k.b<TbImageView> B;
    public c2 o;
    public TbRichTextView.t p;
    public boolean q;
    public String r;
    public View.OnClickListener s;
    public TbRichTextView.z t;
    public c.a.q0.i2.i.c u;
    public View.OnLongClickListener v;
    public c.a.q0.i2.k.e.a1.c w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a implements c.a.e.e.k.c<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f19888a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19888a = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
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
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.f19888a.m.getPageContext().getPageActivity()) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* renamed from: c.a.q0.i2.k.g.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0937b implements c.a.e.e.k.c<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f19889a;

        public C0937b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19889a = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
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
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.f19889a.m.getPageContext().getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
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
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f19890e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f19891f;

        public c(b bVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19891f = bVar;
            this.f19890e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray sparseArray;
            PostData postData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && this.f19890e.getView() != null) {
                    this.f19890e.getView().setTag(R.id.tag_subpb_ban_display_keyboard, Boolean.TRUE);
                }
                this.f19891f.s.onClick(this.f19890e.getView());
                if (view != null) {
                    view.setTag(R.id.tag_subpb_ban_display_keyboard, null);
                }
                if (this.f19890e.getView() != null) {
                    this.f19890e.getView().setTag(R.id.tag_subpb_ban_display_keyboard, null);
                }
                if (this.f19890e.getView() == null || (sparseArray = (SparseArray) this.f19890e.getView().getTag(R.id.tag_from)) == null || !(sparseArray.get(R.id.tag_clip_board) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null || postData.t() == null || postData.q() == null) {
                    return;
                }
                c.a.q0.i2.k.g.e.a(postData.q().threadId, postData.t().getUserId(), postData.E());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f19892e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f19893f;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostData f19894e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f19895f;

            public a(d dVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19895f = dVar;
                this.f19894e = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.f19895f;
                    b bVar = dVar.f19893f;
                    bVar.w.f19263b.a(null, bVar.o, this.f19894e, dVar.f19892e.mRichTextView.getLayoutStrategy());
                }
            }
        }

        public d(b bVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19893f = bVar;
            this.f19892e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) == null || this.f19892e.pbItemViewRoot == null || this.f19893f.w == null) {
                    return;
                }
                c.a.e.e.m.e.a().postDelayed(new a(this, postData), 100L);
                String f0 = this.f19893f.o.f0();
                if (StringUtils.isNull(f0) || "0".equals(f0)) {
                    f0 = this.f19893f.o.D0();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", f0).param("fid", this.f19893f.o.T()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.E()).param("obj_source", 1).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f19896e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f19897f;

        public e(b bVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19897f = bVar;
            this.f19896e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f19897f.o == null || (pbCommenFloorItemViewHolder = this.f19896e) == null || (agreeView = pbCommenFloorItemViewHolder.mBottomAgreeView) == null || agreeView.getData() == null) {
                return;
            }
            int i2 = view == this.f19896e.mBottomAgreeView.getImgAgree() ? 1 : 2;
            String f0 = this.f19897f.o.f0();
            if (StringUtils.isNull(f0) || "0".equals(f0)) {
                f0 = this.f19897f.o.D0();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", f0).param("fid", this.f19897f.o.T()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f19896e.mBottomAgreeView.getData().postId).param("obj_source", 1).param("obj_type", i2));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f19898e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f19899f;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostData f19900e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f19901f;

            public a(f fVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19901f = fVar;
                this.f19900e = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    f fVar = this.f19901f;
                    b bVar = fVar.f19899f;
                    bVar.w.f19263b.a(null, bVar.o, this.f19900e, fVar.f19898e.mRichTextView.getLayoutStrategy());
                }
            }
        }

        public f(b bVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19899f = bVar;
            this.f19898e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) == null || this.f19898e.pbItemViewRoot == null || this.f19899f.w == null) {
                    return;
                }
                c.a.e.e.m.e.a().postDelayed(new a(this, postData), 100L);
                String f0 = this.f19899f.o.f0();
                if (StringUtils.isNull(f0) || "0".equals(f0)) {
                    f0 = this.f19899f.o.D0();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", f0).param("fid", this.f19899f.o.T()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.E()).param("obj_source", 1).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f19902e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f19903f;

        public g(b bVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19903f = bVar;
            this.f19902e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f19903f.o == null || (pbCommenFloorItemViewHolder = this.f19902e) == null || (agreeView = pbCommenFloorItemViewHolder.mPbFloorPraiseView) == null || agreeView.getData() == null) {
                return;
            }
            int i2 = view == this.f19902e.mPbFloorPraiseView.getImgAgree() ? 1 : 2;
            String f0 = this.f19903f.o.f0();
            if (StringUtils.isNull(f0) || "0".equals(f0)) {
                f0 = this.f19903f.o.D0();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", f0).param("fid", this.f19903f.o.T()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f19902e.mPbFloorPraiseView.getData().postId).param("obj_source", 1).param("obj_type", i2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.q0.i2.k.a) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = null;
        this.p = null;
        this.q = k.c().g();
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = c.a.p0.b.d.x0();
        this.z = false;
        this.A = new c.a.e.e.k.b<>(new a(this), 6, 0);
        this.B = new c.a.e.e.k.b<>(new C0937b(this), 12, 0);
        if (newSubPbActivity == null || newSubPbActivity.getSubPbModel() == null) {
            return;
        }
        this.x = newSubPbActivity.getSubPbModel().t0();
    }

    @Override // c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        q0(i2, view, viewGroup, (PostData) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view;
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onLongClickListener) == null) {
            this.v = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public final void i0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.mRichTextView.setTextViewOnTouchListener(this.u);
            pbCommenFloorItemViewHolder.mRichTextView.setTextViewCheckSelection(false);
        }
    }

    public final void j0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pbCommenFloorItemViewHolder) == null) {
            if (pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            layoutParams.height = c.a.q0.i2.k.b.i(R.dimen.tbds2);
            layoutParams.leftMargin = c.a.q0.i2.k.b.i(R.dimen.tbds148);
            if (this.y) {
                layoutParams.topMargin = c.a.q0.i2.k.b.i(R.dimen.tbds0);
            }
            pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
            ColumnLayout columnLayout = (ColumnLayout) pbCommenFloorItemViewHolder.getView().findViewById(R.id.item_head_owner_root);
            if (columnLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams2 = (RelativeLayout.LayoutParams) columnLayout.getLayoutParams();
            } else {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            }
            layoutParams2.leftMargin = c.a.q0.i2.k.b.i(R.dimen.tbds21);
            layoutParams2.rightMargin = c.a.q0.i2.k.b.i(R.dimen.tbds1);
            columnLayout.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.mRichTextView.setCommonTextViewOnClickListener(new c(this, pbCommenFloorItemViewHolder));
        }
    }

    public final void k0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, pbCommenFloorItemViewHolder, postData, i2) == null) {
            if (this.y) {
                View view = pbCommenFloorItemViewHolder.mBottomCommentContainer;
                if (view != null) {
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        pbCommenFloorItemViewHolder.mBottomCommentContainer.setTag(sparseArray);
                    }
                    sparseArray.put(R.id.tag_load_sub_data, postData);
                }
                View view2 = pbCommenFloorItemViewHolder.mBottomShareContainer;
                if (view2 != null) {
                    SparseArray sparseArray2 = (SparseArray) view2.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        pbCommenFloorItemViewHolder.mBottomShareContainer.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                }
            }
            ImageView imageView = pbCommenFloorItemViewHolder.mCommentView;
            if (imageView != null) {
                SparseArray sparseArray3 = (SparseArray) imageView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.mCommentView.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, postData);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.mShareView;
            if (imageView2 != null) {
                SparseArray sparseArray4 = (SparseArray) imageView2.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    pbCommenFloorItemViewHolder.mShareView.setTag(sparseArray4);
                }
                sparseArray4.put(R.id.tag_load_sub_data, postData);
                sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.m0));
            }
        }
    }

    public final void l0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.mImgGodComment.setVisibility(postData.b0 ? 0 : 8);
    }

    public final void m0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder, postData, view, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.mPosition = i2;
        c.a.q0.i2.k.b.h(pbCommenFloorItemViewHolder, postData, view, i2, this.m, this.o, this.y, i2 == 0);
        c.a.q0.i2.k.b.e(pbCommenFloorItemViewHolder, postData, this.o, i2, this.y);
        if (this.y && postData.m0) {
            pbCommenFloorItemViewHolder.mPostReplyContainer.setVisibility(8);
            pbCommenFloorItemViewHolder.mTrisectionContainer.setVisibility(0);
            if (this.o.z2()) {
                pbCommenFloorItemViewHolder.mFeedBackImg.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.mFeedBackImg.setVisibility(0);
            }
        } else {
            pbCommenFloorItemViewHolder.mTrisectionContainer.setVisibility(8);
            pbCommenFloorItemViewHolder.mPostReplyContainer.setVisibility(0);
            pbCommenFloorItemViewHolder.mCommentView.setVisibility(0);
            pbCommenFloorItemViewHolder.mShareView.setVisibility(0);
            pbCommenFloorItemViewHolder.mPbFloorPraiseView.setVisibility(0);
            pbCommenFloorItemViewHolder.mFeedBackImg.setVisibility(8);
        }
        c.a.q0.i2.k.b.c(pbCommenFloorItemViewHolder, postData, postData.m0, this.y);
        c.a.q0.i2.k.b.f(this.m, pbCommenFloorItemViewHolder, postData, view, this.q, this.n, i2 != 0, this.p);
        c.a.q0.i2.k.b.d(this.m, pbCommenFloorItemViewHolder, postData, this.o);
        c.a.q0.i2.k.b.g(pbCommenFloorItemViewHolder, postData);
        c.a.q0.i2.k.b.b(pbCommenFloorItemViewHolder, postData, this.q);
        l0(pbCommenFloorItemViewHolder, postData);
    }

    public final void n0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.pbItemViewRoot == null) {
            return;
        }
        if (StringHelper.equals(this.r, postData.E())) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.pbItemViewRoot, R.color.CAM_X0313);
        } else {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.pbItemViewRoot, R.color.CAM_X0205);
        }
    }

    public final void o0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048586, this, pbCommenFloorItemViewHolder, postData, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (i2 == 0) {
            pbCommenFloorItemViewHolder.updateUegInfo(postData.S, postData.E(), this.z);
        } else {
            pbCommenFloorItemViewHolder.updateUegInfo(postData.q0 == 1, postData.E(), this.z);
        }
    }

    public void p(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, zVar) == null) {
            this.t = zVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: p0 */
    public PbCommenFloorItemViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f2966e).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.pb_post_reply_container)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.m.getPageContext(), inflate, this.x);
            pbCommenFloorItemViewHolder.setIsSubPb(true);
            pbCommenFloorItemViewHolder.mImagesView.setConstrainLayoutPool(this.A);
            pbCommenFloorItemViewHolder.mImagesView.setImageViewPool(this.B);
            j0(pbCommenFloorItemViewHolder);
            c.a.q0.i2.k.b.k(pbCommenFloorItemViewHolder, null, this.y);
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View q0(int i2, View view, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            k0(pbCommenFloorItemViewHolder, postData, i2);
            r0(pbCommenFloorItemViewHolder);
            i0(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) z(i2);
            if (postData2 != null) {
                postData2.B0();
                m0(pbCommenFloorItemViewHolder, postData2, view, i2);
                n0(pbCommenFloorItemViewHolder, postData);
                o0(pbCommenFloorItemViewHolder, postData, i2);
            }
            c.a.q0.i2.k.b.k(pbCommenFloorItemViewHolder, null, this.y);
            pbCommenFloorItemViewHolder.mBottomLine.setVisibility(i2 == 0 ? 8 : 0);
            if (postData2 != null && postData2.t() != null && postData2.q() != null) {
                c.a.q0.i2.k.g.e.b(String.valueOf(postData2.q().threadId), postData2.t().getUserId(), postData2.E());
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void r0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.pbItemViewRoot.setOnLongClickListener(this.v);
            c.a.q0.i2.k.a aVar = this.m;
            if (aVar == null || aVar.getPageContext().getOrignalPage() == null) {
                return;
            }
            c.a.q0.i2.k.e.a1.a eventController = this.m.getEventController();
            if (eventController != null) {
                pbCommenFloorItemViewHolder.mUserNameView.setOnClickListener(eventController.f19238b);
                pbCommenFloorItemViewHolder.mHeadPhotoView.setOnClickListener(eventController.f19238b);
                pbCommenFloorItemViewHolder.mPendantHeadView.setOnClickListener(eventController.f19238b);
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setOnClickListener(eventController.f19238b);
                pbCommenFloorItemViewHolder.mRichTextView.setOnEmotionClickListener(eventController.f19241e);
            }
            pbCommenFloorItemViewHolder.mRichTextView.setOnLongClickListener(this.v);
            pbCommenFloorItemViewHolder.mRichTextView.setOnImageClickListener(this.t);
            pbCommenFloorItemViewHolder.mRichTextView.setOnClickListener(this.s);
            pbCommenFloorItemViewHolder.getView().setOnClickListener(this.s);
            pbCommenFloorItemViewHolder.mTailContent.setOnClickListener(this.s);
            pbCommenFloorItemViewHolder.mRecommendLiveLayout.setOnClickListener(this.s);
            if (this.w == null) {
                this.w = new c.a.q0.i2.k.e.a1.c(this.m.getPageContext());
            }
            if (this.y) {
                pbCommenFloorItemViewHolder.mBottomCommentContainer.setOnClickListener(this.s);
                pbCommenFloorItemViewHolder.mBottomShareContainer.setOnClickListener(new d(this, pbCommenFloorItemViewHolder));
                pbCommenFloorItemViewHolder.mBottomAgreeView.mAfterManualClickListener = new e(this, pbCommenFloorItemViewHolder);
            }
            pbCommenFloorItemViewHolder.mCommentView.setOnClickListener(this.s);
            pbCommenFloorItemViewHolder.mShareView.setOnClickListener(new f(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.mPbFloorPraiseView.mAfterManualClickListener = new g(this, pbCommenFloorItemViewHolder);
            if (this.y) {
                pbCommenFloorItemViewHolder.mFeedBackImg.setOnClickListener(this.s);
            }
        }
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.z = z;
        }
    }

    public void t0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.r = str;
        }
    }

    public void u0(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, c2Var) == null) {
            this.o = c2Var;
        }
    }
}
