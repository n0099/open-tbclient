package com.baidu.tbadk.core.util.schemeaction.deeplink;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.schemeaction.UriBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
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

    public DeepLinkItem(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isDesignatePkg = true;
        this.appUrl = str2;
        this.webUrl = str;
        this.pkgName = str3;
        this.ext = str4;
        this.isDesignatePkg = false;
    }

    private void checkDesignatePkg() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || TextUtils.isEmpty(this.appUrl)) {
            return;
        }
        if (this.appUrl.startsWith("tiebaapp") || this.appUrl.startsWith("com.baidu.tieba") || this.appUrl.startsWith("tieba") || this.appUrl.startsWith("tiebaclient") || this.appUrl.startsWith("tieba.baidu.com") || this.appUrl.startsWith("bdtiebalive")) {
            this.isDesignatePkg = false;
        }
    }

    private DeepLinkItem parserBundle(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, bundle)) == null) {
            if (bundle == null) {
                return this;
            }
            this.appUrl = bundle.getString(DEEPLINK_APPURL_KEY);
            this.marketUrl = bundle.getString(DEEPLINK_MARKETURL_KEY);
            this.webUrl = bundle.getString(DEEPLINK_WEBURL_KEY);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, uri)) == null) {
            if (uri == null) {
                return this;
            }
            this.appUrl = uri.getQueryParameter(DEEPLINK_APPURL_KEY);
            this.webUrl = uri.getQueryParameter(DEEPLINK_WEBURL_KEY);
            this.pkgName = uri.getQueryParameter("pkgName");
            this.marketUrl = uri.getQueryParameter(DEEPLINK_MARKETURL_KEY);
            this.marketPkgName = uri.getQueryParameter(DEEPLINK_MARKET_PKGNAME_KEY);
            this.isDesignatePkg = uri.getBooleanQueryParameter(DEEPLINK_IS_DESIGNATE_PKG, true);
            this.ext = uri.getQueryParameter("ext");
            return this;
        }
        return (DeepLinkItem) invokeL.objValue;
    }

    public DeepLinkItem(UriBuilder uriBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uriBuilder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isDesignatePkg = true;
        if (uriBuilder == null) {
            return;
        }
        parserBundle(uriBuilder.getParamsObject());
        if (TextUtils.isEmpty(this.appUrl) && TextUtils.isEmpty(this.webUrl)) {
            parserUri(uriBuilder.getUri());
        }
        checkDesignatePkg();
    }
}
