package c.a.t0.o1.c.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import c.a.l.d;
import c.a.l.h0;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.w0.a;
import c.a.s0.s.q.e2;
import c.a.t0.g0.d0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c extends c.a.d.n.e.a<c.a.t0.g0.f0.b, ThreadCardViewHolder<c.a.t0.g0.f0.b>> implements c.a.t0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public c.a.d.n.e.s p;
    public boolean q;
    public c.a.d.f.k.b<ImageView> r;
    public c.a.d.f.k.b<GifView> s;
    public d0<c.a.t0.g0.f0.b> t;

    /* loaded from: classes8.dex */
    public class a implements c.a.d.f.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (c.a.s0.s.k.c().g()) {
                        tbImageView.setAdjustViewBounds(false);
                        tbImageView.setInterceptOnClick(false);
                    } else {
                        tbImageView.setDefaultResource(R.drawable.icon_click);
                        tbImageView.setAdjustViewBounds(true);
                        tbImageView.setInterceptOnClick(true);
                    }
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, imageView) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.n.getPageActivity());
                boolean g2 = c.a.s0.s.k.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g2) {
                    foreDrawableImageView.setAdjustViewBounds(false);
                    foreDrawableImageView.setInterceptOnClick(false);
                } else {
                    foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                    foreDrawableImageView.setAdjustViewBounds(true);
                    foreDrawableImageView.setInterceptOnClick(true);
                }
                return foreDrawableImageView;
            }
            return (ImageView) invokeV.objValue;
        }

        public ImageView h(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imageView)) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.reset();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements c.a.d.f.k.c<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        public GifView e(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) {
                gifView.setTag(null);
                if (c.a.s0.s.k.c().g()) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.onDestroy();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.n.getPageActivity());
                boolean g2 = c.a.s0.s.k.c().g();
                gifView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g2) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }
            return (GifView) invokeV.objValue;
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.release();
                gifView.onDestroy();
                gifView.setImageDrawable(null);
                gifView.resetDefaultNoImageDay();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }
    }

    /* renamed from: c.a.t0.o1.c.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1267c extends d0<c.a.t0.g0.f0.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f20157b;

        public C1267c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20157b = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.g0.d0
        /* renamed from: d */
        public void a(View view, c.a.t0.g0.f0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, bVar) == null) {
                this.f20157b.n0(view, bVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.l.d.b
        public void a(c.a.s0.s.q.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) || aVar == null) {
                return;
            }
            if (view.getId() == R.id.user_name) {
                aVar.objType = 3;
            } else if (view.getId() == R.id.user_avatar) {
                aVar.objType = 4;
            } else {
                aVar.objType = 1;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements c.a.d.n.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20158e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20158e = cVar;
        }

        @Override // c.a.d.n.e.w
        public void b(View view, c.a.d.n.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.d.n.e.g) && (view.getTag() instanceof ThreadCardViewHolder)) {
                c.a.d.n.e.g gVar = (c.a.d.n.e.g) nVar;
                if (gVar.g() instanceof c.a.t0.g0.f0.b) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    c.a.t0.g0.f0.b bVar = (c.a.t0.g0.f0.b) gVar.g();
                    bVar.k = 1;
                    if (this.f20158e.t != null) {
                        this.f20158e.t.a(threadCardViewHolder.getView(), bVar);
                    }
                    if (c.a.t0.o1.h.n.a.a(this.f20158e.n, gVar.g())) {
                        return;
                    }
                    ThreadCardUtils.jumpToPB((c.a.s0.s.q.a) bVar, view.getContext(), 1, false, c.a.l.e.a((c.a.d.n.e.s) viewGroup, view, i2));
                    threadCardViewHolder.getCardView().o(new a.C0195a(1));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements c.a.d.n.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20159e;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20159e = cVar;
        }

        @Override // c.a.d.n.e.w
        public void b(View view, c.a.d.n.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.d.n.e.g) && (view.getTag() instanceof ThreadCardViewHolder)) {
                c.a.d.n.e.g gVar = (c.a.d.n.e.g) nVar;
                if (gVar.g() instanceof c.a.t0.g0.f0.b) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    c.a.t0.g0.f0.b bVar = (c.a.t0.g0.f0.b) gVar.g();
                    bVar.k = 1;
                    if (this.f20159e.t != null) {
                        this.f20159e.t.a(threadCardViewHolder.getView(), bVar);
                    }
                    ThreadCardUtils.jumpToPB((c.a.s0.s.q.a) bVar, view.getContext(), 1, false);
                    threadCardViewHolder.getCardView().o(new a.C0195a(1));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements c.a.d.n.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.l.s f20160e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f20161f;

        public g(c cVar, c.a.l.s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20161f = cVar;
            this.f20160e = sVar;
        }

        @Override // c.a.d.n.e.w
        public void b(View view, c.a.d.n.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            c.a.t0.g0.f0.b bVar;
            e2 e2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                boolean z = nVar instanceof c.a.d.n.e.g;
                if (z) {
                    c.a.d.n.e.g gVar = (c.a.d.n.e.g) nVar;
                    if ((gVar.g() instanceof c.a.t0.g0.f0.b) && nVar != null && gVar.g() != null && (bVar = (c.a.t0.g0.f0.b) gVar.g()) != null && (e2Var = bVar.f17778e) != null && bVar.z && e2Var.t0() != null) {
                        if (bVar.f17778e.getType() == e2.Y3) {
                            BdToast.i(this.f20161f.n.getContext(), this.f20161f.n.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
                            return;
                        }
                        int a = c.a.s0.s.j0.p.c.a(bVar.f17778e.t0().button_link_type.intValue(), bVar.f17778e.t0().apk_detail != null ? bVar.f17778e.t0().apk_detail.pkg_source.intValue() : 0);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(bVar.f17778e.t0());
                        ItemCardHelper.q(this.f20160e.t(), bVar.f17778e.t0().item_id.longValue(), this.f20160e.s(itemData), bVar.f17778e.v1(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(bVar.f17778e.t0().forum_name, String.valueOf(bVar.f17778e.t0().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view.getTag() instanceof ThreadCardViewHolder)) {
                    c.a.d.n.e.g gVar2 = (c.a.d.n.e.g) nVar;
                    if (gVar2.g() instanceof c.a.t0.g0.f0.b) {
                        ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                        c.a.t0.g0.f0.b bVar2 = (c.a.t0.g0.f0.b) gVar2.g();
                        bVar2.k = 1;
                        if (this.f20161f.t != null) {
                            this.f20161f.t.a(threadCardViewHolder.getView(), bVar2);
                        }
                        ThreadCardUtils.jumpToPB((c.a.s0.s.q.a) bVar2, view.getContext(), 1, false, c.a.l.e.a((c.a.d.n.e.s) viewGroup, view, i2));
                        threadCardViewHolder.getCardView().o(new a.C0195a(1));
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements c.a.d.n.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20162e;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20162e = cVar;
        }

        @Override // c.a.d.n.e.w
        public void b(View view, c.a.d.n.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.d.n.e.g) && (view.getTag() instanceof ThreadCardViewHolder)) {
                c.a.d.n.e.g gVar = (c.a.d.n.e.g) nVar;
                if (gVar.g() instanceof c.a.t0.g0.f0.b) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    c.a.t0.g0.f0.b bVar = (c.a.t0.g0.f0.b) gVar.g();
                    bVar.k = 1;
                    if (this.f20162e.t != null) {
                        this.f20162e.t.a(threadCardViewHolder.getView(), bVar);
                    }
                    ThreadCardUtils.jumpToPB((c.a.s0.s.q.a) bVar, view.getContext(), 1, false, c.a.l.e.a((c.a.d.n.e.s) viewGroup, view, i2));
                    threadCardViewHolder.getCardView().o(new a.C0195a(1));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20163b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f20164c;

        public i(c cVar, ViewGroup viewGroup, View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, viewGroup, view, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.f20163b = view;
            this.f20164c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(c.a.l.e.a((c.a.d.n.e.s) this.a, this.f20163b, this.f20164c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = true;
        this.r = new c.a.d.f.k.b<>(new a(this), 12, 0);
        this.s = new c.a.d.f.k.b<>(new b(this), 20, 0);
        this.t = new C1267c(this);
        this.n = tbPageContext;
        c0();
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.t0.g0.f0.k.Y = "c10705";
            c.a.t0.g0.f0.k.Z = "c10730";
            c.a.t0.g0.f0.k.a0 = "c10731";
            c.a.t0.g0.f0.k.b0 = "c10704";
            c.a.t0.g0.f0.k.c0 = "c10755";
            c.a.t0.g0.f0.k.d0 = "c10710";
            c.a.t0.g0.f0.k.e0 = "c10736";
            c.a.t0.g0.f0.k.f0 = "c10737";
            c.a.t0.g0.f0.k.g0 = "c10711";
            c.a.t0.g0.f0.k.h0 = "c10758";
            c.a.t0.g0.f0.k.i0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: d0 */
    public ThreadCardViewHolder<c.a.t0.g0.f0.b> I(ViewGroup viewGroup, c.a.t0.g0.f0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, viewGroup, bVar)) == null) {
            l0.b bVar2 = new l0.b(this.n.getPageActivity(), false);
            n0 n0Var = new n0(this.n.getPageActivity());
            c.a.s0.s.q.f fVar = new c.a.s0.s.q.f();
            fVar.f13371b = 9;
            fVar.f13377h = 9;
            n0Var.u(fVar);
            n0Var.v(4);
            n0Var.A("personalize_page");
            n0Var.z(4);
            n0Var.w(1);
            n0Var.a(32);
            bVar2.m(n0Var);
            l0 k = bVar2.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.p);
            k.r(1);
            ThreadCardViewHolder<c.a.t0.g0.f0.b> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.m);
            V(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: e0 */
    public ThreadCardViewHolder<c.a.t0.g0.f0.b> J(ViewGroup viewGroup, c.a.t0.g0.f0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, viewGroup, bVar)) == null) {
            l0.b bVar2 = new l0.b(this.n.getPageActivity(), false);
            if (bVar.t) {
                c.a.l.o oVar = new c.a.l.o(this.n.getPageActivity());
                oVar.B(this.r, this.s);
                oVar.w(ImageViewerConfig.FROM_CONCERN);
                oVar.y(1);
                oVar.x(this.q);
                oVar.v(1);
                bVar2.n(oVar);
            } else if (bVar.u) {
                c.a.l.y yVar = new c.a.l.y(this.n.getPageActivity());
                yVar.p(ImageViewerConfig.FROM_CONCERN);
                yVar.q(this.q);
                bVar2.n(yVar);
            } else if (bVar.v) {
                c.a.l.v vVar = new c.a.l.v(this.n.getPageActivity());
                vVar.r(ImageViewerConfig.FROM_CONCERN);
                vVar.s(this.q);
                bVar2.n(vVar);
            } else if (bVar.w) {
                c.a.l.z zVar = new c.a.l.z(this.n.getPageActivity());
                zVar.q(ImageViewerConfig.FROM_CONCERN);
                zVar.r(this.q);
                bVar2.n(zVar);
            } else {
                boolean z = bVar.x;
            }
            l0 k = bVar2.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.p);
            k.r(1);
            ThreadCardViewHolder<c.a.t0.g0.f0.b> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.m);
            V(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: f0 */
    public ThreadCardViewHolder<c.a.t0.g0.f0.b> K(ViewGroup viewGroup, c.a.t0.g0.f0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, viewGroup, bVar)) == null) {
            l0.b bVar2 = new l0.b(this.n.getPageActivity(), false);
            c.a.l.s sVar = new c.a.l.s(this.n.getPageActivity());
            sVar.y(2);
            sVar.r();
            sVar.v(true);
            bVar2.h(sVar);
            bVar2.h(new h0(this.n.getPageActivity()));
            bVar2.h(new c.a.l.a0(this.n.getPageActivity()));
            c.a.l.k kVar = new c.a.l.k(this.n.getPageActivity());
            kVar.s();
            bVar2.h(kVar);
            c.a.l.n nVar = new c.a.l.n(this.n.getPageActivity());
            nVar.w(this.q);
            nVar.v(ImageViewerConfig.FROM_CONCERN);
            bVar2.h(nVar);
            l0 k = bVar2.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.p);
            k.r(1);
            ThreadCardViewHolder<c.a.t0.g0.f0.b> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.m);
            V(new g(this, sVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    @Override // c.a.t0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.o = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: g0 */
    public ThreadCardViewHolder<c.a.t0.g0.f0.b> L(ViewGroup viewGroup, c.a.t0.g0.f0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, viewGroup, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            l0.b bVar2 = new l0.b(this.n.getPageActivity());
            if (bVar.r) {
                c.a.l.d dVar = new c.a.l.d(this.n.getPageActivity());
                dVar.s(this.m);
                dVar.a(128);
                dVar.b(1024);
                dVar.r(new d(this));
                bVar2.o(dVar);
            } else if (bVar.s) {
                bVar2.o(new c.a.l.m(this.n.getPageActivity()));
            }
            l0 k = bVar2.k(BaseCardInfo.SupportType.TOP, viewGroup, this.p);
            k.r(1);
            ThreadCardViewHolder<c.a.t0.g0.f0.b> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.m);
            V(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, viewGroup)) == null) {
            return null;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: i0 */
    public View O(int i2, View view, ViewGroup viewGroup, c.a.t0.g0.f0.b bVar, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, threadCardViewHolder})) == null) {
            if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || bVar.f17778e == null) {
                return null;
            }
            bVar.K(bVar.position + 1);
            threadCardViewHolder.getCardView().q(i2);
            if (threadCardViewHolder.getCardView().f() instanceof n0) {
                ((n0) threadCardViewHolder.getCardView().f()).y(new i(this, viewGroup, view, i2));
            }
            if (threadCardViewHolder.getCardView() instanceof c.a.t0.t.e) {
                threadCardViewHolder.getCardView().d(this.o);
            }
            threadCardViewHolder.showUnfollowedDecorItemIfNeed(false, Align.ALIGN_RIGHT_BOTTOM);
            threadCardViewHolder.onBindDataToView(bVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.t);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: j0 */
    public View P(int i2, View view, ViewGroup viewGroup, c.a.t0.g0.f0.b bVar, ThreadCardViewHolder<c.a.t0.g0.f0.b> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, threadCardViewHolder})) == null) {
            if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || bVar.f17778e == null) {
                return null;
            }
            bVar.K(bVar.position + 1);
            c.a.t0.g0.v.b().a(bVar.i("c12351"));
            threadCardViewHolder.getCardView().q(i2);
            if (threadCardViewHolder.getCardView() instanceof c.a.t0.t.e) {
                threadCardViewHolder.getCardView().d(this.o);
            }
            if (bVar.u) {
                c.a.l.y yVar = (c.a.l.y) threadCardViewHolder.getCardView().g();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.f4231j.singalImg.getLayoutParams();
                layoutParams.width = bVar.o;
                layoutParams.height = bVar.p;
                if (yVar.f4231j.singalImg.getVisibility() != 8) {
                    yVar.f4231j.singalImg.setLayoutParams(layoutParams);
                }
            }
            threadCardViewHolder.onBindDataToView(bVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.t);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: k0 */
    public View Q(int i2, View view, ViewGroup viewGroup, c.a.t0.g0.f0.b bVar, ThreadCardViewHolder<c.a.t0.g0.f0.b> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, threadCardViewHolder})) == null) {
            if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || bVar.f17778e == null) {
                return null;
            }
            bVar.K(bVar.position + 1);
            threadCardViewHolder.getCardView().q(i2);
            if (threadCardViewHolder.getCardView() instanceof c.a.t0.t.e) {
                threadCardViewHolder.getCardView().d(this.o);
            }
            if (bVar.D) {
                c.a.t0.g0.v.b().a(new StatisticItem("c13424"));
            }
            threadCardViewHolder.onBindDataToView(bVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.t);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: l0 */
    public View R(int i2, View view, ViewGroup viewGroup, c.a.t0.g0.f0.b bVar, ThreadCardViewHolder<c.a.t0.g0.f0.b> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, threadCardViewHolder})) == null) {
            if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || bVar.f17778e == null) {
                return null;
            }
            bVar.K(bVar.position + 1);
            threadCardViewHolder.getCardView().q(i2);
            if (threadCardViewHolder.getCardView() instanceof c.a.t0.t.e) {
                threadCardViewHolder.getCardView().d(this.o);
            }
            if (bVar.r) {
                threadCardViewHolder.showUnfollowedDecorItemIfNeed(true, Align.ALIGN_RIGHT_TOP);
            } else if (bVar.s) {
                c.a.t0.g0.v.b().a(bVar.B());
                c.a.t0.t.d.c().a(bVar.B());
                c.a.t0.o1.h.m.a.f(bVar.f17778e, this.m, bVar.q());
            }
            threadCardViewHolder.onBindDataToView(bVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.t);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: m0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.t0.g0.f0.b bVar, ThreadCardViewHolder<c.a.t0.g0.f0.b> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void n0(View view, c.a.t0.g0.f0.b bVar) {
        StatisticItem A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, view, bVar) == null) || view == null || bVar == null || bVar.getThreadData() == null || StringUtils.isNull(bVar.getThreadData().v1())) {
            return;
        }
        int id = view.getId();
        int i2 = 1;
        if (bVar.r) {
            if (id == R.id.thread_card_root) {
                c.a.t0.o1.c.c.b(view, bVar, 2);
            } else if (id == R.id.user_avatar || id == R.id.user_name) {
                c.a.t0.o1.c.c.b(view, bVar, 1);
            }
        } else if (bVar.s) {
            c.a.t0.g0.v.b().d(true);
            if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread) {
                if (bVar.G()) {
                    A = bVar.D();
                } else {
                    A = bVar.A();
                }
                TiebaStatic.log(A);
                c.a.t0.t.d.c().i("page_concern", "clk_", A);
            } else {
                TiebaStatic.log(bVar.o());
                c.a.t0.t.d.c().i("page_concern", "clk_", bVar.o());
                i2 = 9;
            }
            c.a.t0.o1.h.m.a.c(bVar.f17778e, this.m, bVar.q(), i2);
        } else if (!bVar.t && !bVar.u && !bVar.v && !bVar.w) {
            if (!bVar.z) {
                if (bVar.A) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    if (threadCardViewHolder != null) {
                        ThreadCardUtils.jumpToPB((c.a.s0.s.q.a) bVar.getThreadData(), view.getContext(), 1, false);
                        threadCardViewHolder.getCardView().o(new a.C0195a(1));
                    }
                } else if (!bVar.B) {
                    if (bVar.C) {
                        if (view.getId() == R.id.thread_card_root) {
                            c.a.t0.o1.c.c.b(view, bVar, 2);
                        } else if (id == R.id.forum_name_text) {
                            c.a.t0.o1.c.c.b(view, bVar, 7);
                        }
                    } else if (bVar.D) {
                        if (view.getId() == R.id.thread_card_root) {
                            c.a.t0.o1.c.c.b(view, bVar, 2);
                        } else if (id == R.id.god_reply_voice_btn) {
                            StatisticItem statisticItem = new StatisticItem("c13423");
                            statisticItem.param("obj_locate", 4);
                            statisticItem.param("tid", bVar.l);
                            e2 e2Var = bVar.f17778e;
                            if (e2Var != null && e2Var.y1() != null) {
                                statisticItem.param("pid", bVar.f17778e.y1().G());
                            }
                            TiebaStatic.log(statisticItem);
                        } else if (id == R.id.god_reply_content) {
                            StatisticItem statisticItem2 = new StatisticItem("c13423");
                            statisticItem2.param("obj_locate", 2);
                            statisticItem2.param("tid", bVar.l);
                            e2 e2Var2 = bVar.f17778e;
                            if (e2Var2 != null && e2Var2.y1() != null) {
                                statisticItem2.param("pid", bVar.f17778e.y1().G());
                            }
                            TiebaStatic.log(statisticItem2);
                        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            if (id == R.id.god_reply_agree_view) {
                                StatisticItem statisticItem3 = new StatisticItem("c13423");
                                statisticItem3.param("obj_locate", 5);
                                statisticItem3.param("tid", bVar.l);
                                e2 e2Var3 = bVar.f17778e;
                                if (e2Var3 != null && e2Var3.y1() != null) {
                                    statisticItem3.param("pid", bVar.f17778e.y1().G());
                                }
                                TiebaStatic.log(statisticItem3);
                            } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                                StatisticItem statisticItem4 = new StatisticItem("c13423");
                                statisticItem4.param("obj_locate", 3);
                                statisticItem4.param("tid", bVar.l);
                                e2 e2Var4 = bVar.f17778e;
                                if (e2Var4 != null && e2Var4.y1() != null) {
                                    statisticItem4.param("pid", bVar.f17778e.y1().G());
                                }
                                TiebaStatic.log(statisticItem4);
                            }
                        } else {
                            StatisticItem statisticItem5 = new StatisticItem("c13423");
                            statisticItem5.param("obj_locate", 1);
                            statisticItem5.param("tid", bVar.l);
                            e2 e2Var5 = bVar.f17778e;
                            if (e2Var5 != null && e2Var5.y1() != null) {
                                statisticItem5.param("pid", bVar.f17778e.y1().G());
                            }
                            TiebaStatic.log(statisticItem5);
                        }
                    } else if (bVar.F && (view.getId() == R.id.thread_card_root || view.getId() == R.id.thread_info_commont_container)) {
                        c.a.t0.o1.c.c.b(view, bVar, 2);
                    }
                }
            }
        } else if (view.getId() == R.id.thread_card_root) {
            c.a.t0.o1.c.c.b(view, bVar, 2);
        } else if (view instanceof TbImageView) {
            c.a.t0.o1.c.c.b(view, bVar, 3);
        } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
            c.a.t0.o1.c.c.b(view, bVar, 2);
        }
        if (id == R.id.thread_info_commont_container || id == R.id.thread_info_commont_img || id == R.id.thread_info_commont_num) {
            c.a.t0.o1.c.c.b(view, bVar, 8);
        }
    }

    public void o0(c.a.d.n.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, sVar) == null) {
            this.p = sVar;
        }
    }

    @Override // c.a.d.n.e.a
    public BdUniqueId v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? c.a.t0.g0.f0.b.R : (BdUniqueId) invokeV.objValue;
    }

    @Override // c.a.d.n.e.a
    public BdUniqueId w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? c.a.t0.g0.f0.b.N : (BdUniqueId) invokeV.objValue;
    }

    @Override // c.a.d.n.e.a
    public BdUniqueId x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? c.a.t0.g0.f0.b.Q : (BdUniqueId) invokeV.objValue;
    }

    @Override // c.a.d.n.e.a
    public BdUniqueId y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? c.a.t0.g0.f0.b.I : (BdUniqueId) invokeV.objValue;
    }
}
