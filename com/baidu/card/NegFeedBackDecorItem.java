package com.baidu.card;

import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.jv4;
import com.baidu.tieba.kt;
import com.baidu.tieba.qs;
import com.baidu.tieba.rs;
import com.baidu.tieba.yr;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class NegFeedBackDecorItem extends yr implements qs<NegativeFeedBackData>, rs {
    public static /* synthetic */ Interceptable $ic;
    public static final int VIEW_WH;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isConcernRecommend;
    public Align mAlign;
    public NEGFeedBackView mNegFeedBackView;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-17901561, "Lcom/baidu/card/NegFeedBackDecorItem;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-17901561, "Lcom/baidu/card/NegFeedBackDecorItem;");
                return;
            }
        }
        VIEW_WH = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    }

    public NegFeedBackDecorItem(TbPageContext tbPageContext, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, align};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setInsertIndex(-1);
        NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(tbPageContext);
        this.mNegFeedBackView = nEGFeedBackView;
        nEGFeedBackView.setId(R.id.decor_item_right_id);
        setDecorView(this.mNegFeedBackView);
        autoAlignParent(align);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NegFeedBackDecorItem(TbPageContext tbPageContext, boolean z) {
        this(tbPageContext, r9);
        Align align;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (Align) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (z) {
            align = Align.ALIGN_RIGHT_BOTTOM;
        } else {
            align = Align.ALIGN_RIGHT_TOP;
        }
    }

    private void adjustForConcernRecommend() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds57);
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
            int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds34);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = dimens2;
            layoutParams.topMargin = dimens3;
            setLayoutParams(layoutParams);
            this.mNegFeedBackView.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.mNegFeedBackView.setPadding(0, 0, 0, 0);
            this.mNegFeedBackView.setLayoutParams(layoutParams);
        }
    }

    private int getDimens(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) == null) {
            return BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), i);
        }
        return invokeI.intValue;
    }

    public void adjustMarginTop(int i) {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (nEGFeedBackView = this.mNegFeedBackView) != null && (nEGFeedBackView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNegFeedBackView.getLayoutParams();
            layoutParams.topMargin = i;
            this.mNegFeedBackView.setLayoutParams(layoutParams);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qs
    public void onBindDataToView(NegativeFeedBackData negativeFeedBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, negativeFeedBackData) == null) {
            if (negativeFeedBackData == null) {
                this.mNegFeedBackView.setVisibility(8);
                return;
            }
            this.mNegFeedBackView.setData(negativeFeedBackData);
            this.mNegFeedBackView.setFirstRowSingleColumn(true);
            this.mNegFeedBackView.setVisibility(0);
        }
    }

    public void setAutoProcess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.mNegFeedBackView.setAutoProcess(z);
        }
    }

    public void setHeadText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mNegFeedBackView.setHeadText(str);
        }
    }

    public void setNegEventCallback(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, nEGFeedbackEventCallback) == null) {
            this.mNegFeedBackView.setEventCallback(nEGFeedbackEventCallback);
        }
    }

    public void showWithNone(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mNegFeedBackView.showWithNone(z);
        }
    }

    private void setAlignTop(jv4 jv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, jv4Var) == null) {
            if (jv4Var.showCardBottomOpWeight()) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds80);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds88);
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds50);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize2, dimenPixelSize2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = dimenPixelSize3;
                layoutParams.topMargin = dimenPixelSize4;
                setLayoutParams(layoutParams);
                this.mNegFeedBackView.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.mNegFeedBackView.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.mNegFeedBackView.setLayoutParams(layoutParams);
                return;
            }
            int i = VIEW_WH;
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
            layoutParams2.addRule(11);
            layoutParams2.addRule(10);
            layoutParams2.rightMargin = dimens2;
            layoutParams2.topMargin = dimens3;
            setLayoutParams(layoutParams2);
            this.mNegFeedBackView.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
            this.mNegFeedBackView.setPadding(dimens, dimens, dimens, dimens);
            this.mNegFeedBackView.setLayoutParams(layoutParams2);
        }
    }

    private void setTopMarginParentAlignTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, this, i) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNegFeedBackView.getLayoutParams();
            if (this.mNegFeedBackView.getParent() == null || layoutParams == null || layoutParams.topMargin != i) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds80);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds88);
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize2, dimenPixelSize2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.rightMargin = dimenPixelSize3;
                layoutParams2.topMargin = i;
                setLayoutParams(layoutParams2);
                this.mNegFeedBackView.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.mNegFeedBackView.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.mNegFeedBackView.setLayoutParams(layoutParams2);
            }
        }
    }

    public void autoAlignParent(jv4 jv4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jv4Var) == null) && jv4Var != null && jv4Var.getNegFeedBackData() != null) {
            if (jv4Var.getNegFeedBackData().getTopicID() <= 0 && jv4Var.getThreadData() != null) {
                if (!jv4Var.showCardBottomOpWeight() && !jv4Var.isFromFrs()) {
                    autoAlignParent(Align.ALIGN_RIGHT_BOTTOM);
                } else if (jv4Var.isSupportTop()) {
                    setTopMarginParentAlignTop(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                } else if (jv4Var.isSupportBottom()) {
                    kt ktVar = this.threadCard;
                    if (ktVar != null) {
                        ktVar.p(this);
                    }
                } else {
                    autoAlignParent(Align.ALIGN_RIGHT_TOP);
                }
            } else if (this.isConcernRecommend) {
                adjustForConcernRecommend();
            } else {
                setAlignTop(jv4Var);
            }
        }
    }

    public void autoAlignParent(Align align) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, align) != null) || this.mAlign == align) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds80);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds88);
        if (align == Align.ALIGN_RIGHT_TOP) {
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds50);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize2, dimenPixelSize2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = dimenPixelSize3;
            layoutParams.topMargin = dimenPixelSize4;
            setLayoutParams(layoutParams);
            this.mNegFeedBackView.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.mNegFeedBackView.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.mNegFeedBackView.setLayoutParams(layoutParams);
        } else if (align == Align.ALIGN_RIGHT_CENTER) {
            int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize2, dimenPixelSize2);
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = dimenPixelSize5;
            layoutParams2.bottomMargin = 0;
            setLayoutParams(layoutParams2);
            this.mNegFeedBackView.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.mNegFeedBackView.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.mNegFeedBackView.setLayoutParams(layoutParams2);
        } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
            int i = VIEW_WH;
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            layoutParams3.rightMargin = dimens2;
            layoutParams3.bottomMargin = dimens3;
            setLayoutParams(layoutParams3);
            this.mNegFeedBackView.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
            this.mNegFeedBackView.setPadding(dimens, dimens, dimens, dimens);
            this.mNegFeedBackView.setLayoutParams(layoutParams3);
        }
        this.mAlign = align;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yr
    public NEGFeedBackView getDecorView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mNegFeedBackView;
        }
        return (NEGFeedBackView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rs
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) {
            this.mNegFeedBackView.onChangeSkinType();
        }
    }
}
