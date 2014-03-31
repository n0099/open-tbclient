package com.baidu.tbadk.core.view;

import android.content.Context;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
final class u implements com.baidu.adp.lib.d.c<TbImageView> {
    private final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(Context context) {
        this.a = context;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ TbImageView a() {
        return new TbImageView(this.a);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ void a(TbImageView tbImageView) {
        TbImageView tbImageView2 = tbImageView;
        tbImageView2.setBackgroundResource(0);
        tbImageView2.setImageDrawable(null);
        tbImageView2.setTag(null);
        tbImageView2.setOnClickListener(null);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* bridge */ /* synthetic */ TbImageView b(TbImageView tbImageView) {
        return tbImageView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ TbImageView c(TbImageView tbImageView) {
        TbImageView tbImageView2 = tbImageView;
        tbImageView2.setBackgroundResource(0);
        tbImageView2.setImageDrawable(null);
        tbImageView2.setTag(null);
        tbImageView2.setOnClickListener(null);
        return tbImageView2;
    }
}
