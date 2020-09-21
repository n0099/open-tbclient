package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.os.Bundle;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.platform.comapi.wnplatform.p.g;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class d {
    private static int a;
    private static int b = 0;

    public static void a(int i) {
        a = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.b> */
    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList<b> a(Bundle bundle, boolean z) {
        int i;
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "GuideUtility.getGuideLineText--->" + bundle.toString());
        ArrayList<b> arrayList = new ArrayList<>();
        if (bundle == null) {
            return arrayList;
        }
        bundle.getInt("updatetype");
        g.a(bundle.getInt("nRemainDist"), g.b.ZH, new StringBuffer());
        String string = bundle.getString("usGuideText");
        int[] intArray = bundle.getIntArray("unIdx");
        int[] intArray2 = bundle.getIntArray("unWordCnt");
        int[] intArray3 = bundle.getIntArray("unLineNo");
        boolean[] booleanArray = bundle.getBooleanArray("bHighLight");
        a(intArray, intArray2, intArray3, booleanArray);
        String replace = string.contains(UgcConstant.AT_RULE_TAG) ? string.replace(UgcConstant.AT_RULE_TAG, StringHelper.STRING_MORE) : string;
        if (intArray.length == 0) {
            return arrayList;
        }
        int i2 = 0;
        HashMap hashMap = new HashMap();
        int i3 = 0;
        for (int i4 = 0; i4 < intArray3.length; i4++) {
            i3 += intArray2[i4];
            if (i2 != intArray3[i4]) {
                hashMap.put(Integer.valueOf(i2), Integer.valueOf(i3 - intArray2[i4]));
                i2++;
                i3 = intArray2[i4];
            }
            if (i4 == intArray3.length - 1) {
                hashMap.put(Integer.valueOf(i2), Integer.valueOf(i3));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = hashMap.size();
        int i5 = 0;
        while (i5 < size) {
            int intValue = ((Integer) hashMap.get(Integer.valueOf(i5))).intValue();
            char[] cArr = new char[intValue];
            int[] iArr = new int[intValue];
            int[] iArr2 = new int[intValue];
            for (int i6 = 0; i6 < intValue; i6++) {
                if (i5 > 0) {
                    i = i5 > 1 ? ((Integer) hashMap.get(Integer.valueOf(i5 - 2))).intValue() + i6 + ((Integer) hashMap.get(Integer.valueOf(i5 - 1))).intValue() : ((Integer) hashMap.get(Integer.valueOf(i5 - 1))).intValue() + i6;
                } else {
                    i = i6;
                }
                if (i < replace.length()) {
                    cArr[i6] = replace.charAt(i);
                }
                iArr2[i6] = 1;
                int i7 = 0;
                while (true) {
                    if (i7 >= intArray.length) {
                        break;
                    } else if (i7 == intArray.length - 1) {
                        if (booleanArray[i7]) {
                            iArr[i6] = 1;
                        } else {
                            iArr[i6] = 0;
                        }
                    } else if (i >= intArray[i7 + 1]) {
                        i7++;
                    } else if (booleanArray[i7]) {
                        iArr[i6] = 1;
                    } else {
                        iArr[i6] = 0;
                    }
                }
            }
            arrayList2.add(new b(cArr, iArr, iArr2));
            i5++;
        }
        if (!z) {
            a(arrayList2, hashMap);
        }
        for (int i8 = 0; i8 < arrayList2.size(); i8++) {
            arrayList.add(arrayList2.get(i8));
        }
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= arrayList.size()) {
                return arrayList;
            }
            com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "guide line:" + i10 + String.valueOf(((b) arrayList.get(i10)).c));
            i9 = i10 + 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: java.util.ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.b> */
    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList<b> a(Bundle bundle) {
        int i;
        com.baidu.platform.comapi.wnplatform.d.a.a("GuideUtility.getGuideLineText", "" + bundle.toString());
        ArrayList<b> arrayList = new ArrayList<>();
        if (bundle == null) {
            return arrayList;
        }
        try {
            bundle.getInt("updatetype");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bundle.getInt("POIIsPassingPOI") == 0) {
            return arrayList;
        }
        String string = bundle.getString("usPOIGuideText");
        int[] intArray = bundle.getIntArray("unPOIIdx");
        int[] intArray2 = bundle.getIntArray("unPOIWordCnt");
        int[] intArray3 = bundle.getIntArray("unPOILineNo");
        boolean[] booleanArray = bundle.getBooleanArray("bPOIHighLight");
        a(intArray, intArray2, intArray3, booleanArray);
        String replace = string.contains(UgcConstant.AT_RULE_TAG) ? string.replace(UgcConstant.AT_RULE_TAG, StringHelper.STRING_MORE) : string;
        if (intArray.length == 0) {
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < intArray3.length; i4++) {
            i2 += intArray2[i4];
            if (i3 != intArray3[i4]) {
                hashMap.put(Integer.valueOf(i3), Integer.valueOf(i2 - intArray2[i4]));
                i3++;
                i2 = intArray2[i4];
            }
            if (i4 == intArray3.length - 1) {
                hashMap.put(Integer.valueOf(i3), Integer.valueOf(i2));
            }
        }
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "poi segNumMap size:" + hashMap.size());
        for (int i5 = 0; i5 < hashMap.size(); i5++) {
            com.baidu.platform.comapi.wnplatform.d.a.c("yang11", i5 + "==" + hashMap.get(Integer.valueOf(i5)));
        }
        ArrayList arrayList2 = new ArrayList();
        int size = hashMap.size();
        int i6 = 0;
        while (i6 < size) {
            int intValue = ((Integer) hashMap.get(Integer.valueOf(i6))).intValue();
            char[] cArr = new char[intValue];
            int[] iArr = new int[intValue];
            int[] iArr2 = new int[intValue];
            for (int i7 = 0; i7 < intValue; i7++) {
                if (i6 > 0) {
                    i = i6 > 1 ? ((Integer) hashMap.get(Integer.valueOf(i6 - 2))).intValue() + i7 + ((Integer) hashMap.get(Integer.valueOf(i6 - 1))).intValue() : ((Integer) hashMap.get(Integer.valueOf(i6 - 1))).intValue() + i7;
                } else {
                    i = i7;
                }
                if (i < replace.length()) {
                    cArr[i7] = replace.charAt(i);
                }
                iArr2[i7] = 1;
                int i8 = 0;
                while (true) {
                    if (i8 >= intArray.length) {
                        break;
                    } else if (i8 == intArray.length - 1) {
                        if (booleanArray[i8]) {
                            iArr[i7] = 1;
                        } else {
                            iArr[i7] = 0;
                        }
                    } else if (i >= intArray[i8 + 1]) {
                        i8++;
                    } else if (booleanArray[i8]) {
                        iArr[i7] = 1;
                    } else {
                        iArr[i7] = 0;
                    }
                }
            }
            arrayList2.add(new b(cArr, iArr, iArr2));
            i6++;
        }
        a(arrayList2);
        for (int i9 = 0; i9 < arrayList2.size(); i9++) {
            arrayList.add(arrayList2.get(i9));
        }
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (i11 >= arrayList.size()) {
                break;
            }
            com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "poi line:" + i11 + String.valueOf(((b) arrayList.get(i11)).c));
            i10 = i11 + 1;
        }
        return arrayList;
    }

    public static int a() {
        return b;
    }

    private static void a(ArrayList<b> arrayList, HashMap<Integer, Integer> hashMap) {
        b bVar;
        b = 0;
        if (hashMap.size() >= 2 && hashMap.get(1).intValue() <= 6) {
            com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "guide enter new branch1!!!");
            b a2 = b.a(arrayList.get(0), arrayList.get(1));
            arrayList.remove(0);
            arrayList.remove(0);
            arrayList.add(0, a2);
        }
        if (arrayList.size() >= 2 && arrayList.get(1).c.length > a) {
            com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "guide enter new branch2!!!");
            b bVar2 = arrayList.get(1);
            if (arrayList.size() < 3) {
                bVar = null;
            } else {
                bVar = arrayList.get(2);
            }
            b a3 = b.a(arrayList.get(1), a);
            b b2 = b.b(arrayList.get(1), a);
            b = b2.c.length;
            com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "headSecondText:" + String.valueOf(a3.c));
            com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "tailSecondText:" + String.valueOf(b2.c));
            b a4 = arrayList.size() >= 3 ? b.a(b2, arrayList.get(2)) : b2;
            arrayList.remove(bVar2);
            if (bVar != null) {
                arrayList.remove(bVar);
            }
            arrayList.add(a3);
            arrayList.add(a4);
        }
    }

    private static void a(ArrayList<b> arrayList) {
        b bVar;
        if (arrayList.size() >= 1) {
            b a2 = b.a(arrayList.get(0), arrayList.get(1));
            arrayList.remove(0);
            arrayList.remove(0);
            arrayList.add(0, a2);
            if (arrayList.get(0).c.length > a) {
                com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "poi enter new branch2!!!");
                b bVar2 = arrayList.get(0);
                if (arrayList.size() < 2) {
                    bVar = null;
                } else {
                    bVar = arrayList.get(1);
                }
                b a3 = b.a(arrayList.get(0), a);
                b b2 = b.b(arrayList.get(0), a);
                com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "headSecondText:" + String.valueOf(a3.c));
                com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "tailSecondText:" + String.valueOf(b2.c));
                b a4 = arrayList.size() >= 2 ? b.a(b2, arrayList.get(1)) : b2;
                arrayList.remove(bVar2);
                if (bVar != null) {
                    arrayList.remove(bVar);
                }
                arrayList.add(a3);
                arrayList.add(a4);
            }
        }
    }

    private static void a(int[] iArr, int[] iArr2, int[] iArr3, boolean[] zArr) {
        String str = "";
        String str2 = "";
        String str3 = "";
        for (int i = 0; i < iArr.length; i++) {
            str3 = str3 + iArr[i] + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            str = str + iArr2[i2] + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        for (int i3 = 0; i3 < iArr3.length; i3++) {
            str2 = str2 + iArr3[i3] + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        String str4 = "";
        for (int i4 = 0; i4 < zArr.length; i4++) {
            str4 = str4 + zArr[i4] + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "unIdxString:" + str3);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "unWordCntString:" + str);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "unLineNoString:" + str2);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "highLightString:" + str4);
    }
}
