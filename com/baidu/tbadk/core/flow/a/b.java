package com.baidu.tbadk.core.flow.a;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.o;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.flow.b {
    @Override // com.baidu.tbadk.core.flow.b
    public c rV() {
        c cVar = new c();
        cVar.setDrawableId(p.icon_banner_n);
        cVar.bM(p.icon_banner_s);
        cVar.setSpacing(o.square_indicator_spacing);
        cVar.setGravity(81);
        cVar.bN(o.ds22);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView V(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public e rW() {
        e eVar = new e();
        Resources resources = TbadkCoreApplication.m411getInst().getResources();
        if (resources != null) {
            eVar.setHeight(resources.getDimensionPixelSize(o.ds330));
        }
        return eVar;
    }
}
