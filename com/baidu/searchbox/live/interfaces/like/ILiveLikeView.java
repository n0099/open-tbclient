package com.baidu.searchbox.live.interfaces.like;

import android.animation.Animator;
import android.view.View;
import com.baidu.webkit.sdk.WebChromeClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u000eJ'\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b!\u0010\u0018¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/live/interfaces/like/ILiveLikeView;", "Lkotlin/Any;", "Landroid/view/View;", "view", "", "n", "", "addLikeAnimation", "(Landroid/view/View;I)V", "", "clickBySelf", "addLikeAnimationNew", "(Landroid/view/View;IZ)V", "getLikeAnimatorView", "()Landroid/view/View;", "getLikeRippleView", "getLikeView", "getLikeViewNew", "", "", "images", "initImages", "(Landroid/view/View;[Ljava/lang/String;)V", "playAnimation", "(Landroid/view/View;)V", "Landroid/animation/Animator$AnimatorListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAnimatorListener", "(Landroid/view/View;Landroid/animation/Animator$AnimatorListener;)V", "Lcom/baidu/searchbox/live/interfaces/like/LiveLikeAnimatorCallback;", WebChromeClient.KEY_ARG_CALLBACK, "setLikeAnimatorListener", "(Landroid/view/View;Lcom/baidu/searchbox/live/interfaces/like/LiveLikeAnimatorCallback;)V", "startRipple", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface ILiveLikeView {
    void addLikeAnimation(View view2, int i);

    void addLikeAnimationNew(View view2, int i, boolean z);

    View getLikeAnimatorView();

    View getLikeRippleView();

    View getLikeView();

    View getLikeViewNew();

    void initImages(View view2, String[] strArr);

    void playAnimation(View view2);

    void setAnimatorListener(View view2, Animator.AnimatorListener animatorListener);

    void setLikeAnimatorListener(View view2, LiveLikeAnimatorCallback liveLikeAnimatorCallback);

    void startRipple(View view2);
}
