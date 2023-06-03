package com.baidu.searchbox.download.unified;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class DestinationControlUtil {
    public static final List<String> PRIVATE_SOURCE_LIST = new ArrayList();

    public static boolean isSdcardPublic(String str) {
        return !PRIVATE_SOURCE_LIST.contains(str);
    }
}
