package com.baidu.searchbox.floating;

import android.app.Notification;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.searchbox.floating.animator.FloatViewAnimator;
import com.baidu.searchbox.floating.config.ScaleMode;
import com.baidu.searchbox.floating.listener.FloatViewListener;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J(\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013H\u0016J\u001c\u0010\u001f\u001a\u00020\u00032\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0!H\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%H\u0016¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/floating/IFloating;", "", "addFloatListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/searchbox/floating/listener/FloatViewListener;", "dismiss", "immediately", "", "hasFloatingView", "nextScale", "onCreate", MissionEvent.MESSAGE_DESTROY, MediaAEffect.AE_ANIM_REVERSE, "setAnimator", ShaderParams.VALUE_TYPE_ANIMATOR, "Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;", "setBlockOffset", "left", "", "top", "right", "bottom", "setDefaultSize", "with", "height", "setDragEnable", "enable", "setLocation", "x", "y", "setScaleMode", "mode", "Lkotlin/Pair;", "Lcom/baidu/searchbox/floating/config/ScaleMode;", "startForeground", "notification", "Landroid/app/Notification;", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IFloating {
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

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static void addFloatListener(IFloating iFloating, FloatViewListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        public static void dismiss(IFloating iFloating, boolean z) {
        }

        public static boolean hasFloatingView(IFloating iFloating) {
            return false;
        }

        public static boolean nextScale(IFloating iFloating) {
            return false;
        }

        public static void onCreate(IFloating iFloating) {
        }

        public static void onDestroy(IFloating iFloating) {
        }

        public static void reverse(IFloating iFloating, boolean z) {
        }

        public static void setAnimator(IFloating iFloating, FloatViewAnimator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        public static void setBlockOffset(IFloating iFloating, int i, int i2, int i3, int i4) {
        }

        public static void setDefaultSize(IFloating iFloating, int i, int i2) {
        }

        public static void setDragEnable(IFloating iFloating, boolean z) {
        }

        public static void setLocation(IFloating iFloating, int i, int i2) {
        }

        public static void setScaleMode(IFloating iFloating, Pair<? extends ScaleMode, ? extends ScaleMode> mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
        }

        public static void startForeground(IFloating iFloating, Notification notification) {
            Intrinsics.checkNotNullParameter(notification, "notification");
        }

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
}
