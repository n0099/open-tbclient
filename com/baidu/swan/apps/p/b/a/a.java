package com.baidu.swan.apps.p.b.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.cookie.SM;
/* loaded from: classes7.dex */
public class a extends com.baidu.swan.apps.p.a<com.baidu.swan.apps.p.b.a> {
    @Override // com.baidu.swan.apps.p.a
    @NonNull
    public String agB() {
        return "extractMediaMetadata";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.p.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.p.b.a aVar) {
        if (command.obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) command.obj;
            if (arrayList.size() >= 4) {
                HashMap hashMap = new HashMap();
                hashMap.put(SM.COOKIE, (String) arrayList.get(1));
                hashMap.put("User-Agent", (String) arrayList.get(2));
                hashMap.put("Referer", (String) arrayList.get(3));
                aVar.f((String) arrayList.get(0), hashMap);
            }
        }
    }
}
