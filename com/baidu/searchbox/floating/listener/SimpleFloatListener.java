package com.baidu.searchbox.floating.listener;

import android.graphics.Point;
import android.view.View;
import com.baidu.searchbox.floating.config.ScaleMode;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes11.dex */
public class SimpleFloatListener implements FloatViewListener {
    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewCreate(boolean z, View view, ScaleMode scaleMode, Point point) {
        q.n(scaleMode, "scaleLevel");
        q.n(point, "position");
        onViewCreate(z, view);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewDismiss(View view, ScaleMode scaleMode, Point point) {
        q.n(view, "view");
        q.n(scaleMode, "scaleLevel");
        q.n(point, "position");
        onViewDismiss(view);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewShow(View view, ScaleMode scaleMode, Point point) {
        q.n(view, "view");
        q.n(scaleMode, "scaleLevel");
        q.n(point, "position");
        onViewShow(view);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewHide(View view, ScaleMode scaleMode, Point point) {
        q.n(view, "view");
        q.n(scaleMode, "scaleLevel");
        q.n(point, "position");
        onViewHide(view);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onClick(View view, ScaleMode scaleMode, Point point) {
        q.n(view, "view");
        q.n(scaleMode, "scaleLevel");
        q.n(point, "position");
        onClick(view);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onScale(boolean z, ScaleMode scaleMode, Point point) {
        q.n(scaleMode, "scaleLevel");
        q.n(point, "position");
        onScale(z);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewCreate(boolean z, View view) {
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewDismiss(View view) {
        q.n(view, "view");
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewShow(View view) {
        q.n(view, "view");
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewHide(View view) {
        q.n(view, "view");
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onPermissionResult(boolean z) {
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onClick(View view) {
        q.n(view, "view");
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onScale(boolean z) {
    }
}
