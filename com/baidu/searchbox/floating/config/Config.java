package com.baidu.searchbox.floating.config;

import android.app.Notification;
import android.graphics.Rect;
import android.view.View;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.searchbox.floating.IFloating;
import com.baidu.searchbox.floating.animator.FloatViewAnimator;
import com.baidu.searchbox.floating.listener.FloatViewListener;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 Z:\u0001ZB\u0007¢\u0006\u0004\bX\u0010YR$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR2\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0011\u001a\u0004\b3\u0010\u0013\"\u0004\b4\u0010\u0015R\"\u00105\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0011\u001a\u0004\b5\u0010\u0013\"\u0004\b6\u0010\u0015R\"\u00107\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0011\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u0010\u0015R.\u0010;\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020:098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010H\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010\u0011\u001a\u0004\bI\u0010\u0013\"\u0004\bJ\u0010\u0015R.\u0010L\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020K098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010<\u001a\u0004\bM\u0010>\"\u0004\bN\u0010@R\"\u0010O\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR.\u0010U\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020:098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010<\u001a\u0004\bV\u0010>\"\u0004\bW\u0010@¨\u0006["}, d2 = {"Lcom/baidu/searchbox/floating/config/Config;", "Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;", ShaderParams.VALUE_TYPE_ANIMATOR, "Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;", "getAnimator", "()Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;", "setAnimator", "(Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;)V", "Landroid/graphics/Rect;", "blockOffset", "Landroid/graphics/Rect;", "getBlockOffset", "()Landroid/graphics/Rect;", "setBlockOffset", "(Landroid/graphics/Rect;)V", "", "canDrag", "Z", "getCanDrag", "()Z", "setCanDrag", "(Z)V", "", "", "filter", "Ljava/util/Set;", "getFilter", "()Ljava/util/Set;", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/floating/listener/FloatViewListener;", "Lkotlin/collections/ArrayList;", "floatViewListeners", "Ljava/util/ArrayList;", "getFloatViewListeners", "()Ljava/util/ArrayList;", "setFloatViewListeners", "(Ljava/util/ArrayList;)V", "Lcom/baidu/searchbox/floating/IFloating;", "floatingContext", "Lcom/baidu/searchbox/floating/IFloating;", "getFloatingContext", "()Lcom/baidu/searchbox/floating/IFloating;", "setFloatingContext", "(Lcom/baidu/searchbox/floating/IFloating;)V", "Landroid/view/View;", "floatingView", "Landroid/view/View;", "getFloatingView", "()Landroid/view/View;", "setFloatingView", "(Landroid/view/View;)V", "isAnimating", "setAnimating", "isDragging", "setDragging", "isForeground", "setForeground", "Lkotlin/Pair;", "", "location", "Lkotlin/Pair;", "getLocation", "()Lkotlin/Pair;", "setLocation", "(Lkotlin/Pair;)V", "Landroid/app/Notification;", "notification", "Landroid/app/Notification;", "getNotification", "()Landroid/app/Notification;", "setNotification", "(Landroid/app/Notification;)V", MediaAEffect.AE_ANIM_REVERSE, "getReverse", "setReverse", "Lcom/baidu/searchbox/floating/config/ScaleMode;", "scaleMode", "getScaleMode", "setScaleMode", "shadow", "I", "getShadow", "()I", "setShadow", "(I)V", "size", "getSize", "setSize", "<init>", "()V", "Companion", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class Config {
    public static final Companion Companion = new Companion(null);
    public static final String FLOATING_CLOSE_WARNING = "floating_close_warning";
    public static final String FLOATING_PERMISSION_AUTH = "floating_permission_auth";
    public FloatViewAnimator animator;
    public boolean canDrag;
    public final Set<String> filter;
    public ArrayList<FloatViewListener> floatViewListeners;
    public IFloating floatingContext;
    public View floatingView;
    public boolean isAnimating;
    public boolean isDragging;
    public boolean isForeground;
    public Notification notification;
    public boolean reverse;
    public Pair<? extends ScaleMode, ? extends ScaleMode> scaleMode;
    public int shadow;
    public Rect blockOffset = new Rect(0, 0, 0, 0);
    public Pair<Integer, Integer> location = new Pair<>(-1, -1);
    public Pair<Integer, Integer> size = new Pair<>(-1, -1);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/floating/config/Config$Companion;", "", "FLOATING_CLOSE_WARNING", "Ljava/lang/String;", "FLOATING_PERMISSION_AUTH", "<init>", "()V", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Config() {
        ScaleMode scaleMode = ScaleMode.S;
        this.scaleMode = new Pair<>(scaleMode, scaleMode);
        this.canDrag = true;
        this.floatViewListeners = new ArrayList<>();
        this.filter = new LinkedHashSet();
    }

    public final FloatViewAnimator getAnimator() {
        return this.animator;
    }

    public final Rect getBlockOffset() {
        return this.blockOffset;
    }

    public final boolean getCanDrag() {
        return this.canDrag;
    }

    public final Set<String> getFilter() {
        return this.filter;
    }

    public final ArrayList<FloatViewListener> getFloatViewListeners() {
        return this.floatViewListeners;
    }

    public final IFloating getFloatingContext() {
        return this.floatingContext;
    }

    public final View getFloatingView() {
        return this.floatingView;
    }

    public final Pair<Integer, Integer> getLocation() {
        return this.location;
    }

    public final Notification getNotification() {
        return this.notification;
    }

    public final boolean getReverse() {
        return this.reverse;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.Pair<? extends com.baidu.searchbox.floating.config.ScaleMode, ? extends com.baidu.searchbox.floating.config.ScaleMode>, kotlin.Pair<com.baidu.searchbox.floating.config.ScaleMode, com.baidu.searchbox.floating.config.ScaleMode> */
    public final Pair<ScaleMode, ScaleMode> getScaleMode() {
        return this.scaleMode;
    }

    public final int getShadow() {
        return this.shadow;
    }

    public final Pair<Integer, Integer> getSize() {
        return this.size;
    }

    public final boolean isAnimating() {
        return this.isAnimating;
    }

    public final boolean isDragging() {
        return this.isDragging;
    }

    public final boolean isForeground() {
        return this.isForeground;
    }

    public final void setAnimating(boolean z) {
        this.isAnimating = z;
    }

    public final void setAnimator(FloatViewAnimator floatViewAnimator) {
        this.animator = floatViewAnimator;
    }

    public final void setBlockOffset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<set-?>");
        this.blockOffset = rect;
    }

    public final void setCanDrag(boolean z) {
        this.canDrag = z;
    }

    public final void setDragging(boolean z) {
        this.isDragging = z;
    }

    public final void setFloatViewListeners(ArrayList<FloatViewListener> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.floatViewListeners = arrayList;
    }

    public final void setFloatingContext(IFloating iFloating) {
        this.floatingContext = iFloating;
    }

    public final void setFloatingView(View view2) {
        this.floatingView = view2;
    }

    public final void setForeground(boolean z) {
        this.isForeground = z;
    }

    public final void setLocation(Pair<Integer, Integer> pair) {
        Intrinsics.checkNotNullParameter(pair, "<set-?>");
        this.location = pair;
    }

    public final void setNotification(Notification notification) {
        this.notification = notification;
    }

    public final void setReverse(boolean z) {
        this.reverse = z;
    }

    public final void setScaleMode(Pair<? extends ScaleMode, ? extends ScaleMode> pair) {
        Intrinsics.checkNotNullParameter(pair, "<set-?>");
        this.scaleMode = pair;
    }

    public final void setShadow(int i) {
        this.shadow = i;
    }

    public final void setSize(Pair<Integer, Integer> pair) {
        Intrinsics.checkNotNullParameter(pair, "<set-?>");
        this.size = pair;
    }
}
