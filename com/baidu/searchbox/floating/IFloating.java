package com.baidu.searchbox.floating;

import android.app.Notification;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.searchbox.floating.animator.FloatViewAnimator;
import com.baidu.searchbox.floating.config.ScaleMode;
import com.baidu.searchbox.floating.listener.FloatViewListener;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Pair;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\nJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0016H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0016H&¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H&¢\u0006\u0004\b\"\u0010\nJ\u001f\u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0016H&¢\u0006\u0004\b%\u0010 J#\u0010)\u001a\u00020\u00042\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0&H&¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+H&¢\u0006\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/baidu/searchbox/floating/IFloating;", "Lkotlin/Any;", "Lcom/baidu/searchbox/floating/listener/FloatViewListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "addFloatListener", "(Lcom/baidu/searchbox/floating/listener/FloatViewListener;)V", "", "immediately", "dismiss", "(Z)V", "hasFloatingView", "()Z", "nextScale", "onCreate", "()V", MissionEvent.MESSAGE_DESTROY, MediaAEffect.AE_ANIM_REVERSE, "Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;", ShaderParams.VALUE_TYPE_ANIMATOR, "setAnimator", "(Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;)V", "", "left", "top", "right", "bottom", "setBlockOffset", "(IIII)V", "with", "height", "setDefaultSize", "(II)V", "enable", "setDragEnable", "x", "y", "setLocation", "Lkotlin/Pair;", "Lcom/baidu/searchbox/floating/config/ScaleMode;", "mode", "setScaleMode", "(Lkotlin/Pair;)V", "Landroid/app/Notification;", ActionJsonData.TAG_NOTIFICATION, "startForeground", "(Landroid/app/Notification;)V", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface IFloating {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static /* synthetic */ void dismiss$default(IFloating iFloating, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                iFloating.dismiss(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismiss");
        }
    }

    void addFloatListener(FloatViewListener floatViewListener);

    void dismiss(boolean z);

    boolean hasFloatingView();

    boolean nextScale();

    void onCreate();

    void onDestroy();

    void reverse(boolean z);

    void setAnimator(FloatViewAnimator floatViewAnimator);

    void setBlockOffset(int i, int i2, int i3, int i4);

    void setDefaultSize(int i, int i2);

    void setDragEnable(boolean z);

    void setLocation(int i, int i2);

    void setScaleMode(Pair<? extends ScaleMode, ? extends ScaleMode> pair);

    void startForeground(Notification notification);
}
