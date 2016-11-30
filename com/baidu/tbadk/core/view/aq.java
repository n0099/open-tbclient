package com.baidu.tbadk.core.view;

import android.content.Context;
/* loaded from: classes.dex */
class aq implements com.baidu.adp.lib.f.c<HeadImageView> {
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(Context context) {
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: wU */
    public HeadImageView ez() {
        return new HeadImageView(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void o(HeadImageView headImageView) {
        headImageView.setBackgroundResource(0);
        headImageView.setImageDrawable(null);
        headImageView.setTag(null);
        headImageView.setOnClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public HeadImageView p(HeadImageView headImageView) {
        return headImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public HeadImageView q(HeadImageView headImageView) {
        headImageView.setBackgroundResource(0);
        headImageView.setImageDrawable(null);
        headImageView.setTag(null);
        headImageView.setOnClickListener(null);
        return headImageView;
    }
}
