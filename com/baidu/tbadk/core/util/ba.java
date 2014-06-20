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
public class ba {
    public static void a(ListView listView, int i, int i2) {
        ListAdapter adapter;
        int pbImageSize;
        if (listView != null && (adapter = listView.getAdapter()) != null && BdResourceLoaderNetHelperStatic.a() && com.baidu.adp.lib.resourceLoader.d.a().c(i2)) {
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
            boolean i6 = bh.i();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            com.baidu.adp.lib.resourceLoader.d.a().a(i, (com.baidu.adp.lib.resourceLoader.c) null);
            while (true) {
                int i7 = firstVisiblePosition;
                int i8 = i5;
                int i9 = i4;
                int i10 = i3;
                if (i7 < adapter.getCount()) {
                    Object item = adapter.getItem(i7);
                    if (item instanceof af) {
                        af afVar = (af) item;
                        if (afVar.isSupportImageSize()) {
                            LinkedList<ab> imagesWithEmotions = afVar.getImagesWithEmotions();
                            if (imagesWithEmotions != null && imagesWithEmotions.size() > 0) {
                                Iterator<ab> it = imagesWithEmotions.iterator();
                                while (it.hasNext()) {
                                    ab next = it.next();
                                    int i11 = next.b * next.c;
                                    if (i11 > 0) {
                                        if (next.d != null) {
                                            pbImageSize = i9 + (i11 * 4);
                                        } else {
                                            pbImageSize = i9 + (i11 * 2);
                                        }
                                    } else if (next.d != null) {
                                        BdLog.e("missing big emotion image width and height!");
                                        pbImageSize = i9 + TbConfig.getBigEmotionsSize();
                                    } else if (next.e != null) {
                                        pbImageSize = i9 + TbConfig.getBubbleImageSize();
                                    } else {
                                        pbImageSize = i9 + TbConfig.getPbImageSize();
                                    }
                                    int i12 = i10 + 1;
                                    if (i12 <= 13 && pbImageSize <= bigImageMaxUsedMemory) {
                                        if (i7 > lastVisiblePosition) {
                                            if (next.d != null) {
                                                com.baidu.tbadk.widget.richText.e eVar = next.d;
                                                String str = i6 ? eVar.b.d : eVar.b.c;
                                                if (!TextUtils.isEmpty(str)) {
                                                    com.baidu.adp.lib.resourceLoader.d.a().a(eVar.b.b, 20, null, 0, 0, i, eVar.b.e, eVar.b.b, Boolean.valueOf(i6), str);
                                                    i9 = pbImageSize;
                                                    i10 = i12;
                                                }
                                            } else if (next.e != null) {
                                                String str2 = next.e;
                                                if (!TextUtils.isEmpty(str2)) {
                                                    com.baidu.adp.lib.resourceLoader.d.a().a(str2, 19, null, i);
                                                    i9 = pbImageSize;
                                                    i10 = i12;
                                                }
                                            } else {
                                                String str3 = next.a;
                                                if (!TextUtils.isEmpty(str3)) {
                                                    com.baidu.adp.lib.resourceLoader.d.a().a(str3, i2, null, i);
                                                }
                                            }
                                        }
                                        i9 = pbImageSize;
                                        i10 = i12;
                                    } else {
                                        return;
                                    }
                                }
                            }
                        } else {
                            LinkedList<String> imageUrl = afVar.getImageUrl();
                            if (imageUrl != null && imageUrl.size() > 0) {
                                Iterator<String> it2 = imageUrl.iterator();
                                while (it2.hasNext()) {
                                    String next2 = it2.next();
                                    i10++;
                                    i9 += TbConfig.getPbImageSize();
                                    if (i10 <= 13 && i9 <= bigImageMaxUsedMemory) {
                                        if (i7 > lastVisiblePosition && !TextUtils.isEmpty(next2)) {
                                            com.baidu.adp.lib.resourceLoader.d.a().a(next2, i2, null, i);
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                        }
                        LinkedList<String> photoUrl = afVar.getPhotoUrl();
                        if (photoUrl != null) {
                            Iterator<String> it3 = photoUrl.iterator();
                            while (it3.hasNext()) {
                                String next3 = it3.next();
                                i8++;
                                if (i8 >= 30) {
                                    break;
                                } else if (i7 > lastVisiblePosition) {
                                    com.baidu.adp.lib.resourceLoader.d.a().a(next3, 12, null, i);
                                }
                            }
                        }
                        LinkedList<String> forumPhotoUrl = afVar.getForumPhotoUrl();
                        if (forumPhotoUrl != null) {
                            Iterator<String> it4 = forumPhotoUrl.iterator();
                            while (it4.hasNext()) {
                                String next4 = it4.next();
                                if (i7 > lastVisiblePosition) {
                                    com.baidu.adp.lib.resourceLoader.d.a().a(next4, 11, null, i);
                                }
                            }
                        }
                        if (i10 >= 13 && i8 >= 30) {
                            return;
                        }
                    }
                    i3 = i10;
                    i4 = i9;
                    i5 = i8;
                    firstVisiblePosition = i7 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
