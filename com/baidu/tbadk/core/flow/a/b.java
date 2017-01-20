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
    public c th() {
        c cVar = new c();
        cVar.ct(r.g.icon_banner_n);
        cVar.cu(r.g.icon_banner_s);
        cVar.setSpacing(r.f.ds22);
        cVar.setGravity(81);
        cVar.cv(r.f.ds22);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView S(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public e ti() {
        e eVar = new e();
        Resources resources = TbadkCoreApplication.m9getInst().getResources();
        if (resources != null) {
            eVar.setHeight(resources.getDimensionPixelSize(r.f.ds330));
        }
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View tj() {
        return null;
    }
}
