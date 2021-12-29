package com.baidu.swan.videoplayer.media.video;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.c0.b.a;
import c.a.r0.a.c0.b.b;
import c.a.r0.a.e0.d;
import c.a.r0.a.j1.g.c;
import c.a.r0.y.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
/* loaded from: classes11.dex */
public class VideoContainerManager extends a<VideoHolderWrapper, c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public Context f41386i;

    /* renamed from: j  reason: collision with root package name */
    public SwanAppComponentContainerView f41387j;

    /* renamed from: k  reason: collision with root package name */
    public VideoHolderWrapper f41388k;

    /* loaded from: classes11.dex */
    public class VideoHolderWrapper extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public FrameLayout f41389e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f41390f;

        /* renamed from: g  reason: collision with root package name */
        public SimpleDraweeView f41391g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ VideoContainerManager f41392h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoHolderWrapper(@NonNull VideoContainerManager videoContainerManager, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoContainerManager, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41392h = videoContainerManager;
            c();
            b();
            a();
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ImageView imageView = new ImageView(this.f41392h.f41386i);
                this.f41390f = imageView;
                imageView.setImageResource(e.swanapp_video_btn_play);
                this.f41390f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                this.f41390f.setBackgroundResource(e.swanapp_video_background_circle);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                addView(this.f41390f, layoutParams);
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f41391g = new SimpleDraweeView(getContext());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.f41391g.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
                addView(this.f41391g, layoutParams);
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f41389e = new FrameLayout(getContext());
                addView(this.f41389e, new FrameLayout.LayoutParams(-1, -1));
            }
        }

        public View getPlayerIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41390f : (View) invokeV.objValue;
        }

        public void getPoster(String str, SimpleDraweeView simpleDraweeView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, simpleDraweeView) == null) {
                Uri uri = getUri(str);
                if (uri == null) {
                    simpleDraweeView.setController(null);
                    return;
                }
                ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(uri);
                int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
                int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
                if (measuredWidth > 0 && measuredHeight > 0) {
                    newBuilderWithSource.setResizeOptions(new ResizeOptions(measuredWidth, measuredHeight));
                }
                simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setOldController(simpleDraweeView.getController()).setImageRequest(newBuilderWithSource.build()).build());
            }
        }

        public Uri getUri(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                if (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("file://")) {
                    if (str.startsWith("/")) {
                        return Uri.fromFile(new File(str));
                    }
                    return null;
                }
                return Uri.parse(str);
            }
            return (Uri) invokeL.objValue;
        }

        public FrameLayout getVideoHolder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f41389e : (FrameLayout) invokeV.objValue;
        }

        public SimpleDraweeView getVideoPoster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f41391g : (SimpleDraweeView) invokeV.objValue;
        }

        public void setPoster(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                setPoster(str, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
            }
        }

        public void setPoster(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY;
            }
            ScalingUtils.ScaleType scaleType = ScalingUtils.ScaleType.CENTER_CROP;
            char c2 = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != 3143043) {
                if (hashCode != 94852023) {
                    if (hashCode == 951526612 && str2.equals("contain")) {
                        c2 = 0;
                    }
                } else if (str2.equals(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY)) {
                    c2 = 1;
                }
            } else if (str2.equals("fill")) {
                c2 = 2;
            }
            if (c2 == 0) {
                ScalingUtils.ScaleType scaleType2 = ScalingUtils.ScaleType.CENTER_INSIDE;
            } else if (c2 == 1) {
                ScalingUtils.ScaleType scaleType3 = ScalingUtils.ScaleType.CENTER_CROP;
            } else if (c2 == 2) {
                ScalingUtils.ScaleType scaleType4 = ScalingUtils.ScaleType.FIT_XY;
            }
            this.f41391g.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            getPoster(str, this.f41391g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41386i = context;
        SwanAppComponentContainerView swanAppComponentContainerView = new SwanAppComponentContainerView(this.f41386i);
        this.f41387j = swanAppComponentContainerView;
        swanAppComponentContainerView.setBackgroundColor(Color.parseColor("#666666"));
        g(1);
    }

    public SwanAppComponentContainerView G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41387j : (SwanAppComponentContainerView) invokeV.objValue;
    }

    public FrameLayout H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? I().getVideoHolder() : (FrameLayout) invokeV.objValue;
    }

    public final VideoHolderWrapper I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f41388k == null) {
                this.f41388k = new VideoHolderWrapper(this, this.f41386i);
            }
            return this.f41388k;
        }
        return (VideoHolderWrapper) invokeV.objValue;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Q(I().getPlayerIcon(), 8);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Q(I().getVideoPoster(), 8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.c0.b.a
    @NonNull
    /* renamed from: L */
    public VideoHolderWrapper v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? I() : (VideoHolderWrapper) invokeL.objValue;
    }

    public void M(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            View playerIcon = I().getPlayerIcon();
            playerIcon.setOnClickListener(onClickListener);
            Q(playerIcon, 0);
        }
    }

    public void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            I().setPoster(str, str2);
            Q(I().getVideoPoster(), 0);
        }
    }

    public void O(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || cVar == null) {
            return;
        }
        P(cVar);
    }

    public final void P(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || cVar == null) {
            return;
        }
        if (!(m() != null)) {
            if (I().getParent() instanceof ViewGroup) {
                ((ViewGroup) I().getParent()).removeView(I());
            }
            G().setDescendantFocusability(393216);
            c.a.r0.a.c0.b.c insert = insert();
            d.b("video", "Add CoverContainerWrapper " + insert.a() + " position " + cVar.l);
            return;
        }
        c n = n();
        if (!TextUtils.equals(cVar.f5421f, n.f5421f) || !TextUtils.equals(cVar.f5422g, n.f5422g) || !TextUtils.equals(cVar.f5423h, n.f5423h)) {
            c.a.r0.a.c0.g.a.a("video", "updateCoverContainerPosition with different id");
        }
        c.a.r0.a.c0.b.c update = update((VideoContainerManager) cVar);
        d.b("video", "Update CoverContainerWrapper " + update.a() + " position " + cVar.l);
    }

    public final void Q(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, view, i2) == null) || view == null || view.getVisibility() == i2) {
            return;
        }
        view.setVisibility(i2);
    }

    @Override // c.a.r0.a.c0.b.a
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) ? this.f41387j : (SwanAppComponentContainerView) invokeL.objValue;
    }
}
