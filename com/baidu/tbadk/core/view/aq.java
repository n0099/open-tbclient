package com.baidu.tbadk.core.view;

import android.content.Context;
/* loaded from: classes.dex */
class aq implements com.baidu.adp.lib.e.c<HeadImageView> {
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(Context context) {
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: tU */
    public HeadImageView hA() {
        return new HeadImageView(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void k(HeadImageView headImageView) {
        headImageView.setBackgroundResource(0);
        headImageView.setImageDrawable(null);
        headImageView.setTag(null);
        headImageView.setOnClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public HeadImageView l(HeadImageView headImageView) {
        return headImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public HeadImageView m(HeadImageView headImageView) {
        headImageView.setBackgroundResource(0);
        headImageView.setImageDrawable(null);
        headImageView.setTag(null);
        headImageView.setOnClickListener(null);
        return headImageView;
    }
}
