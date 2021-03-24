package com.baidu.adp.plugin.proxy;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ContentProviderProxy extends ContentProvider {
    public static final String CONTENT_PROVIDER_AUTHOR = "content://com.baidu.adp.plugin.provider";
    public static final String PROVIDER_AUTHOR = "com.baidu.adp.plugin.provider";
    public static final String PROVIDER_AUTHOR_SEPARATOR = ";";
    public static final String PROVIDER_FRAGMENT_SEPARATOR = "#";
    public static ContentProviderProxy mContent;

    public static final Uri convertToContainerUri(Uri uri) {
        if (uri == null) {
            return null;
        }
        return Uri.parse("content://com.baidu.adp.plugin.provider#" + uri.toString());
    }

    public static final Uri convertToPluginUri(Uri uri) {
        String fragment;
        if (uri == null || (fragment = uri.getFragment()) == null) {
            return null;
        }
        return Uri.parse(fragment);
    }

    public static ContentProviderProxy getInstance() {
        return mContent;
    }

    public static ContentProvider queryContentProvider(String str) {
        ArrayList<Plugin> allPlugins = PluginCenter.getInstance().getAllPlugins();
        if (str != null && allPlugins != null && allPlugins.size() != 0) {
            try {
                for (Plugin plugin2 : allPlugins) {
                    ContentProvider contentProvider = plugin2.getContentProvider(str);
                    if (contentProvider != null) {
                        return contentProvider;
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        return super.applyBatch(arrayList);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        ContentProvider queryContentProvider;
        if (uri == null || (queryContentProvider = queryContentProvider(uri.getAuthority())) == null) {
            return 0;
        }
        return queryContentProvider.bulkInsert(uri, contentValuesArr);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        ContentProvider queryContentProvider;
        if (uri == null || (queryContentProvider = queryContentProvider(uri.getAuthority())) == null) {
            return 0;
        }
        return queryContentProvider.delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        ContentProvider queryContentProvider;
        if (uri == null || (queryContentProvider = queryContentProvider(uri.getAuthority())) == null) {
            return null;
        }
        return queryContentProvider.getType(uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (uri == null) {
            return null;
        }
        ContentProvider queryContentProvider = queryContentProvider(uri.getAuthority());
        return queryContentProvider == null ? uri : queryContentProvider.insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public boolean isTemporary() {
        return super.isTemporary();
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        mContent = this;
        return true;
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        return super.openAssetFile(uri, str);
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return super.openFile(uri, str);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        ContentProvider queryContentProvider;
        if (uri == null || (queryContentProvider = queryContentProvider(uri.getAuthority())) == null) {
            return null;
        }
        return queryContentProvider.query(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        ContentProvider queryContentProvider;
        if (uri == null || (queryContentProvider = queryContentProvider(uri.getAuthority())) == null) {
            return 0;
        }
        return queryContentProvider.update(uri, contentValues, str, strArr);
    }
}
