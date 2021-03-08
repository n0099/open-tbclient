package com.baidu.e;

import android.content.Context;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class b extends PlatformViewFactory {
    private static HashMap<String, a> apC = new HashMap<>();
    private final BinaryMessenger messenger;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BinaryMessenger binaryMessenger) {
        super(StandardMessageCodec.INSTANCE);
        this.messenger = binaryMessenger;
    }

    @Override // io.flutter.plugin.platform.PlatformViewFactory
    public PlatformView create(Context context, int i, Object obj) {
        Map map;
        if (obj == null || !(obj instanceof Map)) {
            map = null;
        } else {
            map = (Map) obj;
        }
        String valueOf = map == null ? "0" : String.valueOf(map.get("persistentViewId"));
        if (Integer.parseInt(valueOf) < 0) {
            a aVar = apC.get(valueOf);
            if (aVar == null) {
                a aVar2 = new a(context, this.messenger, i, map);
                apC.put(valueOf, aVar2);
                return aVar2;
            }
            return aVar;
        }
        return new a(context, this.messenger, i, map);
    }

    public static void bJ(int i) {
        if (apC.containsKey(String.valueOf(i))) {
            apC.remove(Integer.valueOf(i));
        }
    }
}
