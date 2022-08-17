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
import com.repackage.ow1;
import com.repackage.pw1;
import com.repackage.qw1;
import com.repackage.sx1;
import com.repackage.tp2;
import com.repackage.zx1;
import java.io.File;
/* loaded from: classes3.dex */
public class VideoContainerManager extends ow1<VideoHolderWrapper, tp2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context i;
    public SwanAppComponentContainerView j;
    public VideoHolderWrapper k;

    /* loaded from: classes3.dex */
    public class VideoHolderWrapper extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrameLayout a;
        public ImageView b;
        public SimpleDraweeView c;
        public final /* synthetic */ VideoContainerManager d;

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
            this.d = videoContainerManager;
            e();
            d();
            c();
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, simpleDraweeView) == null) {
                Uri b = b(str);
                if (b == null) {
                    simpleDraweeView.setController(null);
                    return;
                }
                ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(b);
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
                ImageView imageView = new ImageView(this.d.i);
                this.b = imageView;
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f0811aa);
                this.b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                this.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f0811a0);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                addView(this.b, layoutParams);
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.c = new SimpleDraweeView(getContext());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.c.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
                addView(this.c, layoutParams);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (View) invokeV.objValue;
        }

        public FrameLayout getVideoHolder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (FrameLayout) invokeV.objValue;
        }

        public SimpleDraweeView getVideoPoster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : (SimpleDraweeView) invokeV.objValue;
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
            char c = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != 3143043) {
                if (hashCode != 94852023) {
                    if (hashCode == 951526612 && str2.equals("contain")) {
                        c = 0;
                    }
                } else if (str2.equals(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY)) {
                    c = 1;
                }
            } else if (str2.equals("fill")) {
                c = 2;
            }
            if (c == 0) {
                ScalingUtils.ScaleType scaleType2 = ScalingUtils.ScaleType.CENTER_INSIDE;
            } else if (c == 1) {
                ScalingUtils.ScaleType scaleType3 = ScalingUtils.ScaleType.CENTER_CROP;
            } else if (c == 2) {
                ScalingUtils.ScaleType scaleType4 = ScalingUtils.ScaleType.FIT_XY;
            }
            this.c.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            a(str, this.c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoContainerManager(@NonNull Context context, @NonNull tp2 tp2Var) {
        super(context, tp2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tp2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (pw1) objArr2[1]);
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
    @Override // com.repackage.ow1
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

    public void O(tp2 tp2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tp2Var) == null) || tp2Var == null) {
            return;
        }
        P(tp2Var);
    }

    public final void P(tp2 tp2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, tp2Var) == null) || tp2Var == null) {
            return;
        }
        if (!(m() != null)) {
            if (I().getParent() instanceof ViewGroup) {
                ((ViewGroup) I().getParent()).removeView(I());
            }
            G().setDescendantFocusability(393216);
            qw1 insert = insert();
            zx1.b("video", "Add CoverContainerWrapper " + insert.a() + " position " + tp2Var.h);
            return;
        }
        tp2 n = n();
        if (!TextUtils.equals(tp2Var.b, n.b) || !TextUtils.equals(tp2Var.c, n.c) || !TextUtils.equals(tp2Var.d, n.d)) {
            sx1.a("video", "updateCoverContainerPosition with different id");
        }
        qw1 update = update((VideoContainerManager) tp2Var);
        zx1.b("video", "Update CoverContainerWrapper " + update.a() + " position " + tp2Var.h);
    }

    public final void Q(View view2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, view2, i) == null) || view2 == null || view2.getVisibility() == i) {
            return;
        }
        view2.setVisibility(i);
    }

    @Override // com.repackage.ow1
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) ? this.j : (SwanAppComponentContainerView) invokeL.objValue;
    }
}
