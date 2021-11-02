package com.baidu.adp.plugin.proxy;

import android.content.ContentResolver;
import android.content.Context;
import android.content.IContentProvider;
import b.a.e.h.k.d;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ContentResolverProxy extends ContentResolver {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ContentResolverProxy mProxy;
    public transient /* synthetic */ FieldHolder $fh;
    public ContentResolver mContentResolver;
    public Context mContext;
    public final String mPluginAuthor;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1751804767, "Lcom/baidu/adp/plugin/proxy/ContentResolverProxy;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1751804767, "Lcom/baidu/adp/plugin/proxy/ContentResolverProxy;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentResolverProxy(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPluginAuthor = ContentProviderProxy.PROVIDER_AUTHOR;
        this.mContext = context;
        this.mContentResolver = context.getContentResolver();
    }

    public static synchronized ContentResolverProxy getContentResolver() {
        InterceptResult invokeV;
        ContentResolverProxy contentResolverProxy;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
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
        return (ContentResolverProxy) invokeV.objValue;
    }

    public IContentProvider acquireExistingProvider(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
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
        return (IContentProvider) invokeLL.objValue;
    }

    public IContentProvider acquireProvider(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
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
        return (IContentProvider) invokeLL.objValue;
    }

    public IContentProvider acquireUnstableProvider(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
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
        return (IContentProvider) invokeLL.objValue;
    }

    public boolean releaseProvider(IContentProvider iContentProvider) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iContentProvider)) == null) {
            try {
                return ((Boolean) d.a(this.mContentResolver, "releaseProvider", new Object[]{iContentProvider})).booleanValue();
            } catch (Exception e2) {
                BdLog.e(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean releaseUnstableProvider(IContentProvider iContentProvider) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iContentProvider)) == null) {
            try {
                return ((Boolean) d.a(this.mContentResolver, "releaseUnstableProvider", new Object[]{iContentProvider})).booleanValue();
            } catch (Exception e2) {
                BdLog.e(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void unstableProviderDied(IContentProvider iContentProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iContentProvider) == null) {
            try {
                d.a(this.mContentResolver, "unstableProviderDied", new Object[]{iContentProvider});
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }
}
