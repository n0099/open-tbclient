package com.baidu.searchbox.player.element;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u000bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/player/element/BackButtonElement;", "android/view/View$OnClickListener", "Lcom/baidu/searchbox/player/element/AbsElement;", "", "attachToRootAtOnce", "()Z", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "", "initElement", "()V", "v", "onClick", "(Landroid/view/View;)V", "", "visibility", "onParentVisibleChanged", "(I)V", "Landroid/widget/ImageView;", "backButton", "Landroid/widget/ImageView;", "<init>", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class BackButtonElement extends AbsElement implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView backButton;

    public BackButtonElement() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public boolean attachToRootAtOnce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.element.IElement
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ImageView imageView = this.backButton;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backButton");
            }
            return imageView;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void initElement() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.backButton = imageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backButton");
            }
            int dp2px = BdPlayerUtils.dp2px(imageView, 26.0f);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(dp2px, dp2px));
            int dp2px2 = BdPlayerUtils.dp2px(imageView, 10.0f);
            imageView.setPadding(dp2px2, dp2px2, dp2px2, dp2px2);
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f08020c);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            BDVideoPlayer videoPlayer = getVideoPlayer();
            if (!(videoPlayer instanceof UniversalPlayer)) {
                videoPlayer = null;
            }
            UniversalPlayer universalPlayer = (UniversalPlayer) videoPlayer;
            if (universalPlayer != null) {
                universalPlayer.switchToHalf(2);
            }
        }
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void onParentVisibleChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i == 0) {
                BDVideoPlayer videoPlayer = getVideoPlayer();
                if (!(videoPlayer instanceof UniversalPlayer)) {
                    videoPlayer = null;
                }
                UniversalPlayer universalPlayer = (UniversalPlayer) videoPlayer;
                if (universalPlayer != null && universalPlayer.isFullMode()) {
                    ImageView imageView = this.backButton;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("backButton");
                    }
                    imageView.setVisibility(0);
                    return;
                }
            }
            ImageView imageView2 = this.backButton;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backButton");
            }
            imageView2.setVisibility(8);
        }
    }
}
