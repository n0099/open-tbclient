package com.baidu.mobads.sdk.api;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class StyleParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBrandBottomDp;
    public int mBrandFontColor;
    public int mBrandFontSizeSp;
    public Typeface mBrandFontTypeFace;
    public int mBrandLeftDp;
    public int mBrandRightDp;
    public int mButtonBackgroundColor;
    public int mButtonBottomDp;
    public int mButtonFontColor;
    public int mButtonFontSizeSp;
    public Typeface mButtonFontTypeFace;
    public int mButtonForegroundColor;
    public int mButtonHeightDp;
    public int mButtonLeftDp;
    public int mButtonRightDp;
    public int mButtonTopDp;
    public int mButtonWidthDp;
    public int mDislikeBottomDp;
    public int mDislikeLeftDp;
    public int mDislikeRightDp;
    public int mDislikeTopDp;
    public int mFirstPicBottomDp;
    public int mFirstPicHeightDp;
    public int mFirstPicLeftDp;
    public int mFirstPicRightDp;
    public int mFirstPicTopDp;
    public int mFirstPicWidthDp;
    public int mIconBottomDp;
    public int mIconHeightDp;
    public int mIconLeftDp;
    public int mIconRightDp;
    public int mIconTopDp;
    public int mIconWidthDp;
    public Drawable mImageBackground;
    public int mImageBackgroundColor;
    public boolean mIsRegionClick;
    public boolean mIsShowActionButton;
    public boolean mIsShowDialog;
    public boolean mIsShowDownloadInfo;
    public int mSmartDownloadAppNameBottomDp;
    public int mSmartDownloadAppNameLeftDp;
    public int mSmartDownloadAppNameRightDp;
    public int mSmartDownloadAppNameTextColor;
    public int mSmartDownloadAppNameTextSizeSp;
    public int mSmartDownloadAppNameTopDp;
    public int mSmartDownloadButtonBackgroundColor;
    public int mSmartDownloadButtonBottomDp;
    public int mSmartDownloadButtonFontColor;
    public int mSmartDownloadButtonFontSizeSp;
    public Typeface mSmartDownloadButtonFontTypeFace;
    public int mSmartDownloadButtonForegroundColor;
    public int mSmartDownloadButtonHeightDp;
    public int mSmartDownloadButtonLeftDp;
    public int mSmartDownloadButtonRightDp;
    public int mSmartDownloadButtonTopDp;
    public int mSmartDownloadButtonWidthDp;
    public int mSmartDownloadCompanyBottomDp;
    public int mSmartDownloadCompanyLeftDp;
    public int mSmartDownloadCompanyRightDp;
    public int mSmartDownloadCompanyTextColor;
    public int mSmartDownloadCompanyTextSizeSp;
    public int mSmartDownloadCompanyTopDp;
    public int mSmartDownloadPermissionBottomDp;
    public int mSmartDownloadPermissionLeftDp;
    public int mSmartDownloadPermissionRightDp;
    public int mSmartDownloadPermissionTextColor;
    public int mSmartDownloadPermissionTextSizeSp;
    public int mSmartDownloadPermissionTopDp;
    public int mSmartDownloadPrivacyBottomDp;
    public int mSmartDownloadPrivacyLeftDp;
    public int mSmartDownloadPrivacyRightDp;
    public int mSmartDownloadPrivacyTextColor;
    public int mSmartDownloadPrivacyTextSizeSp;
    public int mSmartDownloadPrivacyTopDp;
    public int mSmartDownloadVersionBottomDp;
    public int mSmartDownloadVersionLeftDp;
    public int mSmartDownloadVersionRightDp;
    public int mSmartDownloadVersionTextColor;
    public int mSmartDownloadVersionTextSizeSp;
    public int mSmartDownloadVersionTopDp;
    public int mSmartDownloadViewBackgroundColor;
    public int mSmartDownloadViewBottomDp;
    public int mSmartDownloadViewLeftDp;
    public int mSmartDownloadViewRightDp;
    public int mSmartDownloadViewTopDp;
    public int mThreePicBottomDp;
    public int mThreePicHeightDp;
    public int mThreePicLeftDp;
    public int mThreePicRightDp;
    public int mThreePicTopDp;
    public int mThreePicWidthDp;
    public int mTitleBottomDp;
    public int mTitleFontColor;
    public int mTitleFontSizeSp;
    public Typeface mTitleFontTypeFace;
    public int mTitleLeftDp;
    public int mTitleRightDp;
    public int mTitleTopDp;
    public int mTwoPicBottomDp;
    public int mTwoPicHeightDp;
    public int mTwoPicLeftDp;
    public int mTwoPicRightDp;
    public int mTwoPicTopDp;
    public int mTwoPicWidthDp;
    public boolean useDislike;

    /* loaded from: classes3.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mBrandBottomDp;
        public int mBrandFontColor;
        public int mBrandFontSizeSp;
        public Typeface mBrandFontTypeFace;
        public int mBrandLeftDp;
        public int mBrandRightDp;
        public int mButtonBackgroundColor;
        public int mButtonBottomDp;
        public int mButtonFontColor;
        public int mButtonFontSizeSp;
        public Typeface mButtonFontTypeFace;
        public int mButtonForegroundColor;
        public int mButtonHeightDp;
        public int mButtonLeftDp;
        public int mButtonRightDp;
        public int mButtonTopDp;
        public int mButtonWidthDp;
        public int mDislikeBottomDp;
        public int mDislikeLeftDp;
        public int mDislikeRightDp;
        public int mDislikeTopDp;
        public int mFirstPicBottomDp;
        public int mFirstPicHeightDp;
        public int mFirstPicLeftDp;
        public int mFirstPicRightDp;
        public int mFirstPicTopDp;
        public int mFirstPicWidthDp;
        public int mIconBottomDp;
        public int mIconHeightDp;
        public int mIconLeftDp;
        public int mIconRightDp;
        public int mIconTopDp;
        public int mIconWidthDp;
        public Drawable mImageBackground;
        public int mImageBackgroundColor;
        public boolean mIsRegionClick;
        public boolean mIsShowActionButton;
        public boolean mIsShowDialog;
        public boolean mIsShowDownloadInfo;
        public int mSmartDownloadAppNameBottomDp;
        public int mSmartDownloadAppNameLeftDp;
        public int mSmartDownloadAppNameRightDp;
        public int mSmartDownloadAppNameTextColor;
        public int mSmartDownloadAppNameTextSizeSp;
        public int mSmartDownloadAppNameTopDp;
        public int mSmartDownloadButtonBackgroundColor;
        public int mSmartDownloadButtonBottomDp;
        public int mSmartDownloadButtonFontColor;
        public int mSmartDownloadButtonFontSizeSp;
        public Typeface mSmartDownloadButtonFontTypeFace;
        public int mSmartDownloadButtonForegroundColor;
        public int mSmartDownloadButtonHeightDp;
        public int mSmartDownloadButtonLeftDp;
        public int mSmartDownloadButtonRightDp;
        public int mSmartDownloadButtonTopDp;
        public int mSmartDownloadButtonWidthDp;
        public int mSmartDownloadCompanyBottomDp;
        public int mSmartDownloadCompanyLeftDp;
        public int mSmartDownloadCompanyRightDp;
        public int mSmartDownloadCompanyTextColor;
        public int mSmartDownloadCompanyTextSizeSp;
        public int mSmartDownloadCompanyTopDp;
        public int mSmartDownloadPermissionBottomDp;
        public int mSmartDownloadPermissionLeftDp;
        public int mSmartDownloadPermissionRightDp;
        public int mSmartDownloadPermissionTextColor;
        public int mSmartDownloadPermissionTextSizeSp;
        public int mSmartDownloadPermissionTopDp;
        public int mSmartDownloadPrivacyBottomDp;
        public int mSmartDownloadPrivacyLeftDp;
        public int mSmartDownloadPrivacyRightDp;
        public int mSmartDownloadPrivacyTextColor;
        public int mSmartDownloadPrivacyTextSizeSp;
        public int mSmartDownloadPrivacyTopDp;
        public int mSmartDownloadVersionBottomDp;
        public int mSmartDownloadVersionLeftDp;
        public int mSmartDownloadVersionRightDp;
        public int mSmartDownloadVersionTextColor;
        public int mSmartDownloadVersionTextSizeSp;
        public int mSmartDownloadVersionTopDp;
        public int mSmartDownloadViewBackgroundColor;
        public int mSmartDownloadViewBottomDp;
        public int mSmartDownloadViewHeightDp;
        public int mSmartDownloadViewLeftDp;
        public int mSmartDownloadViewRightDp;
        public int mSmartDownloadViewTopDp;
        public int mSmartDownloadViewWidthDp;
        public int mThreePicBottomDp;
        public int mThreePicHeightDp;
        public int mThreePicLeftDp;
        public int mThreePicRightDp;
        public int mThreePicTopDp;
        public int mThreePicWidthDp;
        public int mTitleBottomDp;
        public int mTitleFontColor;
        public int mTitleFontSizeSp;
        public Typeface mTitleFontTypeFace;
        public int mTitleLeftDp;
        public int mTitleRightDp;
        public int mTitleTopDp;
        public int mTwoPicBottomDp;
        public int mTwoPicHeightDp;
        public int mTwoPicLeftDp;
        public int mTwoPicRightDp;
        public int mTwoPicTopDp;
        public int mTwoPicWidthDp;
        public boolean useDislike;

        public Builder() {
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
            this.mIsShowDownloadInfo = true;
            this.mIsRegionClick = false;
            this.mIsShowDialog = false;
            this.mIsShowActionButton = true;
            this.mSmartDownloadViewBackgroundColor = Color.parseColor("#F5F5F5");
            this.mSmartDownloadViewWidthDp = -1;
            this.mSmartDownloadViewHeightDp = -1;
            this.mSmartDownloadViewLeftDp = -1;
            this.mSmartDownloadViewRightDp = -1;
            this.mSmartDownloadViewTopDp = -1;
            this.mSmartDownloadViewBottomDp = -1;
            this.mSmartDownloadCompanyTextSizeSp = -1;
            this.mSmartDownloadCompanyTextColor = Color.parseColor("#858585");
            this.mSmartDownloadCompanyTopDp = -1;
            this.mSmartDownloadCompanyBottomDp = -1;
            this.mSmartDownloadCompanyLeftDp = -1;
            this.mSmartDownloadCompanyRightDp = -1;
            this.mSmartDownloadVersionTextSizeSp = -1;
            this.mSmartDownloadVersionTextColor = Color.parseColor("#858585");
            this.mSmartDownloadVersionTopDp = -1;
            this.mSmartDownloadVersionBottomDp = -1;
            this.mSmartDownloadVersionLeftDp = -1;
            this.mSmartDownloadVersionRightDp = -1;
            this.mSmartDownloadPermissionTextSizeSp = -1;
            this.mSmartDownloadPermissionTextColor = Color.parseColor("#858585");
            this.mSmartDownloadPermissionTopDp = -1;
            this.mSmartDownloadPermissionBottomDp = -1;
            this.mSmartDownloadPermissionLeftDp = -1;
            this.mSmartDownloadPermissionRightDp = -1;
            this.mSmartDownloadPrivacyTextSizeSp = -1;
            this.mSmartDownloadPrivacyTextColor = Color.parseColor("#858585");
            this.mSmartDownloadPrivacyTopDp = -1;
            this.mSmartDownloadPrivacyBottomDp = -1;
            this.mSmartDownloadPrivacyLeftDp = -1;
            this.mSmartDownloadPrivacyRightDp = -1;
            this.mSmartDownloadAppNameTextSizeSp = -1;
            this.mSmartDownloadAppNameTextColor = Color.parseColor("#1F1F1F");
            this.mSmartDownloadAppNameTopDp = -1;
            this.mSmartDownloadAppNameBottomDp = -1;
            this.mSmartDownloadAppNameLeftDp = -1;
            this.mSmartDownloadAppNameRightDp = -1;
            this.mSmartDownloadButtonWidthDp = -2;
            this.mSmartDownloadButtonHeightDp = -2;
            this.mSmartDownloadButtonLeftDp = -1;
            this.mSmartDownloadButtonRightDp = -1;
            this.mSmartDownloadButtonTopDp = -1;
            this.mSmartDownloadButtonBottomDp = -1;
            this.mSmartDownloadButtonForegroundColor = Color.parseColor("#3388FF");
            this.mSmartDownloadButtonBackgroundColor = Color.parseColor("#D7E6FF");
            this.mSmartDownloadButtonFontSizeSp = -1;
            this.mSmartDownloadButtonFontColor = Color.parseColor("#F5F5F5");
            this.mSmartDownloadButtonFontTypeFace = null;
            this.mIconWidthDp = -1;
            this.mIconHeightDp = -1;
            this.mIconTopDp = -1;
            this.mIconBottomDp = -1;
            this.mIconLeftDp = -1;
            this.mIconRightDp = -1;
            this.mTitleLeftDp = -1;
            this.mTitleRightDp = -1;
            this.mTitleTopDp = -1;
            this.mTitleBottomDp = -1;
            this.mTitleFontSizeSp = -1;
            this.mTitleFontColor = Color.parseColor("#000000");
            this.mTitleFontTypeFace = null;
            this.mFirstPicWidthDp = -1;
            this.mFirstPicHeightDp = -1;
            this.mFirstPicTopDp = -1;
            this.mFirstPicBottomDp = -1;
            this.mFirstPicLeftDp = -1;
            this.mFirstPicRightDp = -1;
            this.mTwoPicWidthDp = -1;
            this.mTwoPicHeightDp = -1;
            this.mTwoPicTopDp = -1;
            this.mTwoPicBottomDp = -1;
            this.mTwoPicLeftDp = -1;
            this.mTwoPicRightDp = -1;
            this.mThreePicWidthDp = -1;
            this.mThreePicHeightDp = -1;
            this.mThreePicTopDp = -1;
            this.mThreePicBottomDp = -1;
            this.mThreePicLeftDp = -1;
            this.mThreePicRightDp = -1;
            this.mImageBackgroundColor = Color.parseColor("#F4F5F6");
            this.mImageBackground = null;
            this.mBrandLeftDp = -1;
            this.mBrandRightDp = -1;
            this.mBrandBottomDp = -1;
            this.mBrandFontSizeSp = -1;
            this.mBrandFontColor = Color.parseColor("#999999");
            this.mBrandFontTypeFace = null;
            this.mButtonWidthDp = -2;
            this.mButtonHeightDp = -2;
            this.mButtonLeftDp = -1;
            this.mButtonRightDp = -1;
            this.mButtonTopDp = -1;
            this.mButtonBottomDp = -1;
            this.mButtonForegroundColor = Color.parseColor("#3388FF");
            this.mButtonBackgroundColor = Color.parseColor("#D7E6FF");
            this.mButtonFontSizeSp = -1;
            this.mButtonFontColor = Color.parseColor("#FFFFFF");
            this.mButtonFontTypeFace = null;
            this.useDislike = true;
            this.mDislikeTopDp = -1;
            this.mDislikeBottomDp = -1;
            this.mDislikeLeftDp = -1;
            this.mDislikeRightDp = -1;
        }

        public StyleParams build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new StyleParams(this);
            }
            return (StyleParams) invokeV.objValue;
        }

        public Builder setBrandBottomDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.mBrandBottomDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setBrandFontColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.mBrandFontColor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setBrandFontSizeSp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.mBrandFontSizeSp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setBrandFontTypeFace(Typeface typeface) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, typeface)) == null) {
                this.mBrandFontTypeFace = typeface;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBrandLeftDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.mBrandLeftDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setBrandRightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.mBrandRightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setButtonBackgroundColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                this.mButtonBackgroundColor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setButtonBottomDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.mButtonBottomDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setButtonFontTypeface(Typeface typeface) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, typeface)) == null) {
                this.mButtonFontTypeFace = typeface;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setButtonForegroundColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                this.mButtonForegroundColor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setButtonHeightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
                this.mButtonHeightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setButtonLeftDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                this.mButtonLeftDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setButtonRightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
                this.mButtonRightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setButtonTextColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
                this.mButtonFontColor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setButtonTextSizeSp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
                this.mButtonFontSizeSp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setButtonTopDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
                this.mButtonTopDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setButtonWidthDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
                this.mButtonWidthDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setDislikeBottomDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
                this.mDislikeBottomDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setDislikeLeftDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
                this.mDislikeLeftDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setDislikeRightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
                this.mDislikeRightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setDislikeTopDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
                this.mDislikeTopDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setDownloadViewBackgroundColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
                this.mSmartDownloadViewBackgroundColor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setDownloadViewBottomDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
                this.mSmartDownloadViewBottomDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setDownloadViewLeftDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
                this.mSmartDownloadViewLeftDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setDownloadViewRightD(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
                this.mSmartDownloadViewRightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setDownloadViewTopDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
                this.mSmartDownloadViewTopDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setFirstPicBottomDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
                this.mFirstPicBottomDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setFirstPicHeightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
                this.mFirstPicHeightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setFirstPicLeftDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
                this.mFirstPicLeftDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setFirstPicRightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
                this.mFirstPicRightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setFirstPicTopDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i)) == null) {
                this.mFirstPicTopDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setFirstPicWidthDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) {
                this.mFirstPicWidthDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setIconBottomDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i)) == null) {
                this.mIconBottomDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setIconHeightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) {
                this.mIconHeightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setIconLeftDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
                this.mIconLeftDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setIconRightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i)) == null) {
                this.mIconRightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setIconTopDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i)) == null) {
                this.mIconTopDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setIconWidthDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i)) == null) {
                this.mIconWidthDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setImageBackground(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, drawable)) == null) {
                this.mImageBackground = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setImageBackgroundColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i)) == null) {
                this.mImageBackgroundColor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setRegionClick(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048617, this, z)) == null) {
                this.mIsRegionClick = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setShowActionButton(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048618, this, z)) == null) {
                this.mIsShowActionButton = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setShowDialogFrame(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048619, this, z)) == null) {
                this.mIsShowDialog = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setShowDownloadInfo(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048620, this, z)) == null) {
                this.mIsShowDownloadInfo = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setSmartDownloadAppNameBottomDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i)) == null) {
                this.mSmartDownloadAppNameBottomDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadAppNameLeftDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i)) == null) {
                this.mSmartDownloadAppNameLeftDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadAppNameRightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i)) == null) {
                this.mSmartDownloadAppNameRightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadAppNameTextColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i)) == null) {
                this.mSmartDownloadAppNameTextColor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadAppNameTextSizeSp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i)) == null) {
                this.mSmartDownloadAppNameTextSizeSp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadAppNameTopDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i)) == null) {
                this.mSmartDownloadAppNameTopDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadButtonBackgroundColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i)) == null) {
                this.mSmartDownloadButtonBackgroundColor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadButtonBottomDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i)) == null) {
                this.mSmartDownloadButtonBottomDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadButtonFontColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048629, this, i)) == null) {
                this.mSmartDownloadButtonFontColor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadButtonFontSizeSp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i)) == null) {
                this.mSmartDownloadButtonFontSizeSp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadButtonFontTypeFace(Typeface typeface) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, typeface)) == null) {
                this.mSmartDownloadButtonFontTypeFace = typeface;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setSmartDownloadButtonForegroundColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i)) == null) {
                this.mSmartDownloadButtonForegroundColor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadButtonHeightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i)) == null) {
                this.mSmartDownloadButtonHeightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadButtonLeftDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048634, this, i)) == null) {
                this.mSmartDownloadButtonLeftDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadButtonRightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i)) == null) {
                this.mSmartDownloadButtonRightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadButtonTopDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i)) == null) {
                this.mSmartDownloadButtonTopDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadButtonWidthDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048637, this, i)) == null) {
                this.mSmartDownloadButtonWidthDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadCompanyBottomDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048638, this, i)) == null) {
                this.mSmartDownloadCompanyBottomDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadCompanyLeftDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i)) == null) {
                this.mSmartDownloadCompanyLeftDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadCompanyRightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048640, this, i)) == null) {
                this.mSmartDownloadCompanyRightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadCompanyTextColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048641, this, i)) == null) {
                this.mSmartDownloadCompanyTextColor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadCompanyTextSizeSp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048642, this, i)) == null) {
                this.mSmartDownloadCompanyTextSizeSp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadCompanyTopDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048643, this, i)) == null) {
                this.mSmartDownloadCompanyTopDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadPermissionBottomDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048644, this, i)) == null) {
                this.mSmartDownloadPermissionBottomDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadPermissionLeftDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048645, this, i)) == null) {
                this.mSmartDownloadPermissionLeftDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadPermissionRightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048646, this, i)) == null) {
                this.mSmartDownloadPermissionRightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadPermissionTextColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048647, this, i)) == null) {
                this.mSmartDownloadPermissionTextColor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadPermissionTextSizeSp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048648, this, i)) == null) {
                this.mSmartDownloadPermissionTextSizeSp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadPermissionTopDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048649, this, i)) == null) {
                this.mSmartDownloadPermissionTopDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadPrivacyBottomDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048650, this, i)) == null) {
                this.mSmartDownloadPrivacyBottomDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadPrivacyLeftDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048651, this, i)) == null) {
                this.mSmartDownloadPrivacyLeftDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadPrivacyRightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048652, this, i)) == null) {
                this.mSmartDownloadPrivacyRightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadPrivacyTextColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048653, this, i)) == null) {
                this.mSmartDownloadPrivacyTextColor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadPrivacyTextSizeSp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i)) == null) {
                this.mSmartDownloadPrivacyTextSizeSp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadPrivacyTopDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048655, this, i)) == null) {
                this.mSmartDownloadPrivacyTopDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadVersionBottomDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048656, this, i)) == null) {
                this.mSmartDownloadVersionBottomDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadVersionLeftDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048657, this, i)) == null) {
                this.mSmartDownloadVersionLeftDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadVersionRightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048658, this, i)) == null) {
                this.mSmartDownloadVersionRightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadVersionTextColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048659, this, i)) == null) {
                this.mSmartDownloadVersionTextColor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadVersionTextSizeSp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048660, this, i)) == null) {
                this.mSmartDownloadVersionTextSizeSp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSmartDownloadVersionTopDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048661, this, i)) == null) {
                this.mSmartDownloadVersionTopDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setThreePicBottomDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048662, this, i)) == null) {
                this.mThreePicBottomDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setThreePicHeightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048663, this, i)) == null) {
                this.mThreePicHeightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setThreePicLeftDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048664, this, i)) == null) {
                this.mThreePicLeftDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setThreePicRightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048665, this, i)) == null) {
                this.mThreePicRightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setThreePicTopDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048666, this, i)) == null) {
                this.mThreePicTopDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setThreePicWidthDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048667, this, i)) == null) {
                this.mThreePicWidthDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTitleBottomDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048668, this, i)) == null) {
                this.mTitleBottomDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTitleFontColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048669, this, i)) == null) {
                this.mTitleFontColor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTitleFontSizeSp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048670, this, i)) == null) {
                this.mTitleFontSizeSp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTitleFontTypeFace(Typeface typeface) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048671, this, typeface)) == null) {
                this.mTitleFontTypeFace = typeface;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTitleLeftDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048672, this, i)) == null) {
                this.mTitleLeftDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTitleRightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048673, this, i)) == null) {
                this.mTitleRightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTitleTopDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048674, this, i)) == null) {
                this.mTitleTopDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTwoPicBottomDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048675, this, i)) == null) {
                this.mTwoPicBottomDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTwoPicHeightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048676, this, i)) == null) {
                this.mTwoPicHeightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTwoPicLeftDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048677, this, i)) == null) {
                this.mTwoPicLeftDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTwoPicRightDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048678, this, i)) == null) {
                this.mTwoPicRightDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTwoPicTopDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048679, this, i)) == null) {
                this.mTwoPicTopDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTwoPicWidthDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048680, this, i)) == null) {
                this.mTwoPicWidthDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }
    }

    public StyleParams(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.useDislike = true;
        this.mDislikeTopDp = -1;
        this.mDislikeBottomDp = -1;
        this.mDislikeLeftDp = -1;
        this.mDislikeRightDp = -1;
        this.mSmartDownloadViewTopDp = builder.mSmartDownloadViewTopDp;
        this.mSmartDownloadViewBottomDp = builder.mSmartDownloadViewBottomDp;
        this.mSmartDownloadViewLeftDp = builder.mSmartDownloadViewLeftDp;
        this.mSmartDownloadViewRightDp = builder.mSmartDownloadViewRightDp;
        this.mSmartDownloadViewBackgroundColor = builder.mSmartDownloadViewBackgroundColor;
        this.mSmartDownloadCompanyTextSizeSp = builder.mSmartDownloadCompanyTextSizeSp;
        this.mSmartDownloadCompanyTextColor = builder.mSmartDownloadCompanyTextColor;
        this.mSmartDownloadCompanyTopDp = builder.mSmartDownloadCompanyTopDp;
        this.mSmartDownloadCompanyBottomDp = builder.mSmartDownloadCompanyBottomDp;
        this.mSmartDownloadCompanyLeftDp = builder.mSmartDownloadCompanyLeftDp;
        this.mSmartDownloadCompanyRightDp = builder.mSmartDownloadCompanyRightDp;
        this.mSmartDownloadVersionTextSizeSp = builder.mSmartDownloadVersionTextSizeSp;
        this.mSmartDownloadVersionTextColor = builder.mSmartDownloadVersionTextColor;
        this.mSmartDownloadVersionTopDp = builder.mSmartDownloadVersionTopDp;
        this.mSmartDownloadVersionBottomDp = builder.mSmartDownloadVersionBottomDp;
        this.mSmartDownloadVersionLeftDp = builder.mSmartDownloadVersionLeftDp;
        this.mSmartDownloadVersionRightDp = builder.mSmartDownloadVersionRightDp;
        this.mSmartDownloadPermissionTextSizeSp = builder.mSmartDownloadPermissionTextSizeSp;
        this.mSmartDownloadPermissionTextColor = builder.mSmartDownloadPermissionTextColor;
        this.mSmartDownloadPermissionTopDp = builder.mSmartDownloadPermissionTopDp;
        this.mSmartDownloadPermissionBottomDp = builder.mSmartDownloadPermissionBottomDp;
        this.mSmartDownloadPermissionLeftDp = builder.mSmartDownloadPermissionLeftDp;
        this.mSmartDownloadPermissionRightDp = builder.mSmartDownloadPermissionRightDp;
        this.mSmartDownloadPrivacyTextSizeSp = builder.mSmartDownloadPrivacyTextSizeSp;
        this.mSmartDownloadPrivacyTextColor = builder.mSmartDownloadPrivacyTextColor;
        this.mSmartDownloadPrivacyTopDp = builder.mSmartDownloadPrivacyTopDp;
        this.mSmartDownloadPrivacyBottomDp = builder.mSmartDownloadPrivacyBottomDp;
        this.mSmartDownloadPrivacyLeftDp = builder.mSmartDownloadPrivacyLeftDp;
        this.mSmartDownloadPrivacyRightDp = builder.mSmartDownloadPrivacyRightDp;
        this.mSmartDownloadAppNameTextSizeSp = builder.mSmartDownloadAppNameTextSizeSp;
        this.mSmartDownloadAppNameTextColor = builder.mSmartDownloadAppNameTextColor;
        this.mSmartDownloadAppNameTopDp = builder.mSmartDownloadAppNameTopDp;
        this.mSmartDownloadAppNameBottomDp = builder.mSmartDownloadAppNameBottomDp;
        this.mSmartDownloadAppNameLeftDp = builder.mSmartDownloadAppNameLeftDp;
        this.mSmartDownloadAppNameRightDp = builder.mSmartDownloadAppNameRightDp;
        this.mSmartDownloadButtonWidthDp = builder.mSmartDownloadButtonWidthDp;
        this.mSmartDownloadButtonHeightDp = builder.mSmartDownloadButtonHeightDp;
        this.mSmartDownloadButtonLeftDp = builder.mSmartDownloadButtonLeftDp;
        this.mSmartDownloadButtonRightDp = builder.mSmartDownloadButtonRightDp;
        this.mSmartDownloadButtonTopDp = builder.mSmartDownloadButtonTopDp;
        this.mSmartDownloadButtonBottomDp = builder.mSmartDownloadButtonBottomDp;
        this.mSmartDownloadButtonForegroundColor = builder.mSmartDownloadButtonForegroundColor;
        this.mSmartDownloadButtonBackgroundColor = builder.mSmartDownloadButtonBackgroundColor;
        this.mSmartDownloadButtonFontSizeSp = builder.mSmartDownloadButtonFontSizeSp;
        this.mSmartDownloadButtonFontColor = builder.mSmartDownloadButtonFontColor;
        this.mSmartDownloadButtonFontTypeFace = builder.mSmartDownloadButtonFontTypeFace;
        this.mIconWidthDp = builder.mIconWidthDp;
        this.mIconHeightDp = builder.mIconHeightDp;
        this.mIconTopDp = builder.mIconTopDp;
        this.mIconBottomDp = builder.mIconBottomDp;
        this.mIconLeftDp = builder.mIconLeftDp;
        this.mIconRightDp = builder.mIconRightDp;
        this.mTitleLeftDp = builder.mTitleLeftDp;
        this.mTitleRightDp = builder.mTitleRightDp;
        this.mTitleTopDp = builder.mTitleTopDp;
        this.mTitleBottomDp = builder.mTitleBottomDp;
        this.mTitleFontSizeSp = builder.mTitleFontSizeSp;
        this.mTitleFontColor = builder.mTitleFontColor;
        this.mTitleFontTypeFace = builder.mTitleFontTypeFace;
        this.mFirstPicWidthDp = builder.mFirstPicWidthDp;
        this.mFirstPicHeightDp = builder.mFirstPicHeightDp;
        this.mFirstPicTopDp = builder.mFirstPicTopDp;
        this.mFirstPicBottomDp = builder.mFirstPicBottomDp;
        this.mFirstPicLeftDp = builder.mFirstPicLeftDp;
        this.mFirstPicRightDp = builder.mFirstPicRightDp;
        this.mTwoPicWidthDp = builder.mTwoPicWidthDp;
        this.mTwoPicHeightDp = builder.mTwoPicHeightDp;
        this.mTwoPicTopDp = builder.mTwoPicTopDp;
        this.mTwoPicBottomDp = builder.mTwoPicBottomDp;
        this.mTwoPicLeftDp = builder.mTwoPicLeftDp;
        this.mTwoPicRightDp = builder.mTwoPicRightDp;
        this.mThreePicWidthDp = builder.mThreePicWidthDp;
        this.mThreePicHeightDp = builder.mThreePicHeightDp;
        this.mThreePicTopDp = builder.mThreePicTopDp;
        this.mThreePicBottomDp = builder.mThreePicBottomDp;
        this.mThreePicLeftDp = builder.mThreePicLeftDp;
        this.mThreePicRightDp = builder.mThreePicRightDp;
        this.mImageBackground = builder.mImageBackground;
        this.mImageBackgroundColor = builder.mImageBackgroundColor;
        this.mBrandLeftDp = builder.mBrandLeftDp;
        this.mBrandRightDp = builder.mBrandRightDp;
        this.mBrandBottomDp = builder.mBrandBottomDp;
        this.mBrandFontSizeSp = builder.mBrandFontSizeSp;
        this.mBrandFontColor = builder.mBrandFontColor;
        this.mBrandFontTypeFace = builder.mBrandFontTypeFace;
        this.mButtonWidthDp = builder.mButtonWidthDp;
        this.mButtonHeightDp = builder.mButtonHeightDp;
        this.mButtonLeftDp = builder.mButtonLeftDp;
        this.mButtonRightDp = builder.mButtonRightDp;
        this.mButtonTopDp = builder.mButtonTopDp;
        this.mButtonBottomDp = builder.mButtonBottomDp;
        this.mButtonFontColor = builder.mButtonFontColor;
        this.mButtonFontSizeSp = builder.mButtonFontSizeSp;
        this.mButtonFontTypeFace = builder.mButtonFontTypeFace;
        this.mButtonForegroundColor = builder.mButtonForegroundColor;
        this.mButtonBackgroundColor = builder.mButtonBackgroundColor;
        this.mIsShowDownloadInfo = builder.mIsShowDownloadInfo;
        this.mIsShowActionButton = builder.mIsShowActionButton;
        this.mIsRegionClick = builder.mIsRegionClick;
        this.mIsShowDialog = builder.mIsShowDialog;
        this.useDislike = builder.useDislike;
        this.mDislikeTopDp = builder.mDislikeTopDp;
        this.mDislikeBottomDp = builder.mDislikeBottomDp;
        this.mDislikeLeftDp = builder.mDislikeLeftDp;
        this.mDislikeRightDp = builder.mDislikeRightDp;
    }

    public int getBrandBottomDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mBrandBottomDp;
        }
        return invokeV.intValue;
    }

    public int getBrandFontColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBrandFontColor;
        }
        return invokeV.intValue;
    }

    public int getBrandFontSizeSp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mBrandFontSizeSp;
        }
        return invokeV.intValue;
    }

    public Typeface getBrandFontTypeFace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mBrandFontTypeFace;
        }
        return (Typeface) invokeV.objValue;
    }

    public int getBrandLeftDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mBrandLeftDp;
        }
        return invokeV.intValue;
    }

    public int getBrandRightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mBrandRightDp;
        }
        return invokeV.intValue;
    }

    public int getButtonBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mButtonBackgroundColor;
        }
        return invokeV.intValue;
    }

    public int getButtonBottomDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mButtonBottomDp;
        }
        return invokeV.intValue;
    }

    public Typeface getButtonFontTypeFace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mButtonFontTypeFace;
        }
        return (Typeface) invokeV.objValue;
    }

    public int getButtonForegroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mButtonForegroundColor;
        }
        return invokeV.intValue;
    }

    public int getButtonHeightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mButtonHeightDp;
        }
        return invokeV.intValue;
    }

    public int getButtonLeftDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mButtonLeftDp;
        }
        return invokeV.intValue;
    }

    public int getButtonRightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mButtonRightDp;
        }
        return invokeV.intValue;
    }

    public int getButtonTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mButtonFontColor;
        }
        return invokeV.intValue;
    }

    public int getButtonTextSizeSp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mButtonFontSizeSp;
        }
        return invokeV.intValue;
    }

    public int getButtonTopDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mButtonTopDp;
        }
        return invokeV.intValue;
    }

    public int getButtonWidthDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mButtonWidthDp;
        }
        return invokeV.intValue;
    }

    public int getDislikeBottomDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mDislikeBottomDp;
        }
        return invokeV.intValue;
    }

    public int getDislikeLeftDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mDislikeLeftDp;
        }
        return invokeV.intValue;
    }

    public int getDislikeRightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mDislikeRightDp;
        }
        return invokeV.intValue;
    }

    public int getDislikeTopDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mDislikeTopDp;
        }
        return invokeV.intValue;
    }

    public int getFirstPicBottomDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mFirstPicBottomDp;
        }
        return invokeV.intValue;
    }

    public int getFirstPicHeightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mFirstPicHeightDp;
        }
        return invokeV.intValue;
    }

    public int getFirstPicLeftDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mFirstPicLeftDp;
        }
        return invokeV.intValue;
    }

    public int getFirstPicRightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mFirstPicRightDp;
        }
        return invokeV.intValue;
    }

    public int getFirstPicTopDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mFirstPicTopDp;
        }
        return invokeV.intValue;
    }

    public int getFirstPicWidthDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mFirstPicWidthDp;
        }
        return invokeV.intValue;
    }

    public int getIconBottomDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mIconBottomDp;
        }
        return invokeV.intValue;
    }

    public int getIconHeightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mIconHeightDp;
        }
        return invokeV.intValue;
    }

    public int getIconLeftDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.mIconLeftDp;
        }
        return invokeV.intValue;
    }

    public int getIconRightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mIconRightDp;
        }
        return invokeV.intValue;
    }

    public int getIconTopDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mIconTopDp;
        }
        return invokeV.intValue;
    }

    public int getIconWidthDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.mIconWidthDp;
        }
        return invokeV.intValue;
    }

    public Drawable getImageBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.mImageBackground;
        }
        return (Drawable) invokeV.objValue;
    }

    public int getImageBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.mImageBackgroundColor;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadAppNameBottomDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.mSmartDownloadAppNameBottomDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadAppNameLeftDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.mSmartDownloadAppNameLeftDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadAppNameRightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.mSmartDownloadAppNameRightDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadAppNameTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.mSmartDownloadAppNameTextColor;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadAppNameTextSizeSp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.mSmartDownloadAppNameTextSizeSp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadAppNameTopDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.mSmartDownloadAppNameTopDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadButtonBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.mSmartDownloadButtonBackgroundColor;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadButtonBottomDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.mSmartDownloadButtonBottomDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadButtonFontColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.mSmartDownloadButtonFontColor;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadButtonFontSizeSp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.mSmartDownloadButtonFontSizeSp;
        }
        return invokeV.intValue;
    }

    public Typeface getSmartDownloadButtonFontTypeFace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.mSmartDownloadButtonFontTypeFace;
        }
        return (Typeface) invokeV.objValue;
    }

    public int getSmartDownloadButtonForegroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.mSmartDownloadButtonForegroundColor;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadButtonHeightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.mSmartDownloadButtonHeightDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadButtonLeftDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.mSmartDownloadButtonLeftDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadButtonRightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.mSmartDownloadButtonRightDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadButtonTopDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.mSmartDownloadButtonTopDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadButtonWidthDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.mSmartDownloadButtonWidthDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadCompanyBottomDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.mSmartDownloadCompanyBottomDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadCompanyLeftDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.mSmartDownloadCompanyLeftDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadCompanyRightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.mSmartDownloadCompanyRightDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadCompanyTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.mSmartDownloadCompanyTextColor;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadCompanyTextSizeSp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.mSmartDownloadCompanyTextSizeSp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadCompanyTopDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.mSmartDownloadCompanyTopDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadPermissionBottomDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.mSmartDownloadPermissionBottomDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadPermissionLeftDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.mSmartDownloadPermissionLeftDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadPermissionRightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.mSmartDownloadPermissionRightDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadPermissionTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.mSmartDownloadPermissionTextColor;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadPermissionTextSizeSp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.mSmartDownloadPermissionTextSizeSp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadPermissionTopDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.mSmartDownloadPermissionTopDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadPrivacyBottomDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.mSmartDownloadPrivacyBottomDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadPrivacyLeftDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.mSmartDownloadPrivacyLeftDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadPrivacyRightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.mSmartDownloadPrivacyRightDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadPrivacyTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.mSmartDownloadPrivacyTextColor;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadPrivacyTextSizeSp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.mSmartDownloadPrivacyTextSizeSp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadPrivacyTopDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.mSmartDownloadPrivacyTopDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadVersionBottomDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.mSmartDownloadVersionBottomDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadVersionLeftDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.mSmartDownloadVersionLeftDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadVersionRightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.mSmartDownloadVersionRightDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadVersionTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.mSmartDownloadVersionTextColor;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadVersionTextSizeSp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.mSmartDownloadVersionTextSizeSp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadVersionTopDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.mSmartDownloadVersionTopDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadViewBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.mSmartDownloadViewBackgroundColor;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadViewBottomDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.mSmartDownloadViewBottomDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadViewLeftDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.mSmartDownloadViewLeftDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadViewRightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.mSmartDownloadViewRightDp;
        }
        return invokeV.intValue;
    }

    public int getSmartDownloadViewTopDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.mSmartDownloadViewTopDp;
        }
        return invokeV.intValue;
    }

    public int getThreePicBottomDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.mThreePicBottomDp;
        }
        return invokeV.intValue;
    }

    public int getThreePicHeightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.mThreePicHeightDp;
        }
        return invokeV.intValue;
    }

    public int getThreePicLeftDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.mThreePicLeftDp;
        }
        return invokeV.intValue;
    }

    public int getThreePicRightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.mThreePicRightDp;
        }
        return invokeV.intValue;
    }

    public int getThreePicTopDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.mThreePicTopDp;
        }
        return invokeV.intValue;
    }

    public int getThreePicWidthDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.mThreePicWidthDp;
        }
        return invokeV.intValue;
    }

    public int getTitleBottomDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.mTitleBottomDp;
        }
        return invokeV.intValue;
    }

    public int getTitleFontColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return this.mTitleFontColor;
        }
        return invokeV.intValue;
    }

    public int getTitleFontSizeSp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.mTitleFontSizeSp;
        }
        return invokeV.intValue;
    }

    public Typeface getTitleFontTypeFace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.mTitleFontTypeFace;
        }
        return (Typeface) invokeV.objValue;
    }

    public int getTitleLeftDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return this.mTitleLeftDp;
        }
        return invokeV.intValue;
    }

    public int getTitleRightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.mTitleRightDp;
        }
        return invokeV.intValue;
    }

    public int getTitleTopDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.mTitleTopDp;
        }
        return invokeV.intValue;
    }

    public int getTwoPicBottomDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.mTwoPicBottomDp;
        }
        return invokeV.intValue;
    }

    public int getTwoPicHeightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.mTwoPicHeightDp;
        }
        return invokeV.intValue;
    }

    public int getTwoPicLeftDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return this.mTwoPicLeftDp;
        }
        return invokeV.intValue;
    }

    public int getTwoPicRightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.mTwoPicRightDp;
        }
        return invokeV.intValue;
    }

    public int getTwoPicTopDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.mTwoPicTopDp;
        }
        return invokeV.intValue;
    }

    public int getTwoPicWidthDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.mTwoPicWidthDp;
        }
        return invokeV.intValue;
    }

    public boolean getUseDislike() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            return this.useDislike;
        }
        return invokeV.booleanValue;
    }

    public boolean isRegionClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return this.mIsRegionClick;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowActionButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.mIsShowActionButton;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            return this.mIsShowDialog;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowDownloadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.mIsShowDownloadInfo;
        }
        return invokeV.booleanValue;
    }
}
