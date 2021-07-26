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
import d.a.o0.a.c0.b.a;
import d.a.o0.a.c0.b.b;
import d.a.o0.a.e0.d;
import d.a.o0.a.i1.g.c;
import java.io.File;
/* loaded from: classes3.dex */
public class VideoContainerManager extends a<VideoHolderWrapper, c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public Context f12134i;
    public SwanAppComponentContainerView j;
    public VideoHolderWrapper k;

    /* loaded from: classes3.dex */
    public class VideoHolderWrapper extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public FrameLayout f12135e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f12136f;

        /* renamed from: g  reason: collision with root package name */
        public SimpleDraweeView f12137g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ VideoContainerManager f12138h;

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
            this.f12138h = videoContainerManager;
            e();
            d();
            c();
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, simpleDraweeView) == null) {
                Uri b2 = b(str);
                if (b2 == null) {
                    simpleDraweeView.setController(null);
                    return;
                }
                ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(b2);
                int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
                int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
                if (measuredWidth > 0 && measuredHeight > 0) {
                    newBuilderWithSource.setResizeOptions(new ResizeOptions(measuredWidth, measuredHeight));
                }
                simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setOldController(simpleDraweeView.getController()).setImageRequest(newBuilderWithSource.build()).build());
            }
        }

        public Uri b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
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

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ImageView imageView = new ImageView(this.f12138h.f12134i);
                this.f12136f = imageView;
                imageView.setImageResource(d.a.o0.v.c.btn_play);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                addView(this.f12136f, layoutParams);
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f12137g = new SimpleDraweeView(getContext());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.f12137g.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
                addView(this.f12137g, layoutParams);
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f12135e = new FrameLayout(getContext());
                addView(this.f12135e, new FrameLayout.LayoutParams(-1, -1));
            }
        }

        public View getPlayerIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12136f : (View) invokeV.objValue;
        }

        public FrameLayout getVideoHolder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f12135e : (FrameLayout) invokeV.objValue;
        }

        public SimpleDraweeView getVideoPoster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f12137g : (SimpleDraweeView) invokeV.objValue;
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
            this.f12137g.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            a(str, this.f12137g);
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
        this.f12134i = context;
        SwanAppComponentContainerView swanAppComponentContainerView = new SwanAppComponentContainerView(this.f12134i);
        this.j = swanAppComponentContainerView;
        swanAppComponentContainerView.setBackgroundColor(Color.parseColor("#666666"));
        g(1);
    }

    public SwanAppComponentContainerView I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (SwanAppComponentContainerView) invokeV.objValue;
    }

    public FrameLayout J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? K().getVideoHolder() : (FrameLayout) invokeV.objValue;
    }

    public final VideoHolderWrapper K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.k == null) {
                this.k = new VideoHolderWrapper(this, this.f12134i);
            }
            return this.k;
        }
        return (VideoHolderWrapper) invokeV.objValue;
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            S(K().getPlayerIcon(), 8);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            S(K().getVideoPoster(), 8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.a.c0.b.a
    @NonNull
    /* renamed from: N */
    public VideoHolderWrapper v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? K() : (VideoHolderWrapper) invokeL.objValue;
    }

    public void O(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            View playerIcon = K().getPlayerIcon();
            playerIcon.setOnClickListener(onClickListener);
            S(playerIcon, 0);
        }
    }

    public void P(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            K().setPoster(str, str2);
            S(K().getVideoPoster(), 0);
        }
    }

    public void Q(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || cVar == null) {
            return;
        }
        R(cVar);
    }

    public final void R(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || cVar == null) {
            return;
        }
        if (!(m() != null)) {
            if (K().getParent() instanceof ViewGroup) {
                ((ViewGroup) K().getParent()).removeView(K());
            }
            I().setDescendantFocusability(393216);
            d.a.o0.a.c0.b.c w = w();
            d.a("video", "Add CoverContainerWrapper " + w.a() + " position " + cVar.l);
            return;
        }
        c n = n();
        if (!TextUtils.equals(cVar.f43981f, n.f43981f) || !TextUtils.equals(cVar.f43982g, n.f43982g) || !TextUtils.equals(cVar.f43983h, n.f43983h)) {
            d.a.o0.a.c0.g.a.a("video", "updateCoverContainerPosition with different id");
        }
        d.a.o0.a.c0.b.c G = G(cVar);
        d.a("video", "Update CoverContainerWrapper " + G.a() + " position " + cVar.l);
    }

    public final void S(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, view, i2) == null) || view == null || view.getVisibility() == i2) {
            return;
        }
        view.setVisibility(i2);
    }

    @Override // d.a.o0.a.c0.b.a
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) ? this.j : (SwanAppComponentContainerView) invokeL.objValue;
    }
}
