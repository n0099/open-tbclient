package com.baidu.searchbox.floating.listener;

import android.graphics.Point;
import android.view.View;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.floating.config.ScaleMode;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
@Deprecated(message = "请直接使用SimpleFloatListener", replaceWith = @ReplaceWith(expression = "SimpleFloatListener", imports = {}))
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\fH&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J*\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/floating/listener/FloatViewListener;", "", "onClick", "", "view", "Landroid/view/View;", "scaleLevel", "Lcom/baidu/searchbox/floating/config/ScaleMode;", CriusAttrConstants.POSITION, "Landroid/graphics/Point;", "onPermissionResult", "access", "", "onScale", "isEnLager", "onViewCreate", "isCreate", "onViewDismiss", "onViewHide", "onViewShow", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface FloatViewListener {
    void onClick(View view2);

    void onClick(View view2, ScaleMode scaleMode, Point point);

    void onPermissionResult(boolean z);

    void onScale(boolean z);

    void onScale(boolean z, ScaleMode scaleMode, Point point);

    void onViewCreate(boolean z, View view2);

    void onViewCreate(boolean z, View view2, ScaleMode scaleMode, Point point);

    void onViewDismiss(View view2);

    void onViewDismiss(View view2, ScaleMode scaleMode, Point point);

    void onViewHide(View view2);

    void onViewHide(View view2, ScaleMode scaleMode, Point point);

    void onViewShow(View view2);

    void onViewShow(View view2, ScaleMode scaleMode, Point point);
}
