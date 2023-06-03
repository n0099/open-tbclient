package com.baidu.searchbox.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public class NoScrollGridView extends GridView {
    public NoScrollGridView(Context context) {
        super(context);
    }

    public NoScrollGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public NoScrollGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.GridView
    @TargetApi(16)
    public int getColumnWidth() {
        if (DeviceUtil.OSInfo.hasJellyBean()) {
            return super.getColumnWidth();
        }
        int width = ((WindowManager) getContext().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getWidth();
        int numColumns = getNumColumns();
        int horizontalSpacing = getHorizontalSpacing();
        return (((width - getPaddingLeft()) - getPaddingLeft()) - ((numColumns - 1) * horizontalSpacing)) / numColumns;
    }

    @Override // android.widget.GridView
    @TargetApi(16)
    public int getHorizontalSpacing() {
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getHorizontalSpacing();
        }
        try {
            Field declaredField = getClass().getDeclaredField("mHorizontalSpacing");
            declaredField.setAccessible(true);
            return declaredField.getInt(this);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
