package com.baidu.megapp.ma;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MABottomToolBar {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CommonMenuType mCommonMenuType;
    public CommonToolBarType mCommonToolBarType;
    public OnCommonToolBarClickListener mOnCommonToolBarClickListener;
    public OnCommonToolBarItemClickListener mOnCommonToolBarItemClickListener;
    public OnCommonToolMenuClickListener mOnCommonToolMenuClickListener;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Deprecated
    /* loaded from: classes4.dex */
    public static final class CommonMenuType {
        public static final /* synthetic */ CommonMenuType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CommonMenuType MENU_STYLE_AD_IMMERSIVE_LANDING_PAGE;
        public static final CommonMenuType MENU_STYLE_NO;
        public static final CommonMenuType MENU_STYLE_NS_H5;
        public static final CommonMenuType MENU_STYLE_NS_NA;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-911198557, "Lcom/baidu/megapp/ma/MABottomToolBar$CommonMenuType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-911198557, "Lcom/baidu/megapp/ma/MABottomToolBar$CommonMenuType;");
                    return;
                }
            }
            MENU_STYLE_NO = new CommonMenuType("MENU_STYLE_NO", 0);
            MENU_STYLE_NS_NA = new CommonMenuType("MENU_STYLE_NS_NA", 1);
            MENU_STYLE_NS_H5 = new CommonMenuType("MENU_STYLE_NS_H5", 2);
            CommonMenuType commonMenuType = new CommonMenuType("MENU_STYLE_AD_IMMERSIVE_LANDING_PAGE", 3);
            MENU_STYLE_AD_IMMERSIVE_LANDING_PAGE = commonMenuType;
            $VALUES = new CommonMenuType[]{MENU_STYLE_NO, MENU_STYLE_NS_NA, MENU_STYLE_NS_H5, commonMenuType};
        }

        public CommonMenuType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CommonMenuType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CommonMenuType) Enum.valueOf(CommonMenuType.class, str) : (CommonMenuType) invokeL.objValue;
        }

        public static CommonMenuType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CommonMenuType[]) $VALUES.clone() : (CommonMenuType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class CommonToolBarType {
        public static final /* synthetic */ CommonToolBarType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CommonToolBarType TOOL_BAR_STYLE_AD_IMMERSIVE_LANDING_PAGE;
        public static final CommonToolBarType TOOL_BAR_STYLE_NEWS;
        public static final CommonToolBarType TOOL_BAR_STYLE_NO;
        public static final CommonToolBarType TOOL_BAR_STYLE_NS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(889158021, "Lcom/baidu/megapp/ma/MABottomToolBar$CommonToolBarType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(889158021, "Lcom/baidu/megapp/ma/MABottomToolBar$CommonToolBarType;");
                    return;
                }
            }
            TOOL_BAR_STYLE_NO = new CommonToolBarType("TOOL_BAR_STYLE_NO", 0);
            TOOL_BAR_STYLE_NS = new CommonToolBarType("TOOL_BAR_STYLE_NS", 1);
            TOOL_BAR_STYLE_NEWS = new CommonToolBarType("TOOL_BAR_STYLE_NEWS", 2);
            CommonToolBarType commonToolBarType = new CommonToolBarType("TOOL_BAR_STYLE_AD_IMMERSIVE_LANDING_PAGE", 3);
            TOOL_BAR_STYLE_AD_IMMERSIVE_LANDING_PAGE = commonToolBarType;
            $VALUES = new CommonToolBarType[]{TOOL_BAR_STYLE_NO, TOOL_BAR_STYLE_NS, TOOL_BAR_STYLE_NEWS, commonToolBarType};
        }

        public CommonToolBarType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CommonToolBarType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CommonToolBarType) Enum.valueOf(CommonToolBarType.class, str) : (CommonToolBarType) invokeL.objValue;
        }

        public static CommonToolBarType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CommonToolBarType[]) $VALUES.clone() : (CommonToolBarType[]) invokeV.objValue;
        }
    }

    @Deprecated
    /* loaded from: classes4.dex */
    public interface OnCommonToolBarClickListener {
        void onBackClick();
    }

    /* loaded from: classes4.dex */
    public interface OnCommonToolBarItemClickListener {
        public static final int TOOL_ITEM_BACK = 1;
        public static final int TOOL_ITEM_SHARE = 2;

        boolean onItemClick(int i);
    }

    @Deprecated
    /* loaded from: classes4.dex */
    public interface OnCommonToolMenuClickListener {
        void onRefreshClick();

        void onShareClick();
    }

    public MABottomToolBar() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCommonToolBarType = CommonToolBarType.TOOL_BAR_STYLE_NO;
        this.mCommonMenuType = CommonMenuType.MENU_STYLE_NO;
        this.mOnCommonToolBarClickListener = null;
        this.mOnCommonToolMenuClickListener = null;
        this.mOnCommonToolBarItemClickListener = null;
    }

    @Deprecated
    public OnCommonToolMenuClickListener getOnCommonToolMenuClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mOnCommonToolMenuClickListener : (OnCommonToolMenuClickListener) invokeV.objValue;
    }

    @Deprecated
    public OnCommonToolBarClickListener getOnToolBarClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mOnCommonToolBarClickListener : (OnCommonToolBarClickListener) invokeV.objValue;
    }

    public OnCommonToolBarItemClickListener getOnToolBarItemClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mOnCommonToolBarItemClickListener : (OnCommonToolBarItemClickListener) invokeV.objValue;
    }

    @Deprecated
    public CommonMenuType getToolBarMenuStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCommonMenuType : (CommonMenuType) invokeV.objValue;
    }

    public CommonToolBarType getToolBarStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mCommonToolBarType : (CommonToolBarType) invokeV.objValue;
    }

    @Deprecated
    public void setOnCommonToolMenuClickListener(OnCommonToolMenuClickListener onCommonToolMenuClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onCommonToolMenuClickListener) == null) {
            this.mOnCommonToolMenuClickListener = onCommonToolMenuClickListener;
        }
    }

    @Deprecated
    public void setOnToolBarClickListener(OnCommonToolBarClickListener onCommonToolBarClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onCommonToolBarClickListener) == null) {
            this.mOnCommonToolBarClickListener = onCommonToolBarClickListener;
        }
    }

    public void setOnToolBarItemClickListener(OnCommonToolBarItemClickListener onCommonToolBarItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onCommonToolBarItemClickListener) == null) {
            this.mOnCommonToolBarItemClickListener = onCommonToolBarItemClickListener;
        }
    }

    @Deprecated
    public void setToolBarMenuStyle(CommonMenuType commonMenuType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, commonMenuType) == null) {
            this.mCommonMenuType = commonMenuType;
        }
    }

    public void setToolBarStyle(CommonToolBarType commonToolBarType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, commonToolBarType) == null) {
            this.mCommonToolBarType = commonToolBarType;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("mCommonToolBarType = " + this.mCommonToolBarType + "\n");
            sb.append("mCommonMenuType = " + this.mCommonMenuType + "\n");
            sb.append("mOnCommonToolBarClickListener = " + this.mOnCommonToolBarClickListener + "\n");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("mOnCommonToolMenuClickListener = ");
            sb2.append(this.mOnCommonToolMenuClickListener);
            sb.append(sb2.toString());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
