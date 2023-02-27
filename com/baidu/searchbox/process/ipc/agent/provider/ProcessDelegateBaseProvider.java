package com.baidu.searchbox.process.ipc.agent.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.process.ipc.agent.Agent;
import com.baidu.searchbox.process.ipc.delegate.DelegateDef;
import com.baidu.searchbox.process.ipc.delegate.Delegation;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
public class ProcessDelegateBaseProvider extends ContentProvider implements Agent, DelegateDef {
    public static final boolean DEBUG = false;
    public static final String TAG = "DelegateBaseProvider";

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // com.baidu.searchbox.process.ipc.agent.Agent
    public void exit() {
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    private ProviderDelegation createDelegation(String str) {
        Class<?> cls;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
        }
        if (cls == null) {
            return null;
        }
        int modifiers = cls.getModifiers();
        if (Delegation.class.isAssignableFrom(cls) && !cls.isInterface() && !Modifier.isAbstract(modifiers)) {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            Object newInstance = declaredConstructor.newInstance(new Object[0]);
            if (!(newInstance instanceof ProviderDelegation)) {
                return null;
            }
            return (ProviderDelegation) newInstance;
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        Bundle bundle2 = new Bundle();
        ProviderDelegation createDelegation = createDelegation(str);
        if (createDelegation == null) {
            setResultBundleData(bundle2, 2, null);
            return bundle2;
        }
        createDelegation.setAgent(this);
        if (bundle != null) {
            createDelegation.mParams.putAll(bundle);
        }
        setResultBundleData(bundle2, 0, createDelegation.execCall(createDelegation.mParams));
        return bundle2;
    }

    public void setResultBundleData(Bundle bundle, int i, Bundle bundle2) {
        bundle.putInt(DelegateDef.EXTRA_RESULT_CODE, i);
        bundle.putBundle(DelegateDef.EXTRA_RESULT, bundle2);
    }
}
