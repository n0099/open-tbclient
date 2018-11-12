package com.baidu.tbadk.core.flow.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.flow.a {
    @Override // com.baidu.tbadk.core.flow.a
    public c AL() {
        c cVar = new c();
        cVar.de(e.f.icon_banner_n);
        cVar.df(e.f.icon_banner_s);
        cVar.setSpacing(e.C0200e.ds22);
        cVar.setGravity(81);
        cVar.dg(e.C0200e.ds22);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.a
    public TbImageView bp(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.a
    public e AM() {
        e eVar = new e();
        Resources resources = TbadkCoreApplication.getInst().getResources();
        if (resources != null) {
            eVar.setHeight(resources.getDimensionPixelSize(e.C0200e.ds330));
        }
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.a
    public View AN() {
        return null;
    }
}
