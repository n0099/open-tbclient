package com.baidu.searchbox.crius.ui;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.ui.indicator.CriusUIIndicatorView;
import com.baidu.searchbox.crius.ui.swiper.CriusUISwiperView;
import com.baidu.searchbox.crius.ui.view.CriusUILayout;
import com.baidu.searchbox.crius.ui.view.CriusUIRelativeLayout;
import com.baidu.searchbox.crius.ui.view.CriusUIVirtualLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CriusUIFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CriusUIFactory() {
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

    public static CriusUI create(Context context, CriusData criusData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, criusData)) == null) {
            if (!TextUtils.isEmpty(criusData.component)) {
                return new CriusUIComponent(context, criusData);
            }
            String str = criusData.type;
            char c = 65535;
            switch (str.hashCode()) {
                case -889477000:
                    if (str.equals(NativeConstants.TYPE_SWIPER)) {
                        c = 5;
                        break;
                    }
                    break;
                case -712446937:
                    if (str.equals(NativeConstants.TYPE_VIRTUAL_VIEW)) {
                        c = 1;
                        break;
                    }
                    break;
                case -711999985:
                    if (str.equals(NativeConstants.TYPE_INDICATOR)) {
                        c = 6;
                        break;
                    }
                    break;
                case 102340:
                    if (str.equals(NativeConstants.TYPE_GIF)) {
                        c = 7;
                        break;
                    }
                    break;
                case 3556653:
                    if (str.equals("text")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3619493:
                    if (str.equals(NativeConstants.TYPE_VIEW)) {
                        c = 0;
                        break;
                    }
                    break;
                case 100313435:
                    if (str.equals("image")) {
                        c = 3;
                        break;
                    }
                    break;
                case 112202875:
                    if (str.equals("video")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return new CriusUILayout(context, criusData);
                case 1:
                    return new CriusUIVirtualLayout(context, criusData);
                case 2:
                    return new CriusUITextView(context, criusData);
                case 3:
                    return new CriusUIImageView(context, criusData);
                case 4:
                    return new CriusUIVideoView(context, criusData);
                case 5:
                    return new CriusUISwiperView(context, criusData);
                case 6:
                    return new CriusUIIndicatorView(context, criusData);
                case 7:
                    return new CriusUIGifImage(context, criusData);
                default:
                    return new CriusUIRelativeLayout(context, criusData);
            }
        }
        return (CriusUI) invokeLL.objValue;
    }
}
