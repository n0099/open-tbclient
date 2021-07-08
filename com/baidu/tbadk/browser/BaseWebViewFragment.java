package com.baidu.tbadk.browser;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes3.dex */
public class BaseWebViewFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f12132e;

    /* renamed from: f  reason: collision with root package name */
    public String f12133f;

    /* renamed from: g  reason: collision with root package name */
    public String f12134g;

    public BaseWebViewFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public ShareItem H0(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, str3, str4)) == null) {
            ShareItem shareItem = new ShareItem();
            if (StringUtils.isNull(this.f12134g, true)) {
                shareItem.r = getResources().getString(R.string.share_from_tieba);
            } else {
                shareItem.r = this.f12134g;
            }
            shareItem.t = this.f12132e;
            if (StringUtils.isNull(this.f12133f, true)) {
                shareItem.s = this.f12132e;
            } else {
                String I0 = I0("<meta name=\"description\" content=\"", "\"");
                if (StringUtils.isNull(I0, true)) {
                    shareItem.s = this.f12132e;
                } else {
                    shareItem.s = I0;
                }
                String I02 = I0("<img src=\"", "\"");
                if (!StringUtils.isNull(I02, true)) {
                    shareItem.v = Uri.parse(I02);
                }
                String I03 = I0("<meta name=\"shareurl\" content=\"", "\"");
                if (!StringUtils.isNull(I03, true)) {
                    shareItem.t = I03;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                shareItem.r = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                shareItem.t = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                shareItem.s = str3;
            }
            if (!TextUtils.isEmpty(str4)) {
                shareItem.v = Uri.parse(str4);
            }
            return shareItem;
        }
        return (ShareItem) invokeLLLL.objValue;
    }

    public final String I0(String str, String str2) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true) || (indexOf = this.f12133f.indexOf(str)) < 0) {
                return null;
            }
            int length = indexOf + str.length();
            String str3 = this.f12133f;
            String substring = str3.substring(length, str3.length());
            int indexOf2 = substring.indexOf(str2);
            if (indexOf2 < 0) {
                return null;
            }
            return substring.substring(0, indexOf2);
        }
        return (String) invokeLL.objValue;
    }

    public boolean J0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? N0(str, "blank") : invokeL.booleanValue;
    }

    public boolean K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? N0(this.f12132e, "nomenu") : invokeV.booleanValue;
    }

    public boolean L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? N0(this.f12132e, "nonavigationbar") : invokeV.booleanValue;
    }

    public boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? N0(this.f12132e, "noshare") : invokeV.booleanValue;
    }

    public boolean N0(String str, String str2) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                try {
                    String query = new URL(str).getQuery();
                    if (StringUtils.isNull(query) || (split = query.split("&")) == null) {
                        return true;
                    }
                    for (String str3 : split) {
                        String[] split2 = str3.split("=");
                        if (split2 != null && split2.length == 2) {
                            String str4 = split2[0];
                            String str5 = split2[1];
                            if (str2.equalsIgnoreCase(str4) && "1".equalsIgnoreCase(str5)) {
                                return false;
                            }
                        }
                    }
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final String O0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? (str == null || str.startsWith("http://") || str.startsWith("https://")) ? str : "http://".concat(str) : (String) invokeL.objValue;
    }

    public void P0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (!StringUtils.isNull(str) && str.startsWith(NewUrlSchemaHelper.Jump.JUMP_TO_TBWEBVIEW)) {
                this.f12132e = str;
            } else {
                this.f12132e = O0(str);
            }
        }
    }

    public void Q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f12134g = str;
        }
    }
}
