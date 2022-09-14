package com.baidu.android.util.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class WrappedClipboardManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @TargetApi(11)
    /* loaded from: classes.dex */
    public static class HoneycombClipboardManager extends WrappedClipboardManager {
        public static /* synthetic */ Interceptable $ic;
        public static ClipData sClipData;
        public static ClipboardManager sInstance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-478546449, "Lcom/baidu/android/util/android/WrappedClipboardManager$HoneycombClipboardManager;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-478546449, "Lcom/baidu/android/util/android/WrappedClipboardManager$HoneycombClipboardManager;");
            }
        }

        @SuppressLint({"ServiceCast"})
        public HoneycombClipboardManager() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            sInstance = (ClipboardManager) AppRuntime.getAppContext().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
        }

        @Override // com.baidu.android.util.android.WrappedClipboardManager
        public CharSequence getText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    sClipData = sInstance.getPrimaryClip();
                } catch (Exception unused) {
                }
                ClipData clipData = sClipData;
                return (clipData == null || clipData.getItemCount() <= 0) ? "" : sClipData.getItemAt(0).getText();
            }
            return (CharSequence) invokeV.objValue;
        }

        @Override // com.baidu.android.util.android.WrappedClipboardManager
        public boolean hasText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? sInstance.hasPrimaryClip() : invokeV.booleanValue;
        }

        @Override // com.baidu.android.util.android.WrappedClipboardManager
        public void setText(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence) == null) {
                ClipData newPlainText = ClipData.newPlainText("text/plain", charSequence);
                sClipData = newPlainText;
                try {
                    sInstance.setPrimaryClip(newPlainText);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public WrappedClipboardManager() {
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

    public static WrappedClipboardManager newInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? new HoneycombClipboardManager() : (WrappedClipboardManager) invokeL.objValue;
    }

    public abstract CharSequence getText();

    public abstract boolean hasText();

    public abstract void setText(CharSequence charSequence);
}
