package com.baidu.searchbox.floating.config;

import android.app.Notification;
import android.graphics.Rect;
import android.view.View;
import com.baidu.searchbox.floating.IFloating;
import com.baidu.searchbox.floating.animator.FloatViewAnimator;
import com.baidu.searchbox.floating.listener.FloatViewListener;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Pair;
import kotlin.e;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes14.dex */
public class Config {
    public static final Companion Companion = new Companion(null);
    public static final String FLOATING_CLOSE_WARNING = "floating_close_warning";
    public static final String FLOATING_PERMISSION_AUTH = "floating_permission_auth";
    private FloatViewAnimator animator;
    private IFloating floatingContext;
    private View floatingView;
    private boolean isAnimating;
    private boolean isDragging;
    private boolean isForeground;
    private Notification notification;
    private boolean reverse;
    private int shadow;
    private Rect blockOffset = new Rect(0, 0, 0, 0);
    private Pair<Integer, Integer> location = new Pair<>(-1, -1);
    private Pair<Integer, Integer> size = new Pair<>(-1, -1);
    private Pair<? extends ScaleMode, ? extends ScaleMode> scaleMode = new Pair<>(ScaleMode.S, ScaleMode.S);
    private boolean canDrag = true;
    private ArrayList<FloatViewListener> floatViewListeners = new ArrayList<>();
    private final Set<String> filter = new LinkedHashSet();

    @e
    /* loaded from: classes14.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }
    }

    public final Rect getBlockOffset() {
        return this.blockOffset;
    }

    public final void setBlockOffset(Rect rect) {
        p.p(rect, "<set-?>");
        this.blockOffset = rect;
    }

    public final Pair<Integer, Integer> getLocation() {
        return this.location;
    }

    public final void setLocation(Pair<Integer, Integer> pair) {
        p.p(pair, "<set-?>");
        this.location = pair;
    }

    public final Pair<Integer, Integer> getSize() {
        return this.size;
    }

    public final void setSize(Pair<Integer, Integer> pair) {
        p.p(pair, "<set-?>");
        this.size = pair;
    }

    public final int getShadow() {
        return this.shadow;
    }

    public final void setShadow(int i) {
        this.shadow = i;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.Pair<? extends com.baidu.searchbox.floating.config.ScaleMode, ? extends com.baidu.searchbox.floating.config.ScaleMode>, kotlin.Pair<com.baidu.searchbox.floating.config.ScaleMode, com.baidu.searchbox.floating.config.ScaleMode> */
    public final Pair<ScaleMode, ScaleMode> getScaleMode() {
        return this.scaleMode;
    }

    public final void setScaleMode(Pair<? extends ScaleMode, ? extends ScaleMode> pair) {
        p.p(pair, "<set-?>");
        this.scaleMode = pair;
    }

    public final boolean getCanDrag() {
        return this.canDrag;
    }

    public final void setCanDrag(boolean z) {
        this.canDrag = z;
    }

    public final boolean isDragging() {
        return this.isDragging;
    }

    public final void setDragging(boolean z) {
        this.isDragging = z;
    }

    public final boolean isAnimating() {
        return this.isAnimating;
    }

    public final void setAnimating(boolean z) {
        this.isAnimating = z;
    }

    public final boolean isForeground() {
        return this.isForeground;
    }

    public final void setForeground(boolean z) {
        this.isForeground = z;
    }

    public final boolean getReverse() {
        return this.reverse;
    }

    public final void setReverse(boolean z) {
        this.reverse = z;
    }

    public final IFloating getFloatingContext() {
        return this.floatingContext;
    }

    public final void setFloatingContext(IFloating iFloating) {
        this.floatingContext = iFloating;
    }

    public final ArrayList<FloatViewListener> getFloatViewListeners() {
        return this.floatViewListeners;
    }

    public final void setFloatViewListeners(ArrayList<FloatViewListener> arrayList) {
        p.p(arrayList, "<set-?>");
        this.floatViewListeners = arrayList;
    }

    public final View getFloatingView() {
        return this.floatingView;
    }

    public final void setFloatingView(View view) {
        this.floatingView = view;
    }

    public final FloatViewAnimator getAnimator() {
        return this.animator;
    }

    public final void setAnimator(FloatViewAnimator floatViewAnimator) {
        this.animator = floatViewAnimator;
    }

    public final Notification getNotification() {
        return this.notification;
    }

    public final void setNotification(Notification notification) {
        this.notification = notification;
    }

    public final Set<String> getFilter() {
        return this.filter;
    }
}
