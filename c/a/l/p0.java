package c.a.l;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class p0 extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout l;
    public ItemCardView m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(Context context) {
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
        m(Boolean.TRUE);
    }

    @Override // c.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.l == null) {
                FrameLayout frameLayout = new FrameLayout(this.f3783f);
                this.l = frameLayout;
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0206);
                this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.l.removeAllViews();
            if (this.m == null) {
                ItemCardView itemCardView = new ItemCardView(this.f3783f);
                this.m = itemCardView;
                itemCardView.setBackGroundColor(R.color.CAM_X0205);
                this.m.setIsShowRightBtn(true);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003) - UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
            layoutParams.leftMargin = this.f3783f.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
            layoutParams.rightMargin = this.f3783f.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
            layoutParams.bottomMargin = this.f3783f.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
            this.l.addView(this.m, layoutParams);
            return this.l;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0206);
            ItemCardView itemCardView = this.m;
            if (itemCardView != null) {
                itemCardView.onChangeSkinType();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: r */
    public void onBindDataToView(c.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (aVar != null && aVar.getThreadData() != null && aVar.getThreadData().y1 != null && aVar.getThreadData().y1.B != null) {
                if (aVar.getThreadData().y1.m) {
                    this.l.setVisibility(8);
                    return;
                }
                this.l.setVisibility(0);
                this.m.setData(aVar.getThreadData().y1.C, 13, aVar.getThreadData().y1.f47437f);
                return;
            }
            this.l.setVisibility(8);
        }
    }
}
