package com.baidu.ala.view.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.rw5;
import com.baidu.tieba.view.AlaPlayAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AlaCardBottomUserInfoLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_USERNAME_LENGTH = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView alaCardUserHeadImg;
    public TextView alaCardUserName;
    public AlaPlayAnimationView alaPlayAnim;
    public TextView alaWatchCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaCardBottomUserInfoLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaCardBottomUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaCardBottomUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        init(context);
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00ed, (ViewGroup) this, true);
            this.alaCardUserHeadImg = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0901da);
            this.alaCardUserName = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0901db);
            this.alaPlayAnim = (AlaPlayAnimationView) inflate.findViewById(R.id.obfuscated_res_0x7f090231);
            this.alaWatchCount = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090243);
            initHeaderImg();
        }
    }

    private void initHeaderImg() {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) != null) || (headImageView = this.alaCardUserHeadImg) == null) {
            return;
        }
        headImageView.setDefaultResource(17170445);
        this.alaCardUserHeadImg.setDefaultBgResource(R.color.CAM_X0205);
        this.alaCardUserHeadImg.setIsRound(true);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            SkinManager.setViewTextColor(this.alaCardUserName, R.color.CAM_X0101, TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setViewTextColor(this.alaWatchCount, R.color.CAM_X0101, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setUserHeadImgVisible(int i) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (headImageView = this.alaCardUserHeadImg) != null) {
            headImageView.setVisibility(i);
        }
    }

    public void setData(ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) && threadData != null && threadData.getThreadAlaInfo() != null) {
            AlaUserInfoData alaUserInfoData = threadData.getThreadAlaInfo().user_info;
            if (threadData.getAuthor() != null) {
                str = threadData.getAuthor().getName_show();
            } else if (alaUserInfoData != null) {
                str = alaUserInfoData.user_name;
            } else {
                str = "";
            }
            if (rw5.e(str) > 10) {
                str = rw5.m(str, 10) + "...";
            }
            if (alaUserInfoData != null) {
                this.alaCardUserHeadImg.startLoad(alaUserInfoData.portrait, 28, false);
            }
            this.alaCardUserName.setText(str);
            this.alaWatchCount.setText(String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0234), StringHelper.numFormatOverWan(threadData.getThreadAlaInfo().audience_count)));
        }
    }
}
