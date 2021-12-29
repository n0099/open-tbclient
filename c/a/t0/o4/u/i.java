package c.a.t0.o4.u;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.RenderMode;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.album.AddMediaInfo;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final List<MediaFileInfo> f21865e;

    /* renamed from: f  reason: collision with root package name */
    public BaseFragmentActivity f21866f;

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f21867g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.o4.u.c f21868h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21869i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f21870j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f21871k;
    public View.OnClickListener l;
    public c.a.t0.o4.u.g m;
    public h n;
    public TbCameraView.i o;
    public TbCameraView.g p;
    public c.a.t0.k0.g q;
    public d r;

    /* loaded from: classes8.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f21872e;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21872e = iVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f21872e.r.f21876d.cancelAnimation();
                this.f21872e.r.f21876d.setFrame(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f21873e;

        public c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21873e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21873e.q.I();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public View f21874b;

        /* renamed from: c  reason: collision with root package name */
        public TbCameraView f21875c;

        /* renamed from: d  reason: collision with root package name */
        public TBLottieAnimationView f21876d;

        public d(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(i iVar, a aVar) {
            this(iVar);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public MediaFileInfo f21877e;

        /* renamed from: f  reason: collision with root package name */
        public int f21878f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f21879g;

        public e(i iVar, MediaFileInfo mediaFileInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, mediaFileInfo, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21879g = iVar;
            this.f21877e = mediaFileInfo;
            this.f21878f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == c.a.t0.o4.g.pic) {
                    if (this.f21879g.m == null || this.f21877e == null) {
                        return;
                    }
                    this.f21879g.m.a(this.f21878f, this.f21877e);
                } else if (view.getId() == c.a.t0.o4.g.lay_select) {
                    if (this.f21877e == null || this.f21879g.n == null) {
                        return;
                    }
                    this.f21879g.n.a(this.f21878f, this.f21877e);
                } else if (view.getId() != c.a.t0.o4.g.video_thumb || this.f21879g.n == null || this.f21877e == null) {
                } else {
                    this.f21879g.n.a(this.f21878f, this.f21877e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f21880b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f21881c;

        public f(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(i iVar, a aVar) {
            this(iVar);
        }
    }

    /* loaded from: classes8.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f21882b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f21883c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f21884d;

        public g(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(i iVar, a aVar) {
            this(iVar);
        }
    }

    public i(BaseFragmentActivity baseFragmentActivity, c.a.t0.o4.u.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21865e = new ArrayList();
        this.f21869i = false;
        this.f21870j = true;
        this.f21871k = true;
        this.f21866f = baseFragmentActivity;
        this.f21868h = cVar;
        this.f21867g = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: e */
    public MediaFileInfo getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (MediaFileInfo) ListUtils.getItem(this.f21865e, i2) : (MediaFileInfo) invokeI.objValue;
    }

    public final View f(int i2, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, mediaFileInfo})) == null) {
            if (mediaFileInfo == null || mediaFileInfo.getType() != 2) {
                return view;
            }
            d dVar = this.r;
            if (dVar == null || dVar.f21875c == null) {
                this.r = new d(this, null);
                View inflate = this.f21867g.inflate(c.a.t0.o4.h.album_make_picture_view, viewGroup, false);
                d dVar2 = this.r;
                dVar2.a = inflate;
                dVar2.f21875c = (TbCameraView) inflate.findViewById(c.a.t0.o4.g.camera_surfaceview);
                this.r.f21876d = (TBLottieAnimationView) inflate.findViewById(c.a.t0.o4.g.anim_make_photo);
                this.r.f21874b = inflate.findViewById(c.a.t0.o4.g.icon_placer_holder);
                this.r.f21876d.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.r.f21876d.setFrame(0);
                this.r.f21876d.setRenderMode(RenderMode.HARDWARE);
                SkinManager.setLottieAnimation(this.r.f21876d, c.a.t0.o4.i.lottie_photo);
                inflate.setTag(this.r);
                x(this.r.f21874b);
            }
            SkinManager.setBackgroundColor(this.r.a, c.a.t0.o4.d.black_alpha90);
            this.r.f21875c.setOnRequestPermissionListener(this.o);
            this.r.f21875c.setOnOpenCameraFailedListener(this.p);
            this.r.f21876d.setOnClickListener(this.l);
            this.r.f21875c.setOnClickListener(this.l);
            this.r.a.setOnClickListener(this.l);
            this.r.f21876d.addAnimatorUpdateListener(new a(this));
            this.r.f21876d.addAnimatorListener(new b(this));
            return this.r.a;
        }
        return (View) invokeCommon.objValue;
    }

    public final View g(int i2, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        InterceptResult invokeCommon;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, mediaFileInfo})) == null) {
            if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (view != null && (view.getTag() instanceof g)) {
                    gVar = (g) view.getTag();
                } else {
                    g gVar2 = new g(this, null);
                    View inflate = this.f21867g.inflate(c.a.t0.o4.h.album_image_item_view, viewGroup, false);
                    gVar2.a = inflate;
                    TbImageView tbImageView = (TbImageView) inflate.findViewById(c.a.t0.o4.g.pic);
                    gVar2.f21882b = tbImageView;
                    tbImageView.setDefaultResource(0);
                    gVar2.f21882b.setTagPaddingDis(8, 8);
                    gVar2.f21882b.setGifIconSupport(true);
                    gVar2.f21882b.setLongIconSupport(true);
                    gVar2.f21883c = (ImageView) inflate.findViewById(c.a.t0.o4.g.select_icon);
                    gVar2.f21884d = (RelativeLayout) inflate.findViewById(c.a.t0.o4.g.lay_select);
                    c.a.t0.o4.u.c cVar = this.f21868h;
                    if (cVar != null && cVar.m() != null && this.f21868h.m().isFromQRCode()) {
                        gVar2.f21884d.setVisibility(8);
                    }
                    if (!this.f21871k) {
                        gVar2.f21884d.setVisibility(8);
                    }
                    inflate.setTag(gVar2);
                    gVar = gVar2;
                    view = inflate;
                }
                gVar.f21882b.setIsLongPic(imageFileInfo.isLong());
                gVar.f21882b.startLoad(imageFileInfo.getFilePath(), 35, false);
                s(gVar.f21883c, mediaFileInfo);
                e eVar = new e(this, mediaFileInfo, i2);
                gVar.f21882b.setOnClickListener(eVar);
                gVar.f21884d.setOnClickListener(eVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ListUtils.getCount(this.f21865e) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            MediaFileInfo mediaFileInfo = (MediaFileInfo) ListUtils.getItem(this.f21865e, i2);
            if (mediaFileInfo != null) {
                return mediaFileInfo.getType();
            }
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            MediaFileInfo item = getItem(i2);
            if (item == null) {
                return view;
            }
            if (item.getType() == 2) {
                return f(i2, view, viewGroup, item);
            }
            if (item.getType() == 1) {
                return h(i2, view, viewGroup, item);
            }
            return item.getType() == 0 ? g(i2, view, viewGroup, item) : view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    public final View h(int i2, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        InterceptResult invokeCommon;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), view, viewGroup, mediaFileInfo})) == null) {
            if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (view != null && (view.getTag() instanceof g)) {
                    fVar = (f) view.getTag();
                } else {
                    f fVar2 = new f(this, null);
                    View inflate = this.f21867g.inflate(c.a.t0.o4.h.album_video_item_view, viewGroup, false);
                    fVar2.a = inflate;
                    TbImageView tbImageView = (TbImageView) inflate.findViewById(c.a.t0.o4.g.video_thumb);
                    fVar2.f21880b = tbImageView;
                    tbImageView.setDefaultResource(0);
                    fVar2.f21880b.setTagPaddingDis(8, 8);
                    fVar2.f21880b.setGifIconSupport(false);
                    fVar2.f21880b.setLongIconSupport(false);
                    fVar2.f21881c = (TextView) inflate.findViewById(c.a.t0.o4.g.video_play_time);
                    inflate.setTag(fVar2);
                    fVar = fVar2;
                    view = inflate;
                }
                fVar.f21880b.startLoad(videoFileInfo.videoPath, 37, false);
                fVar.f21881c.setText(StringHelper.stringForVideoTime(videoFileInfo.videoDuration));
                fVar.f21880b.setOnClickListener(new e(this, mediaFileInfo, i2));
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public int i(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        List<MediaFileInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, imageFileInfo)) == null) {
            if (imageFileInfo != null && imageFileInfo.getFilePath() != null && (list = this.f21865e) != null && list.size() != 0) {
                String filePath = imageFileInfo.getFilePath();
                int size = this.f21865e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MediaFileInfo mediaFileInfo = this.f21865e.get(i2);
                    if (mediaFileInfo instanceof ImageFileInfo) {
                        ImageFileInfo imageFileInfo2 = (ImageFileInfo) mediaFileInfo;
                        if (imageFileInfo2.getFilePath() != null && imageFileInfo2.getFilePath().equals(filePath)) {
                            return i2;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public TbCameraView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d dVar = this.r;
            if (dVar != null) {
                return dVar.f21875c;
            }
            return null;
        }
        return (TbCameraView) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f21869i : invokeV.booleanValue;
    }

    public final MediaFileInfo l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new AddMediaInfo() : (MediaFileInfo) invokeV.objValue;
    }

    public void m(List<MediaFileInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            this.f21865e.clear();
            if (this.f21870j) {
                this.f21865e.add(l());
            }
            if (!ListUtils.isEmpty(list)) {
                this.f21865e.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public void n(c.a.t0.o4.u.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, gVar) == null) {
            this.m = gVar;
        }
    }

    public void o(TbCameraView.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gVar) == null) {
            this.p = gVar;
        }
    }

    public void p(TbCameraView.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, iVar) == null) {
            this.o = iVar;
        }
    }

    public void q(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f21869i = z;
        }
    }

    public final void s(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, imageView, mediaFileInfo) == null) {
            c.a.t0.o4.u.c cVar = this.f21868h;
            if (cVar != null && (mediaFileInfo instanceof ImageFileInfo)) {
                q = cVar.n((ImageFileInfo) mediaFileInfo);
            } else {
                c.a.t0.o4.u.c cVar2 = this.f21868h;
                q = (cVar2 == null || !(mediaFileInfo instanceof VideoFileInfo)) ? false : cVar2.q((VideoFileInfo) mediaFileInfo);
            }
            t(imageView, q);
        }
    }

    public void t(ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048597, this, imageView, z) == null) || imageView == null) {
            return;
        }
        if (z) {
            imageView.setContentDescription(this.f21866f.getResources().getString(c.a.t0.o4.j.check_box_checked));
            imageView.setImageDrawable(WebPManager.getMaskDrawable(c.a.t0.o4.f.icon_mask_set_list_ok_selection26, WebPManager.ResourceStateType.NORMAL));
            return;
        }
        imageView.setContentDescription(this.f21866f.getResources().getString(c.a.t0.o4.j.check_box_not_checked));
        imageView.setImageDrawable(WebPManager.getMaskDrawable(c.a.t0.o4.f.icon_mask_set_list_ok26, WebPManager.ResourceStateType.NORMAL));
    }

    public void u(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, hVar) == null) {
            this.n = hVar;
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || this.f21870j == z) {
            return;
        }
        this.f21870j = z;
        notifyDataSetChanged();
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f21871k = z;
        }
    }

    public void x(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view) == null) {
            if (this.q == null && view != null) {
                c.a.t0.k0.g gVar = new c.a.t0.k0.g(this.f21866f.getPageContext(), view);
                this.q = gVar;
                gVar.g0(c.a.t0.o4.f.bg_tip_blue_up_left);
                this.q.M(new c(this));
                this.q.O(16);
                this.q.N(5000);
            }
            if (this.q != null) {
                String n = c.a.s0.s.g0.b.n("key_show_take_photo_tip");
                this.q.m0(this.f21866f.getString(c.a.t0.o4.j.album_take_photo_tip), n);
            }
        }
    }
}
