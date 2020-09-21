package com.baidu.searchbox.floating.listener;

import android.graphics.Point;
import android.view.View;
import com.baidu.searchbox.floating.config.ScaleMode;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes5.dex */
public class SimpleFloatListener implements FloatViewListener {
    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewCreate(boolean z, View view, ScaleMode scaleMode, Point point) {
        q.m(scaleMode, "scaleLevel");
        q.m(point, "position");
        onViewCreate(z, view);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewDismiss(View view, ScaleMode scaleMode, Point point) {
        q.m(view, "view");
        q.m(scaleMode, "scaleLevel");
        q.m(point, "position");
        onViewDismiss(view);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewShow(View view, ScaleMode scaleMode, Point point) {
        q.m(view, "view");
        q.m(scaleMode, "scaleLevel");
        q.m(point, "position");
        onViewShow(view);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewHide(View view, ScaleMode scaleMode, Point point) {
        q.m(view, "view");
        q.m(scaleMode, "scaleLevel");
        q.m(point, "position");
        onViewHide(view);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onClick(View view, ScaleMode scaleMode, Point point) {
        q.m(view, "view");
        q.m(scaleMode, "scaleLevel");
        q.m(point, "position");
        onClick(view);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onScale(boolean z, ScaleMode scaleMode, Point point) {
        q.m(scaleMode, "scaleLevel");
        q.m(point, "position");
        onScale(z);
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewCreate(boolean z, View view) {
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewDismiss(View view) {
        q.m(view, "view");
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewShow(View view) {
        q.m(view, "view");
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onViewHide(View view) {
        q.m(view, "view");
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onPermissionResult(boolean z) {
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onClick(View view) {
        q.m(view, "view");
    }

    @Override // com.baidu.searchbox.floating.listener.FloatViewListener
    public void onScale(boolean z) {
    }
}
