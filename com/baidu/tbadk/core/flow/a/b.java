package com.baidu.tbadk.core.flow.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b implements com.baidu.tbadk.core.flow.a {
    @Override // com.baidu.tbadk.core.flow.a
    public c ua() {
        c cVar = new c();
        cVar.nH(R.drawable.icon_banner_n);
        cVar.nI(R.drawable.icon_banner_s);
        cVar.setSpacing(R.dimen.ds22);
        cVar.setGravity(81);
        cVar.nJ(R.dimen.ds22);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.a
    public TbImageView V(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.a
    public e tZ() {
        e eVar = new e();
        Resources resources = TbadkCoreApplication.getInst().getResources();
        if (resources != null) {
            eVar.setHeight(resources.getDimensionPixelSize(R.dimen.ds330));
        }
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.a
    public View bhC() {
        return null;
    }
}
