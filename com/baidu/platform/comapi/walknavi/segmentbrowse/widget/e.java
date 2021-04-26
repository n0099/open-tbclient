package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.os.Bundle;
import com.baidu.platform.comapi.wnplatform.o.f;
import com.baidu.tbadk.core.util.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static int f10105a;

    /* renamed from: b  reason: collision with root package name */
    public static int f10106b;

    public static void a(int i2) {
        f10105a = i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> */
    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList<c> a(Bundle bundle, boolean z) {
        int i2;
        int i3;
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
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i2 = 1;
            if (i4 >= intArray3.length) {
                break;
            }
            i5 += intArray2[i4];
            if (i6 != intArray3[i4]) {
                hashMap.put(Integer.valueOf(i6), Integer.valueOf(i5 - intArray2[i4]));
                i6++;
                i5 = intArray2[i4];
            }
            if (i4 == intArray3.length - 1) {
                hashMap.put(Integer.valueOf(i6), Integer.valueOf(i5));
            }
            i4++;
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
                    i3 = i8;
                } else if (i7 > i2) {
                    i3 = ((Integer) hashMap.get(Integer.valueOf(i7 - 1))).intValue() + i8 + ((Integer) hashMap.get(Integer.valueOf(i7 - 2))).intValue();
                } else {
                    i3 = ((Integer) hashMap.get(Integer.valueOf(i7 - 1))).intValue() + i8;
                }
                if (i3 < string.length()) {
                    cArr[i8] = string.charAt(i3);
                }
                iArr2[i8] = 1;
                String str = string;
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
                        if (i3 >= intArray[i10]) {
                            i9 = i10;
                        } else if (booleanArray[i9]) {
                            iArr[i8] = 1;
                        } else {
                            iArr[i8] = 0;
                        }
                    }
                }
                i8++;
                string = str;
                i2 = 1;
            }
            arrayList2.add(new c(cArr, iArr, iArr2));
            i7++;
            string = string;
            i2 = 1;
        }
        if (!z) {
            a(arrayList2, hashMap);
        }
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            arrayList.add(arrayList2.get(i11));
        }
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "guide line:" + i12 + String.valueOf(((c) arrayList.get(i12)).f10101c));
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
        int i2;
        int i3;
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
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i2 = 1;
            if (i4 >= intArray3.length) {
                break;
            }
            i5 += intArray2[i4];
            if (i6 != intArray3[i4]) {
                hashMap.put(Integer.valueOf(i6), Integer.valueOf(i5 - intArray2[i4]));
                i6++;
                i5 = intArray2[i4];
            }
            if (i4 == intArray3.length - 1) {
                hashMap.put(Integer.valueOf(i6), Integer.valueOf(i5));
            }
            i4++;
        }
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "poi segNumMap size:" + hashMap.size());
        for (int i7 = 0; i7 < hashMap.size(); i7++) {
            com.baidu.platform.comapi.wnplatform.d.a.c("yang11", i7 + "==" + hashMap.get(Integer.valueOf(i7)));
        }
        ArrayList arrayList2 = new ArrayList();
        int size = hashMap.size();
        int i8 = 0;
        while (i8 < size) {
            int intValue = ((Integer) hashMap.get(Integer.valueOf(i8))).intValue();
            char[] cArr = new char[intValue];
            int[] iArr = new int[intValue];
            int[] iArr2 = new int[intValue];
            int i9 = 0;
            while (i9 < intValue) {
                if (i8 <= 0) {
                    i3 = i9;
                } else if (i8 > i2) {
                    i3 = ((Integer) hashMap.get(Integer.valueOf(i8 - 1))).intValue() + i9 + ((Integer) hashMap.get(Integer.valueOf(i8 - 2))).intValue();
                } else {
                    i3 = ((Integer) hashMap.get(Integer.valueOf(i8 - 1))).intValue() + i9;
                }
                if (i3 < string.length()) {
                    cArr[i9] = string.charAt(i3);
                }
                iArr2[i9] = 1;
                HashMap hashMap2 = hashMap;
                int i10 = 0;
                while (true) {
                    if (i10 >= intArray.length) {
                        break;
                    } else if (i10 == intArray.length - 1) {
                        if (booleanArray[i10]) {
                            iArr[i9] = 1;
                        } else {
                            iArr[i9] = 0;
                        }
                    } else {
                        int i11 = i10 + 1;
                        str = string;
                        if (i3 >= intArray[i11]) {
                            i10 = i11;
                            string = str;
                        } else if (booleanArray[i10]) {
                            iArr[i9] = 1;
                        } else {
                            iArr[i9] = 0;
                        }
                    }
                }
                i9++;
                hashMap = hashMap2;
                string = str;
                i2 = 1;
            }
            arrayList2.add(new c(cArr, iArr, iArr2));
            i8++;
            hashMap = hashMap;
            string = string;
            i2 = 1;
        }
        a(arrayList2);
        for (int i12 = 0; i12 < arrayList2.size(); i12++) {
            arrayList.add(arrayList2.get(i12));
        }
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "poi line:" + i13 + String.valueOf(((c) arrayList.get(i13)).f10101c));
        }
        return arrayList;
    }

    public static int a() {
        return f10106b;
    }

    public static void a(ArrayList<c> arrayList, HashMap<Integer, Integer> hashMap) {
        f10106b = 0;
        if (hashMap.size() >= 2 && hashMap.get(1).intValue() <= 6) {
            com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "guide enter new branch1!!!");
            c a2 = c.a(arrayList.get(0), arrayList.get(1));
            arrayList.remove(0);
            arrayList.remove(0);
            arrayList.add(0, a2);
        }
        if (arrayList.size() < 2 || arrayList.get(1).f10101c.length <= f10105a) {
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "guide enter new branch2!!!");
        c cVar = arrayList.get(1);
        c cVar2 = arrayList.size() >= 3 ? arrayList.get(2) : null;
        c a3 = c.a(arrayList.get(1), f10105a);
        c b2 = c.b(arrayList.get(1), f10105a);
        f10106b = b2.f10101c.length;
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "headSecondText:" + String.valueOf(a3.f10101c));
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "tailSecondText:" + String.valueOf(b2.f10101c));
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
            if (arrayList.get(0).f10101c.length > f10105a) {
                com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "poi enter new branch2!!!");
                c cVar = arrayList.get(0);
                c cVar2 = arrayList.size() >= 2 ? arrayList.get(1) : null;
                c a3 = c.a(arrayList.get(0), f10105a);
                c b2 = c.b(arrayList.get(0), f10105a);
                com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "headSecondText:" + String.valueOf(a3.f10101c));
                com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "tailSecondText:" + String.valueOf(b2.f10101c));
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
        for (int i2 = 0; i2 < iArr.length; i2++) {
            str2 = str2 + iArr[i2] + ",";
        }
        String str3 = "";
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            str3 = str3 + iArr2[i3] + ",";
        }
        String str4 = "";
        for (int i4 = 0; i4 < iArr3.length; i4++) {
            str4 = str4 + iArr3[i4] + ",";
        }
        for (int i5 = 0; i5 < zArr.length; i5++) {
            str = str + zArr[i5] + ",";
        }
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "unIdxString:" + str2);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "unWordCntString:" + str3);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "unLineNoString:" + str4);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "highLightString:" + str);
    }
}
