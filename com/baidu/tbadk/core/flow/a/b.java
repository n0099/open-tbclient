package com.baidu.tbadk.core.flow.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.flow.b {
    @Override // com.baidu.tbadk.core.flow.b
    public c tm() {
        c cVar = new c();
        cVar.cu(d.g.icon_banner_n);
        cVar.cv(d.g.icon_banner_s);
        cVar.setSpacing(d.f.ds22);
        cVar.setGravity(81);
        cVar.cw(d.f.ds22);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView ay(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public e tn() {
        e eVar = new e();
        Resources resources = TbadkCoreApplication.getInst().getResources();
        if (resources != null) {
            eVar.setHeight(resources.getDimensionPixelSize(d.f.ds330));
        }
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View to() {
        return null;
    }
}
