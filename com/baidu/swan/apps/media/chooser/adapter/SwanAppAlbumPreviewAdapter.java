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
import c.a.p0.a.v2.n0;
import c.a.p0.a.v2.u;
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
    public ArrayList<MediaModel> f46077a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<View> f46078b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f46079c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.a.i1.d.d.a f46080d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f46081e;

    /* renamed from: f  reason: collision with root package name */
    public h f46082f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.a.i1.d.e.a f46083g;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f46084e;

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
            this.f46084e = swanAppAlbumPreviewAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f46084e.f46080d == null) {
                return;
            }
            this.f46084e.f46080d.clickContainer();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f46085e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f46086f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f46087g;

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
            this.f46087g = swanAppAlbumPreviewAdapter;
            this.f46085e = hVar;
            this.f46086f = mediaModel;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f46087g.n(this.f46085e, (ImageModel) this.f46086f);
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
        public final /* synthetic */ h f46088e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f46089f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f46090g;

        /* loaded from: classes6.dex */
        public class a implements MediaPlayer.OnPreparedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f46091e;

            /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC1734a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f46092e;

                public RunnableC1734a(a aVar) {
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
                    this.f46092e = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        c cVar = this.f46092e.f46091e;
                        cVar.f46090g.q(cVar.f46088e);
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
                this.f46091e = cVar;
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                    this.f46091e.f46088e.f46104d.postDelayed(new RunnableC1734a(this), 300L);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements MediaPlayer.OnErrorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f46093e;

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
                this.f46093e = cVar;
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                    c cVar = this.f46093e;
                    cVar.f46090g.o(cVar.f46088e);
                    return false;
                }
                return invokeLII.booleanValue;
            }
        }

        /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$c$c  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1735c implements MediaPlayer.OnCompletionListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f46094e;

            public C1735c(c cVar) {
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
                this.f46094e = cVar;
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                    c cVar = this.f46094e;
                    cVar.f46090g.o(cVar.f46088e);
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
            this.f46090g = swanAppAlbumPreviewAdapter;
            this.f46088e = hVar;
            this.f46089f = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f46088e.f46104d.isPlaying()) {
                return;
            }
            this.f46088e.f46103c.setVisibility(0);
            this.f46088e.f46104d.setVisibility(0);
            this.f46088e.f46105e.setVisibility(8);
            if (this.f46090g.f46080d != null) {
                this.f46090g.f46080d.hideBar();
            }
            MediaController mediaController = new MediaController(this.f46090g.f46079c);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.f46088e.f46104d.setMediaController(mediaController);
            this.f46088e.f46104d.setVideoPath(this.f46089f.getPath());
            this.f46088e.f46104d.setOnPreparedListener(new a(this));
            this.f46088e.f46104d.setOnErrorListener(new b(this));
            this.f46088e.f46104d.setOnCompletionListener(new C1735c(this));
            this.f46088e.f46104d.start();
            this.f46090g.f46082f = this.f46088e;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f46095e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f46096f;

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
            this.f46096f = swanAppAlbumPreviewAdapter;
            this.f46095e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f46095e.f46104d.isPlaying()) {
                this.f46095e.f46104d.stopPlayback();
                this.f46096f.o(this.f46095e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f46097a;

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
            this.f46097a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f46097a.f46102b.setVisibility(8);
                this.f46097a.f46102b.clearAnimation();
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
        public final /* synthetic */ h f46098a;

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
            this.f46098a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f46098a.f46102b.setVisibility(0);
                this.f46098a.f46102b.clearAnimation();
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
        public final /* synthetic */ HugePhotoDraweeView f46099a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f46100b;

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
            this.f46100b = swanAppAlbumPreviewAdapter;
            this.f46099a = hugePhotoDraweeView;
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
                    this.f46099a.setIsDynamicBitmap(false);
                    this.f46099a.setZoomEnabled(true);
                    Bitmap underlyingBitmap = ((CloseableStaticBitmap) obj).getUnderlyingBitmap();
                    this.f46100b.f46081e = u.j();
                    c.a.p0.a.i1.e.b b2 = c.a.p0.a.i1.e.b.b(underlyingBitmap);
                    if (b2 == null) {
                        return;
                    }
                    if (underlyingBitmap.getWidth() < this.f46100b.f46081e[0] && underlyingBitmap.getHeight() < this.f46100b.f46081e[0]) {
                        b2.m();
                    } else {
                        b2.n();
                    }
                    this.f46099a.setImage(b2);
                    this.f46100b.m(this.f46099a, underlyingBitmap);
                } else if (obj instanceof CloseableAnimatedImage) {
                    this.f46099a.setIsDynamicBitmap(true);
                    this.f46099a.setZoomEnabled(false);
                    this.f46099a.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
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
        public View f46101a;

        /* renamed from: b  reason: collision with root package name */
        public HugePhotoDraweeView f46102b;

        /* renamed from: c  reason: collision with root package name */
        public View f46103c;

        /* renamed from: d  reason: collision with root package name */
        public VideoView f46104d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f46105e;

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
            this.f46101a = view;
            this.f46102b = (HugePhotoDraweeView) view.findViewById(c.a.p0.a.f.album_preview_image);
            this.f46103c = view.findViewById(c.a.p0.a.f.preview_video_layout);
            this.f46104d = (VideoView) view.findViewById(c.a.p0.a.f.preview_video_view);
            this.f46105e = (ImageView) view.findViewById(c.a.p0.a.f.video_preview);
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
        this.f46081e = new int[1];
        this.f46079c = activity;
        this.f46077a = arrayList;
        this.f46078b = new SparseArray<>();
    }

    public void destroy() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hVar = this.f46082f) == null) {
            return;
        }
        VideoView videoView = hVar.f46104d;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.f46082f.f46104d = null;
        this.f46082f = null;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f46077a.size() : invokeV.intValue;
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
            MediaModel mediaModel = this.f46077a.get(i2);
            View view = this.f46078b.get(i2);
            if (view == null) {
                view = LayoutInflater.from(this.f46079c).inflate(c.a.p0.a.g.swanapp_album_preview_item, viewGroup, false);
                hVar = new h(this, view);
                view.setTag(hVar);
                this.f46078b.put(i2, view);
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
        ControllerListener j2 = j(hVar.f46102b);
        String path = mediaModel.getPath();
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(path.startsWith("http") ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        newBuilderWithSource.setResizeOptions(new ResizeOptions(n0.o(this.f46079c), n0.n(this.f46079c), 10240.0f));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(c.a.p0.a.i1.d.c.c.f6741d).setImageRequest(newBuilderWithSource.build()).setControllerListener(j2).setOldController(hVar.f46102b.getController()).build();
        hVar.f46102b.setVisibility(0);
        hVar.f46102b.setController(build);
        if (mediaModel instanceof ImageModel) {
            hVar.f46103c.setVisibility(8);
            hVar.f46102b.setOnClickListener(new a(this));
            hVar.f46102b.setOnLongClickListener(new b(this, hVar, mediaModel));
        }
    }

    public final void l(h hVar, MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar, mediaModel) == null) {
            if (!(mediaModel instanceof VideoModel)) {
                hVar.f46105e.setVisibility(8);
            } else if (hVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
            } else {
                hVar.f46103c.setVisibility(8);
                hVar.f46104d.setVisibility(8);
                hVar.f46105e.setVisibility(0);
                hVar.f46102b.setOnClickListener(new c(this, hVar, mediaModel));
                hVar.f46103c.setOnClickListener(new d(this, hVar));
            }
        }
    }

    public final void m(HugePhotoDraweeView hugePhotoDraweeView, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, hugePhotoDraweeView, bitmap) == null) {
            int o = n0.o(this.f46079c);
            int n = n0.n(this.f46079c);
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
            if (this.f46083g == null) {
                this.f46083g = new c.a.p0.a.i1.d.e.a(this.f46079c);
            }
            this.f46083g.j(hVar.f46101a, imageModel.getPath());
        }
    }

    public final void o(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hVar) == null) {
            p(hVar, true);
        }
    }

    public final void p(h hVar, boolean z) {
        c.a.p0.a.i1.d.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048588, this, hVar, z) == null) || hVar == null) {
            return;
        }
        hVar.f46105e.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f46079c, c.a.p0.a.a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new f(this, hVar));
        hVar.f46102b.startAnimation(loadAnimation);
        if (!z || (aVar = this.f46080d) == null) {
            return;
        }
        aVar.showBar();
    }

    public void pageScrollStateChanged() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (hVar = this.f46082f) == null || hVar.f46104d == null || !this.f46082f.f46104d.isPlaying()) {
            return;
        }
        this.f46082f.f46104d.stopPlayback();
        p(this.f46082f, false);
    }

    public final void q(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hVar) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f46079c, c.a.p0.a.a.swanapp_album_preview_img_exit);
            loadAnimation.setAnimationListener(new e(this, hVar));
            hVar.f46102b.startAnimation(loadAnimation);
        }
    }

    public void setCurrentViewBackground(int i2, @ColorInt int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) || i2 >= this.f46078b.size() || this.f46078b.get(i2) == null) {
            return;
        }
        this.f46078b.get(i2).findViewById(c.a.p0.a.f.album_preview_item_root).setBackgroundColor(i3);
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, arrayList) == null) {
            this.f46077a = arrayList;
            this.f46078b.clear();
            notifyDataSetChanged();
        }
    }

    public void setListener(c.a.p0.a.i1.d.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.f46080d = aVar;
        }
    }
}
