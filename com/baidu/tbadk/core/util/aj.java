package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class aj {
    public static void a(ListView listView, BdUniqueId bdUniqueId) {
        ListAdapter adapter;
        ArrayList<ak> images;
        int pbImageSize;
        if (listView != null && com.baidu.adp.lib.util.i.fs() && (adapter = listView.getAdapter()) != null) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
            boolean up = bb.up();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            com.baidu.adp.lib.g.c.dG().a(bdUniqueId, (com.baidu.adp.lib.g.b) null);
            while (true) {
                int i4 = firstVisiblePosition;
                if (i4 < adapter.getCount()) {
                    Object item = adapter.getItem(i4);
                    if ((item instanceof al) && (images = ((al) item).getImages()) != null && images.size() != 0) {
                        Iterator<ak> it = images.iterator();
                        int i5 = i3;
                        int i6 = i;
                        int i7 = i2;
                        while (it.hasNext()) {
                            ak next = it.next();
                            if (com.baidu.adp.lib.g.c.dG().V(next.Xu)) {
                                if (12 == next.Xu || 28 == next.Xu) {
                                    int i8 = i5 + 1;
                                    if (i8 <= 30 && i4 > lastVisiblePosition && !TextUtils.isEmpty(next.imgUrl)) {
                                        if (12 == next.Xu) {
                                            com.baidu.adp.lib.g.c.dG().a(next.imgUrl, 12, null, bdUniqueId);
                                            i5 = i8;
                                        } else if (28 == next.Xu) {
                                            com.baidu.adp.lib.g.c.dG().a(next.imgUrl, 28, null, bdUniqueId);
                                            i5 = i8;
                                        }
                                    }
                                    i5 = i8;
                                } else {
                                    int i9 = next.width * next.height;
                                    if (i9 > 0) {
                                        if (next.Xv != null) {
                                            pbImageSize = i7 + (i9 * 4);
                                        } else {
                                            pbImageSize = i7 + (i9 * 2);
                                        }
                                    } else if (next.Xv != null) {
                                        BdLog.e("missing big emotion image width and height!");
                                        pbImageSize = i7 + TbConfig.getBigEmotionsSize();
                                    } else {
                                        pbImageSize = i7 + TbConfig.getPbImageSize();
                                    }
                                    int i10 = i6 + 1;
                                    if (i10 <= 13 && pbImageSize < bigImageMaxUsedMemory && i4 > lastVisiblePosition) {
                                        if (next.Xv != null) {
                                            com.baidu.tbadk.widget.richText.d dVar = next.Xv;
                                            String str = up ? dVar.auo.atR : dVar.auo.atQ;
                                            if (!TextUtils.isEmpty(str)) {
                                                com.baidu.adp.lib.g.c.dG().a(dVar.auo.atP, next.Xu, null, 0, 0, bdUniqueId, dVar.auo.mGid, dVar.auo.atP, Boolean.valueOf(up), str);
                                                i7 = pbImageSize;
                                                i6 = i10;
                                            }
                                        } else {
                                            String str2 = next.imgUrl;
                                            if (!TextUtils.isEmpty(str2)) {
                                                com.baidu.adp.lib.g.c.dG().a(str2, next.Xu, null, bdUniqueId);
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
