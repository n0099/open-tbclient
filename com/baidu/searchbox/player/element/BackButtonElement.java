package com.baidu.searchbox.player.element;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.tieba.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/player/element/BackButtonElement;", "Lcom/baidu/searchbox/player/element/AbsElement;", "Landroid/view/View$OnClickListener;", "()V", "backButton", "Landroid/widget/ImageView;", "attachToRootAtOnce", "", "getContentView", "Landroid/view/View;", "initElement", "", "onClick", "v", "onParentVisibleChanged", "visibility", "", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class BackButtonElement extends AbsElement implements View.OnClickListener {
    public ImageView backButton;

    @Override // com.baidu.searchbox.player.element.AbsElement
    public boolean attachToRootAtOnce() {
        return false;
    }

    @Override // com.baidu.searchbox.player.element.IElement
    public View getContentView() {
        ImageView imageView = this.backButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            return null;
        }
        return imageView;
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void initElement() {
        ImageView imageView = new ImageView(getContext());
        this.backButton = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            imageView = null;
        }
        int dp2px = BdPlayerUtils.dp2px(imageView, 26.0f);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(dp2px, dp2px));
        int dp2px2 = BdPlayerUtils.dp2px(imageView, 10.0f);
        imageView.setPadding(dp2px2, dp2px2, dp2px2, dp2px2);
        imageView.setImageResource(R.drawable.obfuscated_res_0x7f08026d);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        UniversalPlayer universalPlayer;
        BDVideoPlayer videoPlayer = getVideoPlayer();
        if (videoPlayer instanceof UniversalPlayer) {
            universalPlayer = (UniversalPlayer) videoPlayer;
        } else {
            universalPlayer = null;
        }
        if (universalPlayer != null) {
            universalPlayer.switchToHalf(2);
        }
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void onParentVisibleChanged(int i) {
        UniversalPlayer universalPlayer;
        ImageView imageView = null;
        if (i == 0) {
            BDVideoPlayer videoPlayer = getVideoPlayer();
            if (videoPlayer instanceof UniversalPlayer) {
                universalPlayer = (UniversalPlayer) videoPlayer;
            } else {
                universalPlayer = null;
            }
            boolean z = true;
            if ((universalPlayer == null || !universalPlayer.isFullMode()) ? false : false) {
                ImageView imageView2 = this.backButton;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backButton");
                } else {
                    imageView = imageView2;
                }
                imageView.setVisibility(0);
                return;
            }
        }
        ImageView imageView3 = this.backButton;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
    }
}
