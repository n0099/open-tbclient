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
public class ar {
    public static void a(ListView listView, BdUniqueId bdUniqueId) {
        ListAdapter adapter;
        ArrayList<as> images;
        int pbImageSize;
        if (listView != null && com.baidu.adp.lib.util.j.fi() && (adapter = listView.getAdapter()) != null) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
            boolean mN = az.mN();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            com.baidu.adp.lib.f.d.ef().a(bdUniqueId, (com.baidu.adp.lib.f.c) null);
            while (true) {
                int i4 = firstVisiblePosition;
                if (i4 < adapter.getCount()) {
                    Object item = adapter.getItem(i4);
                    if ((item instanceof at) && (images = ((at) item).getImages()) != null && images.size() != 0) {
                        Iterator<as> it = images.iterator();
                        int i5 = i3;
                        int i6 = i;
                        int i7 = i2;
                        while (it.hasNext()) {
                            as next = it.next();
                            if (com.baidu.adp.lib.f.d.ef().J(next.ER)) {
                                if (12 == next.ER) {
                                    int i8 = i5 + 1;
                                    if (i8 > 30 || i4 <= lastVisiblePosition || TextUtils.isEmpty(next.AI)) {
                                        i5 = i8;
                                    } else {
                                        com.baidu.adp.lib.f.d.ef().a(next.AI, 12, null, bdUniqueId);
                                        i5 = i8;
                                    }
                                } else {
                                    int i9 = next.width * next.height;
                                    if (i9 > 0) {
                                        if (next.ES != null) {
                                            pbImageSize = i7 + (i9 * 4);
                                        } else {
                                            pbImageSize = i7 + (i9 * 2);
                                        }
                                    } else if (next.ES != null) {
                                        BdLog.e("missing big emotion image width and height!");
                                        pbImageSize = i7 + TbConfig.getBigEmotionsSize();
                                    } else {
                                        pbImageSize = i7 + TbConfig.getPbImageSize();
                                    }
                                    int i10 = i6 + 1;
                                    if (i10 <= 13 && pbImageSize < bigImageMaxUsedMemory && i4 > lastVisiblePosition) {
                                        if (next.ES != null) {
                                            com.baidu.tbadk.widget.richText.e eVar = next.ES;
                                            String str = mN ? eVar.TF.Th : eVar.TF.Tg;
                                            if (!TextUtils.isEmpty(str)) {
                                                com.baidu.adp.lib.f.d.ef().a(eVar.TF.Tf, next.ER, null, 0, 0, bdUniqueId, eVar.TF.Ti, eVar.TF.Tf, Boolean.valueOf(mN), str);
                                                i7 = pbImageSize;
                                                i6 = i10;
                                            }
                                        } else {
                                            String str2 = next.AI;
                                            if (!TextUtils.isEmpty(str2)) {
                                                com.baidu.adp.lib.f.d.ef().a(str2, next.ER, null, bdUniqueId);
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
