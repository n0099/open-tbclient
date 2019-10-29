package com.baidu.live.tieba.e;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class c extends ContentObserver {
    private a aoJ;

    /* loaded from: classes6.dex */
    public interface a {
        void onChange(boolean z);
    }

    public c(Context context, Handler handler) {
        super(handler);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        vv();
    }

    private void vv() {
        try {
            int i = Settings.System.getInt(TbadkCoreApplication.getInst().getContentResolver(), "accelerometer_rotation");
            if (this.aoJ != null) {
                this.aoJ.onChange(i == 1);
            }
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a(a aVar) {
        this.aoJ = aVar;
        vv();
    }
}
