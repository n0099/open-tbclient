package com.baidu.tbadk.core.view.viewpager.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.viewpager.a;
import com.baidu.tbadk.core.view.viewpager.g;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class c extends g<com.baidu.tbadk.core.view.viewpager.a.a, a> {
    private Context mContext;

    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.viewpager.g
    public View a(ViewGroup viewGroup, a aVar, com.baidu.tbadk.core.view.viewpager.a.a aVar2) {
        aVar.agC.d(aVar2.getImageUrl(), 10, false);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.viewpager.g
    public void a(int i, a aVar, com.baidu.tbadk.core.view.viewpager.a.a aVar2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.viewpager.g
    /* renamed from: d */
    public a c(ViewGroup viewGroup) {
        TbImageView tbImageView = new TbImageView(this.mContext);
        tbImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return new a(tbImageView);
    }

    /* loaded from: classes.dex */
    public class a extends a.C0043a {
        public TbImageView agC;

        public a(View view) {
            super(view);
            if (view instanceof TbImageView) {
                this.agC = (TbImageView) view;
                this.agC.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }
}
