package com.baidu.tbadk.core.view;

import android.content.Context;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements com.baidu.adp.lib.f.c<TbImageView> {
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(Context context) {
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: wR */
    public TbImageView ez() {
        return new TbImageView(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void o(TbImageView tbImageView) {
        tbImageView.setBackgroundResource(0);
        tbImageView.setImageDrawable(null);
        tbImageView.setTag(null);
        tbImageView.setOnClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public TbImageView p(TbImageView tbImageView) {
        return tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public TbImageView q(TbImageView tbImageView) {
        tbImageView.setBackgroundResource(0);
        tbImageView.setImageDrawable(null);
        tbImageView.setTag(null);
        tbImageView.setOnClickListener(null);
        return tbImageView;
    }
}
