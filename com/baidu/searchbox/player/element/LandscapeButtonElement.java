package com.baidu.searchbox.player.element;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.tieba.R;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/player/element/LandscapeButtonElement;", "android/view/View$OnClickListener", "Lcom/baidu/searchbox/player/element/AbsElement;", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "", "initElement", "()V", "v", "onClick", "(Landroid/view/View;)V", "", RemoteMessageConst.Notification.VISIBILITY, "onParentVisibleChanged", "(I)V", "Landroid/widget/ImageView;", "landButton", "Landroid/widget/ImageView;", "<init>", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class LandscapeButtonElement extends AbsElement implements View.OnClickListener {
    public ImageView landButton;

    @Override // com.baidu.searchbox.player.element.IElement
    public View getContentView() {
        ImageView imageView = this.landButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("landButton");
        }
        return imageView;
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void initElement() {
        ImageView imageView = new ImageView(getContext());
        this.landButton = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("landButton");
        }
        int dp2px = BdPlayerUtils.dp2px(imageView, 16.0f);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(dp2px, dp2px));
        imageView.setImageResource(R.drawable.obfuscated_res_0x7f080222);
        imageView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        BDVideoPlayer videoPlayer = getVideoPlayer();
        if (!(videoPlayer instanceof UniversalPlayer)) {
            videoPlayer = null;
        }
        UniversalPlayer universalPlayer = (UniversalPlayer) videoPlayer;
        if (universalPlayer != null) {
            universalPlayer.switchToFull(1);
        }
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void onParentVisibleChanged(int i) {
        if (i == 0) {
            BDVideoPlayer videoPlayer = getVideoPlayer();
            if (!(videoPlayer instanceof UniversalPlayer)) {
                videoPlayer = null;
            }
            UniversalPlayer universalPlayer = (UniversalPlayer) videoPlayer;
            if (universalPlayer != null && !universalPlayer.isFullMode()) {
                ImageView imageView = this.landButton;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("landButton");
                }
                imageView.setVisibility(0);
                return;
            }
        }
        ImageView imageView2 = this.landButton;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("landButton");
        }
        imageView2.setVisibility(8);
    }
}
