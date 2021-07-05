package com.baidu.swan.apps.media.chooser.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.swan.apps.media.image.HugePhotoDraweeView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.u;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<MediaModel> f11097a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<View> f11098b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f11099c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.a.i1.d.d.a f11100d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f11101e;

    /* renamed from: f  reason: collision with root package name */
    public h f11102f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.a.i1.d.e.a f11103g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f11104e;

        public a(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11104e = swanAppAlbumPreviewAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f11104e.f11100d == null) {
                return;
            }
            this.f11104e.f11100d.clickContainer();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f11105e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f11106f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f11107g;

        public b(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar, MediaModel mediaModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewAdapter, hVar, mediaModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11107g = swanAppAlbumPreviewAdapter;
            this.f11105e = hVar;
            this.f11106f = mediaModel;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f11107g.p(this.f11105e, (ImageModel) this.f11106f);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f11108e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f11109f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f11110g;

        /* loaded from: classes4.dex */
        public class a implements MediaPlayer.OnPreparedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f11111e;

            /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0176a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f11112e;

                public RunnableC0176a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f11112e = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        c cVar = this.f11112e.f11111e;
                        cVar.f11110g.t(cVar.f11108e);
                    }
                }
            }

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
                this.f11111e = cVar;
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                    this.f11111e.f11108e.f11124d.postDelayed(new RunnableC0176a(this), 300L);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements MediaPlayer.OnErrorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f11113e;

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
                this.f11113e = cVar;
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                    c cVar = this.f11113e;
                    cVar.f11110g.r(cVar.f11108e);
                    return false;
                }
                return invokeLII.booleanValue;
            }
        }

        /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$c$c  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0177c implements MediaPlayer.OnCompletionListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f11114e;

            public C0177c(c cVar) {
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
                this.f11114e = cVar;
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                    c cVar = this.f11114e;
                    cVar.f11110g.r(cVar.f11108e);
                }
            }
        }

        public c(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar, MediaModel mediaModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewAdapter, hVar, mediaModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11110g = swanAppAlbumPreviewAdapter;
            this.f11108e = hVar;
            this.f11109f = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f11108e.f11124d.isPlaying()) {
                return;
            }
            this.f11108e.f11123c.setVisibility(0);
            this.f11108e.f11124d.setVisibility(0);
            this.f11108e.f11125e.setVisibility(8);
            if (this.f11110g.f11100d != null) {
                this.f11110g.f11100d.hideBar();
            }
            MediaController mediaController = new MediaController(this.f11110g.f11099c);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.f11108e.f11124d.setMediaController(mediaController);
            this.f11108e.f11124d.setVideoPath(this.f11109f.getPath());
            this.f11108e.f11124d.setOnPreparedListener(new a(this));
            this.f11108e.f11124d.setOnErrorListener(new b(this));
            this.f11108e.f11124d.setOnCompletionListener(new C0177c(this));
            this.f11108e.f11124d.start();
            this.f11110g.f11102f = this.f11108e;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f11115e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f11116f;

        public d(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewAdapter, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11116f = swanAppAlbumPreviewAdapter;
            this.f11115e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f11115e.f11124d.isPlaying()) {
                this.f11115e.f11124d.stopPlayback();
                this.f11116f.r(this.f11115e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f11117a;

        public e(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewAdapter, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11117a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f11117a.f11122b.setVisibility(8);
                this.f11117a.f11122b.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f11118a;

        public f(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewAdapter, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11118a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f11118a.f11122b.setVisibility(0);
                this.f11118a.f11122b.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends BaseControllerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HugePhotoDraweeView f11119a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f11120b;

        public g(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, HugePhotoDraweeView hugePhotoDraweeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewAdapter, hugePhotoDraweeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11120b = swanAppAlbumPreviewAdapter;
            this.f11119a = hugePhotoDraweeView;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, th) == null) {
                super.onFailure(str, th);
            }
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj, animatable) == null) {
                super.onFinalImageSet(str, obj, animatable);
                if (obj instanceof CloseableStaticBitmap) {
                    this.f11119a.setIsDynamicBitmap(false);
                    this.f11119a.setZoomEnabled(true);
                    Bitmap underlyingBitmap = ((CloseableStaticBitmap) obj).getUnderlyingBitmap();
                    this.f11120b.f11101e = u.j();
                    d.a.q0.a.i1.e.b b2 = d.a.q0.a.i1.e.b.b(underlyingBitmap);
                    if (b2 == null) {
                        return;
                    }
                    if (underlyingBitmap.getWidth() < this.f11120b.f11101e[0] && underlyingBitmap.getHeight() < this.f11120b.f11101e[0]) {
                        b2.m();
                    } else {
                        b2.n();
                    }
                    this.f11119a.setImage(b2);
                    this.f11120b.o(this.f11119a, underlyingBitmap);
                } else if (obj instanceof CloseableAnimatedImage) {
                    this.f11119a.setIsDynamicBitmap(true);
                    this.f11119a.setZoomEnabled(false);
                    this.f11119a.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
                }
            }
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onSubmit(String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj) == null) {
                super.onSubmit(str, obj);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f11121a;

        /* renamed from: b  reason: collision with root package name */
        public HugePhotoDraweeView f11122b;

        /* renamed from: c  reason: collision with root package name */
        public View f11123c;

        /* renamed from: d  reason: collision with root package name */
        public VideoView f11124d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f11125e;

        public h(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11121a = view;
            this.f11122b = (HugePhotoDraweeView) view.findViewById(d.a.q0.a.f.album_preview_image);
            this.f11123c = view.findViewById(d.a.q0.a.f.preview_video_layout);
            this.f11124d = (VideoView) view.findViewById(d.a.q0.a.f.preview_video_view);
            this.f11125e = (ImageView) view.findViewById(d.a.q0.a.f.video_preview);
        }
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11101e = new int[1];
        this.f11099c = activity;
        this.f11097a = arrayList;
        this.f11098b = new SparseArray<>();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11097a.size() : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            return -2;
        }
        return invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) {
            MediaModel mediaModel = this.f11097a.get(i2);
            View view = this.f11098b.get(i2);
            if (view == null) {
                view = LayoutInflater.from(this.f11099c).inflate(d.a.q0.a.g.swanapp_album_preview_item, viewGroup, false);
                hVar = new h(this, view);
                view.setTag(hVar);
                this.f11098b.put(i2, view);
            } else {
                hVar = (h) view.getTag();
            }
            m(hVar, mediaModel);
            n(hVar, mediaModel);
            viewGroup.addView(view);
            return view;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public void k() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (hVar = this.f11102f) == null) {
            return;
        }
        VideoView videoView = hVar.f11124d;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.f11102f.f11124d = null;
        this.f11102f = null;
    }

    public final ControllerListener l(HugePhotoDraweeView hugePhotoDraweeView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hugePhotoDraweeView)) == null) ? new g(this, hugePhotoDraweeView) : (ControllerListener) invokeL.objValue;
    }

    public final void m(h hVar, MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, hVar, mediaModel) == null) || hVar == null || mediaModel == null || TextUtils.isEmpty(mediaModel.getPath())) {
            return;
        }
        ControllerListener l = l(hVar.f11122b);
        String path = mediaModel.getPath();
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(path.startsWith("http") ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        newBuilderWithSource.setResizeOptions(new ResizeOptions(n0.o(this.f11099c), n0.n(this.f11099c), 10240.0f));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(d.a.q0.a.i1.d.c.c.f48800d).setImageRequest(newBuilderWithSource.build()).setControllerListener(l).setOldController(hVar.f11122b.getController()).build();
        hVar.f11122b.setVisibility(0);
        hVar.f11122b.setController(build);
        if (mediaModel instanceof ImageModel) {
            hVar.f11123c.setVisibility(8);
            hVar.f11122b.setOnClickListener(new a(this));
            hVar.f11122b.setOnLongClickListener(new b(this, hVar, mediaModel));
        }
    }

    public final void n(h hVar, MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar, mediaModel) == null) {
            if (!(mediaModel instanceof VideoModel)) {
                hVar.f11125e.setVisibility(8);
            } else if (hVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
            } else {
                hVar.f11123c.setVisibility(8);
                hVar.f11124d.setVisibility(8);
                hVar.f11125e.setVisibility(0);
                hVar.f11122b.setOnClickListener(new c(this, hVar, mediaModel));
                hVar.f11123c.setOnClickListener(new d(this, hVar));
            }
        }
    }

    public final void o(HugePhotoDraweeView hugePhotoDraweeView, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, hugePhotoDraweeView, bitmap) == null) {
            int o = n0.o(this.f11099c);
            int n = n0.n(this.f11099c);
            if (bitmap == null || bitmap.getHeight() <= n * 1.6f) {
                return;
            }
            float width = bitmap.getWidth() == 0 ? 1.0f : o / bitmap.getWidth();
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(o / 2, 0.0f));
        }
    }

    public final void p(h hVar, ImageModel imageModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, hVar, imageModel) == null) {
            if (this.f11103g == null) {
                this.f11103g = new d.a.q0.a.i1.d.e.a(this.f11099c);
            }
            this.f11103g.j(hVar.f11121a, imageModel.getPath());
        }
    }

    public void q() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (hVar = this.f11102f) == null || hVar.f11124d == null || !this.f11102f.f11124d.isPlaying()) {
            return;
        }
        this.f11102f.f11124d.stopPlayback();
        s(this.f11102f, false);
    }

    public final void r(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, hVar) == null) {
            s(hVar, true);
        }
    }

    public final void s(h hVar, boolean z) {
        d.a.q0.a.i1.d.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, hVar, z) == null) || hVar == null) {
            return;
        }
        hVar.f11125e.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f11099c, d.a.q0.a.a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new f(this, hVar));
        hVar.f11122b.startAnimation(loadAnimation);
        if (!z || (aVar = this.f11100d) == null) {
            return;
        }
        aVar.showBar();
    }

    public final void t(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hVar) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f11099c, d.a.q0.a.a.swanapp_album_preview_img_exit);
            loadAnimation.setAnimationListener(new e(this, hVar));
            hVar.f11122b.startAnimation(loadAnimation);
        }
    }

    public void u(int i2, @ColorInt int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) || i2 >= this.f11098b.size() || this.f11098b.get(i2) == null) {
            return;
        }
        this.f11098b.get(i2).findViewById(d.a.q0.a.f.album_preview_item_root).setBackgroundColor(i3);
    }

    public void v(d.a.q0.a.i1.d.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            this.f11100d = aVar;
        }
    }
}
