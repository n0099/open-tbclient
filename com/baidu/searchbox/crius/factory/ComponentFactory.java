package com.baidu.searchbox.crius.factory;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.crius.data.RenderData;
/* loaded from: classes2.dex */
public class ComponentFactory implements IComponentFactory {
    public static volatile ComponentFactory sInstance;
    public IComponentFactory componentFactory;

    public static ComponentFactory getInstance() {
        if (sInstance == null) {
            synchronized (ComponentFactory.class) {
                if (sInstance == null) {
                    sInstance = new ComponentFactory();
                }
            }
        }
        return sInstance;
    }

    @Override // com.baidu.searchbox.crius.factory.IComponentFactory
    public View createComponent(Context context, String str) {
        if (this.componentFactory == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.componentFactory.createComponent(context, str);
    }

    @Override // com.baidu.searchbox.crius.factory.IComponentFactory
    public boolean renderComponent(String str, View view2, RenderData renderData, boolean z, boolean z2, boolean z3) {
        IComponentFactory iComponentFactory = this.componentFactory;
        if (iComponentFactory == null || view2 == null || renderData == null) {
            return false;
        }
        return iComponentFactory.renderComponent(str, view2, renderData, z, z2, z3);
    }

    public void setComponentFactory(IComponentFactory iComponentFactory) {
        this.componentFactory = iComponentFactory;
    }
}
