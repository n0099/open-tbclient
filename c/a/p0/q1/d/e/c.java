package c.a.p0.q1.d.e;

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
import c.a.p0.h0.b0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class c extends c.a.d.o.e.a<c.a.p0.h0.e0.b, ThreadCardViewHolder<c.a.p0.h0.e0.b>> implements c.a.p0.v.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public c.a.d.o.e.s l;
    public boolean m;
    public c.a.d.f.k.b<ImageView> n;
    public c.a.d.f.k.b<GifView> o;
    public b0<c.a.p0.h0.e0.b> p;

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    if (c.a.o0.r.l.c().g()) {
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
                    foreDrawableImageView.N();
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
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.j.getPageActivity());
                boolean g2 = c.a.o0.r.l.c().g();
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
                    foreDrawableImageView.N();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.F();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (c.a.o0.r.l.c().g()) {
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
                gifView.Y();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.j.getPageActivity());
                boolean g2 = c.a.o0.r.l.c().g();
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
                gifView.b0();
                gifView.Y();
                gifView.setImageDrawable(null);
                gifView.c0();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }
    }

    /* renamed from: c.a.p0.q1.d.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1290c extends b0<c.a.p0.h0.e0.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f17162b;

        public C1290c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17162b = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.h0.b0
        /* renamed from: d */
        public void a(View view, c.a.p0.h0.e0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, bVar) == null) {
                this.f17162b.n0(view, bVar);
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.l.d.b
        public void a(c.a.o0.r.r.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) || aVar == null) {
                return;
            }
            if (view.getId() == R.id.obfuscated_res_0x7f0922bb) {
                aVar.objType = 3;
            } else if (view.getId() == R.id.obfuscated_res_0x7f092296) {
                aVar.objType = 4;
            } else {
                aVar.objType = 1;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.a.d.o.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof c.a.d.o.e.g) && (view.getTag() instanceof ThreadCardViewHolder)) {
                c.a.d.o.e.g gVar = (c.a.d.o.e.g) nVar;
                if (gVar.e() instanceof c.a.p0.h0.e0.b) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    c.a.p0.h0.e0.b bVar = (c.a.p0.h0.e0.b) gVar.e();
                    bVar.f15320f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), bVar);
                    }
                    if (c.a.p0.q1.i.n.a.a(this.a.j, gVar.e())) {
                        return;
                    }
                    ThreadCardUtils.jumpToPB((c.a.o0.r.r.a) bVar, view.getContext(), 1, false, c.a.l.e.a((c.a.d.o.e.s) viewGroup, view, i));
                    threadCardViewHolder.c().o(new a.C0196a(1));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements c.a.d.o.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof c.a.d.o.e.g) && (view.getTag() instanceof ThreadCardViewHolder)) {
                c.a.d.o.e.g gVar = (c.a.d.o.e.g) nVar;
                if (gVar.e() instanceof c.a.p0.h0.e0.b) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    c.a.p0.h0.e0.b bVar = (c.a.p0.h0.e0.b) gVar.e();
                    bVar.f15320f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), bVar);
                    }
                    ThreadCardUtils.jumpToPB((c.a.o0.r.r.a) bVar, view.getContext(), 1, false);
                    threadCardViewHolder.c().o(new a.C0196a(1));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements c.a.d.o.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.l.s a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f17163b;

        public g(c cVar, c.a.l.s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17163b = cVar;
            this.a = sVar;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c.a.p0.h0.e0.b bVar;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = nVar instanceof c.a.d.o.e.g;
                if (z) {
                    c.a.d.o.e.g gVar = (c.a.d.o.e.g) nVar;
                    if ((gVar.e() instanceof c.a.p0.h0.e0.b) && nVar != null && gVar.e() != null && (bVar = (c.a.p0.h0.e0.b) gVar.e()) != null && (threadData = bVar.a) != null && bVar.u && threadData.getItem() != null) {
                        if (bVar.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast.i(this.f17163b.j.getContext(), this.f17163b.j.getString(R.string.obfuscated_res_0x7f0f14d0), R.drawable.obfuscated_res_0x7f08099f, true).q();
                            return;
                        }
                        int a = c.a.o0.r.l0.p.c.a(bVar.a.getItem().button_link_type.intValue(), bVar.a.getItem().apk_detail != null ? bVar.a.getItem().apk_detail.pkg_source.intValue() : 0);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(bVar.a.getItem());
                        ItemCardHelper.q(this.a.u(), bVar.a.getItem().item_id.longValue(), this.a.t(itemData), bVar.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(bVar.a.getItem().forum_name, String.valueOf(bVar.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view.getTag() instanceof ThreadCardViewHolder)) {
                    c.a.d.o.e.g gVar2 = (c.a.d.o.e.g) nVar;
                    if (gVar2.e() instanceof c.a.p0.h0.e0.b) {
                        ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                        c.a.p0.h0.e0.b bVar2 = (c.a.p0.h0.e0.b) gVar2.e();
                        bVar2.f15320f = 1;
                        if (this.f17163b.p != null) {
                            this.f17163b.p.a(threadCardViewHolder.b(), bVar2);
                        }
                        ThreadCardUtils.jumpToPB((c.a.o0.r.r.a) bVar2, view.getContext(), 1, false, c.a.l.e.a((c.a.d.o.e.s) viewGroup, view, i));
                        threadCardViewHolder.c().o(new a.C0196a(1));
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements c.a.d.o.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof c.a.d.o.e.g) && (view.getTag() instanceof ThreadCardViewHolder)) {
                c.a.d.o.e.g gVar = (c.a.d.o.e.g) nVar;
                if (gVar.e() instanceof c.a.p0.h0.e0.b) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    c.a.p0.h0.e0.b bVar = (c.a.p0.h0.e0.b) gVar.e();
                    bVar.f15320f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), bVar);
                    }
                    ThreadCardUtils.jumpToPB((c.a.o0.r.r.a) bVar, view.getContext(), 1, false, c.a.l.e.a((c.a.d.o.e.s) viewGroup, view, i));
                    threadCardViewHolder.c().o(new a.C0196a(1));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17164b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f17165c;

        public i(c cVar, ViewGroup viewGroup, View view, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, viewGroup, view, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.f17164b = view;
            this.f17165c = i;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(c.a.l.e.a((c.a.d.o.e.s) this.a, this.f17164b, this.f17165c));
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
        this.m = true;
        this.n = new c.a.d.f.k.b<>(new a(this), 12, 0);
        this.o = new c.a.d.f.k.b<>(new b(this), 20, 0);
        this.p = new C1290c(this);
        this.j = tbPageContext;
        c0();
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.p0.h0.e0.k.R = "c10705";
            c.a.p0.h0.e0.k.S = "c10730";
            c.a.p0.h0.e0.k.T = "c10731";
            c.a.p0.h0.e0.k.U = "c10704";
            c.a.p0.h0.e0.k.V = "c10755";
            c.a.p0.h0.e0.k.W = "c10710";
            c.a.p0.h0.e0.k.X = "c10736";
            c.a.p0.h0.e0.k.Y = "c10737";
            c.a.p0.h0.e0.k.Z = "c10711";
            c.a.p0.h0.e0.k.g0 = "c10758";
            c.a.p0.h0.e0.k.h0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: d0 */
    public ThreadCardViewHolder<c.a.p0.h0.e0.b> I(ViewGroup viewGroup, c.a.p0.h0.e0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, viewGroup, bVar)) == null) {
            l0.b bVar2 = new l0.b(this.j.getPageActivity(), false);
            n0 n0Var = new n0(this.j.getPageActivity());
            c.a.o0.r.r.f fVar = new c.a.o0.r.r.f();
            fVar.f10852b = 9;
            fVar.f10858h = 9;
            n0Var.v(fVar);
            n0Var.w(4);
            n0Var.B("personalize_page");
            n0Var.A(4);
            n0Var.x(1);
            n0Var.b(32);
            bVar2.m(n0Var);
            l0 k = bVar2.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<c.a.p0.h0.e0.b> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: e0 */
    public ThreadCardViewHolder<c.a.p0.h0.e0.b> J(ViewGroup viewGroup, c.a.p0.h0.e0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, viewGroup, bVar)) == null) {
            l0.b bVar2 = new l0.b(this.j.getPageActivity(), false);
            if (bVar.o) {
                c.a.l.o oVar = new c.a.l.o(this.j.getPageActivity());
                oVar.C(this.n, this.o);
                oVar.x(ImageViewerConfig.FROM_CONCERN);
                oVar.z(1);
                oVar.y(this.m);
                oVar.w(1);
                bVar2.n(oVar);
            } else if (bVar.p) {
                c.a.l.y yVar = new c.a.l.y(this.j.getPageActivity());
                yVar.q(ImageViewerConfig.FROM_CONCERN);
                yVar.r(this.m);
                bVar2.n(yVar);
            } else if (bVar.q) {
                c.a.l.v vVar = new c.a.l.v(this.j.getPageActivity());
                vVar.s(ImageViewerConfig.FROM_CONCERN);
                vVar.t(this.m);
                bVar2.n(vVar);
            } else if (bVar.r) {
                c.a.l.z zVar = new c.a.l.z(this.j.getPageActivity());
                zVar.r(ImageViewerConfig.FROM_CONCERN);
                zVar.s(this.m);
                bVar2.n(zVar);
            } else {
                boolean z = bVar.s;
            }
            l0 k = bVar2.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<c.a.p0.h0.e0.b> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: f0 */
    public ThreadCardViewHolder<c.a.p0.h0.e0.b> K(ViewGroup viewGroup, c.a.p0.h0.e0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, viewGroup, bVar)) == null) {
            l0.b bVar2 = new l0.b(this.j.getPageActivity(), false);
            c.a.l.s sVar = new c.a.l.s(this.j.getPageActivity());
            sVar.z(2);
            sVar.s();
            sVar.w(true);
            bVar2.h(sVar);
            bVar2.h(new h0(this.j.getPageActivity()));
            bVar2.h(new c.a.l.a0(this.j.getPageActivity()));
            c.a.l.k kVar = new c.a.l.k(this.j.getPageActivity());
            kVar.t();
            bVar2.h(kVar);
            c.a.l.n nVar = new c.a.l.n(this.j.getPageActivity());
            nVar.x(this.m);
            nVar.w(ImageViewerConfig.FROM_CONCERN);
            bVar2.h(nVar);
            l0 k = bVar2.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<c.a.p0.h0.e0.b> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new g(this, sVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    @Override // c.a.p0.v.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.k = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: g0 */
    public ThreadCardViewHolder<c.a.p0.h0.e0.b> L(ViewGroup viewGroup, c.a.p0.h0.e0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, viewGroup, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            l0.b bVar2 = new l0.b(this.j.getPageActivity());
            if (bVar.m) {
                c.a.l.d dVar = new c.a.l.d(this.j.getPageActivity());
                dVar.t(this.i);
                dVar.b(128);
                dVar.c(1024);
                dVar.s(new d(this));
                bVar2.o(dVar);
            } else if (bVar.n) {
                bVar2.o(new c.a.l.m(this.j.getPageActivity()));
            }
            l0 k = bVar2.k(BaseCardInfo.SupportType.TOP, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<c.a.p0.h0.e0.b> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
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
    @Override // c.a.d.o.e.a
    /* renamed from: i0 */
    public View O(int i2, View view, ViewGroup viewGroup, c.a.p0.h0.e0.b bVar, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, threadCardViewHolder})) == null) {
            if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || bVar.a == null) {
                return null;
            }
            bVar.I(bVar.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c().f() instanceof n0) {
                ((n0) threadCardViewHolder.c().f()).z(new i(this, viewGroup, view, i2));
            }
            if (threadCardViewHolder.c() instanceof c.a.p0.v.e) {
                threadCardViewHolder.c().e(this.k);
            }
            threadCardViewHolder.u(false, Align.ALIGN_RIGHT_BOTTOM);
            threadCardViewHolder.g(bVar);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: j0 */
    public View P(int i2, View view, ViewGroup viewGroup, c.a.p0.h0.e0.b bVar, ThreadCardViewHolder<c.a.p0.h0.e0.b> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, threadCardViewHolder})) == null) {
            if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || bVar.a == null) {
                return null;
            }
            bVar.I(bVar.position + 1);
            c.a.p0.h0.u.b().a(bVar.g("c12351"));
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof c.a.p0.v.e) {
                threadCardViewHolder.c().e(this.k);
            }
            if (bVar.p) {
                c.a.l.y yVar = (c.a.l.y) threadCardViewHolder.c().g();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.f3502f.f25144d.getLayoutParams();
                layoutParams.width = bVar.j;
                layoutParams.height = bVar.k;
                if (yVar.f3502f.f25144d.getVisibility() != 8) {
                    yVar.f3502f.f25144d.setLayoutParams(layoutParams);
                }
            }
            threadCardViewHolder.g(bVar);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: k0 */
    public View Q(int i2, View view, ViewGroup viewGroup, c.a.p0.h0.e0.b bVar, ThreadCardViewHolder<c.a.p0.h0.e0.b> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, threadCardViewHolder})) == null) {
            if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || bVar.a == null) {
                return null;
            }
            bVar.I(bVar.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof c.a.p0.v.e) {
                threadCardViewHolder.c().e(this.k);
            }
            if (bVar.y) {
                c.a.p0.h0.u.b().a(new StatisticItem("c13424"));
            }
            threadCardViewHolder.g(bVar);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: l0 */
    public View R(int i2, View view, ViewGroup viewGroup, c.a.p0.h0.e0.b bVar, ThreadCardViewHolder<c.a.p0.h0.e0.b> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, threadCardViewHolder})) == null) {
            if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || bVar.a == null) {
                return null;
            }
            bVar.I(bVar.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof c.a.p0.v.e) {
                threadCardViewHolder.c().e(this.k);
            }
            if (bVar.m) {
                threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
            } else if (bVar.n) {
                c.a.p0.h0.u.b().a(bVar.B());
                c.a.p0.v.d.c().a(bVar.B());
                c.a.p0.q1.i.m.a.h(bVar.a, this.i, bVar.q());
            }
            threadCardViewHolder.g(bVar);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: m0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.p0.h0.e0.b bVar, ThreadCardViewHolder<c.a.p0.h0.e0.b> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void n0(View view, c.a.p0.h0.e0.b bVar) {
        StatisticItem A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, view, bVar) == null) || view == null || bVar == null || bVar.getThreadData() == null || StringUtils.isNull(bVar.getThreadData().getTid())) {
            return;
        }
        int id = view.getId();
        int i2 = 1;
        if (bVar.m) {
            if (id == R.id.obfuscated_res_0x7f091f9a) {
                c.a.p0.q1.d.c.b(view, bVar, 2);
            } else if (id == R.id.obfuscated_res_0x7f092296 || id == R.id.obfuscated_res_0x7f0922bb) {
                c.a.p0.q1.d.c.b(view, bVar, 1);
            }
        } else if (bVar.n) {
            c.a.p0.h0.u.b().d(true);
            if (id != R.id.obfuscated_res_0x7f090a44 && id != R.id.obfuscated_res_0x7f090a43 && id != R.id.obfuscated_res_0x7f090a45 && id != R.id.obfuscated_res_0x7f090a46) {
                if (bVar.isVideoThreadType()) {
                    A = bVar.C();
                } else {
                    A = bVar.A();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
                c.a.p0.v.d.c().i("page_concern", "clk_", A);
            } else {
                TiebaStatic.log(bVar.k());
                c.a.p0.v.d.c().i("page_concern", "clk_", bVar.k());
                i2 = 9;
            }
            c.a.p0.q1.i.m.a.d(bVar.a, this.i, bVar.q(), i2);
        } else if (!bVar.o && !bVar.p && !bVar.q && !bVar.r) {
            if (!bVar.u) {
                if (bVar.v) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    if (threadCardViewHolder != null) {
                        ThreadCardUtils.jumpToPB((c.a.o0.r.r.a) bVar.getThreadData(), view.getContext(), 1, false);
                        threadCardViewHolder.c().o(new a.C0196a(1));
                    }
                } else if (!bVar.w) {
                    if (bVar.x) {
                        if (view.getId() == R.id.obfuscated_res_0x7f091f9a) {
                            c.a.p0.q1.d.c.b(view, bVar, 2);
                        } else if (id == R.id.obfuscated_res_0x7f090a68) {
                            c.a.p0.q1.d.c.b(view, bVar, 7);
                        }
                    } else if (bVar.y) {
                        if (view.getId() == R.id.obfuscated_res_0x7f091f9a) {
                            c.a.p0.q1.d.c.b(view, bVar, 2);
                        } else if (id == R.id.obfuscated_res_0x7f090cd2) {
                            StatisticItem statisticItem = new StatisticItem("c13423");
                            statisticItem.param("obj_locate", 4);
                            statisticItem.param("tid", bVar.f15321g);
                            ThreadData threadData = bVar.a;
                            if (threadData != null && threadData.getTopAgreePost() != null) {
                                statisticItem.param("pid", bVar.a.getTopAgreePost().G());
                            }
                            TiebaStatic.log(statisticItem);
                        } else if (id == R.id.obfuscated_res_0x7f090ccd) {
                            StatisticItem statisticItem2 = new StatisticItem("c13423");
                            statisticItem2.param("obj_locate", 2);
                            statisticItem2.param("tid", bVar.f15321g);
                            ThreadData threadData2 = bVar.a;
                            if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                                statisticItem2.param("pid", bVar.a.getTopAgreePost().G());
                            }
                            TiebaStatic.log(statisticItem2);
                        } else if (id == R.id.obfuscated_res_0x7f090cd0 || id == R.id.obfuscated_res_0x7f090cd1) {
                            StatisticItem statisticItem3 = new StatisticItem("c13423");
                            statisticItem3.param("obj_locate", 1);
                            statisticItem3.param("tid", bVar.f15321g);
                            ThreadData threadData3 = bVar.a;
                            if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                statisticItem3.param("pid", bVar.a.getTopAgreePost().G());
                            }
                            TiebaStatic.log(statisticItem3);
                        } else if (id == R.id.obfuscated_res_0x7f090ccc) {
                            StatisticItem statisticItem4 = new StatisticItem("c13423");
                            statisticItem4.param("obj_locate", 5);
                            statisticItem4.param("tid", bVar.f15321g);
                            ThreadData threadData4 = bVar.a;
                            if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                statisticItem4.param("pid", bVar.a.getTopAgreePost().G());
                            }
                            TiebaStatic.log(statisticItem4);
                        } else if ((view instanceof TbImageView) && (view.getTag(R.id.obfuscated_res_0x7f090cce) instanceof Integer)) {
                            StatisticItem statisticItem5 = new StatisticItem("c13423");
                            statisticItem5.param("obj_locate", 3);
                            statisticItem5.param("tid", bVar.f15321g);
                            ThreadData threadData5 = bVar.a;
                            if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                                statisticItem5.param("pid", bVar.a.getTopAgreePost().G());
                            }
                            TiebaStatic.log(statisticItem5);
                        }
                    } else if (bVar.A && (view.getId() == R.id.obfuscated_res_0x7f091f9a || view.getId() == R.id.obfuscated_res_0x7f091fac)) {
                        c.a.p0.q1.d.c.b(view, bVar, 2);
                    }
                }
            }
        } else if (view.getId() == R.id.obfuscated_res_0x7f091f9a) {
            c.a.p0.q1.d.c.b(view, bVar, 2);
        } else if (view instanceof TbImageView) {
            c.a.p0.q1.d.c.b(view, bVar, 3);
        } else if (view.getId() == R.id.obfuscated_res_0x7f091f9b || view.getId() == R.id.obfuscated_res_0x7f091f8d) {
            c.a.p0.q1.d.c.b(view, bVar, 2);
        }
        if (id == R.id.obfuscated_res_0x7f091fac || id == R.id.obfuscated_res_0x7f091faf || id == R.id.obfuscated_res_0x7f091fb0) {
            c.a.p0.q1.d.c.b(view, bVar, 8);
        }
    }

    public void o0(c.a.d.o.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, sVar) == null) {
            this.l = sVar;
        }
    }

    @Override // c.a.d.o.e.a
    public BdUniqueId v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? c.a.p0.h0.e0.b.M : (BdUniqueId) invokeV.objValue;
    }

    @Override // c.a.d.o.e.a
    public BdUniqueId w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? c.a.p0.h0.e0.b.I : (BdUniqueId) invokeV.objValue;
    }

    @Override // c.a.d.o.e.a
    public BdUniqueId x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? c.a.p0.h0.e0.b.L : (BdUniqueId) invokeV.objValue;
    }

    @Override // c.a.d.o.e.a
    public BdUniqueId y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? c.a.p0.h0.e0.b.D : (BdUniqueId) invokeV.objValue;
    }
}
