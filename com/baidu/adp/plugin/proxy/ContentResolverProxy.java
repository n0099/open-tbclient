package com.baidu.adp.plugin.proxy;

import android.content.ContentResolver;
import android.content.Context;
import android.content.IContentProvider;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import d.b.c.h.k.d;
/* loaded from: classes.dex */
public class ContentResolverProxy extends ContentResolver {
    public static volatile ContentResolverProxy mProxy;
    public ContentResolver mContentResolver;
    public Context mContext;
    public final String mPluginAuthor;

    public ContentResolverProxy(Context context) {
        super(context);
        this.mPluginAuthor = ContentProviderProxy.PROVIDER_AUTHOR;
        this.mContext = context;
        this.mContentResolver = context.getContentResolver();
    }

    public static synchronized ContentResolverProxy getContentResolver() {
        ContentResolverProxy contentResolverProxy;
        synchronized (ContentResolverProxy.class) {
            if (mProxy == null) {
                synchronized (ContentResolverProxy.class) {
                    if (mProxy == null) {
                        mProxy = new ContentResolverProxy(BdBaseApplication.getInst().getBaseContext());
                    }
                }
            }
            contentResolverProxy = mProxy;
        }
        return contentResolverProxy;
    }

    public IContentProvider acquireExistingProvider(Context context, String str) {
        try {
            if (ContentProviderProxy.queryContentProvider(str) != null) {
                str = ContentProviderProxy.PROVIDER_AUTHOR;
            }
            return (IContentProvider) d.a(this.mContentResolver, "acquireExistingProvider", new Object[]{context, str});
        } catch (Exception e2) {
            BdLog.e(e2);
            return null;
        }
    }

    public IContentProvider acquireProvider(Context context, String str) {
        try {
            if (ContentProviderProxy.queryContentProvider(str) != null) {
                str = ContentProviderProxy.PROVIDER_AUTHOR;
            }
            return (IContentProvider) d.a(this.mContentResolver, "acquireProvider", new Object[]{context, str});
        } catch (Exception e2) {
            BdLog.e(e2);
            return null;
        }
    }

    public IContentProvider acquireUnstableProvider(Context context, String str) {
        if (ContentProviderProxy.queryContentProvider(str) != null) {
            str = ContentProviderProxy.PROVIDER_AUTHOR;
        }
        try {
            return (IContentProvider) d.a(this.mContentResolver, "acquireUnstableProvider", new Object[]{context, str});
        } catch (Exception e2) {
            BdLog.e(e2);
            return null;
        }
    }

    public boolean releaseProvider(IContentProvider iContentProvider) {
        try {
            return ((Boolean) d.a(this.mContentResolver, "releaseProvider", new Object[]{iContentProvider})).booleanValue();
        } catch (Exception e2) {
            BdLog.e(e2);
            return false;
        }
    }

    public boolean releaseUnstableProvider(IContentProvider iContentProvider) {
        try {
            return ((Boolean) d.a(this.mContentResolver, "releaseUnstableProvider", new Object[]{iContentProvider})).booleanValue();
        } catch (Exception e2) {
            BdLog.e(e2);
            return false;
        }
    }

    public void unstableProviderDied(IContentProvider iContentProvider) {
        try {
            d.a(this.mContentResolver, "unstableProviderDied", new Object[]{iContentProvider});
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }
}
