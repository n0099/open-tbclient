package com.baidu.searchbox.floating.listener;

import android.graphics.Point;
import android.view.View;
import com.baidu.searchbox.floating.config.ScaleMode;
import kotlin.e;
@e
/* loaded from: classes16.dex */
public interface FloatViewListener {
    void onClick(View view);

    void onClick(View view, ScaleMode scaleMode, Point point);

    void onPermissionResult(boolean z);

    void onScale(boolean z);

    void onScale(boolean z, ScaleMode scaleMode, Point point);

    void onViewCreate(boolean z, View view);

    void onViewCreate(boolean z, View view, ScaleMode scaleMode, Point point);

    void onViewDismiss(View view);

    void onViewDismiss(View view, ScaleMode scaleMode, Point point);

    void onViewHide(View view);

    void onViewHide(View view, ScaleMode scaleMode, Point point);

    void onViewShow(View view);

    void onViewShow(View view, ScaleMode scaleMode, Point point);
}
