package com.baidu.searchbox.crius.factory;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.crius.data.RenderData;
/* loaded from: classes2.dex */
public class NativeRenderFactory implements INativeRenderFactory {
    public static volatile NativeRenderFactory sInstance;
    public INativeRenderFactory nativeRenderFactory;

    public static NativeRenderFactory getInstance() {
        if (sInstance == null) {
            synchronized (NativeRenderFactory.class) {
                if (sInstance == null) {
                    sInstance = new NativeRenderFactory();
                }
            }
        }
        return sInstance;
    }

    @Override // com.baidu.searchbox.crius.factory.INativeRenderFactory
    public View createView(Context context, String str) {
        if (this.nativeRenderFactory == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.nativeRenderFactory.createView(context, str);
    }

    @Override // com.baidu.searchbox.crius.factory.INativeRenderFactory
    public boolean renderBackground(String str, View view2, String str2, String str3) {
        if (this.nativeRenderFactory == null || view2 == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.nativeRenderFactory.renderBackground(str, view2, str2, str3);
    }

    @Override // com.baidu.searchbox.crius.factory.INativeRenderFactory
    public boolean renderView(String str, View view2, RenderData renderData, boolean z, boolean z2) {
        INativeRenderFactory iNativeRenderFactory = this.nativeRenderFactory;
        if (iNativeRenderFactory == null || view2 == null || renderData == null) {
            return false;
        }
        return iNativeRenderFactory.renderView(str, view2, renderData, z, z2);
    }

    public void setNativeRenderFactory(INativeRenderFactory iNativeRenderFactory) {
        this.nativeRenderFactory = iNativeRenderFactory;
    }
}
