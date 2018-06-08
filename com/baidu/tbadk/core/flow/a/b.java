package com.baidu.tbadk.core.flow.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.flow.a {
    @Override // com.baidu.tbadk.core.flow.a
    public c xl() {
        c cVar = new c();
        cVar.ct(d.f.icon_banner_n);
        cVar.cu(d.f.icon_banner_s);
        cVar.setSpacing(d.e.ds22);
        cVar.setGravity(81);
        cVar.cv(d.e.ds22);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.a
    public TbImageView aC(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.a
    public e xm() {
        e eVar = new e();
        Resources resources = TbadkCoreApplication.getInst().getResources();
        if (resources != null) {
            eVar.setHeight(resources.getDimensionPixelSize(d.e.ds330));
        }
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.a
    public View xn() {
        return null;
    }
}
