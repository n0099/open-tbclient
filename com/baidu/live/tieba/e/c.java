package com.baidu.live.tieba.e;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class c extends ContentObserver {
    private a bcG;

    /* loaded from: classes3.dex */
    public interface a {
        void onChange(boolean z);
    }

    public c(Context context, Handler handler) {
        super(handler);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        GY();
    }

    private void GY() {
        try {
            int i = Settings.System.getInt(TbadkCoreApplication.getInst().getContentResolver(), "accelerometer_rotation");
            if (this.bcG != null) {
                this.bcG.onChange(i == 1);
            }
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a(a aVar) {
        this.bcG = aVar;
        GY();
    }
}
