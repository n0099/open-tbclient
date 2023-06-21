package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ImageProvider;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UserData extends com.baidu.tbadk.data.UserData implements TbCheckBox.c, ImageProvider, PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_COMMON_ATTENTION = 1;
    public static final int TYPE_FOLLOW_TIP_TEXT = 3;
    public static final int TYPE_OHTER_ATTENTION = 2;
    public static final int TYPE_OTHER_TITLE = 0;
    public static final String TYPE_USER = "type_user";
    public static final String TYPE_USER_NICKNAME_LEFT_DAYS = "type_user_nickname_left_days";
    public static final long serialVersionUID = -2636990595209169859L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isLastNewFan;
    public boolean isNewFan;
    public int mAttentionType;
    public boolean mIsChecked;

    public UserData() {
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
        this.mIsChecked = false;
        this.mAttentionType = 2;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
            preLoadImageInfo.imgUrl = getPortrait();
            preLoadImageInfo.procType = 12;
            arrayList.add(preLoadImageInfo);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.c
    public boolean isChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mIsChecked;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserData(long j, String str, String str2, int i) {
        super(j, str, str2, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {Long.valueOf(j), str, str2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Long) objArr2[0]).longValue(), (String) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsChecked = false;
        this.mAttentionType = 2;
    }

    @Override // com.baidu.tbadk.data.UserData, com.baidu.tbadk.data.MetaData
    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            super.parserJson(jSONObject);
            try {
                boolean z = true;
                if (jSONObject.optInt("is_new") != 1) {
                    z = false;
                }
                this.isNewFan = z;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.c
    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mIsChecked = z;
        }
    }

    @Override // com.baidu.tbadk.data.MetaData, com.baidu.tieba.nb5
    public void setIsLike(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            super.setIsLike(z);
            if (!z) {
                setHave_attention(0);
            }
        }
    }
}
