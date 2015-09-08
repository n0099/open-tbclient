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
public class ab {
    public static void a(ListView listView, BdUniqueId bdUniqueId) {
        ListAdapter adapter;
        ArrayList<ac> images;
        int pbImageSize;
        if (listView != null && com.baidu.adp.lib.util.i.iM() && (adapter = listView.getAdapter()) != null) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
            boolean uU = ar.uU();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            com.baidu.adp.lib.f.c.gZ().a(bdUniqueId, (com.baidu.adp.lib.f.b) null);
            while (true) {
                int i4 = firstVisiblePosition;
                if (i4 < adapter.getCount()) {
                    Object item = adapter.getItem(i4);
                    if ((item instanceof ad) && (images = ((ad) item).getImages()) != null && images.size() != 0) {
                        Iterator<ac> it = images.iterator();
                        int i5 = i3;
                        int i6 = i;
                        int i7 = i2;
                        while (it.hasNext()) {
                            ac next = it.next();
                            if (com.baidu.adp.lib.f.c.gZ().W(next.aaD)) {
                                if (12 == next.aaD) {
                                    int i8 = i5 + 1;
                                    if (i8 > 30 || i4 <= lastVisiblePosition || TextUtils.isEmpty(next.Wg)) {
                                        i5 = i8;
                                    } else {
                                        com.baidu.adp.lib.f.c.gZ().a(next.Wg, 12, null, bdUniqueId);
                                        i5 = i8;
                                    }
                                } else {
                                    int i9 = next.width * next.height;
                                    if (i9 > 0) {
                                        if (next.aaE != null) {
                                            pbImageSize = i7 + (i9 * 4);
                                        } else {
                                            pbImageSize = i7 + (i9 * 2);
                                        }
                                    } else if (next.aaE != null) {
                                        BdLog.e("missing big emotion image width and height!");
                                        pbImageSize = i7 + TbConfig.getBigEmotionsSize();
                                    } else {
                                        pbImageSize = i7 + TbConfig.getPbImageSize();
                                    }
                                    int i10 = i6 + 1;
                                    if (i10 <= 13 && pbImageSize < bigImageMaxUsedMemory && i4 > lastVisiblePosition) {
                                        if (next.aaE != null) {
                                            com.baidu.tbadk.widget.richText.d dVar = next.aaE;
                                            String str = uU ? dVar.avh.auK : dVar.avh.auJ;
                                            if (!TextUtils.isEmpty(str)) {
                                                com.baidu.adp.lib.f.c.gZ().a(dVar.avh.auI, next.aaD, null, 0, 0, bdUniqueId, dVar.avh.mGid, dVar.avh.auI, Boolean.valueOf(uU), str);
                                                i7 = pbImageSize;
                                                i6 = i10;
                                            }
                                        } else {
                                            String str2 = next.Wg;
                                            if (!TextUtils.isEmpty(str2)) {
                                                com.baidu.adp.lib.f.c.gZ().a(str2, next.aaD, null, bdUniqueId);
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
