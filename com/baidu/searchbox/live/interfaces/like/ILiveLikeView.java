package com.baidu.searchbox.live.interfaces.like;

import android.animation.Animator;
import android.view.View;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/like/ILiveLikeView;", "Lkotlin/Any;", "Landroid/view/View;", "view", "", "n", "", "addLikeAnimation", "(Landroid/view/View;I)V", "getLikeAnimatorView", "()Landroid/view/View;", "getLikeRippleView", "getLikeView", "playAnimation", "(Landroid/view/View;)V", "Landroid/animation/Animator$AnimatorListener;", "listener", "setAnimatorListener", "(Landroid/view/View;Landroid/animation/Animator$AnimatorListener;)V", "Lcom/baidu/searchbox/live/interfaces/like/LiveLikeAnimatorCallback;", WebChromeClient.KEY_ARG_CALLBACK, "setLikeAnimatorListener", "(Landroid/view/View;Lcom/baidu/searchbox/live/interfaces/like/LiveLikeAnimatorCallback;)V", "startRipple", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface ILiveLikeView {
    void addLikeAnimation(View view, int i);

    View getLikeAnimatorView();

    View getLikeRippleView();

    View getLikeView();

    void playAnimation(View view);

    void setAnimatorListener(View view, Animator.AnimatorListener animatorListener);

    void setLikeAnimatorListener(View view, LiveLikeAnimatorCallback liveLikeAnimatorCallback);

    void startRipple(View view);
}
