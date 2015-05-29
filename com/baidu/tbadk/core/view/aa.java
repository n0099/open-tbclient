package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes.dex */
public class aa {
    NoDataViewFactory.ImgType ZE = NoDataViewFactory.ImgType.NONE;
    int ZF = -1;
    int Zy = -1;
    int mHeight = -1;
    int mWidth = -1;

    private aa() {
    }

    public static aa a(NoDataViewFactory.ImgType imgType, int i) {
        aa aaVar = new aa();
        aaVar.ZE = imgType;
        aaVar.ZF = i;
        return aaVar;
    }

    public static aa a(NoDataViewFactory.ImgType imgType, int i, int i2, int i3, int i4) {
        aa aaVar = new aa();
        aaVar.ZE = imgType;
        aaVar.Zy = i;
        aaVar.ZF = i2;
        aaVar.mHeight = i3;
        aaVar.mWidth = i4;
        return aaVar;
    }

    public static aa a(NoDataViewFactory.ImgType imgType) {
        aa aaVar = new aa();
        aaVar.ZE = imgType;
        return aaVar;
    }
}
