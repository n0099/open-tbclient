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
public class an {
    public static void a(ListView listView, BdUniqueId bdUniqueId) {
        ListAdapter adapter;
        ArrayList<ao> images;
        int pbImageSize;
        if (listView != null && com.baidu.adp.lib.util.k.iY() && (adapter = listView.getAdapter()) != null) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
            boolean tL = bc.tL();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            com.baidu.adp.lib.f.d.hl().a(bdUniqueId, (com.baidu.adp.lib.f.c) null);
            while (true) {
                int i4 = firstVisiblePosition;
                if (i4 < adapter.getCount()) {
                    Object item = adapter.getItem(i4);
                    if ((item instanceof ap) && (images = ((ap) item).getImages()) != null && images.size() != 0) {
                        Iterator<ao> it = images.iterator();
                        int i5 = i3;
                        int i6 = i;
                        int i7 = i2;
                        while (it.hasNext()) {
                            ao next = it.next();
                            if (com.baidu.adp.lib.f.d.hl().V(next.Vx)) {
                                if (12 == next.Vx) {
                                    int i8 = i5 + 1;
                                    if (i8 > 30 || i4 <= lastVisiblePosition || TextUtils.isEmpty(next.Ri)) {
                                        i5 = i8;
                                    } else {
                                        com.baidu.adp.lib.f.d.hl().a(next.Ri, 12, null, bdUniqueId);
                                        i5 = i8;
                                    }
                                } else {
                                    int i9 = next.width * next.height;
                                    if (i9 > 0) {
                                        if (next.Vy != null) {
                                            pbImageSize = i7 + (i9 * 4);
                                        } else {
                                            pbImageSize = i7 + (i9 * 2);
                                        }
                                    } else if (next.Vy != null) {
                                        BdLog.e("missing big emotion image width and height!");
                                        pbImageSize = i7 + TbConfig.getBigEmotionsSize();
                                    } else {
                                        pbImageSize = i7 + TbConfig.getPbImageSize();
                                    }
                                    int i10 = i6 + 1;
                                    if (i10 <= 13 && pbImageSize < bigImageMaxUsedMemory && i4 > lastVisiblePosition) {
                                        if (next.Vy != null) {
                                            com.baidu.tbadk.widget.richText.e eVar = next.Vy;
                                            String str = tL ? eVar.alT.alv : eVar.alT.alu;
                                            if (!TextUtils.isEmpty(str)) {
                                                com.baidu.adp.lib.f.d.hl().a(eVar.alT.alt, next.Vx, null, 0, 0, bdUniqueId, eVar.alT.alw, eVar.alT.alt, Boolean.valueOf(tL), str);
                                                i7 = pbImageSize;
                                                i6 = i10;
                                            }
                                        } else {
                                            String str2 = next.Ri;
                                            if (!TextUtils.isEmpty(str2)) {
                                                com.baidu.adp.lib.f.d.hl().a(str2, next.Vx, null, bdUniqueId);
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
