package com.baidu.tbadk.core.frameworkData;

import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.m;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class b {
    private static final ArrayList<String> a;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        a = arrayList;
        arrayList.add("com.baidu.tbadk.core.util.resourceLoader.PicImageLoaderProc");
        a.add("com.baidu.tbadk.core.util.resourceLoader.PortraitImageLoaderProc");
        a.add("com.baidu.tbadk.core.voice.cache.VoiceResourceLoaderProc");
    }

    public static void a() {
        String packageName = com.baidu.adp.a.b.a().b().getPackageName();
        try {
            m.a();
            PackageInfo packageInfo = com.baidu.adp.a.b.a().b().getPackageManager().getPackageInfo(packageName, 7);
            a(packageInfo.activities);
            a(packageInfo.services);
            a(packageInfo.receivers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
            try {
                Class.forName(it.next());
            } catch (Exception e2) {
                f.b(e2.getMessage());
            }
        }
    }

    private static void a(ComponentInfo[] componentInfoArr) {
        if (componentInfoArr != null) {
            for (ComponentInfo componentInfo : componentInfoArr) {
                try {
                    Class.forName(componentInfo.name);
                } catch (Exception e) {
                    f.b(e.getMessage());
                }
            }
        }
    }
}
