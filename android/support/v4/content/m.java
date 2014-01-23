package android.support.v4.content;

import android.support.v4.content.ModernAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public /* synthetic */ class m {
    static final /* synthetic */ int[] a = new int[ModernAsyncTask.Status.values().length];

    static {
        try {
            a[ModernAsyncTask.Status.RUNNING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[ModernAsyncTask.Status.FINISHED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
