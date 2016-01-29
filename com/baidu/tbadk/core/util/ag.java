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
public class ag {
    public static void a(ListView listView, BdUniqueId bdUniqueId) {
        ListAdapter adapter;
        ArrayList<ah> images;
        int pbImageSize;
        if (listView != null && com.baidu.adp.lib.util.i.ja() && (adapter = listView.getAdapter()) != null) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
            boolean wq = ax.wq();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            com.baidu.adp.lib.g.c.hl().a(bdUniqueId, (com.baidu.adp.lib.g.b) null);
            while (true) {
                int i4 = firstVisiblePosition;
                if (i4 < adapter.getCount()) {
                    Object item = adapter.getItem(i4);
                    if ((item instanceof ai) && (images = ((ai) item).getImages()) != null && images.size() != 0) {
                        Iterator<ah> it = images.iterator();
                        int i5 = i3;
                        int i6 = i;
                        int i7 = i2;
                        while (it.hasNext()) {
                            ah next = it.next();
                            if (com.baidu.adp.lib.g.c.hl().ai(next.acq)) {
                                if (12 == next.acq || 28 == next.acq) {
                                    int i8 = i5 + 1;
                                    if (i8 <= 30 && i4 > lastVisiblePosition && !TextUtils.isEmpty(next.imgUrl)) {
                                        if (12 == next.acq) {
                                            com.baidu.adp.lib.g.c.hl().a(next.imgUrl, 12, null, bdUniqueId);
                                            i5 = i8;
                                        } else if (28 == next.acq) {
                                            com.baidu.adp.lib.g.c.hl().a(next.imgUrl, 28, null, bdUniqueId);
                                            i5 = i8;
                                        }
                                    }
                                    i5 = i8;
                                } else {
                                    int i9 = next.width * next.height;
                                    if (i9 > 0) {
                                        if (next.acr != null) {
                                            pbImageSize = i7 + (i9 * 4);
                                        } else {
                                            pbImageSize = i7 + (i9 * 2);
                                        }
                                    } else if (next.acr != null) {
                                        BdLog.e("missing big emotion image width and height!");
                                        pbImageSize = i7 + TbConfig.getBigEmotionsSize();
                                    } else {
                                        pbImageSize = i7 + TbConfig.getPbImageSize();
                                    }
                                    int i10 = i6 + 1;
                                    if (i10 <= 13 && pbImageSize < bigImageMaxUsedMemory && i4 > lastVisiblePosition) {
                                        if (next.acr != null) {
                                            com.baidu.tbadk.widget.richText.d dVar = next.acr;
                                            String str = wq ? dVar.awQ.awt : dVar.awQ.aws;
                                            if (!TextUtils.isEmpty(str)) {
                                                com.baidu.adp.lib.g.c.hl().a(dVar.awQ.awr, next.acq, null, 0, 0, bdUniqueId, dVar.awQ.mGid, dVar.awQ.awr, Boolean.valueOf(wq), str);
                                                i7 = pbImageSize;
                                                i6 = i10;
                                            }
                                        } else {
                                            String str2 = next.imgUrl;
                                            if (!TextUtils.isEmpty(str2)) {
                                                com.baidu.adp.lib.g.c.hl().a(str2, next.acq, null, bdUniqueId);
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
