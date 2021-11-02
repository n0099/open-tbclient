package com.baidu.searchbox.ui.viewpager;

import android.content.res.ColorStateList;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class BdPagerTab {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mBoldWhenSelect;
    public ColorStateList mColorStateList;
    public int mIconResId;
    public String mId;
    public boolean mIsForPlaceholder;
    public boolean mIsNew;
    public String mNewCount;
    public BdPagerTab mParentTab;
    public int mSelSubTabIndex;
    public int mSelTextColor;
    public int mSubTabEndIndex;
    public int mSubTabStartIndex;
    public ArrayList<BdPagerTab> mSubTabs;
    public int mTabBackgroundResId;
    public int mTextColor;
    public int mTextSize;
    public String mTitle;

    public BdPagerTab() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTextSize = 20;
        this.mTextColor = -1;
        this.mSelTextColor = -1;
        this.mColorStateList = null;
        this.mTabBackgroundResId = 0;
        this.mParentTab = null;
        this.mSubTabs = null;
        this.mSelSubTabIndex = 0;
        this.mSubTabStartIndex = 0;
        this.mSubTabEndIndex = 0;
        this.mIsForPlaceholder = false;
        this.mIsNew = false;
    }

    public BdPagerTab addSubTab(BdPagerTab bdPagerTab) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bdPagerTab)) == null) {
            if (this.mSubTabs == null) {
                this.mSubTabs = new ArrayList<>();
            }
            if (bdPagerTab != null) {
                bdPagerTab.mParentTab = this;
                this.mSubTabs.add(bdPagerTab);
                this.mSubTabEndIndex = this.mSubTabs.size();
            }
            return this;
        }
        return (BdPagerTab) invokeL.objValue;
    }

    public ColorStateList getColorStateList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mColorStateList : (ColorStateList) invokeV.objValue;
    }

    public String getFormatTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.mTitle)) {
                sb.append(this.mTitle);
            }
            BdPagerTab bdPagerTab = this.mParentTab;
            if (bdPagerTab != null) {
                while (bdPagerTab != null) {
                    sb.insert(0, bdPagerTab.getTitle() + ",");
                    bdPagerTab = bdPagerTab.getParentTab();
                }
            }
            if (sb.length() == 0) {
                sb.append(toString());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public int getIconResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIconResId : invokeV.intValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mId : (String) invokeV.objValue;
    }

    public String getNewCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mNewCount : (String) invokeV.objValue;
    }

    public BdPagerTab getParentTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mParentTab : (BdPagerTab) invokeV.objValue;
    }

    public int getSelSubTabIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mSelSubTabIndex : invokeV.intValue;
    }

    public int getSelTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSelTextColor : invokeV.intValue;
    }

    public BdPagerTab getSubTabAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            ArrayList<BdPagerTab> arrayList = this.mSubTabs;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.mSubTabs.get(i2);
        }
        return (BdPagerTab) invokeI.objValue;
    }

    public int getSubTabCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList<BdPagerTab> arrayList = this.mSubTabs;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int[] getSubTabIndexRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new int[]{this.mSubTabStartIndex, this.mSubTabEndIndex} : (int[]) invokeV.objValue;
    }

    public List<BdPagerTab> getSubTabs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mSubTabs : (List) invokeV.objValue;
    }

    public List<BdPagerTab> getSubTabsByRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int i2 = this.mSubTabStartIndex;
            int i3 = this.mSubTabEndIndex;
            if (i3 > i2 && i3 != 0 && i3 <= this.mSubTabs.size()) {
                return this.mSubTabs.subList(i2, i3);
            }
            return this.mSubTabs;
        }
        return (List) invokeV.objValue;
    }

    public int getTabBackgroundResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mTabBackgroundResId : invokeV.intValue;
    }

    public int getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mTextColor : invokeV.intValue;
    }

    public int getTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mTextSize : invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mTitle : (String) invokeV.objValue;
    }

    public boolean isBoldWhenSelect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mBoldWhenSelect : invokeV.booleanValue;
    }

    public boolean isForPlaceholder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mIsForPlaceholder : invokeV.booleanValue;
    }

    public boolean isNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mIsNew : invokeV.booleanValue;
    }

    public boolean needSelected(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.equalsIgnoreCase(this.mId)) {
                return true;
            }
            ArrayList<BdPagerTab> arrayList = this.mSubTabs;
            if (arrayList != null) {
                Iterator<BdPagerTab> it = arrayList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (it.next().needSelected(str)) {
                        this.mSelSubTabIndex = i2;
                        return true;
                    }
                    i2++;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public BdPagerTab setBoldWhenSelect(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            this.mBoldWhenSelect = z;
            return this;
        }
        return (BdPagerTab) invokeZ.objValue;
    }

    public BdPagerTab setColorStateList(ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, colorStateList)) == null) {
            this.mColorStateList = colorStateList;
            return this;
        }
        return (BdPagerTab) invokeL.objValue;
    }

    public BdPagerTab setIconResId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            this.mIconResId = i2;
            return this;
        }
        return (BdPagerTab) invokeI.objValue;
    }

    public BdPagerTab setId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            this.mId = str;
            return this;
        }
        return (BdPagerTab) invokeL.objValue;
    }

    public void setIsForPlaceholder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.mIsForPlaceholder = z;
        }
    }

    public void setIsNew(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.mIsNew = z;
        }
    }

    public void setNewCount(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.mNewCount = str;
        }
    }

    public void setNewCountMax99(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            if (i2 <= 0) {
                this.mNewCount = "";
            } else {
                this.mNewCount = i2 > 99 ? "99+" : String.valueOf(i2);
            }
        }
    }

    public void setSelSubTabIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.mSelSubTabIndex = i2;
        }
    }

    public BdPagerTab setSelTextColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            this.mSelTextColor = i2;
            return this;
        }
        return (BdPagerTab) invokeI.objValue;
    }

    public void setSubTabIndexRange(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048608, this, i2, i3) == null) {
            this.mSubTabStartIndex = i2;
            this.mSubTabEndIndex = i3;
        }
    }

    public BdPagerTab setTabBackgroundResId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            this.mTabBackgroundResId = i2;
            return this;
        }
        return (BdPagerTab) invokeI.objValue;
    }

    public BdPagerTab setTextColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) {
            this.mTextColor = i2;
            return this;
        }
        return (BdPagerTab) invokeI.objValue;
    }

    public BdPagerTab setTextSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            this.mTextSize = i2;
            return this;
        }
        return (BdPagerTab) invokeI.objValue;
    }

    public BdPagerTab setTitle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            this.mTitle = str;
            return this;
        }
        return (BdPagerTab) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return "title = " + this.mTitle + ", id = " + this.mId + ", obj = " + super.toString();
        }
        return (String) invokeV.objValue;
    }
}
