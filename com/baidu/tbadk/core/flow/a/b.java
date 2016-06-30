package com.baidu.tbadk.core.flow.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.flow.b {
    @Override // com.baidu.tbadk.core.flow.b
    public c sf() {
        c cVar = new c();
        cVar.ce(u.f.icon_banner_n);
        cVar.cf(u.f.icon_banner_s);
        cVar.setSpacing(u.e.ds22);
        cVar.setGravity(81);
        cVar.cg(u.e.ds22);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView I(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public e sg() {
        e eVar = new e();
        Resources resources = TbadkCoreApplication.m9getInst().getResources();
        if (resources != null) {
            eVar.setHeight(resources.getDimensionPixelSize(u.e.ds330));
        }
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View sh() {
        return null;
    }
}
