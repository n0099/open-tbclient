package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class aj {
    public static void a(ListView listView, com.baidu.tbadk.editortool.aa aaVar, int i, int i2) {
        a(listView, aaVar, null, null, null, i, i2);
    }

    public static void a(ListView listView, com.baidu.tbadk.editortool.aa aaVar, com.baidu.tbadk.imageManager.d dVar, com.baidu.tbadk.imageManager.d dVar2, com.baidu.tbadk.imageManager.d dVar3, int i, int i2) {
        a(listView, aaVar, dVar, dVar2, dVar3, null, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x0207 A[Catch: Exception -> 0x01d9, TryCatch #0 {Exception -> 0x01d9, blocks: (B:12:0x002d, B:13:0x0035, B:16:0x003c, B:17:0x0048, B:21:0x0052, B:23:0x005a, B:25:0x005e, B:27:0x0064, B:30:0x006d, B:110:0x01a6, B:112:0x01b2, B:114:0x01b6, B:116:0x01c4, B:118:0x01d0, B:115:0x01bf, B:35:0x0079, B:37:0x007f, B:38:0x0083, B:129:0x0207, B:131:0x0211, B:134:0x021f, B:40:0x0089, B:42:0x0090, B:43:0x0094, B:135:0x0228, B:50:0x00a3, B:122:0x01e3, B:125:0x01ec, B:128:0x01f4, B:56:0x00b3, B:58:0x00bc, B:60:0x00c4, B:62:0x00ca, B:63:0x00ce, B:109:0x019e, B:68:0x00de, B:70:0x00e6, B:72:0x00f2, B:75:0x0103, B:77:0x010c, B:79:0x0110, B:81:0x0115, B:84:0x012f, B:85:0x0133, B:87:0x0137, B:88:0x0143, B:90:0x0147, B:93:0x0151, B:95:0x0157, B:96:0x015b, B:99:0x0167, B:101:0x016f, B:103:0x0177, B:106:0x0189), top: B:140:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00da A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x019e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079 A[Catch: Exception -> 0x01d9, TryCatch #0 {Exception -> 0x01d9, blocks: (B:12:0x002d, B:13:0x0035, B:16:0x003c, B:17:0x0048, B:21:0x0052, B:23:0x005a, B:25:0x005e, B:27:0x0064, B:30:0x006d, B:110:0x01a6, B:112:0x01b2, B:114:0x01b6, B:116:0x01c4, B:118:0x01d0, B:115:0x01bf, B:35:0x0079, B:37:0x007f, B:38:0x0083, B:129:0x0207, B:131:0x0211, B:134:0x021f, B:40:0x0089, B:42:0x0090, B:43:0x0094, B:135:0x0228, B:50:0x00a3, B:122:0x01e3, B:125:0x01ec, B:128:0x01f4, B:56:0x00b3, B:58:0x00bc, B:60:0x00c4, B:62:0x00ca, B:63:0x00ce, B:109:0x019e, B:68:0x00de, B:70:0x00e6, B:72:0x00f2, B:75:0x0103, B:77:0x010c, B:79:0x0110, B:81:0x0115, B:84:0x012f, B:85:0x0133, B:87:0x0137, B:88:0x0143, B:90:0x0147, B:93:0x0151, B:95:0x0157, B:96:0x015b, B:99:0x0167, B:101:0x016f, B:103:0x0177, B:106:0x0189), top: B:140:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0090 A[Catch: Exception -> 0x01d9, TryCatch #0 {Exception -> 0x01d9, blocks: (B:12:0x002d, B:13:0x0035, B:16:0x003c, B:17:0x0048, B:21:0x0052, B:23:0x005a, B:25:0x005e, B:27:0x0064, B:30:0x006d, B:110:0x01a6, B:112:0x01b2, B:114:0x01b6, B:116:0x01c4, B:118:0x01d0, B:115:0x01bf, B:35:0x0079, B:37:0x007f, B:38:0x0083, B:129:0x0207, B:131:0x0211, B:134:0x021f, B:40:0x0089, B:42:0x0090, B:43:0x0094, B:135:0x0228, B:50:0x00a3, B:122:0x01e3, B:125:0x01ec, B:128:0x01f4, B:56:0x00b3, B:58:0x00bc, B:60:0x00c4, B:62:0x00ca, B:63:0x00ce, B:109:0x019e, B:68:0x00de, B:70:0x00e6, B:72:0x00f2, B:75:0x0103, B:77:0x010c, B:79:0x0110, B:81:0x0115, B:84:0x012f, B:85:0x0133, B:87:0x0137, B:88:0x0143, B:90:0x0147, B:93:0x0151, B:95:0x0157, B:96:0x015b, B:99:0x0167, B:101:0x016f, B:103:0x0177, B:106:0x0189), top: B:140:0x002d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(ListView listView, com.baidu.tbadk.editortool.aa aaVar, com.baidu.tbadk.imageManager.d dVar, com.baidu.tbadk.imageManager.d dVar2, com.baidu.tbadk.imageManager.d dVar3, com.baidu.tbadk.imageManager.d dVar4, int i, int i2) {
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
        if (listView != null && aaVar != null) {
            aaVar.a();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            ListAdapter adapter = listView.getAdapter();
            if (adapter != null) {
                if (dVar == null) {
                    dVar = new ak(listView);
                }
                if (dVar2 == null) {
                    dVar2 = new am(listView);
                }
                try {
                    boolean a = a();
                    int i10 = 0;
                    int i11 = 0;
                    int i12 = 0;
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
                            if (item instanceof ai) {
                                ai aiVar = (ai) item;
                                if (aiVar.isSupportImageSize()) {
                                    LinkedList<ad> imagesWithEmotions = aiVar.getImagesWithEmotions();
                                    if (imagesWithEmotions != null) {
                                        Iterator<ad> it2 = imagesWithEmotions.iterator();
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                i7 = i12;
                                                i8 = i11;
                                                i9 = i10;
                                                z = false;
                                                break;
                                            }
                                            ad next = it2.next();
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
                                            if (i13 > lastVisiblePosition && (i12 = i12 + next.c) > com.baidu.adp.lib.util.j.c(TbadkApplication.m252getInst().getApp())) {
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
                                        LinkedList<String> imageUrl = aiVar.getImageUrl();
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
                            if (item2 instanceof ai) {
                                ai aiVar2 = (ai) item2;
                                if (i15 < i3) {
                                    if (aiVar2.isSupportImageSize()) {
                                        LinkedList<ad> imagesWithEmotions2 = aiVar2.getImagesWithEmotions();
                                        if (imagesWithEmotions2 != null) {
                                            i6 = i15;
                                            for (int i18 = 0; i18 < imagesWithEmotions2.size() && i6 < i3; i18++) {
                                                ad adVar = imagesWithEmotions2.get(i18);
                                                i6++;
                                                if (adVar.d == null) {
                                                    if (adVar.e != null) {
                                                        aaVar.f(adVar.e, dVar4);
                                                    } else {
                                                        com.baidu.adp.widget.a.a b = aaVar.b(adVar.a, dVar);
                                                        if (b != null) {
                                                            dVar.a(b, adVar.a, true);
                                                        }
                                                    }
                                                }
                                            }
                                            if (i16 < 30 && (photoUrl = aiVar2.getPhotoUrl()) != null) {
                                                it = photoUrl.iterator();
                                                while (it.hasNext()) {
                                                    String next3 = it.next();
                                                    i16++;
                                                    if (i2 == 0) {
                                                        aaVar.d(next3, dVar2);
                                                    } else if (i2 == 1) {
                                                        aaVar.c(next3, dVar2);
                                                    }
                                                }
                                            }
                                            i5 = i16;
                                            forumPhotoUrl = aiVar2.getForumPhotoUrl();
                                            if (forumPhotoUrl != null) {
                                                Iterator<String> it4 = forumPhotoUrl.iterator();
                                                while (it4.hasNext()) {
                                                    i5++;
                                                    aaVar.e(it4.next(), dVar);
                                                }
                                            }
                                            i4 = i6;
                                        }
                                    } else {
                                        LinkedList<String> imageUrl2 = aiVar2.getImageUrl();
                                        if (imageUrl2 != null) {
                                            i6 = i15;
                                            for (int i19 = 0; i19 < imageUrl2.size() && i6 < i3; i19++) {
                                                i6++;
                                                aaVar.b(imageUrl2.get(i19), dVar);
                                            }
                                            if (i16 < 30) {
                                                it = photoUrl.iterator();
                                                while (it.hasNext()) {
                                                }
                                            }
                                            i5 = i16;
                                            forumPhotoUrl = aiVar2.getForumPhotoUrl();
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
                                forumPhotoUrl = aiVar2.getForumPhotoUrl();
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
                    BdLog.e(e.toString());
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
        com.baidu.tbadk.imageManager.e.a().b(Math.max((int) (UtilHelper.getBitmapMaxMemory(TbadkApplication.m252getInst().getApp()) * 0.28f), i));
    }
}
