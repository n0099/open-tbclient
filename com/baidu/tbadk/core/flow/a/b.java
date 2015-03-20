package com.baidu.tbadk.core.flow.a;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.flow.b {
    @Override // com.baidu.tbadk.core.flow.b
    public c rl() {
        c cVar = new c();
        cVar.setDrawableId(u.icon_banner_n);
        cVar.bI(u.icon_banner_s);
        cVar.setSpacing(t.square_indicator_spacing);
        cVar.setGravity(81);
        cVar.bJ(t.ds22);
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
    public e rm() {
        e eVar = new e();
        Resources resources = TbadkApplication.getInst().getResources();
        if (resources != null) {
            eVar.setHeight(resources.getDimensionPixelSize(t.ds330));
        }
        return eVar;
    }
}
