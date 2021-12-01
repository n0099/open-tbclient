package c.a.r0.l4.k;

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
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class i extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final List<MediaFileInfo> f19530e;

    /* renamed from: f  reason: collision with root package name */
    public BaseFragmentActivity f19531f;

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f19532g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.l4.k.c f19533h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19534i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f19535j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f19536k;
    public View.OnClickListener l;
    public c.a.r0.l4.k.g m;
    public h n;
    public TbCameraView.i o;
    public TbCameraView.g p;
    public c.a.r0.k0.g q;
    public d r;

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f19537e;

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
            this.f19537e = iVar;
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
                this.f19537e.r.f19541d.cancelAnimation();
                this.f19537e.r.f19541d.setFrame(0);
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

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f19538e;

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
            this.f19538e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19538e.q.I();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public View f19539b;

        /* renamed from: c  reason: collision with root package name */
        public TbCameraView f19540c;

        /* renamed from: d  reason: collision with root package name */
        public TBLottieAnimationView f19541d;

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

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public MediaFileInfo f19542e;

        /* renamed from: f  reason: collision with root package name */
        public int f19543f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f19544g;

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
            this.f19544g = iVar;
            this.f19542e = mediaFileInfo;
            this.f19543f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.pic) {
                    if (this.f19544g.m == null || this.f19542e == null) {
                        return;
                    }
                    this.f19544g.m.a(this.f19543f, this.f19542e);
                } else if (view.getId() == R.id.lay_select) {
                    if (this.f19542e == null || this.f19544g.n == null) {
                        return;
                    }
                    this.f19544g.n.a(this.f19543f, this.f19542e);
                } else if (view.getId() != R.id.video_thumb || this.f19544g.n == null || this.f19542e == null) {
                } else {
                    this.f19544g.n.a(this.f19543f, this.f19542e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f19545b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19546c;

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

    /* loaded from: classes6.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f19547b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f19548c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f19549d;

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

    public i(BaseFragmentActivity baseFragmentActivity, c.a.r0.l4.k.c cVar) {
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
        this.f19530e = new ArrayList();
        this.f19534i = false;
        this.f19535j = true;
        this.f19536k = true;
        this.f19531f = baseFragmentActivity;
        this.f19533h = cVar;
        this.f19532g = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: e */
    public MediaFileInfo getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (MediaFileInfo) ListUtils.getItem(this.f19530e, i2) : (MediaFileInfo) invokeI.objValue;
    }

    public final View f(int i2, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, mediaFileInfo})) == null) {
            if (mediaFileInfo == null || mediaFileInfo.getType() != 2) {
                return view;
            }
            d dVar = this.r;
            if (dVar == null || dVar.f19540c == null) {
                this.r = new d(this, null);
                View inflate = this.f19532g.inflate(R.layout.album_make_picture_view, viewGroup, false);
                d dVar2 = this.r;
                dVar2.a = inflate;
                dVar2.f19540c = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.r.f19541d = (TBLottieAnimationView) inflate.findViewById(R.id.anim_make_photo);
                this.r.f19539b = inflate.findViewById(R.id.icon_placer_holder);
                this.r.f19541d.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.r.f19541d.setFrame(0);
                this.r.f19541d.setRenderMode(RenderMode.HARDWARE);
                SkinManager.setLottieAnimation(this.r.f19541d, R.raw.lottie_photo);
                inflate.setTag(this.r);
                x(this.r.f19539b);
            }
            SkinManager.setBackgroundColor(this.r.a, R.color.black_alpha90);
            this.r.f19540c.setOnRequestPermissionListener(this.o);
            this.r.f19540c.setOnOpenCameraFailedListener(this.p);
            this.r.f19541d.setOnClickListener(this.l);
            this.r.f19540c.setOnClickListener(this.l);
            this.r.a.setOnClickListener(this.l);
            this.r.f19541d.addAnimatorUpdateListener(new a(this));
            this.r.f19541d.addAnimatorListener(new b(this));
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
                    View inflate = this.f19532g.inflate(R.layout.album_image_item_view, viewGroup, false);
                    gVar2.a = inflate;
                    TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.pic);
                    gVar2.f19547b = tbImageView;
                    tbImageView.setDefaultResource(0);
                    gVar2.f19547b.setTagPaddingDis(8, 8);
                    gVar2.f19547b.setGifIconSupport(true);
                    gVar2.f19547b.setLongIconSupport(true);
                    gVar2.f19548c = (ImageView) inflate.findViewById(R.id.select_icon);
                    gVar2.f19549d = (RelativeLayout) inflate.findViewById(R.id.lay_select);
                    c.a.r0.l4.k.c cVar = this.f19533h;
                    if (cVar != null && cVar.m() != null && this.f19533h.m().isFromQRCode()) {
                        gVar2.f19549d.setVisibility(8);
                    }
                    if (!this.f19536k) {
                        gVar2.f19549d.setVisibility(8);
                    }
                    inflate.setTag(gVar2);
                    gVar = gVar2;
                    view = inflate;
                }
                gVar.f19547b.setIsLongPic(imageFileInfo.isLong());
                gVar.f19547b.startLoad(imageFileInfo.getFilePath(), 35, false);
                s(gVar.f19548c, mediaFileInfo);
                e eVar = new e(this, mediaFileInfo, i2);
                gVar.f19547b.setOnClickListener(eVar);
                gVar.f19549d.setOnClickListener(eVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ListUtils.getCount(this.f19530e) : invokeV.intValue;
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
            MediaFileInfo mediaFileInfo = (MediaFileInfo) ListUtils.getItem(this.f19530e, i2);
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
                    View inflate = this.f19532g.inflate(R.layout.album_video_item_view, viewGroup, false);
                    fVar2.a = inflate;
                    TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.video_thumb);
                    fVar2.f19545b = tbImageView;
                    tbImageView.setDefaultResource(0);
                    fVar2.f19545b.setTagPaddingDis(8, 8);
                    fVar2.f19545b.setGifIconSupport(false);
                    fVar2.f19545b.setLongIconSupport(false);
                    fVar2.f19546c = (TextView) inflate.findViewById(R.id.video_play_time);
                    inflate.setTag(fVar2);
                    fVar = fVar2;
                    view = inflate;
                }
                fVar.f19545b.startLoad(videoFileInfo.videoPath, 37, false);
                fVar.f19546c.setText(StringHelper.stringForVideoTime(videoFileInfo.videoDuration));
                fVar.f19545b.setOnClickListener(new e(this, mediaFileInfo, i2));
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
            if (imageFileInfo != null && imageFileInfo.getFilePath() != null && (list = this.f19530e) != null && list.size() != 0) {
                String filePath = imageFileInfo.getFilePath();
                int size = this.f19530e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MediaFileInfo mediaFileInfo = this.f19530e.get(i2);
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
                return dVar.f19540c;
            }
            return null;
        }
        return (TbCameraView) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f19534i : invokeV.booleanValue;
    }

    public final MediaFileInfo l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new AddMediaInfo() : (MediaFileInfo) invokeV.objValue;
    }

    public void m(List<MediaFileInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            this.f19530e.clear();
            if (this.f19535j) {
                this.f19530e.add(l());
            }
            if (!ListUtils.isEmpty(list)) {
                this.f19530e.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public void n(c.a.r0.l4.k.g gVar) {
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
            this.f19534i = z;
        }
    }

    public final void s(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, imageView, mediaFileInfo) == null) {
            c.a.r0.l4.k.c cVar = this.f19533h;
            if (cVar != null && (mediaFileInfo instanceof ImageFileInfo)) {
                q = cVar.n((ImageFileInfo) mediaFileInfo);
            } else {
                c.a.r0.l4.k.c cVar2 = this.f19533h;
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
            imageView.setContentDescription(this.f19531f.getResources().getString(R.string.check_box_checked));
            imageView.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_set_list_ok_selection26, WebPManager.ResourceStateType.NORMAL));
            return;
        }
        imageView.setContentDescription(this.f19531f.getResources().getString(R.string.check_box_not_checked));
        imageView.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_set_list_ok26, WebPManager.ResourceStateType.NORMAL));
    }

    public void u(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, hVar) == null) {
            this.n = hVar;
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || this.f19535j == z) {
            return;
        }
        this.f19535j = z;
        notifyDataSetChanged();
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f19536k = z;
        }
    }

    public void x(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view) == null) {
            if (this.q == null && view != null) {
                c.a.r0.k0.g gVar = new c.a.r0.k0.g(this.f19531f.getPageContext(), view);
                this.q = gVar;
                gVar.g0(R.drawable.bg_tip_blue_up_left);
                this.q.M(new c(this));
                this.q.O(16);
                this.q.N(5000);
            }
            if (this.q != null) {
                String n = c.a.q0.s.e0.b.n("key_show_take_photo_tip");
                this.q.m0(this.f19531f.getString(R.string.album_take_photo_tip), n);
            }
        }
    }
}
