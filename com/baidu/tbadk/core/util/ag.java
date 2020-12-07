package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.widget.richText.TbRichTextEmotionInfo;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ag {
    public static void a(com.baidu.adp.widget.ListView.t tVar, BdUniqueId bdUniqueId) {
        a(tVar, bdUniqueId, 13);
    }

    public static void a(com.baidu.adp.widget.ListView.t tVar, BdUniqueId bdUniqueId, int i) {
        com.baidu.adp.widget.ListView.r adapter;
        ArrayList<PreLoadImageInfo> images;
        if (tVar != null && com.baidu.adp.lib.util.j.isWifiNet() && (adapter = tVar.getAdapter()) != null) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
            boolean btZ = av.btZ();
            int firstVisiblePosition = tVar.getFirstVisiblePosition();
            int lastVisiblePosition = tVar.getLastVisiblePosition();
            com.baidu.adp.lib.e.c.mS().a(bdUniqueId, (com.baidu.adp.lib.e.b) null);
            while (true) {
                int i5 = firstVisiblePosition;
                if (i5 < adapter.getCount()) {
                    Object item = adapter.getItem(i5);
                    if ((item instanceof ah) && (images = ((ah) item).getImages()) != null && images.size() != 0) {
                        Iterator<PreLoadImageInfo> it = images.iterator();
                        int i6 = i4;
                        int i7 = i3;
                        int i8 = i2;
                        while (it.hasNext()) {
                            PreLoadImageInfo next = it.next();
                            if (com.baidu.adp.lib.e.c.mS().aw(next.procType)) {
                                if (12 == next.procType || 28 == next.procType) {
                                    i6++;
                                    if (i6 <= 30 && i5 > lastVisiblePosition && !TextUtils.isEmpty(next.imgUrl)) {
                                        if (12 == next.procType) {
                                            com.baidu.adp.lib.e.c.mS().a(next.imgUrl, 12, null, next.width, next.height, bdUniqueId, new Object[0]);
                                        } else if (28 == next.procType) {
                                            com.baidu.adp.lib.e.c.mS().a(next.imgUrl, 28, null, next.width, next.height, bdUniqueId, new Object[0]);
                                        }
                                    }
                                } else {
                                    int i9 = next.width * next.height;
                                    if (i9 > 0) {
                                        if (next.bigEmotion != null) {
                                            i7 += i9 * 4;
                                        } else {
                                            i7 += i9 * 2;
                                        }
                                    } else if (next.bigEmotion != null) {
                                        BdLog.e("missing big emotion image width and height!");
                                        i7 += TbConfig.getBigEmotionsSize();
                                    } else {
                                        i7 += TbConfig.getPbImageSize();
                                    }
                                    i8++;
                                    if (i8 <= i && i7 < bigImageMaxUsedMemory && i5 > lastVisiblePosition) {
                                        if (next.bigEmotion != null) {
                                            TbRichTextEmotionInfo tbRichTextEmotionInfo = next.bigEmotion;
                                            String str = btZ ? tbRichTextEmotionInfo.mGifInfo.mDynamicUrl : tbRichTextEmotionInfo.mGifInfo.mStaticUrl;
                                            if (!TextUtils.isEmpty(str)) {
                                                com.baidu.adp.lib.e.c.mS().a(tbRichTextEmotionInfo.mGifInfo.mSharpText, next.procType, null, next.width, next.height, bdUniqueId, tbRichTextEmotionInfo.mGifInfo.mGid, tbRichTextEmotionInfo.mGifInfo.mSharpText, Boolean.valueOf(btZ), str);
                                            }
                                        } else {
                                            String str2 = next.imgUrl;
                                            if (!TextUtils.isEmpty(str2)) {
                                                com.baidu.adp.lib.e.c.mS().a(str2, next.procType, null, next.width, next.height, bdUniqueId, new Object[0]);
                                            }
                                        }
                                    }
                                }
                                i6 = i6;
                                i7 = i7;
                                i8 = i8;
                            }
                        }
                        if ((i8 > i || i7 >= bigImageMaxUsedMemory) && i6 > 30) {
                            return;
                        }
                        i4 = i6;
                        i3 = i7;
                        i2 = i8;
                    }
                    firstVisiblePosition = i5 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
