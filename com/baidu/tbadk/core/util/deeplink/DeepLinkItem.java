package com.baidu.tbadk.core.util.deeplink;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class DeepLinkItem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEEPLINK_APPURL_KEY = "appUrl";
    public static final String DEEPLINK_EXT = "ext";
    public static final String DEEPLINK_IS_DESIGNATE_PKG = "isDesignatePkg";
    public static final String DEEPLINK_MARKETURL_KEY = "marketUrl";
    public static final String DEEPLINK_MARKET_PKGNAME_KEY = "marketPkgName";
    public static final String DEEPLINK_PKGNAME_KEY = "pkgName";
    public static final String DEEPLINK_WEBURL_KEY = "webUrl";
    public transient /* synthetic */ FieldHolder $fh;
    public String appUrl;
    public String ext;
    public boolean isDesignatePkg;
    public String marketPkgName;
    public String marketUrl;
    public String pkgName;
    public String webUrl;

    public DeepLinkItem(UriBuilder uriBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uriBuilder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isDesignatePkg = true;
        if (uriBuilder == null) {
            return;
        }
        parserBundle(uriBuilder.getParams());
        if (TextUtils.isEmpty(this.appUrl) && TextUtils.isEmpty(this.webUrl)) {
            parserUri(uriBuilder.getUri());
        }
    }

    private DeepLinkItem parserBundle(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, bundle)) == null) {
            if (bundle == null) {
                return this;
            }
            this.appUrl = bundle.getString("appUrl");
            this.marketUrl = bundle.getString(DEEPLINK_MARKETURL_KEY);
            this.webUrl = bundle.getString("webUrl");
            this.pkgName = bundle.getString("pkgName");
            this.marketPkgName = bundle.getString(DEEPLINK_MARKET_PKGNAME_KEY);
            this.isDesignatePkg = bundle.getBoolean(DEEPLINK_MARKET_PKGNAME_KEY, true);
            this.ext = bundle.getString("ext");
            return this;
        }
        return (DeepLinkItem) invokeL.objValue;
    }

    private DeepLinkItem parserUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, uri)) == null) {
            if (uri == null) {
                return this;
            }
            this.appUrl = uri.getQueryParameter("appUrl");
            this.webUrl = uri.getQueryParameter("webUrl");
            this.pkgName = uri.getQueryParameter("pkgName");
            this.marketUrl = uri.getQueryParameter(DEEPLINK_MARKETURL_KEY);
            this.marketPkgName = uri.getQueryParameter(DEEPLINK_MARKET_PKGNAME_KEY);
            this.isDesignatePkg = uri.getBooleanQueryParameter(DEEPLINK_IS_DESIGNATE_PKG, true);
            this.ext = uri.getQueryParameter("ext");
            return this;
        }
        return (DeepLinkItem) invokeL.objValue;
    }
}
