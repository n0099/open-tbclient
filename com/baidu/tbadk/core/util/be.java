package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.lib.resourceLoader.BdResourceLoaderNetHelperStatic;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class be {
    public static void a(ListView listView, int i) {
        ListAdapter adapter;
        LinkedList<bf> images;
        int pbImageSize;
        if (listView != null && BdResourceLoaderNetHelperStatic.a() && (adapter = listView.getAdapter()) != null) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
            boolean i5 = bn.i();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            com.baidu.adp.lib.resourceLoader.d.a().a(i, (com.baidu.adp.lib.resourceLoader.c) null);
            while (true) {
                int i6 = firstVisiblePosition;
                if (i6 < adapter.getCount()) {
                    Object item = adapter.getItem(i6);
                    if ((item instanceof bg) && (images = ((bg) item).getImages()) != null && images.size() != 0) {
                        Iterator<bf> it = images.iterator();
                        int i7 = i4;
                        int i8 = i2;
                        int i9 = i3;
                        while (it.hasNext()) {
                            bf next = it.next();
                            if (com.baidu.adp.lib.resourceLoader.d.a().c(next.d)) {
                                if (12 == next.d) {
                                    int i10 = i7 + 1;
                                    if (i10 > 30 || i6 <= lastVisiblePosition || TextUtils.isEmpty(next.a)) {
                                        i7 = i10;
                                    } else {
                                        com.baidu.adp.lib.resourceLoader.d.a().a(next.a, 12, null, i);
                                        i7 = i10;
                                    }
                                } else {
                                    int i11 = next.b * next.c;
                                    if (i11 > 0) {
                                        if (next.e != null) {
                                            pbImageSize = i9 + (i11 * 4);
                                        } else {
                                            pbImageSize = i9 + (i11 * 2);
                                        }
                                    } else if (next.e != null) {
                                        BdLog.e("missing big emotion image width and height!");
                                        pbImageSize = i9 + TbConfig.getBigEmotionsSize();
                                    } else {
                                        pbImageSize = i9 + TbConfig.getPbImageSize();
                                    }
                                    int i12 = i8 + 1;
                                    if (i12 <= 13 && pbImageSize < bigImageMaxUsedMemory && i6 > lastVisiblePosition) {
                                        if (next.e != null) {
                                            com.baidu.tbadk.widget.richText.e eVar = next.e;
                                            String str = i5 ? eVar.b.d : eVar.b.c;
                                            if (!TextUtils.isEmpty(str)) {
                                                com.baidu.adp.lib.resourceLoader.d.a().a(eVar.b.b, next.d, null, 0, 0, i, eVar.b.e, eVar.b.b, Boolean.valueOf(i5), str);
                                                i9 = pbImageSize;
                                                i8 = i12;
                                            }
                                        } else {
                                            String str2 = next.a;
                                            if (!TextUtils.isEmpty(str2)) {
                                                com.baidu.adp.lib.resourceLoader.d.a().a(str2, next.d, null, i);
                                            }
                                        }
                                    }
                                    i9 = pbImageSize;
                                    i8 = i12;
                                }
                            }
                        }
                        if ((i8 > 13 || i9 >= bigImageMaxUsedMemory) && i7 > 30) {
                            return;
                        }
                        i4 = i7;
                        i3 = i9;
                        i2 = i8;
                    }
                    firstVisiblePosition = i6 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
