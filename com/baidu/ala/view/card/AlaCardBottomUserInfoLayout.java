package com.baidu.ala.view.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.d1.o0;
import c.a.s0.s.q.e2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.AlaPlayAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init(context);
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.ala_card_bottom_user_info_layout, (ViewGroup) this, true);
            this.alaCardUserHeadImg = (HeadImageView) inflate.findViewById(R.id.ala_card_user_head_img);
            this.alaCardUserName = (TextView) inflate.findViewById(R.id.ala_card_user_name);
            this.alaPlayAnim = (AlaPlayAnimationView) inflate.findViewById(R.id.ala_play_anim);
            this.alaWatchCount = (TextView) inflate.findViewById(R.id.ala_watch_count);
            initHeaderImg();
        }
    }

    private void initHeaderImg() {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (headImageView = this.alaCardUserHeadImg) == null) {
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

    public void setData(e2 e2Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var) == null) || e2Var == null || e2Var.p1() == null) {
            return;
        }
        AlaUserInfoData alaUserInfoData = e2Var.p1().user_info;
        if (e2Var.J() != null) {
            str = e2Var.J().getName_show();
        } else {
            str = alaUserInfoData != null ? alaUserInfoData.user_name : "";
        }
        if (o0.d(str) > 10) {
            str = o0.n(str, 10) + "...";
        }
        if (alaUserInfoData != null) {
            this.alaCardUserHeadImg.startLoad(alaUserInfoData.portrait, 28, false);
        }
        this.alaCardUserName.setText(str);
        this.alaWatchCount.setText(String.format(getContext().getResources().getString(R.string.ala_card_watch_num_text), StringHelper.numFormatOverWan(e2Var.p1().audience_count)));
    }

    public void setUserHeadImgVisible(int i2) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (headImageView = this.alaCardUserHeadImg) == null) {
            return;
        }
        headImageView.setVisibility(i2);
    }

    public void startPlayAnimation() {
        AlaPlayAnimationView alaPlayAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (alaPlayAnimationView = this.alaPlayAnim) == null) {
            return;
        }
        alaPlayAnimationView.startPlayAnimation();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public AlaCardBottomUserInfoLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        init(context);
    }
}
