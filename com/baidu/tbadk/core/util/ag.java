package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.ListView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ag implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ ListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ListView listView) {
        this.a = listView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        com.baidu.adp.lib.util.f.e("LoadImageHelper", "imageLoaded", "callback:" + str);
        View findViewWithTag = this.a.findViewWithTag(str);
        while (findViewWithTag != null) {
            com.baidu.adp.lib.util.f.e("LoadImageHelper", "imageLoaded", "gif set");
            GifView gifView = (GifView) findViewWithTag;
            com.baidu.tbadk.widget.richText.e tbRichTextEmotionINfo = gifView.getTbRichTextEmotionINfo();
            if (bVar == null) {
                if (tbRichTextEmotionINfo != null) {
                    tbRichTextEmotionINfo.j = true;
                }
            } else if (tbRichTextEmotionINfo != null) {
                tbRichTextEmotionINfo.j = false;
            }
            gifView.setGif(bVar);
            gifView.setIsLoading(false);
            gifView.setTag(null);
            findViewWithTag = this.a.findViewWithTag(str);
        }
    }
}
