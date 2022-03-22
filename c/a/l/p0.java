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

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f3470h;
    public ItemCardView i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(Context context) {
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
        n(Boolean.TRUE);
    }

    @Override // c.a.l.a
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f3470h == null) {
                FrameLayout frameLayout = new FrameLayout(this.f3392b);
                this.f3470h = frameLayout;
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0206);
                this.f3470h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f3470h.removeAllViews();
            if (this.i == null) {
                ItemCardView itemCardView = new ItemCardView(this.f3392b);
                this.i = itemCardView;
                itemCardView.setBackGroundColor(R.color.CAM_X0205);
                this.i.setIsShowRightBtn(true);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003) - UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
            layoutParams.leftMargin = this.f3392b.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
            layoutParams.rightMargin = this.f3392b.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
            layoutParams.bottomMargin = this.f3392b.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
            this.f3470h.addView(this.i, layoutParams);
            return this.f3470h;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.f3470h, R.color.CAM_X0206);
            ItemCardView itemCardView = this.i;
            if (itemCardView != null) {
                itemCardView.G();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: s */
    public void a(c.a.o0.r.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (aVar != null && aVar.getThreadData() != null && aVar.getThreadData().originalThreadData != null && aVar.getThreadData().originalThreadData.C != null) {
                if (!aVar.getThreadData().originalThreadData.m && !aVar.getThreadData().shouldShowBlockedState()) {
                    this.f3470h.setVisibility(0);
                    this.i.setData(aVar.getThreadData().originalThreadData.D, 13, aVar.getThreadData().originalThreadData.f29826f);
                    return;
                }
                this.f3470h.setVisibility(8);
                return;
            }
            this.f3470h.setVisibility(8);
        }
    }
}
