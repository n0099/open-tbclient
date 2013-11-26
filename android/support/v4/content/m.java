package android.support.v4.content;

import android.support.v4.content.ModernAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public /* synthetic */ class m {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f319a = new int[ModernAsyncTask.Status.values().length];

    static {
        try {
            f319a[ModernAsyncTask.Status.RUNNING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f319a[ModernAsyncTask.Status.FINISHED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
