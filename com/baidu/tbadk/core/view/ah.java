package com.baidu.tbadk.core.view;

import android.content.Context;
/* loaded from: classes.dex */
class ah implements com.baidu.adp.lib.f.c<HeadImageView> {
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(Context context) {
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: vX */
    public HeadImageView hc() {
        return new HeadImageView(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void l(HeadImageView headImageView) {
        headImageView.setBackgroundResource(0);
        headImageView.setImageDrawable(null);
        headImageView.setTag(null);
        headImageView.setOnClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public HeadImageView m(HeadImageView headImageView) {
        return headImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public HeadImageView n(HeadImageView headImageView) {
        headImageView.setBackgroundResource(0);
        headImageView.setImageDrawable(null);
        headImageView.setTag(null);
        headImageView.setOnClickListener(null);
        return headImageView;
    }
}
