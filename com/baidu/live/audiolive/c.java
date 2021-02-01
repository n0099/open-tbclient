package com.baidu.live.audiolive;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public interface c {
    void a(TbPageContext tbPageContext, b bVar);

    void onActivityResult(int i, int i2, Intent intent);

    void onConfigurationChanged(Configuration configuration);

    void onDestroy();

    boolean onKeyDown(int i, KeyEvent keyEvent);

    void onPause();

    void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);

    void onResume();

    void onStart();

    void onStop();

    void onWindowFocusChanged(boolean z);
}
