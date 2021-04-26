package com.baidu.nps.stub.component;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.utils.ContextHolder;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class NPSProvider extends ContentProvider {
    public ContentProvider mProviderImpl = null;

    private synchronized boolean bindProviderImpl(Bundle bundle) {
        if (this.mProviderImpl != null) {
            return true;
        }
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString("pkg");
        String string2 = bundle.getString(com.baidu.nps.main.manager.Bundle.EXTRA_KEY_CLAZZ);
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            ContentProvider instantiateProvider = NPSManager.getInstance().instantiateProvider(string, string2);
            if (instantiateProvider == null) {
                return false;
            }
            try {
                ProviderInfo providerInfo = getContext().getPackageManager().getProviderInfo(new ComponentName(getContext().getPackageName(), getClass().getName()), 0);
                if (providerInfo == null) {
                    return false;
                }
                this.mProviderImpl = instantiateProvider;
                instantiateProvider.attachInfo(ContextHolder.getApplicationContext(), providerInfo);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        return false;
    }

    @Override // android.content.ContentProvider
    @TargetApi(29)
    public ContentProviderResult[] applyBatch(String str, ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.applyBatch(str, arrayList);
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return -1;
        }
        return contentProvider.bulkInsert(uri, contentValuesArr);
    }

    @Override // android.content.ContentProvider
    @TargetApi(29)
    public Bundle call(String str, String str2, String str3, Bundle bundle) {
        if (str2.equals(com.baidu.nps.main.manager.Bundle.METHOD_VALUE_BIND_PROVIDER)) {
            bindProviderImpl(bundle);
            return null;
        }
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.call(str, str2, str3, bundle);
    }

    @Override // android.content.ContentProvider
    public Uri canonicalize(Uri uri) {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.canonicalize(uri);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return 0;
        }
        return contentProvider.delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            super.dump(fileDescriptor, printWriter, strArr);
        } else {
            contentProvider.dump(fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.content.ContentProvider
    public String[] getStreamTypes(Uri uri, String str) {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.getStreamTypes(uri, str);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.getType(uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider != null) {
            contentProvider.onConfigurationChanged(configuration);
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider != null) {
            contentProvider.onLowMemory();
        }
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider != null) {
            contentProvider.onTrimMemory(i2);
        }
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.openAssetFile(uri, str);
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.openFile(uri, str);
    }

    @Override // android.content.ContentProvider
    public <T> ParcelFileDescriptor openPipeHelper(Uri uri, String str, Bundle bundle, T t, ContentProvider.PipeDataWriter<T> pipeDataWriter) throws FileNotFoundException {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.openPipeHelper(uri, str, bundle, t, pipeDataWriter);
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle) throws FileNotFoundException {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.openTypedAssetFile(uri, str, bundle);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.query(uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    @TargetApi(26)
    public boolean refresh(Uri uri, Bundle bundle, CancellationSignal cancellationSignal) {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return false;
        }
        return contentProvider.refresh(uri, bundle, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    public void shutdown() {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            super.shutdown();
        } else {
            contentProvider.shutdown();
        }
    }

    @Override // android.content.ContentProvider
    public Uri uncanonicalize(Uri uri) {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.uncanonicalize(uri);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return 0;
        }
        return contentProvider.update(uri, contentValues, str, strArr);
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.applyBatch(arrayList);
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.openAssetFile(uri, str, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.openFile(uri, str, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.openTypedAssetFile(uri, str, bundle, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    @TargetApi(26)
    public Cursor query(Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.query(uri, strArr, bundle, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        if (str.equals(com.baidu.nps.main.manager.Bundle.METHOD_VALUE_BIND_PROVIDER)) {
            bindProviderImpl(bundle);
            return null;
        }
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.call(str, str2, bundle);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        ContentProvider contentProvider = this.mProviderImpl;
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.query(uri, strArr, str, strArr2, str2);
    }
}
