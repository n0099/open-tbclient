package com.baidu.tbadk.core.view.viewpager.bannerflow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class b extends c<com.baidu.tbadk.core.view.viewpager.bannerflow.a, a> {
    private Context mContext;

    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.viewpager.c
    public View a(ViewGroup viewGroup, a aVar, com.baidu.tbadk.core.view.viewpager.bannerflow.a aVar2) {
        aVar.asX.startLoad(aVar2.getImageUrl(), 10, false);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.viewpager.c
    /* renamed from: g */
    public a f(ViewGroup viewGroup) {
        TbImageView tbImageView = new TbImageView(this.mContext);
        tbImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return new a(tbImageView);
    }

    /* loaded from: classes.dex */
    public class a extends BdBaseViewPagerAdapter.a {
        public TbImageView asX;

        public a(View view) {
            super(view);
            if (view instanceof TbImageView) {
                this.asX = (TbImageView) view;
                this.asX.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }
}
