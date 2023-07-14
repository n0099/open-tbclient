package com.baidu.searchbox.crius.debug;

import android.os.Bundle;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.crius.CriusLoader;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class DebugCriusFlattenActivity extends BaseActivity {
    @Override // com.baidu.searchbox.appframework.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        CriusLoader.init(this);
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d0033);
    }
}
