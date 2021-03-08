package com.baidu.searchbox.floating.listener;

import android.graphics.Point;
import android.view.View;
import com.baidu.searchbox.floating.config.ScaleMode;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes14.dex */
public class SimpleFloatListener implements FloatViewListener {
    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewCreate(boolean z, View view, ScaleMode scaleMode, Point point) {
        p.p(scaleMode, "scaleLevel");
        p.p(point, "position");
        onViewCreate(z, view);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewDismiss(View view, ScaleMode scaleMode, Point point) {
        p.p(view, "view");
        p.p(scaleMode, "scaleLevel");
        p.p(point, "position");
        onViewDismiss(view);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewShow(View view, ScaleMode scaleMode, Point point) {
        p.p(view, "view");
        p.p(scaleMode, "scaleLevel");
        p.p(point, "position");
        onViewShow(view);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewHide(View view, ScaleMode scaleMode, Point point) {
        p.p(view, "view");
        p.p(scaleMode, "scaleLevel");
        p.p(point, "position");
        onViewHide(view);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onClick(View view, ScaleMode scaleMode, Point point) {
        p.p(view, "view");
        p.p(scaleMode, "scaleLevel");
        p.p(point, "position");
        onClick(view);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onScale(boolean z, ScaleMode scaleMode, Point point) {
        p.p(scaleMode, "scaleLevel");
        p.p(point, "position");
        onScale(z);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewCreate(boolean z, View view) {
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewDismiss(View view) {
        p.p(view, "view");
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewShow(View view) {
        p.p(view, "view");
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewHide(View view) {
        p.p(view, "view");
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onPermissionResult(boolean z) {
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onClick(View view) {
        p.p(view, "view");
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onScale(boolean z) {
    }
}
