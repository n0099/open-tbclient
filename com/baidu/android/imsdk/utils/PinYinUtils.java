package com.baidu.android.imsdk.utils;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes18.dex */
public class PinYinUtils {
    private static Comparator<PinYinObject> pyComparator = new Comparator<PinYinObject>() { // from class: com.baidu.android.imsdk.utils.PinYinUtils.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(PinYinObject pinYinObject, PinYinObject pinYinObject2) {
            return pinYinObject.getPy().compareToIgnoreCase(pinYinObject2.getPy());
        }
    };

    /* loaded from: classes18.dex */
    public interface PinYinObject {
        String getPy();
    }

    public static String getPy(String str) {
        if (str == null) {
            return null;
        }
        return !"".equals(str) ? getPinYin(str) : str;
    }

    private static String getPinYin(String str) {
        ArrayList<HanziToPinyin.Token> arrayList = HanziToPinyin.getInstance().get(str);
        StringBuilder sb = new StringBuilder();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<HanziToPinyin.Token> it = arrayList.iterator();
            while (it.hasNext()) {
                HanziToPinyin.Token next = it.next();
                if (2 == next.type) {
                    sb.append(next.target);
                } else {
                    sb.append(next.source);
                }
            }
        }
        return sb.toString().toLowerCase();
    }

    public static void sortByPinYin(List<? extends PinYinObject> list) {
        if (list != null) {
            Collections.sort(list, pyComparator);
        }
    }
}
