package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ae {
    public static void a(ListView listView, com.baidu.tbadk.editortool.ab abVar, int i, int i2) {
        a(listView, abVar, null, null, null, i, i2);
    }

    public static void a(ListView listView, com.baidu.tbadk.editortool.ab abVar, com.baidu.tbadk.imageManager.d dVar, com.baidu.tbadk.imageManager.d dVar2, com.baidu.tbadk.imageManager.d dVar3, int i, int i2) {
        a(listView, abVar, dVar, dVar2, dVar3, null, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x0210 A[Catch: Exception -> 0x01dc, TryCatch #0 {Exception -> 0x01dc, blocks: (B:12:0x002d, B:13:0x0038, B:16:0x003f, B:17:0x004b, B:21:0x0055, B:23:0x005d, B:25:0x0061, B:27:0x0067, B:30:0x0070, B:110:0x01a9, B:112:0x01b5, B:114:0x01b9, B:116:0x01c7, B:118:0x01d3, B:115:0x01c2, B:35:0x007c, B:37:0x0082, B:38:0x0086, B:129:0x0210, B:131:0x021a, B:134:0x0228, B:40:0x008c, B:42:0x0093, B:43:0x0097, B:135:0x0231, B:50:0x00a6, B:122:0x01ec, B:125:0x01f5, B:128:0x01fd, B:56:0x00b6, B:58:0x00bf, B:60:0x00c7, B:62:0x00cd, B:63:0x00d1, B:109:0x01a1, B:68:0x00e1, B:70:0x00e9, B:72:0x00f5, B:75:0x0106, B:77:0x010f, B:79:0x0113, B:81:0x0118, B:84:0x0132, B:85:0x0136, B:87:0x013a, B:88:0x0146, B:90:0x014a, B:93:0x0154, B:95:0x015a, B:96:0x015e, B:99:0x016a, B:101:0x0172, B:103:0x017a, B:106:0x018c), top: B:140:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007c A[Catch: Exception -> 0x01dc, TryCatch #0 {Exception -> 0x01dc, blocks: (B:12:0x002d, B:13:0x0038, B:16:0x003f, B:17:0x004b, B:21:0x0055, B:23:0x005d, B:25:0x0061, B:27:0x0067, B:30:0x0070, B:110:0x01a9, B:112:0x01b5, B:114:0x01b9, B:116:0x01c7, B:118:0x01d3, B:115:0x01c2, B:35:0x007c, B:37:0x0082, B:38:0x0086, B:129:0x0210, B:131:0x021a, B:134:0x0228, B:40:0x008c, B:42:0x0093, B:43:0x0097, B:135:0x0231, B:50:0x00a6, B:122:0x01ec, B:125:0x01f5, B:128:0x01fd, B:56:0x00b6, B:58:0x00bf, B:60:0x00c7, B:62:0x00cd, B:63:0x00d1, B:109:0x01a1, B:68:0x00e1, B:70:0x00e9, B:72:0x00f5, B:75:0x0106, B:77:0x010f, B:79:0x0113, B:81:0x0118, B:84:0x0132, B:85:0x0136, B:87:0x013a, B:88:0x0146, B:90:0x014a, B:93:0x0154, B:95:0x015a, B:96:0x015e, B:99:0x016a, B:101:0x0172, B:103:0x017a, B:106:0x018c), top: B:140:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093 A[Catch: Exception -> 0x01dc, TryCatch #0 {Exception -> 0x01dc, blocks: (B:12:0x002d, B:13:0x0038, B:16:0x003f, B:17:0x004b, B:21:0x0055, B:23:0x005d, B:25:0x0061, B:27:0x0067, B:30:0x0070, B:110:0x01a9, B:112:0x01b5, B:114:0x01b9, B:116:0x01c7, B:118:0x01d3, B:115:0x01c2, B:35:0x007c, B:37:0x0082, B:38:0x0086, B:129:0x0210, B:131:0x021a, B:134:0x0228, B:40:0x008c, B:42:0x0093, B:43:0x0097, B:135:0x0231, B:50:0x00a6, B:122:0x01ec, B:125:0x01f5, B:128:0x01fd, B:56:0x00b6, B:58:0x00bf, B:60:0x00c7, B:62:0x00cd, B:63:0x00d1, B:109:0x01a1, B:68:0x00e1, B:70:0x00e9, B:72:0x00f5, B:75:0x0106, B:77:0x010f, B:79:0x0113, B:81:0x0118, B:84:0x0132, B:85:0x0136, B:87:0x013a, B:88:0x0146, B:90:0x014a, B:93:0x0154, B:95:0x015a, B:96:0x015e, B:99:0x016a, B:101:0x0172, B:103:0x017a, B:106:0x018c), top: B:140:0x002d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(ListView listView, com.baidu.tbadk.editortool.ab abVar, com.baidu.tbadk.imageManager.d dVar, com.baidu.tbadk.imageManager.d dVar2, com.baidu.tbadk.imageManager.d dVar3, com.baidu.tbadk.imageManager.d dVar4, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        LinkedList<String> forumPhotoUrl;
        LinkedList<String> photoUrl;
        Iterator<String> it;
        int i7;
        int i8;
        int i9;
        boolean z;
        View findViewWithTag;
        View findViewWithTag2;
        if (listView != null && abVar != null) {
            abVar.a();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            ListAdapter adapter = listView.getAdapter();
            if (adapter != null) {
                if (dVar == null) {
                    dVar = new af(listView);
                }
                if (dVar2 == null) {
                    dVar2 = new ah(listView);
                }
                try {
                    boolean a = a();
                    int i10 = 0;
                    int i11 = 0;
                    int i12 = 0;
                    com.baidu.tbadk.editortool.ab.b();
                    int i13 = firstVisiblePosition;
                    while (true) {
                        if (i13 >= adapter.getCount()) {
                            i3 = i10;
                            break;
                        } else if (i13 > lastVisiblePosition && !a) {
                            i3 = i10;
                            break;
                        } else if (i != 0) {
                            i3 = i10;
                            break;
                        } else {
                            Object item = adapter.getItem(i13);
                            if (item instanceof ad) {
                                ad adVar = (ad) item;
                                if (adVar.isSupportImageSize()) {
                                    LinkedList<ab> imagesWithEmotions = adVar.getImagesWithEmotions();
                                    if (imagesWithEmotions != null) {
                                        Iterator<ab> it2 = imagesWithEmotions.iterator();
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                i7 = i12;
                                                i8 = i11;
                                                i9 = i10;
                                                z = false;
                                                break;
                                            }
                                            ab next = it2.next();
                                            if (!a && (findViewWithTag2 = listView.findViewWithTag(next.a())) != null && a(findViewWithTag2, listView)) {
                                                i7 = i12;
                                                i8 = i11;
                                                i9 = i10;
                                                z = true;
                                                break;
                                            }
                                            i10++;
                                            int i14 = next.b * next.c;
                                            if (i14 > 0) {
                                                if (next.d != null) {
                                                    i11 += i14 * 4;
                                                } else {
                                                    i11 += i14 * 2;
                                                }
                                            } else if (next.d != null) {
                                                BdLog.e("missing big emotion image width and height!");
                                                i11 += TbConfig.getBigEmotionsSize();
                                            } else if (next.e != null) {
                                                i11 += TbConfig.getBubbleImageSize();
                                            }
                                            if (i13 > lastVisiblePosition && (i12 = i12 + next.c) > com.baidu.adp.lib.util.k.c(TbadkApplication.m252getInst().getApp())) {
                                                i7 = i12;
                                                i8 = i11;
                                                i9 = i10;
                                                z = true;
                                                break;
                                            }
                                        }
                                        if (z) {
                                            i3 = i9;
                                            i11 = i8;
                                            break;
                                        }
                                    }
                                    i7 = i12;
                                    i8 = i11;
                                    i9 = i10;
                                    z = false;
                                    if (z) {
                                    }
                                } else {
                                    if (i10 < 13) {
                                        LinkedList<String> imageUrl = adVar.getImageUrl();
                                        if (imageUrl != null) {
                                            Iterator<String> it3 = imageUrl.iterator();
                                            while (true) {
                                                if (!it3.hasNext()) {
                                                    i7 = i12;
                                                    i8 = i11;
                                                    i9 = i10;
                                                    z = false;
                                                    break;
                                                }
                                                String next2 = it3.next();
                                                if (!a && (findViewWithTag = listView.findViewWithTag(next2)) != null && a(findViewWithTag, listView)) {
                                                    i7 = i12;
                                                    i8 = i11;
                                                    i9 = i10;
                                                    z = true;
                                                    break;
                                                }
                                                i10++;
                                                i11 += TbConfig.getPbImageSize();
                                            }
                                        }
                                        i7 = i12;
                                        i8 = i11;
                                        i9 = i10;
                                        z = false;
                                    } else {
                                        i7 = i12;
                                        i8 = i11;
                                        i9 = i10;
                                        z = true;
                                    }
                                    if (z) {
                                    }
                                }
                            } else {
                                i7 = i12;
                                i8 = i11;
                                i9 = i10;
                            }
                            i13++;
                            i10 = i9;
                            i11 = i8;
                            i12 = i7;
                        }
                    }
                    a((int) (i11 * 1.2f));
                    int i15 = 0;
                    int i16 = 0;
                    int i17 = firstVisiblePosition;
                    while (i17 < adapter.getCount()) {
                        if (i17 <= lastVisiblePosition || a) {
                            Object item2 = adapter.getItem(i17);
                            if (item2 instanceof ad) {
                                ad adVar2 = (ad) item2;
                                if (i15 < i3) {
                                    if (adVar2.isSupportImageSize()) {
                                        LinkedList<ab> imagesWithEmotions2 = adVar2.getImagesWithEmotions();
                                        if (imagesWithEmotions2 != null) {
                                            i6 = i15;
                                            for (int i18 = 0; i18 < imagesWithEmotions2.size() && i6 < i3; i18++) {
                                                ab abVar2 = imagesWithEmotions2.get(i18);
                                                i6++;
                                                if (abVar2.d == null) {
                                                    if (abVar2.e != null) {
                                                        abVar.f(abVar2.e, dVar4);
                                                    } else {
                                                        com.baidu.adp.widget.a.a b = abVar.b(abVar2.a, dVar);
                                                        if (b != null) {
                                                            dVar.a(b, abVar2.a, true);
                                                        }
                                                    }
                                                }
                                            }
                                            if (i16 < 30 && (photoUrl = adVar2.getPhotoUrl()) != null) {
                                                it = photoUrl.iterator();
                                                while (it.hasNext()) {
                                                    String next3 = it.next();
                                                    i16++;
                                                    if (i2 == 0) {
                                                        abVar.d(next3, dVar2);
                                                    } else if (i2 == 1) {
                                                        abVar.c(next3, dVar2);
                                                    }
                                                }
                                            }
                                            i5 = i16;
                                            forumPhotoUrl = adVar2.getForumPhotoUrl();
                                            if (forumPhotoUrl != null) {
                                                Iterator<String> it4 = forumPhotoUrl.iterator();
                                                while (it4.hasNext()) {
                                                    i5++;
                                                    abVar.e(it4.next(), dVar);
                                                }
                                            }
                                            i4 = i6;
                                        }
                                    } else {
                                        LinkedList<String> imageUrl2 = adVar2.getImageUrl();
                                        if (imageUrl2 != null) {
                                            i6 = i15;
                                            for (int i19 = 0; i19 < imageUrl2.size() && i6 < i3; i19++) {
                                                i6++;
                                                abVar.b(imageUrl2.get(i19), dVar);
                                            }
                                            if (i16 < 30) {
                                                it = photoUrl.iterator();
                                                while (it.hasNext()) {
                                                }
                                            }
                                            i5 = i16;
                                            forumPhotoUrl = adVar2.getForumPhotoUrl();
                                            if (forumPhotoUrl != null) {
                                            }
                                            i4 = i6;
                                        }
                                    }
                                }
                                i6 = i15;
                                if (i16 < 30) {
                                }
                                i5 = i16;
                                forumPhotoUrl = adVar2.getForumPhotoUrl();
                                if (forumPhotoUrl != null) {
                                }
                                i4 = i6;
                            } else {
                                i4 = i15;
                                i5 = i16;
                            }
                            if (!a || i4 < i3 || i5 < 30) {
                                i17++;
                                i16 = i5;
                                i15 = i4;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                } catch (Exception e) {
                    BdLog.e("LoadImageHelper", "loadListView", e.toString());
                }
            }
        }
    }

    private static boolean a() {
        return UtilHelper.getNetStatusInfo(TbadkApplication.m252getInst().getApp()) == UtilHelper.NetworkStateInfo.WIFI;
    }

    private static boolean a(View view, View view2) {
        int bottom = view.getBottom();
        int top = view.getTop();
        while (true) {
            View view3 = (View) view.getParent();
            if (view3 == null) {
                return false;
            }
            if (view3 == view2) {
                return top > view2.getBottom() || bottom < view2.getTop();
            }
            top += view3.getTop();
            bottom += view3.getBottom();
            view = view3;
        }
    }

    public static void a(int i) {
        int max = Math.max((int) (UtilHelper.getBitmapMaxMemory(TbadkApplication.m252getInst().getApp()) * 0.28f), i);
        BdLog.i("set pic cache size to :" + (max / LocationClientOption.MIN_SCAN_SPAN) + "KB. needed:" + (i / LocationClientOption.MIN_SCAN_SPAN) + "KB.");
        com.baidu.tbadk.imageManager.e.a().b(max);
    }
}
