package c.a.p0.s4.k;

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
/* loaded from: classes2.dex */
public class i extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<MediaFileInfo> a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragmentActivity f18360b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f18361c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.s4.k.c f18362d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18363e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18364f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18365g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f18366h;
    public c.a.p0.s4.k.g i;
    public h j;
    public TbCameraView.g k;
    public TbCameraView.e l;
    public c.a.p0.l0.g m;
    public d n;

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes2.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
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
                this.a.n.f18369d.cancelAnimation();
                this.a.n.f18369d.setFrame(0);
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

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        public c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.m.I();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public View f18367b;

        /* renamed from: c  reason: collision with root package name */
        public TbCameraView f18368c;

        /* renamed from: d  reason: collision with root package name */
        public TBLottieAnimationView f18369d;

        public d(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(i iVar, a aVar) {
            this(iVar);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MediaFileInfo a;

        /* renamed from: b  reason: collision with root package name */
        public int f18370b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f18371c;

        public e(i iVar, MediaFileInfo mediaFileInfo, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, mediaFileInfo, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18371c = iVar;
            this.a = mediaFileInfo;
            this.f18370b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.obfuscated_res_0x7f091830) {
                    if (this.f18371c.i == null || this.a == null) {
                        return;
                    }
                    this.f18371c.i.a(this.f18370b, this.a);
                } else if (view.getId() == R.id.obfuscated_res_0x7f0911b8) {
                    if (this.a == null || this.f18371c.j == null) {
                        return;
                    }
                    this.f18371c.j.a(this.f18370b, this.a);
                } else if (view.getId() != R.id.obfuscated_res_0x7f092391 || this.f18371c.j == null || this.a == null) {
                } else {
                    this.f18371c.j.a(this.f18370b, this.a);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f18372b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f18373c;

        public f(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(i iVar, a aVar) {
            this(iVar);
        }
    }

    /* loaded from: classes2.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f18374b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f18375c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f18376d;

        public g(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(i iVar, a aVar) {
            this(iVar);
        }
    }

    public i(BaseFragmentActivity baseFragmentActivity, c.a.p0.s4.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f18363e = false;
        this.f18364f = true;
        this.f18365g = true;
        this.f18360b = baseFragmentActivity;
        this.f18362d = cVar;
        this.f18361c = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: e */
    public MediaFileInfo getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? (MediaFileInfo) ListUtils.getItem(this.a, i) : (MediaFileInfo) invokeI.objValue;
    }

    public final View f(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view, viewGroup, mediaFileInfo})) == null) {
            if (mediaFileInfo == null || mediaFileInfo.getType() != 2) {
                return view;
            }
            d dVar = this.n;
            if (dVar == null || dVar.f18368c == null) {
                this.n = new d(this, null);
                View inflate = this.f18361c.inflate(R.layout.obfuscated_res_0x7f0d011b, viewGroup, false);
                d dVar2 = this.n;
                dVar2.a = inflate;
                dVar2.f18368c = (TbCameraView) inflate.findViewById(R.id.obfuscated_res_0x7f09048a);
                this.n.f18369d = (TBLottieAnimationView) inflate.findViewById(R.id.obfuscated_res_0x7f090269);
                this.n.f18367b = inflate.findViewById(R.id.obfuscated_res_0x7f090e1e);
                this.n.f18369d.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.n.f18369d.setFrame(0);
                this.n.f18369d.setRenderMode(RenderMode.HARDWARE);
                SkinManager.setLottieAnimation(this.n.f18369d, R.raw.obfuscated_res_0x7f11002d);
                inflate.setTag(this.n);
                x(this.n.f18367b);
            }
            SkinManager.setBackgroundColor(this.n.a, R.color.black_alpha90);
            this.n.f18368c.setOnRequestPermissionListener(this.k);
            this.n.f18368c.setOnOpenCameraFailedListener(this.l);
            this.n.f18369d.setOnClickListener(this.f18366h);
            this.n.f18368c.setOnClickListener(this.f18366h);
            this.n.a.setOnClickListener(this.f18366h);
            this.n.f18369d.addAnimatorUpdateListener(new a(this));
            this.n.f18369d.addAnimatorListener(new b(this));
            return this.n.a;
        }
        return (View) invokeCommon.objValue;
    }

    public final View g(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        InterceptResult invokeCommon;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view, viewGroup, mediaFileInfo})) == null) {
            if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (view != null && (view.getTag() instanceof g)) {
                    gVar = (g) view.getTag();
                } else {
                    g gVar2 = new g(this, null);
                    View inflate = this.f18361c.inflate(R.layout.obfuscated_res_0x7f0d0118, viewGroup, false);
                    gVar2.a = inflate;
                    TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091830);
                    gVar2.f18374b = tbImageView;
                    tbImageView.setDefaultResource(0);
                    gVar2.f18374b.setTagPaddingDis(8, 8);
                    gVar2.f18374b.setGifIconSupport(true);
                    gVar2.f18374b.setLongIconSupport(true);
                    gVar2.f18375c = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091c77);
                    gVar2.f18376d = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0911b8);
                    c.a.p0.s4.k.c cVar = this.f18362d;
                    if (cVar != null && cVar.m() != null && this.f18362d.m().isFromQRCode()) {
                        gVar2.f18376d.setVisibility(8);
                    }
                    if (!this.f18365g) {
                        gVar2.f18376d.setVisibility(8);
                    }
                    inflate.setTag(gVar2);
                    gVar = gVar2;
                    view = inflate;
                }
                gVar.f18374b.setIsLongPic(imageFileInfo.isLong());
                gVar.f18374b.J(imageFileInfo.getFilePath(), 35, false);
                s(gVar.f18375c, mediaFileInfo);
                e eVar = new e(this, mediaFileInfo, i);
                gVar.f18374b.setOnClickListener(eVar);
                gVar.f18376d.setOnClickListener(eVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ListUtils.getCount(this.a) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            MediaFileInfo mediaFileInfo = (MediaFileInfo) ListUtils.getItem(this.a, i);
            if (mediaFileInfo != null) {
                return mediaFileInfo.getType();
            }
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view, viewGroup)) == null) {
            MediaFileInfo item = getItem(i);
            if (item == null) {
                return view;
            }
            if (item.getType() == 2) {
                return f(i, view, viewGroup, item);
            }
            if (item.getType() == 1) {
                return h(i, view, viewGroup, item);
            }
            return item.getType() == 0 ? g(i, view, viewGroup, item) : view;
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

    public final View h(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        InterceptResult invokeCommon;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view, viewGroup, mediaFileInfo})) == null) {
            if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (view != null && (view.getTag() instanceof g)) {
                    fVar = (f) view.getTag();
                } else {
                    f fVar2 = new f(this, null);
                    View inflate = this.f18361c.inflate(R.layout.obfuscated_res_0x7f0d011c, viewGroup, false);
                    fVar2.a = inflate;
                    TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092391);
                    fVar2.f18372b = tbImageView;
                    tbImageView.setDefaultResource(0);
                    fVar2.f18372b.setTagPaddingDis(8, 8);
                    fVar2.f18372b.setGifIconSupport(false);
                    fVar2.f18372b.setLongIconSupport(false);
                    fVar2.f18373c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092368);
                    inflate.setTag(fVar2);
                    fVar = fVar2;
                    view = inflate;
                }
                fVar.f18372b.J(videoFileInfo.videoPath, 37, false);
                fVar.f18373c.setText(StringHelper.stringForVideoTime(videoFileInfo.videoDuration));
                fVar.f18372b.setOnClickListener(new e(this, mediaFileInfo, i));
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
            if (imageFileInfo != null && imageFileInfo.getFilePath() != null && (list = this.a) != null && list.size() != 0) {
                String filePath = imageFileInfo.getFilePath();
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    MediaFileInfo mediaFileInfo = this.a.get(i);
                    if (mediaFileInfo instanceof ImageFileInfo) {
                        ImageFileInfo imageFileInfo2 = (ImageFileInfo) mediaFileInfo;
                        if (imageFileInfo2.getFilePath() != null && imageFileInfo2.getFilePath().equals(filePath)) {
                            return i;
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
            d dVar = this.n;
            if (dVar != null) {
                return dVar.f18368c;
            }
            return null;
        }
        return (TbCameraView) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f18363e : invokeV.booleanValue;
    }

    public final MediaFileInfo l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new AddMediaInfo() : (MediaFileInfo) invokeV.objValue;
    }

    public void m(List<MediaFileInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            this.a.clear();
            if (this.f18364f) {
                this.a.add(l());
            }
            if (!ListUtils.isEmpty(list)) {
                this.a.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public void n(c.a.p0.s4.k.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, gVar) == null) {
            this.i = gVar;
        }
    }

    public void o(TbCameraView.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eVar) == null) {
            this.l = eVar;
        }
    }

    public void p(TbCameraView.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, gVar) == null) {
            this.k = gVar;
        }
    }

    public void q(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.f18366h = onClickListener;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f18363e = z;
        }
    }

    public final void s(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, imageView, mediaFileInfo) == null) {
            c.a.p0.s4.k.c cVar = this.f18362d;
            if (cVar != null && (mediaFileInfo instanceof ImageFileInfo)) {
                q = cVar.n((ImageFileInfo) mediaFileInfo);
            } else {
                c.a.p0.s4.k.c cVar2 = this.f18362d;
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
            imageView.setContentDescription(this.f18360b.getResources().getString(R.string.obfuscated_res_0x7f0f03a7));
            imageView.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08081e, WebPManager.ResourceStateType.NORMAL));
            return;
        }
        imageView.setContentDescription(this.f18360b.getResources().getString(R.string.obfuscated_res_0x7f0f03a8));
        imageView.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08081d, WebPManager.ResourceStateType.NORMAL));
    }

    public void u(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, hVar) == null) {
            this.j = hVar;
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || this.f18364f == z) {
            return;
        }
        this.f18364f = z;
        notifyDataSetChanged();
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f18365g = z;
        }
    }

    public void x(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view) == null) {
            if (this.m == null && view != null) {
                c.a.p0.l0.g gVar = new c.a.p0.l0.g(this.f18360b.getPageContext(), view);
                this.m = gVar;
                gVar.g0(R.drawable.obfuscated_res_0x7f0802f4);
                this.m.M(new c(this));
                this.m.O(16);
                this.m.N(5000);
            }
            if (this.m != null) {
                String o = c.a.o0.r.j0.b.o("key_show_take_photo_tip");
                this.m.m0(this.f18360b.getString(R.string.obfuscated_res_0x7f0f0252), o);
            }
        }
    }
}
