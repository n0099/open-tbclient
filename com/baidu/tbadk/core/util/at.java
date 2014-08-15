package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.resourceLoader.BdResourceLoaderNetHelperStatic;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class at {
    public static void a(ListView listView, BdUniqueId bdUniqueId) {
        ListAdapter adapter;
        LinkedList<au> images;
        int pbImageSize;
        if (listView != null && BdResourceLoaderNetHelperStatic.a() && (adapter = listView.getAdapter()) != null) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
            boolean i4 = bb.i();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            com.baidu.adp.lib.resourceLoader.d.a().a(bdUniqueId, (com.baidu.adp.lib.resourceLoader.c) null);
            while (true) {
                int i5 = firstVisiblePosition;
                if (i5 < adapter.getCount()) {
                    Object item = adapter.getItem(i5);
                    if ((item instanceof av) && (images = ((av) item).getImages()) != null && images.size() != 0) {
                        Iterator<au> it = images.iterator();
                        int i6 = i3;
                        int i7 = i;
                        int i8 = i2;
                        while (it.hasNext()) {
                            au next = it.next();
                            if (com.baidu.adp.lib.resourceLoader.d.a().a(next.d)) {
                                if (12 == next.d) {
                                    int i9 = i6 + 1;
                                    if (i9 > 30 || i5 <= lastVisiblePosition || TextUtils.isEmpty(next.a)) {
                                        i6 = i9;
                                    } else {
                                        com.baidu.adp.lib.resourceLoader.d.a().a(next.a, 12, null, bdUniqueId);
                                        i6 = i9;
                                    }
                                } else {
                                    int i10 = next.b * next.c;
                                    if (i10 > 0) {
                                        if (next.e != null) {
                                            pbImageSize = i8 + (i10 * 4);
                                        } else {
                                            pbImageSize = i8 + (i10 * 2);
                                        }
                                    } else if (next.e != null) {
                                        BdLog.e("missing big emotion image width and height!");
                                        pbImageSize = i8 + TbConfig.getBigEmotionsSize();
                                    } else {
                                        pbImageSize = i8 + TbConfig.getPbImageSize();
                                    }
                                    int i11 = i7 + 1;
                                    if (i11 <= 13 && pbImageSize < bigImageMaxUsedMemory && i5 > lastVisiblePosition) {
                                        if (next.e != null) {
                                            com.baidu.tbadk.widget.richText.e eVar = next.e;
                                            String str = i4 ? eVar.b.d : eVar.b.c;
                                            if (!TextUtils.isEmpty(str)) {
                                                com.baidu.adp.lib.resourceLoader.d.a().a(eVar.b.b, next.d, null, 0, 0, bdUniqueId, eVar.b.e, eVar.b.b, Boolean.valueOf(i4), str);
                                                i8 = pbImageSize;
                                                i7 = i11;
                                            }
                                        } else {
                                            String str2 = next.a;
                                            if (!TextUtils.isEmpty(str2)) {
                                                com.baidu.adp.lib.resourceLoader.d.a().a(str2, next.d, null, bdUniqueId);
                                            }
                                        }
                                    }
                                    i8 = pbImageSize;
                                    i7 = i11;
                                }
                            }
                        }
                        if ((i7 > 13 || i8 >= bigImageMaxUsedMemory) && i6 > 30) {
                            return;
                        }
                        i3 = i6;
                        i2 = i8;
                        i = i7;
                    }
                    firstVisiblePosition = i5 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
