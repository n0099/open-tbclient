package com.baidu.f;

import android.content.Context;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class b extends PlatformViewFactory {
    private static HashMap<String, a> aoZ = new HashMap<>();
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
            a aVar = aoZ.get(valueOf);
            if (aVar == null) {
                a aVar2 = new a(context, this.messenger, i, map);
                aoZ.put(valueOf, aVar2);
                return aVar2;
            }
            return aVar;
        }
        return new a(context, this.messenger, i, map);
    }

    public static void bK(int i) {
        if (aoZ.containsKey(String.valueOf(i))) {
            aoZ.remove(Integer.valueOf(i));
        }
    }
}
