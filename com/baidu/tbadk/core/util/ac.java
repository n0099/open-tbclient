package com.baidu.tbadk.core.util;

import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.gif.GifView;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class ac {
    public static void a(ListView listView, com.baidu.tbadk.editortool.ab abVar, int i, int i2) {
        a(listView, abVar, null, null, null, i, i2);
    }

    public static void a(ListView listView, com.baidu.tbadk.editortool.ab abVar, com.baidu.tbadk.imageManager.d dVar, com.baidu.tbadk.imageManager.d dVar2, com.baidu.tbadk.imageManager.d dVar3, int i, int i2) {
        a(listView, abVar, dVar, dVar2, null, null, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:164:0x0056 A[EDGE_INSN: B:164:0x0056->B:20:0x0056 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0139 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(ListView listView, com.baidu.tbadk.editortool.ab abVar, com.baidu.tbadk.imageManager.d dVar, com.baidu.tbadk.imageManager.d dVar2, com.baidu.tbadk.imageManager.d dVar3, com.baidu.tbadk.imageManager.d dVar4, int i, int i2) {
        int i3;
        int i4;
        LinkedList<String> photoUrl;
        boolean z;
        View findViewWithTag;
        int i5;
        int i6;
        int i7;
        View findViewWithTag2;
        if (listView != null && abVar != null) {
            abVar.a();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            ListAdapter adapter = listView.getAdapter();
            if (adapter != null) {
                if (dVar == null) {
                    dVar = new ad(listView);
                }
                if (dVar2 == null) {
                    dVar2 = new af(listView);
                }
                com.baidu.tbadk.imageManager.d agVar = dVar3 == null ? new ag(listView) : dVar3;
                try {
                    boolean z2 = UtilHelper.d(TbadkApplication.j().b()) == UtilHelper.NetworkStateInfo.WIFI;
                    int i8 = 0;
                    int i9 = 0;
                    int i10 = 0;
                    boolean b = b.b();
                    for (int i11 = firstVisiblePosition; i11 < adapter.getCount() && ((i11 <= lastVisiblePosition || z2) && i == 0); i11++) {
                        Object item = adapter.getItem(i11);
                        if (item instanceof ab) {
                            ab abVar2 = (ab) item;
                            if (abVar2.isSupportImageSize()) {
                                LinkedList<aa> imagesWithEmotions = abVar2.getImagesWithEmotions();
                                if (imagesWithEmotions != null) {
                                    Iterator<aa> it = imagesWithEmotions.iterator();
                                    while (it.hasNext()) {
                                        aa next = it.next();
                                        if (z2 || (findViewWithTag2 = listView.findViewWithTag(next.a())) == null || !a(findViewWithTag2, listView)) {
                                            i8++;
                                            int i12 = next.b * next.c;
                                            if (i12 > 0) {
                                                if (next.d != null) {
                                                    i9 += i12 * 4;
                                                } else {
                                                    i9 += i12 * 2;
                                                }
                                            } else if (next.d != null) {
                                                com.baidu.adp.lib.util.f.b("missing big emotion image width and height!");
                                                i9 += com.baidu.tbadk.core.data.n.v();
                                            } else if (next.e != null) {
                                                i9 += com.baidu.tbadk.core.data.n.w();
                                            }
                                            if (i11 > lastVisiblePosition) {
                                                i7 = next.c + i10;
                                                if (i7 > com.baidu.adp.lib.util.i.c(TbadkApplication.j().b())) {
                                                    i6 = i9;
                                                    i5 = i8;
                                                    i8 = i5;
                                                    i9 = i6;
                                                    i10 = i7;
                                                    z = true;
                                                    break;
                                                }
                                                i10 = i7;
                                            }
                                        } else {
                                            i7 = i10;
                                            i6 = i9;
                                            i5 = i8;
                                            i8 = i5;
                                            i9 = i6;
                                            i10 = i7;
                                            z = true;
                                            break;
                                        }
                                    }
                                    z = false;
                                    if (z) {
                                        break;
                                    }
                                }
                                z = false;
                                if (z) {
                                }
                            } else {
                                if (i8 < 13) {
                                    LinkedList<String> imageUrl = abVar2.getImageUrl();
                                    if (imageUrl != null) {
                                        Iterator<String> it2 = imageUrl.iterator();
                                        while (it2.hasNext()) {
                                            String next2 = it2.next();
                                            if (z2 || (findViewWithTag = listView.findViewWithTag(next2)) == null || !a(findViewWithTag, listView)) {
                                                i8++;
                                                i9 += com.baidu.tbadk.core.data.n.h();
                                            }
                                        }
                                        z = false;
                                        if (z) {
                                        }
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                }
                                i7 = i10;
                                i6 = i9;
                                i5 = i8;
                                i8 = i5;
                                i9 = i6;
                                i10 = i7;
                                z = true;
                                if (z) {
                                }
                            }
                        }
                    }
                    int i13 = i8;
                    int max = Math.max((int) (UtilHelper.e(TbadkApplication.j().b()) * 0.28f), (int) (i9 * 1.2f));
                    com.baidu.adp.lib.util.f.d("set pic cache size to :" + (max / LocationClientOption.MIN_SCAN_SPAN) + "KB. needed:" + (i3 / LocationClientOption.MIN_SCAN_SPAN) + "KB.");
                    com.baidu.tbadk.imageManager.e.a().a(max);
                    int i14 = 0;
                    int i15 = firstVisiblePosition;
                    int i16 = 0;
                    while (i15 < adapter.getCount()) {
                        if (i15 <= lastVisiblePosition || z2) {
                            Object item2 = adapter.getItem(i15);
                            if (item2 instanceof ab) {
                                ab abVar3 = (ab) item2;
                                if (i14 < i13) {
                                    if (abVar3.isSupportImageSize()) {
                                        LinkedList<aa> imagesWithEmotions2 = abVar3.getImagesWithEmotions();
                                        if (imagesWithEmotions2 != null) {
                                            int i17 = 0;
                                            while (i17 < imagesWithEmotions2.size() && i14 < i13) {
                                                aa aaVar = imagesWithEmotions2.get(i17);
                                                int i18 = i14 + 1;
                                                if (aaVar.d != null) {
                                                    com.baidu.tbadk.widget.richText.e eVar = aaVar.d;
                                                    View findViewWithTag3 = listView.findViewWithTag(aaVar.a());
                                                    if (findViewWithTag3 != null) {
                                                        GifView gifView = (GifView) findViewWithTag3;
                                                        if (eVar.j) {
                                                            gifView.setGif(null);
                                                        }
                                                    }
                                                    if (!eVar.k) {
                                                        String str = b ? eVar.b : eVar.a;
                                                        com.baidu.adp.lib.util.f.e("LoadImageHelper", "loadEmotion", "emotion dynamic:" + eVar.c);
                                                        com.baidu.adp.widget.ImageView.b a = abVar.a(eVar.e, eVar.c, str, b, agVar);
                                                        if (findViewWithTag3 != null) {
                                                            GifView gifView2 = (GifView) findViewWithTag3;
                                                            if (a != null) {
                                                                gifView2.setGif(a);
                                                                gifView2.setIsLoading(false);
                                                                eVar.j = false;
                                                            } else {
                                                                gifView2.setIsLoading(true);
                                                            }
                                                        }
                                                    }
                                                } else if (aaVar.e != null) {
                                                    abVar.g(aaVar.e, dVar4);
                                                } else {
                                                    Log.e("image:", aaVar.a);
                                                    com.baidu.adp.widget.ImageView.b b2 = abVar.b(aaVar.a, dVar);
                                                    if (b2 != null) {
                                                        dVar.a(b2, aaVar.a, true);
                                                    }
                                                }
                                                i17++;
                                                i14 = i18;
                                            }
                                        }
                                    } else {
                                        LinkedList<String> imageUrl2 = abVar3.getImageUrl();
                                        if (imageUrl2 != null) {
                                            int i19 = i14;
                                            for (int i20 = 0; i20 < imageUrl2.size() && i19 < i13; i20++) {
                                                i19++;
                                                abVar.b(imageUrl2.get(i20), dVar);
                                            }
                                            i14 = i19;
                                        }
                                    }
                                }
                                if (i16 < 30 && (photoUrl = abVar3.getPhotoUrl()) != null) {
                                    Iterator<String> it3 = photoUrl.iterator();
                                    while (it3.hasNext()) {
                                        String next3 = it3.next();
                                        i16++;
                                        if (i2 == 0) {
                                            abVar.d(next3, dVar2);
                                        } else if (i2 == 1) {
                                            abVar.c(next3, dVar2);
                                        }
                                    }
                                }
                                i4 = i16;
                                LinkedList<String> forumPhotoUrl = abVar3.getForumPhotoUrl();
                                if (forumPhotoUrl != null) {
                                    Iterator<String> it4 = forumPhotoUrl.iterator();
                                    while (it4.hasNext()) {
                                        i4++;
                                        abVar.f(it4.next(), dVar);
                                    }
                                }
                            } else {
                                i4 = i16;
                            }
                            if (!z2 || i14 < i13 || i4 < 30) {
                                i15++;
                                i16 = i4;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b("LoadImageHelper", "loadListView", e.toString());
                }
            }
        }
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
}
