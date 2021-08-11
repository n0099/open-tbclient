package com.baidu.ala.gift;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes4.dex */
public class AlaDynamicGiftAndNativeData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaDynamicGift mAlaDynamicGift;
    public ArrayList<String> unZipFilesPathList;
    public String upZipDirPath;

    public AlaDynamicGiftAndNativeData() {
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

    public String getDynamicGiftId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AlaDynamicGift alaDynamicGift = this.mAlaDynamicGift;
            if (alaDynamicGift == null) {
                return null;
            }
            return alaDynamicGift.giftId;
        }
        return (String) invokeV.objValue;
    }

    public String getDynamicGiftName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AlaDynamicGift alaDynamicGift = this.mAlaDynamicGift;
            if (alaDynamicGift == null) {
                return null;
            }
            return alaDynamicGift.giftName;
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<String> getDynamicGiftPicPathList() {
        InterceptResult invokeV;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!ListUtils.isEmpty(this.unZipFilesPathList)) {
                return this.unZipFilesPathList;
            }
            if (StringUtils.isNull(this.upZipDirPath) || (listFiles = new File(this.upZipDirPath).listFiles()) == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            for (File file : listFiles) {
                if (file != null && !file.isDirectory()) {
                    arrayList.add(file.getAbsolutePath());
                }
            }
            Collections.sort(arrayList, new Comparator<String>(this) { // from class: com.baidu.ala.gift.AlaDynamicGiftAndNativeData.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AlaDynamicGiftAndNativeData this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(String str, String str2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? str.compareTo(str2) : invokeLL.intValue;
                }
            });
            this.unZipFilesPathList = arrayList;
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean isLandScapeZip() {
        InterceptResult invokeV;
        AlaDynamicGiftZip alaDynamicGiftZip;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AlaDynamicGift alaDynamicGift = this.mAlaDynamicGift;
            if (alaDynamicGift == null || (alaDynamicGiftZip = alaDynamicGift.giftZip) == null) {
                return false;
            }
            return alaDynamicGiftZip.isLandScape();
        }
        return invokeV.booleanValue;
    }
}
