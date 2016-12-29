package com.baidu.tbadk.core.flow.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.flow.b {
    @Override // com.baidu.tbadk.core.flow.b
    public c tn() {
        c cVar = new c();
        cVar.cu(r.f.icon_banner_n);
        cVar.cv(r.f.icon_banner_s);
        cVar.setSpacing(r.e.ds22);
        cVar.setGravity(81);
        cVar.cw(r.e.ds22);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView Q(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public e to() {
        e eVar = new e();
        Resources resources = TbadkCoreApplication.m9getInst().getResources();
        if (resources != null) {
            eVar.setHeight(resources.getDimensionPixelSize(r.e.ds330));
        }
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View tp() {
        return null;
    }
}
