package com.baidu.searchbox.floating.listener;

import android.graphics.Point;
import android.view.View;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.floating.config.ScaleMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0005\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ'\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0006J'\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u000bJ\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0006J'\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0006J'\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/floating/listener/SimpleFloatListener;", "Lcom/baidu/searchbox/floating/listener/FloatViewListener;", "Landroid/view/View;", "view", "", "onClick", "(Landroid/view/View;)V", "Lcom/baidu/searchbox/floating/config/ScaleMode;", "scaleLevel", "Landroid/graphics/Point;", CriusAttrConstants.POSITION, "(Landroid/view/View;Lcom/baidu/searchbox/floating/config/ScaleMode;Landroid/graphics/Point;)V", "", "access", "onPermissionResult", "(Z)V", "isEnLager", "onScale", "(ZLcom/baidu/searchbox/floating/config/ScaleMode;Landroid/graphics/Point;)V", "isCreate", "onViewCreate", "(ZLandroid/view/View;)V", "(ZLandroid/view/View;Lcom/baidu/searchbox/floating/config/ScaleMode;Landroid/graphics/Point;)V", "onViewDismiss", "onViewHide", "onViewShow", "<init>", "()V", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public class SimpleFloatListener implements FloatViewListener {
    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onPermissionResult(boolean z) {
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onScale(boolean z) {
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
