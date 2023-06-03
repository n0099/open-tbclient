package com.baidu.searchbox.floating.config;

import android.app.Notification;
import android.graphics.Rect;
import android.view.View;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.searchbox.floating.IFloating;
import com.baidu.searchbox.floating.animator.FloatViewAnimator;
import com.baidu.searchbox.floating.listener.FloatViewListener;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR*\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0012\"\u0004\b5\u0010\u0014R\u001a\u00106\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0012\"\u0004\b7\u0010\u0014R\u001a\u00108\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0012\"\u0004\b9\u0010\u0014R&\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020<0;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0012\"\u0004\bI\u0010\u0014R&\u0010J\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020K0;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010>\"\u0004\bM\u0010@R\u001a\u0010N\u001a\u00020<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR&\u0010S\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020<0;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010>\"\u0004\bU\u0010@R\u001a\u0010V\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0012\"\u0004\bX\u0010\u0014R\u001a\u0010Y\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0012\"\u0004\b[\u0010\u0014¨\u0006]"}, d2 = {"Lcom/baidu/searchbox/floating/config/Config;", "", "()V", ShaderParams.VALUE_TYPE_ANIMATOR, "Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;", "getAnimator", "()Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;", "setAnimator", "(Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;)V", "blockOffset", "Landroid/graphics/Rect;", "getBlockOffset", "()Landroid/graphics/Rect;", "setBlockOffset", "(Landroid/graphics/Rect;)V", "canDrag", "", "getCanDrag", "()Z", "setCanDrag", "(Z)V", "cornerRadius", "", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "filter", "", "", "getFilter", "()Ljava/util/Set;", "floatViewListeners", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/floating/listener/FloatViewListener;", "Lkotlin/collections/ArrayList;", "getFloatViewListeners", "()Ljava/util/ArrayList;", "setFloatViewListeners", "(Ljava/util/ArrayList;)V", "floatingContext", "Lcom/baidu/searchbox/floating/IFloating;", "getFloatingContext", "()Lcom/baidu/searchbox/floating/IFloating;", "setFloatingContext", "(Lcom/baidu/searchbox/floating/IFloating;)V", "floatingView", "Landroid/view/View;", "getFloatingView", "()Landroid/view/View;", "setFloatingView", "(Landroid/view/View;)V", "isAnimating", "setAnimating", "isDragging", "setDragging", "isForeground", "setForeground", "location", "Lkotlin/Pair;", "", GameAssistConstKt.METHOD_GET_LOCATION, "()Lkotlin/Pair;", "setLocation", "(Lkotlin/Pair;)V", "notification", "Landroid/app/Notification;", "getNotification", "()Landroid/app/Notification;", "setNotification", "(Landroid/app/Notification;)V", MediaAEffect.AE_ANIM_REVERSE, "getReverse", "setReverse", "scaleMode", "Lcom/baidu/searchbox/floating/config/ScaleMode;", "getScaleMode", "setScaleMode", "shadow", "getShadow", "()I", "setShadow", "(I)V", "size", "getSize", "setSize", "supportScaleDoubleTap", "getSupportScaleDoubleTap", "setSupportScaleDoubleTap", "supportScaleGesture", "getSupportScaleGesture", "setSupportScaleGesture", "Companion", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class Config {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_HEIGHT = 105;
    public static final int DEFAULT_WIDTH = 187;
    public static final int DEFAULT_X = 15;
    public static final int DEFAULT_Y = 80;
    public static final String FLOATING_CLOSE_WARNING = "floating_close_warning";
    public static final String FLOATING_PERMISSION_AUTH = "floating_permission_auth";
    public FloatViewAnimator animator;
    public boolean canDrag;
    public float cornerRadius;
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
    public boolean supportScaleDoubleTap;
    public boolean supportScaleGesture;
    public Rect blockOffset = new Rect(0, 0, 0, 0);
    public Pair<Integer, Integer> location = new Pair<>(-1, -1);
    public Pair<Integer, Integer> size = new Pair<>(-1, -1);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/floating/config/Config$Companion;", "", "()V", "DEFAULT_HEIGHT", "", "DEFAULT_WIDTH", "DEFAULT_X", "DEFAULT_Y", "FLOATING_CLOSE_WARNING", "", "FLOATING_PERMISSION_AUTH", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
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

    public final float getCornerRadius() {
        return this.cornerRadius;
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

    public final boolean getSupportScaleDoubleTap() {
        return this.supportScaleDoubleTap;
    }

    public final boolean getSupportScaleGesture() {
        return this.supportScaleGesture;
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

    public final void setCornerRadius(float f) {
        this.cornerRadius = f;
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

    public final void setSupportScaleDoubleTap(boolean z) {
        this.supportScaleDoubleTap = z;
    }

    public final void setSupportScaleGesture(boolean z) {
        this.supportScaleGesture = z;
    }
}
