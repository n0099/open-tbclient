package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.os.Bundle;
import com.baidu.platform.comapi.wnplatform.o.f;
import com.baidu.tbadk.core.util.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static int f10186a;

    /* renamed from: b  reason: collision with root package name */
    public static int f10187b;

    public static void a(int i) {
        f10186a = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> */
    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList<c> a(Bundle bundle, boolean z) {
        int i;
        int i2;
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "GuideUtility.getGuideLineText--->" + bundle.toString());
        ArrayList<c> arrayList = new ArrayList<>();
        if (bundle == null) {
            return arrayList;
        }
        bundle.getInt("updatetype");
        com.baidu.platform.comapi.wnplatform.o.f.a(bundle.getInt("nRemainDist"), f.a.ZH, new StringBuffer());
        String string = bundle.getString("usGuideText");
        int[] intArray = bundle.getIntArray("unIdx");
        int[] intArray2 = bundle.getIntArray("unWordCnt");
        int[] intArray3 = bundle.getIntArray("unLineNo");
        boolean[] booleanArray = bundle.getBooleanArray("bHighLight");
        a(intArray, intArray2, intArray3, booleanArray);
        if (string.contains("@")) {
            string = string.replace("@", StringHelper.STRING_MORE);
        }
        if (intArray.length == 0) {
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i = 1;
            if (i3 >= intArray3.length) {
                break;
            }
            i4 += intArray2[i3];
            if (i5 != intArray3[i3]) {
                hashMap.put(Integer.valueOf(i5), Integer.valueOf(i4 - intArray2[i3]));
                i5++;
                i4 = intArray2[i3];
            }
            if (i3 == intArray3.length - 1) {
                hashMap.put(Integer.valueOf(i5), Integer.valueOf(i4));
            }
            i3++;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = hashMap.size();
        int i6 = 0;
        while (i6 < size) {
            int intValue = ((Integer) hashMap.get(Integer.valueOf(i6))).intValue();
            char[] cArr = new char[intValue];
            int[] iArr = new int[intValue];
            int[] iArr2 = new int[intValue];
            int i7 = 0;
            while (i7 < intValue) {
                if (i6 <= 0) {
                    i2 = i7;
                } else if (i6 > i) {
                    i2 = ((Integer) hashMap.get(Integer.valueOf(i6 - 1))).intValue() + i7 + ((Integer) hashMap.get(Integer.valueOf(i6 - 2))).intValue();
                } else {
                    i2 = ((Integer) hashMap.get(Integer.valueOf(i6 - 1))).intValue() + i7;
                }
                if (i2 < string.length()) {
                    cArr[i7] = string.charAt(i2);
                }
                iArr2[i7] = 1;
                String str = string;
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
                    } else {
                        int i9 = i8 + 1;
                        if (i2 >= intArray[i9]) {
                            i8 = i9;
                        } else if (booleanArray[i8]) {
                            iArr[i7] = 1;
                        } else {
                            iArr[i7] = 0;
                        }
                    }
                }
                i7++;
                string = str;
                i = 1;
            }
            arrayList2.add(new c(cArr, iArr, iArr2));
            i6++;
            string = string;
            i = 1;
        }
        if (!z) {
            a(arrayList2, hashMap);
        }
        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
            arrayList.add(arrayList2.get(i10));
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "guide line:" + i11 + String.valueOf(((c) arrayList.get(i11)).f10182c));
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.util.ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0182, code lost:
        r18 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<c> a(Bundle bundle) {
        int i;
        int i2;
        String str;
        com.baidu.platform.comapi.wnplatform.d.a.a("GuideUtility.getGuideLineText", "" + bundle.toString());
        ArrayList<c> arrayList = new ArrayList<>();
        if (bundle == null) {
            return arrayList;
        }
        try {
            bundle.getInt("updatetype");
        } catch (Exception e2) {
            e2.printStackTrace();
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
        if (string.contains("@")) {
            string = string.replace("@", StringHelper.STRING_MORE);
        }
        if (intArray.length == 0) {
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i = 1;
            if (i3 >= intArray3.length) {
                break;
            }
            i4 += intArray2[i3];
            if (i5 != intArray3[i3]) {
                hashMap.put(Integer.valueOf(i5), Integer.valueOf(i4 - intArray2[i3]));
                i5++;
                i4 = intArray2[i3];
            }
            if (i3 == intArray3.length - 1) {
                hashMap.put(Integer.valueOf(i5), Integer.valueOf(i4));
            }
            i3++;
        }
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "poi segNumMap size:" + hashMap.size());
        for (int i6 = 0; i6 < hashMap.size(); i6++) {
            com.baidu.platform.comapi.wnplatform.d.a.c("yang11", i6 + "==" + hashMap.get(Integer.valueOf(i6)));
        }
        ArrayList arrayList2 = new ArrayList();
        int size = hashMap.size();
        int i7 = 0;
        while (i7 < size) {
            int intValue = ((Integer) hashMap.get(Integer.valueOf(i7))).intValue();
            char[] cArr = new char[intValue];
            int[] iArr = new int[intValue];
            int[] iArr2 = new int[intValue];
            int i8 = 0;
            while (i8 < intValue) {
                if (i7 <= 0) {
                    i2 = i8;
                } else if (i7 > i) {
                    i2 = ((Integer) hashMap.get(Integer.valueOf(i7 - 1))).intValue() + i8 + ((Integer) hashMap.get(Integer.valueOf(i7 - 2))).intValue();
                } else {
                    i2 = ((Integer) hashMap.get(Integer.valueOf(i7 - 1))).intValue() + i8;
                }
                if (i2 < string.length()) {
                    cArr[i8] = string.charAt(i2);
                }
                iArr2[i8] = 1;
                HashMap hashMap2 = hashMap;
                int i9 = 0;
                while (true) {
                    if (i9 >= intArray.length) {
                        break;
                    } else if (i9 == intArray.length - 1) {
                        if (booleanArray[i9]) {
                            iArr[i8] = 1;
                        } else {
                            iArr[i8] = 0;
                        }
                    } else {
                        int i10 = i9 + 1;
                        str = string;
                        if (i2 >= intArray[i10]) {
                            i9 = i10;
                            string = str;
                        } else if (booleanArray[i9]) {
                            iArr[i8] = 1;
                        } else {
                            iArr[i8] = 0;
                        }
                    }
                }
                i8++;
                hashMap = hashMap2;
                string = str;
                i = 1;
            }
            arrayList2.add(new c(cArr, iArr, iArr2));
            i7++;
            hashMap = hashMap;
            string = string;
            i = 1;
        }
        a(arrayList2);
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            arrayList.add(arrayList2.get(i11));
        }
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "poi line:" + i12 + String.valueOf(((c) arrayList.get(i12)).f10182c));
        }
        return arrayList;
    }

    public static int a() {
        return f10187b;
    }

    public static void a(ArrayList<c> arrayList, HashMap<Integer, Integer> hashMap) {
        f10187b = 0;
        if (hashMap.size() >= 2 && hashMap.get(1).intValue() <= 6) {
            com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "guide enter new branch1!!!");
            c a2 = c.a(arrayList.get(0), arrayList.get(1));
            arrayList.remove(0);
            arrayList.remove(0);
            arrayList.add(0, a2);
        }
        if (arrayList.size() < 2 || arrayList.get(1).f10182c.length <= f10186a) {
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "guide enter new branch2!!!");
        c cVar = arrayList.get(1);
        c cVar2 = arrayList.size() >= 3 ? arrayList.get(2) : null;
        c a3 = c.a(arrayList.get(1), f10186a);
        c b2 = c.b(arrayList.get(1), f10186a);
        f10187b = b2.f10182c.length;
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "headSecondText:" + String.valueOf(a3.f10182c));
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "tailSecondText:" + String.valueOf(b2.f10182c));
        if (arrayList.size() >= 3) {
            b2 = c.a(b2, arrayList.get(2));
        }
        arrayList.remove(cVar);
        if (cVar2 != null) {
            arrayList.remove(cVar2);
        }
        arrayList.add(a3);
        arrayList.add(b2);
    }

    public static void a(ArrayList<c> arrayList) {
        if (arrayList.size() >= 1) {
            c a2 = c.a(arrayList.get(0), arrayList.get(1));
            arrayList.remove(0);
            arrayList.remove(0);
            arrayList.add(0, a2);
            if (arrayList.get(0).f10182c.length > f10186a) {
                com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "poi enter new branch2!!!");
                c cVar = arrayList.get(0);
                c cVar2 = arrayList.size() >= 2 ? arrayList.get(1) : null;
                c a3 = c.a(arrayList.get(0), f10186a);
                c b2 = c.b(arrayList.get(0), f10186a);
                com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "headSecondText:" + String.valueOf(a3.f10182c));
                com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "tailSecondText:" + String.valueOf(b2.f10182c));
                if (arrayList.size() >= 2) {
                    b2 = c.a(b2, arrayList.get(1));
                }
                arrayList.remove(cVar);
                if (cVar2 != null) {
                    arrayList.remove(cVar2);
                }
                arrayList.add(a3);
                arrayList.add(b2);
            }
        }
    }

    public static void a(int[] iArr, int[] iArr2, int[] iArr3, boolean[] zArr) {
        String str = "";
        String str2 = "";
        for (int i = 0; i < iArr.length; i++) {
            str2 = str2 + iArr[i] + ",";
        }
        String str3 = "";
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            str3 = str3 + iArr2[i2] + ",";
        }
        String str4 = "";
        for (int i3 = 0; i3 < iArr3.length; i3++) {
            str4 = str4 + iArr3[i3] + ",";
        }
        for (int i4 = 0; i4 < zArr.length; i4++) {
            str = str + zArr[i4] + ",";
        }
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "unIdxString:" + str2);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "unWordCntString:" + str3);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "unLineNoString:" + str4);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "highLightString:" + str);
    }
}
