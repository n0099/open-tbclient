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
import c.a.o0.a.v2.n0;
import c.a.o0.a.v2.u;
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
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<MediaModel> f45948a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<View> f45949b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f45950c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.a.i1.d.d.a f45951d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f45952e;

    /* renamed from: f  reason: collision with root package name */
    public h f45953f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.a.i1.d.e.a f45954g;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f45955e;

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
            this.f45955e = swanAppAlbumPreviewAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45955e.f45951d == null) {
                return;
            }
            this.f45955e.f45951d.clickContainer();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f45956e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f45957f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f45958g;

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
            this.f45958g = swanAppAlbumPreviewAdapter;
            this.f45956e = hVar;
            this.f45957f = mediaModel;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f45958g.n(this.f45956e, (ImageModel) this.f45957f);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f45959e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f45960f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f45961g;

        /* loaded from: classes6.dex */
        public class a implements MediaPlayer.OnPreparedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f45962e;

            /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC1729a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f45963e;

                public RunnableC1729a(a aVar) {
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
                    this.f45963e = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        c cVar = this.f45963e.f45962e;
                        cVar.f45961g.q(cVar.f45959e);
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
                this.f45962e = cVar;
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                    this.f45962e.f45959e.f45975d.postDelayed(new RunnableC1729a(this), 300L);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements MediaPlayer.OnErrorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f45964e;

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
                this.f45964e = cVar;
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                    c cVar = this.f45964e;
                    cVar.f45961g.o(cVar.f45959e);
                    return false;
                }
                return invokeLII.booleanValue;
            }
        }

        /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$c$c  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1730c implements MediaPlayer.OnCompletionListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f45965e;

            public C1730c(c cVar) {
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
                this.f45965e = cVar;
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                    c cVar = this.f45965e;
                    cVar.f45961g.o(cVar.f45959e);
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
            this.f45961g = swanAppAlbumPreviewAdapter;
            this.f45959e = hVar;
            this.f45960f = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45959e.f45975d.isPlaying()) {
                return;
            }
            this.f45959e.f45974c.setVisibility(0);
            this.f45959e.f45975d.setVisibility(0);
            this.f45959e.f45976e.setVisibility(8);
            if (this.f45961g.f45951d != null) {
                this.f45961g.f45951d.hideBar();
            }
            MediaController mediaController = new MediaController(this.f45961g.f45950c);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.f45959e.f45975d.setMediaController(mediaController);
            this.f45959e.f45975d.setVideoPath(this.f45960f.getPath());
            this.f45959e.f45975d.setOnPreparedListener(new a(this));
            this.f45959e.f45975d.setOnErrorListener(new b(this));
            this.f45959e.f45975d.setOnCompletionListener(new C1730c(this));
            this.f45959e.f45975d.start();
            this.f45961g.f45953f = this.f45959e;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f45966e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f45967f;

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
            this.f45967f = swanAppAlbumPreviewAdapter;
            this.f45966e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f45966e.f45975d.isPlaying()) {
                this.f45966e.f45975d.stopPlayback();
                this.f45967f.o(this.f45966e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f45968a;

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
            this.f45968a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f45968a.f45973b.setVisibility(8);
                this.f45968a.f45973b.clearAnimation();
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

    /* loaded from: classes6.dex */
    public class f implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f45969a;

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
            this.f45969a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f45969a.f45973b.setVisibility(0);
                this.f45969a.f45973b.clearAnimation();
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

    /* loaded from: classes6.dex */
    public class g extends BaseControllerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HugePhotoDraweeView f45970a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f45971b;

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
            this.f45971b = swanAppAlbumPreviewAdapter;
            this.f45970a = hugePhotoDraweeView;
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
                    this.f45970a.setIsDynamicBitmap(false);
                    this.f45970a.setZoomEnabled(true);
                    Bitmap underlyingBitmap = ((CloseableStaticBitmap) obj).getUnderlyingBitmap();
                    this.f45971b.f45952e = u.j();
                    c.a.o0.a.i1.e.b b2 = c.a.o0.a.i1.e.b.b(underlyingBitmap);
                    if (b2 == null) {
                        return;
                    }
                    if (underlyingBitmap.getWidth() < this.f45971b.f45952e[0] && underlyingBitmap.getHeight() < this.f45971b.f45952e[0]) {
                        b2.m();
                    } else {
                        b2.n();
                    }
                    this.f45970a.setImage(b2);
                    this.f45971b.m(this.f45970a, underlyingBitmap);
                } else if (obj instanceof CloseableAnimatedImage) {
                    this.f45970a.setIsDynamicBitmap(true);
                    this.f45970a.setZoomEnabled(false);
                    this.f45970a.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
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

    /* loaded from: classes6.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f45972a;

        /* renamed from: b  reason: collision with root package name */
        public HugePhotoDraweeView f45973b;

        /* renamed from: c  reason: collision with root package name */
        public View f45974c;

        /* renamed from: d  reason: collision with root package name */
        public VideoView f45975d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f45976e;

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
            this.f45972a = view;
            this.f45973b = (HugePhotoDraweeView) view.findViewById(c.a.o0.a.f.album_preview_image);
            this.f45974c = view.findViewById(c.a.o0.a.f.preview_video_layout);
            this.f45975d = (VideoView) view.findViewById(c.a.o0.a.f.preview_video_view);
            this.f45976e = (ImageView) view.findViewById(c.a.o0.a.f.video_preview);
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
        this.f45952e = new int[1];
        this.f45950c = activity;
        this.f45948a = arrayList;
        this.f45949b = new SparseArray<>();
    }

    public void destroy() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hVar = this.f45953f) == null) {
            return;
        }
        VideoView videoView = hVar.f45975d;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.f45953f.f45975d = null;
        this.f45953f = null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2, obj) == null) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f45948a.size() : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            return -2;
        }
        return invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) {
            MediaModel mediaModel = this.f45948a.get(i2);
            View view = this.f45949b.get(i2);
            if (view == null) {
                view = LayoutInflater.from(this.f45950c).inflate(c.a.o0.a.g.swanapp_album_preview_item, viewGroup, false);
                hVar = new h(this, view);
                view.setTag(hVar);
                this.f45949b.put(i2, view);
            } else {
                hVar = (h) view.getTag();
            }
            k(hVar, mediaModel);
            l(hVar, mediaModel);
            viewGroup.addView(view);
            return view;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public final ControllerListener j(HugePhotoDraweeView hugePhotoDraweeView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hugePhotoDraweeView)) == null) ? new g(this, hugePhotoDraweeView) : (ControllerListener) invokeL.objValue;
    }

    public final void k(h hVar, MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, hVar, mediaModel) == null) || hVar == null || mediaModel == null || TextUtils.isEmpty(mediaModel.getPath())) {
            return;
        }
        ControllerListener j2 = j(hVar.f45973b);
        String path = mediaModel.getPath();
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(path.startsWith("http") ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        newBuilderWithSource.setResizeOptions(new ResizeOptions(n0.o(this.f45950c), n0.n(this.f45950c), 10240.0f));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(c.a.o0.a.i1.d.c.c.f6705d).setImageRequest(newBuilderWithSource.build()).setControllerListener(j2).setOldController(hVar.f45973b.getController()).build();
        hVar.f45973b.setVisibility(0);
        hVar.f45973b.setController(build);
        if (mediaModel instanceof ImageModel) {
            hVar.f45974c.setVisibility(8);
            hVar.f45973b.setOnClickListener(new a(this));
            hVar.f45973b.setOnLongClickListener(new b(this, hVar, mediaModel));
        }
    }

    public final void l(h hVar, MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar, mediaModel) == null) {
            if (!(mediaModel instanceof VideoModel)) {
                hVar.f45976e.setVisibility(8);
            } else if (hVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
            } else {
                hVar.f45974c.setVisibility(8);
                hVar.f45975d.setVisibility(8);
                hVar.f45976e.setVisibility(0);
                hVar.f45973b.setOnClickListener(new c(this, hVar, mediaModel));
                hVar.f45974c.setOnClickListener(new d(this, hVar));
            }
        }
    }

    public final void m(HugePhotoDraweeView hugePhotoDraweeView, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, hugePhotoDraweeView, bitmap) == null) {
            int o = n0.o(this.f45950c);
            int n = n0.n(this.f45950c);
            if (bitmap == null || bitmap.getHeight() <= n * 1.6f) {
                return;
            }
            float width = bitmap.getWidth() == 0 ? 1.0f : o / bitmap.getWidth();
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(o / 2, 0.0f));
        }
    }

    public final void n(h hVar, ImageModel imageModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, hVar, imageModel) == null) {
            if (this.f45954g == null) {
                this.f45954g = new c.a.o0.a.i1.d.e.a(this.f45950c);
            }
            this.f45954g.j(hVar.f45972a, imageModel.getPath());
        }
    }

    public final void o(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hVar) == null) {
            p(hVar, true);
        }
    }

    public final void p(h hVar, boolean z) {
        c.a.o0.a.i1.d.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048588, this, hVar, z) == null) || hVar == null) {
            return;
        }
        hVar.f45976e.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f45950c, c.a.o0.a.a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new f(this, hVar));
        hVar.f45973b.startAnimation(loadAnimation);
        if (!z || (aVar = this.f45951d) == null) {
            return;
        }
        aVar.showBar();
    }

    public void pageScrollStateChanged() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (hVar = this.f45953f) == null || hVar.f45975d == null || !this.f45953f.f45975d.isPlaying()) {
            return;
        }
        this.f45953f.f45975d.stopPlayback();
        p(this.f45953f, false);
    }

    public final void q(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hVar) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f45950c, c.a.o0.a.a.swanapp_album_preview_img_exit);
            loadAnimation.setAnimationListener(new e(this, hVar));
            hVar.f45973b.startAnimation(loadAnimation);
        }
    }

    public void setCurrentViewBackground(int i2, @ColorInt int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) || i2 >= this.f45949b.size() || this.f45949b.get(i2) == null) {
            return;
        }
        this.f45949b.get(i2).findViewById(c.a.o0.a.f.album_preview_item_root).setBackgroundColor(i3);
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, arrayList) == null) {
            this.f45948a = arrayList;
            this.f45949b.clear();
            notifyDataSetChanged();
        }
    }

    public void setListener(c.a.o0.a.i1.d.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.f45951d = aVar;
        }
    }
}
