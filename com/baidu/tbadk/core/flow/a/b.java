package com.baidu.tbadk.core.flow.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.flow.b {
    @Override // com.baidu.tbadk.core.flow.b
    public c to() {
        c cVar = new c();
        cVar.cq(w.g.icon_banner_n);
        cVar.cr(w.g.icon_banner_s);
        cVar.setSpacing(w.f.ds22);
        cVar.setGravity(81);
        cVar.cs(w.f.ds22);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView as(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public e tp() {
        e eVar = new e();
        Resources resources = TbadkCoreApplication.m9getInst().getResources();
        if (resources != null) {
            eVar.setHeight(resources.getDimensionPixelSize(w.f.ds330));
        }
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View tq() {
        return null;
    }
}
