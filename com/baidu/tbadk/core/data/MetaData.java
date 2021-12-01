package com.baidu.tbadk.core.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ImageInfo;
import com.baidu.tbadk.core.util.ImageProvider;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class MetaData extends com.baidu.tbadk.data.MetaData implements TbCheckBox.c, ImageProvider, PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -5772546803814127750L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsChecked;

    public MetaData() {
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
        this.mIsChecked = false;
    }

    @Override // com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getForumPhotoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<IconData> iconInfo = getIconInfo();
            ArrayList<IconData> tShowInfoNew = getTShowInfoNew();
            if (iconInfo == null || tShowInfoNew == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < iconInfo.size(); i2++) {
                arrayList.add(iconInfo.get(i2).getIcon());
            }
            for (int i3 = 0; i3 < iconInfo.size(); i3++) {
                arrayList.add(tShowInfoNew.get(i3).getIcon());
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
            preLoadImageInfo.imgUrl = getPortrait();
            preLoadImageInfo.procType = 12;
            arrayList.add(preLoadImageInfo);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<ImageInfo> getImagesWithEmotions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getPhotoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(getPortrait());
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.c
    public boolean isChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mIsChecked : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.util.ImageProvider
    public boolean isSupportImageSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.c
    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mIsChecked = z;
        }
    }
}
