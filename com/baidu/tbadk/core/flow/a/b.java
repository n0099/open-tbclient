package com.baidu.tbadk.core.flow.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.flow.b {
    @Override // com.baidu.tbadk.core.flow.b
    public c uw() {
        c cVar = new c();
        cVar.setDrawableId(t.f.icon_banner_n);
        cVar.cr(t.f.icon_banner_s);
        cVar.setSpacing(t.e.square_indicator_spacing);
        cVar.setGravity(81);
        cVar.cs(t.e.ds22);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView X(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public e ux() {
        e eVar = new e();
        Resources resources = TbadkCoreApplication.m411getInst().getResources();
        if (resources != null) {
            eVar.setHeight(resources.getDimensionPixelSize(t.e.ds330));
        }
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View uy() {
        return null;
    }
}
