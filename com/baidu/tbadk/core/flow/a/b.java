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
    public c sg() {
        c cVar = new c();
        cVar.ce(t.f.icon_banner_n);
        cVar.cf(t.f.icon_banner_s);
        cVar.setSpacing(t.e.square_indicator_spacing);
        cVar.setGravity(81);
        cVar.cg(t.e.ds22);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView J(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public e sh() {
        e eVar = new e();
        Resources resources = TbadkCoreApplication.m11getInst().getResources();
        if (resources != null) {
            eVar.setHeight(resources.getDimensionPixelSize(t.e.ds330));
        }
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View si() {
        return null;
    }
}
