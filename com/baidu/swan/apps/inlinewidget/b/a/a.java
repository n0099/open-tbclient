package com.baidu.swan.apps.inlinewidget.b.a;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.cookie.SM;
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.b.a> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String azs() {
        return "extractMediaMetadata";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.b.a aVar) {
        if (command.obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) command.obj;
            if (arrayList.size() >= 4) {
                HashMap hashMap = new HashMap();
                hashMap.put(SM.COOKIE, (String) arrayList.get(1));
                hashMap.put("User-Agent", (String) arrayList.get(2));
                hashMap.put("Referer", (String) arrayList.get(3));
                aVar.e((String) arrayList.get(0), hashMap);
            }
        }
    }
}
