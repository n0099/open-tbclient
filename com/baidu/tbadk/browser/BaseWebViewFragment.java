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
    public String a;
    public String b;
    public String c;

    public BaseWebViewFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void A1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    public ShareItem q1(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4)) == null) {
            ShareItem shareItem = new ShareItem();
            if (StringUtils.isNull(this.c, true)) {
                shareItem.v = getResources().getString(R.string.obfuscated_res_0x7f0f1155);
            } else {
                shareItem.v = this.c;
            }
            shareItem.x = this.a;
            if (StringUtils.isNull(this.b, true)) {
                shareItem.w = this.a;
            } else {
                String r1 = r1(BaseWebViewActivity.SHARE_CONTENT_START, "\"");
                if (StringUtils.isNull(r1, true)) {
                    shareItem.w = this.a;
                } else {
                    shareItem.w = r1;
                }
                String r12 = r1(BaseWebViewActivity.SHARE_IMG_START, "\"");
                if (!StringUtils.isNull(r12, true)) {
                    shareItem.z = Uri.parse(r12);
                }
                String r13 = r1(BaseWebViewActivity.SHARE_URL_START, "\"");
                if (!StringUtils.isNull(r13, true)) {
                    shareItem.x = r13;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                shareItem.v = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                shareItem.x = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                shareItem.w = str3;
            }
            if (!TextUtils.isEmpty(str4)) {
                shareItem.z = Uri.parse(str4);
            }
            return shareItem;
        }
        return (ShareItem) invokeLLLL.objValue;
    }

    public final String r1(String str, String str2) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true) || (indexOf = this.b.indexOf(str)) < 0) {
                return null;
            }
            int length = indexOf + str.length();
            String str3 = this.b;
            String substring = str3.substring(length, str3.length());
            int indexOf2 = substring.indexOf(str2);
            if (indexOf2 < 0) {
                return null;
            }
            return substring.substring(0, indexOf2);
        }
        return (String) invokeLL.objValue;
    }

    public boolean s1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? w1(str, "blank") : invokeL.booleanValue;
    }

    public boolean t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? w1(this.a, BaseWebViewActivity.KEY_NO_MENU) : invokeV.booleanValue;
    }

    public boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? w1(this.a, BaseWebViewActivity.KEY_NO_NAVIGATIONBAR) : invokeV.booleanValue;
    }

    public boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? w1(this.a, BaseWebViewActivity.KEY_NO_SHARE) : invokeV.booleanValue;
    }

    public boolean w1(String str, String str2) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
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
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final String x1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? (str == null || str.startsWith("http://") || str.startsWith("https://")) ? str : "http://".concat(str) : (String) invokeL.objValue;
    }

    public void z1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (!StringUtils.isNull(str) && str.startsWith(NewUrlSchemaHelper.Jump.JUMP_TO_TBWEBVIEW)) {
                this.a = str;
            } else {
                this.a = x1(str);
            }
        }
    }
}
