package com.baidu.adp.plugin.proxy;

import android.content.ContentResolver;
import android.content.Context;
import android.content.IContentProvider;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.util.f;
/* loaded from: classes.dex */
public class ContentResolverProxy extends ContentResolver {
    private static volatile ContentResolverProxy mProxy = null;
    private ContentResolver mContentResolver;
    private Context mContext;
    private final String mPluginAuthor;

    private ContentResolverProxy(Context context) {
        super(context);
        this.mPluginAuthor = ContentProviderProxy.PROVIDER_AUTHOR;
        this.mContext = context;
        this.mContentResolver = this.mContext.getContentResolver();
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

    protected IContentProvider acquireProvider(Context context, String str) {
        try {
            if (ContentProviderProxy.queryContentProvider(str) != null) {
                str = ContentProviderProxy.PROVIDER_AUTHOR;
            }
            return (IContentProvider) f.a(this.mContentResolver, "acquireProvider", new Object[]{context, str});
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    protected IContentProvider acquireExistingProvider(Context context, String str) {
        try {
            if (ContentProviderProxy.queryContentProvider(str) != null) {
                str = ContentProviderProxy.PROVIDER_AUTHOR;
            }
            return (IContentProvider) f.a(this.mContentResolver, "acquireExistingProvider", new Object[]{context, str});
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public boolean releaseProvider(IContentProvider iContentProvider) {
        try {
            return ((Boolean) f.a(this.mContentResolver, "releaseProvider", new Object[]{iContentProvider})).booleanValue();
        } catch (Exception e) {
            BdLog.e(e);
            return false;
        }
    }

    protected IContentProvider acquireUnstableProvider(Context context, String str) {
        if (ContentProviderProxy.queryContentProvider(str) != null) {
            str = ContentProviderProxy.PROVIDER_AUTHOR;
        }
        try {
            return (IContentProvider) f.a(this.mContentResolver, "acquireUnstableProvider", new Object[]{context, str});
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public boolean releaseUnstableProvider(IContentProvider iContentProvider) {
        try {
            return ((Boolean) f.a(this.mContentResolver, "releaseUnstableProvider", new Object[]{iContentProvider})).booleanValue();
        } catch (Exception e) {
            BdLog.e(e);
            return false;
        }
    }

    public void unstableProviderDied(IContentProvider iContentProvider) {
        try {
            f.a(this.mContentResolver, "unstableProviderDied", new Object[]{iContentProvider});
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
