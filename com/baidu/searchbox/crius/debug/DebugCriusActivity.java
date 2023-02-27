package com.baidu.searchbox.crius.debug;

import android.os.Bundle;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.crius.CriusLoader;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class DebugCriusActivity extends BaseActivity {
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.crius.debug.DebugCriusActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        CriusLoader.init(this);
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d0032);
    }
}
