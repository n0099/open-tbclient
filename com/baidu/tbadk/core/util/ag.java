package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.widget.richText.TbRichTextEmotionInfo;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ag {
    public static void a(com.baidu.adp.widget.ListView.w wVar, BdUniqueId bdUniqueId) {
        ListAdapter adapter;
        ArrayList<PreLoadImageInfo> images;
        int pbImageSize;
        if (wVar != null && com.baidu.adp.lib.util.i.hl() && (adapter = wVar.getAdapter()) != null) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
            boolean vv = av.vv();
            int firstVisiblePosition = wVar.getFirstVisiblePosition();
            int lastVisiblePosition = wVar.getLastVisiblePosition();
            com.baidu.adp.lib.f.c.fM().a(bdUniqueId, (com.baidu.adp.lib.f.b) null);
            while (true) {
                int i4 = firstVisiblePosition;
                if (i4 < adapter.getCount()) {
                    Object item = adapter.getItem(i4);
                    if ((item instanceof ah) && (images = ((ah) item).getImages()) != null && images.size() != 0) {
                        Iterator<PreLoadImageInfo> it = images.iterator();
                        int i5 = i3;
                        int i6 = i;
                        int i7 = i2;
                        while (it.hasNext()) {
                            PreLoadImageInfo next = it.next();
                            if (com.baidu.adp.lib.f.c.fM().al(next.procType)) {
                                if (12 == next.procType || 28 == next.procType) {
                                    int i8 = i5 + 1;
                                    if (i8 <= 30 && i4 > lastVisiblePosition && !TextUtils.isEmpty(next.imgUrl)) {
                                        if (12 == next.procType) {
                                            com.baidu.adp.lib.f.c.fM().a(next.imgUrl, 12, null, bdUniqueId);
                                            i5 = i8;
                                        } else if (28 == next.procType) {
                                            com.baidu.adp.lib.f.c.fM().a(next.imgUrl, 28, null, bdUniqueId);
                                            i5 = i8;
                                        }
                                    }
                                    i5 = i8;
                                } else {
                                    int i9 = next.width * next.height;
                                    if (i9 > 0) {
                                        if (next.bigEmotion != null) {
                                            pbImageSize = i7 + (i9 * 4);
                                        } else {
                                            pbImageSize = i7 + (i9 * 2);
                                        }
                                    } else if (next.bigEmotion != null) {
                                        BdLog.e("missing big emotion image width and height!");
                                        pbImageSize = i7 + TbConfig.getBigEmotionsSize();
                                    } else {
                                        pbImageSize = i7 + TbConfig.getPbImageSize();
                                    }
                                    int i10 = i6 + 1;
                                    if (i10 <= 13 && pbImageSize < bigImageMaxUsedMemory && i4 > lastVisiblePosition) {
                                        if (next.bigEmotion != null) {
                                            TbRichTextEmotionInfo tbRichTextEmotionInfo = next.bigEmotion;
                                            String str = vv ? tbRichTextEmotionInfo.mGifInfo.mDynamicUrl : tbRichTextEmotionInfo.mGifInfo.mStaticUrl;
                                            if (!TextUtils.isEmpty(str)) {
                                                com.baidu.adp.lib.f.c.fM().a(tbRichTextEmotionInfo.mGifInfo.mSharpText, next.procType, null, 0, 0, bdUniqueId, tbRichTextEmotionInfo.mGifInfo.mGid, tbRichTextEmotionInfo.mGifInfo.mSharpText, Boolean.valueOf(vv), str);
                                                i7 = pbImageSize;
                                                i6 = i10;
                                            }
                                        } else {
                                            String str2 = next.imgUrl;
                                            if (!TextUtils.isEmpty(str2)) {
                                                com.baidu.adp.lib.f.c.fM().a(str2, next.procType, null, bdUniqueId);
                                            }
                                        }
                                    }
                                    i7 = pbImageSize;
                                    i6 = i10;
                                }
                            }
                        }
                        if ((i6 > 13 || i7 >= bigImageMaxUsedMemory) && i5 > 30) {
                            return;
                        }
                        i3 = i5;
                        i2 = i7;
                        i = i6;
                    }
                    firstVisiblePosition = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
