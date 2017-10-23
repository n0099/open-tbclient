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
public class ad {
    public static void a(com.baidu.adp.widget.ListView.g gVar, BdUniqueId bdUniqueId) {
        ListAdapter adapter;
        ArrayList<PreLoadImageInfo> images;
        int i;
        int i2;
        int pbImageSize;
        if (gVar != null && com.baidu.adp.lib.util.j.hi() && (adapter = gVar.getAdapter()) != null) {
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
            boolean vv = an.vv();
            int firstVisiblePosition = gVar.getFirstVisiblePosition();
            int lastVisiblePosition = gVar.getLastVisiblePosition();
            com.baidu.adp.lib.f.c.fJ().a(bdUniqueId, (com.baidu.adp.lib.f.b) null);
            while (true) {
                int i6 = firstVisiblePosition;
                if (i6 < adapter.getCount()) {
                    Object item = adapter.getItem(i6);
                    if ((item instanceof ae) && (images = ((ae) item).getImages()) != null && images.size() != 0) {
                        Iterator<PreLoadImageInfo> it = images.iterator();
                        int i7 = i5;
                        int i8 = i4;
                        while (it.hasNext()) {
                            PreLoadImageInfo next = it.next();
                            if (com.baidu.adp.lib.f.c.fJ().ao(next.procType)) {
                                if (12 == next.procType || 28 == next.procType) {
                                    int i9 = i7 + 1;
                                    if (i9 <= 30 && i6 > lastVisiblePosition && !TextUtils.isEmpty(next.imgUrl)) {
                                        if (12 == next.procType) {
                                            com.baidu.adp.lib.f.c.fJ().a(next.imgUrl, 12, null, bdUniqueId);
                                            i = i8;
                                            i2 = i9;
                                        } else if (28 == next.procType) {
                                            com.baidu.adp.lib.f.c.fJ().a(next.imgUrl, 28, null, bdUniqueId);
                                            i = i8;
                                            i2 = i9;
                                        }
                                    }
                                    i = i8;
                                    i2 = i9;
                                } else {
                                    int i10 = next.width * next.height;
                                    if (i10 > 0) {
                                        if (next.bigEmotion != null) {
                                            pbImageSize = i8 + (i10 * 4);
                                        } else {
                                            pbImageSize = i8 + (i10 * 2);
                                        }
                                    } else if (next.bigEmotion != null) {
                                        BdLog.e("missing big emotion image width and height!");
                                        pbImageSize = i8 + TbConfig.getBigEmotionsSize();
                                    } else {
                                        pbImageSize = i8 + TbConfig.getPbImageSize();
                                    }
                                    int i11 = i3 + 1;
                                    if (i11 <= 13 && pbImageSize < bigImageMaxUsedMemory && i6 > lastVisiblePosition) {
                                        if (next.bigEmotion != null) {
                                            TbRichTextEmotionInfo tbRichTextEmotionInfo = next.bigEmotion;
                                            String str = vv ? tbRichTextEmotionInfo.mGifInfo.mDynamicUrl : tbRichTextEmotionInfo.mGifInfo.mStaticUrl;
                                            if (!TextUtils.isEmpty(str)) {
                                                com.baidu.adp.lib.f.c.fJ().a(tbRichTextEmotionInfo.mGifInfo.mSharpText, next.procType, null, 0, 0, bdUniqueId, tbRichTextEmotionInfo.mGifInfo.mGid, tbRichTextEmotionInfo.mGifInfo.mSharpText, Boolean.valueOf(vv), str);
                                            }
                                            i2 = i7;
                                            i = pbImageSize;
                                            i3 = i11;
                                        } else {
                                            String str2 = next.imgUrl;
                                            if (!TextUtils.isEmpty(str2)) {
                                                com.baidu.adp.lib.f.c.fJ().a(str2, next.procType, null, bdUniqueId);
                                            }
                                        }
                                    }
                                    i2 = i7;
                                    i = pbImageSize;
                                    i3 = i11;
                                }
                                i7 = i2;
                                i8 = i;
                            }
                        }
                        if ((i3 > 13 || i8 >= bigImageMaxUsedMemory) && i7 > 30) {
                            return;
                        }
                        i4 = i8;
                        i5 = i7;
                    }
                    firstVisiblePosition = i6 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
