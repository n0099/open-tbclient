package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.core.view.viewpager.b<com.baidu.tbadk.core.view.viewpager.bannerflow.a, a> {
    private Context mContext;

    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.viewpager.b
    public View a(ViewGroup viewGroup, a aVar, com.baidu.tbadk.core.view.viewpager.bannerflow.a aVar2) {
        aVar.fhd.startLoad(aVar2.getImageUrl(), 10, false);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.viewpager.b
    /* renamed from: M */
    public a L(ViewGroup viewGroup) {
        TbImageView tbImageView = new TbImageView(this.mContext);
        tbImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return new a(tbImageView);
    }

    /* loaded from: classes.dex */
    public class a extends BdBaseViewPagerAdapter.a {
        public TbImageView fhd;

        public a(View view) {
            super(view);
            if (view instanceof TbImageView) {
                this.fhd = (TbImageView) view;
                this.fhd.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }
}
