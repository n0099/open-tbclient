package com.baidu.swan.apps.adaptation.a;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public interface u {

    /* loaded from: classes7.dex */
    public interface a {
        void onResult(String str);
    }

    void a(Bitmap bitmap, HashMap<String, String> hashMap, File[] fileArr, a aVar);

    void a(HashMap<String, String> hashMap, File file, a aVar);

    void a(HashMap<String, String> hashMap, File file, a aVar, String str);

    void n(Context context, String str, String str2);
}
