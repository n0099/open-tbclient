package com.baidu.searchbox.interaction.cloudcontrol;

import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/interaction/cloudcontrol/InteractionSpHelperByDebug;", "Lcom/baidu/android/util/sp/SharedPrefsWrapper;", "()V", "lib-interaction-cloudcontrol_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InteractionSpHelperByDebug extends SharedPrefsWrapper {
    public static final InteractionSpHelperByDebug INSTANCE = new InteractionSpHelperByDebug();

    public InteractionSpHelperByDebug() {
        super(KVStorageFactory.getSharedPreferences("com.baidu.searchbox.interaction.interaction_sp_debug"));
    }
}
