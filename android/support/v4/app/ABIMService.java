package android.support.v4.app;

import android.support.v4.app.JobIntentService;
import com.baidu.android.imsdk.utils.LogUtils;
/* loaded from: classes3.dex */
public abstract class ABIMService extends JobIntentService {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v4.app.JobIntentService
    public JobIntentService.GenericWorkItem dequeueWork() {
        try {
            return super.dequeueWork();
        } catch (SecurityException e) {
            LogUtils.e("ABIMService", "dequeueWork exception :", e);
            return null;
        }
    }
}
