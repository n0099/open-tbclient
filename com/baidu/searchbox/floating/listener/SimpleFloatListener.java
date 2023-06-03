package com.baidu.searchbox.floating.listener;

import android.graphics.Point;
import android.view.View;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.floating.config.ScaleMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001a\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/floating/listener/SimpleFloatListener;", "Lcom/baidu/searchbox/floating/listener/FloatViewListener;", "()V", "onClick", "", "view", "Landroid/view/View;", "scaleLevel", "Lcom/baidu/searchbox/floating/config/ScaleMode;", CriusAttrConstants.POSITION, "Landroid/graphics/Point;", "onDragEnd", "onGestureSingleTapConfirmed", "onPermissionResult", "access", "", "onScale", "isEnLager", "onScaleGestureCallback", "isInProgress", "onViewCreate", "isCreate", "onViewDismiss", "onViewHide", "onViewShow", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class SimpleFloatListener implements FloatViewListener {
    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    public void onDragEnd(Point position) {
        Intrinsics.checkNotNullParameter(position, "position");
    }

    public void onGestureSingleTapConfirmed() {
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onPermissionResult(boolean z) {
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onScale(boolean z) {
    }

    public void onScaleGestureCallback(boolean z) {
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewCreate(boolean z, View view2) {
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewDismiss(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewHide(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewShow(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onClick(View view2, ScaleMode scaleLevel, Point position) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(scaleLevel, "scaleLevel");
        Intrinsics.checkNotNullParameter(position, "position");
        onClick(view2);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onScale(boolean z, ScaleMode scaleLevel, Point position) {
        Intrinsics.checkNotNullParameter(scaleLevel, "scaleLevel");
        Intrinsics.checkNotNullParameter(position, "position");
        onScale(z);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewDismiss(View view2, ScaleMode scaleLevel, Point position) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(scaleLevel, "scaleLevel");
        Intrinsics.checkNotNullParameter(position, "position");
        onViewDismiss(view2);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewHide(View view2, ScaleMode scaleLevel, Point position) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(scaleLevel, "scaleLevel");
        Intrinsics.checkNotNullParameter(position, "position");
        onViewHide(view2);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewShow(View view2, ScaleMode scaleLevel, Point position) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(scaleLevel, "scaleLevel");
        Intrinsics.checkNotNullParameter(position, "position");
        onViewShow(view2);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewCreate(boolean z, View view2, ScaleMode scaleLevel, Point position) {
        Intrinsics.checkNotNullParameter(scaleLevel, "scaleLevel");
        Intrinsics.checkNotNullParameter(position, "position");
        onViewCreate(z, view2);
    }
}
