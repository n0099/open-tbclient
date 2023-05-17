package com.baidu.swan.apps.core.prefetch.image.config.image;

import androidx.annotation.NonNull;
import com.baidu.tieba.be2;
import com.baidu.tieba.md2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class CustomStrategyImpl implements md2 {
    public final List<String> a = new ArrayList<String>() { // from class: com.baidu.swan.apps.core.prefetch.image.config.image.CustomStrategyImpl.1
        {
            add("intercepthttp");
            add("intercepthttps");
        }
    };

    @NonNull
    public String toString() {
        return "CustomStrategyImpl";
    }

    @Override // com.baidu.tieba.md2
    public boolean a(@NonNull be2.a aVar) {
        String d = aVar.d();
        for (String str : this.a) {
            if (d.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}
