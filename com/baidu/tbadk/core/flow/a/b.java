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
    public c Cc() {
        c cVar = new c();
        cVar.ds(e.f.icon_banner_n);
        cVar.dt(e.f.icon_banner_s);
        cVar.setSpacing(e.C0210e.ds22);
        cVar.setGravity(81);
        cVar.du(e.C0210e.ds22);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.a
    public TbImageView bs(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.a
    public e Cd() {
        e eVar = new e();
        Resources resources = TbadkCoreApplication.getInst().getResources();
        if (resources != null) {
            eVar.setHeight(resources.getDimensionPixelSize(e.C0210e.ds330));
        }
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.a
    public View Ce() {
        return null;
    }
}
