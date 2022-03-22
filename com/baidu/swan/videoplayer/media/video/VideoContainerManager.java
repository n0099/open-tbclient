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
import c.a.n0.a.s.b.a;
import c.a.n0.a.s.b.b;
import c.a.n0.a.u.d;
import c.a.n0.a.z0.g.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tieba.R;
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
/* loaded from: classes4.dex */
public class VideoContainerManager extends a<VideoHolderWrapper, c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context i;
    public SwanAppComponentContainerView j;
    public VideoHolderWrapper k;

    /* loaded from: classes4.dex */
    public class VideoHolderWrapper extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrameLayout a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f29722b;

        /* renamed from: c  reason: collision with root package name */
        public SimpleDraweeView f29723c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VideoContainerManager f29724d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoHolderWrapper(@NonNull VideoContainerManager videoContainerManager, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoContainerManager, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29724d = videoContainerManager;
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
                ImageView imageView = new ImageView(this.f29724d.i);
                this.f29722b = imageView;
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08119b);
                this.f29722b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                this.f29722b.setBackgroundResource(R.drawable.obfuscated_res_0x7f081191);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                addView(this.f29722b, layoutParams);
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f29723c = new SimpleDraweeView(getContext());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.f29723c.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
                addView(this.f29723c, layoutParams);
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a = new FrameLayout(getContext());
                addView(this.a, new FrameLayout.LayoutParams(-1, -1));
            }
        }

        public View getPlayerIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f29722b : (View) invokeV.objValue;
        }

        public FrameLayout getVideoHolder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (FrameLayout) invokeV.objValue;
        }

        public SimpleDraweeView getVideoPoster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f29723c : (SimpleDraweeView) invokeV.objValue;
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
            this.f29723c.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            a(str, this.f29723c);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = context;
        SwanAppComponentContainerView swanAppComponentContainerView = new SwanAppComponentContainerView(this.i);
        this.j = swanAppComponentContainerView;
        swanAppComponentContainerView.setBackgroundColor(Color.parseColor("#666666"));
        g(1);
    }

    public SwanAppComponentContainerView G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (SwanAppComponentContainerView) invokeV.objValue;
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
            if (this.k == null) {
                this.k = new VideoHolderWrapper(this, this.i);
            }
            return this.k;
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
    @Override // c.a.n0.a.s.b.a
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
            c.a.n0.a.s.b.c insert = insert();
            d.b("video", "Add CoverContainerWrapper " + insert.a() + " position " + cVar.f6102h);
            return;
        }
        c n = n();
        if (!TextUtils.equals(cVar.f6096b, n.f6096b) || !TextUtils.equals(cVar.f6097c, n.f6097c) || !TextUtils.equals(cVar.f6098d, n.f6098d)) {
            c.a.n0.a.s.g.a.a("video", "updateCoverContainerPosition with different id");
        }
        c.a.n0.a.s.b.c update = update((VideoContainerManager) cVar);
        d.b("video", "Update CoverContainerWrapper " + update.a() + " position " + cVar.f6102h);
    }

    public final void Q(View view, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, view, i) == null) || view == null || view.getVisibility() == i) {
            return;
        }
        view.setVisibility(i);
    }

    @Override // c.a.n0.a.s.b.a
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) ? this.j : (SwanAppComponentContainerView) invokeL.objValue;
    }
}
