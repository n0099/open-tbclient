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
public class as {
    public static void a(ListView listView, BdUniqueId bdUniqueId) {
        ListAdapter adapter;
        ArrayList<at> images;
        int pbImageSize;
        if (listView != null && com.baidu.adp.lib.util.i.fg() && (adapter = listView.getAdapter()) != null) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
            boolean pS = bg.pS();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            com.baidu.adp.lib.f.d.ec().a(bdUniqueId, (com.baidu.adp.lib.f.c) null);
            while (true) {
                int i4 = firstVisiblePosition;
                if (i4 < adapter.getCount()) {
                    Object item = adapter.getItem(i4);
                    if ((item instanceof au) && (images = ((au) item).getImages()) != null && images.size() != 0) {
                        Iterator<at> it = images.iterator();
                        int i5 = i3;
                        int i6 = i;
                        int i7 = i2;
                        while (it.hasNext()) {
                            at next = it.next();
                            if (com.baidu.adp.lib.f.d.ec().W(next.Jn)) {
                                if (12 == next.Jn) {
                                    int i8 = i5 + 1;
                                    if (i8 > 30 || i4 <= lastVisiblePosition || TextUtils.isEmpty(next.Fa)) {
                                        i5 = i8;
                                    } else {
                                        com.baidu.adp.lib.f.d.ec().a(next.Fa, 12, null, bdUniqueId);
                                        i5 = i8;
                                    }
                                } else {
                                    int i9 = next.width * next.height;
                                    if (i9 > 0) {
                                        if (next.Jo != null) {
                                            pbImageSize = i7 + (i9 * 4);
                                        } else {
                                            pbImageSize = i7 + (i9 * 2);
                                        }
                                    } else if (next.Jo != null) {
                                        BdLog.e("missing big emotion image width and height!");
                                        pbImageSize = i7 + TbConfig.getBigEmotionsSize();
                                    } else {
                                        pbImageSize = i7 + TbConfig.getPbImageSize();
                                    }
                                    int i10 = i6 + 1;
                                    if (i10 <= 13 && pbImageSize < bigImageMaxUsedMemory && i4 > lastVisiblePosition) {
                                        if (next.Jo != null) {
                                            com.baidu.tbadk.widget.richText.e eVar = next.Jo;
                                            String str = pS ? eVar.aap.ZR : eVar.aap.ZQ;
                                            if (!TextUtils.isEmpty(str)) {
                                                com.baidu.adp.lib.f.d.ec().a(eVar.aap.ZP, next.Jn, null, 0, 0, bdUniqueId, eVar.aap.ZS, eVar.aap.ZP, Boolean.valueOf(pS), str);
                                                i7 = pbImageSize;
                                                i6 = i10;
                                            }
                                        } else {
                                            String str2 = next.Fa;
                                            if (!TextUtils.isEmpty(str2)) {
                                                com.baidu.adp.lib.f.d.ec().a(str2, next.Jn, null, bdUniqueId);
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
