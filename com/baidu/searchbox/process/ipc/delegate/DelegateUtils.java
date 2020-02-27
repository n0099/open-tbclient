package com.baidu.searchbox.process.ipc.delegate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity;
import com.baidu.searchbox.process.ipc.agent.provider.MainProcessDelegateProvider;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import rx.d;
import rx.j;
/* loaded from: classes11.dex */
public final class DelegateUtils implements DelegateDef {
    public static Handler sMainHandler = new Handler(Looper.getMainLooper());

    private DelegateUtils() {
    }

    @NonNull
    public static DelegateResult callOnMainWithContentProvider(@NonNull Context context, @NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle) {
        try {
            Bundle call = context.getContentResolver().call(MainProcessDelegateProvider.PROVIDER_URI, cls.getName(), (String) null, bundle);
            if (call != null) {
                call.setClassLoader(cls.getClassLoader());
            }
            if (call == null) {
                return new DelegateResult(1, cls, null, null);
            }
            return new DelegateResult(call.getInt(DelegateDef.EXTRA_RESULT_CODE), cls, null, call.getBundle(DelegateDef.EXTRA_RESULT));
        } catch (IllegalArgumentException e) {
            return new DelegateResult(1, cls, null, null);
        } catch (SecurityException e2) {
            return new DelegateResult(1, cls, null, null);
        }
    }

    @NonNull
    public static d<DelegateResult> safeCallOnMainWithContentProvider(@NonNull final Context context, @NonNull final Class<? extends ProviderDelegation> cls, @Nullable final Bundle bundle) {
        return d.a((d.a) new d.a<DelegateResult>() { // from class: com.baidu.searchbox.process.ipc.delegate.DelegateUtils.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(j<? super DelegateResult> jVar) {
                jVar.onNext(DelegateUtils.callOnMainWithContentProvider(context, cls, bundle));
                jVar.onCompleted();
            }
        });
    }

    public static void callOnMainWithContentProviderASync(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle, @NonNull DelegateListener delegateListener) {
        notifyResult(delegateListener, new DelegateResult(1, cls, bundle).addDesc("agent is not implement"));
    }

    public static void callOnMainWithActivity(@NonNull Activity activity, @NonNull Class<? extends ProcessDelegateBaseActivity> cls, @NonNull Class<? extends ActivityDelegation> cls2, @NonNull DelegateListener delegateListener) {
        callOnMainWithActivity(activity, cls, cls2, null, delegateListener);
    }

    public static void callOnMainWithActivity(@NonNull Activity activity, @NonNull Class<? extends ProcessDelegateBaseActivity> cls, @NonNull final Class<? extends ActivityDelegation> cls2, @Nullable final Bundle bundle, @NonNull final DelegateListener delegateListener) {
        if (cls2 == null) {
            notifyResult(delegateListener, new DelegateResult(2, cls2, bundle).addDesc("action is null"));
            return;
        }
        final String name = cls2.getName();
        if (TextUtils.isEmpty(name)) {
            notifyResult(delegateListener, new DelegateResult(2, cls2, bundle).addDesc("caller not instanceof ActivityResultDispatcherHolder"));
        } else if (!(activity instanceof ActivityResultDispatcherHolder)) {
            notifyResult(delegateListener, new DelegateResult(2, cls2, bundle).addDesc("caller not instanceof ActivityResultDispatcherHolder"));
        } else {
            ActivityResultDispatcher resultDispatcher = ((ActivityResultDispatcherHolder) activity).getResultDispatcher();
            if (resultDispatcher == null) {
                notifyResult(delegateListener, new DelegateResult(2, cls2, bundle).addDesc("null == observable"));
                return;
            }
            resultDispatcher.addConsumer(new ActivityResultConsumer() { // from class: com.baidu.searchbox.process.ipc.delegate.DelegateUtils.2
                @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
                public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
                    if (intent == null || !name.equals(intent.getStringExtra(DelegateDef.EXTRA_DELEGATION_NAME))) {
                        return false;
                    }
                    if (-1 != i) {
                        DelegateUtils.notifyResult(delegateListener, new DelegateResult(3, cls2, bundle).addDesc("activity resultCode = " + i));
                        return true;
                    }
                    DelegateResult delegateResult = new DelegateResult(intent.getIntExtra(DelegateDef.EXTRA_RESULT_CODE, 0), cls2, bundle, intent.getBundleExtra(DelegateDef.EXTRA_RESULT));
                    delegateResult.addDesc(intent.getStringExtra(DelegateDef.EXTRA_RESULT_DESC));
                    DelegateUtils.notifyResult(delegateListener, delegateResult);
                    return true;
                }
            });
            resultDispatcher.startActivityForResult(new Intent(activity, cls).putExtra(DelegateDef.EXTRA_DELEGATION_NAME, name).putExtra("extra_params", bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyResult(final DelegateListener delegateListener, final DelegateResult delegateResult) {
        sMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.process.ipc.delegate.DelegateUtils.3
            @Override // java.lang.Runnable
            public void run() {
                DelegateListener.this.onDelegateCallBack(delegateResult);
            }
        });
    }
}
